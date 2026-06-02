package android.support.v4.app;

import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

public final class RemoteInput {
   private final String a;
   private final CharSequence b;
   private final CharSequence[] c;
   private final boolean d;
   private final Bundle e;
   private final Set<String> f;

   static android.app.RemoteInput a(RemoteInput var0) {
      return new Builder(var0.a()).setLabel(var0.b()).setChoices(var0.c()).setAllowFreeFormInput(var0.e()).addExtras(var0.f()).build();
   }

   static android.app.RemoteInput[] a(RemoteInput[] var0) {
      android.app.RemoteInput[] var3;
      if (var0 == null) {
         var3 = null;
      } else {
         android.app.RemoteInput[] var2 = new android.app.RemoteInput[var0.length];

         for (int var1 = 0; var1 < var0.length; var1++) {
            var2[var1] = a(var0[var1]);
         }

         var3 = var2;
      }

      return var3;
   }

   public String a() {
      return this.a;
   }

   public CharSequence b() {
      return this.b;
   }

   public CharSequence[] c() {
      return this.c;
   }

   public Set<String> d() {
      return this.f;
   }

   public boolean e() {
      return this.d;
   }

   public Bundle f() {
      return this.e;
   }
}
