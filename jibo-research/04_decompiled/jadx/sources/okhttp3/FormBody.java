package okhttp3;

import com.google.api.client.http.UrlEncodedParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes2.dex */
public final class FormBody extends RequestBody {

    /* JADX INFO: renamed from: a */
    private static final MediaType f15065a = MediaType.m15695a(UrlEncodedParser.CONTENT_TYPE);

    /* JADX INFO: renamed from: b */
    private final List<String> f15066b;

    /* JADX INFO: renamed from: c */
    private final List<String> f15067c;

    FormBody(List<String> list, List<String> list2) {
        this.f15066b = Util.m15839a(list);
        this.f15067c = Util.m15839a(list2);
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: a */
    public MediaType mo14283a() {
        return f15065a;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: b */
    public long mo14285b() {
        return m15605a((BufferedSink) null, true);
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: a */
    public void mo14284a(BufferedSink bufferedSink) throws IOException {
        m15605a(bufferedSink, false);
    }

    /* JADX INFO: renamed from: a */
    private long m15605a(BufferedSink bufferedSink, boolean z) {
        Buffer bufferMo16271c;
        long jM16263b = 0;
        if (z) {
            bufferMo16271c = new Buffer();
        } else {
            bufferMo16271c = bufferedSink.mo16271c();
        }
        int size = this.f15066b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bufferMo16271c.mo16298k(38);
            }
            bufferMo16271c.mo16267b(this.f15066b.get(i));
            bufferMo16271c.mo16298k(61);
            bufferMo16271c.mo16267b(this.f15067c.get(i));
        }
        if (z) {
            jM16263b = bufferMo16271c.m16263b();
            bufferMo16271c.m16310u();
        }
        return jM16263b;
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private final List<String> f15068a = new ArrayList();

        /* JADX INFO: renamed from: b */
        private final List<String> f15069b = new ArrayList();

        /* JADX INFO: renamed from: a */
        public Builder m15606a(String str, String str2) {
            this.f15068a.add(HttpUrl.m15635a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f15069b.add(HttpUrl.m15635a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m15608b(String str, String str2) {
            this.f15068a.add(HttpUrl.m15635a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f15069b.add(HttpUrl.m15635a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        /* JADX INFO: renamed from: a */
        public FormBody m15607a() {
            return new FormBody(this.f15068a, this.f15069b);
        }
    }
}
