package com.upc.ojociudadano.activity.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseFragment;
import com.upc.ojociudadano.activity.ui.messages.WelcomeUserFragment;

import butterknife.OnClick;

/**
 * Created by apaico on 01/09/16.
 */
public class RegisterFragment extends BaseFragment {

    public RegisterFragment() {
    }

    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean showBack(){
        return true;
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_register);
    }

    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=true;
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @OnClick(R.id.btn_register)
    public void sendRegister(){
        mInteractionListener.replaceFragment(WelcomeUserFragment.newInstance(), true);
    }
}
