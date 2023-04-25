package com.wa.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Phones {
    String phone;
    String type;
    @JsonProperty("wa_id")
    String waId;
}
