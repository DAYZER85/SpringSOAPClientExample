package com.ykh.project.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BilbertClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("GeocoderService.wsdl");
        return marshaller;
    }



    @Bean
    public BwlClient countryClient(Jaxb2Marshaller marshaller) {
        BwlClient client = new BwlClient();
        client.setDefaultUri("https://geoservices.tamu.edu/Services/Geocode/WebService/GeocoderService_V04_01.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setMessageSender(new WebServiceMessageSenderWithAuth());
        return client;
    }


}
