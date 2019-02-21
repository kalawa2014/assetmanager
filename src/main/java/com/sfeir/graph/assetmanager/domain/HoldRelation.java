package com.sfeir.graph.assetmanager.domain;

import com.sfeir.graph.assetmanager.domain.abs.ARelation;
import com.sfeir.graph.assetmanager.util.LabelType;

public class HoldRelation extends ARelation {
    private int share;
    private long price;

    public HoldRelation() {
        super();
        this.setLabel(LabelType.HOLD.name());
    }
}
