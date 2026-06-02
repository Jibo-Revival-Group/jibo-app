package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ListViewDescribeResponse;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListViewDescribeModel implements ListViewDescribe {

    /* JADX INFO: renamed from: a */
    private static final List<String> f12508a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private String f12509b;

    /* JADX INFO: renamed from: c */
    private String f12510c;

    static {
        f12508a.add("WITH ");
        f12508a.add("GROUP BY ");
        f12508a.add("HAVING ");
        f12508a.add("ORDER BY ");
        f12508a.add("LIMIT ");
        f12508a.add("OFFSET ");
        f12508a.add("FOR ");
        f12508a.add("UPDATE ");
    }

    /* JADX INFO: renamed from: a */
    public static ListViewDescribe m12499a(ListViewDescribeResponse listViewDescribeResponse) {
        return new ListViewDescribeModel(listViewDescribeResponse);
    }

    private ListViewDescribeModel(ListViewDescribeResponse listViewDescribeResponse) {
        if (listViewDescribeResponse == null) {
            throw new IllegalArgumentException("ListViewDescribeResponse cannot be null");
        }
        this.f12509b = listViewDescribeResponse.m12333a();
        this.f12510c = "";
        if (listViewDescribeResponse.m12334b() != null) {
            int iLastIndexOf = listViewDescribeResponse.m12334b().lastIndexOf("USING SCOPE");
            iLastIndexOf = iLastIndexOf == -1 ? listViewDescribeResponse.m12334b().lastIndexOf("WHERE") : iLastIndexOf;
            if (iLastIndexOf != -1) {
                this.f12510c = listViewDescribeResponse.m12334b().substring(iLastIndexOf, m12498a(iLastIndexOf, listViewDescribeResponse.m12334b())).trim();
            }
        }
    }

    @Override // com.salesforce.android.cases.core.model.ListViewDescribe
    /* JADX INFO: renamed from: a */
    public String mo12500a() {
        return this.f12510c;
    }

    /* JADX INFO: renamed from: a */
    private int m12498a(int i, String str) {
        Iterator<String> it = f12508a.iterator();
        while (it.hasNext()) {
            int iLastIndexOf = str.lastIndexOf(it.next());
            if (iLastIndexOf != -1 && iLastIndexOf > i) {
                return iLastIndexOf;
            }
        }
        return str.length();
    }
}
