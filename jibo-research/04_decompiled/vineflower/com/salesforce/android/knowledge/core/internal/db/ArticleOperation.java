package com.salesforce.android.knowledge.core.internal.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.salesforce.android.knowledge.core.internal.model.ArticleDetailsModel;
import com.salesforce.android.knowledge.core.internal.model.ArticleListModel;
import com.salesforce.android.knowledge.core.internal.model.ArticleSummaryModel;
import com.salesforce.android.knowledge.core.internal.model.ChatterUserModel;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.ArticleSummary;
import com.salesforce.android.knowledge.core.model.ChatterUser;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

class ArticleOperation {
   static final ServiceLogger a = ServiceLogging.a(ArticleOperation.class);
   @SuppressLint("SimpleDateFormat")
   static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

   static void a(int var0, int var1, StringBuilder var2) {
      var2.append(" OFFSET ");
      var2.append((var0 - 1) * var1);
   }

   static void a(int var0, StringBuilder var1) {
      var1.append(" LIMIT ");
      var1.append(var0 + 1);
   }

   static void a(CharSequence var0, StringBuilder var1, List<String> var2) {
      var1.append(" (");
      a("ArticleSummary", "title", var1);
      c(var0.toString(), var1, var2);
      var1.append(" OR ");
      a("ArticleSummary", "summary", var1);
      c(var0.toString(), var1, var2);
      var1.append(")");
   }

   static void a(String var0, String var1, StringBuilder var2) {
      var2.append(var0);
      var2.append(".");
      var2.append(var1);
   }

   static void a(String var0, StringBuilder var1, List<String> var2) {
      var1.append(" ");
      a("ArticleCategories", "category_name", var1);
      b(var0, var1, var2);
   }

   static void a(StringBuilder var0) {
      var0.append(" INNER JOIN ");
      var0.append("ArticleCategories");
      var0.append(" ON ");
      a("ArticleCategories", "article_id", var0);
      var0.append(" = ");
      a("ArticleSummary", "id", var0);
   }

   public static void a(SQLiteDatabase var0) {
      var0.execSQL(
         "CREATE TABLE IF NOT EXISTS ArticleSummary (id TEXT PRIMARY KEY, article_number TEXT NOT NULL, title TEXT NOT NULL, url TEXT, summary TEXT, last_published TEXT, view_score REAL NOT NULL DEFAULT 0, view_count INTEGER NOT NULL DEFAULT 0, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"
      );
      var0.execSQL("CREATE TABLE IF NOT EXISTS ChatterUser (id TEXT PRIMARY KEY, first_name TEXT, last_name TEXT, email TEXT, username TEXT)");
      var0.execSQL(
         "CREATE TABLE IF NOT EXISTS ArticleDetail (article_id TEXT NOT NULL, last_modified_date TEXT NOT NULL, last_modified_by TEXT NOT NULL, created_date TEXT NOT NULL, created_by TEXT NOT NULL, version_number INTEGER NOT NULL, cached_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP, UNIQUE(article_id), FOREIGN KEY(article_id) REFERENCES ArticleSummary(id),FOREIGN KEY(last_modified_by) REFERENCES ChatterUser(id),FOREIGN KEY(created_by) REFERENCES ChatterUser(id))"
      );
      var0.execSQL(
         "CREATE TABLE IF NOT EXISTS ArticleField (article_id TEXT NOT NULL, name TEXT NOT NULL, label TEXT NOT NULL, value TEXT, type INTEGER NOT NULL, UNIQUE(article_id, name),FOREIGN KEY(article_id) REFERENCES ArticleDetail(article_id))"
      );
   }

   static void a(SQLiteDatabase var0, ArticleSummary var1) {
      var1 = var1;
      ContentValues var2 = new ContentValues();
      var2.put("id", var1.g());
      var2.put("article_number", var1.h());
      var2.put("last_published", b.format(var1.n()));
      var2.put("summary", var1.j());
      var2.put("title", var1.i());
      var2.put("url", var1.k());
      var2.put("view_score", var1.m());
      var2.put("view_count", var1.l());
      var0.insertWithOnConflict("ArticleSummary", null, var2, 5);
   }

   static void b(int var0, int var1, StringBuilder var2) {
      var2.append(" ORDER BY ");
      switch (var0) {
         case 1:
            var2.append("datetime(");
            a("ArticleSummary", "last_published", var2);
            var2.append(")");
            break;
         case 2:
            a("ArticleSummary", "title", var2);
            break;
         case 3:
            a("ArticleSummary", "view_score", var2);
            break;
         default:
            throw new IllegalArgumentException("Unhandled sorting column");
      }

      if (var1 == 1) {
         var2.append(" ASC");
      } else {
         var2.append(" DESC");
      }
   }

