package com.training.services;

import com.training.exceptions.UnauthorizedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class PesoQuotationTest {

    @Autowired
    @Qualifier("PesoQuotation")
    private QuotationStrategy pesoQuotation;

    @Test(expected = UnauthorizedException.class)
    public void getQuotationTest() throws IOException {
        pesoQuotation.getQuotation();
    }
}