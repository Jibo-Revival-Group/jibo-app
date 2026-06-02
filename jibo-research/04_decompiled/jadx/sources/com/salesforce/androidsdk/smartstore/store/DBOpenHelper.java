package com.salesforce.androidsdk.smartstore.store;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.smartstore.util.SmartStoreLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;
import net.sqlcipher.database.SQLiteOpenHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DBOpenHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a */
    private static String f14303a;

    /* JADX INFO: renamed from: c */
    private static Map<String, DBOpenHelper> f14304c = new HashMap();

    /* JADX INFO: renamed from: b */
    private String f14305b;

    /* JADX INFO: renamed from: a */
    public static synchronized Map<String, DBOpenHelper> m14718a() {
        return f14304c;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized List<String> m14717a(Context context, UserAccount userAccount, String str) {
        ArrayList arrayList;
        synchronized (DBOpenHelper.class) {
            arrayList = new ArrayList();
            if (userAccount != null) {
                String strM14241a = userAccount.m14241a(str);
                String[] list = new File(context.getApplicationInfo().dataDir + "/databases").list(new SmartStoreFileFilter(strM14241a));
                if (list != null && list.length > 0) {
                    for (String str2 : list) {
                        if (str2.indexOf(".db") > -1) {
                            arrayList.add(str2.substring(0, str2.indexOf(strM14241a)));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static synchronized List<String> m14723b(Context context, UserAccount userAccount, String str) {
        ArrayList arrayList;
        String strM14241a;
        String strM14246f = null;
        synchronized (DBOpenHelper.class) {
            arrayList = new ArrayList();
            if (userAccount != null) {
                strM14241a = userAccount.m14241a(str);
                strM14246f = userAccount.m14246f();
            } else {
                strM14241a = null;
            }
            String[] list = new File(context.getApplicationInfo().dataDir + "/databases").list(new SmartStoreGlobalFileFilter(strM14241a, strM14246f));
            if (list != null && list.length > 0) {
                for (String str2 : list) {
                    int iIndexOf = str2.indexOf(".db");
                    if (iIndexOf > -1) {
                        arrayList.add(str2.substring(0, iIndexOf));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static DBOpenHelper m14716a(Context context, String str, UserAccount userAccount, String str2) {
        List<String> listM14717a;
        String str3;
        String str4;
        StringBuffer stringBuffer = new StringBuffer(str);
        if (userAccount != null) {
            stringBuffer.append(userAccount.m14241a(str2));
        }
        stringBuffer.append(".db");
        String string = stringBuffer.toString();
        DBOpenHelper dBOpenHelper = f14304c.get(string);
        if (dBOpenHelper == null) {
            if (userAccount == null) {
                listM14717a = m14723b(context, userAccount, str2);
                str3 = "numGlobalStores";
                str4 = "globalSmartStoreInit";
            } else {
                listM14717a = m14717a(context, userAccount, str2);
                str3 = "numUserStores";
                str4 = "userSmartStoreInit";
            }
            int size = listM14717a == null ? 0 : listM14717a.size();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str3, size);
            } catch (JSONException e) {
                SmartStoreLogger.m14825a("DBOpenHelper", "Error occurred while creating JSON", e);
            }
            EventBuilderHelper.m14288a(str4, userAccount, "DBOpenHelper", jSONObject);
            DBOpenHelper dBOpenHelper2 = new DBOpenHelper(context, string);
            f14304c.put(string, dBOpenHelper2);
            return dBOpenHelper2;
        }
        return dBOpenHelper;
    }

    protected DBOpenHelper(Context context, String str) {
        super(context, str, null, 3, new DBHook());
        m14730a(context);
        this.f14305b = str;
        f14303a = context.getApplicationInfo().dataDir;
    }

    /* JADX INFO: renamed from: a */
    protected void m14730a(Context context) {
        SqliteLibraryLoader.m14808a(context);
    }

    @Override // net.sqlcipher.database.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.setLockingEnabled(false);
        SmartStore.m14775a(sQLiteDatabase);
    }

    @Override // net.sqlcipher.database.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.setLockingEnabled(false);
        if (i == 1) {
            SmartStore.m14782b(sQLiteDatabase);
        }
        if (i < 3) {
            SmartStore.m14777a(sQLiteDatabase, "soup_names", "soup_attrs", new String[]{"externalStorage"});
        }
    }

    @Override // net.sqlcipher.database.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        new SmartStore(sQLiteDatabase).m14798b();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m14719a(Context context, UserAccount userAccount) {
        m14726c(context, userAccount, null);
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m14726c(Context context, UserAccount userAccount, String str) {
        m14725b(context, "smartstore", userAccount, str);
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m14725b(Context context, String str, UserAccount userAccount, String str2) {
        try {
            StringBuffer stringBuffer = new StringBuffer(str);
            if (userAccount != null) {
                stringBuffer.append(userAccount.m14241a(str2));
            }
            stringBuffer.append(".db");
            String string = stringBuffer.toString();
            DBOpenHelper dBOpenHelper = f14304c.get(string);
            if (dBOpenHelper != null) {
                dBOpenHelper.close();
                f14304c.remove(string);
            }
            context.deleteDatabase(string);
            if (userAccount != null && TextUtils.isEmpty(str2)) {
                StringBuffer stringBuffer2 = new StringBuffer(str);
                stringBuffer2.append(userAccount.m14261u());
                m14720a(context, stringBuffer2.toString());
            }
            StringBuilder sb = new StringBuilder(context.getApplicationInfo().dataDir);
            sb.append("/databases/").append(string).append("_external_soup_blobs/");
            m14722a(new File(sb.toString()));
        } catch (Exception e) {
            SmartStoreLogger.m14825a("DBOpenHelper", "Exception occurred while attemption to delete database", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m14724b(Context context) {
        m14720a(context, "00D");
    }

    static class DBHook implements SQLiteDatabaseHook {
        DBHook() {
        }

        @Override // net.sqlcipher.database.SQLiteDatabaseHook
        public void preKey(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("PRAGMA cipher_default_kdf_iter = '4000'");
        }

        @Override // net.sqlcipher.database.SQLiteDatabaseHook
        public void postKey(SQLiteDatabase sQLiteDatabase) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m14720a(Context context, String str) {
        File file = new File(context.getApplicationInfo().dataDir + "/databases");
        if (file != null) {
            SmartStoreFileFilter smartStoreFileFilter = new SmartStoreFileFilter(str);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2 != null && smartStoreFileFilter.accept(file, file2.getName())) {
                        file2.delete();
                        f14304c.remove(file2.getName());
                    }
                }
            }
        }
    }

    private static class SmartStoreFileFilter implements FilenameFilter {

        /* JADX INFO: renamed from: a */
        private String f14306a;

        public SmartStoreFileFilter(String str) {
            this.f14306a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str != null && str.contains(this.f14306a);
        }

        /* JADX INFO: renamed from: a */
        String m14737a() {
            return this.f14306a;
        }
    }

    private static class SmartStoreGlobalFileFilter extends SmartStoreFileFilter {

        /* JADX INFO: renamed from: a */
        String f14307a;

        public SmartStoreGlobalFileFilter(String str, String str2) {
            super(str);
            this.f14307a = str2;
        }

        @Override // com.salesforce.androidsdk.smartstore.store.DBOpenHelper.SmartStoreFileFilter, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return m14737a() == null || !(super.accept(file, str) || str.contains(this.f14307a));
        }
    }

    /* JADX INFO: renamed from: a */
    public String m14728a(String str) {
        StringBuilder sb = new StringBuilder(f14303a);
        sb.append("/databases/").append(this.f14305b).append("_external_soup_blobs/");
        if (str != null) {
            sb.append(str).append('/');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m14722a(File file) {
        boolean zM14722a;
        if (file == null || !file.exists()) {
            return false;
        }
        boolean z = true;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    zM14722a = file2.delete();
                } else {
                    zM14722a = m14722a(file2);
                }
                z &= zM14722a;
            }
        }
        return z & file.delete();
    }

    /* JADX INFO: renamed from: b */
    public boolean m14735b(String str) {
        return new File(m14728a(str)).mkdirs();
    }

    /* JADX INFO: renamed from: c */
    public boolean m14736c(String str) {
        if (f14303a != null) {
            return m14722a(new File(m14728a(str)));
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static void m14721a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        File[] fileArrListFiles;
        File file = new File(sQLiteDatabase.getPath() + "_external_soup_blobs/");
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                File[] fileArrListFiles2 = file2.listFiles();
                if (fileArrListFiles2 != null) {
                    for (File file3 : fileArrListFiles2) {
                        StringBuilder sb = new StringBuilder();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(file3));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    sb.append(line).append('\n');
                                }
                            }
                            bufferedReader.close();
                            String strM14365a = Encryptor.m14365a(sb.toString(), str);
                            file3.delete();
                            FileOutputStream fileOutputStream = new FileOutputStream(file3, false);
                            fileOutputStream.write(Encryptor.m14371b(strM14365a, str2).getBytes());
                            fileOutputStream.close();
                        } catch (IOException e) {
                            SmartStoreLogger.m14825a("DBOpenHelper", "Exception occurred while rekeying external files", e);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m14732a(String str, long j, JSONObject jSONObject, String str2) {
        return m14731a(str, j, jSONObject.toString(), str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m14731a(java.lang.String r7, long r8, java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            r6 = this;
            r1 = 0
            java.io.File r0 = r6.m14727a(r7, r8)
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L23
            r2 = 0
            r3.<init>(r0, r2)     // Catch: java.io.IOException -> L23
            r2 = 0
            byte[] r0 = com.salesforce.androidsdk.analytics.security.Encryptor.m14374c(r10, r11)     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L59
            if (r0 == 0) goto L31
            r3.write(r0)     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L59
            r0 = 1
            if (r3 == 0) goto L1d
            if (r2 == 0) goto L2d
            r3.close()     // Catch: java.lang.Throwable -> L1e java.io.IOException -> L23
        L1d:
            return r0
        L1e:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L23
            goto L1d
        L23:
            r0 = move-exception
            java.lang.String r2 = "DBOpenHelper"
            java.lang.String r3 = "Exception occurred while attempting to write external soup blob"
            com.salesforce.androidsdk.smartstore.util.SmartStoreLogger.m14825a(r2, r3, r0)
        L2b:
            r0 = r1
            goto L1d
        L2d:
            r3.close()     // Catch: java.io.IOException -> L23
            goto L1d
        L31:
            if (r3 == 0) goto L2b
            if (r2 == 0) goto L3e
            r3.close()     // Catch: java.io.IOException -> L23 java.lang.Throwable -> L39
            goto L2b
        L39:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch: java.io.IOException -> L23
            goto L2b
        L3e:
            r3.close()     // Catch: java.io.IOException -> L23
            goto L2b
        L42:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L44
        L44:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L48:
            if (r3 == 0) goto L4f
            if (r2 == 0) goto L55
            r3.close()     // Catch: java.io.IOException -> L23 java.lang.Throwable -> L50
        L4f:
            throw r0     // Catch: java.io.IOException -> L23
        L50:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L23
            goto L4f
        L55:
            r3.close()     // Catch: java.io.IOException -> L23
            goto L4f
        L59:
            r0 = move-exception
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.smartstore.store.DBOpenHelper.m14731a(java.lang.String, long, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m14729a(String str, long j, String str2) throws Throwable {
        try {
            String strM14734b = m14734b(str, j, str2);
            if (strM14734b != null) {
                return new JSONObject(strM14734b);
            }
        } catch (JSONException e) {
            SmartStoreLogger.m14825a("DBOpenHelper", "Exception occurred while attempting to read external soup blob", e);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[Catch: IOException -> 0x002b, SYNTHETIC, TRY_ENTER, TryCatch #5 {IOException -> 0x002b, blocks: (B:3:0x0005, B:8:0x0022, B:15:0x0035, B:11:0x0027, B:23:0x0043, B:27:0x004c, B:26:0x0048, B:24:0x0046), top: B:37:0x0005, inners: #2, #3 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m14734b(java.lang.String r11, long r12, java.lang.String r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r1 = 0
            java.io.File r0 = r10.m14727a(r11, r12)
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.IOException -> L2b
            r3.<init>(r0)     // Catch: java.io.IOException -> L2b
            r2 = 0
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            long r6 = r0.length()     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            int r0 = (int) r6     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            r4.readFully(r0)     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            java.lang.String r0 = com.salesforce.androidsdk.analytics.security.Encryptor.m14366a(r0, r14)     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L50
            if (r3 == 0) goto L25
            if (r1 == 0) goto L35
            r3.close()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L2b
        L25:
            return r0
        L26:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L2b
            goto L25
        L2b:
            r0 = move-exception
            java.lang.String r2 = "DBOpenHelper"
            java.lang.String r3 = "Exception occurred while attempting to read external soup blob"
            com.salesforce.androidsdk.smartstore.util.SmartStoreLogger.m14825a(r2, r3, r0)
            r0 = r1
            goto L25
        L35:
            r3.close()     // Catch: java.io.IOException -> L2b
            goto L25
        L39:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L3b
        L3b:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        L3f:
            if (r3 == 0) goto L46
            if (r2 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L47
        L46:
            throw r0     // Catch: java.io.IOException -> L2b
        L47:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L2b
            goto L46
        L4c:
            r3.close()     // Catch: java.io.IOException -> L2b
            goto L46
        L50:
            r0 = move-exception
            r2 = r1
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.androidsdk.smartstore.store.DBOpenHelper.m14734b(java.lang.String, long, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    public boolean m14733a(String str, Long[] lArr) {
        boolean zDelete = true;
        for (Long l : lArr) {
            zDelete &= m14727a(str, l.longValue()).delete();
        }
        return zDelete;
    }

    /* JADX INFO: renamed from: a */
    public File m14727a(String str, long j) {
        return new File(m14728a(str), "soupelt_" + j);
    }
}
