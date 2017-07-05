package com.upc.ojociudadano.activity.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseActivity;
import com.upc.ojociudadano.activity.ui.complaint.ComplaintFragment;

/**
 * Created by apaico on 09/09/16.
 */
public class AccountActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_private_main);
        if (savedInstanceState == null){
            replaceFragmentPrivate(AccountFragment.newInstance(), false);
        }
    }

    public static Intent makeIntent(Context context){
        Intent intent = new Intent(context, AccountActivity.class);
        return intent;
    }
}
