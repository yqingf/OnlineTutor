package com.aylfq5.online.tutor.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Boolean value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Boolean value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Boolean value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Boolean value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Boolean> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Boolean> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Boolean value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Boolean value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Boolean value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Boolean value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Boolean> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Boolean> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
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

        public Criteria andPersonalProfileIsNull() {
            addCriterion("personal_profile is null");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIsNotNull() {
            addCriterion("personal_profile is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileEqualTo(String value) {
            addCriterion("personal_profile =", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotEqualTo(String value) {
            addCriterion("personal_profile <>", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileGreaterThan(String value) {
            addCriterion("personal_profile >", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileGreaterThanOrEqualTo(String value) {
            addCriterion("personal_profile >=", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLessThan(String value) {
            addCriterion("personal_profile <", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLessThanOrEqualTo(String value) {
            addCriterion("personal_profile <=", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLike(String value) {
            addCriterion("personal_profile like", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotLike(String value) {
            addCriterion("personal_profile not like", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIn(List<String> values) {
            addCriterion("personal_profile in", values, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotIn(List<String> values) {
            addCriterion("personal_profile not in", values, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileBetween(String value1, String value2) {
            addCriterion("personal_profile between", value1, value2, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotBetween(String value1, String value2) {
            addCriterion("personal_profile not between", value1, value2, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesIsNull() {
            addCriterion("specialties is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesIsNotNull() {
            addCriterion("specialties is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesEqualTo(String value) {
            addCriterion("specialties =", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesNotEqualTo(String value) {
            addCriterion("specialties <>", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesGreaterThan(String value) {
            addCriterion("specialties >", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesGreaterThanOrEqualTo(String value) {
            addCriterion("specialties >=", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesLessThan(String value) {
            addCriterion("specialties <", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesLessThanOrEqualTo(String value) {
            addCriterion("specialties <=", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesLike(String value) {
            addCriterion("specialties like", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesNotLike(String value) {
            addCriterion("specialties not like", value, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesIn(List<String> values) {
            addCriterion("specialties in", values, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesNotIn(List<String> values) {
            addCriterion("specialties not in", values, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesBetween(String value1, String value2) {
            addCriterion("specialties between", value1, value2, "specialties");
            return (Criteria) this;
        }

        public Criteria andSpecialtiesNotBetween(String value1, String value2) {
            addCriterion("specialties not between", value1, value2, "specialties");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationIsNull() {
            addCriterion("tutor_expectation is null");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationIsNotNull() {
            addCriterion("tutor_expectation is not null");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationEqualTo(String value) {
            addCriterion("tutor_expectation =", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationNotEqualTo(String value) {
            addCriterion("tutor_expectation <>", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationGreaterThan(String value) {
            addCriterion("tutor_expectation >", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationGreaterThanOrEqualTo(String value) {
            addCriterion("tutor_expectation >=", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationLessThan(String value) {
            addCriterion("tutor_expectation <", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationLessThanOrEqualTo(String value) {
            addCriterion("tutor_expectation <=", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationLike(String value) {
            addCriterion("tutor_expectation like", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationNotLike(String value) {
            addCriterion("tutor_expectation not like", value, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationIn(List<String> values) {
            addCriterion("tutor_expectation in", values, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationNotIn(List<String> values) {
            addCriterion("tutor_expectation not in", values, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationBetween(String value1, String value2) {
            addCriterion("tutor_expectation between", value1, value2, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andTutorExpectationNotBetween(String value1, String value2) {
            addCriterion("tutor_expectation not between", value1, value2, "tutorExpectation");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleIsNull() {
            addCriterion("professional_title is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleIsNotNull() {
            addCriterion("professional_title is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleEqualTo(String value) {
            addCriterion("professional_title =", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleNotEqualTo(String value) {
            addCriterion("professional_title <>", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleGreaterThan(String value) {
            addCriterion("professional_title >", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleGreaterThanOrEqualTo(String value) {
            addCriterion("professional_title >=", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleLessThan(String value) {
            addCriterion("professional_title <", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleLessThanOrEqualTo(String value) {
            addCriterion("professional_title <=", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleLike(String value) {
            addCriterion("professional_title like", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleNotLike(String value) {
            addCriterion("professional_title not like", value, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleIn(List<String> values) {
            addCriterion("professional_title in", values, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleNotIn(List<String> values) {
            addCriterion("professional_title not in", values, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleBetween(String value1, String value2) {
            addCriterion("professional_title between", value1, value2, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andProfessionalTitleNotBetween(String value1, String value2) {
            addCriterion("professional_title not between", value1, value2, "professionalTitle");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersIsNull() {
            addCriterion("selected_numbers is null");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersIsNotNull() {
            addCriterion("selected_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersEqualTo(Byte value) {
            addCriterion("selected_numbers =", value, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersNotEqualTo(Byte value) {
            addCriterion("selected_numbers <>", value, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersGreaterThan(Byte value) {
            addCriterion("selected_numbers >", value, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersGreaterThanOrEqualTo(Byte value) {
            addCriterion("selected_numbers >=", value, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersLessThan(Byte value) {
            addCriterion("selected_numbers <", value, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersLessThanOrEqualTo(Byte value) {
            addCriterion("selected_numbers <=", value, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersIn(List<Byte> values) {
            addCriterion("selected_numbers in", values, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersNotIn(List<Byte> values) {
            addCriterion("selected_numbers not in", values, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersBetween(Byte value1, Byte value2) {
            addCriterion("selected_numbers between", value1, value2, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andSelectedNumbersNotBetween(Byte value1, Byte value2) {
            addCriterion("selected_numbers not between", value1, value2, "selectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersIsNull() {
            addCriterion("expected_numbers is null");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersIsNotNull() {
            addCriterion("expected_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersEqualTo(Byte value) {
            addCriterion("expected_numbers =", value, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersNotEqualTo(Byte value) {
            addCriterion("expected_numbers <>", value, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersGreaterThan(Byte value) {
            addCriterion("expected_numbers >", value, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersGreaterThanOrEqualTo(Byte value) {
            addCriterion("expected_numbers >=", value, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersLessThan(Byte value) {
            addCriterion("expected_numbers <", value, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersLessThanOrEqualTo(Byte value) {
            addCriterion("expected_numbers <=", value, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersIn(List<Byte> values) {
            addCriterion("expected_numbers in", values, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersNotIn(List<Byte> values) {
            addCriterion("expected_numbers not in", values, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersBetween(Byte value1, Byte value2) {
            addCriterion("expected_numbers between", value1, value2, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andExpectedNumbersNotBetween(Byte value1, Byte value2) {
            addCriterion("expected_numbers not between", value1, value2, "expectedNumbers");
            return (Criteria) this;
        }

        public Criteria andOfficeIsNull() {
            addCriterion("office is null");
            return (Criteria) this;
        }

        public Criteria andOfficeIsNotNull() {
            addCriterion("office is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeEqualTo(String value) {
            addCriterion("office =", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeNotEqualTo(String value) {
            addCriterion("office <>", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeGreaterThan(String value) {
            addCriterion("office >", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeGreaterThanOrEqualTo(String value) {
            addCriterion("office >=", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeLessThan(String value) {
            addCriterion("office <", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeLessThanOrEqualTo(String value) {
            addCriterion("office <=", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeLike(String value) {
            addCriterion("office like", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeNotLike(String value) {
            addCriterion("office not like", value, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeIn(List<String> values) {
            addCriterion("office in", values, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeNotIn(List<String> values) {
            addCriterion("office not in", values, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeBetween(String value1, String value2) {
            addCriterion("office between", value1, value2, "office");
            return (Criteria) this;
        }

        public Criteria andOfficeNotBetween(String value1, String value2) {
            addCriterion("office not between", value1, value2, "office");
            return (Criteria) this;
        }

        public Criteria andAchievementsIsNull() {
            addCriterion("achievements is null");
            return (Criteria) this;
        }

        public Criteria andAchievementsIsNotNull() {
            addCriterion("achievements is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementsEqualTo(String value) {
            addCriterion("achievements =", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotEqualTo(String value) {
            addCriterion("achievements <>", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsGreaterThan(String value) {
            addCriterion("achievements >", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsGreaterThanOrEqualTo(String value) {
            addCriterion("achievements >=", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsLessThan(String value) {
            addCriterion("achievements <", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsLessThanOrEqualTo(String value) {
            addCriterion("achievements <=", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsLike(String value) {
            addCriterion("achievements like", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotLike(String value) {
            addCriterion("achievements not like", value, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsIn(List<String> values) {
            addCriterion("achievements in", values, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotIn(List<String> values) {
            addCriterion("achievements not in", values, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsBetween(String value1, String value2) {
            addCriterion("achievements between", value1, value2, "achievements");
            return (Criteria) this;
        }

        public Criteria andAchievementsNotBetween(String value1, String value2) {
            addCriterion("achievements not between", value1, value2, "achievements");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
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