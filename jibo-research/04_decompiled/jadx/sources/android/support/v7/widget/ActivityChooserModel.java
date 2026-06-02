package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class ActivityChooserModel extends DataSetObservable {

    /* JADX INFO: renamed from: a */
    static final String f3578a = ActivityChooserModel.class.getSimpleName();

    /* JADX INFO: renamed from: e */
    private static final Object f3579e = new Object();

    /* JADX INFO: renamed from: f */
    private static final Map<String, ActivityChooserModel> f3580f = new HashMap();

    /* JADX INFO: renamed from: b */
    final Context f3581b;

    /* JADX INFO: renamed from: c */
    final String f3582c;

    /* JADX INFO: renamed from: d */
    boolean f3583d;

    /* JADX INFO: renamed from: g */
    private final Object f3584g;

    /* JADX INFO: renamed from: h */
    private final List<ActivityResolveInfo> f3585h;

    /* JADX INFO: renamed from: i */
    private final List<HistoricalRecord> f3586i;

    /* JADX INFO: renamed from: j */
    private Intent f3587j;

    /* JADX INFO: renamed from: k */
    private ActivitySorter f3588k;

    /* JADX INFO: renamed from: l */
    private int f3589l;

    /* JADX INFO: renamed from: m */
    private boolean f3590m;

    /* JADX INFO: renamed from: n */
    private boolean f3591n;

    /* JADX INFO: renamed from: o */
    private boolean f3592o;

    /* JADX INFO: renamed from: p */
    private OnChooseActivityListener f3593p;

    public interface ActivitySorter {
        /* JADX INFO: renamed from: a */
        void m3779a(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public interface OnChooseActivityListener {
        /* JADX INFO: renamed from: a */
        boolean m3780a(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* JADX INFO: renamed from: a */
    public int m3771a() {
        int size;
        synchronized (this.f3584g) {
            m3765e();
            size = this.f3585h.size();
        }
        return size;
    }

    /* JADX INFO: renamed from: a */
    public ResolveInfo m3773a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f3584g) {
            m3765e();
            resolveInfo = this.f3585h.get(i).f3594a;
        }
        return resolveInfo;
    }

    /* JADX INFO: renamed from: a */
    public int m3772a(ResolveInfo resolveInfo) {
        synchronized (this.f3584g) {
            m3765e();
            List<ActivityResolveInfo> list = this.f3585h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f3594a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public Intent m3774b(int i) {
        synchronized (this.f3584g) {
            if (this.f3587j == null) {
                return null;
            }
            m3765e();
            ActivityResolveInfo activityResolveInfo = this.f3585h.get(i);
            ComponentName componentName = new ComponentName(activityResolveInfo.f3594a.activityInfo.packageName, activityResolveInfo.f3594a.activityInfo.name);
            Intent intent = new Intent(this.f3587j);
            intent.setComponent(componentName);
            if (this.f3593p != null) {
                if (this.f3593p.m3780a(this, new Intent(intent))) {
                    return null;
                }
            }
            m3763a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* JADX INFO: renamed from: b */
    public ResolveInfo m3775b() {
        synchronized (this.f3584g) {
            m3765e();
            if (!this.f3585h.isEmpty()) {
                return this.f3585h.get(0).f3594a;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3777c(int i) {
        float f;
        synchronized (this.f3584g) {
            m3765e();
            ActivityResolveInfo activityResolveInfo = this.f3585h.get(i);
            ActivityResolveInfo activityResolveInfo2 = this.f3585h.get(0);
            if (activityResolveInfo2 != null) {
                f = (activityResolveInfo2.f3595b - activityResolveInfo.f3595b) + 5.0f;
            } else {
                f = 1.0f;
            }
            m3763a(new HistoricalRecord(new ComponentName(activityResolveInfo.f3594a.activityInfo.packageName, activityResolveInfo.f3594a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3764d() {
        if (!this.f3590m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f3591n) {
            this.f3591n = false;
            if (!TextUtils.isEmpty(this.f3582c)) {
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f3586i), this.f3582c);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public int m3776c() {
        int size;
        synchronized (this.f3584g) {
            m3765e();
            size = this.f3586i.size();
        }
        return size;
    }

    /* JADX INFO: renamed from: e */
    private void m3765e() {
        boolean zM3767g = m3767g() | m3768h();
        m3769i();
        if (zM3767g) {
            m3766f();
            notifyChanged();
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m3766f() {
        if (this.f3588k == null || this.f3587j == null || this.f3585h.isEmpty() || this.f3586i.isEmpty()) {
            return false;
        }
        this.f3588k.m3779a(this.f3587j, this.f3585h, Collections.unmodifiableList(this.f3586i));
        return true;
    }

    /* JADX INFO: renamed from: g */
    private boolean m3767g() {
        if (!this.f3592o || this.f3587j == null) {
            return false;
        }
        this.f3592o = false;
        this.f3585h.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f3581b.getPackageManager().queryIntentActivities(this.f3587j, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f3585h.add(new ActivityResolveInfo(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    private boolean m3768h() {
        if (!this.f3583d || !this.f3591n || TextUtils.isEmpty(this.f3582c)) {
            return false;
        }
        this.f3583d = false;
        this.f3590m = true;
        m3770j();
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3763a(HistoricalRecord historicalRecord) {
        boolean zAdd = this.f3586i.add(historicalRecord);
        if (zAdd) {
            this.f3591n = true;
            m3769i();
            m3764d();
            m3766f();
            notifyChanged();
        }
        return zAdd;
    }

    /* JADX INFO: renamed from: i */
    private void m3769i() {
        int size = this.f3586i.size() - this.f3589l;
        if (size > 0) {
            this.f3591n = true;
            for (int i = 0; i < size; i++) {
                this.f3586i.remove(0);
            }
        }
    }

    public static final class HistoricalRecord {

        /* JADX INFO: renamed from: a */
        public final ComponentName f3596a;

        /* JADX INFO: renamed from: b */
        public final long f3597b;

        /* JADX INFO: renamed from: c */
        public final float f3598c;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.f3596a = componentName;
            this.f3597b = j;
            this.f3598c = f;
        }

        public int hashCode() {
            return (((((this.f3596a == null ? 0 : this.f3596a.hashCode()) + 31) * 31) + ((int) (this.f3597b ^ (this.f3597b >>> 32)))) * 31) + Float.floatToIntBits(this.f3598c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                HistoricalRecord historicalRecord = (HistoricalRecord) obj;
                if (this.f3596a == null) {
                    if (historicalRecord.f3596a != null) {
                        return false;
                    }
                } else if (!this.f3596a.equals(historicalRecord.f3596a)) {
                    return false;
                }
                return this.f3597b == historicalRecord.f3597b && Float.floatToIntBits(this.f3598c) == Float.floatToIntBits(historicalRecord.f3598c);
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.f3596a);
            sb.append("; time:").append(this.f3597b);
            sb.append("; weight:").append(new BigDecimal(this.f3598c));
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {

        /* JADX INFO: renamed from: a */
        public final ResolveInfo f3594a;

        /* JADX INFO: renamed from: b */
        public float f3595b;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.f3594a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3595b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f3595b) == Float.floatToIntBits(((ActivityResolveInfo) obj).f3595b);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.f3595b) - Float.floatToIntBits(this.f3595b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.f3594a.toString());
            sb.append("; weight:").append(new BigDecimal(this.f3595b));
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: j */
    private void m3770j() {
        FileInputStream fileInputStreamOpenFileInput;
        try {
            try {
                fileInputStreamOpenFileInput = this.f3581b.openFileInput(this.f3582c);
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, HTTP.UTF_8);
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!"historical-records".equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<HistoricalRecord> list = this.f3586i;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput != null) {
                                    try {
                                        fileInputStreamOpenFileInput.close();
                                        return;
                                    } catch (IOException e) {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (next2 != 3 && next2 != 4) {
                                if (!"historical-record".equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new HistoricalRecord(xmlPullParserNewPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, SkillsJsonParser.TYPE_TIME)), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    } catch (XmlPullParserException e2) {
                        Log.e(f3578a, "Error reading historical recrod file: " + this.f3582c, e2);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException e3) {
                            }
                        }
                    }
                } catch (IOException e4) {
                    Log.e(f3578a, "Error reading historical recrod file: " + this.f3582c, e4);
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException e5) {
                        }
                    }
                }
            } catch (FileNotFoundException e6) {
            }
        } catch (Throwable th) {
            if (fileInputStreamOpenFileInput != null) {
                try {
                    fileInputStreamOpenFileInput.close();
                } catch (IOException e7) {
                }
            }
            throw th;
        }
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = ActivityChooserModel.this.f3581b.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                            xmlSerializerNewSerializer.startDocument(HTTP.UTF_8, true);
                            xmlSerializerNewSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                                xmlSerializerNewSerializer.startTag(null, "historical-record");
                                xmlSerializerNewSerializer.attribute(null, "activity", historicalRecord.f3596a.flattenToString());
                                xmlSerializerNewSerializer.attribute(null, SkillsJsonParser.TYPE_TIME, String.valueOf(historicalRecord.f3597b));
                                xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(historicalRecord.f3598c));
                                xmlSerializerNewSerializer.endTag(null, "historical-record");
                            }
                            xmlSerializerNewSerializer.endTag(null, "historical-records");
                            xmlSerializerNewSerializer.endDocument();
                            ActivityChooserModel.this.f3583d = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            Log.e(ActivityChooserModel.f3578a, "Error writing historical record file: " + ActivityChooserModel.this.f3582c, e2);
                            ActivityChooserModel.this.f3583d = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IllegalArgumentException e4) {
                        Log.e(ActivityChooserModel.f3578a, "Error writing historical record file: " + ActivityChooserModel.this.f3582c, e4);
                        ActivityChooserModel.this.f3583d = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (IllegalStateException e6) {
                        Log.e(ActivityChooserModel.f3578a, "Error writing historical record file: " + ActivityChooserModel.this.f3582c, e6);
                        ActivityChooserModel.this.f3583d = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException e7) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    ActivityChooserModel.this.f3583d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e9) {
                Log.e(ActivityChooserModel.f3578a, "Error writing historical record file: " + str, e9);
            }
            return null;
        }
    }
}
