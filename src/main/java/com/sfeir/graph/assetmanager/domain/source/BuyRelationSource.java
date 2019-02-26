package com.sfeir.graph.assetmanager.domain.source;

import com.microsoft.applicationinsights.core.dependencies.apachecommons.lang3.reflect.FieldUtils;
import com.microsoft.spring.data.gremlin.conversion.source.GremlinSourceEdge;
import com.sfeir.graph.assetmanager.domain.BuyRelation;
import com.sfeir.graph.assetmanager.util.LabelType;

public class BuyRelationSource extends GremlinSourceEdge<BuyRelation> {

    public BuyRelationSource() {
        super(BuyRelation.class);
        this.setIdField(FieldUtils.getField(this.getDomainClass(),"id", true));
        this.setLabel(LabelType.BUY.name());
    }
}
