package com.sfeir.graph.assetmanager.service;

import com.sfeir.graph.assetmanager.config.SfeirGremlinTemplate;
import com.sfeir.graph.assetmanager.repository.HoldRelationRepository;
import com.sfeir.graph.assetmanager.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GraphServices {

	@Autowired
	private SfeirGremlinTemplate template;

	@Autowired
	private RelationRepository relationRepository;

	@Autowired
	private HoldRelationRepository holdRelationRepository;


	public List<Object> getAllGraph() {
		String query = "g.V()";

		return template.getGremlinClient()
				.submit(query).stream()
				.map(r -> r.get(Object.class))
				.collect(Collectors.toList());
	}


	public List<Object> getAllVertex() {
		
		//return StreamSupport.stream(relationRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return StreamSupport.stream(holdRelationRepository.findAll().spliterator(), false).collect(Collectors.toList());

	}
}
