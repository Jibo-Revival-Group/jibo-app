package org.joda.time;

final class UTCDateTimeZone extends DateTimeZone {
   static final DateTimeZone b = new UTCDateTimeZone();

   public UTCDateTimeZone() {
      super("UTC");
   }

   @Override
   public String a(long var1) {
      return "UTC";
   }

   @Override
   public int b(long var1) {
      return 0;
   }

   @Override
   public int c(long var1) {
      return 0;
   }

   @Override
   public int e(long var1) {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      return var1 instanceof UTCDateTimeZone;
   }

   @Override
   public boolean f() {
      return true;
   }

   @Override
   public long g(long var1) {
      return var1;
   }

   @Override
   public long h(long var1) {
      return var1;
   }

   @Override
   public int hashCode() {
      return this.e().hashCode();
   }
}
