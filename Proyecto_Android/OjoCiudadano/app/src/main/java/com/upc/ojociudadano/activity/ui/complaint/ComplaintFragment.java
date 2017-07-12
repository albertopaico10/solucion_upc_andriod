package com.upc.ojociudadano.activity.ui.complaint;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by apaico on 08/09/16.
 */
public class ComplaintFragment extends BaseFragment {
    @Bind(R.id.tv_url_web_page)TextView tvUrlWebPage;

    public ComplaintFragment() {
    }

    public static ComplaintFragment newInstance() {
        Bundle args = new Bundle();
        ComplaintFragment fragment = new ComplaintFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_complaint, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    private void initUI() {
        tvUrlWebPage.setPaintFlags(tvUrlWebPage.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }


    @Override
    public String getTitle(){
        return getString(R.string.title_my_complaint);
    }

    @Override
    public boolean showBack(){
        return true;
    }

    @OnClick(R.id.tv_url_web_page)
    public void redirectWebPage(){
        Intent viewIntent = new Intent("android.intent.action.VIEW",Uri.parse(getString(R.string.url_web_page)));
        startActivity(viewIntent);
    }
}
