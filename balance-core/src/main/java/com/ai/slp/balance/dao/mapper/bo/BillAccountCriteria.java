package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BillAccountCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BillAccountCriteria() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdIsNull() {
            addCriterion("bill_cycle_id is null");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdIsNotNull() {
            addCriterion("bill_cycle_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdEqualTo(String value) {
            addCriterion("bill_cycle_id =", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdNotEqualTo(String value) {
            addCriterion("bill_cycle_id <>", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdGreaterThan(String value) {
            addCriterion("bill_cycle_id >", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdGreaterThanOrEqualTo(String value) {
            addCriterion("bill_cycle_id >=", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdLessThan(String value) {
            addCriterion("bill_cycle_id <", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdLessThanOrEqualTo(String value) {
            addCriterion("bill_cycle_id <=", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdLike(String value) {
            addCriterion("bill_cycle_id like", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdNotLike(String value) {
            addCriterion("bill_cycle_id not like", value, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdIn(List<String> values) {
            addCriterion("bill_cycle_id in", values, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdNotIn(List<String> values) {
            addCriterion("bill_cycle_id not in", values, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdBetween(String value1, String value2) {
            addCriterion("bill_cycle_id between", value1, value2, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andBillCycleIdNotBetween(String value1, String value2) {
            addCriterion("bill_cycle_id not between", value1, value2, "billCycleId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(String value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(String value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(String value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(String value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(String value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLike(String value) {
            addCriterion("subject_id like", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotLike(String value) {
            addCriterion("subject_id not like", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<String> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<String> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(String value1, String value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(String value1, String value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Long value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Long value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Long value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Long value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Long value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Long> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Long> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Long value1, Long value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Long value1, Long value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaIsNull() {
            addCriterion("overdraft_quota is null");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaIsNotNull() {
            addCriterion("overdraft_quota is not null");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaEqualTo(Long value) {
            addCriterion("overdraft_quota =", value, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaNotEqualTo(Long value) {
            addCriterion("overdraft_quota <>", value, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaGreaterThan(Long value) {
            addCriterion("overdraft_quota >", value, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("overdraft_quota >=", value, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaLessThan(Long value) {
            addCriterion("overdraft_quota <", value, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaLessThanOrEqualTo(Long value) {
            addCriterion("overdraft_quota <=", value, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaIn(List<Long> values) {
            addCriterion("overdraft_quota in", values, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaNotIn(List<Long> values) {
            addCriterion("overdraft_quota not in", values, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaBetween(Long value1, Long value2) {
            addCriterion("overdraft_quota between", value1, value2, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andOverdraftQuotaNotBetween(Long value1, Long value2) {
            addCriterion("overdraft_quota not between", value1, value2, "overdraftQuota");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPayDayIsNull() {
            addCriterion("pay_day is null");
            return (Criteria) this;
        }

        public Criteria andPayDayIsNotNull() {
            addCriterion("pay_day is not null");
            return (Criteria) this;
        }

        public Criteria andPayDayEqualTo(Timestamp value) {
            addCriterion("pay_day =", value, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayNotEqualTo(Timestamp value) {
            addCriterion("pay_day <>", value, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayGreaterThan(Timestamp value) {
            addCriterion("pay_day >", value, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("pay_day >=", value, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayLessThan(Timestamp value) {
            addCriterion("pay_day <", value, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayLessThanOrEqualTo(Timestamp value) {
            addCriterion("pay_day <=", value, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayIn(List<Timestamp> values) {
            addCriterion("pay_day in", values, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayNotIn(List<Timestamp> values) {
            addCriterion("pay_day not in", values, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayBetween(Timestamp value1, Timestamp value2) {
            addCriterion("pay_day between", value1, value2, "payDay");
            return (Criteria) this;
        }

        public Criteria andPayDayNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("pay_day not between", value1, value2, "payDay");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqIsNull() {
            addCriterion("bill_item_seq is null");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqIsNotNull() {
            addCriterion("bill_item_seq is not null");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqEqualTo(String value) {
            addCriterion("bill_item_seq =", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqNotEqualTo(String value) {
            addCriterion("bill_item_seq <>", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqGreaterThan(String value) {
            addCriterion("bill_item_seq >", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqGreaterThanOrEqualTo(String value) {
            addCriterion("bill_item_seq >=", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqLessThan(String value) {
            addCriterion("bill_item_seq <", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqLessThanOrEqualTo(String value) {
            addCriterion("bill_item_seq <=", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqLike(String value) {
            addCriterion("bill_item_seq like", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqNotLike(String value) {
            addCriterion("bill_item_seq not like", value, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqIn(List<String> values) {
            addCriterion("bill_item_seq in", values, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqNotIn(List<String> values) {
            addCriterion("bill_item_seq not in", values, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqBetween(String value1, String value2) {
            addCriterion("bill_item_seq between", value1, value2, "billItemSeq");
            return (Criteria) this;
        }

        public Criteria andBillItemSeqNotBetween(String value1, String value2) {
            addCriterion("bill_item_seq not between", value1, value2, "billItemSeq");
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