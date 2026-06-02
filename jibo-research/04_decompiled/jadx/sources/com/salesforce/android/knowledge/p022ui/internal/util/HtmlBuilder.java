package com.salesforce.android.knowledge.p022ui.internal.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HtmlBuilder {

    /* JADX INFO: renamed from: a */
    final Map<String, String[]> f13421a = new HashMap();

    /* JADX INFO: renamed from: b */
    final StringBuilder f13422b = new StringBuilder("<!doctype html><html><head>");

    /* JADX INFO: renamed from: c */
    final StringBuilder f13423c = new StringBuilder();

    /* JADX INFO: renamed from: d */
    final List<String> f13424d = new ArrayList();

    /* JADX INFO: renamed from: e */
    final List<String> f13425e = new ArrayList();

    /* JADX INFO: renamed from: a */
    public static HtmlBuilder m13688a() {
        return new HtmlBuilder();
    }

    private HtmlBuilder() {
    }

    /* JADX INFO: renamed from: a */
    public HtmlBuilder m13689a(String str) {
        this.f13422b.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"").append(str).append("\"/>");
        return this;
    }

    /* JADX INFO: renamed from: a */
    public HtmlBuilder m13691a(String str, String... strArr) {
        this.f13421a.put(str, strArr);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public HtmlBuilder m13693b(String str) {
        this.f13424d.add(str);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public HtmlBuilder m13695c(String str) {
        this.f13425e.add(str);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public HtmlBuilder m13696d(String str) {
        this.f13423c.append("<h1>").append(str).append("</h1>");
        return this;
    }

    /* JADX INFO: renamed from: b */
    public HtmlBuilder m13692b() {
        this.f13423c.append("<section>");
        return this;
    }

    /* JADX INFO: renamed from: c */
    public HtmlBuilder m13694c() {
        this.f13423c.append("</section>");
        return this;
    }

    /* JADX INFO: renamed from: e */
    public HtmlBuilder m13698e(String str) {
        this.f13423c.append("<p>").append(str).append("</p>");
        return this;
    }

    /* JADX INFO: renamed from: a */
    public HtmlBuilder m13690a(String str, String str2) {
        this.f13423c.append("<p class=\"").append(str).append("\">").append(str2).append("</p>");
        return this;
    }

    /* JADX INFO: renamed from: d */
    public String m13697d() {
        this.f13422b.append("<style type=\"text/css\">");
        for (Map.Entry<String, String[]> entry : this.f13421a.entrySet()) {
            this.f13422b.append(entry.getKey()).append("{");
            for (String str : entry.getValue()) {
                this.f13422b.append(str).append(";");
            }
            this.f13422b.append("}");
        }
        this.f13422b.append("</style>");
        for (String str2 : this.f13424d) {
            this.f13422b.append("<style type=\"text/css\">");
            this.f13422b.append(str2);
            this.f13422b.append("</style>");
        }
        for (String str3 : this.f13425e) {
            this.f13423c.append("<script>");
            this.f13423c.append(str3);
            this.f13423c.append("</script>");
        }
        return this.f13422b.append("</head><body>").append((CharSequence) this.f13423c).append("</body></html>").toString();
    }
}
