package com.jibo.utils;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Commons {

    /* JADX INFO: renamed from: a */
    public static final Pattern f11676a = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");

    /* JADX INFO: renamed from: b */
    public static final Pattern f11677b = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    /* JADX INFO: renamed from: c */
    public static final Pattern f11678c = Pattern.compile("\\w*[A-Z]\\w*");

    /* JADX INFO: renamed from: d */
    public static final Pattern f11679d = Pattern.compile("\\w*[a-z]\\w*");

    /* JADX INFO: renamed from: e */
    public static final Pattern f11680e = Pattern.compile(".*\\d+.*");

    /* JADX INFO: renamed from: f */
    public static final Pattern f11681f = Pattern.compile("(([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3}))");
}
