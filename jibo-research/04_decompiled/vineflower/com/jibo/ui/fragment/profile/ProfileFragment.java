package com.jibo.ui.fragment.profile;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.service.SyncHelper;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.AvatarBaseFragment;
import com.jibo.ui.fragment.account.AccountSettingsFragment;
import com.jibo.ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.invite.PreferredNameFragment;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;

public class ProfileFragment extends AvatarBaseFragment {
   public static final String n = ProfileFragment.class.getSimpleName();
   @BindView
   View bottomPanel;
   @BindView
   View contactAdult;
   @BindView
   View contactChild;
   @BindView
   TextView daysLeftInfo;
   @BindView
   TextView mBirthday;
   @BindView
   TextView mEmail;
   @BindView
   TextView mLegalGuardianName;
   @BindView
   TextView mName;
   @BindView
   TextView mNickName;
   @BindView
   TextView mPersonalSettings;
   @BindView
   LinearLayout mPersonalSettingsRow;
   @BindView
   TextView mTrained;
   private Member o;
   private boolean p;
   @BindView
   View personalSettingDivider;
   private ArrayList<Loop> q = null;
   private JiboSkillsAsyncClient r;
   private boolean s = true;

   private void b(int var1) {
      PopupWindow var4 = new PopupWindow(this.getActivity());
      View var3 = ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(var1, null);
      var3.findViewById(2131296535).setOnClickListener(new OnClickListener(this, var4) {
         final PopupWindow a;
         final ProfileFragment b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void onClick(View var1) {
            this.a.dismiss();
            SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this.b.getActivity(), AccountSettingsFragment.class.getName());
            if (this.b.q != null) {
               var2.a("ARG_LOOPS", this.b.q);
            }

            var2.a(1001);
         }
      });
      switch (var1) {
         case 2131427611:
            var3.findViewById(2131296690).setOnClickListener(new OnClickListener(this, var4) {
               final PopupWindow a;
               final ProfileFragment b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void onClick(View var1) {
                  this.a.dismiss();
                  this.b.t();
               }
            });
            break;
         case 2131427612:
            var3.findViewById(2131296540).setOnClickListener(new OnClickListener(this, var4) {
               final PopupWindow a;
               final ProfileFragment b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void onClick(View var1) {
                  this.a.dismiss();
                  PreferredNameFragment.a(this.b, this.b.k, this.b.o);
               }
            });
      }

