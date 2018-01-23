package com.lys.base.utils.kit;

import android.os.Environment;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * ProjectName：AppConfig
 * Description：全局配置类
 * Author：JensenWei
 * QQ: 2188307188
 * Createtime：2016/7/11 11:38
 * Modified By：
 * Fixtime：2016/7/11 11:38
 * FixDescription：
 */
public class AppConfig {

    public static final boolean DEV = false;//开发模式
    public static final String TOPBRANCHNO = "20000004";//一级代理商编号
    public static final String PGY_URL = "https://www.pgyer.com/b1m0";//蒲公英地址

//        public static final String BASE_URL = "http://121.201.20.239:9710/appservice/";//测试环境地址
//    public static final String BASE_URL = "http://192.168.0.211:8111/appservice/";//本地测试环境地址
    public static final String BASE_URL = "http://appsys.yiyoupay.net/appservice/";//生产环境地址
    public static final String WX_URL = "http://weixin.yiyoupay.net/wxpay/front/split.do?";//微信分享地址

    //根目录地址
    public static final String DIR_YZF_ROOT = Environment.getExternalStorageDirectory() + File.separator + "YZF" + File.separator;
    //相册目录
    public static final String DIR_PICTURES_ROOT = Environment.getExternalStorageDirectory() + File.separator + "Pictures" + File.separator + "YZF/";
    //注册图片存放地址
    public static final String REGIEST_IMG = DIR_YZF_ROOT;
    public static final String DIR_PICTURE = DIR_YZF_ROOT + "picture/";

    //绑定银行卡
    public static final String BINDCARD_URL = "trade/bankBinding.do";
    // 登录
    public static final String LOGIN_URL = "userlogin.do";
    // 修改密码
    public static final String CHANGEPASSWORD_URL = "modifyPwd.do";
    // 获取验证码
    public static final String GETCODES_URL = "verification.do";
    // 搜索支行
    public static final String SEARCHSUBBANK_URL = "searchBank.do";
    //搜索银行总行
    public static final String SEARCHBANK_URL = "queryMinBank.do";
    // 获取账户信息
    public static final String GETACCTINFO_URL = "trade/queryMerchAcct.do";
    // 获取商户信息
    public static final String GETMERCHINFO_URL = "reMerchinfo.do";
    // 交易接口
    public static final String TRADE_URL = "trade/submit.do";
    // 获取交易记录
    public static final String GETORDERLIST_URL = "trade/queryTrans.do";
    // 注册帐号
    public static final String REGIEST_URL = "registered.do";
    //上传注册资料
    public static final String UPLOADDATA_URL = "businessregistration.do";
    //上传注册资料
    public static final String VERIFIED_URL = "userVerified.do";
    // 上传注册照片
    public static final String UPLOADPHOTOS_URL = "uploadFile.do";
    // 刷新接口
    public static final String REFRESH_URL = "refreshuser.do";
    // 找回密码
    public static final String FINDPASSWORD_URL = "resePwd.do";

    // 获取费率
    public static final String GETMERCHFEE_URL = "trade/queryMerchFee.do";

    // 获取白名单卡
    public static final String GETWHITELIST_URl = "trade/merchCradInfo.do";
    // 解绑白名单卡
    public static final String DELETEBANKCARD_URl = "trade/bankDelete.do";

    // 获取收益
    public static final String GETPROFIT_URL = "profit.do";

    // 获取子商户
    public static final String GETSUBMERCH_URL = "theMerch.do";

    //获取收益列表
    public static final String GETPROFITLIST_URL = "profitDetail.do";
    //获取收益列表
    public static final String GETMERCHLEVEL_URL = "getMerchLevel.do";

    //获取banner列表
    public static final String GETBANNERLIST_URL = "home/getBannerPhotos.do";

    //获取banner列表
    public static final String GETWELCOMEPHOTOS_URL = "home/getWelcomePhotos.do";

    //获取随机养卡规划
    public static final String GETRANDOMPLANCARD_URL = "randomPlanCard.do";

    //新增养卡规划
    public static final String CREATEPLANCARD_URL = "createRepayment.do";

    //支付保证金
    public static final String PAYPLANCARD_URL = "payRepayment.do";

    //确认养卡规划
    public static final String CONFIRMPLANCARD_URL = "confirmRepayment.do";

    //快捷绑卡
    public static final String CGIBINDCARD_URL = "bindCard.do";

