package com.google.maps.model;

import java.net.URL;
import org.joda.time.Instant;

public class PlaceDetails {
   public AddressComponent[] addressComponents;
   public PlaceDetails.AlternatePlaceIds[] altIds;
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
   public PlaceDetails.Review[] reviews;
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
      public PlaceDetails.Review.AspectRating[] aspects;
      public String authorName;
      public URL authorUrl;
      public String language;
      public int rating;
      public String text;
      public Instant time;

      public static class AspectRating {
         public int rating;
         public PlaceDetails.Review.AspectRating.RatingType type;

         public enum RatingType {
            APPEAL,
            ATMOSPHERE,
            DECOR,
            FACILITIES,
            FOOD,
            OVERALL,
            QUALITY,
            SERVICE,
            UNKNOWN;

            private static final PlaceDetails.Review.AspectRating.RatingType[] $VALUES = new PlaceDetails.Review.AspectRating.RatingType[]{
               PlaceDetails.Review.AspectRating.RatingType.APPEAL,
               PlaceDetails.Review.AspectRating.RatingType.ATMOSPHERE,
               PlaceDetails.Review.AspectRating.RatingType.DECOR,
               PlaceDetails.Review.AspectRating.RatingType.FACILITIES,
               PlaceDetails.Review.AspectRating.RatingType.FOOD,
               PlaceDetails.Review.AspectRating.RatingType.OVERALL,
               PlaceDetails.Review.AspectRating.RatingType.QUALITY,
               PlaceDetails.Review.AspectRating.RatingType.SERVICE,
               PlaceDetails.Review.AspectRating.RatingType.UNKNOWN
            };
         }
      }
   }
}
