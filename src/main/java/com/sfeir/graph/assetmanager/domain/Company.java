package com.sfeir.graph.assetmanager.domain;

import com.sfeir.graph.assetmanager.domain.abs.AAssetNode;
import com.sfeir.graph.assetmanager.util.LabelType;

public class Company extends AAssetNode {

    public Company() {
        super();
        this.setLabel(LabelType.COMPANY.name());
    }
}
