package com.amazonaws.util;

final class TimingInfoUnmodifiable extends TimingInfo {
   TimingInfoUnmodifiable(Long var1, long var2, Long var4) {
      super(var1, var2, var4);
   }

   @Override
   public TimingInfo endTiming() {
      throw new UnsupportedOperationException();
   }
}
