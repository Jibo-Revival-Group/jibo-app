package com.salesforce.androidsdk.analytics.transform;

import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.model.DeviceAppAttributes;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class AILTNTransform implements Transform {
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private JSONObject b(InstrumentationEvent var1) {
      JSONObject var2 = new JSONObject();

      label35: {
         DeviceAppAttributes var3;
         try {
            var3 = var1.m();
         } catch (JSONException var6) {
            var7 = var6;
            break label35;
         }

         if (var3 != null) {
            try {
               var8 = var3.a();
            } catch (JSONException var5) {
               var7 = var5;
               break label35;
            }

            var2 = var8;
         }

         try {
            var2.put("connectionType", var1.n());
            return var2;
         } catch (JSONException var4) {
            var7 = var4;
         }
      }

      SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var7);
      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private JSONObject c(InstrumentationEvent var1) {
      JSONObject var5 = new JSONObject();

      InstrumentationEvent.SchemaType var6;
      long var31;
      try {
         var5.put("version", "0.2");
         var6 = var1.j();
         var5.put("schemaType", var6.name());
         var5.put("id", var1.a());
         var5.put("eventSource", var1.d());
         var31 = var1.b();
         var5.put("ts", var31);
         var5.put("pageStartTime", var1.p());
         var31 = var1.c() - var31;
      } catch (JSONException var29) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var29);
         return null;
      }

      label205:
      if (var31 > 0L) {
         label214: {
            try {
               if (var6 == InstrumentationEvent.SchemaType.LightningInteraction || var6 == InstrumentationEvent.SchemaType.LightningPerformance) {
                  break label214;
               }
            } catch (JSONException var28) {
               SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var28);
               return null;
            }

            try {
               if (var6 == InstrumentationEvent.SchemaType.LightningPageView) {
                  var5.put("ept", var31);
               }
               break label205;
            } catch (JSONException var27) {
               SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var27);
               return null;
            }
         }

         try {
            var5.put("duration", var31);
         } catch (JSONException var26) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var26);
            return null;
         }
      }

      try {
         String var4 = var1.f();
         if (!TextUtils.isEmpty(var4)) {
            var5.put("clientSessionId", var4);
         }
      } catch (JSONException var25) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var25);
         return null;
      }

      try {
         if (var6 != InstrumentationEvent.SchemaType.LightningPerformance) {
            var5.put("sequence", var1.g());
         }
      } catch (JSONException var24) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var24);
         return null;
      }

      JSONObject var32;
      try {
         var32 = var1.e();
      } catch (JSONException var23) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var23);
         return null;
      }

      if (var32 != null) {
         try {
            var5.put("attributes", var32);
         } catch (JSONException var22) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var22);
            return null;
         }
      }

      try {
         if (var6 != InstrumentationEvent.SchemaType.LightningPerformance) {
            var5.put("page", var1.q());
         }
      } catch (JSONException var21) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var21);
         return null;
      }

      try {
         var32 = var1.r();
      } catch (JSONException var20) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var20);
         return null;
      }

      if (var32 != null) {
         try {
            if (var6 == InstrumentationEvent.SchemaType.LightningPageView) {
               var5.put("previousPage", var32);
            }
         } catch (JSONException var19) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var19);
            return null;
         }
      }

      try {
         var32 = var1.s();
      } catch (JSONException var18) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var18);
         return null;
      }

      label156:
      if (var32 != null) {
         try {
            if (var6 != InstrumentationEvent.SchemaType.LightningPageView && var6 != InstrumentationEvent.SchemaType.LightningPerformance) {
               break label156;
            }
         } catch (JSONException var17) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var17);
            return null;
         }

         try {
            var5.put("marks", var32);
         } catch (JSONException var16) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var16);
            return null;
         }
      }

      label215: {
         try {
            if (var6 != InstrumentationEvent.SchemaType.LightningInteraction && var6 != InstrumentationEvent.SchemaType.LightningPageView) {
               break label215;
            }
         } catch (JSONException var15) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var15);
            return null;
         }

         try {
            var32 = this.d(var1);
         } catch (JSONException var14) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var14);
            return null;
         }

         if (var32 != null) {
            try {
               var5.put("locator", var32);
            } catch (JSONException var13) {
               SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var13);
               return null;
            }
         }
      }

      label132: {
         label216: {
            try {
               var32 = var1.k();
               if (var6 == InstrumentationEvent.SchemaType.LightningPerformance) {
                  break label216;
               }
            } catch (JSONException var12) {
               SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var12);
               return null;
            }

            label125: {
               try {
                  if (var6 != InstrumentationEvent.SchemaType.LightningInteraction) {
                     break label125;
                  }
               } catch (JSONException var11) {
                  SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var11);
                  return null;
               }

               if (var32 != null) {
                  try {
                     var32 = var32.name();
                     break label132;
                  } catch (JSONException var10) {
                     SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var10);
                     return null;
                  }
               }
            }

            var32 = null;
            break label132;
         }

         var32 = "defs";
      }

      try {
         if (!TextUtils.isEmpty(var32)) {
            var5.put("eventType", var32);
         }
      } catch (JSONException var9) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var9);
         return null;
      }

      try {
         var32 = var1.l();
      } catch (JSONException var8) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var8);
         return null;
      }

      JSONObject var30 = var5;
      if (var32 != null) {
         JSONObject var39 = var5;

         try {
            if (var6 != InstrumentationEvent.SchemaType.LightningError) {
               return var39;
            }

            var5.put("errorType", var32.name());
         } catch (JSONException var7) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var7);
            Object var40 = null;
            return (JSONObject)var40;
         }

         var30 = var5;
      }

      return var30;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private JSONObject d(InstrumentationEvent var1) {
      Object var4 = null;
      JSONObject var3 = new JSONObject();

      String var5;
      String var6;
      try {
         var6 = var1.h();
         var5 = var1.o();
      } catch (JSONException var10) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var10);
         return null;
      }

      Object var2 = var4;

      try {
         if (TextUtils.isEmpty(var6)) {
            return (JSONObject)var2;
         }

         if (TextUtils.isEmpty(var5)) {
            return (JSONObject)var4;
         }
      } catch (JSONException var9) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var9);
         return null;
      }

      try {
         var3.put("target", var6);
         var3.put("scope", var5);
         var12 = var1.i();
      } catch (JSONException var8) {
         SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var8);
         return null;
      }

      JSONObject var11 = var3;
      if (var12 != null) {
         try {
            var3.put("context", var12);
         } catch (JSONException var7) {
            SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var7);
            Object var14 = null;
            return (JSONObject)var14;
         }

         var11 = var3;
      }

      return var11;
   }

   @Override
   public JSONObject a(InstrumentationEvent var1) {
      Object var2 = null;
      JSONObject var5;
      if (var1 == null) {
         var5 = (JSONObject)var2;
      } else {
         JSONObject var3 = this.c(var1);
         if (var3 != null) {
            try {
               var3.put("deviceAttributes", this.b(var1));
            } catch (JSONException var4) {
               SalesforceAnalyticsLogger.a(null, "AILTNTransform", "Exception occurred while transforming JSON", var4);
               Object var6 = var2;
               return (JSONObject)var6;
            }
         }

         var5 = var3;
      }

      return var5;
   }
}
