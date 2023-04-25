package com.wa.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Location {
    String latitude;
    String longitude;
    String name;
    String address;
}
