package com.sfeir.graph.assetmanager.repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import com.sfeir.graph.assetmanager.domain.abs.ARelation;

public interface RelationRepository extends GremlinRepository<ARelation, String> {
}
