package com.sfeir.graph.assetmanager.repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import com.sfeir.graph.assetmanager.domain.HoldRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldRelationRepository extends GremlinRepository<HoldRelation, String> {

    List<HoldRelation> findAllByLabel(String label);
}
