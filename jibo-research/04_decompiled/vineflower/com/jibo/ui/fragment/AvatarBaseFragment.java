package com.jibo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.db.EntityData;
import com.jibo.service.SyncHelper;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.onboarding.AboutYouFragment;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import java.io.File;

public abstract class AvatarBaseFragment extends PhotoBaseFragment {
   public static String a = "NEW_USER";
   @BindView
   public ImageView avatar;
   protected int b = 2131230833;
   public boolean c = false;
   public boolean d = false;
   public Account e;
   @BindView
   public ProgressBar photoProgressBar;

   private void c(String var1) {
      try {
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }
      } catch (Exception var3) {
         Crashlytics.a(var3);
      }
   }

   public void a() {
      this.d = true;

      try {
         if (!TextUtils.isEmpty(this.l)) {
            this.a(this.l);
         }
      } catch (Exception var2) {
         if (this.d()) {
            this.avatar.setImageBitmap(null);
            UIUtils.a(this.avatar, this.getString(2131755302));
         }
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 107) {
         switch (var2) {
            case 0:
               try {
                  this.r();
               } catch (Exception var4) {
                  LogUtils.a(f, "onButtonClick:MakePhoto", var4);
                  UIUtils.a(this.getView(), this.getString(2131755299));
               }
               break;
            case 1:
               this.s();
               break;
            case 2:
               this.avatar.setImageBitmap(null);
               this.photoProgressBar.setVisibility(8);
               this.d = false;
               this.c(this.l);
               this.a(this.e);
         }
      }
   }

   protected void a(Account var1) {
      if (var1 != null) {
         if (TextUtils.isEmpty(var1.getPhotoUrl())) {
            this.avatar.setImageResource(this.b);
         } else {
            this.photoProgressBar.setVisibility(0);
            this.a(var1.getPhotoUrl());
         }
      }
   }

   protected void a(MemberAccount var1) {
      if (TextUtils.isEmpty(var1.getPhotoUrl())) {
         this.avatar.setImageResource(this.b);
      } else {
         this.a(var1.getPhotoUrl());
      }
   }

   protected void a(String var1) {
      this.photoProgressBar.setVisibility(0);
      Glide.a(this.getActivity()).a(var1).a(this.b).c(this.b).a(new RequestListener<String, GlideDrawable>(this) {
         final AvatarBaseFragment a;

         {
            this.a = var1;
         }

         public boolean a(GlideDrawable var1, String var2, Target<GlideDrawable> var3, boolean var4, boolean var5) {
            if (this.a.getActivity() != null && !this.a.getActivity().isFinishing() && !this.a.isRemoving()) {
               this.a.photoProgressBar.setVisibility(8);
            }

            return false;
         }

         public boolean a(Exception var1, String var2, Target<GlideDrawable> var3, boolean var4) {
            if (this.a.getActivity() != null && !this.a.getActivity().isFinishing() && !this.a.isRemoving()) {
               this.a.photoProgressBar.setVisibility(8);
            }

            return false;
         }
      }).a(DiskCacheStrategy.ALL).d().a(this.avatar);
   }

   protected void b() {
      this.f();
      EntityData.a(this.getActivity()).a().updatePhoto(new File(this.l), null, new AsyncHandler<UpdatePhotoRequest, Account>(this) {
         final AvatarBaseFragment a;

         {
            this.a = var1;
         }

         public void a(UpdatePhotoRequest var1, Account var2) {
            this.a.l = var2.getPhotoUrl();
            if (EntityData.a(this.a.getActivity()).i().getId().equals(var2.getId())) {
               this.a.e = var2;
               if (this.a.d()) {
                  EntityData.a(this.a.getActivity()).a(var2, true, null);
               }
            } else if (this.a.d()) {
               EntityData.a(this.a.getActivity()).a(var2, true);
            }

            this.a.g();
            this.a.a(new Runnable(this, var2) {
               final Account a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  SyncHelper.b(this.b.a.getActivity());
                  if (this.b.a.getActivity() instanceof OnBoardingActivity) {
                     Bundle var1x = new Bundle();
                     var1x.putBoolean(AvatarBaseFragment.a, true);
                     TabbedActivity.a(this.b.a.getActivity(), var1x);
                  } else {
                     this.b.a.b(this.a.getPhotoUrl());
                     this.b.a.a(this.a.getPhotoUrl());
                  }
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "update photo", true);
         }
      });
   }

   protected void b(Account var1) {
      this.f();
      EntityData.a(this.getActivity()).a(var1, false, new AsyncHandler<UpdateRequest, Account>(this) {
         final AvatarBaseFragment a;

         {
            this.a = var1;
         }

         public void a(UpdateRequest var1, Account var2) {
            File var3 = null;
            if (this.a.l != null) {
               var3 = new File(this.a.l);
            }

            if (var3 != null && var3.exists() && this.a.d && this.a.d()) {
               this.a.b();
            } else {
               this.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.a.g();
                     if (this.a.a instanceof AboutYouFragment) {
                        Bundle var1x = new Bundle();
                        var1x.putBoolean(AvatarBaseFragment.a, true);
                        TabbedActivity.a(this.a.a.getActivity(), var1x);
                     }

                     SyncHelper.c(this.a.a.getActivity());
                  }
               });
            }
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "save account", true);
         }
      });
   }

   protected void b(String var1) {
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1 && var1 == 69) {
         this.a();
      }
   }

   @OnClick
   public void onAvatarClick(View var1) {
      if (!this.c) {
         DialogUtils.a(this, 107, this.getString(2131755770), 2130903045);
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.e = EntityData.a(this.getActivity()).i();
   }
}
