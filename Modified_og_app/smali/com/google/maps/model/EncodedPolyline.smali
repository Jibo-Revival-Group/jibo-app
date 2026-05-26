.class public Lcom/google/maps/model/EncodedPolyline;
.super Ljava/lang/Object;
.source "EncodedPolyline.java"


# instance fields
.field private final points:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/google/maps/model/EncodedPolyline;->points:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/maps/model/LatLng;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    invoke-static {p1}, Lcom/google/maps/internal/PolylineEncoding;->encode(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/maps/model/EncodedPolyline;->points:Ljava/lang/String;

    .line 40
    return-void
.end method


# virtual methods
.method public decodePath()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/maps/model/LatLng;",
            ">;"
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Lcom/google/maps/model/EncodedPolyline;->points:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/maps/internal/PolylineEncoding;->decode(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/google/maps/model/EncodedPolyline;->points:Ljava/lang/String;

    return-object v0
.end method
