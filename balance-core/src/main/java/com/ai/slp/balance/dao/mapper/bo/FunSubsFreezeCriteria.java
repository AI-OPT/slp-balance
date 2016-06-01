package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunSubsFreezeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunSubsFreezeCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSubsFreezeIdIsNull() {
            addCriterion("SUBS_FREEZE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdIsNotNull() {
            addCriterion("SUBS_FREEZE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdEqualTo(Long value) {
            addCriterion("SUBS_FREEZE_ID =", value, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdNotEqualTo(Long value) {
            addCriterion("SUBS_FREEZE_ID <>", value, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdGreaterThan(Long value) {
            addCriterion("SUBS_FREEZE_ID >", value, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBS_FREEZE_ID >=", value, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdLessThan(Long value) {
            addCriterion("SUBS_FREEZE_ID <", value, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdLessThanOrEqualTo(Long value) {
            addCriterion("SUBS_FREEZE_ID <=", value, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdIn(List<Long> values) {
            addCriterion("SUBS_FREEZE_ID in", values, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdNotIn(List<Long> values) {
            addCriterion("SUBS_FREEZE_ID not in", values, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdBetween(Long value1, Long value2) {
            addCriterion("SUBS_FREEZE_ID between", value1, value2, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andSubsFreezeIdNotBetween(Long value1, Long value2) {
            addCriterion("SUBS_FREEZE_ID not between", value1, value2, "subsFreezeId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdIsNull() {
            addCriterion("PAY_RULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdIsNotNull() {
            addCriterion("PAY_RULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdEqualTo(Long value) {
            addCriterion("PAY_RULE_ID =", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdNotEqualTo(Long value) {
            addCriterion("PAY_RULE_ID <>", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdGreaterThan(Long value) {
            addCriterion("PAY_RULE_ID >", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PAY_RULE_ID >=", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdLessThan(Long value) {
            addCriterion("PAY_RULE_ID <", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("PAY_RULE_ID <=", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdIn(List<Long> values) {
            addCriterion("PAY_RULE_ID in", values, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdNotIn(List<Long> values) {
            addCriterion("PAY_RULE_ID not in", values, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdBetween(Long value1, Long value2) {
            addCriterion("PAY_RULE_ID between", value1, value2, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("PAY_RULE_ID not between", value1, value2, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdIsNull() {
            addCriterion("FREEZE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFreezeIdIsNotNull() {
            addCriterion("FREEZE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeIdEqualTo(Long value) {
            addCriterion("FREEZE_ID =", value, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdNotEqualTo(Long value) {
            addCriterion("FREEZE_ID <>", value, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdGreaterThan(Long value) {
            addCriterion("FREEZE_ID >", value, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FREEZE_ID >=", value, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdLessThan(Long value) {
            addCriterion("FREEZE_ID <", value, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdLessThanOrEqualTo(Long value) {
            addCriterion("FREEZE_ID <=", value, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdIn(List<Long> values) {
            addCriterion("FREEZE_ID in", values, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdNotIn(List<Long> values) {
            addCriterion("FREEZE_ID not in", values, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdBetween(Long value1, Long value2) {
            addCriterion("FREEZE_ID between", value1, value2, "freezeId");
            return (Criteria) this;
        }

        public Criteria andFreezeIdNotBetween(Long value1, Long value2) {
            addCriterion("FREEZE_ID not between", value1, value2, "freezeId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNull() {
            addCriterion("SUBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNotNull() {
            addCriterion("SUBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsIdEqualTo(Long value) {
            addCriterion("SUBS_ID =", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotEqualTo(Long value) {
            addCriterion("SUBS_ID <>", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThan(Long value) {
            addCriterion("SUBS_ID >", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBS_ID >=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThan(Long value) {
            addCriterion("SUBS_ID <", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThanOrEqualTo(Long value) {
            addCriterion("SUBS_ID <=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIn(List<Long> values) {
            addCriterion("SUBS_ID in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotIn(List<Long> values) {
            addCriterion("SUBS_ID not in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdBetween(Long value1, Long value2) {
            addCriterion("SUBS_ID between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotBetween(Long value1, Long value2) {
            addCriterion("SUBS_ID not between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNull() {
            addCriterion("ACCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("ACCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(Long value) {
            addCriterion("ACCT_ID =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(Long value) {
            addCriterion("ACCT_ID <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(Long value) {
            addCriterion("ACCT_ID >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCT_ID >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(Long value) {
            addCriterion("ACCT_ID <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(Long value) {
            addCriterion("ACCT_ID <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<Long> values) {
            addCriterion("ACCT_ID in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<Long> values) {
            addCriterion("ACCT_ID not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(Long value1, Long value2) {
            addCriterion("ACCT_ID between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(Long value1, Long value2) {
            addCriterion("ACCT_ID not between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("SUBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("SUBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Long value) {
            addCriterion("SUBJECT_ID =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Long value) {
            addCriterion("SUBJECT_ID <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Long value) {
            addCriterion("SUBJECT_ID >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_ID >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Long value) {
            addCriterion("SUBJECT_ID <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("SUBJECT_ID <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Long> values) {
            addCriterion("SUBJECT_ID in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Long> values) {
            addCriterion("SUBJECT_ID not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_ID between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("SUBJECT_ID not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdIsNull() {
            addCriterion("DEST_SUBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdIsNotNull() {
            addCriterion("DEST_SUBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdEqualTo(Long value) {
            addCriterion("DEST_SUBJECT_ID =", value, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdNotEqualTo(Long value) {
            addCriterion("DEST_SUBJECT_ID <>", value, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdGreaterThan(Long value) {
            addCriterion("DEST_SUBJECT_ID >", value, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DEST_SUBJECT_ID >=", value, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdLessThan(Long value) {
            addCriterion("DEST_SUBJECT_ID <", value, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("DEST_SUBJECT_ID <=", value, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdIn(List<Long> values) {
            addCriterion("DEST_SUBJECT_ID in", values, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdNotIn(List<Long> values) {
            addCriterion("DEST_SUBJECT_ID not in", values, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdBetween(Long value1, Long value2) {
            addCriterion("DEST_SUBJECT_ID between", value1, value2, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andDestSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("DEST_SUBJECT_ID not between", value1, value2, "destSubjectId");
            return (Criteria) this;
        }

        public Criteria andRunModeIsNull() {
            addCriterion("RUN_MODE is null");
            return (Criteria) this;
        }

        public Criteria andRunModeIsNotNull() {
            addCriterion("RUN_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andRunModeEqualTo(String value) {
            addCriterion("RUN_MODE =", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeNotEqualTo(String value) {
            addCriterion("RUN_MODE <>", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeGreaterThan(String value) {
            addCriterion("RUN_MODE >", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeGreaterThanOrEqualTo(String value) {
            addCriterion("RUN_MODE >=", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeLessThan(String value) {
            addCriterion("RUN_MODE <", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeLessThanOrEqualTo(String value) {
            addCriterion("RUN_MODE <=", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeLike(String value) {
            addCriterion("RUN_MODE like", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeNotLike(String value) {
            addCriterion("RUN_MODE not like", value, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeIn(List<String> values) {
            addCriterion("RUN_MODE in", values, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeNotIn(List<String> values) {
            addCriterion("RUN_MODE not in", values, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeBetween(String value1, String value2) {
            addCriterion("RUN_MODE between", value1, value2, "runMode");
            return (Criteria) this;
        }

        public Criteria andRunModeNotBetween(String value1, String value2) {
            addCriterion("RUN_MODE not between", value1, value2, "runMode");
            return (Criteria) this;
        }

        public Criteria andCalModeIsNull() {
            addCriterion("CAL_MODE is null");
            return (Criteria) this;
        }

        public Criteria andCalModeIsNotNull() {
            addCriterion("CAL_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andCalModeEqualTo(String value) {
            addCriterion("CAL_MODE =", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeNotEqualTo(String value) {
            addCriterion("CAL_MODE <>", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeGreaterThan(String value) {
            addCriterion("CAL_MODE >", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_MODE >=", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeLessThan(String value) {
            addCriterion("CAL_MODE <", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeLessThanOrEqualTo(String value) {
            addCriterion("CAL_MODE <=", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeLike(String value) {
            addCriterion("CAL_MODE like", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeNotLike(String value) {
            addCriterion("CAL_MODE not like", value, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeIn(List<String> values) {
            addCriterion("CAL_MODE in", values, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeNotIn(List<String> values) {
            addCriterion("CAL_MODE not in", values, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeBetween(String value1, String value2) {
            addCriterion("CAL_MODE between", value1, value2, "calMode");
            return (Criteria) this;
        }

        public Criteria andCalModeNotBetween(String value1, String value2) {
            addCriterion("CAL_MODE not between", value1, value2, "calMode");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountIsNull() {
            addCriterion("ORGINAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountIsNotNull() {
            addCriterion("ORGINAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountEqualTo(Long value) {
            addCriterion("ORGINAL_AMOUNT =", value, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountNotEqualTo(Long value) {
            addCriterion("ORGINAL_AMOUNT <>", value, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountGreaterThan(Long value) {
            addCriterion("ORGINAL_AMOUNT >", value, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("ORGINAL_AMOUNT >=", value, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountLessThan(Long value) {
            addCriterion("ORGINAL_AMOUNT <", value, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountLessThanOrEqualTo(Long value) {
            addCriterion("ORGINAL_AMOUNT <=", value, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountIn(List<Long> values) {
            addCriterion("ORGINAL_AMOUNT in", values, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountNotIn(List<Long> values) {
            addCriterion("ORGINAL_AMOUNT not in", values, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountBetween(Long value1, Long value2) {
            addCriterion("ORGINAL_AMOUNT between", value1, value2, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andOrginalAmountNotBetween(Long value1, Long value2) {
            addCriterion("ORGINAL_AMOUNT not between", value1, value2, "orginalAmount");
            return (Criteria) this;
        }

        public Criteria andAllotMonthIsNull() {
            addCriterion("ALLOT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andAllotMonthIsNotNull() {
            addCriterion("ALLOT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andAllotMonthEqualTo(Integer value) {
            addCriterion("ALLOT_MONTH =", value, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthNotEqualTo(Integer value) {
            addCriterion("ALLOT_MONTH <>", value, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthGreaterThan(Integer value) {
            addCriterion("ALLOT_MONTH >", value, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALLOT_MONTH >=", value, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthLessThan(Integer value) {
            addCriterion("ALLOT_MONTH <", value, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthLessThanOrEqualTo(Integer value) {
            addCriterion("ALLOT_MONTH <=", value, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthIn(List<Integer> values) {
            addCriterion("ALLOT_MONTH in", values, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthNotIn(List<Integer> values) {
            addCriterion("ALLOT_MONTH not in", values, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthBetween(Integer value1, Integer value2) {
            addCriterion("ALLOT_MONTH between", value1, value2, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("ALLOT_MONTH not between", value1, value2, "allotMonth");
            return (Criteria) this;
        }

        public Criteria andThawFeeIsNull() {
            addCriterion("THAW_FEE is null");
            return (Criteria) this;
        }

        public Criteria andThawFeeIsNotNull() {
            addCriterion("THAW_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andThawFeeEqualTo(Long value) {
            addCriterion("THAW_FEE =", value, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeNotEqualTo(Long value) {
            addCriterion("THAW_FEE <>", value, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeGreaterThan(Long value) {
            addCriterion("THAW_FEE >", value, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("THAW_FEE >=", value, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeLessThan(Long value) {
            addCriterion("THAW_FEE <", value, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeLessThanOrEqualTo(Long value) {
            addCriterion("THAW_FEE <=", value, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeIn(List<Long> values) {
            addCriterion("THAW_FEE in", values, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeNotIn(List<Long> values) {
            addCriterion("THAW_FEE not in", values, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeBetween(Long value1, Long value2) {
            addCriterion("THAW_FEE between", value1, value2, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawFeeNotBetween(Long value1, Long value2) {
            addCriterion("THAW_FEE not between", value1, value2, "thawFee");
            return (Criteria) this;
        }

        public Criteria andThawScaleIsNull() {
            addCriterion("THAW_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andThawScaleIsNotNull() {
            addCriterion("THAW_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andThawScaleEqualTo(Integer value) {
            addCriterion("THAW_SCALE =", value, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleNotEqualTo(Integer value) {
            addCriterion("THAW_SCALE <>", value, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleGreaterThan(Integer value) {
            addCriterion("THAW_SCALE >", value, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("THAW_SCALE >=", value, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleLessThan(Integer value) {
            addCriterion("THAW_SCALE <", value, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleLessThanOrEqualTo(Integer value) {
            addCriterion("THAW_SCALE <=", value, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleIn(List<Integer> values) {
            addCriterion("THAW_SCALE in", values, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleNotIn(List<Integer> values) {
            addCriterion("THAW_SCALE not in", values, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleBetween(Integer value1, Integer value2) {
            addCriterion("THAW_SCALE between", value1, value2, "thawScale");
            return (Criteria) this;
        }

        public Criteria andThawScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("THAW_SCALE not between", value1, value2, "thawScale");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountIsNull() {
            addCriterion("ALREADY_ALLOT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountIsNotNull() {
            addCriterion("ALREADY_ALLOT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountEqualTo(Long value) {
            addCriterion("ALREADY_ALLOT_AMOUNT =", value, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountNotEqualTo(Long value) {
            addCriterion("ALREADY_ALLOT_AMOUNT <>", value, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountGreaterThan(Long value) {
            addCriterion("ALREADY_ALLOT_AMOUNT >", value, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("ALREADY_ALLOT_AMOUNT >=", value, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountLessThan(Long value) {
            addCriterion("ALREADY_ALLOT_AMOUNT <", value, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountLessThanOrEqualTo(Long value) {
            addCriterion("ALREADY_ALLOT_AMOUNT <=", value, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountIn(List<Long> values) {
            addCriterion("ALREADY_ALLOT_AMOUNT in", values, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountNotIn(List<Long> values) {
            addCriterion("ALREADY_ALLOT_AMOUNT not in", values, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountBetween(Long value1, Long value2) {
            addCriterion("ALREADY_ALLOT_AMOUNT between", value1, value2, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotAmountNotBetween(Long value1, Long value2) {
            addCriterion("ALREADY_ALLOT_AMOUNT not between", value1, value2, "alreadyAllotAmount");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthIsNull() {
            addCriterion("ALREADY_ALLOT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthIsNotNull() {
            addCriterion("ALREADY_ALLOT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthEqualTo(Integer value) {
            addCriterion("ALREADY_ALLOT_MONTH =", value, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthNotEqualTo(Integer value) {
            addCriterion("ALREADY_ALLOT_MONTH <>", value, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthGreaterThan(Integer value) {
            addCriterion("ALREADY_ALLOT_MONTH >", value, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALREADY_ALLOT_MONTH >=", value, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthLessThan(Integer value) {
            addCriterion("ALREADY_ALLOT_MONTH <", value, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthLessThanOrEqualTo(Integer value) {
            addCriterion("ALREADY_ALLOT_MONTH <=", value, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthIn(List<Integer> values) {
            addCriterion("ALREADY_ALLOT_MONTH in", values, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthNotIn(List<Integer> values) {
            addCriterion("ALREADY_ALLOT_MONTH not in", values, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthBetween(Integer value1, Integer value2) {
            addCriterion("ALREADY_ALLOT_MONTH between", value1, value2, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAlreadyAllotMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("ALREADY_ALLOT_MONTH not between", value1, value2, "alreadyAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthIsNull() {
            addCriterion("START_ALLOT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthIsNotNull() {
            addCriterion("START_ALLOT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthEqualTo(String value) {
            addCriterion("START_ALLOT_MONTH =", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthNotEqualTo(String value) {
            addCriterion("START_ALLOT_MONTH <>", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthGreaterThan(String value) {
            addCriterion("START_ALLOT_MONTH >", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthGreaterThanOrEqualTo(String value) {
            addCriterion("START_ALLOT_MONTH >=", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthLessThan(String value) {
            addCriterion("START_ALLOT_MONTH <", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthLessThanOrEqualTo(String value) {
            addCriterion("START_ALLOT_MONTH <=", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthLike(String value) {
            addCriterion("START_ALLOT_MONTH like", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthNotLike(String value) {
            addCriterion("START_ALLOT_MONTH not like", value, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthIn(List<String> values) {
            addCriterion("START_ALLOT_MONTH in", values, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthNotIn(List<String> values) {
            addCriterion("START_ALLOT_MONTH not in", values, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthBetween(String value1, String value2) {
            addCriterion("START_ALLOT_MONTH between", value1, value2, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andStartAllotMonthNotBetween(String value1, String value2) {
            addCriterion("START_ALLOT_MONTH not between", value1, value2, "startAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthIsNull() {
            addCriterion("LAST_ALLOT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthIsNotNull() {
            addCriterion("LAST_ALLOT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthEqualTo(String value) {
            addCriterion("LAST_ALLOT_MONTH =", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthNotEqualTo(String value) {
            addCriterion("LAST_ALLOT_MONTH <>", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthGreaterThan(String value) {
            addCriterion("LAST_ALLOT_MONTH >", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_ALLOT_MONTH >=", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthLessThan(String value) {
            addCriterion("LAST_ALLOT_MONTH <", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthLessThanOrEqualTo(String value) {
            addCriterion("LAST_ALLOT_MONTH <=", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthLike(String value) {
            addCriterion("LAST_ALLOT_MONTH like", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthNotLike(String value) {
            addCriterion("LAST_ALLOT_MONTH not like", value, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthIn(List<String> values) {
            addCriterion("LAST_ALLOT_MONTH in", values, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthNotIn(List<String> values) {
            addCriterion("LAST_ALLOT_MONTH not in", values, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthBetween(String value1, String value2) {
            addCriterion("LAST_ALLOT_MONTH between", value1, value2, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andLastAllotMonthNotBetween(String value1, String value2) {
            addCriterion("LAST_ALLOT_MONTH not between", value1, value2, "lastAllotMonth");
            return (Criteria) this;
        }

        public Criteria andAllotStatusIsNull() {
            addCriterion("ALLOT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAllotStatusIsNotNull() {
            addCriterion("ALLOT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAllotStatusEqualTo(String value) {
            addCriterion("ALLOT_STATUS =", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusNotEqualTo(String value) {
            addCriterion("ALLOT_STATUS <>", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusGreaterThan(String value) {
            addCriterion("ALLOT_STATUS >", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ALLOT_STATUS >=", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusLessThan(String value) {
            addCriterion("ALLOT_STATUS <", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusLessThanOrEqualTo(String value) {
            addCriterion("ALLOT_STATUS <=", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusLike(String value) {
            addCriterion("ALLOT_STATUS like", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusNotLike(String value) {
            addCriterion("ALLOT_STATUS not like", value, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusIn(List<String> values) {
            addCriterion("ALLOT_STATUS in", values, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusNotIn(List<String> values) {
            addCriterion("ALLOT_STATUS not in", values, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusBetween(String value1, String value2) {
            addCriterion("ALLOT_STATUS between", value1, value2, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andAllotStatusNotBetween(String value1, String value2) {
            addCriterion("ALLOT_STATUS not between", value1, value2, "allotStatus");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateIsNull() {
            addCriterion("LAST_ALLOT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateIsNotNull() {
            addCriterion("LAST_ALLOT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateEqualTo(Timestamp value) {
            addCriterion("LAST_ALLOT_DATE =", value, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateNotEqualTo(Timestamp value) {
            addCriterion("LAST_ALLOT_DATE <>", value, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateGreaterThan(Timestamp value) {
            addCriterion("LAST_ALLOT_DATE >", value, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("LAST_ALLOT_DATE >=", value, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateLessThan(Timestamp value) {
            addCriterion("LAST_ALLOT_DATE <", value, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("LAST_ALLOT_DATE <=", value, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateIn(List<Timestamp> values) {
            addCriterion("LAST_ALLOT_DATE in", values, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateNotIn(List<Timestamp> values) {
            addCriterion("LAST_ALLOT_DATE not in", values, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LAST_ALLOT_DATE between", value1, value2, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andLastAllotDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LAST_ALLOT_DATE not between", value1, value2, "lastAllotDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andActiveDateIsNull() {
            addCriterion("ACTIVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andActiveDateIsNotNull() {
            addCriterion("ACTIVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andActiveDateEqualTo(Timestamp value) {
            addCriterion("ACTIVE_DATE =", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotEqualTo(Timestamp value) {
            addCriterion("ACTIVE_DATE <>", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateGreaterThan(Timestamp value) {
            addCriterion("ACTIVE_DATE >", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ACTIVE_DATE >=", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateLessThan(Timestamp value) {
            addCriterion("ACTIVE_DATE <", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("ACTIVE_DATE <=", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateIn(List<Timestamp> values) {
            addCriterion("ACTIVE_DATE in", values, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotIn(List<Timestamp> values) {
            addCriterion("ACTIVE_DATE not in", values, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACTIVE_DATE between", value1, value2, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACTIVE_DATE not between", value1, value2, "activeDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateIsNull() {
            addCriterion("INACTIVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInactiveDateIsNotNull() {
            addCriterion("INACTIVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInactiveDateEqualTo(Timestamp value) {
            addCriterion("INACTIVE_DATE =", value, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateNotEqualTo(Timestamp value) {
            addCriterion("INACTIVE_DATE <>", value, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateGreaterThan(Timestamp value) {
            addCriterion("INACTIVE_DATE >", value, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("INACTIVE_DATE >=", value, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateLessThan(Timestamp value) {
            addCriterion("INACTIVE_DATE <", value, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("INACTIVE_DATE <=", value, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateIn(List<Timestamp> values) {
            addCriterion("INACTIVE_DATE in", values, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateNotIn(List<Timestamp> values) {
            addCriterion("INACTIVE_DATE not in", values, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("INACTIVE_DATE between", value1, value2, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andInactiveDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("INACTIVE_DATE not between", value1, value2, "inactiveDate");
            return (Criteria) this;
        }

        public Criteria andChnlIdIsNull() {
            addCriterion("CHNL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChnlIdIsNotNull() {
            addCriterion("CHNL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChnlIdEqualTo(String value) {
            addCriterion("CHNL_ID =", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotEqualTo(String value) {
            addCriterion("CHNL_ID <>", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdGreaterThan(String value) {
            addCriterion("CHNL_ID >", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHNL_ID >=", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdLessThan(String value) {
            addCriterion("CHNL_ID <", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdLessThanOrEqualTo(String value) {
            addCriterion("CHNL_ID <=", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdLike(String value) {
            addCriterion("CHNL_ID like", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotLike(String value) {
            addCriterion("CHNL_ID not like", value, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdIn(List<String> values) {
            addCriterion("CHNL_ID in", values, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotIn(List<String> values) {
            addCriterion("CHNL_ID not in", values, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdBetween(String value1, String value2) {
            addCriterion("CHNL_ID between", value1, value2, "chnlId");
            return (Criteria) this;
        }

        public Criteria andChnlIdNotBetween(String value1, String value2) {
            addCriterion("CHNL_ID not between", value1, value2, "chnlId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNull() {
            addCriterion("CREATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNotNull() {
            addCriterion("CREATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdEqualTo(String value) {
            addCriterion("CREATE_OPER_ID =", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <>", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThan(String value) {
            addCriterion("CREATE_OPER_ID >", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID >=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThan(String value) {
            addCriterion("CREATE_OPER_ID <", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLike(String value) {
            addCriterion("CREATE_OPER_ID like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotLike(String value) {
            addCriterion("CREATE_OPER_ID not like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIn(List<String> values) {
            addCriterion("CREATE_OPER_ID in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotIn(List<String> values) {
            addCriterion("CREATE_OPER_ID not in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID not between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsIsNull() {
            addCriterion("FUND_ACTIVE_MONTHS is null");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsIsNotNull() {
            addCriterion("FUND_ACTIVE_MONTHS is not null");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsEqualTo(Integer value) {
            addCriterion("FUND_ACTIVE_MONTHS =", value, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsNotEqualTo(Integer value) {
            addCriterion("FUND_ACTIVE_MONTHS <>", value, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsGreaterThan(Integer value) {
            addCriterion("FUND_ACTIVE_MONTHS >", value, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUND_ACTIVE_MONTHS >=", value, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsLessThan(Integer value) {
            addCriterion("FUND_ACTIVE_MONTHS <", value, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsLessThanOrEqualTo(Integer value) {
            addCriterion("FUND_ACTIVE_MONTHS <=", value, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsIn(List<Integer> values) {
            addCriterion("FUND_ACTIVE_MONTHS in", values, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsNotIn(List<Integer> values) {
            addCriterion("FUND_ACTIVE_MONTHS not in", values, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsBetween(Integer value1, Integer value2) {
            addCriterion("FUND_ACTIVE_MONTHS between", value1, value2, "fundActiveMonths");
            return (Criteria) this;
        }

        public Criteria andFundActiveMonthsNotBetween(Integer value1, Integer value2) {
            addCriterion("FUND_ACTIVE_MONTHS not between", value1, value2, "fundActiveMonths");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}