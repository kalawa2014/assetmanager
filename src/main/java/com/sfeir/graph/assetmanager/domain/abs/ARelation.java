package com.sfeir.graph.assetmanager.domain.abs;


import com.microsoft.spring.data.gremlin.annotation.EdgeFrom;
import com.microsoft.spring.data.gremlin.annotation.EdgeTo;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.Vertex;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Vertex
public abstract class ARelation {

    @Id
    private String id;

    private String label;

    private Date date;

    private String assests = "assets";

    @EdgeFrom
    private AAssetNode nodeFrom;

    @EdgeTo
    private AAssetNode nodeTo;
}
