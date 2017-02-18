package com.training.services;

import com.training.model.Quotation;

import java.io.IOException;

public interface QuotationStrategy {

    Quotation getQuotation() throws IOException;

}
