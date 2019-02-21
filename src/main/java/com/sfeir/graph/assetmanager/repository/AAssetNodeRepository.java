package com.sfeir.graph.assetmanager.repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import com.sfeir.graph.assetmanager.domain.abs.AAssetNode;

public interface AAssetNodeRepository extends GremlinRepository<AAssetNode, String> {
}
