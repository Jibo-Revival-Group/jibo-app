package com.jibo.ui.fragment.invite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;

public abstract class BaseLoopInviteFragment extends BaseFragment {
   Boolean b;
   Account c;
   String d;
   String e;
   String l;
   Member m;
   MemberAccount n;
   boolean o;
   MenuItem p;
   int q;

   private void b(Class var1, Bundle var2) {
      if (this.k != null) {
         var2.putParcelable(Loop.class.getSimpleName(), this.k);
      }

      if (this.c != null) {
         var2.putParcelable(Account.class.getSimpleName(), this.c);
      }

      if (this.b != null) {
         var2.putBoolean("ARG_IS_CHILD", this.b);
      }

      if (this.d != null) {
         var2.putString("ARG_NICKNAME", this.d);
      }

      if (this.l != null) {
         var2.putString("ARG_NAME", this.d);
      }

      if (this.e != null) {
         var2.putString("ARG_PHONETIC_NAME", this.e);
      }

      if (this.m != null) {
         var2.putParcelable(Member.class.getSimpleName(), this.m);
      }

      if (this.b != null) {
         var2.putBoolean("ARG_IS_PARENT", this.o);
      }

      if (this.n != null) {
         var2.putParcelable(MemberAccount.class.getSimpleName(), this.n);
      }

      ((BaseActivity)this.getActivity()).c(var1, var2);
   }

