package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public final class zzd extends zzav implements AutocompletePrediction {
   public zzd(DataHolder var1, int var2) {
      super(var1, var2);
   }

   private final String b() {
      return this.a("ap_description", "");
   }

   private final List<zzb> c() {
      return this.a("ap_matched_subscriptions", zzb.CREATOR, Collections.emptyList());
   }

   @Override
   public final CharSequence a(CharacterStyle var1) {
      return zzg.a(this.b(), this.c(), var1);
   }

   @Override
   public final String a() {
      return this.a("ap_place_id", (String)null);
   }
}
