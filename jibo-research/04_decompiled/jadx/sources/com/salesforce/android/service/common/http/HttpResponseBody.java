package com.salesforce.android.service.common.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes.dex */
public interface HttpResponseBody extends Closeable {
    /* JADX INFO: renamed from: a */
    BufferedSource mo13775a();

    /* JADX INFO: renamed from: b */
    Reader mo13776b();

    /* JADX INFO: renamed from: c */
    String mo13777c() throws IOException;
}
