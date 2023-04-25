package com.wa.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Identity {
    String acknowledged;
    @JsonProperty("created_timestamp")
    String createdTimestamp;
    String hash;
}
