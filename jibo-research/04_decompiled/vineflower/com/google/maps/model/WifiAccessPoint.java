package com.google.maps.model;

public class WifiAccessPoint {
   public Integer age;
   public Integer channel;
   public String macAddress;
   public Integer signalStrength = null;
   public Integer signalToNoiseRatio;

   public WifiAccessPoint() {
      this.age = null;
      this.channel = null;
      this.signalToNoiseRatio = null;
   }

   private WifiAccessPoint(String var1, Integer var2, Integer var3, Integer var4, Integer var5) {
      this.age = null;
      this.channel = null;
      this.signalToNoiseRatio = null;
      this.macAddress = var1;
      this.signalStrength = var2;
      this.age = var3;
      this.channel = var4;
      this.signalToNoiseRatio = var5;
   }

   public static class WifiAccessPointBuilder {
      private Integer _age;
      private Integer _channel;
      private String _macAddress = null;
      private Integer _signalStrength = null;
      private Integer _signalToNoiseRatio;

      public WifiAccessPointBuilder() {
         this._age = null;
         this._channel = null;
         this._signalToNoiseRatio = null;
      }

      public WifiAccessPoint.WifiAccessPointBuilder Age(int var1) {
         this._age = new Integer(var1);
         return this;
      }

      public WifiAccessPoint.WifiAccessPointBuilder Channel(int var1) {
         this._channel = new Integer(var1);
         return this;
      }

      public WifiAccessPoint.WifiAccessPointBuilder MacAddress(String var1) {
         this._macAddress = var1;
         return this;
      }

      public WifiAccessPoint.WifiAccessPointBuilder SignalStrength(int var1) {
         this._signalStrength = new Integer(var1);
         return this;
      }

      public WifiAccessPoint.WifiAccessPointBuilder SignalToNoiseRatio(int var1) {
         this._signalToNoiseRatio = new Integer(var1);
         return this;
      }

      public WifiAccessPoint createWifiAccessPoint() {
         return new WifiAccessPoint(this._macAddress, this._signalStrength, this._age, this._channel, this._signalToNoiseRatio);
      }
   }
}
