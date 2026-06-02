package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zza;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
   private final MapView.zzb a;

   public MapView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a = new MapView.zzb(this, var1, GoogleMapOptions.a(var1, var2));
      this.setClickable(true);
   }

   public MapView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = new MapView.zzb(this, var1, GoogleMapOptions.a(var1, var2));
      this.setClickable(true);
   }

   static final class zzb extends zza<Object> {
      private final ViewGroup a;
      private final Context b;
      private final GoogleMapOptions c;
      private final List<Object> d = new ArrayList<>();

      zzb(ViewGroup var1, Context var2, GoogleMapOptions var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
