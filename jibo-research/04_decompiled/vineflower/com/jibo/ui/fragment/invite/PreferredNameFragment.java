package com.jibo.ui.fragment.invite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.collision.JiboCollisionAsyncClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.view.proxima.CustomFontEditText;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;
import java.util.List;

public class PreferredNameFragment extends BaseLoopInviteFragment {
   public static final String a = LogUtils.a(PreferredNameFragment.class);
   @BindView
   View mChangePronunciationName;
   @BindView
   TextView mPreferredNameTip;
   @BindView
   View mViewLoopMembers;
   @BindView
   EditText nickname;
   @BindView
   TextView nicknameSkip;
   private MemberAccount r;
   private boolean s = false;
   private JiboCollisionAsyncClient t;
   private String u;

   public static void a(BaseFragment var0, Loop var1, Member var2) {
      SingleFragmentActivity.Builder var3 = new SingleFragmentActivity.Builder(var0, PreferredNameFragment.class.getName());
      var3.a("ARGS_SHOULD_RETURN_VALUE", true);
      var3.a(Loop.class.getSimpleName(), var1);
      var3.a(Member.class.getSimpleName(), var2);
      var3.a(MemberAccount.class.getSimpleName(), var2.getAccount());
      if (var2.getNickname() != null) {
         var3.a("ARG_NICKNAME", var2.getNickname());
      }

      var3.a(1011);
   }

   private void r() {
      if (!this.s && this.p != null) {
         boolean var1;
         if (!this.nickname.getText().toString().trim().isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         this.b(var1);
      }
   }

   @Override
   public void a() {
      this.u = this.d;
      this.nickname.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new LengthFilter(20)});
      TextView var2 = this.nicknameSkip;
      byte var1;
      if (this.s) {
         var1 = 8;
      } else {
         var1 = 0;
      }

      var2.setVisibility(var1);
      this.nickname.addTextChangedListener(new TextWatcher(this) {
         final PreferredNameFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
            if (this.a.nickname != null) {
               this.a.nicknameSkip.setEnabled(this.a.nickname.getText().toString().trim().isEmpty());
               this.a.r();
            }
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3, int var4) {
         }
      });
      this.nickname.setText(this.d);
      this.mPreferredNameTip.setTextColor(ImageUtils.b(this.getActivity(), 2131099679));
      if (!TextUtils.isEmpty(this.l)) {
         this.mPreferredNameTip.setText(this.getString(2131755599, this.l));
      } else {
         TextView var3 = this.mPreferredNameTip;
         String var4;
         if (this.r != null) {
            var4 = this.r.getFirstName();
         } else {
            var4 = this.c.getFirstName();
         }

         var3.setText(this.getString(2131755599, var4));
      }

      if (this.r == null) {
         this.mChangePronunciationName.setVisibility(8);
      }

      this.r();
      if (LoopHelper.getActiveMembersCount(this.k) == 1) {
         this.mViewLoopMembers.setVisibility(8);
      }
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
      this.a(false);
      this.b(false);
      this.d = this.nickname.getText().toString().trim();
      if (this.d.isEmpty()) {
         this.d = null;
      }

      List var2 = LoopHelper.getMembersNicknames(this.k);
      if (this.r != null) {
         var2.remove(this.r.getFirstName());
         var2.remove(this.u);
      }

      String var1;
      if (TextUtils.isEmpty(this.d)) {
         if (this.r != null) {
            var1 = this.r.getFirstName();
         } else {
            var1 = this.c.getFirstName();
         }
      } else {
         var1 = this.d;
      }

      if (var2.isEmpty() && this.s) {
         ((SingleFragmentActivity)this.getActivity()).q().putExtra("ARGS_CHOSEN_NICKNAME", this.d);
         ((SingleFragmentActivity)this.getActivity()).q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", this.e);
         this.getActivity().finish();
      } else {
         this.t.match(var2, var1, new AsyncHandler<MatchRequest, CollisionCheckContainer>(this) {
            final PreferredNameFragment a;

            {
               this.a = var1;
            }

            public void a(MatchRequest var1, CollisionCheckContainer var2x) {
               this.a.a(new Runnable(this, var2x) {
                  final CollisionCheckContainer a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     this.b.a.g();
                     this.b.a.b(true);
                     if (!this.a.getCollision()) {
                        if (this.b.a.s) {
                           ((SingleFragmentActivity)this.b.a.getActivity()).q().putExtra("ARGS_CHOSEN_NICKNAME", this.b.a.d);
                           ((SingleFragmentActivity)this.b.a.getActivity()).q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", this.b.a.e);
                           this.b.a.getActivity().finish();
                        } else {
                           UIUtils.a(this.b.a.getActivity(), this.b.a.nickname);
                           if (!DateTimeUtils.isAdult(this.b.a.c.getBirthday())) {
                              if (this.b.a.m == null) {
                                 this.b.a.a(SelectGuardianFragment.class);
                              } else {
                                 this.b.a.a(LegalGuardianFragment.class);
                              }
                           } else if (this.b.a.o) {
                              this.b.a.a(EmailFragment.class);
                           } else {
                              this.b.a.a(EmailInviteInfoFragment.class);
                           }
                        }
                     } else {
                        this.b.a.mPreferredNameTip.setTextColor(ImageUtils.b(this.b.a.getActivity(), 2131099764));
                        if (TextUtils.isEmpty(this.b.a.nickname.getText().toString().trim())) {
                           TextView var2x = this.b.a.mPreferredNameTip;
                           PreferredNameFragment var3 = this.b.a;
                           String var1x;
                           if (this.b.a.r != null) {
                              var1x = this.b.a.r.getFirstName();
                           } else {
                              var1x = this.b.a.c.getFirstName();
                           }

                           var2x.setText(var3.getString(2131755600, var1x));
                        } else {
                           this.b.a.mPreferredNameTip.setText(this.b.a.getString(2131755601, Util.c(this.a.getClosestPair())));
                        }
                     }
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "collision match", false);
            }
         });
      }
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.s = var1.getBoolean("ARGS_SHOULD_RETURN_VALUE");
      this.r = (MemberAccount)var1.getParcelable(MemberAccount.class.getSimpleName());
   }

   @OnClick
   void changePronunciationName(View var1) {
      new Bundle().putParcelable(Member.class.getSimpleName(), this.m);
      NamePronunciationFragment.a(this, this.k, this.m);
   }

   @Override
   public boolean h() {
      ((SingleFragmentActivity)this.getActivity()).q().putExtra("ARGS_CHOSEN_NICKNAME", this.u);
      return false;
   }

   @OnClick
   public void nicknameSkip(View var1) {
      this.b();
   }

   @Override
   protected String o() {
      return this.getString(2131756063);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         switch (var1) {
            case 1021:
               String var4 = var3.getStringExtra("ARGS_CHOSEN_PHONETIC_NAME");
               this.e = var4;
               this.m.setPhoneticName(var4);
               ((SingleFragmentActivity)this.getActivity()).q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", var4);
         }
      } else if (var1 == 1021) {
         this.e = this.m.getPhoneticName();
      }
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
      return var1.inflate(2131427457, var2, false);
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
      Account var3 = EntityData.a(this.getActivity()).i();
      if (var3 != null) {
         JiboCollisionAsyncClient var4 = new JiboCollisionAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
         this.t = var4;
         this.a(var4);
      }
   }

   @OnClick
   void viewLoopMembers(View var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      ((BaseActivity)this.getActivity()).c(LoopMembersFragment.class, var2);
   }
}
