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
public class Component {
    String type;
    @JsonProperty("sub_type")
    String subType;
    List<Parameter> parameters=new ArrayList<>();
    String text;
    int index;
}
