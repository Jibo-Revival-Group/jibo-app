package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class CameraPosition extends zzbfm implements ReflectedParcelable {
   public static final Creator<CameraPosition> CREATOR = new zza();
   public final LatLng a;
   public final float b;
   public final float c;
   public final float d;

   public CameraPosition(LatLng var1, float var2, float var3, float var4) {
      zzbq.a(var1, "null camera target");
      boolean var5;
      if (0.0F <= var3 && var3 <= 90.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      zzbq.b(var5, "Tilt needs to be between 0 and 90 inclusive: %s", var3);
      this.a = var1;
      this.b = var2;
      this.c = var3 + 0.0F;
      var2 = var4;
      if (var4 <= 0.0) {
         var2 = var4 % 360.0F + 360.0F;
      }

      this.d = var2 % 360.0F;
   }

   public static CameraPosition.Builder a() {
      return new CameraPosition.Builder();
   }

   public static CameraPosition a(Context var0, AttributeSet var1) {
      CameraPosition var5;
      if (var1 == null) {
         var5 = null;
      } else {
         TypedArray var4 = var0.getResources().obtainAttributes(var1, R.styleable.MapAttrs);
         float var2;
         if (var4.hasValue(R.styleable.MapAttrs_cameraTargetLat)) {
            var2 = var4.getFloat(R.styleable.MapAttrs_cameraTargetLat, 0.0F);
         } else {
            var2 = 0.0F;
         }

         float var3;
         if (var4.hasValue(R.styleable.MapAttrs_cameraTargetLng)) {
            var3 = var4.getFloat(R.styleable.MapAttrs_cameraTargetLng, 0.0F);
         } else {
            var3 = 0.0F;
         }

         LatLng var6 = new LatLng(var2, var3);
         CameraPosition.Builder var7 = a();
         var7.a(var6);
         if (var4.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            var7.a(var4.getFloat(R.styleable.MapAttrs_cameraZoom, 0.0F));
         }

         if (var4.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            var7.c(var4.getFloat(R.styleable.MapAttrs_cameraBearing, 0.0F));
         }

         if (var4.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            var7.b(var4.getFloat(R.styleable.MapAttrs_cameraTilt, 0.0F));
         }

         var5 = var7.a();
      }

      return var5;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof CameraPosition)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!this.a.equals(var1.a)
               || Float.floatToIntBits(this.b) != Float.floatToIntBits(var1.b)
               || Float.floatToIntBits(this.c) != Float.floatToIntBits(var1.c)
               || Float.floatToIntBits(this.d) != Float.floatToIntBits(var1.d)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d});
   }

   @Override
   public final String toString() {
      return zzbg.a(this).a("target", this.a).a("zoom", this.b).a("tilt", this.c).a("bearing", this.d).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, var2, false);
      zzbfp.a(var1, 3, this.b);
      zzbfp.a(var1, 4, this.c);
      zzbfp.a(var1, 5, this.d);
      zzbfp.a(var1, var3);
   }

   public static final class Builder {
      private LatLng a;
      private float b;
      private float c;
      private float d;

      public final CameraPosition.Builder a(float var1) {
         this.b = var1;
         return this;
      }

      public final CameraPosition.Builder a(LatLng var1) {
         this.a = var1;
         return this;
      }

      public final CameraPosition a() {
         return new CameraPosition(this.a, this.b, this.c, this.d);
      }

      public final CameraPosition.Builder b(float var1) {
         this.c = var1;
         return this;
      }

      public final CameraPosition.Builder c(float var1) {
         this.d = var1;
         return this;
      }
   }
}
