package com.lys.base.api;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 调用后台的接口,架构网络层采用Retroft+Rxjava+gson
 * Created by ccj on 2016/7/1.
 *
 */
public class APIService {

    private static final String TAG = "APIService";
    public static final String URL_HOST = "http://123.234.82.23";//服务器端口

    //get请求
    public static final String URL_GANK_IO = "http://gank.io";//gank.io 中的妹子API


    private static APIService apiService;

    //单例
    public static APIService getIntance(){
        if (apiService==null){
            synchronized (APIService.class){
                if(apiService==null){
                    apiService=new APIService();
                }
            }
        }

        return apiService;
    }


    /**
     * 基础地址
     * 初始化 retroft
     */
    protected static final Retrofit getsRetrofit(){
        OkHttpClient client=new OkHttpClient.Builder()
                //添加应用拦截器
//                .addInterceptor(new MyOkhttpInterceptor())
        //添加网络拦截器
//                .addNetworkInterceptor(new MyOkhttpInterceptor())
        .build();

        Retrofit sRetrofit=new Retrofit.Builder()
                .baseUrl(URL_GANK_IO != null ? URL_HOST : URL_GANK_IO)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
                .build();

        return  sRetrofit;

    }



    /**
     * 基础地址
     * 初始化 retroft
     */
    protected static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(URL_GANK_IO != null ? URL_HOST : URL_GANK_IO)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

//    protected static final RetrofitRequest apiManager = sRetrofit.create(RetrofitRequest.class);

    /**********************仿照上面的方法,进行请求数据****************************/

}
