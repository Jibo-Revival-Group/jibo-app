package com.amazonaws.util;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes.dex */
public class StringInputStream extends ByteArrayInputStream {
    private final String string;

    public StringInputStream(String str) {
        super(str.getBytes(StringUtils.UTF8));
        this.string = str;
    }
}
