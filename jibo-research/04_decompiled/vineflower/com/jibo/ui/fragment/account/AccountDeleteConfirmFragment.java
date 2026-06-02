package com.jibo.ui.fragment.account;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.RemoveRequest;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.utils.ImageUtils;

public class AccountDeleteConfirmFragment extends BaseFragment {
   public static final String a = AccountDeleteConfirmFragment.class.getSimpleName();
   boolean b;
   private final int[] c = new int[]{2131296456, 2131296457, 2131296458, 2131296581};
   @BindView
   ImageView closeButton;
   @BindView
   ImageView cross1;
   @BindView
   ImageView cross2;
   @BindView
   ImageView cross3;
   @BindView
   ImageView cross4;
   private CircleProgressFragment d;
   @BindView
   View hideWarning;
   @BindView
   CustomFontTextView title;
   @BindView
   CustomFontTextView warning1;
   @BindView
   CustomFontTextView warning2;
   @BindView
   CustomFontTextView warning3;

   public AccountDeleteConfirmFragment() {
      this.b = false;
   }

   private void a() {
      if (this.d != null) {
         this.d.a();
         this.d = null;
      }

      this.d = new CircleProgressFragment();
      this.d.c(this.getString(2131755534));
      this.d.a(new CircleProgressFragment.OnDismissListener(this) {
         final AccountDeleteConfirmFragment a;

         {
            this.a = var1;
         }

         @Override
         public void a(CircleProgressFragment.Status var1) {
            if (var1 == CircleProgressFragment.Status.Success) {
               String var3;
               if (this.a.getArguments() != null) {
                  var3 = this.a.getArguments().getString(JiboAnalytics.ak, "");
               } else {
                  var3 = "";
               }

               Bundle var2 = new Bundle();
               var2.putString(JiboAnalytics.ak, var3);
               ((BaseActivity)this.a.getActivity()).a(AccountDeletedFragment.class, var2);
            }
         }
      });
      this.d.show(this.getActivity().getSupportFragmentManager(), CircleProgressFragment.class.getSimpleName());
   }

   private void a(String var1, boolean var2) {
      if (this.d != null) {
         if (var2) {
            this.d.a(var1);
         } else {
            this.d.b(var1);
         }

         this.d = null;
      }
   }

   @Override
   protected void a(ActionBar var1) {
   }

   @Override
   public boolean h() {
      this.onCloseButtonClick();
      return true;
   }

   @Override
   protected String o() {
      return "";
   }

   @OnClick
   public void onBtnDelete() {
      this.a();
      EntityData.a(this.getActivity()).a().remove(new AsyncHandler<RemoveRequest, Account>(this) {
         final AccountDeleteConfirmFragment a;

         {
            this.a = var1;
         }

         public void a(RemoveRequest var1, Account var2) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  KeyManager.getInstance(this.a.a.getActivity(), EntityData.a(this.a.a.getActivity()).i().getId()).deleteAccountData(this.a.a.getActivity());
                  String var1x;
                  if (this.a.a.getArguments() != null) {
                     var1x = this.a.a.getArguments().getString(JiboAnalytics.ak, "");
                  } else {
                     var1x = "";
                  }

                  JiboAnalytics.b(this.a.a.getActivity());
                  JiboAnalytics.d(this.a.a.getActivity(), var1x);
                  this.a.a.a(this.a.a.getString(2131755539), true);
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "account remove", false);
            this.a.a(this.a.getString(2131755535), false);
         }
      });
   }

   @OnClick
   public void onCloseButtonClick() {
      this.getActivity().finish();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.k();
      if (this.getArguments() != null && this.getArguments().containsKey("ARG_IS_OWNER_AND_SUSPENDED")) {
         this.b = this.getArguments().getBoolean("ARG_IS_OWNER_AND_SUSPENDED");
      }

      return var1.inflate(2131427420, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.closeButton.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099771));
      this.cross1.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099764));
      this.cross2.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099764));
      this.cross3.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099764));
      this.cross4.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231362, 2131099764));
      if (this.b) {
         this.hideWarning.setVisibility(0);
         this.title.setText(2131755066);
         this.warning1.setText(2131755247);
         this.warning2.setText(2131755249);
         this.warning3.setText(2131755248);
      } else {
         this.hideWarning.setVisibility(8);
         this.warning1.setText(2131755889);
         this.warning2.setText(2131755888);
         this.warning3.setText(2131755890);
      }

      float var3 = this.getResources().getConfiguration().fontScale;
      if (var3 > 1.0F) {
         int[] var7 = this.c;
         int var5 = var7.length;

         for (int var4 = 0; var4 < var5; var4++) {
            LayoutParams var8 = (LayoutParams)var1.findViewById(var7[var4]).getLayoutParams();
            int var6 = var8.topMargin;
            var8.setMargins(var8.leftMargin, (int)(var6 / var3), var8.rightMargin, var8.bottomMargin);
         }
      }
   }
}
