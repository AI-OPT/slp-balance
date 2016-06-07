package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunAccountInfoLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunAccountInfoLogCriteria() {
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

        public Criteria andAcctNameIsNull() {
            addCriterion("acct_name is null");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNotNull() {
            addCriterion("acct_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("acct_name =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotEqualTo(String value) {
            addCriterion("acct_name <>", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThan(String value) {
            addCriterion("acct_name >", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThanOrEqualTo(String value) {
            addCriterion("acct_name >=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThan(String value) {
            addCriterion("acct_name <", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThanOrEqualTo(String value) {
            addCriterion("acct_name <=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLike(String value) {
            addCriterion("acct_name like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotLike(String value) {
            addCriterion("acct_name not like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameIn(List<String> values) {
            addCriterion("acct_name in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotIn(List<String> values) {
            addCriterion("acct_name not in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameBetween(String value1, String value2) {
            addCriterion("acct_name between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotBetween(String value1, String value2) {
            addCriterion("acct_name not between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("cust_id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("cust_id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNull() {
            addCriterion("acct_type is null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNotNull() {
            addCriterion("acct_type is not null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeEqualTo(String value) {
            addCriterion("acct_type =", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotEqualTo(String value) {
            addCriterion("acct_type <>", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThan(String value) {
            addCriterion("acct_type >", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("acct_type >=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThan(String value) {
            addCriterion("acct_type <", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThanOrEqualTo(String value) {
            addCriterion("acct_type <=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLike(String value) {
            addCriterion("acct_type like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotLike(String value) {
            addCriterion("acct_type not like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIn(List<String> values) {
            addCriterion("acct_type in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotIn(List<String> values) {
            addCriterion("acct_type not in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeBetween(String value1, String value2) {
            addCriterion("acct_type between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotBetween(String value1, String value2) {
            addCriterion("acct_type not between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNull() {
            addCriterion("post_type is null");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNotNull() {
            addCriterion("post_type is not null");
            return (Criteria) this;
        }

        public Criteria andPostTypeEqualTo(String value) {
            addCriterion("post_type =", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotEqualTo(String value) {
            addCriterion("post_type <>", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThan(String value) {
            addCriterion("post_type >", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("post_type >=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThan(String value) {
            addCriterion("post_type <", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThanOrEqualTo(String value) {
            addCriterion("post_type <=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLike(String value) {
            addCriterion("post_type like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotLike(String value) {
            addCriterion("post_type not like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIn(List<String> values) {
            addCriterion("post_type in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotIn(List<String> values) {
            addCriterion("post_type not in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeBetween(String value1, String value2) {
            addCriterion("post_type between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotBetween(String value1, String value2) {
            addCriterion("post_type not between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andAcctAddrIsNull() {
            addCriterion("acct_addr is null");
            return (Criteria) this;
        }

        public Criteria andAcctAddrIsNotNull() {
            addCriterion("acct_addr is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAddrEqualTo(String value) {
            addCriterion("acct_addr =", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotEqualTo(String value) {
            addCriterion("acct_addr <>", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrGreaterThan(String value) {
            addCriterion("acct_addr >", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrGreaterThanOrEqualTo(String value) {
            addCriterion("acct_addr >=", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrLessThan(String value) {
            addCriterion("acct_addr <", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrLessThanOrEqualTo(String value) {
            addCriterion("acct_addr <=", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrLike(String value) {
            addCriterion("acct_addr like", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotLike(String value) {
            addCriterion("acct_addr not like", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrIn(List<String> values) {
            addCriterion("acct_addr in", values, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotIn(List<String> values) {
            addCriterion("acct_addr not in", values, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrBetween(String value1, String value2) {
            addCriterion("acct_addr between", value1, value2, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotBetween(String value1, String value2) {
            addCriterion("acct_addr not between", value1, value2, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceIsNull() {
            addCriterion("total_balance is null");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceIsNotNull() {
            addCriterion("total_balance is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceEqualTo(Long value) {
            addCriterion("total_balance =", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceNotEqualTo(Long value) {
            addCriterion("total_balance <>", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceGreaterThan(Long value) {
            addCriterion("total_balance >", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("total_balance >=", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceLessThan(Long value) {
            addCriterion("total_balance <", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceLessThanOrEqualTo(Long value) {
            addCriterion("total_balance <=", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceIn(List<Long> values) {
            addCriterion("total_balance in", values, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceNotIn(List<Long> values) {
            addCriterion("total_balance not in", values, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceBetween(Long value1, Long value2) {
            addCriterion("total_balance between", value1, value2, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceNotBetween(Long value1, Long value2) {
            addCriterion("total_balance not between", value1, value2, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Long value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Long value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Long value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Long value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Long value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Long value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Long> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Long> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Long value1, Long value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Long value1, Long value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andTempCreditIsNull() {
            addCriterion("temp_credit is null");
            return (Criteria) this;
        }

        public Criteria andTempCreditIsNotNull() {
            addCriterion("temp_credit is not null");
            return (Criteria) this;
        }

        public Criteria andTempCreditEqualTo(Long value) {
            addCriterion("temp_credit =", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditNotEqualTo(Long value) {
            addCriterion("temp_credit <>", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditGreaterThan(Long value) {
            addCriterion("temp_credit >", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditGreaterThanOrEqualTo(Long value) {
            addCriterion("temp_credit >=", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditLessThan(Long value) {
            addCriterion("temp_credit <", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditLessThanOrEqualTo(Long value) {
            addCriterion("temp_credit <=", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditIn(List<Long> values) {
            addCriterion("temp_credit in", values, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditNotIn(List<Long> values) {
            addCriterion("temp_credit not in", values, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditBetween(Long value1, Long value2) {
            addCriterion("temp_credit between", value1, value2, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditNotBetween(Long value1, Long value2) {
            addCriterion("temp_credit not between", value1, value2, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeIsNull() {
            addCriterion("temp_valid_time is null");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeIsNotNull() {
            addCriterion("temp_valid_time is not null");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeEqualTo(Timestamp value) {
            addCriterion("temp_valid_time =", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeNotEqualTo(Timestamp value) {
            addCriterion("temp_valid_time <>", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeGreaterThan(Timestamp value) {
            addCriterion("temp_valid_time >", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("temp_valid_time >=", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeLessThan(Timestamp value) {
            addCriterion("temp_valid_time <", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("temp_valid_time <=", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeIn(List<Timestamp> values) {
            addCriterion("temp_valid_time in", values, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeNotIn(List<Timestamp> values) {
            addCriterion("temp_valid_time not in", values, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("temp_valid_time between", value1, value2, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("temp_valid_time not between", value1, value2, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaIsNull() {
            addCriterion("d_tot_quota is null");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaIsNotNull() {
            addCriterion("d_tot_quota is not null");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaEqualTo(Long value) {
            addCriterion("d_tot_quota =", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaNotEqualTo(Long value) {
            addCriterion("d_tot_quota <>", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaGreaterThan(Long value) {
            addCriterion("d_tot_quota >", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("d_tot_quota >=", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaLessThan(Long value) {
            addCriterion("d_tot_quota <", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaLessThanOrEqualTo(Long value) {
            addCriterion("d_tot_quota <=", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaIn(List<Long> values) {
            addCriterion("d_tot_quota in", values, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaNotIn(List<Long> values) {
            addCriterion("d_tot_quota not in", values, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaBetween(Long value1, Long value2) {
            addCriterion("d_tot_quota between", value1, value2, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaNotBetween(Long value1, Long value2) {
            addCriterion("d_tot_quota not between", value1, value2, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaIsNull() {
            addCriterion("d_sig_quota is null");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaIsNotNull() {
            addCriterion("d_sig_quota is not null");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaEqualTo(Long value) {
            addCriterion("d_sig_quota =", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaNotEqualTo(Long value) {
            addCriterion("d_sig_quota <>", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaGreaterThan(Long value) {
            addCriterion("d_sig_quota >", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("d_sig_quota >=", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaLessThan(Long value) {
            addCriterion("d_sig_quota <", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaLessThanOrEqualTo(Long value) {
            addCriterion("d_sig_quota <=", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaIn(List<Long> values) {
            addCriterion("d_sig_quota in", values, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaNotIn(List<Long> values) {
            addCriterion("d_sig_quota not in", values, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaBetween(Long value1, Long value2) {
            addCriterion("d_sig_quota between", value1, value2, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaNotBetween(Long value1, Long value2) {
            addCriterion("d_sig_quota not between", value1, value2, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaIsNull() {
            addCriterion("d_trans_quota is null");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaIsNotNull() {
            addCriterion("d_trans_quota is not null");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaEqualTo(Long value) {
            addCriterion("d_trans_quota =", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaNotEqualTo(Long value) {
            addCriterion("d_trans_quota <>", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaGreaterThan(Long value) {
            addCriterion("d_trans_quota >", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("d_trans_quota >=", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaLessThan(Long value) {
            addCriterion("d_trans_quota <", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaLessThanOrEqualTo(Long value) {
            addCriterion("d_trans_quota <=", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaIn(List<Long> values) {
            addCriterion("d_trans_quota in", values, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaNotIn(List<Long> values) {
            addCriterion("d_trans_quota not in", values, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaBetween(Long value1, Long value2) {
            addCriterion("d_trans_quota between", value1, value2, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaNotBetween(Long value1, Long value2) {
            addCriterion("d_trans_quota not between", value1, value2, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIsNull() {
            addCriterion("acct_status is null");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIsNotNull() {
            addCriterion("acct_status is not null");
            return (Criteria) this;
        }

        public Criteria andAcctStatusEqualTo(String value) {
            addCriterion("acct_status =", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotEqualTo(String value) {
            addCriterion("acct_status <>", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusGreaterThan(String value) {
            addCriterion("acct_status >", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusGreaterThanOrEqualTo(String value) {
            addCriterion("acct_status >=", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLessThan(String value) {
            addCriterion("acct_status <", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLessThanOrEqualTo(String value) {
            addCriterion("acct_status <=", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLike(String value) {
            addCriterion("acct_status like", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotLike(String value) {
            addCriterion("acct_status not like", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIn(List<String> values) {
            addCriterion("acct_status in", values, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotIn(List<String> values) {
            addCriterion("acct_status not in", values, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusBetween(String value1, String value2) {
            addCriterion("acct_status between", value1, value2, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotBetween(String value1, String value2) {
            addCriterion("acct_status not between", value1, value2, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateIsNull() {
            addCriterion("balance_chg_date is null");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateIsNotNull() {
            addCriterion("balance_chg_date is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateEqualTo(Timestamp value) {
            addCriterion("balance_chg_date =", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateNotEqualTo(Timestamp value) {
            addCriterion("balance_chg_date <>", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateGreaterThan(Timestamp value) {
            addCriterion("balance_chg_date >", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("balance_chg_date >=", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateLessThan(Timestamp value) {
            addCriterion("balance_chg_date <", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("balance_chg_date <=", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateIn(List<Timestamp> values) {
            addCriterion("balance_chg_date in", values, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateNotIn(List<Timestamp> values) {
            addCriterion("balance_chg_date not in", values, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("balance_chg_date between", value1, value2, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("balance_chg_date not between", value1, value2, "balanceChgDate");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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