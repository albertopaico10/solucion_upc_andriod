package com.upc.ojociudadano.activity.ui.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseActivity;

/**
 * Created by apaico on 02/09/16.
 */
public class RegisterComplaintActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_private_main);
        if (savedInstanceState == null){
            replaceFragmentPrivate(PhotoFragment.newInstance(), false);
        }
    }

    public static Intent makeIntent(Context context){
        Intent intent = new Intent(context, RegisterComplaintActivity.class);
        return intent;
    }
}
