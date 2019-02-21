package com.sfeir.graph.assetmanager.domain.abs;

import com.microsoft.spring.data.gremlin.annotation.Edge;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Edge
public abstract class AAssetNode {
    @Id
    @GeneratedValue
    private String id;

    private String label;

    private String name;

    private long value;

}
