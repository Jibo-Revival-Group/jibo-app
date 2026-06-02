package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import com.yalantis.ucrop.util.FileUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DecideChecker {

    /* JADX INFO: renamed from: f */
    private static final JSONArray f11838f = new JSONArray();

    /* JADX INFO: renamed from: a */
    private final MPConfig f11839a;

    /* JADX INFO: renamed from: b */
    private final Context f11840b;

    /* JADX INFO: renamed from: c */
    private final Map<String, DecideMessages> f11841c = new HashMap();

    /* JADX INFO: renamed from: d */
    private final ImageStore f11842d;

    /* JADX INFO: renamed from: e */
    private final SystemInformation f11843e;

    static class Result {

        /* JADX INFO: renamed from: a */
        public final List<InAppNotification> f11844a = new ArrayList();

        /* JADX INFO: renamed from: b */
        public JSONArray f11845b = DecideChecker.f11838f;

        /* JADX INFO: renamed from: c */
        public JSONArray f11846c = DecideChecker.f11838f;

        /* JADX INFO: renamed from: d */
        public boolean f11847d = false;
    }

    public DecideChecker(Context context, MPConfig mPConfig) {
        this.f11840b = context;
        this.f11839a = mPConfig;
        this.f11842d = m11702a(context);
        this.f11843e = SystemInformation.m11933a(context);
    }

    /* JADX INFO: renamed from: a */
    protected ImageStore m11702a(Context context) {
        return new ImageStore(context, "DecideChecker");
    }

    /* JADX INFO: renamed from: a */
    public void m11703a(DecideMessages decideMessages) {
        this.f11841c.put(decideMessages.m11707a(), decideMessages);
    }

    /* JADX INFO: renamed from: a */
    public void m11704a(String str, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        DecideMessages decideMessages = this.f11841c.get(str);
        if (decideMessages != null) {
            try {
                Result resultM11698a = m11698a(decideMessages.m11707a(), decideMessages.m11711b(), remoteService);
                if (resultM11698a != null) {
                    decideMessages.m11710a(resultM11698a.f11844a, resultM11698a.f11845b, resultM11698a.f11846c, resultM11698a.f11847d);
                }
            } catch (UnintelligibleMessageException e) {
                MPLog.m12031e("MixpanelAPI.DChecker", e.getMessage(), e);
            }
        }
    }

    static class UnintelligibleMessageException extends Exception {
        public UnintelligibleMessageException(String str, JSONException jSONException) {
            super(str, jSONException);
        }
    }

    /* JADX INFO: renamed from: a */
    private Result m11698a(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException, JSONException, UnintelligibleMessageException {
        String strM11701b = m11701b(str, str2, remoteService);
        MPLog.m12021a("MixpanelAPI.DChecker", "Mixpanel decide server response was:\n" + strM11701b);
        if (strM11701b == null) {
            return null;
        }
        Result resultM11697a = m11697a(strM11701b);
        Iterator<InAppNotification> it = resultM11697a.f11844a.iterator();
        while (it.hasNext()) {
            InAppNotification next = it.next();
            Bitmap bitmapM11696a = m11696a(next, this.f11840b);
            if (bitmapM11696a == null) {
                MPLog.m12026c("MixpanelAPI.DChecker", "Could not retrieve image for notification " + next.m11749b() + ", will not show the notification.");
                it.remove();
            } else {
                next.m11748a(bitmapM11696a);
            }
        }
        return resultM11697a;
    }

    /* JADX INFO: renamed from: a */
    static Result m11697a(String str) throws JSONException, UnintelligibleMessageException {
        JSONArray jSONArray;
        Result result = new Result();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("notifications")) {
                jSONArray = null;
            } else {
                try {
                    jSONArray = jSONObject.getJSONArray("notifications");
                } catch (JSONException e) {
                    MPLog.m12030e("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for notifications: " + jSONObject);
                    jSONArray = null;
                }
            }
            if (jSONArray != null) {
                int iMin = Math.min(jSONArray.length(), 2);
                for (int i = 0; i < iMin; i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String string = jSONObject2.getString(ShareConstants.MEDIA_TYPE);
                        if (string.equalsIgnoreCase("takeover")) {
                            result.f11844a.add(new TakeoverInAppNotification(jSONObject2));
                        } else if (string.equalsIgnoreCase("mini")) {
                            result.f11844a.add(new MiniInAppNotification(jSONObject2));
                        }
                    } catch (BadDecideObjectException e2) {
                        MPLog.m12031e("MixpanelAPI.DChecker", "Received a strange response from notifications service: " + jSONArray.toString(), e2);
                    } catch (OutOfMemoryError e3) {
                        MPLog.m12031e("MixpanelAPI.DChecker", "Not enough memory to show load notification from package: " + jSONArray.toString(), e3);
                    } catch (JSONException e4) {
                        MPLog.m12031e("MixpanelAPI.DChecker", "Received a strange response from notifications service: " + jSONArray.toString(), e4);
                    }
                }
            }
            if (jSONObject.has("event_bindings")) {
                try {
                    result.f11845b = jSONObject.getJSONArray("event_bindings");
                } catch (JSONException e5) {
                    MPLog.m12030e("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for event bindings: " + jSONObject);
                }
            }
            if (jSONObject.has("variants")) {
                try {
                    result.f11846c = jSONObject.getJSONArray("variants");
                } catch (JSONException e6) {
                    MPLog.m12030e("MixpanelAPI.DChecker", "Mixpanel endpoint returned non-array JSON for variants: " + jSONObject);
                }
            }
            if (jSONObject.has("automatic_events")) {
                try {
                    result.f11847d = jSONObject.getBoolean("automatic_events");
                } catch (JSONException e7) {
                    MPLog.m12030e("MixpanelAPI.DChecker", "Mixpanel endpoint returned a non boolean value for automatic events: " + jSONObject);
                }
            }
            return result;
        } catch (JSONException e8) {
            throw new UnintelligibleMessageException("Mixpanel endpoint returned unparsable result:\n" + str, e8);
        }
    }

    /* JADX INFO: renamed from: b */
    private String m11701b(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        try {
            String strEncode = URLEncoder.encode(str, "utf-8");
            String strEncode2 = str2 != null ? URLEncoder.encode(str2, "utf-8") : null;
            StringBuilder sbAppend = new StringBuilder().append("?version=1&lib=android&token=").append(strEncode);
            if (strEncode2 != null) {
                sbAppend.append("&distinct_id=").append(strEncode2);
            }
            sbAppend.append("&properties=");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("$android_lib_version", "5.2.1");
                jSONObject.putOpt("$android_app_version", this.f11843e.m11934a());
                jSONObject.putOpt("$android_version", Build.VERSION.RELEASE);
                jSONObject.putOpt("$android_app_release", this.f11843e.m11935b());
                jSONObject.putOpt("$android_device_model", Build.MODEL);
                sbAppend.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
            } catch (Exception e) {
                MPLog.m12031e("MixpanelAPI.DChecker", "Exception constructing properties JSON", e.getCause());
            }
            String str3 = this.f11839a.m11777m() + sbAppend.toString();
            MPLog.m12021a("MixpanelAPI.DChecker", "Querying decide server, url: " + str3);
            byte[] bArrM11700a = m11700a(remoteService, this.f11840b, str3);
            if (bArrM11700a == null) {
                return null;
            }
            try {
                return new String(bArrM11700a, HTTP.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF not supported on this platform?", e2);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m11696a(InAppNotification inAppNotification, Context context) throws RemoteService.ServiceUnavailableException {
        String[] strArr = (inAppNotification.mo11751d() != InAppNotification.Type.TAKEOVER || m11695a(((WindowManager) context.getSystemService("window")).getDefaultDisplay()) < 720) ? new String[]{inAppNotification.m11757j(), inAppNotification.m11756i()} : new String[]{inAppNotification.m11758k(), inAppNotification.m11757j(), inAppNotification.m11756i()};
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            try {
                return this.f11842d.m12016b(str);
            } catch (ImageStore.CantGetImageException e) {
                MPLog.m12022a("MixpanelAPI.DChecker", "Can't load image " + str + " for a notification", e);
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    private static int m11695a(Display display) {
        if (Build.VERSION.SDK_INT < 13) {
            return display.getWidth();
        }
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m11700a(RemoteService remoteService, Context context, String str) throws RemoteService.ServiceUnavailableException {
        MPConfig mPConfigM11762a = MPConfig.m11762a(context);
        if (!remoteService.mo12007a(context, mPConfigM11762a.m11790z())) {
            return null;
        }
        try {
            return remoteService.mo12008a(str, null, mPConfigM11762a.m11789y());
        } catch (FileNotFoundException e) {
            MPLog.m12022a("MixpanelAPI.DChecker", "Cannot get " + str + ", file not found.", e);
            return null;
        } catch (OutOfMemoryError e2) {
            MPLog.m12031e("MixpanelAPI.DChecker", "Out of memory when getting to " + str + FileUtils.HIDDEN_PREFIX, e2);
            return null;
        } catch (MalformedURLException e3) {
            MPLog.m12031e("MixpanelAPI.DChecker", "Cannot interpret " + str + " as a URL.", e3);
            return null;
        } catch (IOException e4) {
            MPLog.m12022a("MixpanelAPI.DChecker", "Cannot get " + str + FileUtils.HIDDEN_PREFIX, e4);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public DecideMessages m11705b(String str) {
        return this.f11841c.get(str);
    }
}
