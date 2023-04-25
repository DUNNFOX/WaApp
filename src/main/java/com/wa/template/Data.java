package com.wa.template;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data {
    private String name;
    private String status;
    private String category;
    private String id;
}
