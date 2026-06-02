package com.jibo.ui.fragment.invite;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.SetLegalGuardianRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;

public class LegalGuardianFragment extends BaseLoopInviteFragment {
   public static final String a = LogUtils.a(LegalGuardianFragment.class);
   @BindView
   ImageView avatar;
   @BindView
   TextView email;
   @BindView
   TextView legalGuardianInfo;
   @BindView
   TextView legalGuardianTitle;
   @BindView
   TextView name;

   private void b(Member var1) {
      EntityData.a(this.getActivity())
         .b()
         .setLegalGuardian(this.k.getId(), var1.getId(), this.m.getId(), new AsyncHandler<SetLegalGuardianRequest, CommandResponse>(this, var1) {
            final Member a;
            final LegalGuardianFragment b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void a(SetLegalGuardianRequest var1, CommandResponse var2) {
               JiboAnalytics.a(this.b.getActivity(), this.b.k.getRobot(), this.b.c.getBirthday());
               if (TextUtils.isEmpty(this.b.d)) {
                  if (this.b.m.getAccountId().equals(EntityData.a(this.b.getActivity()).i().getId())) {
                     this.b.j.a(this.b.getString(2131755491));
                  } else {
                     this.b.j.a(this.b.getString(2131755490));
                  }
               } else {
                  this.b.a(this.a);
               }
            }

            @Override
            public void onError(Exception var1) {
               this.b.j.b(this.b.getString(2131755288));
               this.b.a(var1, "set legal guardian", false);
            }
         });
   }

   private void r() {
      if (this.j != null) {
         this.j.dismiss();
         this.j = null;
      }

      if (this.j == null) {
         this.j = new CircleProgressFragment();
         SpannableStringBuilder var1;
         if (this.m.getAccountId().equals(EntityData.a(this.getActivity()).i().getId())) {
            var1 = new SpannableStringBuilder(this.getString(2131755843));
         } else {
            var1 = Util.a(this.getString(2131755842, this.m.getAccount().getFirstName()), this.m.getAccount().getFirstName());
         }

         this.j.c(var1);
         this.j.a(new CircleProgressFragment.OnDismissListener(this) {
            final LegalGuardianFragment a;

            {
               this.a = var1;
            }

            @Override
            public void a(CircleProgressFragment.Status var1) {
               if (var1 == CircleProgressFragment.Status.Success) {
                  this.a.getActivity().setResult(-1);
                  this.a.getActivity().finish();
               }

               if (SharedPreferencesUtil.k(this.a.getContext())) {
                  SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this.a.getContext(), CongratsFragment.class.getName());
                  var2.a(Account.class.getSimpleName(), this.a.c);
                  var2.a("ARG_NICKNAME", this.a.d);
                  var2.a(1017);
               }
            }
         });
         this.j.show(this.getActivity().getSupportFragmentManager(), "CircleFragment");
      }

      EntityData.a(this.getActivity())
         .b()
         .inviteMember(
            this.k.getId(),
            this.c.getEmail(),
            this.c.getFirstName(),
            this.c.getLastName(),
            this.c.getGender(),
            this.c.getBirthday(),
            false,
            true,
            new AsyncHandler<InviteMemberRequest, Loop>(this) {
               final LegalGuardianFragment a;

               {
                  this.a = var1;
               }

               public void a(InviteMemberRequest var1, Loop var2) {
                  this.a
                     .a(
                        new Runnable(this, var2) {
                           final Loop a;
                           final <unrepresentable> b;

                           {
                              this.b = var1;
                              this.a = var2x;
                           }

                           @Override
                           public void run() {
                              if (this.a != null) {
                                 for (Member var1x : this.a.getMembers()) {
                                    if (var1x.getAccount() != null
                                       && this.b.a.c.getFirstName().equals(var1x.getAccount().getFirstName())
                                       && this.b.a.c.getLastName().equals(var1x.getAccount().getLastName())
                                       && var1x.getAccount().getBirthday() != null
                                       && var1x.getAccount().getBirthday() == this.b.a.c.getBirthday()
                                       && var1x.getAccount().getGender() != null
                                       && var1x.getAccount().getGender().ordinal() == this.b.a.c.getGender().ordinal()
                                       && var1x.getStatus() != Member.InvitationStatus.removed) {
                                       this.b.a.b(var1x);
                                       return;
                                    }
                                 }
                              }

                              this.b.a.j.b("");
                           }
                        }
                     );
               }

               @Override
               public void onError(Exception var1) {
                  this.a.j.b(this.a.getString(2131755288));
                  this.a.a(var1, "invite member", false);
               }
            }
         );
   }

   @Override
   public void a() {
      TextView var4 = this.name;
      String var2;
      if (this.m.getAccount() != null) {
         var2 = this.m.getAccount().getFirstName();
      } else {
         var2 = "";
      }

      String var3;
      if (this.m.getAccount() != null) {
         var3 = this.m.getAccount().getLastName();
      } else {
         var3 = "";
      }

      Util.a(var4, var2, var3);
      this.email.setText(this.m.getAccount().getEmail());
      TextView var5 = this.email;
      byte var1;
      if (TextUtils.isEmpty(this.m.getAccount().getEmail())) {
         var1 = 8;
      } else {
         var1 = 0;
      }

      var5.setVisibility(var1);
      Util.a(this.getActivity(), this.avatar, this.m);
      if (LoopHelper.isOwner(this.k, this.m.getAccountId())) {
         this.legalGuardianTitle.setText(this.getString(2131755587));
         this.legalGuardianInfo.setText(String.format(this.getString(2131755334), this.c.getFirstName()));
      } else {
         this.legalGuardianTitle.setText(this.getString(2131755586));
         this.legalGuardianInfo.setText(String.format(this.getString(2131755333), this.c.getFirstName()));
      }
   }

   @Override
   protected void a(Member var1) {
      EntityData.a(this.getActivity())
         .b()
         .updateNickname(this.k.getId(), var1.getId(), this.d, new AsyncHandler<UpdateNicknameRequest, CommandResponse>(this) {
            final LegalGuardianFragment a;

            {
               this.a = var1;
            }

            public void a(UpdateNicknameRequest var1, CommandResponse var2) {
               if (this.a.m.getAccountId().equals(EntityData.a(this.a.getActivity()).i().getId())) {
                  this.a.j.a(this.a.getString(2131755491));
               } else {
                  this.a.j.a(this.a.getString(2131755490));
               }
            }

            @Override
            public void onError(Exception var1) {
               this.a.j.b("");
               this.a.a(var1, "update nickname", false);
            }
         });
   }

   @Override
   public void b() {
      this.r();
   }

   @Override
   protected String o() {
      return this.getString(2131756059);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427445, var2, false);
   }
}
