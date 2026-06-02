package com.salesforce.android.knowledge.core.offline;

import android.text.Html;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class ArticleParser {

    /* JADX INFO: renamed from: a */
    private static final Pattern f13011a = Pattern.compile("<img[^>]+src=\\\"([^\"]+)\\\"[^>]*>");

    /* JADX INFO: renamed from: b */
    private final String f13012b;

    ArticleParser(String str) {
        this.f13012b = str;
    }

    /* JADX INFO: renamed from: a */
    List<String> m13285a(ArticleDetails articleDetails) {
        ArrayList arrayList = new ArrayList();
        Iterator<ArticleDetails.Field> it = articleDetails.mo13203f().iterator();
        while (it.hasNext()) {
            String strMo13208c = it.next().mo13208c();
            if (strMo13208c != null) {
                Matcher matcher = f13011a.matcher(strMo13208c);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (strGroup.startsWith("//")) {
                        strGroup = "https:" + strGroup;
                    } else if (strGroup.startsWith("/")) {
                        strGroup = this.f13012b + strGroup;
                    }
                    arrayList.add(Html.fromHtml(strGroup).toString());
                }
            }
        }
        return arrayList;
    }
}
