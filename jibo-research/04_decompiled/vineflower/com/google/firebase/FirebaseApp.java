package com.google.firebase;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
   static final Map<String, FirebaseApp> a = new ArrayMap<>();
   private static final List<String> b = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");
   private static final List<String> c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
   private static final List<String> d = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");
   private static final List<String> e = Arrays.asList();
   private static final Set<String> f = Collections.emptySet();
   private static final Object g = new Object();
   private final Context h;
   private final String i;
   private final FirebaseOptions j;
   private final AtomicBoolean k = new AtomicBoolean(false);
   private final AtomicBoolean l = new AtomicBoolean();
   private final List<Object> m = new CopyOnWriteArrayList<>();
   private final List<FirebaseApp.zza> n = new CopyOnWriteArrayList<>();
   private final List<Object> o = new CopyOnWriteArrayList<>();
   private FirebaseApp.zzb p;

   private FirebaseApp(Context var1, String var2, FirebaseOptions var3) {
      this.h = zzbq.a(var1);
      this.i = zzbq.a(var2);
      this.j = zzbq.a(var3);
      this.p = new com.google.firebase.internal.zza();
   }

   public static FirebaseApp a(Context param0) {
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
      // 00: getstatic com/google/firebase/FirebaseApp.g Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/google/firebase/FirebaseApp.a Ljava/util/Map;
      // 09: ldc "[DEFAULT]"
      // 0b: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 10: ifeq 1b
      // 13: invokestatic com/google/firebase/FirebaseApp.d ()Lcom/google/firebase/FirebaseApp;
      // 16: astore 0
      // 17: aload 1
      // 18: monitorexit
      // 19: aload 0
      // 1a: areturn
      // 1b: aload 0
      // 1c: invokestatic com/google/firebase/FirebaseOptions.a (Landroid/content/Context;)Lcom/google/firebase/FirebaseOptions;
      // 1f: astore 2
      // 20: aload 2
      // 21: ifnonnull 30
      // 24: aconst_null
      // 25: astore 0
      // 26: aload 1
      // 27: monitorexit
      // 28: goto 19
      // 2b: astore 0
      // 2c: aload 1
      // 2d: monitorexit
      // 2e: aload 0
      // 2f: athrow
      // 30: aload 0
      // 31: aload 2
      // 32: invokestatic com/google/firebase/FirebaseApp.a (Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;)Lcom/google/firebase/FirebaseApp;
      // 35: astore 0
      // 36: aload 1
      // 37: monitorexit
      // 38: goto 19
      // try (4 -> 12): 24 null
      // try (14 -> 17): 24 null
      // try (21 -> 23): 24 null
      // try (25 -> 27): 24 null
      // try (29 -> 35): 24 null
   }

   public static FirebaseApp a(Context var0, FirebaseOptions var1) {
      return a(var0, var1, "[DEFAULT]");
   }

   public static FirebaseApp a(Context param0, FirebaseOptions param1, String param2) {
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
      // 01: invokestatic com/google/firebase/internal/zzb.a (Landroid/content/Context;)Lcom/google/firebase/internal/zzb;
      // 04: pop
      // 05: aload 0
      // 06: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 09: instanceof android/app/Application
      // 0c: ifeq 26
      // 0f: aload 0
      // 10: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 13: checkcast android/app/Application
      // 16: invokestatic com/google/android/gms/common/api/internal/zzk.a (Landroid/app/Application;)V
      // 19: invokestatic com/google/android/gms/common/api/internal/zzk.a ()Lcom/google/android/gms/common/api/internal/zzk;
      // 1c: new com/google/firebase/zza
      // 1f: dup
      // 20: invokespecial com/google/firebase/zza.<init> ()V
      // 23: invokevirtual com/google/android/gms/common/api/internal/zzk.a (Lcom/google/android/gms/common/api/internal/zzl;)V
      // 26: aload 2
      // 27: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 2a: astore 2
      // 2b: aload 0
      // 2c: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 2f: ifnonnull d1
      // 32: getstatic com/google/firebase/FirebaseApp.g Ljava/lang/Object;
      // 35: astore 5
      // 37: aload 5
      // 39: monitorenter
      // 3a: getstatic com/google/firebase/FirebaseApp.a Ljava/util/Map;
      // 3d: aload 2
      // 3e: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 43: ifne d9
      // 46: bipush 1
      // 47: istore 4
      // 49: aload 2
      // 4a: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 4d: invokevirtual java/lang/String.length ()I
      // 50: istore 3
      // 51: new java/lang/StringBuilder
      // 54: astore 6
      // 56: aload 6
      // 58: iload 3
      // 59: bipush 33
      // 5b: iadd
      // 5c: invokespecial java/lang/StringBuilder.<init> (I)V
      // 5f: iload 4
      // 61: aload 6
      // 63: ldc "FirebaseApp name "
      // 65: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 68: aload 2
      // 69: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 6c: ldc " already exists!"
      // 6e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 71: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 74: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 77: aload 0
      // 78: ldc "Application context cannot be null."
      // 7a: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 7d: pop
      // 7e: new com/google/firebase/FirebaseApp
      // 81: astore 6
      // 83: aload 6
      // 85: aload 0
      // 86: aload 2
      // 87: aload 1
      // 88: invokespecial com/google/firebase/FirebaseApp.<init> (Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/FirebaseOptions;)V
      // 8b: getstatic com/google/firebase/FirebaseApp.a Ljava/util/Map;
      // 8e: aload 2
      // 8f: aload 6
      // 91: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 96: pop
      // 97: aload 5
      // 99: monitorexit
      // 9a: aload 6
      // 9c: invokestatic com/google/firebase/internal/zzb.a (Lcom/google/firebase/FirebaseApp;)V
      // 9f: aload 6
      // a1: ldc com/google/firebase/FirebaseApp
      // a3: aload 6
      // a5: getstatic com/google/firebase/FirebaseApp.b Ljava/util/List;
      // a8: invokespecial com/google/firebase/FirebaseApp.a (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Iterable;)V
      // ab: aload 6
      // ad: invokevirtual com/google/firebase/FirebaseApp.e ()Z
      // b0: ifeq ce
      // b3: aload 6
      // b5: ldc com/google/firebase/FirebaseApp
      // b7: aload 6
      // b9: getstatic com/google/firebase/FirebaseApp.c Ljava/util/List;
      // bc: invokespecial com/google/firebase/FirebaseApp.a (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Iterable;)V
      // bf: aload 6
      // c1: ldc android/content/Context
      // c3: aload 6
      // c5: invokevirtual com/google/firebase/FirebaseApp.a ()Landroid/content/Context;
      // c8: getstatic com/google/firebase/FirebaseApp.d Ljava/util/List;
      // cb: invokespecial com/google/firebase/FirebaseApp.a (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Iterable;)V
      // ce: aload 6
      // d0: areturn
      // d1: aload 0
      // d2: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // d5: astore 0
      // d6: goto 32
      // d9: bipush 0
      // da: istore 4
      // dc: goto 49
      // df: astore 0
      // e0: aload 5
      // e2: monitorexit
      // e3: aload 0
      // e4: athrow
      // try (26 -> 30): 101 null
      // try (32 -> 71): 101 null
      // try (102 -> 104): 101 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final <T> void a(Class<T> var1, T var2, Iterable<String> var3) {
      boolean var5 = ContextCompat.b(this.h);
      if (var5) {
         FirebaseApp.zzc.b(this.h);
      }

      for (String var16 : var3) {
         label61: {
            IllegalAccessException var7;
            label60: {
               label59: {
                  label58: {
                     if (var5) {
                        try {
                           if (!e.contains(var16)) {
                              continue;
                           }
                        } catch (ClassNotFoundException var12) {
                           if (f.contains(var16)) {
                              throw new IllegalStateException(
                                 String.valueOf(var16).concat(" is missing, but is required. Check if it has been removed by Proguard.")
                              );
                           }
                           break label61;
                        } catch (NoSuchMethodException var13) {
                           throw new IllegalStateException(
                              String.valueOf(var16).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it.")
                           );
                        } catch (InvocationTargetException var14) {
                           Log.wtf("FirebaseApp", "Firebase API initialization failure.", var14);
                           continue;
                        } catch (IllegalAccessException var15) {
                           var7 = var15;
                           var17 = String.valueOf(var16);
                           if (var17.length() != 0) {
                              break label59;
                           }
                           break label58;
                        }
                     }

                     try {
                        Method var19 = Class.forName(var16).getMethod("getInstance", var1);
                        int var4 = var19.getModifiers();
                        if (Modifier.isPublic(var4) && Modifier.isStatic(var4)) {
                           var19.invoke(null, var2);
                        }
                        continue;
                     } catch (ClassNotFoundException var8) {
                        if (f.contains(var16)) {
                           throw new IllegalStateException(
                              String.valueOf(var16).concat(" is missing, but is required. Check if it has been removed by Proguard.")
                           );
                        }
                        break label61;
                     } catch (NoSuchMethodException var9) {
                        throw new IllegalStateException(String.valueOf(var16).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                     } catch (InvocationTargetException var10) {
                        Log.wtf("FirebaseApp", "Firebase API initialization failure.", var10);
                        continue;
                     } catch (IllegalAccessException var11) {
                        var7 = var11;
                        var17 = String.valueOf(var16);
                        if (var17.length() != 0) {
                           break label59;
                        }
                     }
                  }

                  var18 = new String("Failed to initialize ");
                  break label60;
               }

               var18 = "Failed to initialize ".concat(var17);
            }

            Log.wtf("FirebaseApp", var18, var7);
            continue;
         }

         Log.d("FirebaseApp", String.valueOf(var16).concat(" is not linked. Skipping initialization."));
      }
   }

   public static void a(boolean param0) {
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
      // 00: getstatic com/google/firebase/FirebaseApp.g Ljava/lang/Object;
      // 03: astore 4
      // 05: aload 4
      // 07: monitorenter
      // 08: new java/util/ArrayList
      // 0b: astore 5
      // 0d: aload 5
      // 0f: getstatic com/google/firebase/FirebaseApp.a Ljava/util/Map;
      // 12: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 17: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 1a: aload 5
      // 1c: checkcast java/util/ArrayList
      // 1f: astore 5
      // 21: aload 5
      // 23: invokevirtual java/util/ArrayList.size ()I
      // 26: istore 3
      // 27: bipush 0
      // 28: istore 1
      // 29: iload 1
      // 2a: iload 3
      // 2b: if_icmpge 61
      // 2e: aload 5
      // 30: iload 1
      // 31: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 34: astore 6
      // 36: iload 1
      // 37: bipush 1
      // 38: iadd
      // 39: istore 2
      // 3a: aload 6
      // 3c: checkcast com/google/firebase/FirebaseApp
      // 3f: astore 6
      // 41: iload 2
      // 42: istore 1
      // 43: aload 6
      // 45: getfield com/google/firebase/FirebaseApp.k Ljava/util/concurrent/atomic/AtomicBoolean;
      // 48: invokevirtual java/util/concurrent/atomic/AtomicBoolean.get ()Z
      // 4b: ifeq 29
      // 4e: aload 6
      // 50: iload 0
      // 51: invokespecial com/google/firebase/FirebaseApp.b (Z)V
      // 54: iload 2
      // 55: istore 1
      // 56: goto 29
      // 59: astore 5
      // 5b: aload 4
      // 5d: monitorexit
      // 5e: aload 5
      // 60: athrow
      // 61: aload 4
      // 63: monitorexit
      // 64: return
      // try (4 -> 16): 44 null
      // try (21 -> 25): 44 null
      // try (29 -> 32): 44 null
      // try (34 -> 41): 44 null
      // try (45 -> 47): 44 null
      // try (49 -> 51): 44 null
   }

   private final void b(boolean var1) {
      Log.d("FirebaseApp", "Notifying background state change listeners.");
      Iterator var2 = this.n.iterator();

      while (var2.hasNext()) {
         ((FirebaseApp.zza)var2.next()).a(var1);
      }
   }

   public static FirebaseApp d() {
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
      // 00: getstatic com/google/firebase/FirebaseApp.g Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/google/firebase/FirebaseApp.a Ljava/util/Map;
      // 09: ldc "[DEFAULT]"
      // 0b: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 10: checkcast com/google/firebase/FirebaseApp
      // 13: astore 2
      // 14: aload 2
      // 15: ifnonnull 56
      // 18: new java/lang/IllegalStateException
      // 1b: astore 3
      // 1c: invokestatic com/google/android/gms/common/util/zzs.a ()Ljava/lang/String;
      // 1f: astore 2
      // 20: aload 2
      // 21: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 24: invokevirtual java/lang/String.length ()I
      // 27: istore 0
      // 28: new java/lang/StringBuilder
      // 2b: astore 4
      // 2d: aload 4
      // 2f: iload 0
      // 30: bipush 116
      // 32: iadd
      // 33: invokespecial java/lang/StringBuilder.<init> (I)V
      // 36: aload 3
      // 37: aload 4
      // 39: ldc_w "Default FirebaseApp is not initialized in this process "
      // 3c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3f: aload 2
      // 40: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 43: ldc_w ". Make sure to call FirebaseApp.initializeApp(Context) first."
      // 46: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 49: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 4c: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 4f: aload 3
      // 50: athrow
      // 51: astore 2
      // 52: aload 1
      // 53: monitorexit
      // 54: aload 2
      // 55: athrow
      // 56: aload 1
      // 57: monitorexit
      // 58: aload 2
      // 59: areturn
      // try (4 -> 9): 38 null
      // try (11 -> 38): 38 null
      // try (39 -> 41): 38 null
      // try (43 -> 45): 38 null
   }

   private final void g() {
      boolean var1;
      if (!this.l.get()) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzbq.a(var1, "FirebaseApp was deleted");
   }

   private final void h() {
      this.a(FirebaseApp.class, this, b);
      if (this.e()) {
         this.a(FirebaseApp.class, this, c);
         this.a(Context.class, this.h, d);
      }
   }

   public Context a() {
      this.g();
      return this.h;
   }

   public String b() {
      this.g();
      return this.i;
   }

   public FirebaseOptions c() {
      this.g();
      return this.j;
   }

   public final boolean e() {
      return "[DEFAULT]".equals(this.b());
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (!(var1 instanceof FirebaseApp)) {
         var2 = false;
      } else {
         var2 = this.i.equals(((FirebaseApp)var1).b());
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.i.hashCode();
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("name", this.i).a("options", this.j).toString();
   }

   public interface zza {
      void a(boolean var1);
   }

   public interface zzb {
   }

   @TargetApi(24)
   static final class zzc extends BroadcastReceiver {
      private static AtomicReference<FirebaseApp.zzc> a = new AtomicReference<>();
      private final Context b;

      private zzc(Context var1) {
         this.b = var1;
      }

      private static void b(Context var0) {
         if (a.get() == null) {
            FirebaseApp.zzc var1 = new FirebaseApp.zzc(var0);
            if (a.compareAndSet(null, var1)) {
               var0.registerReceiver(var1, new IntentFilter("android.intent.action.USER_UNLOCKED"));
            }
         }
      }

      public final void onReceive(Context param1, Intent param2) {
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
         // 00: invokestatic com/google/firebase/FirebaseApp.f ()Ljava/lang/Object;
         // 03: astore 1
         // 04: aload 1
         // 05: monitorenter
         // 06: getstatic com/google/firebase/FirebaseApp.a Ljava/util/Map;
         // 09: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
         // 0e: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
         // 13: astore 2
         // 14: aload 2
         // 15: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 1a: ifeq 31
         // 1d: aload 2
         // 1e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 23: checkcast com/google/firebase/FirebaseApp
         // 26: invokestatic com/google/firebase/FirebaseApp.a (Lcom/google/firebase/FirebaseApp;)V
         // 29: goto 14
         // 2c: astore 2
         // 2d: aload 1
         // 2e: monitorexit
         // 2f: aload 2
         // 30: athrow
         // 31: aload 1
         // 32: monitorexit
         // 33: aload 0
         // 34: getfield com/google/firebase/FirebaseApp$zzc.b Landroid/content/Context;
         // 37: aload 0
         // 38: invokevirtual android/content/Context.unregisterReceiver (Landroid/content/BroadcastReceiver;)V
         // 3b: return
         // try (4 -> 8): 16 null
         // try (8 -> 15): 16 null
         // try (17 -> 19): 16 null
         // try (21 -> 23): 16 null
      }
   }
}
