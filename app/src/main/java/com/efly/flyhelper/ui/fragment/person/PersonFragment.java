package com.efly.flyhelper.ui.fragment.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ccj.base.base.BaseFragment;
import com.efly.flyhelper.R;

/**
 * Created by Administrator on 2016/7/7.
 */

public class PersonFragment extends BaseFragment<PersonContract.presenter> implements PersonContract.View {



    private View view;
    private static final String TAG = PersonFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_person, null);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void initView() {

    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.hide();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(),error+"",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showData(String data) {

    }
}
