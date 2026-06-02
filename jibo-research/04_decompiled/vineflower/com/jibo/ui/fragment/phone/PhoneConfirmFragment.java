package com.jibo.ui.fragment.phone;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.VerifyPhoneByCodeRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;

public class PhoneConfirmFragment extends PhoneBaseFragment {
   public static final String l = PhoneConfirmFragment.class.getSimpleName();
   @BindView
   EditText code;
   @BindView
   TextView footer1;
   @BindView
   TextView footer_error;
   private String m;

   private void q() {
      this.f();
      this.e();
      EntityData.a(this.getActivity()).a().verifyPhoneByCode(this.code.getText().toString().trim(), new AsyncHandler<VerifyPhoneByCodeRequest, Account>(this) {
         final PhoneConfirmFragment a;

         {
            this.a = var1;
         }

         public void a(VerifyPhoneByCodeRequest var1, Account var2) {
            this.a.g();
            JiboAnalytics.c(this.a.getActivity());
            this.a.a(new Runnable(this, var2) {
               final Account a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  this.a.setAccessKeyId(EntityData.a(this.b.a.getActivity()).i().getAccessKeyId());
                  this.a.setSecretAccessKey(EntityData.a(this.b.a.getActivity()).i().getSecretAccessKey());
                  EntityData.a(this.b.a.getActivity()).a(this.a, true, null);
                  if (this.b.a.d) {
                     if (this.b.a.getActivity() instanceof SingleFragmentActivity) {
                        ((SingleFragmentActivity)this.b.a.getActivity()).q().putExtra(Account.class.getSimpleName(), this.a);
                     }

                     this.b.a.getActivity().finish();
                  } else {
                     ((OnBoardingActivity)this.b.a.getActivity()).s();
                  }
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(new Runnable(this, var1) {
               final Exception a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  AmazonServiceException var1x = (AmazonServiceException)this.a;
                  if ("TOKEN_NOT_FOUND".equals(var1x.getErrorCode())) {
                     this.b.a.footer_error.setVisibility(0);
                     this.b.a.footer1.setVisibility(8);
                     this.b.a.footer_error.setText(2131755313);
                  } else if ("PHONE_TOKEN_EXPIRED".equals(var1x.getErrorCode())) {
                     this.b.a.footer_error.setVisibility(0);
                     this.b.a.footer1.setVisibility(8);
                     this.b.a.footer_error.setText(2131755312);
                  } else {
                     this.b.a.footer_error.setVisibility(8);
                     this.b.a.footer1.setVisibility(0);
                  }

                  this.b.a.a(this.a, "verify phone by code", false);
               }
            });
         }
      });
   }

   @Override
   protected void a() {
      int var1 = -1;
      boolean var2 = true;
      boolean var3 = true;
      if (this.c != null) {
         if (this.d) {
            this.c.setText(this.getString(2131755051).toUpperCase());
            CustomFontTextView var4 = this.c;
            if (this.code.length() == 6) {
               var2 = var3;
            } else {
               var2 = false;
            }

            var4.setEnabled(var2);
            var4 = this.c;
            if (this.c.isEnabled()) {
               var1 = -1;
            } else {
               var1 = ImageUtils.b(this.getActivity(), 2131099772);
            }

            var4.setTextColor(var1);
         } else if (this.code.length() > 0) {
            this.c.setText(this.getString(2131755050).toUpperCase());
            CustomFontTextView var8 = this.c;
            if (this.code.length() != 6) {
               var2 = false;
            }

            var8.setEnabled(var2);
            var8 = this.c;
            if (!this.c.isEnabled()) {
               var1 = ImageUtils.b(this.getActivity(), 2131099772);
            }

            var8.setTextColor(var1);
         } else {
            this.c.setText(this.getString(2131755053));
            this.c.setTextColor(ImageUtils.b(this.getActivity(), 2131099672));
            this.c.setEnabled(true);
         }
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      if (var2 == -1) {
         if (this.d) {
            this.getFragmentManager().d();
         } else {
            ((OnBoardingActivity)this.getActivity()).s();
         }
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected String b() {
      return this.m.trim();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.m = var1.getString("PARAM_PHONENUMBER");
   }

   @Override
   public boolean h() {
      boolean var1;
      if (this.d) {
         DialogUtils.a(
            this,
            this.getFragmentManager(),
            104,
            this.getString(2131755274),
            this.getString(2131755265),
            this.getString(2131755053),
            this.getString(2131755083)
         );
         var1 = true;
      } else {
         var1 = super.h();
      }

      return var1;
   }

   @Override
   protected String o() {
      return this.getString(2131756060);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492874, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296281);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427454, var2, false);
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      if (this.b != null && this.b.getActionView() != null) {
         this.c = (CustomFontTextView)this.b.getActionView();
         ProximaHelper.b(this.c);
         this.a();
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
                  final PhoneConfirmFragment a;

                  {
                     this.a = var1;
                  }

                  public void onClick(View var1) {
                     if (this.a.c.getText().toString().equals(this.a.getString(2131755053))) {
                        DialogUtils.a(
                           this.a,
                           this.a.getFragmentManager(),
                           104,
                           this.a.getString(2131755274),
                           this.a.getString(2131755264),
                           this.a.getString(2131755053),
                           this.a.getString(2131755083)
                        );
                     } else {
                        this.a.q();
                     }
                  }
               }
            );
      }
   }

   @OnClick
   public void onResendCode(View var1) {
      this.b(new Runnable(this) {
         final PhoneConfirmFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
         }
      });
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString("PARAM_PHONENUMBER", this.m);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.code.addTextChangedListener(new TextWatcher(this) {
         final PhoneConfirmFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
            this.a.a();
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }
      });
   }
}
