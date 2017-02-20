package com.training.controllers;

import com.training.model.Quotation;
import com.training.services.QuotationStrategy;
import com.training.services.QuotationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private QuotationFactory quotationFactory;

    @RequestMapping(value = "/quotation/{currency}", method = RequestMethod.GET)
    public Quotation getQuotation(@PathVariable String currency) throws IOException {

        QuotationStrategy quotationStrategy = quotationFactory.getQuotation(currency);

        return quotationStrategy.getQuotation();
    }
}
