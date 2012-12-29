package com.bensnape.example;

import com.jayway.jsonpath.JsonPath;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import static org.junit.Assert.assertEquals;


public class MercuryStepdefs {

    private MercuryRequest mercuryRequest;

    private String response;

    private enum RequestType {
        JSON, XML
    }

    @Given("^I request the (\\w+) Most Watched Feed for (\\w+)$")
    public void I_request_the_type_Most_Watched_Feed_for_platform(String type, String platform) throws Throwable {
        mercuryRequest = new MercuryRequest();
        response = mercuryRequest.requestMostWatchedFeed(type, platform);
    }

    @Then("^I get a successful (\\w+) response with the correct (\\w+)$")
    public void I_get_a_successful_type_response_with_the_correct_platform(String type, String platform) throws Throwable {
        String text;
        response = mercuryRequest.requestMostWatchedFeed(type, platform);

        switch (RequestType.valueOf(type.toUpperCase())) {
            case JSON:
                JSONObject json = mercuryRequest.stringToJson(response);
                text = JsonPath.read(json, "$.Parameters.Platform");
                assertEquals(platform, text);
                break;
            case XML:
                Document xml = mercuryRequest.stringToXml(response);
                XPathFactory xpf = XPathFactory.newInstance();
                XPath xpath = xpf.newXPath();
                text = xpath.evaluate("//Params/Param[2]/Value", xml.getDocumentElement());
                assertEquals(platform, text);
                break;
        }
    }

}
