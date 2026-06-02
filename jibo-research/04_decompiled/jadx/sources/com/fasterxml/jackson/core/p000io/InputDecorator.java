package com.fasterxml.jackson.core.p000io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputDecorator implements Serializable {
    /* JADX INFO: renamed from: a */
    public abstract InputStream m6173a(IOContext iOContext, InputStream inputStream) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract Reader m6174a(IOContext iOContext, Reader reader) throws IOException;
}
