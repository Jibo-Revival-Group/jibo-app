package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zza extends zzbfm implements AutocompletePrediction {
   public static final Creator<zza> CREATOR = new zzc();
   private static final List<zzb> a = Collections.emptyList();
   private String b;
   private String c;
   private List<Integer> d;
   private List<zzb> e;
   private int f;
   private String g;
   private List<zzb> h;
   private String i;
   private List<zzb> j;

   zza(String var1, List<Integer> var2, int var3, String var4, List<zzb> var5, String var6, List<zzb> var7, String var8, List<zzb> var9) {
      this.c = var1;
      this.d = var2;
      this.f = var3;
      this.b = var4;
      this.e = var5;
      this.g = var6;
      this.h = var7;
      this.i = var8;
      this.j = var9;
   }

   @Override
   public final CharSequence a(CharacterStyle var1) {
      return zzg.a(this.b, this.e, var1);
   }

   @Override
   public final String a() {
      return this.c;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zza)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!zzbg.a(this.c, var1.c)
               || !zzbg.a(this.d, var1.d)
               || !zzbg.a(this.f, var1.f)
               || !zzbg.a(this.b, var1.b)
               || !zzbg.a(this.e, var1.e)
               || !zzbg.a(this.g, var1.g)
               || !zzbg.a(this.h, var1.h)
               || !zzbg.a(this.i, var1.i)
               || !zzbg.a(this.j, var1.j)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.c, this.d, this.f, this.b, this.e, this.g, this.h, this.i, this.j});
   }

   @Override
   public final String toString() {
      return zzbg.a(this)
         .a("placeId", this.c)
         .a("placeTypes", this.d)
         .a("fullText", this.b)
         .a("fullTextMatchedSubstrings", this.e)
         .a("primaryText", this.g)
         .a("primaryTextMatchedSubstrings", this.h)
         .a("secondaryText", this.i)
         .a("secondaryTextMatchedSubstrings", this.j)
         .toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b, false);
      zzbfp.a(var1, 2, this.c, false);
      zzbfp.a(var1, 3, this.d, false);
      zzbfp.c(var1, 4, this.e, false);
      zzbfp.a(var1, 5, this.f);
      zzbfp.a(var1, 6, this.g, false);
      zzbfp.c(var1, 7, this.h, false);
      zzbfp.a(var1, 8, this.i, false);
      zzbfp.c(var1, 9, this.j, false);
      zzbfp.a(var1, var2);
   }
}
