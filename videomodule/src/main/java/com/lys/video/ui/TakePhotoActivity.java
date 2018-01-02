package com.lys.video.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lys.base.base.BaseActivity;
import com.lys.base.base.Constants;
import com.lys.base.utils.TLog;
import com.lys.base.utils.router.LoginModuleService;
import com.lys.base.utils.router.RouterConstants;
import com.lys.base.utils.router.RouterUtils;
import com.lys.video.R;
import com.lys.video.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/7/8.
 */
@Route(path= RouterConstants.VIDEO_MUDULE_ACTIVITY,group = RouterConstants.VIDEO_MODULE_NAME)
public class TakePhotoActivity extends BaseActivity<TakePhotoContract.Presenter> implements TakePhotoContract.View {
    @BindView(R2.id.imageView)
    ImageView imageView;
    @BindView(R2.id.button)
    Button button;

    @Autowired
    LoginModuleService loginModuleService;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        ButterKnife.bind(this);
        RouterUtils.inject(this);

        mPresenter = new TakePhotoPresenter(this);
        mPresenter.start();
    }



    @OnClick(R2.id.button)
    public void onClick(View v) {
        if (v.getId()==R.id.button){
            takePhoto();
        }
    }




    private void takePhoto() {
        if (loginModuleService.checkLoginState()){ //模拟模块间通信,调用登录服务:如果登录就开始下一步.
            startTakePhoto();
        }else {
            Toast.makeText(this,"请登录",Toast.LENGTH_SHORT).show();
        }
    }

    private void startTakePhoto() {
        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picture, Constants.IMAGES_ACTIVITY_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Constants.IMAGES_ACTIVITY_REQUEST_CODE == requestCode) {
            if (resultCode == RESULT_OK) {
                TLog.log(data.getData().toString());
                Log.e("Tlog","data-->"+data.getData().toString());
                mPresenter.savePhoto(data);
            }
        }

    }


    @Override
    public void initView() {

    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }
    //WindowLeaked
    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showBitmap(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }


}
