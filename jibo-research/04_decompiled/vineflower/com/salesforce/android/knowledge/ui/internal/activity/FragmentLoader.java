package com.salesforce.android.knowledge.ui.internal.activity;

import android.support.v7.app.AppCompatActivity;
import com.salesforce.android.knowledge.ui.KnowledgeScene;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.navigation.Navigator;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.functional.Consumer;

public class FragmentLoader implements Navigator.Listener {
   private final KnowledgeFragment.Factory a;
   private ActivityReference<AppCompatActivity> b = ActivityReference.a();

   FragmentLoader(FragmentLoader.Builder var1) {
      this.a = var1.a;
   }

   public static FragmentLoader.Builder a() {
      return new FragmentLoader.Builder();
   }

   private void a(AppCompatActivity var1, boolean var2) {
      int var4 = 0;
      KnowledgeFragment var5 = this.a.a();
      int var3;
      if (var2) {
         var3 = 0;
      } else {
         var3 = R.anim.knowledge_fragment_in;
      }

      if (var2) {
         var4 = R.anim.knowledge_fragment_out;
      }

      var1.getSupportFragmentManager().a().a(var3, var4).b(R.id.knowledge_fragment_container, var5, "KnowledgeFragment").d();
   }

   private boolean d(AppCompatActivity var1) {
      boolean var2;
      if (var1.getSupportFragmentManager().a("KnowledgeFragment") != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void a(AppCompatActivity var1) {
      this.b = ActivityReference.a(var1);
      if (!this.d(var1)) {
         this.b(var1);
      }
   }

   @Override
   public void a(KnowledgeScene var1, KnowledgeScene var2) {
      this.b.a(new Consumer<AppCompatActivity>(this) {
         final FragmentLoader a;

         {
            this.a = var1;
         }

         public void a(AppCompatActivity var1) {
            this.a.b(var1);
         }
      });
   }

   void b(AppCompatActivity var1) {
      this.a(var1, false);
   }

   @Override
   public void b(KnowledgeScene var1, KnowledgeScene var2) {
      if (var2 != KnowledgeScene.SCENE_NONE) {
         this.b.a(new Consumer<AppCompatActivity>(this) {
            final FragmentLoader a;

            {
               this.a = var1;
            }

            public void a(AppCompatActivity var1) {
               this.a.c(var1);
            }
         });
      }
   }

   void c(AppCompatActivity var1) {
      this.a(var1, true);
   }

   public static class Builder {
      KnowledgeFragment.Factory a;

      Builder() {
      }

      public FragmentLoader a() {
         if (this.a == null) {
            this.a = new KnowledgeFragment.Factory();
         }

         return new FragmentLoader(this);
      }
   }
}
