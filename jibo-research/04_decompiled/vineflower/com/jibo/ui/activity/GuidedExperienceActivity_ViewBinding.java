package com.jibo.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.relex.circleindicator.CircleIndicator;

public class GuidedExperienceActivity_ViewBinding extends BaseActivity_ViewBinding {
   private GuidedExperienceActivity b;
   private View c;
   private View d;
   private View e;

   public GuidedExperienceActivity_ViewBinding(GuidedExperienceActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public GuidedExperienceActivity_ViewBinding(GuidedExperienceActivity var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.viewPager = Utils.b(var2, 2131297065, "field 'viewPager'", ViewPager.class);
      var1.indicator = Utils.b(var2, 2131296609, "field 'indicator'", CircleIndicator.class);
      View var3 = Utils.a(var2, 2131296452, "field 'cheersButton' and method 'cheersButtonClicked'");
      var1.cheersButton = Utils.c(var3, 2131296452, "field 'cheersButton'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final GuidedExperienceActivity b;
         final GuidedExperienceActivity_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.cheersButtonClicked(var1);
         }
      });
      var3 = Utils.a(var2, 2131296324, "field 'arrowRight' and method 'nextSlide'");
      var1.arrowRight = Utils.c(var3, 2131296324, "field 'arrowRight'", ImageView.class);
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final GuidedExperienceActivity b;
         final GuidedExperienceActivity_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.nextSlide(var1);
         }
      });
      var3 = Utils.a(var2, 2131296323, "field 'arrowLeft' and method 'previousSlide'");
      var1.arrowLeft = Utils.c(var3, 2131296323, "field 'arrowLeft'", ImageView.class);
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final GuidedExperienceActivity b;
         final GuidedExperienceActivity_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.previousSlide(var1);
         }
      });
      var1.dimmer = Utils.a(var2, 2131296530, "field 'dimmer'");
      var1.overlayContainer = Utils.b(var2, 2131296761, "field 'overlayContainer'", ViewGroup.class);
      var1.overlay = Utils.b(var2, 2131296760, "field 'overlay'", ViewGroup.class);
   }

   @Override
   public void unbind() {
      GuidedExperienceActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.viewPager = null;
      var1.indicator = null;
      var1.cheersButton = null;
      var1.arrowRight = null;
      var1.arrowLeft = null;
      var1.dimmer = null;
      var1.overlayContainer = null;
      var1.overlay = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      super.unbind();
   }
}
