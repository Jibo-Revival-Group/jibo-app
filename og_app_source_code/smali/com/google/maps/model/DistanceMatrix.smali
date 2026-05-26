.class public Lcom/google/maps/model/DistanceMatrix;
.super Ljava/lang/Object;
.source "DistanceMatrix.java"


# instance fields
.field public final destinationAddresses:[Ljava/lang/String;

.field public final originAddresses:[Ljava/lang/String;

.field public final rows:[Lcom/google/maps/model/DistanceMatrixRow;


# direct methods
.method public constructor <init>([Ljava/lang/String;[Ljava/lang/String;[Lcom/google/maps/model/DistanceMatrixRow;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/google/maps/model/DistanceMatrix;->originAddresses:[Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/google/maps/model/DistanceMatrix;->destinationAddresses:[Ljava/lang/String;

    .line 48
    iput-object p3, p0, Lcom/google/maps/model/DistanceMatrix;->rows:[Lcom/google/maps/model/DistanceMatrixRow;

    .line 49
    return-void
.end method
