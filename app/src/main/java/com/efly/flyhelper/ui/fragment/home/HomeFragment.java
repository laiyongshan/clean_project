package com.efly.flyhelper.ui.fragment.home;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lys.base.Constants;
import com.lys.base.base.BaseApplication;
import com.lys.base.base.BaseFragment;
import com.lys.base.utils.DialogCreator;
import com.lys.base.utils.router.RouterConstants;
import com.efly.flyhelper.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/7/7.
 */
public class HomeFragment extends BaseFragment implements HomeContract.View,View.OnClickListener{

    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.tv_show)
    TextView tvShow;
    private View view;
    private static final String TAG = HomeFragment.class.getSimpleName();

    private HomePresenter mHomePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_message, null);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mHomePresenter==null){
            mHomePresenter = new HomePresenter(this);
            mHomePresenter.start();

        }
    }

    class mycl implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(d!=null)
                d.dismiss();
        }
    }


    Dialog d;

    @OnClick({R.id.button2, R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                navigateToLogin();
//                TDeviceUtils.showSystemShareOption(getActivity(),"分享测试","http:www.yeohe.com");
//                DialogCreator.createLoadingDialog(getActivity(),"提交中.......").show();
                d=DialogCreator.createBaseCustomDialog(getActivity(), "提示", "创建一个新的Dialog",new mycl());
                d.show();
                break;
            case R.id.button3:
                navigateTakePhoto();
                mHomePresenter.postData(new HashMap());//提交数据
                break;

            case R.id.tv_show:
                Toast.makeText(getActivity(),tvShow.getText().toString().trim(),Toast.LENGTH_LONG).show();
                break;
        }
    }


    private void navigateToLogin() {
        ARouter.getInstance().build(RouterConstants.LOGIN_MOUDLE_ACTIVITY).
                withString(Constants.START_LOGIN_WITH_PARAMS, "I am params from MainActivity").greenChannel().
                navigation(getActivity(), Constants.REQUEST_START_LOGIN);
    }

    private void navigateTakePhoto() {
        ARouter.getInstance().
                build(RouterConstants.VIDEO_MUDULE_ACTIVITY,RouterConstants.VIDEO_MODULE_NAME).
                withString(Constants.START_LOGIN_WITH_PARAMS, "I am params from MainActivity").
                navigation(getActivity(), new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {

                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Toast.makeText(getActivity(), "没有目标Activity", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onArrival(Postcard postcard) {

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Toast.makeText(getActivity(), "已被拦截", Toast.LENGTH_SHORT).show();
                    }
                });

    }


    @Override
    public void initView() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_START_LOGIN) {

            if (data == null) {
                return;
            }
            String str = data.getStringExtra(Constants.PARAMS_RESULT_FROM_LOGIN);

            if (str == null) {
                return;
            }

            tvShow.setText(str);
            BaseApplication.showToast(str);
        }
    }


    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void showData(String getIpInfoResponse) {
        tvShow.setText(getIpInfoResponse);
    }

    @Override
    public void showErr(String error) {
        BaseApplication.showShortToast(error);
    }


    @Override
    public void setListener() {
        tvShow.setOnClickListener(this);
    }


}
