package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class SignInConfiguration extends zzbfm implements ReflectedParcelable {
   public static final Creator<SignInConfiguration> CREATOR = new zzx();
   private final String a;
   private GoogleSignInOptions b;

   public SignInConfiguration(String var1, GoogleSignInOptions var2) {
      this.a = zzbq.a(var1);
      this.b = var2;
   }

   public final GoogleSignInOptions a() {
      return this.b;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else {
         try {
            var1 = var1;
         } catch (ClassCastException var8) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         label49: {
            label50: {
               try {
                  if (!this.a.equals(var1.a)) {
                     return var2;
                  }

                  if (this.b != null) {
                     break label50;
                  }
               } catch (ClassCastException var7) {
                  var2 = var3;
                  return var2;
               }

               var2 = var3;

               try {
                  if (var1.b != null) {
                     return var2;
                  }
                  break label49;
               } catch (ClassCastException var6) {
                  var2 = var3;
                  return var2;
               }
            }

            boolean var4;
            try {
               var4 = this.b.equals(var1.b);
            } catch (ClassCastException var5) {
               var2 = var3;
               return var2;
            }

            var2 = var3;
            if (!var4) {
               return var2;
            }
         }

         var2 = true;
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return new zzp().a(this.a).a(this.b).a();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 2, this.a, false);
      zzbfp.a(var1, 5, this.b, var2, false);
      zzbfp.a(var1, var3);
   }
}
