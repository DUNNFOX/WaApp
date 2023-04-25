package com.wa.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Template {
    String name;
    Language language;
    List<Component> components = new ArrayList<>();
}