   public abstract void a();

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
      var1.setHomeButtonEnabled(true);
      this.n();
   }

   protected void a(Member var1) {
      if (this.d() && this.o && !TextUtils.isEmpty(this.c.getEmail())) {
         this.m = var1;
         SharedPreferencesUtil.a(this.getActivity(), var1.getId());
      }

      EntityData.a(this.getActivity())
         .b()
         .updateNickname(this.k.getId(), var1.getId(), this.d, new AsyncHandler<UpdateNicknameRequest, CommandResponse>(this) {
            final BaseLoopInviteFragment a;

            {
               this.a = var1;
            }

            public void a(UpdateNicknameRequest var1, CommandResponse var2) {
               if (TextUtils.isEmpty(this.a.c.getEmail())) {
                  this.a.j.a(this.a.getString(2131755761));
               } else {
                  this.a.j.a(this.a.getString(2131755324));
               }
            }

            @Override
            public void onError(Exception var1) {
               CircleProgressFragment var3 = this.a.j;
               String var2;
               if (TextUtils.isEmpty(this.a.c.getEmail())) {
                  var2 = "";
               } else {
                  var2 = this.a.getString(2131755288);
               }

               var3.b(var2);
               this.a.a(var1, "update nickname", false);
            }
         });
   }

   public void a(Class var1) {
      this.b(var1, new Bundle());
   }

   public void a(Class var1, Bundle var2) {
      Bundle var3 = var2;
      if (var2 == null) {
         var3 = new Bundle();
      }

      this.b(var1, var3);
   }

   public abstract void b();

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (var1.containsKey(Account.class.getSimpleName())) {
         this.c = (Account)var1.getParcelable(Account.class.getSimpleName());
      }

      if (var1.containsKey("ARG_IS_CHILD")) {
         this.b = var1.getBoolean("ARG_IS_CHILD", false);
      }

      if (var1.containsKey("ARG_IS_PARENT")) {
         this.o = var1.getBoolean("ARG_IS_PARENT", false);
      }

      if (var1.containsKey("ARG_NICKNAME")) {
         this.d = var1.getString("ARG_NICKNAME");
      }

      if (var1.containsKey("ARG_PHONETIC_NAME")) {
         this.e = var1.getString("ARG_PHONETIC_NAME");
      }

      if (var1.containsKey("ARG_NAME")) {
         this.l = var1.getString("ARG_NAME");
      }

      if (var1.containsKey(Member.class.getSimpleName())) {
         this.m = (Member)var1.getParcelable(Member.class.getSimpleName());
      }

      if (var1.containsKey(MemberAccount.class.getSimpleName())) {
         this.n = (MemberAccount)var1.getParcelable(MemberAccount.class.getSimpleName());
      }
   }

   public void b(boolean var1) {
      if (this.p != null) {
         this.p.setEnabled(var1);
         FragmentActivity var3 = this.getActivity();
         MenuItem var4 = this.p;
         int var2;
         if (this.p.isEnabled()) {
            var2 = 2131099871;
         } else {
            var2 = 2131099701;
         }

         ImageUtils.a(var3, var4, var2);
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      Account var2;
      if (this.c == null) {
         var2 = new Account();
      } else {
         var2 = this.c;
      }

      this.c = var2;
      DisplayMetrics var3 = new DisplayMetrics();
      this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(var3);
      this.q = var3.widthPixels;
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492867, var1);
      super.onCreateOptionsMenu(var1, var2);
      ImageUtils.a(this.getActivity(), var1);
      this.p = var1.findItem(2131296294);
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
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.c != null) {
         var1.putParcelable(Account.class.getSimpleName(), this.c);
      }

      if (this.b != null) {
         var1.putBoolean("ARG_IS_CHILD", this.b);
      }

      if (this.d != null) {
         var1.putString("ARG_NICKNAME", this.d);
      }

      if (this.e != null) {
         var1.putString("ARG_PHONETIC_NAME", this.e);
      }

      if (this.l != null) {
         var1.putString("ARG_NAME", this.l);
      }

      if (this.m != null) {
         var1.putParcelable(Member.class.getSimpleName(), this.m);
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.a();
   }

   protected void q() {
      if (this.j == null) {
         JiboAnalytics.a(this.getActivity(), this.k.getRobot(), this.c.getBirthday());
         this.j = new CircleProgressFragment();
         String var1;
         if (this.c.getEmail() != null && !this.c.getEmail().isEmpty()) {
            var1 = this.getString(2131755652);
         } else {
            var1 = this.getString(2131755762, this.c.getFirstName());
         }

         this.j.c(var1);
         this.j.a(new CircleProgressFragment.OnDismissListener(this) {
            final BaseLoopInviteFragment a;

            {
               this.a = var1;
            }

            @Override
            public void a(CircleProgressFragment.Status var1) {
               Intent var2 = new Intent();
               if (var1 == CircleProgressFragment.Status.Success && this.a.m != null && this.a.o) {
                  var2.putExtra(Member.class.getSimpleName(), this.a.m);
               }

               this.a.getActivity().setResult(-1, var2);
               this.a.getActivity().finish();
               if (SharedPreferencesUtil.k(this.a.getContext())) {
                  SingleFragmentActivity.Builder var3 = new SingleFragmentActivity.Builder(this.a.getContext(), CongratsFragment.class.getName());
                  var3.a(Account.class.getSimpleName(), this.a.c);
                  var3.a("ARG_NICKNAME", this.a.d);
                  var3.a(1017);
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
            this.o,
            false,
            new AsyncHandler<InviteMemberRequest, Loop>(this) {
               final BaseLoopInviteFragment a;

               {
                  this.a = var1;
               }

               private void a(Member var1) {
                  try {
                     this.a.a(var1);
                  } catch (Exception var2) {
                     if (var2 instanceof AmazonServiceException) {
                        this.a.a(var2, ((AmazonServiceException)var2).getServiceName(), false);
                     }

                     this.a.j.b("");
                  }
               }

               public void a(InviteMemberRequest var1, Loop var2) {
                  boolean var3;
                  label55: {
                     if (var2 != null) {
                        for (Member var4 : var2.getMembers()) {
                           if (var4.getAccount() != null && !LoopHelper.isMemberRemoved(var4)) {
                              if (!TextUtils.isEmpty(var4.getAccount().getEmail()) && !TextUtils.isEmpty(this.a.c.getEmail())) {
                                 if (this.a.c.getEmail().equalsIgnoreCase(var4.getAccount().getEmail())) {
                                    this.a(var4);
                                    var3 = true;
                                    break label55;
                                 }
                              } else if (TextUtils.isEmpty(this.a.c.getEmail())
                                 && this.a.c.getFirstName().equalsIgnoreCase(var4.getAccount().getFirstName())
                                 && this.a.c.getLastName().equalsIgnoreCase(var4.getAccount().getLastName())
                                 && var4.getAccount().getBirthday() != null
                                 && var4.getAccount().getBirthday() == this.a.c.getBirthday()
                                 && this.a.c.getGender().compareTo(var4.getAccount().getGender()) == 0) {
                                 this.a(var4);
                                 var3 = true;
                                 break label55;
                              }
                           }
                        }
                     }

                     var3 = false;
                  }

                  if (!var3 || var2 == null) {
                     CircleProgressFragment var7 = this.a.j;
                     String var6;
                     if (TextUtils.isEmpty(this.a.c.getEmail())) {
                        var6 = "";
                     } else {
                        var6 = this.a.getString(2131755323);
                     }

                     var7.b(var6);
                  }
               }

               @Override
               public void onError(Exception var1) {
                  CircleProgressFragment var3 = this.a.j;
                  String var2;
                  if (TextUtils.isEmpty(this.a.c.getEmail())) {
                     var2 = "";
                  } else {
                     var2 = this.a.getString(2131755323);
                  }

                  var3.b(var2);
                  this.a.a(var1, "invite member", false);
               }
            }
         );
   }
}
