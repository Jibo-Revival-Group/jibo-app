package com.jibo.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class LoopsAndLastMessagesContentProvider extends ContentProvider {
   private DatabaseHelper a;

   public int delete(Uri var1, String var2, String[] var3) {
      throw new UnsupportedOperationException();
   }

   public String getType(Uri var1) {
      return "com.jibo.provider.db/lastMessages";
   }

   public Uri insert(Uri var1, ContentValues var2) {
      throw new UnsupportedOperationException();
   }

   public boolean onCreate() {
      this.a = DatabaseHelper.a(this.getContext());
      return true;
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      StringBuilder var6 = new StringBuilder(
         "SELECT LoopsAndMessages._id AS _id, LoopsAndMessages.content AS content, LoopsAndMessages.created AS created, LoopsAndMessages.sender AS sender, LoopsAndMessages.name AS name, LoopsAndMessages.data As data, unread.unreadCount As unreadCount, account.data AS userData, LoopsAndMessages.hasPhotoVideo AS hasPhotoVideo FROM(SELECT message.loopId, message.content, message.created, message.sender, loop.name, loop.data, loop._id, message.hasPhotoVideo FROM entity AS loop  LEFT JOIN (SELECT a.loopId, a.sender, a.content, a.created, a.hasPhotoVideo, a._id as messageId FROM jot AS a WHERE NOT EXISTS (SELECT b._id, b.created FROM jot AS b WHERE a.loopId = b.loopId AND b.created > a.created)) AS message ON loop._id = message.loopId WHERE loop.type = 8"
      );
      if (var3 != null) {
         var6.append(" AND loop.");
         var6.append(var3);
      }

      var6.append(
         " ) as LoopsAndMessages LEFT JOIN (SELECT * FROM entity WHERE type = 2 )AS account ON LoopsAndMessages.sender = account._id LEFT JOIN (SELECT loopId, COUNT(*) as unreadCount FROM jot WHERE is_read = 0 AND _id NOT LIKE 'TEMP%' GROUP BY loopId) AS unread ON LoopsAndMessages.loopId = unread.loopId"
      );
      Cursor var7 = this.a.getReadableDatabase().rawQuery(var6.toString(), null);
      var7.setNotificationUri(this.getContext().getContentResolver(), var1);
      return var7;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      throw new UnsupportedOperationException();
   }
}