   static void b(String var0, StringBuilder var1, List<String> var2) {
      var1.append(" = ?");
      var2.add(var0);
   }

   public static void b(SQLiteDatabase var0) {
      DbUtil.a(var0, "ArticleField");
      DbUtil.a(var0, "ArticleDetail");
      DbUtil.a(var0, "ChatterUser");
      DbUtil.a(var0, "ArticleSummary");
   }

   static void c(String var0, StringBuilder var1, List<String> var2) {
      var1.append(" LIKE ?");
      var2.add('%' + var0 + '%');
   }

   static class ReadDetails implements DbRead.Operation<ArticleDetails> {
      private final ArticleDetailRequest a;

      ReadDetails(ArticleDetailRequest var1) {
         this.a = var1;
      }

      private static ChatterUserModel a(Cursor var0, String var1) {
         String var2 = DbUtil.a(var0, var1 + "__" + "id");
         return ChatterUserModel.a(
            DbUtil.a(var0, var1 + "__" + "first_name"),
            DbUtil.a(var0, var1 + "__" + "last_name"),
            DbUtil.a(var0, var1 + "__" + "email"),
            DbUtil.a(var0, var1 + "__" + "username"),
            var2
         );
      }

      public static List<ArticleDetailsModel.FieldModel> a(SQLiteDatabase var0, String[] var1) {
         net.sqlcipher.Cursor var3 = var0.rawQuery("SELECT * FROM ArticleField WHERE article_id = ?", var1);
         ArrayList var2 = new ArrayList(var3.getCount());

         while (var3.moveToNext()) {
            var2.add(ArticleDetailsModel.FieldModel.a(DbUtil.a(var3, "label"), DbUtil.a(var3, "name"), DbUtil.a(var3, "value"), DbUtil.b(var3, "type")));
         }

         var3.close();
         return var2;
      }

      // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      public ArticleDetails a(SQLiteDatabase var1) throws Exception {
         String var14 = this.a.a();
         String[] var17 = new String[]{var14};
         net.sqlcipher.Cursor var6 = var1.rawQuery(
            "SELECT ad.*, sum.*, cu.id AS cu__id, cu.first_name AS cu__first_name, cu.last_name AS cu__last_name, cu.email AS cu__email, cu.username AS cu__username, mu.id AS mu__id, mu.first_name AS mu__first_name, mu.last_name AS mu__last_name, mu.email AS mu__email, mu.username AS mu__username FROM ArticleDetail ad JOIN ChatterUser cu ON cu.id = ad.created_by JOIN ChatterUser mu ON mu.id = ad.last_modified_by JOIN ArticleSummary sum ON sum.id = ad.article_id WHERE ad.article_id = ?",
            var17
         );
         boolean var19 = false /* VF: Semaphore variable */;

         label29: {
            try {
               var19 = true;
               if (var6.moveToFirst()) {
                  String var11 = DbUtil.a(var6, "article_number");
                  String var10 = DbUtil.a(var6, "title");
                  String var12 = DbUtil.a(var6, "summary");
                  String var7 = DbUtil.a(var6, "url");
                  int var4 = DbUtil.b(var6, "view_count");
                  double var2 = var6.getDouble(var6.getColumnIndex("view_score"));
                  String var15 = DbUtil.a(var6, "last_published");
                  int var5 = DbUtil.b(var6, "version_number");
                  String var16 = DbUtil.a(var6, "created_date");
                  String var9 = DbUtil.a(var6, "last_modified_date");
                  ChatterUserModel var13 = a(var6, "cu");
                  ChatterUserModel var8 = a(var6, "mu");
                  List var22 = a(var1, var17);
                  var21 = ArticleDetailsModel.a(
                     var14,
                     var11,
                     var10,
                     var12,
                     var7,
                     var4,
                     var2,
                     ArticleOperation.b.parse(var15),
                     var5,
                     ArticleOperation.b.parse(var16),
                     ArticleOperation.b.parse(var9),
                     var13,
                     var8,
                     var22
                  );
                  var19 = false;
                  break label29;
               }

               var19 = false;
            } finally {
               if (var19) {
                  var6.close();
               }
            }

            var21 = null;
         }

