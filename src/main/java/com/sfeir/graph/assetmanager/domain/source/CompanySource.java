package com.sfeir.graph.assetmanager.domain.source;

import com.microsoft.applicationinsights.core.dependencies.apachecommons.lang3.reflect.FieldUtils;
import com.microsoft.spring.data.gremlin.conversion.source.GremlinSourceVertex;
import com.sfeir.graph.assetmanager.domain.Company;
import com.sfeir.graph.assetmanager.util.LabelType;

public class CompanySource  extends GremlinSourceVertex<Company> {

    public CompanySource() {
        super(Company.class);
        this.setIdField(FieldUtils.getField(this.getDomainClass(),"id", true));
        this.setLabel(LabelType.ASSET.name());
    }
}
