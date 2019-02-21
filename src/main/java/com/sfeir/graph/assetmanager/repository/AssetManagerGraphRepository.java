package com.sfeir.graph.assetmanager.repository;

import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import com.sfeir.graph.assetmanager.domain.AssetManagerGraph;

public interface AssetManagerGraphRepository extends GremlinRepository<AssetManagerGraph, String> {
}
