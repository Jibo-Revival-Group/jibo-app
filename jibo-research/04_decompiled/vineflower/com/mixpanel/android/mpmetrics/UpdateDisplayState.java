package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class UpdateDisplayState implements Parcelable {
   public static final Creator<UpdateDisplayState> CREATOR = new Creator<UpdateDisplayState>() {
      public UpdateDisplayState a(Parcel var1) {
         Bundle var2 = new Bundle(UpdateDisplayState.class.getClassLoader());
         var2.readFromParcel(var1);
         return new UpdateDisplayState(var2);
      }

      public UpdateDisplayState[] a(int var1) {
         return new UpdateDisplayState[var1];
      }
   };
   private static final ReentrantLock d = new ReentrantLock();
   private static long e = -1L;
   private static UpdateDisplayState f = null;
   private static int g = 0;
   private static int h = -1;
   private final String a;
   private final String b;
   private final UpdateDisplayState.DisplayState c;

   private UpdateDisplayState(Bundle var1) {
      this.a = var1.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY");
      this.b = var1.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY");
      this.c = (UpdateDisplayState.DisplayState)var1.getParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY");
   }

   UpdateDisplayState(UpdateDisplayState.DisplayState var1, String var2, String var3) {
      this.a = var2;
      this.b = var3;
      this.c = var1;
   }

   static int a(UpdateDisplayState.DisplayState var0, String var1, String var2) {
      int var3 = -1;
      if (!d.isHeldByCurrentThread()) {
         throw new AssertionError();
      }

      if (!b()) {
         e = System.currentTimeMillis();
         f = new UpdateDisplayState(var0, var1, var2);
         g++;
         var3 = g;
      } else {
         MPLog.a("MixpanelAPI.UpDisplSt", "Already showing (or cooking) a Mixpanel update, declining to show another.");
      }

      return var3;
   }

   static ReentrantLock a() {
      return d;
   }

   public static void a(int var0) {
      d.lock();

      try {
         if (var0 == h) {
            h = -1;
            f = null;
         }
      } finally {
         d.unlock();
      }
   }

   public static UpdateDisplayState b(int param0) {
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
      // 00: aconst_null
      // 01: astore 2
      // 02: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.d Ljava/util/concurrent/locks/ReentrantLock;
      // 05: invokevirtual java/util/concurrent/locks/ReentrantLock.lock ()V
      // 08: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.h I
      // 0b: ifle 1f
      // 0e: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.h I
      // 11: istore 1
      // 12: iload 1
      // 13: iload 0
      // 14: if_icmpeq 1f
      // 17: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.d Ljava/util/concurrent/locks/ReentrantLock;
      // 1a: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 1d: aload 2
      // 1e: areturn
      // 1f: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.f Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;
      // 22: astore 3
      // 23: aload 3
      // 24: ifnonnull 30
      // 27: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.d Ljava/util/concurrent/locks/ReentrantLock;
      // 2a: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 2d: goto 1d
      // 30: invokestatic java/lang/System.currentTimeMillis ()J
      // 33: putstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.e J
      // 36: iload 0
      // 37: putstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.h I
      // 3a: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.f Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;
      // 3d: astore 2
      // 3e: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.d Ljava/util/concurrent/locks/ReentrantLock;
      // 41: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 44: goto 1d
      // 47: astore 2
      // 48: getstatic com/mixpanel/android/mpmetrics/UpdateDisplayState.d Ljava/util/concurrent/locks/ReentrantLock;
      // 4b: invokevirtual java/util/concurrent/locks/ReentrantLock.unlock ()V
      // 4e: aload 2
      // 4f: athrow
      // try (4 -> 8): 31 null
      // try (15 -> 17): 31 null
      // try (22 -> 28): 31 null
   }

   static boolean b() {
      if (!d.isHeldByCurrentThread()) {
         throw new AssertionError();
      }

      long var3 = System.currentTimeMillis();
      long var1 = e;
      if (g > 0 && var3 - var1 > 43200000L) {
         MPLog.c("MixpanelAPI.UpDisplSt", "UpdateDisplayState set long, long ago, without showing. Update state will be cleared.");
         f = null;
      }

      boolean var0;
      if (f != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public UpdateDisplayState.DisplayState c() {
      return this.c;
   }

   public String d() {
      return this.b;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      Bundle var3 = new Bundle();
      var3.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISTINCT_ID_BUNDLE_KEY", this.a);
      var3.putString("com.mixpanel.android.mpmetrics.UpdateDisplayState.TOKEN_BUNDLE_KEY", this.b);
      var3.putParcelable("com.mixpanel.android.mpmetrics.UpdateDisplayState.DISPLAYSTATE_BUNDLE_KEY", this.c);
      var1.writeBundle(var3);
   }

   public static class AnswerMap implements Parcelable {
      public static final Creator<UpdateDisplayState.AnswerMap> CREATOR = new Creator<UpdateDisplayState.AnswerMap>() {
         public UpdateDisplayState.AnswerMap a(Parcel var1) {
            Bundle var3 = new Bundle(UpdateDisplayState.AnswerMap.class.getClassLoader());
            UpdateDisplayState.AnswerMap var2 = new UpdateDisplayState.AnswerMap();
            var3.readFromParcel(var1);

            for (String var4 : var3.keySet()) {
               var2.a(Integer.valueOf(var4), var3.getString(var4));
            }

            return var2;
         }

         public UpdateDisplayState.AnswerMap[] a(int var1) {
            return new UpdateDisplayState.AnswerMap[var1];
         }
      };
      private final HashMap<Integer, String> a = new HashMap<>();

      public void a(Integer var1, String var2) {
         this.a.put(var1, var2);
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         Bundle var3 = new Bundle();

         for (Entry var4 : this.a.entrySet()) {
            var3.putString(Integer.toString((Integer)var4.getKey()), (String)var4.getValue());
         }

         var1.writeBundle(var3);
      }
   }

   public abstract static class DisplayState implements Parcelable {
      public static final Creator<UpdateDisplayState.DisplayState> CREATOR = new Creator<UpdateDisplayState.DisplayState>() {
         public UpdateDisplayState.DisplayState a(Parcel var1) {
            Bundle var2 = new Bundle(UpdateDisplayState.DisplayState.class.getClassLoader());
            var2.readFromParcel(var1);
            String var3 = var2.getString("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_TYPE_KEY");
            var2 = var2.getBundle("com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.STATE_IMPL_KEY");
            if ("InAppNotificationState".equals(var3)) {
               return new UpdateDisplayState.DisplayState.InAppNotificationState(var2);
            } else {
               throw new RuntimeException("Unrecognized display state type " + var3);
            }
         }

         public UpdateDisplayState.DisplayState[] a(int var1) {
            return new UpdateDisplayState.DisplayState[var1];
         }
      };

      private DisplayState() {
      }

      public static final class InAppNotificationState extends UpdateDisplayState.DisplayState {
         public static final Creator<UpdateDisplayState.DisplayState.InAppNotificationState> CREATOR = new Creator<UpdateDisplayState.DisplayState.InAppNotificationState>() {
            public UpdateDisplayState.DisplayState.InAppNotificationState a(Parcel var1) {
               Bundle var2 = new Bundle(UpdateDisplayState.DisplayState.InAppNotificationState.class.getClassLoader());
               var2.readFromParcel(var1);
               return new UpdateDisplayState.DisplayState.InAppNotificationState(var2);
            }

            public UpdateDisplayState.DisplayState.InAppNotificationState[] a(int var1) {
               return new UpdateDisplayState.DisplayState.InAppNotificationState[var1];
            }
         };
         private static String c = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.INAPP_KEY";
         private static String d = "com.com.mixpanel.android.mpmetrics.UpdateDisplayState.InAppNotificationState.HIGHLIGHT_KEY";
         private final InAppNotification a;
         private final int b;

         private InAppNotificationState(Bundle var1) {
            this.a = (InAppNotification)var1.getParcelable(c);
            this.b = var1.getInt(d);
         }

         public InAppNotificationState(InAppNotification var1, int var2) {
            this.a = var1;
            this.b = var2;
         }

         public InAppNotification a() {
            return this.a;
         }

         public int describeContents() {
            return 0;
         }

         public void writeToParcel(Parcel var1, int var2) {
            Bundle var3 = new Bundle();
            var3.putParcelable(c, this.a);
            var3.putInt(d, this.b);
            var1.writeBundle(var3);
         }
      }
   }
}
