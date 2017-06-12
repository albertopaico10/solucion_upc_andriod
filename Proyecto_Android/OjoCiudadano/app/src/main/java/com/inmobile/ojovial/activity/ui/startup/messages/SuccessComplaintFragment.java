package com.inmobile.ojovial.activity.ui.startup.messages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inmobile.ojovial.activity.R;
import com.inmobile.ojovial.activity.common.BaseFragment;
import com.inmobile.ojovial.activity.ui.startup.home.HomeActivity;

import butterknife.OnClick;

/**
 * Created by apaico on 02/09/16.
 */
public class SuccessComplaintFragment extends BaseFragment {

    public SuccessComplaintFragment() {
    }

    public static SuccessComplaintFragment newInstance() {
        Bundle args = new Bundle();
        SuccessComplaintFragment fragment = new SuccessComplaintFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_success_complaint, container, false);
    }

    @OnClick(R.id.ok_button)
    public void returnMenuPrincipal(){
        startActivity(HomeActivity.makeIntent(getContext()));
    }
}
