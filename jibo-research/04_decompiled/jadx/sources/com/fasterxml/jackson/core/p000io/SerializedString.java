package com.fasterxml.jackson.core.p000io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SerializedString implements SerializableString, Serializable {

    /* JADX INFO: renamed from: a */
    protected final String f5508a;

    /* JADX INFO: renamed from: b */
    protected byte[] f5509b;

    /* JADX INFO: renamed from: c */
    protected transient String f5510c;

    public SerializedString(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.f5508a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.f5510c = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.f5508a);
    }

    protected Object readResolve() {
        return new SerializedString(this.f5510c);
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    /* JADX INFO: renamed from: a */
    public final String mo6095a() {
        return this.f5508a;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    /* JADX INFO: renamed from: b */
    public final byte[] mo6096b() {
        byte[] bArr = this.f5509b;
        if (bArr == null) {
            byte[] bArrM6178a = JsonStringEncoder.m6176a().m6178a(this.f5508a);
            this.f5509b = bArrM6178a;
            return bArrM6178a;
        }
        return bArr;
    }

    public final String toString() {
        return this.f5508a;
    }

    public final int hashCode() {
        return this.f5508a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f5508a.equals(((SerializedString) obj).f5508a);
    }
}
