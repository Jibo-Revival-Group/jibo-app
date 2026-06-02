package com.yalantis.ucrop.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.Comparator;

public class FileUtils {
   private static final boolean DEBUG = false;
   public static final String HIDDEN_PREFIX = ".";
   public static final String MIME_TYPE_APP = "application/*";
   public static final String MIME_TYPE_AUDIO = "audio/*";
   public static final String MIME_TYPE_IMAGE = "image/*";
   public static final String MIME_TYPE_TEXT = "text/*";
   public static final String MIME_TYPE_VIDEO = "video/*";
   static final String TAG = "FileUtils";
   public static Comparator<File> sComparator = new Comparator<File>() {
      public int compare(File var1, File var2) {
         return var1.getName().toLowerCase().compareTo(var2.getName().toLowerCase());
      }
   };
   public static FileFilter sDirFilter = new FileFilter() {
      @Override
      public boolean accept(File var1) {
         String var3 = var1.getName();
         boolean var2;
         if (var1.isDirectory() && !var3.startsWith(".")) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   };
   public static FileFilter sFileFilter = new FileFilter() {
      @Override
      public boolean accept(File var1) {
         String var3 = var1.getName();
         boolean var2;
         if (var1.isFile() && !var3.startsWith(".")) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   };

   private FileUtils() {
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void copyFile(String var0, String var1) throws IOException {
      Object var3 = null;
      boolean var14 = false /* VF: Semaphore variable */;

      FileChannel var2;
      label122: {
         label123: {
            try {
               var14 = true;
               File var19 = new File((String)var0);
               FileInputStream var4 = new FileInputStream(var19);
               var2 = var4.getChannel();
               var14 = false;
            } finally {
               if (var14) {
                  var2 = null;
                  var18 = (FileChannel)var3;
                  break label123;
               }
            }

            try {
               File var20 = new File(var1);
               var0 = new FileOutputStream(var20);
               var18 = var0.getChannel();
            } finally {
               ;
            }

            label113:
            try {
               var2.transferTo(0L, var2.size(), var18);
               var2.close();
               break label122;
            } finally {
               break label113;
            }
         }

         if (var2 != null) {
            var2.close();
         }

         if (var18 != null) {
            var18.close();
         }

         throw var0;
      }

      if (var2 != null) {
         var2.close();
      }

      if (var18 != null) {
         var18.close();
      }
   }

   public static Intent createGetContentIntent() {
      Intent var0 = new Intent("android.intent.action.GET_CONTENT");
      var0.setType("*/*");
      var0.addCategory("android.intent.category.OPENABLE");
      return var0;
   }

   public static String getDataColumn(Context param0, Uri param1, String param2, String[] param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 04: aload 1
      // 05: bipush 1
      // 06: anewarray 122
      // 09: dup
      // 0a: bipush 0
      // 0b: ldc "_data"
      // 0d: aastore
      // 0e: aload 2
      // 0f: aload 3
      // 10: aconst_null
      // 11: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 14: astore 1
      // 15: aload 1
      // 16: ifnull 45
      // 19: aload 1
      // 1a: astore 0
      // 1b: aload 1
      // 1c: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 21: ifeq 45
      // 24: aload 1
      // 25: astore 0
      // 26: aload 1
      // 27: aload 1
      // 28: ldc "_data"
      // 2a: invokeinterface android/database/Cursor.getColumnIndexOrThrow (Ljava/lang/String;)I 2
      // 2f: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 34: astore 2
      // 35: aload 2
      // 36: astore 0
      // 37: aload 1
      // 38: ifnull 43
      // 3b: aload 1
      // 3c: invokeinterface android/database/Cursor.close ()V 1
      // 41: aload 2
      // 42: astore 0
      // 43: aload 0
      // 44: areturn
      // 45: aload 1
      // 46: ifnull 4f
      // 49: aload 1
      // 4a: invokeinterface android/database/Cursor.close ()V 1
      // 4f: aconst_null
      // 50: astore 0
      // 51: goto 43
      // 54: astore 2
      // 55: aconst_null
      // 56: astore 1
      // 57: aload 1
      // 58: astore 0
      // 59: ldc "FileUtils"
      // 5b: ldc "getDataColumn: _data"
      // 5d: aload 2
      // 5e: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 61: pop
      // 62: aload 1
      // 63: ifnull 4f
      // 66: aload 1
      // 67: invokeinterface android/database/Cursor.close ()V 1
      // 6c: goto 4f
      // 6f: astore 0
      // 70: aconst_null
      // 71: astore 1
      // 72: aload 0
      // 73: astore 2
      // 74: aload 1
      // 75: ifnull 7e
      // 78: aload 1
      // 79: invokeinterface android/database/Cursor.close ()V 1
      // 7e: aload 2
      // 7f: athrow
      // 80: astore 2
      // 81: aload 0
      // 82: astore 1
      // 83: goto 74
      // 86: astore 2
      // 87: goto 57
      // try (0 -> 14): 46 java/lang/IllegalArgumentException
      // try (0 -> 14): 61 null
      // try (18 -> 21): 76 java/lang/IllegalArgumentException
      // try (18 -> 21): 72 null
      // try (23 -> 29): 76 java/lang/IllegalArgumentException
      // try (23 -> 29): 72 null
      // try (51 -> 56): 72 null
   }

   public static String getExtension(String var0) {
      if (var0 == null) {
         var0 = null;
      } else {
         int var1 = var0.lastIndexOf(".");
         if (var1 >= 0) {
            var0 = var0.substring(var1);
         } else {
            var0 = "";
         }
      }

      return var0;
   }

   public static File getFile(Context var0, Uri var1) {
      if (var1 != null) {
         String var2 = getPath(var0, var1);
         if (var2 != null && isLocal(var2)) {
            return new File(var2);
         }
      }

      return null;
   }

   public static String getMimeType(Context var0, Uri var1) {
      return getMimeType(new File(getPath(var0, var1)));
   }

   public static String getMimeType(File var0) {
      String var1 = getExtension(var0.getName());
      String var2;
      if (var1.length() > 0) {
         var2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var1.substring(1));
      } else {
         var2 = "application/octet-stream";
      }

      return var2;
   }

   @SuppressLint("NewApi")
   public static String getPath(Context var0, Uri var1) {
      Object var4 = null;
      String var3 = null;
      boolean var2;
      if (VERSION.SDK_INT >= 19) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2 && DocumentsContract.isDocumentUri(var0, var1)) {
         if (isExternalStorageDocument(var1)) {
            String[] var6 = DocumentsContract.getDocumentId(var1).split(":");
            if ("primary".equalsIgnoreCase(var6[0])) {
               var3 = Environment.getExternalStorageDirectory() + "/" + var6[1];
            }
         } else if (isDownloadsDocument(var1)) {
            String var7 = DocumentsContract.getDocumentId(var1);
            var3 = getDataColumn(var0, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(var7)), null, null);
         } else if (isMediaDocument(var1)) {
            String[] var9 = DocumentsContract.getDocumentId(var1).split(":");
            String var5 = var9[0];
            if ("image".equals(var5)) {
               var1 = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(var5)) {
               var1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
               var1 = (Uri)var4;
               if ("audio".equals(var5)) {
                  var1 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
               }
            }

            var3 = getDataColumn(var0, var1, "_id=?", new String[]{var9[1]});
         }
      } else if ("content".equalsIgnoreCase(var1.getScheme())) {
         if (isGooglePhotosUri(var1)) {
            var3 = var1.getLastPathSegment();
         } else {
            var3 = getDataColumn(var0, var1, null, null);
         }
      } else if ("file".equalsIgnoreCase(var1.getScheme())) {
         var3 = var1.getPath();
      }

      return var3;
   }

