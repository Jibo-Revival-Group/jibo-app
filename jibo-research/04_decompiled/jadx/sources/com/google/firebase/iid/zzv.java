package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class zzv {

    /* JADX INFO: renamed from: a */
    private static int f8687a = 0;

    /* JADX INFO: renamed from: b */
    private static PendingIntent f8688b;

    /* JADX INFO: renamed from: d */
    private final Context f8690d;

    /* JADX INFO: renamed from: e */
    private final zzu f8691e;

    /* JADX INFO: renamed from: g */
    private Messenger f8693g;

    /* JADX INFO: renamed from: h */
    private MessengerCompat f8694h;

    /* JADX INFO: renamed from: c */
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> f8689c = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: f */
    private Messenger f8692f = new Messenger(new zzw(this, Looper.getMainLooper()));

    public zzv(Context context, zzu zzuVar) {
        this.f8690d = context;
        this.f8691e = zzuVar;
    }

    /* JADX INFO: renamed from: a */
    private static synchronized String m9162a() {
        int i;
        i = f8687a;
        f8687a = i + 1;
        return Integer.toString(i);
    }

    /* JADX INFO: renamed from: a */
    private static synchronized void m9163a(Context context, Intent intent) {
        if (f8688b == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            f8688b = PendingIntent.getBroadcast(context, 0, intent2, 0);
        }
        intent.putExtra("app", f8688b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m9164a(Message message) {
        String str;
        String strSubstring;
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                this.f8694h = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.f8693g = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(action);
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Unexpected response action: ".concat(strValueOf) : new String("Unexpected response action: "));
                return;
            }
            return;
        }
        String stringExtra = intent2.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent2.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String strValueOf2 = String.valueOf(stringExtra);
                    Log.d("FirebaseInstanceId", strValueOf2.length() != 0 ? "Unexpected response string: ".concat(strValueOf2) : new String("Unexpected response string: "));
                    return;
                }
                return;
            }
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            Bundle extras = intent2.getExtras();
            extras.putString("registration_id", strGroup2);
            synchronized (this.f8689c) {
                TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.f8689c.remove(strGroup);
                if (taskCompletionSourceRemove != null) {
                    taskCompletionSourceRemove.m8935a(extras);
                    return;
                } else {
                    String strValueOf3 = String.valueOf(strGroup);
                    Log.w("FirebaseInstanceId", strValueOf3.length() != 0 ? "Missing callback for ".concat(strValueOf3) : new String("Missing callback for "));
                    return;
                }
            }
        }
        String stringExtra2 = intent2.getStringExtra("error");
        if (stringExtra2 == null) {
            String strValueOf4 = String.valueOf(intent2.getExtras());
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf4).length() + 49).append("Unexpected response, no error or registration id ").append(strValueOf4).toString());
            return;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String strValueOf5 = String.valueOf(stringExtra2);
            Log.d("FirebaseInstanceId", strValueOf5.length() != 0 ? "Received InstanceID error ".concat(strValueOf5) : new String("Received InstanceID error "));
        }
        if (stringExtra2.startsWith("|")) {
            String[] strArrSplit = stringExtra2.split("\\|");
            if (!"ID".equals(strArrSplit[1])) {
                String strValueOf6 = String.valueOf(stringExtra2);
                Log.w("FirebaseInstanceId", strValueOf6.length() != 0 ? "Unexpected structured response ".concat(strValueOf6) : new String("Unexpected structured response "));
            }
            if (strArrSplit.length > 2) {
                str = strArrSplit[2];
                strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
            } else {
                strSubstring = "UNKNOWN";
                str = null;
            }
            intent2.putExtra("error", strSubstring);
        } else {
            str = null;
            strSubstring = stringExtra2;
        }
        m9166a(str, strSubstring);
    }

    /* JADX INFO: renamed from: a */
    private final void m9166a(String str, String str2) {
        synchronized (this.f8689c) {
            if (str == null) {
                for (int i = 0; i < this.f8689c.size(); i++) {
                    this.f8689c.m2453c(i).m8934a(new IOException(str2));
                }
                this.f8689c.clear();
            } else {
                TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.f8689c.remove(str);
                if (taskCompletionSourceRemove == null) {
                    String strValueOf = String.valueOf(str);
                    Log.w("FirebaseInstanceId", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
                    return;
                }
                taskCompletionSourceRemove.m8934a(new IOException(str2));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private final Bundle m9167b(Bundle bundle) throws IOException {
        Bundle bundleM9168c = m9168c(bundle);
        if (bundleM9168c == null || !bundleM9168c.containsKey("google.messenger")) {
            return bundleM9168c;
        }
        Bundle bundleM9168c2 = m9168c(bundle);
        if (bundleM9168c2 == null || !bundleM9168c2.containsKey("google.messenger")) {
            return bundleM9168c2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0101  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Bundle m9168c(android.os.Bundle r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.m9168c(android.os.Bundle):android.os.Bundle");
    }

    /* JADX INFO: renamed from: a */
    final Bundle m9169a(Bundle bundle) throws IOException {
        if (this.f8691e.m9161d() < 12000000) {
            return m9167b(bundle);
        }
        try {
            return (Bundle) Tasks.m8941a((Task) zzi.m9136a(this.f8690d).m9139b(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 22).append("Error making request: ").append(strValueOf).toString());
            }
            if ((e.getCause() instanceof zzs) && ((zzs) e.getCause()).m9153a() == 4) {
                return m9167b(bundle);
            }
            return null;
        }
    }
}
