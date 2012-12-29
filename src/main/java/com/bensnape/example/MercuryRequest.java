package com.bensnape.example;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

public class MercuryRequest {

    private String baseUrl = "http://mercury.itv.com/api/";

    public String requestMostWatchedFeed(String type, String platform) throws IOException {
        String response = "";
        InputStream in = new URL(baseUrl + type + "/" + platform + "/episode/mostwatched").openStream();

        try {
            response = IOUtils.toString(in);
        } finally {
            IOUtils.closeQuietly(in);
        }

        return response;
    }

    public Document stringToXml(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.parse(new InputSource(new StringReader(xml)));
    }

    public JSONObject stringToJson(String json) throws ParseException {
        return (JSONObject) new JSONParser().parse(json);
    }

}
