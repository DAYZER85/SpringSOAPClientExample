package com.ykh.project.tutorial;

import GeocoderService.wsdl.GeocodeAddressNonParsedResponse;
import com.ykh.project.tutorial.config.BwlClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MytestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytestApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(BwlClient bwlClient) {
        return (args) -> {
            GeocodeAddressNonParsedResponse response = bwlClient.getCountry();
            System.err.println(response);
        };

    }
}


