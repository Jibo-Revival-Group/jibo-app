package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.GeolocationApi;
import java.io.IOException;
import java.util.logging.Logger;

public class GeolocationResponseAdapter extends TypeAdapter<GeolocationApi.Response> {
   private static final Logger LOG = Logger.getLogger(GeolocationApi.Response.class.getName());

   public GeolocationApi.Response read(JsonReader var1) throws IOException {
      GeolocationApi.Response var5;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var5 = null;
      } else {
         GeolocationApi.Response var2 = new GeolocationApi.Response();
         LatLngAdapter var3 = new LatLngAdapter();
         var1.c();

         while (var1.e()) {
            String var4 = var1.g();
            if (var4.equals("location")) {
               var2.location = var3.read(var1);
            } else if (var4.equals("accuracy")) {
               var2.accuracy = var1.k();
            } else if (var4.equals("error")) {
               var1.c();

               while (var1.e()) {
                  var4 = var1.g();
                  if (var4.equals("code")) {
                     var2.code = var1.m();
                  } else if (var4.equals("message")) {
                     var2.message = var1.h();
                  } else if (var4.equals("errors")) {
                     var1.a();

                     while (var1.e()) {
                        var1.c();

                        while (var1.e()) {
                           var4 = var1.g();
                           if (var4.equals("reason")) {
                              var2.reason = var1.h();
                           } else if (var4.equals("domain")) {
                              var2.domain = var1.h();
                           } else if (var4.equals("debugInfo")) {
                              var2.debugInfo = var1.h();
                           } else if (var4.equals("message")) {
                              var1.h();
                           } else if (var4.equals("location")) {
                              var1.h();
                           } else if (var4.equals("locationType")) {
                              var1.h();
                           }
                        }

                        var1.d();
                     }

                     var1.b();
                  }
               }

               var1.d();
            }
         }

         var1.d();
         var5 = var2;
      }

      return var5;
   }

   public void write(JsonWriter var1, GeolocationApi.Response var2) throws IOException {
      throw new UnsupportedOperationException("Unimplemented method.");
   }
}
