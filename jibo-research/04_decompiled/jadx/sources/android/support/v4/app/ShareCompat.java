package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ShareCompat {

    public static class IntentBuilder {

        /* JADX INFO: renamed from: a */
        private Activity f1758a;

        /* JADX INFO: renamed from: b */
        private Intent f1759b = new Intent().setAction("android.intent.action.SEND");

        /* JADX INFO: renamed from: c */
        private CharSequence f1760c;

        /* JADX INFO: renamed from: d */
        private ArrayList<String> f1761d;

        /* JADX INFO: renamed from: e */
        private ArrayList<String> f1762e;

        /* JADX INFO: renamed from: f */
        private ArrayList<String> f1763f;

        /* JADX INFO: renamed from: g */
        private ArrayList<Uri> f1764g;

        /* JADX INFO: renamed from: a */
        public static IntentBuilder m1790a(Activity activity) {
            return new IntentBuilder(activity);
        }

        private IntentBuilder(Activity activity) {
            this.f1758a = activity;
            this.f1759b.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
            this.f1759b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", activity.getComponentName());
            this.f1759b.addFlags(524288);
        }

        /* JADX INFO: renamed from: a */
        public Intent m1792a() {
            if (this.f1761d != null) {
                m1791a("android.intent.extra.EMAIL", this.f1761d);
                this.f1761d = null;
            }
            if (this.f1762e != null) {
                m1791a("android.intent.extra.CC", this.f1762e);
                this.f1762e = null;
            }
            if (this.f1763f != null) {
                m1791a("android.intent.extra.BCC", this.f1763f);
                this.f1763f = null;
            }
            boolean z = this.f1764g != null && this.f1764g.size() > 1;
            boolean zEquals = this.f1759b.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (!z && zEquals) {
                this.f1759b.setAction("android.intent.action.SEND");
                if (this.f1764g != null && !this.f1764g.isEmpty()) {
                    this.f1759b.putExtra("android.intent.extra.STREAM", this.f1764g.get(0));
                } else {
                    this.f1759b.removeExtra("android.intent.extra.STREAM");
                }
                this.f1764g = null;
            }
            if (z && !zEquals) {
                this.f1759b.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.f1764g != null && !this.f1764g.isEmpty()) {
                    this.f1759b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f1764g);
                } else {
                    this.f1759b.removeExtra("android.intent.extra.STREAM");
                }
            }
            return this.f1759b;
        }

        /* JADX INFO: renamed from: a */
        private void m1791a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f1759b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f1759b.putExtra(str, strArr);
        }

        /* JADX INFO: renamed from: b */
        public Intent m1797b() {
            return Intent.createChooser(m1792a(), this.f1760c);
        }

        /* JADX INFO: renamed from: a */
        public IntentBuilder m1795a(CharSequence charSequence) {
            this.f1760c = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public IntentBuilder m1793a(int i) {
            return m1795a(this.f1758a.getText(i));
        }

        /* JADX INFO: renamed from: a */
        public IntentBuilder m1796a(String str) {
            this.f1759b.setType(str);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public IntentBuilder m1794a(Uri uri) {
            if (!this.f1759b.getAction().equals("android.intent.action.SEND")) {
                this.f1759b.setAction("android.intent.action.SEND");
            }
            this.f1764g = null;
            this.f1759b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public IntentBuilder m1798b(Uri uri) {
            Uri uri2 = (Uri) this.f1759b.getParcelableExtra("android.intent.extra.STREAM");
            if (this.f1764g == null && uri2 == null) {
                return m1794a(uri);
            }
            if (this.f1764g == null) {
                this.f1764g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.f1759b.removeExtra("android.intent.extra.STREAM");
                this.f1764g.add(uri2);
            }
            this.f1764g.add(uri);
            return this;
        }
    }
}
