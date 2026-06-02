package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.List;

public final class zzg {
   public static CharSequence a(String var0, List<zzb> var1, CharacterStyle var2) {
      if (var2 != null) {
         var0 = new SpannableString((CharSequence)var0);

         for (zzb var6 : var1) {
            CharacterStyle var7 = CharacterStyle.wrap(var2);
            int var4 = var6.a;
            int var3 = var6.a;
            var0.setSpan(var7, var4, var6.b + var3, 0);
         }
      }

      return (CharSequence)var0;
   }
}
