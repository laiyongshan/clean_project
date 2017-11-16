package com.efly.flyhelper.ui.fragment.person;

import com.efly.flyhelper.api.MainAPIServiceImp;
import com.efly.flyhelper.bean.GankBean;
import com.efly.flyhelper.ui.fragment.person.PersonContract.presenter;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/11/16.
 */

public class PersonPresenter implements presenter{

    private PersonContract.View view;

    public PersonPresenter(PersonContract.View view){
        this.view=view;
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadData(int page) {

        view.showProgress();
        Observable<GankBean>  gankBeanObservable= MainAPIServiceImp.getGankBean(page);

        gankBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GankBean>() {
                    @Override
                    public void onCompleted() {
                        view.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.hideProgress();
                    }

                    @Override
                    public void onNext(GankBean gankBean) {
                        if (gankBean.getError()==false){
                            view.showError("请求错误");
                        }else{
                            view.showData(gankBean.toString());
                        }
                    }
                });
    }
}
