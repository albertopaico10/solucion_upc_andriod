package com.upc.ojociudadano.activity.ui.recomendation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseFragment;

/**
 * Created by apaico on 08/09/16.
 */
public class RecomendationFragment extends BaseFragment {

    public RecomendationFragment() {
    }

    public static RecomendationFragment newInstance() {
        Bundle args = new Bundle();
        RecomendationFragment fragment = new RecomendationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_recomendation, container, false);
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_recommendation);
    }

    @Override
    public boolean showBack(){
        return true;
    }
}
