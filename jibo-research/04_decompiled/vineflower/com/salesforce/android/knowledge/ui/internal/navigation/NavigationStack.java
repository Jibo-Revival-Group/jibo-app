package com.salesforce.android.knowledge.ui.internal.navigation;

import android.os.Bundle;
import com.salesforce.android.knowledge.ui.KnowledgeScene;
import com.salesforce.android.knowledge.ui.internal.presenter.Presenter;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

class NavigationStack extends LinkedBlockingDeque<NavigationStack.Entry> {
   KnowledgeScene a() {
      KnowledgeScene var1;
      if (this.isEmpty()) {
         var1 = KnowledgeScene.SCENE_NONE;
      } else {
         var1 = this.peek().b();
      }

      return var1;
   }

   void a(KnowledgeScene var1) {
      Iterator var3 = this.descendingIterator();

      while (var3.hasNext()) {
         NavigationStack.Entry var2 = (NavigationStack.Entry)var3.next();
         if (var2.b() == var1) {
            var2.a().c();
            var3.remove();
            break;
         }
      }
   }

   public void a(NavigationStack.Entry var1) {
      super.push(var1);
      var1.a().b();
   }

   NavigationStack.Entry b() {
      Iterator var1 = super.iterator();
      if (var1.hasNext()) {
         var1.next();
         if (var1.hasNext()) {
            return (NavigationStack.Entry)var1.next();
         }
      }

      return null;
   }

   public NavigationStack.Entry c() {
      NavigationStack.Entry var1 = (NavigationStack.Entry)super.pop();
      var1.a().c();
      return var1;
   }

   static class Entry {
      private final KnowledgeScene a;
      private final Presenter<?> b;
      private final Bundle c = new Bundle();

      Entry(KnowledgeScene var1, Presenter<?> var2) {
         this.a = var1;
         this.b = var2;
      }

      Presenter<?> a() {
         return this.b;
      }

      KnowledgeScene b() {
         return this.a;
      }

      Bundle c() {
         return this.c;
      }
   }
}
