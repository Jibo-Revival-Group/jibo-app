package com.amazonaws.internal.config;

import com.amazonaws.regions.Regions;
import com.jibo.aws.integration.aws.services.account.JiboAccountClient;
import com.jibo.aws.integration.aws.services.binary.JiboBinaryClient;
import com.jibo.aws.integration.aws.services.jot.JiboJotClient;
import com.jibo.aws.integration.aws.services.loop.JiboLoopClient;
import com.jibo.aws.integration.aws.services.photo.JiboPhotoClient;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesClient;
import com.jibo.aws.integration.aws.services.voicetraining.JiboVoiceTrainingClient;
import com.jibo.aws.integration.util.a;
import java.util.HashMap;
import java.util.Map;

public class InternalConfig {
   public static final String TAG = a.a(InternalConfig.class);
   private final SignerConfig defaultSignerConfig = getDefaultSigner();
   private final Map<String, HttpClientConfig> httpClients;
   private final Map<String, SignerConfig> regionSigners = getDefaultRegionSigners();
   private final Map<String, SignerConfig> serviceRegionSigners;
   private final Map<String, SignerConfig> serviceSigners;

   InternalConfig() {
      this.regionSigners.putAll(getOverrideRegionSigners());
      this.serviceSigners = getDefaultServiceSigners();
      this.serviceSigners.putAll(getOverrideServiceSigners());
      this.serviceRegionSigners = getDefaultServiceRegionSigners();
      this.serviceRegionSigners.putAll(getOverrideServiceRegionSigners());
      this.httpClients = getDefaultHttpClients();
      this.httpClients.putAll(getOverrideHttpClients());
   }

   private static Map<String, HttpClientConfig> getDefaultHttpClients() {
      HashMap var0 = new HashMap();
      var0.put(JiboAccountClient.class.getSimpleName(), new HttpClientConfig("account"));
      var0.put(JiboLoopClient.class.getSimpleName(), new HttpClientConfig("loop"));
      var0.put(JiboJotClient.class.getSimpleName(), new HttpClientConfig("jot"));
      var0.put(JiboRobotPropertiesClient.class.getSimpleName(), new HttpClientConfig("robotproperties"));
      var0.put(JiboVoiceTrainingClient.class.getSimpleName(), new HttpClientConfig("voicetraining"));
      var0.put(JiboPhotoClient.class.getSimpleName(), new HttpClientConfig("photo"));
      var0.put(JiboBinaryClient.class.getSimpleName(), new HttpClientConfig("binary"));
      return var0;
   }

   private static Map<String, SignerConfig> getDefaultRegionSigners() {
      HashMap var0 = new HashMap();
      var0.put(Regions.ApiDev.getName(), new SignerConfig("AWS4SignerType"));
      var0.put(Regions.ServerDev.getName(), new SignerConfig("AWS4SignerType"));
      return var0;
   }

   private static Map<String, SignerConfig> getDefaultServiceRegionSigners() {
      return new HashMap<>();
   }

   private static Map<String, SignerConfig> getDefaultServiceSigners() {
      HashMap var0 = new HashMap();
      var0.put("account", new SignerConfig("AWS4SignerType"));
      var0.put("loop", new SignerConfig("AWS4SignerType"));
      var0.put("jot", new SignerConfig("AWS4SignerType"));
      var0.put("robotproperties", new SignerConfig("AWS4SignerType"));
      var0.put("voicetraining", new SignerConfig("AWS4SignerType"));
      var0.put("audio", new SignerConfig("AWS4SignerType"));
      var0.put("photo", new SignerConfig("AWS4SignerType"));
      var0.put("snap", new SignerConfig("AWS4SignerType"));
      var0.put("binary", new SignerConfig("AWS4SignerType"));
      return var0;
   }

   private static SignerConfig getDefaultSigner() {
      return new SignerConfig("AWS4SignerType");
   }

   private static Map<String, HttpClientConfig> getOverrideHttpClients() {
      return new HashMap<>();
   }

   private static Map<String, SignerConfig> getOverrideRegionSigners() {
      return new HashMap<>();
   }

   private static Map<String, SignerConfig> getOverrideServiceRegionSigners() {
      return new HashMap<>();
   }

   private static Map<String, SignerConfig> getOverrideServiceSigners() {
      return new HashMap<>();
   }

   public HttpClientConfig getHttpClientConfig(String var1) {
      return this.httpClients.get(var1);
   }

   public SignerConfig getSignerConfig(String var1, String var2) {
      if (var1 == null) {
         throw new IllegalArgumentException();
      }

      if (var2 != null) {
         String var3 = var1 + "/" + var2;
         SignerConfig var6 = this.serviceRegionSigners.get(var3);
         if (var6 != null) {
            SignerConfig var9 = var6;
            return var9;
         }

         SignerConfig var7 = this.regionSigners.get(var2);
         SignerConfig var5 = var7;
         if (var7 != null) {
            return var5;
         }
      }

      SignerConfig var4 = this.serviceSigners.get(var1);
      SignerConfig var8 = var4;
      if (var4 == null) {
         var8 = this.defaultSignerConfig;
      }

      return var8;
   }

   public static class Factory {
      private static final InternalConfig SINGELTON;

      static {
         InternalConfig var0;
         try {
            var0 = new InternalConfig();
         } catch (RuntimeException var1) {
            throw var1;
         } catch (Exception var2) {
            throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Android SDK", var2);
         }

         SINGELTON = var0;
      }

      public static InternalConfig getInternalConfig() {
         return SINGELTON;
      }
   }
}
