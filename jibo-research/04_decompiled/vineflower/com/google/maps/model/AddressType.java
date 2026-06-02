package com.google.maps.model;

import com.google.maps.internal.StringJoin;

public enum AddressType implements StringJoin.UrlValue {
   ACCOUNTING("accounting"),
   ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
   ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
   ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
   ADMINISTRATIVE_AREA_LEVEL_4("administrative_area_level_4"),
   ADMINISTRATIVE_AREA_LEVEL_5("administrative_area_level_5"),
   AIRPORT("airport"),
   BUS_STATION("bus_station"),
   CAR_DEALER("car_dealer"),
   CAR_REPAIR("car_repair"),
   CHURCH("church"),
   COLLOQUIAL_AREA("colloquial_area"),
   COUNTRY("country"),
   ESTABLISHMENT("establishment"),
   FINANCE("finance"),
   FOOD("food"),
   FURNITURE_STORE("furniture_store"),
   GAS_STATION("gas_station"),
   GROCERY_OR_SUPERMARKET("grocery_or_supermarket"),
   GYM("gym"),
   HEALTH("health"),
   HOME_GOODS_STORE("home_goods_store"),
   INSURANCE_AGENCY("insurance_agency"),
   INTERSECTION("intersection"),
   LAWYER("lawyer"),
   LIGHT_RAIL_STATION("light_rail_station"),
   LOCALITY("locality"),
   LODGING("lodging"),
   MEAL_TAKEAWAY("meal_takeaway"),
   MOVING_COMPANY("moving_company"),
   NATURAL_FEATURE("natural_feature"),
   NEIGHBORHOOD("neighborhood"),
   PARK("park"),
   PLACE_OF_WORSHIP("place_of_worship"),
   POINT_OF_INTEREST("point_of_interest"),
   POLITICAL("political"),
   POSTAL_CODE("postal_code"),
   POSTAL_CODE_PREFIX("postal_code_prefix"),
   POSTAL_TOWN("postal_town"),
   POST_OFFICE("post_office"),
   PREMISE("premise"),
   ROUTE("route"),
   SHOPPING_MALL("shopping_mall"),
   STORAGE("storage"),
   STORE("store"),
   STREET_ADDRESS("street_address"),
   SUBLOCALITY("sublocality"),
   SUBLOCALITY_LEVEL_1("sublocality_level_1"),
   SUBLOCALITY_LEVEL_2("sublocality_level_2"),
   SUBLOCALITY_LEVEL_3("sublocality_level_3"),
   SUBLOCALITY_LEVEL_4("sublocality_level_4"),
   SUBLOCALITY_LEVEL_5("sublocality_level_5"),
   SUBPREMISE("subpremise"),
   SUBWAY_STATION("subway_station"),
   SYNAGOGUE("synagogue"),
   TRAIN_STATION("train_station"),
   TRANSIT_STATION("transit_station"),
   UNIVERSITY("university"),
   UNKNOWN("unknown"),
   WARD("ward");

   private static final AddressType[] $VALUES = new AddressType[]{
      AddressType.STREET_ADDRESS,
      AddressType.ROUTE,
      AddressType.INTERSECTION,
      AddressType.POLITICAL,
      AddressType.COUNTRY,
      AddressType.ADMINISTRATIVE_AREA_LEVEL_1,
      AddressType.ADMINISTRATIVE_AREA_LEVEL_2,
      AddressType.ADMINISTRATIVE_AREA_LEVEL_3,
      AddressType.ADMINISTRATIVE_AREA_LEVEL_4,
      AddressType.ADMINISTRATIVE_AREA_LEVEL_5,
      AddressType.COLLOQUIAL_AREA,
      AddressType.LOCALITY,
      AddressType.WARD,
      AddressType.SUBLOCALITY,
      AddressType.SUBLOCALITY_LEVEL_1,
      AddressType.SUBLOCALITY_LEVEL_2,
      AddressType.SUBLOCALITY_LEVEL_3,
      AddressType.SUBLOCALITY_LEVEL_4,
      AddressType.SUBLOCALITY_LEVEL_5,
      AddressType.NEIGHBORHOOD,
      AddressType.PREMISE,
      AddressType.SUBPREMISE,
      AddressType.POSTAL_CODE,
      AddressType.POSTAL_CODE_PREFIX,
      AddressType.NATURAL_FEATURE,
      AddressType.AIRPORT,
      AddressType.UNIVERSITY,
      AddressType.PARK,
      AddressType.POINT_OF_INTEREST,
      AddressType.ESTABLISHMENT,
      AddressType.BUS_STATION,
      AddressType.TRAIN_STATION,
      AddressType.SUBWAY_STATION,
      AddressType.TRANSIT_STATION,
      AddressType.LIGHT_RAIL_STATION,
      AddressType.CHURCH,
      AddressType.FINANCE,
      AddressType.POST_OFFICE,
      AddressType.PLACE_OF_WORSHIP,
      AddressType.POSTAL_TOWN,
      AddressType.SYNAGOGUE,
      AddressType.FOOD,
      AddressType.GROCERY_OR_SUPERMARKET,
      AddressType.STORE,
      AddressType.LAWYER,
      AddressType.HEALTH,
      AddressType.INSURANCE_AGENCY,
      AddressType.GAS_STATION,
      AddressType.CAR_DEALER,
      AddressType.CAR_REPAIR,
      AddressType.MEAL_TAKEAWAY,
      AddressType.FURNITURE_STORE,
      AddressType.HOME_GOODS_STORE,
      AddressType.SHOPPING_MALL,
      AddressType.GYM,
      AddressType.ACCOUNTING,
      AddressType.MOVING_COMPANY,
      AddressType.LODGING,
      AddressType.STORAGE,
      AddressType.UNKNOWN
   };
   private final String addressType;

   AddressType(String var3) {
      this.addressType = var3;
   }

   public String toCanonicalLiteral() {
      return this.toString();
   }

   @Override
   public String toString() {
      return this.addressType;
   }

   @Override
   public String toUrlValue() {
      if (this == UNKNOWN) {
         throw new UnsupportedOperationException("Shouldn't use AddressType.UNKNOWN in a request.");
      } else {
         return this.addressType;
      }
   }
}
