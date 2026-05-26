.class public final enum Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;
.super Ljava/lang/Enum;
.source "PlaceDetails.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/PlaceDetails$Review$AspectRating;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "RatingType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum APPEAL:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum ATMOSPHERE:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum DECOR:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum FACILITIES:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum FOOD:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum OVERALL:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum QUALITY:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum SERVICE:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

.field public static final enum UNKNOWN:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 106
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "APPEAL"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->APPEAL:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 107
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "ATMOSPHERE"

    invoke-direct {v0, v1, v4}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->ATMOSPHERE:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 108
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "DECOR"

    invoke-direct {v0, v1, v5}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->DECOR:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 109
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "FACILITIES"

    invoke-direct {v0, v1, v6}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->FACILITIES:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 110
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "FOOD"

    invoke-direct {v0, v1, v7}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->FOOD:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 111
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "OVERALL"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->OVERALL:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 112
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "QUALITY"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->QUALITY:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 113
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "SERVICE"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->SERVICE:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 119
    new-instance v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    const-string v1, "UNKNOWN"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->UNKNOWN:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    .line 105
    const/16 v0, 0x9

    new-array v0, v0, [Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    sget-object v1, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->APPEAL:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->ATMOSPHERE:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->DECOR:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->FACILITIES:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->FOOD:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->OVERALL:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->QUALITY:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->SERVICE:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->UNKNOWN:Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->$VALUES:[Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 105
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;
    .locals 1

    .prologue
    .line 105
    const-class v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;
    .locals 1

    .prologue
    .line 105
    sget-object v0, Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->$VALUES:[Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    invoke-virtual {v0}, [Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/PlaceDetails$Review$AspectRating$RatingType;

    return-object v0
.end method
