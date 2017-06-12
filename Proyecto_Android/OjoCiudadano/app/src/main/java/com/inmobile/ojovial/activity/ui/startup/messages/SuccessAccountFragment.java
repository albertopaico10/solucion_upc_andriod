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
 * Created by apaico on 09/09/16.
 */
public class SuccessAccountFragment extends BaseFragment {

    public SuccessAccountFragment() {
    }

    public static SuccessAccountFragment newInstance() {
        Bundle args = new Bundle();
        SuccessAccountFragment fragment = new SuccessAccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_update);
    }

    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_update_user, container, false);
    }

    @OnClick(R.id.id_update_customer)
    public void returnMenuPrincipal(){
        startActivity(HomeActivity.makeIntent(getContext()));
    }
}
