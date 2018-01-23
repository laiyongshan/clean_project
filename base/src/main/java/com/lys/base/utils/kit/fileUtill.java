package com.lys.base.utils.kit;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件工具类
 *
 * @author liujian
 */
public class fileUtill {

    /**
     * 判断SD卡是否存在
     *
     * @return
     */
    public static boolean sdCardIsExit() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 如果sd卡不存在，就保存在手机存储中
     *
     * @param context
     */
    public static void FileCache(Context context) {
        // 如果有SD卡则在SD卡中建一个LazyList的目录存放缓存的图片
        // 没有SD卡就放在系统的缓存目录中
        File cacheDir;
        if (sdCardIsExit()) {
            cacheDir = new File(AppConfig.DIR_PICTURE);
        } else {
            cacheDir = context.getCacheDir();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
    }

//	/**
//	 * 删除SD卡或者手机的缓存图片和目录
//	 */
//	public void deleteFile() {
//		File dirFile = new File(Constants.SIGN_PICTURE);
//		if (!dirFile.exists()) {
//			return;
//		}
//		if (dirFile.isDirectory()) {
//			String[] children = dirFile.list();
//			for (int i = 0; i < children.length; i++) {
//				new File(dirFile, children[i]).delete();
//			}
//		}
//
//		dirFile.delete();
//	}

    /**
     * 获取SD卡路径
     *
     * @return /sdcard/
     */
    public static String getSDCardPath() {
        if (sdCardIsExit()) {
            return Environment.getExternalStorageDirectory().toString() + "/";
        }
        return null;
    }

    /**
     * 创建文件夹
     *
     * @param dirPath
     */
    public static String creatDir2SDCard(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {// 判断文件是否存在
            file.mkdirs();
        }
        return dirPath;
    }

    /**
     * 创建文件
     * <p/>
     * 如果是/sdcard/download/123.doc则只需传入filePath=download/123.doc
     *
     * @param filePath 文件路径
     * @return 创建文件的路径
     * @throws IOException
     */
    public static String creatFile2SDCard(String filePath) throws IOException {
        // 无论传入什么值 都是从根目录开始 即/sdcard/+filePath
        // 创建文件路径包含的文件夹
        String filedir = creatDir2SDCard(getFileDir(filePath));
        String fileFinalPath = filedir + getFileName(filePath);
        File file = new File(fileFinalPath);
        if (!file.exists()) {
            file.createNewFile();
        }
        return fileFinalPath;
    }

    /**
     * 获取文件目录路径
     *
     * @param filePath
     * @return
     */
    private static String getFileDir(String filePath) {
        if (filePath.startsWith(getSDCardPath())) {
            return filePath.replace(getFileName(filePath), "");
        }
        return getSDCardPath() + filePath.replace(getFileName(filePath), "");
    }

    /**
     * 获取文件名
     *
     * @param filePath
     * @return
     */
    private static String getFileName(String filePath) {
        int index;
        String tempName = "";
        if ((index = filePath.lastIndexOf("/")) != -1) {
            // 如果有后缀名才
            tempName = filePath.substring(index + 1);
        }
        return tempName.contains(".") ? tempName : "";
    }


    public static boolean delDir(File f) {
        try {
            if (f.exists() && f.isDirectory()) {// 判断是文件还是目录
                if (f.listFiles().length == 0) {// 若目录下没有文件则直接删除
                    f.delete();
                } else {// 若有则把文件放进数组，并判断是否有下级目录
                    File delFile[] = f.listFiles();
                    int i = f.listFiles().length;
                    for (int j = 0; j < i; j++) {
                        if (delFile[j].isDirectory()) {
                            delDir(delFile[j]);// 递归调用del方法并取得子目录路径
                        }
                        delFile[j].delete();
                    }// 删除文件
                    f.delete();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @param data     数据
     * @param path     路径
     * @param fileName 文件名
     * @return true成功 false失败
     */
    public static boolean writeToSdcard(byte[] data, String path, String fileName) {
        FileOutputStream fos = null;
        try {
            //判断有没有文件夹
            File filePath = new File(path);
            if (!filePath.exists()) {
                //创建文件夹
                filePath.mkdirs();
            }

            //判断有没有同名的文件
            File file = new File(path + fileName);
            //有的话，删除
            if (file.exists()) {
                file.delete();
            }
            //写文件
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            return true;

        } catch (Exception e) {
            return false;
            // TODO: handle exception
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 检测 是否有外存储设备
     *
     * @return
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }



    public static String getUriPath(Context context, Uri uri) {
        if(uri == null) {
            return null;
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
            if("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            } else if("com.android.providers.media.documents".equals(uri.getAuthority())) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                Uri contentUri = null;
                if("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[] {split[1]};
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } else if("content".equalsIgnoreCase(uri.getScheme())) {
            if("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        } else if("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if(cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if(cursor != null) cursor.close();
        }
        return null;
    }
}
