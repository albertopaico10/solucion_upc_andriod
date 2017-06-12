package com.inmobile.ojovial.activity.common;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by apaico on 26/08/16.
 */
public abstract class BaseFragment extends Fragment {
    protected InteractionListener mInteractionListener;
    static final int REQUEST_IMAGE_CAPTURE_PERMISSION = 0;
    protected static boolean sIsPublic =true;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InteractionListener) {
            mInteractionListener = (InteractionListener) context;
        } else {
            throw new RuntimeException("Context should implements InteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = onCreateViewCalled(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        mInteractionListener.updateTitle(getTitle().toUpperCase(), showBack(), sIsPublic);
        return rootView;
    }

    public String getTitle() {
        return "";
    }
    public boolean showBack() {
        return false;
    }

    protected abstract View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected void checkCameraPermissions(){
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){ //||
            requestPermissions(new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, REQUEST_IMAGE_CAPTURE_PERMISSION);
        } else {
            cameraPermissionGranted();
        }
    }

    protected void cameraPermissionGranted(){
    }

    public interface InteractionListener {
        void replaceFragment(Fragment fragment, boolean addToBackStack);
        void replaceFragmentPrivate(Fragment fragment, boolean addToBackStack);
        void updateTitle(String title, boolean showBack,boolean isPublic);
    }

}
