package com.mixpanel.android.viewcrawler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.mixpanel.android.util.MPLog;

class FlipGesture implements SensorEventListener {
   private int a = -1;
   private int b = 0;
   private long c = -1L;
   private final float[] d = new float[3];
   private final FlipGesture.OnFlipGestureListener e;

   public FlipGesture(FlipGesture.OnFlipGestureListener var1) {
      this.e = var1;
   }

   private float[] a(float[] var1) {
      for (int var3 = 0; var3 < 3; var3++) {
         float var2 = this.d[var3];
         this.d[var3] = var2 + 0.7F * (var1[var3] - var2);
      }

      return this.d;
   }

   public void onAccuracyChanged(Sensor var1, int var2) {
   }

   public void onSensorChanged(SensorEvent var1) {
      float[] var6 = this.a(var1.values);
      int var3 = this.b;
      float var2 = var6[0] * var6[0] + var6[1] * var6[1] + var6[2] * var6[2];
      this.b = 0;
      if (var6[2] > 7.8F && var6[2] < 11.8F) {
         this.b = -1;
      }

      if (var6[2] < -7.8F && var6[2] > -11.8F) {
         this.b = 1;
      }

      if (var2 < 60.840004F || var2 > 139.24F) {
         this.b = 0;
      }

      if (var3 != this.b) {
         this.c = var1.timestamp;
      }

      long var4 = var1.timestamp - this.c;
      switch (this.b) {
         case -1:
            if (var4 > 250000000L && this.a == 1) {
               MPLog.a("MixpanelAPI.FlipGesture", "Flip gesture completed");
               this.a = 0;
               this.e.a();
            }
            break;
         case 0:
            if (var4 > 1000000000L && this.a != 0) {
               MPLog.a("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
               this.a = 0;
            }
            break;
         case 1:
            if (var4 > 250000000L && this.a == 0) {
               MPLog.a("MixpanelAPI.FlipGesture", "Flip gesture begun");
               this.a = 1;
            }
      }
   }

   public interface OnFlipGestureListener {
      void a();
   }
}
