package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
   private final SearchManager j;
   private final SearchView k;
   private final SearchableInfo l;
   private final Context m;
   private final WeakHashMap<String, ConstantState> n;
   private final int o;
   private boolean p = false;
   private int q = 1;
   private ColorStateList r;
   private int s = -1;
   private int t = -1;
   private int u = -1;
   private int v = -1;
   private int w = -1;
   private int x = -1;

   public SuggestionsAdapter(Context var1, SearchView var2, SearchableInfo var3, WeakHashMap<String, ConstantState> var4) {
      super(var1, var2.getSuggestionRowLayout(), null, true);
      this.j = (SearchManager)this.d.getSystemService("search");
      this.k = var2;
      this.l = var3;
      this.o = var2.getSuggestionCommitIconResId();
      this.m = var1;
      this.n = var4;
   }

   private Drawable a(ComponentName var1) {
      Object var3 = null;
      String var4 = var1.flattenToShortString();
      Drawable var6;
      if (this.n.containsKey(var4)) {
         ConstantState var5 = this.n.get(var4);
         if (var5 == null) {
            var6 = null;
         } else {
            var6 = var5.newDrawable(this.m.getResources());
         }
      } else {
         Drawable var2 = this.b(var1);
         ConstantState var7;
         if (var2 == null) {
            var7 = (ConstantState)var3;
         } else {
            var7 = var2.getConstantState();
         }

         this.n.put(var4, var7);
         var6 = var2;
      }

      return var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private Drawable a(String var1) {
      Drawable var3;
      if (var1 != null && !var1.isEmpty() && !"0".equals(var1)) {
         label40: {
            int var2;
            String var5;
            Drawable var11;
            try {
               var2 = Integer.parseInt(var1);
               StringBuilder var10 = new StringBuilder();
               var5 = var10.append("android.resource://").append(this.m.getPackageName()).append("/").append(var2).toString();
               var11 = this.b(var5);
            } catch (NumberFormatException var8) {
               var11 = this.b(var1);
               var3 = var11;
               if (var11 != null) {
                  return var3;
               }
               break label40;
            } catch (NotFoundException var9) {
               Log.w("SuggestionsAdapter", "Icon resource not found: " + var1);
               var3 = null;
               return var3;
            }

            var3 = var11;
            if (var11 != null) {
               return var3;
            }

            try {
               var3 = ContextCompat.a(this.m, var2);
               this.a(var5, var3);
               return var3;
            } catch (NumberFormatException var6) {
               var11 = this.b(var1);
               var3 = var11;
               if (var11 != null) {
                  return var3;
               }
            } catch (NotFoundException var7) {
               Log.w("SuggestionsAdapter", "Icon resource not found: " + var1);
               var3 = null;
               return var3;
            }
         }

         var3 = this.b(Uri.parse(var1));
         this.a(var1, var3);
      } else {
         var3 = null;
      }

      return var3;
   }

   private static String a(Cursor var0, int var1) {
      Object var2 = null;
      String var4;
      if (var1 == -1) {
         var4 = (String)var2;
      } else {
         try {
            var4 = var0.getString(var1);
         } catch (Exception var3) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", var3);
            var4 = (String)var2;
         }
      }

      return var4;
   }

   public static String a(Cursor var0, String var1) {
      return a(var0, var0.getColumnIndex(var1));
   }

   private void a(ImageView var1, Drawable var2, int var3) {
      var1.setImageDrawable(var2);
      if (var2 == null) {
         var1.setVisibility(var3);
      } else {
         var1.setVisibility(0);
         var2.setVisible(false, false);
         var2.setVisible(true, false);
      }
   }

   private void a(TextView var1, CharSequence var2) {
      var1.setText(var2);
      if (TextUtils.isEmpty(var2)) {
         var1.setVisibility(8);
      } else {
         var1.setVisibility(0);
      }
   }

   private void a(String var1, Drawable var2) {
      if (var2 != null) {
         this.n.put(var1, var2.getConstantState());
      }
   }

   private Drawable b(ComponentName var1) {
      Object var3 = null;
      PackageManager var4 = this.d.getPackageManager();

      ActivityInfo var5;
      try {
         var5 = var4.getActivityInfo(var1, 128);
      } catch (NameNotFoundException var6) {
         Log.w("SuggestionsAdapter", var6.toString());
         return (Drawable)var3;
      }

      int var2 = var5.getIconResource();
      Drawable var7;
      if (var2 == 0) {
         var7 = (Drawable)var3;
      } else {
         Drawable var8 = var4.getDrawable(var1.getPackageName(), var2, var5.applicationInfo);
         if (var8 == null) {
            Log.w("SuggestionsAdapter", "Invalid icon resource " + var2 + " for " + var1.flattenToShortString());
            var7 = (Drawable)var3;
         } else {
            var7 = var8;
         }
      }

      return var7;
   }

   private Drawable b(Uri param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: ldc_w "android.resource"
      // 003: aload 1
      // 004: invokevirtual android/net/Uri.getScheme ()Ljava/lang/String;
      // 007: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 00a: istore 2
      // 00b: iload 2
      // 00c: ifeq 06a
      // 00f: aload 0
      // 010: aload 1
      // 011: invokevirtual android/support/v7/widget/SuggestionsAdapter.a (Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
      // 014: astore 3
      // 015: aload 3
      // 016: astore 1
      // 017: aload 1
      // 018: areturn
      // 019: astore 3
      // 01a: new java/io/FileNotFoundException
      // 01d: astore 4
      // 01f: new java/lang/StringBuilder
      // 022: astore 3
      // 023: aload 3
      // 024: invokespecial java/lang/StringBuilder.<init> ()V
      // 027: aload 4
      // 029: aload 3
      // 02a: ldc_w "Resource does not exist: "
      // 02d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 030: aload 1
      // 031: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 034: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 037: invokespecial java/io/FileNotFoundException.<init> (Ljava/lang/String;)V
      // 03a: aload 4
      // 03c: athrow
      // 03d: astore 3
      // 03e: ldc "SuggestionsAdapter"
      // 040: new java/lang/StringBuilder
      // 043: dup
      // 044: invokespecial java/lang/StringBuilder.<init> ()V
      // 047: ldc_w "Icon not found: "
      // 04a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 04d: aload 1
      // 04e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 051: ldc_w ", "
      // 054: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 057: aload 3
      // 058: invokevirtual java/io/FileNotFoundException.getMessage ()Ljava/lang/String;
      // 05b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 05e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 061: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 064: pop
      // 065: aconst_null
      // 066: astore 1
      // 067: goto 017
      // 06a: aload 0
      // 06b: getfield android/support/v7/widget/SuggestionsAdapter.m Landroid/content/Context;
      // 06e: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 071: aload 1
      // 072: invokevirtual android/content/ContentResolver.openInputStream (Landroid/net/Uri;)Ljava/io/InputStream;
      // 075: astore 4
      // 077: aload 4
      // 079: ifnonnull 09f
      // 07c: new java/io/FileNotFoundException
      // 07f: astore 4
      // 081: new java/lang/StringBuilder
      // 084: astore 3
      // 085: aload 3
      // 086: invokespecial java/lang/StringBuilder.<init> ()V
      // 089: aload 4
      // 08b: aload 3
      // 08c: ldc_w "Failed to open "
      // 08f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 092: aload 1
      // 093: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 096: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 099: invokespecial java/io/FileNotFoundException.<init> (Ljava/lang/String;)V
      // 09c: aload 4
      // 09e: athrow
      // 09f: aload 4
      // 0a1: aconst_null
      // 0a2: invokestatic android/graphics/drawable/Drawable.createFromStream (Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
      // 0a5: astore 3
      // 0a6: aload 4
      // 0a8: invokevirtual java/io/InputStream.close ()V
      // 0ab: aload 3
      // 0ac: astore 1
      // 0ad: goto 017
      // 0b0: astore 4
      // 0b2: new java/lang/StringBuilder
      // 0b5: astore 5
      // 0b7: aload 5
      // 0b9: invokespecial java/lang/StringBuilder.<init> ()V
      // 0bc: ldc "SuggestionsAdapter"
      // 0be: aload 5
      // 0c0: ldc_w "Error closing icon stream for "
      // 0c3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c6: aload 1
      // 0c7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0ca: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0cd: aload 4
      // 0cf: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 0d2: pop
      // 0d3: aload 3
      // 0d4: astore 1
      // 0d5: goto 017
      // 0d8: astore 3
      // 0d9: aload 4
      // 0db: invokevirtual java/io/InputStream.close ()V
      // 0de: aload 3
      // 0df: athrow
      // 0e0: astore 4
      // 0e2: new java/lang/StringBuilder
      // 0e5: astore 5
      // 0e7: aload 5
      // 0e9: invokespecial java/lang/StringBuilder.<init> ()V
      // 0ec: ldc "SuggestionsAdapter"
      // 0ee: aload 5
      // 0f0: ldc_w "Error closing icon stream for "
      // 0f3: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f6: aload 1
      // 0f7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 0fa: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0fd: aload 4
      // 0ff: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 102: pop
      // 103: goto 0de
      // try (0 -> 5): 32 java/io/FileNotFoundException
      // try (7 -> 11): 15 android/content/res/Resources$NotFoundException
      // try (7 -> 11): 32 java/io/FileNotFoundException
      // try (16 -> 32): 32 java/io/FileNotFoundException
      // try (52 -> 58): 32 java/io/FileNotFoundException
      // try (60 -> 76): 32 java/io/FileNotFoundException
      // try (76 -> 80): 103 null
      // try (80 -> 82): 85 java/io/IOException
      // try (80 -> 82): 32 java/io/FileNotFoundException
      // try (86 -> 100): 32 java/io/FileNotFoundException
      // try (104 -> 106): 108 java/io/IOException
      // try (104 -> 106): 32 java/io/FileNotFoundException
      // try (106 -> 108): 32 java/io/FileNotFoundException
      // try (109 -> 123): 32 java/io/FileNotFoundException
   }

   private Drawable b(String var1) {
      ConstantState var2 = this.n.get(var1);
      Drawable var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = var2.newDrawable();
      }

      return var3;
   }

   private CharSequence b(CharSequence var1) {
      if (this.r == null) {
         TypedValue var2 = new TypedValue();
         this.d.getTheme().resolveAttribute(R.attr.textColorSearchUrl, var2, true);
         this.r = this.d.getResources().getColorStateList(var2.resourceId);
      }

      SpannableString var3 = new SpannableString(var1);
      var3.setSpan(new TextAppearanceSpan(null, 0, 0, this.r, null), 0, var1.length(), 33);
      return var3;
   }

   private void d(Cursor var1) {
      Bundle var2;
      if (var1 != null) {
         var2 = var1.getExtras();
      } else {
         var2 = null;
      }

      if (var2 != null && var2.getBoolean("in_progress")) {
      }
   }

   private Drawable e(Cursor var1) {
      Drawable var2;
      if (this.v == -1) {
         var2 = null;
      } else {
         Drawable var3 = this.a(var1.getString(this.v));
         var2 = var3;
         if (var3 == null) {
            var2 = this.g(var1);
         }
      }

      return var2;
   }

   private Drawable f(Cursor var1) {
      Drawable var2;
      if (this.w == -1) {
         var2 = null;
      } else {
         var2 = this.a(var1.getString(this.w));
      }

      return var2;
   }

   private Drawable g(Cursor var1) {
      Drawable var2 = this.a(this.l.getSearchActivity());
      if (var2 == null) {
         var2 = this.d.getPackageManager().getDefaultActivityIcon();
      }

      return var2;
   }

   Cursor a(SearchableInfo var1, String var2, int var3) {
      Cursor var4 = null;
      if (var1 != null) {
         String var5 = var1.getSuggestAuthority();
         if (var5 != null) {
            Builder var8 = new Builder().scheme("content").authority(var5).query("").fragment("");
            var5 = var1.getSuggestPath();
            if (var5 != null) {
               var8.appendEncodedPath(var5);
            }

            var8.appendPath("search_suggest_query");
            var5 = var1.getSuggestSelection();
            String[] var6;
            if (var5 != null) {
               var6 = new String[]{var2};
            } else {
               var8.appendPath(var2);
               var6 = null;
            }

            if (var3 > 0) {
               var8.appendQueryParameter("limit", String.valueOf(var3));
            }

            Uri var7 = var8.build();
            var4 = this.d.getContentResolver().query(var7, null, var5, var6, null);
         }
      }

      return var4;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public Cursor a(CharSequence var1) {
      if (var1 == null) {
         var1 = "";
      } else {
         var1 = var1.toString();
      }

      Object var5;
      if (this.k.getVisibility() == 0 && this.k.getWindowVisibility() == 0) {
         label28: {
            try {
               var5 = this.a(this.l, var1, 50);
            } catch (RuntimeException var3) {
               Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", var3);
               break label28;
            }

            if (var5 != null) {
               try {
                  var5.getCount();
                  return var5;
               } catch (RuntimeException var2) {
                  Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", var2);
               }
            }
         }

         var5 = null;
      } else {
         var5 = null;
      }

      return var5;
   }

   Drawable a(Uri var1) throws FileNotFoundException {
      String var5 = var1.getAuthority();
      if (TextUtils.isEmpty(var5)) {
         throw new FileNotFoundException("No authority: " + var1);
      }

      Resources var3;
      try {
         var3 = this.d.getPackageManager().getResourcesForApplication(var5);
      } catch (NameNotFoundException var7) {
         throw new FileNotFoundException("No package found for authority: " + var1);
      }

      List var4 = var1.getPathSegments();
      if (var4 == null) {
         throw new FileNotFoundException("No path: " + var1);
      }

      int var2 = var4.size();
      if (var2 == 1) {
         try {
            var2 = Integer.parseInt((String)var4.get(0));
         } catch (NumberFormatException var6) {
            throw new FileNotFoundException("Single path segment is not a resource ID: " + var1);
         }
      } else {
         if (var2 != 2) {
            throw new FileNotFoundException("More than two path segments: " + var1);
         }

         var2 = var3.getIdentifier((String)var4.get(1), (String)var4.get(0), var5);
      }

      if (var2 == 0) {
         throw new FileNotFoundException("No resource found for: " + var1);
      } else {
         return var3.getDrawable(var2);
      }
   }

   @Override
   public View a(Context var1, Cursor var2, ViewGroup var3) {
      View var4 = super.a(var1, var2, var3);
      var4.setTag(new SuggestionsAdapter.ChildViewCache(var4));
      ((ImageView)var4.findViewById(R.id.edit_query)).setImageResource(this.o);
      return var4;
   }

   public void a(int var1) {
      this.q = var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void a(Cursor var1) {
      if (this.p) {
         Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
         if (var1 != null) {
            var1.close();
         }
      } else {
         try {
            super.a(var1);
         } catch (Exception var3) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", var3);
            return;
         }

         if (var1 != null) {
            try {
               this.s = var1.getColumnIndex("suggest_text_1");
               this.t = var1.getColumnIndex("suggest_text_2");
               this.u = var1.getColumnIndex("suggest_text_2_url");
               this.v = var1.getColumnIndex("suggest_icon_1");
               this.w = var1.getColumnIndex("suggest_icon_2");
               this.x = var1.getColumnIndex("suggest_flags");
            } catch (Exception var2) {
               Log.e("SuggestionsAdapter", "error changing cursor and caching columns", var2);
            }
         }
      }
   }

   @Override
   public void a(View var1, Context var2, Cursor var3) {
      SuggestionsAdapter.ChildViewCache var8 = (SuggestionsAdapter.ChildViewCache)var1.getTag();
      int var4;
      if (this.x != -1) {
         var4 = var3.getInt(this.x);
      } else {
         var4 = 0;
      }

      if (var8.a != null) {
         String var5 = a(var3, this.s);
         this.a(var8.a, var5);
      }

      if (var8.b != null) {
         String var6 = a(var3, this.u);
         CharSequence var7;
         if (var6 != null) {
            var7 = this.b((CharSequence)var6);
         } else {
            var7 = a(var3, this.t);
         }

         if (TextUtils.isEmpty(var7)) {
            if (var8.a != null) {
               var8.a.setSingleLine(false);
               var8.a.setMaxLines(2);
            }
         } else if (var8.a != null) {
            var8.a.setSingleLine(true);
            var8.a.setMaxLines(1);
         }

         this.a(var8.b, var7);
      }

      if (var8.c != null) {
         this.a(var8.c, this.e(var3), 4);
      }

      if (var8.d != null) {
         this.a(var8.d, this.f(var3), 8);
      }

      if (this.q != 2 && (this.q != 1 || (var4 & 1) == 0)) {
         var8.e.setVisibility(8);
      } else {
         var8.e.setVisibility(0);
         var8.e.setTag(var8.a.getText());
         var8.e.setOnClickListener(this);
      }
   }

   @Override
   public CharSequence c(Cursor var1) {
      Object var3 = null;
      String var2;
      if (var1 == null) {
         var2 = (String)var3;
      } else {
         var2 = a(var1, "suggest_intent_query");
         if (var2 == null) {
            if (this.l.shouldRewriteQueryFromData()) {
               var2 = a(var1, "suggest_intent_data");
               if (var2 != null) {
                  return var2;
               }
            }

            var2 = (String)var3;
            if (this.l.shouldRewriteQueryFromText()) {
               String var4 = a(var1, "suggest_text_1");
               var2 = (String)var3;
               if (var4 != null) {
                  var2 = var4;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      try {
         var2 = super.getDropDownView(var1, var2, var3);
      } catch (RuntimeException var5) {
         Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", var5);
         var2 = this.b(this.d, this.c, var3);
         if (var2 != null) {
            ((SuggestionsAdapter.ChildViewCache)var2.getTag()).a.setText(var5.toString());
         }
      }

      return var2;
   }

   @Override
   public View getView(int var1, View var2, ViewGroup var3) {
      try {
         var2 = super.getView(var1, var2, var3);
      } catch (RuntimeException var5) {
         Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", var5);
         var2 = this.a(this.d, this.c, var3);
         if (var2 != null) {
            ((SuggestionsAdapter.ChildViewCache)var2.getTag()).a.setText(var5.toString());
         }
      }

      return var2;
   }

   @Override
   public boolean hasStableIds() {
      return false;
   }

   public void notifyDataSetChanged() {
      super.notifyDataSetChanged();
      this.d(this.a());
   }

   public void notifyDataSetInvalidated() {
      super.notifyDataSetInvalidated();
      this.d(this.a());
   }

   public void onClick(View var1) {
      Object var2 = var1.getTag();
      if (var2 instanceof CharSequence) {
         this.k.a((CharSequence)var2);
      }
   }

   private static final class ChildViewCache {
      public final TextView a;
      public final TextView b;
      public final ImageView c;
      public final ImageView d;
      public final ImageView e;

      public ChildViewCache(View var1) {
         this.a = (TextView)var1.findViewById(16908308);
         this.b = (TextView)var1.findViewById(16908309);
         this.c = (ImageView)var1.findViewById(16908295);
         this.d = (ImageView)var1.findViewById(16908296);
         this.e = (ImageView)var1.findViewById(R.id.edit_query);
      }
   }
}
