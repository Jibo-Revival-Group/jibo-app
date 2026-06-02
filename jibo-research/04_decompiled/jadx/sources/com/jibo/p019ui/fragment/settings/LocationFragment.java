package com.jibo.p019ui.fragment.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.maps.GeoApiContext;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.PermissionUtil;
import com.jibo.utils.UIUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationFragment extends BaseFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: d */
    public static final String f11026d = LocationFragment.class.getSimpleName();

    /* JADX INFO: renamed from: a */
    private GoogleApiClient f11027a;

    /* JADX INFO: renamed from: b */
    private AddressLocatorTask f11028b;

    /* JADX INFO: renamed from: e */
    protected JiboRobotPropertiesAsyncClient f11029e;

    /* JADX INFO: renamed from: l */
    protected String f11030l;

    /* JADX INFO: renamed from: m */
    protected String f11031m;

    /* JADX INFO: renamed from: n */
    protected AsyncGeocoderTaskProcessor f11032n = new C13261();

    /* JADX INFO: renamed from: o */
    protected CircleProgressFragment f11033o;

    @BindView
    protected TextView txtLocation;

    @BindView
    protected TextView txtTimezone;

    public interface AsyncGeocoderTaskProcessor {
        /* JADX INFO: renamed from: a */
        void mo10394a(Bundle bundle);
    }

    public interface ManualLocationFragmentListener {
        /* JADX INFO: renamed from: a */
        void mo10396a(SingleFragmentActivity.Builder builder);
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.settings.LocationFragment$1 */
    class C13261 implements AsyncGeocoderTaskProcessor {
        C13261() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[Catch: Exception -> 0x005e, TryCatch #0 {Exception -> 0x005e, blocks: (B:7:0x002f, B:9:0x0035, B:12:0x0047, B:11:0x003b), top: B:16:0x002f }] */
        @Override // com.jibo.ui.fragment.settings.LocationFragment.AsyncGeocoderTaskProcessor
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void mo10394a(final android.os.Bundle r7) {
            /*
                r6 = this;
                r5 = 0
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this
                boolean r0 = r0.m10342d()
                if (r0 != 0) goto La
            L9:
                return
            La:
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this
                r1 = 2131755307(0x7f10012b, float:1.914149E38)
                java.lang.String r0 = r0.getString(r1)
                android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
                r1.<init>(r0)
                android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
                r3 = 1
                r2.<init>(r3)
                java.lang.String r3 = " "
                int r3 = r0.lastIndexOf(r3)
                int r0 = r0.length()
                r4 = 33
                r1.setSpan(r2, r3, r0, r4)
                if (r7 == 0) goto L3b
                boolean r0 = r7.isEmpty()     // Catch: java.lang.Exception -> L5e
                if (r0 != 0) goto L3b
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this     // Catch: java.lang.Exception -> L5e
                com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient r0 = r0.f11029e     // Catch: java.lang.Exception -> L5e
                if (r0 != 0) goto L47
            L3b:
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this     // Catch: java.lang.Exception -> L5e
                com.jibo.ui.fragment.dialog.CircleProgressFragment r0 = r0.f11033o     // Catch: java.lang.Exception -> L5e
                r0.m10506b(r1)     // Catch: java.lang.Exception -> L5e
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this     // Catch: java.lang.Exception -> L5e
                r2 = 0
                r0.f11033o = r2     // Catch: java.lang.Exception -> L5e
            L47:
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this     // Catch: java.lang.Exception -> L5e
                com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient r0 = r0.f11029e     // Catch: java.lang.Exception -> L5e
                com.jibo.ui.fragment.settings.LocationFragment r2 = com.jibo.p019ui.fragment.settings.LocationFragment.this     // Catch: java.lang.Exception -> L5e
                com.jibo.aws.integration.aws.services.loop.model.Loop r2 = com.jibo.p019ui.fragment.settings.LocationFragment.m11024a(r2)     // Catch: java.lang.Exception -> L5e
                java.lang.String r2 = r2.getRobotFriendlyId()     // Catch: java.lang.Exception -> L5e
                com.jibo.ui.fragment.settings.LocationFragment$1$1 r3 = new com.jibo.ui.fragment.settings.LocationFragment$1$1     // Catch: java.lang.Exception -> L5e
                r3.<init>()     // Catch: java.lang.Exception -> L5e
                r0.getRobot(r2, r3)     // Catch: java.lang.Exception -> L5e
                goto L9
            L5e:
                r0 = move-exception
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this
                com.jibo.ui.fragment.dialog.CircleProgressFragment r0 = r0.f11033o
                r0.m10506b(r1)
                com.jibo.ui.fragment.settings.LocationFragment r0 = com.jibo.p019ui.fragment.settings.LocationFragment.this
                r0.f11033o = r5
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.settings.LocationFragment.C13261.mo10394a(android.os.Bundle):void");
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11030l = bundle.getString("ARGS_LOCATION");
            this.f11031m = bundle.getString(RobotHelper.FIELD_TIMEZONE);
        } else if (getArguments() != null) {
            this.f11030l = getArguments().getString("ARGS_LOCATION");
            this.f11031m = getArguments().getString(RobotHelper.FIELD_TIMEZONE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_robot_location, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        mo10393a();
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null && LoopHelper.isOwner(this.f9934k, accountM10134i.getId())) {
            this.f11029e = EntityData.m10089a(getActivity()).m10132g();
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("ARGS_LOCATION", this.f11030l);
        bundle.putString(RobotHelper.FIELD_TIMEZONE, this.f11031m);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f11028b != null) {
            this.f11028b.cancel(true);
            this.f11028b = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.f11033o != null) {
            this.f11033o.m10502a();
        }
        if (this.f11027a != null) {
            this.f11027a.mo6903g();
        }
        super.onDestroyView();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_location);
    }

    @OnClick
    @Optional
    public void btnSetLocationClick(View view) {
        JiboAnalytics.m9855g(getActivity(), JiboAnalytics.f9230an);
        if (PermissionUtil.m11421b(getActivity())) {
            if (this.f11027a == null) {
                m11027b();
                return;
            } else if (!this.f11027a.mo6906j()) {
                this.f11027a.mo6901e();
                return;
            } else {
                m11030r();
                return;
            }
        }
        m11029q();
    }

    @OnClick
    @Optional
    public void setManuallyClick(View view) {
        m11031a((ManualLocationFragmentListener) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1019 && i2 == -1) {
            Location location = new Location("MANUALLY_ENTERED");
            location.setLongitude(intent.getDoubleExtra("ARGS_LONGITUDE", 0.0d));
            location.setLatitude(intent.getDoubleExtra("ARGS_LATITUDE", 0.0d));
            m11025a(location);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length > 0) {
            int i2 = 0;
            for (int i3 : iArr) {
                i2 += i3;
            }
            if (i2 == 0) {
                switch (i) {
                    case 1:
                        m11027b();
                        break;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo6915a(Bundle bundle) {
        m11030r();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo6914a(int i) {
        UIUtils.m11475a(getView(), getString(R.string.error_message_could_not_get_location));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public void mo6916a(ConnectionResult connectionResult) {
        UIUtils.m11475a(getView(), getString(R.string.error_message_could_not_get_location));
    }

    /* JADX INFO: renamed from: b */
    private void m11027b() {
        if (this.f11027a == null) {
            this.f11027a = new GoogleApiClient.Builder(getActivity()).m6910a((GoogleApiClient.ConnectionCallbacks) this).m6911a((GoogleApiClient.OnConnectionFailedListener) this).m6908a(LocationServices.f8065a).m6913b();
            this.f11027a.mo6901e();
        }
    }

    /* JADX INFO: renamed from: q */
    private void m11029q() {
        requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    /* JADX INFO: renamed from: a */
    private void m11025a(Location location) {
        if (Geocoder.isPresent()) {
            if (this.f11033o != null) {
                this.f11033o.m10502a();
                this.f11033o = null;
            }
            if (this.f11028b != null) {
                this.f11028b.cancel(true);
                this.f11028b = null;
            }
            this.f11033o = new CircleProgressFragment();
            this.f11033o.m10509c(getString(R.string.message_setting_location));
            this.f11033o.show(getActivity().getSupportFragmentManager(), "CircleFragment");
            this.f11028b = new AddressLocatorTask(getActivity(), this.f11032n);
            this.f11028b.execute(location);
            return;
        }
        UIUtils.m11475a(getView(), getString(R.string.error_message_could_not_get_location));
    }

    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: r */
    private void m11030r() {
        if (LocationServices.f8066b.mo7823b(this.f11027a).m8739a()) {
            Location locationMo7822a = LocationServices.f8066b.mo7822a(this.f11027a);
            if (locationMo7822a != null) {
                m11025a(locationMo7822a);
                return;
            } else {
                UIUtils.m11475a(getView(), getString(R.string.error_message_could_not_get_location));
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.m3221a(R.string.open_settings, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.settings.LocationFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                LocationFragment.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        builder.m3232b(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.settings.LocationFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.m3220a(R.string.title_location);
        builder.m3231b(R.string.location_enable_in_setting_msg);
        builder.m3236b().show();
    }

    /* JADX INFO: renamed from: a */
    protected void mo10393a() {
        if (this.txtLocation != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(TextUtils.isEmpty(this.f11030l) ? getString(R.string.robot_info_not_available) : this.f11030l);
            this.txtLocation.setText(sb.toString());
            this.txtTimezone.setText(RobotHelper.getTimeZoneFriendly(this.f11031m != null ? this.f11031m.replace("\\/", "/") : "", getString(R.string.text_location_not_set)));
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m11031a(ManualLocationFragmentListener manualLocationFragmentListener) {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, ManualLocationFragment.class.getName());
        if (manualLocationFragmentListener != null) {
            manualLocationFragmentListener.mo10396a(builder);
        }
        builder.m10275a(1019);
    }

    private static class AddressLocatorTask extends AsyncTask<Location, Void, Bundle> {

        /* JADX INFO: renamed from: a */
        private AsyncGeocoderTaskProcessor f11041a;

        /* JADX INFO: renamed from: b */
        private Context f11042b;

        public AddressLocatorTask(Context context, AsyncGeocoderTaskProcessor asyncGeocoderTaskProcessor) {
            this.f11042b = context.getApplicationContext();
            this.f11041a = asyncGeocoderTaskProcessor;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bundle bundle) {
            if (this.f11041a != null && !isCancelled()) {
                this.f11041a.mo10394a(bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle doInBackground(Location... locationArr) {
            Bundle bundle = new Bundle();
            Geocoder geocoder = new Geocoder(this.f11042b);
            try {
                if (isCancelled()) {
                    return bundle;
                }
                bundle.putString(RobotHelper.FIELD_TIMEZONE, TimeZoneApi.getTimeZone(new GeoApiContext.Builder().apiKey(this.f11042b.getString(R.string.google_timezone_api_key)).build(), new LatLng(locationArr[0].getLatitude(), locationArr[0].getLongitude())).awaitIgnoreError().getID().replace("/", "\\/"));
                if (isCancelled()) {
                    return bundle;
                }
                List<Address> fromLocation = geocoder.getFromLocation(locationArr[0].getLatitude(), locationArr[0].getLongitude(), 1);
                if (isCancelled()) {
                    return bundle;
                }
                if (fromLocation != null && !fromLocation.isEmpty()) {
                    Address address = fromLocation.get(0);
                    String locality = address.getLocality();
                    if (locality == null) {
                        locality = address.getMaxAddressLineIndex() >= 2 ? address.getAddressLine(1) : address.getAddressLine(0);
                    }
                    if (locality.contains(",")) {
                        locality = locality.split(",")[0];
                    }
                    bundle.putString(RobotHelper.FIELD_CITY, locality);
                    bundle.putString("state", address.getAdminArea());
                    bundle.putString(RobotHelper.FIELD_ZIPCODE, address.getPostalCode());
                    bundle.putString(RobotHelper.FIELD_COUNTRY, address.getCountryName());
                    bundle.putString(RobotHelper.FIELD_COUNTRY_CODE, address.getCountryCode());
                    bundle.putDouble(RobotHelper.FIELD_LATITUDE, locationArr[0].getLatitude());
                    bundle.putDouble(RobotHelper.FIELD_LONGITUDE, locationArr[0].getLongitude());
                    bundle.putString(RobotHelper.FIELD_ADDRESS_LINE, address.getAddressLine(0));
                }
            } catch (Exception e) {
            }
            return bundle;
        }
    }
}
