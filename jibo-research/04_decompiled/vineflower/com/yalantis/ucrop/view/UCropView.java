package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

public class UCropView extends FrameLayout {
   private final GestureCropImageView mGestureCropImageView;
   private final OverlayView mViewOverlay;

   public UCropView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public UCropView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      LayoutInflater.from(var1).inflate(R.layout.ucrop_view, this, true);
      this.mGestureCropImageView = (GestureCropImageView)this.findViewById(R.id.image_view_crop);
      this.mViewOverlay = (OverlayView)this.findViewById(R.id.view_overlay);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.ucrop_UCropView);
      this.mViewOverlay.processStyledAttributes(var4);
      this.mGestureCropImageView.processStyledAttributes(var4);
      var4.recycle();
      this.mGestureCropImageView.setCropBoundsChangeListener(new CropBoundsChangeListener(this) {
         final UCropView this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onCropAspectRatioChanged(float var1) {
            this.this$0.mViewOverlay.setTargetAspectRatio(var1);
         }
      });
      this.mViewOverlay.setOverlayViewChangeListener(new OverlayViewChangeListener(this) {
         final UCropView this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onCropRectUpdated(RectF var1) {
            this.this$0.mGestureCropImageView.setCropRect(var1);
         }
      });
   }

   public GestureCropImageView getCropImageView() {
      return this.mGestureCropImageView;
   }

   public OverlayView getOverlayView() {
      return this.mViewOverlay;
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }
}
