package com.url.shortner.representer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrlRepresenter {

    private String key;
    private String shortUrl;
}
