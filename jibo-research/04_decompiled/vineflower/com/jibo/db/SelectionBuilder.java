package com.jibo.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.jibo.utils.Lists;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class SelectionBuilder {
   private static final String a = LogUtils.a(SelectionBuilder.class);
   private String b = null;
   private Map<String, String> c = Maps.a();
   private StringBuilder d = new StringBuilder();
   private ArrayList<String> e = Lists.a();
   private String f = null;
   private String g = null;

   private void a(String[] var1) {
      for (int var2 = 0; var2 < var1.length; var2++) {
         String var3 = this.c.get(var1[var2]);
         if (var3 != null) {
            var1[var2] = var3;
         }
      }
   }

   private void d() {
      if (this.b == null) {
         throw new IllegalStateException("Table not specified");
      }
   }

   public int a(SQLiteDatabase var1) {
      this.d();
      LogUtils.b(a, "delete() " + this);
      return var1.delete(this.b, this.b(), this.c());
   }

   public int a(SQLiteDatabase var1, ContentValues var2) {
      this.d();
      LogUtils.b(a, "update() " + this);
      return var1.update(this.b, var2, this.b(), this.c());
   }

   public Cursor a(SQLiteDatabase var1, String[] var2, String var3) {
      return this.a(var1, var2, null, null, var3, null);
   }

   public Cursor a(SQLiteDatabase var1, String[] var2, String var3, String var4, String var5, String var6) {
      this.d();
      if (var2 != null) {
         this.a(var2);
      }

      if (TextUtils.isEmpty(var5) && !TextUtils.isEmpty(this.f)) {
         var5 = this.f;
      }

      LogUtils.b(a, "query(columns=" + Arrays.toString(var2) + ") " + this);
      return var1.query(this.b, var2, this.b(), this.c(), var3, var4, var5, var6);
   }

   public SelectionBuilder a(String var1) {
      this.b = var1;
      return this;
   }

   public SelectionBuilder a(String var1, String... var2) {
      if (TextUtils.isEmpty(var1)) {
         if (var2 != null && var2.length > 0) {
            throw new IllegalArgumentException("Valid selection required when including arguments=");
         }
      } else {
         if (this.d.length() > 0) {
            this.d.append(" AND ");
         }

         this.d.append("(").append(var1).append(")");
         if (var2 != null) {
            Collections.addAll(this.e, var2);
         }
      }

      return this;
   }

   public String a() {
      return this.g;
   }

   public SelectionBuilder b(String var1) {
      this.f = var1;
      return this;
   }

   public SelectionBuilder b(String var1, String... var2) {
      if (TextUtils.isEmpty(var1)) {
         if (var2 != null && var2.length > 0) {
            throw new IllegalArgumentException("Valid selection required when including arguments=");
         }
      } else {
         if (this.d.length() > 0) {
            this.d.append(" OR ");
         }

         this.d.append("(").append(var1).append(")");
         if (var2 != null) {
            Collections.addAll(this.e, var2);
         }
      }

      return this;
   }

   public String b() {
      return this.d.toString();
   }

   public SelectionBuilder c(String var1, String... var2) {
      if (TextUtils.isEmpty(var1)) {
         if (var2 != null && var2.length > 0) {
            throw new IllegalArgumentException("Valid selection required when including arguments=");
         }
      } else {
         if (this.d.length() > 0) {
            this.d.append(" AND ");
         }

         this.d.append("(").append(var1).append(")");
         if (var2 != null) {
            Collections.addAll(this.e, var2);
         }
      }

      return this;
   }

   public String[] c() {
      return this.e.toArray(new String[this.e.size()]);
   }

   @Override
   public String toString() {
      return "SelectionBuilder[table=" + this.b + ", selection=" + this.b() + ", selectionArgs=" + Arrays.toString(this.c()) + "]";
   }
}
