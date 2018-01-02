package com.efly.flyhelper.ui.fragment.home;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/8/25.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View view;
    private String baiduData;

    public HomePresenter(HomeContract.View view){
        this.view=view;
    }

    @Override
    public void start() {
        view.initView();
        view.setListener();
        loadData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadData() {
//        Observable<String> userObservable = MainAPIServiceImp.getData();
//
//
//        userObservable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        view.hideProgress();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        TLog.log(e.getMessage().toString());
//                        view.hideProgress();
//                    }
//
//                    @Override
//                    public void onNext(String getIpInfoResponse) {
////                        ArrayList<Meizhi.ResultsBean> meiZhiTemp = (ArrayList<Meizhi.ResultsBean>) getIpInfoResponse.results;
////                        if (getIpInfoResponse.error==true){
////                            view.showErr("请求错误");
////                        }
//                        view.showData(getIpInfoResponse);
//                    }
//                });


        OkHttpUtils.get().url("http://www.baidu.com").id(100).build().execute(new StringCallback() {

            @Override
            public void onBefore(Request request, int id){
                view.showProgress();
            }

            @Override
            public void onAfter(int id)
            {
                view.hideProgress();
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
                view.showData("onError:" + e.getMessage());
                view.hideProgress();
            }

            @Override
            public void onResponse(String response, int id) {
                view.showData("" + response.toString());
            }
        });

    }

    @Override
    public void postData(HashMap params) {
        view.showData("提交数据："+"Oye"+params.size());
    }
}
