package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.ui.activity.WifiActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

public class JiboPreparationsFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(JiboPreparationsFragment.class);
   public static final int[] b = new int[]{2131297079, 2131297080, 2131297081, 2131297082};
   public static final int[] c = new int[]{2131296364, 2131296350, 2131296382, 2131296383};
   @BindView
   ImageView checkmarkImage;
   @BindView
   ImageView closeButton;
   private int l = 0;
   @BindView
   View progressView;

   private void a(int var1) {
      this.getView().findViewById(b[var1]).setAlpha(0.0F);
      this.getView().findViewById(b[var1]).setVisibility(8);
      this.getView().findViewById(c[var1]).setEnabled(false);
      this.getView().findViewById(b[var1 + 1]).setAlpha(0.0F);
      this.getView().findViewById(b[var1 + 1]).setVisibility(0);
      this.checkmarkImage
         .animate()
         .scaleX(0.7F)
         .scaleY(0.7F)
         .setStartDelay(200L)
         .setInterpolator(new AnticipateInterpolator())
         .setDuration(500L)
         .withEndAction(new Runnable(this, var1) {
            final int a;
            final JiboPreparationsFragment b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void run() {
               this.b.getView().findViewById(JiboPreparationsFragment.c[this.a + 1]).setEnabled(true);
            }
         })
         .start();
      this.getView()
         .findViewById(b[var1 + 1])
         .animate()
         .setInterpolator(new AccelerateInterpolator())
         .setStartDelay(200L)
         .alpha(1.0F)
         .setDuration(600L)
         .start();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.k();
   }

   @OnClick
   public void btnNextScreenClick(View var1) {
      var1.setEnabled(false);
      this.checkmarkImage.setScaleX(0.5F);
      this.checkmarkImage.setScaleY(0.5F);
      this.checkmarkImage.setPivotX(this.checkmarkImage.getWidth() / 2);
      this.checkmarkImage.setPivotX(this.checkmarkImage.getHeight() / 2);
      this.getView().findViewById(b[this.l]).animate().alpha(0.0F).setDuration(500L).start();
      if (this.l == 0) {
         this.a(this.l);
         this.l++;
      } else {
         this.progressView.animate().alpha(1.0F).setDuration(700L).start();
         this.checkmarkImage.animate().scaleX(1.0F).scaleY(1.0F).setInterpolator(new BounceInterpolator()).setDuration(800L).withEndAction(new Runnable(this) {
            final JiboPreparationsFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               if (this.a.d()) {
                  if (this.a.l == 3) {
                     this.a.c().postDelayed(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           ((WifiActivity)this.a.a.getActivity()).q();
                        }
                     }, 600L);
                  } else {
                     this.a.a(this.a.l);
                     this.a.progressView.animate().alpha(0.0F).setDuration(600L).setStartDelay(200L).start();
                     this.a.l++;
                  }
               }
            }
         }).start();
      }
   }

   @Override
   public boolean h() {
      this.getActivity().finish();
      return true;
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onCloseClick(View var1) {
      this.h();
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.l = var1.getInt("ARG_STEP", 0);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427484, var2, false);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putInt("ARG_STEP", this.l);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.closeButton.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099771));
      this.checkmarkImage.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231044, 2131099871));
      this.getView().findViewById(b[this.l]).setAlpha(1.0F);
      this.getView().findViewById(b[this.l]).setVisibility(0);
      this.getView().findViewById(c[this.l]).setEnabled(true);
   }

   public static class JiboPreparationsStartFragment extends Fragment {
      private final int[] a = new int[]{2131296456, 2131296457, 2131296458};
      @BindView
      TextView title;

      @Override
      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         return var1.inflate(2131427580, var2, false);
      }

      @Override
      public void onViewCreated(View var1, Bundle var2) {
         super.onViewCreated(var1, var2);
         ButterKnife.a(this, var1);
         float var3 = this.getResources().getConfiguration().fontScale;
         this.title.setTextSize(0, this.title.getTextSize() / var3);
         int[] var7 = this.a;
         int var5 = var7.length;

         for (int var4 = 0; var4 < var5; var4++) {
            LayoutParams var8 = (LayoutParams)var1.findViewById(var7[var4]).getLayoutParams();
            int var6 = var8.topMargin;
            var8.setMargins(var8.leftMargin, (int)(var6 / (var3 * var3)), var8.rightMargin, var8.bottomMargin);
         }
      }
   }
}
