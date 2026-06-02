package io.fabric.sdk.android.services.concurrency;

public enum Priority {
   HIGH,
   IMMEDIATE,
   LOW,
   NORMAL;

   private static final Priority[] $VALUES = new Priority[]{Priority.LOW, Priority.NORMAL, Priority.HIGH, Priority.IMMEDIATE};

   static <Y> int compareTo(PriorityProvider var0, Y var1) {
      Priority var2;
      if (var1 instanceof PriorityProvider) {
         var2 = ((PriorityProvider)var1).b();
      } else {
         var2 = NORMAL;
      }

      return var2.ordinal() - var0.b().ordinal();
   }
}
