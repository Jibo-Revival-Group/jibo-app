package com.salesforce.androidsdk.push;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.rest.ApiVersionStrings;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;

public class PushService extends IntentService {
   private static WakeLock a;
   private Context b = SalesforceSDKManager.a().k();

   public PushService() {
      super("PushService");
   }

   private void a(long var1, UserAccount var3) {
      Calendar var4 = Calendar.getInstance();
      var4.add(14, (int)var1);
      Intent var5 = new Intent(this.b, PushService.SFDCRegistrationRetryAlarmReceiver.class);
      if (var3 == null) {
         Bundle var6 = new Bundle();
         var6.putString("account_bundle", "all_accounts");
         var5.putExtra("account_bundle", var6);
      } else {
         var5.putExtra("account_bundle", var3.w());
      }

      PendingIntent var7 = PendingIntent.getBroadcast(this.b, 1, var5, 1073741824);
      ((AlarmManager)this.b.getSystemService("alarm")).set(0, var4.getTimeInMillis(), var7);
   }

   static void a(Intent var0) {
      Context var1 = SalesforceSDKManager.a().k();
      if (a == null) {
         a = ((PowerManager)var1.getSystemService("power")).newWakeLock(1, "PushService");
      }

      a.acquire();
      var0.setClassName(var1, PushService.class.getName());
      if (var1.startService(var0) == null) {
         SalesforceSDKLogger.b("PushService", "Could not start GCM service");
      }
   }

   private void a(UserAccount var1) {
      try {
         this.c(PushMessaging.g(this.b, var1), var1);
      } catch (Exception var5) {
         SalesforceSDKLogger.a("PushService", "Error occurred during SFDC unregistration", var5);
      } finally {
         PushMessaging.h(this.b, var1);
         this.b.sendBroadcast(new Intent("com.salesfore.mobilesdk.c2dm.UNREGISTERED").setPackage(this.b.getPackageName()));
         this.b.sendBroadcast(new Intent("com.salesfore.mobilesdk.c2dm.ACTUAL_UNREGISTERED").setPackage(this.b.getPackageName()));
      }
   }

   private void a(String param1, UserAccount param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 2
      // 01: ifnonnull 0c
      // 04: ldc "PushService"
      // 06: ldc "Account is null, will retry registration later"
      // 08: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.a (Ljava/lang/String;Ljava/lang/String;)V
      // 0b: return
      // 0c: ldc2_w 30000
      // 0f: lstore 7
      // 11: lload 7
      // 13: lstore 3
      // 14: lload 7
      // 16: lstore 5
      // 18: aload 0
      // 19: aload 1
      // 1a: aload 2
      // 1b: invokespecial com/salesforce/androidsdk/push/PushService.b (Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)Ljava/lang/String;
      // 1e: astore 9
      // 20: aload 9
      // 22: ifnull 46
      // 25: ldc2_w 518400000
      // 28: lstore 7
      // 2a: lload 7
      // 2c: lstore 3
      // 2d: lload 7
      // 2f: lstore 5
      // 31: aload 0
      // 32: getfield com/salesforce/androidsdk/push/PushService.b Landroid/content/Context;
      // 35: aload 1
      // 36: aload 9
      // 38: aload 2
      // 39: invokestatic com/salesforce/androidsdk/push/PushMessaging.a (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
      // 3c: aload 0
      // 3d: lload 7
      // 3f: aconst_null
      // 40: invokespecial com/salesforce/androidsdk/push/PushService.a (JLcom/salesforce/androidsdk/accounts/UserAccount;)V
      // 43: goto 0b
      // 46: lload 7
      // 48: lstore 3
      // 49: lload 7
      // 4b: lstore 5
      // 4d: aload 0
      // 4e: getfield com/salesforce/androidsdk/push/PushService.b Landroid/content/Context;
      // 51: aload 1
      // 52: aload 2
      // 53: invokestatic com/salesforce/androidsdk/push/PushMessaging.a (Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
      // 56: goto 3c
      // 59: astore 1
      // 5a: ldc "PushService"
      // 5c: ldc "Error occurred during SFDC registration"
      // 5e: aload 1
      // 5f: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 62: aload 0
      // 63: lload 3
      // 64: aconst_null
      // 65: invokespecial com/salesforce/androidsdk/push/PushService.a (JLcom/salesforce/androidsdk/accounts/UserAccount;)V
      // 68: goto 0b
      // 6b: astore 1
      // 6c: lload 5
      // 6e: lstore 3
      // 6f: aload 0
      // 70: lload 3
      // 71: aconst_null
      // 72: invokespecial com/salesforce/androidsdk/push/PushService.a (JLcom/salesforce/androidsdk/accounts/UserAccount;)V
      // 75: aload 1
      // 76: athrow
      // 77: astore 1
      // 78: goto 6f
      // try (12 -> 17): 46 java/lang/Exception
      // try (12 -> 17): 56 null
      // try (25 -> 31): 46 java/lang/Exception
      // try (25 -> 31): 56 null
      // try (40 -> 45): 46 java/lang/Exception
      // try (40 -> 45): 56 null
      // try (47 -> 51): 65 null
   }

