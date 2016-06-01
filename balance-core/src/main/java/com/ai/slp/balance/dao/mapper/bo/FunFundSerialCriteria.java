package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunFundSerialCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunFundSerialCriteria() {
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

        public Criteria andPaySerialCodeIsNull() {
            addCriterion("pay_serial_code is null");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeIsNotNull() {
            addCriterion("pay_serial_code is not null");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeEqualTo(String value) {
            addCriterion("pay_serial_code =", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeNotEqualTo(String value) {
            addCriterion("pay_serial_code <>", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeGreaterThan(String value) {
            addCriterion("pay_serial_code >", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_serial_code >=", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeLessThan(String value) {
            addCriterion("pay_serial_code <", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeLessThanOrEqualTo(String value) {
            addCriterion("pay_serial_code <=", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeLike(String value) {
            addCriterion("pay_serial_code like", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeNotLike(String value) {
            addCriterion("pay_serial_code not like", value, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeIn(List<String> values) {
            addCriterion("pay_serial_code in", values, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeNotIn(List<String> values) {
            addCriterion("pay_serial_code not in", values, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeBetween(String value1, String value2) {
            addCriterion("pay_serial_code between", value1, value2, "paySerialCode");
            return (Criteria) this;
        }

        public Criteria andPaySerialCodeNotBetween(String value1, String value2) {
            addCriterion("pay_serial_code not between", value1, value2, "paySerialCode");
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

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("system_id like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("system_id not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeIsNull() {
            addCriterion("peer_serial_code is null");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeIsNotNull() {
            addCriterion("peer_serial_code is not null");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeEqualTo(String value) {
            addCriterion("peer_serial_code =", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeNotEqualTo(String value) {
            addCriterion("peer_serial_code <>", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeGreaterThan(String value) {
            addCriterion("peer_serial_code >", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("peer_serial_code >=", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeLessThan(String value) {
            addCriterion("peer_serial_code <", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeLessThanOrEqualTo(String value) {
            addCriterion("peer_serial_code <=", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeLike(String value) {
            addCriterion("peer_serial_code like", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeNotLike(String value) {
            addCriterion("peer_serial_code not like", value, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeIn(List<String> values) {
            addCriterion("peer_serial_code in", values, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeNotIn(List<String> values) {
            addCriterion("peer_serial_code not in", values, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeBetween(String value1, String value2) {
            addCriterion("peer_serial_code between", value1, value2, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andPeerSerialCodeNotBetween(String value1, String value2) {
            addCriterion("peer_serial_code not between", value1, value2, "peerSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeIsNull() {
            addCriterion("cancel_serial_code is null");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeIsNotNull() {
            addCriterion("cancel_serial_code is not null");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeEqualTo(String value) {
            addCriterion("cancel_serial_code =", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeNotEqualTo(String value) {
            addCriterion("cancel_serial_code <>", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeGreaterThan(String value) {
            addCriterion("cancel_serial_code >", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_serial_code >=", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeLessThan(String value) {
            addCriterion("cancel_serial_code <", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeLessThanOrEqualTo(String value) {
            addCriterion("cancel_serial_code <=", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeLike(String value) {
            addCriterion("cancel_serial_code like", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeNotLike(String value) {
            addCriterion("cancel_serial_code not like", value, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeIn(List<String> values) {
            addCriterion("cancel_serial_code in", values, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeNotIn(List<String> values) {
            addCriterion("cancel_serial_code not in", values, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeBetween(String value1, String value2) {
            addCriterion("cancel_serial_code between", value1, value2, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andCancelSerialCodeNotBetween(String value1, String value2) {
            addCriterion("cancel_serial_code not between", value1, value2, "cancelSerialCode");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNull() {
            addCriterion("opt_type is null");
            return (Criteria) this;
        }

        public Criteria andOptTypeIsNotNull() {
            addCriterion("opt_type is not null");
            return (Criteria) this;
        }

        public Criteria andOptTypeEqualTo(String value) {
            addCriterion("opt_type =", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotEqualTo(String value) {
            addCriterion("opt_type <>", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThan(String value) {
            addCriterion("opt_type >", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("opt_type >=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThan(String value) {
            addCriterion("opt_type <", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLessThanOrEqualTo(String value) {
            addCriterion("opt_type <=", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeLike(String value) {
            addCriterion("opt_type like", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotLike(String value) {
            addCriterion("opt_type not like", value, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeIn(List<String> values) {
            addCriterion("opt_type in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotIn(List<String> values) {
            addCriterion("opt_type not in", values, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeBetween(String value1, String value2) {
            addCriterion("opt_type between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andOptTypeNotBetween(String value1, String value2) {
            addCriterion("opt_type not between", value1, value2, "optType");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Long value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Long value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Long value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Long value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Long> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Long> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Long value1, Long value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTransSummaryIsNull() {
            addCriterion("trans_summary is null");
            return (Criteria) this;
        }

        public Criteria andTransSummaryIsNotNull() {
            addCriterion("trans_summary is not null");
            return (Criteria) this;
        }

        public Criteria andTransSummaryEqualTo(String value) {
            addCriterion("trans_summary =", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryNotEqualTo(String value) {
            addCriterion("trans_summary <>", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryGreaterThan(String value) {
            addCriterion("trans_summary >", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("trans_summary >=", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryLessThan(String value) {
            addCriterion("trans_summary <", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryLessThanOrEqualTo(String value) {
            addCriterion("trans_summary <=", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryLike(String value) {
            addCriterion("trans_summary like", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryNotLike(String value) {
            addCriterion("trans_summary not like", value, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryIn(List<String> values) {
            addCriterion("trans_summary in", values, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryNotIn(List<String> values) {
            addCriterion("trans_summary not in", values, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryBetween(String value1, String value2) {
            addCriterion("trans_summary between", value1, value2, "transSummary");
            return (Criteria) this;
        }

        public Criteria andTransSummaryNotBetween(String value1, String value2) {
            addCriterion("trans_summary not between", value1, value2, "transSummary");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdIsNull() {
            addCriterion("pay_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdIsNotNull() {
            addCriterion("pay_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdEqualTo(Long value) {
            addCriterion("pay_rule_id =", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdNotEqualTo(Long value) {
            addCriterion("pay_rule_id <>", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdGreaterThan(Long value) {
            addCriterion("pay_rule_id >", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_rule_id >=", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdLessThan(Long value) {
            addCriterion("pay_rule_id <", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_rule_id <=", value, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdIn(List<Long> values) {
            addCriterion("pay_rule_id in", values, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdNotIn(List<Long> values) {
            addCriterion("pay_rule_id not in", values, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdBetween(Long value1, Long value2) {
            addCriterion("pay_rule_id between", value1, value2, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_rule_id not between", value1, value2, "payRuleId");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andAcctId1IsNull() {
            addCriterion("acct_id1 is null");
            return (Criteria) this;
        }

        public Criteria andAcctId1IsNotNull() {
            addCriterion("acct_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andAcctId1EqualTo(Long value) {
            addCriterion("acct_id1 =", value, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1NotEqualTo(Long value) {
            addCriterion("acct_id1 <>", value, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1GreaterThan(Long value) {
            addCriterion("acct_id1 >", value, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1GreaterThanOrEqualTo(Long value) {
            addCriterion("acct_id1 >=", value, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1LessThan(Long value) {
            addCriterion("acct_id1 <", value, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1LessThanOrEqualTo(Long value) {
            addCriterion("acct_id1 <=", value, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1In(List<Long> values) {
            addCriterion("acct_id1 in", values, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1NotIn(List<Long> values) {
            addCriterion("acct_id1 not in", values, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1Between(Long value1, Long value2) {
            addCriterion("acct_id1 between", value1, value2, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctId1NotBetween(Long value1, Long value2) {
            addCriterion("acct_id1 not between", value1, value2, "acctId1");
            return (Criteria) this;
        }

        public Criteria andAcctName1IsNull() {
            addCriterion("acct_name1 is null");
            return (Criteria) this;
        }

        public Criteria andAcctName1IsNotNull() {
            addCriterion("acct_name1 is not null");
            return (Criteria) this;
        }

        public Criteria andAcctName1EqualTo(String value) {
            addCriterion("acct_name1 =", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1NotEqualTo(String value) {
            addCriterion("acct_name1 <>", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1GreaterThan(String value) {
            addCriterion("acct_name1 >", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1GreaterThanOrEqualTo(String value) {
            addCriterion("acct_name1 >=", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1LessThan(String value) {
            addCriterion("acct_name1 <", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1LessThanOrEqualTo(String value) {
            addCriterion("acct_name1 <=", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1Like(String value) {
            addCriterion("acct_name1 like", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1NotLike(String value) {
            addCriterion("acct_name1 not like", value, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1In(List<String> values) {
            addCriterion("acct_name1 in", values, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1NotIn(List<String> values) {
            addCriterion("acct_name1 not in", values, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1Between(String value1, String value2) {
            addCriterion("acct_name1 between", value1, value2, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctName1NotBetween(String value1, String value2) {
            addCriterion("acct_name1 not between", value1, value2, "acctName1");
            return (Criteria) this;
        }

        public Criteria andAcctId2IsNull() {
            addCriterion("acct_id2 is null");
            return (Criteria) this;
        }

        public Criteria andAcctId2IsNotNull() {
            addCriterion("acct_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andAcctId2EqualTo(Long value) {
            addCriterion("acct_id2 =", value, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2NotEqualTo(Long value) {
            addCriterion("acct_id2 <>", value, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2GreaterThan(Long value) {
            addCriterion("acct_id2 >", value, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2GreaterThanOrEqualTo(Long value) {
            addCriterion("acct_id2 >=", value, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2LessThan(Long value) {
            addCriterion("acct_id2 <", value, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2LessThanOrEqualTo(Long value) {
            addCriterion("acct_id2 <=", value, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2In(List<Long> values) {
            addCriterion("acct_id2 in", values, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2NotIn(List<Long> values) {
            addCriterion("acct_id2 not in", values, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2Between(Long value1, Long value2) {
            addCriterion("acct_id2 between", value1, value2, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctId2NotBetween(Long value1, Long value2) {
            addCriterion("acct_id2 not between", value1, value2, "acctId2");
            return (Criteria) this;
        }

        public Criteria andAcctName2IsNull() {
            addCriterion("acct_name2 is null");
            return (Criteria) this;
        }

        public Criteria andAcctName2IsNotNull() {
            addCriterion("acct_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andAcctName2EqualTo(String value) {
            addCriterion("acct_name2 =", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2NotEqualTo(String value) {
            addCriterion("acct_name2 <>", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2GreaterThan(String value) {
            addCriterion("acct_name2 >", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2GreaterThanOrEqualTo(String value) {
            addCriterion("acct_name2 >=", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2LessThan(String value) {
            addCriterion("acct_name2 <", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2LessThanOrEqualTo(String value) {
            addCriterion("acct_name2 <=", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2Like(String value) {
            addCriterion("acct_name2 like", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2NotLike(String value) {
            addCriterion("acct_name2 not like", value, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2In(List<String> values) {
            addCriterion("acct_name2 in", values, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2NotIn(List<String> values) {
            addCriterion("acct_name2 not in", values, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2Between(String value1, String value2) {
            addCriterion("acct_name2 between", value1, value2, "acctName2");
            return (Criteria) this;
        }

        public Criteria andAcctName2NotBetween(String value1, String value2) {
            addCriterion("acct_name2 not between", value1, value2, "acctName2");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Timestamp value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Timestamp value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Timestamp value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Timestamp value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Timestamp> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Timestamp> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateIsNull() {
            addCriterion("last_status_date is null");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateIsNotNull() {
            addCriterion("last_status_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateEqualTo(Timestamp value) {
            addCriterion("last_status_date =", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateNotEqualTo(Timestamp value) {
            addCriterion("last_status_date <>", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateGreaterThan(Timestamp value) {
            addCriterion("last_status_date >", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("last_status_date >=", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateLessThan(Timestamp value) {
            addCriterion("last_status_date <", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("last_status_date <=", value, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateIn(List<Timestamp> values) {
            addCriterion("last_status_date in", values, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateNotIn(List<Timestamp> values) {
            addCriterion("last_status_date not in", values, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("last_status_date between", value1, value2, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andLastStatusDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("last_status_date not between", value1, value2, "lastStatusDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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