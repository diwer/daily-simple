package cn.whatisee.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImageExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("filepath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filepath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filepath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filepath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filepath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filepath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filepath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filepath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filepath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filepath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filepath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filepath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filepath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filepath not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(Integer value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(Integer value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(Integer value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(Integer value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(Integer value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<Integer> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<Integer> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(Integer value1, Integer value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(Integer value1, Integer value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Byte value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Byte value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Byte value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Byte value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Byte value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Byte> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Byte> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Byte value1, Byte value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFlagdescIsNull() {
            addCriterion("flagdesc is null");
            return (Criteria) this;
        }

        public Criteria andFlagdescIsNotNull() {
            addCriterion("flagdesc is not null");
            return (Criteria) this;
        }

        public Criteria andFlagdescEqualTo(String value) {
            addCriterion("flagdesc =", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescNotEqualTo(String value) {
            addCriterion("flagdesc <>", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescGreaterThan(String value) {
            addCriterion("flagdesc >", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescGreaterThanOrEqualTo(String value) {
            addCriterion("flagdesc >=", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescLessThan(String value) {
            addCriterion("flagdesc <", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescLessThanOrEqualTo(String value) {
            addCriterion("flagdesc <=", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescLike(String value) {
            addCriterion("flagdesc like", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescNotLike(String value) {
            addCriterion("flagdesc not like", value, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescIn(List<String> values) {
            addCriterion("flagdesc in", values, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescNotIn(List<String> values) {
            addCriterion("flagdesc not in", values, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescBetween(String value1, String value2) {
            addCriterion("flagdesc between", value1, value2, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andFlagdescNotBetween(String value1, String value2) {
            addCriterion("flagdesc not between", value1, value2, "flagdesc");
            return (Criteria) this;
        }

        public Criteria andUsedidIsNull() {
            addCriterion("usedId is null");
            return (Criteria) this;
        }

        public Criteria andUsedidIsNotNull() {
            addCriterion("usedId is not null");
            return (Criteria) this;
        }

        public Criteria andUsedidEqualTo(String value) {
            addCriterion("usedId =", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotEqualTo(String value) {
            addCriterion("usedId <>", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidGreaterThan(String value) {
            addCriterion("usedId >", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidGreaterThanOrEqualTo(String value) {
            addCriterion("usedId >=", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidLessThan(String value) {
            addCriterion("usedId <", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidLessThanOrEqualTo(String value) {
            addCriterion("usedId <=", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidLike(String value) {
            addCriterion("usedId like", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotLike(String value) {
            addCriterion("usedId not like", value, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidIn(List<String> values) {
            addCriterion("usedId in", values, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotIn(List<String> values) {
            addCriterion("usedId not in", values, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidBetween(String value1, String value2) {
            addCriterion("usedId between", value1, value2, "usedid");
            return (Criteria) this;
        }

        public Criteria andUsedidNotBetween(String value1, String value2) {
            addCriterion("usedId not between", value1, value2, "usedid");
            return (Criteria) this;
        }

        public Criteria andCreatetdateIsNull() {
            addCriterion("createtdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatetdateIsNotNull() {
            addCriterion("createtdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetdateEqualTo(Date value) {
            addCriterion("createtdate =", value, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateNotEqualTo(Date value) {
            addCriterion("createtdate <>", value, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateGreaterThan(Date value) {
            addCriterion("createtdate >", value, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateGreaterThanOrEqualTo(Date value) {
            addCriterion("createtdate >=", value, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateLessThan(Date value) {
            addCriterion("createtdate <", value, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateLessThanOrEqualTo(Date value) {
            addCriterion("createtdate <=", value, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateIn(List<Date> values) {
            addCriterion("createtdate in", values, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateNotIn(List<Date> values) {
            addCriterion("createtdate not in", values, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateBetween(Date value1, Date value2) {
            addCriterion("createtdate between", value1, value2, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreatetdateNotBetween(Date value1, Date value2) {
            addCriterion("createtdate not between", value1, value2, "createtdate");
            return (Criteria) this;
        }

        public Criteria andCreateridIsNull() {
            addCriterion("createrid is null");
            return (Criteria) this;
        }

        public Criteria andCreateridIsNotNull() {
            addCriterion("createrid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateridEqualTo(String value) {
            addCriterion("createrid =", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotEqualTo(String value) {
            addCriterion("createrid <>", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridGreaterThan(String value) {
            addCriterion("createrid >", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridGreaterThanOrEqualTo(String value) {
            addCriterion("createrid >=", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLessThan(String value) {
            addCriterion("createrid <", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLessThanOrEqualTo(String value) {
            addCriterion("createrid <=", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLike(String value) {
            addCriterion("createrid like", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotLike(String value) {
            addCriterion("createrid not like", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridIn(List<String> values) {
            addCriterion("createrid in", values, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotIn(List<String> values) {
            addCriterion("createrid not in", values, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridBetween(String value1, String value2) {
            addCriterion("createrid between", value1, value2, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotBetween(String value1, String value2) {
            addCriterion("createrid not between", value1, value2, "createrid");
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