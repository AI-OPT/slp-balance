package com.ai.slp.balance.test.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.ai.opt.sdk.appserver.CacheServiceStart;
import com.ai.slp.balance.util.FunSubjectUtil;

public class FunSubjectCacheTest {

    private static final Logger log = LogManager.getLogger(FunSubjectCacheTest.class);

    @Before
    public void testWrite() throws Exception {
        CacheServiceStart.main(new String[] {});
    }

    @Test
    public void testWriteFunSubject() throws Exception {
        String funSubjectName = FunSubjectUtil.getFunSubject(100000L).toJSONString();
        log.debug("获取到缓存FunSubject：" + funSubjectName);
        // assertEquals("优酷170付费点播", funSubjectName);
    }

    @Test
    public void write() throws Exception {
        CacheServiceStart.main(new String[] {});
    }
}