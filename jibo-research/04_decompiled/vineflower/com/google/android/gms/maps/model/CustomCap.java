package com.google.android.gms.maps.model;

public final class CustomCap extends Cap {
   public final BitmapDescriptor a;
   public final float b;

   @Override
   public final String toString() {
      String var2 = String.valueOf(this.a);
      float var1 = this.b;
      return new StringBuilder(String.valueOf(var2).length() + 55)
         .append("[CustomCap: bitmapDescriptor=")
         .append(var2)
         .append(" refWidth=")
         .append(var1)
         .append("]")
         .toString();
   }
}
