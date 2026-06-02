package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.common.api.internal.zzcu;
import com.google.android.gms.common.api.internal.zzdg;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class GoogleApiClient {
   private static final Set<GoogleApiClient> a = Collections.newSetFromMap(new WeakHashMap<>());

   public static Set<GoogleApiClient> a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/common/api/GoogleApiClient.a Ljava/util/Set;
      // 03: astore 0
      // 04: aload 0
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/api/GoogleApiClient.a Ljava/util/Set;
      // 09: astore 1
      // 0a: aload 0
      // 0b: monitorexit
      // 0c: aload 1
      // 0d: areturn
      // 0e: astore 1
      // 0f: aload 0
      // 10: monitorexit
      // 11: aload 1
      // 12: athrow
      // try (4 -> 8): 10 null
      // try (11 -> 13): 10 null
   }

   public <C extends Api.zze> C a(Api.zzc<C> var1) {
      throw new UnsupportedOperationException();
   }

   public <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      throw new UnsupportedOperationException();
   }

   public void a(int var1) {
      throw new UnsupportedOperationException();
   }

   public abstract void a(GoogleApiClient.OnConnectionFailedListener var1);

   public void a(zzdg var1) {
      throw new UnsupportedOperationException();
   }

   public abstract void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

   public boolean a(zzcu var1) {
      throw new UnsupportedOperationException();
   }

   public Context b() {
      throw new UnsupportedOperationException();
   }

   public <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      throw new UnsupportedOperationException();
   }

   public abstract void b(GoogleApiClient.OnConnectionFailedListener var1);

   public void b(zzdg var1) {
      throw new UnsupportedOperationException();
   }

   public Looper c() {
      throw new UnsupportedOperationException();
   }

   public void d() {
      throw new UnsupportedOperationException();
   }

   public abstract void e();

   public abstract ConnectionResult f();

   public abstract void g();

   public abstract void h();

   public abstract PendingResult<Status> i();

   public abstract boolean j();

   public static final class Builder {
      private Account a;
      private final Set<Scope> b = new HashSet<>();
      private final Set<Scope> c = new HashSet<>();
      private int d;
      private View e;
      private String f;
      private String g;
      private final Map<Api<?>, zzt> h = new ArrayMap<>();
      private final Context i;
      private final Map<Api<?>, Api.ApiOptions> j = new ArrayMap<>();
      private zzce k;
      private int l = -1;
      private GoogleApiClient.OnConnectionFailedListener m;
      private Looper n;
      private GoogleApiAvailability o = GoogleApiAvailability.a();
      private Api.zza<? extends zzcxd, zzcxe> p = zzcxa.a;
      private final ArrayList<GoogleApiClient.ConnectionCallbacks> q = new ArrayList<>();
      private final ArrayList<GoogleApiClient.OnConnectionFailedListener> r = new ArrayList<>();
      private boolean s = false;

      public Builder(Context var1) {
         this.i = var1;
         this.n = var1.getMainLooper();
         this.f = var1.getPackageName();
         this.g = var1.getClass().getName();
      }

      public final GoogleApiClient.Builder a(Handler var1) {
         zzbq.a(var1, "Handler must not be null");
         this.n = var1.getLooper();
         return this;
      }

      public final GoogleApiClient.Builder a(Api<? extends Api.ApiOptions.NotRequiredOptions> var1) {
         zzbq.a(var1, "Api must not be null");
         this.j.put(var1, null);
         List var2 = var1.a().a(null);
         this.c.addAll(var2);
         this.b.addAll(var2);
         return this;
      }

      public final <O extends Api.ApiOptions.HasOptions> GoogleApiClient.Builder a(Api<O> var1, O var2) {
         zzbq.a(var1, "Api must not be null");
         zzbq.a(var2, "Null options are not permitted for this Api");
         this.j.put(var1, var2);
         List var3 = var1.a().a(var2);
         this.c.addAll(var3);
         this.b.addAll(var3);
         return this;
      }

      public final GoogleApiClient.Builder a(GoogleApiClient.ConnectionCallbacks var1) {
         zzbq.a(var1, "Listener must not be null");
         this.q.add(var1);
         return this;
      }

      public final GoogleApiClient.Builder a(GoogleApiClient.OnConnectionFailedListener var1) {
         zzbq.a(var1, "Listener must not be null");
         this.r.add(var1);
         return this;
      }

      public final zzr a() {
         zzcxe var1 = zzcxe.a;
         if (this.j.containsKey(zzcxa.b)) {
            var1 = (zzcxe)this.j.get(zzcxa.b);
         }

         return new zzr(this.a, this.b, this.h, this.d, this.e, this.f, this.g, var1);
      }

      public final GoogleApiClient b() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
         //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 000: aload 0
         // 001: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.j Ljava/util/Map;
         // 004: invokeinterface java/util/Map.isEmpty ()Z 1
         // 009: ifne 132
         // 00c: bipush 1
         // 00d: istore 2
         // 00e: iload 2
         // 00f: ldc "must call addApi() to add at least one API"
         // 011: invokestatic com/google/android/gms/common/internal/zzbq.b (ZLjava/lang/Object;)V
         // 014: aload 0
         // 015: invokevirtual com/google/android/gms/common/api/GoogleApiClient$Builder.a ()Lcom/google/android/gms/common/internal/zzr;
         // 018: astore 8
         // 01a: aconst_null
         // 01b: astore 3
         // 01c: aload 8
         // 01e: invokevirtual com/google/android/gms/common/internal/zzr.f ()Ljava/util/Map;
         // 021: astore 10
         // 023: new android/support/v4/util/ArrayMap
         // 026: dup
         // 027: invokespecial android/support/v4/util/ArrayMap.<init> ()V
         // 02a: astore 7
         // 02c: new android/support/v4/util/ArrayMap
         // 02f: dup
         // 030: invokespecial android/support/v4/util/ArrayMap.<init> ()V
         // 033: astore 9
         // 035: new java/util/ArrayList
         // 038: dup
         // 039: invokespecial java/util/ArrayList.<init> ()V
         // 03c: astore 11
         // 03e: aload 0
         // 03f: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.j Ljava/util/Map;
         // 042: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
         // 047: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
         // 04c: astore 6
         // 04e: bipush 0
         // 04f: istore 1
         // 050: aload 6
         // 052: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 057: ifeq 14a
         // 05a: aload 6
         // 05c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 061: checkcast com/google/android/gms/common/api/Api
         // 064: astore 5
         // 066: aload 0
         // 067: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.j Ljava/util/Map;
         // 06a: aload 5
         // 06c: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
         // 071: astore 12
         // 073: aload 10
         // 075: aload 5
         // 077: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
         // 07c: ifnull 137
         // 07f: bipush 1
         // 080: istore 2
         // 081: aload 7
         // 083: aload 5
         // 085: iload 2
         // 086: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
         // 089: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
         // 08e: pop
         // 08f: new com/google/android/gms/common/api/internal/zzt
         // 092: dup
         // 093: aload 5
         // 095: iload 2
         // 096: invokespecial com/google/android/gms/common/api/internal/zzt.<init> (Lcom/google/android/gms/common/api/Api;Z)V
         // 099: astore 13
         // 09b: aload 11
         // 09d: aload 13
         // 09f: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
         // 0a2: pop
         // 0a3: aload 5
         // 0a5: invokevirtual com/google/android/gms/common/api/Api.b ()Lcom/google/android/gms/common/api/Api$zza;
         // 0a8: astore 4
         // 0aa: aload 4
         // 0ac: aload 0
         // 0ad: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.i Landroid/content/Context;
         // 0b0: aload 0
         // 0b1: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.n Landroid/os/Looper;
         // 0b4: aload 8
         // 0b6: aload 12
         // 0b8: aload 13
         // 0ba: aload 13
         // 0bc: invokevirtual com/google/android/gms/common/api/Api$zza.a (Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/internal/zzr;Ljava/lang/Object;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)Lcom/google/android/gms/common/api/Api$zze;
         // 0bf: astore 13
         // 0c1: aload 9
         // 0c3: aload 5
         // 0c5: invokevirtual com/google/android/gms/common/api/Api.c ()Lcom/google/android/gms/common/api/Api$zzc;
         // 0c8: aload 13
         // 0ca: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
         // 0cf: pop
         // 0d0: aload 4
         // 0d2: invokevirtual com/google/android/gms/common/api/Api$zzd.a ()I
         // 0d5: bipush 1
         // 0d6: if_icmpne 23b
         // 0d9: aload 12
         // 0db: ifnull 13c
         // 0de: bipush 1
         // 0df: istore 1
         // 0e0: aload 13
         // 0e2: invokeinterface com/google/android/gms/common/api/Api$zze.c ()Z 1
         // 0e7: ifeq 141
         // 0ea: aload 5
         // 0ec: astore 4
         // 0ee: aload 3
         // 0ef: ifnull 144
         // 0f2: aload 5
         // 0f4: invokevirtual com/google/android/gms/common/api/Api.d ()Ljava/lang/String;
         // 0f7: astore 4
         // 0f9: aload 3
         // 0fa: invokevirtual com/google/android/gms/common/api/Api.d ()Ljava/lang/String;
         // 0fd: astore 3
         // 0fe: new java/lang/IllegalStateException
         // 101: dup
         // 102: new java/lang/StringBuilder
         // 105: dup
         // 106: aload 4
         // 108: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
         // 10b: invokevirtual java/lang/String.length ()I
         // 10e: bipush 21
         // 110: iadd
         // 111: aload 3
         // 112: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
         // 115: invokevirtual java/lang/String.length ()I
         // 118: iadd
         // 119: invokespecial java/lang/StringBuilder.<init> (I)V
         // 11c: aload 4
         // 11e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 121: ldc_w " cannot be used with "
         // 124: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 127: aload 3
         // 128: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 12b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 12e: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
         // 131: athrow
         // 132: bipush 0
         // 133: istore 2
         // 134: goto 00e
         // 137: bipush 0
         // 138: istore 2
         // 139: goto 081
         // 13c: bipush 0
         // 13d: istore 1
         // 13e: goto 0e0
         // 141: aload 3
         // 142: astore 4
         // 144: aload 4
         // 146: astore 3
         // 147: goto 050
         // 14a: aload 3
         // 14b: ifnull 1bc
         // 14e: iload 1
         // 14f: ifeq 183
         // 152: aload 3
         // 153: invokevirtual com/google/android/gms/common/api/Api.d ()Ljava/lang/String;
         // 156: astore 3
         // 157: new java/lang/IllegalStateException
         // 15a: dup
         // 15b: new java/lang/StringBuilder
         // 15e: dup
         // 15f: aload 3
         // 160: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
         // 163: invokevirtual java/lang/String.length ()I
         // 166: bipush 82
         // 168: iadd
         // 169: invokespecial java/lang/StringBuilder.<init> (I)V
         // 16c: ldc_w "With using "
         // 16f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 172: aload 3
         // 173: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 176: ldc_w ", GamesOptions can only be specified within GoogleSignInOptions.Builder"
         // 179: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
         // 17c: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
         // 17f: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
         // 182: athrow
         // 183: aload 0
         // 184: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.a Landroid/accounts/Account;
         // 187: ifnonnull 22f
         // 18a: bipush 1
         // 18b: istore 2
         // 18c: iload 2
         // 18d: ldc_w "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead"
         // 190: bipush 1
         // 191: anewarray 4
         // 194: dup
         // 195: bipush 0
         // 196: aload 3
         // 197: invokevirtual com/google/android/gms/common/api/Api.d ()Ljava/lang/String;
         // 19a: aastore
         // 19b: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/String;[Ljava/lang/Object;)V
         // 19e: aload 0
         // 19f: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.b Ljava/util/Set;
         // 1a2: aload 0
         // 1a3: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.c Ljava/util/Set;
         // 1a6: invokeinterface java/util/Set.equals (Ljava/lang/Object;)Z 2
         // 1ab: ldc_w "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead."
         // 1ae: bipush 1
         // 1af: anewarray 4
         // 1b2: dup
         // 1b3: bipush 0
         // 1b4: aload 3
         // 1b5: invokevirtual com/google/android/gms/common/api/Api.d ()Ljava/lang/String;
         // 1b8: aastore
         // 1b9: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/String;[Ljava/lang/Object;)V
         // 1bc: aload 9
         // 1be: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
         // 1c3: bipush 1
         // 1c4: invokestatic com/google/android/gms/common/api/internal/zzba.a (Ljava/lang/Iterable;Z)I
         // 1c7: istore 1
         // 1c8: new com/google/android/gms/common/api/internal/zzba
         // 1cb: dup
         // 1cc: aload 0
         // 1cd: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.i Landroid/content/Context;
         // 1d0: new java/util/concurrent/locks/ReentrantLock
         // 1d3: dup
         // 1d4: invokespecial java/util/concurrent/locks/ReentrantLock.<init> ()V
         // 1d7: aload 0
         // 1d8: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.n Landroid/os/Looper;
         // 1db: aload 8
         // 1dd: aload 0
         // 1de: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.o Lcom/google/android/gms/common/GoogleApiAvailability;
         // 1e1: aload 0
         // 1e2: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.p Lcom/google/android/gms/common/api/Api$zza;
         // 1e5: aload 7
         // 1e7: aload 0
         // 1e8: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.q Ljava/util/ArrayList;
         // 1eb: aload 0
         // 1ec: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.r Ljava/util/ArrayList;
         // 1ef: aload 9
         // 1f1: aload 0
         // 1f2: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.l I
         // 1f5: iload 1
         // 1f6: aload 11
         // 1f8: bipush 0
         // 1f9: invokespecial com/google/android/gms/common/api/internal/zzba.<init> (Landroid/content/Context;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/internal/zzr;Lcom/google/android/gms/common/GoogleApiAvailability;Lcom/google/android/gms/common/api/Api$zza;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;IILjava/util/ArrayList;Z)V
         // 1fc: astore 4
         // 1fe: invokestatic com/google/android/gms/common/api/GoogleApiClient.k ()Ljava/util/Set;
         // 201: astore 3
         // 202: aload 3
         // 203: monitorenter
         // 204: invokestatic com/google/android/gms/common/api/GoogleApiClient.k ()Ljava/util/Set;
         // 207: aload 4
         // 209: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
         // 20e: pop
         // 20f: aload 3
         // 210: monitorexit
         // 211: aload 0
         // 212: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.l I
         // 215: iflt 22c
         // 218: aload 0
         // 219: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.k Lcom/google/android/gms/common/api/internal/zzce;
         // 21c: invokestatic com/google/android/gms/common/api/internal/zzi.b (Lcom/google/android/gms/common/api/internal/zzce;)Lcom/google/android/gms/common/api/internal/zzi;
         // 21f: aload 0
         // 220: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.l I
         // 223: aload 4
         // 225: aload 0
         // 226: getfield com/google/android/gms/common/api/GoogleApiClient$Builder.m Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;
         // 229: invokevirtual com/google/android/gms/common/api/internal/zzi.a (ILcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)V
         // 22c: aload 4
         // 22e: areturn
         // 22f: bipush 0
         // 230: istore 2
         // 231: goto 18c
         // 234: astore 4
         // 236: aload 3
         // 237: monitorexit
         // 238: aload 4
         // 23a: athrow
         // 23b: goto 0e0
         // try (239 -> 245): 262 null
         // try (263 -> 265): 262 null
      }
   }

   public interface ConnectionCallbacks {
      void a(int var1);

      void a(Bundle var1);
   }

   public interface OnConnectionFailedListener {
      void a(ConnectionResult var1);
   }
}
