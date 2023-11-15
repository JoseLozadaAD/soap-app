package com.assuresoft.soap;

import com.assuresoft.soap.model.GetAllCountriesResponse;
import com.assuresoft.soap.model.GetCountryRequest;
import com.assuresoft.soap.model.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
  private static final String NAMESPACE_URI = "www.assuresoft.com";

  @Autowired
  private CountryRepository countryRepository;

  /**
   * This method find a country by its name
   *
   * @param request a country name
   * @return a country
   */
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countryRepository.findCountry(request.getName()));

    return response;
  }

  /**
   * New functionality get all the countries
   *
   * @return a list of all the countries
   */
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
  @ResponsePayload
  public GetAllCountriesResponse getAllCountry() {
    GetAllCountriesResponse response = new GetAllCountriesResponse();
    response.setCountries(countryRepository.findAllCountries());

    return response;
  }
}