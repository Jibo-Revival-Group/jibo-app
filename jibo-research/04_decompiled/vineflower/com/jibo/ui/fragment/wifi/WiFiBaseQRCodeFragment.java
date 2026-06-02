package com.jibo.ui.fragment.wifi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.oobe.JiboOobeAsyncClient;
import com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.oobe.model.PrepareRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.StatusContainer;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.LoopHolidaysAlarmReceiver;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class WiFiBaseQRCodeFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(WiFiBaseQRCodeFragment.class);
   protected JiboLoopAsyncClient b;
   protected JiboOobeAsyncClient c;
   protected int l = 0;
   protected List<String> m = new ArrayList<>();
   protected TokenContainer n;
   protected CircleProgressFragment o;
   private String p;
   private final Runnable q = new Runnable(this) {
      final WiFiBaseQRCodeFragment a;

      {
         this.a = var1;
      }

      @Override
      public void run() {
         if (this.a.d() && this.a.b != null) {
            LogUtils.a(WiFiBaseQRCodeFragment.a, "checkForNewRobotRunnable");
            if (this.a.n == null) {
               this.a.c().postDelayed(this.a.q, 4000L);
            } else {
               this.a.c.getStatus(this.a.n.getToken(), new AsyncHandler<GetStatusRequest, StatusContainer>(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  public void a(GetStatusRequest var1, StatusContainer var2) {
                     boolean var3;
                     label49: {
                        var3 = true;
                        LogUtils.a(WiFiBaseQRCodeFragment.a, var2.toString());
                        if (var2.getComplete()) {
                           if (this.a.a.k != null) {
                              LogUtils.a(WiFiBaseQRCodeFragment.a, "Robot is online, closing wifi setup");
                              FragmentActivity var10 = this.a.a.getActivity();
                              if (!TextUtils.isEmpty(EntityData.a(this.a.a.getActivity()).i().getPhotoUrl())) {
                                 var3 = true;
                              } else {
                                 var3 = false;
                              }

                              JiboAnalytics.b(var10, var3);
                              JiboAnalytics.f(this.a.a.getActivity());
                              this.a.a.a(new Runnable(this) {
                                 final <unrepresentable> a;

                                 {
                                    this.a = var1;
                                 }

                                 @Override
                                 public void run() {
                                    if (this.a.a.a.d()) {
                                       this.a.a.a.g();
                                       ((BaseActivity)this.a.a.a.getActivity()).a(WiFiSuccessFragment.class, null);
                                    }
                                 }
                              });
                              return;
                           }

                           List var7 = this.a.a.b.listLoops();
                           Collections.sort(var7, new Comparator<Loop>(this) {
                              final <unrepresentable> a;

                              {
                                 this.a = var1;
                              }

                              public int a(Loop var1, Loop var2x) {
                                 return var2x.getUpdated().compareTo(var1.getUpdated());
                              }
                           });
                           if (var7 != null && !var7.isEmpty()) {
                              var8 = (Loop)var7.get(0);
                              break label49;
                           }
                        }

                        var8 = null;
                     }

                     if (var8 == null || !DateTimeUtils.isLessThanFiveMinutes(var8.getUpdated(), System.currentTimeMillis())) {
                        this.a.a.c().postDelayed(this.a.a.q, 2000L);
                     } else if (DateTimeUtils.isLessThanFiveMinutes(var8.getCreated(), var8.getUpdated())) {
                        try {
                           JiboLoopAsyncClient var5 = this.a.a.b;
                           String var11 = var8.getId();
                           StringBuilder var4 = new StringBuilder();
                           var5.updateLoop(var11, var4.append(EntityData.a(this.a.a.getActivity()).i().getFirstName()).append("'s").append(" Jibo").toString());
                           StringBuilder var12 = new StringBuilder();
                           var8.setName(var12.append(EntityData.a(this.a.a.getActivity()).i().getFirstName()).append("'s").append(" Jibo").toString());
                           LoopHolidaysAlarmReceiver.a(this.a.a.getActivity(), var8);
                        } catch (Exception var6) {
                           this.a.a.a(var6, "update loop", false);
                           LogUtils.a(WiFiBaseQRCodeFragment.a, "update loop", var6);
                        }

                        if (this.a.a.d()) {
                           EntityData.a(this.a.a.getActivity()).a(var8, true);
                           EntityData.a(this.a.a.getActivity()).a(var8);
                           SharedPreferencesUtil.a(this.a.a.getActivity(), var8.getId(), false);
                        }

                        LogUtils.a(WiFiBaseQRCodeFragment.a, "Robot found, showing Success screen");
                        this.a.a.a(new Runnable(this, var8) {
                           final Loop a;
                           final <unrepresentable> b;

                           {
                              this.b = var1;
                              this.a = var2x;
                           }

                           @Override
                           public void run() {
                              if (this.b.a.a.d()) {
                                 this.b.a.a.g();
                                 Bundle var1 = new Bundle();
                                 var1.putParcelable(Loop.class.getSimpleName(), this.a);
                                 ((BaseActivity)this.b.a.a.getActivity()).a(WiFiSuccessFragment.class, var1);
                              }
                           }
                        });
                     } else {
                        LogUtils.a(WiFiBaseQRCodeFragment.a, "Robot is online, closing wifi setup");
                        FragmentActivity var9 = this.a.a.getActivity();
                        if (TextUtils.isEmpty(EntityData.a(this.a.a.getActivity()).i().getPhotoUrl())) {
                           var3 = false;
                        }

                        JiboAnalytics.b(var9, var3);
                        this.a.a.a(new Runnable(this) {
                           final <unrepresentable> a;

                           {
                              this.a = var1;
                           }

                           @Override
                           public void run() {
                              if (this.a.a.a.d()) {
                                 this.a.a.a.g();
                                 ((BaseActivity)this.a.a.a.getActivity()).a(WiFiSuccessFragment.class, null);
                              }
                           }
                        });
                     }
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.a.a.a(var1, "get status", false);
                  }
               });
            }
         }
      }
   };
   private Runnable r = new Runnable(this) {
      final WiFiBaseQRCodeFragment a;
      private final long b;

      {
         this.a = var1;
         this.b = 10000L;
      }

      @Override
      public void run() {
         Object var2 = null;
         if (this.a.d()) {
            this.a.c().removeCallbacks(this);
            if (this.a.n != null && this.a.n.getExpires() - 30000L > Calendar.getInstance().getTimeInMillis()) {
               LogUtils.a("TOKEN", "TOKEN IS ALIVE");
               if (this.a.p == null || !this.a.p.equals(this.a.u())) {
                  this.a.v();
               }

               this.a.s();
               if (this.a.o != null) {
                  this.a.o.a();
                  this.a.o = null;
               }

               this.a.c().postDelayed(this, 10000L);
            } else {
               LogUtils.a("TOKEN", "TOKEN EXPIRED");
               if (this.a.o == null) {
                  this.a.o = new CircleProgressFragment();
                  this.a.o.c("");
                  this.a.o.show(this.a.getActivity().getSupportFragmentManager(), "CircleFragment");
               }

               String var1 = (String)var2;
               if (this.a.k != null) {
                  var1 = (String)var2;
                  if (this.a.k.getId() != null) {
                     var1 = this.a.k.getId();
                  }
               }

               this.a.c.prepareRobot(var1, new AsyncHandler<PrepareRobotRequest, TokenContainer>(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  public void a(PrepareRobotRequest var1, TokenContainer var2x) {
                     if (this.a.a.d()) {
                        this.a.a.n = var2x;
                        LogUtils.a("TOKEN", "NEW TOKEN:" + this.a.a.n.toString());
                        this.a.a.c().postDelayed(this.a.a.r, 10000L);
                        this.a.a.a(new Runnable(this) {
                           final <unrepresentable> a;

                           {
                              this.a = var1;
                           }

                           @Override
                           public void run() {
                              this.a.a.a.v();
                              this.a.a.a.s();
                              this.a.a.a.c().postDelayed(new Runnable(this) {
                                 final <unrepresentable> a;

                                 {
                                    this.a = var1;
                                 }

                                 @Override
                                 public void run() {
                                    if (this.a.a.a.a.d() && this.a.a.a.a.o != null) {
                                       this.a.a.a.a.o.a();
                                       this.a.a.a.a.o = null;
                                    }
                                 }
                              }, 500L);
                           }
                        });
                     }
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.a.a.o.b("");
                     this.a.a.o = null;
                     this.a.a.a(var1, "prepareRobot", false);
                     if (!ErrorHelper.b((AmazonServiceException)var1) && !ErrorHelper.a((AmazonServiceException)var1)) {
                        this.a.a.a(new Runnable(this) {
                           final <unrepresentable> a;

                           {
                              this.a = var1;
                           }

                           @Override
                           public void run() {
                              ((BaseActivity)this.a.a.a.getActivity()).c(WiFiHelpFragment.class, null);
                           }
                        });
                     }
                  }
               });
            }
         }
      }
   };

   private String a(String var1, String var2) {
      StringBuilder var4 = new StringBuilder();

      for (int var3 = 0; var3 < var1.length(); var3++) {
         var4.append(String.valueOf((char)(var2.charAt(var3 % var2.length()) ^ var1.charAt(var3))));
      }

      return var4.toString();
   }

   private void t() {
      this.b = EntityData.a(this.getActivity()).b();
      if (this.c == null || this.c.isTerminated()) {
         this.c = new JiboOobeAsyncClient(
            new BasicAWSCredentials(EntityData.a(this.getActivity()).i().getAccessKeyId(), EntityData.a(this.getActivity()).i().getSecretAccessKey())
         );
      }
   }

   private String u() {
      StringBuilder var1 = new StringBuilder();
      var1.append(e.getString("ARG_SSID", "")).append("\n").append(e.getString("ARG_PASSWORD", "")).append("\n");
      if (!e.getString("ARG_IPADDRESS", "").isEmpty()
         || !e.getString("ARG_SUBNETMASK", "").isEmpty()
         || !e.getString("ARG_ROUTER", "").isEmpty()
         || !e.getString("ARG_DNS1", "").isEmpty()
         || !e.getString("ARG_DNS2", "").isEmpty()) {
         var1.append(e.getString("ARG_IPADDRESS", ""))
            .append("\n")
            .append(e.getString("ARG_SUBNETMASK", ""))
            .append("\n")
            .append(e.getString("ARG_ROUTER", ""))
            .append("\n")
            .append(e.getString("ARG_DNS1", ""))
            .append("\n")
            .append(e.getString("ARG_DNS2", ""))
            .append("\n");
      }

      var1.append(this.n.getToken());
      return var1.toString();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void v() {
      try {
         if (!this.d()) {
            return;
         }
      } catch (Exception var15) {
         LogUtils.a(a, "generateQRCodes", var15);
         return;
      }

      int var4;
      int var5;
      String var6;
      StringBuilder var18;
      try {
         this.p = this.u();
         var6 = this.a(this.p, "Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs.");
         String var7 = a;
         StringBuilder var8 = new StringBuilder();
         LogUtils.a(var7, var8.append("codeContent: ").append(var6).toString());
         var4 = (int)Math.ceil(var6.length() / 50.0F);
         var5 = (int)Math.floor((float)var6.length() / var4);
         var18 = new StringBuilder();
         this.m.clear();
      } catch (Exception var14) {
         LogUtils.a(a, "generateQRCodes", var14);
         return;
      }

      int var1 = 1;
      int var2 = 0;

      while (true) {
         if (var1 > var4) {
            for (int var16 = 0; var16 < var4; var16++) {
               try {
                  String var19 = a;
                  StringBuilder var17 = new StringBuilder();
                  LogUtils.a(var19, var17.append("code #").append(var16).append(": ").append(this.m.get(var16)).toString());
               } catch (Exception var9) {
                  LogUtils.a(a, "generateQRCodes", var9);
                  return;
               }
            }

            return;
         }

         int var3;
         label58: {
            label57: {
               try {
                  var18.delete(0, var18.length());
                  var18.append(var1).append("/").append(var4).append("\n");
                  if (var2 + var5 >= var6.length()) {
                     break label57;
                  }
               } catch (Exception var13) {
                  LogUtils.a(a, "generateQRCodes", var13);
                  break;
               }

               if (var1 != var4) {
                  var3 = var2 + var5;
                  break label58;
               }
            }

            try {
               var3 = var6.length();
            } catch (Exception var12) {
               LogUtils.a(a, "generateQRCodes", var12);
               break;
            }
         }

         try {
            var18.append(var6.substring(var2, var3));
         } catch (Exception var11) {
            LogUtils.a(a, "generateQRCodes", var11);
            break;
         }

         var2 += var5;

         try {
            this.m.add(var18.toString());
         } catch (Exception var10) {
            LogUtils.a(a, "generateQRCodes", var10);
            break;
         }

         var1++;
      }
   }

   protected void a() {
      this.c().post(this.r);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.k();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      TokenContainer var3;
      if (var1.containsKey(TokenContainer.class.getSimpleName())) {
         var3 = (TokenContainer)var1.getSerializable(TokenContainer.class.getSimpleName());
      } else {
         var3 = this.n;
      }

      this.n = var3;
      int var2;
      if (var1.containsKey("ARG_QR_CODE_IND")) {
         var2 = var1.getInt("ARG_QR_CODE_IND", 0);
      } else {
         var2 = this.l;
      }

      this.l = var2;
      List var5;
      if (var1.containsKey("ARG_QR_CODES")) {
         var5 = var1.getStringArrayList("ARG_QR_CODES");
      } else {
         var5 = this.m;
      }

      this.m = var5;
      String var4;
      if (var1.containsKey("ARG_QR_CODE_CONTENT")) {
         var4 = var1.getString("ARG_QR_CODE_CONTENT");
      } else {
         var4 = this.p;
      }

      this.p = var4;
   }

   @Override
   public boolean h() {
      this.getActivity().getSupportFragmentManager().a(WaitForTapFragment.class.getSimpleName(), 1);
      return true;
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      if (this.c != null) {
         this.c.shutdown();
         this.c = null;
      }
   }

   @Override
   public void onPause() {
      super.onPause();
      this.r();
      this.g();
      if (this.o != null) {
         this.o.a();
         this.o = null;
      }
   }

   @Override
   public void onResume() {
      super.onResume();
      this.t();
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putSerializable(TokenContainer.class.getSimpleName(), this.n);
      var1.putInt("ARG_QR_CODE_IND", this.l);
      var1.putStringArrayList("ARG_QR_CODES", (ArrayList)this.m);
      var1.putString("ARG_QR_CODE_CONTENT", this.p);
   }

   protected void q() {
      this.c().postDelayed(this.q, 4000L);
   }

   protected void r() {
      this.c().removeCallbacks(this.r);
      this.c().removeCallbacks(this.q);
   }

   protected abstract void s();
}
