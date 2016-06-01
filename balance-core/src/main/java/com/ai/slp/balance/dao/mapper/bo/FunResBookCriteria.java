package com.ai.slp.balance.dao.mapper.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FunResBookCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FunResBookCriteria() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Long value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Long value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Long value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Long value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Long value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Long value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Long> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Long> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Long value1, Long value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Long value1, Long value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
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

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Long value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Long value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Long value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Long value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Long value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Long> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Long> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Long value1, Long value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Long value1, Long value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeIsNull() {
            addCriterion("owner_type is null");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeIsNotNull() {
            addCriterion("owner_type is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeEqualTo(Integer value) {
            addCriterion("owner_type =", value, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeNotEqualTo(Integer value) {
            addCriterion("owner_type <>", value, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeGreaterThan(Integer value) {
            addCriterion("owner_type >", value, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_type >=", value, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeLessThan(Integer value) {
            addCriterion("owner_type <", value, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("owner_type <=", value, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeIn(List<Integer> values) {
            addCriterion("owner_type in", values, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeNotIn(List<Integer> values) {
            addCriterion("owner_type not in", values, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeBetween(Integer value1, Integer value2) {
            addCriterion("owner_type between", value1, value2, "ownerType");
            return (Criteria) this;
        }

        public Criteria andOwnerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_type not between", value1, value2, "ownerType");
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

        public Criteria andSubjectIdEqualTo(Long value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Long value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Long value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Long value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Long> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Long> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Long value1, Long value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("resource_type is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(Integer value) {
            addCriterion("resource_type =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(Integer value) {
            addCriterion("resource_type <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(Integer value) {
            addCriterion("resource_type >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_type >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(Integer value) {
            addCriterion("resource_type <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("resource_type <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<Integer> values) {
            addCriterion("resource_type in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<Integer> values) {
            addCriterion("resource_type not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("resource_type between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_type not between", value1, value2, "resourceType");
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

        public Criteria andEffectTimeIsNull() {
            addCriterion("effect_time is null");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIsNotNull() {
            addCriterion("effect_time is not null");
            return (Criteria) this;
        }

        public Criteria andEffectTimeEqualTo(Timestamp value) {
            addCriterion("effect_time =", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotEqualTo(Timestamp value) {
            addCriterion("effect_time <>", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThan(Timestamp value) {
            addCriterion("effect_time >", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("effect_time >=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThan(Timestamp value) {
            addCriterion("effect_time <", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("effect_time <=", value, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeIn(List<Timestamp> values) {
            addCriterion("effect_time in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotIn(List<Timestamp> values) {
            addCriterion("effect_time not in", values, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("effect_time between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andEffectTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("effect_time not between", value1, value2, "effectTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Timestamp value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Timestamp value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Timestamp value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Timestamp value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Timestamp> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Timestamp> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
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

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIsNull() {
            addCriterion("deduct_amount is null");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIsNotNull() {
            addCriterion("deduct_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDeductAmountEqualTo(BigDecimal value) {
            addCriterion("deduct_amount =", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotEqualTo(BigDecimal value) {
            addCriterion("deduct_amount <>", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountGreaterThan(BigDecimal value) {
            addCriterion("deduct_amount >", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_amount >=", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountLessThan(BigDecimal value) {
            addCriterion("deduct_amount <", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduct_amount <=", value, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountIn(List<BigDecimal> values) {
            addCriterion("deduct_amount in", values, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotIn(List<BigDecimal> values) {
            addCriterion("deduct_amount not in", values, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_amount between", value1, value2, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andDeductAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduct_amount not between", value1, value2, "deductAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountIsNull() {
            addCriterion("present_amount is null");
            return (Criteria) this;
        }

        public Criteria andPresentAmountIsNotNull() {
            addCriterion("present_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPresentAmountEqualTo(BigDecimal value) {
            addCriterion("present_amount =", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountNotEqualTo(BigDecimal value) {
            addCriterion("present_amount <>", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountGreaterThan(BigDecimal value) {
            addCriterion("present_amount >", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("present_amount >=", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountLessThan(BigDecimal value) {
            addCriterion("present_amount <", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("present_amount <=", value, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountIn(List<BigDecimal> values) {
            addCriterion("present_amount in", values, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountNotIn(List<BigDecimal> values) {
            addCriterion("present_amount not in", values, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present_amount between", value1, value2, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andPresentAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present_amount not between", value1, value2, "presentAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountIsNull() {
            addCriterion("exchange_amount is null");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountIsNotNull() {
            addCriterion("exchange_amount is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountEqualTo(BigDecimal value) {
            addCriterion("exchange_amount =", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNotEqualTo(BigDecimal value) {
            addCriterion("exchange_amount <>", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountGreaterThan(BigDecimal value) {
            addCriterion("exchange_amount >", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_amount >=", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountLessThan(BigDecimal value) {
            addCriterion("exchange_amount <", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_amount <=", value, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountIn(List<BigDecimal> values) {
            addCriterion("exchange_amount in", values, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNotIn(List<BigDecimal> values) {
            addCriterion("exchange_amount not in", values, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_amount between", value1, value2, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andExchangeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_amount not between", value1, value2, "exchangeAmount");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNull() {
            addCriterion("book_status is null");
            return (Criteria) this;
        }

        public Criteria andBookStatusIsNotNull() {
            addCriterion("book_status is not null");
            return (Criteria) this;
        }

        public Criteria andBookStatusEqualTo(String value) {
            addCriterion("book_status =", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotEqualTo(String value) {
            addCriterion("book_status <>", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThan(String value) {
            addCriterion("book_status >", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusGreaterThanOrEqualTo(String value) {
            addCriterion("book_status >=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThan(String value) {
            addCriterion("book_status <", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLessThanOrEqualTo(String value) {
            addCriterion("book_status <=", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusLike(String value) {
            addCriterion("book_status like", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotLike(String value) {
            addCriterion("book_status not like", value, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusIn(List<String> values) {
            addCriterion("book_status in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotIn(List<String> values) {
            addCriterion("book_status not in", values, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusBetween(String value1, String value2) {
            addCriterion("book_status between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andBookStatusNotBetween(String value1, String value2) {
            addCriterion("book_status not between", value1, value2, "bookStatus");
            return (Criteria) this;
        }

        public Criteria andAllowPresentIsNull() {
            addCriterion("allow_present is null");
            return (Criteria) this;
        }

        public Criteria andAllowPresentIsNotNull() {
            addCriterion("allow_present is not null");
            return (Criteria) this;
        }

        public Criteria andAllowPresentEqualTo(Integer value) {
            addCriterion("allow_present =", value, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentNotEqualTo(Integer value) {
            addCriterion("allow_present <>", value, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentGreaterThan(Integer value) {
            addCriterion("allow_present >", value, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentGreaterThanOrEqualTo(Integer value) {
            addCriterion("allow_present >=", value, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentLessThan(Integer value) {
            addCriterion("allow_present <", value, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentLessThanOrEqualTo(Integer value) {
            addCriterion("allow_present <=", value, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentIn(List<Integer> values) {
            addCriterion("allow_present in", values, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentNotIn(List<Integer> values) {
            addCriterion("allow_present not in", values, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentBetween(Integer value1, Integer value2) {
            addCriterion("allow_present between", value1, value2, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowPresentNotBetween(Integer value1, Integer value2) {
            addCriterion("allow_present not between", value1, value2, "allowPresent");
            return (Criteria) this;
        }

        public Criteria andAllowConvertIsNull() {
            addCriterion("allow_convert is null");
            return (Criteria) this;
        }

        public Criteria andAllowConvertIsNotNull() {
            addCriterion("allow_convert is not null");
            return (Criteria) this;
        }

        public Criteria andAllowConvertEqualTo(Integer value) {
            addCriterion("allow_convert =", value, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertNotEqualTo(Integer value) {
            addCriterion("allow_convert <>", value, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertGreaterThan(Integer value) {
            addCriterion("allow_convert >", value, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertGreaterThanOrEqualTo(Integer value) {
            addCriterion("allow_convert >=", value, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertLessThan(Integer value) {
            addCriterion("allow_convert <", value, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertLessThanOrEqualTo(Integer value) {
            addCriterion("allow_convert <=", value, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertIn(List<Integer> values) {
            addCriterion("allow_convert in", values, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertNotIn(List<Integer> values) {
            addCriterion("allow_convert not in", values, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertBetween(Integer value1, Integer value2) {
            addCriterion("allow_convert between", value1, value2, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowConvertNotBetween(Integer value1, Integer value2) {
            addCriterion("allow_convert not between", value1, value2, "allowConvert");
            return (Criteria) this;
        }

        public Criteria andAllowClearIsNull() {
            addCriterion("allow_clear is null");
            return (Criteria) this;
        }

        public Criteria andAllowClearIsNotNull() {
            addCriterion("allow_clear is not null");
            return (Criteria) this;
        }

        public Criteria andAllowClearEqualTo(Integer value) {
            addCriterion("allow_clear =", value, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearNotEqualTo(Integer value) {
            addCriterion("allow_clear <>", value, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearGreaterThan(Integer value) {
            addCriterion("allow_clear >", value, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearGreaterThanOrEqualTo(Integer value) {
            addCriterion("allow_clear >=", value, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearLessThan(Integer value) {
            addCriterion("allow_clear <", value, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearLessThanOrEqualTo(Integer value) {
            addCriterion("allow_clear <=", value, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearIn(List<Integer> values) {
            addCriterion("allow_clear in", values, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearNotIn(List<Integer> values) {
            addCriterion("allow_clear not in", values, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearBetween(Integer value1, Integer value2) {
            addCriterion("allow_clear between", value1, value2, "allowClear");
            return (Criteria) this;
        }

        public Criteria andAllowClearNotBetween(Integer value1, Integer value2) {
            addCriterion("allow_clear not between", value1, value2, "allowClear");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(Integer value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(Integer value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(Integer value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(Integer value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<Integer> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<Integer> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Long value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Long value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Long value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Long value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Long value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Long> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Long> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Long value1, Long value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Long value1, Long value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andUseVersionIsNull() {
            addCriterion("use_version is null");
            return (Criteria) this;
        }

        public Criteria andUseVersionIsNotNull() {
            addCriterion("use_version is not null");
            return (Criteria) this;
        }

        public Criteria andUseVersionEqualTo(Long value) {
            addCriterion("use_version =", value, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionNotEqualTo(Long value) {
            addCriterion("use_version <>", value, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionGreaterThan(Long value) {
            addCriterion("use_version >", value, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("use_version >=", value, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionLessThan(Long value) {
            addCriterion("use_version <", value, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionLessThanOrEqualTo(Long value) {
            addCriterion("use_version <=", value, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionIn(List<Long> values) {
            addCriterion("use_version in", values, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionNotIn(List<Long> values) {
            addCriterion("use_version not in", values, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionBetween(Long value1, Long value2) {
            addCriterion("use_version between", value1, value2, "useVersion");
            return (Criteria) this;
        }

        public Criteria andUseVersionNotBetween(Long value1, Long value2) {
            addCriterion("use_version not between", value1, value2, "useVersion");
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