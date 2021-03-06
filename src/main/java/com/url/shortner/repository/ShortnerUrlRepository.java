package com.url.shortner.repository;

import com.url.shortner.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortnerUrlRepository extends JpaRepository<ShortUrl, String> {

    Optional<ShortUrl> findById(String key);
    Optional<ShortUrl> findByUrl(String url);
}
