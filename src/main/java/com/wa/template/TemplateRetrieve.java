package com.wa.template;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRetrieve {
    private List<Data> data;
}
