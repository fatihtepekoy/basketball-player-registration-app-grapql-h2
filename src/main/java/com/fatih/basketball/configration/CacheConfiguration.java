package com.fatih.basketball.configration;

import java.util.List;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {

  public static final String PLAYERS_CACHE = "PLAYERS_CACHE";

  @Bean
  public CacheManager cacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();
    cacheManager.setCaches(List.of(new ConcurrentMapCache(PLAYERS_CACHE)));
    cacheManager.initializeCaches();
    return new TransactionAwareCacheManagerProxy(cacheManager);
  }
}