package com.google.maps.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GeolocationPayload {
    public String carrier;
    public CellTower[] cellTowers;
    public Boolean considerIp;
    public Integer homeMobileCountryCode;
    public Integer homeMobileNetworkCode;
    public String radioType;
    public WifiAccessPoint[] wifiAccessPoints;

    public GeolocationPayload() {
        this.homeMobileCountryCode = null;
        this.homeMobileNetworkCode = null;
        this.radioType = null;
        this.carrier = null;
        this.considerIp = null;
    }

    private GeolocationPayload(Integer num, Integer num2, String str, String str2, Boolean bool, CellTower[] cellTowerArr, WifiAccessPoint[] wifiAccessPointArr) {
        this.homeMobileCountryCode = null;
        this.homeMobileNetworkCode = null;
        this.radioType = null;
        this.carrier = null;
        this.considerIp = null;
        this.homeMobileCountryCode = num;
        this.homeMobileNetworkCode = num2;
        this.radioType = str;
        this.carrier = str2;
        this.considerIp = bool;
        this.cellTowers = cellTowerArr;
        this.wifiAccessPoints = wifiAccessPointArr;
    }

    public static class GeolocationPayloadBuilder {
        private Integer _homeMobileCountryCode = null;
        private Integer _homeMobileNetworkCode = null;
        private String _radioType = null;
        private String _carrier = null;
        private Boolean _considerIp = null;
        private CellTower[] _cellTowers = null;
        private List<CellTower> _addedCellTowers = new ArrayList();
        private WifiAccessPoint[] _wifiAccessPoints = null;
        private List<WifiAccessPoint> _addedWifiAccessPoints = new ArrayList();

        public GeolocationPayload createGeolocationPayload() {
            if (!this._addedWifiAccessPoints.isEmpty()) {
                this._wifiAccessPoints = (WifiAccessPoint[]) this._addedWifiAccessPoints.toArray(new WifiAccessPoint[0]);
            }
            if (!this._addedCellTowers.isEmpty()) {
                this._cellTowers = (CellTower[]) this._addedCellTowers.toArray(new CellTower[0]);
            }
            return new GeolocationPayload(this._homeMobileCountryCode, this._homeMobileNetworkCode, this._radioType, this._carrier, this._considerIp, this._cellTowers, this._wifiAccessPoints);
        }

        public GeolocationPayloadBuilder HomeMobileCountryCode(int i) {
            this._homeMobileCountryCode = new Integer(i);
            return this;
        }

        public GeolocationPayloadBuilder HomeMobileNetworkCode(int i) {
            this._homeMobileNetworkCode = new Integer(i);
            return this;
        }

        public GeolocationPayloadBuilder RadioType(String str) {
            this._radioType = str;
            return this;
        }

        public GeolocationPayloadBuilder Carrier(String str) {
            this._carrier = str;
            return this;
        }

        public GeolocationPayloadBuilder ConsiderIp(boolean z) {
            this._considerIp = new Boolean(z);
            return this;
        }

        public GeolocationPayloadBuilder CellTowers(CellTower[] cellTowerArr) {
            this._cellTowers = cellTowerArr;
            return this;
        }

        public GeolocationPayloadBuilder AddCellTower(CellTower cellTower) {
            this._addedCellTowers.add(cellTower);
            return this;
        }

        public GeolocationPayloadBuilder WifiAccessPoints(WifiAccessPoint[] wifiAccessPointArr) {
            this._wifiAccessPoints = wifiAccessPointArr;
            return this;
        }

        public GeolocationPayloadBuilder AddWifiAccessPoint(WifiAccessPoint wifiAccessPoint) {
            this._addedWifiAccessPoints.add(wifiAccessPoint);
            return this;
        }
    }
}
