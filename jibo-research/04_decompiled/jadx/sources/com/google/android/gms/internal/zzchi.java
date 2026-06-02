package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.zzd;

/* JADX INFO: loaded from: classes.dex */
public final class zzchi extends zzcjl {

    /* JADX INFO: renamed from: a */
    private final zzchj f7213a;

    /* JADX INFO: renamed from: b */
    private boolean f7214b;

    zzchi(zzcim zzcimVar) {
        super(zzcimVar);
        this.f7213a = new zzchj(this, mo7864l(), "google_app_measurement_local.db");
    }

    @TargetApi(11)
    /* JADX INFO: renamed from: a */
    private final boolean m8066a(int i, byte[] bArr) {
        mo7855c();
        if (this.f7214b) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.MEDIA_TYPE, Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        for (int i3 = 0; i3 < 5; i3++) {
            SQLiteDatabase sQLiteDatabase = null;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabaseM8067z = m8067z();
                if (sQLiteDatabaseM8067z == null) {
                    this.f7214b = true;
                    if (sQLiteDatabaseM8067z != null) {
                        sQLiteDatabaseM8067z.close();
                    }
                    return false;
                }
                sQLiteDatabaseM8067z.beginTransaction();
                long j = 0;
                Cursor cursorRawQuery = sQLiteDatabaseM8067z.rawQuery("select count(1) from messages", null);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
                if (j >= 100000) {
                    mo7872t().m8106y().m8108a("Data loss, local db full");
                    long j2 = (100000 - j) + 1;
                    long jDelete = sQLiteDatabaseM8067z.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                    if (jDelete != j2) {
                        mo7872t().m8106y().m8111a("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                    }
                }
                sQLiteDatabaseM8067z.insertOrThrow("messages", null, contentValues);
                sQLiteDatabaseM8067z.setTransactionSuccessful();
                sQLiteDatabaseM8067z.endTransaction();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabaseM8067z != null) {
                    sQLiteDatabaseM8067z.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                try {
                    mo7872t().m8106y().m8109a("Error writing entry to local database", e);
                    this.f7214b = true;
                    if (0 != 0) {
                        cursor.close();
                    }
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                if (Build.VERSION.SDK_INT < 11 || !(e2 instanceof SQLiteDatabaseLockedException)) {
                    if (0 != 0 && sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    mo7872t().m8106y().m8109a("Error writing entry to local database", e2);
                    this.f7214b = true;
                } else {
                    SystemClock.sleep(i2);
                    i2 += 20;
                }
                if (0 != 0) {
                    cursor.close();
                }
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        mo7872t().m8097A().m8108a("Failed to write entry to local database");
        return false;
    }

    /* JADX INFO: renamed from: z */
    private final SQLiteDatabase m8067z() {
        if (this.f7214b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f7213a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f7214b = true;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fd  */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.util.List<com.google.android.gms.internal.zzbfm>] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @android.annotation.TargetApi(11)
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.zzbfm> m8068a(int r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzchi.m8068a(int):java.util.List");
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo7850a() {
        super.mo7850a();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8069a(zzcgl zzcglVar) {
        mo7868p();
        byte[] bArrM8400a = zzclq.m8400a((Parcelable) zzcglVar);
        if (bArrM8400a.length <= 131072) {
            return m8066a(2, bArrM8400a);
        }
        mo7872t().m8097A().m8108a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8070a(zzcha zzchaVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzchaVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return m8066a(0, bArrMarshall);
        }
        mo7872t().m8097A().m8108a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8071a(zzcln zzclnVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzclnVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return m8066a(1, bArrMarshall);
        }
        mo7872t().m8097A().m8108a("User property too long for local database. Sending directly to service");
        return false;
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ void mo7853b() {
        super.mo7853b();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void mo7855c() {
        super.mo7855c();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: d */
    public final /* bridge */ /* synthetic */ zzcgd mo7856d() {
        return super.mo7856d();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: e */
    public final /* bridge */ /* synthetic */ zzcgk mo7857e() {
        return super.mo7857e();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ zzcjn mo7858f() {
        return super.mo7858f();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ zzchh mo7859g() {
        return super.mo7859g();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ zzcgu mo7860h() {
        return super.mo7860h();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ zzckg mo7861i() {
        return super.mo7861i();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: j */
    public final /* bridge */ /* synthetic */ zzckc mo7862j() {
        return super.mo7862j();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: k */
    public final /* bridge */ /* synthetic */ zzd mo7863k() {
        return super.mo7863k();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: l */
    public final /* bridge */ /* synthetic */ Context mo7864l() {
        return super.mo7864l();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: m */
    public final /* bridge */ /* synthetic */ zzchi mo7865m() {
        return super.mo7865m();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: n */
    public final /* bridge */ /* synthetic */ zzcgo mo7866n() {
        return super.mo7866n();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: o */
    public final /* bridge */ /* synthetic */ zzchk mo7867o() {
        return super.mo7867o();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: p */
    public final /* bridge */ /* synthetic */ zzclq mo7868p() {
        return super.mo7868p();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: q */
    public final /* bridge */ /* synthetic */ zzcig mo7869q() {
        return super.mo7869q();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: r */
    public final /* bridge */ /* synthetic */ zzclf mo7870r() {
        return super.mo7870r();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: s */
    public final /* bridge */ /* synthetic */ zzcih mo7871s() {
        return super.mo7871s();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: t */
    public final /* bridge */ /* synthetic */ zzchm mo7872t() {
        return super.mo7872t();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: u */
    public final /* bridge */ /* synthetic */ zzchx mo7873u() {
        return super.mo7873u();
    }

    @Override // com.google.android.gms.internal.zzcjk
    /* JADX INFO: renamed from: v */
    public final /* bridge */ /* synthetic */ zzcgn mo7874v() {
        return super.mo7874v();
    }

    @Override // com.google.android.gms.internal.zzcjl
    /* JADX INFO: renamed from: w */
    protected final boolean mo7936w() {
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final void m8072y() {
        mo7855c();
        try {
            int iDelete = m8067z().delete("messages", null, null) + 0;
            if (iDelete > 0) {
                mo7872t().m8101E().m8109a("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            mo7872t().m8106y().m8109a("Error resetting local analytics data. error", e);
        }
    }
}
