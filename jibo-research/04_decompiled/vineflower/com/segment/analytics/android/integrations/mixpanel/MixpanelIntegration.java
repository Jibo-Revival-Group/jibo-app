package com.segment.analytics.android.integrations.mixpanel;

import android.app.Activity;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.ValueMap;
import com.segment.analytics.integrations.AliasPayload;
import com.segment.analytics.integrations.IdentifyPayload;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.integrations.ScreenPayload;
import com.segment.analytics.integrations.TrackPayload;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class MixpanelIntegration extends Integration<MixpanelAPI> {
   public static final Integration.Factory FACTORY = new Integration.Factory() {
      @Override
      public Integration<?> create(ValueMap var1, Analytics var2) {
         boolean var8 = var1.getBoolean("consolidatedPageCalls", true);
         boolean var6 = var1.getBoolean("trackAllPages", false);
         boolean var7 = var1.getBoolean("trackCategorizedPages", false);
         boolean var4 = var1.getBoolean("trackNamedPages", false);
         boolean var5 = var1.getBoolean("people", false);
         String var11 = var1.getString("token");
         Set var9 = MixpanelIntegration.getStringSet(var1, "increments");
         boolean var3 = var1.getBoolean("setAllTraitsByDefault", true);
         Set var10 = MixpanelIntegration.getStringSet(var1, "peopleProperties");
         Set var13 = MixpanelIntegration.getStringSet(var1, "superProperties");
         Logger var12 = var2.logger("Mixpanel");
         MixpanelAPI var15 = MixpanelAPI.a(var2.getApplication(), var11);
         var12.verbose("MixpanelAPI.getInstance(context, %s);", var11);
         MixpanelAPI.People var14;
         if (var5) {
            var14 = var15.c();
         } else {
            var14 = null;
         }

         return new MixpanelIntegration(var15, var14, var5, var8, var6, var7, var4, var11, var12, var9, var3, var10, var13);
      }

      @Override
      public String key() {
         return "Mixpanel";
      }
   };
   private static final Map<String, String> MAPPER;
   private static final String MIXPANEL_KEY = "Mixpanel";
   private static final String VIEWED_EVENT_FORMAT = "Viewed %s Screen";
   private final boolean consolidatedPageCalls;
   final Set<String> increments;
   final boolean isPeopleEnabled;
   private final Logger logger;
   private final MixpanelAPI mixpanel;
   final MixpanelAPI.People mixpanelPeople;
   private final Set<String> peopleProperties;
   final boolean setAllTraitsByDefault;
   private final Set<String> superProperties;
   final String token;
   final boolean trackAllPages;
   final boolean trackCategorizedPages;
   final boolean trackNamedPages;

   static {
      LinkedHashMap var0 = new LinkedHashMap();
      var0.put("email", "$email");
      var0.put("phone", "$phone");
      var0.put("firstName", "$first_name");
      var0.put("lastName", "$last_name");
      var0.put("name", "$name");
      var0.put("username", "$username");
      var0.put("createdAt", "$created");
      MAPPER = Collections.unmodifiableMap(var0);
   }

   public MixpanelIntegration(
      MixpanelAPI var1,
      MixpanelAPI.People var2,
      boolean var3,
      boolean var4,
      boolean var5,
      boolean var6,
      boolean var7,
      String var8,
      Logger var9,
      Set<String> var10,
      boolean var11,
      Set<String> var12,
      Set<String> var13
   ) {
      this.mixpanel = var1;
      this.mixpanelPeople = var2;
      this.isPeopleEnabled = var3;
      this.consolidatedPageCalls = var4;
      this.trackAllPages = var5;
      this.trackCategorizedPages = var6;
      this.trackNamedPages = var7;
      this.token = var8;
      this.logger = var9;
      this.increments = var10;
      this.setAllTraitsByDefault = var11;
      this.peopleProperties = var12;
      this.superProperties = var13;
   }

   static <T> Map<String, T> filter(Map<String, T> var0, Iterable<String> var1) {
      LinkedHashMap var2 = new LinkedHashMap();

      for (String var3 : var1) {
         if (var0.containsKey(var3)) {
            var2.put(var3, var0.get(var3));
         }
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Set<String> getStringSet(ValueMap var0, String var1) {
      try {
         var9 = (List)var0.get(var1);
      } catch (ClassCastException var7) {
         return Collections.emptySet();
      }

      label42:
      if (var9 != null) {
         try {
            if (var9.size() == 0) {
               break label42;
            }
         } catch (ClassCastException var6) {
            return Collections.emptySet();
         }

         try {
            var8 = new HashSet(var9.size());
         } catch (ClassCastException var5) {
            return Collections.emptySet();
         }

         int var2 = 0;

         while (true) {
            try {
               if (var2 >= var9.size()) {
                  return var8;
               }

               var8.add((String)var9.get(var2));
            } catch (ClassCastException var4) {
               Set var10 = Collections.emptySet();
               return var10;
            }

            var2++;
         }
      }

      try {
         var11 = Collections.emptySet();
      } catch (ClassCastException var3) {
         var11 = Collections.emptySet();
      }

      return var11;
   }

   private void registerSuperProperties(Map<String, Object> var1) {
      if (!Utils.isNullOrEmpty(var1)) {
         JSONObject var2 = new ValueMap(Utils.transform(var1, MAPPER)).toJsonObject();
         this.mixpanel.a(var2);
         this.logger.verbose("mixpanel.registerSuperProperties(%s)", var2);
      }
   }

   private void setPeopleProperties(Map<String, Object> var1) {
      if (!Utils.isNullOrEmpty(var1) && this.isPeopleEnabled) {
         JSONObject var2 = new ValueMap(Utils.transform(var1, MAPPER)).toJsonObject();
         this.mixpanelPeople.a(var2);
         this.logger.verbose("mixpanel.getPeople().set(%s)", var2);
      }
   }

   @Override
   public void alias(AliasPayload var1) {
      super.alias(var1);
      String var3 = var1.previousId();
      String var2 = var3;
      if (var3.equals(var1.anonymousId())) {
         var2 = this.mixpanel.b();
      }

      String var4 = var1.userId();
      if (var4 != null) {
         this.mixpanel.a(var4, var2);
         this.logger.verbose("mixpanel.alias(%s, %s)", var4, var2);
      }
   }

   void event(String var1, Properties var2) {
      JSONObject var5 = var2.toJsonObject();
      this.mixpanel.a(var1, var5);
      this.logger.verbose("mixpanel.track(%s, %s)", var1, var5);
      if (this.isPeopleEnabled) {
         double var3 = var2.revenue();
         if (var3 != 0.0) {
            this.mixpanelPeople.a(var3, var5);
            this.logger.verbose("mixpanelPeople.trackCharge(%s, %s)", var3, var5);
         }
      }
   }

   @Override
   public void flush() {
      super.flush();
      this.mixpanel.a();
      this.logger.verbose("mixpanel.flush()");
   }

   public MixpanelAPI getUnderlyingInstance() {
      return this.mixpanel;
   }

   @Override
   public void identify(IdentifyPayload var1) {
      super.identify(var1);
      String var2 = var1.userId();
      if (var2 != null) {
         this.mixpanel.a(var2);
         this.logger.verbose("mixpanel.identify(%s)", var2);
         if (this.isPeopleEnabled) {
            this.mixpanelPeople.a(var2);
            this.logger.verbose("mixpanel.getPeople().identify(%s)", var2);
         }
      }

      Traits var3 = var1.traits();
      if (this.setAllTraitsByDefault) {
         this.registerSuperProperties(var3);
         this.setPeopleProperties(var3);
      } else {
         this.registerSuperProperties(filter(var3, this.superProperties));
         this.setPeopleProperties(filter(var3, this.peopleProperties));
      }
   }

   @Override
   public void onActivityCreated(Activity var1, Bundle var2) {
      super.onActivityCreated(var1, var2);
      MixpanelAPI.a(var1, this.token);
   }

   @Override
   public void reset() {
      super.reset();
      this.mixpanel.d();
      this.logger.verbose("mixpanel.reset()");
   }

   @Override
   public void screen(ScreenPayload var1) {
      if (this.consolidatedPageCalls) {
         Properties var2 = new Properties();
         var2.putAll(var1.properties());
         var2.put("name", var1.name());
         this.event("Loaded a Screen", var2);
      } else if (this.trackAllPages) {
         this.event(String.format("Viewed %s Screen", var1.event()), var1.properties());
      } else if (this.trackCategorizedPages && !Utils.isNullOrEmpty(var1.category())) {
         this.event(String.format("Viewed %s Screen", var1.category()), var1.properties());
      } else if (this.trackNamedPages && !Utils.isNullOrEmpty(var1.name())) {
         this.event(String.format("Viewed %s Screen", var1.name()), var1.properties());
      }
   }

   @Override
   public void track(TrackPayload var1) {
      String var2 = var1.event();
      this.event(var2, var1.properties());
      if (this.increments.contains(var2) && this.isPeopleEnabled) {
         this.mixpanelPeople.a(var2, 1.0);
         this.mixpanelPeople.a("Last " + var2, new Date());
      }
   }
}
