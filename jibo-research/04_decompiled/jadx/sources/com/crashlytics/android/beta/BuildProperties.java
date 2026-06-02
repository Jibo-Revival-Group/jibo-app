package com.crashlytics.android.beta;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
class BuildProperties {

    /* JADX INFO: renamed from: a */
    public final String f5126a;

    /* JADX INFO: renamed from: b */
    public final String f5127b;

    /* JADX INFO: renamed from: c */
    public final String f5128c;

    /* JADX INFO: renamed from: d */
    public final String f5129d;

    BuildProperties(String str, String str2, String str3, String str4) {
        this.f5126a = str;
        this.f5127b = str2;
        this.f5128c = str3;
        this.f5129d = str4;
    }

    /* JADX INFO: renamed from: a */
    public static BuildProperties m5700a(Properties properties) {
        return new BuildProperties(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    /* JADX INFO: renamed from: a */
    public static BuildProperties m5699a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return m5700a(properties);
    }
}
