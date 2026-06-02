package com.mixpanel.android.viewcrawler;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DynamicEventTracker implements ViewVisitor.OnEventListener {

    /* JADX INFO: renamed from: e */
    private static String f12096e = "MixpanelAPI.DynamicEventTracker";

    /* JADX INFO: renamed from: a */
    private final MixpanelAPI f12097a;

    /* JADX INFO: renamed from: b */
    private final Handler f12098b;

    /* JADX INFO: renamed from: d */
    private final Map<Signature, UnsentEvent> f12100d = new HashMap();

    /* JADX INFO: renamed from: c */
    private final Runnable f12099c = new SendDebouncedTask();

    public DynamicEventTracker(MixpanelAPI mixpanelAPI, Handler handler) {
        this.f12097a = mixpanelAPI;
        this.f12098b = handler;
    }

    @Override // com.mixpanel.android.viewcrawler.ViewVisitor.OnEventListener
    /* JADX INFO: renamed from: a */
    public void mo12048a(View view, String str, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$text", m12044a(view));
            jSONObject.put("$from_binding", true);
            jSONObject.put(SkillsJsonParser.TYPE_TIME, jCurrentTimeMillis / 1000);
        } catch (JSONException e) {
            MPLog.m12031e(f12096e, "Can't format properties from view due to JSON issue", e);
        }
        if (z) {
            Signature signature = new Signature(view, str);
            UnsentEvent unsentEvent = new UnsentEvent(str, jSONObject, jCurrentTimeMillis);
            synchronized (this.f12100d) {
                boolean zIsEmpty = this.f12100d.isEmpty();
                this.f12100d.put(signature, unsentEvent);
                if (zIsEmpty) {
                    this.f12098b.postDelayed(this.f12099c, 1000L);
                }
            }
            return;
        }
        this.f12097a.m11836a(str, jSONObject);
    }

    private final class SendDebouncedTask implements Runnable {
        private SendDebouncedTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (DynamicEventTracker.this.f12100d) {
                Iterator it = DynamicEventTracker.this.f12100d.entrySet().iterator();
                while (it.hasNext()) {
                    UnsentEvent unsentEvent = (UnsentEvent) ((Map.Entry) it.next()).getValue();
                    if (jCurrentTimeMillis - unsentEvent.f12103a > 1000) {
                        DynamicEventTracker.this.f12097a.m11836a(unsentEvent.f12104b, unsentEvent.f12105c);
                        it.remove();
                    }
                }
                if (!DynamicEventTracker.this.f12100d.isEmpty()) {
                    DynamicEventTracker.this.f12098b.postDelayed(this, 500L);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m12044a(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text == null) {
                return null;
            }
            return text.toString();
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount && sb.length() < 128; i++) {
            String strM12044a = m12044a(viewGroup.getChildAt(i));
            if (strM12044a != null && strM12044a.length() > 0) {
                if (z) {
                    sb.append(", ");
                }
                sb.append(strM12044a);
                z = true;
            }
        }
        if (sb.length() > 128) {
            return sb.substring(0, 128);
        }
        if (!z) {
            return null;
        }
        return sb.toString();
    }

    private static class Signature {

        /* JADX INFO: renamed from: a */
        private final int f12102a;

        public Signature(View view, String str) {
            this.f12102a = view.hashCode() ^ str.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof Signature) && this.f12102a == obj.hashCode();
        }

        public int hashCode() {
            return this.f12102a;
        }
    }

    private static class UnsentEvent {

        /* JADX INFO: renamed from: a */
        public final long f12103a;

        /* JADX INFO: renamed from: b */
        public final String f12104b;

        /* JADX INFO: renamed from: c */
        public final JSONObject f12105c;

        public UnsentEvent(String str, JSONObject jSONObject, long j) {
            this.f12104b = str;
            this.f12105c = jSONObject;
            this.f12103a = j;
        }
    }
}
