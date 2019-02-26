package com.sfeir.graph.assetmanager.service;

import com.microsoft.spring.data.gremlin.conversion.source.GremlinSourceVertex;
import com.sfeir.graph.assetmanager.config.SfeirGremlinTemplate;
import com.sfeir.graph.assetmanager.domain.Asset;
import com.sfeir.graph.assetmanager.domain.BuyRelation;
import com.sfeir.graph.assetmanager.domain.HoldRelation;
import com.sfeir.graph.assetmanager.domain.abs.AAssetNode;
import com.sfeir.graph.assetmanager.domain.source.AssetNodeSource;
import com.sfeir.graph.assetmanager.domain.source.BuyRelationSource;
import com.sfeir.graph.assetmanager.repository.AAssetNodeRepository;
import com.sfeir.graph.assetmanager.repository.AssetManagerGraphRepository;
import com.sfeir.graph.assetmanager.repository.HoldRelationRepository;
import com.sfeir.graph.assetmanager.repository.RelationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class GraphServices {

	@Autowired
	private SfeirGremlinTemplate template;

	@Autowired
	private RelationRepository relationRepository;

	@Autowired
	private HoldRelationRepository holdRelationRepository;

	@Autowired
	private AAssetNodeRepository nodeRepository;

	@Autowired
	private AssetManagerGraphRepository graphRepository;


	public List<Object> getAllGraph() {
		String query = "g.V().valueMap()";

		return template.getGremlinClient()
				.submit(query).stream()
				.map(r -> r.get(Object.class))
				.collect(Collectors.toList());
	}

	public List<Asset> getRepositoryGraph(String id) {
		return Collections.singletonList(template.findVertexById(id, new AssetNodeSource()));
	}


	public List<Object> getAllVertex() {

		//return StreamSupport.stream(relationRepository.findAll().spliterator(), false).collect(Collectors.toList());
		// return StreamSupport.stream(holdRelationRepository.findAll().spliterator(), false).collect(Collectors.toList());
		String query = "g.V().valueMap()";

		return template.getGremlinClient()
				.submit(query).stream()
				.map(r -> {
					LinkedHashMap<String, Object> result = r.get(LinkedHashMap.class);
					//AAssetNode aAssetNode = (AAssetNode)result;
					log.info("--> {} values {}",result.keySet(), result.values());
					return r.get(Object.class);
				})
				.collect(Collectors.toList());
	}

	public List<Object> getVertexByKey(String key) {
		return Collections.singletonList (holdRelationRepository.findById(key));
	}

	public List<HoldRelation> getVertexByLabel(String label) {
		return holdRelationRepository.findAllByLabel(label);
	}

	public List<Asset> getAllNode() {
		//return StreamSupport.stream(nodeRepository.findAll(AAssetNode.class).spliterator(), false).collect(Collectors.toList());
		return template.findAll(new AssetNodeSource());
	}

	public AAssetNode createNode(Asset node) {
		//node = new Asset();
		//node.setName("Opel Occasion");
		//node.setValue(2000);


		return template.insert(node, new AssetNodeSource());
	}

	public List<BuyRelation> getAllBuyRelation() {
		return template.findAll(new BuyRelationSource());
	}
}
