package com.sfeir.graph.assetmanager.domain;


import com.sfeir.graph.assetmanager.domain.abs.AAssetNode;
import com.sfeir.graph.assetmanager.util.LabelType;

public class Asset extends AAssetNode {
    public Asset() {
        super();
        this.setLabel(LabelType.ASSET.name());
    }
}
