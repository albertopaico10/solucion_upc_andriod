package com.upc.ojociudadano.activity.ui.complaint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseActivity;
import com.upc.ojociudadano.activity.ui.register.PhotoFragment;

/**
 * Created by apaico on 08/09/16.
 */
public class ComplaintActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_private_main);
        if (savedInstanceState == null){
            replaceFragmentPrivate(ComplaintFragment.newInstance(), false);
        }
    }

    public static Intent makeIntent(Context context){
        Intent intent = new Intent(context, ComplaintActivity.class);
        return intent;
    }
}
