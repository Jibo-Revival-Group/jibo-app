package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.StandaloneActionMode;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImplV9 extends AppCompatDelegateImplBase implements MenuBuilder.Callback, Factory2 {
   private static final boolean t;
   private View A;
   private boolean B;
   private boolean C;
   private boolean D;
   private AppCompatDelegateImplV9.PanelFeatureState[] E;
   private AppCompatDelegateImplV9.PanelFeatureState F;
   private boolean G;
   private final Runnable H;
   private boolean I;
   private Rect J;
   private Rect K;
   private AppCompatViewInflater L;
   ActionMode m;
   ActionBarContextView n;
   PopupWindow o;
   Runnable p;
   ViewPropertyAnimatorCompat q = null;
   boolean r;
   int s;
   private DecorContentParent u;
   private AppCompatDelegateImplV9.ActionMenuPresenterCallback v;
   private AppCompatDelegateImplV9.PanelMenuPresenterCallback w;
   private boolean x;
   private ViewGroup y;
   private TextView z;

   static {
      boolean var0;
      if (VERSION.SDK_INT < 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      t = var0;
   }

   AppCompatDelegateImplV9(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
      this.H = new Runnable(this) {
         final AppCompatDelegateImplV9 a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if ((this.a.s & 1) != 0) {
               this.a.f(0);
            }

            if ((this.a.s & 4096) != 0) {
               this.a.f(108);
            }

            this.a.r = false;
            this.a.s = 0;
         }
      };
   }

   private void A() {
      if (this.x) {
         throw new AndroidRuntimeException("Window feature must be requested before adding content");
      }
   }

   private void a(AppCompatDelegateImplV9.PanelFeatureState var1, KeyEvent var2) {
      byte var4 = -1;
      if (!var1.o && !this.q()) {
         if (var1.a == 0) {
            boolean var3;
            if ((this.a.getResources().getConfiguration().screenLayout & 15) == 4) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var3) {
               return;
            }
         }

         Callback var5 = this.r();
         if (var5 != null && !var5.onMenuOpened(var1.a, var1.j)) {
            this.a(var1, true);
         } else {
            WindowManager var12 = (WindowManager)this.a.getSystemService("window");
            if (var12 != null && this.b(var1, var2)) {
               int var11;
               label67:
               if (var1.g != null && !var1.q) {
                  if (var1.i != null) {
                     LayoutParams var8 = var1.i.getLayoutParams();
                     if (var8 != null) {
                        var11 = var4;
                        if (var8.width == -1) {
                           break label67;
                        }
                     }
                  }

                  var11 = -2;
               } else {
                  if (var1.g == null) {
                     if (!this.a(var1) || var1.g == null) {
                        return;
                     }
                  } else if (var1.q && var1.g.getChildCount() > 0) {
                     var1.g.removeAllViews();
                  }

                  if (!this.c(var1) || !var1.a()) {
                     return;
                  }

                  LayoutParams var7 = var1.h.getLayoutParams();
                  if (var7 == null) {
                     var7 = new LayoutParams(-2, -2);
                  }

                  var11 = var1.b;
                  var1.g.setBackgroundResource(var11);
                  ViewParent var6 = var1.h.getParent();
                  if (var6 != null && var6 instanceof ViewGroup) {
                     ((ViewGroup)var6).removeView(var1.h);
                  }

                  var1.g.addView(var1.h, var7);
                  if (!var1.h.hasFocus()) {
                     var1.h.requestFocus();
                  }

                  var11 = -2;
               }

               var1.n = false;
               android.view.WindowManager.LayoutParams var9 = new android.view.WindowManager.LayoutParams(var11, -2, var1.d, var1.e, 1002, 8519680, -3);
               var9.gravity = var1.c;
               var9.windowAnimations = var1.f;
               var12.addView(var1.g, var9);
               var1.o = true;
            }
         }
      }
   }

   private void a(MenuBuilder var1, boolean var2) {
      if (this.u != null && this.u.f() && (!ViewConfiguration.get(this.a).hasPermanentMenuKey() || this.u.h())) {
         Callback var5 = this.r();
         if (this.u.g() && var2) {
            this.u.j();
            if (!this.q()) {
               var5.onPanelClosed(108, this.a(0, true).j);
            }
         } else if (var5 != null && !this.q()) {
            if (this.r && (this.s & 1) != 0) {
               this.b.getDecorView().removeCallbacks(this.H);
               this.H.run();
            }

            AppCompatDelegateImplV9.PanelFeatureState var3 = this.a(0, true);
            if (var3.j != null && !var3.r && var5.onPreparePanel(0, var3.i, var3.j)) {
               var5.onMenuOpened(108, var3.j);
               this.u.i();
            }
         }
      } else {
         AppCompatDelegateImplV9.PanelFeatureState var4 = this.a(0, true);
         var4.q = true;
         this.a(var4, false);
         this.a(var4, null);
      }
   }

   private boolean a(AppCompatDelegateImplV9.PanelFeatureState var1) {
      var1.a(this.o());
      var1.g = new AppCompatDelegateImplV9.ListMenuDecorView(this, var1.l);
      var1.c = 81;
      return true;
   }

   private boolean a(AppCompatDelegateImplV9.PanelFeatureState var1, int var2, KeyEvent var3, int var4) {
      boolean var6 = false;
      boolean var5 = false;
      if (var3.isSystem()) {
         var6 = var5;
      } else {
         label22: {
            if (!var1.m) {
               var5 = var6;
               if (!this.b(var1, var3)) {
                  break label22;
               }
            }

            var5 = var6;
            if (var1.j != null) {
               var5 = var1.j.performShortcut(var2, var3, var4);
            }
         }

         var6 = var5;
         if (var5) {
            var6 = var5;
            if ((var4 & 1) == 0) {
               var6 = var5;
               if (this.u == null) {
                  this.a(var1, true);
                  var6 = var5;
               }
            }
         }
      }

      return var6;
   }

   private boolean a(ViewParent var1) {
      boolean var2;
      if (var1 == null) {
         var2 = false;
      } else {
         View var3 = this.b.getDecorView();

         while (true) {
            if (var1 == null) {
               var2 = true;
               break;
            }

            if (var1 == var3 || !(var1 instanceof View) || ViewCompat.B((View)var1)) {
               var2 = false;
               break;
            }

            var1 = var1.getParent();
         }
      }

      return var2;
   }

   private boolean b(AppCompatDelegateImplV9.PanelFeatureState var1) {
      Object var7;
      label34: {
         Context var4 = this.a;
         if ((var1.a == 0 || var1.a == 108) && this.u != null) {
            TypedValue var5 = new TypedValue();
            Theme var6 = var4.getTheme();
            var6.resolveAttribute(R.attr.actionBarTheme, var5, true);
            Theme var2 = null;
            if (var5.resourceId != 0) {
               var2 = var4.getResources().newTheme();
               var2.setTo(var6);
               var2.applyStyle(var5.resourceId, true);
               var2.resolveAttribute(R.attr.actionBarWidgetTheme, var5, true);
            } else {
               var6.resolveAttribute(R.attr.actionBarWidgetTheme, var5, true);
            }

            Theme var3 = var2;
            if (var5.resourceId != 0) {
               var3 = var2;
               if (var2 == null) {
                  var3 = var4.getResources().newTheme();
                  var3.setTo(var6);
               }

               var3.applyStyle(var5.resourceId, true);
            }

            if (var3 != null) {
               var7 = new ContextThemeWrapper(var4, 0);
               var7.getTheme().setTo(var3);
               break label34;
            }
         }

         var7 = var4;
      }

      MenuBuilder var8 = new MenuBuilder((Context)var7);
      var8.a(this);
      var1.a(var8);
      return true;
   }

   private boolean b(AppCompatDelegateImplV9.PanelFeatureState var1, KeyEvent var2) {
      boolean var5 = false;
      boolean var4;
      if (this.q()) {
         var4 = var5;
      } else if (var1.m) {
         var4 = true;
      } else {
         if (this.F != null && this.F != var1) {
            this.a(this.F, false);
         }

         Callback var6 = this.r();
         if (var6 != null) {
            var1.i = var6.onCreatePanelView(var1.a);
         }

         boolean var3;
         if (var1.a != 0 && var1.a != 108) {
            var3 = 0;
         } else {
            var3 = 1;
         }

         if (var3 && this.u != null) {
            this.u.k();
         }

         if (var1.i == null && (!var3 || !(this.n() instanceof ToolbarActionBar))) {
            if (var1.j == null || var1.r) {
               if (var1.j == null) {
                  var4 = var5;
                  if (!this.b(var1)) {
                     return var4;
                  }

                  var4 = var5;
                  if (var1.j == null) {
                     return var4;
                  }
               }

               if (var3 && this.u != null) {
                  if (this.v == null) {
                     this.v = new AppCompatDelegateImplV9.ActionMenuPresenterCallback(this);
                  }

                  this.u.a(var1.j, this.v);
               }

               var1.j.g();
               if (!var6.onCreatePanelMenu(var1.a, var1.j)) {
                  var1.a((MenuBuilder)null);
                  var4 = var5;
                  if (var3) {
                     var4 = var5;
                     if (this.u != null) {
                        this.u.a(null, this.v);
                        var4 = var5;
                        return var4;
                     }
                  }

                  return var4;
               }

               var1.r = false;
            }

            var1.j.g();
            if (var1.s != null) {
               var1.j.d(var1.s);
               var1.s = null;
            }

            if (!var6.onPreparePanel(0, var1.i, var1.j)) {
               if (var3 && this.u != null) {
                  this.u.a(null, this.v);
               }

               var1.j.h();
               return var5;
            }

            if (var2 != null) {
               var3 = var2.getDeviceId();
            } else {
               var3 = -1;
            }

            if (KeyCharacterMap.load(var3).getKeyboardType() != 1) {
               var4 = true;
            } else {
               var4 = false;
            }

            var1.p = var4;
            var1.j.setQwertyMode(var1.p);
            var1.j.h();
         }

         var1.m = true;
         var1.n = false;
         this.F = var1;
         var4 = true;
      }

      return var4;
   }

   private boolean c(AppCompatDelegateImplV9.PanelFeatureState var1) {
      boolean var2 = true;
      if (var1.i != null) {
         var1.h = var1.i;
      } else if (var1.j == null) {
         var2 = false;
      } else {
         if (this.w == null) {
            this.w = new AppCompatDelegateImplV9.PanelMenuPresenterCallback(this);
         }

         var1.h = (View)var1.a(this.w);
         if (var1.h != null) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   private void d(int var1) {
      this.s |= 1 << var1;
      if (!this.r) {
         ViewCompat.a(this.b.getDecorView(), this.H);
         this.r = true;
      }
   }

   private boolean d(int var1, KeyEvent var2) {
      if (var2.getRepeatCount() == 0) {
         AppCompatDelegateImplV9.PanelFeatureState var4 = this.a(var1, true);
         if (!var4.o) {
            return this.b(var4, var2);
         }
      }

      return false;
   }

   private boolean e(int var1, KeyEvent var2) {
      boolean var4 = true;
      boolean var3;
      if (this.m != null) {
         var3 = false;
      } else {
         label60: {
            AppCompatDelegateImplV9.PanelFeatureState var5 = this.a(var1, true);
            if (var1 == 0 && this.u != null && this.u.f() && !ViewConfiguration.get(this.a).hasPermanentMenuKey()) {
               if (this.u.g()) {
                  var3 = this.u.j();
                  break label60;
               }

               if (!this.q() && this.b(var5, var2)) {
                  var3 = this.u.i();
                  break label60;
               }
            } else {
               if (var5.o || var5.n) {
                  var3 = var5.o;
                  this.a(var5, true);
                  break label60;
               }

               if (var5.m) {
                  if (var5.r) {
                     var5.m = false;
                     var3 = this.b(var5, var2);
                  } else {
                     var3 = true;
                  }

                  if (var3) {
                     this.a(var5, var2);
                     var3 = var4;
                     break label60;
                  }
               }
            }

            var3 = false;
         }

         if (var3) {
            AudioManager var6 = (AudioManager)this.a.getSystemService("audio");
            if (var6 != null) {
               var6.playSoundEffect(0);
            } else {
               Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
         }
      }

      return var3;
   }

   private int h(int var1) {
      int var2;
      if (var1 == 8) {
         Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
         var2 = 108;
      } else {
         var2 = var1;
         if (var1 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            var2 = 109;
         }
      }

      return var2;
   }

   private void x() {
      if (!this.x) {
         this.y = this.y();
         CharSequence var1 = this.s();
         if (!TextUtils.isEmpty(var1)) {
            this.b(var1);
         }

         this.z();
         this.a(this.y);
         this.x = true;
         AppCompatDelegateImplV9.PanelFeatureState var2 = this.a(0, false);
         if (!this.q() && (var2 == null || var2.j == null)) {
            this.d(108);
         }
      }
   }

   private ViewGroup y() {
      TypedArray var1 = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
      if (!var1.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
         var1.recycle();
         throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }

      if (var1.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
         this.c(1);
      } else if (var1.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
         this.c(108);
      }

      if (var1.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
         this.c(109);
      }

      if (var1.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
         this.c(10);
      }

      this.k = var1.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      var1.recycle();
      this.b.getDecorView();
      LayoutInflater var5 = LayoutInflater.from(this.a);
      ViewGroup var6;
      if (!this.l) {
         if (this.k) {
            var6 = (ViewGroup)var5.inflate(R.layout.abc_dialog_title_material, null);
            this.i = false;
            this.h = false;
         } else if (this.h) {
            TypedValue var7 = new TypedValue();
            this.a.getTheme().resolveAttribute(R.attr.actionBarTheme, var7, true);
            Object var8;
            if (var7.resourceId != 0) {
               var8 = new ContextThemeWrapper(this.a, var7.resourceId);
            } else {
               var8 = this.a;
            }

            var6 = (ViewGroup)LayoutInflater.from((Context)var8).inflate(R.layout.abc_screen_toolbar, null);
            this.u = (DecorContentParent)var6.findViewById(R.id.decor_content_parent);
            this.u.setWindowCallback(this.r());
            if (this.i) {
               this.u.a(109);
            }

            if (this.B) {
               this.u.a(2);
            }

            if (this.C) {
               this.u.a(5);
            }
         } else {
            var6 = null;
         }
      } else {
         if (this.j) {
            var6 = (ViewGroup)var5.inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
         } else {
            var6 = (ViewGroup)var5.inflate(R.layout.abc_screen_simple, null);
         }

         if (VERSION.SDK_INT >= 21) {
            ViewCompat.a(var6, new OnApplyWindowInsetsListener(this) {
               final AppCompatDelegateImplV9 a;

               {
                  this.a = var1;
               }

               @Override
               public WindowInsetsCompat a(View var1, WindowInsetsCompat var2) {
                  int var3 = var2.b();
                  int var4 = this.a.g(var3);
                  WindowInsetsCompat var5x = var2;
                  if (var3 != var4) {
                     var5x = var2.a(var2.a(), var4, var2.c(), var2.d());
                  }

                  return ViewCompat.a(var1, var5x);
               }
            });
         } else {
            ((FitWindowsViewGroup)var6).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener(this) {
               final AppCompatDelegateImplV9 a;

               {
                  this.a = var1;
               }

               @Override
               public void a(Rect var1) {
                  var1.top = this.a.g(var1.top);
               }
            });
         }
      }

      if (var6 == null) {
         throw new IllegalArgumentException(
            "AppCompat does not support the current theme features: { windowActionBar: "
               + this.h
               + ", windowActionBarOverlay: "
               + this.i
               + ", android:windowIsFloating: "
               + this.k
               + ", windowActionModeOverlay: "
               + this.j
               + ", windowNoTitle: "
               + this.l
               + " }"
         );
      }

      if (this.u == null) {
         this.z = (TextView)var6.findViewById(R.id.title);
      }

      ViewUtils.b(var6);
      ContentFrameLayout var4 = (ContentFrameLayout)var6.findViewById(R.id.action_bar_activity_content);
      ViewGroup var2 = (ViewGroup)this.b.findViewById(16908290);
      if (var2 != null) {
         while (var2.getChildCount() > 0) {
            View var3 = var2.getChildAt(0);
            var2.removeViewAt(0);
            var4.addView(var3);
         }

         var2.setId(-1);
         var4.setId(16908290);
         if (var2 instanceof FrameLayout) {
            ((FrameLayout)var2).setForeground(null);
         }
      }

      this.b.setContentView(var6);
      var4.setAttachListener(new ContentFrameLayout.OnAttachListener(this) {
         final AppCompatDelegateImplV9 a;

         {
            this.a = var1;
         }

         @Override
         public void a() {
         }

         @Override
         public void b() {
            this.a.w();
         }
      });
      return var6;
   }

   private void z() {
      ContentFrameLayout var1 = (ContentFrameLayout)this.y.findViewById(16908290);
      View var2 = this.b.getDecorView();
      var1.a(var2.getPaddingLeft(), var2.getPaddingTop(), var2.getPaddingRight(), var2.getPaddingBottom());
      TypedArray var3 = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
      var3.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, var1.getMinWidthMajor());
      var3.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, var1.getMinWidthMinor());
      if (var3.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
         var3.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, var1.getFixedWidthMajor());
      }

      if (var3.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
         var3.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, var1.getFixedWidthMinor());
      }

      if (var3.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
         var3.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, var1.getFixedHeightMajor());
      }

      if (var3.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
         var3.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, var1.getFixedHeightMinor());
      }

      var3.recycle();
      var1.requestLayout();
   }

   protected AppCompatDelegateImplV9.PanelFeatureState a(int var1, boolean var2) {
      AppCompatDelegateImplV9.PanelFeatureState[] var3;
      label23: {
         AppCompatDelegateImplV9.PanelFeatureState[] var4 = this.E;
         if (var4 != null) {
            var3 = var4;
            if (var4.length > var1) {
               break label23;
            }
         }

         var3 = new AppCompatDelegateImplV9.PanelFeatureState[var1 + 1];
         if (var4 != null) {
            System.arraycopy(var4, 0, var3, 0, var4.length);
         }

         this.E = var3;
      }

      AppCompatDelegateImplV9.PanelFeatureState var6 = var3[var1];
      AppCompatDelegateImplV9.PanelFeatureState var5;
      if (var6 == null) {
         var6 = new AppCompatDelegateImplV9.PanelFeatureState(var1);
         var3[var1] = var6;
         var5 = var6;
      } else {
         var5 = var6;
      }

      return var5;
   }

   AppCompatDelegateImplV9.PanelFeatureState a(Menu var1) {
      AppCompatDelegateImplV9.PanelFeatureState[] var5 = this.E;
      int var2;
      if (var5 != null) {
         var2 = var5.length;
      } else {
         var2 = 0;
      }

      int var3 = 0;

      while (true) {
         if (var3 >= var2) {
            var6 = null;
            break;
         }

         AppCompatDelegateImplV9.PanelFeatureState var4 = var5[var3];
         if (var4 != null && var4.j == var1) {
            var6 = var4;
            break;
         }

         var3++;
      }

      return var6;
   }

   @Override
   public ActionMode a(ActionMode.Callback var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("ActionMode callback can not be null.");
      }

      if (this.m != null) {
         this.m.c();
      }

      var1 = new AppCompatDelegateImplV9.ActionModeCallbackWrapperV9(this, var1);
      ActionBar var2 = this.a();
      if (var2 != null) {
         this.m = var2.startActionMode(var1);
         if (this.m != null && this.e != null) {
            this.e.onSupportActionModeStarted(this.m);
         }
      }

      if (this.m == null) {
         this.m = this.b(var1);
      }

      return this.m;
   }

   @Override
   public <T extends View> T a(int var1) {
      this.x();
      return (T)this.b.findViewById(var1);
   }

   View a(View var1, String var2, Context var3, AttributeSet var4) {
      if (this.c instanceof Factory) {
         var1 = ((Factory)this.c).onCreateView(var2, var3, var4);
         if (var1 != null) {
            return var1;
         }
      }

      return null;
   }

   void a(int var1, AppCompatDelegateImplV9.PanelFeatureState var2, Menu var3) {
      AppCompatDelegateImplV9.PanelFeatureState var6 = var2;
      Menu var5 = var3;
      if (var3 == null) {
         AppCompatDelegateImplV9.PanelFeatureState var4 = var2;
         if (var2 == null) {
            var4 = var2;
            if (var1 >= 0) {
               var4 = var2;
               if (var1 < this.E.length) {
                  var4 = this.E[var1];
               }
            }
         }

         var6 = var4;
         var5 = var3;
         if (var4 != null) {
            var5 = var4.j;
            var6 = var4;
         }
      }

      if ((var6 == null || var6.o) && !this.q()) {
         this.c.onPanelClosed(var1, var5);
      }
   }

   @Override
   void a(int var1, Menu var2) {
      if (var1 == 108) {
         ActionBar var3 = this.a();
         if (var3 != null) {
            var3.dispatchMenuVisibilityChanged(false);
         }
      } else if (var1 == 0) {
         AppCompatDelegateImplV9.PanelFeatureState var4 = this.a(var1, true);
         if (var4.o) {
            this.a(var4, false);
         }
      }
   }

   @Override
   public void a(Configuration var1) {
      if (this.h && this.x) {
         ActionBar var2 = this.a();
         if (var2 != null) {
            var2.onConfigurationChanged(var1);
         }
      }

      AppCompatDrawableManager.a().a(this.a);
      this.j();
   }

   @Override
   public void a(Bundle var1) {
      if (this.c instanceof Activity && NavUtils.b((Activity)this.c) != null) {
         ActionBar var2 = this.n();
         if (var2 == null) {
            this.I = true;
         } else {
            var2.setDefaultDisplayHomeAsUpEnabled(true);
         }
      }
   }

   void a(AppCompatDelegateImplV9.PanelFeatureState var1, boolean var2) {
      if (var2 && var1.a == 0 && this.u != null && this.u.g()) {
         this.b(var1.j);
      } else {
         WindowManager var3 = (WindowManager)this.a.getSystemService("window");
         if (var3 != null && var1.o && var1.g != null) {
            var3.removeView(var1.g);
            if (var2) {
               this.a(var1.a, var1, null);
            }
         }

         var1.m = false;
         var1.n = false;
         var1.o = false;
         var1.h = null;
         var1.q = true;
         if (this.F == var1) {
            this.F = null;
         }
      }
   }

   @Override
   public void a(MenuBuilder var1) {
      this.a(var1, true);
   }

   @Override
   public void a(Toolbar var1) {
      if (this.c instanceof Activity) {
         ActionBar var2 = this.a();
         if (var2 instanceof WindowDecorActionBar) {
            throw new IllegalStateException(
               "This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead."
            );
         }

         this.g = null;
         if (var2 != null) {
            var2.onDestroy();
         }

         if (var1 != null) {
            ToolbarActionBar var3 = new ToolbarActionBar(var1, ((Activity)this.c).getTitle(), this.d);
            this.f = var3;
            this.b.setCallback(var3.getWrappedWindowCallback());
         } else {
            this.f = null;
            this.b.setCallback(this.d);
         }

         this.f();
      }
   }

   @Override
   public void a(View var1) {
      this.x();
      ViewGroup var2 = (ViewGroup)this.y.findViewById(16908290);
      var2.removeAllViews();
      var2.addView(var1);
      this.c.onContentChanged();
   }

   @Override
   public void a(View var1, LayoutParams var2) {
      this.x();
      ViewGroup var3 = (ViewGroup)this.y.findViewById(16908290);
      var3.removeAllViews();
      var3.addView(var1, var2);
      this.c.onContentChanged();
   }

   void a(ViewGroup var1) {
   }

   @Override
   boolean a(int var1, KeyEvent var2) {
      boolean var4 = true;
      ActionBar var6 = this.a();
      boolean var8;
      if (var6 != null && var6.onKeyShortcut(var1, var2)) {
         var8 = var4;
      } else if (this.F != null && this.a(this.F, var2.getKeyCode(), var2, 1)) {
         var8 = var4;
         if (this.F != null) {
            this.F.n = true;
            var8 = var4;
         }
      } else {
         if (this.F == null) {
            AppCompatDelegateImplV9.PanelFeatureState var7 = this.a(0, true);
            this.b(var7, var2);
            boolean var5 = this.a(var7, var2.getKeyCode(), var2, 1);
            var7.m = false;
            var8 = var4;
            if (var5) {
               return var8;
            }
         }

         var8 = false;
      }

      return var8;
   }

   @Override
   public boolean a(MenuBuilder var1, MenuItem var2) {
      Callback var4 = this.r();
      if (var4 != null && !this.q()) {
         AppCompatDelegateImplV9.PanelFeatureState var5 = this.a((Menu)var1.p());
         if (var5 != null) {
            return var4.onMenuItemSelected(var5.a, var2);
         }
      }

      return false;
   }

   @Override
   boolean a(KeyEvent var1) {
      boolean var2 = true;
      boolean var4 = true;
      if (var1.getKeyCode() != 82 || !this.c.dispatchKeyEvent(var1)) {
         int var3 = var1.getKeyCode();
         if (var1.getAction() != 0) {
            var2 = false;
         }

         if (var2) {
            var4 = this.c(var3, var1);
         } else {
            var4 = this.b(var3, var1);
         }
      }

      return var4;
   }

   @Override
   ActionMode b(ActionMode.Callback var1) {
      this.u();
      if (this.m != null) {
         this.m.c();
      }

      ActionMode.Callback var4 = var1;
      if (!(var1 instanceof AppCompatDelegateImplV9.ActionModeCallbackWrapperV9)) {
         var4 = new AppCompatDelegateImplV9.ActionModeCallbackWrapperV9(this, var1);
      }

      ActionMode var8;
      if (this.e != null && !this.q()) {
         try {
            var8 = this.e.onWindowStartingSupportActionMode(var4);
         } catch (AbstractMethodError var7) {
            var8 = null;
         }
      } else {
         var8 = null;
      }

      if (var8 != null) {
         this.m = var8;
      } else {
         if (this.n == null) {
            if (this.k) {
               TypedValue var5 = new TypedValue();
               Theme var9 = this.a.getTheme();
               var9.resolveAttribute(R.attr.actionBarTheme, var5, true);
               Object var10;
               if (var5.resourceId != 0) {
                  Theme var6 = this.a.getResources().newTheme();
                  var6.setTo(var9);
                  var6.applyStyle(var5.resourceId, true);
                  var10 = new ContextThemeWrapper(this.a, 0);
                  var10.getTheme().setTo(var6);
               } else {
                  var10 = this.a;
               }

               this.n = new ActionBarContextView((Context)var10);
               this.o = new PopupWindow((Context)var10, null, R.attr.actionModePopupWindowStyle);
               PopupWindowCompat.a(this.o, 2);
               this.o.setContentView(this.n);
               this.o.setWidth(-1);
               var10.getTheme().resolveAttribute(R.attr.actionBarSize, var5, true);
               int var2 = TypedValue.complexToDimensionPixelSize(var5.data, var10.getResources().getDisplayMetrics());
               this.n.setContentHeight(var2);
               this.o.setHeight(-2);
               this.p = new Runnable(this) {
                  final AppCompatDelegateImplV9 a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     this.a.o.showAtLocation(this.a.n, 55, 0, 0);
                     this.a.u();
                     if (this.a.t()) {
                        this.a.n.setAlpha(0.0F);
                        this.a.q = ViewCompat.l(this.a.n).a(1.0F);
                        this.a.q.a(new ViewPropertyAnimatorListenerAdapter(this) {
                           final <unrepresentable> a;

                           {
                              this.a = var1;
                           }

                           @Override
                           public void a(View var1) {
                              this.a.a.n.setVisibility(0);
                           }

                           @Override
                           public void b(View var1) {
                              this.a.a.n.setAlpha(1.0F);
                              this.a.a.q.a((ViewPropertyAnimatorListener)null);
                              this.a.a.q = null;
                           }
                        });
                     } else {
                        this.a.n.setAlpha(1.0F);
                        this.a.n.setVisibility(0);
                     }
                  }
               };
            } else {
               ViewStubCompat var11 = (ViewStubCompat)this.y.findViewById(R.id.action_mode_bar_stub);
               if (var11 != null) {
                  var11.setLayoutInflater(LayoutInflater.from(this.o()));
                  this.n = (ActionBarContextView)var11.a();
               }
            }
         }

         if (this.n != null) {
            this.u();
            this.n.c();
            Context var14 = this.n.getContext();
            ActionBarContextView var12 = this.n;
            boolean var3;
            if (this.o == null) {
               var3 = true;
            } else {
               var3 = false;
            }

            StandaloneActionMode var13 = new StandaloneActionMode(var14, var12, var4, var3);
            if (var4.a(var13, var13.b())) {
               var13.d();
               this.n.a(var13);
               this.m = var13;
               if (this.t()) {
                  this.n.setAlpha(0.0F);
                  this.q = ViewCompat.l(this.n).a(1.0F);
                  this.q.a(new ViewPropertyAnimatorListenerAdapter(this) {
                     final AppCompatDelegateImplV9 a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void a(View var1) {
                        this.a.n.setVisibility(0);
                        this.a.n.sendAccessibilityEvent(32);
                        if (this.a.n.getParent() instanceof View) {
                           ViewCompat.q((View)this.a.n.getParent());
                        }
                     }

                     @Override
                     public void b(View var1) {
                        this.a.n.setAlpha(1.0F);
                        this.a.q.a((ViewPropertyAnimatorListener)null);
                        this.a.q = null;
                     }
                  });
               } else {
                  this.n.setAlpha(1.0F);
                  this.n.setVisibility(0);
                  this.n.sendAccessibilityEvent(32);
                  if (this.n.getParent() instanceof View) {
                     ViewCompat.q((View)this.n.getParent());
                  }
               }

               if (this.o != null) {
                  this.b.getDecorView().post(this.p);
               }
            } else {
               this.m = null;
            }
         }
      }

      if (this.m != null && this.e != null) {
         this.e.onSupportActionModeStarted(this.m);
      }

      return this.m;
   }

   public View b(View var1, String var2, Context var3, AttributeSet var4) {
      if (this.L == null) {
         String var7 = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
         if (var7 != null && !AppCompatViewInflater.class.getName().equals(var7)) {
            try {
               this.L = (AppCompatViewInflater)Class.forName(var7).getDeclaredConstructor().newInstance();
            } catch (Throwable var8) {
               Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + var7 + ". Falling back to default.", var8);
               this.L = new AppCompatViewInflater();
            }
         } else {
            this.L = new AppCompatViewInflater();
         }
      }

      boolean var5;
      if (t) {
         if (var4 instanceof XmlPullParser) {
            if (((XmlPullParser)var4).getDepth() > 1) {
               var5 = true;
            } else {
               var5 = false;
            }
         } else {
            var5 = this.a((ViewParent)var1);
         }
      } else {
         var5 = false;
      }

      return this.L.a(var1, var2, var3, var4, var5, t, true, VectorEnabledTintResources.a());
   }

   @Override
   public void b(int var1) {
      this.x();
      ViewGroup var2 = (ViewGroup)this.y.findViewById(16908290);
      var2.removeAllViews();
      LayoutInflater.from(this.a).inflate(var1, var2);
      this.c.onContentChanged();
   }

   @Override
   public void b(Bundle var1) {
      this.x();
   }

   void b(MenuBuilder var1) {
      if (!this.D) {
         this.D = true;
         this.u.l();
         Callback var2 = this.r();
         if (var2 != null && !this.q()) {
            var2.onPanelClosed(108, var1);
         }

         this.D = false;
      }
   }

   @Override
   public void b(View var1, LayoutParams var2) {
      this.x();
      ((ViewGroup)this.y.findViewById(16908290)).addView(var1, var2);
      this.c.onContentChanged();
   }

   @Override
   void b(CharSequence var1) {
      if (this.u != null) {
         this.u.setWindowTitle(var1);
      } else if (this.n() != null) {
         this.n().setWindowTitle(var1);
      } else if (this.z != null) {
         this.z.setText(var1);
      }
   }

   boolean b(int var1, KeyEvent var2) {
      boolean var4 = true;
      boolean var3;
      switch (var1) {
         case 4:
            boolean var5 = this.G;
            this.G = false;
            AppCompatDelegateImplV9.PanelFeatureState var6 = this.a(0, false);
            if (var6 != null && var6.o) {
               var3 = var4;
               if (!var5) {
                  this.a(var6, true);
                  var3 = var4;
               }
               break;
            } else if (this.v()) {
               var3 = var4;
               break;
            }
         default:
            var3 = false;
            break;
         case 82:
            this.e(0, var2);
            var3 = var4;
      }

      return var3;
   }

   @Override
   boolean b(int var1, Menu var2) {
      boolean var4 = true;
      boolean var3;
      if (var1 == 108) {
         ActionBar var5 = this.a();
         var3 = var4;
         if (var5 != null) {
            var5.dispatchMenuVisibilityChanged(true);
            var3 = var4;
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public boolean c(int var1) {
      boolean var2 = false;
      var1 = this.h(var1);
      if (!this.l || var1 != 108) {
         if (this.h && var1 == 1) {
            this.h = false;
         }

         switch (var1) {
            case 1:
               this.A();
               this.l = true;
               var2 = true;
               break;
            case 2:
               this.A();
               this.B = true;
               var2 = true;
               break;
            case 5:
               this.A();
               this.C = true;
               var2 = true;
               break;
            case 10:
               this.A();
               this.j = true;
               var2 = true;
               break;
            case 108:
               this.A();
               this.h = true;
               var2 = true;
               break;
            case 109:
               this.A();
               this.i = true;
               var2 = true;
               break;
            default:
               var2 = this.b.requestFeature(var1);
         }
      }

      return var2;
   }

   boolean c(int var1, KeyEvent var2) {
      boolean var4 = true;
      boolean var3 = true;
      switch (var1) {
         case 4:
            if ((var2.getFlags() & 128) != 0) {
               var3 = var4;
            } else {
               var3 = false;
            }

            this.G = var3;
         default:
            var3 = false;
            break;
         case 82:
            this.d(0, var2);
      }

      return var3;
   }

   @Override
   public void d() {
      ActionBar var1 = this.a();
      if (var1 != null) {
         var1.setShowHideAnimationEnabled(false);
      }
   }

   @Override
   public void e() {
      ActionBar var1 = this.a();
      if (var1 != null) {
         var1.setShowHideAnimationEnabled(true);
      }
   }

   void e(int var1) {
      this.a(this.a(var1, true), true);
   }

   @Override
   public void f() {
      ActionBar var1 = this.a();
      if (var1 == null || !var1.invalidateOptionsMenu()) {
         this.d(0);
      }
   }

   void f(int var1) {
      AppCompatDelegateImplV9.PanelFeatureState var3 = this.a(var1, true);
      if (var3.j != null) {
         Bundle var2 = new Bundle();
         var3.j.c(var2);
         if (var2.size() > 0) {
            var3.s = var2;
         }

         var3.j.g();
         var3.j.clear();
      }

      var3.r = true;
      var3.q = true;
      if ((var1 == 108 || var1 == 0) && this.u != null) {
         AppCompatDelegateImplV9.PanelFeatureState var4 = this.a(0, false);
         if (var4 != null) {
            var4.m = false;
            this.b(var4, null);
         }
      }
   }

   int g(int var1) {
      int var3 = 1;
      boolean var4 = true;
      byte var5 = 0;
      boolean var2;
      if (this.n != null && this.n.getLayoutParams() instanceof MarginLayoutParams) {
         MarginLayoutParams var6 = (MarginLayoutParams)this.n.getLayoutParams();
         if (this.n.isShown()) {
            if (this.J == null) {
               this.J = new Rect();
               this.K = new Rect();
            }

            Rect var8 = this.J;
            Rect var7 = this.K;
            var8.set(0, var1, 0, 0);
            ViewUtils.a(this.y, var8, var7);
            if (var7.top == 0) {
               var2 = var1;
            } else {
               var2 = 0;
            }

            boolean var10;
            if (var6.topMargin != var2) {
               var6.topMargin = var1;
               if (this.A == null) {
                  this.A = new View(this.a);
                  this.A.setBackgroundColor(this.a.getResources().getColor(R.color.abc_input_method_navigation_guard));
                  this.y.addView(this.A, -1, new LayoutParams(-1, var1));
                  var10 = true;
               } else {
                  LayoutParams var14 = this.A.getLayoutParams();
                  if (var14.height != var1) {
                     var14.height = var1;
                     this.A.setLayoutParams(var14);
                  }

                  var10 = true;
               }
            } else {
               var10 = false;
            }

            if (this.A == null) {
               var4 = false;
            }

            var3 = var1;
            if (!this.j) {
               var3 = var1;
               if (var4) {
                  var3 = 0;
               }
            }

            var1 = var3;
            var3 = var10;
            var2 = var4;
         } else if (var6.topMargin != 0) {
            var6.topMargin = 0;
            var2 = 0;
         } else {
            var3 = 0;
            var2 = 0;
         }

         if (var3) {
            this.n.setLayoutParams(var6);
         }
      } else {
         var2 = 0;
      }

      if (this.A != null) {
         View var13 = this.A;
         byte var11;
         if (var2) {
            var11 = var5;
         } else {
            var11 = 8;
         }

         var13.setVisibility(var11);
      }

      return var1;
   }

   @Override
   public void g() {
      if (this.r) {
         this.b.getDecorView().removeCallbacks(this.H);
      }

      super.g();
      if (this.f != null) {
         this.f.onDestroy();
      }
   }

   @Override
   public void i() {
      LayoutInflater var1 = LayoutInflater.from(this.a);
      if (var1.getFactory() == null) {
         LayoutInflaterCompat.b(var1, this);
      } else if (!(var1.getFactory2() instanceof AppCompatDelegateImplV9)) {
         Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
      }
   }

   @Override
   public void m() {
      this.x();
      if (this.h && this.f == null) {
         if (this.c instanceof Activity) {
            this.f = new WindowDecorActionBar((Activity)this.c, this.i);
         } else if (this.c instanceof Dialog) {
            this.f = new WindowDecorActionBar((Dialog)this.c);
         }

         if (this.f != null) {
            this.f.setDefaultDisplayHomeAsUpEnabled(this.I);
         }
      }
   }

   public final View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      View var5 = this.a(var1, var2, var3, var4);
      if (var5 != null) {
         var1 = var5;
      } else {
         var1 = this.b(var1, var2, var3, var4);
      }

      return var1;
   }

   public View onCreateView(String var1, Context var2, AttributeSet var3) {
      return this.onCreateView(null, var1, var2, var3);
   }

   final boolean t() {
      boolean var1;
      if (this.x && this.y != null && ViewCompat.y(this.y)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   void u() {
      if (this.q != null) {
         this.q.b();
      }
   }

   boolean v() {
      boolean var1 = true;
      if (this.m != null) {
         this.m.c();
      } else {
         ActionBar var2 = this.a();
         if (var2 == null || !var2.collapseActionView()) {
            var1 = false;
         }
      }

      return var1;
   }

   void w() {
      if (this.u != null) {
         this.u.l();
      }

      if (this.o != null) {
         this.b.getDecorView().removeCallbacks(this.p);
         if (this.o.isShowing()) {
            try {
               this.o.dismiss();
            } catch (IllegalArgumentException var2) {
            }
         }

         this.o = null;
      }

      this.u();
      AppCompatDelegateImplV9.PanelFeatureState var1 = this.a(0, false);
      if (var1 != null && var1.j != null) {
         var1.j.close();
      }
   }

   private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
      final AppCompatDelegateImplV9 a;

      ActionMenuPresenterCallback(AppCompatDelegateImplV9 var1) {
         this.a = var1;
      }

      @Override
      public void a(MenuBuilder var1, boolean var2) {
         this.a.b(var1);
      }

      @Override
      public boolean a(MenuBuilder var1) {
         Callback var2 = this.a.r();
         if (var2 != null) {
            var2.onMenuOpened(108, var1);
         }

         return true;
      }
   }

   class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
      final AppCompatDelegateImplV9 a;
      private ActionMode.Callback b;

      public ActionModeCallbackWrapperV9(AppCompatDelegateImplV9 var1, ActionMode.Callback var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a(ActionMode var1) {
         this.b.a(var1);
         if (this.a.o != null) {
            this.a.b.getDecorView().removeCallbacks(this.a.p);
         }

         if (this.a.n != null) {
            this.a.u();
            this.a.q = ViewCompat.l(this.a.n).a(0.0F);
            this.a.q.a(new ViewPropertyAnimatorListenerAdapter(this) {
               final AppCompatDelegateImplV9.ActionModeCallbackWrapperV9 a;

               {
                  this.a = var1;
               }

               @Override
               public void b(View var1) {
                  this.a.a.n.setVisibility(8);
                  if (this.a.a.o != null) {
                     this.a.a.o.dismiss();
                  } else if (this.a.a.n.getParent() instanceof View) {
                     ViewCompat.q((View)this.a.a.n.getParent());
                  }

                  this.a.a.n.removeAllViews();
                  this.a.a.q.a((ViewPropertyAnimatorListener)null);
                  this.a.a.q = null;
               }
            });
         }

         if (this.a.e != null) {
            this.a.e.onSupportActionModeFinished(this.a.m);
         }

         this.a.m = null;
      }

      @Override
      public boolean a(ActionMode var1, Menu var2) {
         return this.b.a(var1, var2);
      }

      @Override
      public boolean a(ActionMode var1, MenuItem var2) {
         return this.b.a(var1, var2);
      }

      @Override
      public boolean b(ActionMode var1, Menu var2) {
         return this.b.b(var1, var2);
      }
   }

   private class ListMenuDecorView extends ContentFrameLayout {
      final AppCompatDelegateImplV9 a;

      public ListMenuDecorView(AppCompatDelegateImplV9 var1, Context var2) {
         super(var2);
         this.a = var1;
      }

      private boolean a(int var1, int var2) {
         boolean var3;
         if (var1 >= -5 && var2 >= -5 && var1 <= this.getWidth() + 5 && var2 <= this.getHeight() + 5) {
            var3 = false;
         } else {
            var3 = true;
         }

         return var3;
      }

      public boolean dispatchKeyEvent(KeyEvent var1) {
         boolean var2;
         if (!this.a.a(var1) && !super.dispatchKeyEvent(var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         boolean var2;
         if (var1.getAction() == 0 && this.a((int)var1.getX(), (int)var1.getY())) {
            this.a.e(0);
            var2 = true;
         } else {
            var2 = super.onInterceptTouchEvent(var1);
         }

         return var2;
      }

      public void setBackgroundResource(int var1) {
         this.setBackgroundDrawable(AppCompatResources.b(this.getContext(), var1));
      }
   }

   protected static final class PanelFeatureState {
      int a;
      int b;
      int c;
      int d;
      int e;
      int f;
      ViewGroup g;
      View h;
      View i;
      MenuBuilder j;
      ListMenuPresenter k;
      Context l;
      boolean m;
      boolean n;
      boolean o;
      public boolean p;
      boolean q;
      boolean r;
      Bundle s;

      PanelFeatureState(int var1) {
         this.a = var1;
         this.q = false;
      }

      MenuView a(MenuPresenter.Callback var1) {
         MenuView var2;
         if (this.j == null) {
            var2 = null;
         } else {
            if (this.k == null) {
               this.k = new ListMenuPresenter(this.l, R.layout.abc_list_menu_item_layout);
               this.k.a(var1);
               this.j.a(this.k);
            }

            var2 = this.k.a(this.g);
         }

         return var2;
      }

      void a(Context var1) {
         TypedValue var3 = new TypedValue();
         Theme var2 = var1.getResources().newTheme();
         var2.setTo(var1.getTheme());
         var2.resolveAttribute(R.attr.actionBarPopupTheme, var3, true);
         if (var3.resourceId != 0) {
            var2.applyStyle(var3.resourceId, true);
         }

         var2.resolveAttribute(R.attr.panelMenuListTheme, var3, true);
         if (var3.resourceId != 0) {
            var2.applyStyle(var3.resourceId, true);
         } else {
            var2.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
         }

         ContextThemeWrapper var4 = new ContextThemeWrapper(var1, 0);
         var4.getTheme().setTo(var2);
         this.l = var4;
         TypedArray var5 = var4.obtainStyledAttributes(R.styleable.AppCompatTheme);
         this.b = var5.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
         this.f = var5.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
         var5.recycle();
      }

      void a(MenuBuilder var1) {
         if (var1 != this.j) {
            if (this.j != null) {
               this.j.b(this.k);
            }

            this.j = var1;
            if (var1 != null && this.k != null) {
               var1.a(this.k);
            }
         }
      }

      public boolean a() {
         boolean var2 = true;
         boolean var1;
         if (this.h == null) {
            var1 = false;
         } else {
            var1 = var2;
            if (this.i == null) {
               var1 = var2;
               if (this.k.d().getCount() <= 0) {
                  var1 = false;
               }
            }
         }

         return var1;
      }

      private static class SavedState implements Parcelable {
         public static final Creator<AppCompatDelegateImplV9.PanelFeatureState.SavedState> CREATOR = new ClassLoaderCreator<AppCompatDelegateImplV9.PanelFeatureState.SavedState>() {
            public AppCompatDelegateImplV9.PanelFeatureState.SavedState a(Parcel var1) {
               return AppCompatDelegateImplV9.PanelFeatureState.SavedState.a(var1, null);
            }

            public AppCompatDelegateImplV9.PanelFeatureState.SavedState a(Parcel var1, ClassLoader var2) {
               return AppCompatDelegateImplV9.PanelFeatureState.SavedState.a(var1, var2);
            }

            public AppCompatDelegateImplV9.PanelFeatureState.SavedState[] a(int var1) {
               return new AppCompatDelegateImplV9.PanelFeatureState.SavedState[var1];
            }
         };
         int a;
         boolean b;
         Bundle c;

         SavedState() {
         }

         static AppCompatDelegateImplV9.PanelFeatureState.SavedState a(Parcel var0, ClassLoader var1) {
            boolean var2 = true;
            AppCompatDelegateImplV9.PanelFeatureState.SavedState var3 = new AppCompatDelegateImplV9.PanelFeatureState.SavedState();
            var3.a = var0.readInt();
            if (var0.readInt() != 1) {
               var2 = false;
            }

            var3.b = var2;
            if (var3.b) {
               var3.c = var0.readBundle(var1);
            }

            return var3;
         }

         public int describeContents() {
            return 0;
         }

         public void writeToParcel(Parcel var1, int var2) {
            var1.writeInt(this.a);
            byte var3;
            if (this.b) {
               var3 = 1;
            } else {
               var3 = 0;
            }

            var1.writeInt(var3);
            if (this.b) {
               var1.writeBundle(this.c);
            }
         }
      }
   }

   private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
      final AppCompatDelegateImplV9 a;

      PanelMenuPresenterCallback(AppCompatDelegateImplV9 var1) {
         this.a = var1;
      }

      @Override
      public void a(MenuBuilder var1, boolean var2) {
         MenuBuilder var4 = var1.p();
         boolean var3;
         if (var4 != var1) {
            var3 = true;
         } else {
            var3 = false;
         }

         AppCompatDelegateImplV9 var5 = this.a;
         if (var3) {
            var1 = var4;
         }

         AppCompatDelegateImplV9.PanelFeatureState var6 = var5.a((Menu)var1);
         if (var6 != null) {
            if (var3) {
               this.a.a(var6.a, var6, var4);
               this.a.a(var6, true);
            } else {
               this.a.a(var6, var2);
            }
         }
      }

      @Override
      public boolean a(MenuBuilder var1) {
         if (var1 == null && this.a.h) {
            Callback var2 = this.a.r();
            if (var2 != null && !this.a.q()) {
               var2.onMenuOpened(108, var1);
            }
         }

         return true;
      }
   }
}
