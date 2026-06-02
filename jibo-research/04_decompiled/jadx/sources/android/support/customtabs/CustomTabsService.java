package android.support.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsService;
import android.support.v4.util.ArrayMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* JADX INFO: renamed from: a */
    private final Map<IBinder, IBinder.DeathRecipient> f370a = new ArrayMap();

    /* JADX INFO: renamed from: b */
    private ICustomTabsService.Stub f371b = new ICustomTabsService.Stub() { // from class: android.support.customtabs.CustomTabsService.1
        @Override // android.support.customtabs.ICustomTabsService
        /* JADX INFO: renamed from: a */
        public boolean mo326a(long j) {
            return CustomTabsService.this.m320a(j);
        }

        @Override // android.support.customtabs.ICustomTabsService
        /* JADX INFO: renamed from: a */
        public boolean mo327a(ICustomTabsCallback iCustomTabsCallback) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: android.support.customtabs.CustomTabsService.1.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        CustomTabsService.this.m321a(customTabsSessionToken);
                    }
                };
                synchronized (CustomTabsService.this.f370a) {
                    iCustomTabsCallback.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.f370a.put(iCustomTabsCallback.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.m324b(customTabsSessionToken);
            } catch (RemoteException e) {
                return false;
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        /* JADX INFO: renamed from: a */
        public boolean mo328a(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.m322a(new CustomTabsSessionToken(iCustomTabsCallback), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        /* JADX INFO: renamed from: a */
        public Bundle mo325a(String str, Bundle bundle) {
            return CustomTabsService.this.m319a(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        /* JADX INFO: renamed from: a */
        public boolean mo329a(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.m323a(new CustomTabsSessionToken(iCustomTabsCallback), bundle);
        }
    };

    /* JADX INFO: renamed from: a */
    protected abstract Bundle m319a(String str, Bundle bundle);

    /* JADX INFO: renamed from: a */
    protected abstract boolean m320a(long j);

    /* JADX INFO: renamed from: a */
    protected abstract boolean m322a(CustomTabsSessionToken customTabsSessionToken, Uri uri, Bundle bundle, List<Bundle> list);

    /* JADX INFO: renamed from: a */
    protected abstract boolean m323a(CustomTabsSessionToken customTabsSessionToken, Bundle bundle);

    /* JADX INFO: renamed from: b */
    protected abstract boolean m324b(CustomTabsSessionToken customTabsSessionToken);

    /* JADX INFO: renamed from: a */
    protected boolean m321a(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.f370a) {
                IBinder iBinderM332a = customTabsSessionToken.m332a();
                iBinderM332a.unlinkToDeath(this.f370a.get(iBinderM332a), 0);
                this.f370a.remove(iBinderM332a);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
