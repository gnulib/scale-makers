package com.castlighthealth.device.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.castlighthealth.device.api.ping.ProtectedPingService;
import com.castlighthealth.device.api.ping.PublicPingService;

@Component
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(PublicPingService.class);
        register(ProtectedPingService.class);
    }

}