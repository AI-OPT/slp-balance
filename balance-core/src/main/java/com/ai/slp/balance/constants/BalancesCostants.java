package com.ai.slp.balance.constants;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ai.opt.sdk.util.DateUtil;

/**
 * 余额中心常量定义类 Date: 2015年7月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public final class BalancesCostants {
	/**
	 * 订单支付MDS所有topic信息
	 *
	 * Date: 2016年6月21日 <br>
	 * Copyright (c) 2016 asiainfo.com <br>
	 * @author zhangzd
	 */
	public static final class OrdOrder {
		public static final String SLP_CHARGE_TOPIC = "slpChargeTopic";
	}
	
	public static final class BusiType {
        
        private BusiType() {
            
        }
        
        /**
         * 1、订单收费类
         */
        public static final String ORDER_CHARGE = "1";
        
        /**
         * 2、缴费充值类
         */
        public static final String ACCOUNT_CHARGE = "2";
        
    }
	
    private BalancesCostants() {
    }

    /**
     * 账户信息表 Date: 2015年7月27日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author fanpw
     */
    public static final class FunAccountInfo {

        private FunAccountInfo() {
        }

        /**
         * 账户状态 Date: 2015年7月27日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author fanpw
         */
        public static final class AcctStatus {

            private AcctStatus() {
            }

            /**
             * 0：无效
             */
            public static final String IN_VALID = "0";

            /**
             * 1：有效
             */
            public static final String VALID = "1";

            /**
             * 2：冻结
             */
            public static final String FREEZE = "2";
        }

        /**
         * 寄送方式 Date: 2015年7月27日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author fanpw
         */
        public static final class PostType {

            private PostType() {
            }

            /**
             * 不寄送
             */
            public static final String NONE = "0";

            /**
             * Email
             */
            public static final String ELECT = "1";

            /**
             * 邮寄
             */
            public static final String PAGE = "2";

        }

    }

    /**
     * 账本信息 Date: 2015年7月27日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author lilg
     */
    public static final class FunFundBook {

        private FunFundBook() {
        }

        /**
         * 账本状态 Date: 2015年7月27日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static class BookStatus {

            protected BookStatus() {
            }

            /**
             * 有效
             */
            public static final String VALID = "1";

            /**
             * 无效
             */
            public static final String INVALID = "0";

            /**
             * 冻结
             */
            public static final String FREEZE = "2";
        }

        /**
         * 资金类型，继承Subject资金类型 Date: 2015年8月20日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class FundType extends FunSubject.FundType {
            private FundType() {
            }
        }

        /**
         * 默认的生失效时间 Date: 2015年8月20日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static class DefaultDate {
            protected DefaultDate() {
            };

            /**
             * 默认失效时间
             */
            public static final Timestamp expireDate = DateUtil.getTimestamp("2099-12-31 23:59:59",
                    "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 交易订单流水 Date: 2015年8月17日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author lilg
     */
    public static final class FunFundSerial {
        private FunFundSerial() {
        }

        /**
         * 操作类型 Date: 2015年8月17日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class OptType {
            private OptType() {
            }

            /**
             * 存入
             */
            public static final String DEPOSIT = "1";

            /**
             * 扣款
             */
            public static final String DEDUCT = "2";

            /**
             * 转账
             */
            public static final String TRANSFER = "3";

            /**
             * 提现
             */
            public static final String WITHDROW = "4";

            /**
             * 预存转兑
             */
            public static final String PREEXCHANGE = "5";

            /**
             * 冲正
             */
            public static final String REVERSE = "6";

            /**
             * 活动终止
             */
            public static final String PAY_RULE_CANCLE = "7";

        }

        /**
         * 交易状态 Date: 2015年8月17日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class PayStatus {
            private PayStatus() {
            }

            /**
             * 0 交易未完成
             */
            public static final String UNFINISHED = "0";

            /**
             * 1 交易成功
             */
            public static final String SUCCESS = "1";

            /**
             * 2 交易失败
             */
            public static final String FAILURE = "2";
        }
    }

    /**
     * 科目 Date: 2015年8月17日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author lilg
     */
    public static final class FunSubject {
        private FunSubject() {
        }

        /**
         * 科目类型 Date: 2015年8月17日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class SubjectType {
            private SubjectType() {
            }

            // 资源科目
            public static final String RESOURCE = "1";

            // 消费科目
            public static final String FEE = "2";

            // 资金科目
            public static final String FUND = "9";

        }

        /**
         * 资金类型 Date: 2015年8月20日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static class FundType {
            protected FundType() {
            }

            /**
             * 现金
             */
            public static final String CASH = "1";

            /**
             * 通信现金
             */
            public static final String TELE_CASH = "2";

            /**
             * 赠款
             */
            public static final String GRANT = "3";

            /**
             * 押金科目
             */
            public static final String FOREGIFT = "8";
            /*
             * 1：现金 2：通讯现金 3：赠款 4：红包 5：优惠券 6: 预存转兑 7: 月费返还 8：押金
             */
        }

        /**
         * 账本叠加方式 Date: 2015年8月20日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class ValidType {
            private ValidType() {
            }

            /**
             * 0：新增时叠加在同账本上，账本不受有效期限制
             */
            public static final String MERGE = "0";

            /**
             * 1：新增时叠加在同账本上，有效期按照规则顺延
             */
            public static final String DELAY = "1";

            /**
             * 2：新增（不叠加）
             */
            public static final String ADD = "2";

        }

        /**
         * 对象在缓存中的属性名 Date: 2015年8月20日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class CacheJsonKey {
            private CacheJsonKey() {
            }

            public static final String TENANT_ID = "tenantId";

            public static final String VALID_TYPE = "validType";

            public static final String FUND_TYPE = "fundType";

            public static final String SUBJECT_TYPE = "subjectType";

            public static final String USE_PRI = "usePri";

        }
    }

    /**
     * 资源账本 <br>
     *
     * Date: 2015年10月28日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author lilg
     */
    public static final class FunResBook {

        private FunResBook() {
        }

        /**
         * 账本状态<br>
         *
         * Date: 2015年10月28日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class BookStatus extends FunFundBook.BookStatus {
            private BookStatus() {

            }

            /**
             * 未激活，非即买即用提前入账时的状态
             */
            public static final String UN_ACTIVATED = "3";
        }

        /**
         * 默认的生失效时间 <br>
         *
         * Date: 2015年10月28日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class DefaultDate extends FunFundBook.DefaultDate {
            private DefaultDate() {

            }

            /**
             * 默认生效时间
             */
            public static final Timestamp effectDate = DateUtil.getTimestamp("2000-01-01 00:00:00",
                    "yyyy-MM-dd HH:mm:ss");
        }

        /**
         * 账本产生的来源类型<br>
         *
         * Date: 2015年10月28日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class SourceType {

            private SourceType() {

            }

            /**
             * 产品订购
             */
            public static final int PRODUCT_ORDER = 0;

            /**
             * 资源转赠
             */
            public static final int RES_PRESENT = 1;

            /**
             * 资源转换
             */
            public static final int RES_CONVERT = 2;

            /**
             * 资源交易
             */
            public static final int RES_TRANS = 3;

            /**
             * 活动受理
             */
            public static final int PAY_RULE = 4;

            /**
             * 资源分配
             */
            public static final int RES_ALLOT = 5;

            /**
             * 资源批发
             */
            public static final int RES_WHOLESALE = 6;

            private static final Integer[] arrAll = { PRODUCT_ORDER, RES_PRESENT, RES_CONVERT,
                    RES_TRANS, PAY_RULE, RES_ALLOT, RES_WHOLESALE };

            /**
             * 所有值(升序)
             */
            public static final List<Integer> ALL = Collections.unmodifiableList(Arrays
                    .asList(arrAll));
            static {
                Arrays.sort(arrAll);
            }
        }

        /**
         * 资源类型 <br>
         *
         * Date: 2015年10月28日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class ResourceType {

            private ResourceType() {
            }

            /**
             * 语音
             */
            public static final int CALL = 10;

            /**
             * 短信
             */
            public static final int MSG = 50;

            /**
             * 流量
             */
            public static final int DATA = 60;

            /**
             * G币 (国美GB)
             */
            public static final int GB = 99;

            private static final Integer[] arrAll = { CALL, MSG, DATA, GB };

            /**
             * 所有值(升序)
             */
            public static final List<Integer> ALL = Collections.unmodifiableList(Arrays
                    .asList(arrAll));
            static {
                Arrays.sort(arrAll);
            }
        }

        /**
         * 属主类型 <br>
         *
         * Date: 2015年10月28日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class OwnerType {
            private OwnerType() {

            }

            /**
             * 用户
             */
            public static final int USER = 0;

            /**
             * 账户
             */
            public static final int ACCOUNT = 1;

            /**
             * 属组
             */
            public static final int GROUP = 2;

            private static final Integer[] arrAll = { USER, ACCOUNT, GROUP };

            /**
             * 所有值(升序)
             */
            public static final List<Integer> ALL = Collections.unmodifiableList(Arrays
                    .asList(arrAll));
            static {
                Arrays.sort(arrAll);
            }
        }

        /**
         * 清零标志 <br>
         *
         * Date: 2015年10月28日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class AllowClear {
            private AllowClear() {

            }

            /**
             * 清零
             */
            public static final int YES = 0;

            /**
             * 不清零
             */
            public static final int NO = 1;

            private static final Integer[] arrAll = { YES, NO };

            /**
             * 所有值(升序)
             */
            public static final List<Integer> ALL = Collections.unmodifiableList(Arrays
                    .asList(arrAll));
            static {
                Arrays.sort(arrAll);
            }
        }

        /**
         * 可转增标识
         *
         * Date: 2015年11月16日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class AllowPresent {
            private AllowPresent() {

            }

            /**
             * 1 可转赠
             */
            public static final int YES = 1;

            /**
             * 0 不可转赠
             */
            public static final int NO = 0;

            private static final Integer[] arrAll = { YES, NO };

            /**
             * 所有值(升序)
             */
            public static final List<Integer> ALL = Collections.unmodifiableList(Arrays
                    .asList(arrAll));
            static {
                Arrays.sort(arrAll);
            }
        }

        /**
         * 可转兑/买卖标识
         *
         * Date: 2015年11月16日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class AllowConvert {
            private AllowConvert() {

            }

            /**
             * 1 可转兑/买卖
             */
            public static final int YES = 1;

            /**
             * 0 不可转兑/买卖
             */
            public static final int NO = 0;

            private static final Integer[] arrAll = { YES, NO };

            /**
             * 所有值(升序)
             */
            public static final List<Integer> ALL = Collections.unmodifiableList(Arrays
                    .asList(arrAll));
            static {
                Arrays.sort(arrAll);
            }
        }

        /**
         * 即买即用标识
         *
         * Date: 2015年11月17日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class UseFlag {
            private UseFlag() {

            }

            /**
             * 即买即用
             */
            public static final String IMMEDIATELY = "1";

            /**
             * 非即买即用
             */
            public static final String UM_IMMEDIATELY = "0";
        }

    }

    /**
     * 资源操作记录
     *
     * Date: 2015年11月16日 <br>
     * Copyright (c) 2015 asiainfo.com <br>
     * 
     * @author lilg
     */
    public static final class FunResOperaDetail {
        private FunResOperaDetail() {

        }

        /**
         * 操作记录状态
         *
         * Date: 2015年11月16日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class Status {
            private Status() {
            }

            /**
             * 等待抵扣
             */
            public static final String WAIT_DEDUCT = "1";

            /**
             * 已抵扣
             */
            public static final String ALREADY_DEDUCT = "0";
        }

        /**
         * 操作类型
         *
         * Date: 2015年11月16日 <br>
         * Copyright (c) 2015 asiainfo.com <br>
         * 
         * @author lilg
         */
        public static final class OptType {
            private OptType() {
            }

            /**
             * 入账
             */
            public static final int DEPOSIT = 0;

            /**
             * 抵扣
             */
            public static final int DEDUCT = 1;

            /**
             * 剩余抵扣 <br>
             * 注：后台抵扣进程遇到账本余额不足只能抵扣部分时,会根据剩余未抵扣的金额新生成该操作类型一条操作记录
             */
            public static final int PART_DEDUCT = 2;

            /**
             * 账本生失效维护
             */
            public static final int MAINTAIN_RESBOOK = 3;

        }
    }

}
