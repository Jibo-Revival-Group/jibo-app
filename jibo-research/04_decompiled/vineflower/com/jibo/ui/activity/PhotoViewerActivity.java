package com.jibo.ui.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.JiboGlideModule;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.MediaHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.service.MediaDeletingService;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.helpers.FragmentStateCursorPagerAdapter;
import com.jibo.ui.view.TouchImageView;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.NetworkStateReceiver;
import com.jibo.utils.OriginalKey;
import com.jibo.utils.SharedPreferencesUtil;
import java.io.File;

public class PhotoViewerActivity extends AppCompatActivity implements DialogUtils.DialogFragmentWrapperClickListener {
   public static final String a = LogUtils.a(PhotoViewerActivity.class);
   private static SparseBooleanArray f = new SparseBooleanArray();
   Unbinder b;
   int c;
   boolean d;
   int e;
   @BindView
   View footer;
   private int g = 0;
   private PhotoViewerActivity.MediaAdapter h;
   private Media i;
   private Cursor j;
   private int k = 1536;
   private ContentObserver l;
   private Account m;
   private boolean n;
   private NetworkStateReceiver o;
   @BindView
   ViewPager pager;
   @BindView
   TextView photoDateText;
   @BindView
   Toolbar toolbar;
   @BindView
   ImageView transitionImage;
   @BindView
   View viewNetworkDown;

