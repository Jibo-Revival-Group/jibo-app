package com.yalantis.ucrop.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
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

/* JADX INFO: loaded from: classes2.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    private static final String TAG = "BitmapCropTask";
    private final Bitmap.CompressFormat mCompressFormat;
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

    public native boolean cropCImg(String str, String str2, int i, int i2, int i3, int i4, float f, float f2, int i5, int i6, int i7, int i8) throws IOException, OutOfMemoryError;

    static {
        System.loadLibrary("ucrop");
    }

    public BitmapCropTask(Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mExifInfo = cropParameters.getExifInfo();
        this.mCropCallback = bitmapCropCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Throwable doInBackground(Void... voidArr) {
        if (this.mViewBitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (this.mViewBitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            crop(resize());
            this.mViewBitmap = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    private float resize() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.mImageInputPath, options);
        boolean z = this.mExifInfo.getExifDegrees() == 90 || this.mExifInfo.getExifDegrees() == 270;
        this.mCurrentScale /= Math.min((z ? options.outHeight : options.outWidth) / this.mViewBitmap.getWidth(), (z ? options.outWidth : options.outHeight) / this.mViewBitmap.getHeight());
        if (this.mMaxResultImageSizeX <= 0 || this.mMaxResultImageSizeY <= 0) {
            return 1.0f;
        }
        float fWidth = this.mCropRect.width() / this.mCurrentScale;
        float fHeight = this.mCropRect.height() / this.mCurrentScale;
        if (fWidth <= this.mMaxResultImageSizeX && fHeight <= this.mMaxResultImageSizeY) {
            return 1.0f;
        }
        float fMin = Math.min(this.mMaxResultImageSizeX / fWidth, this.mMaxResultImageSizeY / fHeight);
        this.mCurrentScale /= fMin;
        return fMin;
    }

    private boolean crop(float f) throws Throwable {
        ExifInterface exifInterface = new ExifInterface(this.mImageInputPath);
        int iRound = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
        int iRound2 = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
        int iRound3 = Math.round(this.mCropRect.width() / this.mCurrentScale);
        int iRound4 = Math.round(this.mCropRect.height() / this.mCurrentScale);
        boolean zShouldCrop = shouldCrop(iRound3, iRound4);
        Log.i(TAG, "Should crop: " + zShouldCrop);
        if (zShouldCrop) {
            boolean zCropCImg = cropCImg(this.mImageInputPath, this.mImageOutputPath, iRound2, iRound, iRound3, iRound4, this.mCurrentAngle, f, this.mCompressFormat.ordinal(), this.mCompressQuality, this.mExifInfo.getExifDegrees(), this.mExifInfo.getExifTranslation());
            if (zCropCImg) {
                ImageHeaderParser.copyExif(exifInterface, iRound3, iRound4, this.mImageOutputPath);
                return zCropCImg;
            }
            return zCropCImg;
        }
        FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
        return false;
    }

    private boolean shouldCrop(int i, int i2) {
        int iRound = Math.round(Math.max(i, i2) / 1000.0f) + 1;
        return (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) || Math.abs(this.mCropRect.left - this.mCurrentImageRect.left) > ((float) iRound) || Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) > ((float) iRound) || Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) > ((float) iRound) || Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) > ((float) iRound);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Throwable th) {
        if (this.mCropCallback != null) {
            if (th == null) {
                this.mCropCallback.onBitmapCropped(Uri.fromFile(new File(this.mImageOutputPath)));
            } else {
                this.mCropCallback.onCropFailure(th);
            }
        }
    }
}
