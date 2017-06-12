package com.inmobile.ojovial.activity.ui.startup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.inmobile.ojovial.activity.R;
import com.inmobile.ojovial.activity.common.BaseActivity;
import com.inmobile.ojovial.activity.ui.startup.login.LoginFragment;

/**
 * Created by apaico on 26/08/16.
 */
public class PublicActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_public_main);
        if (savedInstanceState == null){
            replaceFragment(LoginFragment.newInstance(), false);
        }
    }

    public static Intent makeIntent(Context context){
        Intent intent = new Intent(context, PublicActivity.class);
        return intent;
    }

}
