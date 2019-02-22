package com.sfeir.graph.assetmanager.repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import com.sfeir.graph.assetmanager.domain.HoldRelation;

public interface HoldRelationRepository extends GremlinRepository<HoldRelation, String> {
}
