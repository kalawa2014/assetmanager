package com.sfeir.graph.assetmanager.repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import com.sfeir.graph.assetmanager.domain.HoldRelation;
import com.sfeir.graph.assetmanager.domain.abs.ARelation;

import java.util.List;

public interface RelationRepository extends GremlinRepository<ARelation, String> {

    List<HoldRelation> findAllByLabel(String label);
}
