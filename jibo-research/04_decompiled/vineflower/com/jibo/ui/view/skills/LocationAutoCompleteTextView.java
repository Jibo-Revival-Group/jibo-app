package com.jibo.ui.view.skills;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Filter.FilterResults;
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
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.settings.LocationFragment;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.view.proxima.CustomFontAutoCompleteTextView;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class LocationAutoCompleteTextView
   extends CustomFontAutoCompleteTextView
   implements GoogleApiClient.ConnectionCallbacks,
   GoogleApiClient.OnConnectionFailedListener {
   private static final String a = LocationAutoCompleteTextView.class.getSimpleName();
   private GoogleApiClient b;
   private LocationAutoCompleteTextView.PlaceArrayAdapter c;
   private LocationAutoCompleteTextView.AddressLocatorTask d;
   private OnClickListener e;
   private ResultCallback<PlaceBuffer> f = new ResultCallback<PlaceBuffer>(this) {
      final LocationAutoCompleteTextView a;

      {
         this.a = var1;
      }

      public void a(PlaceBuffer var1) {
         if (var1.a().c() && var1.b() != 0) {
            Location var2 = new Location("MANUAL");
            var2.setLatitude(var1.b(0).a().a);
            var2.setLongitude(var1.b(0).a().b);
            this.a.a(var2);
         } else {
            UIUtils.a(this.a, this.a.getContext().getString(2131755307));
         }
      }
   };
   private OnItemClickListener g = new OnItemClickListener(this) {
      final LocationAutoCompleteTextView a;

      {
         this.a = var1;
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         ((BaseActivity)this.a.getContext()).f();
         String var6 = String.valueOf(this.a.c.a(var3).a);
         Places.c.a(this.a.b, var6).a(this.a.f);
      }
   };
   private LocationFragment.AsyncGeocoderTaskProcessor h = new LocationFragment.AsyncGeocoderTaskProcessor(this) {
      final LocationAutoCompleteTextView a;

      {
         this.a = var1;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void a(Bundle var1) {
         try {
            if (this.a.getContext() == null || ((BaseActivity)this.a.getContext()).isFinishing() || !this.a.isAttachedToWindow()) {
               return;
            }
         } catch (Exception var5) {
            return;
         }

         if (var1 == null) {
            try {
               UIUtils.a(this.a, this.a.getContext().getString(2131755307));
            } catch (Exception var4) {
            }
         } else {
            try {
               DataItems.LocationDataValue var2 = new DataItems.LocationDataValue(
                  var1.getDouble("lat"),
                  var1.getDouble("lng"),
                  var1.getString("city"),
                  var1.getString("state"),
                  var1.getString("country"),
                  var1.getString("timezone"),
                  Util.e(var1.getString("addressLine")),
                  Util.d(var1.getString("addressLine"))
               );
               this.a.setTag(var2);
               this.a.e.onClick(this.a);
            } catch (Exception var3) {
            }
         }
      }
   };

   public LocationAutoCompleteTextView(Context var1) {
      super(var1);
      this.a();
   }

   public LocationAutoCompleteTextView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
   }

   public LocationAutoCompleteTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      this.c = new LocationAutoCompleteTextView.PlaceArrayAdapter(this, this.getContext(), 17367043, null, null);
      this.setAdapter(this.c);
      this.setThreshold(3);
      this.setOnItemClickListener(this.g);
   }

   private void a(Location var1) {
      if (Geocoder.isPresent()) {
         if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
         }

         if (this.getContext() != null && !((BaseActivity)this.getContext()).isFinishing() && this.isAttachedToWindow()) {
            ((BaseActivity)this.getContext()).k();
            this.d = new LocationAutoCompleteTextView.AddressLocatorTask(this.getContext(), this.h);
            this.d.execute(new Location[]{var1});
         }
      } else {
         UIUtils.a(this, this.getContext().getString(2131755307));
      }
   }

   @Override
   public void a(int var1) {
      this.c.a((GoogleApiClient)null);
   }

   @Override
   public void a(Bundle var1) {
      this.c.a(this.b);
   }

   @Override
   public void a(ConnectionResult var1) {
      UIUtils.a(this, this.getContext().getString(2131755307));
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.b == null) {
         this.b = new GoogleApiClient.Builder(this.getContext()).a(this).a(this).a(Places.a).b();
         this.b.e();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.d != null) {
         this.d.cancel(true);
         this.d = null;
      }

      if (this.b != null) {
         this.b.g();
         this.b = null;
      }
   }

   public void setOnClickListener(OnClickListener var1) {
      this.e = var1;
   }

   private static class AddressLocatorTask extends AsyncTask<Location, Void, Bundle> {
      private LocationFragment.AsyncGeocoderTaskProcessor a;
      private Context b;

      public AddressLocatorTask(Context var1, LocationFragment.AsyncGeocoderTaskProcessor var2) {
         this.b = var1.getApplicationContext();
         this.a = var2;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      protected Bundle a(Location... var1) {
         Bundle var4 = new Bundle();
         Geocoder var2 = new Geocoder(this.b);

         try {
            if (this.isCancelled()) {
               return var4;
            }
         } catch (Exception var13) {
            return var4;
         }

         try {
            GeoApiContext.Builder var3 = new GeoApiContext.Builder();
            GeoApiContext var17 = var3.apiKey(this.b.getString(2131755332)).build();
            LatLng var5 = new LatLng(var1[0].getLatitude(), var1[0].getLongitude());
            var4.putString("timezone", TimeZoneApi.getTimeZone(var17, var5).awaitIgnoreError().getID().replace("/", "\\/"));
            if (this.isCancelled()) {
               return var4;
            }
         } catch (Exception var12) {
            return var4;
         }

         try {
            var15 = var2.getFromLocation(var1[0].getLatitude(), var1[0].getLongitude(), 1);
            if (this.isCancelled()) {
               return var4;
            }
         } catch (Exception var11) {
            return var4;
         }

         if (var15 != null) {
            Address var19;
            try {
               if (var15.isEmpty()) {
                  return var4;
               }

               var19 = (Address)var15.get(0);
               var16 = var19.getLocality();
            } catch (Exception var10) {
               return var4;
            }

            label58:
            if (var16 == null) {
               try {
                  if (var19.getMaxAddressLineIndex() >= 2) {
                     var16 = var19.getAddressLine(1);
                     break label58;
                  }
               } catch (Exception var9) {
                  return var4;
               }

               try {
                  var16 = var19.getAddressLine(0);
               } catch (Exception var8) {
                  return var4;
               }
            }

            String var18 = var16;

            try {
               if (var16.contains(",")) {
                  var18 = var16.split(",")[0];
               }
            } catch (Exception var7) {
               return var4;
            }

            try {
               var4.putString("city", var18);
               var4.putString("state", var19.getAdminArea());
               var4.putString("country", var19.getCountryName());
               var4.putDouble("lat", var1[0].getLatitude());
               var4.putDouble("lng", var1[0].getLongitude());
               StringBuilder var14 = new StringBuilder();
               var4.putString("addressLine", var14.append(var19.getFeatureName()).append(" ").append(var19.getThoroughfare()).toString());
            } catch (Exception var6) {
            }
         }

         return var4;
      }

      protected void a(Bundle var1) {
         this.b = null;
         if (this.a != null && !this.isCancelled()) {
            this.a.a(var1);
         }
      }
   }

   private class PlaceArrayAdapter extends ArrayAdapter<LocationAutoCompleteTextView.PlaceArrayAdapter.PlaceAutocomplete> implements Filterable {
      final LocationAutoCompleteTextView a;
      private GoogleApiClient b;
      private AutocompleteFilter c;
      private LatLngBounds d;
      private ArrayList<LocationAutoCompleteTextView.PlaceArrayAdapter.PlaceAutocomplete> e;

      public PlaceArrayAdapter(LocationAutoCompleteTextView var1, Context var2, int var3, LatLngBounds var4, AutocompleteFilter var5) {
         super(var2, var3);
         this.a = var1;
         this.d = var4;
         this.c = var5;
      }

      private ArrayList<LocationAutoCompleteTextView.PlaceArrayAdapter.PlaceAutocomplete> a(CharSequence var1) {
         ArrayList var5;
         if (this.getContext() == null || ((BaseActivity)this.getContext()).isFinishing() || !this.a.isAttachedToWindow()) {
            var5 = null;
         } else if (this.b != null && this.b.j()) {
            AutocompletePredictionBuffer var2 = Places.c.a(this.b, var1.toString(), this.d, this.c).a(10L, TimeUnit.SECONDS);
            Status var6 = var2.a();
            if (!var6.c()) {
               Toast.makeText(this.getContext(), "Error: " + var6.toString(), 0).show();
               LogUtils.d("PlaceArrayAdapter", "Error getting place predictions: " + var6.toString());
               var2.c_();
               var5 = null;
            } else {
               LogUtils.c("PlaceArrayAdapter", "Query completed. Received " + var2.b() + " predictions.");
               Iterator var3 = var2.iterator();
               var5 = new ArrayList(var2.b());

               while (var3.hasNext()) {
                  AutocompletePrediction var4 = (AutocompletePrediction)var3.next();
                  var5.add(new LocationAutoCompleteTextView.PlaceArrayAdapter.PlaceAutocomplete(this, var4.a(), var4.a(null)));
               }

               var2.c_();
            }
         } else {
            LogUtils.d("PlaceArrayAdapter", "Google API client is not connected.");
            var5 = null;
         }

         return var5;
      }

      public LocationAutoCompleteTextView.PlaceArrayAdapter.PlaceAutocomplete a(int var1) {
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
            final LocationAutoCompleteTextView.PlaceArrayAdapter a;

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
         final LocationAutoCompleteTextView.PlaceArrayAdapter c;

         PlaceAutocomplete(LocationAutoCompleteTextView.PlaceArrayAdapter var1, CharSequence var2, CharSequence var3) {
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
