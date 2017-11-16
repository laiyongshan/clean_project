package com.efly.flyhelper.ui.fragment.person;

import com.ccj.base.base.BaseModel;
import com.ccj.base.base.BasePresenter;
import com.ccj.base.base.BaseView;

/**
 * Created by Administrator on 2017/11/16.
 */

public class PersonContract {

    interface View extends BaseView{
        void showProgress();
        void hideProgress();
        void showError(String error);
        void showData(String data);
    }

    interface presenter extends BasePresenter{
        void loadData(int page);
    }

    interface Model extends BaseModel{

    }

}