    //快捷绑卡确认
    public static final String CONFIRMBINDCARD_URL = "confirmBindCard.do";

    //查询养卡规划
    public static final String QUERYPLAN_URL = "queryPlan.do";

    //查询详细养卡规划
    public static final String QUERYPLANDETAIL_URL = "queryPlanDetail.do";

    //cgi快捷交易
    public static final String CGIQUICKPAY_URL = "cgiQuickPay.do";

    //h5快捷交易
    public static final String H5QUICKPAY_URL = "h5QuickPay.do";

    //代付交易
    public static final String WITHDRAW_URL = "withdraw.do";

    //开通卡规划
    public static final String OPENPLANCARD_URL = "openPlanCard.do";

    //修改结算卡
    public static final String MODIFIEDSETTLECARD_URL = "modifiedSettleCard.do";

    //修改信用卡
    public static final String MODIFIEDCREDITCARD_URL = "trade/modifiedCreditCard.do";

    //添加交易记录
    public static final String ADDRECORD_URL = "addRecord.do";

    //添加交易记录
    public static final String GETPREVIEWPLAN_URL = "getPreviewPlan.do";

    //获取推送消息
    public static final String GETPUSHMSG_URL = "getPushMsg.do";

    //获取贷款H5
    public static final String GETLOANSH5_URL = "getLoansH5.do";

    //获取信用卡H5
    public static final String GETCREDITH5_URL = "getCreditH5.do";

    public static final String APP_ID = "wx33707aaf76db1f7f";//微信appids


    // 消费、撤销错误码
    public static Map<String, String> errorCode = new HashMap<>();
    public static Map<String, String> serviceType = new HashMap<>();

    public static final String ZNXF = "00";//账内消费
    public static final String DF = "01";//代付
    public static final String KJZFH5 = "02";//快捷支付H5
    public static final String SSKKXG = "03";//实时扣款-香港
    public static final String WXZS = "04";//微信支付(正扫)
    public static final String ZFBZS = "05";//支付宝支付(正扫)
    public static final String DK = "06";//代扣
    public static final String SYSRZ = "07";//---
    public static final String VIP = "08";//vip购买
    public static final String TXGZHZF = "09";//腾讯公众号支付
    public static final String DDJGCX = "10";//订单结果查询
    public static final String WXGDEWM = "11";//微信固定二维码支付
    public static final String WXFS = "12";//微信支付(反扫)
    public static final String ZFBFS = "13";//支付宝支付(反扫)
    public static final String TIXIAN = "14";//提现
    public static final String SHZC = "15";//商户注册
    public static final String YRCX = "16";//商户余额查询
    public static final String WXAPPZF = "17";//微信APP支付
    public static final String SFZSB = "18";//API无卡(直清)
    public static final String WXZSH5 = "22";//微信正扫(H5)
    public static final String BANGKA = "23";//绑卡
    public static final String SMRZ = "24";//实名认证
    public static final String WKZF = "25";//快捷支付API
    public static final String YLEWMZS = "26";//银联二维码正扫
    public static final String YLEWMFS = "27";//银联二维码反扫
    public static final String DXYAMSQ = "28";//短信验证码申请
    public static final String WYB2C = "29";//网银B2C支付
    public static final String WGZF = "30";//网关支付
    public static final String XJCZ = "31";//现金充值
    public static final String WMZF = "33";//完美支付
    public static final String YLKJRWSQ = "34";//银联快捷入网申请
    public static final String YLKJDSQ = "35";//银联快捷短信申请
    public static final String YLKJZF = "36";//银联快捷支付
    public static final String ZNKK = "37";//帐内扣款
    public static final String ZNDJ = "38";//帐内冻结
    public static final String ZNJD = "39";//帐内解冻

    public static final String H5ZFB = "62";//H5支付（支付宝）
    public static final String H5WX = "63";//H5支付（微信）
    public static final String APIKJ = "64";//纯API快捷
    public static final String QQZS = "65";//QQ钱包支付（正扫）
    public static final String WXWAP = "66";//微信WAP
    public static final String ZFBWAP = "67";//支付宝WAP
    public static final String APIKJDXSQ = "68";//API快捷绑卡短信申请
    public static final String APIKJKQR = "69";//API快捷绑卡确认
    public static final String KGHQR = "70";//卡规划确认
    public static final String HK = "71";//还款
    public static final String HKXF = "72";//还款消费
    public static final String THBZJ = "73";//退还保证金
    public static final String SCHK = "74";//首次还款


