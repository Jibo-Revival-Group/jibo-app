package com.jibo.p018db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.jibo.p018db.DatabaseContract;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseProvider extends ContentProvider {

    /* JADX INFO: renamed from: a */
    private static final String f9701a = LogUtils.m11405a(DatabaseProvider.class);

    /* JADX INFO: renamed from: b */
    private static final UriMatcher f9702b = m10086a();

    /* JADX INFO: renamed from: c */
    private DatabaseHelper f9703c;

    /* JADX INFO: renamed from: a */
    private static UriMatcher m10086a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.jibo.provider.db", "entity", 100);
        uriMatcher.addURI("com.jibo.provider.db", "entity/#", 101);
        uriMatcher.addURI("com.jibo.provider.db", "entity/#/*", 102);
        uriMatcher.addURI("com.jibo.provider.db", "log_entries", 400);
        uriMatcher.addURI("com.jibo.provider.db", "log_entries/#", 401);
        uriMatcher.addURI("com.jibo.provider.db", ShareConstants.WEB_DIALOG_PARAM_MEDIA, 300);
        uriMatcher.addURI("com.jibo.provider.db", "media/*", 301);
        uriMatcher.addURI("com.jibo.provider.db", "jot", 200);
        uriMatcher.addURI("com.jibo.provider.db", "jot/*", 201);
        return uriMatcher;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f9703c = DatabaseHelper.m10084a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f9702b.match(uri)) {
            case 100:
            case 101:
            case 102:
                return "com.jibo.provider.db/entity";
            case 200:
            case 201:
                return "com.jibo.provider.db/jot";
            case 300:
            case 301:
                return "com.jibo.provider.db/media";
            case 400:
            case 401:
                return "vnd.android.cursor.dir/vnd.logprovider.entries";
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    /* JADX INFO: renamed from: a */
    private SelectionBuilder m10087a(Uri uri) {
        SelectionBuilder selectionBuilder = new SelectionBuilder();
        switch (f9702b.match(uri)) {
            case 100:
                return selectionBuilder.m10144a("entity").m10147b("type ASC");
            case 101:
                return selectionBuilder.m10144a("entity").m10145a("type=?", uri.getPathSegments().get(1));
            case 102:
                return selectionBuilder.m10144a("entity").m10145a("type=?", uri.getPathSegments().get(1)).m10150c("_id=?", uri.getPathSegments().get(2));
            case 200:
                return selectionBuilder.m10144a("jot");
            case 201:
                return selectionBuilder.m10144a("jot").m10145a("_id=?", uri.getPathSegments().get(1));
            case 300:
                return selectionBuilder.m10144a(ShareConstants.WEB_DIALOG_PARAM_MEDIA).m10147b("created DESC");
            case 301:
                return selectionBuilder.m10144a(ShareConstants.WEB_DIALOG_PARAM_MEDIA).m10145a("_id=?", uri.getPathSegments().get(1));
            case 400:
                return selectionBuilder.m10144a("log_entry");
            case 401:
                return selectionBuilder.m10144a("log_entry").m10145a("_id=?", uri.getPathSegments().get(1));
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorM10142a;
        SQLiteDatabase readableDatabase = this.f9703c.getReadableDatabase();
        SelectionBuilder selectionBuilderM10087a = m10087a(uri);
        if (!TextUtils.isEmpty(selectionBuilderM10087a.m10146a())) {
            cursorM10142a = selectionBuilderM10087a.m10145a(str, strArr2).m10143a(readableDatabase, strArr, null, null, str2, selectionBuilderM10087a.m10146a());
        } else {
            cursorM10142a = selectionBuilderM10087a.m10145a(str, strArr2).m10142a(readableDatabase, strArr, str2);
        }
        cursorM10142a.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorM10142a;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uriM10082a;
        SQLiteDatabase writableDatabase = this.f9703c.getWritableDatabase();
        switch (f9702b.match(uri)) {
            case 100:
            case 101:
            case 102:
                if (writableDatabase.insert("entity", null, contentValues) <= 0) {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                uriM10082a = uri;
                break;
                break;
            case 200:
            case 201:
                if (writableDatabase.insert("jot", null, contentValues) <= 0) {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                getContext().getContentResolver().notifyChange(DatabaseContract.f9693b, null);
                uriM10082a = uri;
                break;
                break;
            case 300:
            case 301:
                if (writableDatabase.insert(ShareConstants.WEB_DIALOG_PARAM_MEDIA, null, contentValues) <= 0) {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                uriM10082a = uri;
                break;
                break;
            case 400:
                long jInsert = writableDatabase.insert("log_entry", null, contentValues);
                if (jInsert > 0) {
                    uriM10082a = DatabaseContract.LogEntry.m10082a(jInsert);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return uriM10082a;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        String str;
        int i;
        SQLiteDatabase writableDatabase = this.f9703c.getWritableDatabase();
        int iMatch = f9702b.match(uri);
        writableDatabase.beginTransaction();
        try {
            try {
                switch (iMatch) {
                    case 100:
                    case 101:
                        str = "entity";
                        break;
                    case 200:
                    case 201:
                        str = "jot";
                        break;
                    case 300:
                    case 301:
                        str = ShareConstants.WEB_DIALOG_PARAM_MEDIA;
                        break;
                    case 400:
                        str = "log_entry";
                        break;
                    default:
                        throw new UnsupportedOperationException("Unknown uri: " + uri);
                }
                if (contentValuesArr == null || str == null) {
                    i = 0;
                } else {
                    i = 0;
                    for (ContentValues contentValues : contentValuesArr) {
                        if (writableDatabase.insertWithOnConflict(str, null, contentValues, 5) != -1) {
                            i++;
                        }
                    }
                }
                writableDatabase.setTransactionSuccessful();
                getContext().getContentResolver().notifyChange(uri, null);
                if (iMatch == 200) {
                    getContext().getContentResolver().notifyChange(DatabaseContract.f9693b, null);
                }
                writableDatabase.endTransaction();
                return i;
            } catch (UnsupportedOperationException e) {
                writableDatabase.endTransaction();
                return 0;
            } catch (Exception e2) {
                LogUtils.m11408a(f9701a, "bulkInsert", e2);
                writableDatabase.endTransaction();
                return 0;
            }
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            int iM10140a = m10087a(uri).m10145a(str, strArr).m10140a(this.f9703c.getWritableDatabase());
            getContext().getContentResolver().notifyChange(uri, null);
            return iM10140a;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            int iM10141a = m10087a(uri).m10145a(str, strArr).m10141a(this.f9703c.getWritableDatabase(), contentValues);
            getContext().getContentResolver().notifyChange(uri, null);
            int iMatch = f9702b.match(uri);
            if (iMatch == 200 || iMatch == 201) {
                getContext().getContentResolver().notifyChange(DatabaseContract.JotEntry.f9696a, null);
                getContext().getContentResolver().notifyChange(DatabaseContract.f9693b, null);
                return iM10141a;
            }
            return iM10141a;
        } catch (Exception e) {
            return 0;
        }
    }
}
