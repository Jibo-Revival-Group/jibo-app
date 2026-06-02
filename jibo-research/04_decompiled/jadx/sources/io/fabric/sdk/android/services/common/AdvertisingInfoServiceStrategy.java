package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {

    /* JADX INFO: renamed from: a */
    private final Context f14564a;

    public AdvertisingInfoServiceStrategy(Context context) {
        this.f14564a = context.getApplicationContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy$1] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // io.fabric.sdk.android.services.common.AdvertisingInfoStrategy
    /* JADX INFO: renamed from: a */
    public AdvertisingInfo mo15159a() {
        AdvertisingInfo advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        advertisingInfo = 0;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Fabric.m15085h().mo15063a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
        } else {
            try {
                this.f14564a.getPackageManager().getPackageInfo("com.android.vending", 0);
                AdvertisingConnection advertisingConnection = new AdvertisingConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    try {
                    } catch (Exception e) {
                        Fabric.m15085h().mo15071d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                    } finally {
                        this.f14564a.unbindService(advertisingConnection);
                    }
                    if (this.f14564a.bindService(intent, advertisingConnection, 1)) {
                        AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.m15161a());
                        advertisingInfo = new AdvertisingInfo(advertisingInterface.m15162a(), advertisingInterface.m15163b());
                    } else {
                        Fabric.m15085h().mo15063a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                    }
                } catch (Throwable th) {
                    Fabric.m15085h().mo15064a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Fabric.m15085h().mo15063a("Fabric", "Unable to find Google Play Services package name");
            } catch (Exception e3) {
                Fabric.m15085h().mo15064a("Fabric", "Unable to determine if Google Play Services is available", e3);
            }
        }
        return advertisingInfo;
    }

    private static final class AdvertisingConnection implements ServiceConnection {

        /* JADX INFO: renamed from: a */
        private boolean f14565a;

        /* JADX INFO: renamed from: b */
        private final LinkedBlockingQueue<IBinder> f14566b;

        private AdvertisingConnection() {
            this.f14565a = false;
            this.f14566b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f14566b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f14566b.clear();
        }

        /* JADX INFO: renamed from: a */
        public IBinder m15161a() {
            if (this.f14565a) {
                Fabric.m15085h().mo15072e("Fabric", "getBinder already called");
            }
            this.f14565a = true;
            try {
                return this.f14566b.poll(200L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    private static final class AdvertisingInterface implements IInterface {

        /* JADX INFO: renamed from: a */
        private final IBinder f14567a;

        public AdvertisingInterface(IBinder iBinder) {
            this.f14567a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f14567a;
        }

        /* JADX INFO: renamed from: a */
        public String m15162a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            String string = null;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f14567a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Exception e) {
                Fabric.m15085h().mo15063a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
            return string;
        }

        /* JADX INFO: renamed from: b */
        public boolean m15163b() throws RemoteException {
            boolean z;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(1);
                    this.f14567a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    z = parcelObtain2.readInt() != 0;
                } catch (Exception e) {
                    Fabric.m15085h().mo15063a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    z = false;
                }
                return z;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
