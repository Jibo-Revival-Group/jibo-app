package com.salesforce.android.knowledge.core.util;

import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LanguageManager {

    /* JADX INFO: renamed from: a */
    private static final Locale f13062a = new Locale("da");

    /* JADX INFO: renamed from: b */
    private static final Locale f13063b = new Locale("nl", "NL");

    /* JADX INFO: renamed from: c */
    private static final Locale f13064c = new Locale("fi");

    /* JADX INFO: renamed from: d */
    private static final Locale f13065d = new Locale("no");

    /* JADX INFO: renamed from: e */
    private static final Locale f13066e = new Locale("pt", "BR");

    /* JADX INFO: renamed from: f */
    private static final Locale f13067f = new Locale("ru");

    /* JADX INFO: renamed from: g */
    private static final Locale f13068g = new Locale("es");

    /* JADX INFO: renamed from: h */
    private static final Locale f13069h = new Locale("es", "MX");

    /* JADX INFO: renamed from: i */
    private static final Locale f13070i = new Locale("sv");

    /* JADX INFO: renamed from: j */
    private static final Locale f13071j = new Locale("th");

    /* JADX INFO: renamed from: k */
    private static final HashMap<String, Locale> f13072k = new HashMap<>();

    /* JADX INFO: renamed from: l */
    private static final HashMap<String, Locale> f13073l = new HashMap<>();

    static {
        f13072k.put(Locale.SIMPLIFIED_CHINESE.getLanguage(), Locale.SIMPLIFIED_CHINESE);
        f13072k.put(f13062a.getLanguage(), f13062a);
        f13072k.put(f13063b.getLanguage(), f13063b);
        f13072k.put(Locale.US.getLanguage(), Locale.US);
        f13072k.put(f13064c.getLanguage(), f13064c);
        f13072k.put(Locale.FRENCH.getLanguage(), Locale.FRENCH);
        f13072k.put(Locale.GERMAN.getLanguage(), Locale.GERMAN);
        f13072k.put(Locale.ITALIAN.getLanguage(), Locale.ITALIAN);
        f13072k.put(Locale.JAPANESE.getLanguage(), Locale.JAPANESE);
        f13072k.put(Locale.KOREAN.getLanguage(), Locale.KOREAN);
        f13072k.put(f13065d.getLanguage(), f13065d);
        f13072k.put(f13066e.getLanguage(), f13066e);
        f13072k.put(f13067f.getLanguage(), f13067f);
        f13072k.put(f13068g.getLanguage(), f13068g);
        f13072k.put(f13070i.getLanguage(), f13070i);
        f13072k.put(f13071j.getLanguage(), f13071j);
        f13073l.put(Locale.TRADITIONAL_CHINESE.getCountry(), Locale.TRADITIONAL_CHINESE);
        f13073l.put(f13069h.getCountry(), f13069h);
    }

    /* JADX INFO: renamed from: a */
    public static String m13339a(Locale locale) {
        Locale locale2 = f13073l.get(locale.getCountry());
        if (locale2 != null && !locale2.getLanguage().equals(locale.getLanguage())) {
            locale2 = null;
        }
        if (locale2 == null) {
            locale2 = f13072k.get(locale.getLanguage());
        }
        if (locale2 == null) {
            throw new IllegalArgumentException("Input Language Not supported: " + locale.toString());
        }
        StringBuilder sb = new StringBuilder(locale2.getLanguage().toLowerCase());
        return locale2.getCountry().isEmpty() ? sb.toString() : sb.append("-").append(locale2.getCountry().toUpperCase()).toString();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m13340b(Locale locale) {
        return (locale == null || f13072k.get(locale.getLanguage()) == null) ? false : true;
    }
}
