package com.efly.flyhelper.ui.test;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ccj.base.base.BaseActivity;
import com.efly.flyhelper.R;

/**
 * Created by Administrator on 2017/12/18.
 */

public class TestActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_test);
        setToolBarMenuOnclick(new mainToolBarMenuClick());
        setTitle("BaseActivityTest");
        setBackArrow();
    }


    class mainToolBarMenuClick implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_refresh:
                    Toast.makeText(mContext, "refresh", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_message:
                    Toast.makeText(mContext, "message", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.action_message1:
                    Toast.makeText(mContext, "消息", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

}
