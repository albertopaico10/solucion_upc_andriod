package com.upc.ojociudadano.activity.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.upc.ojociudadano.activity.R;
import com.upc.ojociudadano.activity.ui.field.PhotoField;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by apaico on 07/09/16.
 */
public class PhotoFieldAdapter  extends RecyclerView.Adapter<PhotoFieldAdapter.PhotoViewHolder>{
    private List<PhotoField> mPhotoList;
    private PhotoListener mPhotoListener;

    public PhotoFieldAdapter(List<PhotoField> photoList) {
        this.mPhotoList = photoList;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_photo_field, parent, false);
        return new PhotoViewHolder(itemView,mPhotoListener);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder,final int position) {
        PhotoField photoField = mPhotoList.get(position);
        holder.ibTakePhotoN.setBackgroundResource(photoField.getImageButton());
        holder.ivPhotoN.setImageBitmap(photoField.getImageView());
    }

    public void setPhotoListener(PhotoListener photoListener){
        mPhotoListener = photoListener;
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.btn_take_photo_n)ImageButton ibTakePhotoN;
        @Bind(R.id.iv_photo_n)ImageView ivPhotoN;

        public PhotoViewHolder(View itemView,PhotoListener photoListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mPhotoListener=photoListener;
        }

        @OnClick(R.id.btn_take_photo_n)
        public void takePicture(){
            if (mPhotoListener != null) {
                mPhotoListener.photoFieldSelected(getAdapterPosition());
            }
        }
    }

    public void update(List<PhotoField> photoField){
        if (photoField!=null){
            mPhotoList.clear();
            mPhotoList.addAll(photoField);
            notifyDataSetChanged();
        }
    }

    public void insert(PhotoField photoField,int position){
        if (photoField!=null){
            mPhotoList.remove(position);
            mPhotoList.add(position,photoField);
            notifyDataSetChanged();
        }
    }

    public interface PhotoListener{
        void photoFieldSelected(int position);

    }
}
