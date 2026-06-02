package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.Base64Coder;
import com.mixpanel.android.util.HttpService;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import com.yalantis.ucrop.util.FileUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class AnalyticsMessages {

    /* JADX INFO: renamed from: d */
    private static final Map<Context, AnalyticsMessages> f11810d = new HashMap();

    /* JADX INFO: renamed from: a */
    protected final Context f11811a;

    /* JADX INFO: renamed from: b */
    protected final MPConfig f11812b;

    /* JADX INFO: renamed from: c */
    private final Worker f11813c = m11664a();

    AnalyticsMessages(Context context) {
        this.f11811a = context;
        this.f11812b = m11671c(context);
        m11670b().mo12006a();
    }

    /* JADX INFO: renamed from: a */
    protected Worker m11664a() {
        return new Worker();
    }

    /* JADX INFO: renamed from: a */
    public static AnalyticsMessages m11659a(Context context) {
        AnalyticsMessages analyticsMessages;
        synchronized (f11810d) {
            Context applicationContext = context.getApplicationContext();
            if (!f11810d.containsKey(applicationContext)) {
                analyticsMessages = new AnalyticsMessages(applicationContext);
                f11810d.put(applicationContext, analyticsMessages);
            } else {
                analyticsMessages = f11810d.get(applicationContext);
            }
        }
        return analyticsMessages;
    }

    /* JADX INFO: renamed from: a */
    public void m11665a(EventDescription eventDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = eventDescription;
        this.f11813c.m11685a(messageObtain);
    }

    /* JADX INFO: renamed from: a */
    public void m11667a(PeopleDescription peopleDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = peopleDescription;
        this.f11813c.m11685a(messageObtain);
    }

    /* JADX INFO: renamed from: a */
    public void m11666a(FlushDescription flushDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = flushDescription.m11676d();
        messageObtain.arg1 = flushDescription.m11675a() ? 1 : 0;
        this.f11813c.m11685a(messageObtain);
    }

    /* JADX INFO: renamed from: a */
    public void m11668a(DecideMessages decideMessages) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 12;
        messageObtain.obj = decideMessages;
        this.f11813c.m11685a(messageObtain);
    }

    /* JADX INFO: renamed from: b */
    protected MPDbAdapter m11669b(Context context) {
        return MPDbAdapter.m11791a(context);
    }

    /* JADX INFO: renamed from: c */
    protected MPConfig m11671c(Context context) {
        return MPConfig.m11762a(context);
    }

    /* JADX INFO: renamed from: b */
    protected RemoteService m11670b() {
        return new HttpService();
    }

    static class EventDescription extends MixpanelDescription {

        /* JADX INFO: renamed from: a */
        private final String f11814a;

        /* JADX INFO: renamed from: b */
        private final JSONObject f11815b;

        /* JADX INFO: renamed from: c */
        private final boolean f11816c;

        public EventDescription(String str, JSONObject jSONObject, String str2, boolean z) {
            super(str2);
            this.f11814a = str;
            this.f11815b = jSONObject;
            this.f11816c = z;
        }

        /* JADX INFO: renamed from: a */
        public String m11672a() {
            return this.f11814a;
        }

        /* JADX INFO: renamed from: b */
        public JSONObject m11673b() {
            return this.f11815b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m11674c() {
            return this.f11816c;
        }
    }

    static class PeopleDescription extends MixpanelDescription {

        /* JADX INFO: renamed from: a */
        private final JSONObject f11819a;

        public PeopleDescription(JSONObject jSONObject, String str) {
            super(str);
            this.f11819a = jSONObject;
        }

        public String toString() {
            return this.f11819a.toString();
        }

        /* JADX INFO: renamed from: a */
        public JSONObject m11677a() {
            return this.f11819a;
        }
    }

    static class FlushDescription extends MixpanelDescription {

        /* JADX INFO: renamed from: a */
        private final boolean f11817a;

        public FlushDescription(String str) {
            this(str, true);
        }

        protected FlushDescription(String str, boolean z) {
            super(str);
            this.f11817a = z;
        }

        /* JADX INFO: renamed from: a */
        public boolean m11675a() {
            return this.f11817a;
        }
    }

    static class MixpanelDescription {

        /* JADX INFO: renamed from: a */
        private final String f11818a;

        public MixpanelDescription(String str) {
            this.f11818a = str;
        }

        /* JADX INFO: renamed from: d */
        public String m11676d() {
            return this.f11818a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11662a(String str) {
        MPLog.m12021a("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11663a(String str, Throwable th) {
        MPLog.m12022a("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")", th);
    }

    class Worker {

        /* JADX INFO: renamed from: g */
        private SystemInformation f11826g;

        /* JADX INFO: renamed from: b */
        private final Object f11821b = new Object();

        /* JADX INFO: renamed from: d */
        private long f11823d = 0;

        /* JADX INFO: renamed from: e */
        private long f11824e = 0;

        /* JADX INFO: renamed from: f */
        private long f11825f = -1;

        /* JADX INFO: renamed from: c */
        private Handler f11822c = m11684a();

        public Worker() {
        }

        /* JADX INFO: renamed from: a */
        public void m11685a(Message message) {
            synchronized (this.f11821b) {
                if (this.f11822c == null) {
                    AnalyticsMessages.this.m11662a("Dead mixpanel worker dropping a message: " + message.what);
                } else {
                    this.f11822c.sendMessage(message);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        protected Handler m11684a() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
            handlerThread.start();
            return new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        class AnalyticsMessageHandler extends Handler {

            /* JADX INFO: renamed from: b */
            private MPDbAdapter f11828b;

            /* JADX INFO: renamed from: c */
            private final DecideChecker f11829c;

            /* JADX INFO: renamed from: d */
            private final long f11830d;

            /* JADX INFO: renamed from: e */
            private long f11831e;

            /* JADX INFO: renamed from: f */
            private long f11832f;

            /* JADX INFO: renamed from: g */
            private int f11833g;

            public AnalyticsMessageHandler(Looper looper) {
                super(looper);
                this.f11828b = null;
                Worker.this.f11826g = SystemInformation.m11933a(AnalyticsMessages.this.f11811a);
                this.f11829c = m11691a();
                this.f11830d = AnalyticsMessages.this.f11812b.m11766b();
            }

            /* JADX INFO: renamed from: a */
            protected DecideChecker m11691a() {
                return new DecideChecker(AnalyticsMessages.this.f11811a, AnalyticsMessages.this.f11812b);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws Throwable {
                String strD;
                JSONException e;
                String str;
                int iM11797a;
                String strD2 = null;
                if (this.f11828b == null) {
                    this.f11828b = AnalyticsMessages.this.m11669b(AnalyticsMessages.this.f11811a);
                    this.f11828b.m11799a(System.currentTimeMillis() - ((long) AnalyticsMessages.this.f11812b.m11767c()), MPDbAdapter.Table.EVENTS);
                    this.f11828b.m11799a(System.currentTimeMillis() - ((long) AnalyticsMessages.this.f11812b.m11767c()), MPDbAdapter.Table.PEOPLE);
                }
                int iM11797a2 = -3;
                try {
                    if (message.what == 0) {
                        PeopleDescription peopleDescription = (PeopleDescription) message.obj;
                        AnalyticsMessages.this.m11662a("Queuing people record for sending later");
                        AnalyticsMessages.this.m11662a("    " + peopleDescription.toString());
                        strD2 = peopleDescription.m11676d();
                        iM11797a2 = this.f11828b.m11797a(peopleDescription.m11677a(), strD2, MPDbAdapter.Table.PEOPLE, false);
                    } else if (message.what == 1) {
                        EventDescription eventDescription = (EventDescription) message.obj;
                        try {
                            JSONObject jSONObjectM11686a = m11686a(eventDescription);
                            AnalyticsMessages.this.m11662a("Queuing event for sending later");
                            AnalyticsMessages.this.m11662a("    " + jSONObjectM11686a.toString());
                            strD = eventDescription.m11676d();
                            try {
                                DecideMessages decideMessagesM11705b = this.f11829c.m11705b(strD);
                                if (decideMessagesM11705b == null || !eventDescription.m11674c() || decideMessagesM11705b.m11714e()) {
                                    iM11797a = this.f11828b.m11797a(jSONObjectM11686a, strD, MPDbAdapter.Table.EVENTS, eventDescription.m11674c());
                                    str = strD;
                                } else {
                                    return;
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                MPLog.m12031e("MixpanelAPI.Messages", "Exception tracking event " + eventDescription.m11672a(), e);
                                str = strD;
                                iM11797a = -3;
                            }
                        } catch (JSONException e3) {
                            strD = null;
                            e = e3;
                        }
                        strD2 = str;
                        iM11797a2 = iM11797a;
                    } else if (message.what == 2) {
                        AnalyticsMessages.this.m11662a("Flushing queue due to scheduled or forced flush");
                        Worker.this.m11682b();
                        String str2 = (String) message.obj;
                        boolean z = message.arg1 == 1;
                        m11687a(this.f11828b, str2);
                        if (z && SystemClock.elapsedRealtime() >= this.f11831e) {
                            try {
                                this.f11829c.m11704a(str2, AnalyticsMessages.this.m11670b());
                            } catch (RemoteService.ServiceUnavailableException e4) {
                                this.f11831e = SystemClock.elapsedRealtime() + ((long) (e4.m12035a() * 1000));
                            }
                        }
                        strD2 = str2;
                    } else if (message.what == 12) {
                        AnalyticsMessages.this.m11662a("Installing a check for in-app notifications");
                        DecideMessages decideMessages = (DecideMessages) message.obj;
                        this.f11829c.m11703a(decideMessages);
                        if (SystemClock.elapsedRealtime() >= this.f11831e) {
                            try {
                                this.f11829c.m11704a(decideMessages.m11707a(), AnalyticsMessages.this.m11670b());
                            } catch (RemoteService.ServiceUnavailableException e5) {
                                this.f11831e = ((long) (e5.m12035a() * 1000)) + SystemClock.elapsedRealtime();
                            }
                        }
                    } else if (message.what == 13) {
                        m11689a((String) message.obj);
                    } else if (message.what == 5) {
                        MPLog.m12028d("MixpanelAPI.Messages", "Worker received a hard kill. Dumping all events and force-killing. Thread id " + Thread.currentThread().getId());
                        synchronized (Worker.this.f11821b) {
                            this.f11828b.m11798a();
                            Worker.this.f11822c = null;
                            Looper.myLooper().quit();
                        }
                    } else {
                        MPLog.m12030e("MixpanelAPI.Messages", "Unexpected message received by Mixpanel worker: " + message);
                    }
                    if ((iM11797a2 >= AnalyticsMessages.this.f11812b.m11765a() || iM11797a2 == -2) && this.f11833g <= 0 && strD2 != null) {
                        AnalyticsMessages.this.m11662a("Flushing queue due to bulk upload limit (" + iM11797a2 + ") for project " + strD2);
                        Worker.this.m11682b();
                        m11687a(this.f11828b, strD2);
                        if (SystemClock.elapsedRealtime() >= this.f11831e) {
                            try {
                                this.f11829c.m11704a(strD2, AnalyticsMessages.this.m11670b());
                                return;
                            } catch (RemoteService.ServiceUnavailableException e6) {
                                this.f11831e = ((long) (e6.m12035a() * 1000)) + SystemClock.elapsedRealtime();
                                return;
                            }
                        }
                        return;
                    }
                    if (iM11797a2 > 0 && !hasMessages(2, strD2)) {
                        AnalyticsMessages.this.m11662a("Queue depth " + iM11797a2 + " - Adding flush in " + this.f11830d);
                        if (this.f11830d >= 0) {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 2;
                            messageObtain.obj = strD2;
                            messageObtain.arg1 = 1;
                            sendMessageDelayed(messageObtain, this.f11830d);
                        }
                    }
                } catch (RuntimeException e7) {
                    MPLog.m12031e("MixpanelAPI.Messages", "Worker threw an unhandled exception", e7);
                    synchronized (Worker.this.f11821b) {
                        Worker.this.f11822c = null;
                        try {
                            Looper.myLooper().quit();
                            MPLog.m12031e("MixpanelAPI.Messages", "Mixpanel will not process any more analytics messages", e7);
                        } catch (Exception e8) {
                            MPLog.m12031e("MixpanelAPI.Messages", "Could not halt looper", e8);
                        }
                    }
                }
            }

            /* JADX INFO: renamed from: a */
            private void m11689a(String str) {
                try {
                    try {
                        if (GoogleApiAvailability.m6828a().mo6834a(AnalyticsMessages.this.f11811a) != 0) {
                            MPLog.m12026c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play Services are not installed.");
                        } else {
                            final String strM7609b = InstanceID.m7604c(AnalyticsMessages.this.f11811a).m7609b(str, "GCM", null);
                            MixpanelAPI.m11818a(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.1
                                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
                                /* JADX INFO: renamed from: a */
                                public void mo11692a(MixpanelAPI mixpanelAPI) {
                                    MPLog.m12021a("MixpanelAPI.Messages", "Using existing pushId " + strM7609b);
                                    mixpanelAPI.m11842c().mo11869b(strM7609b);
                                }
                            });
                        }
                    } catch (RuntimeException e) {
                        MPLog.m12026c("MixpanelAPI.Messages", "Can't register for push notifications, Google Play services are not configured.");
                    }
                } catch (IOException e2) {
                    MPLog.m12027c("MixpanelAPI.Messages", "Exception when trying to register for GCM", e2);
                } catch (NoClassDefFoundError e3) {
                    MPLog.m12028d("MixpanelAPI.Messages", "Google play services were not part of this build, push notifications cannot be registered or delivered");
                }
            }

            /* JADX INFO: renamed from: a */
            private void m11687a(MPDbAdapter mPDbAdapter, String str) throws Throwable {
                if (!AnalyticsMessages.this.m11670b().mo12007a(AnalyticsMessages.this.f11811a, AnalyticsMessages.this.f11812b.m11790z())) {
                    AnalyticsMessages.this.m11662a("Not flushing data to Mixpanel because the device is not connected to the internet.");
                } else {
                    m11688a(mPDbAdapter, str, MPDbAdapter.Table.EVENTS, AnalyticsMessages.this.f11812b.m11775k());
                    m11688a(mPDbAdapter, str, MPDbAdapter.Table.PEOPLE, AnalyticsMessages.this.f11812b.m11776l());
                }
            }

            /* JADX INFO: renamed from: a */
            private void m11688a(MPDbAdapter mPDbAdapter, String str, MPDbAdapter.Table table, String str2) throws Throwable {
                boolean z;
                RemoteService remoteServiceM11670b = AnalyticsMessages.this.m11670b();
                DecideMessages decideMessagesM11705b = this.f11829c.m11705b(str);
                boolean z2 = true;
                if (decideMessagesM11705b == null || decideMessagesM11705b.m11713d() == null) {
                    z2 = false;
                }
                String[] strArrM11802a = mPDbAdapter.m11802a(table, str, z2);
                Integer numValueOf = 0;
                if (strArrM11802a != null) {
                    numValueOf = Integer.valueOf(strArrM11802a[2]);
                }
                while (strArrM11802a != null && numValueOf.intValue() > 0) {
                    String str3 = strArrM11802a[0];
                    String str4 = strArrM11802a[1];
                    String strM11999a = Base64Coder.m11999a(str4);
                    HashMap map = new HashMap();
                    map.put(ShareConstants.WEB_DIALOG_PARAM_DATA, strM11999a);
                    if (MPConfig.f11915a) {
                        map.put("verbose", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    }
                    boolean z3 = true;
                    try {
                        try {
                            byte[] bArrMo12008a = remoteServiceM11670b.mo12008a(str2, map, AnalyticsMessages.this.f11812b.m11789y());
                            if (bArrMo12008a == null) {
                                z = false;
                                try {
                                    AnalyticsMessages.this.m11662a("Response was null, unexpected failure posting to " + str2 + FileUtils.HIDDEN_PREFIX);
                                } catch (OutOfMemoryError e) {
                                    z3 = z;
                                    e = e;
                                    MPLog.m12031e("MixpanelAPI.Messages", "Out of memory when posting to " + str2 + FileUtils.HIDDEN_PREFIX, e);
                                } catch (MalformedURLException e2) {
                                    z3 = z;
                                    e = e2;
                                    MPLog.m12031e("MixpanelAPI.Messages", "Cannot interpret " + str2 + " as a URL.", e);
                                }
                            } else {
                                z = true;
                                try {
                                    String str5 = new String(bArrMo12008a, HTTP.UTF_8);
                                    if (this.f11833g > 0) {
                                        this.f11833g = 0;
                                        removeMessages(2, str);
                                    }
                                    AnalyticsMessages.this.m11662a("Successfully posted to " + str2 + ": \n" + str4);
                                    AnalyticsMessages.this.m11662a("Response was " + str5);
                                } catch (UnsupportedEncodingException e3) {
                                    throw new RuntimeException("UTF not supported on this platform?", e3);
                                }
                            }
                            z3 = z;
                        } catch (OutOfMemoryError e4) {
                            e = e4;
                        } catch (MalformedURLException e5) {
                            e = e5;
                        }
                    } catch (RemoteService.ServiceUnavailableException e6) {
                        AnalyticsMessages.this.m11663a("Cannot post message to " + str2 + FileUtils.HIDDEN_PREFIX, e6);
                        z3 = false;
                        this.f11832f = e6.m12035a() * 1000;
                    } catch (SocketTimeoutException e7) {
                        AnalyticsMessages.this.m11663a("Cannot post message to " + str2 + FileUtils.HIDDEN_PREFIX, e7);
                        z3 = false;
                    } catch (IOException e8) {
                        AnalyticsMessages.this.m11663a("Cannot post message to " + str2 + FileUtils.HIDDEN_PREFIX, e8);
                        z3 = false;
                    }
                    if (z3) {
                        AnalyticsMessages.this.m11662a("Not retrying this batch of events, deleting them from DB.");
                        mPDbAdapter.m11801a(str3, table, str, z2);
                        String[] strArrM11802a2 = mPDbAdapter.m11802a(table, str, z2);
                        numValueOf = strArrM11802a2 != null ? Integer.valueOf(strArrM11802a2[2]) : numValueOf;
                        strArrM11802a = strArrM11802a2;
                    } else {
                        removeMessages(2, str);
                        this.f11832f = Math.max(((long) Math.pow(2.0d, this.f11833g)) * 60000, this.f11832f);
                        this.f11832f = Math.min(this.f11832f, 600000L);
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 2;
                        messageObtain.obj = str;
                        sendMessageDelayed(messageObtain, this.f11832f);
                        this.f11833g++;
                        AnalyticsMessages.this.m11662a("Retrying this batch of events in " + this.f11832f + " ms");
                        return;
                    }
                }
            }

            /* JADX INFO: renamed from: b */
            private JSONObject m11690b() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mp_lib", "android");
                jSONObject.put("$lib_version", "5.2.1");
                jSONObject.put("$os", "Android");
                jSONObject.put("$os_version", Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE);
                jSONObject.put("$manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
                jSONObject.put("$brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
                jSONObject.put("$model", Build.MODEL == null ? "UNKNOWN" : Build.MODEL);
                try {
                    try {
                        switch (GoogleApiAvailability.m6828a().mo6834a(AnalyticsMessages.this.f11811a)) {
                            case 0:
                                jSONObject.put("$google_play_services", "available");
                                break;
                            case 1:
                                jSONObject.put("$google_play_services", "missing");
                                break;
                            case 2:
                                jSONObject.put("$google_play_services", "out of date");
                                break;
                            case 3:
                                jSONObject.put("$google_play_services", "disabled");
                                break;
                            case 9:
                                jSONObject.put("$google_play_services", "invalid");
                                break;
                        }
                    } catch (RuntimeException e) {
                        jSONObject.put("$google_play_services", "not configured");
                    }
                } catch (NoClassDefFoundError e2) {
                    jSONObject.put("$google_play_services", "not included");
                }
                DisplayMetrics displayMetricsM11939f = Worker.this.f11826g.m11939f();
                jSONObject.put("$screen_dpi", displayMetricsM11939f.densityDpi);
                jSONObject.put("$screen_height", displayMetricsM11939f.heightPixels);
                jSONObject.put("$screen_width", displayMetricsM11939f.widthPixels);
                String strM11934a = Worker.this.f11826g.m11934a();
                if (strM11934a != null) {
                    jSONObject.put("$app_version", strM11934a);
                    jSONObject.put("$app_version_string", strM11934a);
                }
                Integer numM11935b = Worker.this.f11826g.m11935b();
                if (numM11935b != null) {
                    jSONObject.put("$app_release", numM11935b);
                    jSONObject.put("$app_build_number", numM11935b);
                }
                Boolean boolValueOf = Boolean.valueOf(Worker.this.f11826g.m11937d());
                if (boolValueOf != null) {
                    jSONObject.put("$has_nfc", boolValueOf.booleanValue());
                }
                Boolean boolValueOf2 = Boolean.valueOf(Worker.this.f11826g.m11938e());
                if (boolValueOf2 != null) {
                    jSONObject.put("$has_telephone", boolValueOf2.booleanValue());
                }
                String strM11940g = Worker.this.f11826g.m11940g();
                if (strM11940g != null) {
                    jSONObject.put("$carrier", strM11940g);
                }
                Boolean boolM11941h = Worker.this.f11826g.m11941h();
                if (boolM11941h != null) {
                    jSONObject.put("$wifi", boolM11941h.booleanValue());
                }
                Boolean boolM11942i = Worker.this.f11826g.m11942i();
                if (boolM11942i != null) {
                    jSONObject.put("$bluetooth_enabled", boolM11942i);
                }
                String strM11943j = Worker.this.f11826g.m11943j();
                if (strM11943j != null) {
                    jSONObject.put("$bluetooth_version", strM11943j);
                }
                return jSONObject;
            }

            /* JADX INFO: renamed from: a */
            private JSONObject m11686a(EventDescription eventDescription) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectM11673b = eventDescription.m11673b();
                JSONObject jSONObjectM11690b = m11690b();
                jSONObjectM11690b.put("token", eventDescription.m11676d());
                if (jSONObjectM11673b != null) {
                    Iterator<String> itKeys = jSONObjectM11673b.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectM11690b.put(next, jSONObjectM11673b.get(next));
                    }
                }
                jSONObject.put("event", eventDescription.m11672a());
                jSONObject.put("properties", jSONObjectM11690b);
                return jSONObject;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public void m11682b() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f11823d + 1;
            if (this.f11825f > 0) {
                this.f11824e = ((jCurrentTimeMillis - this.f11825f) + (this.f11824e * this.f11823d)) / j;
                AnalyticsMessages.this.m11662a("Average send frequency approximately " + (this.f11824e / 1000) + " seconds.");
            }
            this.f11825f = jCurrentTimeMillis;
            this.f11823d = j;
        }
    }
}
