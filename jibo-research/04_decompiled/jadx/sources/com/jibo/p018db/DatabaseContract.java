package com.jibo.p018db;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseContract {

    /* JADX INFO: renamed from: a */
    public static final Uri f9692a = Uri.parse("content://com.jibo.provider.db");

    /* JADX INFO: renamed from: b */
    public static final Uri f9693b = Uri.parse("content://com.jibo.provider.db.messages");

    public static class LogEntry implements BaseColumns {

        /* JADX INFO: renamed from: a */
        public static final Uri f9697a = DatabaseContract.f9692a.buildUpon().appendPath("log_entries").build();

        /* JADX INFO: renamed from: a */
        public static Uri m10082a(long j) {
            return ContentUris.withAppendedId(f9697a, j);
        }
    }

    public static final class EntityEntry implements BaseColumns {

        /* JADX INFO: renamed from: a */
        public static final String[] f9694a = {"_id", "name", ShareConstants.MEDIA_TYPE, "retrieved", "modified", ShareConstants.WEB_DIALOG_PARAM_DATA};

        /* JADX INFO: renamed from: b */
        public static final Uri f9695b = DatabaseContract.f9692a.buildUpon().appendPath("entity").build();

        /* JADX INFO: renamed from: a */
        public static Uri m10079a(int i) {
            return f9695b.buildUpon().appendPath(Integer.toString(i)).build();
        }

        /* JADX INFO: renamed from: a */
        public static Uri m10080a(int i, String str) {
            return f9695b.buildUpon().appendPath(Integer.toString(i)).appendPath(str).build();
        }
    }

    public static final class JotEntry implements BaseColumns {

        /* JADX INFO: renamed from: a */
        public static final Uri f9696a = DatabaseContract.f9692a.buildUpon().appendPath("jot").build();

        /* JADX INFO: renamed from: a */
        public static Uri m10081a(String str) {
            return f9696a.buildUpon().appendPath(str).build();
        }
    }

    public static final class MediaEntry implements BaseColumns {

        /* JADX INFO: renamed from: a */
        public static final String[] f9698a = {"_id", "accountId", "url", "loopId", "created", ShareConstants.MEDIA_TYPE, "reference", "isEncrypted"};

        /* JADX INFO: renamed from: b */
        public static final Uri f9699b = DatabaseContract.f9692a.buildUpon().appendPath(ShareConstants.WEB_DIALOG_PARAM_MEDIA).build();

        /* JADX INFO: renamed from: a */
        public static Uri m10083a(String str) {
            return f9699b.buildUpon().appendPath(str).build();
        }
    }
}
