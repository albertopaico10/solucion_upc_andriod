package com.upc.ojociudadano.activity.ui.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseFragment;
import com.upc.ojociudadano.activity.ui.messages.SuccessAccountFragment;
import com.upc.ojociudadano.activity.ui.recomendation.RecomendationFragment;
import com.upc.ojociudadano.activity.ui.register.RegisterComplaintFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by apaico on 09/09/16.
 */
public class AccountFragment extends BaseFragment {
    @Bind(R.id.id_change_pwd)CheckBox idChangePwd;
    @Bind(R.id.et_password)EditText etPassword;
    @Bind(R.id.et_password_confirm)EditText etPasswordConfirm;
    public AccountFragment() {
    }

    public static AccountFragment newInstance() {
        Bundle args = new Bundle();
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_update);
    }

    @Override
    public boolean showBack(){
        return true;
    }

    @OnClick(R.id.id_change_pwd)
    public void visiblePassword(){
        if(idChangePwd.isChecked()){
            etPassword.setVisibility(View.VISIBLE);
            etPasswordConfirm.setVisibility(View.VISIBLE);
        }
        else{
            etPassword.setVisibility(View.GONE);
            etPasswordConfirm.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_update_customer)
    public void updateCustomer(){
        mInteractionListener.replaceFragmentPrivate(SuccessAccountFragment.newInstance(), true);
    }
}
