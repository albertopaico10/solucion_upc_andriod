package com.upc.ojociudadano.activity.common;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.upc.ojociudadano.activity.R;

/**
 * Created by apaico on 26/08/16.
 */
public class FragmentManagerHelper {
    private FragmentManager mFragmentManager;

    public FragmentManagerHelper(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    public void replace(Fragment fragment, boolean addToBackStack) {
        replace(R.id.flContent, fragment, addToBackStack);
    }

    public void replacePrivate(Fragment fragment, boolean addToBackStack) {
        replace(R.id.fl_content_private, fragment, addToBackStack);
    }

    public void replace(@IdRes int containerId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction replaceTransaction = mFragmentManager.beginTransaction();
        replaceTransaction.replace(containerId, fragment, fragment.getClass().getName());
        if (addToBackStack) {
            replaceTransaction.addToBackStack(fragment.getClass().getName());
        }
        replaceTransaction.commit();
    }
}
