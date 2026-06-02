package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.CrashPromptDialog;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler;
import com.crashlytics.android.core.LogFileManager;
import com.crashlytics.android.core.ReportUploader;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class CrashlyticsController {

    /* JADX INFO: renamed from: a */
    static final FilenameFilter f5170a = new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsController.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    };

    /* JADX INFO: renamed from: b */
    static final Comparator<File> f5171b = new Comparator<File>() { // from class: com.crashlytics.android.core.CrashlyticsController.2
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };

    /* JADX INFO: renamed from: c */
    static final Comparator<File> f5172c = new Comparator<File>() { // from class: com.crashlytics.android.core.CrashlyticsController.3
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };

    /* JADX INFO: renamed from: d */
    static final FilenameFilter f5173d = new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsController.4
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return CrashlyticsController.f5174e.matcher(str).matches();
        }
    };

    /* JADX INFO: renamed from: e */
    private static final Pattern f5174e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* JADX INFO: renamed from: f */
    private static final Map<String, String> f5175f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);

    /* JADX INFO: renamed from: g */
    private static final String[] f5176g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* JADX INFO: renamed from: h */
    private final AtomicInteger f5177h = new AtomicInteger(0);

    /* JADX INFO: renamed from: i */
    private final CrashlyticsCore f5178i;

    /* JADX INFO: renamed from: j */
    private final CrashlyticsBackgroundWorker f5179j;

    /* JADX INFO: renamed from: k */
    private final HttpRequestFactory f5180k;

    /* JADX INFO: renamed from: l */
    private final IdManager f5181l;

    /* JADX INFO: renamed from: m */
    private final PreferenceManager f5182m;

    /* JADX INFO: renamed from: n */
    private final FileStore f5183n;

    /* JADX INFO: renamed from: o */
    private final AppData f5184o;

    /* JADX INFO: renamed from: p */
    private final LogFileDirectoryProvider f5185p;

    /* JADX INFO: renamed from: q */
    private final LogFileManager f5186q;

    /* JADX INFO: renamed from: r */
    private final ReportUploader.ReportFilesProvider f5187r;

    /* JADX INFO: renamed from: s */
    private final ReportUploader.HandlingExceptionCheck f5188s;

    /* JADX INFO: renamed from: t */
    private final DevicePowerStateListener f5189t;

    /* JADX INFO: renamed from: u */
    private final StackTraceTrimmingStrategy f5190u;

    /* JADX INFO: renamed from: v */
    private final String f5191v;

    /* JADX INFO: renamed from: w */
    private CrashlyticsUncaughtExceptionHandler f5192w;

    static class FileNameContainsFilter implements FilenameFilter {

        /* JADX INFO: renamed from: a */
        private final String f5210a;

        public FileNameContainsFilter(String str) {
            this.f5210a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f5210a) && !str.endsWith(".cls_temp");
        }
    }

    static class SessionPartFileFilter implements FilenameFilter {

        /* JADX INFO: renamed from: a */
        private final String f5223a;

        public SessionPartFileFilter(String str) {
            this.f5223a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return (str.equals(new StringBuilder().append(this.f5223a).append(".cls").toString()) || !str.contains(this.f5223a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    private static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !CrashlyticsController.f5170a.accept(file, str) && CrashlyticsController.f5174e.matcher(str).matches();
        }
    }

    static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ClsFileOutputStream.f5148a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    CrashlyticsController(CrashlyticsCore crashlyticsCore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, PreferenceManager preferenceManager, FileStore fileStore, AppData appData, UnityVersionProvider unityVersionProvider) {
        this.f5178i = crashlyticsCore;
        this.f5179j = crashlyticsBackgroundWorker;
        this.f5180k = httpRequestFactory;
        this.f5181l = idManager;
        this.f5182m = preferenceManager;
        this.f5183n = fileStore;
        this.f5184o = appData;
        this.f5191v = unityVersionProvider.mo5927a();
        Context contextR = crashlyticsCore.m15121r();
        this.f5185p = new LogFileDirectoryProvider(fileStore);
        this.f5186q = new LogFileManager(contextR, this.f5185p);
        this.f5187r = new ReportUploaderFilesProvider();
        this.f5188s = new ReportUploaderHandlingExceptionCheck();
        this.f5189t = new DevicePowerStateListener(contextR);
        this.f5190u = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
    }

    /* JADX INFO: renamed from: a */
    void m5836a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        m5832a();
        this.f5192w = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() { // from class: com.crashlytics.android.core.CrashlyticsController.5
            @Override // com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.CrashListener
            /* JADX INFO: renamed from: a */
            public void mo5855a(Thread thread, Throwable th) {
                CrashlyticsController.this.m5837a(thread, th);
            }
        }, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.f5192w);
    }

    /* JADX INFO: renamed from: a */
    synchronized void m5837a(final Thread thread, final Throwable th) {
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.f5189t.m5902b();
        final Date date = new Date();
        this.f5179j.m5779a(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                CrashlyticsController.this.f5178i.m5880o();
                CrashlyticsController.this.m5800a(date, thread, th);
                SettingsData settingsDataM15458b = Settings.m15455a().m15458b();
                SessionSettingsData sessionSettingsData = settingsDataM15458b != null ? settingsDataM15458b.f14788b : null;
                CrashlyticsController.this.m5840b(sessionSettingsData);
                CrashlyticsController.this.m5829m();
                if (sessionSettingsData != null) {
                    CrashlyticsController.this.m5834a(sessionSettingsData.f14781g);
                }
                if (!CrashlyticsController.this.m5804a(settingsDataM15458b)) {
                    CrashlyticsController.this.m5814b(settingsDataM15458b);
                }
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m5833a(float f, SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.m15085h().mo15070d("CrashlyticsCore", "Could not send reports. Settings are not available.");
        } else {
            new ReportUploader(this.f5184o.f5137a, m5825h(settingsData.f14787a.f14747d), this.f5187r, this.f5188s).m5965a(f, m5804a(settingsData) ? new PrivacyDialogCheck(this.f5178i, this.f5182m, settingsData.f14789c) : new ReportUploader.AlwaysSendCheck());
        }
    }

    /* JADX INFO: renamed from: b */
    void m5841b(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.f5179j.m5780a(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsController.8
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!CrashlyticsController.this.m5845e()) {
                    CrashlyticsController.this.m5816b(date, thread, th);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m5832a() {
        this.f5179j.m5781b(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.11
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                CrashlyticsController.this.m5829m();
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: k */
    private String m5827k() {
        File[] fileArrM5830n = m5830n();
        if (fileArrM5830n.length > 0) {
            return m5783a(fileArrM5830n[0]);
        }
        return null;
    }

    /* JADX INFO: renamed from: l */
    private String m5828l() {
        File[] fileArrM5830n = m5830n();
        if (fileArrM5830n.length > 1) {
            return m5783a(fileArrM5830n[1]);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    static String m5783a(File file) {
        return file.getName().substring(0, 35);
    }

    /* JADX INFO: renamed from: a */
    boolean m5839a(final SessionSettingsData sessionSettingsData) {
        return ((Boolean) this.f5179j.m5779a(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsController.12
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                if (CrashlyticsController.this.m5845e()) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Finalizing previously open sessions.");
                CrashlyticsController.this.m5792a(sessionSettingsData, true);
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public void m5829m() throws Exception {
        Date date = new Date();
        String string = new CLSUUID(this.f5181l).toString();
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Opening a new session with ID " + string);
        m5799a(string, date);
        m5820c(string);
        m5821d(string);
        m5822e(string);
        this.f5186q.m5924a(string);
    }

    /* JADX INFO: renamed from: b */
    void m5840b(SessionSettingsData sessionSettingsData) throws Exception {
        m5792a(sessionSettingsData, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m5792a(SessionSettingsData sessionSettingsData, boolean z) throws Exception {
        int i = z ? 1 : 0;
        m5809b(i + 8);
        File[] fileArrM5830n = m5830n();
        if (fileArrM5830n.length <= i) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        m5823f(m5783a(fileArrM5830n[i]));
        if (sessionSettingsData == null) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            m5801a(fileArrM5830n, i, sessionSettingsData.f14777c);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5801a(File[] fileArr, int i, int i2) throws Throwable {
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String strM5783a = m5783a(file);
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Closing session: " + strM5783a);
            m5793a(file, strM5783a, i2);
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5784a(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.m5721a();
            } catch (IOException e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5796a(String str) {
        for (File file : m5818b(str)) {
            file.delete();
        }
    }

    /* JADX INFO: renamed from: b */
    private File[] m5818b(String str) {
        return m5807a(new SessionPartFileFilter(str));
    }

    /* JADX INFO: renamed from: b */
    File[] m5842b() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, m5806a(m5847g(), f5170a));
        Collections.addAll(linkedList, m5806a(m5848h(), f5170a));
        Collections.addAll(linkedList, m5806a(m5846f(), f5170a));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* JADX INFO: renamed from: c */
    File[] m5843c() {
        return m5807a(new FileNameContainsFilter("BeginSession"));
    }

    /* JADX INFO: renamed from: n */
    private File[] m5830n() {
        File[] fileArrM5843c = m5843c();
        Arrays.sort(fileArrM5843c, f5171b);
        return fileArrM5843c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public File[] m5807a(FilenameFilter filenameFilter) {
        return m5806a(m5846f(), filenameFilter);
    }

    /* JADX INFO: renamed from: a */
    private File[] m5806a(File file, FilenameFilter filenameFilter) {
        return m5819b(file.listFiles(filenameFilter));
    }

    /* JADX INFO: renamed from: b */
    private File[] m5817b(File file) {
        return m5819b(file.listFiles());
    }

    /* JADX INFO: renamed from: b */
    private File[] m5819b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* JADX INFO: renamed from: a */
    private void m5797a(String str, int i) {
        Utils.m6002a(m5846f(), new FileNameContainsFilter(str + "SessionEvent"), i, f5172c);
    }

    /* JADX INFO: renamed from: a */
    void m5834a(int i) {
        int iM6001a = i - Utils.m6001a(m5847g(), i, f5172c);
        Utils.m6002a(m5846f(), f5170a, iM6001a - Utils.m6001a(m5848h(), iM6001a, f5172c), f5172c);
    }

    /* JADX INFO: renamed from: b */
    private void m5809b(int i) {
        HashSet hashSet = new HashSet();
        File[] fileArrM5830n = m5830n();
        int iMin = Math.min(i, fileArrM5830n.length);
        for (int i2 = 0; i2 < iMin; i2++) {
            hashSet.add(m5783a(fileArrM5830n[i2]));
        }
        this.f5186q.m5925a(hashSet);
        m5802a(m5807a(new AnySessionPartFileFilter()), hashSet);
    }

    /* JADX INFO: renamed from: a */
    private void m5802a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f5174e.matcher(name);
            if (!matcher.matches()) {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
                return;
            } else {
                if (!set.contains(matcher.group(1))) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Trimming session file: " + name);
                    file.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private File[] m5808a(String str, File[] fileArr, int i) {
        if (fileArr.length > i) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
            m5797a(str, i);
            return m5807a(new FileNameContainsFilter(str + "SessionEvent"));
        }
        return fileArr;
    }

    /* JADX INFO: renamed from: d */
    void m5844d() {
        this.f5179j.m5780a(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsController.13
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsController.this.m5838a(CrashlyticsController.this.m5807a(new InvalidPartFileFilter()));
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m5838a(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Found invalid session part file: " + file);
            hashSet.add(m5783a(file));
        }
        if (!hashSet.isEmpty()) {
            File fileM5849i = m5849i();
            if (!fileM5849i.exists()) {
                fileM5849i.mkdir();
            }
            for (File file2 : m5807a(new FilenameFilter() { // from class: com.crashlytics.android.core.CrashlyticsController.14
                @Override // java.io.FilenameFilter
                public boolean accept(File file3, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Moving session file: " + file2);
                if (!file2.renameTo(new File(fileM5849i, file2.getName()))) {
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                    file2.delete();
                }
            }
            m5831o();
        }
    }

    /* JADX INFO: renamed from: o */
    private void m5831o() {
        File fileM5849i = m5849i();
        if (fileM5849i.exists()) {
            File[] fileArrM5806a = m5806a(fileM5849i, new InvalidPartFileFilter());
            Arrays.sort(fileArrM5806a, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i = 0; i < fileArrM5806a.length && hashSet.size() < 4; i++) {
                hashSet.add(m5783a(fileArrM5806a[i]));
            }
            m5802a(m5817b(fileM5849i), hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX INFO: renamed from: a */
    public void m5800a(Date date, Thread thread, Throwable th) throws Throwable {
        ?? r2;
        CodedOutputStream codedOutputStreamM5722a = null;
        try {
            String strM5827k = m5827k();
            if (strM5827k == null) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.m15189a((Flushable) null, "Failed to flush to session begin file.");
                CommonUtils.m15188a((Closeable) null, "Failed to close fatal exception file output stream.");
            } else {
                m5815b(strM5827k, th.getClass().getName());
                ClsFileOutputStream clsFileOutputStream = new ClsFileOutputStream(m5846f(), strM5827k + "SessionCrash");
                try {
                    codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream);
                    m5787a(codedOutputStreamM5722a, date, thread, th, AppMeasurement.CRASH_ORIGIN, true);
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                    CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                } catch (Exception e) {
                    e = e;
                    r2 = clsFileOutputStream;
                    try {
                        Fabric.m15085h().mo15073e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                        CommonUtils.m15188a((Closeable) r2, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                        CommonUtils.m15188a((Closeable) r2, "Failed to close fatal exception file output stream.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r2 = clsFileOutputStream;
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                    CommonUtils.m15188a((Closeable) r2, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            r2 = codedOutputStreamM5722a;
        } catch (Throwable th4) {
            th = th4;
            r2 = codedOutputStreamM5722a;
        }
    }

    /* JADX INFO: renamed from: a */
    void m5835a(final SessionEventData sessionEventData) {
        this.f5179j.m5781b(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsController.15
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                if (!CrashlyticsController.this.m5845e()) {
                    CrashlyticsController.this.m5813b(sessionEventData);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m5813b(SessionEventData sessionEventData) throws Throwable {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStreamM5722a = null;
        try {
            String strM5828l = m5828l();
            if (strM5828l == null) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                CommonUtils.m15189a((Flushable) null, "Failed to flush to session begin file.");
                CommonUtils.m15188a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            m5815b(strM5828l, String.format(Locale.US, "<native-crash [%s (%s)]>", sessionEventData.f5365b.f5371b, sessionEventData.f5365b.f5370a));
            clsFileOutputStream = new ClsFileOutputStream(m5846f(), strM5828l + (sessionEventData.f5367d != null && sessionEventData.f5367d.length > 0 ? "SessionCrash" : "SessionMissingBinaryImages"));
            try {
                try {
                    codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream);
                    NativeCrashWriter.m5942a(sessionEventData, new LogFileManager(this.f5178i.m15121r(), this.f5185p, strM5828l), new MetaDataStore(m5846f()).m5934b(strM5828l), codedOutputStreamM5722a);
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                    CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                } catch (Exception e) {
                    e = e;
                    Fabric.m15085h().mo15073e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                    CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
            CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m5816b(Date date, Thread thread, Throwable th) throws Throwable {
        ClsFileOutputStream clsFileOutputStream;
        ClsFileOutputStream clsFileOutputStream2;
        CodedOutputStream codedOutputStreamM5722a = null;
        String strM5827k = m5827k();
        if (strM5827k == null) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        m5798a(strM5827k, th.getClass().getName());
        try {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            clsFileOutputStream2 = new ClsFileOutputStream(m5846f(), strM5827k + "SessionEvent" + CommonUtils.m15175a(this.f5177h.getAndIncrement()));
        } catch (Exception e) {
            e = e;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
        try {
            codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream2);
            m5787a(codedOutputStreamM5722a, date, thread, th, "error", false);
            CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to non-fatal file.");
            CommonUtils.m15188a((Closeable) clsFileOutputStream2, "Failed to close non-fatal file output stream.");
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = clsFileOutputStream2;
            try {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to non-fatal file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
            } catch (Throwable th3) {
                th = th3;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to non-fatal file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            clsFileOutputStream = clsFileOutputStream2;
            CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to non-fatal file.");
            CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw th;
        }
        try {
            m5797a(strM5827k, 64);
        } catch (Exception e3) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5799a(String str, Date date) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStreamM5722a = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5846f(), str + "BeginSession");
            try {
                codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream);
                SessionProtobufHelper.m5993a(codedOutputStreamM5722a, str, String.format(Locale.US, "Crashlytics Android SDK/%s", this.f5178i.mo5600a()), date.getTime() / 1000);
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close begin session file.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session begin file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m5820c(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStreamM5722a;
        CodedOutputStream codedOutputStream = null;
        try {
            ClsFileOutputStream clsFileOutputStream2 = new ClsFileOutputStream(m5846f(), str + "SessionApp");
            try {
                codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream2);
            } catch (Throwable th) {
                th = th;
                clsFileOutputStream = clsFileOutputStream2;
            }
            try {
                SessionProtobufHelper.m5995a(codedOutputStreamM5722a, this.f5181l.m15227c(), this.f5184o.f5137a, this.f5184o.f5141e, this.f5184o.f5142f, this.f5181l.m15226b(), DeliveryMechanism.determineFrom(this.f5184o.f5139c).getId(), this.f5191v);
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session app file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream2, "Failed to close session app file.");
            } catch (Throwable th2) {
                clsFileOutputStream = clsFileOutputStream2;
                th = th2;
                codedOutputStream = codedOutputStreamM5722a;
                CommonUtils.m15189a(codedOutputStream, "Failed to flush to session app file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            clsFileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m5821d(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStreamM5722a = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5846f(), str + "SessionOS");
            try {
                codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream);
                SessionProtobufHelper.m5998a(codedOutputStreamM5722a, CommonUtils.m15204g(this.f5178i.m15121r()));
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session OS file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session OS file.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush to session OS file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m5822e(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream = null;
        CodedOutputStream codedOutputStreamM5722a = null;
        try {
            ClsFileOutputStream clsFileOutputStream2 = new ClsFileOutputStream(m5846f(), str + "SessionDevice");
            try {
                codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream2);
                Context contextR = this.f5178i.m15121r();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                SessionProtobufHelper.m5992a(codedOutputStreamM5722a, this.f5181l.m15232h(), CommonUtils.m15169a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.m15192b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.m15203f(contextR), this.f5181l.m15233i(), CommonUtils.m15205h(contextR), Build.MANUFACTURER, Build.PRODUCT);
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush session device info.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream2, "Failed to close session device file.");
            } catch (Throwable th) {
                th = th;
                clsFileOutputStream = clsFileOutputStream2;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush session device info.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m5823f(String str) throws Exception {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStreamM5722a = null;
        try {
            clsFileOutputStream = new ClsFileOutputStream(m5846f(), str + "SessionUser");
            try {
                codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream);
                UserMetaData userMetaDataM5824g = m5824g(str);
                if (userMetaDataM5824g.m6000a()) {
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush session user file.");
                    CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session user file.");
                } else {
                    SessionProtobufHelper.m5994a(codedOutputStreamM5722a, userMetaDataM5824g.f5342b, userMetaDataM5824g.f5343c, userMetaDataM5824g.f5344d);
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush session user file.");
                    CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session user file.");
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Failed to flush session user file.");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5787a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        Thread[] threadArr;
        Map<String, String> treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.f5190u);
        Context contextR = this.f5178i.m15121r();
        long time = date.getTime() / 1000;
        Float fM15197c = CommonUtils.m15197c(contextR);
        int iM15171a = CommonUtils.m15171a(contextR, this.f5189t.m5901a());
        boolean zM15201d = CommonUtils.m15201d(contextR);
        int i = contextR.getResources().getConfiguration().orientation;
        long jM15192b = CommonUtils.m15192b() - CommonUtils.m15193b(contextR);
        long jM15194b = CommonUtils.m15194b(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoM15173a = CommonUtils.m15173a(contextR.getPackageName(), contextR);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f5339c;
        String str2 = this.f5184o.f5138b;
        String strM15227c = this.f5181l.m15227c();
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Thread, StackTraceElement[]> next = it.next();
                threadArr[i3] = next.getKey();
                linkedList.add(this.f5190u.mo5935a(next.getValue()));
                i2 = i3 + 1;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (!CommonUtils.m15191a(contextR, "com.crashlytics.CollectCustomKeys", true)) {
            treeMap = new TreeMap<>();
        } else {
            Map<String, String> mapM5872g = this.f5178i.m5872g();
            treeMap = (mapM5872g == null || mapM5872g.size() <= 1) ? mapM5872g : new TreeMap<>(mapM5872g);
        }
        SessionProtobufHelper.m5986a(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.f5186q, runningAppProcessInfoM15173a, i, strM15227c, str2, fM15197c, iM15171a, zM15201d, jM15192b, jM15194b);
    }

    /* JADX INFO: renamed from: a */
    private void m5793a(File file, String str, int i) throws Throwable {
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] fileArrM5807a = m5807a(new FileNameContainsFilter(str + "SessionCrash"));
        boolean z = fileArrM5807a != null && fileArrM5807a.length > 0;
        Fabric.m15085h().mo15063a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] fileArrM5807a2 = m5807a(new FileNameContainsFilter(str + "SessionEvent"));
        boolean z2 = fileArrM5807a2 != null && fileArrM5807a2.length > 0;
        Fabric.m15085h().mo15063a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            m5794a(file, str, m5808a(str, fileArrM5807a2, i), z ? fileArrM5807a[0] : null);
        } else {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "No events present for session ID " + str);
        }
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Removing session part files for ID " + str);
        m5796a(str);
    }

    /* JADX INFO: renamed from: a */
    private void m5794a(File file, String str, File[] fileArr, File file2) throws Throwable {
        ClsFileOutputStream clsFileOutputStream;
        CodedOutputStream codedOutputStreamM5722a = null;
        boolean z = file2 != null;
        File fileM5847g = z ? m5847g() : m5848h();
        if (!fileM5847g.exists()) {
            fileM5847g.mkdirs();
        }
        try {
            clsFileOutputStream = new ClsFileOutputStream(fileM5847g, str);
            try {
                try {
                    codedOutputStreamM5722a = CodedOutputStream.m5722a(clsFileOutputStream);
                    Fabric.m15085h().mo15063a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                    m5785a(codedOutputStreamM5722a, file);
                    codedOutputStreamM5722a.m5749a(4, new Date().getTime() / 1000);
                    codedOutputStreamM5722a.m5751a(5, z);
                    codedOutputStreamM5722a.m5748a(11, 1);
                    codedOutputStreamM5722a.m5759b(12, 3);
                    m5786a(codedOutputStreamM5722a, str);
                    m5788a(codedOutputStreamM5722a, fileArr, str);
                    if (z) {
                        m5785a(codedOutputStreamM5722a, file2);
                    }
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Error flushing session file stream");
                    CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close CLS file");
                } catch (Exception e) {
                    e = e;
                    Fabric.m15085h().mo15073e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    CommonUtils.m15189a(codedOutputStreamM5722a, "Error flushing session file stream");
                    m5784a(clsFileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15189a(codedOutputStreamM5722a, "Error flushing session file stream");
                CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            clsFileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            clsFileOutputStream = null;
            CommonUtils.m15189a(codedOutputStreamM5722a, "Error flushing session file stream");
            CommonUtils.m15188a((Closeable) clsFileOutputStream, "Failed to close CLS file");
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5788a(CodedOutputStream codedOutputStream, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, CommonUtils.f14568a);
        for (File file : fileArr) {
            try {
                Fabric.m15085h().mo15063a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                m5785a(codedOutputStream, file);
            } catch (Exception e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5786a(CodedOutputStream codedOutputStream, String str) throws Throwable {
        for (String str2 : f5176g) {
            File[] fileArrM5807a = m5807a(new FileNameContainsFilter(str + str2));
            if (fileArrM5807a.length == 0) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                m5785a(codedOutputStream, fileArrM5807a[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5785a(CodedOutputStream codedOutputStream, File file) throws Throwable {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                m5795a(fileInputStream, codedOutputStream, (int) file.length());
                CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5795a(InputStream inputStream, CodedOutputStream codedOutputStream, int i) throws IOException {
        int i2;
        byte[] bArr = new byte[i];
        int i3 = 0;
        while (i3 < bArr.length && (i2 = inputStream.read(bArr, i3, bArr.length - i3)) >= 0) {
            i3 += i2;
        }
        codedOutputStream.m5756a(bArr);
    }

    /* JADX INFO: renamed from: g */
    private UserMetaData m5824g(String str) {
        return m5845e() ? new UserMetaData(this.f5178i.m5873h(), this.f5178i.m5875j(), this.f5178i.m5874i()) : new MetaDataStore(m5846f()).m5933a(str);
    }

    /* JADX INFO: renamed from: e */
    boolean m5845e() {
        return this.f5192w != null && this.f5192w.m5896a();
    }

    /* JADX INFO: renamed from: f */
    File m5846f() {
        return this.f5183n.mo15418a();
    }

    /* JADX INFO: renamed from: g */
    File m5847g() {
        return new File(m5846f(), "fatal-sessions");
    }

    /* JADX INFO: renamed from: h */
    File m5848h() {
        return new File(m5846f(), "nonfatal-sessions");
    }

    /* JADX INFO: renamed from: i */
    File m5849i() {
        return new File(m5846f(), "invalidClsFiles");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m5804a(SettingsData settingsData) {
        return (settingsData == null || !settingsData.f14790d.f14760a || this.f5182m.m5956a()) ? false : true;
    }

    /* JADX INFO: renamed from: h */
    private CreateReportSpiCall m5825h(String str) {
        return new DefaultCreateReportSpiCall(this.f5178i, CommonUtils.m15195b(this.f5178i.m15121r(), "com.crashlytics.ApiEndpoint"), str, this.f5180k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m5814b(SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.m15085h().mo15070d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context contextR = this.f5178i.m15121r();
        ReportUploader reportUploader = new ReportUploader(this.f5184o.f5137a, m5825h(settingsData.f14787a.f14747d), this.f5187r, this.f5188s);
        for (File file : m5842b()) {
            this.f5179j.m5780a(new SendReportRunnable(contextR, new SessionReport(file, f5175f), reportUploader));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5798a(String str, String str2) {
        Answers answers = (Answers) Fabric.m15076a(Answers.class);
        if (answers == null) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Answers is not available");
        } else {
            answers.m5606a(new Crash.LoggedException(str, str2));
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m5815b(String str, String str2) {
        Answers answers = (Answers) Fabric.m15076a(Answers.class);
        if (answers == null) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Answers is not available");
        } else {
            answers.m5605a(new Crash.FatalException(str, str2));
        }
    }

    private final class ReportUploaderHandlingExceptionCheck implements ReportUploader.HandlingExceptionCheck {
        private ReportUploaderHandlingExceptionCheck() {
        }

        @Override // com.crashlytics.android.core.ReportUploader.HandlingExceptionCheck
        /* JADX INFO: renamed from: a */
        public boolean mo5862a() {
            return CrashlyticsController.this.m5845e();
        }
    }

    private final class ReportUploaderFilesProvider implements ReportUploader.ReportFilesProvider {
        private ReportUploaderFilesProvider() {
        }

        @Override // com.crashlytics.android.core.ReportUploader.ReportFilesProvider
        /* JADX INFO: renamed from: a */
        public File[] mo5860a() {
            return CrashlyticsController.this.m5842b();
        }

        @Override // com.crashlytics.android.core.ReportUploader.ReportFilesProvider
        /* JADX INFO: renamed from: b */
        public File[] mo5861b() {
            return CrashlyticsController.this.m5849i().listFiles();
        }
    }

    private static final class PrivacyDialogCheck implements ReportUploader.SendCheck {

        /* JADX INFO: renamed from: a */
        private final Kit f5212a;

        /* JADX INFO: renamed from: b */
        private final PreferenceManager f5213b;

        /* JADX INFO: renamed from: c */
        private final PromptSettingsData f5214c;

        public PrivacyDialogCheck(Kit kit, PreferenceManager preferenceManager, PromptSettingsData promptSettingsData) {
            this.f5212a = kit;
            this.f5213b = preferenceManager;
            this.f5214c = promptSettingsData;
        }

        @Override // com.crashlytics.android.core.ReportUploader.SendCheck
        /* JADX INFO: renamed from: a */
        public boolean mo5859a() {
            Activity activityM15092b = this.f5212a.m15122s().m15092b();
            if (activityM15092b == null || activityM15092b.isFinishing()) {
                return true;
            }
            final CrashPromptDialog crashPromptDialogM5771a = CrashPromptDialog.m5771a(activityM15092b, this.f5214c, new CrashPromptDialog.AlwaysSendCallback() { // from class: com.crashlytics.android.core.CrashlyticsController.PrivacyDialogCheck.1
                @Override // com.crashlytics.android.core.CrashPromptDialog.AlwaysSendCallback
                /* JADX INFO: renamed from: a */
                public void mo5775a(boolean z) {
                    PrivacyDialogCheck.this.f5213b.m5955a(z);
                }
            });
            activityM15092b.runOnUiThread(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsController.PrivacyDialogCheck.2
                @Override // java.lang.Runnable
                public void run() {
                    crashPromptDialogM5771a.m5772a();
                }
            });
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Waiting for user opt-in.");
            crashPromptDialogM5771a.m5773b();
            return crashPromptDialogM5771a.m5774c();
        }
    }

    private static final class SendReportRunnable implements Runnable {

        /* JADX INFO: renamed from: a */
        private final Context f5220a;

        /* JADX INFO: renamed from: b */
        private final Report f5221b;

        /* JADX INFO: renamed from: c */
        private final ReportUploader f5222c;

        public SendReportRunnable(Context context, Report report, ReportUploader reportUploader) {
            this.f5220a = context;
            this.f5221b = report;
            this.f5222c = reportUploader;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtils.m15211n(this.f5220a)) {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f5222c.m5966a(this.f5221b);
            }
        }
    }

    private static final class LogFileDirectoryProvider implements LogFileManager.DirectoryProvider {

        /* JADX INFO: renamed from: a */
        private final FileStore f5211a;

        public LogFileDirectoryProvider(FileStore fileStore) {
            this.f5211a = fileStore;
        }

        @Override // com.crashlytics.android.core.LogFileManager.DirectoryProvider
        /* JADX INFO: renamed from: a */
        public File mo5857a() {
            File file = new File(this.f5211a.mo15418a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
