package com.salesforce.android.knowledge.ui;

import android.content.Context;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.KnowledgeCore;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.HashSet;
import java.util.Set;

public class KnowledgeUI {
   final KnowledgeUIConfiguration a;
   KnowledgeClient b;
   final Set<KnowledgeViewAddition> c = new HashSet<>();

   private KnowledgeUI(KnowledgeUIConfiguration var1) {
      this.a = var1;
   }

   public static KnowledgeUI a(KnowledgeUIConfiguration var0) {
      return new KnowledgeUI(var0);
   }

   public KnowledgeUI a(KnowledgeViewAddition var1) {
      this.c.add(var1);
      return this;
   }

   KnowledgeUIClientImpl a(KnowledgeClient var1) {
      return KnowledgeUIClientImpl.a(this.a, var1, this.c);
   }

   public Async<KnowledgeUIClient> a(Context var1) {
      boolean var3 = true;
      String var5 = this.a.a().a();
      String var4 = this.a.f();
      String var6 = this.a.b();
      boolean var2;
      if (this.b != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (this.a.c() == null) {
         var3 = false;
      }

      KnowledgeUIAnalyticsEmit.a(var5, var4, var6, var2, var3);
      Async var7;
      if (this.b != null) {
         var7 = BasicAsync.c(this.a(this.b));
      } else {
         var7 = KnowledgeCore.a(this.a.a()).a(var1).a(new Function<KnowledgeClient, KnowledgeUIClient>(this) {
            final KnowledgeUI a;

            {
               this.a = var1;
            }

            public KnowledgeUIClient a(KnowledgeClient var1) {
               KnowledgeUIClientImpl var2x = this.a.a(var1);
               var1.a(var2x);
               return var2x;
            }
         });
      }

      var7.a(new Async.ResultHandler<KnowledgeUIClient>(this) {
         final KnowledgeUI a;

         {
            this.a = var1;
         }

         public void a(Async<?> var1, KnowledgeUIClient var2x) {
            KnowledgeUIAnalyticsEmit.b();
         }
      });
      return var7;
   }
}
