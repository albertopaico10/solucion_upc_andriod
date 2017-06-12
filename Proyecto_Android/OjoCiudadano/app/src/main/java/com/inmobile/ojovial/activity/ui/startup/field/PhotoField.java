package com.inmobile.ojovial.activity.ui.startup.field;

import android.graphics.Bitmap;

/**
 * Created by apaico on 07/09/16.
 */
public class PhotoField {

    private int mImageButton;
    private Bitmap mImageView;

    public PhotoField(int imageButton) {
        this.mImageButton = imageButton;
    }

    public PhotoField(Bitmap mImageView) {
        this.mImageView = mImageView;
    }

    public int getImageButton() {
        return mImageButton;
    }

    public void setImageButton(int imageButton) {
        this.mImageButton = imageButton;
    }

    public Bitmap getImageView() {
        return mImageView;
    }

    public void setImageView(Bitmap imageView) {
        this.mImageView = imageView;
    }
}
