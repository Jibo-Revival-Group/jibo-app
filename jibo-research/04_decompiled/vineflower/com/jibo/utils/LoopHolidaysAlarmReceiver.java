package com.jibo.utils;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.settings.HolidaySettingsFragment;
import java.util.Calendar;

public class LoopHolidaysAlarmReceiver extends BroadcastReceiver {
   public static void a(Context var0, Loop var1) {
      AlarmManager var2 = (AlarmManager)var0.getSystemService("alarm");
      Intent var3 = new Intent(var0, LoopHolidaysAlarmReceiver.class);
      var3.putExtra(Loop.class.getSimpleName(), var1.getId());
      PendingIntent var4 = PendingIntent.getBroadcast(var0, var1.getId().hashCode() + 10000, var3, 134217728);
      Calendar var5 = Calendar.getInstance();
      var5.setTimeInMillis(System.currentTimeMillis());
      var5.add(6, 2);
      var5.set(12, 0);
      var5.set(13, 0);
      var5.add(11, 12);
      var2.set(1, var5.getTimeInMillis(), var4);
   }

   public static void b(Context var0, Loop var1) {
      if (var1 != null) {
         SharedPreferencesUtil.h(var0, var1.getId());
         AlarmManager var2 = (AlarmManager)var0.getSystemService("alarm");
         Intent var3 = new Intent(var0, LoopHolidaysAlarmReceiver.class);
         var3.putExtra(Loop.class.getSimpleName(), var1.getId());
         var2.cancel(PendingIntent.getBroadcast(var0, var1.getId().hashCode() + 10000, var3, 134217728));
         ((NotificationManager)var0.getSystemService("notification")).cancel(var1.getId(), var1.getId().hashCode() + 10001);
      }
   }

   private void c(Context var1, Loop var2) {
      Intent var3 = new SingleFragmentActivity.Builder(var1, HolidaySettingsFragment.class.getName()).a(Loop.class.getSimpleName(), var2).a();
      PendingIntent var4 = TaskStackBuilder.a(var1).b(var3).a(var2.getId().hashCode() + 10001, 134217728);
      Uri var5 = RingtoneManager.getDefaultUri(2);
      NotificationCompat.Builder var6 = new NotificationCompat.Builder(var1)
         .a(UIUtils.a())
         .b(var1.getString(2131755560))
         .a((CharSequence)var1.getString(2131755561))
         .a(true)
         .a(var5)
         .a(var4);
      NotificationCompat.BigTextStyle var7 = new NotificationCompat.BigTextStyle(var6);
      var7.b(var1.getString(2131755560));
      var7.a(var1.getString(2131755561));
      var6.a(var7);
      if (VERSION.SDK_INT >= 21) {
         var6.d(var1.getResources().getColor(2131099771));
      }

      ((NotificationManager)var1.getSystemService("notification")).notify(var2.getId(), var2.getId().hashCode() + 10001, var6.b());
   }

