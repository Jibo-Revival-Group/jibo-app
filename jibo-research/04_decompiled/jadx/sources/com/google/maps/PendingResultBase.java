package com.google.maps;

import com.google.maps.PendingResult;
import com.google.maps.PendingResultBase;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.internal.StringJoin;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class PendingResultBase<T, A extends PendingResultBase<T, A, R>, R extends ApiResponse<T>> implements PendingResult<T> {
    private final ApiConfig config;
    private final GeoApiContext context;
    private PendingResult<T> delegate;
    private HashMap<String, String> params = new HashMap<>();
    private Class<? extends R> responseClass;

    protected abstract void validateRequest();

    protected PendingResultBase(GeoApiContext geoApiContext, ApiConfig apiConfig, Class<? extends R> cls) {
        this.context = geoApiContext;
        this.config = apiConfig;
        this.responseClass = cls;
    }

    @Override // com.google.maps.PendingResult
    public final void setCallback(PendingResult.Callback<T> callback) {
        makeRequest().setCallback(callback);
    }

    @Override // com.google.maps.PendingResult
    public final T await() throws InterruptedException, ApiException, IOException {
        return makeRequest().await();
    }

    @Override // com.google.maps.PendingResult
    public final T awaitIgnoreError() {
        return makeRequest().awaitIgnoreError();
    }

    @Override // com.google.maps.PendingResult
    public final void cancel() {
        if (this.delegate != null) {
            this.delegate.cancel();
        }
    }

    private PendingResult<T> makeRequest() {
        if (this.delegate != null) {
            throw new IllegalStateException("'await', 'awaitIgnoreError' or 'setCallback' was already called.");
        }
        validateRequest();
        switch (this.config.requestVerb) {
            case "GET":
                PendingResult<T> pendingResult = this.context.get(this.config, this.responseClass, this.params);
                this.delegate = pendingResult;
                return pendingResult;
            case "POST":
                PendingResult<T> pendingResultPost = this.context.post(this.config, this.responseClass, this.params);
                this.delegate = pendingResultPost;
                return pendingResultPost;
            default:
                throw new IllegalStateException(String.format("Unexpected request method '%s'", this.config.requestVerb));
        }
    }

    protected A param(String str, String str2) {
        this.params.put(str, str2);
        return this;
    }

    protected A param(String str, StringJoin.UrlValue urlValue) {
        this.params.put(str, urlValue.toUrlValue());
        return this;
    }

    protected Map<String, String> params() {
        return Collections.unmodifiableMap(this.params);
    }

    public final A language(String str) {
        return (A) param("language", str);
    }

    public A channel(String str) {
        return (A) param("channel", str);
    }

    public A custom(String str, String str2) {
        return (A) param(str, str2);
    }
}
