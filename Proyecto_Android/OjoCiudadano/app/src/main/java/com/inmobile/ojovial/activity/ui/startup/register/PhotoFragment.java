package com.inmobile.ojovial.activity.ui.startup.register;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inmobile.ojovial.activity.R;
import com.inmobile.ojovial.activity.common.BaseFragment;
import com.inmobile.ojovial.activity.ui.startup.adapters.PhotoFieldAdapter;
import com.inmobile.ojovial.activity.ui.startup.field.PhotoField;
import com.inmobile.ojovial.activity.ui.startup.util.camera.AlbumStorageDirFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;

/**
 * Created by apaico on 01/09/16.
 */
public class PhotoFragment extends BaseFragment implements PhotoFieldAdapter.PhotoListener {
    private boolean mIsVisible;
    private boolean mShouldShowRenderingInfo;
    @Bind(R.id.rw_photo_list)RecyclerView rvPhotoList;
    private PhotoFieldAdapter mPhotoFieldAdapter;
    private List<PhotoField> mPhotoList;
    private List<PhotoField> mFields = new ArrayList<>();

    private String mCurrentPhotoPath;
    private AlbumStorageDirFactory mAlbumStorageDirFactory = null;
    public static final String JPEG_FILE_SUFFIX = ".jpg";
    private static final String JPEG_FILE_PREFIX = "IMG_";

    private static final int ACTION_TAKE_PHOTO_1 = 1;
    private static final int ACTION_TAKE_PHOTO_2 = 2;
    private static final int ACTION_TAKE_PHOTO_3 = 3;

    public PhotoFragment() {
        mPhotoList=new ArrayList<>();
        mIsVisible=false;
        mShouldShowRenderingInfo = false;
    }

    @Override
    public String getTitle(){
        return getString(R.string.title_take_photo);
    }

    @Override
    public boolean showBack(){
        return true;
    }

    public static PhotoFragment newInstance() {
        Bundle args = new Bundle();
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected View onCreateViewCalled(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sIsPublic=false;
        return inflater.inflate(R.layout.fragment_photo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        setUI();
    }

    private void setUI() {
        mPhotoFieldAdapter = new PhotoFieldAdapter(mPhotoList);
        mPhotoFieldAdapter.setPhotoListener(this);
        rvPhotoList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPhotoList.setAdapter(mPhotoFieldAdapter);
        preparedData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_continue, menu);
        MenuItem item = menu.findItem(R.id.menu_item_finish);
        item.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_next:
                mInteractionListener.replaceFragmentPrivate(RegisterComplaintFragment.newInstance(), true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<PhotoField> preparedData(){
        mFields.add(new PhotoField(R.drawable.cam1));
        mFields.add(new PhotoField(R.drawable.cam2));
        mFields.add(new PhotoField(R.drawable.cam3));
        mPhotoFieldAdapter.update(mFields);
        return mFields;
    }

    private void dispatchTakePictureIntent(int actionCode) {
        /*Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f;

        try {
            f = setUpPhotoFile();
            mCurrentPhotoPath = f.getAbsolutePath();
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        } catch (IOException e) {
            e.printStackTrace();
            mCurrentPhotoPath = null;
        }
        startActivityForResult(takePictureIntent, actionCode);
        */
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, actionCode);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data!=null){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            PhotoField beanPhotoField=mFields.get(requestCode-1);
            beanPhotoField.setImageView(imageBitmap);
            mPhotoFieldAdapter.insert(beanPhotoField,requestCode-1);
        }else{
            Toast.makeText(getContext(), "No se puede procesar la foto.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void photoFieldSelected(int position) {
        switch (position){
            case 0:
                //Toast.makeText(getContext(), "Camara 1", Toast.LENGTH_SHORT).show();
                dispatchTakePictureIntent(ACTION_TAKE_PHOTO_1);
                break;
            case 1:
                //Toast.makeText(getContext(), "Camara 2", Toast.LENGTH_SHORT).show();
                dispatchTakePictureIntent(ACTION_TAKE_PHOTO_2);
                break;
            default:
                //Toast.makeText(getContext(), "Camara 3", Toast.LENGTH_SHORT).show();
                dispatchTakePictureIntent(ACTION_TAKE_PHOTO_3);
        }
    }
    /*
    @Override
    public void onResume(){
        super.onResume();
        mIsVisible = true;

        if (mShouldShowRenderingInfo){
            mShouldShowRenderingInfo = false;
           //mInteractionListener.replaceFragment(W2RenderingInfoFragment.newInstance(), true);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        mIsVisible = false;
    }

    @Override
    protected void cameraPermissionGranted(){
        if (mIsVisible){
            mShouldShowRenderingInfo = false;
        } else {
            mShouldShowRenderingInfo = true;
        }
    }

    private File setUpPhotoFile() throws IOException {
        File f = createLocalImage();
        mCurrentPhotoPath = f.getAbsolutePath();
        return f;
    }

    private File createLocalImage() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
        File albumF = getAlbumDir();
        File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
        return imageF;
    }

    private File getAlbumDir() {
        File storageDir = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getString(R.string.album_name));

            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()){
                        return null;
                    }
                }
            }
        }
        return storageDir;
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        getActivity().sendBroadcast(mediaScanIntent);
    }

    private void setPic() {
        int targetW = ivPhotoCamera.getWidth();
        int targetH = ivPhotoCamera.getHeight();

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW/targetW, photoH/targetH);
        }

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        ivPhotoCamera.setImageBitmap(bitmap);
    }
    */

}
