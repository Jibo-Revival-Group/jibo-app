package com.jibo.ui.fragment.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;
import com.amazonaws.handlers.AsyncHandler;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.gson.JsonObject;
import com.google.maps.GeoApiContext;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;
import com.jibo.JiboAnalytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.PermissionUtil;
import com.jibo.utils.UIUtils;

public class LocationFragment extends BaseFragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   public static final String d = LocationFragment.class.getSimpleName();
   private GoogleApiClient a;
   private LocationFragment.AddressLocatorTask b;
   protected JiboRobotPropertiesAsyncClient e;
   protected String l;
   protected String m;
   protected LocationFragment.AsyncGeocoderTaskProcessor n = new LocationFragment.AsyncGeocoderTaskProcessor(this) {
      final LocationFragment a;

      {
         this.a = var1;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void a(Bundle var1) {
         if (this.a.d()) {
            SpannableStringBuilder var2;
            label27: {
               String var3 = this.a.getString(2131755307);
               var2 = new SpannableStringBuilder(var3);
               var2.setSpan(new StyleSpan(1), var3.lastIndexOf(" "), var3.length(), 33);
               if (var1 != null) {
                  try {
                     if (!var1.isEmpty() && this.a.e != null) {
                        break label27;
                     }
                  } catch (Exception var8) {
                     this.a.o.b(var2);
                     this.a.o = null;
                     return;
                  }
               }

               try {
                  this.a.o.b(var2);
                  this.a.o = null;
               } catch (Exception var7) {
                  this.a.o.b(var2);
                  this.a.o = null;
                  return;
               }
            }

            try {
               JiboRobotPropertiesAsyncClient var4 = this.a.e;
               String var5 = this.a.k.getRobotFriendlyId();
               AsyncHandler var9 = new AsyncHandler<GetRobotRequest, Robot>(this, var2, var1) {
                  final SpannableStringBuilder a;
                  final Bundle b;
                  final <unrepresentable> c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3;
                  }

                  public void a(GetRobotRequest var1, Robot var2x) {
                     if (this.c.a.d()) {
                        JsonObject var4x = new JsonObject();
                        var4x.a("lat", this.b.getDouble("lat"));
                        var4x.a("lng", this.b.getDouble("lng"));
                        var4x.a("city", this.b.getString("city"));
                        var4x.a("state", this.b.getString("state"));
                        var4x.a("zipcode", this.b.getString("zipcode"));
                        var4x.a("country", this.b.getString("country"));
                        var4x.a("countryCode", this.b.getString("countryCode"));
                        var4x.a("timezone", this.b.getString("timezone", this.b.getString("timezone")));
                        var2x.getPayload().a("locationOverride", var4x);
                        var2x.getPayload().a("timezone", this.b.getString("timezone", this.b.getString("timezone")));
                        var2x.getPayload().a("avatar");
                        var2x.getPayload().a("connectedAt");
                        var2x.getPayload().a("SSID");
                        var2x.getPayload().a("serialNumber");
                        var2x.getPayload().a("platform");

                        try {
                           this.c.a.e.updateRobot(var2x);
                           this.c.a.l = RobotHelper.getLocation(var2x);
                           this.c.a.m = RobotHelper.getTimeZone(var2x);
                           LocationFragment var5x = this.c.a;
                           Runnable var7 = new Runnable(this) {
                              final <unrepresentable> a;

                              {
                                 this.a = var1;
                              }

                              @Override
                              public void run() {
                                 this.a.c.a.a();
                              }
                           };
                           var5x.a(var7);
                           String var6 = this.c.a.getString(2131755532);
                           this.c.a.o.a(var6);
                           this.c.a.o = null;
                        } catch (Exception var3) {
                           this.c.a.a(var3, "update robot", false);
                           this.c.a.o.b(this.a);
                           this.c.a.o = null;
                        }
                     }
                  }

                  @Override
                  public void onError(Exception var1) {
                     this.c.a.o.b(this.a);
                     this.c.a.o = null;
                     this.c.a.a(var1, "get robot properties", false);
                  }
               };
               var4.getRobot(var5, var9);
            } catch (Exception var6) {
               this.a.o.b(var2);
               this.a.o = null;
            }
         }
      }
   };
   protected CircleProgressFragment o;
   @BindView
   protected TextView txtLocation;
   @BindView
   protected TextView txtTimezone;

   private void a(Location var1) {
      if (Geocoder.isPresent()) {
         if (this.o != null) {
            this.o.a();
            this.o = null;
         }

         if (this.b != null) {
            this.b.cancel(true);
            this.b = null;
         }

         this.o = new CircleProgressFragment();
         String var2 = this.getString(2131755533);
         this.o.c(var2);
         this.o.show(this.getActivity().getSupportFragmentManager(), "CircleFragment");
         this.b = new LocationFragment.AddressLocatorTask(this.getActivity(), this.n);
         this.b.execute(new Location[]{var1});
      } else {
         UIUtils.a(this.getView(), this.getString(2131755307));
      }
   }

   private void b() {
      if (this.a == null) {
         this.a = new GoogleApiClient.Builder(this.getActivity()).a(this).a(this).a(LocationServices.a).b();
         this.a.e();
      }
   }

   private void q() {
      this.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 1);
   }

   @SuppressLint("MissingPermission")
   private void r() {
      if (LocationServices.b.b(this.a).a()) {
         Location var1 = LocationServices.b.a(this.a);
         if (var1 != null) {
            this.a(var1);
         } else {
            UIUtils.a(this.getView(), this.getString(2131755307));
         }
      } else {
         AlertDialog.Builder var2 = new AlertDialog.Builder(this.getActivity());
         var2.a(2131755574, new OnClickListener(this) {
            final LocationFragment a;

            {
               this.a = var1;
            }

            public void onClick(DialogInterface var1, int var2x) {
               Intent var3 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
               this.a.startActivity(var3);
            }
         });
         var2.b(2131755126, new OnClickListener(this) {
            final LocationFragment a;

            {
               this.a = var1;
            }

            public void onClick(DialogInterface var1, int var2) {
               var1.dismiss();
            }
         });
         var2.a(2131756040);
         var2.b(2131755498);
         var2.b().show();
      }
   }

   protected void a() {
      if (this.txtLocation != null) {
         StringBuilder var2 = new StringBuilder();
         String var1;
         if (TextUtils.isEmpty(this.l)) {
            var1 = this.getString(2131755640);
         } else {
            var1 = this.l;
         }

         var2.append(var1);
         this.txtLocation.setText(var2.toString());
         if (this.m != null) {
            var1 = this.m.replace("\\/", "/");
         } else {
            var1 = "";
         }

         this.txtTimezone.setText(RobotHelper.getTimeZoneFriendly(var1, this.getString(2131755802)));
      }
   }

   @Override
   public void a(int var1) {
      UIUtils.a(this.getView(), this.getString(2131755307));
   }

   @Override
   public void a(Bundle var1) {
      this.r();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   public void a(ConnectionResult var1) {
      UIUtils.a(this.getView(), this.getString(2131755307));
   }

   protected void a(LocationFragment.ManualLocationFragmentListener var1) {
      SingleFragmentActivity.Builder var2 = new SingleFragmentActivity.Builder(this, ManualLocationFragment.class.getName());
      if (var1 != null) {
         var1.a(var2);
      }

      var2.a(1019);
   }

   @OnClick
   @Optional
   public void btnSetLocationClick(View var1) {
      JiboAnalytics.g(this.getActivity(), JiboAnalytics.an);
      if (PermissionUtil.b(this.getActivity())) {
         if (this.a == null) {
            this.b();
         } else if (!this.a.j()) {
            this.a.e();
         } else {
            this.r();
         }
      } else {
         this.q();
      }
   }

   @Override
   protected String o() {
      return this.getString(2131756040);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 1019 && var2 == -1) {
         Location var4 = new Location("MANUALLY_ENTERED");
         var4.setLongitude(var3.getDoubleExtra("ARGS_LONGITUDE", 0.0));
         var4.setLatitude(var3.getDoubleExtra("ARGS_LATITUDE", 0.0));
         this.a(var4);
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.l = var1.getString("ARGS_LOCATION");
         this.m = var1.getString("timezone");
      } else if (this.getArguments() != null) {
         this.l = this.getArguments().getString("ARGS_LOCATION");
         this.m = this.getArguments().getString("timezone");
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427465, var2, false);
   }

   @Override
   public void onDestroyView() {
      if (this.o != null) {
         this.o.a();
      }

      if (this.a != null) {
         this.a.g();
      }

      super.onDestroyView();
   }

   @Override
   public void onPause() {
      super.onPause();
      if (this.b != null) {
         this.b.cancel(true);
         this.b = null;
      }
   }

   @Override
   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      int var5 = 0;
      if (var3.length > 0) {
         int var6 = var3.length;
         int var4 = 0;

         while (var5 < var6) {
            var4 += var3[var5];
            var5++;
         }

         if (var4 == 0) {
            switch (var1) {
               case 1:
                  this.b();
            }
         }
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString("ARGS_LOCATION", this.l);
      var1.putString("timezone", this.m);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.a();
      Account var3 = EntityData.a(this.getActivity()).i();
      if (var3 != null && LoopHelper.isOwner(this.k, var3.getId())) {
         this.e = EntityData.a(this.getActivity()).g();
      }
   }

   @OnClick
   @Optional
   public void setManuallyClick(View var1) {
      this.a((LocationFragment.ManualLocationFragmentListener)null);
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
            GeoApiContext var16 = var3.apiKey(this.b.getString(2131755332)).build();
            LatLng var5 = new LatLng(var1[0].getLatitude(), var1[0].getLongitude());
            var4.putString("timezone", TimeZoneApi.getTimeZone(var16, var5).awaitIgnoreError().getID().replace("/", "\\/"));
            if (this.isCancelled()) {
               return var4;
            }
         } catch (Exception var12) {
            return var4;
         }

         try {
            var14 = var2.getFromLocation(var1[0].getLatitude(), var1[0].getLongitude(), 1);
            if (this.isCancelled()) {
               return var4;
            }
         } catch (Exception var11) {
            return var4;
         }

         if (var14 != null) {
            Address var18;
            try {
               if (var14.isEmpty()) {
                  return var4;
               }

               var18 = (Address)var14.get(0);
               var15 = var18.getLocality();
            } catch (Exception var10) {
               return var4;
            }

            label58:
            if (var15 == null) {
               try {
                  if (var18.getMaxAddressLineIndex() >= 2) {
                     var15 = var18.getAddressLine(1);
                     break label58;
                  }
               } catch (Exception var9) {
                  return var4;
               }

               try {
                  var15 = var18.getAddressLine(0);
               } catch (Exception var8) {
                  return var4;
               }
            }

            String var17 = var15;

            try {
               if (var15.contains(",")) {
                  var17 = var15.split(",")[0];
               }
            } catch (Exception var7) {
               return var4;
            }

            try {
               var4.putString("city", var17);
               var4.putString("state", var18.getAdminArea());
               var4.putString("zipcode", var18.getPostalCode());
               var4.putString("country", var18.getCountryName());
               var4.putString("countryCode", var18.getCountryCode());
               var4.putDouble("lat", var1[0].getLatitude());
               var4.putDouble("lng", var1[0].getLongitude());
               var4.putString("addressLine", var18.getAddressLine(0));
            } catch (Exception var6) {
            }
         }

         return var4;
      }

      protected void a(Bundle var1) {
         if (this.a != null && !this.isCancelled()) {
            this.a.a(var1);
         }
      }
   }

   public interface AsyncGeocoderTaskProcessor {
      void a(Bundle var1);
   }

   public interface ManualLocationFragmentListener {
      void a(SingleFragmentActivity.Builder var1);
   }
}
