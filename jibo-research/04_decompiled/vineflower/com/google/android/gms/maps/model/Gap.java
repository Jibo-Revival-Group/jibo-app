package com.google.android.gms.maps.model;

public final class Gap extends PatternItem {
   public final float a;

   @Override
   public final String toString() {
      float var1 = this.a;
      return new StringBuilder(29).append("[Gap: length=").append(var1).append("]").toString();
   }
}
