package com.jibo.ui.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.PermissionUtil;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class PhotoBaseFragment extends BaseFragment {
   private String a;
   protected String l;
   public Uri m;

   private void a(UCrop.Options var1) {
      UCrop var2 = UCrop.of(Uri.fromFile(new File(this.l)), Uri.fromFile(new File(this.l)));
      var2.withOptions(var1);
      var2.start(this.getActivity(), this);
   }

   public void a(int var1) {
      this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, var1);
   }

   public void a(Uri var1) {
      try {
         long var3 = System.currentTimeMillis() / 1000L;
         StringBuilder var5 = new StringBuilder();
         this.l = var5.append(this.a).append(Long.valueOf(var3)).append("_").append("tmp_photo.jpg").toString();
         ImageUtils.a(this.l, this.getActivity().getContentResolver().openInputStream(var1));
      } catch (FileNotFoundException var6) {
         Crashlytics.a(var6);
         return;
      }

      UCrop.Options var7 = new UCrop.Options();
      var7.setCompressionFormat(CompressFormat.JPEG);
      var7.setCompressionQuality(95);
      var7.setStatusBarColor(this.getResources().getColor(2131099672));
      var7.setToolbarColor(this.getResources().getColor(2131099771));
      var7.setHideBottomControls(true);
      var7.setFreeStyleCropEnabled(false);
      var7.setOvalDimmedLayer(true);
      var7.setShowCropGrid(false);
      var7.setShowCropFrame(false);
      var7.setCropPadding(this.getResources().getDimensionPixelSize(2131165268));
      var7.withAspectRatio(1.0F, 1.0F);
      int var2 = this.getResources().getDimensionPixelSize(2131165269);
      var7.withMaxResultSize(var2, var2);
      this.a(var7);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         switch (var1) {
            case 1009:
               Uri var8 = this.m;
               this.m = null;
               if (this instanceof AvatarBaseFragment) {
                  this.a(var8);
               }
               break;
            case 1010:
               Uri var7 = var3.getData();
               if (this instanceof AvatarBaseFragment) {
                  this.a(var7);
               }
         }
      } else {
         switch (var1) {
            case 1009:
               if (this.m != null) {
                  try {
                     long var4 = Long.parseLong(this.m.getLastPathSegment().replace("image:", ""));
                     this.getActivity().getContentResolver().delete(Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.valueOf(var4).toString()});
                  } catch (Exception var6) {
                     LogUtils.a(f, "onActivityResult", var6);
                     Crashlytics.a(var6);
                  }
               }

               this.m = null;
         }
      }
   }

   @Override
   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      int var5 = 0;
      if (var3.length > 0) {
         int var6 = var3.length;
         int var4 = 0;

         while (var5 < var6) {
            var4 += var3[var5];
            var5++;
         }

         if (var4 == 0) {
            switch (var1) {
               case 1:
                  this.q();
                  break;
               case 2:
                  this.r();
                  break;
               case 3:
                  this.s();
            }
         }
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.a = this.getActivity().getExternalCacheDir() + "/";
   }

   public void q() {
      if (PermissionUtil.a(this.getActivity())) {
         ContentValues var1 = new ContentValues(1);
         var1.put("mime_type", "image/jpg");
         this.m = this.getActivity().getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, var1);
         ImageUtils.a(this, 1009, this.m);
      } else {
         this.a(1);
      }
   }

   public void r() {
      if (PermissionUtil.a(this.getActivity())) {
         ContentValues var1 = new ContentValues(1);
         var1.put("mime_type", "image/jpg");
         this.m = this.getActivity().getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, var1);
         ImageUtils.b(this, 1009, this.m);
      } else {
         this.a(2);
      }
   }

   public void s() {
      if (PermissionUtil.a(this.getActivity())) {
         Intent var1 = new Intent("android.intent.action.GET_CONTENT");
         var1.setType("image/*");
         this.startActivityForResult(var1, 1010);
      } else {
         this.a(3);
      }
   }
}
