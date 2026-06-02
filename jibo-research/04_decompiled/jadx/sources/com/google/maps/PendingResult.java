package com.google.maps;

import com.google.maps.errors.ApiException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface PendingResult<T> {

    public interface Callback<T> {
        void onFailure(Throwable th);

        void onResult(T t);
    }

    T await() throws InterruptedException, ApiException, IOException;

    T awaitIgnoreError();

    void cancel();

    void setCallback(Callback<T> callback);
}
