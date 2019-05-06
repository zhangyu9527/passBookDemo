package com.zhangyu.passbook.passbook.constant;

/**
 * 常量定义
 */
public class Constants {
    //商户优惠券 kafka topic
    public static final String TEMPLATE_TOPIC="merchants-template";
    //token 文件存储目录
    public static final String TOKEN_DIR="/tmp/token/";
    //已使用的token 文件名后缀
    public static final String USED_TOKEN_SUFFIX="_";

    //用户数 的redis key
    public static final String USE_COUNT_KEY="zhangyu-user-count";

    //
    public class UserTable{
        //User Hbase 表名
         public static final String TABLE_NAME="pb:user";
        //基本信息列族
         public static final String FAMILY_B="b";
         public static final String NAME="name";
         public static final String AGE="age";
         public static final String SEX="sex";
         //额外信息列族
         public static final String FAMILY_O="O";
         public static final String PHONE="phone";

         public static final String ADDRESS="address";
    }

    public class PassTemplateTable{
        /** PassTemplate HBase 表名 */
        public static final String TABLE_NAME = "pb:passtemplate";

        /** 基本信息列族 */
        public static final String FAMILY_B = "b";

        /** 商户 id */
        public static final String ID = "id";

        /** 优惠券标题 */
        public static final String TITLE = "title";

        /** 优惠券摘要信息 */
        public static final String SUMMARY = "summary";

        /** 优惠券详细信息 */
        public static final String DESC = "desc";

        /** 优惠券是否有 token */
        public static final String HAS_TOKEN = "has_token";

        /** 优惠券背景色 */
        public static final String BACKGROUND = "background";

        /** 约束信息列族 */
        public static final String FAMILY_C = "c";

        /** 最大个数限制 */
        public static final String LIMIT = "limit";

        /** 优惠券开始时间 */
        public static final String START = "start";

        /** 优惠券结束时间 */
        public static final String END = "end";
    }

    public class PassTable {

        /** Pass HBase 表名 */
        public static final String TABLE_NAME = "pb:pass";

        /** 信息列族 */
        public static final String FAMILY_I = "i";

        /** 用户 id */
        public static final String USER_ID = "user_id";

        /** 优惠券 id */
        public static final String TEMPLATE_ID = "template_id";

        /** 优惠券识别码 */
        public static final String TOKEN = "token";

        /** 领取日期 */
        public static final String ASSIGNED_DATE = "assigned_date";

        /** 消费日期 */
        public static final String CON_DATE = "con_date";
    }

    /**
     * <h2>Feedback Hbase Table</h2>
     * */
    public class Feedback {

        /** Feedback HBase 表名 */
        public static final String TABLE_NAME = "pb:feedback";

        /** 信息列族 */
        public static final String FAMILY_I = "i";

        /** 用户 id */
        public static final String USER_ID = "user_id";

        /** 评论类型 */
        public static final String TYPE = "type";

        /** PassTemplate RowKey, 如果是 app 评论, 则是 -1 */
        public static final String TEMPLATE_ID = "template_id";

        /** 评论内容 */
        public static final String COMMENT = "comment";
    }
}