   public static File getPathWithoutFilename(File var0) {
      if (var0 != null) {
         if (!var0.isDirectory()) {
            String var1 = var0.getName();
            String var2 = var0.getAbsolutePath();
            var1 = var2.substring(0, var2.length() - var1.length());
            String var3 = var1;
            if (var1.endsWith("/")) {
               var3 = var1.substring(0, var1.length() - 1);
            }

            var0 = new File(var3);
         }
      } else {
         var0 = null;
      }

      return var0;
   }

   public static String getReadableFileSize(int var0) {
      DecimalFormat var5 = new DecimalFormat("###.#");
      float var1 = 0.0F;
      String var4 = " KB";
      String var3 = var4;
      if (var0 > 1024) {
         float var2 = var0 / 1024;
         var3 = var4;
         var1 = var2;
         if (var2 > 1024.0F) {
            var1 = var2 / 1024.0F;
            if (var1 > 1024.0F) {
               var1 /= 1024.0F;
               var3 = " GB";
            } else {
               var3 = " MB";
            }
         }
      }

      return String.valueOf(var5.format(var1) + var3);
   }

   public static Bitmap getThumbnail(Context var0, Uri var1) {
      return getThumbnail(var0, var1, getMimeType(var0, var1));
   }

   public static Bitmap getThumbnail(Context var0, Uri var1, String var2) {
      Cursor var4 = null;
      Object var17;
      if (!isMediaUri(var1)) {
         Log.e("FileUtils", "You can only retrieve thumbnails for images and videos.");
         var17 = var4;
      } else {
         if (var1 != null) {
            var17 = var0.getContentResolver();

            label165: {
               label148: {
                  try {
                     var4 = var17.query(var1, null, null, null, null);
                     break label148;
                  } catch (Exception var15) {
                  } finally {
                     ;
                  }

                  var4 = null;
                  break label165;
               }

               label140: {
                  try {
                     if (var4.moveToFirst()) {
                        int var3 = var4.getInt(0);
                        if (var2.contains("video")) {
                           var19 = Thumbnails.getThumbnail((ContentResolver)var17, var3, 1, null);
                           break label140;
                        }

                        if (var2.contains("image/*")) {
                           var19 = android.provider.MediaStore.Images.Thumbnails.getThumbnail((ContentResolver)var17, var3, 1, null);
                           break label140;
                        }
                     }
                  } catch (Exception var13) {
                     var17 = var13;
                     break label165;
                  } finally {
                     if (var4 != null) {
                        var4.close();
                     }

                     throw var17;
                  }

                  var19 = null;
               }

               var17 = var19;
               if (var4 != null) {
                  var4.close();
                  var17 = var19;
               }

               return var17;
            }

            if (var4 != null) {
               var4.close();
               var17 = null;
               return var17;
            }
         }

         var17 = null;
      }

      return var17;
   }

   public static Bitmap getThumbnail(Context var0, File var1) {
      return getThumbnail(var0, getUri(var1), getMimeType(var1));
   }

   public static Uri getUri(File var0) {
      Uri var1;
      if (var0 != null) {
         var1 = Uri.fromFile(var0);
      } else {
         var1 = null;
      }

      return var1;
   }

   public static boolean isDownloadsDocument(Uri var0) {
      return "com.android.providers.downloads.documents".equals(var0.getAuthority());
   }

   public static boolean isExternalStorageDocument(Uri var0) {
      return "com.android.externalstorage.documents".equals(var0.getAuthority());
   }

   public static boolean isGooglePhotosUri(Uri var0) {
      return "com.google.android.apps.photos.content".equals(var0.getAuthority());
   }

   public static boolean isLocal(String var0) {
      boolean var1;
      if (var0 != null && !var0.startsWith("http://") && !var0.startsWith("https://")) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isMediaDocument(Uri var0) {
      return "com.android.providers.media.documents".equals(var0.getAuthority());
   }

   public static boolean isMediaUri(Uri var0) {
      return "media".equalsIgnoreCase(var0.getAuthority());
   }
}
