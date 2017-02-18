package com.training.services;

import com.training.model.Quotation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class DollarQuotationTest {

    @Autowired
    @Qualifier("DollarQuotation")
    private QuotationStrategy dollarQuotation;

    @Test
    public void getQuotationTest() throws Exception {
        Quotation quotation = dollarQuotation.getQuotation();
        assertTrue(quotation.getCurrency().equals("USD"));
    }
}