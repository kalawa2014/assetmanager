package com.sfeir.graph.assetmanager.domain.source;

import com.microsoft.applicationinsights.core.dependencies.apachecommons.lang3.reflect.FieldUtils;
import com.microsoft.spring.data.gremlin.conversion.source.GremlinSourceVertex;
import com.sfeir.graph.assetmanager.domain.Asset;
import com.sfeir.graph.assetmanager.util.LabelType;

public class AssetNodeSource extends GremlinSourceVertex<Asset> {

    public AssetNodeSource() {
        super(Asset.class);
        this.setIdField(FieldUtils.getField(this.getDomainClass(),"id", true));
        this.setLabel(LabelType.ASSET.name());
    }
}
