package com.jibo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.ui.fragment.tips.TipsFragment;
import com.jibo.ui.fragment.tips.TipsGuidedExperienceFragment;
import com.jibo.ui.view.NoBounceBehavior;
import com.jibo.utils.ImageUtils;

public class TipsActivity extends BaseActivity {
   @BindView
   AppBarLayout appBarLayout;
   @BindView
   CollapsingToolbarLayout collapsingToolbar;
   int h;
   String i;
   @BindView
   ImageView image;
   @BindView
   TextView text;
   @BindView
   TextView title;
   @BindView
   Toolbar toolbar;
   @BindView
   View toolbarContainer;

   public void a(TipsFragment.Tip var1) {
      if (!this.i.equalsIgnoreCase("TAG_TIP5")) {
         this.text.setText(Html.fromHtml(this.getString(var1.c())));
         Glide.a(this).a(Integer.valueOf(var1.d())).b().a(this.image);
         this.title.setText(var1.e());
      }
   }

   public void collapseToolbar(View var1) {
      this.appBarLayout.setExpanded(false);
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.TipsActivity");
      this.getIntent().putExtra(BaseActivity.b, 2131427366);
      super.onCreate(var1);
      TypedValue var2 = new TypedValue();
      if (this.getTheme().resolveAttribute(16843499, var2, true)) {
         this.h = TypedValue.complexToDimensionPixelSize(var2.data, this.getResources().getDisplayMetrics());
      }

      this.i = this.getIntent().getExtras().getString("ARGS_TAG");
      if (this.i.equalsIgnoreCase("TAG_TIP5")) {
         this.appBarLayout.a(false, false);
         ((NoBounceBehavior)((CoordinatorLayout.LayoutParams)this.appBarLayout.getLayoutParams()).b()).a(false);
      }

      if (var1 == null) {
         FragmentTransaction var3 = this.getSupportFragmentManager().a();
         if (this.i.equalsIgnoreCase("TAG_TIP0")) {
            this.text.setText(Html.fromHtml(this.getString(2131755901)));
            Glide.a(this).a(Integer.valueOf(2131231334)).b().a(this.image);
            this.title.setText(2131756016);
            var3.b(2131296575, Fragment.instantiate(this, TipsGuidedExperienceFragment.class.getName(), this.getIntent().getExtras()), TipsFragment.f)
               .a(TipsFragment.f)
               .d();
         } else {
            var3.b(2131296575, Fragment.instantiate(this, TipsFragment.class.getName(), this.getIntent().getExtras()), TipsFragment.f).a(TipsFragment.f).d();
         }
      }

      this.appBarLayout.a(new AppBarLayout.OnOffsetChangedListener(this) {
         boolean a;
         int b;
         final TipsActivity c;

         {
            this.c = var1;
            this.a = false;
            this.b = -1;
         }

         @Override
         public void a(AppBarLayout var1, int var2x) {
            if (this.b == -1) {
               this.b = var1.getTotalScrollRange();
            }

            if (this.b + var2x <= this.c.h) {
               this.c.toolbar.setBackground(null);
               this.a = true;
            } else if (this.a && this.b + var2x > this.c.h) {
               this.c.toolbar.setBackground(ImageUtils.a(this.c, 2131230985));
               this.a = false;
            }
         }
      });
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.TipsActivity");
      super.onResume();
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.TipsActivity");
      super.onStart();
   }
}
