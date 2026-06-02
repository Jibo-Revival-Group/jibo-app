package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zza;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
   private final StreetViewPanoramaView.zzb a;

   public StreetViewPanoramaView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a = new StreetViewPanoramaView.zzb(this, var1, null);
   }

   public StreetViewPanoramaView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = new StreetViewPanoramaView.zzb(this, var1, null);
   }

   static final class zzb extends zza<Object> {
      private final ViewGroup a;
      private final Context b;
      private final StreetViewPanoramaOptions c;
      private final List<Object> d = new ArrayList<>();

      zzb(ViewGroup var1, Context var2, StreetViewPanoramaOptions var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
