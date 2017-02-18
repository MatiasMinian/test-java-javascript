package com.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data public class Quotation {

    private String currency;
    private double quote;
    private String lastUpdate;
}
