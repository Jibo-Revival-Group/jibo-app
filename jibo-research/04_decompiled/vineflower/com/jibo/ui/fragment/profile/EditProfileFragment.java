package com.jibo.ui.fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberPhotoRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.AvatarBaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.ui.fragment.invite.EmailFragment;
import com.jibo.ui.fragment.invite.NewEmailFragment;
import com.jibo.ui.fragment.invite.PreferredNameFragment;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;

public class EditProfileFragment extends AvatarBaseFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {
   public static final String n = EditProfileFragment.class.getSimpleName();
   @BindView
   View avatarEdit;
   @BindView
   TextView birthday;
   @BindView
   View btnResendInvite;
   @BindView
   TextView email;
   @BindView
   TextView gender;
   @BindView
   TextView legalGuardianEmail;
   @BindView
   TextView legalGuardianName;
   @BindView
   TextView memberName;
   private Member o;
   @BindView
   TextView preferredName;
   @BindView
   TextView setEmailInfo;
   @BindView
   View settingAddPrefName;
   @BindView
   View settingBirthday;
   @BindView
   View settingEmail;
   @BindView
   View settingGender;
   @BindView
   View settingLegalGuardianEmail;
   @BindView
   View settingLegalGuardianName;
   @BindView
   View settingPrefferedName;
   @BindView
   View settingSetEmail;
   @BindView
   View settingSetPhone;

