package com.sfeir.graph.assetmanager.domain;

import com.sfeir.graph.assetmanager.domain.abs.ARelation;
import com.sfeir.graph.assetmanager.util.LabelType;

public class BuyRelation extends ARelation {
    private int number;
    private long price;

    public BuyRelation() {
        super();
        this.setLabel(LabelType.BUY.name());
    }
}
