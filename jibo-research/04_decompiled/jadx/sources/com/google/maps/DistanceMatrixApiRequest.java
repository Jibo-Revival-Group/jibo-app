package com.google.maps;

import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TransitRoutingPreference;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.joda.time.ReadableInstant;

/* JADX INFO: loaded from: classes.dex */
public class DistanceMatrixApiRequest extends PendingResultBase<DistanceMatrix, DistanceMatrixApiRequest, DistanceMatrixApi.Response> {
    public DistanceMatrixApiRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, DistanceMatrixApi.API_CONFIG, DistanceMatrixApi.Response.class);
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("origins")) {
            throw new IllegalArgumentException("Request must contain 'origins'");
        }
        if (!params().containsKey("destinations")) {
            throw new IllegalArgumentException("Request must contain 'destinations'");
        }
        if (TravelMode.TRANSIT.toString().equals(params().get("mode")) && params().containsKey("arrival_time") && params().containsKey("departure_time")) {
            throw new IllegalArgumentException("Transit request must not contain both a departureTime and an arrivalTime");
        }
    }

    public DistanceMatrixApiRequest origins(String... strArr) {
        return param("origins", StringJoin.join('|', strArr));
    }

    public DistanceMatrixApiRequest origins(LatLng... latLngArr) {
        return param("origins", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr));
    }

    public DistanceMatrixApiRequest destinations(String... strArr) {
        return param("destinations", StringJoin.join('|', strArr));
    }

    public DistanceMatrixApiRequest destinations(LatLng... latLngArr) {
        return param("destinations", StringJoin.join('|', (StringJoin.UrlValue[]) latLngArr));
    }

    public DistanceMatrixApiRequest mode(TravelMode travelMode) {
        if (TravelMode.DRIVING.equals(travelMode) || TravelMode.WALKING.equals(travelMode) || TravelMode.BICYCLING.equals(travelMode) || TravelMode.TRANSIT.equals(travelMode)) {
            return param("mode", travelMode);
        }
        throw new IllegalArgumentException("Distance Matrix API travel modes must be Driving, Transit, Walking or Bicycling");
    }

    public DistanceMatrixApiRequest avoid(DirectionsApi.RouteRestriction routeRestriction) {
        return param("avoid", routeRestriction);
    }

    public DistanceMatrixApiRequest units(Unit unit) {
        return param("units", unit);
    }

    public DistanceMatrixApiRequest departureTime(ReadableInstant readableInstant) {
        return param("departure_time", Long.toString(readableInstant.mo16580c() / 1000));
    }

    public DistanceMatrixApiRequest trafficModel(TrafficModel trafficModel) {
        return param("traffic_model", trafficModel);
    }

    public DistanceMatrixApiRequest arrivalTime(ReadableInstant readableInstant) {
        return param("arrival_time", Long.toString(readableInstant.mo16580c() / 1000));
    }

    public DistanceMatrixApiRequest transitModes(TransitMode... transitModeArr) {
        return param("transit_mode", StringJoin.join('|', (StringJoin.UrlValue[]) transitModeArr));
    }

    public DistanceMatrixApiRequest transitRoutingPreference(TransitRoutingPreference transitRoutingPreference) {
        return param("transit_routing_preference", transitRoutingPreference);
    }
}
