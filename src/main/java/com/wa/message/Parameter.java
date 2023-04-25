package com.wa.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Parameter {
    String type;
    String text;
    Currency currency;
    @JsonProperty("date_time")
    DateTime dateTime;
    Media image;
    Media document;
    Media video;
}
