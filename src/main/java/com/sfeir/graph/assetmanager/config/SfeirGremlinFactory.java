package com.sfeir.graph.assetmanager.config;

import com.microsoft.applicationinsights.core.dependencies.googlecommon.collect.ImmutableMap;
import com.microsoft.spring.data.gremlin.common.GremlinConfig;
import com.microsoft.spring.data.gremlin.config.GremlinConfigurationSupport;
import com.microsoft.spring.data.gremlin.conversion.MappingGremlinConverter;
import com.microsoft.spring.data.gremlin.exception.GremlinIllegalConfigurationException;
import com.microsoft.spring.data.gremlin.repository.config.EnableGremlinRepositories;
import com.microsoft.spring.data.gremlin.telemetry.EmptyTracker;
import com.microsoft.spring.data.gremlin.telemetry.TelemetryTracker;
import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.ser.GraphSONMessageSerializerV1d0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;


@EnableConfigurationProperties(GremlinProperties.class)
public class SfeirGremlinFactory {

	private Cluster gremlinCluster;

	private GremlinConfig gremlinConfig;

	@Autowired
	private TelemetryTracker telemetryTracker;

	public SfeirGremlinFactory(GremlinProperties gremlinProps) {
		this.gremlinConfig = GremlinConfig.builder(gremlinProps.getEndpoint(), gremlinProps.getUsername(), gremlinProps.getPassword()).build();
	}

	public SfeirGremlinFactory(GremlinConfig gremlinConfig) {
		this.gremlinConfig = gremlinConfig;
	}

	private void trackTelemetryCustomEvent() {
		this.telemetryTracker.trackEvent(getClass().getSimpleName());
	}

	private Cluster createGremlinCluster() throws GremlinIllegalConfigurationException {
		final Cluster cluster;

		try {
			Map<String, Object> configure = ImmutableMap.of("serializeResultToString",true);
			GraphSONMessageSerializerV1d0 serializer = new GraphSONMessageSerializerV1d0();
			serializer.configure(configure, null);
			cluster = Cluster.build(this.gremlinConfig.getEndpoint())
					.serializer(serializer)
					.credentials(this.gremlinConfig.getUsername(), this.gremlinConfig.getPassword())
					.enableSsl(this.gremlinConfig.isSslEnabled())
					.port(this.gremlinConfig.getPort())
					.create();
		} catch (IllegalArgumentException e) {
			throw new GremlinIllegalConfigurationException("Invalid configuration of Gremlin", e);
		}

		trackTelemetryCustomEvent();

		return cluster;
	}


	public Client getGremlinClient() {

		if (this.gremlinCluster == null) {
			this.gremlinCluster = this.createGremlinCluster();
		}

		return this.gremlinCluster.connect();
	}



}
