package com.inmobile.ojovial.activity.ui.startup.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inmobile.ojovial.activity.R;
import com.inmobile.ojovial.activity.common.BaseFragment;

/**
 * Created by apaico on 01/09/16.
 */
public class IntroFragment extends BaseFragment {

    public IntroFragment() {
    }

    public static IntroFragment newInstance() {
        Bundle args = new Bundle();
        IntroFragment fragment = new IntroFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }
}
