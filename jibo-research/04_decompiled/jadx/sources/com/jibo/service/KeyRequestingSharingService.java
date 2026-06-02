package com.jibo.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.internal.ShareConstants;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.key.model.Request;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.DatabaseContract;
import com.jibo.p018db.EntityData;
import com.jibo.utils.ServiceUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes.dex */
public class KeyRequestingSharingService extends IntentService {

    /* JADX INFO: renamed from: a */
    public static final String f9746a = KeyRequestingSharingService.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private Account f9747b;

    public KeyRequestingSharingService() {
        super(f9746a);
    }

    /* JADX INFO: renamed from: a */
    public static void m10160a(Context context) {
        Intent intent = new Intent(context, (Class<?>) KeyRequestingSharingService.class);
        intent.setAction("ACTION_CHECK_ALL_LOOPS");
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: a */
    public static void m10162a(Context context, Map<String, String> map) {
        Intent intent = new Intent(context, (Class<?>) KeyRequestingSharingService.class);
        intent.setAction("ACTION_KEY_REQUESTED");
        intent.putExtra("loopId", map.get("loopId"));
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: b */
    public static void m10165b(Context context, Map<String, String> map) {
        Intent intent = new Intent(context, (Class<?>) KeyRequestingSharingService.class);
        intent.setAction("ACTION_KEY_SHARED");
        intent.putExtra("loopId", map.get("loopId"));
        intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ID, map.get(ShareConstants.WEB_DIALOG_PARAM_ID));
        ServiceUtils.m11427a(context, intent);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ServiceUtils.m11426a((Service) this);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceUtils.m11428b(this);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) throws Throwable {
        this.f9747b = EntityData.m10089a(this).m10134i();
        if ("ACTION_CHECK_ALL_LOOPS".equals(intent.getAction())) {
            m10159a();
            return;
        }
        if ("ACTION_REQUEST_KEY".equals(intent.getAction())) {
            m10163a(intent.getExtras());
        } else if ("ACTION_KEY_REQUESTED".equals(intent.getAction())) {
            m10166b(intent.getExtras());
        } else if ("ACTION_KEY_SHARED".equals(intent.getAction())) {
            m10167c(intent.getExtras());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10161a(Context context, String str) {
        try {
            if (KeyManager.getInstance(context.getApplicationContext(), this.f9747b.getId()).obtainKeyHolder(context.getApplicationContext(), str) != null) {
                return;
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
        Intent intent = new Intent(context, (Class<?>) KeyRequestingSharingService.class);
        intent.setAction("ACTION_REQUEST_KEY");
        intent.putExtra("loopId", str);
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: a */
    private void m10159a() throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = getContentResolver().query(DatabaseContract.EntityEntry.m10079a(8), DatabaseContract.EntityEntry.f9694a, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (!cursorQuery.isClosed() && cursorQuery.moveToFirst()) {
                        while (!cursorQuery.isAfterLast()) {
                            EntityData.m10089a(this);
                            Loop loopM10088a = EntityData.m10088a(cursorQuery);
                            if (LoopHelper.isMemberAccepted(loopM10088a, EntityData.m10089a(this).m10134i().getId())) {
                                m10161a(getApplicationContext(), loopM10088a.getId());
                            }
                            cursorQuery.moveToNext();
                        }
                    }
                } catch (Exception e) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10163a(Bundle bundle) {
        String string = bundle.getString("loopId");
        if (!TextUtils.isEmpty(string)) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), 0);
                if (TextUtils.isEmpty(sharedPreferences.getString("PREF_PUSH_SERVICE_TOKEN", null))) {
                    Thread.sleep(2000L);
                }
                if (!TextUtils.isEmpty(sharedPreferences.getString("PREF_PUSH_SERVICE_TOKEN", null))) {
                    KeyManager keyManager = KeyManager.getInstance(getApplicationContext(), this.f9747b.getId());
                    Request requestCreateRequest = EntityData.m10089a(getApplicationContext()).m10126d().createRequest(string, keyManager.getPublicKeyForSharing());
                    if (requestCreateRequest != null) {
                        m10164a(keyManager, requestCreateRequest, string);
                    }
                }
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10166b(Bundle bundle) {
        String string = bundle.getString("loopId");
        if (!TextUtils.isEmpty(string)) {
            try {
                KeyManager.SymmetricKeyHolder symmetricKeyHolderObtainKeyHolder = KeyManager.getInstance(getApplicationContext(), this.f9747b.getId()).obtainKeyHolder(getApplicationContext(), string);
                EntityData entityDataM10089a = EntityData.m10089a(getApplicationContext());
                try {
                    for (Request request : entityDataM10089a.m10126d().listIncomingRequests(string)) {
                        try {
                            entityDataM10089a.m10126d().share(request.getId(), symmetricKeyHolderObtainKeyHolder.shareSymmetricKey(request.getPublicKey()));
                        } catch (Exception e) {
                            Crashlytics.m5597a((Throwable) e);
                        }
                    }
                } catch (Exception e2) {
                    Crashlytics.m5597a((Throwable) e2);
                }
            } catch (Exception e3) {
                Crashlytics.m5597a((Throwable) e3);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m10167c(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("loopId");
            String string2 = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                try {
                    Request request = EntityData.m10089a(getApplicationContext()).m10126d().getRequest(string2);
                    if (request != null) {
                        m10164a(KeyManager.getInstance(getApplicationContext(), this.f9747b.getId()), request, string);
                    }
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10164a(KeyManager keyManager, Request request, String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException, KeyStoreException, NoSuchProviderException {
        if (!TextUtils.isEmpty(request.getEncryptedKey())) {
            keyManager.saveSymmetricKey(getApplicationContext(), str, request.getEncryptedKey());
            getContentResolver().notifyChange(DatabaseContract.EntityEntry.m10079a(8), null);
            LocalBroadcastManager localBroadcastManagerM1878a = LocalBroadcastManager.m1878a(this);
            Intent intent = new Intent();
            intent.setAction("ACTION_KEY_SAVED");
            intent.putExtra("loopId", str);
            localBroadcastManagerM1878a.m1883a(intent);
        }
    }
}
