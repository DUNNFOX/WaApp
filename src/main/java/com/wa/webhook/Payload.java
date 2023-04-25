package com.wa.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Payload {
    String object;
    List<Entry> entry=new ArrayList<>();

}
