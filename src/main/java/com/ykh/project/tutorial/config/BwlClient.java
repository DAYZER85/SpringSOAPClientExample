package com.ykh.project.tutorial.config;

import GeocoderService.wsdl.CensusYear;
import GeocoderService.wsdl.GeocodeAddressNonParsed;
import GeocoderService.wsdl.GeocodeAddressNonParsedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.DatatypeConfigurationException;

@Slf4j
public class BwlClient extends WebServiceGatewaySupport {


    public GeocodeAddressNonParsedResponse getCountry()  throws DatatypeConfigurationException {

        GeocodeAddressNonParsed addressRequest =  new GeocodeAddressNonParsed();
        addressRequest.setStreetAddress("3620 North Vermont Ave W.");
        addressRequest.setApiKey("6ca4b61d9dae475a924c01103f53ba56");
        addressRequest.setVersion(4.01);
        addressRequest.setShouldCalculateCensus(true);
        addressRequest.setShouldNotStoreTransactionDetails(false);
        addressRequest.setShouldReturnReferenceGeometry(false);

        addressRequest.setCensusYear(CensusYear.ALL_AVAILABLE);
        log.info("Requesting location for " + addressRequest);

        GeocodeAddressNonParsedResponse response = (GeocodeAddressNonParsedResponse) getWebServiceTemplate()
                .marshalSendAndReceive( addressRequest,
                        new SoapActionCallback(
                                "https://geoservices.tamu.edu/GeocodeAddressNonParsed"));

        return response;
    }


}
