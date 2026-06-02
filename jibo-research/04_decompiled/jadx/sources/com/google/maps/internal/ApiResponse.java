package com.google.maps.internal;

import com.google.maps.errors.ApiException;

/* JADX INFO: loaded from: classes.dex */
public interface ApiResponse<T> {
    ApiException getError();

    T getResult();

    boolean successful();
}
