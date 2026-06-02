package com.jibo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.guided.JiboAvatarSlideFragment;
import com.jibo.ui.fragment.guided.JiboRobotSlideFragment;
import com.jibo.ui.fragment.guided.LocationSlideFragment;
import com.jibo.ui.fragment.guided.WelcomeSlideFragment;
import com.jibo.ui.fragment.jibos.JiboDetailsFragment;
import com.jibo.ui.fragment.wifi.WiFiSuccessFragment;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;

public class GuidedExperienceActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
   @BindView
   ImageView arrowLeft;
   @BindView
   ImageView arrowRight;
   @BindView
   TextView cheersButton;
   @BindView
   View dimmer;
   private List<GuidedExperienceActivity.SlideInfo> h;
   private GuidedExperienceActivity.MyPagerAdapter i;
   @BindView
   CircleIndicator indicator;
   private JiboRobotPropertiesAsyncClient j;
   private Loop k;
   private Robot l;
   @BindView
   ViewGroup overlay;
   @BindView
   ViewGroup overlayContainer;
   @BindView
   ViewPager viewPager;

   private void c(int var1) {
      GuidedExperienceActivity.SlideInfo var2 = this.h.get(var1);
      if (var2.b()) {
         this.i();
      } else {
         this.j();
      }

      if (var2.c() != -1) {
         View var3 = LayoutInflater.from(this).inflate(var2.c(), null);
         this.overlayContainer.removeAllViews();
         this.overlayContainer.addView(var3);
         this.overlay.setVisibility(0);
      } else {
         this.overlay.setVisibility(8);
      }
   }

   private void r() {
      Bundle var1 = new Bundle();
      var1.putBoolean("ARGS_IS_IN_TUTORIAL_MODE", true);
      JiboDetailsFragment var5 = new JiboDetailsFragment();
      JiboDetailsFragment var4 = new JiboDetailsFragment();
      LocationSlideFragment var2 = new LocationSlideFragment();
      Bundle var3 = new Bundle();
      var3.putParcelable(Loop.class.getSimpleName(), this.k);
      var2.setArguments(var3);
      var5.setArguments(var1);
      var4.setArguments(var1);
      this.h = new ArrayList<>();
      this.h.add(new GuidedExperienceActivity.SlideInfo(this, new WelcomeSlideFragment()));
      this.h.add(new GuidedExperienceActivity.SlideInfo(this, new JiboRobotSlideFragment()));
      this.h.add(new GuidedExperienceActivity.SlideInfo(this, var2));
      this.h.add(new GuidedExperienceActivity.SlideInfo(this, new JiboAvatarSlideFragment()));
      this.h.add(new GuidedExperienceActivity.SlideInfo(this, var5, false, 2131427576));
   }

   private void s() {
      if (this.k != null) {
         this.j.getRobot(this.k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this) {
            final GuidedExperienceActivity a;

            {
               this.a = var1;
            }

            public void a(GetRobotRequest var1, Robot var2) {
               this.a.l = var2;
            }

            @Override
            public void onError(Exception var1) {
               this.a.a(var1, "get robot");
            }
         });
      }
   }

   @Override
   public void a(int var1) {
   }

   @Override
   public void a(int var1, float var2, int var3) {
   }

   @Override
   public void b(int var1) {
      if (var1 == this.h.size() - 1) {
         this.arrowRight.setVisibility(4);
         this.cheersButton.setVisibility(0);
         this.arrowLeft.setVisibility(0);
      } else if (var1 == 0) {
         this.arrowLeft.setVisibility(0);
      } else {
         this.arrowRight.setVisibility(0);
         this.cheersButton.setVisibility(8);
         this.arrowLeft.setVisibility(0);
      }

      this.c(var1);
      if (this.h.get(var1).a() instanceof JiboDetailsFragment) {
         ((JiboDetailsFragment)this.h.get(var1).a()).n_();
      }
   }

   @OnClick
   public void cheersButtonClicked(View var1) {
      this.finish();
   }

   @Override
   public void i() {
      if (this.dimmer != null) {
         this.dimmer.setVisibility(0);
      }
   }

   @Override
   public void j() {
      if (this.dimmer != null) {
         this.dimmer.setVisibility(8);
      }
   }

   @OnClick
   public void nextSlide(View var1) {
      this.viewPager.a(Math.min(this.viewPager.getCurrentItem() + 1, this.i.b() - 1), true);
   }

   @Override
   public void onBackPressed() {
      if (this.viewPager.getCurrentItem() == 0) {
         JiboAnalytics.k(this);
         new SingleFragmentActivity.Builder(this, WiFiSuccessFragment.class.getName()).a(Loop.class.getSimpleName(), this.k).a(1000);
         this.finish();
      } else {
         this.viewPager.a(this.viewPager.getCurrentItem() - 1, true);
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.GuidedExperienceActivity");
      this.getIntent().putExtra(b, 2131427359);
      super.onCreate(var1);
      this.arrowRight.setImageDrawable(ImageUtils.a(this, 2131231006, 2131099771));
      this.arrowLeft.setImageDrawable(ImageUtils.a(this, 2131231006, 2131099771));
      if (var1 != null) {
         this.k = (Loop)var1.getParcelable(Loop.class.getSimpleName());
      } else {
         this.k = (Loop)this.getIntent().getParcelableExtra(Loop.class.getSimpleName());
      }

      this.r();
      this.i = new GuidedExperienceActivity.MyPagerAdapter(this, this.getSupportFragmentManager());
      this.viewPager.setAdapter(this.i);
      this.indicator.setViewPager(this.viewPager);
      this.viewPager.a(this);
      this.j = EntityData.a(this).g();
      this.s();
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.GuidedExperienceActivity");
      super.onResume();
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putParcelable(Loop.class.getSimpleName(), this.k);
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.GuidedExperienceActivity");
      super.onStart();
   }

   @OnClick
   public void previousSlide(View var1) {
      if (this.viewPager.getCurrentItem() == 0) {
         this.onBackPressed();
      } else {
         this.viewPager.a(Math.max(this.viewPager.getCurrentItem() - 1, 0), true);
      }
   }

   public Robot q() {
      return this.l;
   }

   private class MyPagerAdapter extends FragmentPagerAdapter {
      final GuidedExperienceActivity a;

      public MyPagerAdapter(GuidedExperienceActivity var1, FragmentManager var2) {
         super(var2);
         this.a = var1;
      }

      @Override
      public Fragment a(int var1) {
         return this.a.h.get(var1).a();
      }

      @Override
      public int b() {
         return this.a.h.size();
      }
   }

   private class SlideInfo {
      final GuidedExperienceActivity a;
      private Fragment b;
      private boolean c;
      private int d;

      public SlideInfo(GuidedExperienceActivity var1, Fragment var2) {
         this.a = var1;
         this.d = -1;
         this.b = var2;
      }

      public SlideInfo(GuidedExperienceActivity var1, Fragment var2, boolean var3, int var4) {
         this.a = var1;
         this.d = -1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public Fragment a() {
         return this.b;
      }

      public boolean b() {
         return this.c;
      }

      public int c() {
         return this.d;
      }
   }
}
