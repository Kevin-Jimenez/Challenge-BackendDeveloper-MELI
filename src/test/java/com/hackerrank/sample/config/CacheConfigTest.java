package com.hackerrank.sample.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import static org.junit.jupiter.api.Assertions.*;

class CacheConfigTest {

    private final CacheConfig cacheConfig = new CacheConfig();

    @Test
    @DisplayName("Deberia configurar correctamente el CacheManager con sus nombres de cache")
    void cacheManager_Configuration_Success() {

        CacheManager cacheManager = cacheConfig.cacheManager();

        assertNotNull(cacheManager);
        assertTrue(cacheManager instanceof CaffeineCacheManager);

        CaffeineCacheManager manager = (CaffeineCacheManager) cacheManager;

        assertTrue(manager.getCacheNames().contains("productById"));
        assertTrue(manager.getCacheNames().contains("productsPage"));
        assertTrue(manager.getCacheNames().contains("vendorById"));
    }
}