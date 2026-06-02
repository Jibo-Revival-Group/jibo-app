package com.jibo.ui.fragment.phone;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;

public class PhoneFillFragment extends PhoneBaseFragment {
   public static final String l = PhoneFillFragment.class.getSimpleName();
   @BindView
   View btnNext;
   @BindView
   EditText phone;

   @Override
   protected void a() {
      View var2 = this.btnNext;
      boolean var1;
      if (this.a(this.b()).length() == 10) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.setEnabled(var1);
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      if (var2 == -1 && !this.d) {
         ((OnBoardingActivity)this.getActivity()).s();
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      boolean var2;
      if (!(this.getActivity() instanceof OnBoardingActivity)) {
         var2 = true;
      } else {
         var2 = false;
      }

      var1.setDisplayHomeAsUpEnabled(var2);
      this.l();
   }

   @Override
   protected String b() {
      return this.phone.getText().toString().trim();
   }

   @Override
   protected String o() {
      return this.getString(2131756062);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      if (!this.d) {
         var2.inflate(2131492874, var1);
         super.onCreateOptionsMenu(var1, var2);
         this.b = var1.findItem(2131296281);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427456, var2, false);
   }

   @OnClick
   public void onNext(View var1) {
      this.b(this.e);
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      if (this.b != null && this.b.getActionView() != null) {
         this.c = (CustomFontTextView)this.b.getActionView();
         ProximaHelper.b(this.c);
         this.c.setTextColor(ImageUtils.b(this.getActivity(), 2131099672));
         this.c.setText(this.getString(2131755053));
         this.c.setTextSize(2, 15.0F);
         this.c
            .setPadding(
               this.getResources().getDimensionPixelSize(2131165265),
               this.getResources().getDimensionPixelSize(2131165267),
               this.getResources().getDimensionPixelSize(2131165265),
               this.getResources().getDimensionPixelSize(2131165267)
            );
         if (VERSION.SDK_INT >= 21) {
            this.c.setLetterSpacing(0.12F);
         }

         this.c
            .setOnClickListener(
               new OnClickListener(this) {
                  final PhoneFillFragment a;

                  {
                     this.a = var1;
                  }

                  public void onClick(View var1) {
                     DialogUtils.a(
                        this.a,
                        this.a.getFragmentManager(),
                        104,
                        this.a.getString(2131755274),
                        this.a.getString(2131755264),
                        this.a.getString(2131755053),
                        this.a.getString(2131755083)
                     );
                  }
               }
            );
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher(this) {
         final PhoneFillFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
            synchronized (this) {
               super.afterTextChanged(var1);
               this.a.a();
            }
         }
      });
   }
}
