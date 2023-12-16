package com.github.shortener.urlshortener.repositories;

import com.github.shortener.urlshortener.domains.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findById(Long id);

    Optional<Url> findByOriginalUrl(String url);

    Optional<Url> findByShortUrl(String url);
}
