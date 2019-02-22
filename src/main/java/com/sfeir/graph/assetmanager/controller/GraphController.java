package com.sfeir.graph.assetmanager.controller;

import com.sfeir.graph.assetmanager.service.GraphServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping(value = "graphs2", method = RequestMethod.GET)
    public List<Object> getAll2() {
        return this.graphServices.getAllVertex();
    }
}
