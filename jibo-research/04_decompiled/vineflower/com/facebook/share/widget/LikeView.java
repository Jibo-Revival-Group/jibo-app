package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.FacebookException;
import com.facebook.R;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;

public class LikeView extends FrameLayout {
   private static final int NO_FOREGROUND_COLOR = -1;
   private LikeView.AuxiliaryViewPosition auxiliaryViewPosition;
   private BroadcastReceiver broadcastReceiver;
   private LinearLayout containerView;
   private LikeView.LikeActionControllerCreationCallback creationCallback;
   private int edgePadding;
   private boolean explicitlyDisabled;
   private int foregroundColor;
   private LikeView.HorizontalAlignment horizontalAlignment;
   private int internalPadding;
   private LikeActionController likeActionController;
   private LikeBoxCountView likeBoxCountView;
   private LikeButton likeButton;
   private LikeView.Style likeViewStyle = LikeView.Style.DEFAULT;
   private String objectId;
   private LikeView.ObjectType objectType;
   private LikeView.OnErrorListener onErrorListener;
   private FragmentWrapper parentFragment;
   private TextView socialSentenceView;

   public LikeView(Context var1) {
      super(var1);
      this.horizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
      this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
      this.foregroundColor = -1;
      this.initialize(var1);
   }

   public LikeView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.horizontalAlignment = LikeView.HorizontalAlignment.DEFAULT;
      this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.DEFAULT;
      this.foregroundColor = -1;
      this.parseAttributes(var2);
      this.initialize(var1);
   }

   private void associateWithLikeActionController(LikeActionController var1) {
      this.likeActionController = var1;
      this.broadcastReceiver = new LikeView.LikeControllerBroadcastReceiver(this);
      LocalBroadcastManager var3 = LocalBroadcastManager.a(this.getContext());
      IntentFilter var2 = new IntentFilter();
      var2.addAction("com.facebook.sdk.LikeActionController.UPDATED");
      var2.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
      var2.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
      var3.a(this.broadcastReceiver, var2);
   }

   private Activity getActivity() {
      Context var1 = this.getContext();

      while (!(var1 instanceof Activity) && var1 instanceof ContextWrapper) {
         var1 = ((ContextWrapper)var1).getBaseContext();
      }

      if (var1 instanceof Activity) {
         return (Activity)var1;
      } else {
         throw new FacebookException("Unable to get Activity.");
      }
   }

   private Bundle getAnalyticsParameters() {
      Bundle var1 = new Bundle();
      var1.putString("style", this.likeViewStyle.toString());
      var1.putString("auxiliary_position", this.auxiliaryViewPosition.toString());
      var1.putString("horizontal_alignment", this.horizontalAlignment.toString());
      var1.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
      var1.putString("object_type", this.objectType.toString());
      return var1;
   }

   private void initialize(Context var1) {
      this.edgePadding = this.getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
      this.internalPadding = this.getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
      if (this.foregroundColor == -1) {
         this.foregroundColor = this.getResources().getColor(R.color.com_facebook_likeview_text_color);
      }

      this.setBackgroundColor(0);
      this.containerView = new LinearLayout(var1);
      LayoutParams var2 = new LayoutParams(-2, -2);
      this.containerView.setLayoutParams(var2);
      this.initializeLikeButton(var1);
      this.initializeSocialSentenceView(var1);
      this.initializeLikeCountView(var1);
      this.containerView.addView(this.likeButton);
      this.containerView.addView(this.socialSentenceView);
      this.containerView.addView(this.likeBoxCountView);
      this.addView(this.containerView);
      this.setObjectIdAndTypeForced(this.objectId, this.objectType);
      this.updateLikeStateAndLayout();
   }

   private void initializeLikeButton(Context var1) {
      boolean var2;
      if (this.likeActionController != null && this.likeActionController.isObjectLiked()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.likeButton = new LikeButton(var1, var2);
      this.likeButton.setOnClickListener(new OnClickListener(this) {
         final LikeView this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.toggleLike();
         }
      });
      android.widget.LinearLayout.LayoutParams var3 = new android.widget.LinearLayout.LayoutParams(-2, -2);
      this.likeButton.setLayoutParams(var3);
   }

   private void initializeLikeCountView(Context var1) {
      this.likeBoxCountView = new LikeBoxCountView(var1);
      android.widget.LinearLayout.LayoutParams var2 = new android.widget.LinearLayout.LayoutParams(-1, -1);
      this.likeBoxCountView.setLayoutParams(var2);
   }

   private void initializeSocialSentenceView(Context var1) {
      this.socialSentenceView = new TextView(var1);
      this.socialSentenceView.setTextSize(0, this.getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
      this.socialSentenceView.setMaxLines(2);
      this.socialSentenceView.setTextColor(this.foregroundColor);
      this.socialSentenceView.setGravity(17);
      android.widget.LinearLayout.LayoutParams var2 = new android.widget.LinearLayout.LayoutParams(-2, -1);
      this.socialSentenceView.setLayoutParams(var2);
   }

   private void parseAttributes(AttributeSet var1) {
      if (var1 != null && this.getContext() != null) {
         TypedArray var2 = this.getContext().obtainStyledAttributes(var1, R.styleable.com_facebook_like_view);
         if (var2 != null) {
            this.objectId = Utility.coerceValueIfNullOrEmpty(var2.getString(R.styleable.com_facebook_like_view_com_facebook_object_id), null);
            this.objectType = LikeView.ObjectType.fromInt(
               var2.getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, LikeView.ObjectType.DEFAULT.getValue())
            );
            this.likeViewStyle = LikeView.Style.fromInt(var2.getInt(R.styleable.com_facebook_like_view_com_facebook_style, LikeView.Style.DEFAULT.getValue()));
            if (this.likeViewStyle == null) {
               throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
            }

            this.auxiliaryViewPosition = LikeView.AuxiliaryViewPosition.fromInt(
               var2.getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, LikeView.AuxiliaryViewPosition.DEFAULT.getValue())
            );
            if (this.auxiliaryViewPosition == null) {
               throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
            }

            this.horizontalAlignment = LikeView.HorizontalAlignment.fromInt(
               var2.getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, LikeView.HorizontalAlignment.DEFAULT.getValue())
            );
            if (this.horizontalAlignment == null) {
               throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
            }

            this.foregroundColor = var2.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
            var2.recycle();
         }
      }
   }

   private void setObjectIdAndTypeForced(String var1, LikeView.ObjectType var2) {
      this.tearDownObjectAssociations();
      this.objectId = var1;
      this.objectType = var2;
      if (!Utility.isNullOrEmpty(var1)) {
         this.creationCallback = new LikeView.LikeActionControllerCreationCallback(this);
         if (!this.isInEditMode()) {
            LikeActionController.getControllerForObjectId(var1, var2, this.creationCallback);
         }
      }
   }

   private void tearDownObjectAssociations() {
      if (this.broadcastReceiver != null) {
         LocalBroadcastManager.a(this.getContext()).a(this.broadcastReceiver);
         this.broadcastReceiver = null;
      }

      if (this.creationCallback != null) {
         this.creationCallback.cancel();
         this.creationCallback = null;
      }

      this.likeActionController = null;
   }

   private void toggleLike() {
      if (this.likeActionController != null) {
         Activity var1 = null;
         if (this.parentFragment == null) {
            var1 = this.getActivity();
         }

         this.likeActionController.toggleLike(var1, this.parentFragment, this.getAnalyticsParameters());
      }
   }

   private void updateBoxCountCaretPosition() {
      switch (<unrepresentable>.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()]) {
         case 1:
            this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
            break;
         case 2:
            this.likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
            break;
         case 3:
            LikeBoxCountView var2 = this.likeBoxCountView;
            LikeBoxCountView.LikeBoxCountViewCaretPosition var1;
            if (this.horizontalAlignment == LikeView.HorizontalAlignment.RIGHT) {
               var1 = LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT;
            } else {
               var1 = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
            }

            var2.setCaretPosition(var1);
      }
   }

   private void updateLayout() {
      byte var2 = 1;
      LayoutParams var3 = (LayoutParams)this.containerView.getLayoutParams();
      android.widget.LinearLayout.LayoutParams var4 = (android.widget.LinearLayout.LayoutParams)this.likeButton.getLayoutParams();
      byte var1;
      if (this.horizontalAlignment == LikeView.HorizontalAlignment.LEFT) {
         var1 = 3;
      } else if (this.horizontalAlignment == LikeView.HorizontalAlignment.CENTER) {
         var1 = 1;
      } else {
         var1 = 5;
      }

      var3.gravity = var1 | 48;
      var4.gravity = var1;
      this.socialSentenceView.setVisibility(8);
      this.likeBoxCountView.setVisibility(8);
      Object var6;
      if (this.likeViewStyle == LikeView.Style.STANDARD
         && this.likeActionController != null
         && !Utility.isNullOrEmpty(this.likeActionController.getSocialSentence())) {
         var6 = this.socialSentenceView;
      } else {
         if (this.likeViewStyle != LikeView.Style.BOX_COUNT
            || this.likeActionController == null
            || Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())) {
            return;
         }

         this.updateBoxCountCaretPosition();
         var6 = this.likeBoxCountView;
      }

      var6.setVisibility(0);
      ((android.widget.LinearLayout.LayoutParams)var6.getLayoutParams()).gravity = var1;
      LinearLayout var7 = this.containerView;
      var1 = var2;
      if (this.auxiliaryViewPosition == LikeView.AuxiliaryViewPosition.INLINE) {
         var1 = 0;
      }

      var7.setOrientation(var1);
      if (this.auxiliaryViewPosition != LikeView.AuxiliaryViewPosition.TOP
         && (this.auxiliaryViewPosition != LikeView.AuxiliaryViewPosition.INLINE || this.horizontalAlignment != LikeView.HorizontalAlignment.RIGHT)) {
         this.containerView.removeView((View)var6);
         this.containerView.addView((View)var6);
      } else {
         this.containerView.removeView(this.likeButton);
         this.containerView.addView(this.likeButton);
      }

      switch (<unrepresentable>.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()]) {
         case 1:
            var6.setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
            break;
         case 2:
            var6.setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
            break;
         case 3:
            if (this.horizontalAlignment == LikeView.HorizontalAlignment.RIGHT) {
               var6.setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
            } else {
               var6.setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
            }
      }
   }

   private void updateLikeStateAndLayout() {
      boolean var1;
      if (!this.explicitlyDisabled) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (this.likeActionController == null) {
         this.likeButton.setSelected(false);
         this.socialSentenceView.setText(null);
         this.likeBoxCountView.setText(null);
      } else {
         this.likeButton.setSelected(this.likeActionController.isObjectLiked());
         this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
         this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
         var1 &= this.likeActionController.shouldEnableView();
      }

      super.setEnabled(var1);
      this.likeButton.setEnabled(var1);
      this.updateLayout();
   }

   public LikeView.OnErrorListener getOnErrorListener() {
      return this.onErrorListener;
   }

   protected void onDetachedFromWindow() {
      this.setObjectIdAndType(null, LikeView.ObjectType.UNKNOWN);
      super.onDetachedFromWindow();
   }

   public void setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition var1) {
      if (var1 == null) {
         var1 = LikeView.AuxiliaryViewPosition.DEFAULT;
      }

      if (this.auxiliaryViewPosition != var1) {
         this.auxiliaryViewPosition = var1;
         this.updateLayout();
      }
   }

   public void setEnabled(boolean var1) {
      if (!var1) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.explicitlyDisabled = var1;
      this.updateLikeStateAndLayout();
   }

   public void setForegroundColor(int var1) {
      if (this.foregroundColor != var1) {
         this.socialSentenceView.setTextColor(var1);
      }
   }

   public void setFragment(Fragment var1) {
      this.parentFragment = new FragmentWrapper(var1);
   }

   public void setFragment(android.support.v4.app.Fragment var1) {
      this.parentFragment = new FragmentWrapper(var1);
   }

   public void setHorizontalAlignment(LikeView.HorizontalAlignment var1) {
      if (var1 == null) {
         var1 = LikeView.HorizontalAlignment.DEFAULT;
      }

      if (this.horizontalAlignment != var1) {
         this.horizontalAlignment = var1;
         this.updateLayout();
      }
   }

   public void setLikeViewStyle(LikeView.Style var1) {
      if (var1 == null) {
         var1 = LikeView.Style.DEFAULT;
      }

      if (this.likeViewStyle != var1) {
         this.likeViewStyle = var1;
         this.updateLayout();
      }
   }

   public void setObjectIdAndType(String var1, LikeView.ObjectType var2) {
      var1 = Utility.coerceValueIfNullOrEmpty(var1, null);
      if (var2 == null) {
         var2 = LikeView.ObjectType.DEFAULT;
      }

      if (!Utility.areObjectsEqual(var1, this.objectId) || var2 != this.objectType) {
         this.setObjectIdAndTypeForced(var1, var2);
         this.updateLikeStateAndLayout();
      }
   }

   public void setOnErrorListener(LikeView.OnErrorListener var1) {
      this.onErrorListener = var1;
   }

   public enum AuxiliaryViewPosition {
      BOTTOM("bottom", 0),
      INLINE("inline", 1),
      TOP("top", 2);

      private static final LikeView.AuxiliaryViewPosition[] $VALUES = new LikeView.AuxiliaryViewPosition[]{
         LikeView.AuxiliaryViewPosition.BOTTOM, LikeView.AuxiliaryViewPosition.INLINE, LikeView.AuxiliaryViewPosition.TOP
      };
      static LikeView.AuxiliaryViewPosition DEFAULT = BOTTOM;
      private int intValue;
      private String stringValue;

      AuxiliaryViewPosition(String var3, int var4) {
         this.stringValue = var3;
         this.intValue = var4;
      }

      static LikeView.AuxiliaryViewPosition fromInt(int var0) {
         LikeView.AuxiliaryViewPosition[] var4 = values();
         int var2 = var4.length;
         int var1 = 0;

         LikeView.AuxiliaryViewPosition var3;
         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = var4[var1];
            if (var3.getValue() == var0) {
               break;
            }

            var1++;
         }

         return var3;
      }

      private int getValue() {
         return this.intValue;
      }

      @Override
      public String toString() {
         return this.stringValue;
      }
   }

   public enum HorizontalAlignment {
      CENTER("center", 0),
      LEFT("left", 1),
      RIGHT("right", 2);

      private static final LikeView.HorizontalAlignment[] $VALUES = new LikeView.HorizontalAlignment[]{
         LikeView.HorizontalAlignment.CENTER, LikeView.HorizontalAlignment.LEFT, LikeView.HorizontalAlignment.RIGHT
      };
      static LikeView.HorizontalAlignment DEFAULT = CENTER;
      private int intValue;
      private String stringValue;

      HorizontalAlignment(String var3, int var4) {
         this.stringValue = var3;
         this.intValue = var4;
      }

      static LikeView.HorizontalAlignment fromInt(int var0) {
         LikeView.HorizontalAlignment[] var4 = values();
         int var2 = var4.length;
         int var1 = 0;

         LikeView.HorizontalAlignment var3;
         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = var4[var1];
            if (var3.getValue() == var0) {
               break;
            }

            var1++;
         }

         return var3;
      }

      private int getValue() {
         return this.intValue;
      }

      @Override
      public String toString() {
         return this.stringValue;
      }
   }

   private class LikeActionControllerCreationCallback implements LikeActionController.CreationCallback {
      private boolean isCancelled;
      final LikeView this$0;

      private LikeActionControllerCreationCallback(LikeView var1) {
         this.this$0 = var1;
      }

      public void cancel() {
         this.isCancelled = true;
      }

      @Override
      public void onComplete(LikeActionController var1, FacebookException var2) {
         if (!this.isCancelled) {
            FacebookException var3 = var2;
            if (var1 != null) {
               if (!var1.shouldEnableView()) {
                  var2 = new FacebookException("Cannot use LikeView. The device may not be supported.");
               }

               this.this$0.associateWithLikeActionController(var1);
               this.this$0.updateLikeStateAndLayout();
               var3 = var2;
            }

            if (var3 != null && this.this$0.onErrorListener != null) {
               this.this$0.onErrorListener.onError(var3);
            }

            this.this$0.creationCallback = null;
         }
      }
   }

   private class LikeControllerBroadcastReceiver extends BroadcastReceiver {
      final LikeView this$0;

      private LikeControllerBroadcastReceiver(LikeView var1) {
         this.this$0 = var1;
      }

      public void onReceive(Context var1, Intent var2) {
         boolean var4 = true;
         String var6 = var2.getAction();
         Bundle var7 = var2.getExtras();
         boolean var3 = var4;
         if (var7 != null) {
            String var5 = var7.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
            var3 = var4;
            if (!Utility.isNullOrEmpty(var5)) {
               if (Utility.areObjectsEqual(this.this$0.objectId, var5)) {
                  var3 = var4;
               } else {
                  var3 = false;
               }
            }
         }

         if (var3) {
            if ("com.facebook.sdk.LikeActionController.UPDATED".equals(var6)) {
               this.this$0.updateLikeStateAndLayout();
            } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(var6)) {
               if (this.this$0.onErrorListener != null) {
                  this.this$0.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(var7));
               }
            } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(var6)) {
               this.this$0.setObjectIdAndTypeForced(this.this$0.objectId, this.this$0.objectType);
               this.this$0.updateLikeStateAndLayout();
            }
         }
      }
   }

   public enum ObjectType {
      OPEN_GRAPH("open_graph", 1),
      PAGE("page", 2),
      UNKNOWN("unknown", 0);

      private static final LikeView.ObjectType[] $VALUES = new LikeView.ObjectType[]{
         LikeView.ObjectType.UNKNOWN, LikeView.ObjectType.OPEN_GRAPH, LikeView.ObjectType.PAGE
      };
      public static LikeView.ObjectType DEFAULT = LikeView.ObjectType.UNKNOWN;
      private int intValue;
      private String stringValue;

      ObjectType(String var3, int var4) {
         this.stringValue = var3;
         this.intValue = var4;
      }

      public static LikeView.ObjectType fromInt(int var0) {
         LikeView.ObjectType[] var4 = values();
         int var2 = var4.length;
         int var1 = 0;

         LikeView.ObjectType var3;
         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = var4[var1];
            if (var3.getValue() == var0) {
               break;
            }

            var1++;
         }

         return var3;
      }

      public int getValue() {
         return this.intValue;
      }

      @Override
      public String toString() {
         return this.stringValue;
      }
   }

   public interface OnErrorListener {
      void onError(FacebookException var1);
   }

   public enum Style {
      BOX_COUNT("box_count", 2),
      BUTTON("button", 1),
      STANDARD("standard", 0);

      private static final LikeView.Style[] $VALUES = new LikeView.Style[]{LikeView.Style.STANDARD, LikeView.Style.BUTTON, LikeView.Style.BOX_COUNT};
      static LikeView.Style DEFAULT = LikeView.Style.STANDARD;
      private int intValue;
      private String stringValue;

      Style(String var3, int var4) {
         this.stringValue = var3;
         this.intValue = var4;
      }

      static LikeView.Style fromInt(int var0) {
         LikeView.Style[] var4 = values();
         int var2 = var4.length;
         int var1 = 0;

         LikeView.Style var3;
         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = var4[var1];
            if (var3.getValue() == var0) {
               break;
            }

            var1++;
         }

         return var3;
      }

      private int getValue() {
         return this.intValue;
      }

      @Override
      public String toString() {
         return this.stringValue;
      }
   }
}
