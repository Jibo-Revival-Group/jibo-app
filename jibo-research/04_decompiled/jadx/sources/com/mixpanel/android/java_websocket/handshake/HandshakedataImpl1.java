package com.mixpanel.android.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class HandshakedataImpl1 implements HandshakeBuilder {

    /* JADX INFO: renamed from: a */
    private byte[] f11790a;

    /* JADX INFO: renamed from: b */
    private TreeMap<String, String> f11791b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    /* JADX INFO: renamed from: b */
    public Iterator<String> mo11640b() {
        return Collections.unmodifiableSet(this.f11791b.keySet()).iterator();
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    /* JADX INFO: renamed from: b */
    public String mo11639b(String str) {
        String str2 = this.f11791b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    /* JADX INFO: renamed from: c */
    public byte[] mo11642c() {
        return this.f11790a;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.HandshakeBuilder
    /* JADX INFO: renamed from: a */
    public void mo11635a(byte[] bArr) {
        this.f11790a = bArr;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.HandshakeBuilder
    /* JADX INFO: renamed from: a */
    public void mo11634a(String str, String str2) {
        this.f11791b.put(str, str2);
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    /* JADX INFO: renamed from: c */
    public boolean mo11641c(String str) {
        return this.f11791b.containsKey(str);
    }
}
