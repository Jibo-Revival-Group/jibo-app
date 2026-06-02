package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapLoadTask.BitmapWorkerResult> {
   private static final String TAG = "BitmapWorkerTask";
   private final BitmapLoadCallback mBitmapLoadCallback;
   private final Context mContext;
   private Uri mInputUri;
   private Uri mOutputUri;
   private final int mRequiredHeight;
   private final int mRequiredWidth;

   public BitmapLoadTask(Context var1, Uri var2, Uri var3, int var4, int var5, BitmapLoadCallback var6) {
      this.mContext = var1;
      this.mInputUri = var2;
      this.mOutputUri = var3;
      this.mRequiredWidth = var4;
      this.mRequiredHeight = var5;
      this.mBitmapLoadCallback = var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void copyFile(Uri var1, Uri var2) throws NullPointerException, IOException {
      Closeable var4 = null;
      Log.d("BitmapWorkerTask", "copyFile");
      if (var2 == null) {
         throw new NullPointerException("Output Uri is null - cannot copy image");
      }

      try {
         var49 = this.mContext.getContentResolver().openInputStream(var1);
      } finally {
         ;
      }

      label227: {
         FileOutputStream var6;
         try {
            File var55 = new File(var2.getPath());
            var6 = new FileOutputStream(var55);
         } catch (Throwable var48) {
            Object var5 = null;
            var4 = var49;
            var50 = var48;
            var51 = (FileOutputStream)var5;
            break label227;
         }

         if (var49 == null) {
            label213:
            try {
               NullPointerException var52 = new NullPointerException("InputStream for given input Uri is null");
               throw var52;
            } catch (Throwable var44) {
               var4 = var49;
               var51 = var6;
               var50 = var44;
               break label213;
            }
         } else {
            label223: {
               try {
                  var53 = new byte[1024];
               } catch (Throwable var47) {
                  var4 = var49;
                  var51 = var6;
                  var50 = var47;
                  break label223;
               }

               while (true) {
                  int var3;
                  try {
                     var3 = var49.read(var53);
                  } catch (Throwable var46) {
                     var4 = var49;
                     var51 = var6;
                     var50 = var46;
                     break;
                  }

                  if (var3 <= 0) {
                     BitmapLoadUtils.close(var6);
                     BitmapLoadUtils.close(var49);
                     this.mInputUri = this.mOutputUri;
                     return;
                  }

                  try {
                     var6.write(var53, 0, var3);
                  } catch (Throwable var45) {
                     var4 = var49;
                     var51 = var6;
                     var50 = var45;
                     break;
                  }
               }
            }
         }
      }

      BitmapLoadUtils.close(var51);
      BitmapLoadUtils.close(var4);
      this.mInputUri = this.mOutputUri;
      throw var50;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void downloadFile(Uri var1, Uri var2) throws NullPointerException, IOException {
      Sink var4 = null;
      Object var5 = null;
      Log.d("BitmapWorkerTask", "downloadFile");
      if (var2 == null) {
         throw new NullPointerException("Output Uri is null - cannot download image");
      }

      OkHttpClient var6 = new OkHttpClient();
      boolean var71 = false /* VF: Semaphore variable */;

      Response var3;
      label451: {
         try {
            var71 = true;
            Request.Builder var91 = new Request.Builder();
            var3 = FirebasePerfOkHttpClient.execute(var6.a(var91.a(var1.toString()).c()));
            var71 = false;
         } finally {
            if (var71) {
               var3 = null;
               var87 = null;
               break label451;
            }
         }

         try {
            var80 = var3.h().c();
         } finally {
            ;
         }

         BufferedSource var92 = var80;
         var1 = var5;

         try {
            var88 = this.mContext.getContentResolver().openOutputStream(var2);
         } catch (Throwable var78) {
            var87 = var92;
            var4 = (Sink)var1;
            var1 = var78;
            break label451;
         }

         label438:
         if (var88 != null) {
            var1 = var5;

            try {
               var89 = Okio.a(var88);
            } catch (Throwable var74) {
               var87 = var92;
               var4 = (Sink)var1;
               var1 = var74;
               break label438;
            }

            Sink var83 = var89;

            try {
               var92.a(var89);
            } catch (Throwable var73) {
               var87 = var92;
               var4 = var83;
               var1 = var73;
               break label438;
            }

            BitmapLoadUtils.close(var92);
            BitmapLoadUtils.close(var89);
            if (var3 != null) {
               BitmapLoadUtils.close(var3.h());
            }

            var6.s().b();
            this.mInputUri = this.mOutputUri;
            return;
         } else {
            label453: {
               var1 = var5;

               try {
                  var90 = new NullPointerException;
               } catch (Throwable var77) {
                  var87 = var92;
                  var4 = (Sink)var1;
                  var1 = var77;
                  break label453;
               }

               var1 = var5;

               try {
                  var90./* $VF: Unable to resugar constructor */<init>("OutputStream for given output Uri is null");
               } catch (Throwable var76) {
                  var87 = var92;
                  var4 = (Sink)var1;
                  var1 = var76;
                  break label453;
               }

               var1 = var5;

               label428:
               try {
                  throw var90;
               } catch (Throwable var75) {
                  var87 = var92;
                  var4 = (Sink)var1;
                  var1 = var75;
                  break label428;
               }
            }
         }
      }

      BitmapLoadUtils.close(var87);
      BitmapLoadUtils.close(var4);
      if (var3 != null) {
         BitmapLoadUtils.close(var3.h());
      }

      var6.s().b();
      this.mInputUri = this.mOutputUri;
      throw var1;
   }

   private void processInputUri() throws NullPointerException, IOException {
      Throwable var1 = this.mInputUri.getScheme();
      Log.d("BitmapWorkerTask", "Uri scheme: " + var1);
      if (!"http".equals(var1) && !"https".equals(var1)) {
         if ("content".equals(var1)) {
            var1 = FileUtils.getPath(this.mContext, this.mInputUri);
            if (!TextUtils.isEmpty(var1) && new File(var1).exists()) {
               this.mInputUri = Uri.fromFile(new File(var1));
            } else {
               try {
                  this.copyFile(this.mInputUri, this.mOutputUri);
                  return;
               } catch (NullPointerException var2) {
                  var1 = var2;
               } catch (IOException var3) {
                  var1 = var3;
               }

               Log.e("BitmapWorkerTask", "Copying failed", var1);
               throw var1;
            }
         } else if (!"file".equals(var1)) {
            Log.e("BitmapWorkerTask", "Invalid Uri scheme " + var1);
            throw new IllegalArgumentException("Invalid Uri scheme" + var1);
         }
      } else {
         try {
            this.downloadFile(this.mInputUri, this.mOutputUri);
            return;
         } catch (NullPointerException var4) {
            var1 = var4;
         } catch (IOException var5) {
            var1 = var5;
         }

         Log.e("BitmapWorkerTask", "Downloading failed", var1);
         throw var1;
      }
   }

   protected BitmapLoadTask.BitmapWorkerResult doInBackground(Void... var1) {
      int var2 = 0;
      Bitmap var13 = null;
      BitmapLoadTask.BitmapWorkerResult var14;
      if (this.mInputUri == null) {
         var14 = new BitmapLoadTask.BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
      } else {
         label79: {
            try {
               this.processInputUri();
               break label79;
            } catch (NullPointerException var11) {
               var15 = var11;
            } catch (IOException var12) {
               var15 = var12;
            }

            BitmapLoadTask.BitmapWorkerResult var19 = new BitmapLoadTask.BitmapWorkerResult(var15);
            return var19;
         }

         ParcelFileDescriptor var8;
         try {
            var8 = this.mContext.getContentResolver().openFileDescriptor(this.mInputUri, "r");
         } catch (FileNotFoundException var10) {
            BitmapLoadTask.BitmapWorkerResult var20 = new BitmapLoadTask.BitmapWorkerResult(var10);
            return var20;
         }

         if (var8 != null) {
            FileDescriptor var7 = var8.getFileDescriptor();
            Options var6 = new Options();
            var6.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(var7, null, var6);
            if (var6.outWidth != -1 && var6.outHeight != -1) {
               var6.inSampleSize = BitmapLoadUtils.calculateInSampleSize(var6, this.mRequiredWidth, this.mRequiredHeight);
               var6.inJustDecodeBounds = false;

               while (!var2) {
                  Bitmap var5;
                  try {
                     var5 = BitmapFactory.decodeFileDescriptor(var7, null, var6);
                  } catch (OutOfMemoryError var9) {
                     Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", var9);
                     var6.inSampleSize *= 2;
                     continue;
                  }

                  var13 = var5;
                  var2 = 1;
               }

               if (var13 == null) {
                  var14 = new BitmapLoadTask.BitmapWorkerResult(
                     new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]")
                  );
               } else {
                  if (VERSION.SDK_INT >= 16) {
                     BitmapLoadUtils.close(var8);
                  }

                  int var3 = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
                  int var4 = BitmapLoadUtils.exifToDegrees(var3);
                  var2 = BitmapLoadUtils.exifToTranslation(var3);
                  ExifInfo var17 = new ExifInfo(var3, var4, var2);
                  Matrix var18 = new Matrix();
                  if (var4 != 0) {
                     var18.preRotate(var4);
                  }

                  if (var2 != 1) {
                     var18.postScale(var2, 1.0F);
                  }

                  if (!var18.isIdentity()) {
                     var14 = new BitmapLoadTask.BitmapWorkerResult(BitmapLoadUtils.transformBitmap(var13, var18), var17);
                  } else {
                     var14 = new BitmapLoadTask.BitmapWorkerResult(var13, var17);
                  }
               }
            } else {
               var14 = new BitmapLoadTask.BitmapWorkerResult(
                  new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]")
               );
            }
         } else {
            var14 = new BitmapLoadTask.BitmapWorkerResult(new NullPointerException("ParcelFileDescriptor was null for given Uri: [" + this.mInputUri + "]"));
         }
      }

      return var14;
   }

   protected void onPostExecute(BitmapLoadTask.BitmapWorkerResult var1) {
      if (var1.mBitmapWorkerException == null) {
         BitmapLoadCallback var3 = this.mBitmapLoadCallback;
         Bitmap var2 = var1.mBitmapResult;
         ExifInfo var5 = var1.mExifInfo;
         String var4 = this.mInputUri.getPath();
         String var6;
         if (this.mOutputUri == null) {
            var6 = null;
         } else {
            var6 = this.mOutputUri.getPath();
         }

         var3.onBitmapLoaded(var2, var5, var4, var6);
      } else {
         this.mBitmapLoadCallback.onFailure(var1.mBitmapWorkerException);
      }
   }

   public static class BitmapWorkerResult {
      Bitmap mBitmapResult;
      Exception mBitmapWorkerException;
      ExifInfo mExifInfo;

      public BitmapWorkerResult(Bitmap var1, ExifInfo var2) {
         this.mBitmapResult = var1;
         this.mExifInfo = var2;
      }

      public BitmapWorkerResult(Exception var1) {
         this.mBitmapWorkerException = var1;
      }
   }
}
