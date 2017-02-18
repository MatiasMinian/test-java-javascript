package com.training.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.Quotation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("DollarQuotation")
public class DollarQuotation implements QuotationStrategy {

    @Override
    public Quotation getQuotation() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String stringResponse = restTemplate.getForObject("http://apilayer.net/api/live?access_key=c9ed30272f078ece78f2f8fd3e07dec0&source=USD&currencies=ARS&format=1", String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(stringResponse);
        JsonNode quotes = response.get("quotes");
        String currency = response.get("source").asText();
        double quote = quotes.get("USDARS").asDouble();

        Date date = new Date();
        date.setTime(response.get("timestamp").asLong() * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return new Quotation(currency, quote, sdf.format(date));
    }
}
