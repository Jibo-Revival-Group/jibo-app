package com.google.maps.model;

public enum DistanceMatrixElementStatus {
   NOT_FOUND,
   OK,
   ZERO_RESULTS;

   private static final DistanceMatrixElementStatus[] $VALUES = new DistanceMatrixElementStatus[]{
      DistanceMatrixElementStatus.OK, DistanceMatrixElementStatus.NOT_FOUND, DistanceMatrixElementStatus.ZERO_RESULTS
   };
}
