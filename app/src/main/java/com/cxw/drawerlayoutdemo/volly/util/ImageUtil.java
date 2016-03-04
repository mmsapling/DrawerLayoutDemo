package com.cxw.drawerlayoutdemo.volly.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class ImageUtil {

    /**保存文件到本地路径*/
    public static void saveBitmapToLocalFile(String localImagePath,Bitmap bitmap){
        if(bitmap==null){
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(localImagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            bitmap = null;
        }
    }
    /**
     * 从内存卡中读取bitmap
     */
    public static Bitmap getBitmapFromFile(String localImagePath) {
        Bitmap bitmap = null;
        try {
            File file=new File(localImagePath);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                bitmap = BitmapFactory.decodeStream(fis);
                fis.close();
            }
        } catch (FileNotFoundException e) {
            bitmap = null;
            //AppViewException.onViewException(e);
        } catch (IOException e) {
            bitmap = null;
            //AppViewException.onViewException(e);
        }catch (OutOfMemoryError ex) {
            bitmap = null;
            System.gc();
        }
        return bitmap;
    }

    /**
     * 从网络中获取bitmap
     */
    public static Bitmap getBitmapFromURL(String imageUrl, String localImagePath) {
        Bitmap bitmap =null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            FileOutputStream fos = new FileOutputStream(localImagePath);
            if(bitmap!=null){
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            }
            fos.flush();
            fos.close();
            is.close();
        } catch (FileNotFoundException e) {
            bitmap = null;
            //AppViewException.onViewException(e);
        } catch (IOException e) {
            bitmap = null;
            //AppViewException.onViewException(e);
        } catch (OutOfMemoryError ex) {
            bitmap = null;
            System.gc();
        }
        return bitmap;
    }


}
