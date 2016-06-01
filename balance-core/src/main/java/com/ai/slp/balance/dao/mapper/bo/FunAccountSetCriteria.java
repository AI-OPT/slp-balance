package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunAccountSetCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunAccountSetCriteria() {
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

        public Criteria andLoginPasswordIsNull() {
            addCriterion("login_password is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("login_password is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("login_password =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("login_password <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("login_password >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("login_password >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("login_password <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("login_password <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("login_password like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("login_password not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("login_password in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("login_password not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("login_password between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("login_password not between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andPayCheckIsNull() {
            addCriterion("pay_check is null");
            return (Criteria) this;
        }

        public Criteria andPayCheckIsNotNull() {
            addCriterion("pay_check is not null");
            return (Criteria) this;
        }

        public Criteria andPayCheckEqualTo(String value) {
            addCriterion("pay_check =", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckNotEqualTo(String value) {
            addCriterion("pay_check <>", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckGreaterThan(String value) {
            addCriterion("pay_check >", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckGreaterThanOrEqualTo(String value) {
            addCriterion("pay_check >=", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckLessThan(String value) {
            addCriterion("pay_check <", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckLessThanOrEqualTo(String value) {
            addCriterion("pay_check <=", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckLike(String value) {
            addCriterion("pay_check like", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckNotLike(String value) {
            addCriterion("pay_check not like", value, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckIn(List<String> values) {
            addCriterion("pay_check in", values, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckNotIn(List<String> values) {
            addCriterion("pay_check not in", values, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckBetween(String value1, String value2) {
            addCriterion("pay_check between", value1, value2, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayCheckNotBetween(String value1, String value2) {
            addCriterion("pay_check not between", value1, value2, "payCheck");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNull() {
            addCriterion("pay_password is null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNotNull() {
            addCriterion("pay_password is not null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordEqualTo(String value) {
            addCriterion("pay_password =", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotEqualTo(String value) {
            addCriterion("pay_password <>", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThan(String value) {
            addCriterion("pay_password >", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("pay_password >=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThan(String value) {
            addCriterion("pay_password <", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThanOrEqualTo(String value) {
            addCriterion("pay_password <=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLike(String value) {
            addCriterion("pay_password like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotLike(String value) {
            addCriterion("pay_password not like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIn(List<String> values) {
            addCriterion("pay_password in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotIn(List<String> values) {
            addCriterion("pay_password not in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordBetween(String value1, String value2) {
            addCriterion("pay_password between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotBetween(String value1, String value2) {
            addCriterion("pay_password not between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andSecureQ1IsNull() {
            addCriterion("secure_q1 is null");
            return (Criteria) this;
        }

        public Criteria andSecureQ1IsNotNull() {
            addCriterion("secure_q1 is not null");
            return (Criteria) this;
        }

        public Criteria andSecureQ1EqualTo(String value) {
            addCriterion("secure_q1 =", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1NotEqualTo(String value) {
            addCriterion("secure_q1 <>", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1GreaterThan(String value) {
            addCriterion("secure_q1 >", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1GreaterThanOrEqualTo(String value) {
            addCriterion("secure_q1 >=", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1LessThan(String value) {
            addCriterion("secure_q1 <", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1LessThanOrEqualTo(String value) {
            addCriterion("secure_q1 <=", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1Like(String value) {
            addCriterion("secure_q1 like", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1NotLike(String value) {
            addCriterion("secure_q1 not like", value, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1In(List<String> values) {
            addCriterion("secure_q1 in", values, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1NotIn(List<String> values) {
            addCriterion("secure_q1 not in", values, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1Between(String value1, String value2) {
            addCriterion("secure_q1 between", value1, value2, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ1NotBetween(String value1, String value2) {
            addCriterion("secure_q1 not between", value1, value2, "secureQ1");
            return (Criteria) this;
        }

        public Criteria andSecureQ2IsNull() {
            addCriterion("secure_q2 is null");
            return (Criteria) this;
        }

        public Criteria andSecureQ2IsNotNull() {
            addCriterion("secure_q2 is not null");
            return (Criteria) this;
        }

        public Criteria andSecureQ2EqualTo(String value) {
            addCriterion("secure_q2 =", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2NotEqualTo(String value) {
            addCriterion("secure_q2 <>", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2GreaterThan(String value) {
            addCriterion("secure_q2 >", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2GreaterThanOrEqualTo(String value) {
            addCriterion("secure_q2 >=", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2LessThan(String value) {
            addCriterion("secure_q2 <", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2LessThanOrEqualTo(String value) {
            addCriterion("secure_q2 <=", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2Like(String value) {
            addCriterion("secure_q2 like", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2NotLike(String value) {
            addCriterion("secure_q2 not like", value, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2In(List<String> values) {
            addCriterion("secure_q2 in", values, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2NotIn(List<String> values) {
            addCriterion("secure_q2 not in", values, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2Between(String value1, String value2) {
            addCriterion("secure_q2 between", value1, value2, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ2NotBetween(String value1, String value2) {
            addCriterion("secure_q2 not between", value1, value2, "secureQ2");
            return (Criteria) this;
        }

        public Criteria andSecureQ3IsNull() {
            addCriterion("secure_q3 is null");
            return (Criteria) this;
        }

        public Criteria andSecureQ3IsNotNull() {
            addCriterion("secure_q3 is not null");
            return (Criteria) this;
        }

        public Criteria andSecureQ3EqualTo(String value) {
            addCriterion("secure_q3 =", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3NotEqualTo(String value) {
            addCriterion("secure_q3 <>", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3GreaterThan(String value) {
            addCriterion("secure_q3 >", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3GreaterThanOrEqualTo(String value) {
            addCriterion("secure_q3 >=", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3LessThan(String value) {
            addCriterion("secure_q3 <", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3LessThanOrEqualTo(String value) {
            addCriterion("secure_q3 <=", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3Like(String value) {
            addCriterion("secure_q3 like", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3NotLike(String value) {
            addCriterion("secure_q3 not like", value, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3In(List<String> values) {
            addCriterion("secure_q3 in", values, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3NotIn(List<String> values) {
            addCriterion("secure_q3 not in", values, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3Between(String value1, String value2) {
            addCriterion("secure_q3 between", value1, value2, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureQ3NotBetween(String value1, String value2) {
            addCriterion("secure_q3 not between", value1, value2, "secureQ3");
            return (Criteria) this;
        }

        public Criteria andSecureA1IsNull() {
            addCriterion("secure_a1 is null");
            return (Criteria) this;
        }

        public Criteria andSecureA1IsNotNull() {
            addCriterion("secure_a1 is not null");
            return (Criteria) this;
        }

        public Criteria andSecureA1EqualTo(String value) {
            addCriterion("secure_a1 =", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1NotEqualTo(String value) {
            addCriterion("secure_a1 <>", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1GreaterThan(String value) {
            addCriterion("secure_a1 >", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1GreaterThanOrEqualTo(String value) {
            addCriterion("secure_a1 >=", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1LessThan(String value) {
            addCriterion("secure_a1 <", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1LessThanOrEqualTo(String value) {
            addCriterion("secure_a1 <=", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1Like(String value) {
            addCriterion("secure_a1 like", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1NotLike(String value) {
            addCriterion("secure_a1 not like", value, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1In(List<String> values) {
            addCriterion("secure_a1 in", values, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1NotIn(List<String> values) {
            addCriterion("secure_a1 not in", values, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1Between(String value1, String value2) {
            addCriterion("secure_a1 between", value1, value2, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA1NotBetween(String value1, String value2) {
            addCriterion("secure_a1 not between", value1, value2, "secureA1");
            return (Criteria) this;
        }

        public Criteria andSecureA2IsNull() {
            addCriterion("secure_a2 is null");
            return (Criteria) this;
        }

        public Criteria andSecureA2IsNotNull() {
            addCriterion("secure_a2 is not null");
            return (Criteria) this;
        }

        public Criteria andSecureA2EqualTo(String value) {
            addCriterion("secure_a2 =", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2NotEqualTo(String value) {
            addCriterion("secure_a2 <>", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2GreaterThan(String value) {
            addCriterion("secure_a2 >", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2GreaterThanOrEqualTo(String value) {
            addCriterion("secure_a2 >=", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2LessThan(String value) {
            addCriterion("secure_a2 <", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2LessThanOrEqualTo(String value) {
            addCriterion("secure_a2 <=", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2Like(String value) {
            addCriterion("secure_a2 like", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2NotLike(String value) {
            addCriterion("secure_a2 not like", value, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2In(List<String> values) {
            addCriterion("secure_a2 in", values, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2NotIn(List<String> values) {
            addCriterion("secure_a2 not in", values, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2Between(String value1, String value2) {
            addCriterion("secure_a2 between", value1, value2, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA2NotBetween(String value1, String value2) {
            addCriterion("secure_a2 not between", value1, value2, "secureA2");
            return (Criteria) this;
        }

        public Criteria andSecureA3IsNull() {
            addCriterion("secure_a3 is null");
            return (Criteria) this;
        }

        public Criteria andSecureA3IsNotNull() {
            addCriterion("secure_a3 is not null");
            return (Criteria) this;
        }

        public Criteria andSecureA3EqualTo(String value) {
            addCriterion("secure_a3 =", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3NotEqualTo(String value) {
            addCriterion("secure_a3 <>", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3GreaterThan(String value) {
            addCriterion("secure_a3 >", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3GreaterThanOrEqualTo(String value) {
            addCriterion("secure_a3 >=", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3LessThan(String value) {
            addCriterion("secure_a3 <", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3LessThanOrEqualTo(String value) {
            addCriterion("secure_a3 <=", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3Like(String value) {
            addCriterion("secure_a3 like", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3NotLike(String value) {
            addCriterion("secure_a3 not like", value, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3In(List<String> values) {
            addCriterion("secure_a3 in", values, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3NotIn(List<String> values) {
            addCriterion("secure_a3 not in", values, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3Between(String value1, String value2) {
            addCriterion("secure_a3 between", value1, value2, "secureA3");
            return (Criteria) this;
        }

        public Criteria andSecureA3NotBetween(String value1, String value2) {
            addCriterion("secure_a3 not between", value1, value2, "secureA3");
            return (Criteria) this;
        }

        public Criteria andRegTypeIsNull() {
            addCriterion("reg_type is null");
            return (Criteria) this;
        }

        public Criteria andRegTypeIsNotNull() {
            addCriterion("reg_type is not null");
            return (Criteria) this;
        }

        public Criteria andRegTypeEqualTo(String value) {
            addCriterion("reg_type =", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeNotEqualTo(String value) {
            addCriterion("reg_type <>", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeGreaterThan(String value) {
            addCriterion("reg_type >", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeGreaterThanOrEqualTo(String value) {
            addCriterion("reg_type >=", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeLessThan(String value) {
            addCriterion("reg_type <", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeLessThanOrEqualTo(String value) {
            addCriterion("reg_type <=", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeLike(String value) {
            addCriterion("reg_type like", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeNotLike(String value) {
            addCriterion("reg_type not like", value, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeIn(List<String> values) {
            addCriterion("reg_type in", values, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeNotIn(List<String> values) {
            addCriterion("reg_type not in", values, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeBetween(String value1, String value2) {
            addCriterion("reg_type between", value1, value2, "regType");
            return (Criteria) this;
        }

        public Criteria andRegTypeNotBetween(String value1, String value2) {
            addCriterion("reg_type not between", value1, value2, "regType");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdIsNull() {
            addCriterion("reg_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdIsNotNull() {
            addCriterion("reg_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdEqualTo(String value) {
            addCriterion("reg_customer_id =", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdNotEqualTo(String value) {
            addCriterion("reg_customer_id <>", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdGreaterThan(String value) {
            addCriterion("reg_customer_id >", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("reg_customer_id >=", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdLessThan(String value) {
            addCriterion("reg_customer_id <", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("reg_customer_id <=", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdLike(String value) {
            addCriterion("reg_customer_id like", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdNotLike(String value) {
            addCriterion("reg_customer_id not like", value, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdIn(List<String> values) {
            addCriterion("reg_customer_id in", values, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdNotIn(List<String> values) {
            addCriterion("reg_customer_id not in", values, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdBetween(String value1, String value2) {
            addCriterion("reg_customer_id between", value1, value2, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegCustomerIdNotBetween(String value1, String value2) {
            addCriterion("reg_customer_id not between", value1, value2, "regCustomerId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdIsNull() {
            addCriterion("reg_chnl_id is null");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdIsNotNull() {
            addCriterion("reg_chnl_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdEqualTo(String value) {
            addCriterion("reg_chnl_id =", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdNotEqualTo(String value) {
            addCriterion("reg_chnl_id <>", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdGreaterThan(String value) {
            addCriterion("reg_chnl_id >", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdGreaterThanOrEqualTo(String value) {
            addCriterion("reg_chnl_id >=", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdLessThan(String value) {
            addCriterion("reg_chnl_id <", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdLessThanOrEqualTo(String value) {
            addCriterion("reg_chnl_id <=", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdLike(String value) {
            addCriterion("reg_chnl_id like", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdNotLike(String value) {
            addCriterion("reg_chnl_id not like", value, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdIn(List<String> values) {
            addCriterion("reg_chnl_id in", values, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdNotIn(List<String> values) {
            addCriterion("reg_chnl_id not in", values, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdBetween(String value1, String value2) {
            addCriterion("reg_chnl_id between", value1, value2, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegChnlIdNotBetween(String value1, String value2) {
            addCriterion("reg_chnl_id not between", value1, value2, "regChnlId");
            return (Criteria) this;
        }

        public Criteria andRegEmailIsNull() {
            addCriterion("reg_email is null");
            return (Criteria) this;
        }

        public Criteria andRegEmailIsNotNull() {
            addCriterion("reg_email is not null");
            return (Criteria) this;
        }

        public Criteria andRegEmailEqualTo(String value) {
            addCriterion("reg_email =", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailNotEqualTo(String value) {
            addCriterion("reg_email <>", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailGreaterThan(String value) {
            addCriterion("reg_email >", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailGreaterThanOrEqualTo(String value) {
            addCriterion("reg_email >=", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailLessThan(String value) {
            addCriterion("reg_email <", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailLessThanOrEqualTo(String value) {
            addCriterion("reg_email <=", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailLike(String value) {
            addCriterion("reg_email like", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailNotLike(String value) {
            addCriterion("reg_email not like", value, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailIn(List<String> values) {
            addCriterion("reg_email in", values, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailNotIn(List<String> values) {
            addCriterion("reg_email not in", values, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailBetween(String value1, String value2) {
            addCriterion("reg_email between", value1, value2, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegEmailNotBetween(String value1, String value2) {
            addCriterion("reg_email not between", value1, value2, "regEmail");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Timestamp value) {
            addCriterion("reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Timestamp value) {
            addCriterion("reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Timestamp value) {
            addCriterion("reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Timestamp value) {
            addCriterion("reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Timestamp> values) {
            addCriterion("reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Timestamp> values) {
            addCriterion("reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNull() {
            addCriterion("update_oper_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNotNull() {
            addCriterion("update_oper_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdEqualTo(String value) {
            addCriterion("update_oper_id =", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotEqualTo(String value) {
            addCriterion("update_oper_id <>", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThan(String value) {
            addCriterion("update_oper_id >", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_oper_id >=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThan(String value) {
            addCriterion("update_oper_id <", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThanOrEqualTo(String value) {
            addCriterion("update_oper_id <=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLike(String value) {
            addCriterion("update_oper_id like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotLike(String value) {
            addCriterion("update_oper_id not like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIn(List<String> values) {
            addCriterion("update_oper_id in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotIn(List<String> values) {
            addCriterion("update_oper_id not in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdBetween(String value1, String value2) {
            addCriterion("update_oper_id between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotBetween(String value1, String value2) {
            addCriterion("update_oper_id not between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Timestamp value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Timestamp value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Timestamp value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Timestamp value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Timestamp> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Timestamp> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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