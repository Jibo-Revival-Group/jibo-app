package com.jibo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.salesforce.android.cases.core.CaseClientCallbacks;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.ui.CaseUI;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.CaseUIConfiguration;
import com.salesforce.android.knowledge.core.KnowledgeConfiguration;
import com.salesforce.android.knowledge.ui.KnowledgeUI;
import com.salesforce.android.knowledge.ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.ui.KnowledgeUIConfiguration;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import java.util.HashMap;
import java.util.Map;

public class JiboSupport {
   private static KnowledgeUIClient a = null;

   public static void a(Activity var0) {
      if (a != null) {
         a.b();
         a = null;
      }

      if (a == null) {
         JiboAnalytics.h(var0);
         KnowledgeUI.a(KnowledgeUIConfiguration.a(KnowledgeConfiguration.a("https://jibo.force.com/jibo"), "Robot", "All"))
            .a(new JiboViewAddition())
            .a(var0)
            .a(new Async.ResultHandler<KnowledgeUIClient>(var0) {
               final Activity a;

               {
                  this.a = var1;
               }

               public void a(Async<?> var1, KnowledgeUIClient var2) {
                  JiboSupport.a = var2;
                  var2.a(new KnowledgeUIClient.OnCloseListener(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void a() {
                        JiboSupport.a = null;
                     }
                  });
                  var2.b(this.a);
               }
            });
      }
   }

   public static void a(Context var0) {
      SmartStoreSDKManager.a(var0, new SalesforceSDKManager.KeyInterface() {
         @Override
         public String a(String var1) {
            return Encryptor.d(var1 + "12s9adpahk;n12-97sdainkasd=012", var1 + "12kl0dsakj4-cxh1qewkjasdol8");
         }
      }, OnBoardingActivity.class);
   }

   public static void b(Context var0) {
      CaseClientCallbacks var1 = new CaseClientCallbacks(var0) {
         final Context a;

         {
            this.a = var1;
         }

         @Override
         public Map<String, String> a() {
            Account var2 = EntityData.a(this.a).i();
            HashMap var1x = new HashMap();
            var1x.put("Unauthenticated_User_Email__c", var2.getEmail());
            var1x.put("Account_ID__c", var2.getId());
            var1x.put("Account_OID__c", var2.getId());
            return var1x;
         }

         @Override
         public boolean a(Bundle var1) {
            return false;
         }

         @Override
         public boolean b(Bundle var1) {
            return false;
         }
      };
      CaseConfiguration var2 = new CaseConfiguration.Builder("https://jibo.force.com/jibo", "NewCase").a(var1).a();
      CaseUI.a(var0).a(CaseUIConfiguration.a(var2));
      CaseUI.a(var0).a().a(new Async.ResultHandler<CaseUIClient>(var0) {
         final Context a;

         {
            this.a = var1;
         }

         public void a(Async<?> var1, CaseUIClient var2x) {
            var2x.a(this.a);
         }
      });
   }
}
