package com.castlighthealth.device.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.castlighthealth.device.controller.Hx711;
import com.pi4j.io.gpio.RaspiPin;

@Configuration
@EnableAspectJAutoProxy
public class ControllerConfig {
	@Bean
	public Hx711 hx711() {
		Hx711 hx711 = new Hx711(RaspiPin.GPIO_21, RaspiPin.GPIO_22);
		return hx711;
	}

}
