package com.google.maps.model;

public enum AddressComponentType {
   ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
   ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
   ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
   ADMINISTRATIVE_AREA_LEVEL_4("administrative_area_level_4"),
   ADMINISTRATIVE_AREA_LEVEL_5("administrative_area_level_5"),
   AIRPORT("airport"),
   BUS_STATION("bus_station"),
   COLLOQUIAL_AREA("colloquial_area"),
   COUNTRY("country"),
   ESTABLISHMENT("establishment"),
   FLOOR("floor"),
   INTERSECTION("intersection"),
   LIGHT_RAIL_STATION("light_rail_station"),
   LOCALITY("locality"),
   NATURAL_FEATURE("natural_feature"),
   NEIGHBORHOOD("neighborhood"),
   PARK("park"),
   PARKING("parking"),
   POINT_OF_INTEREST("point_of_interest"),
   POLITICAL("political"),
   POSTAL_CODE("postal_code"),
   POSTAL_CODE_PREFIX("postal_code_prefix"),
   POSTAL_CODE_SUFFIX("postal_code_suffix"),
   POSTAL_TOWN("postal_town"),
   POST_BOX("post_box"),
   PREMISE("premise"),
   ROOM("room"),
   ROUTE("route"),
   STREET_ADDRESS("street_address"),
   STREET_NUMBER("street_number"),
   SUBLOCALITY("sublocality"),
   SUBLOCALITY_LEVEL_1("sublocality_level_1"),
   SUBLOCALITY_LEVEL_2("sublocality_level_2"),
   SUBLOCALITY_LEVEL_3("sublocality_level_3"),
   SUBLOCALITY_LEVEL_4("sublocality_level_4"),
   SUBLOCALITY_LEVEL_5("sublocality_level_5"),
   SUBPREMISE("subpremise"),
   SUBWAY_STATION("subway_station"),
   TRAIN_STATION("train_station"),
   TRANSIT_STATION("transit_station"),
   UNKNOWN("unknown"),
   WARD("ward");

   private static final AddressComponentType[] $VALUES = new AddressComponentType[]{
      AddressComponentType.STREET_ADDRESS,
      AddressComponentType.ROUTE,
      AddressComponentType.INTERSECTION,
      AddressComponentType.POLITICAL,
      AddressComponentType.COUNTRY,
      AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1,
      AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2,
      AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_3,
      AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_4,
      AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_5,
      AddressComponentType.COLLOQUIAL_AREA,
      AddressComponentType.LOCALITY,
      AddressComponentType.WARD,
      AddressComponentType.SUBLOCALITY,
      AddressComponentType.SUBLOCALITY_LEVEL_1,
      AddressComponentType.SUBLOCALITY_LEVEL_2,
      AddressComponentType.SUBLOCALITY_LEVEL_3,
      AddressComponentType.SUBLOCALITY_LEVEL_4,
      AddressComponentType.SUBLOCALITY_LEVEL_5,
      AddressComponentType.NEIGHBORHOOD,
      AddressComponentType.PREMISE,
      AddressComponentType.SUBPREMISE,
      AddressComponentType.POSTAL_CODE,
      AddressComponentType.POSTAL_CODE_PREFIX,
      AddressComponentType.POSTAL_CODE_SUFFIX,
      AddressComponentType.NATURAL_FEATURE,
      AddressComponentType.AIRPORT,
      AddressComponentType.PARK,
      AddressComponentType.POINT_OF_INTEREST,
      AddressComponentType.FLOOR,
      AddressComponentType.ESTABLISHMENT,
      AddressComponentType.PARKING,
      AddressComponentType.POST_BOX,
      AddressComponentType.POSTAL_TOWN,
      AddressComponentType.ROOM,
      AddressComponentType.STREET_NUMBER,
      AddressComponentType.BUS_STATION,
      AddressComponentType.TRAIN_STATION,
      AddressComponentType.SUBWAY_STATION,
      AddressComponentType.TRANSIT_STATION,
      AddressComponentType.LIGHT_RAIL_STATION,
      AddressComponentType.UNKNOWN
   };
   private final String addressComponentType;

   AddressComponentType(String var3) {
      this.addressComponentType = var3;
   }

   public String toCanonicalLiteral() {
      return this.toString();
   }

   @Override
   public String toString() {
      return this.addressComponentType;
   }
}
