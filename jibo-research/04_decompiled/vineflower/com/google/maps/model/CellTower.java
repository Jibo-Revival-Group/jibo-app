package com.google.maps.model;

public class CellTower {
   public Integer age;
   public Integer cellId = null;
   public Integer locationAreaCode = null;
   public Integer mobileCountryCode = null;
   public Integer mobileNetworkCode = null;
   public Integer signalStrength;
   public Integer timingAdvance;

   public CellTower() {
      this.age = null;
      this.signalStrength = null;
      this.timingAdvance = null;
   }

   private CellTower(Integer var1, Integer var2, Integer var3, Integer var4, Integer var5, Integer var6, Integer var7) {
      this.age = null;
      this.signalStrength = null;
      this.timingAdvance = null;
      this.cellId = var1;
      this.locationAreaCode = var2;
      this.mobileCountryCode = var3;
      this.mobileNetworkCode = var4;
      this.age = var5;
      this.signalStrength = var6;
      this.timingAdvance = var7;
   }

   public static class CellTowerBuilder {
      private Integer _age;
      private Integer _cellId = null;
      private Integer _locationAreaCode = null;
      private Integer _mobileCountryCode = null;
      private Integer _mobileNetworkCode = null;
      private Integer _signalStrength;
      private Integer _timingAdvance;

      public CellTowerBuilder() {
         this._age = null;
         this._signalStrength = null;
         this._timingAdvance = null;
      }

      public CellTower.CellTowerBuilder Age(int var1) {
         this._age = new Integer(var1);
         return this;
      }

      public CellTower.CellTowerBuilder CellId(int var1) {
         this._cellId = new Integer(var1);
         return this;
      }

      public CellTower.CellTowerBuilder LocationAreaCode(int var1) {
         this._locationAreaCode = new Integer(var1);
         return this;
      }

      public CellTower.CellTowerBuilder MobileCountryCode(int var1) {
         this._mobileCountryCode = new Integer(var1);
         return this;
      }

      public CellTower.CellTowerBuilder MobileNetworkCode(int var1) {
         this._mobileNetworkCode = new Integer(var1);
         return this;
      }

      public CellTower.CellTowerBuilder SignalStrength(int var1) {
         this._signalStrength = new Integer(var1);
         return this;
      }

      public CellTower.CellTowerBuilder TimingAdvance(int var1) {
         this._timingAdvance = new Integer(var1);
         return this;
      }

      public CellTower createCellTower() {
         return new CellTower(
            this._cellId, this._locationAreaCode, this._mobileCountryCode, this._mobileNetworkCode, this._age, this._signalStrength, this._timingAdvance
         );
      }
   }
}