    public static final String SYTIXIAN = "98";//收益提现


    static {
        serviceType.put("00", "1008");
        serviceType.put("01", "1006");
        serviceType.put("02", "3001");
        serviceType.put("03", "3003");
        serviceType.put("04", "3101");
        serviceType.put("05", "3201");
        serviceType.put("06", "3401");
        serviceType.put("07", "");
        serviceType.put("08", "3005");
        serviceType.put("09", "3103");
        serviceType.put("10", "4001");
        serviceType.put("11", "3203");
        serviceType.put("12", "3205");
        serviceType.put("13", "3107");
        serviceType.put("14", "1009");
        serviceType.put("15", "1101");
        serviceType.put("16", "1102");
        serviceType.put("17", "3301");
        serviceType.put("18", "1019");
        serviceType.put("22", "3207");
        serviceType.put("23", "1011");
        serviceType.put("24", "1013");
        serviceType.put("25", "1015");
        serviceType.put("26", "3303");
        serviceType.put("27", "3305");
        serviceType.put("28", "1017");
        serviceType.put("29", "1021");
        serviceType.put("30", "1023");
        serviceType.put("31", "1002");
        serviceType.put("32", "1025");
        serviceType.put("33", "4011");
        serviceType.put("34", "4013");
        serviceType.put("35", "4015");
        serviceType.put("36", "4017");
        serviceType.put("37", "1003");
        serviceType.put("38", "1027");
        serviceType.put("39", "1029");

        serviceType.put("62", "3501");
        serviceType.put("63", "3601");
        serviceType.put("64", "1031");
        serviceType.put("65", "3307");
        serviceType.put("66", "3503");
        serviceType.put("67", "3505");
        serviceType.put("68", "1033");
        serviceType.put("69", "1035");
        serviceType.put("70", "7001");
        serviceType.put("71", "7101");
        serviceType.put("72", "7201");
        serviceType.put("73", "7301");
        serviceType.put("74", "7401");

        serviceType.put("98", "1009");

    }

