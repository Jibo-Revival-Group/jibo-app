package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

public class Scene {
   private ViewGroup a;
   private Runnable b;

   static Scene a(View var0) {
      return (Scene)var0.getTag(R.id.transition_current_scene);
   }

   static void a(View var0, Scene var1) {
      var0.setTag(R.id.transition_current_scene, var1);
   }

   public void a() {
      if (a(this.a) == this && this.b != null) {
         this.b.run();
      }
   }
}
