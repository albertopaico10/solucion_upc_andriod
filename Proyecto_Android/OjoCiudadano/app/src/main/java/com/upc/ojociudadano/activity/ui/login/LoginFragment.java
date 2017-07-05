package com.upc.ojociudadano.activity.ui.login;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseFragment;
import com.upc.ojociudadano.activity.ui.home.HomeActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by apaico on 26/08/16.
 */
public class LoginFragment extends BaseFragment {

    @Bind(R.id.tv_create_account)TextView tvCreateAccount;
    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_login);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    private void initUI() {
        tvCreateAccount.setPaintFlags(tvCreateAccount.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }


    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=true;
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @OnClick(R.id.btn_login)
    public void login(){
        startActivity(HomeActivity.makeIntent(getContext()));
    }

    @OnClick(R.id.tv_create_account)
    public void registerAccount(){
        Toast.makeText(getContext(),"Pending Creation",Toast.LENGTH_LONG).show();
    }
}
