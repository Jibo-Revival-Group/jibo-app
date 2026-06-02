package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import com.bumptech.glide.signature.EmptySignature;
import com.facebook.share.widget.ShareDialog;
import com.google.api.client.http.HttpMethods;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.jibo.JiboGlideModule;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.MediaHelper;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.OriginalKey;
import com.jibo.utils.cache.DiskLruCacheWrapper;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DownloadProgressFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    private Thread f10218a;

    /* JADX INFO: renamed from: e */
    private ArrayList<String> f10222e;

    /* JADX INFO: renamed from: c */
    private Handler.Callback f10220c = new Handler.Callback() { // from class: com.jibo.ui.fragment.dialog.DownloadProgressFragment.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (DownloadProgressFragment.this.getActivity() != null && !DownloadProgressFragment.this.getActivity().isFinishing() && !DownloadProgressFragment.this.isDetached() && DownloadProgressFragment.this.isResumed()) {
                if (message.what >= 0) {
                    ((ProgressDialog) DownloadProgressFragment.this.getDialog()).setProgress(message.what);
                    return true;
                }
                if (DownloadProgressFragment.this.getTargetFragment() != null && (DownloadProgressFragment.this.getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener)) {
                    ((DialogUtils.DialogFragmentWrapperClickListener) DownloadProgressFragment.this.getTargetFragment()).mo10186a(DownloadProgressFragment.this.getTargetRequestCode(), -1, DownloadProgressFragment.this.f10223f);
                }
                DownloadProgressFragment.this.getDialog().dismiss();
                return true;
            }
            return true;
        }
    };

    /* JADX INFO: renamed from: d */
    private int f10221d = 0;

    /* JADX INFO: renamed from: f */
    private ArrayList<String> f10223f = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private Handler f10219b = new Handler(Looper.getMainLooper(), this.f10220c);

    /* JADX INFO: renamed from: g */
    static /* synthetic */ int m10552g(DownloadProgressFragment downloadProgressFragment) {
        int i = downloadProgressFragment.f10221d;
        downloadProgressFragment.f10221d = i + 1;
        return i;
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.f10222e = bundle.getStringArrayList("ARG_IDS");
            this.f10223f = bundle.getStringArrayList("ARG_PATHS");
            this.f10221d = bundle.getInt("ARG_INDX", 0);
        } else if (getArguments() != null) {
            this.f10222e = getArguments().getStringArrayList("ARG_IDS");
            this.f10221d = 0;
        }
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle(getString(R.string.dialog_title_downloading_media));
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(1);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.jibo.ui.fragment.dialog.DownloadProgressFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setButton(-2, getString(android.R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.DownloadProgressFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return progressDialog;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10222e == null || this.f10222e.isEmpty()) {
            getDialog().dismiss();
            return;
        }
        ((ProgressDialog) getDialog()).setMax(this.f10222e.size());
        ((ProgressDialog) getDialog()).setProgress(0);
        this.f10218a = new Thread(new Runnable() { // from class: com.jibo.ui.fragment.dialog.DownloadProgressFragment.4
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[PHI: r0
              0x00c3: PHI (r0v19 android.database.Cursor) = (r0v18 android.database.Cursor), (r0v24 android.database.Cursor) binds: [B:23:0x009c, B:17:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.Throwable {
                /*
                    r8 = this;
                    r6 = 0
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    android.support.v4.app.FragmentActivity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L99
                    com.jibo.JiboGlideModule.m9866b(r0)     // Catch: java.lang.Exception -> L99
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    android.support.v4.app.FragmentActivity r0 = r0.getActivity()     // Catch: java.lang.Exception -> L99
                    android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Exception -> L99
                    boolean r7 = com.jibo.utils.SharedPreferencesUtil.m11446g(r0)     // Catch: java.lang.Exception -> L99
                L18:
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    java.lang.Thread r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10547b(r0)     // Catch: java.lang.Exception -> L99
                    boolean r0 = r0.isInterrupted()     // Catch: java.lang.Exception -> L99
                    if (r0 != 0) goto Lac
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    boolean r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10548c(r0)     // Catch: java.lang.Exception -> L99
                    if (r0 == 0) goto Lac
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    int r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10549d(r0)     // Catch: java.lang.Exception -> L99
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    java.util.ArrayList r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10550e(r1)     // Catch: java.lang.Exception -> L99
                    int r1 = r1.size()     // Catch: java.lang.Exception -> L99
                    if (r0 >= r1) goto Lac
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r0 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    android.support.v4.app.FragmentActivity r0 = r0.getActivity()     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    java.util.ArrayList r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10550e(r1)     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r2 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    int r2 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10549d(r2)     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    android.net.Uri r1 = com.jibo.db.DatabaseContract.MediaEntry.m10083a(r1)     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    java.lang.String[] r2 = com.jibo.db.DatabaseContract.MediaEntry.f9698a     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lbe java.lang.Exception -> Lc0
                    if (r0 == 0) goto L7c
                    boolean r1 = r0.isClosed()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> La3
                    if (r1 != 0) goto L7c
                    boolean r1 = r0.moveToFirst()     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> La3
                    if (r1 == 0) goto L7c
                    com.jibo.aws.integration.aws.services.media.model.Media r1 = com.jibo.p018db.EntityData.m10097c(r0)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> La3
                    r8.m10553a(r7, r1)     // Catch: java.lang.Exception -> L9b java.lang.Throwable -> La3
                L7c:
                    if (r0 == 0) goto Lc3
                    r0.close()     // Catch: java.lang.Exception -> L99
                    r6 = r0
                L82:
                    android.os.Message r0 = new android.os.Message     // Catch: java.lang.Exception -> L99
                    r0.<init>()     // Catch: java.lang.Exception -> L99
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    int r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10549d(r1)     // Catch: java.lang.Exception -> L99
                    r0.what = r1     // Catch: java.lang.Exception -> L99
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    android.os.Handler r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10551f(r1)     // Catch: java.lang.Exception -> L99
                    r1.sendMessage(r0)     // Catch: java.lang.Exception -> L99
                    goto L18
                L99:
                    r0 = move-exception
                L9a:
                    return
                L9b:
                    r1 = move-exception
                L9c:
                    if (r0 == 0) goto Lc3
                    r0.close()     // Catch: java.lang.Exception -> L99
                    r6 = r0
                    goto L82
                La3:
                    r1 = move-exception
                    r6 = r0
                    r0 = r1
                La6:
                    if (r6 == 0) goto Lab
                    r6.close()     // Catch: java.lang.Exception -> L99
                Lab:
                    throw r0     // Catch: java.lang.Exception -> L99
                Lac:
                    android.os.Message r0 = new android.os.Message     // Catch: java.lang.Exception -> L99
                    r0.<init>()     // Catch: java.lang.Exception -> L99
                    r1 = -1
                    r0.what = r1     // Catch: java.lang.Exception -> L99
                    com.jibo.ui.fragment.dialog.DownloadProgressFragment r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.this     // Catch: java.lang.Exception -> L99
                    android.os.Handler r1 = com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.m10551f(r1)     // Catch: java.lang.Exception -> L99
                    r1.sendMessage(r0)     // Catch: java.lang.Exception -> L99
                    goto L9a
                Lbe:
                    r0 = move-exception
                    goto La6
                Lc0:
                    r0 = move-exception
                    r0 = r6
                    goto L9c
                Lc3:
                    r6 = r0
                    goto L82
                */
                throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.dialog.DownloadProgressFragment.RunnableC11074.run():void");
            }

            /* JADX INFO: renamed from: a */
            private void m10553a(boolean z, Media media) {
                try {
                    if (DownloadProgressFragment.this.m10546a()) {
                        String url = MediaHelper.getUrl(z, media);
                        File file = new File(DownloadProgressFragment.this.getActivity().getExternalCacheDir(), OriginalKey.m11418a(url));
                        File shareableFile = MediaHelper.getShareableFile(DownloadProgressFragment.this.getActivity().getExternalCacheDir() + "/" + ShareDialog.WEB_SHARE_DIALOG, media);
                        if (!file.exists()) {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(url).openConnection()));
                            httpURLConnection.setReadTimeout(10000);
                            httpURLConnection.setConnectTimeout(5000);
                            httpURLConnection.setRequestMethod(HttpMethods.GET);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            if (!DownloadProgressFragment.this.m10546a() || responseCode != 200) {
                                httpURLConnection.disconnect();
                                return;
                            } else {
                                ((DiskLruCacheWrapper) JiboGlideModule.m9865a(DownloadProgressFragment.this.getActivity()).build()).m11509a(new OriginalKey(url, EmptySignature.m5570a()), httpURLConnection.getInputStream());
                            }
                        }
                        if (file.exists() && DownloadProgressFragment.this.m10546a()) {
                            if (!shareableFile.exists()) {
                                ImageUtils.m11396a(file, shareableFile);
                            }
                            DownloadProgressFragment.this.f10223f.add(shareableFile.getPath());
                        }
                        DownloadProgressFragment.m10552g(DownloadProgressFragment.this);
                    }
                } catch (Exception e) {
                }
            }
        });
        this.f10218a.start();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f10218a != null && !this.f10218a.isInterrupted()) {
            this.f10218a.interrupt();
        }
        this.f10219b.removeCallbacksAndMessages(null);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("ARG_INDX", this.f10222e);
        bundle.putStringArrayList("ARG_PATHS", this.f10223f);
        bundle.putInt("ARG_INDX", this.f10221d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m10546a() {
        return (getActivity() == null || getActivity().isFinishing() || isDetached() || !isResumed()) ? false : true;
    }
}
