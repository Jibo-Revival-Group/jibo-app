package com.google.maps.model;

/* JADX INFO: loaded from: classes.dex */
public class DistanceMatrix {
    public final String[] destinationAddresses;
    public final String[] originAddresses;
    public final DistanceMatrixRow[] rows;

    public DistanceMatrix(String[] strArr, String[] strArr2, DistanceMatrixRow[] distanceMatrixRowArr) {
        this.originAddresses = strArr;
        this.destinationAddresses = strArr2;
        this.rows = distanceMatrixRowArr;
    }
}
