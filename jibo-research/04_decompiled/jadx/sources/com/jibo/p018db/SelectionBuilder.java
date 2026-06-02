package com.jibo.p018db;

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

/* JADX INFO: loaded from: classes.dex */
public class SelectionBuilder {

    /* JADX INFO: renamed from: a */
    private static final String f9723a = LogUtils.m11405a(SelectionBuilder.class);

    /* JADX INFO: renamed from: b */
    private String f9724b = null;

    /* JADX INFO: renamed from: c */
    private Map<String, String> f9725c = Maps.m11416a();

    /* JADX INFO: renamed from: d */
    private StringBuilder f9726d = new StringBuilder();

    /* JADX INFO: renamed from: e */
    private ArrayList<String> f9727e = Lists.m11403a();

    /* JADX INFO: renamed from: f */
    private String f9728f = null;

    /* JADX INFO: renamed from: g */
    private String f9729g = null;

    /* JADX INFO: renamed from: a */
    public SelectionBuilder m10145a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr != null && strArr.length > 0) {
                throw new IllegalArgumentException("Valid selection required when including arguments=");
            }
        } else {
            if (this.f9726d.length() > 0) {
                this.f9726d.append(" AND ");
            }
            this.f9726d.append("(").append(str).append(")");
            if (strArr != null) {
                Collections.addAll(this.f9727e, strArr);
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public SelectionBuilder m10148b(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr != null && strArr.length > 0) {
                throw new IllegalArgumentException("Valid selection required when including arguments=");
            }
        } else {
            if (this.f9726d.length() > 0) {
                this.f9726d.append(" OR ");
            }
            this.f9726d.append("(").append(str).append(")");
            if (strArr != null) {
                Collections.addAll(this.f9727e, strArr);
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: c */
    public SelectionBuilder m10150c(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr != null && strArr.length > 0) {
                throw new IllegalArgumentException("Valid selection required when including arguments=");
            }
        } else {
            if (this.f9726d.length() > 0) {
                this.f9726d.append(" AND ");
            }
            this.f9726d.append("(").append(str).append(")");
            if (strArr != null) {
                Collections.addAll(this.f9727e, strArr);
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public String m10146a() {
        return this.f9729g;
    }

    /* JADX INFO: renamed from: a */
    public SelectionBuilder m10144a(String str) {
        this.f9724b = str;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public SelectionBuilder m10147b(String str) {
        this.f9728f = str;
        return this;
    }

    /* JADX INFO: renamed from: d */
    private void m10139d() {
        if (this.f9724b == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    /* JADX INFO: renamed from: b */
    public String m10149b() {
        return this.f9726d.toString();
    }

    /* JADX INFO: renamed from: c */
    public String[] m10151c() {
        return (String[]) this.f9727e.toArray(new String[this.f9727e.size()]);
    }

    /* JADX INFO: renamed from: a */
    private void m10138a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                String str = this.f9725c.get(strArr[i2]);
                if (str != null) {
                    strArr[i2] = str;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "SelectionBuilder[table=" + this.f9724b + ", selection=" + m10149b() + ", selectionArgs=" + Arrays.toString(m10151c()) + "]";
    }

    /* JADX INFO: renamed from: a */
    public Cursor m10142a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return m10143a(sQLiteDatabase, strArr, null, null, str, null);
    }

    /* JADX INFO: renamed from: a */
    public Cursor m10143a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        m10139d();
        if (strArr != null) {
            m10138a(strArr);
        }
        String str5 = (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(this.f9728f)) ? str3 : this.f9728f;
        LogUtils.m11409b(f9723a, "query(columns=" + Arrays.toString(strArr) + ") " + this);
        return sQLiteDatabase.query(this.f9724b, strArr, m10149b(), m10151c(), str, str2, str5, str4);
    }

    /* JADX INFO: renamed from: a */
    public int m10141a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        m10139d();
        LogUtils.m11409b(f9723a, "update() " + this);
        return sQLiteDatabase.update(this.f9724b, contentValues, m10149b(), m10151c());
    }

    /* JADX INFO: renamed from: a */
    public int m10140a(SQLiteDatabase sQLiteDatabase) {
        m10139d();
        LogUtils.m11409b(f9723a, "delete() " + this);
        return sQLiteDatabase.delete(this.f9724b, m10149b(), m10151c());
    }
}
