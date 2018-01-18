package com.efly.flyhelper.ui.fragment.home;

import com.lys.base.base.BasePresenter;
import com.lys.base.base.BaseView;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/25.
 */

public class  HomeContract {

    interface View extends BaseView{
        void showProgress();
        void hideProgress();
        void showData(String getIpInfoResponse);
        void showErr(String error);
        void setListener();
    }

    interface Presenter extends BasePresenter{
        void loadData();
        void postData(HashMap params);
    }

    interface Model{

    }

}
