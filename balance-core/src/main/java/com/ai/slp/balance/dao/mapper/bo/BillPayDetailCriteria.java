package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BillPayDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BillPayDetailCriteria() {
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

        public Criteria andPayLogSeqIsNull() {
            addCriterion("pay_log_seq is null");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqIsNotNull() {
            addCriterion("pay_log_seq is not null");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqEqualTo(String value) {
            addCriterion("pay_log_seq =", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqNotEqualTo(String value) {
            addCriterion("pay_log_seq <>", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqGreaterThan(String value) {
            addCriterion("pay_log_seq >", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqGreaterThanOrEqualTo(String value) {
            addCriterion("pay_log_seq >=", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqLessThan(String value) {
            addCriterion("pay_log_seq <", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqLessThanOrEqualTo(String value) {
            addCriterion("pay_log_seq <=", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqLike(String value) {
            addCriterion("pay_log_seq like", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqNotLike(String value) {
            addCriterion("pay_log_seq not like", value, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqIn(List<String> values) {
            addCriterion("pay_log_seq in", values, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqNotIn(List<String> values) {
            addCriterion("pay_log_seq not in", values, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqBetween(String value1, String value2) {
            addCriterion("pay_log_seq between", value1, value2, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andPayLogSeqNotBetween(String value1, String value2) {
            addCriterion("pay_log_seq not between", value1, value2, "payLogSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqIsNull() {
            addCriterion("bill_iteam_seq is null");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqIsNotNull() {
            addCriterion("bill_iteam_seq is not null");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqEqualTo(String value) {
            addCriterion("bill_iteam_seq =", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqNotEqualTo(String value) {
            addCriterion("bill_iteam_seq <>", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqGreaterThan(String value) {
            addCriterion("bill_iteam_seq >", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqGreaterThanOrEqualTo(String value) {
            addCriterion("bill_iteam_seq >=", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqLessThan(String value) {
            addCriterion("bill_iteam_seq <", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqLessThanOrEqualTo(String value) {
            addCriterion("bill_iteam_seq <=", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqLike(String value) {
            addCriterion("bill_iteam_seq like", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqNotLike(String value) {
            addCriterion("bill_iteam_seq not like", value, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqIn(List<String> values) {
            addCriterion("bill_iteam_seq in", values, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqNotIn(List<String> values) {
            addCriterion("bill_iteam_seq not in", values, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqBetween(String value1, String value2) {
            addCriterion("bill_iteam_seq between", value1, value2, "billIteamSeq");
            return (Criteria) this;
        }

        public Criteria andBillIteamSeqNotBetween(String value1, String value2) {
            addCriterion("bill_iteam_seq not between", value1, value2, "billIteamSeq");
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

        public Criteria andPayBillFeeIsNull() {
            addCriterion("pay_bill_fee is null");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeIsNotNull() {
            addCriterion("pay_bill_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeEqualTo(Long value) {
            addCriterion("pay_bill_fee =", value, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeNotEqualTo(Long value) {
            addCriterion("pay_bill_fee <>", value, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeGreaterThan(Long value) {
            addCriterion("pay_bill_fee >", value, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_bill_fee >=", value, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeLessThan(Long value) {
            addCriterion("pay_bill_fee <", value, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeLessThanOrEqualTo(Long value) {
            addCriterion("pay_bill_fee <=", value, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeIn(List<Long> values) {
            addCriterion("pay_bill_fee in", values, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeNotIn(List<Long> values) {
            addCriterion("pay_bill_fee not in", values, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeBetween(Long value1, Long value2) {
            addCriterion("pay_bill_fee between", value1, value2, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andPayBillFeeNotBetween(Long value1, Long value2) {
            addCriterion("pay_bill_fee not between", value1, value2, "payBillFee");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Long value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Long value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Long value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Long value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Long value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Long> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Long> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Long value1, Long value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Long value1, Long value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRollbackDateIsNull() {
            addCriterion("rollback_date is null");
            return (Criteria) this;
        }

        public Criteria andRollbackDateIsNotNull() {
            addCriterion("rollback_date is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackDateEqualTo(Timestamp value) {
            addCriterion("rollback_date =", value, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateNotEqualTo(Timestamp value) {
            addCriterion("rollback_date <>", value, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateGreaterThan(Timestamp value) {
            addCriterion("rollback_date >", value, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("rollback_date >=", value, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateLessThan(Timestamp value) {
            addCriterion("rollback_date <", value, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("rollback_date <=", value, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateIn(List<Timestamp> values) {
            addCriterion("rollback_date in", values, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateNotIn(List<Timestamp> values) {
            addCriterion("rollback_date not in", values, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("rollback_date between", value1, value2, "rollbackDate");
            return (Criteria) this;
        }

        public Criteria andRollbackDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("rollback_date not between", value1, value2, "rollbackDate");
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