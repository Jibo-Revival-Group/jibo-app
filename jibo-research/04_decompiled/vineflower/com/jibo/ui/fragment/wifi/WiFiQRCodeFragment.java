package com.jibo.ui.fragment.wifi;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar.OnSeekBarChangeListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.QRCodeWriter;

public class WiFiQRCodeFragment extends WiFiBaseQRCodeFragment {
   public static final String p = LogUtils.a(WiFiQRCodeFragment.class);
   @BindView
   View brightnessLess;
   @BindView
   View brightnessMore;
   @BindView
   View brightnessPanel;
   @BindView
   SeekBar brightnessSeekbar;
   @BindView
   ImageView btnDone;
   @BindView
   ImageView btnDone1;
   @BindView
   TextView btnNextCode;
   @BindView
   TextView btnPrevCode;
   @BindView
   View buttonsPanel;
   @BindView
   View multiCodeToolbar;
   @BindView
   View singleCodeToolbar;
   @BindView
   TextView txtProgress;
   @BindView
   View txtSingleCodeTitle;

   private void t() {
      this.txtSingleCodeTitle.setVisibility(8);
      this.singleCodeToolbar.setVisibility(4);
      this.multiCodeToolbar.setVisibility(8);
      this.btnNextCode.setEnabled(false);
      this.btnPrevCode.setEnabled(false);
      this.buttonsPanel.setVisibility(8);
      int var1;
      if (this.l >= this.m.size() - 1) {
         var1 = this.m.size() - 1;
      } else {
         var1 = this.l;
      }

      this.l = var1;
      if (this.l < 0) {
         var1 = 0;
      } else {
         var1 = this.l;
      }

      this.l = var1;
      if (this.m.size() > 1) {
         this.btnDone1.setVisibility(8);
         this.btnNextCode.setVisibility(0);
         this.multiCodeToolbar.setVisibility(0);
         this.txtProgress.setText(String.valueOf(this.l + 1));
         this.buttonsPanel.setVisibility(0);
         if (this.l + 1 < this.m.size()) {
            this.btnNextCode.setEnabled(true);
         }

         if (this.l - 1 >= 0) {
            this.btnPrevCode.setEnabled(true);
         }

         if (this.l == this.m.size() - 1) {
            this.btnNextCode.setVisibility(8);
            this.btnDone1.setVisibility(0);
         }

         this.brightnessLess
            .setLayoutParams(new LayoutParams(this.getResources().getDimensionPixelSize(2131165464), this.getResources().getDimensionPixelSize(2131165464)));
         this.brightnessMore
            .setLayoutParams(new LayoutParams(this.getResources().getDimensionPixelSize(2131165464), this.getResources().getDimensionPixelSize(2131165464)));
      } else {
         this.singleCodeToolbar.setVisibility(0);
         this.txtSingleCodeTitle.setVisibility(0);
         this.brightnessLess
            .setLayoutParams(new LayoutParams(this.getResources().getDimensionPixelSize(2131165463), this.getResources().getDimensionPixelSize(2131165463)));
         this.brightnessMore
            .setLayoutParams(new LayoutParams(this.getResources().getDimensionPixelSize(2131165463), this.getResources().getDimensionPixelSize(2131165463)));
      }

      FragmentTransaction var2 = this.getChildFragmentManager().a();
      Bundle var3 = new Bundle();
      var3.putInt("ARG_INDX", this.l + 1);
      var3.putInt("ARG_COUNT", this.m.size());
      var3.putString("ARG_DATA", this.m.get(this.l));
      var2.b(2131296574, Fragment.instantiate(this.getActivity(), WiFiQRCodeFragment.QrCodeFragment.class.getName(), var3));
      var2.d();
      this.c().postDelayed(new Runnable(this) {
         final WiFiQRCodeFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.brightnessPanel.setVisibility(0);
         }
      }, 200L);
   }

   private void u() {
      android.view.WindowManager.LayoutParams var1 = this.getActivity().getWindow().getAttributes();
      var1.screenBrightness = 0.75F;
      this.getActivity().getWindow().setAttributes(var1);
      this.brightnessSeekbar.setMax(100);
      this.brightnessSeekbar.setProgress(75);
      this.brightnessSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
         final WiFiQRCodeFragment a;

         {
            this.a = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            android.view.WindowManager.LayoutParams var4 = this.a.getActivity().getWindow().getAttributes();
            var4.screenBrightness = var2 / 100.0F;
            this.a.getActivity().getWindow().setAttributes(var4);
         }

         public void onStartTrackingTouch(SeekBar var1) {
         }

         public void onStopTrackingTouch(SeekBar var1) {
         }
      });
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onBtnDoneClick(View var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      var2.putSerializable(TokenContainer.class.getSimpleName(), this.n);
      ((BaseActivity)this.getActivity()).a(WiFiJiboConnectingFragment.class, var2);
   }

   @OnClick
   public void onBtnNextCodeClick(View var1) {
      this.l++;
      this.t();
   }

   @OnClick
   public void onBtnPrevCodeClick(View var1) {
      this.l--;
      this.t();
   }

   @OnClick
   public void onCloseClick() {
      this.h();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427488, var2, false);
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.b();
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296296 == var1.getItemId()) {
         ((BaseActivity)this.getActivity()).c(WiFiHelpFragment.class, null);
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPause() {
      super.onPause();
   }

   @Override
   public void onResume() {
      super.onResume();
      this.a();
      this.q();
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.btnDone.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231002, 2131099771));
      this.btnDone1.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231002, 2131099771));
      this.u();
   }

   @Override
   protected void s() {
      if (this.d()) {
         this.t();
      }
   }

   public static final class QrCodeFragment extends Fragment {
      Unbinder a;
      private int b;
      private int c;
      private String d;
      @BindView
      ImageView imageQRCode;
      @BindView
      View placeholder;
      @BindView
      TextView text1;

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void a() {
         int var15;
         BitMatrix var19;
         label66: {
            try {
               Display var7 = ((WindowManager)this.getActivity().getSystemService("window")).getDefaultDisplay();
               Point var8 = new Point();
               var7.getSize(var8);
               var15 = var8.x;
               int var2 = var8.y;
               var15 -= this.getResources().getDimensionPixelSize(2131165265) * 2;
               QRCodeWriter var17 = new QRCodeWriter();
               var19 = var17.a(this.d, BarcodeFormat.QR_CODE, var15, var15);
               if (VERSION.SDK_INT >= 23) {
                  var15 = this.getResources().getColor(17170444, this.getActivity().getTheme());
                  break label66;
               }
            } catch (WriterException var13) {
               LogUtils.a(WiFiQRCodeFragment.p, "generateCode", var13);
               return;
            }

            try {
               var15 = this.getResources().getColor(17170444);
            } catch (WriterException var12) {
               LogUtils.a(WiFiQRCodeFragment.p, "generateCode", var12);
               return;
            }
         }

         int var5;
         int var6;
         int[] var18;
         try {
            var6 = var19.a();
            var5 = var19.b();
            var18 = new int[var6 * var5];
         } catch (WriterException var11) {
            LogUtils.a(WiFiQRCodeFragment.p, "generateCode", var11);
            return;
         }

         int var16 = 0;

         while (true) {
            if (var16 >= var5) {
               try {
                  Bitmap var20 = Bitmap.createBitmap(var6, var5, Config.ARGB_8888);
                  var20.setPixels(var18, 0, var6, 0, 0, var6, var5);
                  this.imageQRCode.setImageBitmap(var20);
               } catch (WriterException var9) {
                  LogUtils.a(WiFiQRCodeFragment.p, "generateCode", var9);
               }
               break;
            }

            for (int var3 = 0; var3 < var6; var3++) {
               int var4;
               label43: {
                  label42: {
                     try {
                        if (var19.a(var3, var16)) {
                           break label42;
                        }
                     } catch (WriterException var10) {
                        LogUtils.a(WiFiQRCodeFragment.p, "generateCode", var10);
                        return;
                     }

                     var4 = -1;
                     break label43;
                  }

                  var4 = var15;
               }

               var18[var16 * var6 + var3] = var4;
            }

            var16++;
         }
      }

      @Override
      public void onCreate(Bundle var1) {
         super.onCreate(var1);
         if (this.getArguments() != null) {
            this.b = this.getArguments().getInt("ARG_COUNT", 1);
            this.c = this.getArguments().getInt("ARG_INDX", 1);
            this.d = this.getArguments().getString("ARG_DATA", "");
         }
      }

      @Override
      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         return var1.inflate(2131427489, var2, false);
      }

      @Override
      public void onDestroyView() {
         super.onDestroyView();
         this.a.unbind();
      }

      @Override
      public void onViewCreated(View var1, Bundle var2) {
         super.onViewCreated(var1, var2);
         this.a = ButterKnife.a(this, var1);
         int var4;
         if (this.b == 1) {
            var4 = 2131755547;
         } else {
            var4 = -1;
         }

         int var3 = var4;
         if (var4 == -1) {
            if (this.c == 1) {
               var3 = 2131755548;
            } else if (this.c == this.b) {
               var3 = 2131755550;
            } else {
               var3 = 2131755549;
            }
         }

         this.text1.setText(var3);
         if (this.b > 1) {
            this.placeholder.setVisibility(0);
            this.text1.setMinLines(3);
            this.text1
               .setPadding(
                  this.getResources().getDimensionPixelSize(2131165265),
                  0,
                  this.getResources().getDimensionPixelSize(2131165265),
                  this.getResources().getDimensionPixelSize(2131165265)
               );
         } else {
            this.placeholder.setVisibility(8);
            this.text1.setMinLines(0);
            this.text1
               .setPadding(
                  this.getResources().getDimensionPixelSize(2131165265),
                  this.getResources().getDimensionPixelSize(2131165263),
                  this.getResources().getDimensionPixelSize(2131165265),
                  0
               );
         }

         this.a();
      }
   }
}
