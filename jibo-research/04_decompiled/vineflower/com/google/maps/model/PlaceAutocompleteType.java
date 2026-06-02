package com.google.maps.model;

import com.google.maps.internal.StringJoin;

public enum PlaceAutocompleteType implements StringJoin.UrlValue {
   ADDRESS("address"),
   CITIES("(cities)"),
   ESTABLISHMENT("establishment"),
   GEOCODE("geocode"),
   REGIONS("(regions)");

   private static final PlaceAutocompleteType[] $VALUES = new PlaceAutocompleteType[]{
      PlaceAutocompleteType.GEOCODE,
      PlaceAutocompleteType.ADDRESS,
      PlaceAutocompleteType.ESTABLISHMENT,
      PlaceAutocompleteType.REGIONS,
      PlaceAutocompleteType.CITIES
   };
   private String placeType;

   PlaceAutocompleteType(String var3) {
      this.placeType = var3;
   }

   @Override
   public String toString() {
      return this.placeType;
   }

   @Override
   public String toUrlValue() {
      return this.placeType;
   }
}
