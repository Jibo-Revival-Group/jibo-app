.class public Lcom/google/maps/model/PlaceDetails$Review$AspectRating;
.super Ljava/lang/Object;
.source "PlaceDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/PlaceDetails$Review;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AspectRating"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;
    }
.end annotation


# instance fields
.field public rating:I

.field public type:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 104
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
