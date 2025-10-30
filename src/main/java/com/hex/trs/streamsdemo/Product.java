package com.hex.trs.streamsdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String title;
    private double price;
    private Category category;
    private Vendor vendor;
}

enum Category {
    MOBILE,
    LAPTOP,
    DESKTOP
}
