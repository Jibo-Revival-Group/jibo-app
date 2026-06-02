package com.fasterxml.jackson.core;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class JsonProcessingException extends IOException {

    /* JADX INFO: renamed from: a */
    protected JsonLocation f5413a;

    protected JsonProcessingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
        this.f5413a = jsonLocation;
    }

    protected JsonProcessingException(String str, JsonLocation jsonLocation) {
        this(str, jsonLocation, null);
    }

    /* JADX INFO: renamed from: a */
    public JsonLocation m6076a() {
        return this.f5413a;
    }

    /* JADX INFO: renamed from: b */
    protected String m6077b() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        JsonLocation jsonLocationM6076a = m6076a();
        String strM6077b = m6077b();
        if (jsonLocationM6076a != null || strM6077b != null) {
            StringBuilder sb = new StringBuilder(100);
            sb.append(message);
            if (strM6077b != null) {
                sb.append(strM6077b);
            }
            if (jsonLocationM6076a != null) {
                sb.append('\n');
                sb.append(" at ");
                sb.append(jsonLocationM6076a.toString());
            }
            return sb.toString();
        }
        return message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
