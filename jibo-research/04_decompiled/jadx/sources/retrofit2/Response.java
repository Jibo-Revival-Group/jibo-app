package retrofit2;

import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes2.dex */
public final class Response<T> {

    /* JADX INFO: renamed from: a */
    private final okhttp3.Response f16307a;

    /* JADX INFO: renamed from: b */
    private final T f16308b;

    /* JADX INFO: renamed from: c */
    private final ResponseBody f16309c;

    /* JADX INFO: renamed from: a */
    public static <T> Response<T> m17119a(T t, okhttp3.Response response) {
        Utils.m17162a(response, "rawResponse == null");
        if (!response.m15794d()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new Response<>(response, t, null);
    }

    /* JADX INFO: renamed from: a */
    public static <T> Response<T> m17120a(ResponseBody responseBody, okhttp3.Response response) {
        Utils.m17162a(responseBody, "body == null");
        Utils.m17162a(response, "rawResponse == null");
        if (response.m15794d()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response<>(response, null, responseBody);
    }

    private Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.f16307a = response;
        this.f16308b = t;
        this.f16309c = responseBody;
    }

    /* JADX INFO: renamed from: a */
    public boolean m17121a() {
        return this.f16307a.m15794d();
    }

    /* JADX INFO: renamed from: b */
    public T m17122b() {
        return this.f16308b;
    }

    public String toString() {
        return this.f16307a.toString();
    }
}
