package com.sfeir.graph.assetmanager.domain;

import com.sfeir.graph.assetmanager.domain.abs.ARelation;
import com.sfeir.graph.assetmanager.util.LabelType;

public class SoldRelation extends ARelation {
    private int number;
    private long price;

    public SoldRelation() {
        super();
        this.setLabel(LabelType.SOLD.name());
    }
}
