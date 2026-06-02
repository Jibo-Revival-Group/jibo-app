package com.amazonaws.util;

import com.jibo.aws.integration.util.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimingInfoFullSupport extends TimingInfo {
   private final Map<String, Number> countersByName;
   private final Map<String, List<TimingInfo>> subMeasurementsByName = new HashMap<>();

   TimingInfoFullSupport(Long var1, long var2, Long var4) {
      super(var1, var2, var4);
      this.countersByName = new HashMap<>();
   }

   @Override
   public void addSubMeasurement(String var1, TimingInfo var2) {
      List var4 = this.subMeasurementsByName.get(var1);
      List var3 = var4;
      if (var4 == null) {
         var3 = new ArrayList();
         this.subMeasurementsByName.put(var1, var3);
      }

      if (var2.isEndTimeKnown()) {
         var3.add(var2);
      } else {
         a.a(this.getClass().getSimpleName(), "Skip submeasurement timing info with no end time for " + var1);
      }
   }

   @Override
   public Map<String, Number> getAllCounters() {
      return this.countersByName;
   }

   @Override
   public Number getCounter(String var1) {
      return this.countersByName.get(var1);
   }

   @Override
   public Map<String, List<TimingInfo>> getSubMeasurementsByName() {
      return this.subMeasurementsByName;
   }

   @Override
   public void incrementCounter(String var1) {
      int var2 = 0;
      Number var3 = this.getCounter(var1);
      if (var3 != null) {
         var2 = var3.intValue();
      }

      this.setCounter(var1, var2 + 1);
   }

   @Override
   public void setCounter(String var1, long var2) {
      this.countersByName.put(var1, var2);
   }
}
