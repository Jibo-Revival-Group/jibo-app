package com.jibo.ui.fragment.invite;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.loop.model.UpdatePhoneticNameRequest;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

public class NamePronunciationFragment extends BaseLoopInviteFragment {
   public static final String a = LogUtils.a(NamePronunciationFragment.class);
   @BindView
   TextView mPhoneticNameTip;
   @BindView
   EditText mPhoneticNameView;
   @BindView
   TextView mTitleView;
   Member r;
   int s;
   private CircleProgressFragment t;
   private boolean u = false;
   private String v;

   public NamePronunciationFragment() {
      this.s = 0;
   }

   public static void a(BaseFragment var0, Loop var1, Member var2) {
      SingleFragmentActivity.Builder var3 = new SingleFragmentActivity.Builder(var0, NamePronunciationFragment.class.getName());
      var3.a("ARGS_SHOULD_RETURN_VALUE", true);
      var3.a(Loop.class.getSimpleName(), var1);
      var3.a(Member.class.getSimpleName(), var2);
      var3.a(MemberAccount.class.getSimpleName(), var2.getAccount());
      if (var2.getPhoneticName() != null) {
         var3.a("ARG_PHONETIC_NAME", var2.getPhoneticName());
      }

      var3.a(1021);
   }

   private void r() {
      if (!this.u && this.p != null) {
         boolean var1;
         if (!this.mPhoneticNameView.getText().toString().trim().isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.b(var1);
      }
   }

   @Override
   public void a() {
      new InputFilter(this) {
         final NamePronunciationFragment a;

         {
            this.a = var1;
         }

         public CharSequence filter(CharSequence var1, int var2, int var3, Spanned var4, int var5, int var6) {
            while (true) {
               if (var2 < var3) {
                  if (Character.isLetter(var1.charAt(var2))) {
                     var2++;
                     continue;
                  }

                  var1 = "";
               } else {
                  var1 = null;
               }

               return var1;
            }
         }
      };
      this.v = this.e;
      this.mPhoneticNameView.setText(this.e);
      if (this.r.getAccountId() != null && !this.r.getAccountId().equalsIgnoreCase(EntityData.a(this.getActivity()).i().getId())) {
         this.mTitleView.setText(2131755358);
         TextView var2 = this.mPhoneticNameTip;
         String var1;
         if (TextUtils.isEmpty(this.r.getNickname())) {
            var1 = this.n.getFirstName();
         } else {
            var1 = this.r.getNickname();
         }

         var2.setText(this.getString(2131755608, var1));
      } else {
         this.mTitleView.setText(2131755359);
         this.mPhoneticNameTip.setText(2131755609);
      }

      this.r();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayShowTitleEnabled(true);
      var1.setDisplayShowCustomEnabled(false);
      var1.setHomeAsUpIndicator(2131231362);
      this.n();
   }

   @Override
   public void b() {
      this.e();
      if (this.t == null) {
         this.t = new CircleProgressFragment();
         this.t.c(this.getString(2131755613));
         this.t.show(this.getFragmentManager(), "CircleFragment");
         this.t.a(new CircleProgressFragment.OnDismissListener(this) {
            final NamePronunciationFragment a;

            {
               this.a = var1;
            }

            @Override
            public void a(CircleProgressFragment.Status var1) {
               if (var1 == CircleProgressFragment.Status.Success && this.a.s == 0) {
                  NamePronunciationFragment var2 = this.a;
                  var2.s++;
                  new AlertDialog.Builder(this.a.getActivity()).a(2131755611).b(2131755610).a(17039370, null).b().show();
               }
            }
         });
      }

      this.e = this.mPhoneticNameView.getText().toString().trim();
      EntityData.a(this.getActivity())
         .b()
         .updatePhoneticName(this.k.getId(), this.m.getId(), this.e, new AsyncHandler<UpdatePhoneticNameRequest, CommandResponse>(this) {
            final NamePronunciationFragment a;

            {
               this.a = var1;
            }

            public void a(UpdatePhoneticNameRequest var1, CommandResponse var2) {
               this.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.t.a(this.a.a.getString(2131755614));
                     this.a.a.t = null;
                  }
               });
               ((SingleFragmentActivity)this.a.getActivity()).q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", this.a.e);
               this.a.getActivity().setResult(-1);
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "update phonetic name", true);
               this.a.t.b(this.a.getString(2131755612));
            }
         });
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.u = var1.getBoolean("ARGS_SHOULD_RETURN_VALUE");
      this.n = (MemberAccount)var1.getParcelable(MemberAccount.class.getSimpleName());
      this.r = (Member)var1.getParcelable(Member.class.getSimpleName());
   }

   @Override
   protected String o() {
      return this.getString(2131756055);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      this.p.setIcon(2131231002);
      ImageUtils.a(this.getActivity(), this.p, 2131099871);
      this.r();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.s = 0;
      return var1.inflate(2131427453, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296294 == var1.getItemId()) {
         this.b();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.l();
   }
}
