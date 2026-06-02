package com.fasterxml.jackson.core.p000io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutputDecorator implements Serializable {
    /* JADX INFO: renamed from: a */
    public abstract OutputStream m6197a(IOContext iOContext, OutputStream outputStream) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract Writer m6198a(IOContext iOContext, Writer writer) throws IOException;
}
