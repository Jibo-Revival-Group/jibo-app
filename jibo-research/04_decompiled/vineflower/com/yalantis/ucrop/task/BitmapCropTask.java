package com.yalantis.ucrop.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import java.io.File;
import java.io.IOException;

public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
   private static final String TAG = "BitmapCropTask";
   private final CompressFormat mCompressFormat;
   private final int mCompressQuality;
   private final BitmapCropCallback mCropCallback;
   private final RectF mCropRect;
   private float mCurrentAngle;
   private final RectF mCurrentImageRect;
   private float mCurrentScale;
   private final ExifInfo mExifInfo;
   private final String mImageInputPath;
   private final String mImageOutputPath;
   private final int mMaxResultImageSizeX;
   private final int mMaxResultImageSizeY;
   private Bitmap mViewBitmap;

   static {
      System.loadLibrary("ucrop");
   }

   public BitmapCropTask(Bitmap var1, ImageState var2, CropParameters var3, BitmapCropCallback var4) {
      this.mViewBitmap = var1;
      this.mCropRect = var2.getCropRect();
      this.mCurrentImageRect = var2.getCurrentImageRect();
      this.mCurrentScale = var2.getCurrentScale();
      this.mCurrentAngle = var2.getCurrentAngle();
      this.mMaxResultImageSizeX = var3.getMaxResultImageSizeX();
      this.mMaxResultImageSizeY = var3.getMaxResultImageSizeY();
      this.mCompressFormat = var3.getCompressFormat();
      this.mCompressQuality = var3.getCompressQuality();
      this.mImageInputPath = var3.getImageInputPath();
      this.mImageOutputPath = var3.getImageOutputPath();
      this.mExifInfo = var3.getExifInfo();
      this.mCropCallback = var4;
   }

   private boolean crop(float var1) throws IOException {
      ExifInterface var8 = new ExifInterface(this.mImageInputPath);
      int var3 = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
      int var5 = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
      int var2 = Math.round(this.mCropRect.width() / this.mCurrentScale);
      int var4 = Math.round(this.mCropRect.height() / this.mCurrentScale);
      boolean var6 = this.shouldCrop(var2, var4);
      Log.i("BitmapCropTask", "Should crop: " + var6);
      if (var6) {
         boolean var7 = this.cropCImg(
            this.mImageInputPath,
            this.mImageOutputPath,
            var5,
            var3,
            var2,
            var4,
            this.mCurrentAngle,
            var1,
            this.mCompressFormat.ordinal(),
            this.mCompressQuality,
            this.mExifInfo.getExifDegrees(),
            this.mExifInfo.getExifTranslation()
         );
         var6 = var7;
         if (var7) {
            ImageHeaderParser.copyExif(var8, var2, var4, this.mImageOutputPath);
            var6 = var7;
         }
      } else {
         FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
         var6 = false;
      }

      return var6;
   }

   private float resize() {
      Options var7 = new Options();
      var7.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mImageInputPath, var7);
      boolean var5;
      if (this.mExifInfo.getExifDegrees() != 90 && this.mExifInfo.getExifDegrees() != 270) {
         var5 = 0;
      } else {
         var5 = 1;
      }

      int var6;
      if (var5) {
         var6 = var7.outHeight;
      } else {
         var6 = var7.outWidth;
      }

      float var1 = (float)var6 / this.mViewBitmap.getWidth();
      if (var5) {
         var5 = var7.outWidth;
      } else {
         var5 = var7.outHeight;
      }

      var1 = Math.min(var1, (float)var5 / this.mViewBitmap.getHeight());
      this.mCurrentScale /= var1;
      float var2 = 1.0F;
      var1 = var2;
      if (this.mMaxResultImageSizeX > 0) {
         var1 = var2;
         if (this.mMaxResultImageSizeY > 0) {
            float var3 = this.mCropRect.width() / this.mCurrentScale;
            float var4 = this.mCropRect.height() / this.mCurrentScale;
            if (!(var3 > this.mMaxResultImageSizeX)) {
               var1 = var2;
               if (!(var4 > this.mMaxResultImageSizeY)) {
                  return var1;
               }
            }

            var1 = Math.min(this.mMaxResultImageSizeX / var3, this.mMaxResultImageSizeY / var4);
            this.mCurrentScale /= var1;
         }
      }

      return var1;
   }

   private boolean shouldCrop(int var1, int var2) {
      boolean var4 = true;
      var1 = Math.round(Math.max(var1, var2) / 1000.0F) + 1;
      if (this.mMaxResultImageSizeX > 0) {
         boolean var3 = var4;
         if (this.mMaxResultImageSizeY > 0) {
            return var3;
         }
      }

      boolean var6 = var4;
      if (!(Math.abs(this.mCropRect.left - this.mCurrentImageRect.left) > var1)) {
         var6 = var4;
         if (!(Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) > var1)) {
            var6 = var4;
            if (!(Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) > var1)) {
               if (Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) > var1) {
                  var6 = var4;
               } else {
                  var6 = false;
               }
            }
         }
      }

      return var6;
   }

   public native boolean cropCImg(
      String var1, String var2, int var3, int var4, int var5, int var6, float var7, float var8, int var9, int var10, int var11, int var12
   ) throws IOException, OutOfMemoryError;

   protected Throwable doInBackground(Void... var1) {
      Throwable var4 = null;
      if (this.mViewBitmap == null) {
         var4 = new NullPointerException("ViewBitmap is null");
      } else if (this.mViewBitmap.isRecycled()) {
         var4 = new NullPointerException("ViewBitmap is recycled");
      } else if (this.mCurrentImageRect.isEmpty()) {
         var4 = new NullPointerException("CurrentImageRect is empty");
      } else {
         float var2 = this.resize();

         try {
            this.crop(var2);
            this.mViewBitmap = null;
         } catch (Throwable var3) {
            var4 = var3;
         }
      }

      return var4;
   }

   protected void onPostExecute(Throwable var1) {
      if (this.mCropCallback != null) {
         if (var1 == null) {
            this.mCropCallback.onBitmapCropped(Uri.fromFile(new File(this.mImageOutputPath)));
         } else {
            this.mCropCallback.onCropFailure(var1);
         }
      }
   }
}
