package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification extends zzbfm implements ReflectedParcelable {
   public static final Creator<PasswordSpecification> CREATOR = new zzj();
   public static final PasswordSpecification a = new PasswordSpecification.zza()
      .a(12, 16)
      .a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789")
      .a("abcdefghijkmnopqrstxyz", 1)
      .a("ABCDEFGHJKLMNPQRSTXY", 1)
      .a("3456789", 1)
      .a();
   private static PasswordSpecification b = new PasswordSpecification.zza()
      .a(12, 16)
      .a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890")
      .a("abcdefghijklmnopqrstuvwxyz", 1)
      .a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1)
      .a("1234567890", 1)
      .a();
   private String c;
   private List<String> d;
   private List<Integer> e;
   private int f;
   private int g;
   private final int[] h;
   private final Random i;

   PasswordSpecification(String var1, List<String> var2, List<Integer> var3, int var4, int var5) {
      this.c = var1;
      this.d = Collections.unmodifiableList(var2);
      this.e = Collections.unmodifiableList(var3);
      this.f = var4;
      this.g = var5;
      int[] var7 = new int[95];
      Arrays.fill(var7, -1);
      Iterator var9 = this.d.iterator();

      for (int var10 = 0; var9.hasNext(); var10++) {
         char[] var8 = ((String)var9.next()).toCharArray();
         int var6 = var8.length;

         for (int var11 = 0; var11 < var6; var11++) {
            var7[var8[var11] - ' '] = var10;
         }
      }

      this.h = var7;
      this.i = new SecureRandom();
   }

   private static String b(Collection<Character> var0) {
      char[] var2 = new char[var0.size()];
      Iterator var3 = var0.iterator();

      for (int var1 = 0; var3.hasNext(); var1++) {
         var2[var1] = (Character)var3.next();
      }

      return new String(var2);
   }

   private static boolean b(int var0, int var1, int var2) {
      boolean var3;
      if (var0 >= 32 && var0 <= 126) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.c, false);
      zzbfp.b(var1, 2, this.d, false);
      zzbfp.a(var1, 3, this.e, false);
      zzbfp.a(var1, 4, this.f);
      zzbfp.a(var1, 5, this.g);
      zzbfp.a(var1, var2);
   }

   public static final class zza {
      private final TreeSet<Character> a = new TreeSet<>();
      private final List<String> b = new ArrayList<>();
      private final List<Integer> c = new ArrayList<>();
      private int d = 12;
      private int e = 16;

      private static TreeSet<Character> a(String var0, String var1) {
         if (TextUtils.isEmpty(var0)) {
            throw new PasswordSpecification.zzb(String.valueOf(var1).concat(" cannot be null or empty"));
         }

         TreeSet var5 = new TreeSet();

         for (char var2 : var0.toCharArray()) {
            if (PasswordSpecification.a(var2, 32, 126)) {
               throw new PasswordSpecification.zzb(String.valueOf(var1).concat(" must only contain ASCII printable characters"));
            }

            var5.add(var2);
         }

         return var5;
      }

      public final PasswordSpecification.zza a(int var1, int var2) {
         this.d = 12;
         this.e = 16;
         return this;
      }

      public final PasswordSpecification.zza a(String var1) {
         this.a.addAll(a(var1, "allowedChars"));
         return this;
      }

      public final PasswordSpecification.zza a(String var1, int var2) {
         TreeSet var3 = a(var1, "requiredChars");
         this.b.add(PasswordSpecification.b(var3));
         this.c.add(1);
         return this;
      }

      public final PasswordSpecification a() {
         if (this.a.isEmpty()) {
            throw new PasswordSpecification.zzb("no allowed characters specified");
         }

         Iterator var4 = this.c.iterator();
         int var2 = 0;

         while (var4.hasNext()) {
            var2 += var4.next();
         }

         if (var2 > this.e) {
            throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
         }

         boolean[] var8 = new boolean[95];
         Iterator var5 = this.b.iterator();

         while (var5.hasNext()) {
            for (char var1 : ((String)var5.next()).toCharArray()) {
               if (var8[var1 - ' ']) {
                  throw new PasswordSpecification.zzb(
                     new StringBuilder(58).append("character ").append(var1).append(" occurs in more than one required character set").toString()
                  );
               }

               var8[var1 - ' '] = true;
            }
         }

         return new PasswordSpecification(PasswordSpecification.b(this.a), this.b, this.c, this.d, this.e);
      }
   }

   public static final class zzb extends Error {
      public zzb(String var1) {
         super(var1);
      }
   }
}
