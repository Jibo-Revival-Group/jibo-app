package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.internal.zzz;

final class zzr implements TileProvider {
   private final zzz b;
   private TileOverlayOptions c;

   zzr(TileOverlayOptions var1) {
      this.c = var1;
      super();
      this.b = TileOverlayOptions.a(this.c);
   }
}
