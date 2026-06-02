package com.jibo.p018db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.GetRequest;
import com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient;
import com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.media.JiboMediaAsyncClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.p018db.DatabaseContract;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EntityData {

    /* JADX INFO: renamed from: b */
    private static volatile EntityData f9705b;

    /* JADX INFO: renamed from: c */
    private static Context f9706c;

    /* JADX INFO: renamed from: d */
    private volatile Account f9708d;

    /* JADX INFO: renamed from: e */
    private volatile JiboAccountAsyncClient f9709e;

    /* JADX INFO: renamed from: f */
    private volatile JiboLoopAsyncClient f9710f;

    /* JADX INFO: renamed from: g */
    private volatile JiboGQAAsyncClient f9711g;

    /* JADX INFO: renamed from: h */
    private volatile JiboKeyAsyncClient f9712h;

    /* JADX INFO: renamed from: i */
    private volatile JiboMediaAsyncClient f9713i;

    /* JADX INFO: renamed from: j */
    private volatile JiboPushAsyncClient f9714j;

    /* JADX INFO: renamed from: k */
    private volatile JiboRobotPropertiesAsyncClient f9715k;

    /* JADX INFO: renamed from: a */
    public static final String f9704a = LogUtils.m11405a(EntityData.class);

    /* JADX INFO: renamed from: l */
    private static final Gson f9707l = new Gson();

    private EntityData(Context context) {
        f9706c = context != null ? context.getApplicationContext() : null;
        m10104m();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized EntityData m10089a(Context context) {
        EntityData entityData;
        entityData = f9705b;
        if (entityData == null) {
            synchronized (EntityData.class) {
                entityData = f9705b;
                if (entityData == null) {
                    entityData = new EntityData(context);
                    f9705b = entityData;
                }
            }
        }
        return entityData;
    }

    /* JADX INFO: renamed from: m */
    private void m10104m() {
        m10110a();
        m10122b();
        m10126d();
        m10128e();
        m10132g();
    }

    /* JADX INFO: renamed from: n */
    private void m10105n() {
        try {
            if (this.f9709e != null) {
                this.f9709e.logout();
                this.f9709e.shutdown();
                this.f9709e = null;
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
        try {
            if (this.f9710f != null) {
                this.f9710f.shutdown();
                this.f9710f = null;
            }
        } catch (Exception e2) {
            Crashlytics.m5597a((Throwable) e2);
        }
        try {
            if (this.f9712h != null) {
                this.f9712h.shutdown();
                this.f9712h = null;
            }
        } catch (Exception e3) {
            Crashlytics.m5597a((Throwable) e3);
        }
        try {
            if (this.f9713i != null) {
                this.f9713i.shutdown();
                this.f9713i = null;
            }
        } catch (Exception e4) {
            Crashlytics.m5597a((Throwable) e4);
        }
        try {
            if (this.f9714j != null) {
                this.f9714j.shutdown();
                this.f9714j = null;
            }
        } catch (Exception e5) {
            Crashlytics.m5597a((Throwable) e5);
        }
        try {
            if (this.f9715k != null) {
                this.f9715k.shutdown();
                this.f9715k = null;
            }
        } catch (Exception e6) {
            Crashlytics.m5597a((Throwable) e6);
        }
        try {
            if (this.f9711g != null) {
                this.f9711g.shutdown();
                this.f9711g = null;
            }
        } catch (Exception e7) {
            Crashlytics.m5597a((Throwable) e7);
        }
    }

    /* JADX INFO: renamed from: o */
    private BasicAWSCredentials m10106o() {
        Account accountM10134i = m10134i();
        return (accountM10134i == null || TextUtils.isEmpty(accountM10134i.getAccessKeyId()) || TextUtils.isEmpty(accountM10134i.getSecretAccessKey())) ? new BasicAWSCredentials("", "") : new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey());
    }

    /* JADX INFO: renamed from: a */
    public synchronized JiboAccountAsyncClient m10110a() {
        JiboAccountAsyncClient jiboAccountAsyncClient = this.f9709e;
        if (jiboAccountAsyncClient == null || jiboAccountAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboAccountAsyncClient jiboAccountAsyncClient2 = this.f9709e;
                if (jiboAccountAsyncClient2 == null || jiboAccountAsyncClient2.isTerminated()) {
                    this.f9709e = new JiboAccountAsyncClient(m10106o());
                }
            }
        }
        return this.f9709e;
    }

    /* JADX INFO: renamed from: b */
    public synchronized JiboLoopAsyncClient m10122b() {
        JiboLoopAsyncClient jiboLoopAsyncClient = this.f9710f;
        if (jiboLoopAsyncClient == null || jiboLoopAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboLoopAsyncClient jiboLoopAsyncClient2 = this.f9710f;
                if (jiboLoopAsyncClient2 == null || jiboLoopAsyncClient2.isTerminated()) {
                    this.f9710f = new JiboLoopAsyncClient(m10106o());
                }
            }
        }
        return this.f9710f;
    }

    /* JADX INFO: renamed from: c */
    public synchronized JiboGQAAsyncClient m10124c() {
        JiboGQAAsyncClient jiboGQAAsyncClient = this.f9711g;
        if (jiboGQAAsyncClient == null || jiboGQAAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboGQAAsyncClient jiboGQAAsyncClient2 = this.f9711g;
                if (jiboGQAAsyncClient2 == null || jiboGQAAsyncClient2.isTerminated()) {
                    this.f9711g = new JiboGQAAsyncClient(m10106o());
                }
            }
        }
        return this.f9711g;
    }

    /* JADX INFO: renamed from: d */
    public synchronized JiboKeyAsyncClient m10126d() {
        JiboKeyAsyncClient jiboKeyAsyncClient = this.f9712h;
        if (jiboKeyAsyncClient == null || jiboKeyAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboKeyAsyncClient jiboKeyAsyncClient2 = this.f9712h;
                if (jiboKeyAsyncClient2 == null || jiboKeyAsyncClient2.isTerminated()) {
                    this.f9712h = new JiboKeyAsyncClient(m10106o());
                }
            }
        }
        return this.f9712h;
    }

    /* JADX INFO: renamed from: e */
    public synchronized JiboMediaAsyncClient m10128e() {
        JiboMediaAsyncClient jiboMediaAsyncClient = this.f9713i;
        if (jiboMediaAsyncClient == null || jiboMediaAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboMediaAsyncClient jiboMediaAsyncClient2 = this.f9713i;
                if (jiboMediaAsyncClient2 == null || jiboMediaAsyncClient2.isTerminated()) {
                    this.f9713i = new JiboMediaAsyncClient(m10106o());
                }
            }
        }
        return this.f9713i;
    }

    /* JADX INFO: renamed from: f */
    public synchronized JiboPushAsyncClient m10130f() {
        JiboPushAsyncClient jiboPushAsyncClient = this.f9714j;
        if (jiboPushAsyncClient == null || jiboPushAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboPushAsyncClient jiboPushAsyncClient2 = this.f9714j;
                if (jiboPushAsyncClient2 == null || jiboPushAsyncClient2.isTerminated()) {
                    this.f9714j = new JiboPushAsyncClient(m10106o());
                }
            }
        }
        return this.f9714j;
    }

    /* JADX INFO: renamed from: g */
    public synchronized JiboRobotPropertiesAsyncClient m10132g() {
        JiboRobotPropertiesAsyncClient jiboRobotPropertiesAsyncClient = this.f9715k;
        if (jiboRobotPropertiesAsyncClient == null || jiboRobotPropertiesAsyncClient.isTerminated()) {
            synchronized (this) {
                JiboRobotPropertiesAsyncClient jiboRobotPropertiesAsyncClient2 = this.f9715k;
                if (jiboRobotPropertiesAsyncClient2 == null || jiboRobotPropertiesAsyncClient2.isTerminated()) {
                    this.f9715k = new JiboRobotPropertiesAsyncClient(m10106o());
                }
            }
        }
        return this.f9715k;
    }

    /* JADX INFO: renamed from: h */
    public void m10133h() throws Throwable {
        m10105n();
        this.f9708d = null;
        m10107p();
        m10123b((String) null);
        m10099g(null);
        m10100h(null);
        m10101i(null);
    }

    /* JADX INFO: renamed from: p */
    private void m10107p() {
        try {
            f9706c.getContentResolver().delete(DatabaseContract.EntityEntry.m10079a(1), null, null);
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m10108q() {
        synchronized (this) {
            this.f9708d = null;
        }
        m10134i();
    }

    /* JADX INFO: renamed from: g */
    private void m10099g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                f9706c.getContentResolver().delete(DatabaseContract.EntityEntry.m10079a(2), null, null);
            } else {
                f9706c.getContentResolver().delete(DatabaseContract.EntityEntry.m10080a(2, str), null, null);
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10114a(com.jibo.aws.integration.aws.services.account.model.Account r9, boolean r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10114a(com.jibo.aws.integration.aws.services.account.model.Account, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    private void m10092a(List<Account> list, int i) {
        if (i > 0) {
            try {
                SQLiteDatabase writableDatabase = DatabaseHelper.m10084a(f9706c).getWritableDatabase();
                SelectionBuilder selectionBuilder = new SelectionBuilder();
                selectionBuilder.m10144a("entity").m10145a("type=2", new String[0]);
                if ((i & 2) != 0) {
                    StringBuilder sbAppend = new StringBuilder("_id").append(" IN (");
                    ArrayList arrayList = new ArrayList();
                    Iterator<Account> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getId());
                    }
                    sbAppend.append("'").append(TextUtils.join("','", arrayList)).append("')");
                    selectionBuilder.m10145a(sbAppend.toString(), new String[0]);
                }
                selectionBuilder.m10140a(writableDatabase);
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
        }
        if (list != null) {
            ContentValues[] contentValuesArr = new ContentValues[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                Account account = list.get(i2);
                contentValuesArr[i2] = new ContentValues();
                contentValuesArr[i2].put("_id", account.getId());
                contentValuesArr[i2].put("name", account.getFullName());
                contentValuesArr[i2].put(ShareConstants.MEDIA_TYPE, (Integer) 2);
                contentValuesArr[i2].put("modified", Long.valueOf(System.currentTimeMillis()));
                contentValuesArr[i2].put("retrieved", Long.valueOf(System.currentTimeMillis()));
                contentValuesArr[i2].put(ShareConstants.WEB_DIALOG_PARAM_DATA, f9707l.m9362b(account));
            }
            try {
                f9706c.getContentResolver().bulkInsert(DatabaseContract.EntityEntry.m10079a(2), contentValuesArr);
            } catch (Exception e2) {
                Crashlytics.m5597a((Throwable) e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066 A[Catch: all -> 0x0073, TRY_ENTER, TryCatch #2 {, blocks: (B:7:0x0007, B:17:0x0057, B:18:0x005b, B:25:0x0066, B:29:0x006f, B:30:0x0072), top: B:53:0x0007, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[Catch: all -> 0x0073, TryCatch #2 {, blocks: (B:7:0x0007, B:17:0x0057, B:18:0x005b, B:25:0x0066, B:29:0x006f, B:30:0x0072), top: B:53:0x0007, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.jibo.aws.integration.aws.services.account.model.Account m10134i() {
        /*
            r9 = this;
            r6 = 0
            monitor-enter(r9)
            com.jibo.aws.integration.aws.services.account.model.Account r0 = r9.f9708d     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L5c
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L76
            com.jibo.aws.integration.aws.services.account.model.Account r7 = r9.f9708d     // Catch: java.lang.Throwable -> L73
            if (r7 != 0) goto L93
            android.content.Context r0 = com.jibo.p018db.EntityData.f9706c     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L6b
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L6b
            r1 = 1
            android.net.Uri r1 = com.jibo.db.DatabaseContract.EntityEntry.m10079a(r1)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L6b
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L6b
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7e
            if (r0 == 0) goto L91
            com.google.gson.Gson r0 = com.jibo.p018db.EntityData.f9707l     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7e
            java.lang.String r1 = "data"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7e
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7e
            java.lang.Class<com.jibo.aws.integration.aws.services.account.model.Account> r3 = com.jibo.aws.integration.aws.services.account.model.Account.class
            java.lang.Object r0 = r0.m9355a(r1, r3)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7e
            com.jibo.aws.integration.aws.services.account.model.Account r0 = (com.jibo.aws.integration.aws.services.account.model.Account) r0     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L7e
            java.lang.String r1 = "modified"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L82
            long r4 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L82
            r0.setModified(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L82
            java.lang.String r1 = "retrieved"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L82
            long r4 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L82
            r0.setRetrieved(r4)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L82
            r1 = r0
        L53:
            r9.f9708d = r1     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L88
            if (r2 == 0) goto L8f
            r2.close()     // Catch: java.lang.Throwable -> L73
            r0 = r1
        L5b:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L73
        L5c:
            monitor-exit(r9)
            return r0
        L5e:
            r0 = move-exception
            r1 = r6
            r2 = r7
        L61:
            com.crashlytics.android.Crashlytics.m5597a(r0)     // Catch: java.lang.Throwable -> L7b
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.lang.Throwable -> L73
            r0 = r2
            goto L5b
        L6b:
            r0 = move-exception
            r2 = r6
        L6d:
            if (r2 == 0) goto L72
            r2.close()     // Catch: java.lang.Throwable -> L73
        L72:
            throw r0     // Catch: java.lang.Throwable -> L73
        L73:
            r0 = move-exception
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L73
            throw r0     // Catch: java.lang.Throwable -> L76
        L76:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L79:
            r0 = move-exception
            goto L6d
        L7b:
            r0 = move-exception
            r2 = r1
            goto L6d
        L7e:
            r0 = move-exception
            r1 = r2
            r2 = r7
            goto L61
        L82:
            r1 = move-exception
            r8 = r1
            r1 = r2
            r2 = r0
            r0 = r8
            goto L61
        L88:
            r0 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L61
        L8d:
            r0 = r2
            goto L5b
        L8f:
            r0 = r1
            goto L5b
        L91:
            r1 = r7
            goto L53
        L93:
            r0 = r7
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10134i():com.jibo.aws.integration.aws.services.account.model.Account");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0132  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10115a(com.jibo.aws.integration.aws.services.account.model.Account r11, boolean r12, final com.amazonaws.handlers.AsyncHandler<com.jibo.aws.integration.aws.services.account.model.UpdateRequest, com.jibo.aws.integration.aws.services.account.model.Account> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10115a(com.jibo.aws.integration.aws.services.account.model.Account, boolean, com.amazonaws.handlers.AsyncHandler):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jibo.aws.integration.aws.services.account.model.Account m10111a(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L9
            r0 = r6
        L8:
            return r0
        L9:
            android.content.Context r0 = com.jibo.p018db.EntityData.f9706c     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L62
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L62
            r1 = 2
            android.net.Uri r1 = com.jibo.db.DatabaseContract.EntityEntry.m10080a(r1, r8)     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L62
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L62
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            if (r0 == 0) goto L77
            com.google.gson.Gson r0 = com.jibo.p018db.EntityData.f9707l     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            java.lang.String r1 = "data"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            java.lang.Class<com.jibo.aws.integration.aws.services.account.model.Account> r3 = com.jibo.aws.integration.aws.services.account.model.Account.class
            java.lang.Object r0 = r0.m9355a(r1, r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            com.jibo.aws.integration.aws.services.account.model.Account r0 = (com.jibo.aws.integration.aws.services.account.model.Account) r0     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6f
            java.lang.String r1 = "modified"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L74
            long r4 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L74
            r0.setModified(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L74
            java.lang.String r1 = "retrieved"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L74
            long r4 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L74
            r0.setRetrieved(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L74
        L50:
            if (r2 == 0) goto L8
            r2.close()
            goto L8
        L56:
            r0 = move-exception
            r1 = r0
            r0 = r6
        L59:
            com.crashlytics.android.Crashlytics.m5597a(r1)     // Catch: java.lang.Throwable -> L6c
            if (r6 == 0) goto L8
            r6.close()
            goto L8
        L62:
            r0 = move-exception
            r2 = r6
        L64:
            if (r2 == 0) goto L69
            r2.close()
        L69:
            throw r0
        L6a:
            r0 = move-exception
            goto L64
        L6c:
            r0 = move-exception
            r2 = r6
            goto L64
        L6f:
            r0 = move-exception
            r1 = r0
            r0 = r6
            r6 = r2
            goto L59
        L74:
            r1 = move-exception
            r6 = r2
            goto L59
        L77:
            r0 = r6
            goto L50
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10111a(java.lang.String):com.jibo.aws.integration.aws.services.account.model.Account");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentValues[]] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX INFO: renamed from: b */
    private void m10096b(List<Loop> list) throws Throwable {
        int i = 0;
        SQLiteDatabase writableDatabase = 0;
        writableDatabase = 0;
        try {
            try {
                writableDatabase = DatabaseHelper.m10084a(f9706c).getWritableDatabase();
                SelectionBuilder selectionBuilder = new SelectionBuilder();
                writableDatabase.beginTransaction();
                selectionBuilder.m10144a("entity").m10145a("type=8", new String[0]);
                selectionBuilder.m10140a((SQLiteDatabase) writableDatabase);
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
                if (writableDatabase != 0) {
                    writableDatabase.endTransaction();
                }
            }
            writableDatabase = new ContentValues[list.size()];
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Loop loop = list.get(i2);
                    writableDatabase[i2] = new ContentValues();
                    writableDatabase[i2].put("_id", loop.getId());
                    writableDatabase[i2].put(ShareConstants.MEDIA_TYPE, (Integer) 8);
                    writableDatabase[i2].put("modified", Long.valueOf(System.currentTimeMillis()));
                    writableDatabase[i2].put("retrieved", Long.valueOf(System.currentTimeMillis()));
                    writableDatabase[i2].put("name", loop.getName());
                    writableDatabase[i2].put(ShareConstants.WEB_DIALOG_PARAM_DATA, f9707l.m9362b(loop));
                    i = i2 + 1;
                } else {
                    try {
                        break;
                    } catch (Exception e2) {
                        Crashlytics.m5597a((Throwable) e2);
                    }
                }
            }
            f9706c.getContentResolver().bulkInsert(DatabaseContract.EntityEntry.m10079a(8), writableDatabase);
            m10109r();
        } finally {
            if (writableDatabase != 0) {
                writableDatabase.endTransaction();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed  */
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m10109r() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10109r():void");
    }

    /* JADX INFO: renamed from: a */
    public void m10117a(Loop loop) {
        Loop loopM11443f = SharedPreferencesUtil.m11443f(f9706c);
        if ((loopM11443f == null && loop != null) || (loopM11443f != null && !loopM11443f.equals(loop))) {
            SharedPreferencesUtil.m11430a(f9706c, loop);
            f9706c.getContentResolver().notifyChange(DatabaseContract.EntityEntry.m10079a(8), null);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10123b(String str) throws Throwable {
        try {
            if (TextUtils.isEmpty(str)) {
                f9706c.getContentResolver().delete(DatabaseContract.EntityEntry.m10079a(8), null, null);
            } else {
                f9706c.getContentResolver().delete(DatabaseContract.EntityEntry.m10080a(8, str), null, null);
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
        m10109r();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10118a(com.jibo.aws.integration.aws.services.loop.model.Loop r9, boolean r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10118a(com.jibo.aws.integration.aws.services.loop.model.Loop, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0050  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jibo.aws.integration.aws.services.loop.model.Loop m10125c(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L8
        L7:
            return r6
        L8:
            android.content.Context r0 = com.jibo.p018db.EntityData.f9706c     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            r1 = 8
            android.net.Uri r1 = com.jibo.db.DatabaseContract.EntityEntry.m10080a(r1, r8)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            if (r1 == 0) goto L50
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 != 0) goto L50
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 == 0) goto L50
            com.jibo.aws.integration.aws.services.loop.model.Loop r6 = m10088a(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0 = r6
        L2f:
            if (r1 == 0) goto L34
            r1.close()
        L34:
            r6 = r0
            goto L7
        L36:
            r0 = move-exception
            r1 = r6
        L38:
            com.crashlytics.android.Crashlytics.m5597a(r0)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L4e
            r1.close()
            r0 = r6
            goto L34
        L42:
            r0 = move-exception
            r1 = r6
        L44:
            if (r1 == 0) goto L49
            r1.close()
        L49:
            throw r0
        L4a:
            r0 = move-exception
            goto L44
        L4c:
            r0 = move-exception
            goto L38
        L4e:
            r0 = r6
            goto L34
        L50:
            r0 = r6
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10125c(java.lang.String):com.jibo.aws.integration.aws.services.loop.model.Loop");
    }

    /* JADX INFO: renamed from: a */
    public static Loop m10088a(Cursor cursor) {
        try {
            return (Loop) f9707l.m9355a(cursor.getString(cursor.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_DATA)), Loop.class);
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0025 -> B:13:0x0013). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: h */
    private void m10100h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                f9706c.getContentResolver().delete(DatabaseContract.JotEntry.f9696a, null, null);
            } else {
                f9706c.getContentResolver().delete(DatabaseContract.JotEntry.m10081a(str), null, null);
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d7  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10116a(com.jibo.aws.integration.aws.services.jot.model.Message r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10116a(com.jibo.aws.integration.aws.services.jot.model.Message, java.lang.String):void");
    }

    /* JADX INFO: renamed from: b */
    public static Message m10093b(Cursor cursor) {
        Message message = new Message();
        try {
            message.setId(cursor.getString(cursor.getColumnIndex("_id")));
            message.setLoopId(cursor.getString(cursor.getColumnIndex("loopId")));
            message.setContent(cursor.getString(cursor.getColumnIndex("content")));
            message.setSender(cursor.getString(cursor.getColumnIndex("sender")));
            message.setCreated(Long.valueOf(cursor.getLong(cursor.getColumnIndex("created"))));
            message.setRead(cursor.getInt(cursor.getColumnIndex("is_read")) == 1);
            if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("parts"))) && !"[]".equals(cursor.getString(cursor.getColumnIndex("parts")))) {
                try {
                    message.setParts((List) f9707l.m9356a(cursor.getString(cursor.getColumnIndex("parts")), new TypeToken<List<MessagePart>>() { // from class: com.jibo.db.EntityData.2
                    }.getType()));
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                }
            }
            if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("tags"))) && !"[]".equals(cursor.getString(cursor.getColumnIndex("tags")))) {
                try {
                    message.setTags((List) f9707l.m9356a(cursor.getString(cursor.getColumnIndex("tags")), new TypeToken<List<String>>() { // from class: com.jibo.db.EntityData.3
                    }.getType()));
                } catch (Exception e2) {
                    Crashlytics.m5597a((Throwable) e2);
                }
            }
        } catch (Exception e3) {
            Crashlytics.m5597a((Throwable) e3);
        }
        return message;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0025 -> B:13:0x0013). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: i */
    private void m10101i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                f9706c.getContentResolver().delete(DatabaseContract.MediaEntry.f9699b, null, null);
            } else {
                f9706c.getContentResolver().delete(DatabaseContract.MediaEntry.m10083a(str), null, null);
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10091a(String str, boolean z) {
        if (z) {
            SQLiteDatabase writableDatabase = null;
            try {
                try {
                    writableDatabase = DatabaseHelper.m10084a(f9706c).getWritableDatabase();
                    SelectionBuilder selectionBuilder = new SelectionBuilder();
                    writableDatabase.beginTransaction();
                    selectionBuilder.m10144a(ShareConstants.WEB_DIALOG_PARAM_MEDIA).m10145a("loopId = ?", str);
                    selectionBuilder.m10140a(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                    }
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                    }
                }
                return;
            } catch (Throwable th) {
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                }
                throw th;
            }
        }
        try {
            f9706c.getContentResolver().delete(DatabaseContract.MediaEntry.f9699b, "loopId = ?", new String[]{str});
        } catch (Exception e2) {
            Crashlytics.m5597a((Throwable) e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jibo.aws.integration.aws.services.media.model.Media m10127d(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L8
        L7:
            return r6
        L8:
            android.content.Context r0 = com.jibo.p018db.EntityData.f9706c     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L40
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L40
            android.net.Uri r1 = com.jibo.db.DatabaseContract.MediaEntry.m10083a(r8)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L40
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L40
            if (r1 == 0) goto L4e
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r0 != 0) goto L4e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r0 == 0) goto L4e
            com.jibo.aws.integration.aws.services.media.model.Media r6 = m10097c(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r0 = r6
        L2d:
            if (r1 == 0) goto L32
            r1.close()
        L32:
            r6 = r0
            goto L7
        L34:
            r0 = move-exception
            r1 = r6
        L36:
            com.crashlytics.android.Crashlytics.m5597a(r0)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L4c
            r1.close()
            r0 = r6
            goto L32
        L40:
            r0 = move-exception
            r1 = r6
        L42:
            if (r1 == 0) goto L47
            r1.close()
        L47:
            throw r0
        L48:
            r0 = move-exception
            goto L42
        L4a:
            r0 = move-exception
            goto L36
        L4c:
            r0 = r6
            goto L32
        L4e:
            r0 = r6
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10127d(java.lang.String):com.jibo.aws.integration.aws.services.media.model.Media");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jibo.aws.integration.aws.services.media.model.Media m10129e(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L8
        L7:
            return r6
        L8:
            android.content.Context r0 = com.jibo.p018db.EntityData.f9706c     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            android.net.Uri r1 = com.jibo.db.DatabaseContract.MediaEntry.f9699b     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            r2 = 0
            java.lang.String r3 = "reference = ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L44
            if (r1 == 0) goto L52
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r0 != 0) goto L52
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            if (r0 == 0) goto L52
            com.jibo.aws.integration.aws.services.media.model.Media r6 = m10097c(r1)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4e
            r0 = r6
        L31:
            if (r1 == 0) goto L36
            r1.close()
        L36:
            r6 = r0
            goto L7
        L38:
            r0 = move-exception
            r1 = r6
        L3a:
            com.crashlytics.android.Crashlytics.m5597a(r0)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L50
            r1.close()
            r0 = r6
            goto L36
        L44:
            r0 = move-exception
        L45:
            if (r6 == 0) goto L4a
            r6.close()
        L4a:
            throw r0
        L4b:
            r0 = move-exception
            r6 = r1
            goto L45
        L4e:
            r0 = move-exception
            goto L3a
        L50:
            r0 = r6
            goto L36
        L52:
            r0 = r6
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10129e(java.lang.String):com.jibo.aws.integration.aws.services.media.model.Media");
    }

    /* JADX INFO: renamed from: a */
    public void m10121a(List<Media> list, boolean z) {
        if (z) {
            m10101i(null);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            ContentValues[] contentValuesArr = new ContentValues[size];
            for (int i = 0; i < size; i++) {
                Media media = list.get(i);
                contentValuesArr[i] = new ContentValues();
                contentValuesArr[i].put("_id", media.getPath());
                contentValuesArr[i].put("loopId", media.getLoopId());
                contentValuesArr[i].put("created", media.getCreated());
                contentValuesArr[i].put("accountId", media.getAccountId());
                contentValuesArr[i].put(ShareConstants.MEDIA_TYPE, media.getType());
                contentValuesArr[i].put("reference", media.getReference());
                contentValuesArr[i].put("url", media.getUrl());
                contentValuesArr[i].put("isEncrypted", Integer.valueOf(media.isEncrypted().booleanValue() ? 1 : 0));
            }
            try {
                f9706c.getContentResolver().bulkInsert(DatabaseContract.MediaEntry.f9699b, contentValuesArr);
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10120a(java.util.List<java.lang.String> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10120a(java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0202 A[Catch: Exception -> 0x01ee, all -> 0x0206, TRY_ENTER, TryCatch #2 {Exception -> 0x01ee, blocks: (B:9:0x00ef, B:24:0x0138, B:26:0x013e, B:28:0x017f, B:29:0x0197, B:31:0x01b6, B:52:0x01e9, B:23:0x0135, B:64:0x0202, B:65:0x0205), top: B:79:0x00ef, outer: #5 }] */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10135j() {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10135j():void");
    }

    /* JADX INFO: renamed from: c */
    public static Media m10097c(Cursor cursor) {
        Media media = new Media();
        try {
            media.setPath(cursor.getString(cursor.getColumnIndex("_id")));
            media.setLoopId(cursor.getString(cursor.getColumnIndex("loopId")));
            media.setCreated(Long.valueOf(cursor.getLong(cursor.getColumnIndex("created"))));
            media.setAccountId(cursor.getString(cursor.getColumnIndex("accountId")));
            media.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            media.setType(cursor.getString(cursor.getColumnIndex(ShareConstants.MEDIA_TYPE)));
            media.setReference(cursor.getString(cursor.getColumnIndex("reference")));
            media.setEncrypted(Boolean.valueOf(cursor.getInt(cursor.getColumnIndex("isEncrypted")) == 1));
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
        return media;
    }

    /* JADX INFO: renamed from: c */
    private void m10098c(List<Loop> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<Loop> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(LoopHelper.getAccountIds(it.next(), Member.InvitationStatus.accepted, new String[0]));
            }
            m10092a(m10110a().get(arrayList), 1);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10094b(Loop loop) {
        if (loop != null) {
            m10092a(m10110a().get(LoopHelper.getAccountIds(loop, Member.InvitationStatus.accepted, new String[0])), 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b A[Catch: Exception -> 0x0073, all -> 0x00e3, TryCatch #1 {all -> 0x00e3, blocks: (B:14:0x0055, B:16:0x005b, B:17:0x005f, B:19:0x0065, B:37:0x00cf, B:23:0x0077), top: B:59:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1 A[Catch: all -> 0x00e6, Exception -> 0x00f3, TRY_LEAVE, TryCatch #7 {Exception -> 0x00f3, all -> 0x00e6, blocks: (B:29:0x00a0, B:31:0x00a6, B:33:0x00ac, B:34:0x00c1), top: B:63:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fa  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m10095b(com.jibo.aws.integration.aws.services.loop.model.Loop r13, boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10095b(com.jibo.aws.integration.aws.services.loop.model.Loop, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    public void m10119a(final Commons.AsyncCallback<Object> asyncCallback) {
        m10110a().get(null, new AsyncHandler<GetRequest, List<Account>>() { // from class: com.jibo.db.EntityData.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                asyncCallback.onError(exc);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(GetRequest getRequest, List<Account> list) throws Throwable {
                EntityData.this.m10115a(list.get(0), true, null);
                if (list.get(0).isActive().booleanValue()) {
                    try {
                        asyncCallback.onSuccess(EntityData.this.m10112a(true));
                        return;
                    } catch (Exception e) {
                        Crashlytics.m5597a((Throwable) e);
                        asyncCallback.onError(e);
                        return;
                    }
                }
                asyncCallback.onSuccess(list.get(0));
            }
        });
    }

    /* JADX INFO: renamed from: f */
    public void m10131f(String str) throws Throwable {
        if (!TextUtils.isEmpty(str)) {
            List<Loop> listListLoops = m10122b().listLoops();
            m10096b(listListLoops);
            for (Loop loop : listListLoops) {
                if (loop.getId().equals(str)) {
                    m10094b(loop);
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public List<Loop> m10112a(boolean z) {
        List<Loop> listListLoops = m10122b().listLoops();
        m10096b(listListLoops);
        if (z) {
            m10098c(listListLoops);
        }
        return listListLoops;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ad A[Catch: Exception -> 0x0089, TryCatch #2 {Exception -> 0x0089, blocks: (B:3:0x0002, B:6:0x0009, B:8:0x0015, B:9:0x0019, B:11:0x0028, B:13:0x002e, B:14:0x0031, B:16:0x0037, B:49:0x00a1, B:50:0x00a4, B:40:0x0082, B:41:0x0085, B:54:0x00ad, B:55:0x00b0, B:56:0x00b3, B:46:0x0098), top: B:64:0x0002 }] */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.database.Cursor] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m10113a(android.os.Bundle r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r7 = 1
            r6 = 0
            com.jibo.aws.integration.aws.services.account.model.Account r0 = r9.m10134i()     // Catch: java.lang.Exception -> L89
            if (r0 != 0) goto L9
        L8:
            return
        L9:
            java.lang.String r0 = com.jibo.service.SyncHelper.f9757a     // Catch: java.lang.Exception -> L89
            r1 = 14
            int r8 = r10.getInt(r0, r1)     // Catch: java.lang.Exception -> L89
            r0 = r8 & 2
            if (r0 == 0) goto L19
            r0 = 1
            r9.m10112a(r0)     // Catch: java.lang.Exception -> L89
        L19:
            java.lang.Class<com.jibo.aws.integration.aws.services.loop.model.Loop> r0 = com.jibo.aws.integration.aws.services.loop.model.Loop.class
            java.lang.String r0 = r0.getSimpleName()     // Catch: java.lang.Exception -> L89
            r1 = 0
            java.lang.String r0 = r10.getString(r0, r1)     // Catch: java.lang.Exception -> L89
            r1 = r8 & 1
            if (r1 == 0) goto L31
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L89
            if (r1 != 0) goto L31
            r9.m10131f(r0)     // Catch: java.lang.Exception -> L89
        L31:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L89
            if (r1 != 0) goto L96
            r1 = 8
            android.net.Uri r1 = com.jibo.db.DatabaseContract.EntityEntry.m10080a(r1, r0)     // Catch: java.lang.Exception -> L89
        L3d:
            r0 = r8 & 4
            if (r0 != 0) goto L45
            r0 = r8 & 8
            if (r0 == 0) goto L8
        L45:
            android.content.Context r0 = com.jibo.p018db.EntityData.f9706c     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lb6
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lb6
            java.lang.String[] r2 = com.jibo.db.DatabaseContract.EntityEntry.f9694a     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lb6
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lb6
            if (r1 == 0) goto L9f
            boolean r0 = r1.isClosed()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> Lb4
            if (r0 != 0) goto L9f
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> Lb4
            if (r0 == 0) goto L9f
        L62:
            boolean r0 = r1.isAfterLast()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> Lb4
            if (r0 != 0) goto L9f
            com.jibo.aws.integration.aws.services.loop.model.Loop r2 = m10088a(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> Lb4
            r0 = r8 & 8
            if (r0 == 0) goto L78
            r0 = r8 & 16
            if (r0 == 0) goto L9d
            r0 = r7
        L75:
            r9.m10095b(r2, r0)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> Lb4
        L78:
            r1.moveToNext()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> Lb4
            goto L62
        L7c:
            r0 = move-exception
        L7d:
            com.crashlytics.android.Crashlytics.m5597a(r0)     // Catch: java.lang.Throwable -> Lb4
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.lang.Exception -> L89
        L85:
            r9.m10135j()     // Catch: java.lang.Exception -> L89
            goto L8
        L89:
            r0 = move-exception
            java.lang.String r1 = com.jibo.p018db.EntityData.f9704a
            java.lang.String r2 = "onRunTask-end"
            com.jibo.utils.LogUtils.m11411c(r1, r2)
            com.crashlytics.android.Crashlytics.m5597a(r0)
            goto L8
        L96:
            r0 = 8
            android.net.Uri r1 = com.jibo.db.DatabaseContract.EntityEntry.m10079a(r0)     // Catch: java.lang.Exception -> L89
            goto L3d
        L9d:
            r0 = 0
            goto L75
        L9f:
            if (r1 == 0) goto La4
            r1.close()     // Catch: java.lang.Exception -> L89
        La4:
            r9.m10135j()     // Catch: java.lang.Exception -> L89
            goto L8
        La9:
            r0 = move-exception
            r1 = r6
        Lab:
            if (r1 == 0) goto Lb0
            r1.close()     // Catch: java.lang.Exception -> L89
        Lb0:
            r9.m10135j()     // Catch: java.lang.Exception -> L89
            throw r0     // Catch: java.lang.Exception -> L89
        Lb4:
            r0 = move-exception
            goto Lab
        Lb6:
            r0 = move-exception
            r1 = r6
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p018db.EntityData.m10113a(android.os.Bundle):void");
    }
}
