package com.efly.flyhelper.ui.toolbarTest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ccj.base.base.BaseActivity;
import com.efly.flyhelper.R;
import com.efly.flyhelper.ui.test.TestActivity;

/**
 * Created by Administrator on 2017/12/29.
 */

public class ToolBarTestActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_toolbar_test);
        setTitle("ToolBarTest");

        setToolBarMenuOnclick(new mainToolBarMenuClick());

        ab=getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(ToolBarTestActivity.this,"home",Toast.LENGTH_LONG).show();
                        break;
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
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
                    Toast.makeText(mContext, "消息1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_message2:
                    Toast.makeText(mContext, "消息2", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.action_message3:
                    Toast.makeText(mContext, "消息3", Toast.LENGTH_SHORT).show();
                    break;

            }
            return false;
        }
    }

}
