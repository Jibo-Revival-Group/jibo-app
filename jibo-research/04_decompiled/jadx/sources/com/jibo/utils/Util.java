package com.jibo.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TypefaceSpan;
import android.util.Patterns;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.yalantis.ucrop.util.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class Util {

    /* JADX INFO: renamed from: a */
    public static Comparator<String> f11695a = new Comparator<String>() { // from class: com.jibo.utils.Util.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null) {
                return 1;
            }
            if (str2 == null) {
                return -1;
            }
            return str.compareTo(str2);
        }
    };

    /* JADX INFO: renamed from: a */
    public static String m11489a(String str) {
        if (str != null) {
            if ((str.startsWith("\"") && str.endsWith("\"")) || (str.startsWith("'") && str.endsWith("'"))) {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: renamed from: b */
    public static String m11495b(String str) throws NoSuchAlgorithmException {
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(str.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArrDigest) {
            stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m11488a(Context context) {
        String str = "1.0";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str + FileUtils.HIDDEN_PREFIX + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = str;
            LogUtils.m11407a("getAppVersion", e.getMessage());
            return str2;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m11497c(String str) {
        char[] charArray = str.toLowerCase().toCharArray();
        boolean z = false;
        for (int i = 0; i < charArray.length; i++) {
            if (!z && Character.isLetter(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
                z = true;
            } else if (Character.isWhitespace(charArray[i]) || charArray[i] == '.' || charArray[i] == '\'') {
                z = false;
            }
        }
        return String.valueOf(charArray);
    }

    /* JADX INFO: renamed from: a */
    public static void m11490a(Context context, ImageView imageView, Member member) {
        int i;
        if (member == null || member.getAccount() == null || DateTimeUtils.isAdult(member.getAccount().getBirthday())) {
            i = R.drawable.avatar_profile_other;
        } else {
            i = LoopHelper.isMemberAccepted(member) ? R.drawable.avatar_profile_child_accepted : R.drawable.avatar_profile_child_pending;
        }
        if (member == null || member.getAccount() == null) {
            imageView.setImageResource(i);
        } else {
            Glide.m5254b(context).m5279a(member.getAccount().getPhotoUrl()).mo5235f(i).mo5233e(i).mo5231d(i).mo5223b(DiskCacheStrategy.ALL).mo5239j().mo5216a(imageView);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11494a(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    /* JADX INFO: renamed from: a */
    public static SpannableStringBuilder m11487a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11650b), 0, str.indexOf(str2), 33);
        spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11652d), str.indexOf(str2) + 1, str.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: a */
    public static void m11492a(TextView textView, String str, String str2) {
        if (!Locale.getDefault().getLanguage().equals(Locale.CHINESE.getLanguage())) {
            str2 = str;
            str = str2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2 + " " + str);
        if (str2 != null) {
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11651c), 0, str2.length(), 33);
        }
        if (str != null) {
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11650b), str2.length() + 1, spannableStringBuilder.length(), 33);
        }
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: renamed from: a */
    public static void m11491a(TextView textView, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str != null) {
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11651c), 0, str.length(), 33);
        }
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: renamed from: b */
    public static void m11496b(TextView textView, String str) {
        if (textView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            int iLastIndexOf = str.lastIndexOf(" Jibo");
            spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11651c), 0, iLastIndexOf > 0 ? iLastIndexOf : str.length(), 33);
            if (iLastIndexOf > 0) {
                spannableStringBuilder.setSpan(new CustomTypefaceSpan("", ProximaHelper.f11650b), iLastIndexOf, spannableStringBuilder.length(), 33);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public static class CustomTypefaceSpan extends TypefaceSpan {

        /* JADX INFO: renamed from: a */
        private final Typeface f11696a;

        public CustomTypefaceSpan(String str, Typeface typeface) {
            super(str);
            this.f11696a = typeface;
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            m11501a(textPaint, this.f11696a);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            m11501a(textPaint, this.f11696a);
        }

        /* JADX INFO: renamed from: a */
        private static void m11501a(Paint paint, Typeface typeface) {
            int style;
            Typeface typeface2 = paint.getTypeface();
            if (typeface2 == null) {
                style = 0;
            } else {
                style = typeface2.getStyle();
            }
            int style2 = style & (typeface.getStyle() ^ (-1));
            if ((style2 & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style2 & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11493a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                outputStream.close();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static String m11498d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(" ");
        String str2 = "";
        if (strArrSplit.length == 1) {
            String str3 = strArrSplit[0];
            return "";
        }
        if (strArrSplit.length <= 1) {
            return "";
        }
        String str4 = strArrSplit[0];
        for (int i = 1; i < strArrSplit.length; i++) {
            str2 = str2 + strArrSplit[i] + " ";
        }
        str2.trim();
        return str4;
    }

    /* JADX INFO: renamed from: e */
    public static String m11499e(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(" ");
        String str2 = "";
        if (strArrSplit.length == 1) {
            return strArrSplit[0];
        }
        if (strArrSplit.length <= 1) {
            return "";
        }
        String str3 = strArrSplit[0];
        for (int i = 1; i < strArrSplit.length; i++) {
            str2 = str2 + strArrSplit[i] + " ";
        }
        return str2.trim();
    }
}