    static {
        errorCode.put("01", "请持卡人与发卡行联系");
        errorCode.put("02", "无效商户");
        errorCode.put("03", "无效商户");
        errorCode.put("04", "此卡被没收");
        errorCode.put("05", "持卡人认证失败");
        errorCode.put("06", "交易金额超限");
        errorCode.put("07", "暂时不能退货");
        errorCode.put("08", "请与银行联系");
        errorCode.put("09", "撤销只允许当日操作");
        errorCode.put("10", "无参数需下载");
        errorCode.put("11", "此为 VIP 客户");
        errorCode.put("12", "无效交易");
        errorCode.put("13", "无效金额");
        errorCode.put("14", "无效卡号");
        errorCode.put("15", "此卡无对应发卡行");
        errorCode.put("16", "更新第三磁道");
        errorCode.put("17", "挂失卡");
        errorCode.put("18", "被窃卡");
        errorCode.put("19", "请重做交易");
        errorCode.put("20", "过期卡");
        errorCode.put("21", "该卡未初始化或睡眠卡");
        errorCode.put("22", "操作有误，或超出交易允许天数");
        errorCode.put("23", "非法交易");
        errorCode.put("24", "有作弊嫌疑");
        errorCode.put("25", "原交易不存在或已冲正");
        errorCode.put("26", "重复交易");
        errorCode.put("27", "没收卡");
        errorCode.put("28", "交易无法处理");
        errorCode.put("29", "File Update Denied");
        errorCode.put("30", "格式错误");
        errorCode.put("31", "交易拒绝");
        errorCode.put("32", "卡已作废");
        errorCode.put("33", "过期卡");
        errorCode.put("34", "作弊卡，吞卡");
        errorCode.put("35", "联系保安(没收卡)");
        errorCode.put("36", "不匹配的交易");
        errorCode.put("37", "联系卡中心(没收卡)");
        errorCode.put("38", "密码错误次数超限，请与发卡行联系");
        errorCode.put("39", "无此账户");
        errorCode.put("40", "发卡方不支持的交易");
        errorCode.put("41", "挂失卡(没收卡)");
        errorCode.put("42", "不批准交易");
        errorCode.put("43", "被窃卡(没收卡)");
        errorCode.put("44", "不做任何处理");
        errorCode.put("45", "请插入芯片卡");
        errorCode.put("46", "拨号电话非法");
        errorCode.put("47", "退货金额超限");
        errorCode.put("48", "当日不许退货");
        errorCode.put("49", "30 天内退货");
        errorCode.put("50", "金额超限");
        errorCode.put("51", "可用余额不足");
        errorCode.put("52", "格式错误");
        errorCode.put("53", "没收卡，请与发卡行联系");
        errorCode.put("54", "该卡已过期");
        errorCode.put("55", "密码错");
        errorCode.put("56", "无此卡记录");
        errorCode.put("57", "不允许进行此交易");
        errorCode.put("58", "不允许该卡在本终端进行此交易");
        errorCode.put("59", "卡片校验错，CVN 验证失败");
        errorCode.put("60", "请与银行联系");
        errorCode.put("61", "交易金额超限");
        errorCode.put("62", "受限制的卡");
        errorCode.put("63", "违反安全保密规定");
        errorCode.put("64", "原交易信息不匹配");
        errorCode.put("65", "超出取款次数限制");
        errorCode.put("66", "持卡人身份信息或手机号输入不正确，验证失败");
        errorCode.put("67", "没收卡");
        errorCode.put("68", "交易超时，请重试");
        errorCode.put("69", "发卡方状态不正常，请稍后重试");
        errorCode.put("70", "发卡方线路异常，请稍后重试");
        errorCode.put("71", "交换中心异常，请稍后重试");
        errorCode.put("72", "终端号未登记");
        errorCode.put("73", "请先签到");
        errorCode.put("74", "请联系收单机构手工退货");
        errorCode.put("75", "密码错误次数超限");
        errorCode.put("76", "上批未结，请先结完上批");
        errorCode.put("77", "长时间未做结算导致，账目没有问题");
        errorCode.put("78", "止付卡");
        errorCode.put("79", "非法帐户");
        errorCode.put("80", "交易拒绝");
        errorCode.put("81", "卡已作废");
        errorCode.put("82", "无效卡号");
        errorCode.put("84", "联网暂断,重做交易");
        errorCode.put("87", "密码密钥同步错");
        errorCode.put("88", "MAC 密钥同步错");
        errorCode.put("90", "系统日切，请稍后重试");
        errorCode.put("91", "发卡方状态不正常，请稍后重试");
        errorCode.put("92", "发卡方线路异常，请稍后重试");
        errorCode.put("94", "拒绝/重复交易，请稍后重试");
        errorCode.put("95", "结算不平,上送交易");
        errorCode.put("97", "终端号未登记");
        errorCode.put("98", "发卡方超时");
        errorCode.put("99", "PIN 格式错，请重新签到");
        errorCode.put("A0", "MAC 校验错，请重新签到");
        errorCode.put("A7", "安全处理失败");
        errorCode.put("D8", "未成功");
        errorCode.put("Z1", "该功能暂未开通");
        errorCode.put("Z2", "系统不支持该功能");
        errorCode.put("E1", "用户号码无效");
        errorCode.put("E2", "支付号码无效");
        errorCode.put("E3", "费用已缴");
        errorCode.put("E4", "单笔交易金额超限");
        errorCode.put("E5", "日累计金额超限");
        errorCode.put("E6", "风险卡账户，请联系发卡行");
        errorCode.put("E7", "交易次数超限");
        errorCode.put("E8", "受理方状态异常，请联系 pos 中心");
        errorCode.put("F3", "无效的行业商户");
        errorCode.put("F4", "行业商户状态异常");
        errorCode.put("F5", "行业商户状态超时");
        errorCode.put("F6", "无效的交易币种");
        errorCode.put("F7", "无效的交易发起方");
        errorCode.put("F8", "交易发起方状态异常");
        errorCode.put("G1", "无此交易类型");
        errorCode.put("G2", "无此厂商");
        errorCode.put("G3", "无此终端型号");
        errorCode.put("G4", "无此终端序列号");
        errorCode.put("H3", "接入方代码不匹配");
        errorCode.put("H4", "无效的行业机构");
        errorCode.put("Q2", "有效期错");
        errorCode.put("SK", "无效卡校验");
        errorCode.put("R6", "请插入芯片卡");
        errorCode.put("Z8", "不支持该卡种");
    }
}
