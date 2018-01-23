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
    
    // 消费、撤销错误码
    public static Map<String, String> errorCode = new HashMap<>();
    public static Map<String, String> serviceType = new HashMap<>();


}
