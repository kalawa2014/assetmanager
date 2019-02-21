package com.sfeir.graph.assetmanager.service;

import com.sfeir.graph.assetmanager.config.SfeirGremlinTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphServices {

	@Autowired
	private SfeirGremlinTemplate template;


	public List<Object> getAllGraph() {
		String query = "g.V()";

		return template.getGremlinClient()
				.submit(query).stream()
				.map(r -> r.get(Object.class))
				.collect(Collectors.toList());
	}
}
