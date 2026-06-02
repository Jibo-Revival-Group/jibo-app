package com.firebase.jobdispatcher;

import java.util.List;

public final class Trigger {
   public static final JobTrigger.ImmediateTrigger a = new JobTrigger.ImmediateTrigger();

   public static JobTrigger.ContentUriTrigger a(List<ObservedUri> var0) {
      if (var0 != null && !var0.isEmpty()) {
         return new JobTrigger.ContentUriTrigger(var0);
      } else {
         throw new IllegalArgumentException("Uris must not be null or empty.");
      }
   }

   public static JobTrigger.ExecutionWindowTrigger a(int var0, int var1) {
      if (var0 < 0) {
         throw new IllegalArgumentException("Window start can't be less than 0");
      } else if (var1 < var0) {
         throw new IllegalArgumentException("Window end can't be less than window start");
      } else {
         return new JobTrigger.ExecutionWindowTrigger(var0, var1);
      }
   }
}