   public PhotoViewerActivity() {
      this.d = true;
      this.e = 0;
      this.l = new ContentObserver(this, new Handler()) {
         final PhotoViewerActivity a;

         {
            this.a = var1;
         }

         public void onChange(boolean var1, Uri var2) {
            this.a.c();
            this.a.pager.setCurrentItem(this.a.g);
            this.a.i();
         }
      };
      this.n = true;
      this.o = new NetworkStateReceiver(this) {
         final PhotoViewerActivity a;

         {
            this.a = var1;
         }

         @Override
         public void a(boolean var1) {
            this.a.n = var1;
            this.a.runOnUiThread(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  View var2 = this.a.a.viewNetworkDown;
                  byte var1x;
                  if (!this.a.a.n) {
                     var1x = 0;
                  } else {
                     var1x = 8;
                  }

                  var2.setVisibility(var1x);
                  this.a.a.invalidateOptionsMenu();
               }
            });
         }
      };
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void c() {
      try {
         if (this.h != null) {
            this.h.a((Cursor)null);
         }
      } catch (Exception var10) {
         Crashlytics.a(var10);
         return;
      }

      try {
         if (this.j != null && !this.j.isClosed()) {
            this.j.close();
         }
      } catch (Exception var9) {
         Crashlytics.a(var9);
         return;
      }

      label115: {
         int var1;
         label81: {
            try {
               this.j = null;
               this.j = this.getContentResolver()
                  .query(
                     this.getIntent().getData(),
                     null,
                     this.getIntent().getStringExtra("where"),
                     this.getIntent().getStringArrayExtra("where_args"),
                     this.getIntent().getStringExtra("order")
                  );
               PhotoViewerActivity.MediaAdapter var2 = new PhotoViewerActivity.MediaAdapter(this, this.getSupportFragmentManager(), null);
               this.h = var2;
               if (this.j == null || this.j.isClosed() || this.j.getCount() <= 0 || !this.j.moveToFirst()) {
                  break label115;
               }

               if (this.g >= 0) {
                  var1 = this.g;
                  break label81;
               }
            } catch (Exception var8) {
               Crashlytics.a(var8);
               return;
            }

            var1 = 0;
         }

         label97: {
            try {
               this.g = var1;
               if (this.g >= this.j.getCount()) {
                  var1 = this.j.getCount() - 1;
                  break label97;
               }
            } catch (Exception var7) {
               Crashlytics.a(var7);
               return;
            }

            try {
               var1 = this.g;
            } catch (Exception var6) {
               Crashlytics.a(var6);
               return;
            }
         }

         try {
            this.g = var1;
            if (this.g < this.j.getCount() && this.g >= 0) {
               this.j.moveToPosition(this.g);
               this.pager.setAdapter(this.h);
               this.h.a(this.j);
               return;
            }
         } catch (Exception var5) {
            Crashlytics.a(var5);
            return;
         }

         try {
            this.finish();
         } catch (Exception var4) {
            Crashlytics.a(var4);
         }

         return;
      }

      try {
         this.finish();
      } catch (Exception var3) {
         Crashlytics.a(var3);
      }
   }

   private int d() {
      int var1 = 0;
      int var2 = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
      if (var2 > 0) {
         var1 = this.getResources().getDimensionPixelSize(var2);
      }

      return var1;
   }

   private int e() {
      boolean var2 = ViewConfiguration.get(this).hasPermanentMenuKey();
      Resources var4 = this.getResources();
      String var3;
      if (this.getResources().getConfiguration().orientation == 1) {
         var3 = "navigation_bar_height";
      } else {
         var3 = "navigation_bar_height_landscape";
      }

      int var1 = var4.getIdentifier(var3, "dimen", "android");
      if (var1 > 0 && !var2) {
         var1 = this.getResources().getDimensionPixelSize(var1);
      } else {
         var1 = 0;
      }

      return var1;
   }

   private void f() {
      if ((this.k & 4) == 0 && (this.k & 2) == 0) {
         this.g();
      } else {
         this.h();
      }
   }

   private void g() {
      this.k = this.k | 4 | 2048 | 2;
      this.getWindow().getDecorView().setSystemUiVisibility(this.k);
   }

   private void h() {
      this.k = this.k & -5 & -3;
      this.getWindow().getDecorView().setSystemUiVisibility(this.k);
   }

   private void i() {
      EntityData.a(this);
      this.i = EntityData.c(this.h.d());
      if (this.i != null && this.h.d() != null && !this.h.d().isClosed() && this.h.d().getCount() != 0) {
         this.invalidateOptionsMenu();

         try {
            String[] var1 = DateTimeUtils.getDateTimeParts(
               this.i.getCreated(), "M/d/yy", "hh:mm a", false, this.getString(2131755887), this.getString(2131755865), this.getString(2131755866)
            );
            this.photoDateText.setText(this.getString(2131755524, new Object[]{var1[0], var1[1]}));
         } catch (Exception var2) {
            this.photoDateText.setText("");
         }
      }
   }

   private void j() {
      boolean var1 = SharedPreferencesUtil.g(this.getApplicationContext());
      File var3 = new File(this.getExternalCacheDir(), OriginalKey.a(MediaHelper.getUrl(var1, this.i)));
      File var2 = MediaHelper.getShareableFile(this.getExternalCacheDir() + "/" + "share", this.i);

      try {
         JiboGlideModule.b(this);
         if (!var2.exists()) {
            ImageUtils.a(var3, var2);
         }

         Uri var5 = FileProvider.a(this, "com.jibo.fileprovider", var2);
         Intent var6 = ShareCompat.IntentBuilder.a(this).a(this.getContentResolver().getType(var5)).a(var5).a(2131755850).b();
         var6.addFlags(1);
         if (var6.resolveActivity(this.getPackageManager()) == null) {
            Exception var7 = new Exception(this.getString(2131755257));
            throw var7;
         }

         this.startActivity(var6);
         JiboAnalytics.e(this);
      } catch (Exception var4) {
         Crashlytics.a(var4);
         DialogUtils.c(null, this.getSupportFragmentManager(), 104, this.getString(2131756022), this.getString(2131755257));
      }
   }

   public void a() {
      View var2 = this.viewNetworkDown;
      byte var1;
      if (!this.n) {
         var1 = 0;
      } else {
         var1 = 8;
      }

      var2.setVisibility(var1);
      if (this.getResources().getConfiguration().orientation == 2) {
         this.toolbar.setVisibility(8);
         this.footer.setVisibility(8);
         this.g();
      } else {
         this.toolbar.setVisibility(0);
         this.footer.setVisibility(0);
         if (this.d) {
            LayoutParams var3 = (LayoutParams)this.toolbar.getLayoutParams();
            var3.setMargins(0, this.c, 0, 0);
            this.toolbar.setLayoutParams(var3);
            LayoutParams var4 = (LayoutParams)this.footer.getLayoutParams();
            var4.setMargins(0, 0, 0, this.e);
            this.footer.setLayoutParams(var4);
         } else {
            LayoutParams var5 = (LayoutParams)this.toolbar.getLayoutParams();
            var5.setMargins(0, this.c, 0, 0);
            this.toolbar.setLayoutParams(var5);
            LayoutParams var6 = (LayoutParams)this.footer.getLayoutParams();
            var6.setMargins(0, 0, 0, 0);
            this.footer.setLayoutParams(var6);
         }
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      if (100 == var1) {
         this.setResult(BaseActivity.d);
         this.finish();
      } else if (117 == var1) {
         JiboAnalytics.j(this);
         MediaDeletingService.a(this, this.i);
      }
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.PhotoViewerActivity");
      super.onCreate(var1);
      this.setContentView(2131427362);
      this.c = this.d();
      this.e = this.e();
      this.b = ButterKnife.a(this);
      this.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
         final PhotoViewerActivity a;

         {
            this.a = var1;
         }

         public void onSystemUiVisibilityChange(int var1) {
            if (this.a.getResources().getConfiguration().orientation == 1) {
               if ((var1 & 4) == 0) {
                  this.a.toolbar.animate().alpha(1.0F).setDuration(300L).start();
                  this.a.footer.animate().alpha(1.0F).setDuration(300L).start();
                  this.a.viewNetworkDown.animate().alpha(1.0F).setDuration(300L).start();
               } else {
                  this.a.toolbar.animate().alpha(0.0F).setDuration(300L).start();
                  this.a.footer.animate().alpha(0.0F).setDuration(300L).start();
                  this.a.viewNetworkDown.animate().alpha(0.0F).setDuration(300L).start();
               }
            } else {
               LayoutParams var2 = (LayoutParams)this.a.viewNetworkDown.getLayoutParams();
               if ((var1 & 4) == 0) {
                  var2.setMargins(0, this.a.c, 0, 0);
               } else {
                  var2.setMargins(0, 0, 0, 0);
               }

               this.a.viewNetworkDown.setLayoutParams(var2);
               this.a.viewNetworkDown.animate().alpha(1.0F).setDuration(300L).start();
            }
         }
      });
      this.setSupportActionBar(this.toolbar);
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      if (VERSION.SDK_INT >= 21) {
         this.getWindow().setFlags(67108864, 67108864);
      }

      Display var2 = this.getWindowManager().getDefaultDisplay();
      Point var3 = new Point();
      var2.getRealSize(var3);
      PhotoViewerActivity.PhotoFragment.a = var3.y;
      this.getResources().getDisplayMetrics();
      this.g();
      this.h();
      if (this.getIntent().getStringExtra("media_id") == null || VERSION.SDK_INT < 21) {
         this.transitionImage.setVisibility(8);
      }

      this.m = EntityData.a(this).i();
      if (var1 == null) {
         if (this.getIntent() != null && this.getIntent().getExtras() != null) {
            this.g = this.getIntent().getIntExtra("media_indx", 0);
         }
      } else {
         this.g = var1.getInt("media_indx", 0);
      }

      this.c();
      this.pager.setCurrentItem(this.g);
      this.i();
      this.pager.a(new ViewPager.OnPageChangeListener(this) {
         final PhotoViewerActivity a;

         {
            this.a = var1;
         }

         @Override
         public void a(int var1) {
            if (this.a.getResources().getConfiguration().orientation == 2) {
               this.a.g();
            }
         }

         @Override
         public void a(int var1, float var2x, int var3x) {
         }

         @Override
         public void b(int var1) {
            this.a.g = var1;
            if (this.a.h.f() && this.a.g < this.a.h.b()) {
               this.a.h.d().moveToPosition(this.a.g);
               this.a.i();
            }
         }
      });
      this.pager.a(false, new PhotoViewerActivity.ZoomOutPageTransformer(this));
      this.a();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      int var3 = 2131099871;
      this.getMenuInflater().inflate(2131492878, var1);
      MenuItem var5 = var1.findItem(2131296307);
      MenuItem var6 = var1.findItem(2131296292);
      ImageUtils.a(this, var1);
      boolean var4;
      if (this.n && f.get(this.pager.getCurrentItem(), false)) {
         var4 = true;
      } else {
         var4 = false;
      }

      var5.setEnabled(var4);
      int var2;
      if (var5.isEnabled()) {
         var2 = 2131099871;
      } else {
         var2 = 2131099773;
      }

      ImageUtils.a(this, var5, var2);
      if (this.n && f.get(this.pager.getCurrentItem(), false)) {
         var4 = true;
      } else {
         var4 = false;
      }

      var6.setEnabled(var4);
      if (var6.isEnabled()) {
         var2 = var3;
      } else {
         var2 = 2131099773;
      }

      ImageUtils.a(this, var6, var2);
      if (this.i != null && this.i.getAccountId() != null) {
         if (!LoopHelper.isOwner(EntityData.a(this).c(this.i.getLoopId()), this.m.getId()) && !this.i.getAccountId().equals(this.m.getId())) {
            var6.setVisible(false);
         } else {
            var6.setVisible(true);
         }
      } else {
         var6.setVisible(false);
      }

      return true;
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
      if (this.j != null && !this.j.isClosed()) {
         this.j.close();
      }

      f.clear();
      this.b.unbind();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2 = true;
      switch (var1.getItemId()) {
         case 16908332:
            this.onBackPressed();
            break;
         case 2131296292:
            DialogUtils.a(null, this.getSupportFragmentManager(), 117, this.getString(2131755628), this.getString(2131755625));
            break;
         case 2131296307:
            this.j();
            break;
         default:
            var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   protected void onPause() {
      super.onPause();
      this.unregisterReceiver(this.o);
      this.getContentResolver().unregisterContentObserver(this.l);
   }

   @Override
   protected void onResume() {
      AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.PhotoViewerActivity");
      super.onResume();
      IntentFilter var1 = new IntentFilter();
      var1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      this.registerReceiver(this.o, var1);
      this.getContentResolver().registerContentObserver(this.getIntent().getData(), true, this.l);
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putInt("media_indx", this.g);
   }

   @Override
   protected void onStart() {
      AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.PhotoViewerActivity");
      super.onStart();
   }

   public class MediaAdapter extends FragmentStateCursorPagerAdapter {
      final PhotoViewerActivity a;

      public MediaAdapter(PhotoViewerActivity var1, FragmentManager var2, Cursor var3) {
         super(var2, var3);
         this.a = var1;
      }

      @Override
      public Fragment a(int var1) {
         return Fragment.instantiate(this.a, PhotoViewerActivity.PhotoFragment.class.getName(), null);
      }

      @Override
      public void a(Fragment var1, Cursor var2, int var3) {
         if (!var1.isAdded()) {
            Bundle var4 = new Bundle();
            var4.putInt("media_indx", var3);
            EntityData.a(var1.getActivity());
            Media var5 = EntityData.c(var2);
            if (var5 != null) {
               var4.putParcelable("entity", var5);
            }

            var1.setArguments(var4);
         }
      }
   }

   public static class PhotoFragment extends Fragment {
      public static int a = 0;
      Unbinder b;
      @BindView
      TouchImageView image;
      @BindView
      View progress;

      @OnClick
      public void onContentClick(View var1) {
         this.image.performClick();
      }

      @Override
      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         View var5 = var1.inflate(2131427472, var2, false);
         this.b = ButterKnife.a(this, var5);
         int var4 = this.getArguments().getInt("media_indx");
         Media var6 = (Media)this.getArguments().getParcelable("entity");
         LayoutParams var8 = new LayoutParams(-1, a);
         this.image.setLayoutParams(var8);
         this.progress.setVisibility(0);
         this.image.setEnabled(false);
         String var7 = MediaHelper.getUrl(SharedPreferencesUtil.g(this.getActivity().getApplicationContext()), var6);
         Glide.b(this.image.getContext()).a(var7).d().e().a(DiskCacheStrategy.ALL).a(new RequestListener<String, GlideDrawable>(this, var4) {
            final int a;
            final PhotoViewerActivity.PhotoFragment b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public boolean a(GlideDrawable var1, String var2x, Target<GlideDrawable> var3x, boolean var4x, boolean var5x) {
               if (!this.b.isDetached() && !this.b.isRemoving() && this.b.progress != null) {
                  this.b.getActivity().runOnUiThread(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        PhotoViewerActivity.f.put(this.a.a, true);
                        this.a.b.getActivity().invalidateOptionsMenu();
                        this.a.b.progress.setVisibility(8);
                        this.a.b.image.setEnabled(true);
                     }
                  });
               }

               return false;
            }

            public boolean a(Exception var1, String var2x, Target<GlideDrawable> var3x, boolean var4x) {
               if (!this.b.isDetached() && !this.b.isRemoving() && this.b.progress != null) {
                  this.b.getActivity().runOnUiThread(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        PhotoViewerActivity.f.put(this.a.a, false);
                        this.a.b.getActivity().invalidateOptionsMenu();
                        this.a.b.progress.setVisibility(8);
                        this.a.b.image.setImageBitmap(null);
                     }
                  });
               }

               return false;
            }
         }).a(this.image);
         this.image.setOnClickListener(new OnClickListener(this) {
            final PhotoViewerActivity.PhotoFragment a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               if (this.a.getResources().getConfiguration().orientation == 1) {
                  ((PhotoViewerActivity)this.a.getActivity()).f();
               }
            }
         });
         this.image.setOnTouchListener(new OnTouchListener(this) {
            final PhotoViewerActivity.PhotoFragment a;

            {
               this.a = var1;
            }

            public boolean onTouch(View var1, MotionEvent var2x) {
               if (this.a.getResources().getConfiguration().orientation == 2 && var2x.getActionMasked() == 0) {
                  ((PhotoViewerActivity)this.a.getActivity()).g();
               }

               return false;
            }
         });
         return var5;
      }

      @Override
      public void onDestroyView() {
         super.onDestroyView();
         this.b.unbind();
      }
   }

   public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
      final PhotoViewerActivity a;

      public ZoomOutPageTransformer(PhotoViewerActivity var1) {
         this.a = var1;
      }

      @Override
      public void a(View var1, float var2) {
         int var6 = var1.getWidth();
         int var7 = var1.getHeight();
         if (var2 < -1.0F) {
            var1.setAlpha(0.0F);
         } else if (var2 <= 1.0F) {
            float var3 = Math.max(0.95F, 1.0F - Math.abs(var2));
            float var4 = var7 * (1.0F - var3) / 2.0F;
            float var5 = var6 * (1.0F - var3) / 2.0F;
            if (var2 < 0.0F) {
               var1.setTranslationX(var5 - var4 / 2.0F);
            } else {
               var1.setTranslationX(-var5 + var4 / 2.0F);
            }

            var1.setScaleX(var3);
            var1.setScaleY(var3);
            var1.setAlpha((var3 - 0.95F) / 0.050000012F * 0.050000012F + 0.95F);
         } else {
            var1.setAlpha(0.0F);
         }
      }
   }
}
