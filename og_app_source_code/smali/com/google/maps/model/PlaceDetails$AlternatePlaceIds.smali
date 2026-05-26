.class public Lcom/google/maps/model/PlaceDetails$AlternatePlaceIds;
.super Ljava/lang/Object;
.source "PlaceDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/PlaceDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AlternatePlaceIds"
.end annotation


# instance fields
.field public placeId:Ljava/lang/String;

.field public scope:Lcom/google/maps/model/PlaceIdScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
