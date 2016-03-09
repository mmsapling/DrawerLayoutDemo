package com.cxw.drawerlayoutdemo.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.cxw.drawerlayoutdemo.volly.DResponseService;
import com.cxw.drawerlayoutdemo.volly.DVolleyModel;

import java.util.ArrayList;
import java.util.List;

public class NewsModel extends DVolleyModel {
    public NewsModel(Context context) {
        super(context);
    }
    private DResponseService mImageResponseService;
    public List<String> findImageUrls(){
        List<String> imageUrls = new ArrayList<String>();
        ContentResolver resolver = mContext.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = resolver.query(uri, null, null, null, null, null);
        if(cursor != null){
            while(cursor.moveToNext()){
              long id =  cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                Uri imageUri = Uri.parse(MediaStore.Images.Media.EXTERNAL_CONTENT_URI + "/" + id);
                imageUrls.add(imageUri.toString());
            }
        }
        cursor.close();
        cursor = null;
        return imageUrls;
    }
}
