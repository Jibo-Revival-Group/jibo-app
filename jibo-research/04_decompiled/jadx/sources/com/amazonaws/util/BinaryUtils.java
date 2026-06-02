package com.amazonaws.util;

import com.facebook.appevents.AppEventsConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BinaryUtils {
    public static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b);
            if (hexString.length() == 1) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else if (hexString.length() == 8) {
                hexString = hexString.substring(6);
            }
            sb.append(hexString);
        }
        return sb.toString().toLowerCase(Locale.getDefault());
    }
}
