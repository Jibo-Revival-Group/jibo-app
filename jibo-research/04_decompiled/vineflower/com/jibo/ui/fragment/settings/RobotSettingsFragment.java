package com.jibo.ui.fragment.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.notification.JiboNotificationAsyncClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.WifiActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.ChangeLoopNameDialog;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;

public class RobotSettingsFragment extends BaseFragment implements OnDismissListener {
   public static final String a = RobotSettingsFragment.class.getSimpleName();
   private JiboRobotPropertiesAsyncClient b;
   @BindView
   View btnAbout;
   @BindView
   View btnPassphrase;
   private JiboNotificationAsyncClient c;
   private Robot d;
   private CircleProgressFragment e;
   @BindView
   ImageView iconPassphrase;
   @BindView
   ImageView imgJiboAvatar;
   private String l;
   private String m;
   @BindView
   Switch mRemoteSwitch;
   private OnClickListener n = new OnClickListener(this) {
      final RobotSettingsFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         LoopPassphraseUtils.a(this.a, LoopPassphraseUtils.DialogType.FROM_SETTINGS);
      }
   };
   private OnClickListener o = new OnClickListener(this) {
      final RobotSettingsFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         LoopPassphraseUtils.a(this.a, LoopPassphraseUtils.DialogType.RESTORE, this.a.k);
      }
   };
   @BindView
   TextView passphraseText;
   @BindView
   TextView txtJiboLocation;
   @BindView
   TextView txtJiboName;
   @BindView
   TextView txtJiboWifi;

   private void a() {
      KeyManager var2 = KeyManager.getInstance(this.getContext(), EntityData.a(this.getActivity()).i().getId());

      try {
         var4 = var2.obtainKeyHolder(this.getContext(), this.k.getId());
      } catch (Exception var3) {
         var4 = null;
      }

      boolean var1;
      if (var4 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      EntityData.a(this.getContext()).d().restoreEncryptedKey(this.k.getId(), null, new AsyncHandler<RestoreRequest, Backup>(this, var1) {
         final boolean a;
         final RobotSettingsFragment b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void a(RestoreRequest var1, Backup var2x) {
            this.b.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.b.btnPassphrase.setVisibility(0);
                  if (this.a.a) {
                     this.a.b.passphraseText.setText(2131755633);
                     this.a.b.iconPassphrase.setImageResource(2131231039);
                     this.a.b.btnPassphrase.setOnClickListener(this.a.b.n);
                  } else {
                     this.a.b.passphraseText.setText(2131755635);
                     this.a.b.iconPassphrase.setImageResource(2131231039);
                     this.a.b.btnPassphrase.setOnClickListener(this.a.b.o);
                  }
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.b.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.b.btnPassphrase.setVisibility(0);
                  if (this.a.a) {
                     this.a.b.passphraseText.setText(2131755223);
                     this.a.b.iconPassphrase.setImageResource(2131231033);
                     this.a.b.btnPassphrase.setOnClickListener(this.a.b.n);
                  } else {
                     this.a.b.passphraseText.setText(2131755636);
                     this.a.b.iconPassphrase.setImageResource(2131231283);
                     this.a.b.btnPassphrase.setOnClickListener(null);
                     this.a.b.passphraseText.setTextColor(this.a.b.getResources().getColor(2131099846));
                  }
               }
            });
         }
      });
   }

   private void a(StatusContainer var1) {
      this.b.getRobot(this.k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this, var1) {
         final StatusContainer a;
         final RobotSettingsFragment b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void a(GetRobotRequest var1, Robot var2) {
            this.b.d = var2;
            this.b.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.b.g();
                  this.a.b.l = RobotHelper.getLocation(this.a.b.d);
                  this.a.b.m = RobotHelper.getTimeZone(this.a.b.d);
                  this.a.b.imgJiboAvatar.setImageLevel(RobotHelper.getAvatar(this.a.b.d));
                  TextView var3 = this.a.b.txtJiboWifi;
                  String var2x;
                  if (this.a.a != null && this.a.a.getConnected()) {
                     var2x = RobotHelper.getWifiName(this.a.b.d);
                  } else {
                     var2x = this.a.b.getString(2131755444);
                  }

                  var3.setText(var2x);
                  TextView var4 = this.a.b.txtJiboWifi;
                  FragmentActivity var6 = this.a.b.getActivity();
                  int var1x;
                  if (this.a.a != null && this.a.a.getConnected()) {
                     var1x = 2131099846;
                  } else {
                     var1x = 2131099764;
                  }

                  var4.setTextColor(ImageUtils.b(var6, var1x));
                  var3 = this.a.b.txtJiboLocation;
                  if (!TextUtils.isEmpty(this.a.b.l) && !TextUtils.isEmpty(this.a.b.m)) {
                     var2x = this.a.b.l;
                  } else {
                     var2x = this.a.b.getString(2131755802);
                  }

                  var3.setText(var2x);
                  this.a.b.q();
                  this.a.b.mRemoteSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     public void onCheckedChanged(CompoundButton var1, boolean var2x) {
                        this.a.a.b.b(var2x);
                     }
                  });
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.b.a(var1, "get robot", false);
            if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
               this.b.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.b.txtJiboWifi.setText(2131755444);
                     this.a.b.txtJiboWifi.setTextColor(ImageUtils.b(this.a.b.getActivity(), 2131099764));
                     this.a.b.txtJiboLocation.setText(2131755802);
                  }
               });
            }
         }
      });
   }

   private void b() {
      try {
         this.f();
         if (this.k != null && this.b != null && this.c != null) {
            JiboNotificationAsyncClient var3 = this.c;
            String var1 = this.k.getRobot();
            AsyncHandler var2 = new AsyncHandler<GetStatusRequest, StatusContainer>(this) {
               final RobotSettingsFragment a;

               {
                  this.a = var1;
               }

               public void a(GetStatusRequest var1, StatusContainer var2x) {
                  this.a.a(var2x);
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "notification get status", false);
                  if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                     this.a.a(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           this.a.a.f();
                        }
                     });
                     this.a.a((StatusContainer)null);
                  }
               }
            };
            var3.getStatus(var1, var2);
         }
      } catch (Exception var4) {
      }
   }

   private void b(boolean var1) {
      this.d.getPayload().a("remoteEnabled");
      this.d.getPayload().a("remoteEnabled", var1);
      if (this.e != null) {
         this.e.a();
         this.e = null;
      }

      this.e = new CircleProgressFragment();
      int var2;
      if (var1) {
         var2 = 2131755622;
      } else {
         var2 = 2131755620;
      }

      String var3 = this.getString(var2);
      this.e.c(var3);
      this.e.show(this.getActivity().getSupportFragmentManager(), "CircleFragment");
      this.b.updateRobot(this.d, new AsyncHandler<CreateRobotRequest, CommandResponse>(this, var1) {
         final boolean a;
         final RobotSettingsFragment b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void a(CreateRobotRequest var1, CommandResponse var2x) {
            CircleProgressFragment var4 = this.b.e;
            RobotSettingsFragment var5 = this.b;
            int var3x;
            if (this.a) {
               var3x = 2131755623;
            } else {
               var3x = 2131755621;
            }

            var4.a(var5.getString(var3x));
         }

         @Override
         public void onError(Exception var1) {
            this.b.d.getPayload().a("remoteEnabled");
            JsonObject var3x = this.b.d.getPayload();
            boolean var2x;
            if (!this.a) {
               var2x = true;
            } else {
               var2x = false;
            }

            var3x.a("remoteEnabled", var2x);
            this.b.e.b(this.b.getString(2131755624));
         }
      });
   }

   private void q() {
      if (this.d != null && this.d.getPayload() != null && this.d.getPayload().b("remoteEnabled")) {
         try {
            this.mRemoteSwitch.setChecked(this.d.getPayload().c("remoteEnabled").g());
         } catch (UnsupportedOperationException var2) {
         }
      }
   }

   private void r() {
      this.s();
      EntityData.a(this.getActivity()).b().updateLoop(this.k.getId(), this.k.getName(), new AsyncHandler<UpdateRequest, CommandResponse>(this) {
         final RobotSettingsFragment a;

         {
            this.a = var1;
         }

         public void a(UpdateRequest var1, CommandResponse var2) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  EntityData.a(this.a.a.getActivity()).a(this.a.a.k, false);
                  this.a.a.e.a(this.a.a.getString(2131755539));
                  this.a.a.txtJiboName.setText(this.a.a.k.getName());
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.e.b(this.a.getString(2131755538));
            this.a.a(var1, "update loop", false);
         }
      });
   }

   private void s() {
      this.g();
      this.e = new CircleProgressFragment();
      this.e.c(this.getString(2131755537));
      this.e.show(this.getActivity().getSupportFragmentManager(), "CircleFragment");
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 111 && var2 == 2131296885) {
         this.k.setName((String)var3);
         this.txtJiboName.setText(this.k.getName());
         this.r();
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @OnClick
   public void btnEnableRemoteClick() {
      this.mRemoteSwitch.toggle();
   }

   @OnClick
   public void btnHolidaysClick() {
      Bundle var1 = new Bundle();
      var1.putParcelable(Loop.class.getSimpleName(), this.k);
      ((BaseActivity)this.getActivity()).a(HolidaySettingsFragment.class, var1);
   }

   @OnClick
   public void btnJiboAvatarClick() {
      Bundle var1 = new Bundle();
      var1.putParcelable(Loop.class.getSimpleName(), this.k);
      var1.putParcelable(Robot.class.getSimpleName(), this.d);
      ((BaseActivity)this.getActivity()).a(AvatarSelectionFragment.class, var1);
      ((SingleFragmentActivity)this.getActivity()).q().setAction(AvatarSelectionFragment.class.getSimpleName());
   }

   @OnClick
   public void btnLocationClick() {
      Bundle var1 = new Bundle();
      var1.putParcelable(Loop.class.getSimpleName(), this.k);
      var1.putString("ARGS_LOCATION", this.l);
      var1.putString("timezone", this.m);
      ((BaseActivity)this.getActivity()).a(LocationFragment.class, var1);
   }

   @OnClick
   public void btnWiFiSettingsClick() {
      WifiActivity.a(this.getActivity(), this.k);
   }

   @OnClick
   public void changeName(View var1) {
      ChangeLoopNameDialog var3 = new ChangeLoopNameDialog();
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      var3.setTargetFragment(this, 111);
      var3.setArguments(var2);
      var3.show(this.getActivity().getSupportFragmentManager(), ChangeLoopNameDialog.class.getSimpleName());
   }

   @Override
   protected String o() {
      return this.getString(2131756070);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.d = (Robot)var1.getParcelable(Robot.class.getSimpleName());
      } else if (this.getArguments() != null) {
         this.d = (Robot)this.getArguments().getParcelable(Robot.class.getSimpleName());
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427466, var2, false);
   }

   public void onDismiss(DialogInterface var1) {
      this.a();
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.k == null) {
         this.c().postDelayed(new Runnable(this) {
            final RobotSettingsFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.getActivity().onBackPressed();
            }
         }, 100L);
      } else {
         this.txtJiboName.setText(this.k.getName());
         if (this.d != null) {
            this.imgJiboAvatar.setImageLevel(RobotHelper.getAvatar(this.d));
         }

         this.b();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Robot.class.getSimpleName(), this.d);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if (this.k == null) {
         this.k = SharedPreferencesUtil.f(this.getActivity());
      }

      Account var3 = EntityData.a(this.getActivity()).i();
      if (var3 != null && LoopHelper.isOwner(this.k, var3.getId())) {
         this.b = EntityData.a(this.getActivity()).g();
         JiboNotificationAsyncClient var4 = new JiboNotificationAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
         this.c = var4;
         this.a(var4);
      }

      this.a();
   }

   @OnClick
   public void showAbout(View var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      var2.putParcelable(Robot.class.getSimpleName(), this.d);
      ((BaseActivity)this.getActivity()).a(RobotAboutFragment.class, var2);
   }
}
