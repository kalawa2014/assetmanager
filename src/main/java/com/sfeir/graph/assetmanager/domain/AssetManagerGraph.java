package com.sfeir.graph.assetmanager.domain;

import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.Graph;
import com.microsoft.spring.data.gremlin.annotation.VertexSet;
import com.sfeir.graph.assetmanager.domain.abs.AAssetNode;
import com.sfeir.graph.assetmanager.domain.abs.ARelation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Graph
@Data
@AllArgsConstructor
public class AssetManagerGraph {

    private String id;

    private String name;

    @VertexSet
    private List<ARelation> vertex;

    @EdgeSet
    private List<AAssetNode> edges;

}
