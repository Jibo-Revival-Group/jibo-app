package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.internal.zzevw;
import com.google.android.gms.internal.zzevx;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewg;
import com.google.android.gms.internal.zzewk;
import com.google.android.gms.internal.zzewl;
import com.google.android.gms.internal.zzewm;
import com.google.android.gms.internal.zzewn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentHashMap;

public class Trace extends zzevx implements Parcelable {
   @Keep
   public static final Creator<Trace> CREATOR = new zzc();
   private static final Map<String, Trace> a = new ConcurrentHashMap<>();
   private static Creator<Trace> k = new zzd();
   private final Trace b;
   private final String c;
   private final List<Trace> d;
   private final Map<String, zza> e;
   private final zzewk f;
   private final zzevz g;
   private final Map<String, String> h;
   private zzewn i;
   private zzewn j;

   private Trace(Parcel var1, boolean var2) {
      zzevw var3;
      if (var2) {
         var3 = null;
      } else {
         var3 = zzevw.a();
      }

      super(var3);
      this.b = (Trace)var1.readParcelable(Trace.class.getClassLoader());
      this.c = var1.readString();
      this.d = new ArrayList<>();
      var1.readList(this.d, Trace.class.getClassLoader());
      this.e = new ConcurrentHashMap<>();
      this.h = new ConcurrentHashMap<>();
      var1.readMap(this.e, zza.class.getClassLoader());
      this.i = (zzewn)var1.readParcelable(zzewn.class.getClassLoader());
      this.j = (zzewn)var1.readParcelable(zzewn.class.getClassLoader());
      if (var2) {
         this.g = null;
         this.f = null;
      } else {
         this.g = zzevz.a();
         this.f = new zzewk();
      }
   }

