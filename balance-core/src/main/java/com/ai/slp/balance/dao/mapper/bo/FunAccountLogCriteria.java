package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunAccountLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunAccountLogCriteria() {
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
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("ACCOUNT_ID =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("ACCOUNT_ID <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("ACCOUNT_ID >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_ID >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("ACCOUNT_ID <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("ACCOUNT_ID <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("ACCOUNT_ID in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("ACCOUNT_ID not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_ID between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("ACCOUNT_ID not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNull() {
            addCriterion("ACCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNotNull() {
            addCriterion("ACCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("ACCT_NAME =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotEqualTo(String value) {
            addCriterion("ACCT_NAME <>", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThan(String value) {
            addCriterion("ACCT_NAME >", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_NAME >=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThan(String value) {
            addCriterion("ACCT_NAME <", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThanOrEqualTo(String value) {
            addCriterion("ACCT_NAME <=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLike(String value) {
            addCriterion("ACCT_NAME like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotLike(String value) {
            addCriterion("ACCT_NAME not like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameIn(List<String> values) {
            addCriterion("ACCT_NAME in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotIn(List<String> values) {
            addCriterion("ACCT_NAME not in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameBetween(String value1, String value2) {
            addCriterion("ACCT_NAME between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotBetween(String value1, String value2) {
            addCriterion("ACCT_NAME not between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNull() {
            addCriterion("ACCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNotNull() {
            addCriterion("ACCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeEqualTo(String value) {
            addCriterion("ACCT_TYPE =", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotEqualTo(String value) {
            addCriterion("ACCT_TYPE <>", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThan(String value) {
            addCriterion("ACCT_TYPE >", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_TYPE >=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThan(String value) {
            addCriterion("ACCT_TYPE <", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThanOrEqualTo(String value) {
            addCriterion("ACCT_TYPE <=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLike(String value) {
            addCriterion("ACCT_TYPE like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotLike(String value) {
            addCriterion("ACCT_TYPE not like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIn(List<String> values) {
            addCriterion("ACCT_TYPE in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotIn(List<String> values) {
            addCriterion("ACCT_TYPE not in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeBetween(String value1, String value2) {
            addCriterion("ACCT_TYPE between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotBetween(String value1, String value2) {
            addCriterion("ACCT_TYPE not between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNull() {
            addCriterion("POST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPostTypeIsNotNull() {
            addCriterion("POST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPostTypeEqualTo(String value) {
            addCriterion("POST_TYPE =", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotEqualTo(String value) {
            addCriterion("POST_TYPE <>", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThan(String value) {
            addCriterion("POST_TYPE >", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("POST_TYPE >=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThan(String value) {
            addCriterion("POST_TYPE <", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLessThanOrEqualTo(String value) {
            addCriterion("POST_TYPE <=", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeLike(String value) {
            addCriterion("POST_TYPE like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotLike(String value) {
            addCriterion("POST_TYPE not like", value, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeIn(List<String> values) {
            addCriterion("POST_TYPE in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotIn(List<String> values) {
            addCriterion("POST_TYPE not in", values, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeBetween(String value1, String value2) {
            addCriterion("POST_TYPE between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andPostTypeNotBetween(String value1, String value2) {
            addCriterion("POST_TYPE not between", value1, value2, "postType");
            return (Criteria) this;
        }

        public Criteria andAcctAddrIsNull() {
            addCriterion("ACCT_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andAcctAddrIsNotNull() {
            addCriterion("ACCT_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAddrEqualTo(String value) {
            addCriterion("ACCT_ADDR =", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotEqualTo(String value) {
            addCriterion("ACCT_ADDR <>", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrGreaterThan(String value) {
            addCriterion("ACCT_ADDR >", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_ADDR >=", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrLessThan(String value) {
            addCriterion("ACCT_ADDR <", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrLessThanOrEqualTo(String value) {
            addCriterion("ACCT_ADDR <=", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrLike(String value) {
            addCriterion("ACCT_ADDR like", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotLike(String value) {
            addCriterion("ACCT_ADDR not like", value, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrIn(List<String> values) {
            addCriterion("ACCT_ADDR in", values, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotIn(List<String> values) {
            addCriterion("ACCT_ADDR not in", values, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrBetween(String value1, String value2) {
            addCriterion("ACCT_ADDR between", value1, value2, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andAcctAddrNotBetween(String value1, String value2) {
            addCriterion("ACCT_ADDR not between", value1, value2, "acctAddr");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceIsNull() {
            addCriterion("TOTAL_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceIsNotNull() {
            addCriterion("TOTAL_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceEqualTo(Long value) {
            addCriterion("TOTAL_BALANCE =", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceNotEqualTo(Long value) {
            addCriterion("TOTAL_BALANCE <>", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceGreaterThan(Long value) {
            addCriterion("TOTAL_BALANCE >", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_BALANCE >=", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceLessThan(Long value) {
            addCriterion("TOTAL_BALANCE <", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_BALANCE <=", value, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceIn(List<Long> values) {
            addCriterion("TOTAL_BALANCE in", values, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceNotIn(List<Long> values) {
            addCriterion("TOTAL_BALANCE not in", values, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceBetween(Long value1, Long value2) {
            addCriterion("TOTAL_BALANCE between", value1, value2, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andTotalBalanceNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_BALANCE not between", value1, value2, "totalBalance");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Long value) {
            addCriterion("CREDIT =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Long value) {
            addCriterion("CREDIT <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Long value) {
            addCriterion("CREDIT >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Long value) {
            addCriterion("CREDIT >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Long value) {
            addCriterion("CREDIT <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Long value) {
            addCriterion("CREDIT <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Long> values) {
            addCriterion("CREDIT in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Long> values) {
            addCriterion("CREDIT not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Long value1, Long value2) {
            addCriterion("CREDIT between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Long value1, Long value2) {
            addCriterion("CREDIT not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andTempCreditIsNull() {
            addCriterion("TEMP_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andTempCreditIsNotNull() {
            addCriterion("TEMP_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andTempCreditEqualTo(Long value) {
            addCriterion("TEMP_CREDIT =", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditNotEqualTo(Long value) {
            addCriterion("TEMP_CREDIT <>", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditGreaterThan(Long value) {
            addCriterion("TEMP_CREDIT >", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditGreaterThanOrEqualTo(Long value) {
            addCriterion("TEMP_CREDIT >=", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditLessThan(Long value) {
            addCriterion("TEMP_CREDIT <", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditLessThanOrEqualTo(Long value) {
            addCriterion("TEMP_CREDIT <=", value, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditIn(List<Long> values) {
            addCriterion("TEMP_CREDIT in", values, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditNotIn(List<Long> values) {
            addCriterion("TEMP_CREDIT not in", values, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditBetween(Long value1, Long value2) {
            addCriterion("TEMP_CREDIT between", value1, value2, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempCreditNotBetween(Long value1, Long value2) {
            addCriterion("TEMP_CREDIT not between", value1, value2, "tempCredit");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeIsNull() {
            addCriterion("TEMP_VALID_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeIsNotNull() {
            addCriterion("TEMP_VALID_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeEqualTo(Timestamp value) {
            addCriterion("TEMP_VALID_TIME =", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeNotEqualTo(Timestamp value) {
            addCriterion("TEMP_VALID_TIME <>", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeGreaterThan(Timestamp value) {
            addCriterion("TEMP_VALID_TIME >", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("TEMP_VALID_TIME >=", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeLessThan(Timestamp value) {
            addCriterion("TEMP_VALID_TIME <", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("TEMP_VALID_TIME <=", value, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeIn(List<Timestamp> values) {
            addCriterion("TEMP_VALID_TIME in", values, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeNotIn(List<Timestamp> values) {
            addCriterion("TEMP_VALID_TIME not in", values, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("TEMP_VALID_TIME between", value1, value2, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andTempValidTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("TEMP_VALID_TIME not between", value1, value2, "tempValidTime");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaIsNull() {
            addCriterion("D_TOT_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaIsNotNull() {
            addCriterion("D_TOT_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaEqualTo(Long value) {
            addCriterion("D_TOT_QUOTA =", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaNotEqualTo(Long value) {
            addCriterion("D_TOT_QUOTA <>", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaGreaterThan(Long value) {
            addCriterion("D_TOT_QUOTA >", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("D_TOT_QUOTA >=", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaLessThan(Long value) {
            addCriterion("D_TOT_QUOTA <", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaLessThanOrEqualTo(Long value) {
            addCriterion("D_TOT_QUOTA <=", value, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaIn(List<Long> values) {
            addCriterion("D_TOT_QUOTA in", values, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaNotIn(List<Long> values) {
            addCriterion("D_TOT_QUOTA not in", values, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaBetween(Long value1, Long value2) {
            addCriterion("D_TOT_QUOTA between", value1, value2, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDTotQuotaNotBetween(Long value1, Long value2) {
            addCriterion("D_TOT_QUOTA not between", value1, value2, "dTotQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaIsNull() {
            addCriterion("D_SIG_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaIsNotNull() {
            addCriterion("D_SIG_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaEqualTo(Long value) {
            addCriterion("D_SIG_QUOTA =", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaNotEqualTo(Long value) {
            addCriterion("D_SIG_QUOTA <>", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaGreaterThan(Long value) {
            addCriterion("D_SIG_QUOTA >", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("D_SIG_QUOTA >=", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaLessThan(Long value) {
            addCriterion("D_SIG_QUOTA <", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaLessThanOrEqualTo(Long value) {
            addCriterion("D_SIG_QUOTA <=", value, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaIn(List<Long> values) {
            addCriterion("D_SIG_QUOTA in", values, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaNotIn(List<Long> values) {
            addCriterion("D_SIG_QUOTA not in", values, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaBetween(Long value1, Long value2) {
            addCriterion("D_SIG_QUOTA between", value1, value2, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDSigQuotaNotBetween(Long value1, Long value2) {
            addCriterion("D_SIG_QUOTA not between", value1, value2, "dSigQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaIsNull() {
            addCriterion("D_TRANS_QUOTA is null");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaIsNotNull() {
            addCriterion("D_TRANS_QUOTA is not null");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaEqualTo(Long value) {
            addCriterion("D_TRANS_QUOTA =", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaNotEqualTo(Long value) {
            addCriterion("D_TRANS_QUOTA <>", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaGreaterThan(Long value) {
            addCriterion("D_TRANS_QUOTA >", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("D_TRANS_QUOTA >=", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaLessThan(Long value) {
            addCriterion("D_TRANS_QUOTA <", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaLessThanOrEqualTo(Long value) {
            addCriterion("D_TRANS_QUOTA <=", value, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaIn(List<Long> values) {
            addCriterion("D_TRANS_QUOTA in", values, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaNotIn(List<Long> values) {
            addCriterion("D_TRANS_QUOTA not in", values, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaBetween(Long value1, Long value2) {
            addCriterion("D_TRANS_QUOTA between", value1, value2, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andDTransQuotaNotBetween(Long value1, Long value2) {
            addCriterion("D_TRANS_QUOTA not between", value1, value2, "dTransQuota");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIsNull() {
            addCriterion("ACCT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIsNotNull() {
            addCriterion("ACCT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAcctStatusEqualTo(String value) {
            addCriterion("ACCT_STATUS =", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotEqualTo(String value) {
            addCriterion("ACCT_STATUS <>", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusGreaterThan(String value) {
            addCriterion("ACCT_STATUS >", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ACCT_STATUS >=", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLessThan(String value) {
            addCriterion("ACCT_STATUS <", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLessThanOrEqualTo(String value) {
            addCriterion("ACCT_STATUS <=", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusLike(String value) {
            addCriterion("ACCT_STATUS like", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotLike(String value) {
            addCriterion("ACCT_STATUS not like", value, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusIn(List<String> values) {
            addCriterion("ACCT_STATUS in", values, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotIn(List<String> values) {
            addCriterion("ACCT_STATUS not in", values, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusBetween(String value1, String value2) {
            addCriterion("ACCT_STATUS between", value1, value2, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andAcctStatusNotBetween(String value1, String value2) {
            addCriterion("ACCT_STATUS not between", value1, value2, "acctStatus");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateIsNull() {
            addCriterion("BALANCE_CHG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateIsNotNull() {
            addCriterion("BALANCE_CHG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateEqualTo(Timestamp value) {
            addCriterion("BALANCE_CHG_DATE =", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateNotEqualTo(Timestamp value) {
            addCriterion("BALANCE_CHG_DATE <>", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateGreaterThan(Timestamp value) {
            addCriterion("BALANCE_CHG_DATE >", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("BALANCE_CHG_DATE >=", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateLessThan(Timestamp value) {
            addCriterion("BALANCE_CHG_DATE <", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("BALANCE_CHG_DATE <=", value, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateIn(List<Timestamp> values) {
            addCriterion("BALANCE_CHG_DATE in", values, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateNotIn(List<Timestamp> values) {
            addCriterion("BALANCE_CHG_DATE not in", values, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("BALANCE_CHG_DATE between", value1, value2, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andBalanceChgDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("BALANCE_CHG_DATE not between", value1, value2, "balanceChgDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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