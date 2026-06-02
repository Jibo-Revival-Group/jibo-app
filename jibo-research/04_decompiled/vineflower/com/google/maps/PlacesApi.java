package com.google.maps;

import com.google.maps.model.LatLng;

public class PlacesApi {
   private PlacesApi() {
   }

   public static NearbySearchRequest nearbySearchNextPage(GeoApiContext var0, String var1) {
      NearbySearchRequest var2 = new NearbySearchRequest(var0);
      var2.pageToken(var1);
      return var2;
   }

   public static NearbySearchRequest nearbySearchQuery(GeoApiContext var0, LatLng var1) {
      NearbySearchRequest var2 = new NearbySearchRequest(var0);
      var2.location(var1);
      return var2;
   }

   public static PhotoRequest photo(GeoApiContext var0, String var1) {
      PhotoRequest var2 = new PhotoRequest(var0);
      var2.photoReference(var1);
      return var2;
   }

   public static PlaceAutocompleteRequest placeAutocomplete(GeoApiContext var0, String var1) {
      PlaceAutocompleteRequest var2 = new PlaceAutocompleteRequest(var0);
      var2.input(var1);
      return var2;
   }

   public static PlaceDetailsRequest placeDetails(GeoApiContext var0, String var1) {
      PlaceDetailsRequest var2 = new PlaceDetailsRequest(var0);
      var2.placeId(var1);
      return var2;
   }

   public static QueryAutocompleteRequest queryAutocomplete(GeoApiContext var0, String var1) {
      QueryAutocompleteRequest var2 = new QueryAutocompleteRequest(var0);
      var2.input(var1);
      return var2;
   }

   public static RadarSearchRequest radarSearchQuery(GeoApiContext var0, LatLng var1, int var2) {
      RadarSearchRequest var3 = new RadarSearchRequest(var0);
      var3.location(var1);
      var3.radius(var2);
      return var3;
   }

   public static TextSearchRequest textSearchNextPage(GeoApiContext var0, String var1) {
      TextSearchRequest var2 = new TextSearchRequest(var0);
      var2.pageToken(var1);
      return var2;
   }

   public static TextSearchRequest textSearchQuery(GeoApiContext var0, String var1) {
      TextSearchRequest var2 = new TextSearchRequest(var0);
      var2.query(var1);
      return var2;
   }
}
