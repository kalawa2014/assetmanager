package com.sfeir.graph.assetmanager.controller;

import com.sfeir.graph.assetmanager.domain.Asset;
import com.sfeir.graph.assetmanager.domain.BuyRelation;
import com.sfeir.graph.assetmanager.domain.HoldRelation;
import com.sfeir.graph.assetmanager.domain.abs.AAssetNode;
import com.sfeir.graph.assetmanager.domain.abs.ARelation;
import com.sfeir.graph.assetmanager.service.GraphServices;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GraphController {


    @Autowired
    private GraphServices graphServices;

    @RequestMapping(value = "graphs" , method = RequestMethod.GET)
    public List<Object> getAll() {
        return graphServices.getAllGraph();
    }

    @RequestMapping(value = "allgraphs" ,method = RequestMethod.GET)
    public List<Asset> getAllGraph(@RequestParam(value = "key", required = false) String key) {
        return graphServices.getRepositoryGraph(key);
    }


    @RequestMapping(value = "graphs2", method = RequestMethod.GET)
    public List<Object> getAll2(@RequestParam(value = "key", required = false) String key) {
        return Strings.isEmpty(key) ? this.graphServices.getAllVertex() : this.graphServices.getVertexByKey(key);
    }

    @RequestMapping(value = "buyrelations", method = RequestMethod.GET)
    public List<BuyRelation> getAllVertex() {
        return this.graphServices.getAllBuyRelation();
    }

    @RequestMapping(value = "assets", method = RequestMethod.GET)
    public List<Asset> getAllNode(@RequestParam(value = "label", required = false) String label) {
        return Strings.isEmpty(label) ? this.graphServices.getAllNode() : Collections.emptyList();
    }

    @RequestMapping(value = "assets", method = RequestMethod.POST)
    public AAssetNode createNode(@RequestBody Asset node) {
       return graphServices.createNode(node);
    }

}
