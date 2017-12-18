package com.efly.flyhelper.ui.test;

/**
 * Created by Administrator on 2017/12/18.
 */

public class TestPresenter implements TestContract.Presenter{

    private TestContract.View mView;

    private TestPresenter(TestContract.View mView){
        this.mView=mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }
}
