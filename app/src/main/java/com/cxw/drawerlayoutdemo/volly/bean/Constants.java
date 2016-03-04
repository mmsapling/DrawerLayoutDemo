
package com.cxw.drawerlayoutdemo.volly.bean;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;

/**
 * 静态常数。
 */
public class Constants {
	
	public static String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/yishenghuo/images";
	
	public static String updatePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/yishenghuo/download";
	
	public static final boolean DEBUG = true; //是否开启日记
	
	public static final boolean IS_TEST_FUN = false; //测试功能
	
	public static final String SD_CARD_DIR="yishenghuo_temp";//SD卡路径

	public static final String  CACHE_DIR="cache_temp";//内存路径

	public static final String IMAGE_DIR="yishenghuo_image";//图库路径
	
	/**获取SDCard文件缓存路径   当前目录用来保存其他图片信息*/
	public static String getSDCachePath(Context context) {
		String filePath = null;
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			//外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
			if(context.getExternalCacheDir()!=null){
				filePath=context.getExternalCacheDir().getPath()+ File.separator;
			}
		}
		if(filePath==null){
			filePath = context.getFilesDir().getPath() + File.separator + Constants.SD_CARD_DIR+ File.separator;
		}
		File file=new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		return filePath;
	}
	/**获取软件安装路径文件缓存路径  当前目录用来存贮主题配置信息图片*/
	public static String getCachePath(Context context) {
		String filePath = context.getFilesDir().getPath() + File.separator + Constants.CACHE_DIR+ File.separator;
		File file=new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		return filePath;
	}
	/**获取SD卡的下载的图片保存的位置   当前目录用来存贮用户保存的图片*/
	public static String getSDPicturesPath() {
		String filePath=null;
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			filePath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+ File.separator+IMAGE_DIR+ File.separator;
			File file=new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
		}
		return filePath;
	}
	
	/**
	 * 获取更新apk下载目录
	 */
	public static  String getAPKDownloadDir(Context context) {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			File sdFile = Environment.getExternalStorageDirectory();
			File apkFile = new File(sdFile, SD_CARD_DIR);
			if (!apkFile.exists()) {
				apkFile.mkdir();
			}
			return apkFile.toString() + "/";
		} else {
			return getSDCachePath(context);
		}
	}
	/**保存相应的cityId**/
	public static void setCityID(Context context,String id){
		SharedPreferences preferences = context.getSharedPreferences("CITY_ID", Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString("cityID", id);
		editor.commit();
	}
	/**得到相应的cityId**/
	public static String getCityID(Context context){
		SharedPreferences preferences = context.getSharedPreferences("CITY_ID", Context.MODE_PRIVATE);
		String cityID = preferences.getString("cityID", "");
		if (cityID!=null&&cityID.length()!=0) {
			return cityID;
		}
		return "";
	}
	
	/**获取WEB VIEW 缓存目录*/
	public static String getWebViewCachePath(Context context){
		return context.getFilesDir().getAbsolutePath()+ "/webcache";
	}
	
	/**QQ第三方登录**/
	public static final String QQAppID = "1104914563";
	public static final String QQAppKEY = "HGvpN4c0V7uDjqRe";
	
	/**微信**/
	public static final String WeiXinAppID = "wx5344e5e99067df4c";
	public static final String WeiXinSecret = "1c3b510d71c97a858643e1da5696f3b4";
	/**新浪微博**/
	public static final String XinLangAppID = "";
}
