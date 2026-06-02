package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class CipherSuite {

    /* JADX INFO: renamed from: bj */
    final String f15019bj;

    /* JADX INFO: renamed from: a */
    static final Comparator<String> f14931a = new Comparator<String>() { // from class: okhttp3.CipherSuite.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iMin = Math.min(str.length(), str2.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length >= length2 ? 1 : -1;
            }
            return 0;
        }
    };

    /* JADX INFO: renamed from: bk */
    private static final Map<String, CipherSuite> f14994bk = new TreeMap(f14931a);

    /* JADX INFO: renamed from: b */
    public static final CipherSuite f14984b = m15551a("SSL_RSA_WITH_NULL_MD5", 1);

    /* JADX INFO: renamed from: c */
    public static final CipherSuite f14995c = m15551a("SSL_RSA_WITH_NULL_SHA", 2);

    /* JADX INFO: renamed from: d */
    public static final CipherSuite f14996d = m15551a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* JADX INFO: renamed from: e */
    public static final CipherSuite f14997e = m15551a("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* JADX INFO: renamed from: f */
    public static final CipherSuite f14998f = m15551a("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* JADX INFO: renamed from: g */
    public static final CipherSuite f14999g = m15551a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* JADX INFO: renamed from: h */
    public static final CipherSuite f15000h = m15551a("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* JADX INFO: renamed from: i */
    public static final CipherSuite f15001i = m15551a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* JADX INFO: renamed from: j */
    public static final CipherSuite f15002j = m15551a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* JADX INFO: renamed from: k */
    public static final CipherSuite f15003k = m15551a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* JADX INFO: renamed from: l */
    public static final CipherSuite f15004l = m15551a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* JADX INFO: renamed from: m */
    public static final CipherSuite f15005m = m15551a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* JADX INFO: renamed from: n */
    public static final CipherSuite f15006n = m15551a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* JADX INFO: renamed from: o */
    public static final CipherSuite f15007o = m15551a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* JADX INFO: renamed from: p */
    public static final CipherSuite f15008p = m15551a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* JADX INFO: renamed from: q */
    public static final CipherSuite f15009q = m15551a("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* JADX INFO: renamed from: r */
    public static final CipherSuite f15010r = m15551a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* JADX INFO: renamed from: s */
    public static final CipherSuite f15011s = m15551a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* JADX INFO: renamed from: t */
    public static final CipherSuite f15012t = m15551a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* JADX INFO: renamed from: u */
    public static final CipherSuite f15013u = m15551a("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* JADX INFO: renamed from: v */
    public static final CipherSuite f15014v = m15551a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* JADX INFO: renamed from: w */
    public static final CipherSuite f15015w = m15551a("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* JADX INFO: renamed from: x */
    public static final CipherSuite f15016x = m15551a("TLS_KRB5_WITH_DES_CBC_MD5", 34);

    /* JADX INFO: renamed from: y */
    public static final CipherSuite f15017y = m15551a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);

    /* JADX INFO: renamed from: z */
    public static final CipherSuite f15018z = m15551a("TLS_KRB5_WITH_RC4_128_MD5", 36);

    /* JADX INFO: renamed from: A */
    public static final CipherSuite f14905A = m15551a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);

    /* JADX INFO: renamed from: B */
    public static final CipherSuite f14906B = m15551a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);

    /* JADX INFO: renamed from: C */
    public static final CipherSuite f14907C = m15551a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);

    /* JADX INFO: renamed from: D */
    public static final CipherSuite f14908D = m15551a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);

    /* JADX INFO: renamed from: E */
    public static final CipherSuite f14909E = m15551a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* JADX INFO: renamed from: F */
    public static final CipherSuite f14910F = m15551a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);

    /* JADX INFO: renamed from: G */
    public static final CipherSuite f14911G = m15551a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* JADX INFO: renamed from: H */
    public static final CipherSuite f14912H = m15551a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);

    /* JADX INFO: renamed from: I */
    public static final CipherSuite f14913I = m15551a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* JADX INFO: renamed from: J */
    public static final CipherSuite f14914J = m15551a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);

    /* JADX INFO: renamed from: K */
    public static final CipherSuite f14915K = m15551a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);

    /* JADX INFO: renamed from: L */
    public static final CipherSuite f14916L = m15551a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);

    /* JADX INFO: renamed from: M */
    public static final CipherSuite f14917M = m15551a("TLS_RSA_WITH_NULL_SHA256", 59);

    /* JADX INFO: renamed from: N */
    public static final CipherSuite f14918N = m15551a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);

    /* JADX INFO: renamed from: O */
    public static final CipherSuite f14919O = m15551a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);

    /* JADX INFO: renamed from: P */
    public static final CipherSuite f14920P = m15551a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);

    /* JADX INFO: renamed from: Q */
    public static final CipherSuite f14921Q = m15551a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);

    /* JADX INFO: renamed from: R */
    public static final CipherSuite f14922R = m15551a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);

    /* JADX INFO: renamed from: S */
    public static final CipherSuite f14923S = m15551a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);

    /* JADX INFO: renamed from: T */
    public static final CipherSuite f14924T = m15551a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);

    /* JADX INFO: renamed from: U */
    public static final CipherSuite f14925U = m15551a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);

    /* JADX INFO: renamed from: V */
    public static final CipherSuite f14926V = m15551a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);

    /* JADX INFO: renamed from: W */
    public static final CipherSuite f14927W = m15551a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);

    /* JADX INFO: renamed from: X */
    public static final CipherSuite f14928X = m15551a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* JADX INFO: renamed from: Y */
    public static final CipherSuite f14929Y = m15551a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* JADX INFO: renamed from: Z */
    public static final CipherSuite f14930Z = m15551a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* JADX INFO: renamed from: aa */
    public static final CipherSuite f14958aa = m15551a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* JADX INFO: renamed from: ab */
    public static final CipherSuite f14959ab = m15551a("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* JADX INFO: renamed from: ac */
    public static final CipherSuite f14960ac = m15551a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* JADX INFO: renamed from: ad */
    public static final CipherSuite f14961ad = m15551a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* JADX INFO: renamed from: ae */
    public static final CipherSuite f14962ae = m15551a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* JADX INFO: renamed from: af */
    public static final CipherSuite f14963af = m15551a("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* JADX INFO: renamed from: ag */
    public static final CipherSuite f14964ag = m15551a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);

    /* JADX INFO: renamed from: ah */
    public static final CipherSuite f14965ah = m15551a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* JADX INFO: renamed from: ai */
    public static final CipherSuite f14966ai = m15551a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* JADX INFO: renamed from: aj */
    public static final CipherSuite f14967aj = m15551a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* JADX INFO: renamed from: ak */
    public static final CipherSuite f14968ak = m15551a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);

    /* JADX INFO: renamed from: al */
    public static final CipherSuite f14969al = m15551a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* JADX INFO: renamed from: am */
    public static final CipherSuite f14970am = m15551a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);

    /* JADX INFO: renamed from: an */
    public static final CipherSuite f14971an = m15551a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);

    /* JADX INFO: renamed from: ao */
    public static final CipherSuite f14972ao = m15551a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* JADX INFO: renamed from: ap */
    public static final CipherSuite f14973ap = m15551a("TLS_FALLBACK_SCSV", 22016);

    /* JADX INFO: renamed from: aq */
    public static final CipherSuite f14974aq = m15551a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* JADX INFO: renamed from: ar */
    public static final CipherSuite f14975ar = m15551a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* JADX INFO: renamed from: as */
    public static final CipherSuite f14976as = m15551a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* JADX INFO: renamed from: at */
    public static final CipherSuite f14977at = m15551a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* JADX INFO: renamed from: au */
    public static final CipherSuite f14978au = m15551a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* JADX INFO: renamed from: av */
    public static final CipherSuite f14979av = m15551a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* JADX INFO: renamed from: aw */
    public static final CipherSuite f14980aw = m15551a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* JADX INFO: renamed from: ax */
    public static final CipherSuite f14981ax = m15551a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* JADX INFO: renamed from: ay */
    public static final CipherSuite f14982ay = m15551a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);

    /* JADX INFO: renamed from: az */
    public static final CipherSuite f14983az = m15551a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);

    /* JADX INFO: renamed from: aA */
    public static final CipherSuite f14932aA = m15551a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);

    /* JADX INFO: renamed from: aB */
    public static final CipherSuite f14933aB = m15551a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);

    /* JADX INFO: renamed from: aC */
    public static final CipherSuite f14934aC = m15551a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);

    /* JADX INFO: renamed from: aD */
    public static final CipherSuite f14935aD = m15551a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);

    /* JADX INFO: renamed from: aE */
    public static final CipherSuite f14936aE = m15551a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);

    /* JADX INFO: renamed from: aF */
    public static final CipherSuite f14937aF = m15551a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);

    /* JADX INFO: renamed from: aG */
    public static final CipherSuite f14938aG = m15551a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);

    /* JADX INFO: renamed from: aH */
    public static final CipherSuite f14939aH = m15551a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);

    /* JADX INFO: renamed from: aI */
    public static final CipherSuite f14940aI = m15551a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* JADX INFO: renamed from: aJ */
    public static final CipherSuite f14941aJ = m15551a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* JADX INFO: renamed from: aK */
    public static final CipherSuite f14942aK = m15551a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);

    /* JADX INFO: renamed from: aL */
    public static final CipherSuite f14943aL = m15551a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);

    /* JADX INFO: renamed from: aM */
    public static final CipherSuite f14944aM = m15551a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);

    /* JADX INFO: renamed from: aN */
    public static final CipherSuite f14945aN = m15551a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);

    /* JADX INFO: renamed from: aO */
    public static final CipherSuite f14946aO = m15551a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);

    /* JADX INFO: renamed from: aP */
    public static final CipherSuite f14947aP = m15551a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);

    /* JADX INFO: renamed from: aQ */
    public static final CipherSuite f14948aQ = m15551a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);

    /* JADX INFO: renamed from: aR */
    public static final CipherSuite f14949aR = m15551a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);

    /* JADX INFO: renamed from: aS */
    public static final CipherSuite f14950aS = m15551a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);

    /* JADX INFO: renamed from: aT */
    public static final CipherSuite f14951aT = m15551a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);

    /* JADX INFO: renamed from: aU */
    public static final CipherSuite f14952aU = m15551a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);

    /* JADX INFO: renamed from: aV */
    public static final CipherSuite f14953aV = m15551a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);

    /* JADX INFO: renamed from: aW */
    public static final CipherSuite f14954aW = m15551a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);

    /* JADX INFO: renamed from: aX */
    public static final CipherSuite f14955aX = m15551a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* JADX INFO: renamed from: aY */
    public static final CipherSuite f14956aY = m15551a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* JADX INFO: renamed from: aZ */
    public static final CipherSuite f14957aZ = m15551a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* JADX INFO: renamed from: ba */
    public static final CipherSuite f14985ba = m15551a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* JADX INFO: renamed from: bb */
    public static final CipherSuite f14986bb = m15551a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* JADX INFO: renamed from: bc */
    public static final CipherSuite f14987bc = m15551a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* JADX INFO: renamed from: bd */
    public static final CipherSuite f14988bd = m15551a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* JADX INFO: renamed from: be */
    public static final CipherSuite f14989be = m15551a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* JADX INFO: renamed from: bf */
    public static final CipherSuite f14990bf = m15551a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* JADX INFO: renamed from: bg */
    public static final CipherSuite f14991bg = m15551a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* JADX INFO: renamed from: bh */
    public static final CipherSuite f14992bh = m15551a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* JADX INFO: renamed from: bi */
    public static final CipherSuite f14993bi = m15551a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* JADX INFO: renamed from: a */
    public static synchronized CipherSuite m15550a(String str) {
        CipherSuite cipherSuite;
        cipherSuite = f14994bk.get(str);
        if (cipherSuite == null) {
            cipherSuite = new CipherSuite(str);
            f14994bk.put(str, cipherSuite);
        }
        return cipherSuite;
    }

    /* JADX INFO: renamed from: a */
    static List<CipherSuite> m15549a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m15550a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CipherSuite(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f15019bj = str;
    }

    /* JADX INFO: renamed from: a */
    private static CipherSuite m15551a(String str, int i) {
        return m15550a(str);
    }

    /* JADX INFO: renamed from: a */
    public String m15552a() {
        return this.f15019bj;
    }

    public String toString() {
        return this.f15019bj;
    }
}
