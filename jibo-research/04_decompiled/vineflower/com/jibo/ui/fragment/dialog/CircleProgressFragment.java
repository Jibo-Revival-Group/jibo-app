package com.jibo.ui.fragment.dialog;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleProgressFragment extends DialogFragment {
   private SpannableStringBuilder a;
   private CircleProgressFragment.Status b = CircleProgressFragment.Status.InProgress;
   private AnimationDrawable c;
   private AnimationDrawable d;
   private AnimationDrawable e;
   private CircleProgressFragment.OnDismissListener f;
   private Handler g = new Handler(Looper.getMainLooper());
   private final Runnable h = new Runnable(this) {
      final CircleProgressFragment a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         this.a.dismiss();
      }
   };
   private View i;
   private boolean j = false;
   @BindView
   ImageView mProgressCircle;
   @BindView
   ImageView mProgressFailure;
   @BindView
   TextView mProgressStatusText;
   @BindView
   ImageView mProgressSuccess;

   private void b() {
      if (this.getActivity() != null && this.isResumed() && !this.getActivity().isFinishing()) {
         this.getActivity().runOnUiThread(new Runnable(this) {
            final CircleProgressFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               TextView var2 = this.a.mProgressStatusText;
               byte var1;
               if (TextUtils.isEmpty(this.a.a)) {
                  var1 = 8;
               } else {
                  var1 = 0;
               }

               var2.setVisibility(var1);
               this.a.mProgressStatusText.setText(this.a.a);
               this.a.mProgressStatusText.setTextColor(this.a.getResources().getColor(2131099679));
               this.a.c.stop();
               this.a.mProgressCircle.setVisibility(8);
               this.a.mProgressSuccess.setVisibility(0);
               this.a.d.start();
               this.a.g.postDelayed(this.a.h, 1500L);
            }
         });
      } else {
         this.a();
      }
   }

   private void c() {
      if (this.getActivity() != null && this.isResumed() && !this.getActivity().isFinishing()) {
         this.getActivity().runOnUiThread(new Runnable(this) {
            final CircleProgressFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               TextView var2 = this.a.mProgressStatusText;
               byte var1;
               if (TextUtils.isEmpty(this.a.a)) {
                  var1 = 8;
               } else {
                  var1 = 0;
               }

               var2.setVisibility(var1);
               this.a.mProgressStatusText.setText(this.a.a);
               this.a.mProgressStatusText.setTextColor(this.a.getResources().getColor(2131099764));
               this.a.c.stop();
               this.a.mProgressFailure.setVisibility(0);
               this.a.mProgressCircle.setVisibility(8);
               this.a.e.start();
               this.a.g.postDelayed(this.a.h, 2000L);
            }
         });
      } else {
         this.a();
      }
   }

   public void a() {
      try {
         if (this.getActivity() != null && this.isResumed() && !this.isDetached() && !this.getActivity().isFinishing()) {
            super.dismiss();
         }
      } catch (Exception var2) {
      }
   }

   public void a(SpannableStringBuilder var1) {
      this.b = CircleProgressFragment.Status.Success;
      this.c(var1);
      this.j = true;
      this.b();
   }

   public void a(CircleProgressFragment.OnDismissListener var1) {
      this.f = var1;
   }

   public void a(String var1) {
      this.a(new SpannableStringBuilder(var1));
   }

   public void b(SpannableStringBuilder var1) {
      this.b = CircleProgressFragment.Status.Failure;
      this.c(var1);
      this.j = true;
      this.c();
   }

   public void b(String var1) {
      this.b(new SpannableStringBuilder(var1));
   }

   public void c(SpannableStringBuilder var1) {
      this.a = var1;
   }

   public void c(String var1) {
      this.a = new SpannableStringBuilder(var1);
   }

   @Override
   public void dismiss() {
      if (this.f != null) {
         this.f.a(this.b);
      }

      this.a();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      AppCompatDialog var4 = new AppCompatDialog(this.getActivity(), 16973833);
      this.i = this.getActivity().getLayoutInflater().inflate(2131427414, null);
      ButterKnife.a(this, this.i);
      this.c = (AnimationDrawable)this.mProgressCircle.getDrawable();
      this.d = (AnimationDrawable)this.mProgressSuccess.getDrawable();
      this.e = (AnimationDrawable)this.mProgressFailure.getDrawable();
      this.mProgressCircle.post(new Runnable(this) {
         final CircleProgressFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.c.start();
         }
      });
      TextView var3 = this.mProgressStatusText;
      byte var2;
      if (TextUtils.isEmpty(this.a)) {
         var2 = 8;
      } else {
         var2 = 0;
      }

      var3.setVisibility(var2);
      this.mProgressStatusText.setText(this.a);
      this.setCancelable(false);
      var4.setContentView(this.i);
      var4.setCancelable(false);
      return var4;
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
   }

   @Override
   public void onPause() {
      super.onPause();
      this.g.removeCallbacksAndMessages(null);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.b != CircleProgressFragment.Status.InProgress) {
         this.j = false;
         if (this.b == CircleProgressFragment.Status.Success) {
            this.b();
         } else if (this.b == CircleProgressFragment.Status.Failure) {
            this.c();
         }
      }

      if (VERSION.SDK_INT >= 21) {
         this.i.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
            final CircleProgressFragment a;

            {
               this.a = var1;
            }

            @TargetApi(21)
            public void onLayoutChange(View var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
               var1.removeOnLayoutChangeListener(this);
               if (this.a.b == CircleProgressFragment.Status.Success) {
                  this.a.a(this.a.a);
               } else if (this.a.b == CircleProgressFragment.Status.Failure) {
                  this.a.b(this.a.a);
               }
            }
         });
      }
   }

   public interface OnDismissListener {
      void a(CircleProgressFragment.Status var1);
   }

   public enum Status {
      Failure,
      InProgress,
      Success;

      private static final CircleProgressFragment.Status[] $VALUES = new CircleProgressFragment.Status[]{
         CircleProgressFragment.Status.InProgress, CircleProgressFragment.Status.Success, CircleProgressFragment.Status.Failure
      };
   }
}
