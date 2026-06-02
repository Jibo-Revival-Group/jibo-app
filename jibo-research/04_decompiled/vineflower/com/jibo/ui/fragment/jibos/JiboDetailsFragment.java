package com.jibo.ui.fragment.jibos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient;
import com.jibo.aws.integration.aws.services.gqa.model.Attribution;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.notification.JiboNotificationAsyncClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.DatabaseContract;
import com.jibo.db.EntityData;
import com.jibo.service.SyncHelper;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.activity.WifiActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.account.AccountSettingsFragment;
import com.jibo.ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.dialog.HolidaysPopupFragment;
import com.jibo.ui.fragment.dialog.LoopInfoDialog;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog;
import com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.ui.fragment.invite.NameBirthdayGenderFragment;
import com.jibo.ui.fragment.jibos.adapter.LoopMembersListAdapter;
import com.jibo.ui.fragment.profile.ProfileFragment;
import com.jibo.ui.fragment.settings.RobotSettingsFragment;
import com.jibo.ui.helpers.Items;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JiboDetailsFragment
   extends BaseFragment
   implements LoaderManager.LoaderCallbacks<Cursor>,
   SwipeRefreshLayout.OnRefreshListener,
   LoopPassphraseRestoreDialog.BackupKeyRestoredListener {
   boolean a = false;
   CircleProgressFragment b;
   @BindView
   View btnReconnectToJibo;
   private List<Items.Item> c = new ArrayList<>();
   private JiboDetailsFragment.LoadAttributionsAsyncTask d = new JiboDetailsFragment.LoadAttributionsAsyncTask(this);
   private List<Attribution> e;
   private LoopMembersListAdapter l;
   @BindView
   RecyclerView list;
   @BindView
   View loopSuspendedView;
   private Member m = null;
   private JiboNotificationAsyncClient n;
   private JiboSkillsAsyncClient o;
   private Member p = null;
   private OnClickListener q = new OnClickListener(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         Items.MemberItem var2 = (Items.MemberItem)var1.getTag();
         if (var2.b().getAccount() != null) {
            this.a.a(var2.b());
         }
      }
   };
   private OnLongClickListener r = new OnLongClickListener(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      public boolean onLongClick(View var1) {
         Items.MemberItem var3 = (Items.MemberItem)var1.getTag();
         boolean var2;
         if (var3.b().getAccount() == null) {
            var2 = false;
         } else {
            this.a.p = var3.b();
            DialogUtils.a(
               this.a,
               116,
               this.a.getString(2131755273, this.a.p.getAccount().getFirstName()),
               this.a.getString(2131755263, this.a.p.getAccount().getFirstName(), this.a.p.getAccount().getFirstName()),
               this.a.getString(2131755625)
            );
            var2 = true;
         }

         return var2;
      }
   };
   private JiboRobotPropertiesAsyncClient s;
   @BindView
   SwipeRefreshLayout swipeRefreshLayout;
   private Robot t;
   @BindView
   TextView tutorialTitle;
   @BindView
   View tutorialTitleContainer;
   private BroadcastReceiver u = new BroadcastReceiver(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      public void onReceive(Context var1, Intent var2) {
         if ("LOOP_HOLIDAYS_ALARM_ACTION".equals(var2.getAction()) && this.a.k.getId().equals(var2.getStringExtra(Loop.class.getSimpleName()))) {
            HolidaysPopupFragment.a(this.a.getFragmentManager(), this.a.k);
         }
      }
   };
   private OnClickListener v = new OnClickListener(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         new LoopInfoDialog().show(this.a.getFragmentManager(), LoopInfoDialog.class.getSimpleName());
      }
   };
   private LoopPassphraseUtils.KeyBackupCheckListener w = new LoopPassphraseUtils.KeyBackupCheckListener(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a() {
         this.a.g();
      }

      @Override
      public void b() {
         this.a.g();
         LoopPassphraseUtils.a(this.a, LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO_NO_BACKUP);
      }
   };
   private LoopPassphraseUtils.KeyBackupCheckListener x = new LoopPassphraseUtils.KeyBackupCheckListener(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a() {
         this.a.g();
         LoopPassphraseUtils.a(this.a, LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO, this.a.k);
      }

      @Override
      public void b() {
         this.a.g();
         WifiActivity.a(this.a.getActivity(), this.a.k);
      }
   };
   private OnClickListener y = new OnClickListener(this) {
      final JiboDetailsFragment a;

      {
         this.a = var1;
      }

      public void onClick(View var1) {
         if (var1.findViewById(2131296566).getVisibility() == 0) {
            String var2 = ((Items.AttributionItem)var1.getTag()).a().getUrl();
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var2)));
         }
      }
   };

   private void A() {
      if (!SharedPreferencesUtil.q(this.getActivity()) && this.o != null && this.k != null && this.o != null && this.k != null && !this.a) {
         this.f();
         this.o.getSkillsJson(this.k.getId(), new AsyncHandler<GetSettingsRequest, String>(this) {
            final JiboDetailsFragment a;

            {
               this.a = var1;
            }

            public void a(GetSettingsRequest var1, String var2) {
               SkillsJsonParser.getInstance().clearSkills();
               SkillsJsonParser.getInstance().parseSkills(var2);
               boolean var3;
               if (!SkillsJsonParser.getInstance().isConfigured()) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               this.a.g();
               if (var3) {
                  SharedPreferencesUtil.b(this.a.getActivity(), true);
                  DialogUtils.a(this.a, 124, this.a.getString(2131755591), this.a.getString(2131755589), this.a.getString(2131755590));
               }
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "skills get skills json", false);
            }
         });
      }
   }

   private List<Items.Item> a(List<Attribution> var1) {
      ArrayList var4 = new ArrayList();
      if (var1 != null) {
         Date var2 = null;

         for (Attribution var6 : var1) {
            Date var7;
            if (var2 == null) {
               var7 = new Date(var6.getTimestamp());
               var4.add(new Items.DateItem(DateTimeUtils.getBirthdayString(var6.getTimestamp(), DateTimeUtils.FULL_DATE_FORMAT)));
            } else {
               label20: {
                  Date var3 = new Date(var6.getTimestamp());
                  if (var3.getDate() == var2.getDate() && var3.getMonth() == var2.getMonth()) {
                     var7 = var2;
                     if (var3.getYear() == var2.getYear()) {
                        break label20;
                     }
                  }

                  var4.add(new Items.DateItem(DateTimeUtils.getBirthdayString(var6.getTimestamp(), DateTimeUtils.FULL_DATE_FORMAT)));
                  var7 = var3;
               }
            }

            var4.add(new Items.AttributionItem(var6, this.y));
            var2 = var7;
         }
      }

      return var4;
   }

   private void a(Member var1) {
      SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this, ProfileFragment.class.getName());
      var2.a(Member.class.getSimpleName(), var1).a(Loop.class.getSimpleName(), this.k).a("ARG_LOOPS", ((TabbedActivity)this.getActivity()).x());
      var2.a(1007);
   }

   private void a(String var1, String var2, String var3) {
      this.b = new CircleProgressFragment();
      this.b.c(this.getString(2131755631, var3));
      this.b.show(this.getActivity().getSupportFragmentManager(), CircleProgressFragment.class.getSimpleName());
      EntityData.a(this.getActivity()).b().removeMember(var1, var2, new AsyncHandler<RemoveMemberRequest, Loop>(this) {
         final JiboDetailsFragment a;

         {
            this.a = var1;
         }

         public void a(RemoveMemberRequest var1, Loop var2x) {
            EntityData.a(this.a.getActivity()).a(var2x, true);
            this.a.b.a(this.a.b.getString(2131755630));
         }

         @Override
         public void onError(Exception var1) {
            if (!this.a.d()) {
               this.a.b.b(this.a.getString(2131755626));
            } else if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
               this.a.a(new Runnable(this, var1) {
                  final Exception a;
                  final <unrepresentable> b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  @Override
                  public void run() {
                     String var1x = ErrorHelper.a(this.b.a.getActivity().getApplicationContext(), this.a);
                     this.b.a.b.b(var1x);
                  }
               });
            }

            this.a.a(var1, "remove member", false);
         }
      });
   }

   private void a(Collection<Items.Item> var1) {
      var1.add(new Items.SubheaderItem(2131755357));
      Account var2 = EntityData.a(this.getActivity()).i();
      if (LoopHelper.isOwner(this.k, var2.getId())) {
         var1.add(new Items.JiboSettingsItem(new OnClickListener(this) {
            final JiboDetailsFragment a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               new SingleFragmentActivity.Builder(this.a.getActivity(), RobotSettingsFragment.class.getName()).a(Loop.class.getSimpleName(), this.a.k).a(1003);
            }
         }, this.t));
      } else {
         var1.add(new Items.WifiSettingsItem(new OnClickListener(this) {
            final JiboDetailsFragment a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               WifiActivity.a(this.a.getActivity(), this.a.k);
            }
         }));
      }
   }

   private void b() {
      this.tutorialTitleContainer.setVisibility(0);
      TextView var2 = this.tutorialTitle;
      String var1;
      if (this.k != null) {
         var1 = this.k.getName();
      } else {
         var1 = "";
      }

      var2.setText(var1);
   }

   private void b(boolean var1) {
      byte var2 = 0;
      this.loopSuspendedView.setVisibility(0);
      View var3 = this.btnReconnectToJibo;
      if (!var1) {
         var2 = 8;
      }

      var3.setVisibility(var2);
      this.list.setVisibility(8);
      if (var1 && this.u()) {
         this.f();
         LoopPassphraseUtils.a(this.k.getId(), this, this.w);
      }
   }

   private void q() {
      SkillsJsonParser.getInstance().clearSkills();
      SingleFragmentActivity.Builder var1 = new SingleFragmentActivity.Builder(this.getActivity(), AccountSettingsFragment.class.getName());
      var1.a("ARG_LOOPS", ((TabbedActivity)this.getActivity()).x());
      var1.a(1001);
   }

   private boolean r() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 4
      // 03: aload 0
      // 04: monitorenter
      // 05: aload 0
      // 06: getfield com/jibo/ui/fragment/jibos/JiboDetailsFragment.k Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 09: astore 7
      // 0b: iload 4
      // 0d: istore 3
      // 0e: aload 7
      // 10: ifnull 94
      // 13: iload 4
      // 15: istore 3
      // 16: aload 7
      // 18: aload 0
      // 19: invokevirtual com/jibo/ui/fragment/jibos/JiboDetailsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 1c: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 1f: invokevirtual com/jibo/db/EntityData.i ()Lcom/jibo/aws/integration/aws/services/account/model/Account;
      // 22: invokevirtual com/jibo/aws/integration/aws/services/account/model/Account.getId ()Ljava/lang/String;
      // 25: invokestatic com/jibo/aws/integration/helpers/LoopHelper.isOwner (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z
      // 28: ifeq 94
      // 2b: aload 0
      // 2c: invokevirtual com/jibo/ui/fragment/jibos/JiboDetailsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 2f: invokestatic com/jibo/utils/SharedPreferencesUtil.h (Landroid/content/Context;)[Ljava/lang/String;
      // 32: astore 8
      // 34: aload 8
      // 36: arraylength
      // 37: istore 2
      // 38: bipush 0
      // 39: istore 1
      // 3a: iload 4
      // 3c: istore 3
      // 3d: iload 1
      // 3e: iload 2
      // 3f: if_icmpge 94
      // 42: aload 8
      // 44: iload 1
      // 45: aaload
      // 46: astore 6
      // 48: aload 7
      // 4a: aload 6
      // 4c: invokestatic com/jibo/aws/integration/helpers/LoopHelper.getMemberByIdOrEmail (Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;
      // 4f: astore 5
      // 51: aload 5
      // 53: ifnull 98
      // 56: aload 5
      // 58: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Member.getStatus ()Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
      // 5b: getstatic com/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus.accepted Lcom/jibo/aws/integration/aws/services/loop/model/Member$InvitationStatus;
      // 5e: if_acmpne 98
      // 61: aload 0
      // 62: invokevirtual com/jibo/ui/fragment/jibos/JiboDetailsFragment.getFragmentManager ()Landroid/support/v4/app/FragmentManager;
      // 65: invokestatic com/jibo/ui/fragment/dialog/DialogUtils.a (Landroid/support/v4/app/FragmentManager;)Z
      // 68: ifne 98
      // 6b: bipush 1
      // 6c: istore 3
      // 6d: aload 0
      // 6e: invokevirtual com/jibo/ui/fragment/jibos/JiboDetailsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 71: aload 6
      // 73: invokestatic com/jibo/utils/SharedPreferencesUtil.b (Landroid/content/Context;Ljava/lang/String;)V
      // 76: aload 0
      // 77: invokevirtual com/jibo/ui/fragment/jibos/JiboDetailsFragment.c ()Landroid/os/Handler;
      // 7a: astore 7
      // 7c: new com/jibo/ui/fragment/jibos/JiboDetailsFragment$10
      // 7f: astore 6
      // 81: aload 6
      // 83: aload 0
      // 84: aload 5
      // 86: invokespecial com/jibo/ui/fragment/jibos/JiboDetailsFragment$10.<init> (Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
      // 89: aload 7
      // 8b: aload 6
      // 8d: ldc2_w 500
      // 90: invokevirtual android/os/Handler.postDelayed (Ljava/lang/Runnable;J)Z
      // 93: pop
      // 94: aload 0
      // 95: monitorexit
      // 96: iload 3
      // 97: ireturn
      // 98: iinc 1 1
      // 9b: goto 3a
      // 9e: astore 5
      // a0: aload 0
      // a1: monitorexit
      // a2: aload 5
      // a4: athrow
      // try (4 -> 7): 79 null
      // try (13 -> 28): 79 null
      // try (39 -> 43): 79 null
      // try (45 -> 53): 79 null
      // try (55 -> 73): 79 null
   }

   private void s() {
      try {
         if (this.k != null && this.n != null) {
            this.f();
            JiboNotificationAsyncClient var5 = this.n;
            String var7 = this.k.getRobot();
            AsyncHandler var6 = new AsyncHandler<GetStatusRequest, StatusContainer>(this) {
               final JiboDetailsFragment a;

               {
                  this.a = var1;
               }

               public void a(GetStatusRequest var1, StatusContainer var2) {
                  EntityData.a(this.a.getActivity()).g().getRobot(this.a.k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this, var2) {
                     final StatusContainer a;
                     final <unrepresentable> b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     public void a(GetRobotRequest var1, Robot var2x) {
                        this.b.a.t = var2x;
                        this.b.a.a(new Runnable(this, var2x) {
                           final Robot a;
                           final <unrepresentable> b;

                           {
                              this.b = var1;
                              this.a = var2x;
                           }

                           @Override
                           public void run() {
                              this.b.b.a.g();

                              for (Items.Item var2x : this.b.b.a.c) {
                                 if (var2x instanceof Items.WifiSettingsItem) {
                                    ((Items.WifiSettingsItem)var2x).a(this.a);
                                    ((Items.WifiSettingsItem)var2x).a(this.b.a);
                                    this.b.b.a.l.notifyItemChanged(this.b.b.a.c.indexOf(var2x));
                                    break;
                                 }

                                 if (var2x instanceof Items.JiboSettingsItem) {
                                    this.b.b.a.t();
                                    break;
                                 }
                              }
                           }
                        });
                     }

                     @Override
                     public void onError(Exception var1) {
                        this.b.a.a(var1, "get robot", false);
                        if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                           this.b.a.a(new Runnable(this) {
                              final <unrepresentable> a;

                              {
                                 this.a = var1;
                              }

                              @Override
                              public void run() {
                                 for (Items.Item var2 : this.a.b.a.c) {
                                    if (var2 instanceof Items.WifiSettingsItem) {
                                       ((Items.WifiSettingsItem)var2).a((Robot)null);
                                       ((Items.WifiSettingsItem)var2).a((StatusContainer)null);
                                       this.a.b.a.l.notifyItemChanged(this.a.b.a.c.indexOf(var2));
                                       break;
                                    }
                                 }
                              }
                           });
                        }
                     }
                  });
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
                           if (!this.a.a.k.isSuspended() && this.a.a.c.get(0) != null && this.a.a.c.get(0) instanceof Items.WifiSettingsItem) {
                              ((Items.WifiSettingsItem)this.a.a.c.get(0)).a((Robot)null);
                              ((Items.WifiSettingsItem)this.a.a.c.get(0)).a((StatusContainer)null);
                              this.a.a.l.notifyItemChanged(0);
                           }
                        }
                     });
                  }
               }
            };
            var5.getStatus(var7, var6);
         } else if (this.k != null) {
            JiboRobotPropertiesAsyncClient var3 = EntityData.a(this.getActivity()).g();
            String var1 = this.k.getRobotFriendlyId();
            AsyncHandler var2 = new AsyncHandler<GetRobotRequest, Robot>(this) {
               final JiboDetailsFragment a;

               {
                  this.a = var1;
               }

               public void a(GetRobotRequest var1, Robot var2) {
                  this.a.t = var2;
                  this.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        this.a.a.g();
                        this.a.a.t();
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "get robot", false);
               }
            };
            var3.getRobot(var1, var2);
         }
      } catch (Exception var4) {
         this.g();
      }
   }

   private void t() {
      for (Items.Item var2 : this.c) {
         if (var2 instanceof Items.JiboSettingsItem) {
            ((Items.JiboSettingsItem)var2).a(this.t);
            break;
         }
      }

      this.l.notifyDataSetChanged();
   }

   private boolean u() {
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

      return var1;
   }

   private void v() {
      this.loopSuspendedView.setVisibility(8);
      this.list.setVisibility(0);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void w() {
      if (this.k != null) {
         int var2;
         boolean var3;
         Member var4;
         ArrayList var5;
         Member var7;
         Member var8;
         Iterator var10;
         try {
            var8 = LoopHelper.getOwner(this.k);
            var4 = LoopHelper.getMemberForAccount(this.k, EntityData.a(this.getActivity()).i());
            var3 = LoopHelper.isOwner(this.k, var4.getAccountId());
            List var6 = LoopHelper.sortMembers(this.k, var4);
            var2 = LoopHelper.getUnenrolledMembersCount(this.k);
            var7 = LoopHelper.getFirstUnenrolledMember(this.k);
            var5 = new ArrayList();
            var10 = var6.iterator();
         } catch (Exception var22) {
            LogUtils.a(f, "Exception: ", var22);
            return;
         }

         while (true) {
            try {
               if (!var10.hasNext()) {
                  break;
               }

               Member var9 = (Member)var10.next();
               Items.MemberItem var28 = new Items.MemberItem(this.q, this.k, var9);
               var5.add(var28);
            } catch (Exception var23) {
               LogUtils.a(f, "Exception: ", var23);
               return;
            }
         }

         int var1;
         ArrayList var29;
         try {
            if (!this.d()) {
               return;
            }

            var29 = new ArrayList();
            var1 = LoopHelper.getActiveMembersCount(this.k);
         } catch (Exception var21) {
            LogUtils.a(f, "Exception: ", var21);
            return;
         }

         if (var3) {
            if (var2 > 0) {
               if (var7 == null) {
                  try {
                     var8.getAccount().getFirstName();
                  } catch (Exception var19) {
                     LogUtils.a(f, "Exception: ", var19);
                     return;
                  }
               } else {
                  try {
                     var7.getAccount().getFirstName();
                  } catch (Exception var18) {
                     LogUtils.a(f, "Exception: ", var18);
                     return;
                  }
               }
            }

            String var24;
            if (var1 >= 16) {
               try {
                  var24 = this.getString(2131755439);
               } catch (Exception var17) {
                  LogUtils.a(f, "Exception: ", var17);
                  return;
               }
            } else {
               try {
                  Items.ItemType var32 = Items.ItemType.invite;
                  OnClickListener var25 = new OnClickListener(this) {
                     final JiboDetailsFragment a;

                     {
                        this.a = var1;
                     }

                     public void onClick(View var1) {
                        SingleFragmentActivity.Builder var2x = new SingleFragmentActivity.Builder(this.a, NameBirthdayGenderFragment.class.getName());
                        var2x.a(Loop.class.getSimpleName(), this.a.k);
                        var2x.a(1005);
                     }
                  };
                  Items.SimpleItem var35 = new Items.SimpleItem(var32, var25);
                  var5.add(var35);
                  var24 = String.format(this.getString(2131755438), String.valueOf(16 - var1));
               } catch (Exception var16) {
                  LogUtils.a(f, "Exception: ", var16);
                  return;
               }
            }

            try {
               SpannableStringBuilder var36 = new SpannableStringBuilder(var24);
               Context var38 = this.getActivity().getApplicationContext();
               OnClickListener var37 = new OnClickListener(this) {
                  final JiboDetailsFragment a;

                  {
                     this.a = var1;
                  }

                  public void onClick(View var1) {
                     this.a.x();
                  }
               };
               JiboDetailsFragment.WhyTextClickableSpan var33 = new JiboDetailsFragment.WhyTextClickableSpan(var38, var37);
               var36.setSpan(var33, var24.length() - 4, var24.length(), 18);
            } catch (Exception var15) {
               LogUtils.a(f, "Exception: ", var15);
               return;
            }
         } else {
            try {
               if (var4.isEnrolled()) {
               }
            } catch (Exception var20) {
               LogUtils.a(f, "Exception: ", var20);
               return;
            }
         }

         try {
            if (this.a) {
               this.b();
            }
         } catch (Exception var14) {
            LogUtils.a(f, "Exception: ", var14);
            return;
         }

         try {
            if (!this.d()) {
               return;
            }

            var30 = var29.iterator();
         } catch (Exception var12) {
            LogUtils.a(f, "Exception: ", var12);
            return;
         }

         while (true) {
            try {
               if (!var30.hasNext()) {
                  break;
               }

               CharSequence var34 = (CharSequence)var30.next();
               Items.FooterItem var26 = new Items.FooterItem(var34);
               var5.add(var26);
            } catch (Exception var13) {
               LogUtils.a(f, "Exception: ", var13);
               return;
            }
         }

         try {
            this.c.clear();
            this.a((Collection<Items.Item>)this.c);
            List var27 = this.c;
            Items.SubheaderItem var31 = new Items.SubheaderItem(2131755352);
            var27.add(var31);
            this.c.addAll(var5);
            this.l.notifyDataSetChanged();
            this.s();
            this.z();
         } catch (Exception var11) {
            LogUtils.a(f, "Exception: ", var11);
         }
      }
   }

   private void x() {
      DialogUtils.d(this, 110, this.getString(2131755277), this.getString(2131755276));
   }

   private long y() {
      return 0L;
   }

   private void z() {
      if (this.d != null) {
         this.d.cancel(true);
      }

      this.d = new JiboDetailsFragment.LoadAttributionsAsyncTask(this);
      this.d.execute(new Long[]{this.y()});
   }

   @Override
   public Loader<Cursor> a(int var1, Bundle var2) {
      CursorLoader var5;
      switch (var1) {
         case 2131296704:
            StringBuilder var3 = new StringBuilder("_id").append(" IN (");
            Loop var4 = this.k;
            String var6;
            if (this.k.getRobot() != null) {
               var6 = this.k.getRobot();
            } else {
               var6 = "";
            }

            List var7 = LoopHelper.getAccountIds(var4, null, var6);
            if (var7.size() > 0) {
               var3.append("'").append(TextUtils.join("','", var7)).append("')");
            } else {
               var3.append("'')");
            }

            var5 = new CursorLoader(this.getActivity(), DatabaseContract.EntityEntry.a(2), DatabaseContract.EntityEntry.a, var3.toString(), null, "_id");
            break;
         case 2131296709:
            var5 = new CursorLoader(this.getActivity(), DatabaseContract.EntityEntry.a(8), DatabaseContract.EntityEntry.a, null, null, "_id");
            break;
         default:
            var5 = null;
      }

      return var5;
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 120 && var2 == -1 && var3 != null) {
         SingleFragmentActivity.Builder var4 = new SingleFragmentActivity.Builder(this, NameBirthdayGenderFragment.class.getName());
         var4.a("ARG_IS_CHILD", true);
         var4.a(Loop.class.getSimpleName(), this.k);
         var4.a(Member.class.getSimpleName(), (Parcelable)var3);
         var4.a(1005);
      } else if (var1 == 116) {
         this.a(this.k.getId(), this.p.getId(), this.p.getAccount().getFirstName());
      } else if (var1 == 124) {
         DataItems.DataItem var5 = SkillsJsonParser.getInstance().getViews(null).get(0);
         if (!(var5 instanceof DataItems.GroupDataItem)
            || ((DataItems.GroupDataItem)var5).getChildViews() != null && !((DataItems.GroupDataItem)var5).getChildViews().isEmpty()) {
            SkillsJsonParser.getInstance().selectSkill(0);
            new SingleFragmentActivity.Builder(this.getContext(), SkillSettingsFragment.class.getName())
               .a("PARAM_PATH", new int[]{0})
               .a("PARAM_TITLE", var5.getTitle())
               .a(1001);
         }
      }
   }

   @Override
   public void a(Loader<Cursor> var1) {
   }

   public void a(Loader<Cursor> var1, Cursor var2) {
      if (var1.n() == 2131296709 && this.d()) {
         this.k = SharedPreferencesUtil.f(this.getActivity());
         if (this.d() && ((BaseActivity)this.getActivity()).getSupportActionBar() != null) {
            ((BaseActivity)this.getActivity()).getSupportActionBar().setTitle(this.o());
         }

         if (this.k != null) {
            if (this.getLoaderManager().b(2131296704) != null) {
               this.getLoaderManager().b(2131296704, null, this);
            } else {
               this.getLoaderManager().a(2131296704, null, this);
            }

            if (this.k.isSuspended()) {
               this.b(LoopHelper.isOwner(this.k, EntityData.a(this.getContext()).i().getId()));
            } else {
               this.v();
               this.l.a(this.k);
               this.w();
               this.A();
               if (!this.r() && this.getFragmentManager().a(HolidaysPopupFragment.class.getSimpleName()) == null) {
                  ArrayList var3 = new ArrayList();
                  Collections.addAll(var3, SharedPreferencesUtil.o(this.getActivity()));
                  if (var3.indexOf(this.k.getId()) > -1) {
                     this.c().postDelayed(new Runnable(this) {
                        final JiboDetailsFragment a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           HolidaysPopupFragment.a(this.a.getFragmentManager(), this.a.k);
                        }
                     }, 500L);
                  }
               }
            }
         }
      }
   }

   @Override
   public void a(Loop var1) {
      WifiActivity.a(this.getActivity(), this.k);
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      this.a = var1.getBoolean("ARGS_IS_IN_TUTORIAL_MODE");
   }

   @Override
   public void n_() {
      if (this.k == null) {
         SyncHelper.b(this.getActivity());
      } else {
         SyncHelper.a(this.getActivity(), this.k.getId());
      }

      this.getView().postDelayed(new Runnable(this) {
         final JiboDetailsFragment a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.d()) {
               this.a.swipeRefreshLayout.setRefreshing(false);
            }
         }
      }, 1500L);
   }

   @Override
   public String o() {
      String var1;
      if (this.k != null) {
         var1 = this.k.getName();
      } else {
         var1 = "";
      }

      return var1;
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         if (var1 == 1007 || var1 == 1005) {
            this.n_();
            if (var1 == 1005 && var3 != null && var3.getExtras() != null && var3.getExtras().containsKey(Member.class.getSimpleName())) {
               this.m = (Member)var3.getExtras().getParcelable(Member.class.getSimpleName());
            }
         } else if (var1 == 1015) {
            this.getActivity().getContentResolver().notifyChange(DatabaseContract.EntityEntry.a(8), null);
         }
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
      if (var1 != null) {
         this.a = var1.getBoolean("ARGS_IS_IN_TUTORIAL_MODE");
      } else if (this.getArguments() != null) {
         this.a = this.getArguments().getBoolean("ARGS_IS_IN_TUTORIAL_MODE");
      }
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      var2.inflate(2131492879, var1);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427447, var2, false);
   }

   @OnClick
   public void onCustomerCareClick(View var1) {
      this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755751))));
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (var1.getItemId() == 2131296306) {
         this.q();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPause() {
      super.onPause();
      LocalBroadcastManager.a(this.getActivity()).a(this.u);
   }

   @Override
   public void onResume() {
      super.onResume();
      IntentFilter var1 = new IntentFilter();
      var1.addAction("LOOP_HOLIDAYS_ALARM_ACTION");
      LocalBroadcastManager.a(this.getActivity()).a(this.u, var1);
      if (this.m != null) {
         DialogUtils.b(
            this,
            103,
            this.getString(2131755272, this.m.getAccount().getFirstName()),
            this.getString(2131755262, this.m.getAccount().getFirstName(), this.m.getAccount().getFirstName()),
            this.getString(2131755571)
         );
         this.m = null;
      } else {
         this.r();
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.k = SharedPreferencesUtil.f(this.getActivity());
      Account var4 = EntityData.a(this.getActivity()).i();
      if (var4 != null) {
         JiboNotificationAsyncClient var3 = new JiboNotificationAsyncClient(new BasicAWSCredentials(var4.getAccessKeyId(), var4.getSecretAccessKey()));
         this.n = var3;
         this.a(var3);
         JiboSkillsAsyncClient var5 = new JiboSkillsAsyncClient(new BasicAWSCredentials(var4.getAccessKeyId(), var4.getSecretAccessKey()));
         this.o = var5;
         this.a(var5);
      }

      this.l = new LoopMembersListAdapter(this.c, this.k, var4);
      this.l.a(this.r);
      this.list.setHasFixedSize(true);
      this.list.setItemAnimator(new DefaultItemAnimator());
      this.list.setLayoutManager(new LinearLayoutManager(this.getActivity(), 1, false));
      this.list.addItemDecoration(new LoopMembersListAdapter.SpacesItemDecoration(this.getActivity(), -1, 2131165263, 2131165366));
      this.list.setAdapter(this.l);
      this.swipeRefreshLayout.setOnRefreshListener(this);
      this.swipeRefreshLayout.setColorSchemeResources(2131099771, 2131099672, 2131099672, 2131099672);
      this.getLoaderManager().a(2131296709, null, this);
      if (this.getArguments() != null && this.getArguments().getBundle("ARG_EXTRAS") != null) {
         Bundle var6 = this.getArguments().getBundle("ARG_EXTRAS");
         if (var6.getString("ARG_MESSAGE") != null) {
            this.c().postDelayed(new Runnable(this, var6) {
               final Bundle a;
               final JiboDetailsFragment b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  DialogUtils.d(this.b, 103, this.a.getString("ARG_TITLE"), this.a.getString("ARG_MESSAGE"));
                  this.a.remove("ARG_MESSAGE");
                  this.a.remove("ARG_TITLE");
               }
            }, 200L);
         }
      }

      if (var4 != null && LoopHelper.isOwner(this.k, var4.getId())) {
         this.s = EntityData.a(this.getActivity()).g();
      }

      if (this.getArguments().containsKey("ARG_EXTRAS")) {
         Bundle var7 = this.getArguments().getBundle("ARG_EXTRAS");
         if (var7 != null && var7.containsKey("ARG_SETTINGS") && LoopHelper.isOwner(this.k, var4.getId())) {
            var1.postDelayed(
               new Runnable(this) {
                  final JiboDetailsFragment a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     new SingleFragmentActivity.Builder(this.a.getActivity(), RobotSettingsFragment.class.getName())
                        .a(Loop.class.getSimpleName(), this.a.k)
                        .a(1003);
                  }
               },
               750L
            );
         }
      }
   }

   @OnClick
   public void reconnectToJiboClick() {
      if (!this.u()) {
         this.f();
         LoopPassphraseUtils.a(this.k.getId(), this, this.x);
      } else {
         WifiActivity.a(this.getActivity(), this.k);
      }
   }

   private class LoadAttributionsAsyncTask extends AsyncTask<Long, Void, AttributionListResponse> {
      final JiboDetailsFragment a;
      private long b;

      private LoadAttributionsAsyncTask(JiboDetailsFragment var1) {
         this.a = var1;
         this.b = 0L;
      }

      protected AttributionListResponse a(Long... var1) {
         this.b = var1[0];
         JiboGQAAsyncClient var2 = EntityData.a(this.a.getContext()).c();
         Object var4 = null;

         try {
            var5 = var2.listAttributions(this.a.k.getRobotFriendlyId(), this.b);
         } catch (Exception var3) {
            Crashlytics.a(var3);
            return (AttributionListResponse)var4;
         }

         return var5;
      }

      protected void a(AttributionListResponse var1) {
         super.onPostExecute(var1);
         if (!this.isCancelled() && this.a.d()) {
            if (this.a.e != null) {
               this.a.e.clear();
            }

            if (var1 != null) {
               if (this.b == 0L) {
                  this.a.e = var1.getData();
               } else {
                  this.a.e.addAll(var1.getData());
               }
            }

            List var2 = this.a.a(this.a.e);
            if (this.a.l != null && !var2.isEmpty()) {
               this.a.c.add(new Items.SubheaderItem(2131755839));
               this.a.c.addAll(var2);
               this.a.l.notifyDataSetChanged();
            }
         }
      }

      protected void onPreExecute() {
         super.onPreExecute();
      }
   }

   private static class WhyTextClickableSpan extends ClickableSpan {
      Context a;
      private OnClickListener b;

      public WhyTextClickableSpan(Context var1, OnClickListener var2) {
         this.a = var1;
         this.b = var2;
      }

      public void onClick(View var1) {
         if (this.b != null) {
            this.b.onClick(var1);
         }
      }

      public void updateDrawState(TextPaint var1) {
         var1.setColor(ImageUtils.b(this.a, 2131099771));
         var1.setFakeBoldText(true);
         var1.setTextSize(this.a.getResources().getDimension(2131165495));
      }
   }
}
