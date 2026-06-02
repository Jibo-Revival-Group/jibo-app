package com.jibo.db;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
   public static final Uri a = Uri.parse("content://com.jibo.provider.db");
   public static final Uri b = Uri.parse("content://com.jibo.provider.db.messages");

   public static final class EntityEntry implements BaseColumns {
      public static final String[] a = new String[]{"_id", "name", "type", "retrieved", "modified", "data"};
      public static final Uri b = DatabaseContract.a.buildUpon().appendPath("entity").build();

      public static Uri a(int var0) {
         return b.buildUpon().appendPath(Integer.toString(var0)).build();
      }

      public static Uri a(int var0, String var1) {
         return b.buildUpon().appendPath(Integer.toString(var0)).appendPath(var1).build();
      }
   }

   public static final class JotEntry implements BaseColumns {
      public static final Uri a = DatabaseContract.a.buildUpon().appendPath("jot").build();

      public static Uri a(String var0) {
         return a.buildUpon().appendPath(var0).build();
      }
   }

   public static class LogEntry implements BaseColumns {
      public static final Uri a = DatabaseContract.a.buildUpon().appendPath("log_entries").build();

      public static Uri a(long var0) {
         return ContentUris.withAppendedId(a, var0);
      }
   }

   public static final class MediaEntry implements BaseColumns {
      public static final String[] a = new String[]{"_id", "accountId", "url", "loopId", "created", "type", "reference", "isEncrypted"};
      public static final Uri b = DatabaseContract.a.buildUpon().appendPath("media").build();

      public static Uri a(String var0) {
         return b.buildUpon().appendPath(var0).build();
      }
   }
}
