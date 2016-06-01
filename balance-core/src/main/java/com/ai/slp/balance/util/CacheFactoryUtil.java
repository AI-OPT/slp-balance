package com.ai.slp.balance.util;

import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;

public final class CacheFactoryUtil {

    private CacheFactoryUtil() {
    }

    public static ICacheClient getCacheClient(String namespace) {
    	return CacheFactoryUtil.getCacheClient(namespace);
    }

}
