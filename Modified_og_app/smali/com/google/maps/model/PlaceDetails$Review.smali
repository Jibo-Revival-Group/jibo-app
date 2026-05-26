.class public Lcom/google/maps/model/PlaceDetails$Review;
.super Ljava/lang/Object;
.source "PlaceDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/PlaceDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Review"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/PlaceDetails$Review$AspectRating;
    }
.end annotation


# instance fields
.field public aspects:[Lcom/google/maps/model/PlaceDetails$Review$AspectRating;

.field public authorName:Ljava/lang/String;

.field public authorUrl:Ljava/net/URL;

.field public language:Ljava/lang/String;

.field public rating:I

.field public text:Ljava/lang/String;

.field public time:Lorg/joda/time/Instant;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
