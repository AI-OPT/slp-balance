package com.ai.slp.balance.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class BillCycleDefCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BillCycleDefCriteria() {
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

        public Criteria andBillCycleDefIdIsNull() {
            addCriterion("bill_cycle_def_id is null");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdIsNotNull() {
            addCriterion("bill_cycle_def_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdEqualTo(Integer value) {
            addCriterion("bill_cycle_def_id =", value, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdNotEqualTo(Integer value) {
            addCriterion("bill_cycle_def_id <>", value, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdGreaterThan(Integer value) {
            addCriterion("bill_cycle_def_id >", value, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_cycle_def_id >=", value, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdLessThan(Integer value) {
            addCriterion("bill_cycle_def_id <", value, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdLessThanOrEqualTo(Integer value) {
            addCriterion("bill_cycle_def_id <=", value, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdIn(List<Integer> values) {
            addCriterion("bill_cycle_def_id in", values, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdNotIn(List<Integer> values) {
            addCriterion("bill_cycle_def_id not in", values, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdBetween(Integer value1, Integer value2) {
            addCriterion("bill_cycle_def_id between", value1, value2, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillCycleDefIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_cycle_def_id not between", value1, value2, "billCycleDefId");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeIsNull() {
            addCriterion("bill_gen_type is null");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeIsNotNull() {
            addCriterion("bill_gen_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeEqualTo(String value) {
            addCriterion("bill_gen_type =", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeNotEqualTo(String value) {
            addCriterion("bill_gen_type <>", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeGreaterThan(String value) {
            addCriterion("bill_gen_type >", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bill_gen_type >=", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeLessThan(String value) {
            addCriterion("bill_gen_type <", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeLessThanOrEqualTo(String value) {
            addCriterion("bill_gen_type <=", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeLike(String value) {
            addCriterion("bill_gen_type like", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeNotLike(String value) {
            addCriterion("bill_gen_type not like", value, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeIn(List<String> values) {
            addCriterion("bill_gen_type in", values, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeNotIn(List<String> values) {
            addCriterion("bill_gen_type not in", values, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeBetween(String value1, String value2) {
            addCriterion("bill_gen_type between", value1, value2, "billGenType");
            return (Criteria) this;
        }

        public Criteria andBillGenTypeNotBetween(String value1, String value2) {
            addCriterion("bill_gen_type not between", value1, value2, "billGenType");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsIsNull() {
            addCriterion("postpay_units is null");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsIsNotNull() {
            addCriterion("postpay_units is not null");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsEqualTo(Integer value) {
            addCriterion("postpay_units =", value, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsNotEqualTo(Integer value) {
            addCriterion("postpay_units <>", value, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsGreaterThan(Integer value) {
            addCriterion("postpay_units >", value, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("postpay_units >=", value, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsLessThan(Integer value) {
            addCriterion("postpay_units <", value, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsLessThanOrEqualTo(Integer value) {
            addCriterion("postpay_units <=", value, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsIn(List<Integer> values) {
            addCriterion("postpay_units in", values, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsNotIn(List<Integer> values) {
            addCriterion("postpay_units not in", values, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsBetween(Integer value1, Integer value2) {
            addCriterion("postpay_units between", value1, value2, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayUnitsNotBetween(Integer value1, Integer value2) {
            addCriterion("postpay_units not between", value1, value2, "postpayUnits");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeIsNull() {
            addCriterion("postpay_type is null");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeIsNotNull() {
            addCriterion("postpay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeEqualTo(String value) {
            addCriterion("postpay_type =", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeNotEqualTo(String value) {
            addCriterion("postpay_type <>", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeGreaterThan(String value) {
            addCriterion("postpay_type >", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("postpay_type >=", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeLessThan(String value) {
            addCriterion("postpay_type <", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeLessThanOrEqualTo(String value) {
            addCriterion("postpay_type <=", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeLike(String value) {
            addCriterion("postpay_type like", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeNotLike(String value) {
            addCriterion("postpay_type not like", value, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeIn(List<String> values) {
            addCriterion("postpay_type in", values, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeNotIn(List<String> values) {
            addCriterion("postpay_type not in", values, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeBetween(String value1, String value2) {
            addCriterion("postpay_type between", value1, value2, "postpayType");
            return (Criteria) this;
        }

        public Criteria andPostpayTypeNotBetween(String value1, String value2) {
            addCriterion("postpay_type not between", value1, value2, "postpayType");
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