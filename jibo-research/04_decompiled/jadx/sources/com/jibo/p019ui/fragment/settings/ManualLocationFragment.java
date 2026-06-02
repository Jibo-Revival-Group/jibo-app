package com.jibo.p019ui.fragment.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;
import butterknife.BindView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ManualLocationFragment extends BaseFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a */
    public static final String f11050a = LogUtils.m11405a(ManualLocationFragment.class);

    /* JADX INFO: renamed from: e */
    private static final LatLngBounds f11051e = new LatLngBounds(new LatLng(37.39816d, -122.180831d), new LatLng(37.43061d, -121.97209d));

    /* JADX INFO: renamed from: b */
    MenuItem f11052b;

    /* JADX INFO: renamed from: c */
    private GoogleApiClient f11053c;

    /* JADX INFO: renamed from: d */
    private PlaceArrayAdapter f11054d;

    @BindView
    AutoCompleteTextView locationEdit;

    /* JADX INFO: renamed from: m */
    private Place f11056m;

    /* JADX INFO: renamed from: l */
    private AdapterView.OnItemClickListener f11055l = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.fragment.settings.ManualLocationFragment.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlaceArrayAdapter.PlaceAutocomplete item = ManualLocationFragment.this.f11054d.getItem(i);
            String strValueOf = String.valueOf(item.f11066a);
            Log.i(ManualLocationFragment.f11050a, "Selected: " + ((Object) item.f11067b));
            Places.f8124c.mo8764a(ManualLocationFragment.this.f11053c, strValueOf).mo6920a(ManualLocationFragment.this.f11057n);
            Log.i(ManualLocationFragment.f11050a, "Fetching details for ID: " + ((Object) item.f11066a));
        }
    };

    /* JADX INFO: renamed from: n */
    private ResultCallback<PlaceBuffer> f11057n = new ResultCallback<PlaceBuffer>() { // from class: com.jibo.ui.fragment.settings.ManualLocationFragment.2
        @Override // com.google.android.gms.common.api.ResultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo6928a(PlaceBuffer placeBuffer) {
            if (!placeBuffer.mo6927a().m6935c()) {
                Log.e(ManualLocationFragment.f11050a, "Place query did not complete. Error: " + placeBuffer.mo6927a().toString());
                return;
            }
            ManualLocationFragment.this.f11056m = placeBuffer.mo7265a(0);
            ManualLocationFragment.this.f11052b.setEnabled(true);
        }
    };

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    /* JADX INFO: renamed from: b */
    private void m11038b() {
        if (this.f11053c == null) {
            this.f11053c = new GoogleApiClient.Builder(getActivity()).m6910a((GoogleApiClient.ConnectionCallbacks) this).m6911a((GoogleApiClient.OnConnectionFailedListener) this).m6908a(Places.f8122a).m6913b();
            this.f11053c.mo6901e();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_manual_location, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_save != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m11040a();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m11038b();
        this.f11054d = new PlaceArrayAdapter(getContext(), android.R.layout.simple_list_item_1, null, null);
        this.locationEdit.setAdapter(this.f11054d);
        this.locationEdit.setThreshold(3);
        this.locationEdit.setOnItemClickListener(this.f11055l);
        getActivity().setResult(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_save, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f11052b = menu.findItem(R.id.action_save);
        this.f11052b.setTitle(R.string.set);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.x_white);
        m10352n();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f11052b.setEnabled(!this.locationEdit.getText().toString().isEmpty());
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.new_location);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        getActivity().setResult(0);
        return super.mo10346h();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("ARGS_SKILL_FRAGMENT", getArguments().getBoolean("ARGS_SKILL_FRAGMENT"));
    }

    /* JADX INFO: renamed from: a */
    public void m11040a() {
        JiboAnalytics.m9855g(getActivity(), JiboAnalytics.f9231ao);
        Bundle bundle = new Bundle();
        bundle.putDouble("ARGS_LATITUDE", this.f11056m.mo8765a().f8312a);
        bundle.putDouble("ARGS_LONGITUDE", this.f11056m.mo8765a().f8313b);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo6915a(Bundle bundle) {
        this.f11054d.m11047a(this.f11053c);
        Log.i(f11050a, "Google Places API connected.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo6914a(int i) {
        this.f11054d.m11047a((GoogleApiClient) null);
        Log.e(f11050a, "Google Places API connection suspended.");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public void mo6916a(ConnectionResult connectionResult) {
        Log.e(f11050a, "Google Places API connection failed with error code: " + connectionResult.m6822c());
        Toast.makeText(getContext(), "Google Places API connection failed with error code:" + connectionResult.m6822c(), 1).show();
    }

    private class PlaceArrayAdapter extends ArrayAdapter<PlaceAutocomplete> implements Filterable {

        /* JADX INFO: renamed from: b */
        private GoogleApiClient f11061b;

        /* JADX INFO: renamed from: c */
        private AutocompleteFilter f11062c;

        /* JADX INFO: renamed from: d */
        private LatLngBounds f11063d;

        /* JADX INFO: renamed from: e */
        private ArrayList<PlaceAutocomplete> f11064e;

        public PlaceArrayAdapter(Context context, int i, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
            super(context, i);
            this.f11063d = latLngBounds;
            this.f11062c = autocompleteFilter;
        }

        /* JADX INFO: renamed from: a */
        public void m11047a(GoogleApiClient googleApiClient) {
            if (googleApiClient == null || !googleApiClient.mo6906j()) {
                this.f11061b = null;
            } else {
                this.f11061b = googleApiClient;
            }
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.f11064e.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaceAutocomplete getItem(int i) {
            return this.f11064e.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public ArrayList<PlaceAutocomplete> m11045a(CharSequence charSequence) {
            if (this.f11061b != null) {
                Log.i("PlaceArrayAdapter", "Executing autocomplete query for: " + ((Object) charSequence));
                AutocompletePredictionBuffer autocompletePredictionBuffer = (AutocompletePredictionBuffer) Places.f8124c.mo8763a(this.f11061b, charSequence.toString(), this.f11063d, this.f11062c).mo6917a(10L, TimeUnit.SECONDS);
                Status statusMo6927a = autocompletePredictionBuffer.mo6927a();
                if (!statusMo6927a.m6935c()) {
                    Toast.makeText(getContext(), "Error: " + statusMo6927a.toString(), 0).show();
                    Log.e("PlaceArrayAdapter", "Error getting place predictions: " + statusMo6927a.toString());
                    autocompletePredictionBuffer.mo6926c_();
                    return null;
                }
                Log.i("PlaceArrayAdapter", "Query completed. Received " + autocompletePredictionBuffer.mo7261b() + " predictions.");
                ArrayList<PlaceAutocomplete> arrayList = new ArrayList<>(autocompletePredictionBuffer.mo7261b());
                for (AutocompletePrediction autocompletePrediction : autocompletePredictionBuffer) {
                    arrayList.add(new PlaceAutocomplete(autocompletePrediction.mo8761a(), autocompletePrediction.mo8760a(null)));
                }
                autocompletePredictionBuffer.mo6926c_();
                return arrayList;
            }
            Log.e("PlaceArrayAdapter", "Google API client is not connected.");
            return null;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Filterable
        public Filter getFilter() {
            return new Filter() { // from class: com.jibo.ui.fragment.settings.ManualLocationFragment.PlaceArrayAdapter.1
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (charSequence != null) {
                        PlaceArrayAdapter.this.f11064e = PlaceArrayAdapter.this.m11045a(charSequence);
                        if (PlaceArrayAdapter.this.f11064e != null) {
                            filterResults.values = PlaceArrayAdapter.this.f11064e;
                            filterResults.count = PlaceArrayAdapter.this.f11064e.size();
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
            public CharSequence f11066a;

            /* JADX INFO: renamed from: b */
            public CharSequence f11067b;

            PlaceAutocomplete(CharSequence charSequence, CharSequence charSequence2) {
                this.f11066a = charSequence;
                this.f11067b = charSequence2;
            }

            public String toString() {
                return this.f11067b.toString();
            }
        }
    }
}