   private void a(boolean var1, UserAccount var2) {
      if (var1) {
         String var3 = PushMessaging.e(this.b, var2);
         if (var3 != null) {
            this.a(var3, var2);
         }
      } else {
         this.a(var2);
      }
   }

   private RestClient b(UserAccount var1) {
      ClientManager var2 = SalesforceSDKManager.a().E();
      if (var2 != null) {
         try {
            ClientManager.AccMgrAuthTokenProvider var3 = new ClientManager.AccMgrAuthTokenProvider(var2, var1.e(), var1.a(), var1.b());
            String var10 = var1.j();
            URI var6 = new URI(var1.e());
            URI var7 = new URI(var1.c());
            URI var5 = new URI(var1.d());
            RestClient.ClientInfo var4 = new RestClient.ClientInfo(
               var10,
               var6,
               var7,
               var5,
               var1.i(),
               var1.h(),
               var1.g(),
               var1.f(),
               var1.k(),
               var1.l(),
               var1.m(),
               var1.o(),
               var1.n(),
               var1.p(),
               var1.q(),
               var1.r(),
               var1.s()
            );
            var11 = new RestClient(var4, var1.a(), HttpAccess.a, var3);
         } catch (Exception var8) {
            SalesforceSDKLogger.a("PushService", "Failed to get rest client", var8);
            return null;
         }

         return var11;
      } else {
         return null;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private String b(String var1, UserAccount var2) {
      Object var3 = null;
      HashMap var4 = new HashMap();
      var4.put("ConnectionToken", var1);
      var4.put("ServiceType", "androidGcm");

      try {
         var12 = this.b(var2);
         var14 = RestRequest.a(ApiVersionStrings.a(this.b), "MobilePushServiceDevice", var4);
      } catch (Exception var9) {
         SalesforceSDKLogger.a("PushService", "Push notification registration failed", var9);
         return (String)var3;
      }

      var1 = (String)var3;
      if (var12 != null) {
         label44: {
            label43: {
               label42: {
                  label41: {
                     try {
                        var13 = var12.b(var14);
                        if (var13.a() == 201) {
                           var11 = var13.f();
                           break label41;
                        }
                     } catch (Exception var8) {
                        SalesforceSDKLogger.a("PushService", "Push notification registration failed", var8);
                        var1 = (String)var3;
                        return var1;
                     }

                     try {
                        if (var13.a() == 404) {
                           break label43;
                        }
                        break label42;
                     } catch (Exception var7) {
                        SalesforceSDKLogger.a("PushService", "Push notification registration failed", var7);
                        var1 = (String)var3;
                        return var1;
                     }
                  }

                  if (var11 != null) {
                     try {
                        var1 = var11.getString("id");
                        break label44;
                     } catch (Exception var6) {
                        SalesforceSDKLogger.a("PushService", "Push notification registration failed", var6);
                        var1 = (String)var3;
                        return var1;
                     }
                  }
               }

               var1 = null;
               break label44;
            }

            var1 = "not_enabled";
         }

         try {
            var13.c();
            SalesforceSDKManager.a().e("PN");
         } catch (Exception var5) {
            SalesforceSDKLogger.a("PushService", "Push notification registration failed", var5);
            var1 = (String)var3;
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean c(String var1, UserAccount var2) {
      RestRequest var7 = RestRequest.a(ApiVersionStrings.a(this.b), "MobilePushServiceDevice", var1);

      try {
         var9 = this.b(var2);
      } catch (IOException var6) {
         SalesforceSDKLogger.a("PushService", "Push notification unregistration failed", var6);
         return false;
      }

      if (var9 != null) {
         try {
            var8 = var9.b(var7);
            if (var8.a() == 204) {
               return true;
            }
         } catch (IOException var5) {
            SalesforceSDKLogger.a("PushService", "Push notification unregistration failed", var5);
            return false;
         }

         try {
            var8.c();
         } catch (IOException var4) {
            SalesforceSDKLogger.a("PushService", "Push notification unregistration failed", var4);
         }
      }

      return false;
   }

   protected void onHandleIntent(Intent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ldc "account_bundle"
      // 03: invokevirtual android/content/Intent.getBundleExtra (Ljava/lang/String;)Landroid/os/Bundle;
      // 06: astore 8
      // 08: aconst_null
      // 09: astore 7
      // 0b: bipush 0
      // 0c: istore 3
      // 0d: iload 3
      // 0e: istore 2
      // 0f: aload 7
      // 11: astore 6
      // 13: aload 8
      // 15: ifnull 2d
      // 18: ldc "all_accounts"
      // 1a: aload 8
      // 1c: ldc "account_bundle"
      // 1e: invokevirtual android/os/Bundle.getString (Ljava/lang/String;)Ljava/lang/String;
      // 21: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 24: ifeq a2
      // 27: bipush 1
      // 28: istore 2
      // 29: aload 7
      // 2b: astore 6
      // 2d: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 30: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.o ()Lcom/salesforce/androidsdk/accounts/UserAccountManager;
      // 33: astore 7
      // 35: aload 7
      // 37: invokevirtual com/salesforce/androidsdk/accounts/UserAccountManager.d ()Ljava/util/List;
      // 3a: astore 8
      // 3c: ldc_w "com.salesforce.mobilesdk.c2dm.intent.RETRY"
      // 3f: aload 1
      // 40: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 43: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 46: istore 5
      // 48: ldc_w "com.salesforce.mobilesdk.c2dm.intent.UNREGISTER"
      // 4b: aload 1
      // 4c: invokevirtual android/content/Intent.getAction ()Ljava/lang/String;
      // 4f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 52: istore 4
      // 54: iload 5
      // 56: ifne 5e
      // 59: iload 4
      // 5b: ifeq c7
      // 5e: iload 2
      // 5f: ifeq b2
      // 62: aload 8
      // 64: ifnull c7
      // 67: aload 8
      // 69: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 6e: astore 1
      // 6f: aload 1
      // 70: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 75: ifeq c7
      // 78: aload 0
      // 79: iload 5
      // 7b: aload 1
      // 7c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 81: checkcast com/salesforce/androidsdk/accounts/UserAccount
      // 84: invokespecial com/salesforce/androidsdk/push/PushService.a (ZLcom/salesforce/androidsdk/accounts/UserAccount;)V
      // 87: goto 6f
      // 8a: astore 1
      // 8b: getstatic com/salesforce/androidsdk/push/PushService.a Landroid/os/PowerManager$WakeLock;
      // 8e: ifnull a0
      // 91: getstatic com/salesforce/androidsdk/push/PushService.a Landroid/os/PowerManager$WakeLock;
      // 94: invokevirtual android/os/PowerManager$WakeLock.isHeld ()Z
      // 97: ifeq a0
      // 9a: getstatic com/salesforce/androidsdk/push/PushService.a Landroid/os/PowerManager$WakeLock;
      // 9d: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // a0: aload 1
      // a1: athrow
      // a2: new com/salesforce/androidsdk/accounts/UserAccount
      // a5: dup
      // a6: aload 8
      // a8: invokespecial com/salesforce/androidsdk/accounts/UserAccount.<init> (Landroid/os/Bundle;)V
      // ab: astore 6
      // ad: iload 3
      // ae: istore 2
      // af: goto 2d
      // b2: aload 6
      // b4: astore 1
      // b5: aload 6
      // b7: ifnonnull c0
      // ba: aload 7
      // bc: invokevirtual com/salesforce/androidsdk/accounts/UserAccountManager.b ()Lcom/salesforce/androidsdk/accounts/UserAccount;
      // bf: astore 1
      // c0: aload 0
      // c1: iload 5
      // c3: aload 1
      // c4: invokespecial com/salesforce/androidsdk/push/PushService.a (ZLcom/salesforce/androidsdk/accounts/UserAccount;)V
      // c7: getstatic com/salesforce/androidsdk/push/PushService.a Landroid/os/PowerManager$WakeLock;
      // ca: ifnull dc
      // cd: getstatic com/salesforce/androidsdk/push/PushService.a Landroid/os/PowerManager$WakeLock;
      // d0: invokevirtual android/os/PowerManager$WakeLock.isHeld ()Z
      // d3: ifeq dc
      // d6: getstatic com/salesforce/androidsdk/push/PushService.a Landroid/os/PowerManager$WakeLock;
      // d9: invokevirtual android/os/PowerManager$WakeLock.release ()V
      // dc: return
      // try (30 -> 40): 61 null
      // try (48 -> 51): 61 null
      // try (51 -> 60): 61 null
      // try (83 -> 86): 61 null
      // try (86 -> 90): 61 null
   }

   public static class SFDCRegistrationRetryAlarmReceiver extends BroadcastReceiver {
      public void onReceive(Context var1, Intent var2) {
         if (var2 != null) {
            Bundle var3 = var2.getBundleExtra("account_bundle");
            if (var3 != null) {
               if ("all_accounts".equals(var3.getString("account_bundle"))) {
                  PushMessaging.c(var1, null);
               } else {
                  PushMessaging.c(var1, new UserAccount(var3));
               }
            }
         }
      }
   }
}
