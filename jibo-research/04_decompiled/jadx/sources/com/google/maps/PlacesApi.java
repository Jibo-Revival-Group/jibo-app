package com.google.maps;

import com.google.maps.model.LatLng;

/* JADX INFO: loaded from: classes.dex */
public class PlacesApi {
    private PlacesApi() {
    }

    public static NearbySearchRequest nearbySearchQuery(GeoApiContext geoApiContext, LatLng latLng) {
        NearbySearchRequest nearbySearchRequest = new NearbySearchRequest(geoApiContext);
        nearbySearchRequest.location(latLng);
        return nearbySearchRequest;
    }

    public static NearbySearchRequest nearbySearchNextPage(GeoApiContext geoApiContext, String str) {
        NearbySearchRequest nearbySearchRequest = new NearbySearchRequest(geoApiContext);
        nearbySearchRequest.pageToken(str);
        return nearbySearchRequest;
    }

    public static TextSearchRequest textSearchQuery(GeoApiContext geoApiContext, String str) {
        TextSearchRequest textSearchRequest = new TextSearchRequest(geoApiContext);
        textSearchRequest.query(str);
        return textSearchRequest;
    }

    public static TextSearchRequest textSearchNextPage(GeoApiContext geoApiContext, String str) {
        TextSearchRequest textSearchRequest = new TextSearchRequest(geoApiContext);
        textSearchRequest.pageToken(str);
        return textSearchRequest;
    }

    public static RadarSearchRequest radarSearchQuery(GeoApiContext geoApiContext, LatLng latLng, int i) {
        RadarSearchRequest radarSearchRequest = new RadarSearchRequest(geoApiContext);
        radarSearchRequest.location(latLng);
        radarSearchRequest.radius(i);
        return radarSearchRequest;
    }

    public static PlaceDetailsRequest placeDetails(GeoApiContext geoApiContext, String str) {
        PlaceDetailsRequest placeDetailsRequest = new PlaceDetailsRequest(geoApiContext);
        placeDetailsRequest.placeId(str);
        return placeDetailsRequest;
    }

    public static PhotoRequest photo(GeoApiContext geoApiContext, String str) {
        PhotoRequest photoRequest = new PhotoRequest(geoApiContext);
        photoRequest.photoReference(str);
        return photoRequest;
    }

    public static PlaceAutocompleteRequest placeAutocomplete(GeoApiContext geoApiContext, String str) {
        PlaceAutocompleteRequest placeAutocompleteRequest = new PlaceAutocompleteRequest(geoApiContext);
        placeAutocompleteRequest.input(str);
        return placeAutocompleteRequest;
    }

    public static QueryAutocompleteRequest queryAutocomplete(GeoApiContext geoApiContext, String str) {
        QueryAutocompleteRequest queryAutocompleteRequest = new QueryAutocompleteRequest(geoApiContext);
        queryAutocompleteRequest.input(str);
        return queryAutocompleteRequest;
    }
}
