package org.apache.http.p028io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T t) throws HttpException, IOException;
}
