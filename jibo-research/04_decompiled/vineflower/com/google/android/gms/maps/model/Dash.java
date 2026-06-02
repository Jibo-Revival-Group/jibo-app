package com.google.android.gms.maps.model;

public final class Dash extends PatternItem {
   public final float a;

   @Override
   public final String toString() {
      float var1 = this.a;
      return new StringBuilder(30).append("[Dash: length=").append(var1).append("]").toString();
   }
}
