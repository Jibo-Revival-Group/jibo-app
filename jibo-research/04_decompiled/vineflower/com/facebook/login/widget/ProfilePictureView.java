package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.R;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;

public class ProfilePictureView extends FrameLayout {
   private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
   private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
   private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
   public static final int CUSTOM = -1;
   private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
   private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
   public static final int LARGE = -4;
   private static final int MIN_SIZE = 1;
   public static final int NORMAL = -3;
   private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
   private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
   private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
   public static final int SMALL = -2;
   private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
   public static final String TAG = ProfilePictureView.class.getSimpleName();
   private Bitmap customizedDefaultProfilePicture;
   private ImageView image;
   private Bitmap imageContents;
   private boolean isCropped;
   private ImageRequest lastRequest;
   private ProfilePictureView.OnErrorListener onErrorListener;
   private int presetSizeType;
   private String profileId;
   private int queryHeight = 0;
   private int queryWidth = 0;

   public ProfilePictureView(Context var1) {
      super(var1);
      this.isCropped = true;
      this.presetSizeType = -1;
      this.customizedDefaultProfilePicture = null;
      this.initialize(var1);
   }

   public ProfilePictureView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.isCropped = true;
      this.presetSizeType = -1;
      this.customizedDefaultProfilePicture = null;
      this.initialize(var1);
      this.parseAttributes(var2);
   }

   public ProfilePictureView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.isCropped = true;
      this.presetSizeType = -1;
      this.customizedDefaultProfilePicture = null;
      this.initialize(var1);
      this.parseAttributes(var2);
   }

   private int getPresetSizeInPixels(boolean var1) {
      int var2 = 0;
      switch (this.presetSizeType) {
         case -4:
            var2 = R.dimen.com_facebook_profilepictureview_preset_size_large;
            break;
         case -3:
            var2 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
            break;
         case -2:
            var2 = R.dimen.com_facebook_profilepictureview_preset_size_small;
            break;
         case -1:
            if (var1) {
               var2 = R.dimen.com_facebook_profilepictureview_preset_size_normal;
               break;
            }

            return var2;
         default:
            return var2;
      }

      return this.getResources().getDimensionPixelSize(var2);
   }

   private void initialize(Context var1) {
      this.removeAllViews();
      this.image = new ImageView(var1);
      LayoutParams var2 = new LayoutParams(-1, -1);
      this.image.setLayoutParams(var2);
      this.image.setScaleType(ScaleType.CENTER_INSIDE);
      this.addView(this.image);
   }

   private void parseAttributes(AttributeSet var1) {
      TypedArray var2 = this.getContext().obtainStyledAttributes(var1, R.styleable.com_facebook_profile_picture_view);
      this.setPresetSize(var2.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
      this.isCropped = var2.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
      var2.recycle();
   }

   private void processResponse(ImageResponse var1) {
      if (var1.getRequest() == this.lastRequest) {
         this.lastRequest = null;
         Bitmap var3 = var1.getBitmap();
         Exception var2 = var1.getError();
         if (var2 != null) {
            ProfilePictureView.OnErrorListener var4 = this.onErrorListener;
            if (var4 != null) {
               var4.onError(new FacebookException("Error in downloading profile picture for profileId: " + this.getProfileId(), var2));
            } else {
               Logger.log(LoggingBehavior.REQUESTS, 6, TAG, var2.toString());
            }
         } else if (var3 != null) {
            this.setImageBitmap(var3);
            if (var1.isCachedRedirect()) {
               this.sendImageRequest(false);
            }
         }
      }
   }

   private void refreshImage(boolean var1) {
      boolean var2 = this.updateImageQueryParameters();
      if (this.profileId != null && this.profileId.length() != 0 && (this.queryWidth != 0 || this.queryHeight != 0)) {
         if (var2 || var1) {
            this.sendImageRequest(true);
         }
      } else {
         this.setBlankProfilePicture();
      }
   }

   private void sendImageRequest(boolean var1) {
      ImageRequest var2 = new ImageRequest.Builder(this.getContext(), ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight))
         .setAllowCachedRedirects(var1)
         .setCallerTag(this)
         .setCallback(new ImageRequest.Callback(this) {
            final ProfilePictureView this$0;

            {
               this.this$0 = var1;
            }

            @Override
            public void onCompleted(ImageResponse var1) {
               this.this$0.processResponse(var1);
            }
         })
         .build();
      if (this.lastRequest != null) {
         ImageDownloader.cancelRequest(this.lastRequest);
      }

      this.lastRequest = var2;
      ImageDownloader.downloadAsync(var2);
   }

   private void setBlankProfilePicture() {
      if (this.lastRequest != null) {
         ImageDownloader.cancelRequest(this.lastRequest);
      }

      if (this.customizedDefaultProfilePicture == null) {
         int var1;
         if (this.isCropped()) {
            var1 = R.drawable.com_facebook_profile_picture_blank_square;
         } else {
            var1 = R.drawable.com_facebook_profile_picture_blank_portrait;
         }

         this.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), var1));
      } else {
         this.updateImageQueryParameters();
         this.setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
      }
   }

   private void setImageBitmap(Bitmap var1) {
      if (this.image != null && var1 != null) {
         this.imageContents = var1;
         this.image.setImageBitmap(var1);
      }
   }

   private boolean updateImageQueryParameters() {
      boolean var6 = false;
      boolean var5 = false;
      int var1 = this.getHeight();
      int var3 = this.getWidth();
      boolean var4 = var5;
      if (var3 >= 1) {
         if (var1 < 1) {
            var4 = var5;
         } else {
            int var2 = this.getPresetSizeInPixels(false);
            if (var2 != 0) {
               var1 = var2;
            } else {
               var2 = var3;
            }

            if (var2 <= var1) {
               if (this.isCropped()) {
                  var1 = var2;
               } else {
                  var1 = 0;
               }
            } else if (this.isCropped()) {
               var2 = var1;
            } else {
               var2 = 0;
            }

            label31: {
               if (var2 == this.queryWidth) {
                  var4 = var6;
                  if (var1 == this.queryHeight) {
                     break label31;
                  }
               }

               var4 = true;
            }

            this.queryWidth = var2;
            this.queryHeight = var1;
         }
      }

      return var4;
   }

   public final ProfilePictureView.OnErrorListener getOnErrorListener() {
      return this.onErrorListener;
   }

   public final int getPresetSize() {
      return this.presetSizeType;
   }

   public final String getProfileId() {
      return this.profileId;
   }

   public final boolean isCropped() {
      return this.isCropped;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.lastRequest = null;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.refreshImage(false);
   }

   protected void onMeasure(int var1, int var2) {
      boolean var6 = true;
      android.view.ViewGroup.LayoutParams var10 = this.getLayoutParams();
      boolean var9 = false;
      int var8 = MeasureSpec.getSize(var2);
      int var7 = MeasureSpec.getSize(var1);
      int var5 = var8;
      boolean var3 = var9;
      int var4 = var2;
      if (MeasureSpec.getMode(var2) != 1073741824) {
         var5 = var8;
         var3 = var9;
         var4 = var2;
         if (var10.height == -2) {
            var5 = this.getPresetSizeInPixels(true);
            var4 = MeasureSpec.makeMeasureSpec(var5, 1073741824);
            var3 = true;
         }
      }

      if (MeasureSpec.getMode(var1) != 1073741824 && var10.width == -2) {
         var2 = this.getPresetSizeInPixels(true);
         var1 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
         var3 = var6;
      } else {
         var2 = var7;
      }

      if (var3) {
         this.setMeasuredDimension(var2, var5);
         this.measureChildren(var1, var4);
      } else {
         super.onMeasure(var1, var4);
      }
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (var1.getClass() != Bundle.class) {
         super.onRestoreInstanceState(var1);
      } else {
         Bundle var2 = (Bundle)var1;
         super.onRestoreInstanceState(var2.getParcelable("ProfilePictureView_superState"));
         this.profileId = var2.getString("ProfilePictureView_profileId");
         this.presetSizeType = var2.getInt("ProfilePictureView_presetSize");
         this.isCropped = var2.getBoolean("ProfilePictureView_isCropped");
         this.queryWidth = var2.getInt("ProfilePictureView_width");
         this.queryHeight = var2.getInt("ProfilePictureView_height");
         this.setImageBitmap((Bitmap)var2.getParcelable("ProfilePictureView_bitmap"));
         if (var2.getBoolean("ProfilePictureView_refresh")) {
            this.refreshImage(true);
         }
      }
   }

   protected Parcelable onSaveInstanceState() {
      Parcelable var2 = super.onSaveInstanceState();
      Bundle var3 = new Bundle();
      var3.putParcelable("ProfilePictureView_superState", var2);
      var3.putString("ProfilePictureView_profileId", this.profileId);
      var3.putInt("ProfilePictureView_presetSize", this.presetSizeType);
      var3.putBoolean("ProfilePictureView_isCropped", this.isCropped);
      var3.putParcelable("ProfilePictureView_bitmap", this.imageContents);
      var3.putInt("ProfilePictureView_width", this.queryWidth);
      var3.putInt("ProfilePictureView_height", this.queryHeight);
      boolean var1;
      if (this.lastRequest != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      var3.putBoolean("ProfilePictureView_refresh", var1);
      return var3;
   }

   public final void setCropped(boolean var1) {
      this.isCropped = var1;
      this.refreshImage(false);
   }

   public final void setDefaultProfilePicture(Bitmap var1) {
      this.customizedDefaultProfilePicture = var1;
   }

   public final void setOnErrorListener(ProfilePictureView.OnErrorListener var1) {
      this.onErrorListener = var1;
   }

   public final void setPresetSize(int var1) {
      switch (var1) {
         case -4:
         case -3:
         case -2:
         case -1:
            this.presetSizeType = var1;
            this.requestLayout();
            return;
         default:
            throw new IllegalArgumentException("Must use a predefined preset size");
      }
   }

   public final void setProfileId(String var1) {
      boolean var2 = false;
      if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(var1)) {
         this.setBlankProfilePicture();
         var2 = true;
      }

      this.profileId = var1;
      this.refreshImage(var2);
   }

   public interface OnErrorListener {
      void onError(FacebookException var1);
   }
}
