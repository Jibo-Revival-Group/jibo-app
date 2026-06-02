package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Joiner {

    /* JADX INFO: renamed from: a */
    private final String f8554a;

    /* JADX INFO: renamed from: a */
    public static Joiner m9005a(String str) {
        return new Joiner(str);
    }

    private Joiner(String str) {
        this.f8554a = (String) Preconditions.m9015a(str);
    }

    /* JADX INFO: renamed from: a */
    public <A extends Appendable> A m9006a(A a, Iterator<?> it) throws IOException {
        Preconditions.m9015a(a);
        if (it.hasNext()) {
            a.append(m9007a(it.next()));
            while (it.hasNext()) {
                a.append(this.f8554a);
                a.append(m9007a(it.next()));
            }
        }
        return a;
    }

    /* JADX INFO: renamed from: a */
    public final StringBuilder m9008a(StringBuilder sb, Iterable<?> iterable) {
        return m9009a(sb, iterable.iterator());
    }

    /* JADX INFO: renamed from: a */
    public final StringBuilder m9009a(StringBuilder sb, Iterator<?> it) {
        try {
            m9006a(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: a */
    CharSequence m9007a(Object obj) {
        Preconditions.m9015a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
