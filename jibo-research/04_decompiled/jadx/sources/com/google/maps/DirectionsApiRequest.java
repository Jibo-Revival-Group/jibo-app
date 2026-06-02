package com.google.maps;

import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.maps.DirectionsApi;
import com.google.maps.internal.StringJoin;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TransitMode;
import com.google.maps.model.TransitRoutingPreference;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.joda.time.ReadableInstant;

/* JADX INFO: loaded from: classes.dex */
public class DirectionsApiRequest extends PendingResultBase<DirectionsResult, DirectionsApiRequest, DirectionsApi.Response> {
    protected boolean optimizeWaypoints;
    protected String[] waypoints;

    DirectionsApiRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, DirectionsApi.API_CONFIG, DirectionsApi.Response.class);
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (!params().containsKey("origin")) {
            throw new IllegalArgumentException("Request must contain 'origin'");
        }
        if (!params().containsKey(ShareConstants.DESTINATION)) {
            throw new IllegalArgumentException("Request must contain 'destination'");
        }
        if (TravelMode.TRANSIT.toString().equals(params().get("mode")) && params().containsKey("arrival_time") && params().containsKey("departure_time")) {
            throw new IllegalArgumentException("Transit request must not contain both a departureTime and an arrivalTime");
        }
        if (params().containsKey("traffic_model") && !params().containsKey("departure_time")) {
            throw new IllegalArgumentException("Specifying a traffic model requires that departure time be provided.");
        }
    }

    public DirectionsApiRequest origin(String str) {
        return param("origin", str);
    }

    public DirectionsApiRequest destination(String str) {
        return param(ShareConstants.DESTINATION, str);
    }

    public DirectionsApiRequest origin(LatLng latLng) {
        return origin(latLng.toString());
    }

    public DirectionsApiRequest destination(LatLng latLng) {
        return destination(latLng.toString());
    }

    public DirectionsApiRequest mode(TravelMode travelMode) {
        return param("mode", travelMode);
    }

    public DirectionsApiRequest avoid(DirectionsApi.RouteRestriction... routeRestrictionArr) {
        return param("avoid", StringJoin.join('|', (StringJoin.UrlValue[]) routeRestrictionArr));
    }

    public DirectionsApiRequest units(Unit unit) {
        return param("units", unit);
    }

    public DirectionsApiRequest region(String str) {
        return param("region", str);
    }

    public DirectionsApiRequest arrivalTime(ReadableInstant readableInstant) {
        return param("arrival_time", Long.toString(readableInstant.mo16580c() / 1000));
    }

    public DirectionsApiRequest departureTime(ReadableInstant readableInstant) {
        return param("departure_time", Long.toString(readableInstant.mo16580c() / 1000));
    }

    public DirectionsApiRequest waypoints(String... strArr) {
        this.waypoints = strArr;
        if (strArr == null || strArr.length == 0) {
            return this;
        }
        if (strArr.length == 1) {
            return param("waypoints", strArr[0]);
        }
        return param("waypoints", (this.optimizeWaypoints ? "optimize:true|" : "") + StringJoin.join('|', strArr));
    }

    public DirectionsApiRequest waypoints(LatLng... latLngArr) {
        if (latLngArr != null) {
            int length = latLngArr.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = latLngArr[i].toString();
            }
            return waypoints(strArr);
        }
        return this;
    }

    public DirectionsApiRequest optimizeWaypoints(boolean z) {
        this.optimizeWaypoints = z;
        if (this.waypoints != null) {
            return waypoints(this.waypoints);
        }
        return this;
    }

    public DirectionsApiRequest alternatives(boolean z) {
        return z ? param("alternatives", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) : param("alternatives", "false");
    }

    public DirectionsApiRequest transitMode(TransitMode... transitModeArr) {
        return param("transit_mode", StringJoin.join('|', (StringJoin.UrlValue[]) transitModeArr));
    }

    public DirectionsApiRequest transitRoutingPreference(TransitRoutingPreference transitRoutingPreference) {
        return param("transit_routing_preference", transitRoutingPreference);
    }

    public DirectionsApiRequest trafficModel(TrafficModel trafficModel) {
        return param("traffic_model", trafficModel);
    }
}
