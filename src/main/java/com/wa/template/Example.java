package com.wa.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Example {

    @JsonProperty("header_text")
    private List<String> headerText;

    @JsonProperty("body_text")
    private List<List<String>> bodyText;

}
