package com.google.maps.model;

/* JADX INFO: loaded from: classes.dex */
public class CellTower {
    public Integer age;
    public Integer cellId;
    public Integer locationAreaCode;
    public Integer mobileCountryCode;
    public Integer mobileNetworkCode;
    public Integer signalStrength;
    public Integer timingAdvance;

    public CellTower() {
        this.cellId = null;
        this.locationAreaCode = null;
        this.mobileCountryCode = null;
        this.mobileNetworkCode = null;
        this.age = null;
        this.signalStrength = null;
        this.timingAdvance = null;
    }

    private CellTower(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.cellId = null;
        this.locationAreaCode = null;
        this.mobileCountryCode = null;
        this.mobileNetworkCode = null;
        this.age = null;
        this.signalStrength = null;
        this.timingAdvance = null;
        this.cellId = num;
        this.locationAreaCode = num2;
        this.mobileCountryCode = num3;
        this.mobileNetworkCode = num4;
        this.age = num5;
        this.signalStrength = num6;
        this.timingAdvance = num7;
    }

    public static class CellTowerBuilder {
        private Integer _cellId = null;
        private Integer _locationAreaCode = null;
        private Integer _mobileCountryCode = null;
        private Integer _mobileNetworkCode = null;
        private Integer _age = null;
        private Integer _signalStrength = null;
        private Integer _timingAdvance = null;

        public CellTower createCellTower() {
            return new CellTower(this._cellId, this._locationAreaCode, this._mobileCountryCode, this._mobileNetworkCode, this._age, this._signalStrength, this._timingAdvance);
        }

        public CellTowerBuilder CellId(int i) {
            this._cellId = new Integer(i);
            return this;
        }

        public CellTowerBuilder LocationAreaCode(int i) {
            this._locationAreaCode = new Integer(i);
            return this;
        }

        public CellTowerBuilder MobileCountryCode(int i) {
            this._mobileCountryCode = new Integer(i);
            return this;
        }

        public CellTowerBuilder MobileNetworkCode(int i) {
            this._mobileNetworkCode = new Integer(i);
            return this;
        }

        public CellTowerBuilder Age(int i) {
            this._age = new Integer(i);
            return this;
        }

        public CellTowerBuilder SignalStrength(int i) {
            this._signalStrength = new Integer(i);
            return this;
        }

        public CellTowerBuilder TimingAdvance(int i) {
            this._timingAdvance = new Integer(i);
            return this;
        }
    }
}
