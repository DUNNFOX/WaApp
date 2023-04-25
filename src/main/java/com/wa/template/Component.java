package com.wa.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Component {
    private String type;
    private String format;
    private String text;
    private Example example;
    private List<Button> buttons;

}
