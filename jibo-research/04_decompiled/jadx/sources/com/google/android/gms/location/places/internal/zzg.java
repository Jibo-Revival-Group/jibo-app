package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzg {
    /* JADX INFO: renamed from: a */
    public static CharSequence m8799a(String str, List<zzb> list, CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (zzb zzbVar : list) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), zzbVar.f8203a, zzbVar.f8204b + zzbVar.f8203a, 0);
        }
        return spannableString;
    }
}
