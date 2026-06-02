package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppLink {

    /* JADX INFO: renamed from: a */
    private Uri f4573a;

    /* JADX INFO: renamed from: b */
    private List<Target> f4574b;

    /* JADX INFO: renamed from: c */
    private Uri f4575c;

    public static class Target {

        /* JADX INFO: renamed from: a */
        private final Uri f4576a;

        /* JADX INFO: renamed from: b */
        private final String f4577b;

        /* JADX INFO: renamed from: c */
        private final String f4578c;

        /* JADX INFO: renamed from: d */
        private final String f4579d;

        public Target(String str, String str2, Uri uri, String str3) {
            this.f4577b = str;
            this.f4578c = str2;
            this.f4576a = uri;
            this.f4579d = str3;
        }
    }

    public AppLink(Uri uri, List<Target> list, Uri uri2) {
        this.f4573a = uri;
        this.f4574b = list == null ? Collections.emptyList() : list;
        this.f4575c = uri2;
    }
}
