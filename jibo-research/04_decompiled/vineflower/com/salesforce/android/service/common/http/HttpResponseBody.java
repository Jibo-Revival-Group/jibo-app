package com.salesforce.android.service.common.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import okio.BufferedSource;

public interface HttpResponseBody extends Closeable {
   BufferedSource a();

   Reader b();

   String c() throws IOException;
}