      var4.setFocusable(true);
      var4.setWidth(-2);
      var4.setHeight(-2);
      var4.setContentView(var3);
      if (VERSION.SDK_INT >= 21) {
         var4.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(2131099871)));
         var4.setElevation(10.0F);
      } else {
         var4.setBackgroundDrawable(this.getResources().getDrawable(17301683));
      }

      var1 = this.getResources().getDimensionPixelSize(2131165438);
      int var2 = this.getResources().getDimensionPixelSize(2131165439);
      var4.showAtLocation(((BaseActivity)this.getActivity()).g(), 53, var1, var2);
   }

   private void c(String var1) {
      this.f();
      EntityData.a(this.getActivity())
         .b()
         .updateNickname(this.k.getId(), this.o.getId(), var1, new AsyncHandler<UpdateNicknameRequest, CommandResponse>(this, var1) {
            final String a;
            final ProfileFragment b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void a(UpdateNicknameRequest var1, CommandResponse var2) {
               this.b.o.setNickname(this.a);
               this.b.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.b.g();
                     this.a.b.v();
                     SyncHelper.a(this.a.b.getActivity(), this.a.b.k.getId());
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.b.a(var1, "update nickname", true);
            }
         });
   }

   private void t() {
      DialogUtils.b(this, 115, this.getString(2131755488), this.getString(2131755486));
   }

   private void u() {
      EntityData.a(this.getActivity()).b().removeMember(this.k.getId(), this.o.getId(), new AsyncHandler<RemoveMemberRequest, Loop>(this) {
         final ProfileFragment a;

         {
            this.a = var1;
         }

         public void a(RemoveMemberRequest var1, Loop var2) {
            this.a.a(new Runnable(this, var2) {
               final Loop a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  EntityData.a(this.b.a.getActivity()).b(this.a.getId());
                  this.b.a.getActivity().finish();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "remove member", true);
         }
      });
   }

   private void v() {
      if (this.o != null && this.k != null) {
         this.c = true;
         if (this.o.getAccount() != null) {
            this.a(this.o.getAccount());
         }

         this.mName.setText(this.o.getAccount().getFullName());
         if (!TextUtils.isEmpty(this.o.getNickname())) {
            this.mNickName.setText('"' + this.o.getNickname() + '"');
         } else {
            this.mNickName.setText("");
         }

         if (DateTimeUtils.isAdult(this.o.getAccount().getBirthday())) {
            this.contactChild.setVisibility(8);
         } else {
            this.contactAdult.setVisibility(8);
            String var6 = "";
            String var5 = var6;
            if (!TextUtils.isEmpty(this.o.getLegalGuardianId())) {
               Member var7 = LoopHelper.getMemberByIdOrEmail(this.k, this.o.getLegalGuardianId());
               var5 = var6;
               if (var7 != null) {
                  var5 = var7.getAccount().getFullName();
               }
            }

            this.mLegalGuardianName.setText(var5);
            if (this.daysLeftInfo.getVisibility() == 0 && this.o.getCreated() != null && this.o.getCreated() != -1L) {
               long var1 = this.o.getCreated();
               long var3 = System.currentTimeMillis();
               if (!TextUtils.isEmpty(this.o.getNickname())) {
                  var5 = this.o.getNickname();
               } else {
                  var5 = this.o.getAccount().getFirstName();
               }

               this.daysLeftInfo.setText(this.getString(2131755829, Math.max(0, (int)Math.ceil((float)(864000000L + var1 - var3) / 8.64E7F)), var5));
            }
         }

         if (!TextUtils.isEmpty(this.o.getAccount().getEmail())) {
            this.mEmail.setText(this.o.getAccount().getEmail());
         } else {
            this.mEmail.setText(2131755555);
         }

         if (this.o.getAccount().getBirthday() != null && this.o.getAccount().getBirthday() != -1L) {
            TextView var11 = this.mBirthday;
            long var8 = this.o.getAccount().getBirthday();
            String var10;
            if (DateTimeUtils.isAdult(this.o.getAccount().getBirthday())) {
               var10 = DateTimeUtils.FULL_DATE_FORMAT;
            } else {
               var10 = DateTimeUtils.CHILD_BIRTH_DATE_FORMAT;
            }

            var11.setText(DateTimeUtils.getBirthdayString(var8, var10));
         } else {
            this.mBirthday.setText("");
         }

         if (this.o.getEnrolled().getVoice() && this.o.getEnrolled().getFace()) {
            this.mTrained.setText(2131756083);
         } else if (this.o.getEnrolled().getVoice()) {
            this.mTrained.setText(2131756098);
         } else if (this.o.getEnrolled().getFace()) {
            this.mTrained.setText(2131755317);
         } else {
            this.mTrained.setText(2131755556);
         }

         this.mPersonalSettings.setText(2131755656);
         if (this.p) {
            this.mPersonalSettingsRow.setVisibility(0);
            this.personalSettingDivider.setVisibility(0);
         } else {
            this.mPersonalSettingsRow.setVisibility(8);
            this.personalSettingDivider.setVisibility(8);
         }
      }
   }

   private void w() {
      if (this.o != null && this.k != null) {
         AppBarLayout var4 = (AppBarLayout)this.getActivity().findViewById(2131296320);
         int var2 = ImageUtils.b(this.getActivity(), 2131099790);
         int var1 = ImageUtils.b(this.getActivity(), 2131099791);
         this.b = 2131230832;
         if (!this.p) {
            if (DateTimeUtils.isAdult(this.o.getAccount().getBirthday())) {
               var2 = ImageUtils.b(this.getActivity(), 2131099771);
               var1 = ImageUtils.b(this.getActivity(), 2131099672);
               this.b = 2131230833;
            } else if (LoopHelper.isMemberAccepted(this.o)) {
               var2 = ImageUtils.b(this.getActivity(), 2131099702);
               var1 = ImageUtils.b(this.getActivity(), 2131099703);
               this.b = 2131230830;
               this.bottomPanel.setVisibility(0);
               this.daysLeftInfo.setVisibility(8);
            } else {
               var2 = ImageUtils.b(this.getActivity(), 2131099704);
               var1 = ImageUtils.b(this.getActivity(), 2131099705);
               this.b = 2131230831;
               this.bottomPanel.setVisibility(8);
               this.daysLeftInfo.setVisibility(0);
            }
         }

         if (VERSION.SDK_INT >= 21) {
            Window var3 = this.getActivity().getWindow();
            var3.clearFlags(67108864);
            var3.addFlags(Integer.MIN_VALUE);
            var3.setStatusBarColor(var1);
         }

         var4.setBackgroundColor(var2);
         this.getView().setBackgroundColor(var2);
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 115 && var2 == -1) {
         this.u();
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
      var1.setDisplayShowTitleEnabled(false);
      this.m();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.o = (Member)var1.getParcelable(Member.class.getSimpleName());
      this.s = var1.getBoolean("ARGS_ALLOW_EDIT", true);
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         if (var3 != null && var3.getExtras() != null) {
            if (var3.getExtras().getBoolean("ARGS_REMOVED_FROM_LOOP", false)) {
               this.getActivity().finish();
            } else {
               if (var3.getExtras().containsKey(Account.class.getSimpleName())
                  && var3.getExtras().getParcelable(Account.class.getSimpleName()) instanceof Account) {
                  Account var7 = (Account)var3.getExtras().getParcelable(Account.class.getSimpleName());
                  if (var7.getPhotoUrl() != null && !var7.getPhotoUrl().equals(this.o.getAccount().getPhotoUrl())) {
                     this.o.getAccount().setPhotoUrl(var7.getPhotoUrl());
                     this.a(this.o.getAccount().getPhotoUrl());
                  }

                  this.o.getAccount().setBirthday(var7.getBirthday());
                  this.o.getAccount().setGender(var7.getGender());
                  this.o.getAccount().setFirstName(var7.getFirstName());
                  this.o.getAccount().setLastName(var7.getLastName());
                  SyncHelper.b(this.getActivity());
               } else if (var3.getExtras().containsKey(Member.class.getSimpleName())
                  && var3.getExtras().getParcelable(Member.class.getSimpleName()) instanceof Member) {
                  Member var6 = (Member)var3.getExtras().getParcelable(Member.class.getSimpleName());
                  if (var6.getAccount().getPhotoUrl() != null && !var6.getAccount().getPhotoUrl().equals(this.o.getAccount().getPhotoUrl())) {
                     this.o.getAccount().setPhotoUrl(var6.getAccount().getPhotoUrl());
                     this.a(this.o.getAccount().getPhotoUrl());
                  }

                  this.o.setPhoneticName(var6.getPhoneticName());
                  this.o.setNickname(var6.getNickname());
                  this.o.getAccount().setBirthday(var6.getAccount().getBirthday());
                  this.o.getAccount().setGender(var6.getAccount().getGender());
                  this.o.getAccount().setEmail(var6.getAccount().getEmail());
                  this.o.setStatus(var6.getStatus());
                  SyncHelper.a(this.getActivity(), this.k.getId());
               } else if (var3.getExtras().containsKey("ARGS_CHOSEN_NICKNAME")) {
                  if (var3.getExtras().containsKey("ARGS_CHOSEN_PHONETIC_NAME")) {
                     String var4 = var3.getStringExtra("ARGS_CHOSEN_PHONETIC_NAME");
                     this.o.setPhoneticName(var4);
                  }

                  label49: {
                     String var8 = var3.getStringExtra("ARGS_CHOSEN_NICKNAME");
                     if (var8 != null) {
                        var5 = var8;
                        if (!var8.isEmpty()) {
                           break label49;
                        }
                     }

                     var5 = null;
                  }

                  this.c(var5);
               }

               this.v();
            }
         }
      } else if (var2 == TabbedActivity.c) {
         this.getActivity().setResult(TabbedActivity.c);
         this.getActivity().finish();
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
      this.getActivity().setResult(0);
      this.p = LoopHelper.isCurrentUser(this.o, EntityData.a(this.getActivity()).i());
      if (this.getArguments() != null && this.getArguments().containsKey("ARG_LOOPS")) {
         this.q = this.getArguments().getParcelableArrayList("ARG_LOOPS");
      }

      Account var2 = EntityData.a(this.getActivity()).i();
      JiboSkillsAsyncClient var3 = new JiboSkillsAsyncClient(new BasicAWSCredentials(var2.getAccessKeyId(), var2.getSecretAccessKey()));
      this.r = var3;
      this.a(var3);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      if (this.s && (LoopHelper.isOwner(this.k, this.e.getId()) || this.p)) {
         var2.inflate(2131492868, var1);
         this.c().postDelayed(new Runnable(this, var1) {
            final Menu a;
            final ProfileFragment b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               if (this.a != null && ((MenuBuilder)this.a).k() != null && !((MenuBuilder)this.a).k().isEmpty()) {
                  MenuItem var1x = ((MenuBuilder)this.a).k().get(0);
                  if (var1x.getActionView() != null) {
                     var1x.getActionView().setOnClickListener(new OnClickListener(this, var1x) {
                        final MenuItem a;
                        final <unrepresentable> b;

                        {
                           this.b = var1;
                           this.a = var2x;
                        }

                        public void onClick(View var1) {
                           this.b.b.onOptionsItemSelected(this.a);
                        }
                     });
                  }
               }
            }
         }, 100L);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427458, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      if (this.p) {
         if (LoopHelper.isOwner(this.k, this.e.getId())) {
            this.b(2131427612);
         } else {
            this.b(2131427611);
         }
      } else if (LoopHelper.isOwner(this.k, this.e.getId())) {
         SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this, EditProfileFragment.class.getName());
         var2.a(Member.class.getSimpleName(), this.o).a(Loop.class.getSimpleName(), this.k);
         var2.a(1008);
      }

      return super.onOptionsItemSelected(var1);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Member.class.getSimpleName(), this.o);
      var1.putBoolean("ARGS_ALLOW_EDIT", this.s);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.w();
      this.v();
   }

   @OnClick
   public void personalSettingsClick(View var1) {
      this.f();
      this.r
         .getSkillsJson(
            this.k.getId(),
            new AsyncHandler<GetSettingsRequest, String>(this) {
               final ProfileFragment a;

               {
                  this.a = var1;
               }

               public void a(GetSettingsRequest var1, String var2) {
                  SkillsJsonParser.getInstance().clearSkills();
                  SkillsJsonParser.getInstance().parseSkills(var2);
                  this.a.g();
                  DataItems.DataItem var3 = SkillsJsonParser.getInstance().getViews(null).get(0);
                  if (!(var3 instanceof DataItems.GroupDataItem)
                     || ((DataItems.GroupDataItem)var3).getChildViews() != null && !((DataItems.GroupDataItem)var3).getChildViews().isEmpty()) {
                     SkillsJsonParser.getInstance().selectSkill(0);
                     new SingleFragmentActivity.Builder(this.a.getContext(), SkillSettingsFragment.class.getName())
                        .a("PARAM_PATH", new int[]{0})
                        .a("PARAM_TITLE", var3.getTitle())
                        .a(1001);
                  }
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "skills get skills json", false);
               }
            }
         );
   }
}