   public void onReceive(Context param1, Intent param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 2
      // 001: ldc com/jibo/aws/integration/aws/services/loop/model/Loop
      // 003: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 006: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 009: ifnull 040
      // 00c: aload 2
      // 00d: ldc com/jibo/aws/integration/aws/services/loop/model/Loop
      // 00f: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 012: invokevirtual android/content/Intent.getStringExtra (Ljava/lang/String;)Ljava/lang/String;
      // 015: astore 5
      // 017: aload 1
      // 018: invokestatic com/jibo/db/EntityData.a (Landroid/content/Context;)Lcom/jibo/db/EntityData;
      // 01b: aload 5
      // 01d: invokevirtual com/jibo/db/EntityData.c (Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 020: astore 6
      // 022: aload 6
      // 024: ifnull 034
      // 027: aload 6
      // 029: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.isSuspended ()Ljava/lang/Boolean;
      // 02c: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 02f: istore 3
      // 030: iload 3
      // 031: ifeq 041
      // 034: bipush 0
      // 035: ifeq 040
      // 038: new java/lang/NullPointerException
      // 03b: dup
      // 03c: invokespecial java/lang/NullPointerException.<init> ()V
      // 03f: athrow
      // 040: return
      // 041: aload 1
      // 042: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 045: bipush 8
      // 047: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 04a: getstatic com/jibo/db/DatabaseContract$EntityEntry.a [Ljava/lang/String;
      // 04d: aconst_null
      // 04e: aconst_null
      // 04f: aconst_null
      // 050: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 053: astore 4
      // 055: aload 4
      // 057: ifnull 0c5
      // 05a: aload 4
      // 05c: astore 2
      // 05d: aload 4
      // 05f: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 064: ifne 0c5
      // 067: aload 4
      // 069: astore 2
      // 06a: aload 4
      // 06c: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 071: ifeq 0c5
      // 074: aload 4
      // 076: astore 2
      // 077: aload 1
      // 078: aload 5
      // 07a: invokestatic com/jibo/utils/SharedPreferencesUtil.g (Landroid/content/Context;Ljava/lang/String;)V
      // 07d: aload 4
      // 07f: astore 2
      // 080: aload 4
      // 082: invokeinterface android/database/Cursor.getCount ()I 1
      // 087: bipush 1
      // 088: if_icmpne 095
      // 08b: aload 4
      // 08d: astore 2
      // 08e: aload 0
      // 08f: aload 1
      // 090: aload 6
      // 092: invokespecial com/jibo/utils/LoopHolidaysAlarmReceiver.c (Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
      // 095: aload 4
      // 097: astore 2
      // 098: new android/content/Intent
      // 09b: astore 6
      // 09d: aload 4
      // 09f: astore 2
      // 0a0: aload 6
      // 0a2: ldc_w "LOOP_HOLIDAYS_ALARM_ACTION"
      // 0a5: invokespecial android/content/Intent.<init> (Ljava/lang/String;)V
      // 0a8: aload 4
      // 0aa: astore 2
      // 0ab: aload 6
      // 0ad: ldc com/jibo/aws/integration/aws/services/loop/model/Loop
      // 0af: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 0b2: aload 5
      // 0b4: invokevirtual android/content/Intent.putExtra (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      // 0b7: pop
      // 0b8: aload 4
      // 0ba: astore 2
      // 0bb: aload 1
      // 0bc: invokestatic android/support/v4/content/LocalBroadcastManager.a (Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;
      // 0bf: aload 6
      // 0c1: invokevirtual android/support/v4/content/LocalBroadcastManager.a (Landroid/content/Intent;)Z
      // 0c4: pop
      // 0c5: aload 4
      // 0c7: ifnull 040
      // 0ca: aload 4
      // 0cc: invokeinterface android/database/Cursor.close ()V 1
      // 0d1: goto 040
      // 0d4: astore 1
      // 0d5: aconst_null
      // 0d6: astore 4
      // 0d8: aload 4
      // 0da: astore 2
      // 0db: aload 1
      // 0dc: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 0df: aload 4
      // 0e1: ifnull 040
      // 0e4: aload 4
      // 0e6: invokeinterface android/database/Cursor.close ()V 1
      // 0eb: goto 040
      // 0ee: astore 1
      // 0ef: aconst_null
      // 0f0: astore 2
      // 0f1: aload 2
      // 0f2: ifnull 0fb
      // 0f5: aload 2
      // 0f6: invokeinterface android/database/Cursor.close ()V 1
      // 0fb: aload 1
      // 0fc: athrow
      // 0fd: astore 1
      // 0fe: goto 0f1
      // 101: astore 1
      // 102: goto 0d8
      // try (5 -> 15): 98 java/lang/Exception
      // try (5 -> 15): 110 null
      // try (17 -> 21): 98 java/lang/Exception
      // try (17 -> 21): 110 null
      // try (30 -> 40): 98 java/lang/Exception
      // try (30 -> 40): 110 null
      // try (44 -> 47): 121 java/lang/Exception
      // try (44 -> 47): 119 null
      // try (49 -> 52): 121 java/lang/Exception
      // try (49 -> 52): 119 null
      // try (54 -> 57): 121 java/lang/Exception
      // try (54 -> 57): 119 null
      // try (59 -> 63): 121 java/lang/Exception
      // try (59 -> 63): 119 null
      // try (65 -> 69): 121 java/lang/Exception
      // try (65 -> 69): 119 null
      // try (71 -> 73): 121 java/lang/Exception
      // try (71 -> 73): 119 null
      // try (75 -> 78): 121 java/lang/Exception
      // try (75 -> 78): 119 null
      // try (80 -> 86): 121 java/lang/Exception
      // try (80 -> 86): 119 null
      // try (88 -> 93): 121 java/lang/Exception
      // try (88 -> 93): 119 null
      // try (103 -> 105): 119 null
   }
}
