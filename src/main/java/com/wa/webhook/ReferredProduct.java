package com.wa.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReferredProduct {
    @JsonProperty("catalog_id")
    String catalogId;
    @JsonProperty("product_ratailer_id")
    String productRetailerId;
}
