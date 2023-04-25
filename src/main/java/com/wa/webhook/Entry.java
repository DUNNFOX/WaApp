package com.wa.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class Entry {
    String id;
    List<Changes> changes = new ArrayList<>();
}
