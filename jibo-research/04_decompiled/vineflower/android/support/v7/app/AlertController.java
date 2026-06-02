package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import java.lang.ref.WeakReference;

class AlertController {
   private int A;
   private boolean B = false;
   private CharSequence C;
   private Drawable D;
   private CharSequence E;
   private Drawable F;
   private CharSequence G;
   private Drawable H;
   private int I = 0;
   private Drawable J;
   private ImageView K;
   private TextView L;
   private TextView M;
   private View N;
   private int O;
   private int P;
   private boolean Q;
   private int R;
   private final OnClickListener S;
   final AppCompatDialog a;
   ListView b;
   Button c;
   Message d;
   Button e;
   Message f;
   Button g;
   Message h;
   NestedScrollView i;
   ListAdapter j;
   int k = -1;
   int l;
   int m;
   int n;
   int o;
   Handler p;
   private final Context q;
   private final Window r;
   private final int s;
   private CharSequence t;
   private CharSequence u;
   private View v;
   private int w;
   private int x;
   private int y;
   private int z;

   public AlertController(Context var1, AppCompatDialog var2, Window var3) {
      this.R = 0;
      this.S = new OnClickListener(this) {
         final AlertController a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            Message var2x;
            if (var1 == this.a.c && this.a.d != null) {
               var2x = Message.obtain(this.a.d);
            } else if (var1 == this.a.e && this.a.f != null) {
               var2x = Message.obtain(this.a.f);
            } else if (var1 == this.a.g && this.a.h != null) {
               var2x = Message.obtain(this.a.h);
            } else {
               var2x = null;
            }

            if (var2x != null) {
               var2x.sendToTarget();
            }

            this.a.p.obtainMessage(1, this.a.a).sendToTarget();
         }
      };
      this.q = var1;
      this.a = var2;
      this.r = var3;
      this.p = new AlertController.ButtonHandler(var2);
      TypedArray var4 = var1.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
      this.O = var4.getResourceId(R.styleable.AlertDialog_android_layout, 0);
      this.P = var4.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
      this.l = var4.getResourceId(R.styleable.AlertDialog_listLayout, 0);
      this.m = var4.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
      this.n = var4.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
      this.o = var4.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
      this.Q = var4.getBoolean(R.styleable.AlertDialog_showTitle, true);
      this.s = var4.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
      var4.recycle();
      var2.b(1);
   }

   private ViewGroup a(View var1, View var2) {
      ViewGroup var4;
      if (var1 == null) {
         if (var2 instanceof ViewStub) {
            var2 = ((ViewStub)var2).inflate();
         }

         var4 = (ViewGroup)var2;
      } else {
         if (var2 != null) {
            ViewParent var3 = var2.getParent();
            if (var3 instanceof ViewGroup) {
               ((ViewGroup)var3).removeView(var2);
            }
         }

         if (var1 instanceof ViewStub) {
            var1 = ((ViewStub)var1).inflate();
         }

         var4 = (ViewGroup)var1;
      }

      return var4;
   }

   static void a(View var0, View var1, View var2) {
      byte var4 = 0;
      if (var1 != null) {
         byte var3;
         if (var0.canScrollVertically(-1)) {
            var3 = 0;
         } else {
            var3 = 4;
         }

         var1.setVisibility(var3);
      }

      if (var2 != null) {
         byte var5;
         if (var0.canScrollVertically(1)) {
            var5 = var4;
         } else {
            var5 = 4;
         }

         var2.setVisibility(var5);
      }
   }

   private void a(ViewGroup var1) {
      boolean var2 = false;
      View var3;
      if (this.v != null) {
         var3 = this.v;
      } else if (this.w != 0) {
         var3 = LayoutInflater.from(this.q).inflate(this.w, var1, false);
      } else {
         var3 = null;
      }

      if (var3 != null) {
         var2 = true;
      }

      if (!var2 || !a(var3)) {
         this.r.setFlags(131072, 131072);
      }

      if (var2) {
         FrameLayout var4 = (FrameLayout)this.r.findViewById(R.id.custom);
         var4.addView(var3, new LayoutParams(-1, -1));
         if (this.B) {
            var4.setPadding(this.x, this.y, this.z, this.A);
         }

         if (this.b != null) {
            ((LinearLayoutCompat.LayoutParams)var1.getLayoutParams()).g = 0.0F;
         }
      } else {
         var1.setVisibility(8);
      }
   }

   private void a(ViewGroup var1, View var2, int var3, int var4) {
      Object var6 = null;
      View var7 = this.r.findViewById(R.id.scrollIndicatorUp);
      View var5 = this.r.findViewById(R.id.scrollIndicatorDown);
      if (VERSION.SDK_INT >= 23) {
         ViewCompat.a(var2, var3, var4);
         if (var7 != null) {
            var1.removeView(var7);
         }

         if (var5 != null) {
            var1.removeView(var5);
         }
      } else {
         var2 = var7;
         if (var7 != null) {
            var2 = var7;
            if ((var3 & 1) == 0) {
               var1.removeView(var7);
               var2 = null;
            }
         }

         if (var5 != null && (var3 & 2) == 0) {
            var1.removeView(var5);
            var5 = (View)var6;
         }

         if (var2 != null || var5 != null) {
            if (this.u != null) {
               this.i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this, var2, var5) {
                  final View a;
                  final View b;
                  final AlertController c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  @Override
                  public void a(NestedScrollView var1, int var2x, int var3x, int var4x, int var5x) {
                     AlertController.a(var1, this.a, this.b);
                  }
               });
               this.i.post(new Runnable(this, var2, var5) {
                  final View a;
                  final View b;
                  final AlertController c;

                  {
                     this.c = var1;
                     this.a = var2;
                     this.b = var3;
                  }

                  @Override
                  public void run() {
                     AlertController.a(this.c.i, this.a, this.b);
                  }
               });
            } else if (this.b != null) {
               this.b.setOnScrollListener(new OnScrollListener(this, var2, var5) {
                  final View a;
                  final View b;
                  final AlertController c;

                  {
                     this.c = var1;
                     this.a = var2;
                     this.b = var3;
                  }

                  public void onScroll(AbsListView var1, int var2x, int var3x, int var4x) {
                     AlertController.a(var1, this.a, this.b);
                  }

                  public void onScrollStateChanged(AbsListView var1, int var2x) {
                  }
               });
               this.b.post(new Runnable(this, var2, var5) {
                  final View a;
                  final View b;
                  final AlertController c;

                  {
                     this.c = var1;
                     this.a = var2;
                     this.b = var3;
                  }

                  @Override
                  public void run() {
                     AlertController.a(this.c.b, this.a, this.b);
                  }
               });
            } else {
               if (var2 != null) {
                  var1.removeView(var2);
               }

               if (var5 != null) {
                  var1.removeView(var5);
               }
            }
         }
      }
   }

   private void a(Button var1) {
      android.widget.LinearLayout.LayoutParams var2 = (android.widget.LinearLayout.LayoutParams)var1.getLayoutParams();
      var2.gravity = 1;
      var2.weight = 0.5F;
      var1.setLayoutParams(var2);
   }

   private static boolean a(Context var0) {
      boolean var1 = true;
      TypedValue var2 = new TypedValue();
      var0.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, var2, true);
      if (var2.data == 0) {
         var1 = false;
      }

      return var1;
   }

   static boolean a(View var0) {
      boolean var3 = true;
      if (!var0.onCheckIsTextEditor()) {
         if (!(var0 instanceof ViewGroup)) {
            var3 = false;
         } else {
            ViewGroup var4 = (ViewGroup)var0;
            int var1 = var4.getChildCount();

            int var2;
            do {
               if (var1 <= 0) {
                  var3 = false;
                  break;
               }

               var2 = var1 - 1;
               var1 = var2;
            } while (!a(var4.getChildAt(var2)));
         }
      }

      return var3;
   }

   private int b() {
      int var1;
      if (this.P == 0) {
         var1 = this.O;
      } else if (this.R == 1) {
         var1 = this.P;
      } else {
         var1 = this.O;
      }

      return var1;
   }

   private void b(ViewGroup var1) {
      if (this.N != null) {
         LayoutParams var3 = new LayoutParams(-1, -2);
         var1.addView(this.N, 0, var3);
         this.r.findViewById(R.id.title_template).setVisibility(8);
      } else {
         this.K = (ImageView)this.r.findViewById(16908294);
         boolean var2;
         if (!TextUtils.isEmpty(this.t)) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2 && this.Q) {
            this.L = (TextView)this.r.findViewById(R.id.alertTitle);
            this.L.setText(this.t);
            if (this.I != 0) {
               this.K.setImageResource(this.I);
            } else if (this.J != null) {
               this.K.setImageDrawable(this.J);
            } else {
               this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
               this.K.setVisibility(8);
            }
         } else {
            this.r.findViewById(R.id.title_template).setVisibility(8);
            this.K.setVisibility(8);
            var1.setVisibility(8);
         }
      }
   }

   private void c() {
      View var5 = this.r.findViewById(R.id.parentPanel);
      View var7 = var5.findViewById(R.id.topPanel);
      View var6 = var5.findViewById(R.id.contentPanel);
      View var8 = var5.findViewById(R.id.buttonPanel);
      ViewGroup var14 = (ViewGroup)var5.findViewById(R.id.customPanel);
      this.a(var14);
      View var11 = var14.findViewById(R.id.topPanel);
      View var10 = var14.findViewById(R.id.contentPanel);
      View var9 = var14.findViewById(R.id.buttonPanel);
      ViewGroup var21 = this.a(var11, var7);
      ViewGroup var20 = this.a(var10, var6);
      ViewGroup var22 = this.a(var9, var8);
      this.c(var20);
      this.d(var22);
      this.b(var21);
      boolean var1;
      if (var14 != null && var14.getVisibility() != 8) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      boolean var3;
      if (var21 != null && var21.getVisibility() != 8) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if (var22 != null && var22.getVisibility() != 8) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (!var4 && var20 != null) {
         var5 = var20.findViewById(R.id.textSpacerNoButtons);
         if (var5 != null) {
            var5.setVisibility(0);
         }
      }

      if (var3) {
         if (this.i != null) {
            this.i.setClipToPadding(true);
         }

         var5 = null;
         if (this.u != null || this.b != null) {
            var5 = var21.findViewById(R.id.titleDividerNoCustom);
         }

         if (var5 != null) {
            var5.setVisibility(0);
         }
      } else if (var20 != null) {
         var5 = var20.findViewById(R.id.textSpacerNoTitle);
         if (var5 != null) {
            var5.setVisibility(0);
         }
      }

      if (this.b instanceof AlertController.RecycleListView) {
         ((AlertController.RecycleListView)this.b).a(var3, var4);
      }

      if (!var1) {
         if (this.b != null) {
            var5 = this.b;
         } else {
            var5 = this.i;
         }

         if (var5 != null) {
            if (var3) {
               var1 = (byte)1;
            } else {
               var1 = (byte)0;
            }

            byte var2;
            if (var4) {
               var2 = 2;
            } else {
               var2 = 0;
            }

            this.a(var20, var5, var2 | var1, 3);
         }
      }

      ListView var19 = this.b;
      if (var19 != null && this.j != null) {
         var19.setAdapter(this.j);
         var1 = this.k;
         if (var1 > -1) {
            var19.setItemChecked(var1, true);
            var19.setSelection(var1);
         }
      }
   }

   private void c(ViewGroup var1) {
      this.i = (NestedScrollView)this.r.findViewById(R.id.scrollView);
      this.i.setFocusable(false);
      this.i.setNestedScrollingEnabled(false);
      this.M = (TextView)var1.findViewById(16908299);
      if (this.M != null) {
         if (this.u != null) {
            this.M.setText(this.u);
         } else {
            this.M.setVisibility(8);
            this.i.removeView(this.M);
            if (this.b != null) {
               var1 = (ViewGroup)this.i.getParent();
               int var2 = var1.indexOfChild(this.i);
               var1.removeViewAt(var2);
               var1.addView(this.b, var2, new LayoutParams(-1, -1));
            } else {
               var1.setVisibility(8);
            }
         }
      }
   }

   private void d(ViewGroup var1) {
      boolean var3 = true;
      this.c = (Button)var1.findViewById(16908313);
      this.c.setOnClickListener(this.S);
      byte var2;
      if (TextUtils.isEmpty(this.C) && this.D == null) {
         this.c.setVisibility(8);
         var2 = 0;
      } else {
         this.c.setText(this.C);
         if (this.D != null) {
            this.D.setBounds(0, 0, this.s, this.s);
            this.c.setCompoundDrawables(this.D, null, null, null);
         }

         this.c.setVisibility(0);
         var2 = 1;
      }

      this.e = (Button)var1.findViewById(16908314);
      this.e.setOnClickListener(this.S);
      if (TextUtils.isEmpty(this.E) && this.F == null) {
         this.e.setVisibility(8);
      } else {
         this.e.setText(this.E);
         if (this.F != null) {
            this.F.setBounds(0, 0, this.s, this.s);
            this.e.setCompoundDrawables(this.F, null, null, null);
         }

         this.e.setVisibility(0);
         var2 |= 2;
      }

      this.g = (Button)var1.findViewById(16908315);
      this.g.setOnClickListener(this.S);
      if (TextUtils.isEmpty(this.G) && this.H == null) {
         this.g.setVisibility(8);
      } else {
         this.g.setText(this.G);
         if (this.D != null) {
            this.D.setBounds(0, 0, this.s, this.s);
            this.c.setCompoundDrawables(this.D, null, null, null);
         }

         this.g.setVisibility(0);
         var2 |= 4;
      }

      if (a(this.q)) {
         if (var2 == 1) {
            this.a(this.c);
         } else if (var2 == 2) {
            this.a(this.e);
         } else if (var2 == 4) {
            this.a(this.g);
         }
      }

      boolean var4;
      if (var2 != 0) {
         var4 = var3;
      } else {
         var4 = false;
      }

      if (!var4) {
         var1.setVisibility(8);
      }
   }

   public void a() {
      int var1 = this.b();
      this.a.setContentView(var1);
      this.c();
   }

   public void a(int var1) {
      this.v = null;
      this.w = var1;
      this.B = false;
   }

   public void a(int var1, CharSequence var2, android.content.DialogInterface.OnClickListener var3, Message var4, Drawable var5) {
      Message var6 = var4;
      if (var4 == null) {
         var6 = var4;
         if (var3 != null) {
            var6 = this.p.obtainMessage(var1, var3);
         }
      }

      switch (var1) {
         case -3:
            this.G = var2;
            this.h = var6;
            this.H = var5;
            break;
         case -2:
            this.E = var2;
            this.f = var6;
            this.F = var5;
            break;
         case -1:
            this.C = var2;
            this.d = var6;
            this.D = var5;
            break;
         default:
            throw new IllegalArgumentException("Button does not exist");
      }
   }

   public void a(Drawable var1) {
      this.J = var1;
      this.I = 0;
      if (this.K != null) {
         if (var1 != null) {
            this.K.setVisibility(0);
            this.K.setImageDrawable(var1);
         } else {
            this.K.setVisibility(8);
         }
      }
   }

   public void a(View var1, int var2, int var3, int var4, int var5) {
      this.v = var1;
      this.w = 0;
      this.B = true;
      this.x = var2;
      this.y = var3;
      this.z = var4;
      this.A = var5;
   }

   public void a(CharSequence var1) {
      this.t = var1;
      if (this.L != null) {
         this.L.setText(var1);
      }
   }

   public boolean a(int var1, KeyEvent var2) {
      boolean var3;
      if (this.i != null && this.i.a(var2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public void b(int var1) {
      this.J = null;
      this.I = var1;
      if (this.K != null) {
         if (var1 != 0) {
            this.K.setVisibility(0);
            this.K.setImageResource(this.I);
         } else {
            this.K.setVisibility(8);
         }
      }
   }

   public void b(View var1) {
      this.N = var1;
   }

   public void b(CharSequence var1) {
      this.u = var1;
      if (this.M != null) {
         this.M.setText(var1);
      }
   }

   public boolean b(int var1, KeyEvent var2) {
      boolean var3;
      if (this.i != null && this.i.a(var2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public int c(int var1) {
      TypedValue var2 = new TypedValue();
      this.q.getTheme().resolveAttribute(var1, var2, true);
      return var2.resourceId;
   }

   public void c(View var1) {
      this.v = var1;
      this.w = 0;
      this.B = false;
   }

   public Button d(int var1) {
      Button var2;
      switch (var1) {
         case -3:
            var2 = this.g;
            break;
         case -2:
            var2 = this.e;
            break;
         case -1:
            var2 = this.c;
            break;
         default:
            var2 = null;
      }

      return var2;
   }

   public static class AlertParams {
      public int A;
      public int B;
      public int C;
      public int D;
      public boolean E;
      public boolean[] F;
      public boolean G;
      public boolean H;
      public int I;
      public OnMultiChoiceClickListener J;
      public Cursor K;
      public String L;
      public String M;
      public OnItemSelectedListener N;
      public AlertController.AlertParams.OnPrepareListViewListener O;
      public boolean P;
      public final Context a;
      public final LayoutInflater b;
      public int c = 0;
      public Drawable d;
      public int e = 0;
      public CharSequence f;
      public View g;
      public CharSequence h;
      public CharSequence i;
      public Drawable j;
      public android.content.DialogInterface.OnClickListener k;
      public CharSequence l;
      public Drawable m;
      public android.content.DialogInterface.OnClickListener n;
      public CharSequence o;
      public Drawable p;
      public android.content.DialogInterface.OnClickListener q;
      public boolean r;
      public OnCancelListener s;
      public OnDismissListener t;
      public OnKeyListener u;
      public CharSequence[] v;
      public ListAdapter w;
      public android.content.DialogInterface.OnClickListener x;
      public int y;
      public View z;

      public AlertParams(Context var1) {
         this.E = false;
         this.I = -1;
         this.P = true;
         this.a = var1;
         this.r = true;
         this.b = (LayoutInflater)var1.getSystemService("layout_inflater");
      }

      private void b(AlertController var1) {
         AlertController.RecycleListView var4 = (AlertController.RecycleListView)this.b.inflate(var1.l, null);
         Object var3;
         if (this.G) {
            if (this.K == null) {
               var3 = new ArrayAdapter<CharSequence>(this, this.a, var1.m, 16908308, this.v, var4) {
                  final AlertController.RecycleListView a;
                  final AlertController.AlertParams b;

                  {
                     this.b = var1;
                     this.a = var6;
                  }

                  public View getView(int var1, View var2, ViewGroup var3x) {
                     var2 = super.getView(var1, var2, var3x);
                     if (this.b.F != null && this.b.F[var1]) {
                        this.a.setItemChecked(var1, true);
                     }

                     return var2;
                  }
               };
            } else {
               var3 = new CursorAdapter(this, this.a, this.K, false, var4, var1) {
                  final AlertController.RecycleListView a;
                  final AlertController b;
                  final AlertController.AlertParams c;
                  private final int d;
                  private final int e;

                  {
                     this.c = var1;
                     this.a = var5;
                     this.b = var6;
                     Cursor var7 = this.getCursor();
                     this.d = var7.getColumnIndexOrThrow(this.c.L);
                     this.e = var7.getColumnIndexOrThrow(this.c.M);
                  }

                  public void bindView(View var1, Context var2, Cursor var3x) {
                     ((CheckedTextView)var1.findViewById(16908308)).setText(var3x.getString(this.d));
                     AlertController.RecycleListView var6 = this.a;
                     int var4x = var3x.getPosition();
                     boolean var5;
                     if (var3x.getInt(this.e) == 1) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }

                     var6.setItemChecked(var4x, var5);
                  }

                  public View newView(Context var1, Cursor var2, ViewGroup var3x) {
                     return this.c.b.inflate(this.b.m, var3x, false);
                  }
               };
            }
         } else {
            int var2;
            if (this.H) {
               var2 = var1.n;
            } else {
               var2 = var1.o;
            }

            if (this.K != null) {
               var3 = new SimpleCursorAdapter(this.a, var2, this.K, new String[]{this.L}, new int[]{16908308});
            } else if (this.w != null) {
               var3 = this.w;
            } else {
               var3 = new AlertController.CheckedItemAdapter(this.a, var2, 16908308, this.v);
            }
         }

         if (this.O != null) {
            this.O.a(var4);
         }

         var1.j = (ListAdapter)var3;
         var1.k = this.I;
         if (this.x != null) {
            var4.setOnItemClickListener(new OnItemClickListener(this, var1) {
               final AlertController a;
               final AlertController.AlertParams b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void onItemClick(AdapterView<?> var1, View var2, int var3x, long var4x) {
                  this.b.x.onClick(this.a.a, var3x);
                  if (!this.b.H) {
                     this.a.a.dismiss();
                  }
               }
            });
         } else if (this.J != null) {
            var4.setOnItemClickListener(new OnItemClickListener(this, var4, var1) {
               final AlertController.RecycleListView a;
               final AlertController b;
               final AlertController.AlertParams c;

               {
                  this.c = var1;
                  this.a = var2;
                  this.b = var3x;
               }

               public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
                  if (this.c.F != null) {
                     this.c.F[var3] = this.a.isItemChecked(var3);
                  }

                  this.c.J.onClick(this.b.a, var3, this.a.isItemChecked(var3));
               }
            });
         }

         if (this.N != null) {
            var4.setOnItemSelectedListener(this.N);
         }

         if (this.H) {
            var4.setChoiceMode(1);
         } else if (this.G) {
            var4.setChoiceMode(2);
         }

         var1.b = var4;
      }

      public void a(AlertController var1) {
         if (this.g != null) {
            var1.b(this.g);
         } else {
            if (this.f != null) {
               var1.a(this.f);
            }

            if (this.d != null) {
               var1.a(this.d);
            }

            if (this.c != 0) {
               var1.b(this.c);
            }

            if (this.e != 0) {
               var1.b(var1.c(this.e));
            }
         }

         if (this.h != null) {
            var1.b(this.h);
         }

         if (this.i != null || this.j != null) {
            var1.a(-1, this.i, this.k, null, this.j);
         }

         if (this.l != null || this.m != null) {
            var1.a(-2, this.l, this.n, null, this.m);
         }

         if (this.o != null || this.p != null) {
            var1.a(-3, this.o, this.q, null, this.p);
         }

         if (this.v != null || this.K != null || this.w != null) {
            this.b(var1);
         }

         if (this.z != null) {
            if (this.E) {
               var1.a(this.z, this.A, this.B, this.C, this.D);
            } else {
               var1.c(this.z);
            }
         } else if (this.y != 0) {
            var1.a(this.y);
         }
      }

      public interface OnPrepareListViewListener {
         void a(ListView var1);
      }
   }

   private static final class ButtonHandler extends Handler {
      private WeakReference<DialogInterface> a;

      public ButtonHandler(DialogInterface var1) {
         this.a = new WeakReference<>(var1);
      }

      public void handleMessage(Message var1) {
         switch (var1.what) {
            case -3:
            case -2:
            case -1:
               ((android.content.DialogInterface.OnClickListener)var1.obj).onClick(this.a.get(), var1.what);
            case 0:
            default:
               break;
            case 1:
               ((DialogInterface)var1.obj).dismiss();
         }
      }
   }

   private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
      public CheckedItemAdapter(Context var1, int var2, int var3, CharSequence[] var4) {
         super(var1, var2, var3, var4);
      }

      public long getItemId(int var1) {
         return var1;
      }

      public boolean hasStableIds() {
         return true;
      }
   }

   public static class RecycleListView extends ListView {
      private final int a;
      private final int b;

      public RecycleListView(Context var1) {
         this(var1, null);
      }

      public RecycleListView(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.RecycleListView);
         this.b = var3.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
         this.a = var3.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
      }

      public void a(boolean var1, boolean var2) {
         if (!var2 || !var1) {
            int var5 = this.getPaddingLeft();
            int var3;
            if (var1) {
               var3 = this.getPaddingTop();
            } else {
               var3 = this.a;
            }

            int var6 = this.getPaddingRight();
            int var4;
            if (var2) {
               var4 = this.getPaddingBottom();
            } else {
               var4 = this.b;
            }

            this.setPadding(var5, var3, var6, var4);
         }
      }
   }
}
