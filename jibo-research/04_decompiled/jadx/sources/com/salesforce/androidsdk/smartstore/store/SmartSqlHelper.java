package com.salesforce.androidsdk.smartstore.store;

import com.facebook.share.internal.ShareConstants;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.yalantis.ucrop.util.FileUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SmartSqlHelper {

    /* JADX INFO: renamed from: a */
    public static final Pattern f14326a = Pattern.compile("\\{([^}]+)\\}");

    /* JADX INFO: renamed from: b */
    private static Map<SQLiteDatabase, SmartSqlHelper> f14327b;

    /* JADX INFO: renamed from: a */
    public static synchronized SmartSqlHelper m14763a(SQLiteDatabase sQLiteDatabase) {
        SmartSqlHelper smartSqlHelper;
        if (f14327b == null) {
            f14327b = new HashMap();
        }
        smartSqlHelper = f14327b.get(sQLiteDatabase);
        if (smartSqlHelper == null) {
            smartSqlHelper = new SmartSqlHelper();
            f14327b.put(sQLiteDatabase, smartSqlHelper);
        }
        return smartSqlHelper;
    }

    /* JADX INFO: renamed from: a */
    public String m14767a(SQLiteDatabase sQLiteDatabase, String str) {
        String strTrim = str.toLowerCase(Locale.getDefault()).trim();
        if (strTrim.startsWith("insert") || strTrim.startsWith("update") || strTrim.startsWith("delete")) {
            throw new SmartSqlException("Only SELECT are supported");
        }
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = f14326a.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            String strGroup2 = matcher.group(1);
            int iStart = matcher.start();
            String[] strArrSplit = strGroup2.split(":");
            String str2 = strArrSplit[0];
            String strM14764a = m14764a(sQLiteDatabase, str2, iStart);
            String str3 = str.charAt(iStart + (-1)) == '.' ? "" : strM14764a + FileUtils.HIDDEN_PREFIX;
            boolean zContains = DBHelper.m14689a(sQLiteDatabase).m14712f(sQLiteDatabase, str2).contains("externalStorage");
            if (strArrSplit.length == 1) {
                matcher.appendReplacement(stringBuffer, strM14764a);
            } else if (strArrSplit.length == 2) {
                String str4 = strArrSplit[1];
                if (str4.equals("_soup")) {
                    if (zContains) {
                        matcher.appendReplacement(stringBuffer, String.format("'%s' as '%s', %s%s as '%s'", strM14764a, "externalStorage", str3, ShareConstants.WEB_DIALOG_PARAM_ID, "_soupEntryId"));
                    } else {
                        matcher.appendReplacement(stringBuffer, str3 + "soup");
                    }
                } else if (str4.equals("_soupEntryId")) {
                    matcher.appendReplacement(stringBuffer, str3 + ShareConstants.WEB_DIALOG_PARAM_ID);
                } else if (str4.equals("_soupCreatedDate")) {
                    matcher.appendReplacement(stringBuffer, str3 + "created");
                } else if (str4.equals("_soupLastModifiedDate")) {
                    matcher.appendReplacement(stringBuffer, str3 + "lastModified");
                } else {
                    matcher.appendReplacement(stringBuffer, m14765a(sQLiteDatabase, str2, str4, iStart).replace("$", "\\$"));
                }
            } else if (strArrSplit.length > 2) {
                m14766a("Invalid soup/path reference " + strGroup, iStart);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString().replaceAll("([^ ]+)\\.json_extract\\(soup", "json_extract($1.soup");
    }

    /* JADX INFO: renamed from: a */
    private String m14765a(SQLiteDatabase sQLiteDatabase, String str, String str2, int i) {
        try {
            return DBHelper.m14689a(sQLiteDatabase).m14698a(sQLiteDatabase, str, str2);
        } catch (SmartStore.SmartStoreException e) {
            m14766a(e.getMessage(), i);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m14764a(SQLiteDatabase sQLiteDatabase, String str, int i) {
        String strM14714h = DBHelper.m14689a(sQLiteDatabase).m14714h(sQLiteDatabase, str);
        if (strM14714h == null) {
            m14766a("Unknown soup " + str, i);
        }
        return strM14714h;
    }

    /* JADX INFO: renamed from: a */
    private void m14766a(String str, int i) {
        throw new SmartSqlException(str + " at character " + i);
    }

    public static class SmartSqlException extends SmartStore.SmartStoreException {
        public SmartSqlException(String str) {
            super(str);
        }
    }
}
