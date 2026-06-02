package com.salesforce.androidsdk.smartstore.store;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuerySpec {
   public final QuerySpec.QueryType a;
   public final int b;
   public final String c;
   public final String d;
   public final String e;
   public final String f;
   public final String[] g;
   public final String h;
   public final String i;
   public final QuerySpec.Order j;
   public final String k;
   public final String l;
   public final String m;
   public final String n;

   private QuerySpec(String var1, int var2) {
      this.c = var1;
      this.d = this.a(var1);
      this.e = this.b(var1);
      this.b = var2;
      this.a = QuerySpec.QueryType.smart;
      this.f = null;
      this.g = null;
      this.h = null;
      this.k = null;
      this.l = null;
      this.m = null;
      this.n = null;
      this.i = null;
      this.j = null;
   }

   private QuerySpec(
      String var1,
      String[] var2,
      QuerySpec.QueryType var3,
      String var4,
      String var5,
      String var6,
      String var7,
      String var8,
      QuerySpec.Order var9,
      int var10,
      String var11
   ) {
      this.f = var1;
      this.g = var2;
      this.h = var11;
      this.a = var3;
      this.k = var4;
      this.l = var5;
      this.m = var6;
      this.n = var7;
      this.i = var8;
      this.j = var9;
      this.b = var10;
      this.c = this.b();
      this.d = this.c();
      this.e = this.d();
   }

   public static QuerySpec a(String var0, int var1) {
      return new QuerySpec(var0, var1);
   }

   public static QuerySpec a(String var0, String var1, QuerySpec.Order var2, int var3) {
      return a(var0, null, var1, var2, var3);
   }

   public static QuerySpec a(String var0, String var1, String var2, String var3, QuerySpec.Order var4, int var5) {
      return a(var0, null, var1, var2, var3, var4, var5);
   }

   public static QuerySpec a(String var0, String[] var1, String var2, QuerySpec.Order var3, int var4) {
      return new QuerySpec(var0, var1, QuerySpec.QueryType.range, null, null, null, null, var2, var3, var4, null);
   }

   public static QuerySpec a(String var0, String[] var1, String var2, String var3, String var4, QuerySpec.Order var5, int var6) {
      return new QuerySpec(var0, var1, QuerySpec.QueryType.exact, var3, null, null, null, var4, var5, var6, var2);
   }

   private String a(String var1) {
      return String.format("SELECT count(*) FROM (%s)", var1);
   }

   public static String a(String var0, String var1) {
      if (var0 != null) {
         StringBuffer var2 = new StringBuffer();
         Matcher var3 = Pattern.compile("[^\\(\\) ]+").matcher(var1);

         while (var3.find()) {
            String var4 = var3.group();
            var1 = var4.toLowerCase();
            if (!var1.equals("and") && !var1.equals("or") && !var1.equals("not") && !var4.startsWith("{")) {
               var3.appendReplacement(var2, var0 + ":" + var4);
            } else {
               var3.appendReplacement(var2, var4);
            }
         }

         var3.appendTail(var2);
         var1 = var2.toString();
      }

      return var1;
   }

   private String b() {
      String var2 = this.e();
      String var1 = this.f();
      String var3 = this.g();
      String var4 = this.h();
      return var2 + var1 + var3 + var4;
   }

   private String b(String var1) {
      return String.format("SELECT id FROM (%s)", var1);
   }

   private String c() {
      String var2 = this.f();
      String var1 = this.g();
      return "SELECT count(*) " + var2 + var1;
   }

   private String c(String var1) {
      return "{" + this.f + ":" + var1 + "}";
   }

   private String d() {
      String var2 = this.f();
      String var3 = this.g();
      String var1 = this.h();
      return "SELECT id " + var2 + var3 + var1;
   }

   private String e() {
      int var1 = 0;
      ArrayList var4 = new ArrayList();
      String[] var3;
      if (this.g != null) {
         var3 = this.g;
      } else {
         var3 = new String[]{"_soup"};
      }

      for (int var2 = var3.length; var1 < var2; var1++) {
         var4.add(this.c(var3[var1]));
      }

      return "SELECT " + TextUtils.join(", ", var4) + " ";
   }

   private String f() {
      return "FROM " + this.i() + " ";
   }

   private String g() {
      String var3;
      if (this.h == null && this.a != QuerySpec.QueryType.match) {
         var3 = "";
      } else {
         var3 = null;
         if (this.h != null) {
            var3 = this.c(this.h);
         }

         switch (<unrepresentable>.a[this.a.ordinal()]) {
            case 1:
               var3 = var3 + " = ? ";
               break;
            case 2:
               var3 = var3 + " LIKE ? ";
               break;
            case 3:
               if (this.l == null && this.m == null) {
                  var3 = "";
               } else if (this.m == null) {
                  var3 = var3 + " >= ? ";
               } else if (this.l == null) {
                  var3 = var3 + " <= ? ";
               } else {
                  var3 = var3 + " >= ? AND " + var3 + " <= ? ";
               }
               break;
            case 4:
               var3 = this.c("_soupEntryId")
                  + " IN ("
                  + "SELECT "
                  + "rowid"
                  + " "
                  + "FROM "
                  + this.j()
                  + " "
                  + "WHERE "
                  + this.j()
                  + " MATCH '"
                  + a(var3, this.k)
                  + "') ";
               break;
            default:
               throw new SmartStore.SmartStoreException("Fell through switch: " + this.a);
         }

         if (var3.equals("")) {
            var3 = "";
         } else {
            var3 = "WHERE " + var3;
         }
      }

      return var3;
   }

   private String h() {
      String var1;
      if (this.i != null && this.j != null) {
         var1 = "ORDER BY " + this.c(this.i) + " " + this.j.sql + " ";
      } else {
         var1 = "";
      }

      return var1;
   }

   private String i() {
      return "{" + this.f + "}";
   }

   private String j() {
      return this.i() + "_fts";
   }

   public String[] a() {
      Object var2 = null;
      String var1 = (String)var2;
      switch (<unrepresentable>.a[this.a.ordinal()]) {
         case 1:
            var1 = new String[]{this.k};
            break;
         case 2:
            var1 = new String[]{this.n};
            break;
         case 3:
            if (this.l == null) {
               var1 = (String)var2;
               if (this.m == null) {
                  return var1;
               }
            }

            if (this.m == null) {
               var1 = new String[]{this.l};
            } else if (this.l == null) {
               var1 = new String[]{this.m};
            } else {
               var1 = new String[]{this.l, this.m};
            }
         case 4:
         case 5:
            break;
         default:
            throw new SmartStore.SmartStoreException("Fell through switch: " + this.a);
      }

      return var1;
   }

   public enum Order {
      ascending("ASC"),
      descending("DESC");

      private static final QuerySpec.Order[] $VALUES = new QuerySpec.Order[]{QuerySpec.Order.ascending, QuerySpec.Order.descending};
      public final String sql;

      Order(String var3) {
         this.sql = var3;
      }
   }

   public enum QueryType {
      exact,
      like,
      match,
      range,
      smart;

      private static final QuerySpec.QueryType[] $VALUES = new QuerySpec.QueryType[]{
         QuerySpec.QueryType.exact, QuerySpec.QueryType.range, QuerySpec.QueryType.like, QuerySpec.QueryType.match, QuerySpec.QueryType.smart
      };
   }
}