         var6.close();
         return var21;
      }
   }

   public static class ReadList implements DbRead.Operation<ArticleList> {
      private final ArticleListRequest a;

      public ReadList(ArticleListRequest var1) {
         this.a = var1;
      }

      public ArticleList a(SQLiteDatabase var1) {
         LinkedList var7 = new LinkedList();
         boolean var4;
         if (this.a.i() != null) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         boolean var5;
         if (this.a.k() != null) {
            var5 = 1;
         } else {
            var5 = 0;
         }

         ArrayList var8 = new ArrayList(1);
         StringBuilder var9 = new StringBuilder("SELECT * FROM ");
         var9.append("ArticleSummary");
         if (var4) {
            ArticleOperation.a(var9);
            var9.append(" WHERE");
            ArticleOperation.a(this.a.i(), var9, var8);
         } else {
            var9.append(" WHERE");
         }

         if (var4 && var5) {
            var9.append(" AND");
         }

         if (var5) {
            ArticleOperation.a(this.a.k(), var9, var8);
         }

         ArticleOperation.b(this.a.e(), this.a.g(), var9);
         ArticleOperation.a(this.a.c(), var9);
         ArticleOperation.a(this.a.b(), this.a.c(), var9);
         ArticleOperation.a.a("Executing query: {}", var9);
         net.sqlcipher.Cursor var15 = var1.rawQuery(var9.toString(), var8.toArray(new String[var8.size()]));
         boolean var6 = var15.moveToFirst();
         var4 = 0;
         ArticleOperation.a.a("Found {} rows", var15.getCount());

         while (var6 && var4 < this.a.c()) {
            String var19 = var15.getString(var15.getColumnIndex("id"));
            String var11 = var15.getString(var15.getColumnIndex("article_number"));
            String var21 = var15.getString(var15.getColumnIndex("last_published"));
            String var13 = var15.getString(var15.getColumnIndex("summary"));
            String var12 = var15.getString(var15.getColumnIndex("title"));
            String var10 = var15.getString(var15.getColumnIndex("url"));
            double var2 = var15.getDouble(var15.getColumnIndex("view_score"));
            var5 = var15.getInt(var15.getColumnIndex("view_count"));

            try {
               var7.add(ArticleSummaryModel.a(var19, var11, var12, var13, var10, var5, var2, ArticleOperation.b.parse(var21)));
            } catch (ParseException var14) {
               ArticleOperation.a.d("Unable to parse last published date {} for article {}", var21, var19);
            }

            var6 = var15.moveToNext();
            var4++;
         }

         var15.close();
         ArticleListRequest var20 = this.a;
         if (var15.getCount() > this.a.c()) {
            var6 = true;
         } else {
            var6 = false;
         }

         return ArticleListModel.a(var20, var7, var6);
      }
   }

   public static class WriteDetails implements DbWrite.Operation {
      private final ArticleDetails a;

      public WriteDetails(ArticleDetails var1) {
         this.a = var1;
      }

      private static void a(SQLiteDatabase var0, ArticleDetails var1) {
         ContentValues var2 = new ContentValues();
         var2.put("article_id", var1.g());
         var2.put("created_date", ArticleOperation.b.format(var1.b()));
         var2.put("created_by", var1.d().c());
         var2.put("last_modified_date", ArticleOperation.b.format(var1.c()));
         var2.put("last_modified_by", var1.e().c());
         var2.put("version_number", var1.a());
         var0.insertWithOnConflict("ArticleDetail", null, var2, 5);
      }

      private static void a(SQLiteDatabase var0, ChatterUser var1) {
         ContentValues var2 = new ContentValues();
         var2.put("id", var1.c());
         var2.put("email", var1.a());
         var2.put("first_name", var1.b());
         var2.put("last_name", var1.d());
         var2.put("username", var1.e());
         var0.insertWithOnConflict("ChatterUser", null, var2, 5);
      }

      private static void b(SQLiteDatabase var0, ArticleDetails var1) {
         ContentValues var4 = new ContentValues();

         for (ArticleDetails.Field var2 : var1.f()) {
            var4.put("article_id", var1.g());
            var4.put("label", var2.a());
            var4.put("name", var2.b());
            var4.put("value", var2.c());
            var4.put("type", var2.d());
            var0.insertWithOnConflict("ArticleField", null, var4, 5);
         }
      }

      @Override
      public void a(SQLiteDatabase var1) {
         ChatterUser var3 = this.a.e();
         a(var1, var3);
         ChatterUser var2 = this.a.d();
         if (!var2.c().equals(var3.c())) {
            a(var1, var2);
         }

         ArticleOperation.a(var1, this.a);
         a(var1, this.a);
         b(var1, this.a);
      }
   }

   public static class WriteList implements DbWrite.Operation {
      private final ArticleList a;

      public WriteList(ArticleList var1) {
         this.a = var1;
      }

      @Override
      public void a(SQLiteDatabase var1) {
         for (ArticleSummary var3 : this.a.a()) {
            ArticleOperation.a.a("Inserting {} to database", var3.toString());
            ArticleOperation.a(var1, var3);
         }
      }
   }
}
