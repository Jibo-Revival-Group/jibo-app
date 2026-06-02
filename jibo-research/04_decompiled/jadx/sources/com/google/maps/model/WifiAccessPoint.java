package com.google.maps.model;

/* JADX INFO: loaded from: classes.dex */
public class WifiAccessPoint {
    public Integer age;
    public Integer channel;
    public String macAddress;
    public Integer signalStrength;
    public Integer signalToNoiseRatio;

    public WifiAccessPoint() {
        this.signalStrength = null;
        this.age = null;
        this.channel = null;
        this.signalToNoiseRatio = null;
    }

    private WifiAccessPoint(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this.signalStrength = null;
        this.age = null;
        this.channel = null;
        this.signalToNoiseRatio = null;
        this.macAddress = str;
        this.signalStrength = num;
        this.age = num2;
        this.channel = num3;
        this.signalToNoiseRatio = num4;
    }

    public static class WifiAccessPointBuilder {
        private String _macAddress = null;
        private Integer _signalStrength = null;
        private Integer _age = null;
        private Integer _channel = null;
        private Integer _signalToNoiseRatio = null;

        public WifiAccessPoint createWifiAccessPoint() {
            return new WifiAccessPoint(this._macAddress, this._signalStrength, this._age, this._channel, this._signalToNoiseRatio);
        }

        public WifiAccessPointBuilder MacAddress(String str) {
            this._macAddress = str;
            return this;
        }

        public WifiAccessPointBuilder SignalStrength(int i) {
            this._signalStrength = new Integer(i);
            return this;
        }

        public WifiAccessPointBuilder Age(int i) {
            this._age = new Integer(i);
            return this;
        }

        public WifiAccessPointBuilder Channel(int i) {
            this._channel = new Integer(i);
            return this;
        }

        public WifiAccessPointBuilder SignalToNoiseRatio(int i) {
            this._signalToNoiseRatio = new Integer(i);
            return this;
        }
    }
}
