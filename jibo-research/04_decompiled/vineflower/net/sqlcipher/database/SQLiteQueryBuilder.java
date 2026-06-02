package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;

public class SQLiteQueryBuilder {
   private static final String TAG = "SQLiteQueryBuilder";
   private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
   private boolean mDistinct;
   private SQLiteDatabase.CursorFactory mFactory;
   private Map<String, String> mProjectionMap = null;
   private boolean mStrictProjectionMap;
   private String mTables = "";
   private StringBuilder mWhereClause = null;

   public SQLiteQueryBuilder() {
      this.mDistinct = false;
      this.mFactory = null;
   }

   private static void appendClause(StringBuilder var0, String var1, String var2) {
      if (!TextUtils.isEmpty(var2)) {
         var0.append(var1);
         var0.append(var2);
      }
   }

   private static void appendClauseEscapeClause(StringBuilder var0, String var1, String var2) {
      if (!TextUtils.isEmpty(var2)) {
         var0.append(var1);
         DatabaseUtils.appendEscapedSQLString(var0, var2);
      }
   }

   public static void appendColumns(StringBuilder var0, String[] var1) {
      int var3 = var1.length;

      for (int var2 = 0; var2 < var3; var2++) {
         String var4 = var1[var2];
         if (var4 != null) {
            if (var2 > 0) {
               var0.append(", ");
            }

            var0.append(var4);
         }
      }

      var0.append(' ');
   }

   public static String buildQueryString(boolean var0, String var1, String[] var2, String var3, String var4, String var5, String var6, String var7) {
      if (TextUtils.isEmpty(var4) && !TextUtils.isEmpty(var5)) {
         throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
      }

      if (!TextUtils.isEmpty(var7) && !sLimitPattern.matcher(var7).matches()) {
         throw new IllegalArgumentException("invalid LIMIT clauses:" + var7);
      }

      StringBuilder var8 = new StringBuilder(120);
      var8.append("SELECT ");
      if (var0) {
         var8.append("DISTINCT ");
      }

      if (var2 != null && var2.length != 0) {
         appendColumns(var8, var2);
      } else {
         var8.append("* ");
      }

      var8.append("FROM ");
      var8.append(var1);
      appendClause(var8, " WHERE ", var3);
      appendClause(var8, " GROUP BY ", var4);
      appendClause(var8, " HAVING ", var5);
      appendClause(var8, " ORDER BY ", var6);
      appendClause(var8, " LIMIT ", var7);
      return var8.toString();
   }

   private String[] computeProjection(String[] var1) {
      String[] var9;
      if (var1 != null && var1.length > 0) {
         var9 = var1;
         if (this.mProjectionMap != null) {
            var9 = new String[var1.length];
            int var3 = var1.length;

            for (int var8 = 0; var8 < var3; var8++) {
               String var6 = var1[var8];
               String var11 = this.mProjectionMap.get(var6);
               if (var11 != null) {
                  var9[var8] = var11;
               } else {
                  if (this.mStrictProjectionMap || !var6.contains(" AS ") && !var6.contains(" as ")) {
                     throw new IllegalArgumentException("Invalid column " + var1[var8]);
                  }

                  var9[var8] = var6;
               }
            }
         }
      } else if (this.mProjectionMap != null) {
         Set var4 = this.mProjectionMap.entrySet();
         var1 = new String[var4.size()];
         Iterator var5 = var4.iterator();
         int var2 = 0;

         while (true) {
            var9 = var1;
            if (!var5.hasNext()) {
               break;
            }

            Entry var10 = (Entry)var5.next();
            if (!((String)var10.getKey()).equals("_count")) {
               var1[var2] = (String)var10.getValue();
               var2++;
            }
         }
      } else {
         var9 = null;
      }

      return var9;
   }

