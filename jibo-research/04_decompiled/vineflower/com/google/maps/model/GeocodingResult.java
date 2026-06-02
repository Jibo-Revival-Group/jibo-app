package com.google.maps.model;

public class GeocodingResult {
   public AddressComponent[] addressComponents;
   public String formattedAddress;
   public Geometry geometry;
   public boolean partialMatch;
   public String placeId;
   public String[] postcodeLocalities;
   public AddressType[] types;
}
