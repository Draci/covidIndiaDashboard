package com.covidindia.covidIndiaDashboard.controller;

import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.json.simple.JSONObject;

import java.io.IOException;

@Controller
public class CovidController {

    @RequestMapping(value= {"/covidData"}, method= RequestMethod.GET)
    public  JSONObject getCovidData() throws RestClientException, IOException {
        String baseUrl = "https://corona-virus-world-and-india-data.p.rapidapi.com/api_india";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        JSONObject json = null;

        try{
            response=restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(),String.class);
            JSONParser jsonParser = new JSONParser();
            json = (JSONObject) jsonParser.parse(response.getBody());

        }catch (Exception ex)
        {
            System.out.println(ex);
        }

        return json;
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("x-rapidapi-host", "corona-virus-world-and-india-data.p.rapidapi.com");
        headers.set("x-rapidapi-key", "c45555a198msh8b6f48e0fa94780p1e451bjsn4abb2d7622d6");
        return new HttpEntity<>(headers);
    }

}