   public void appendWhere(CharSequence var1) {
      if (this.mWhereClause == null) {
         this.mWhereClause = new StringBuilder(var1.length() + 16);
      }

      if (this.mWhereClause.length() == 0) {
         this.mWhereClause.append('(');
      }

      this.mWhereClause.append(var1);
   }

   public void appendWhereEscapeString(String var1) {
      if (this.mWhereClause == null) {
         this.mWhereClause = new StringBuilder(var1.length() + 16);
      }

      if (this.mWhereClause.length() == 0) {
         this.mWhereClause.append('(');
      }

      DatabaseUtils.appendEscapedSQLString(this.mWhereClause, var1);
   }

   public String buildQuery(String[] var1, String var2, String[] var3, String var4, String var5, String var6, String var7) {
      var3 = this.computeProjection(var1);
      StringBuilder var9 = new StringBuilder();
      boolean var8;
      if (this.mWhereClause != null && this.mWhereClause.length() > 0) {
         var8 = true;
      } else {
         var8 = false;
      }

      if (var8) {
         var9.append(this.mWhereClause.toString());
         var9.append(')');
      }

      if (var2 != null && var2.length() > 0) {
         if (var8) {
            var9.append(" AND ");
         }

         var9.append('(');
         var9.append(var2);
         var9.append(')');
      }

      return buildQueryString(this.mDistinct, this.mTables, var3, var9.toString(), var4, var5, var6, var7);
   }

   public String buildUnionQuery(String[] var1, String var2, String var3) {
      StringBuilder var7 = new StringBuilder(128);
      int var5 = var1.length;
      String var6;
      if (this.mDistinct) {
         var6 = " UNION ";
      } else {
         var6 = " UNION ALL ";
      }

      for (int var4 = 0; var4 < var5; var4++) {
         if (var4 > 0) {
            var7.append(var6);
         }

         var7.append(var1[var4]);
      }

      appendClause(var7, " ORDER BY ", var2);
      appendClause(var7, " LIMIT ", var3);
      return var7.toString();
   }

   public String buildUnionSubQuery(String var1, String[] var2, Set<String> var3, int var4, String var5, String var6, String[] var7, String var8, String var9) {
      int var11 = var2.length;
      String[] var13 = new String[var11];

      for (int var10 = 0; var10 < var11; var10++) {
         String var12 = var2[var10];
         if (var12.equals(var1)) {
            var13[var10] = "'" + var5 + "' AS " + var1;
         } else if (var10 > var4 && !var3.contains(var12)) {
            var13[var10] = "NULL AS " + var12;
         } else {
            var13[var10] = var12;
         }
      }

      return this.buildQuery(var13, var6, var7, var8, var9, null, null);
   }

   public String getTables() {
      return this.mTables;
   }

   public Cursor query(SQLiteDatabase var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7) {
      return this.query(var1, var2, var3, var4, var5, var6, var7, null);
   }

   public Cursor query(SQLiteDatabase var1, String[] var2, String var3, String[] var4, String var5, String var6, String var7, String var8) {
      Cursor var9;
      if (this.mTables == null) {
         var9 = null;
      } else {
         String var10 = this.buildQuery(var2, var3, var4, var5, var6, var7, var8);
         if (Log.isLoggable("SQLiteQueryBuilder", 3)) {
            Log.d("SQLiteQueryBuilder", "Performing query: " + var10);
         }

         var9 = var1.rawQueryWithFactory(this.mFactory, var10, var4, SQLiteDatabase.findEditTable(this.mTables));
      }

      return var9;
   }

   public void setCursorFactory(SQLiteDatabase.CursorFactory var1) {
      this.mFactory = var1;
   }

   public void setDistinct(boolean var1) {
      this.mDistinct = var1;
   }

   public void setProjectionMap(Map<String, String> var1) {
      this.mProjectionMap = var1;
   }

   public void setStrictProjectionMap(boolean var1) {
      this.mStrictProjectionMap = var1;
   }

   public void setTables(String var1) {
      this.mTables = var1;
   }
}
