package com.google.maps.model;

import java.net.URL;
import org.joda.time.Instant;

/* JADX INFO: loaded from: classes.dex */
public class PlaceDetails {
    public AddressComponent[] addressComponents;
    public AlternatePlaceIds[] altIds;
    public String formattedAddress;
    public String formattedPhoneNumber;
    public Geometry geometry;
    public String[] htmlAttributions;
    public URL icon;
    public String internationalPhoneNumber;
    public String name;
    public OpeningHours openingHours;
    public boolean permanentlyClosed;
    public Photo[] photos;
    public String placeId;
    public PriceLevel priceLevel;
    public float rating;
    public Review[] reviews;
    public PlaceIdScope scope;
    public String[] types;
    public URL url;
    public int utcOffset;
    public String vicinity;
    public URL website;

    public static class AlternatePlaceIds {
        public String placeId;
        public PlaceIdScope scope;
    }

    public static class Review {
        public AspectRating[] aspects;
        public String authorName;
        public URL authorUrl;
        public String language;
        public int rating;
        public String text;
        public Instant time;

        public static class AspectRating {
            public int rating;
            public RatingType type;

            public enum RatingType {
                APPEAL,
                ATMOSPHERE,
                DECOR,
                FACILITIES,
                FOOD,
                OVERALL,
                QUALITY,
                SERVICE,
                UNKNOWN
            }
        }
    }
}
