package com.jibo.ui.fragment.settings;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Filter.FilterResults;
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
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ManualLocationFragment extends BaseFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   public static final String a = LogUtils.a(ManualLocationFragment.class);
   private static final LatLngBounds e = new LatLngBounds(new LatLng(37.39816, -122.180831), new LatLng(37.43061, -121.97209));
   MenuItem b;
   private GoogleApiClient c;
   private ManualLocationFragment.PlaceArrayAdapter d;
   private OnItemClickListener l = new OnItemClickListener(this) {
      final ManualLocationFragment a;

      {
         this.a = var1;
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         ManualLocationFragment.PlaceArrayAdapter.PlaceAutocomplete var6 = this.a.d.a(var3);
         String var7 = String.valueOf(var6.a);
         Log.i(ManualLocationFragment.a, "Selected: " + var6.b);
         Places.c.a(this.a.c, var7).a(this.a.n);
         Log.i(ManualLocationFragment.a, "Fetching details for ID: " + var6.a);
      }
   };
   @BindView
   AutoCompleteTextView locationEdit;
   private Place m;
   private ResultCallback<PlaceBuffer> n = new ResultCallback<PlaceBuffer>(this) {
      final ManualLocationFragment a;

      {
         this.a = var1;
      }

      public void a(PlaceBuffer var1) {
         if (!var1.a().c()) {
            Log.e(ManualLocationFragment.a, "Place query did not complete. Error: " + var1.a().toString());
         } else {
            this.a.m = var1.b(0);
            this.a.b.setEnabled(true);
         }
      }
   };

   private void b() {
      if (this.c == null) {
         this.c = new GoogleApiClient.Builder(this.getActivity()).a(this).a(this).a(Places.a).b();
         this.c.e();
      }
   }

   public void a() {
      JiboAnalytics.g(this.getActivity(), JiboAnalytics.ao);
      Bundle var2 = new Bundle();
      var2.putDouble("ARGS_LATITUDE", this.m.a().a);
      var2.putDouble("ARGS_LONGITUDE", this.m.a().b);
      Intent var1 = new Intent();
      var1.putExtras(var2);
      this.getActivity().setResult(-1, var1);
      this.getActivity().finish();
   }

   @Override
   public void a(int var1) {
      this.d.a((GoogleApiClient)null);
      Log.e(a, "Google Places API connection suspended.");
   }

   @Override
   public void a(Bundle var1) {
      this.d.a(this.c);
      Log.i(a, "Google Places API connected.");
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayShowCustomEnabled(false);
      var1.setHomeAsUpIndicator(2131231362);
      this.n();
   }

   @Override
   public void a(ConnectionResult var1) {
      Log.e(a, "Google Places API connection failed with error code: " + var1.c());
      Toast.makeText(this.getContext(), "Google Places API connection failed with error code:" + var1.c(), 1).show();
   }

   @Override
   public boolean h() {
      this.getActivity().setResult(0);
      return super.h();
   }

   @Override
   protected String o() {
      return this.getString(2131755552);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492871, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.b = var1.findItem(2131296304);
      this.b.setTitle(2131755653);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427449, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296304 == var1.getItemId()) {
         this.a();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      MenuItem var3 = this.b;
      boolean var2;
      if (!this.locationEdit.getText().toString().isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      var3.setEnabled(var2);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("ARGS_SKILL_FRAGMENT", this.getArguments().getBoolean("ARGS_SKILL_FRAGMENT"));
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.b();
      this.d = new ManualLocationFragment.PlaceArrayAdapter(this, this.getContext(), 17367043, null, null);
      this.locationEdit.setAdapter(this.d);
      this.locationEdit.setThreshold(3);
      this.locationEdit.setOnItemClickListener(this.l);
      this.getActivity().setResult(0);
   }

   private class PlaceArrayAdapter extends ArrayAdapter<ManualLocationFragment.PlaceArrayAdapter.PlaceAutocomplete> implements Filterable {
      final ManualLocationFragment a;
      private GoogleApiClient b;
      private AutocompleteFilter c;
      private LatLngBounds d;
      private ArrayList<ManualLocationFragment.PlaceArrayAdapter.PlaceAutocomplete> e;

      public PlaceArrayAdapter(ManualLocationFragment var1, Context var2, int var3, LatLngBounds var4, AutocompleteFilter var5) {
         super(var2, var3);
         this.a = var1;
         this.d = var4;
         this.c = var5;
      }

      private ArrayList<ManualLocationFragment.PlaceArrayAdapter.PlaceAutocomplete> a(CharSequence var1) {
         ArrayList var6;
         if (this.b != null) {
            Log.i("PlaceArrayAdapter", "Executing autocomplete query for: " + var1);
            AutocompletePredictionBuffer var2 = Places.c.a(this.b, var1.toString(), this.d, this.c).a(10L, TimeUnit.SECONDS);
            Status var5 = var2.a();
            if (!var5.c()) {
               Toast.makeText(this.getContext(), "Error: " + var5.toString(), 0).show();
               Log.e("PlaceArrayAdapter", "Error getting place predictions: " + var5.toString());
               var2.c_();
               var6 = null;
            } else {
               Log.i("PlaceArrayAdapter", "Query completed. Received " + var2.b() + " predictions.");
               Iterator var3 = var2.iterator();
               var6 = new ArrayList(var2.b());

               while (var3.hasNext()) {
                  AutocompletePrediction var4 = (AutocompletePrediction)var3.next();
                  var6.add(new ManualLocationFragment.PlaceArrayAdapter.PlaceAutocomplete(this, var4.a(), var4.a(null)));
               }

               var2.c_();
            }
         } else {
            Log.e("PlaceArrayAdapter", "Google API client is not connected.");
            var6 = null;
         }

         return var6;
      }

      public ManualLocationFragment.PlaceArrayAdapter.PlaceAutocomplete a(int var1) {
         return this.e.get(var1);
      }

      public void a(GoogleApiClient var1) {
         if (var1 != null && var1.j()) {
            this.b = var1;
         } else {
            this.b = null;
         }
      }

      public int getCount() {
         return this.e.size();
      }

      public Filter getFilter() {
         return new Filter(this) {
            final ManualLocationFragment.PlaceArrayAdapter a;

            {
               this.a = var1;
            }

            protected FilterResults performFiltering(CharSequence var1) {
               FilterResults var2 = new FilterResults();
               if (var1 != null) {
                  this.a.e = this.a.a(var1);
                  if (this.a.e != null) {
                     var2.values = this.a.e;
                     var2.count = this.a.e.size();
                  }
               }

               return var2;
            }

            protected void publishResults(CharSequence var1, FilterResults var2) {
               if (var2 != null && var2.count > 0) {
                  this.a.notifyDataSetChanged();
               } else {
                  this.a.notifyDataSetInvalidated();
               }
            }
         };
      }

      class PlaceAutocomplete {
         public CharSequence a;
         public CharSequence b;
         final ManualLocationFragment.PlaceArrayAdapter c;

         PlaceAutocomplete(ManualLocationFragment.PlaceArrayAdapter var1, CharSequence var2, CharSequence var3) {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         @Override
         public String toString() {
            return this.b.toString();
         }
      }
   }
}
