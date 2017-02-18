package com.training.services;

import com.training.exceptions.UnauthorizedException;
import com.training.model.Quotation;
import org.springframework.stereotype.Service;

@Service("RealQuotation")
public class RealQuotation implements QuotationStrategy {

    @Override
    public Quotation getQuotation() {
        throw new UnauthorizedException();
    }
}
