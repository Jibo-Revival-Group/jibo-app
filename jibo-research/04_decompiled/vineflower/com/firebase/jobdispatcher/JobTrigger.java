package com.firebase.jobdispatcher;

import java.util.List;

public class JobTrigger {
   public static final class ContentUriTrigger extends JobTrigger {
      private final List<ObservedUri> a;

      ContentUriTrigger(List<ObservedUri> var1) {
         this.a = var1;
      }

      public List<ObservedUri> a() {
         return this.a;
      }
   }

   public static final class ExecutionWindowTrigger extends JobTrigger {
      private final int a;
      private final int b;

      ExecutionWindowTrigger(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }
   }

   public static final class ImmediateTrigger extends JobTrigger {
      ImmediateTrigger() {
      }
   }
}
