package com.wa.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Section {
    @JsonProperty("product_items")
    List<Product> productItems=new ArrayList<>();
    List<Rows> rows=new ArrayList<>();
    String title;
}
