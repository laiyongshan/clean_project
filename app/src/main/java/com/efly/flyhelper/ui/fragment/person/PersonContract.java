package com.efly.flyhelper.ui.fragment.person;

import com.lys.base.base.BaseModel;
import com.lys.base.base.BasePresenter;
import com.lys.base.base.BaseView;

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
