package com.salesforce.android.cases.ui.internal.features.shared.manager;

import android.support.v4.util.SparseArrayCompat;
import com.salesforce.android.cases.ui.CaseUIClient;
import com.salesforce.android.cases.ui.internal.features.shared.BasePresenter;
import com.salesforce.android.cases.ui.internal.features.shared.provider.PresenterProvider;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PresenterManager {
   private List<PresenterProvider> a;
   private SparseArrayCompat<BasePresenter> b;

   private PresenterManager(List<PresenterProvider> var1) {
      this.a = Collections.unmodifiableList(var1);
      this.b = new SparseArrayCompat<>(var1.size());
   }

   public static PresenterManager a(PresenterProvider... var0) {
      return new PresenterManager(Arrays.asList(var0));
   }

   private BasePresenter b(Class<? extends BasePresenter> var1) {
      return this.b.a(var1.hashCode(), null);
   }

   public <P> P a(CaseUIClient var1, Class<? extends BasePresenter> var2) {
      label23: {
         BasePresenter var3 = this.b(var2);
         if (var3 == null) {
            for (PresenterProvider var5 : this.a) {
               if (var5.a(var2)) {
                  var6 = var5.b(var1);
                  this.b.b(var2.hashCode(), var6);
                  break label23;
               }
            }
         }

         var6 = var3;
      }

      if (var6 == null) {
         throw new IllegalStateException("Could not create a presenter for the class " + var2.getCanonicalName() + ".");
      } else {
         return (P)var6;
      }
   }

   public void a(Class<? extends BasePresenter> var1) {
      BasePresenter var2 = this.b.a(var1.hashCode());
      if (var2 != null) {
         var2.e();
      }

      this.b.c(var1.hashCode());
   }
}
