.class public Lcom/google/maps/model/PlaceDetails;
.super Ljava/lang/Object;
.source "PlaceDetails.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/PlaceDetails$Review;,
        Lcom/google/maps/model/PlaceDetails$AlternatePlaceIds;
    }
.end annotation


# instance fields
.field public addressComponents:[Lcom/google/maps/model/AddressComponent;

.field public altIds:[Lcom/google/maps/model/PlaceDetails$AlternatePlaceIds;

.field public formattedAddress:Ljava/lang/String;

.field public formattedPhoneNumber:Ljava/lang/String;

.field public geometry:Lcom/google/maps/model/Geometry;

.field public htmlAttributions:[Ljava/lang/String;

.field public icon:Ljava/net/URL;

.field public internationalPhoneNumber:Ljava/lang/String;

.field public name:Ljava/lang/String;

.field public openingHours:Lcom/google/maps/model/OpeningHours;

.field public permanentlyClosed:Z

.field public photos:[Lcom/google/maps/model/Photo;

.field public placeId:Ljava/lang/String;

.field public priceLevel:Lcom/google/maps/model/PriceLevel;

.field public rating:F

.field public reviews:[Lcom/google/maps/model/PlaceDetails$Review;

.field public scope:Lcom/google/maps/model/PlaceIdScope;

.field public types:[Ljava/lang/String;

.field public url:Ljava/net/URL;

.field public utcOffset:I

.field public vicinity:Ljava/lang/String;

.field public website:Ljava/net/URL;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
