package com.jibo.p019ui.view.skills;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.GeoApiContext;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;
import com.jibo.R;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.settings.LocationFragment;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.view.proxima.CustomFontAutoCompleteTextView;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class LocationAutoCompleteTextView extends CustomFontAutoCompleteTextView implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a */
    private static final String f11653a = LocationAutoCompleteTextView.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private GoogleApiClient f11654b;

    /* JADX INFO: renamed from: c */
    private PlaceArrayAdapter f11655c;

    /* JADX INFO: renamed from: d */
    private AddressLocatorTask f11656d;

    /* JADX INFO: renamed from: e */
    private View.OnClickListener f11657e;

    /* JADX INFO: renamed from: f */
    private ResultCallback<PlaceBuffer> f11658f;

    /* JADX INFO: renamed from: g */
    private AdapterView.OnItemClickListener f11659g;

    /* JADX INFO: renamed from: h */
    private LocationFragment.AsyncGeocoderTaskProcessor f11660h;

    public LocationAutoCompleteTextView(Context context) {
        super(context);
        this.f11658f = new ResultCallback<PlaceBuffer>() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.1
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void mo6928a(PlaceBuffer placeBuffer) {
                if (!placeBuffer.mo6927a().m6935c() || placeBuffer.mo7261b() == 0) {
                    UIUtils.m11475a(LocationAutoCompleteTextView.this, LocationAutoCompleteTextView.this.getContext().getString(R.string.error_message_could_not_get_location));
                    return;
                }
                Location location = new Location("MANUAL");
                location.setLatitude(placeBuffer.mo7265a(0).mo8765a().f8312a);
                location.setLongitude(placeBuffer.mo7265a(0).mo8765a().f8313b);
                LocationAutoCompleteTextView.this.m11361a(location);
            }
        };
        this.f11659g = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((BaseActivity) LocationAutoCompleteTextView.this.getContext()).m10196f();
                Places.f8124c.mo8764a(LocationAutoCompleteTextView.this.f11654b, String.valueOf(LocationAutoCompleteTextView.this.f11655c.getItem(i).f11672a)).mo6920a(LocationAutoCompleteTextView.this.f11658f);
            }
        };
        this.f11660h = new LocationFragment.AsyncGeocoderTaskProcessor() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.3
            @Override // com.jibo.ui.fragment.settings.LocationFragment.AsyncGeocoderTaskProcessor
            /* JADX INFO: renamed from: a */
            public void mo10394a(Bundle bundle) {
                try {
                    if (LocationAutoCompleteTextView.this.getContext() != null && !((BaseActivity) LocationAutoCompleteTextView.this.getContext()).isFinishing() && LocationAutoCompleteTextView.this.isAttachedToWindow()) {
                        if (bundle == null) {
                            UIUtils.m11475a(LocationAutoCompleteTextView.this, LocationAutoCompleteTextView.this.getContext().getString(R.string.error_message_could_not_get_location));
                        } else {
                            LocationAutoCompleteTextView.this.setTag(new DataItems.LocationDataValue(Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LATITUDE)), Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LONGITUDE)), bundle.getString(RobotHelper.FIELD_CITY), bundle.getString("state"), bundle.getString(RobotHelper.FIELD_COUNTRY), bundle.getString(RobotHelper.FIELD_TIMEZONE), Util.m11499e(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE)), Util.m11498d(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE))));
                            LocationAutoCompleteTextView.this.f11657e.onClick(LocationAutoCompleteTextView.this);
                        }
                    }
                } catch (Exception e) {
                }
            }
        };
        m11360a();
    }

    public LocationAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11658f = new ResultCallback<PlaceBuffer>() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.1
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void mo6928a(PlaceBuffer placeBuffer) {
                if (!placeBuffer.mo6927a().m6935c() || placeBuffer.mo7261b() == 0) {
                    UIUtils.m11475a(LocationAutoCompleteTextView.this, LocationAutoCompleteTextView.this.getContext().getString(R.string.error_message_could_not_get_location));
                    return;
                }
                Location location = new Location("MANUAL");
                location.setLatitude(placeBuffer.mo7265a(0).mo8765a().f8312a);
                location.setLongitude(placeBuffer.mo7265a(0).mo8765a().f8313b);
                LocationAutoCompleteTextView.this.m11361a(location);
            }
        };
        this.f11659g = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((BaseActivity) LocationAutoCompleteTextView.this.getContext()).m10196f();
                Places.f8124c.mo8764a(LocationAutoCompleteTextView.this.f11654b, String.valueOf(LocationAutoCompleteTextView.this.f11655c.getItem(i).f11672a)).mo6920a(LocationAutoCompleteTextView.this.f11658f);
            }
        };
        this.f11660h = new LocationFragment.AsyncGeocoderTaskProcessor() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.3
            @Override // com.jibo.ui.fragment.settings.LocationFragment.AsyncGeocoderTaskProcessor
            /* JADX INFO: renamed from: a */
            public void mo10394a(Bundle bundle) {
                try {
                    if (LocationAutoCompleteTextView.this.getContext() != null && !((BaseActivity) LocationAutoCompleteTextView.this.getContext()).isFinishing() && LocationAutoCompleteTextView.this.isAttachedToWindow()) {
                        if (bundle == null) {
                            UIUtils.m11475a(LocationAutoCompleteTextView.this, LocationAutoCompleteTextView.this.getContext().getString(R.string.error_message_could_not_get_location));
                        } else {
                            LocationAutoCompleteTextView.this.setTag(new DataItems.LocationDataValue(Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LATITUDE)), Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LONGITUDE)), bundle.getString(RobotHelper.FIELD_CITY), bundle.getString("state"), bundle.getString(RobotHelper.FIELD_COUNTRY), bundle.getString(RobotHelper.FIELD_TIMEZONE), Util.m11499e(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE)), Util.m11498d(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE))));
                            LocationAutoCompleteTextView.this.f11657e.onClick(LocationAutoCompleteTextView.this);
                        }
                    }
                } catch (Exception e) {
                }
            }
        };
        m11360a();
    }

    public LocationAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11658f = new ResultCallback<PlaceBuffer>() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.1
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void mo6928a(PlaceBuffer placeBuffer) {
                if (!placeBuffer.mo6927a().m6935c() || placeBuffer.mo7261b() == 0) {
                    UIUtils.m11475a(LocationAutoCompleteTextView.this, LocationAutoCompleteTextView.this.getContext().getString(R.string.error_message_could_not_get_location));
                    return;
                }
                Location location = new Location("MANUAL");
                location.setLatitude(placeBuffer.mo7265a(0).mo8765a().f8312a);
                location.setLongitude(placeBuffer.mo7265a(0).mo8765a().f8313b);
                LocationAutoCompleteTextView.this.m11361a(location);
            }
        };
        this.f11659g = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                ((BaseActivity) LocationAutoCompleteTextView.this.getContext()).m10196f();
                Places.f8124c.mo8764a(LocationAutoCompleteTextView.this.f11654b, String.valueOf(LocationAutoCompleteTextView.this.f11655c.getItem(i2).f11672a)).mo6920a(LocationAutoCompleteTextView.this.f11658f);
            }
        };
        this.f11660h = new LocationFragment.AsyncGeocoderTaskProcessor() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.3
            @Override // com.jibo.ui.fragment.settings.LocationFragment.AsyncGeocoderTaskProcessor
            /* JADX INFO: renamed from: a */
            public void mo10394a(Bundle bundle) {
                try {
                    if (LocationAutoCompleteTextView.this.getContext() != null && !((BaseActivity) LocationAutoCompleteTextView.this.getContext()).isFinishing() && LocationAutoCompleteTextView.this.isAttachedToWindow()) {
                        if (bundle == null) {
                            UIUtils.m11475a(LocationAutoCompleteTextView.this, LocationAutoCompleteTextView.this.getContext().getString(R.string.error_message_could_not_get_location));
                        } else {
                            LocationAutoCompleteTextView.this.setTag(new DataItems.LocationDataValue(Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LATITUDE)), Double.valueOf(bundle.getDouble(RobotHelper.FIELD_LONGITUDE)), bundle.getString(RobotHelper.FIELD_CITY), bundle.getString("state"), bundle.getString(RobotHelper.FIELD_COUNTRY), bundle.getString(RobotHelper.FIELD_TIMEZONE), Util.m11499e(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE)), Util.m11498d(bundle.getString(RobotHelper.FIELD_ADDRESS_LINE))));
                            LocationAutoCompleteTextView.this.f11657e.onClick(LocationAutoCompleteTextView.this);
                        }
                    }
                } catch (Exception e) {
                }
            }
        };
        m11360a();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo6915a(Bundle bundle) {
        this.f11655c.m11374a(this.f11654b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo6914a(int i) {
        this.f11655c.m11374a((GoogleApiClient) null);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public void mo6916a(ConnectionResult connectionResult) {
        UIUtils.m11475a(this, getContext().getString(R.string.error_message_could_not_get_location));
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11657e = onClickListener;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11654b == null) {
            this.f11654b = new GoogleApiClient.Builder(getContext()).m6910a((GoogleApiClient.ConnectionCallbacks) this).m6911a((GoogleApiClient.OnConnectionFailedListener) this).m6908a(Places.f8122a).m6913b();
            this.f11654b.mo6901e();
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f11656d != null) {
            this.f11656d.cancel(true);
            this.f11656d = null;
        }
        if (this.f11654b != null) {
            this.f11654b.mo6903g();
            this.f11654b = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11360a() {
        this.f11655c = new PlaceArrayAdapter(getContext(), android.R.layout.simple_list_item_1, null, null);
        setAdapter(this.f11655c);
        setThreshold(3);
        setOnItemClickListener(this.f11659g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11361a(Location location) {
        if (Geocoder.isPresent()) {
            if (this.f11656d != null) {
                this.f11656d.cancel(true);
                this.f11656d = null;
            }
            if (getContext() != null && !((BaseActivity) getContext()).isFinishing() && isAttachedToWindow()) {
                ((BaseActivity) getContext()).m10201k();
                this.f11656d = new AddressLocatorTask(getContext(), this.f11660h);
                this.f11656d.execute(location);
                return;
            }
            return;
        }
        UIUtils.m11475a(this, getContext().getString(R.string.error_message_could_not_get_location));
    }

    private class PlaceArrayAdapter extends ArrayAdapter<PlaceAutocomplete> implements Filterable {

        /* JADX INFO: renamed from: b */
        private GoogleApiClient f11667b;

        /* JADX INFO: renamed from: c */
        private AutocompleteFilter f11668c;

        /* JADX INFO: renamed from: d */
        private LatLngBounds f11669d;

        /* JADX INFO: renamed from: e */
        private ArrayList<PlaceAutocomplete> f11670e;

        public PlaceArrayAdapter(Context context, int i, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
            super(context, i);
            this.f11669d = latLngBounds;
            this.f11668c = autocompleteFilter;
        }

        /* JADX INFO: renamed from: a */
        public void m11374a(GoogleApiClient googleApiClient) {
            if (googleApiClient == null || !googleApiClient.mo6906j()) {
                this.f11667b = null;
            } else {
                this.f11667b = googleApiClient;
            }
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.f11670e.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaceAutocomplete getItem(int i) {
            return this.f11670e.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public ArrayList<PlaceAutocomplete> m11372a(CharSequence charSequence) {
            if (getContext() == null || ((BaseActivity) getContext()).isFinishing() || !LocationAutoCompleteTextView.this.isAttachedToWindow()) {
                return null;
            }
            if (this.f11667b != null && this.f11667b.mo6906j()) {
                AutocompletePredictionBuffer autocompletePredictionBuffer = (AutocompletePredictionBuffer) Places.f8124c.mo8763a(this.f11667b, charSequence.toString(), this.f11669d, this.f11668c).mo6917a(10L, TimeUnit.SECONDS);
                Status statusMo6927a = autocompletePredictionBuffer.mo6927a();
                if (!statusMo6927a.m6935c()) {
                    Toast.makeText(getContext(), "Error: " + statusMo6927a.toString(), 0).show();
                    LogUtils.m11412d("PlaceArrayAdapter", "Error getting place predictions: " + statusMo6927a.toString());
                    autocompletePredictionBuffer.mo6926c_();
                    return null;
                }
                LogUtils.m11411c("PlaceArrayAdapter", "Query completed. Received " + autocompletePredictionBuffer.mo7261b() + " predictions.");
                ArrayList<PlaceAutocomplete> arrayList = new ArrayList<>(autocompletePredictionBuffer.mo7261b());
                for (AutocompletePrediction autocompletePrediction : autocompletePredictionBuffer) {
                    arrayList.add(new PlaceAutocomplete(autocompletePrediction.mo8761a(), autocompletePrediction.mo8760a(null)));
                }
                autocompletePredictionBuffer.mo6926c_();
                return arrayList;
            }
            LogUtils.m11412d("PlaceArrayAdapter", "Google API client is not connected.");
            return null;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Filterable
        public Filter getFilter() {
            return new Filter() { // from class: com.jibo.ui.view.skills.LocationAutoCompleteTextView.PlaceArrayAdapter.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (charSequence != null) {
                        PlaceArrayAdapter.this.f11670e = PlaceArrayAdapter.this.m11372a(charSequence);
                        if (PlaceArrayAdapter.this.f11670e != null) {
                            filterResults.values = PlaceArrayAdapter.this.f11670e;
                            filterResults.count = PlaceArrayAdapter.this.f11670e.size();
                        }
                    }
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    if (filterResults != null && filterResults.count > 0) {
                        PlaceArrayAdapter.this.notifyDataSetChanged();
                    } else {
                        PlaceArrayAdapter.this.notifyDataSetInvalidated();
                    }
                }
            };
        }

        class PlaceAutocomplete {

            /* JADX INFO: renamed from: a */
            public CharSequence f11672a;

            /* JADX INFO: renamed from: b */
            public CharSequence f11673b;

            PlaceAutocomplete(CharSequence charSequence, CharSequence charSequence2) {
                this.f11672a = charSequence;
                this.f11673b = charSequence2;
            }

            public String toString() {
                return this.f11673b.toString();
            }
        }
    }

    private static class AddressLocatorTask extends AsyncTask<Location, Void, Bundle> {

        /* JADX INFO: renamed from: a */
        private LocationFragment.AsyncGeocoderTaskProcessor f11664a;

        /* JADX INFO: renamed from: b */
        private Context f11665b;

        public AddressLocatorTask(Context context, LocationFragment.AsyncGeocoderTaskProcessor asyncGeocoderTaskProcessor) {
            this.f11665b = context.getApplicationContext();
            this.f11664a = asyncGeocoderTaskProcessor;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bundle bundle) {
            this.f11665b = null;
            if (this.f11664a != null && !isCancelled()) {
                this.f11664a.mo10394a(bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle doInBackground(Location... locationArr) {
            Bundle bundle = new Bundle();
            Geocoder geocoder = new Geocoder(this.f11665b);
            try {
                if (isCancelled()) {
                    return bundle;
                }
                bundle.putString(RobotHelper.FIELD_TIMEZONE, TimeZoneApi.getTimeZone(new GeoApiContext.Builder().apiKey(this.f11665b.getString(R.string.google_timezone_api_key)).build(), new LatLng(locationArr[0].getLatitude(), locationArr[0].getLongitude())).awaitIgnoreError().getID().replace("/", "\\/"));
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
                    bundle.putString(RobotHelper.FIELD_COUNTRY, address.getCountryName());
                    bundle.putDouble(RobotHelper.FIELD_LATITUDE, locationArr[0].getLatitude());
                    bundle.putDouble(RobotHelper.FIELD_LONGITUDE, locationArr[0].getLongitude());
                    bundle.putString(RobotHelper.FIELD_ADDRESS_LINE, address.getFeatureName() + " " + address.getThoroughfare());
                }
            } catch (Exception e) {
            }
            return bundle;
        }
    }
}
