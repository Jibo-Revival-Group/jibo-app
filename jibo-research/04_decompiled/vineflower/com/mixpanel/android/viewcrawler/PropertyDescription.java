package com.mixpanel.android.viewcrawler;

class PropertyDescription {
   public final String a;
   public final Class<?> b;
   public final Caller c;
   private final String d;

   public PropertyDescription(String var1, Class<?> var2, Caller var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public Caller a(Object[] var1) throws NoSuchMethodException {
      Caller var2;
      if (this.d == null) {
         var2 = null;
      } else {
         var2 = new Caller(this.b, this.d, var1, void.class);
      }

      return var2;
   }

   @Override
   public String toString() {
      return "[PropertyDescription " + this.a + "," + this.b + ", " + this.c + "/" + this.d + "]";
   }
}
