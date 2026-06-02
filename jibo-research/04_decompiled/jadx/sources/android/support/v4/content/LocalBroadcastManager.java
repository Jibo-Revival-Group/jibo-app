package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* JADX INFO: renamed from: f */
    private static final Object f1805f = new Object();

    /* JADX INFO: renamed from: g */
    private static LocalBroadcastManager f1806g;

    /* JADX INFO: renamed from: a */
    private final Context f1807a;

    /* JADX INFO: renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> f1808b = new HashMap<>();

    /* JADX INFO: renamed from: c */
    private final HashMap<String, ArrayList<ReceiverRecord>> f1809c = new HashMap<>();

    /* JADX INFO: renamed from: d */
    private final ArrayList<BroadcastRecord> f1810d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    private final Handler f1811e;

    private static final class ReceiverRecord {

        /* JADX INFO: renamed from: a */
        final IntentFilter f1815a;

        /* JADX INFO: renamed from: b */
        final BroadcastReceiver f1816b;

        /* JADX INFO: renamed from: c */
        boolean f1817c;

        /* JADX INFO: renamed from: d */
        boolean f1818d;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1815a = intentFilter;
            this.f1816b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f1816b);
            sb.append(" filter=");
            sb.append(this.f1815a);
            if (this.f1818d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private static final class BroadcastRecord {

        /* JADX INFO: renamed from: a */
        final Intent f1813a;

        /* JADX INFO: renamed from: b */
        final ArrayList<ReceiverRecord> f1814b;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.f1813a = intent;
            this.f1814b = arrayList;
        }
    }

    /* JADX INFO: renamed from: a */
    public static LocalBroadcastManager m1878a(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f1805f) {
            if (f1806g == null) {
                f1806g = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f1806g;
        }
        return localBroadcastManager;
    }

    private LocalBroadcastManager(Context context) {
        this.f1807a = context;
        this.f1811e = new Handler(context.getMainLooper()) { // from class: android.support.v4.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        LocalBroadcastManager.this.m1879a();
                        break;
                    default:
                        super.handleMessage(message);
                        break;
                }
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public void m1882a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1808b) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<ReceiverRecord> arrayList = this.f1808b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f1808b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<ReceiverRecord> arrayList2 = this.f1809c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f1809c.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1881a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1808b) {
            ArrayList<ReceiverRecord> arrayListRemove = this.f1808b.remove(broadcastReceiver);
            if (arrayListRemove != null) {
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    ReceiverRecord receiverRecord = arrayListRemove.get(size);
                    receiverRecord.f1818d = true;
                    for (int i = 0; i < receiverRecord.f1815a.countActions(); i++) {
                        String action = receiverRecord.f1815a.getAction(i);
                        ArrayList<ReceiverRecord> arrayList = this.f1809c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                ReceiverRecord receiverRecord2 = arrayList.get(size2);
                                if (receiverRecord2.f1816b == broadcastReceiver) {
                                    receiverRecord2.f1818d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f1809c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1883a(Intent intent) {
        String str;
        ArrayList arrayList;
        synchronized (this.f1808b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1807a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<ReceiverRecord> arrayList2 = this.f1809c.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i = 0;
                while (i < arrayList2.size()) {
                    ReceiverRecord receiverRecord = arrayList2.get(i);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.f1815a);
                    }
                    if (receiverRecord.f1817c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            arrayList = arrayList3;
                        } else {
                            arrayList = arrayList3;
                        }
                    } else {
                        int iMatch = receiverRecord.f1815a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList.add(receiverRecord);
                            receiverRecord.f1817c = true;
                        } else {
                            if (z) {
                                switch (iMatch) {
                                    case ProfilePictureView.LARGE /* -4 */:
                                        str = "category";
                                        break;
                                    case ProfilePictureView.NORMAL /* -3 */:
                                        str = NativeProtocol.WEB_DIALOG_ACTION;
                                        break;
                                    case -2:
                                        str = ShareConstants.WEB_DIALOG_PARAM_DATA;
                                        break;
                                    case -1:
                                        str = ShareConstants.MEDIA_TYPE;
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                            }
                            arrayList = arrayList3;
                        }
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        ((ReceiverRecord) arrayList3.get(i2)).f1817c = false;
                    }
                    this.f1810d.add(new BroadcastRecord(intent, arrayList3));
                    if (!this.f1811e.hasMessages(1)) {
                        this.f1811e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1879a() {
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.f1808b) {
                int size = this.f1810d.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.f1810d.toArray(broadcastRecordArr);
                this.f1810d.clear();
            }
            for (BroadcastRecord broadcastRecord : broadcastRecordArr) {
                int size2 = broadcastRecord.f1814b.size();
                for (int i = 0; i < size2; i++) {
                    ReceiverRecord receiverRecord = broadcastRecord.f1814b.get(i);
                    if (!receiverRecord.f1818d) {
                        receiverRecord.f1816b.onReceive(this.f1807a, broadcastRecord.f1813a);
                    }
                }
            }
        }
    }
}
