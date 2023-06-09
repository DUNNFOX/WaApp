package com.wa.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Sticker {
    @JsonProperty("mime_type")
    String mimeType;
    String sha256;
    String id;
    boolean animated;
}
