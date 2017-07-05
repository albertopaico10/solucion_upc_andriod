package com.upc.ojociudadano.activity.ui.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.common.BaseFragment;
import com.upc.ojociudadano.activity.ui.messages.SuccessComplaintFragment;

/**
 * Created by apaico on 02/09/16.
 */
public class RegisterComplaintFragment extends BaseFragment {

    public RegisterComplaintFragment() {
    }

    public static RegisterComplaintFragment newInstance() {
        Bundle args = new Bundle();
        RegisterComplaintFragment fragment = new RegisterComplaintFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_complete_complaint);
    }

    @Override
    public boolean showBack(){
        return true;
    }

    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_register_complaint, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_continue, menu);
        MenuItem item = menu.findItem(R.id.menu_item_next);
        item.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_finish:
                mInteractionListener.replaceFragmentPrivate(SuccessComplaintFragment.newInstance(), true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
