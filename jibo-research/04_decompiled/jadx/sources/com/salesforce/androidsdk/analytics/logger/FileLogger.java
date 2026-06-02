package com.salesforce.androidsdk.analytics.logger;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.squareup.tape.QueueFile;
import java.io.File;
import java.io.IOException;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class FileLogger {

    /* JADX INFO: renamed from: a */
    private Context f14009a;

    /* JADX INFO: renamed from: b */
    private String f14010b;

    /* JADX INFO: renamed from: c */
    private QueueFile f14011c;

    /* JADX INFO: renamed from: d */
    private int f14012d;

    public FileLogger(Context context, String str) throws IOException {
        this.f14009a = context;
        this.f14010b = str;
        m14308b();
        this.f14011c = new QueueFile(new File(context.getFilesDir(), str + "_log"));
    }

    /* JADX INFO: renamed from: a */
    public int m14309a() {
        return this.f14011c.m15050b();
    }

    /* JADX INFO: renamed from: a */
    public void m14310a(String str) {
        if (!TextUtils.isEmpty(str)) {
            while (m14309a() >= this.f14012d) {
                try {
                    this.f14011c.m15051c();
                } catch (Exception e) {
                    Log.e("FileLogger", "Failed to write log line", e);
                    return;
                }
            }
            if (this.f14012d > 0) {
                this.f14011c.m15047a(str.getBytes(HTTP.UTF_8));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m14307a(int i) {
        SharedPreferences.Editor editorEdit = this.f14009a.getSharedPreferences("sf_file_logger_prefs", 0).edit();
        editorEdit.putInt(this.f14010b, i);
        editorEdit.commit();
        this.f14012d = i;
    }

    /* JADX INFO: renamed from: b */
    private void m14308b() {
        SharedPreferences sharedPreferences = this.f14009a.getSharedPreferences("sf_file_logger_prefs", 0);
        if (!sharedPreferences.contains(this.f14010b)) {
            m14307a(10000);
        }
        this.f14012d = sharedPreferences.getInt(this.f14010b, 10000);
    }
}
