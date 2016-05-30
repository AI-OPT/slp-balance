package com.ai.runner.center.balance.util;

import com.ai.runner.sdk.cache.client.ICacheClient;
import com.ai.runner.sdk.cache.factory.CacheClientBuilderFactory;

public final class CacheFactoryUtil {

    private CacheFactoryUtil() {
    }

    public static ICacheClient getCacheClient(String namespace) {
        return CacheClientBuilderFactory.getCacheClientBuilder().getCacheClient(namespace);
    }

}
