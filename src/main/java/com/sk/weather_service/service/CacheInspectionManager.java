package com.sk.weather_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CacheInspectionManager {

    @Autowired
    CacheManager cacheManager;

    public String getCacheContents(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        String cacheStr;
        if (cache != null) {
            System.out.println("Cache contents : ");
            System.out.println(Objects.requireNonNull(cache.getNativeCache()).toString());
            cacheStr = Objects.requireNonNull(cache.getNativeCache()).toString();
        } else {
            System.out.println("No cache for : "+cacheName);
            cacheStr = "No cache for : "+cacheName;
        }
        return cacheStr;
    }

}
