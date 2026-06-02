package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.Handler.Callback;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public final class NotificationManagerCompat {
   private static final Object a = new Object();
   private static String b;
   private static Set<String> c = new HashSet<>();
   private static final Object f = new Object();
   private static NotificationManagerCompat.SideChannelManager g;
   private final Context d;
   private final NotificationManager e;

   private NotificationManagerCompat(Context var1) {
      this.d = var1;
      this.e = (NotificationManager)this.d.getSystemService("notification");
   }

   public static NotificationManagerCompat a(Context var0) {
      return new NotificationManagerCompat(var0);
   }

   private void a(NotificationManagerCompat.Task param1) {
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
      // 00: getstatic android/support/v4/app/NotificationManagerCompat.f Ljava/lang/Object;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: getstatic android/support/v4/app/NotificationManagerCompat.g Landroid/support/v4/app/NotificationManagerCompat$SideChannelManager;
      // 09: ifnonnull 1f
      // 0c: new android/support/v4/app/NotificationManagerCompat$SideChannelManager
      // 0f: astore 3
      // 10: aload 3
      // 11: aload 0
      // 12: getfield android/support/v4/app/NotificationManagerCompat.d Landroid/content/Context;
      // 15: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 18: invokespecial android/support/v4/app/NotificationManagerCompat$SideChannelManager.<init> (Landroid/content/Context;)V
      // 1b: aload 3
      // 1c: putstatic android/support/v4/app/NotificationManagerCompat.g Landroid/support/v4/app/NotificationManagerCompat$SideChannelManager;
      // 1f: getstatic android/support/v4/app/NotificationManagerCompat.g Landroid/support/v4/app/NotificationManagerCompat$SideChannelManager;
      // 22: aload 1
      // 23: invokevirtual android/support/v4/app/NotificationManagerCompat$SideChannelManager.a (Landroid/support/v4/app/NotificationManagerCompat$Task;)V
      // 26: aload 2
      // 27: monitorexit
      // 28: return
      // 29: astore 1
      // 2a: aload 2
      // 2b: monitorexit
      // 2c: aload 1
      // 2d: athrow
      // try (4 -> 15): 21 null
      // try (15 -> 20): 21 null
      // try (22 -> 24): 21 null
   }

   private static boolean a(Notification var0) {
      Bundle var2 = NotificationCompat.a(var0);
      boolean var1;
      if (var2 != null && var2.getBoolean("android.support.useSideChannel")) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static Set<String> b(Context param0) {
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
      // 00: aload 0
      // 01: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 04: ldc "enabled_notification_listeners"
      // 06: invokestatic android/provider/Settings$Secure.getString (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
      // 09: astore 6
      // 0b: getstatic android/support/v4/app/NotificationManagerCompat.a Ljava/lang/Object;
      // 0e: astore 0
      // 0f: aload 0
      // 10: monitorenter
      // 11: aload 6
      // 13: ifnull 69
      // 16: aload 6
      // 18: getstatic android/support/v4/app/NotificationManagerCompat.b Ljava/lang/String;
      // 1b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1e: ifne 69
      // 21: aload 6
      // 23: ldc ":"
      // 25: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 28: astore 3
      // 29: new java/util/HashSet
      // 2c: astore 4
      // 2e: aload 4
      // 30: aload 3
      // 31: arraylength
      // 32: invokespecial java/util/HashSet.<init> (I)V
      // 35: aload 3
      // 36: arraylength
      // 37: istore 2
      // 38: bipush 0
      // 39: istore 1
      // 3a: iload 1
      // 3b: iload 2
      // 3c: if_icmpge 5f
      // 3f: aload 3
      // 40: iload 1
      // 41: aaload
      // 42: invokestatic android/content/ComponentName.unflattenFromString (Ljava/lang/String;)Landroid/content/ComponentName;
      // 45: astore 5
      // 47: aload 5
      // 49: ifnull 59
      // 4c: aload 4
      // 4e: aload 5
      // 50: invokevirtual android/content/ComponentName.getPackageName ()Ljava/lang/String;
      // 53: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 58: pop
      // 59: iinc 1 1
      // 5c: goto 3a
      // 5f: aload 4
      // 61: putstatic android/support/v4/app/NotificationManagerCompat.c Ljava/util/Set;
      // 64: aload 6
      // 66: putstatic android/support/v4/app/NotificationManagerCompat.b Ljava/lang/String;
      // 69: getstatic android/support/v4/app/NotificationManagerCompat.c Ljava/util/Set;
      // 6c: astore 3
      // 6d: aload 0
      // 6e: monitorexit
      // 6f: aload 3
      // 70: areturn
      // 71: astore 3
      // 72: aload 0
      // 73: monitorexit
      // 74: aload 3
      // 75: athrow
      // try (11 -> 28): 57 null
      // try (33 -> 38): 57 null
      // try (40 -> 45): 57 null
      // try (47 -> 51): 57 null
      // try (51 -> 55): 57 null
      // try (58 -> 60): 57 null
   }

   public void a(int var1, Notification var2) {
      this.a(null, var1, var2);
   }

   public void a(String var1, int var2, Notification var3) {
      if (a(var3)) {
         this.a(new NotificationManagerCompat.NotifyTask(this.d.getPackageName(), var2, var1, var3));
         this.e.cancel(var1, var2);
      } else {
         this.e.notify(var1, var2, var3);
      }
   }

   private static class NotifyTask implements NotificationManagerCompat.Task {
      final String a;
      final int b;
      final String c;
      final Notification d;

      NotifyTask(String var1, int var2, String var3, Notification var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      @Override
      public void a(INotificationSideChannel var1) throws RemoteException {
         var1.a(this.a, this.b, this.c, this.d);
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder("NotifyTask[");
         var1.append("packageName:").append(this.a);
         var1.append(", id:").append(this.b);
         var1.append(", tag:").append(this.c);
         var1.append("]");
         return var1.toString();
      }
   }

   private static class ServiceConnectedEvent {
      final ComponentName a;
      final IBinder b;

      ServiceConnectedEvent(ComponentName var1, IBinder var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   private static class SideChannelManager implements ServiceConnection, Callback {
      private final Context a;
      private final HandlerThread b;
      private final Handler c;
      private final Map<ComponentName, NotificationManagerCompat.SideChannelManager.ListenerRecord> d = new HashMap<>();
      private Set<String> e = new HashSet<>();

      SideChannelManager(Context var1) {
         this.a = var1;
         this.b = new HandlerThread("NotificationManagerCompat");
         this.b.start();
         this.c = new Handler(this.b.getLooper(), this);
      }

      private void a() {
         Set var2 = NotificationManagerCompat.b(this.a);
         if (!var2.equals(this.e)) {
            this.e = var2;
            List var3 = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet var1 = new HashSet();

            for (ResolveInfo var4 : var3) {
               if (var2.contains(var4.serviceInfo.packageName)) {
                  ComponentName var8 = new ComponentName(var4.serviceInfo.packageName, var4.serviceInfo.name);
                  if (var4.serviceInfo.permission != null) {
                     Log.w("NotifManCompat", "Permission present on component " + var8 + ", not adding listener record.");
                  } else {
                     var1.add(var8);
                  }
               }
            }

            for (ComponentName var9 : var1) {
               if (!this.d.containsKey(var9)) {
                  if (Log.isLoggable("NotifManCompat", 3)) {
                     Log.d("NotifManCompat", "Adding listener record for " + var9);
                  }

                  this.d.put(var9, new NotificationManagerCompat.SideChannelManager.ListenerRecord(var9));
               }
            }

            Iterator var7 = this.d.entrySet().iterator();

            while (var7.hasNext()) {
               Entry var10 = (Entry)var7.next();
               if (!var1.contains(var10.getKey())) {
                  if (Log.isLoggable("NotifManCompat", 3)) {
                     Log.d("NotifManCompat", "Removing listener record for " + var10.getKey());
                  }

                  this.b((NotificationManagerCompat.SideChannelManager.ListenerRecord)var10.getValue());
                  var7.remove();
               }
            }
         }
      }

      private void a(ComponentName var1) {
         NotificationManagerCompat.SideChannelManager.ListenerRecord var2 = this.d.get(var1);
         if (var2 != null) {
            this.b(var2);
         }
      }

      private void a(ComponentName var1, IBinder var2) {
         NotificationManagerCompat.SideChannelManager.ListenerRecord var3 = this.d.get(var1);
         if (var3 != null) {
            var3.c = INotificationSideChannel.Stub.a(var2);
            var3.e = 0;
            this.d(var3);
         }
      }

      private boolean a(NotificationManagerCompat.SideChannelManager.ListenerRecord var1) {
         boolean var2;
         if (var1.b) {
            var2 = true;
         } else {
            Intent var3 = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(var1.a);
            var1.b = this.a.bindService(var3, this, 33);
            if (var1.b) {
               var1.e = 0;
            } else {
               Log.w("NotifManCompat", "Unable to bind to listener " + var1.a);
               this.a.unbindService(this);
            }

            var2 = var1.b;
         }

         return var2;
      }

      private void b(ComponentName var1) {
         NotificationManagerCompat.SideChannelManager.ListenerRecord var2 = this.d.get(var1);
         if (var2 != null) {
            this.d(var2);
         }
      }

      private void b(NotificationManagerCompat.SideChannelManager.ListenerRecord var1) {
         if (var1.b) {
            this.a.unbindService(this);
            var1.b = false;
         }

         var1.c = null;
      }

      private void b(NotificationManagerCompat.Task var1) {
         this.a();

         for (NotificationManagerCompat.SideChannelManager.ListenerRecord var2 : this.d.values()) {
            var2.d.add(var1);
            this.d(var2);
         }
      }

      private void c(NotificationManagerCompat.SideChannelManager.ListenerRecord var1) {
         if (!this.c.hasMessages(3, var1.a)) {
            var1.e++;
            if (var1.e > 6) {
               Log.w("NotifManCompat", "Giving up on delivering " + var1.d.size() + " tasks to " + var1.a + " after " + var1.e + " retries");
               var1.d.clear();
            } else {
               int var2 = (1 << var1.e - 1) * 1000;
               if (Log.isLoggable("NotifManCompat", 3)) {
                  Log.d("NotifManCompat", "Scheduling retry for " + var2 + " ms");
               }

               Message var3 = this.c.obtainMessage(3, var1.a);
               this.c.sendMessageDelayed(var3, var2);
            }
         }
      }

      private void d(NotificationManagerCompat.SideChannelManager.ListenerRecord var1) {
         if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + var1.a + ", " + var1.d.size() + " queued tasks");
         }

         if (!var1.d.isEmpty()) {
            if (this.a(var1) && var1.c != null) {
               while (true) {
                  NotificationManagerCompat.Task var3 = var1.d.peek();
                  if (var3 == null) {
                     break;
                  }

                  try {
                     if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder var2 = new StringBuilder();
                        Log.d("NotifManCompat", var2.append("Sending task ").append(var3).toString());
                     }

                     var3.a(var1.c);
                     var1.d.remove();
                  } catch (DeadObjectException var4) {
                     if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + var1.a);
                     }
                     break;
                  } catch (RemoteException var5) {
                     Log.w("NotifManCompat", "RemoteException communicating with " + var1.a, var5);
                     break;
                  }
               }

               if (!var1.d.isEmpty()) {
                  this.c(var1);
               }
            } else {
               this.c(var1);
            }
         }
      }

      public void a(NotificationManagerCompat.Task var1) {
         this.c.obtainMessage(0, var1).sendToTarget();
      }

      public boolean handleMessage(Message var1) {
         boolean var2;
         switch (var1.what) {
            case 0:
               this.b((NotificationManagerCompat.Task)var1.obj);
               var2 = true;
               break;
            case 1:
               NotificationManagerCompat.ServiceConnectedEvent var3 = (NotificationManagerCompat.ServiceConnectedEvent)var1.obj;
               this.a(var3.a, var3.b);
               var2 = true;
               break;
            case 2:
               this.a((ComponentName)var1.obj);
               var2 = true;
               break;
            case 3:
               this.b((ComponentName)var1.obj);
               var2 = true;
               break;
            default:
               var2 = false;
         }

         return var2;
      }

      public void onServiceConnected(ComponentName var1, IBinder var2) {
         if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + var1);
         }

         this.c.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(var1, var2)).sendToTarget();
      }

      public void onServiceDisconnected(ComponentName var1) {
         if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + var1);
         }

         this.c.obtainMessage(2, var1).sendToTarget();
      }

      private static class ListenerRecord {
         final ComponentName a;
         boolean b = false;
         INotificationSideChannel c;
         ArrayDeque<NotificationManagerCompat.Task> d = new ArrayDeque<>();
         int e = 0;

         ListenerRecord(ComponentName var1) {
            this.a = var1;
         }
      }
   }

   private interface Task {
      void a(INotificationSideChannel var1) throws RemoteException;
   }
}
