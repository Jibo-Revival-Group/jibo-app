package org.joda.time.p029tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.joda.time.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultNameProvider implements NameProvider {

    /* JADX INFO: renamed from: a */
    private HashMap<Locale, Map<String, Map<String, Object>>> f16186a = m17001a();

    /* JADX INFO: renamed from: b */
    private HashMap<Locale, Map<String, Map<Boolean, Object>>> f16187b = m17001a();

    @Override // org.joda.time.p029tz.NameProvider
    /* JADX INFO: renamed from: a */
    public String mo17004a(Locale locale, String str, String str2) {
        String[] strArrM17002c = m17002c(locale, str, str2);
        if (strArrM17002c == null) {
            return null;
        }
        return strArrM17002c[0];
    }

    @Override // org.joda.time.p029tz.NameProvider
    /* JADX INFO: renamed from: b */
    public String mo17006b(Locale locale, String str, String str2) {
        String[] strArrM17002c = m17002c(locale, str, str2);
        if (strArrM17002c == null) {
            return null;
        }
        return strArrM17002c[1];
    }

    /* JADX INFO: renamed from: c */
    private synchronized String[] m17002c(Locale locale, String str, String str2) {
        String[] strArr;
        Map map;
        String[] strArr2;
        String[] strArr3 = null;
        synchronized (this) {
            if (locale == null || str == null || str2 == null) {
                strArr = null;
            } else {
                Map<String, Map<String, Object>> map2 = this.f16186a.get(locale);
                if (map2 == null) {
                    HashMap<Locale, Map<String, Map<String, Object>>> map3 = this.f16186a;
                    HashMap mapM17001a = m17001a();
                    map3.put(locale, mapM17001a);
                    map = mapM17001a;
                } else {
                    map = map2;
                }
                Map mapM17001a2 = (Map) map.get(str);
                if (mapM17001a2 == null) {
                    mapM17001a2 = m17001a();
                    map.put(str, mapM17001a2);
                    String[][] zoneStrings = DateTimeUtils.m16515a(Locale.ENGLISH).getZoneStrings();
                    int length = zoneStrings.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String[] strArr4 = zoneStrings[i];
                            if (strArr4 != null && strArr4.length >= 5 && str.equals(strArr4[0])) {
                                strArr2 = strArr4;
                                break;
                            }
                            i++;
                        } else {
                            strArr2 = null;
                            break;
                        }
                    }
                    String[][] zoneStrings2 = DateTimeUtils.m16515a(locale).getZoneStrings();
                    int length2 = zoneStrings2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String[] strArr5 = zoneStrings2[i2];
                            if (strArr5 != null && strArr5.length >= 5 && str.equals(strArr5[0])) {
                                strArr3 = strArr5;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (strArr2 != null && strArr3 != null) {
                        mapM17001a2.put(strArr2[2], new String[]{strArr3[2], strArr3[1]});
                        if (strArr2[2].equals(strArr2[4])) {
                            mapM17001a2.put(strArr2[4] + "-Summer", new String[]{strArr3[4], strArr3[3]});
                        } else {
                            mapM17001a2.put(strArr2[4], new String[]{strArr3[4], strArr3[3]});
                        }
                    }
                }
                strArr = (String[]) mapM17001a2.get(str2);
            }
        }
        return strArr;
    }

    /* JADX INFO: renamed from: a */
    public String m17005a(Locale locale, String str, String str2, boolean z) {
        String[] strArrM17003c = m17003c(locale, str, str2, z);
        if (strArrM17003c == null) {
            return null;
        }
        return strArrM17003c[0];
    }

    /* JADX INFO: renamed from: b */
    public String m17007b(Locale locale, String str, String str2, boolean z) {
        String[] strArrM17003c = m17003c(locale, str, str2, z);
        if (strArrM17003c == null) {
            return null;
        }
        return strArrM17003c[1];
    }

    /* JADX INFO: renamed from: c */
    private synchronized String[] m17003c(Locale locale, String str, String str2, boolean z) {
        String[] strArr;
        Map map;
        String[] strArr2;
        String[] strArr3 = null;
        synchronized (this) {
            if (locale == null || str == null || str2 == null) {
                strArr = null;
            } else {
                if (str.startsWith("Etc/")) {
                    str = str.substring(4);
                }
                Map<String, Map<Boolean, Object>> map2 = this.f16187b.get(locale);
                if (map2 == null) {
                    HashMap<Locale, Map<String, Map<Boolean, Object>>> map3 = this.f16187b;
                    HashMap mapM17001a = m17001a();
                    map3.put(locale, mapM17001a);
                    map = mapM17001a;
                } else {
                    map = map2;
                }
                Map mapM17001a2 = (Map) map.get(str);
                if (mapM17001a2 == null) {
                    mapM17001a2 = m17001a();
                    map.put(str, mapM17001a2);
                    String[][] zoneStrings = DateTimeUtils.m16515a(Locale.ENGLISH).getZoneStrings();
                    int length = zoneStrings.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String[] strArr4 = zoneStrings[i];
                            if (strArr4 != null && strArr4.length >= 5 && str.equals(strArr4[0])) {
                                strArr2 = strArr4;
                                break;
                            }
                            i++;
                        } else {
                            strArr2 = null;
                            break;
                        }
                    }
                    String[][] zoneStrings2 = DateTimeUtils.m16515a(locale).getZoneStrings();
                    int length2 = zoneStrings2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String[] strArr5 = zoneStrings2[i2];
                            if (strArr5 != null && strArr5.length >= 5 && str.equals(strArr5[0])) {
                                strArr3 = strArr5;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    if (strArr2 != null && strArr3 != null) {
                        mapM17001a2.put(Boolean.TRUE, new String[]{strArr3[2], strArr3[1]});
                        mapM17001a2.put(Boolean.FALSE, new String[]{strArr3[4], strArr3[3]});
                    }
                }
                strArr = (String[]) mapM17001a2.get(Boolean.valueOf(z));
            }
        }
        return strArr;
    }

    /* JADX INFO: renamed from: a */
    private HashMap m17001a() {
        return new HashMap(7);
    }
}
