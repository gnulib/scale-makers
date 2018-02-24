package com.castlighthealth.device.api.reading;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.castlighthealth.device.api.reading.model.Reading;
import com.castlighthealth.device.api.reading.resource.PublicReadingResource;
import com.castlighthealth.device.controller.Hx711;

@Component
@Path("public/reading")
public class PublicReadingService implements PublicReadingResource {

    private static final Reading unknown;

    static {
	    	unknown = new Reading();
	    	unknown.setMeasurement("unknown");
    }

    @Autowired
    Hx711 weighScale;
    
	@Override
	public GetPublicReadingResponse getPublicReading() throws Exception {
		long measurement = weighScale.measure(3);
		if (measurement == 0) {
			return GetPublicReadingResponse.withJsonOK(unknown);
		} else {
			Reading reading = new Reading();
			reading.setMeasurement((new Long(measurement)).toString());
			return GetPublicReadingResponse.withJsonOK(reading);
		}

	}
}
