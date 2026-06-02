package com.google.maps;

import com.google.gson.Gson;
import com.google.maps.model.CellTower;
import com.google.maps.model.GeolocationPayload;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.WifiAccessPoint;

public class GeolocationApiRequest extends PendingResultBase<GeolocationResult, GeolocationApiRequest, GeolocationApi.Response> {
   private GeolocationPayload.GeolocationPayloadBuilder builder;
   private GeolocationPayload payload = null;

   GeolocationApiRequest(GeoApiContext var1) {
      super(var1, GeolocationApi.GEOLOCATION_API_CONFIG, GeolocationApi.Response.class);
      this.builder = null;
      this.builder = new GeolocationPayload.GeolocationPayloadBuilder();
   }

   public GeolocationApiRequest AddCellTower(CellTower var1) {
      this.builder.AddCellTower(var1);
      return this;
   }

   public GeolocationApiRequest AddWifiAccessPoint(WifiAccessPoint var1) {
      this.builder.AddWifiAccessPoint(var1);
      return this;
   }

   public GeolocationApiRequest Carrier(String var1) {
      this.builder.Carrier(var1);
      return this;
   }

   public GeolocationApiRequest CellTowers(CellTower[] var1) {
      this.builder.CellTowers(var1);
      return this;
   }

   public GeolocationApiRequest ConsiderIp(boolean var1) {
      this.builder.ConsiderIp(var1);
      return this;
   }

   public GeolocationApiRequest CreatePayload() {
      if (this.payload == null) {
         this.payload = this.builder.createGeolocationPayload();
      }

      return this.param("_payload", new Gson().b(this.payload));
   }

   public GeolocationApiRequest HomeMobileCountryCode(int var1) {
      this.builder.HomeMobileCountryCode(var1);
      return this;
   }

   public GeolocationApiRequest HomeMobileNetworkCode(int var1) {
      this.builder.HomeMobileNetworkCode(var1);
      return this;
   }

   public GeolocationApiRequest Payload(GeolocationPayload var1) {
      this.payload = var1;
      return this;
   }

   public GeolocationApiRequest RadioType(String var1) {
      this.builder.RadioType(var1);
      return this;
   }

   public GeolocationApiRequest WifiAccessPoints(WifiAccessPoint[] var1) {
      this.builder.WifiAccessPoints(var1);
      return this;
   }

   @Override
   protected void validateRequest() {
      if (this.payload.considerIp != null && !this.payload.considerIp && this.payload.wifiAccessPoints != null && this.payload.wifiAccessPoints.length < 2) {
         throw new IllegalArgumentException("Request must contain two or more 'Wifi Access Points'");
      }
   }
}
