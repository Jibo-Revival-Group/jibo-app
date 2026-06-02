package android.support.v7.app;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.View;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
   boolean a;
   private final ActionBarDrawerToggle.Delegate b;
   private DrawerArrowDrawable c;
   private boolean d;
   private final int e;
   private final int f;

   private void a(float var1) {
      if (var1 == 1.0F) {
         this.c.a(true);
      } else if (var1 == 0.0F) {
         this.c.a(false);
      }

      this.c.a(var1);
   }

   @Override
   public void a(int var1) {
   }

   @Override
   public void a(View var1) {
      this.a(1.0F);
      if (this.a) {
         this.b(this.f);
      }
   }

   @Override
   public void a(View var1, float var2) {
      if (this.d) {
         this.a(Math.min(1.0F, Math.max(0.0F, var2)));
      } else {
         this.a(0.0F);
      }
   }

   void b(int var1) {
      this.b.a(var1);
   }

   @Override
   public void b(View var1) {
      this.a(0.0F);
      if (this.a) {
         this.b(this.e);
      }
   }

   public interface Delegate {
      void a(int var1);
   }
}
