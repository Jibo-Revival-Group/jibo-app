package com.segment.analytics;

import android.app.Activity;
import android.os.Bundle;
import com.segment.analytics.integrations.AliasPayload;
import com.segment.analytics.integrations.GroupPayload;
import com.segment.analytics.integrations.IdentifyPayload;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.ScreenPayload;
import com.segment.analytics.integrations.TrackPayload;
import com.segment.analytics.internal.Utils;

abstract class IntegrationOperation {
   static final IntegrationOperation FLUSH = new IntegrationOperation() {
      @Override
      void run(String var1, Integration<?> var2, ProjectSettings var3) {
         var2.flush();
      }

      @Override
      public String toString() {
         return "Flush";
      }
   };
   static final IntegrationOperation RESET = new IntegrationOperation() {
      @Override
      void run(String var1, Integration<?> var2, ProjectSettings var3) {
         var2.reset();
      }

      @Override
      public String toString() {
         return "Reset";
      }
   };

   private IntegrationOperation() {
   }

   static IntegrationOperation alias(AliasPayload var0) {
      return new IntegrationOperation(var0) {
         final AliasPayload val$aliasPayload;

         {
            this.val$aliasPayload = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            if (isIntegrationEnabled(this.val$aliasPayload.integrations(), var1)) {
               var2.alias(this.val$aliasPayload);
            }
         }

         @Override
         public String toString() {
            return this.val$aliasPayload.toString();
         }
      };
   }

   static IntegrationOperation group(GroupPayload var0) {
      return new IntegrationOperation(var0) {
         final GroupPayload val$groupPayload;

         {
            this.val$groupPayload = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            if (isIntegrationEnabled(this.val$groupPayload.integrations(), var1)) {
               var2.group(this.val$groupPayload);
            }
         }

         @Override
         public String toString() {
            return this.val$groupPayload.toString();
         }
      };
   }

   static IntegrationOperation identify(IdentifyPayload var0) {
      return new IntegrationOperation(var0) {
         final IdentifyPayload val$identifyPayload;

         {
            this.val$identifyPayload = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            if (isIntegrationEnabled(this.val$identifyPayload.integrations(), var1)) {
               var2.identify(this.val$identifyPayload);
            }
         }

         @Override
         public String toString() {
            return this.val$identifyPayload.toString();
         }
      };
   }

   static boolean isIntegrationEnabled(ValueMap var0, String var1) {
      boolean var3 = true;
      boolean var2;
      if (Utils.isNullOrEmpty(var0)) {
         var2 = var3;
      } else {
         var2 = var3;
         if (!"Segment.io".equals(var1)) {
            if (var0.containsKey(var1)) {
               var2 = var0.getBoolean(var1, true);
            } else {
               var2 = var3;
               if (var0.containsKey("All")) {
                  var2 = var0.getBoolean("All", true);
               }
            }
         }
      }

      return var2;
   }

   static IntegrationOperation onActivityCreated(Activity var0, Bundle var1) {
      return new IntegrationOperation(var0, var1) {
         final Activity val$activity;
         final Bundle val$bundle;

         {
            this.val$activity = var1;
            this.val$bundle = var2;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivityCreated(this.val$activity, this.val$bundle);
         }

         @Override
         public String toString() {
            return "Activity Created";
         }
      };
   }

   static IntegrationOperation onActivityDestroyed(Activity var0) {
      return new IntegrationOperation(var0) {
         final Activity val$activity;

         {
            this.val$activity = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivityDestroyed(this.val$activity);
         }

         @Override
         public String toString() {
            return "Activity Destroyed";
         }
      };
   }

   static IntegrationOperation onActivityPaused(Activity var0) {
      return new IntegrationOperation(var0) {
         final Activity val$activity;

         {
            this.val$activity = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivityPaused(this.val$activity);
         }

         @Override
         public String toString() {
            return "Activity Paused";
         }
      };
   }

   static IntegrationOperation onActivityResumed(Activity var0) {
      return new IntegrationOperation(var0) {
         final Activity val$activity;

         {
            this.val$activity = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivityResumed(this.val$activity);
         }

         @Override
         public String toString() {
            return "Activity Resumed";
         }
      };
   }

   static IntegrationOperation onActivitySaveInstanceState(Activity var0, Bundle var1) {
      return new IntegrationOperation(var0, var1) {
         final Activity val$activity;
         final Bundle val$bundle;

         {
            this.val$activity = var1;
            this.val$bundle = var2;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivitySaveInstanceState(this.val$activity, this.val$bundle);
         }

         @Override
         public String toString() {
            return "Activity Save Instance";
         }
      };
   }

   static IntegrationOperation onActivityStarted(Activity var0) {
      return new IntegrationOperation(var0) {
         final Activity val$activity;

         {
            this.val$activity = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivityStarted(this.val$activity);
         }

         @Override
         public String toString() {
            return "Activity Started";
         }
      };
   }

   static IntegrationOperation onActivityStopped(Activity var0) {
      return new IntegrationOperation(var0) {
         final Activity val$activity;

         {
            this.val$activity = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            var2.onActivityStopped(this.val$activity);
         }

         @Override
         public String toString() {
            return "Activity Stopped";
         }
      };
   }

   static IntegrationOperation screen(ScreenPayload var0) {
      return new IntegrationOperation(var0) {
         final ScreenPayload val$screenPayload;

         {
            this.val$screenPayload = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            if (isIntegrationEnabled(this.val$screenPayload.integrations(), var1)) {
               var2.screen(this.val$screenPayload);
            }
         }

         @Override
         public String toString() {
            return this.val$screenPayload.toString();
         }
      };
   }

   static IntegrationOperation track(TrackPayload var0) {
      return new IntegrationOperation(var0) {
         final TrackPayload val$trackPayload;

         {
            this.val$trackPayload = var1;
         }

         @Override
         public void run(String var1, Integration<?> var2, ProjectSettings var3) {
            ValueMap var4 = this.val$trackPayload.integrations();
            ValueMap var6 = var3.trackingPlan();
            if (Utils.isNullOrEmpty(var6)) {
               if (isIntegrationEnabled(var4, var1)) {
                  var2.track(this.val$trackPayload);
               }
            } else {
               ValueMap var5 = var6.getValueMap(this.val$trackPayload.event());
               if (Utils.isNullOrEmpty(var5)) {
                  if (!Utils.isNullOrEmpty(var4)) {
                     if (isIntegrationEnabled(var4, var1)) {
                        var2.track(this.val$trackPayload);
                     }
                  } else {
                     var6 = var6.getValueMap("__default");
                     if (Utils.isNullOrEmpty(var6)) {
                        var2.track(this.val$trackPayload);
                     } else if (var6.getBoolean("enabled", true) || "Segment.io".equals(var1)) {
                        var2.track(this.val$trackPayload);
                     }
                  }
               } else if (!var5.getBoolean("enabled", true)) {
                  if ("Segment.io".equals(var1)) {
                     var2.track(this.val$trackPayload);
                  }
               } else {
                  var6 = new ValueMap();
                  var5 = var5.getValueMap("integrations");
                  if (!Utils.isNullOrEmpty(var5)) {
                     var6.putAll(var5);
                  }

                  var6.putAll(var4);
                  if (isIntegrationEnabled(var6, var1)) {
                     var2.track(this.val$trackPayload);
                  }
               }
            }
         }

         @Override
         public String toString() {
            return this.val$trackPayload.toString();
         }
      };
   }

   abstract void run(String var1, Integration<?> var2, ProjectSettings var3);
}
