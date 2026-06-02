package com.salesforce.android.knowledge.core;

import android.content.Context;
import com.salesforce.android.knowledge.core.internal.client.KnowledgeClientImpl;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCache;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import java.security.GeneralSecurityException;

public final class KnowledgeCore {
   private static final ServiceLogger b = ServiceLogging.a(KnowledgeCore.class);
   private final KnowledgeConfiguration a;

   private KnowledgeCore(KnowledgeConfiguration var1) {
      this.a = var1;
   }

   public static KnowledgeCore a(KnowledgeConfiguration var0) {
      return new KnowledgeCore(var0);
   }

   private static boolean a() {
      boolean var0;
      if (SalesforceSDKManager.b() && SalesforceSDKManager.a() instanceof SmartStoreSDKManager) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public Async<KnowledgeClient> a(Context var1) {
      try {
         Arguments.a(var1);
         if (!a()) {
            IllegalStateException var7 = new IllegalStateException(
               "Smartstore was not initialized. Offline storage will not work if SmartStoreSDKManager.initNative is not called."
            );
            throw var7;
         }

         KnowledgeClientImpl var6 = KnowledgeClientImpl.a(this.a).a(var1);
         Async var3 = var6.b().b().a();
         Function var2 = new Function<OfflineResourceCache, KnowledgeClient>(this, var6) {
            final KnowledgeClient a;
            final KnowledgeCore b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public KnowledgeClient a(OfflineResourceCache var1) {
               return this.a;
            }
         };
         var5 = var3.a(var2);
      } catch (GeneralSecurityException var4) {
         var5 = BasicAsync.c(var4);
      }

      return var5;
   }
}