   private void a(Member var1) {
      this.f();
      EntityData.a(this.getActivity())
         .b()
         .updateMember(
            this.k.getId(),
            this.o.getId(),
            this.o.getAccount().getEmail(),
            this.o.getAccount().getFirstName(),
            this.o.getAccount().getLastName(),
            this.o.getAccount().getGender(),
            this.o.getAccount().getBirthday(),
            DateTimeUtils.isAdult(this.o.getAccount().getBirthday()),
            new AsyncHandler<UpdateMemberRequest, Loop>(this) {
               final EditProfileFragment a;

               {
                  this.a = var1;
               }

               public void a(UpdateMemberRequest var1, Loop var2) {
                  if (this.a.d()) {
                     EntityData.a(this.a.getActivity()).a(var2, true);
                  }

                  this.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.a.g();
                        this.a.a.t();
                        if (this.a.a.getActivity() instanceof SingleFragmentActivity) {
                           ((SingleFragmentActivity)this.a.a.getActivity()).q().putExtra(Member.class.getSimpleName(), this.a.a.o);
                        }

                        this.a.a.getActivity().setResult(-1);
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "update member", true);
               }
            }
         );
   }

   private void c(String var1) {
      this.f();
      EntityData.a(this.getActivity())
         .b()
         .updateNickname(this.k.getId(), this.o.getId(), var1, new AsyncHandler<UpdateNicknameRequest, CommandResponse>(this, var1) {
            final String a;
            final EditProfileFragment b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void a(UpdateNicknameRequest var1, CommandResponse var2) {
               this.b.g();
               this.b.o.setNickname(this.a);
               this.b.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.b.t();
                     ((SingleFragmentActivity)this.a.b.getActivity()).q().putExtra(Member.class.getSimpleName(), this.a.b.o);
                     this.a.b.getActivity().setResult(-1);
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.b.a(var1, "update nickname", true);
            }
         });
   }

   private void d(String var1) {
      this.f();
      EntityData.a(this.getActivity())
         .b()
         .updateMember(
            this.o.getLoopId(),
            this.o.getId(),
            var1,
            null,
            null,
            null,
            null,
            DateTimeUtils.isAdult(this.o.getAccount().getBirthday()),
            new AsyncHandler<UpdateMemberRequest, Loop>(this, var1) {
               final String a;
               final EditProfileFragment b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void a(UpdateMemberRequest var1, Loop var2) {
                  this.b.g();
                  this.b.o.getAccount().setEmail(this.a);
                  this.b.o.setStatus(Member.InvitationStatus.invited);
                  this.b.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.b.t();
                        if (this.a.b.getActivity() instanceof SingleFragmentActivity) {
                           ((SingleFragmentActivity)this.a.b.getActivity()).q().putExtra(Member.class.getSimpleName(), this.a.b.o);
                        }

                        this.a.b.getActivity().setResult(-1);
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.b.a(var1, "update member account", true);
               }
            }
         );
   }

   private void t() {
      if (!DateTimeUtils.isAdult(this.o.getAccount().getBirthday()) || !LoopHelper.isMemberAccepted(this.o) && !LoopHelper.isMemberInvited(this.o)) {
         this.c = false;
         this.avatarEdit.setVisibility(0);
      } else {
         this.settingGender.setClickable(false);
         this.settingBirthday.setClickable(false);
         this.settingSetEmail.setClickable(false);
         this.settingSetPhone.setClickable(false);
         this.c = true;
         this.avatarEdit.setVisibility(8);
      }

      this.memberName.setText(this.o.getAccount().getFullName());
      if (!TextUtils.isEmpty(this.o.getNickname())) {
         this.preferredName.setText('"' + this.o.getNickname() + '"');
         this.settingAddPrefName.setVisibility(8);
         this.settingPrefferedName.setVisibility(0);
      } else {
         this.settingPrefferedName.setVisibility(8);
         this.settingAddPrefName.setVisibility(0);
      }

      this.gender.setText(this.getResources().getStringArray(2130903043)[this.o.getAccount().getGender().ordinal()]);
      if (this.o.getAccount().getBirthday() != null) {
         TextView var5 = this.birthday;
         long var2 = this.o.getAccount().getBirthday();
         String var4;
         if (DateTimeUtils.isAdult(this.o.getAccount().getBirthday())) {
            var4 = DateTimeUtils.FULL_DATE_FORMAT;
         } else {
            var4 = DateTimeUtils.CHILD_BIRTH_DATE_FORMAT;
         }

         var5.setText(DateTimeUtils.getBirthdayString(var2, var4));
      }

      if (DateTimeUtils.isAdult(this.o.getAccount().getBirthday())) {
         this.settingLegalGuardianName.setVisibility(8);
         this.settingLegalGuardianEmail.setVisibility(8);
         if (!TextUtils.isEmpty(this.o.getAccount().getEmail())) {
            this.email.setText(this.o.getAccount().getEmail());
            this.settingEmail.setVisibility(0);
            this.settingSetEmail.setVisibility(8);
            View var10 = this.btnResendInvite;
            byte var1;
            if (LoopHelper.isMemberAccepted(this.o)) {
               var1 = 8;
            } else {
               var1 = 0;
            }

            var10.setVisibility(var1);
         } else {
            this.settingEmail.setVisibility(8);
            this.settingSetEmail.setVisibility(0);
            this.setEmailInfo.setText(this.getString(2131755841, this.o.getAccount().getFirstName()));
         }

         this.b = 2131230833;
      } else {
         this.settingSetEmail.setVisibility(8);
         this.settingEmail.setVisibility(8);
         this.settingSetPhone.setVisibility(8);
         this.settingLegalGuardianName.setVisibility(0);
         this.settingLegalGuardianEmail.setVisibility(0);
         String var7 = "";
         String var6 = "";
         String var12 = var6;
         String var11 = var7;
         if (!TextUtils.isEmpty(this.o.getLegalGuardianId())) {
            Member var8 = LoopHelper.getMemberByIdOrEmail(this.k, this.o.getLegalGuardianId());
            var12 = var6;
            var11 = var7;
            if (var8 != null) {
               var11 = var8.getAccount().getFullName();
               var12 = var8.getAccount().getEmail();
            }
         }

         this.legalGuardianName.setText(var11);
         this.legalGuardianEmail.setText(var12);
         int var9;
         if (LoopHelper.isMemberAccepted(this.o)) {
            var9 = 2131230830;
         } else {
            var9 = 2131230831;
         }

         this.b = var9;
      }

      if (this.o.getAccount() != null) {
         this.a(this.o.getAccount());
      }
   }

   private void u() {
      EntityData.a(this.getActivity())
         .b()
         .inviteMember(
            this.o.getLoopId(), this.o.getAccount().getEmail(), null, null, null, null, false, false, new AsyncHandler<InviteMemberRequest, Loop>(this) {
               final EditProfileFragment a;

               {
                  this.a = var1;
               }

               public void a(InviteMemberRequest var1, Loop var2) {
                  this.a.o.setStatus(Member.InvitationStatus.invited);
                  this.a.g();
                  this.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        Snackbar.a(this.a.a.avatar, 2131755296, 0).c();
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "invite member", true);
               }
            }
         );
   }

   private void v() {
      this.f();
      EntityData.a(this.getActivity()).b().removeMember(this.o.getLoopId(), this.o.getId(), new AsyncHandler<RemoveMemberRequest, Loop>(this) {
         final EditProfileFragment a;

         {
            this.a = var1;
         }

         public void a(RemoveMemberRequest var1, Loop var2) {
            this.a.g();
            this.a.a(new Runnable(this, var2) {
               final Loop a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  EntityData.a(this.b.a.getActivity()).a(this.a, true);
                  Intent var1x = new Intent();
                  var1x.putExtra("ARGS_REMOVED_FROM_LOOP", true);
                  this.b.a.getActivity().setResult(-1, var1x);
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

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 116) {
         this.v();
      } else if (var1 == 108) {
         this.o.getAccount().setGender(Account.Gender.values()[var2]);
         this.a(this.o);
      }
   }

   @Override
   public void a(long var1) {
      this.o.getAccount().setBirthday(var1);
      this.a(this.o);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
      this.n();
   }

   @Override
   protected void b() {
      this.f();
      EntityData.a(this.getActivity())
         .b()
         .updateMemberPhoto(this.k.getId(), this.o.getId(), new File(this.l), new AsyncHandler<UpdateMemberPhotoRequest, Loop>(this) {
            final EditProfileFragment a;

            {
               this.a = var1;
            }

            public void a(UpdateMemberPhotoRequest var1, Loop var2) {
               this.a.g();
               if (this.a.d()) {
                  EntityData.a(this.a.getActivity()).a(var2, true);
               }

               this.a.o = LoopHelper.getMemberByIdOrEmail(var2, this.a.o.getId());
               this.a.l = this.a.o.getAccount().getPhotoUrl();
               this.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.b(this.a.a.l);
                     this.a.a.a(this.a.a.l);
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "update photo", true);
            }
         });
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.o = (Member)var1.getParcelable(Member.class.getSimpleName());
   }

   @Override
   protected void b(String var1) {
      super.b(var1);
      if (this.getActivity() instanceof SingleFragmentActivity) {
         ((SingleFragmentActivity)this.getActivity()).q().putExtra(Member.class.getSimpleName(), this.o);
      }

      this.getActivity().setResult(-1);
   }

   @OnClick
   public void birthdayClick() {
      MaterialDatePickerDialogFragment var5 = new MaterialDatePickerDialogFragment();
      Bundle var3 = new Bundle();
      if (this.o.getAccount().getBirthday() != null) {
         long var1;
         if (this.o.getAccount().getBirthday() != null && this.o.getAccount().getBirthday() != -1L) {
            var1 = this.o.getAccount().getBirthday();
         } else {
            var1 = System.currentTimeMillis();
         }

         var3.putLong("ARGS_DATE", var1);
      }

      var3.putString("ARGS_TITLE", this.getString(2131755768));
      Calendar var4 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var4.add(1, -13);
      var4.add(6, 1);
      if (!DateTimeUtils.isAdult(this.o.getAccount().getBirthday())) {
         var3.putString("ARGS_ERROR_TEXT", this.getString(2131755300));
         var3.putLong("ARGS_MIN_VALUE", var4.getTimeInMillis());
      } else {
         var3.putString("ARGS_ERROR_TEXT", this.getString(2131755298));
         var3.putLong("ARGS_MAX_VALUE", var4.getTimeInMillis() - 86400000L);
      }

      var5.setArguments(var3);
      var5.setTargetFragment(this, 0);
      var5.show(((AppCompatActivity)this.getContext()).getSupportFragmentManager(), "datePicker");
   }

   @OnClick
   public void genderClick() {
      DialogUtils.a(this, 108, this.getString(2131755479), 2130903042, this.o.getAccount().getGender().ordinal());
   }

   @OnClick
   public void nicknameClick() {
      PreferredNameFragment.a(this, this.k, this.o);
   }

   @OnClick
   public void nicknameClickEdit() {
      PreferredNameFragment.a(this, this.k, this.o);
   }

   @Override
   protected String o() {
      return this.getString(2131756035);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         if (var1 == 69) {
            this.b();
         } else if (var1 == 1011) {
            if (var3 != null) {
               if (var3.hasExtra("ARGS_CHOSEN_PHONETIC_NAME")) {
                  String var5 = var3.getStringExtra("ARGS_CHOSEN_PHONETIC_NAME");
                  this.o.setPhoneticName(var5);
                  Intent var4 = new Intent();
                  var4.putExtra("ARGS_CHOSEN_PHONETIC_NAME", var5);
                  this.getActivity().setResult(-1, var4);
               }

               label32: {
                  String var7 = var3.getStringExtra("ARGS_CHOSEN_NICKNAME");
                  if (var7 != null) {
                     var6 = var7;
                     if (!var7.isEmpty()) {
                        break label32;
                     }
                  }

                  var6 = null;
               }

               this.c(var6);
            }
         } else if (var1 == 1012 && var3 != null) {
            this.d(var3.getStringExtra("ARGS_CHOSEN_EMAIL"));
         } else if (var1 == 1020) {
            this.o.getAccount().setEmail(var3.getStringExtra("ARGS_CHOSEN_EMAIL"));
            this.o.setStatus(Member.InvitationStatus.invited);
            this.t();
         } else if (var1 == 1021) {
         }
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
      this.getActivity().setResult(0);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427433, var2, false);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Member.class.getSimpleName(), this.o);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.t();
   }

   @OnClick
   public void removeFromLoopClick() {
      DialogUtils.a(
         this,
         116,
         this.getString(2131755273, this.o.getAccount().getFirstName()),
         this.getString(2131755263, this.o.getAccount().getFirstName(), this.o.getAccount().getFirstName()),
         this.getString(2131755625)
      );
   }

   @OnClick
   public void resendInviteClick() {
      if (TextUtils.isEmpty(this.o.getAccount().getEmail())) {
         SingleFragmentActivity.Builder var1 = new SingleFragmentActivity.Builder(this, EmailFragment.class.getName());
         var1.a(Loop.class.getSimpleName(), this.k);
         var1.a(MemberAccount.class.getSimpleName(), this.o.getAccount());
         var1.a("ARG_MODE", EmailFragment.LaunchMode.return_email.ordinal());
         var1.a(1012);
      } else {
         this.u();
      }
   }

   @OnClick
   public void setEmailClick() {
      if (TextUtils.isEmpty(this.o.getAccount().getEmail())) {
         SingleFragmentActivity.Builder var1 = new SingleFragmentActivity.Builder(this, NewEmailFragment.class.getName());
         var1.a(Loop.class.getSimpleName(), this.k);
         var1.a(Member.class.getSimpleName(), this.o);
         var1.a(MemberAccount.class.getSimpleName(), this.o.getAccount());
         var1.a("ARG_MODE", EmailFragment.LaunchMode.add_email.ordinal());
         var1.a(1020);
      } else {
         this.u();
      }
   }
}
