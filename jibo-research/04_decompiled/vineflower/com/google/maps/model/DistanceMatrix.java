package com.google.maps.model;

public class DistanceMatrix {
   public final String[] destinationAddresses;
   public final String[] originAddresses;
   public final DistanceMatrixRow[] rows;

   public DistanceMatrix(String[] var1, String[] var2, DistanceMatrixRow[] var3) {
      this.originAddresses = var1;
      this.destinationAddresses = var2;
      this.rows = var3;
   }
}
