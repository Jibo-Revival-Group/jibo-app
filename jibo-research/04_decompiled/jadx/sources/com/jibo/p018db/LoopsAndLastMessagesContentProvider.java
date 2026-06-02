package com.jibo.p018db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class LoopsAndLastMessagesContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a */
    private DatabaseHelper f9722a;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f9722a = DatabaseHelper.m10084a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        StringBuilder sb = new StringBuilder("SELECT LoopsAndMessages._id AS _id, LoopsAndMessages.content AS content, LoopsAndMessages.created AS created, LoopsAndMessages.sender AS sender, LoopsAndMessages.name AS name, LoopsAndMessages.data As data, unread.unreadCount As unreadCount, account.data AS userData, LoopsAndMessages.hasPhotoVideo AS hasPhotoVideo FROM(SELECT message.loopId, message.content, message.created, message.sender, loop.name, loop.data, loop._id, message.hasPhotoVideo FROM entity AS loop  LEFT JOIN (SELECT a.loopId, a.sender, a.content, a.created, a.hasPhotoVideo, a._id as messageId FROM jot AS a WHERE NOT EXISTS (SELECT b._id, b.created FROM jot AS b WHERE a.loopId = b.loopId AND b.created > a.created)) AS message ON loop._id = message.loopId WHERE loop.type = 8");
        if (str != null) {
            sb.append(" AND loop.");
            sb.append(str);
        }
        sb.append(" ) as LoopsAndMessages LEFT JOIN (SELECT * FROM entity WHERE type = 2 )AS account ON LoopsAndMessages.sender = account._id LEFT JOIN (SELECT loopId, COUNT(*) as unreadCount FROM jot WHERE is_read = 0 AND _id NOT LIKE 'TEMP%' GROUP BY loopId) AS unread ON LoopsAndMessages.loopId = unread.loopId");
        Cursor cursorRawQuery = this.f9722a.getReadableDatabase().rawQuery(sb.toString(), null);
        cursorRawQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorRawQuery;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "com.jibo.provider.db/lastMessages";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
