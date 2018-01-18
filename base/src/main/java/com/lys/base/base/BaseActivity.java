package com.lys.base.base;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lys.base.AppManager;
import com.lys.base.R;
import com.lys.base.utils.DialogCreator;
import com.lys.base.utils.KnifeKit;

import java.util.List;


/**
 * base 来进行 toolbar dialog 初始化,activity栈的添加,删除等
 * Created by ccj on 2016/7/5.
 */
public class BaseActivity<T extends BasePresenter>
        extends AppCompatActivity implements BaseView {

    private static final String TAG = "BaseActivity";
    public T mPresenter;
    protected Dialog progressDialog;
    protected Toolbar toolbar;
    protected ActionBar ab;
    protected Context mContext;
    private int fragmentIndex = 0;


    /**
     * 通用的ToolBar标题
     */
    private TextView commonTitleTv;
    /**
     * 通用的ToolBar
     */
    private Toolbar commonTitleTb;
    /**
     * 内容区域
     */
    private RelativeLayout content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        initDialog();
        initView();
        setSupportActionBar(commonTitleTb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.tool_bar_white));
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Toolbar getToolbar() {
        return toolbar;
    }


    /**
     * 资源释放
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    private void initDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage(getResources().getString(R.string.show_loading_msg));
        progressDialog= DialogCreator.createLoadingDialog(this,"Loading.....");
    }

    public void showLoading() {
        progressDialog.show();
    }

    public void dismissLoading() {
        progressDialog.dismiss();
    }


    @Override
    public void initView() {
        commonTitleTv = (TextView) findViewById(R.id.common_title_tv);
        commonTitleTb = (Toolbar) findViewById(R.id.common_title_tb);
        content = (RelativeLayout) findViewById(R.id.content);
    }

    /**
     * 子类调用，重新设置Toolbar
     *
     * @param layout
     */
    public void setToolBar(int layout) {
        hidetoolBar();
        commonTitleTb = (Toolbar) content.findViewById(layout);
        setSupportActionBar(commonTitleTb);
        //设置actionBar的标题是否显示，对应ActionBar.DISPLAY_SHOW_TITLE。
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * 隐藏ToolBar，通过setToolBar重新定制ToolBar
     */
    public void hidetoolBar() {
        commonTitleTb.setVisibility(View.GONE);
    }

    /**
     * menu的点击事件
     *
     * @param onclick
     */
    public void setToolBarMenuOnclick(Toolbar.OnMenuItemClickListener onclick) {
        commonTitleTb.setOnMenuItemClickListener(onclick);
    }


    /**
     * 设置左上角back按钮
     */
    public void setBackArrow() {
        final Drawable upArrow = getResources().getDrawable(R.mipmap.common_back_ic);
        //给ToolBar设置左侧的图标
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置返回按钮的点击事件
        commonTitleTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置toolbar下面内容区域的内容
     *
     * @param layoutId
     */
    public void setContentLayout(int layoutId) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(layoutId, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        content.addView(contentView, params);

        bindUI(null);
    }


    public void bindUI(View rootView) {
        KnifeKit.bind(this);
    }


    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            commonTitleTv.setText(title);
        }
    }


    /**
     * 设置标题
     *
     * @param resId
     */
    public void setTitle(int resId) {
        commonTitleTv.setText(resId);
    }



    /**
     * 解决fragment onActivityResult不调用
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @SuppressLint("RestrictedApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager fm = getSupportFragmentManager();
        //if (index != 0) {
        if (fm.getFragments() == null) {
            Log.w(TAG, "Activity result fragment fragmentIndex out of range: 0x"
                    + Integer.toHexString(requestCode));
            return;
        }
        for (int i = 0; i <fm.getFragments().size() ; i++) {
            Fragment frag = fm.getFragments().get(i);
            if (frag == null) {
                Log.w(TAG, "Activity result no fragment exists for fragmentIndex: 0x"
                        + Integer.toHexString(requestCode));
            } else {
                handleResult(frag, requestCode, resultCode, data);
            }
        }
        return;
        //}

    }

    /**
     * 递归调用，对所有子Fragement生效
     *
     * @param frag
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }
}
