package com.fasterxml.jackson.core;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class JsonLocation implements Serializable {

    /* JADX INFO: renamed from: a */
    public static final JsonLocation f5406a = new JsonLocation("N/A", -1, -1, -1, -1);

    /* JADX INFO: renamed from: b */
    final long f5407b;

    /* JADX INFO: renamed from: c */
    final long f5408c;

    /* JADX INFO: renamed from: d */
    final int f5409d;

    /* JADX INFO: renamed from: e */
    final int f5410e;

    /* JADX INFO: renamed from: f */
    final transient Object f5411f;

    public JsonLocation(Object obj, long j, int i, int i2) {
        this(obj, -1L, j, i, i2);
    }

    public JsonLocation(Object obj, long j, long j2, int i, int i2) {
        this.f5411f = obj;
        this.f5407b = j;
        this.f5408c = j2;
        this.f5409d = i;
        this.f5410e = i2;
    }

    /* JADX INFO: renamed from: a */
    public long m6059a() {
        return this.f5407b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        if (this.f5411f == null) {
            sb.append("UNKNOWN");
        } else {
            sb.append(this.f5411f.toString());
        }
        sb.append("; line: ");
        sb.append(this.f5409d);
        sb.append(", column: ");
        sb.append(this.f5410e);
        sb.append(']');
        return sb.toString();
    }

    public int hashCode() {
        return ((((this.f5411f == null ? 1 : this.f5411f.hashCode()) ^ this.f5409d) + this.f5410e) ^ ((int) this.f5408c)) + ((int) this.f5407b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        if (this.f5411f == null) {
            if (jsonLocation.f5411f != null) {
                return false;
            }
        } else if (!this.f5411f.equals(jsonLocation.f5411f)) {
            return false;
        }
        return this.f5409d == jsonLocation.f5409d && this.f5410e == jsonLocation.f5410e && this.f5408c == jsonLocation.f5408c && m6059a() == jsonLocation.m6059a();
    }
}
