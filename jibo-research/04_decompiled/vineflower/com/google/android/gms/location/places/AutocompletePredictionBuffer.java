package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.location.places.internal.zzd;

public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
   public AutocompletePredictionBuffer(DataHolder var1) {
      super(var1);
   }

   @Override
   public Status a() {
      return PlacesStatusCodes.c(this.a.b());
   }

   public AutocompletePrediction b(int var1) {
      return new zzd(this.a, var1);
   }

   @Override
   public String toString() {
      return zzbg.a(this).a("status", this.a()).toString();
   }
}
