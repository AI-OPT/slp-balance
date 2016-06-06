package com.ai.slp.balance.test.consumer;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.util.DubboUtil;
import com.ai.slp.common.api.subject.interfaces.IGnSubjectQuerySV;
import com.ai.slp.common.api.subject.param.SubjectFund;
import com.ai.slp.common.api.subject.param.SubjectIdParam;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class GnSubjectQuerySVTest extends TestCase {
    private static final Logger logger = LogManager.getLogger(GnSubjectQuerySVTest.class);

    private static final IGnSubjectQuerySV subjectSv = DubboUtil.getIGnSubjectQuerySV();

    @Test
    public void testGetSubjectFund() {
        SubjectFund subjectFund = subjectSv.getSubjectFund(new SubjectIdParam("BIS-ST",100000));
        assertNotNull("查询出的科目为空", subjectFund);
        assertFalse("查询出的科目内容为空", StringUtil.isBlank(subjectFund.getSubjectName()));
        assertEquals("查询出错", 100000, subjectFund.getSubjectId().longValue());
        logger.info("资金科目查询结果{}", JSON.toJSONString(subjectFund));
    }

    @Test
    public void testGetSubjectName() {
        SubjectIdParam subjectId = new SubjectIdParam();
        subjectId.setTenantId("BIS-ST");
        subjectId.setSubjectId(100000);
        String subjectName = subjectSv.getSubjectName(subjectId);
        assertFalse("返回结果为空", StringUtil.isBlank(subjectName));
        logger.info("科目名称名称翻译，科目{}-->{}", 100001, subjectName);
    }
}
