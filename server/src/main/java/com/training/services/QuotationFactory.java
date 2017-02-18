package com.training.services;

import org.springframework.stereotype.Service;

@Service
public class QuotationFactory {

    public QuotationStrategy getQuotation(String currency) {
        if (currency.equalsIgnoreCase("Dollar")) {
            return new DollarQuotation();
        }
        if (currency.equalsIgnoreCase("Peso")) {
            return new PesoQuotation();
        }
        if (currency.equalsIgnoreCase("Real")) {
            return new RealQuotation();
        }
        throw new IllegalArgumentException("Currency must be Dollar, Peso or Real");
    }
}
