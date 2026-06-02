package com.google.maps.model;

import java.util.ArrayList;
import java.util.List;

public class GeolocationPayload {
   public String carrier;
   public CellTower[] cellTowers;
   public Boolean considerIp;
   public Integer homeMobileCountryCode = null;
   public Integer homeMobileNetworkCode = null;
   public String radioType = null;
   public WifiAccessPoint[] wifiAccessPoints;

   public GeolocationPayload() {
      this.carrier = null;
      this.considerIp = null;
   }

   private GeolocationPayload(Integer var1, Integer var2, String var3, String var4, Boolean var5, CellTower[] var6, WifiAccessPoint[] var7) {
      this.carrier = null;
      this.considerIp = null;
      this.homeMobileCountryCode = var1;
      this.homeMobileNetworkCode = var2;
      this.radioType = var3;
      this.carrier = var4;
      this.considerIp = var5;
      this.cellTowers = var6;
      this.wifiAccessPoints = var7;
   }

   public static class GeolocationPayloadBuilder {
      private List<CellTower> _addedCellTowers;
      private List<WifiAccessPoint> _addedWifiAccessPoints;
      private String _carrier;
      private CellTower[] _cellTowers;
      private Boolean _considerIp;
      private Integer _homeMobileCountryCode = null;
      private Integer _homeMobileNetworkCode = null;
      private String _radioType = null;
      private WifiAccessPoint[] _wifiAccessPoints;

      public GeolocationPayloadBuilder() {
         this._carrier = null;
         this._considerIp = null;
         this._cellTowers = null;
         this._addedCellTowers = new ArrayList<>();
         this._wifiAccessPoints = null;
         this._addedWifiAccessPoints = new ArrayList<>();
      }

      public GeolocationPayload.GeolocationPayloadBuilder AddCellTower(CellTower var1) {
         this._addedCellTowers.add(var1);
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder AddWifiAccessPoint(WifiAccessPoint var1) {
         this._addedWifiAccessPoints.add(var1);
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder Carrier(String var1) {
         this._carrier = var1;
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder CellTowers(CellTower[] var1) {
         this._cellTowers = var1;
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder ConsiderIp(boolean var1) {
         this._considerIp = new Boolean(var1);
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder HomeMobileCountryCode(int var1) {
         this._homeMobileCountryCode = new Integer(var1);
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder HomeMobileNetworkCode(int var1) {
         this._homeMobileNetworkCode = new Integer(var1);
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder RadioType(String var1) {
         this._radioType = var1;
         return this;
      }

      public GeolocationPayload.GeolocationPayloadBuilder WifiAccessPoints(WifiAccessPoint[] var1) {
         this._wifiAccessPoints = var1;
         return this;
      }

      public GeolocationPayload createGeolocationPayload() {
         if (!this._addedWifiAccessPoints.isEmpty()) {
            this._wifiAccessPoints = this._addedWifiAccessPoints.toArray(new WifiAccessPoint[0]);
         }

         if (!this._addedCellTowers.isEmpty()) {
            this._cellTowers = this._addedCellTowers.toArray(new CellTower[0]);
         }

         return new GeolocationPayload(
            this._homeMobileCountryCode,
            this._homeMobileNetworkCode,
            this._radioType,
            this._carrier,
            this._considerIp,
            this._cellTowers,
            this._wifiAccessPoints
         );
      }
   }
}
