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
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.ui.view.proxima.ProximaHelper;

public class PhoneEditFragment extends PhoneBaseFragment {
   public static final String l = PhoneEditFragment.class.getSimpleName();
   @BindView
   EditText phone;

   @Override
   protected void a() {
      if (this.b != null && this.c != null) {
         CustomFontTextView var2 = this.c;
         boolean var1;
         if (this.a(this.b()).length() == 10) {
            var1 = true;
         } else {
            var1 = false;
         }

         var2.setEnabled(var1);
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String b() {
      return this.phone.getText().toString().trim();
   }

   @Override
   protected String o() {
      return this.getString(2131756061);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492874, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296281);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427455, var2, false);
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      if (this.b != null && this.b.getActionView() != null) {
         this.c = (CustomFontTextView)this.b.getActionView();
         ProximaHelper.b(this.c);
         this.c.setTextColor(-1);
         this.c.setText(this.getString(2131755050).toUpperCase());
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

         this.c.setOnClickListener(new OnClickListener(this) {
            final PhoneEditFragment a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.b(this.a.e);
            }
         });
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher(this) {
         final PhoneEditFragment a;

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
      if (this.getArguments() != null && var2 == null) {
         this.phone.setText(this.getArguments().getString("PARAM_PHONENUMBER").replace("+1", ""));
      }
   }
}
