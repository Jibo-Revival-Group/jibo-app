package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UCropActivity extends AppCompatActivity {
   public static final int ALL = 3;
   public static final CompressFormat DEFAULT_COMPRESS_FORMAT = CompressFormat.JPEG;
   public static final int DEFAULT_COMPRESS_QUALITY = 90;
   public static final int NONE = 0;
   public static final int ROTATE = 2;
   private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
   public static final int SCALE = 1;
   private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
   private static final int TABS_COUNT = 3;
   private static final String TAG = "UCropActivity";
   private int mActiveWidgetColor;
   private int[] mAllowedGestures;
   private View mBlockingView;
   private CompressFormat mCompressFormat;
   private int mCompressQuality;
   private List<ViewGroup> mCropAspectRatioViews;
   private GestureCropImageView mGestureCropImageView;
   private TransformImageView.TransformImageListener mImageListener;
   private ViewGroup mLayoutAspectRatio;
   private ViewGroup mLayoutRotate;
   private ViewGroup mLayoutScale;
   private int mLogoColor;
   private OverlayView mOverlayView;
   private boolean mShowBottomControls;
   private boolean mShowLoader = true;
   private final OnClickListener mStateClickListener;
   private int mStatusBarColor;
   private TextView mTextViewRotateAngle;
   private TextView mTextViewScalePercent;
   private int mToolbarColor;
   private String mToolbarTitle;
   private int mToolbarWidgetColor;
   private UCropView mUCropView;
   private ViewGroup mWrapperStateAspectRatio;
   private ViewGroup mWrapperStateRotate;
   private ViewGroup mWrapperStateScale;

   public UCropActivity() {
      this.mCropAspectRatioViews = new ArrayList<>();
      this.mCompressFormat = DEFAULT_COMPRESS_FORMAT;
      this.mCompressQuality = 90;
      this.mAllowedGestures = new int[]{1, 2, 3};
      this.mImageListener = new TransformImageView.TransformImageListener(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onLoadComplete() {
            this.this$0.mUCropView.animate().alpha(1.0F).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.this$0.mBlockingView.setClickable(false);
            this.this$0.mShowLoader = false;
            this.this$0.supportInvalidateOptionsMenu();
         }

         @Override
         public void onLoadFailure(Exception var1) {
            this.this$0.setResultError(var1);
            this.this$0.finish();
         }

         @Override
         public void onRotate(float var1) {
            this.this$0.setAngleText(var1);
         }

         @Override
         public void onScale(float var1) {
            this.this$0.setScaleText(var1);
         }
      };
      this.mStateClickListener = new OnClickListener(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            if (!var1.isSelected()) {
               this.this$0.setWidgetState(var1.getId());
            }
         }
      };
   }

   private void addBlockingView() {
      if (this.mBlockingView == null) {
         this.mBlockingView = new View(this);
         LayoutParams var1 = new LayoutParams(-1, -1);
         var1.addRule(3, R.id.toolbar);
         this.mBlockingView.setLayoutParams(var1);
         this.mBlockingView.setClickable(true);
      }

      ((RelativeLayout)this.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
   }

   private void initiateRootViews() {
      this.mUCropView = this.findViewById(R.id.ucrop);
      this.mGestureCropImageView = this.mUCropView.getCropImageView();
      this.mOverlayView = this.mUCropView.getOverlayView();
      this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
      ((ImageView)this.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, Mode.SRC_ATOP);
   }

   private void processOptions(Intent var1) {
      String var7 = var1.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
      CompressFormat var6 = null;
      if (!TextUtils.isEmpty(var7)) {
         var6 = CompressFormat.valueOf(var7);
      }

      CompressFormat var12 = var6;
      if (var6 == null) {
         var12 = DEFAULT_COMPRESS_FORMAT;
      }

      this.mCompressFormat = var12;
      this.mCompressQuality = var1.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
      int[] var10 = var1.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
      if (var10 != null && var10.length == 3) {
         this.mAllowedGestures = var10;
      }

      this.mGestureCropImageView.setMaxBitmapSize(var1.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
      this.mGestureCropImageView.setMaxScaleMultiplier(var1.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0F));
      this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(var1.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
      this.mOverlayView.setFreestyleCropEnabled(var1.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
      this.mOverlayView
         .setDimmedColor(var1.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", this.getResources().getColor(R.color.ucrop_color_default_dimmed)));
      this.mOverlayView.setOvalDimmedLayer(var1.getBooleanExtra("com.yalantis.ucrop.OvalDimmedLayer", false));
      this.mOverlayView.setShowCropFrame(var1.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
      this.mOverlayView
         .setCropFrameColor(var1.getIntExtra("com.yalantis.ucrop.CropFrameColor", this.getResources().getColor(R.color.ucrop_color_default_crop_frame)));
      this.mOverlayView
         .setCropFrameStrokeWidth(
            var1.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width))
         );
      this.mOverlayView.setShowCropGrid(var1.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
      this.mOverlayView.setCropGridRowCount(var1.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
      this.mOverlayView.setCropGridColumnCount(var1.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
      this.mOverlayView
         .setCropGridColor(var1.getIntExtra("com.yalantis.ucrop.CropGridColor", this.getResources().getColor(R.color.ucrop_color_default_crop_grid)));
      this.mOverlayView
         .setCropGridStrokeWidth(
            var1.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width))
         );
      int var4 = var1.getIntExtra("com.yalantis.ucrop.CropPadding", this.getResources().getDimensionPixelSize(R.dimen.ucrop_padding_crop_frame));
      this.mOverlayView.setPadding(var4, var4, var4, var4);
      this.mGestureCropImageView.setPadding(var4, var4, var4, var4);
      this.mGestureCropImageView.post(new Runnable(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void run() {
            Log.d("CALVINATOR", "Scale : " + this.this$0.mGestureCropImageView.getCurrentScale());
            this.this$0.mGestureCropImageView.zoomInImage(1.5F);
         }
      });
      float var3 = var1.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0F);
      float var2 = var1.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0F);
      var4 = var1.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
      ArrayList var11 = var1.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
      if (var3 > 0.0F && var2 > 0.0F) {
         if (this.mWrapperStateAspectRatio != null) {
            this.mWrapperStateAspectRatio.setVisibility(8);
         }

         this.mGestureCropImageView.setTargetAspectRatio(var3 / var2);
      } else if (var11 != null && var4 < var11.size()) {
         this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio)var11.get(var4)).getAspectRatioX() / ((AspectRatio)var11.get(var4)).getAspectRatioY());
      } else {
         this.mGestureCropImageView.setTargetAspectRatio(0.0F);
      }

      var4 = var1.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
      int var5 = var1.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
      if (var4 > 0 && var5 > 0) {
         this.mGestureCropImageView.setMaxResultImageSizeX(var4);
         this.mGestureCropImageView.setMaxResultImageSizeY(var5);
      }
   }

   private void resetRotation() {
      this.mGestureCropImageView.postRotate(-this.mGestureCropImageView.getCurrentAngle());
      this.mGestureCropImageView.setImageToWrapCropBounds();
   }

   private void rotateByAngle(int var1) {
      this.mGestureCropImageView.postRotate(var1);
      this.mGestureCropImageView.setImageToWrapCropBounds();
   }

   private void setAllowedGestures(int var1) {
      boolean var3 = false;
      GestureCropImageView var4 = this.mGestureCropImageView;
      boolean var2;
      if (this.mAllowedGestures[var1] != 3 && this.mAllowedGestures[var1] != 1) {
         var2 = false;
      } else {
         var2 = true;
      }

      label15: {
         var4.setScaleEnabled(var2);
         var4 = this.mGestureCropImageView;
         if (this.mAllowedGestures[var1] != 3) {
            var2 = var3;
            if (this.mAllowedGestures[var1] != 2) {
               break label15;
            }
         }

         var2 = true;
      }

      var4.setRotateEnabled(var2);
   }

   private void setAngleText(float var1) {
      if (this.mTextViewRotateAngle != null) {
         this.mTextViewRotateAngle.setText(String.format(Locale.getDefault(), "%.1f°", var1));
      }
   }

   private void setImageData(Intent var1) {
      Uri var3 = (Uri)var1.getParcelableExtra("com.yalantis.ucrop.InputUri");
      Uri var2 = (Uri)var1.getParcelableExtra("com.yalantis.ucrop.OutputUri");
      this.processOptions(var1);
      if (var3 != null && var2 != null) {
         try {
            this.mGestureCropImageView.setImageUri(var3, var2);
         } catch (Exception var4) {
            this.setResultError(var4);
            this.finish();
         }
      } else {
         this.setResultError(new NullPointerException(this.getString(R.string.ucrop_error_input_data_is_absent)));
         this.finish();
      }
   }

   private void setInitialState() {
      if (this.mShowBottomControls) {
         if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
            this.setWidgetState(R.id.state_aspect_ratio);
         } else {
            this.setWidgetState(R.id.state_scale);
         }
      } else {
         this.mGestureCropImageView.setScaleEnabled(true);
         this.mGestureCropImageView.setRotateEnabled(true);
      }
   }

   private void setScaleText(float var1) {
      if (this.mTextViewScalePercent != null) {
         this.mTextViewScalePercent.setText(String.format(Locale.getDefault(), "%d%%", (int)(100.0F * var1)));
      }
   }

   @TargetApi(21)
   private void setStatusBarColor(int var1) {
      if (VERSION.SDK_INT >= 21 && this.getWindow() != null) {
         this.getWindow().setStatusBarColor(var1);
      }
   }

   private void setWidgetState(int var1) {
      byte var3 = 8;
      if (this.mShowBottomControls) {
         ViewGroup var5 = this.mWrapperStateAspectRatio;
         boolean var4;
         if (var1 == R.id.state_aspect_ratio) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setSelected(var4);
         var5 = this.mWrapperStateRotate;
         if (var1 == R.id.state_rotate) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setSelected(var4);
         var5 = this.mWrapperStateScale;
         if (var1 == R.id.state_scale) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setSelected(var4);
         var5 = this.mLayoutAspectRatio;
         byte var2;
         if (var1 == R.id.state_aspect_ratio) {
            var2 = 0;
         } else {
            var2 = 8;
         }

         var5.setVisibility(var2);
         var5 = this.mLayoutRotate;
         if (var1 == R.id.state_rotate) {
            var2 = 0;
         } else {
            var2 = 8;
         }

         var5.setVisibility(var2);
         var5 = this.mLayoutScale;
         var2 = var3;
         if (var1 == R.id.state_scale) {
            var2 = 0;
         }

         var5.setVisibility(var2);
         if (var1 == R.id.state_scale) {
            this.setAllowedGestures(0);
         } else if (var1 == R.id.state_rotate) {
            this.setAllowedGestures(1);
         } else {
            this.setAllowedGestures(2);
         }
      }
   }

   private void setupAppBar() {
      this.setStatusBarColor(this.mStatusBarColor);
      Toolbar var1 = this.findViewById(R.id.toolbar);
      var1.setBackgroundColor(this.mToolbarColor);
      var1.setTitleTextColor(this.mToolbarWidgetColor);
      TextView var2 = (TextView)var1.findViewById(R.id.toolbar_title);
      var2.setTextColor(this.mToolbarWidgetColor);
      var2.setText(this.mToolbarTitle);
      Drawable var4 = ContextCompat.a(this, R.drawable.ucrop_ic_cross).mutate();
      var4.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
      var1.setNavigationIcon(var4);
      this.setSupportActionBar(var1);
      ActionBar var3 = this.getSupportActionBar();
      if (var3 != null) {
         var3.setDisplayShowTitleEnabled(false);
      }
   }

   private void setupAspectRatioWidget(Intent var1) {
      int var2 = var1.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
      ArrayList var8 = var1.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
      if (var8 == null || var8.isEmpty()) {
         var8 = new ArrayList();
         var8.add(new AspectRatio(null, 1.0F, 1.0F));
         var8.add(new AspectRatio(null, 3.0F, 4.0F));
         var8.add(new AspectRatio(this.getString(R.string.ucrop_label_original).toUpperCase(), 0.0F, 0.0F));
         var8.add(new AspectRatio(null, 3.0F, 2.0F));
         var8.add(new AspectRatio(null, 16.0F, 9.0F));
         var2 = 2;
      }

      LinearLayout var3 = this.findViewById(R.id.layout_aspect_ratio);
      android.widget.LinearLayout.LayoutParams var4 = new android.widget.LinearLayout.LayoutParams(0, -1);
      var4.weight = 1.0F;

      for (AspectRatio var6 : var8) {
         FrameLayout var9 = (FrameLayout)this.getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, null);
         var9.setLayoutParams(var4);
         AspectRatioTextView var7 = (AspectRatioTextView)var9.getChildAt(0);
         var7.setActiveColor(this.mActiveWidgetColor);
         var7.setAspectRatio(var6);
         var3.addView(var9);
         this.mCropAspectRatioViews.add(var9);
      }

      this.mCropAspectRatioViews.get(var2).setSelected(true);
      Iterator var10 = this.mCropAspectRatioViews.iterator();

      while (var10.hasNext()) {
         ((ViewGroup)var10.next()).setOnClickListener(new OnClickListener(this) {
            final UCropActivity this$0;

            {
               this.this$0 = var1;
            }

            public void onClick(View var1) {
               this.this$0.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView)((ViewGroup)var1).getChildAt(0)).getAspectRatio(var1.isSelected()));
               this.this$0.mGestureCropImageView.setImageToWrapCropBounds();
               if (!var1.isSelected()) {
                  for (ViewGroup var4x : this.this$0.mCropAspectRatioViews) {
                     boolean var2x;
                     if (var4x == var1) {
                        var2x = true;
                     } else {
                        var2x = false;
                     }

                     var4x.setSelected(var2x);
                  }
               }
            }
         });
      }
   }

   private void setupRotateWidget() {
      this.mTextViewRotateAngle = this.findViewById(R.id.text_view_rotate);
      this.<HorizontalProgressWheelView>findViewById(R.id.rotate_scroll_wheel).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onScroll(float var1, float var2) {
            this.this$0.mGestureCropImageView.postRotate(var1 / 42.0F);
         }

         @Override
         public void onScrollEnd() {
            this.this$0.mGestureCropImageView.setImageToWrapCropBounds();
         }

         @Override
         public void onScrollStart() {
            this.this$0.mGestureCropImageView.cancelAllAnimations();
         }
      });
      this.<HorizontalProgressWheelView>findViewById(R.id.rotate_scroll_wheel).setMiddleLineColor(this.mActiveWidgetColor);
      this.<View>findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new OnClickListener(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.resetRotation();
         }
      });
      this.<View>findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new OnClickListener(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.rotateByAngle(90);
         }
      });
   }

   private void setupScaleWidget() {
      this.mTextViewScalePercent = this.findViewById(R.id.text_view_scale);
      this.<HorizontalProgressWheelView>findViewById(R.id.scale_scroll_wheel)
         .setScrollingListener(
            new HorizontalProgressWheelView.ScrollingListener(this) {
               final UCropActivity this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public void onScroll(float var1, float var2) {
                  if (var1 > 0.0F) {
                     this.this$0
                        .mGestureCropImageView
                        .zoomInImage(
                           this.this$0.mGestureCropImageView.getCurrentScale()
                              + (this.this$0.mGestureCropImageView.getMaxScale() - this.this$0.mGestureCropImageView.getMinScale()) / 15000.0F * var1
                        );
                  } else {
                     this.this$0
                        .mGestureCropImageView
                        .zoomOutImage(
                           this.this$0.mGestureCropImageView.getCurrentScale()
                              + (this.this$0.mGestureCropImageView.getMaxScale() - this.this$0.mGestureCropImageView.getMinScale()) / 15000.0F * var1
                        );
                  }
               }

               @Override
               public void onScrollEnd() {
                  this.this$0.mGestureCropImageView.setImageToWrapCropBounds();
               }

               @Override
               public void onScrollStart() {
                  this.this$0.mGestureCropImageView.cancelAllAnimations();
               }
            }
         );
      this.<HorizontalProgressWheelView>findViewById(R.id.scale_scroll_wheel).setMiddleLineColor(this.mActiveWidgetColor);
   }

   private void setupStatesWrapper() {
      ImageView var3 = this.findViewById(R.id.image_view_state_scale);
      ImageView var1 = this.findViewById(R.id.image_view_state_rotate);
      ImageView var2 = this.findViewById(R.id.image_view_state_aspect_ratio);
      var3.setImageDrawable(new SelectedStateListDrawable(var3.getDrawable(), this.mActiveWidgetColor));
      var1.setImageDrawable(new SelectedStateListDrawable(var1.getDrawable(), this.mActiveWidgetColor));
      var2.setImageDrawable(new SelectedStateListDrawable(var2.getDrawable(), this.mActiveWidgetColor));
   }

   private void setupViews(Intent var1) {
      this.mStatusBarColor = var1.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.c(this, R.color.ucrop_color_statusbar));
      this.mToolbarColor = var1.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.c(this, R.color.ucrop_color_toolbar));
      this.mActiveWidgetColor = var1.getIntExtra("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.c(this, R.color.ucrop_color_widget_active));
      this.mToolbarWidgetColor = var1.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.c(this, R.color.ucrop_color_toolbar_widget));
      this.mToolbarTitle = var1.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
      String var3;
      if (!TextUtils.isEmpty(this.mToolbarTitle)) {
         var3 = this.mToolbarTitle;
      } else {
         var3 = this.getResources().getString(R.string.ucrop_label_edit_photo);
      }

      this.mToolbarTitle = var3;
      this.mLogoColor = var1.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.c(this, R.color.ucrop_color_default_logo));
      boolean var2;
      if (!var1.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false)) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mShowBottomControls = var2;
      this.setupAppBar();
      this.initiateRootViews();
      if (this.mShowBottomControls) {
         ViewGroup var4 = this.findViewById(R.id.ucrop_photobox);
         View.inflate(this, R.layout.ucrop_controls, var4);
         this.mWrapperStateAspectRatio = this.findViewById(R.id.state_aspect_ratio);
         this.mWrapperStateAspectRatio.setOnClickListener(this.mStateClickListener);
         this.mWrapperStateRotate = this.findViewById(R.id.state_rotate);
         this.mWrapperStateRotate.setOnClickListener(this.mStateClickListener);
         this.mWrapperStateScale = this.findViewById(R.id.state_scale);
         this.mWrapperStateScale.setOnClickListener(this.mStateClickListener);
         this.mLayoutAspectRatio = this.findViewById(R.id.layout_aspect_ratio);
         this.mLayoutRotate = this.findViewById(R.id.layout_rotate_wheel);
         this.mLayoutScale = this.findViewById(R.id.layout_scale_wheel);
         this.setupAspectRatioWidget(var1);
         this.setupRotateWidget();
         this.setupScaleWidget();
         this.setupStatesWrapper();
      }
   }

   protected void cropAndSaveImage() {
      this.mBlockingView.setClickable(true);
      this.mShowLoader = true;
      this.supportInvalidateOptionsMenu();
      this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback(this) {
         final UCropActivity this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onBitmapCropped(Uri var1) {
            this.this$0.setResultUri(var1, this.this$0.mGestureCropImageView.getTargetAspectRatio());
            this.this$0.finish();
         }

         @Override
         public void onCropFailure(Throwable var1) {
            this.this$0.setResultError(var1);
            this.this$0.finish();
         }
      });
   }

   @Override
   public void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.yalantis.ucrop.UCropActivity");
      super.onCreate(var1);
      this.setContentView(R.layout.ucrop_activity_photobox);
      Intent var2 = this.getIntent();
      this.setupViews(var2);
      this.setImageData(var2);
      this.setInitialState();
      this.addBlockingView();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(R.menu.ucrop_menu_activity, var1);
      MenuItem var2 = var1.findItem(R.id.menu_loader);
      Drawable var3 = var2.getIcon();
      if (var3 != null) {
         try {
            var3.mutate();
            var3.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
            var2.setIcon(var3);
         } catch (IllegalStateException var4) {
            Log.e("UCropActivity", String.format("%s - %s", var4.getMessage(), this.getString(R.string.ucrop_mutate_exception_hint)));
         }

         ((Animatable)var2.getIcon()).start();
      }

      MenuItem var5 = var1.findItem(R.id.menu_crop);
      Drawable var6 = var5.getIcon();
      if (var6 != null) {
         var6.mutate();
         var6.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
         var5.setIcon(var6);
      }

      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if (var1.getItemId() == R.id.menu_crop) {
         this.cropAndSaveImage();
      } else if (var1.getItemId() == 16908332) {
         this.onBackPressed();
      }

      return super.onOptionsItemSelected(var1);
   }

   public boolean onPrepareOptionsMenu(Menu var1) {
      MenuItem var3 = var1.findItem(R.id.menu_crop);
      boolean var2;
      if (!this.mShowLoader) {
         var2 = true;
      } else {
         var2 = false;
      }

      var3.setVisible(var2);
      var1.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
      return super.onPrepareOptionsMenu(var1);
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.yalantis.ucrop.UCropActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.yalantis.ucrop.UCropActivity");
      super.onStart();
   }

   @Override
   protected void onStop() {
      super.onStop();
      if (this.mGestureCropImageView != null) {
         this.mGestureCropImageView.cancelAllAnimations();
      }
   }

   protected void setResultError(Throwable var1) {
      this.setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", var1));
   }

   protected void setResultUri(Uri var1, float var2) {
      this.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", var1).putExtra("com.yalantis.ucrop.CropAspectRatio", var2));
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface GestureTypes {
   }
}
