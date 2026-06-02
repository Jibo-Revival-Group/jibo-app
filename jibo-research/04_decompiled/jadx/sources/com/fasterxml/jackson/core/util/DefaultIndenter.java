package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DefaultIndenter extends DefaultPrettyPrinter.NopIndenter {

    /* JADX INFO: renamed from: a */
    public static final String f5663a;

    /* JADX INFO: renamed from: b */
    public static final DefaultIndenter f5664b;

    /* JADX INFO: renamed from: d */
    private final char[] f5665d;

    /* JADX INFO: renamed from: e */
    private final int f5666e;

    /* JADX INFO: renamed from: f */
    private final String f5667f;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable th) {
            property = "\n";
        }
        f5663a = property;
        f5664b = new DefaultIndenter("  ", f5663a);
    }

    public DefaultIndenter() {
        this("  ", f5663a);
    }

    public DefaultIndenter(String str, String str2) {
        this.f5666e = str.length();
        this.f5665d = new char[str.length() * 16];
        int length = 0;
        for (int i = 0; i < 16; i++) {
            str.getChars(0, str.length(), this.f5665d, length);
            length += str.length();
        }
        this.f5667f = str2;
    }

    @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
    /* JADX INFO: renamed from: a */
    public boolean mo6466a() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
    /* JADX INFO: renamed from: a */
    public void mo6465a(JsonGenerator jsonGenerator, int i) throws IOException {
        jsonGenerator.mo6051c(this.f5667f);
        if (i > 0) {
            int length = this.f5666e * i;
            while (length > this.f5665d.length) {
                jsonGenerator.mo6045a(this.f5665d, 0, this.f5665d.length);
                length -= this.f5665d.length;
            }
            jsonGenerator.mo6045a(this.f5665d, 0, length);
        }
    }
}
