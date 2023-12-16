package com.github.shortener.urlshortener.mappers;

import com.github.shortener.urlshortener.domains.Url;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UrlMapper {

    @Mapping(source = "originalUrl", target = "originalUrl")
    @Mapping(source = "shortUrl", target = "shortUrl")
    Url toDomain(String originalUrl, String shortUrl);
}
