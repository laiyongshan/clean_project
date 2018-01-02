package com.efly.flyhelper.ui.main;


import com.lys.base.base.BasePresenter;
import com.lys.base.base.BaseView;

/**
 * Created by Administrator on 2016/7/7.
 */
public interface MainContract  {

    interface View extends BaseView {
        void initToolBar();
        void initTabHost();
    }

    interface Presenter extends BasePresenter {

    }


}
