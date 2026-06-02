package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.KeyEvent.DispatcherState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
   static final SearchView.AutoCompleteTextViewReflector i = new SearchView.AutoCompleteTextViewReflector();
   private SearchView.OnQueryTextListener A;
   private SearchView.OnCloseListener B;
   private SearchView.OnSuggestionListener C;
   private OnClickListener D;
   private boolean E;
   private boolean F;
   private boolean G;
   private CharSequence H;
   private boolean I;
   private boolean J;
   private int K;
   private boolean L;
   private CharSequence M;
   private CharSequence N;
   private boolean O;
   private int P;
   private Bundle Q;
   private final Runnable R;
   private Runnable S;
   private final WeakHashMap<String, ConstantState> T;
   private final OnClickListener U;
   private final OnEditorActionListener V;
   private final OnItemClickListener W;
   final SearchView.SearchAutoComplete a;
   private final OnItemSelectedListener aa;
   private TextWatcher ab;
   final ImageView b;
   final ImageView c;
   final ImageView d;
   final ImageView e;
   OnFocusChangeListener f;
   CursorAdapter g;
   SearchableInfo h;
   OnKeyListener j;
   private final View k;
   private final View l;
   private final View m;
   private final View n;
   private SearchView.UpdatableTouchDelegate o;
   private Rect p = new Rect();
   private Rect q = new Rect();
   private int[] r = new int[2];
   private int[] s = new int[2];
   private final ImageView t;
   private final Drawable u;
   private final int v;
   private final int w;
   private final Intent x;
   private final Intent y;
   private final CharSequence z;

   public SearchView(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.searchViewStyle);
   }

   public SearchView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.R = new Runnable(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.d();
         }
      };
      this.S = new Runnable(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.g != null && this.a.g instanceof SuggestionsAdapter) {
               this.a.g.a((Cursor)null);
            }
         }
      };
      this.T = new WeakHashMap<>();
      this.U = new OnClickListener(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            if (var1 == this.a.b) {
               this.a.g();
            } else if (var1 == this.a.d) {
               this.a.f();
            } else if (var1 == this.a.c) {
               this.a.e();
            } else if (var1 == this.a.e) {
               this.a.h();
            } else if (var1 == this.a.a) {
               this.a.l();
            }
         }
      };
      this.j = new OnKeyListener(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public boolean onKey(View var1, int var2x, KeyEvent var3x) {
            boolean var5 = false;
            boolean var4;
            if (this.a.h == null) {
               var4 = var5;
            } else if (this.a.a.isPopupShowing() && this.a.a.getListSelection() != -1) {
               var4 = this.a.a(var1, var2x, var3x);
            } else {
               var4 = var5;
               if (!this.a.a.a()) {
                  var4 = var5;
                  if (var3x.hasNoModifiers()) {
                     var4 = var5;
                     if (var3x.getAction() == 1) {
                        var4 = var5;
                        if (var2x == 66) {
                           var1.cancelLongPress();
                           this.a.a(0, null, this.a.a.getText().toString());
                           var4 = true;
                        }
                     }
                  }
               }
            }

            return var4;
         }
      };
      this.V = new OnEditorActionListener(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public boolean onEditorAction(TextView var1, int var2x, KeyEvent var3x) {
            this.a.e();
            return true;
         }
      };
      this.W = new OnItemClickListener(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public void onItemClick(AdapterView<?> var1, View var2x, int var3x, long var4) {
            this.a.a(var3x, 0, null);
         }
      };
      this.aa = new OnItemSelectedListener(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public void onItemSelected(AdapterView<?> var1, View var2x, int var3x, long var4) {
            this.a.a(var3x);
         }

         public void onNothingSelected(AdapterView<?> var1) {
         }
      };
      this.ab = new TextWatcher(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3x, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3x, int var4) {
            this.a.b(var1);
         }
      };
      TintTypedArray var4 = TintTypedArray.a(var1, var2, R.styleable.SearchView, var3, 0);
      LayoutInflater.from(var1).inflate(var4.g(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
      this.a = (SearchView.SearchAutoComplete)this.findViewById(R.id.search_src_text);
      this.a.setSearchView(this);
      this.k = this.findViewById(R.id.search_edit_frame);
      this.l = this.findViewById(R.id.search_plate);
      this.m = this.findViewById(R.id.submit_area);
      this.b = (ImageView)this.findViewById(R.id.search_button);
      this.c = (ImageView)this.findViewById(R.id.search_go_btn);
      this.d = (ImageView)this.findViewById(R.id.search_close_btn);
      this.e = (ImageView)this.findViewById(R.id.search_voice_btn);
      this.t = (ImageView)this.findViewById(R.id.search_mag_icon);
      ViewCompat.a(this.l, var4.a(R.styleable.SearchView_queryBackground));
      ViewCompat.a(this.m, var4.a(R.styleable.SearchView_submitBackground));
      this.b.setImageDrawable(var4.a(R.styleable.SearchView_searchIcon));
      this.c.setImageDrawable(var4.a(R.styleable.SearchView_goIcon));
      this.d.setImageDrawable(var4.a(R.styleable.SearchView_closeIcon));
      this.e.setImageDrawable(var4.a(R.styleable.SearchView_voiceIcon));
      this.t.setImageDrawable(var4.a(R.styleable.SearchView_searchIcon));
      this.u = var4.a(R.styleable.SearchView_searchHintIcon);
      TooltipCompat.a(this.b, this.getResources().getString(R.string.abc_searchview_description_search));
      this.v = var4.g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
      this.w = var4.g(R.styleable.SearchView_commitIcon, 0);
      this.b.setOnClickListener(this.U);
      this.d.setOnClickListener(this.U);
      this.c.setOnClickListener(this.U);
      this.e.setOnClickListener(this.U);
      this.a.setOnClickListener(this.U);
      this.a.addTextChangedListener(this.ab);
      this.a.setOnEditorActionListener(this.V);
      this.a.setOnItemClickListener(this.W);
      this.a.setOnItemSelectedListener(this.aa);
      this.a.setOnKeyListener(this.j);
      this.a.setOnFocusChangeListener(new OnFocusChangeListener(this) {
         final SearchView a;

         {
            this.a = var1;
         }

         public void onFocusChange(View var1, boolean var2x) {
            if (this.a.f != null) {
               this.a.f.onFocusChange(this.a, var2x);
            }
         }
      });
      this.setIconifiedByDefault(var4.a(R.styleable.SearchView_iconifiedByDefault, true));
      var3 = var4.e(R.styleable.SearchView_android_maxWidth, -1);
      if (var3 != -1) {
         this.setMaxWidth(var3);
      }

      this.z = var4.c(R.styleable.SearchView_defaultQueryHint);
      this.H = var4.c(R.styleable.SearchView_queryHint);
      var3 = var4.a(R.styleable.SearchView_android_imeOptions, -1);
      if (var3 != -1) {
         this.setImeOptions(var3);
      }

      var3 = var4.a(R.styleable.SearchView_android_inputType, -1);
      if (var3 != -1) {
         this.setInputType(var3);
      }

      this.setFocusable(var4.a(R.styleable.SearchView_android_focusable, true));
      var4.a();
      this.x = new Intent("android.speech.action.WEB_SEARCH");
      this.x.addFlags(268435456);
      this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
      this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
      this.y.addFlags(268435456);
      this.n = this.findViewById(this.a.getDropDownAnchor());
      if (this.n != null) {
         this.n.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
            final SearchView a;

            {
               this.a = var1;
            }

            public void onLayoutChange(View var1, int var2x, int var3x, int var4x, int var5, int var6, int var7, int var8, int var9) {
               this.a.k();
            }
         });
      }

      this.a(this.E);
      this.r();
   }

   private Intent a(Intent var1, SearchableInfo var2) {
      Intent var3 = new Intent(var1);
      ComponentName var4 = var2.getSearchActivity();
      String var5;
      if (var4 == null) {
         var5 = null;
      } else {
         var5 = var4.flattenToShortString();
      }

      var3.putExtra("calling_package", var5);
      return var3;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private Intent a(Cursor var1, int var2, String var3) {
      label85: {
         String var5;
         try {
            var5 = SuggestionsAdapter.a(var1, "suggest_intent_action");
         } catch (RuntimeException var16) {
            var19 = var16;
            break label85;
         }

         String var4 = var5;
         if (var5 == null) {
            try {
               var4 = this.h.getSuggestIntentAction();
            } catch (RuntimeException var15) {
               var19 = var15;
               break label85;
            }
         }

         var5 = var4;
         if (var4 == null) {
            var5 = "android.intent.action.SEARCH";
         }

         String var6;
         try {
            var6 = SuggestionsAdapter.a(var1, "suggest_intent_data");
         } catch (RuntimeException var14) {
            var19 = var14;
            break label85;
         }

         var4 = var6;
         if (var6 == null) {
            try {
               var4 = this.h.getSuggestIntentData();
            } catch (RuntimeException var13) {
               var19 = var13;
               break label85;
            }
         }

         var6 = var4;
         if (var4 != null) {
            String var7;
            try {
               var7 = SuggestionsAdapter.a(var1, "suggest_intent_data_id");
            } catch (RuntimeException var12) {
               var19 = var12;
               break label85;
            }

            var6 = var4;
            if (var7 != null) {
               try {
                  StringBuilder var25 = new StringBuilder();
                  var6 = var25.append(var4).append("/").append(Uri.encode(var7)).toString();
               } catch (RuntimeException var11) {
                  var19 = var11;
                  break label85;
               }
            }
         }

         Uri var22;
         if (var6 == null) {
            var22 = null;
         } else {
            try {
               var22 = Uri.parse(var6);
            } catch (RuntimeException var10) {
               var19 = var10;
               break label85;
            }
         }

         try {
            var6 = SuggestionsAdapter.a(var1, "suggest_intent_query");
            return this.a(var5, var22, SuggestionsAdapter.a(var1, "suggest_intent_extra_data"), var6, var2, var3);
         } catch (RuntimeException var9) {
            var19 = var9;
         }
      }

      try {
         var2 = var1.getPosition();
      } catch (RuntimeException var8) {
         var2 = -1;
      }

      Log.w("SearchView", "Search suggestions cursor at row " + var2 + " returned exception.", var19);
      return null;
   }

   private Intent a(String var1, Uri var2, String var3, String var4, int var5, String var6) {
      Intent var7 = new Intent(var1);
      var7.addFlags(268435456);
      if (var2 != null) {
         var7.setData(var2);
      }

      var7.putExtra("user_query", this.N);
      if (var4 != null) {
         var7.putExtra("query", var4);
      }

      if (var3 != null) {
         var7.putExtra("intent_extra_data_key", var3);
      }

      if (this.Q != null) {
         var7.putExtra("app_data", this.Q);
      }

      if (var5 != 0) {
         var7.putExtra("action_key", var5);
         var7.putExtra("action_msg", var6);
      }

      var7.setComponent(this.h.getSearchActivity());
      return var7;
   }

   private void a(Intent var1) {
      if (var1 != null) {
         try {
            this.getContext().startActivity(var1);
         } catch (RuntimeException var3) {
            Log.e("SearchView", "Failed launch activity: " + var1, var3);
         }
      }
   }

   private void a(View var1, Rect var2) {
      var1.getLocationInWindow(this.r);
      this.getLocationInWindow(this.s);
      int var4 = this.r[1] - this.s[1];
      int var3 = this.r[0] - this.s[0];
      var2.set(var3, var4, var1.getWidth() + var3, var1.getHeight() + var4);
   }

   private void a(boolean var1) {
      boolean var5 = true;
      byte var3 = 8;
      this.F = var1;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      boolean var4;
      if (!TextUtils.isEmpty(this.a.getText())) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.b.setVisibility(var2);
      this.b(var4);
      View var6 = this.k;
      if (var1) {
         var2 = 8;
      } else {
         var2 = 0;
      }

      var6.setVisibility(var2);
      var2 = var3;
      if (this.t.getDrawable() != null) {
         if (this.E) {
            var2 = var3;
         } else {
            var2 = 0;
         }
      }

      this.t.setVisibility(var2);
      this.p();
      if (!var4) {
         var1 = var5;
      } else {
         var1 = false;
      }

      this.c(var1);
      this.o();
   }

   static boolean a(Context var0) {
      boolean var1;
      if (var0.getResources().getConfiguration().orientation == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private Intent b(Intent var1, SearchableInfo var2) {
      Object var6 = null;
      ComponentName var10 = var2.getSearchActivity();
      Intent var4 = new Intent("android.intent.action.SEARCH");
      var4.setComponent(var10);
      PendingIntent var7 = PendingIntent.getActivity(this.getContext(), 0, var4, 1073741824);
      Bundle var8 = new Bundle();
      if (this.Q != null) {
         var8.putParcelable("app_data", this.Q);
      }

      Intent var9 = new Intent(var1);
      String var11 = "free_form";
      int var3 = 1;
      Resources var5 = this.getResources();
      if (var2.getVoiceLanguageModeId() != 0) {
         var11 = var5.getString(var2.getVoiceLanguageModeId());
      }

      String var13;
      if (var2.getVoicePromptTextId() != 0) {
         var13 = var5.getString(var2.getVoicePromptTextId());
      } else {
         var13 = null;
      }

      String var14;
      if (var2.getVoiceLanguageId() != 0) {
         var14 = var5.getString(var2.getVoiceLanguageId());
      } else {
         var14 = null;
      }

      if (var2.getVoiceMaxResults() != 0) {
         var3 = var2.getVoiceMaxResults();
      }

      var9.putExtra("android.speech.extra.LANGUAGE_MODEL", var11);
      var9.putExtra("android.speech.extra.PROMPT", var13);
      var9.putExtra("android.speech.extra.LANGUAGE", var14);
      var9.putExtra("android.speech.extra.MAX_RESULTS", var3);
      String var12;
      if (var10 == null) {
         var12 = (String)var6;
      } else {
         var12 = var10.flattenToShortString();
      }

      var9.putExtra("calling_package", var12);
      var9.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", var7);
      var9.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", var8);
      return var9;
   }

   private void b(boolean var1) {
      byte var3 = 8;
      byte var2 = var3;
      if (this.G) {
         var2 = var3;
         if (this.n()) {
            var2 = var3;
            label15:
            if (this.hasFocus()) {
               if (!var1) {
                  var2 = var3;
                  if (this.L) {
                     break label15;
                  }
               }

               var2 = 0;
            }
         }
      }

      this.c.setVisibility(var2);
   }

   private boolean b(int var1, int var2, String var3) {
      Cursor var5 = this.g.a();
      boolean var4;
      if (var5 != null && var5.moveToPosition(var1)) {
         this.a(this.a(var5, var2, var3));
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   private CharSequence c(CharSequence var1) {
      Object var3 = var1;
      if (this.E) {
         if (this.u == null) {
            var3 = var1;
         } else {
            int var2 = (int)(this.a.getTextSize() * 1.25);
            this.u.setBounds(0, 0, var2, var2);
            var3 = new SpannableStringBuilder("   ");
            var3.setSpan(new ImageSpan(this.u), 1, 2, 33);
            var3.append(var1);
         }
      }

      return (CharSequence)var3;
   }

   private void c(boolean var1) {
      byte var2;
      if (this.L && !this.c() && var1) {
         var2 = 0;
         this.c.setVisibility(8);
      } else {
         var2 = 8;
      }

      this.e.setVisibility(var2);
   }

   private void e(int var1) {
      Editable var2 = this.a.getText();
      Cursor var3 = this.g.a();
      if (var3 != null) {
         if (var3.moveToPosition(var1)) {
            CharSequence var4 = this.g.c(var3);
            if (var4 != null) {
               this.setQuery(var4);
            } else {
               this.setQuery(var2);
            }
         } else {
            this.setQuery(var2);
         }
      }
   }

   private int getPreferredHeight() {
      return this.getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
   }

   private int getPreferredWidth() {
      return this.getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
   }

   private boolean m() {
      boolean var2 = false;
      boolean var1 = var2;
      if (this.h != null) {
         var1 = var2;
         if (this.h.getVoiceSearchEnabled()) {
            Intent var3 = null;
            if (this.h.getVoiceSearchLaunchWebSearch()) {
               var3 = this.x;
            } else if (this.h.getVoiceSearchLaunchRecognizer()) {
               var3 = this.y;
            }

            var1 = var2;
            if (var3 != null) {
               var1 = var2;
               if (this.getContext().getPackageManager().resolveActivity(var3, 65536) != null) {
                  var1 = true;
               }
            }
         }
      }

      return var1;
   }

   private boolean n() {
      boolean var1;
      if ((this.G || this.L) && !this.c()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void o() {
      byte var1;
      byte var2 = 8;
      var1 = var2;
      label13:
      if (this.n()) {
         if (this.c.getVisibility() != 0) {
            var1 = var2;
            if (this.e.getVisibility() != 0) {
               break label13;
            }
         }

         var1 = 0;
      }

      this.m.setVisibility(var1);
   }

   private void p() {
      boolean var4 = true;
      byte var3 = 0;
      boolean var1;
      if (!TextUtils.isEmpty(this.a.getText())) {
         var1 = true;
      } else {
         var1 = false;
      }

      byte var2 = var4;
      if (!var1) {
         if (this.E && !this.O) {
            var2 = var4;
         } else {
            var2 = 0;
         }
      }

      ImageView var5 = this.d;
      if (var2) {
         var2 = var3;
      } else {
         var2 = 8;
      }

      var5.setVisibility(var2);
      Drawable var6 = this.d.getDrawable();
      if (var6 != null) {
         int[] var8;
         if (var1) {
            var8 = ENABLED_STATE_SET;
         } else {
            var8 = EMPTY_STATE_SET;
         }

         var6.setState(var8);
      }
   }

   private void q() {
      this.post(this.R);
   }

   private void r() {
      CharSequence var2 = this.getQueryHint();
      SearchView.SearchAutoComplete var3 = this.a;
      CharSequence var1 = var2;
      if (var2 == null) {
         var1 = "";
      }

      var3.setHint(this.c(var1));
   }

   private void s() {
      byte var2 = 1;
      this.a.setThreshold(this.h.getSuggestThreshold());
      this.a.setImeOptions(this.h.getImeOptions());
      int var3 = this.h.getInputType();
      int var1 = var3;
      if ((var3 & 15) == 1) {
         var3 &= -65537;
         var1 = var3;
         if (this.h.getSuggestAuthority() != null) {
            var1 = var3 | 65536 | 524288;
         }
      }

      this.a.setInputType(var1);
      if (this.g != null) {
         this.g.a((Cursor)null);
      }

      if (this.h.getSuggestAuthority() != null) {
         this.g = new SuggestionsAdapter(this.getContext(), this, this.h, this.T);
         this.a.setAdapter(this.g);
         SuggestionsAdapter var4 = (SuggestionsAdapter)this.g;
         byte var5 = var2;
         if (this.I) {
            var5 = 2;
         }

         var4.a(var5);
      }
   }

   private void setQuery(CharSequence var1) {
      this.a.setText(var1);
      SearchView.SearchAutoComplete var3 = this.a;
      int var2;
      if (TextUtils.isEmpty(var1)) {
         var2 = 0;
      } else {
         var2 = var1.length();
      }

      var3.setSelection(var2);
   }

   private void t() {
      this.a.dismissDropDown();
   }

   @Override
   public void a() {
      if (!this.O) {
         this.O = true;
         this.P = this.a.getImeOptions();
         this.a.setImeOptions(this.P | 33554432);
         this.a.setText("");
         this.setIconified(false);
      }
   }

   void a(int var1, String var2, String var3) {
      Intent var4 = this.a("android.intent.action.SEARCH", null, null, var3, var1, var2);
      this.getContext().startActivity(var4);
   }

   void a(CharSequence var1) {
      this.setQuery(var1);
   }

   public void a(CharSequence var1, boolean var2) {
      this.a.setText(var1);
      if (var1 != null) {
         this.a.setSelection(this.a.length());
         this.N = var1;
      }

      if (var2 && !TextUtils.isEmpty(var1)) {
         this.e();
      }
   }

   boolean a(int var1) {
      boolean var2;
      if (this.C != null && this.C.a(var1)) {
         var2 = false;
      } else {
         this.e(var1);
         var2 = true;
      }

      return var2;
   }

   boolean a(int var1, int var2, String var3) {
      boolean var4 = false;
      if (this.C == null || !this.C.b(var1)) {
         this.b(var1, 0, null);
         this.a.setImeVisibility(false);
         this.t();
         var4 = true;
      }

      return var4;
   }

   boolean a(View var1, int var2, KeyEvent var3) {
      boolean var5 = false;
      boolean var4;
      if (this.h == null) {
         var4 = var5;
      } else {
         var4 = var5;
         if (this.g != null) {
            var4 = var5;
            if (var3.getAction() == 0) {
               var4 = var5;
               if (var3.hasNoModifiers()) {
                  if (var2 == 66 || var2 == 84 || var2 == 61) {
                     var4 = this.a(this.a.getListSelection(), 0, null);
                  } else if (var2 != 21 && var2 != 22) {
                     var4 = var5;
                     if (var2 == 19) {
                        var4 = var5;
                        if (this.a.getListSelection() == 0) {
                           var4 = var5;
                        }
                     }
                  } else {
                     if (var2 == 21) {
                        var2 = 0;
                     } else {
                        var2 = this.a.length();
                     }

                     this.a.setSelection(var2);
                     this.a.setListSelection(0);
                     this.a.clearListSelection();
                     i.a(this.a, true);
                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   @Override
   public void b() {
      this.a("", false);
      this.clearFocus();
      this.a(true);
      this.a.setImeOptions(this.P);
      this.O = false;
   }

   void b(CharSequence var1) {
      boolean var3 = true;
      Editable var4 = this.a.getText();
      this.N = var4;
      boolean var2;
      if (!TextUtils.isEmpty(var4)) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.b(var2);
      if (!var2) {
         var2 = var3;
      } else {
         var2 = false;
      }

      this.c(var2);
      this.p();
      this.o();
      if (this.A != null && !TextUtils.equals(var1, this.M)) {
         this.A.b(var1.toString());
      }

      this.M = var1.toString();
   }

   public boolean c() {
      return this.F;
   }

   public void clearFocus() {
      this.J = true;
      super.clearFocus();
      this.a.clearFocus();
      this.a.setImeVisibility(false);
      this.J = false;
   }

   void d() {
      int[] var1;
      if (this.a.hasFocus()) {
         var1 = FOCUSED_STATE_SET;
      } else {
         var1 = EMPTY_STATE_SET;
      }

      Drawable var2 = this.l.getBackground();
      if (var2 != null) {
         var2.setState(var1);
      }

      var2 = this.m.getBackground();
      if (var2 != null) {
         var2.setState(var1);
      }

      this.invalidate();
   }

   void e() {
      Editable var1 = this.a.getText();
      if (var1 != null && TextUtils.getTrimmedLength(var1) > 0 && (this.A == null || !this.A.a(var1.toString()))) {
         if (this.h != null) {
            this.a(0, null, var1.toString());
         }

         this.a.setImeVisibility(false);
         this.t();
      }
   }

   void f() {
      if (TextUtils.isEmpty(this.a.getText())) {
         if (this.E && (this.B == null || !this.B.a())) {
            this.clearFocus();
            this.a(true);
         }
      } else {
         this.a.setText("");
         this.a.requestFocus();
         this.a.setImeVisibility(true);
      }
   }

   void g() {
      this.a(false);
      this.a.requestFocus();
      this.a.setImeVisibility(true);
      if (this.D != null) {
         this.D.onClick(this);
      }
   }

   public int getImeOptions() {
      return this.a.getImeOptions();
   }

   public int getInputType() {
      return this.a.getInputType();
   }

   public int getMaxWidth() {
      return this.K;
   }

   public CharSequence getQuery() {
      return this.a.getText();
   }

   public CharSequence getQueryHint() {
      CharSequence var1;
      if (this.H != null) {
         var1 = this.H;
      } else if (this.h != null && this.h.getHintId() != 0) {
         var1 = this.getContext().getText(this.h.getHintId());
      } else {
         var1 = this.z;
      }

      return var1;
   }

   int getSuggestionCommitIconResId() {
      return this.w;
   }

   int getSuggestionRowLayout() {
      return this.v;
   }

   public CursorAdapter getSuggestionsAdapter() {
      return this.g;
   }

   void h() {
      if (this.h != null) {
         SearchableInfo var1 = this.h;

         try {
            if (var1.getVoiceSearchLaunchWebSearch()) {
               Intent var3 = this.a(this.x, var1);
               this.getContext().startActivity(var3);
            } else if (var1.getVoiceSearchLaunchRecognizer()) {
               Intent var4 = this.b(this.y, var1);
               this.getContext().startActivity(var4);
            }
         } catch (ActivityNotFoundException var2) {
            Log.w("SearchView", "Could not find voice search activity");
         }
      }
   }

   void i() {
      this.a(this.c());
      this.q();
      if (this.a.hasFocus()) {
         this.l();
      }
   }

   void k() {
      if (this.n.getWidth() > 1) {
         Resources var7 = this.getContext().getResources();
         int var3 = this.l.getPaddingLeft();
         Rect var8 = new Rect();
         boolean var6 = ViewUtils.a(this);
         int var9;
         if (this.E) {
            var9 = var7.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            var9 = var7.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + var9;
         } else {
            var9 = 0;
         }

         this.a.getDropDownBackground().getPadding(var8);
         int var2;
         if (var6) {
            var2 = -var8.left;
         } else {
            var2 = var3 - (var8.left + var9);
         }

         this.a.setDropDownHorizontalOffset(var2);
         int var4 = this.n.getWidth();
         var2 = var8.left;
         int var5 = var8.right;
         this.a.setDropDownWidth(var9 + var4 + var2 + var5 - var3);
      }
   }

   void l() {
      i.a(this.a);
      i.b(this.a);
   }

   protected void onDetachedFromWindow() {
      this.removeCallbacks(this.R);
      this.post(this.S);
      super.onDetachedFromWindow();
   }

   @Override
   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if (var1) {
         this.a(this.a, this.p);
         this.q.set(this.p.left, 0, this.p.right, var5 - var3);
         if (this.o == null) {
            this.o = new SearchView.UpdatableTouchDelegate(this.q, this.p, this.a);
            this.setTouchDelegate(this.o);
         } else {
            this.o.a(this.q, this.p);
         }
      }
   }

   @Override
   protected void onMeasure(int var1, int var2) {
      if (this.c()) {
         super.onMeasure(var1, var2);
      } else {
         int var4 = MeasureSpec.getMode(var1);
         int var3 = MeasureSpec.getSize(var1);
         switch (var4) {
            case Integer.MIN_VALUE:
               if (this.K > 0) {
                  var1 = Math.min(this.K, var3);
               } else {
                  var1 = Math.min(this.getPreferredWidth(), var3);
               }
               break;
            case 0:
               if (this.K > 0) {
                  var1 = this.K;
               } else {
                  var1 = this.getPreferredWidth();
               }
               break;
            case 1073741824:
               var1 = var3;
               if (this.K > 0) {
                  var1 = Math.min(this.K, var3);
               }
               break;
            default:
               var1 = var3;
         }

         var3 = MeasureSpec.getMode(var2);
         var2 = MeasureSpec.getSize(var2);
         switch (var3) {
            case Integer.MIN_VALUE:
               var2 = Math.min(this.getPreferredHeight(), var2);
               break;
            case 0:
               var2 = this.getPreferredHeight();
         }

         super.onMeasure(MeasureSpec.makeMeasureSpec(var1, 1073741824), MeasureSpec.makeMeasureSpec(var2, 1073741824));
      }
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof SearchView.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         this.a(var1.a);
         this.requestLayout();
      }
   }

   protected Parcelable onSaveInstanceState() {
      SearchView.SavedState var1 = new SearchView.SavedState(super.onSaveInstanceState());
      var1.a = this.c();
      return var1;
   }

   public void onWindowFocusChanged(boolean var1) {
      super.onWindowFocusChanged(var1);
      this.q();
   }

   public boolean requestFocus(int var1, Rect var2) {
      boolean var3 = false;
      if (!this.J && this.isFocusable()) {
         if (!this.c()) {
            var3 = this.a.requestFocus(var1, var2);
            if (var3) {
               this.a(false);
            }
         } else {
            var3 = super.requestFocus(var1, var2);
         }
      }

      return var3;
   }

   public void setAppSearchData(Bundle var1) {
      this.Q = var1;
   }

   public void setIconified(boolean var1) {
      if (var1) {
         this.f();
      } else {
         this.g();
      }
   }

   public void setIconifiedByDefault(boolean var1) {
      if (this.E != var1) {
         this.E = var1;
         this.a(var1);
         this.r();
      }
   }

   public void setImeOptions(int var1) {
      this.a.setImeOptions(var1);
   }

   public void setInputType(int var1) {
      this.a.setInputType(var1);
   }

   public void setMaxWidth(int var1) {
      this.K = var1;
      this.requestLayout();
   }

   public void setOnCloseListener(SearchView.OnCloseListener var1) {
      this.B = var1;
   }

   public void setOnQueryTextFocusChangeListener(OnFocusChangeListener var1) {
      this.f = var1;
   }

   public void setOnQueryTextListener(SearchView.OnQueryTextListener var1) {
      this.A = var1;
   }

   public void setOnSearchClickListener(OnClickListener var1) {
      this.D = var1;
   }

   public void setOnSuggestionListener(SearchView.OnSuggestionListener var1) {
      this.C = var1;
   }

   public void setQueryHint(CharSequence var1) {
      this.H = var1;
      this.r();
   }

   public void setQueryRefinementEnabled(boolean var1) {
      this.I = var1;
      if (this.g instanceof SuggestionsAdapter) {
         SuggestionsAdapter var3 = (SuggestionsAdapter)this.g;
         byte var2;
         if (var1) {
            var2 = 2;
         } else {
            var2 = 1;
         }

         var3.a(var2);
      }
   }

   public void setSearchableInfo(SearchableInfo var1) {
      this.h = var1;
      if (this.h != null) {
         this.s();
         this.r();
      }

      this.L = this.m();
      if (this.L) {
         this.a.setPrivateImeOptions("nm");
      }

      this.a(this.c());
   }

   public void setSubmitButtonEnabled(boolean var1) {
      this.G = var1;
      this.a(this.c());
   }

   public void setSuggestionsAdapter(CursorAdapter var1) {
      this.g = var1;
      this.a.setAdapter(this.g);
   }

   private static class AutoCompleteTextViewReflector {
      private Method a;
      private Method b;
      private Method c;

      AutoCompleteTextViewReflector() {
         try {
            this.a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged");
            this.a.setAccessible(true);
         } catch (NoSuchMethodException var4) {
         }

         try {
            this.b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged");
            this.b.setAccessible(true);
         } catch (NoSuchMethodException var3) {
         }

         try {
            this.c = AutoCompleteTextView.class.getMethod("ensureImeVisible", boolean.class);
            this.c.setAccessible(true);
         } catch (NoSuchMethodException var2) {
         }
      }

      void a(AutoCompleteTextView var1) {
         if (this.a != null) {
            try {
               this.a.invoke(var1);
            } catch (Exception var2) {
            }
         }
      }

      void a(AutoCompleteTextView var1, boolean var2) {
         if (this.c != null) {
            try {
               this.c.invoke(var1, var2);
            } catch (Exception var3) {
            }
         }
      }

      void b(AutoCompleteTextView var1) {
         if (this.b != null) {
            try {
               this.b.invoke(var1);
            } catch (Exception var2) {
            }
         }
      }
   }

   public interface OnCloseListener {
      boolean a();
   }

   public interface OnQueryTextListener {
      boolean a(String var1);

      boolean b(String var1);
   }

   public interface OnSuggestionListener {
      boolean a(int var1);

      boolean b(int var1);
   }

   static class SavedState extends AbsSavedState {
      public static final Creator<SearchView.SavedState> CREATOR = new ClassLoaderCreator<SearchView.SavedState>() {
         public SearchView.SavedState a(Parcel var1) {
            return new SearchView.SavedState(var1, null);
         }

         public SearchView.SavedState a(Parcel var1, ClassLoader var2) {
            return new SearchView.SavedState(var1, var2);
         }

         public SearchView.SavedState[] a(int var1) {
            return new SearchView.SavedState[var1];
         }
      };
      boolean a;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a = (Boolean)var1.readValue(null);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public String toString() {
         return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.a + "}";
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeValue(this.a);
      }
   }

   public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
      final Runnable a = new Runnable(this) {
         final SearchView.SearchAutoComplete a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.b();
         }
      };
      private int b = this.getThreshold();
      private SearchView c;
      private boolean d;

      public SearchAutoComplete(Context var1) {
         this(var1, null);
      }

      public SearchAutoComplete(Context var1, AttributeSet var2) {
         this(var1, var2, R.attr.autoCompleteTextViewStyle);
      }

      public SearchAutoComplete(Context var1, AttributeSet var2, int var3) {
         super(var1, var2, var3);
      }

      private boolean a() {
         boolean var1;
         if (TextUtils.getTrimmedLength(this.getText()) == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      private void b() {
         if (this.d) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput(this, 0);
            this.d = false;
         }
      }

      private int getSearchViewTextMinWidthDp() {
         Configuration var3 = this.getResources().getConfiguration();
         int var2 = var3.screenWidthDp;
         int var1 = var3.screenHeightDp;
         short var4;
         if (var2 >= 960 && var1 >= 720 && var3.orientation == 2) {
            var4 = 256;
         } else if (var2 < 600 && (var2 < 640 || var1 < 480)) {
            var4 = 160;
         } else {
            var4 = 192;
         }

         return var4;
      }

      private void setImeVisibility(boolean var1) {
         InputMethodManager var2 = (InputMethodManager)this.getContext().getSystemService("input_method");
         if (!var1) {
            this.d = false;
            this.removeCallbacks(this.a);
            var2.hideSoftInputFromWindow(this.getWindowToken(), 0);
         } else if (var2.isActive(this)) {
            this.d = false;
            this.removeCallbacks(this.a);
            var2.showSoftInput(this, 0);
         } else {
            this.d = true;
         }
      }

      public boolean enoughToFilter() {
         boolean var1;
         if (this.b > 0 && !super.enoughToFilter()) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      @Override
      public InputConnection onCreateInputConnection(EditorInfo var1) {
         InputConnection var2 = super.onCreateInputConnection(var1);
         if (this.d) {
            this.removeCallbacks(this.a);
            this.post(this.a);
         }

         return var2;
      }

      protected void onFinishInflate() {
         super.onFinishInflate();
         DisplayMetrics var1 = this.getResources().getDisplayMetrics();
         this.setMinWidth((int)TypedValue.applyDimension(1, this.getSearchViewTextMinWidthDp(), var1));
      }

      protected void onFocusChanged(boolean var1, int var2, Rect var3) {
         super.onFocusChanged(var1, var2, var3);
         this.c.i();
      }

      public boolean onKeyPreIme(int var1, KeyEvent var2) {
         boolean var4 = true;
         if (var1 == 4) {
            if (var2.getAction() == 0 && var2.getRepeatCount() == 0) {
               DispatcherState var6 = this.getKeyDispatcherState();
               boolean var3 = var4;
               if (var6 != null) {
                  var6.startTracking(var2, this);
                  var3 = var4;
               }

               return var3;
            }

            if (var2.getAction() == 1) {
               DispatcherState var5 = this.getKeyDispatcherState();
               if (var5 != null) {
                  var5.handleUpEvent(var2);
               }

               if (var2.isTracking() && !var2.isCanceled()) {
                  this.c.clearFocus();
                  this.setImeVisibility(false);
                  return var4;
               }
            }
         }

         return super.onKeyPreIme(var1, var2);
      }

      public void onWindowFocusChanged(boolean var1) {
         super.onWindowFocusChanged(var1);
         if (var1 && this.c.hasFocus() && this.getVisibility() == 0) {
            this.d = true;
            if (SearchView.a(this.getContext())) {
               SearchView.i.a(this, true);
            }
         }
      }

      public void performCompletion() {
      }

      protected void replaceText(CharSequence var1) {
      }

      void setSearchView(SearchView var1) {
         this.c = var1;
      }

      public void setThreshold(int var1) {
         super.setThreshold(var1);
         this.b = var1;
      }
   }

   private static class UpdatableTouchDelegate extends TouchDelegate {
      private final View a;
      private final Rect b;
      private final Rect c;
      private final Rect d;
      private final int e;
      private boolean f;

      public UpdatableTouchDelegate(Rect var1, Rect var2, View var3) {
         super(var1, var3);
         this.e = ViewConfiguration.get(var3.getContext()).getScaledTouchSlop();
         this.b = new Rect();
         this.d = new Rect();
         this.c = new Rect();
         this.a(var1, var2);
         this.a = var3;
      }

      public void a(Rect var1, Rect var2) {
         this.b.set(var1);
         this.d.set(var1);
         this.d.inset(-this.e, -this.e);
         this.c.set(var2);
      }

      public boolean onTouchEvent(MotionEvent var1) {
         boolean var3 = true;
         boolean var7 = false;
         int var5 = (int)var1.getX();
         int var4 = (int)var1.getY();
         boolean var2;
         boolean var6;
         switch (var1.getAction()) {
            case 0:
               if (this.b.contains(var5, var4)) {
                  this.f = true;
                  var6 = true;
                  var2 = var3;
                  break;
               }
            default:
               var6 = false;
               var2 = var3;
               break;
            case 1:
            case 2:
               boolean var8 = this.f;
               var2 = var3;
               var6 = var8;
               if (var8) {
                  var2 = var3;
                  var6 = var8;
                  if (!this.d.contains(var5, var4)) {
                     var2 = false;
                     var6 = var8;
                  }
               }
               break;
            case 3:
               var6 = this.f;
               this.f = false;
               var2 = var3;
         }

         if (var6) {
            if (var2 && !this.c.contains(var5, var4)) {
               var1.setLocation(this.a.getWidth() / 2, this.a.getHeight() / 2);
            } else {
               var1.setLocation(var5 - this.c.left, var4 - this.c.top);
            }

            var7 = this.a.dispatchTouchEvent(var1);
         }

         return var7;
      }
   }
}
