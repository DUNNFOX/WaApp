package com.wa.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TemplateCr {
    private String name;
    private String language;
    private String category;
    private String ft;
    private String bt;
    private String ht;
    private String hdExp;
    private List<String> bdExp;
    private String btnText;
    private String btnNumber;
    private String urlText;
    private String url;




}
