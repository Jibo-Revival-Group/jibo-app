package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import com.jibo.aws.integration.helpers.RobotHelper;

/* JADX INFO: loaded from: classes.dex */
public enum AddressType implements StringJoin.UrlValue {
    STREET_ADDRESS("street_address"),
    ROUTE("route"),
    INTERSECTION("intersection"),
    POLITICAL("political"),
    COUNTRY(RobotHelper.FIELD_COUNTRY),
    ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
    ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
    ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
    ADMINISTRATIVE_AREA_LEVEL_4("administrative_area_level_4"),
    ADMINISTRATIVE_AREA_LEVEL_5("administrative_area_level_5"),
    COLLOQUIAL_AREA("colloquial_area"),
    LOCALITY("locality"),
    WARD("ward"),
    SUBLOCALITY("sublocality"),
    SUBLOCALITY_LEVEL_1("sublocality_level_1"),
    SUBLOCALITY_LEVEL_2("sublocality_level_2"),
    SUBLOCALITY_LEVEL_3("sublocality_level_3"),
    SUBLOCALITY_LEVEL_4("sublocality_level_4"),
    SUBLOCALITY_LEVEL_5("sublocality_level_5"),
    NEIGHBORHOOD("neighborhood"),
    PREMISE("premise"),
    SUBPREMISE("subpremise"),
    POSTAL_CODE("postal_code"),
    POSTAL_CODE_PREFIX("postal_code_prefix"),
    NATURAL_FEATURE("natural_feature"),
    AIRPORT("airport"),
    UNIVERSITY("university"),
    PARK("park"),
    POINT_OF_INTEREST("point_of_interest"),
    ESTABLISHMENT("establishment"),
    BUS_STATION("bus_station"),
    TRAIN_STATION("train_station"),
    SUBWAY_STATION("subway_station"),
    TRANSIT_STATION("transit_station"),
    LIGHT_RAIL_STATION("light_rail_station"),
    CHURCH("church"),
    FINANCE("finance"),
    POST_OFFICE("post_office"),
    PLACE_OF_WORSHIP("place_of_worship"),
    POSTAL_TOWN("postal_town"),
    SYNAGOGUE("synagogue"),
    FOOD("food"),
    GROCERY_OR_SUPERMARKET("grocery_or_supermarket"),
    STORE("store"),
    LAWYER("lawyer"),
    HEALTH("health"),
    INSURANCE_AGENCY("insurance_agency"),
    GAS_STATION("gas_station"),
    CAR_DEALER("car_dealer"),
    CAR_REPAIR("car_repair"),
    MEAL_TAKEAWAY("meal_takeaway"),
    FURNITURE_STORE("furniture_store"),
    HOME_GOODS_STORE("home_goods_store"),
    SHOPPING_MALL("shopping_mall"),
    GYM("gym"),
    ACCOUNTING("accounting"),
    MOVING_COMPANY("moving_company"),
    LODGING("lodging"),
    STORAGE("storage"),
    UNKNOWN("unknown");

    private final String addressType;

    AddressType(String str) {
        this.addressType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.addressType;
    }

    public String toCanonicalLiteral() {
        return toString();
    }

    @Override // com.google.maps.internal.StringJoin.UrlValue
    public String toUrlValue() {
        if (this == UNKNOWN) {
            throw new UnsupportedOperationException("Shouldn't use AddressType.UNKNOWN in a request.");
        }
        return this.addressType;
    }
}
