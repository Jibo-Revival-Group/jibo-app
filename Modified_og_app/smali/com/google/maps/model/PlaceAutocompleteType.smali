.class public final enum Lcom/google/maps/model/PlaceAutocompleteType;
.super Ljava/lang/Enum;
.source "PlaceAutocompleteType.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/PlaceAutocompleteType;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/PlaceAutocompleteType;

.field public static final enum ADDRESS:Lcom/google/maps/model/PlaceAutocompleteType;

.field public static final enum CITIES:Lcom/google/maps/model/PlaceAutocompleteType;

.field public static final enum ESTABLISHMENT:Lcom/google/maps/model/PlaceAutocompleteType;

.field public static final enum GEOCODE:Lcom/google/maps/model/PlaceAutocompleteType;

.field public static final enum REGIONS:Lcom/google/maps/model/PlaceAutocompleteType;


# instance fields
.field private placeType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 25
    new-instance v0, Lcom/google/maps/model/PlaceAutocompleteType;

    const-string v1, "GEOCODE"

    const-string v2, "geocode"

    invoke-direct {v0, v1, v3, v2}, Lcom/google/maps/model/PlaceAutocompleteType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->GEOCODE:Lcom/google/maps/model/PlaceAutocompleteType;

    .line 26
    new-instance v0, Lcom/google/maps/model/PlaceAutocompleteType;

    const-string v1, "ADDRESS"

    const-string v2, "address"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/maps/model/PlaceAutocompleteType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->ADDRESS:Lcom/google/maps/model/PlaceAutocompleteType;

    .line 27
    new-instance v0, Lcom/google/maps/model/PlaceAutocompleteType;

    const-string v1, "ESTABLISHMENT"

    const-string v2, "establishment"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/maps/model/PlaceAutocompleteType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->ESTABLISHMENT:Lcom/google/maps/model/PlaceAutocompleteType;

    .line 28
    new-instance v0, Lcom/google/maps/model/PlaceAutocompleteType;

    const-string v1, "REGIONS"

    const-string v2, "(regions)"

    invoke-direct {v0, v1, v6, v2}, Lcom/google/maps/model/PlaceAutocompleteType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->REGIONS:Lcom/google/maps/model/PlaceAutocompleteType;

    .line 29
    new-instance v0, Lcom/google/maps/model/PlaceAutocompleteType;

    const-string v1, "CITIES"

    const-string v2, "(cities)"

    invoke-direct {v0, v1, v7, v2}, Lcom/google/maps/model/PlaceAutocompleteType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->CITIES:Lcom/google/maps/model/PlaceAutocompleteType;

    .line 24
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/google/maps/model/PlaceAutocompleteType;

    sget-object v1, Lcom/google/maps/model/PlaceAutocompleteType;->GEOCODE:Lcom/google/maps/model/PlaceAutocompleteType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/PlaceAutocompleteType;->ADDRESS:Lcom/google/maps/model/PlaceAutocompleteType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/PlaceAutocompleteType;->ESTABLISHMENT:Lcom/google/maps/model/PlaceAutocompleteType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/PlaceAutocompleteType;->REGIONS:Lcom/google/maps/model/PlaceAutocompleteType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/maps/model/PlaceAutocompleteType;->CITIES:Lcom/google/maps/model/PlaceAutocompleteType;

    aput-object v1, v0, v7

    sput-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->$VALUES:[Lcom/google/maps/model/PlaceAutocompleteType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 32
    iput-object p3, p0, Lcom/google/maps/model/PlaceAutocompleteType;->placeType:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/PlaceAutocompleteType;
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/google/maps/model/PlaceAutocompleteType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/PlaceAutocompleteType;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/PlaceAutocompleteType;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/google/maps/model/PlaceAutocompleteType;->$VALUES:[Lcom/google/maps/model/PlaceAutocompleteType;

    invoke-virtual {v0}, [Lcom/google/maps/model/PlaceAutocompleteType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/PlaceAutocompleteType;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/google/maps/model/PlaceAutocompleteType;->placeType:Ljava/lang/String;

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/google/maps/model/PlaceAutocompleteType;->placeType:Ljava/lang/String;

    return-object v0
.end method