   private final boolean i() {
      boolean var1;
      if (this.j != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private final boolean j() {
      boolean var1;
      if (this.i != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   final String a() {
      return this.c;
   }

   final Map<String, zza> b() {
      return this.e;
   }

   final zzewn c() {
      return this.i;
   }

   final zzewn d() {
      return this.j;
   }

   @Keep
   public int describeContents() {
      return 0;
   }

   @Override
   protected void finalize() throws Throwable {
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
      // 00: bipush 1
      // 01: istore 1
      // 02: aload 0
      // 03: invokespecial com/google/firebase/perf/metrics/Trace.j ()Z
      // 06: ifeq 34
      // 09: aload 0
      // 0a: invokespecial com/google/firebase/perf/metrics/Trace.i ()Z
      // 0d: ifne 34
      // 10: iload 1
      // 11: ifeq 2f
      // 14: ldc "FirebasePerformance"
      // 16: ldc "Trace '%s' is started but not stopped when it is destructed!"
      // 18: bipush 1
      // 19: anewarray 142
      // 1c: dup
      // 1d: bipush 0
      // 1e: aload 0
      // 1f: getfield com/google/firebase/perf/metrics/Trace.c Ljava/lang/String;
      // 22: aastore
      // 23: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 26: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 29: pop
      // 2a: aload 0
      // 2b: bipush 1
      // 2c: invokevirtual com/google/android/gms/internal/zzevx.c (I)V
      // 2f: aload 0
      // 30: invokespecial java/lang/Object.finalize ()V
      // 33: return
      // 34: bipush 0
      // 35: istore 1
      // 36: goto 10
      // 39: astore 2
      // 3a: aload 0
      // 3b: invokespecial java/lang/Object.finalize ()V
      // 3e: aload 2
      // 3f: athrow
      // try (2 -> 8): 31 null
      // try (10 -> 25): 31 null
   }

   @Keep
   public String getAttribute(String var1) {
      return this.h.get(var1);
   }

   @Keep
   public Map<String, String> getAttributes() {
      return new HashMap<>(this.h);
   }

   final List<Trace> h() {
      return this.d;
   }

   @Keep
   public void incrementCounter(String var1) {
      this.incrementCounter(var1, 1L);
   }

   @Keep
   public void incrementCounter(String var1, long var2) {
      String var6;
      if (var1 == null) {
         var6 = "Counter name must not be null";
      } else if (var1.length() > 100) {
         var6 = String.format(Locale.US, "Counter name must not exceed %d characters", 100);
      } else {
         label40: {
            if (var1.startsWith("_")) {
               zzewl[] var9 = zzewl.values();
               int var5 = var9.length;
               int var4 = 0;

               while (true) {
                  if (var4 >= var5) {
                     var6 = "Counter name must not start with '_'";
                     break label40;
                  }

                  if (var9[var4].toString().equals(var1)) {
                     break;
                  }

                  var4++;
               }
            }

            var6 = null;
         }
      }

      if (var6 != null) {
         Log.e("FirebasePerformance", String.format("Cannot increment counter %s. Counter name is invalid.(%s)", var1, var6));
      } else if (!this.j()) {
         Log.w("FirebasePerformance", String.format("Cannot increment counter '%s' for trace '%s' because it's not started", var1, this.c));
      } else if (this.i()) {
         Log.w("FirebasePerformance", String.format("Cannot increment counter '%s' for trace '%s' because it's been stopped", var1, this.c));
      } else {
         String var7 = var1.trim();
         zza var10 = this.e.get(var7);
         zza var8 = var10;
         if (var10 == null) {
            var8 = new zza(var7);
            this.e.put(var7, var8);
         }

         var8.a(var2);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Keep
   public void putAttribute(String var1, String var2) {
      String var4 = var1;
      String var5 = var2;

      boolean var3;
      label155: {
         String var6;
         try {
            var6 = var1.trim();
         } catch (Exception var24) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var24.getMessage()));
            var3 = false;
            var1 = var5;
            break label155;
         }

         var4 = var6;
         var5 = var2;

         try {
            var1 = var2.trim();
         } catch (Exception var23) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var23.getMessage()));
            var3 = false;
            var1 = var5;
            break label155;
         }

         var4 = var6;
         var5 = var1;

         label156: {
            try {
               if (!this.i()) {
                  break label156;
               }
            } catch (Exception var22) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var22.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               var26 = new IllegalArgumentException;
            } catch (Exception var21) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var21.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               var26./* $VF: Unable to resugar constructor */<init>(String.format(Locale.US, "Trace %s has been stopped", this.c));
            } catch (Exception var20) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var20.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               throw var26;
            } catch (Exception var19) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var19.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }
         }

         var4 = var6;
         var5 = var1;

         label157: {
            try {
               if (this.h.containsKey(var6)) {
                  break label157;
               }
            } catch (Exception var18) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var18.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               if (this.h.size() < 5) {
                  break label157;
               }
            } catch (Exception var17) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var17.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               var27 = new IllegalArgumentException;
            } catch (Exception var16) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var16.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               var27./* $VF: Unable to resugar constructor */<init>(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", 5));
            } catch (Exception var15) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var15.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }

            var4 = var6;
            var5 = var1;

            try {
               throw var27;
            } catch (Exception var14) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var14.getMessage()));
               var3 = false;
               var1 = var5;
               break label155;
            }
         }

         var4 = var6;
         var5 = var1;

         try {
            var28 = new SimpleEntry;
         } catch (Exception var13) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var13.getMessage()));
            var3 = false;
            var1 = var5;
            break label155;
         }

         var4 = var6;
         var5 = var1;

         try {
            var28./* $VF: Unable to resugar constructor */<init>(var6, var1);
         } catch (Exception var12) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var12.getMessage()));
            var3 = false;
            var1 = var5;
            break label155;
         }

         var4 = var6;
         var5 = var1;

         String var7;
         try {
            var7 = zzewg.a(var28);
         } catch (Exception var11) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var11.getMessage()));
            var3 = false;
            var1 = var5;
            break label155;
         }

         label92:
         if (var7 != null) {
            var4 = var6;
            var5 = var1;

            try {
               var29 = new IllegalArgumentException;
            } catch (Exception var10) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var10.getMessage()));
               var3 = false;
               var1 = var5;
               break label92;
            }

            var4 = var6;
            var5 = var1;

            try {
               var29./* $VF: Unable to resugar constructor */<init>(var7);
            } catch (Exception var9) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var9.getMessage()));
               var3 = false;
               var1 = var5;
               break label92;
            }

            var4 = var6;
            var5 = var1;

            try {
               throw var29;
            } catch (Exception var8) {
               Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", var4, var5, var8.getMessage()));
               var3 = false;
               var1 = var5;
            }
         } else {
            var3 = true;
            var4 = var6;
         }
      }

      if (var3) {
         this.h.put(var4, var1);
      }
   }

   @Keep
   public void removeAttribute(String var1) {
      if (this.i()) {
         Log.e("FirebasePerformance", "Can't remove a attribute from a Trace that's stopped.");
      } else {
         this.h.remove(var1);
      }
   }

   @Keep
   public void start() {
      String var4 = this.c;
      String var3;
      if (var4 == null) {
         var3 = "Trace name must not be null";
      } else if (var4.length() > 100) {
         var3 = String.format(Locale.US, "Trace name must not exceed %d characters", 100);
      } else {
         label33: {
            if (var4.startsWith("_")) {
               zzewm[] var5 = zzewm.values();
               int var2 = var5.length;
               int var1 = 0;

               while (true) {
                  if (var1 >= var2) {
                     var3 = "Trace name must not start with '_'";
                     break label33;
                  }

                  if (var5[var1].toString().equals(var4)) {
                     break;
                  }

                  var1++;
               }
            }

            var3 = null;
         }
      }

      if (var3 != null) {
         Log.e("FirebasePerformance", String.format("Cannot start trace %s. Trace name is invalid.(%s)", this.c, var3));
      } else if (this.i != null) {
         Log.e("FirebasePerformance", String.format("Trace '%s' has already started, should not start again!", this.c));
      } else {
         this.i = new zzewn();
         this.e();
      }
   }

   @Keep
   public void stop() {
      if (!this.j()) {
         Log.e("FirebasePerformance", String.format("Trace '%s' has not been started so unable to stop!", this.c));
      } else if (this.i()) {
         Log.e("FirebasePerformance", String.format("Trace '%s' has already stopped, should not stop again!", this.c));
      } else {
         this.f();
         this.j = new zzewn();
         if (this.b == null) {
            zzewn var2 = this.j;
            if (!this.d.isEmpty()) {
               int var1 = this.d.size();
               Trace var3 = this.d.get(var1 - 1);
               if (var3.j == null) {
                  var3.j = var2;
               }
            }

            if (!this.c.isEmpty()) {
               if (this.g != null) {
                  this.g.a(new zze(this).a(), this.g());
               }
            } else {
               Log.e("FirebasePerformance", "Trace name is empty, no log is sent to server");
            }
         }
      }
   }

   @Keep
   public void writeToParcel(Parcel var1, int var2) {
      var1.writeParcelable(this.b, 0);
      var1.writeString(this.c);
      var1.writeList(this.d);
      var1.writeMap(this.e);
      var1.writeParcelable(this.i, 0);
      var1.writeParcelable(this.j, 0);
   }
}
