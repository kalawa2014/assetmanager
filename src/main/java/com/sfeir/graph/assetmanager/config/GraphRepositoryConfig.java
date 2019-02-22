package com.sfeir.graph.assetmanager.config;

import com.microsoft.spring.data.gremlin.common.GremlinConfig;
import com.microsoft.spring.data.gremlin.config.GremlinConfigurationSupport;
import com.microsoft.spring.data.gremlin.conversion.MappingGremlinConverter;
import com.microsoft.spring.data.gremlin.repository.config.EnableGremlinRepositories;
import com.microsoft.spring.data.gremlin.telemetry.EmptyTracker;
import com.microsoft.spring.data.gremlin.telemetry.TelemetryTracker;
import org.apache.tinkerpop.gremlin.driver.ser.Serializers;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableConfigurationProperties(GremlinProperties.class)
@PropertySource("classpath:application.properties")
public class GraphRepositoryConfig extends GremlinConfigurationSupport {


    private GremlinProperties gremlinProps;

    public GraphRepositoryConfig (GremlinProperties gremlinProperties) {
        this.gremlinProps = gremlinProperties;

    }

    public GremlinConfig getGremlinConfig() {
        return new GremlinConfig(gremlinProps.getEndpoint(), gremlinProps.getPort(), gremlinProps.getUsername(),
                gremlinProps.getPassword(), gremlinProps.isSslEnabled(), gremlinProps.isTelemetryAllowed(), Serializers.GRAPHSON_V1D0.toString());
    }

    @Bean
    public TelemetryTracker getTelemetryTracker() {
        if (getGremlinConfig().isTelemetryAllowed()) {
            return new TelemetryTracker();
        }

        return new EmptyTracker();
    }

    @Bean
    public SfeirGremlinFactory gremlinFactory() {
        return new SfeirGremlinFactory(getGremlinConfig());
    }

    @Bean
    public MappingGremlinConverter mappingGremlinConverter() throws ClassNotFoundException {
        return new MappingGremlinConverter(gremlinMappingContext());
    }

    @Bean
    public SfeirGremlinTemplate sfeirGremlinTemplate() throws ClassNotFoundException {
        return new SfeirGremlinTemplate(gremlinFactory(),mappingGremlinConverter());
    }
}
