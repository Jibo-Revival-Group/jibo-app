package okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CookieJar {

    /* JADX INFO: renamed from: a */
    public static final CookieJar f15054a = new CookieJar() { // from class: okhttp3.CookieJar.1
        @Override // okhttp3.CookieJar
        /* JADX INFO: renamed from: a */
        public void mo15587a(HttpUrl httpUrl, List<Cookie> list) {
        }

        @Override // okhttp3.CookieJar
        /* JADX INFO: renamed from: a */
        public List<Cookie> mo15586a(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    /* JADX INFO: renamed from: a */
    List<Cookie> mo15586a(HttpUrl httpUrl);

    /* JADX INFO: renamed from: a */
    void mo15587a(HttpUrl httpUrl, List<Cookie> list);
}
