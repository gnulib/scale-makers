package com.castlighthealth.device.api.ping;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.castlighthealth.device.api.ping.model.Pong;
import com.castlighthealth.device.api.ping.resource.ProtectedPingResource;
import com.integratingfactor.idp.lib.client.filter.IdpApiAuthFilter;
import com.integratingfactor.idp.lib.client.rbac.IdpRbacPolicy;

@Component
@Path("ping")
public class ProtectedPingService implements ProtectedPingResource {

    @Override
    @IdpRbacPolicy()
    public GetPingResponse getPing(String authorization) throws Exception {
        Pong pong = new Pong();
        pong.setMessage("Hello " + IdpApiAuthFilter.getRbacDetails().getAccountId() + "!");
        return GetPingResponse.withJsonOK(pong);
    }

}
