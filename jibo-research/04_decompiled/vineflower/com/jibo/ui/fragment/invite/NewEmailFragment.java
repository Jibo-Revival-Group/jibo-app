package com.jibo.ui.fragment.invite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.dialog.AlreadyInTheLoopDialog;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import java.util.Iterator;
import java.util.List;

public class NewEmailFragment extends BaseSuggestionFragment {
   public static final String r = LogUtils.a(NewEmailFragment.class);
   @BindView
   AutoCompleteTextView email;
   @BindView
   TextView footer;
   private Member s;
   private EmailFragment.LaunchMode t = EmailFragment.LaunchMode.send_invite;
   @BindView
   TextView title;

   private void r() {
      if (this.s()) {
         AlreadyInTheLoopDialog var3 = new AlreadyInTheLoopDialog();
         Bundle var2 = new Bundle();
         var2.putParcelable(Loop.class.getSimpleName(), this.k);
         var2.putParcelable(Account.class.getSimpleName(), this.c);
         var3.setArguments(var2);
         var3.show(this.getActivity().getSupportFragmentManager(), AlreadyInTheLoopDialog.class.getSimpleName());
      } else {
         if (this.j == null) {
            this.j = new CircleProgressFragment();
            this.j.c(this.getString(2131755652));
            this.j.a(new CircleProgressFragment.OnDismissListener(this) {
               final NewEmailFragment a;

               {
                  this.a = var1;
               }

               @Override
               public void a(CircleProgressFragment.Status var1) {
                  Intent var2 = new Intent();
                  this.a.getActivity().setResult(-1, var2);
                  this.a.getActivity().finish();
               }
            });
            this.j.show(this.getActivity().getSupportFragmentManager(), "CircleFragment");
         }

         JiboLoopAsyncClient var7 = EntityData.a(this.getActivity()).b();
         String var6 = this.k.getId();
         String var4 = this.s.getId();
         String var5 = this.s.getAccount().getEmail();
         boolean var1;
         if (!DateTimeUtils.isAdult(this.s.getAccount().getBirthday())) {
            var1 = true;
         } else {
            var1 = false;
         }

         var7.updateMember(var6, var4, var5, null, null, null, null, var1, new AsyncHandler<UpdateMemberRequest, Loop>(this) {
            final NewEmailFragment a;

            {
               this.a = var1;
            }

            public void a(UpdateMemberRequest var1, Loop var2) {
               this.a.j.a(this.a.getString(2131755324));
               this.a.s.setStatus(Member.InvitationStatus.invited);
               this.a.a(new Runnable(this, var1) {
                  final UpdateMemberRequest a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     Intent var1x = new Intent();
                     var1x.putExtra("ARGS_CHOSEN_EMAIL", this.a.getEmail());
                     this.b.a.getActivity().setResult(-1, var1x);
                     this.b.a.getActivity().finish();
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "sending gallery invite", true);
               this.a.j.b(this.a.getString(2131755323));
            }
         });
      }
   }

   private boolean s() {
      List var2 = this.k.getMembers();
      boolean var1;
      if (var2 != null && !var2.isEmpty() && var2.size() > 2) {
         Iterator var3 = var2.iterator();

         while (true) {
            if (!var3.hasNext()) {
               var1 = false;
               break;
            }

            Member var4 = (Member)var3.next();
            if (var4.getAccount() != null
               && this.s.getAccount().getEmail().equals(var4.getAccount().getEmail())
               && !LoopHelper.isMemberDeclined(var4)
               && !LoopHelper.isMemberRemoved(var4)) {
               var1 = true;
               break;
            }
         }
      } else {
         var1 = false;
      }

      return var1;
   }

   private void t() {
      boolean var1;
      if (!this.email.getText().toString().trim().isEmpty() && Commons.a.matcher(this.email.getText().toString().trim()).matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.p.setEnabled(var1);
   }

   @Override
   public void a() {
      String var2 = this.d;
      String var1 = var2;
      if (TextUtils.isEmpty(var2)) {
         var1 = var2;
         if (this.n != null) {
            var1 = this.n.getFirstName();
         }
      }

      var2 = var1;
      if (TextUtils.isEmpty(var1)) {
         var2 = var1;
         if (this.s != null) {
            var2 = var1;
            if (this.s.getAccount() != null) {
               var2 = this.s.getAccount().getFirstName();
            }
         }
      }

      var1 = var2;
      if (TextUtils.isEmpty(var2)) {
         var1 = var2;
         if (this.c != null) {
            var1 = this.c.getFirstName();
         }
      }

      this.title.setText(this.getString(2131755742, var1));
      this.email.requestFocus();
      UIUtils.b(this.getActivity(), this.email);
      this.email.setText(this.n.getEmail());
      this.email.addTextChangedListener(new TextWatcher(this) {
         final NewEmailFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
            this.a.t();
         }
      });
      if (this.t == EmailFragment.LaunchMode.add_email) {
         this.footer.setVisibility(0);
         this.footer.setText(this.getString(2131755283, var1));
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayShowCustomEnabled(true);
      this.m();
   }

   @Override
   public void b() {
      this.s.getAccount().setEmail(this.email.getText().toString());
      this.email.setText("");
      this.r();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (var1.containsKey("ARG_MODE")) {
         this.t = EmailFragment.LaunchMode.values()[var1.getInt("ARG_MODE")];
      }

      this.s = (Member)var1.getParcelable(Member.class.getSimpleName());
   }

   @Override
   protected String o() {
      return this.getString(2131755383);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      this.p.setTitle(2131755077);
      this.p.setIcon(null);
      this.t();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427436, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.a.a = true;
      this.email.setAdapter(this.a);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putInt("ARG_MODE", this.t.ordinal());
      var1.putParcelable(Member.class.getSimpleName(), this.s);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.l();
      this.e();
   }
}
