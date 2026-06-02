package com.google.maps;

import com.google.gson.Gson;
import com.google.maps.GeolocationApi;
import com.google.maps.model.CellTower;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.WifiAccessPoint;

/* JADX INFO: loaded from: classes.dex */
public class GeolocationApiRequest extends PendingResultBase<GeolocationResult, GeolocationApiRequest, GeolocationApi.Response> {
    private GeolocationPayload.GeolocationPayloadBuilder builder;
    private GeolocationPayload payload;

    GeolocationApiRequest(GeoApiContext geoApiContext) {
        super(geoApiContext, GeolocationApi.GEOLOCATION_API_CONFIG, GeolocationApi.Response.class);
        this.payload = null;
        this.builder = null;
        this.builder = new GeolocationPayload.GeolocationPayloadBuilder();
    }

    @Override // com.google.maps.PendingResultBase
    protected void validateRequest() {
        if (this.payload.considerIp != null && !this.payload.considerIp.booleanValue() && this.payload.wifiAccessPoints != null && this.payload.wifiAccessPoints.length < 2) {
            throw new IllegalArgumentException("Request must contain two or more 'Wifi Access Points'");
        }
    }

    public GeolocationApiRequest HomeMobileCountryCode(int i) {
        this.builder.HomeMobileCountryCode(i);
        return this;
    }

    public GeolocationApiRequest HomeMobileNetworkCode(int i) {
        this.builder.HomeMobileNetworkCode(i);
        return this;
    }

    public GeolocationApiRequest RadioType(String str) {
        this.builder.RadioType(str);
        return this;
    }

    public GeolocationApiRequest Carrier(String str) {
        this.builder.Carrier(str);
        return this;
    }

    public GeolocationApiRequest ConsiderIp(boolean z) {
        this.builder.ConsiderIp(z);
        return this;
    }

    public GeolocationApiRequest CellTowers(CellTower[] cellTowerArr) {
        this.builder.CellTowers(cellTowerArr);
        return this;
    }

    public GeolocationApiRequest AddCellTower(CellTower cellTower) {
        this.builder.AddCellTower(cellTower);
        return this;
    }

    public GeolocationApiRequest WifiAccessPoints(WifiAccessPoint[] wifiAccessPointArr) {
        this.builder.WifiAccessPoints(wifiAccessPointArr);
        return this;
    }

    public GeolocationApiRequest AddWifiAccessPoint(WifiAccessPoint wifiAccessPoint) {
        this.builder.AddWifiAccessPoint(wifiAccessPoint);
        return this;
    }

    public GeolocationApiRequest Payload(GeolocationPayload geolocationPayload) {
        this.payload = geolocationPayload;
        return this;
    }

    public GeolocationApiRequest CreatePayload() {
        if (this.payload == null) {
            this.payload = this.builder.createGeolocationPayload();
        }
        return param("_payload", new Gson().m9362b(this.payload));
    }
}
