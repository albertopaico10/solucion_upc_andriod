package com.inmobile.ojovial.activity.ui.startup.messages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inmobile.ojovial.activity.R;
import com.inmobile.ojovial.activity.common.BaseFragment;
import com.inmobile.ojovial.activity.ui.startup.login.LoginFragment;

import butterknife.OnClick;

/**
 * Created by apaico on 02/09/16.
 */
public class WelcomeUserFragment extends BaseFragment {

    public WelcomeUserFragment() {
    }

    public static WelcomeUserFragment newInstance() {
        Bundle args = new Bundle();
        WelcomeUserFragment fragment = new WelcomeUserFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=true;
        return inflater.inflate(R.layout.fragment_welcome_user, container, false);
    }

    @OnClick(R.id.ok_button)
    public void redirectLogin(){
        mInteractionListener.replaceFragment(LoginFragment.newInstance(), true);
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_1_welcome);
    }

}
