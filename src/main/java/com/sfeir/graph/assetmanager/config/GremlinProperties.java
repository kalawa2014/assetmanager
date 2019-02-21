package com.sfeir.graph.assetmanager.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.gremlin.driver.ser.Serializers;
import org.springframework.boot.context.properties.ConfigurationProperties;

@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("gremlin")
@Data
public class GremlinProperties {

	private String endpoint;

	private int port;

	private String username;

	private String password;

	private boolean sslEnabled;

	private boolean telemetryAllowed = true;

	private String connectionPool;

	private String serializer = Serializers.GRAPHSON_V1D0.toString();

}
