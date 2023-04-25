package com.wa.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Order {
    @JsonProperty("catalog_id")
    String catalogId;
    String text;
    @JsonProperty("product_items")
    List<ProductItems> productItems=new ArrayList<>(); 
}
