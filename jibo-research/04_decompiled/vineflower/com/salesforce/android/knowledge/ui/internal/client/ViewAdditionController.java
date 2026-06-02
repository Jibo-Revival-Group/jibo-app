package com.salesforce.android.knowledge.ui.internal.client;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.ui.KnowledgeScene;
import com.salesforce.android.knowledge.ui.KnowledgeViewAddition;
import com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity;
import com.salesforce.android.knowledge.ui.internal.navigation.Navigator;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.ref.WeakReference;

class ViewAdditionController implements Navigator.Listener {
   private final KnowledgeViewAddition a;
   private ActivityReference<KnowledgeActivity> b = ActivityReference.a();
   private WeakReference<View> c = new WeakReference<>(null);
   private Animator d;

   ViewAdditionController(KnowledgeViewAddition var1) {
      this.a = var1;
   }

   private void a(Animator var1) {
      if (this.d != null) {
         this.d.cancel();
      }

      if (var1 != null) {
         var1.start();
      }

      this.d = var1;
   }

   private void c(KnowledgeScene var1, KnowledgeScene var2) {
      View var3 = this.c.get();
      if (var3 != null) {
         if (this.a.a(var2) && !this.a.a(var1)) {
            this.a(this.a.a(var3));
         } else if (!this.a.a(var2) && this.a.a(var1)) {
            this.a(this.a.b(var3));
         }
      }
   }

   @Override
   public void a(KnowledgeScene var1, KnowledgeScene var2) {
      this.c(var1, var2);
   }

   void a(KnowledgeActivity var1, KnowledgeScene var2) {
      if (!this.b.a(var1)) {
         ViewGroup var3 = (ViewGroup)var1.getWindow().getDecorView();
         View var4 = this.a.a(var3, var1);
         Arguments.a(var4, "View addition cannot be null");
         this.a.a(var4, this.a.a(var2));
         var1.addContentView(var4, var4.getLayoutParams());
         this.c = new WeakReference<>(var4);
         this.b = ActivityReference.a(var1);
      }
   }

   @Override
   public void b(KnowledgeScene var1, KnowledgeScene var2) {
      this.c(var1, var2);
   }
}
