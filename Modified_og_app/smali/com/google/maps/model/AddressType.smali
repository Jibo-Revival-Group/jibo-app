.class public final enum Lcom/google/maps/model/AddressType;
.super Ljava/lang/Enum;
.source "AddressType.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/AddressType;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/AddressType;

.field public static final enum ACCOUNTING:Lcom/google/maps/model/AddressType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_1:Lcom/google/maps/model/AddressType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_2:Lcom/google/maps/model/AddressType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_3:Lcom/google/maps/model/AddressType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_4:Lcom/google/maps/model/AddressType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_5:Lcom/google/maps/model/AddressType;

.field public static final enum AIRPORT:Lcom/google/maps/model/AddressType;

.field public static final enum BUS_STATION:Lcom/google/maps/model/AddressType;

.field public static final enum CAR_DEALER:Lcom/google/maps/model/AddressType;

.field public static final enum CAR_REPAIR:Lcom/google/maps/model/AddressType;

.field public static final enum CHURCH:Lcom/google/maps/model/AddressType;

.field public static final enum COLLOQUIAL_AREA:Lcom/google/maps/model/AddressType;

.field public static final enum COUNTRY:Lcom/google/maps/model/AddressType;

.field public static final enum ESTABLISHMENT:Lcom/google/maps/model/AddressType;

.field public static final enum FINANCE:Lcom/google/maps/model/AddressType;

.field public static final enum FOOD:Lcom/google/maps/model/AddressType;

.field public static final enum FURNITURE_STORE:Lcom/google/maps/model/AddressType;

.field public static final enum GAS_STATION:Lcom/google/maps/model/AddressType;

.field public static final enum GROCERY_OR_SUPERMARKET:Lcom/google/maps/model/AddressType;

.field public static final enum GYM:Lcom/google/maps/model/AddressType;

.field public static final enum HEALTH:Lcom/google/maps/model/AddressType;

.field public static final enum HOME_GOODS_STORE:Lcom/google/maps/model/AddressType;

.field public static final enum INSURANCE_AGENCY:Lcom/google/maps/model/AddressType;

.field public static final enum INTERSECTION:Lcom/google/maps/model/AddressType;

.field public static final enum LAWYER:Lcom/google/maps/model/AddressType;

.field public static final enum LIGHT_RAIL_STATION:Lcom/google/maps/model/AddressType;

.field public static final enum LOCALITY:Lcom/google/maps/model/AddressType;

.field public static final enum LODGING:Lcom/google/maps/model/AddressType;

.field public static final enum MEAL_TAKEAWAY:Lcom/google/maps/model/AddressType;

.field public static final enum MOVING_COMPANY:Lcom/google/maps/model/AddressType;

.field public static final enum NATURAL_FEATURE:Lcom/google/maps/model/AddressType;

.field public static final enum NEIGHBORHOOD:Lcom/google/maps/model/AddressType;

.field public static final enum PARK:Lcom/google/maps/model/AddressType;

.field public static final enum PLACE_OF_WORSHIP:Lcom/google/maps/model/AddressType;

.field public static final enum POINT_OF_INTEREST:Lcom/google/maps/model/AddressType;

.field public static final enum POLITICAL:Lcom/google/maps/model/AddressType;

.field public static final enum POSTAL_CODE:Lcom/google/maps/model/AddressType;

.field public static final enum POSTAL_CODE_PREFIX:Lcom/google/maps/model/AddressType;

.field public static final enum POSTAL_TOWN:Lcom/google/maps/model/AddressType;

.field public static final enum POST_OFFICE:Lcom/google/maps/model/AddressType;

.field public static final enum PREMISE:Lcom/google/maps/model/AddressType;

.field public static final enum ROUTE:Lcom/google/maps/model/AddressType;

.field public static final enum SHOPPING_MALL:Lcom/google/maps/model/AddressType;

.field public static final enum STORAGE:Lcom/google/maps/model/AddressType;

.field public static final enum STORE:Lcom/google/maps/model/AddressType;

.field public static final enum STREET_ADDRESS:Lcom/google/maps/model/AddressType;

.field public static final enum SUBLOCALITY:Lcom/google/maps/model/AddressType;

.field public static final enum SUBLOCALITY_LEVEL_1:Lcom/google/maps/model/AddressType;

.field public static final enum SUBLOCALITY_LEVEL_2:Lcom/google/maps/model/AddressType;

.field public static final enum SUBLOCALITY_LEVEL_3:Lcom/google/maps/model/AddressType;

.field public static final enum SUBLOCALITY_LEVEL_4:Lcom/google/maps/model/AddressType;

.field public static final enum SUBLOCALITY_LEVEL_5:Lcom/google/maps/model/AddressType;

.field public static final enum SUBPREMISE:Lcom/google/maps/model/AddressType;

.field public static final enum SUBWAY_STATION:Lcom/google/maps/model/AddressType;

.field public static final enum SYNAGOGUE:Lcom/google/maps/model/AddressType;

.field public static final enum TRAIN_STATION:Lcom/google/maps/model/AddressType;

.field public static final enum TRANSIT_STATION:Lcom/google/maps/model/AddressType;

.field public static final enum UNIVERSITY:Lcom/google/maps/model/AddressType;

.field public static final enum UNKNOWN:Lcom/google/maps/model/AddressType;

.field public static final enum WARD:Lcom/google/maps/model/AddressType;


# instance fields
.field private final addressType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 30
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "STREET_ADDRESS"

    const-string v2, "street_address"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->STREET_ADDRESS:Lcom/google/maps/model/AddressType;

    .line 33
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ROUTE"

    const-string v2, "route"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ROUTE:Lcom/google/maps/model/AddressType;

    .line 36
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "INTERSECTION"

    const-string v2, "intersection"

    invoke-direct {v0, v1, v6, v2}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->INTERSECTION:Lcom/google/maps/model/AddressType;

    .line 39
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "POLITICAL"

    const-string v2, "political"

    invoke-direct {v0, v1, v7, v2}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->POLITICAL:Lcom/google/maps/model/AddressType;

    .line 42
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "COUNTRY"

    const-string v2, "country"

    invoke-direct {v0, v1, v8, v2}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->COUNTRY:Lcom/google/maps/model/AddressType;

    .line 48
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_1"

    const/4 v2, 0x5

    const-string v3, "administrative_area_level_1"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_1:Lcom/google/maps/model/AddressType;

    .line 54
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_2"

    const/4 v2, 0x6

    const-string v3, "administrative_area_level_2"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_2:Lcom/google/maps/model/AddressType;

    .line 60
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_3"

    const/4 v2, 0x7

    const-string v3, "administrative_area_level_3"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_3:Lcom/google/maps/model/AddressType;

    .line 66
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_4"

    const/16 v2, 0x8

    const-string v3, "administrative_area_level_4"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_4:Lcom/google/maps/model/AddressType;

    .line 72
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_5"

    const/16 v2, 0x9

    const-string v3, "administrative_area_level_5"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_5:Lcom/google/maps/model/AddressType;

    .line 75
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "COLLOQUIAL_AREA"

    const/16 v2, 0xa

    const-string v3, "colloquial_area"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->COLLOQUIAL_AREA:Lcom/google/maps/model/AddressType;

    .line 78
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "LOCALITY"

    const/16 v2, 0xb

    const-string v3, "locality"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->LOCALITY:Lcom/google/maps/model/AddressType;

    .line 84
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "WARD"

    const/16 v2, 0xc

    const-string v3, "ward"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->WARD:Lcom/google/maps/model/AddressType;

    .line 91
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBLOCALITY"

    const/16 v2, 0xd

    const-string v3, "sublocality"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBLOCALITY:Lcom/google/maps/model/AddressType;

    .line 92
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBLOCALITY_LEVEL_1"

    const/16 v2, 0xe

    const-string v3, "sublocality_level_1"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_1:Lcom/google/maps/model/AddressType;

    .line 93
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBLOCALITY_LEVEL_2"

    const/16 v2, 0xf

    const-string v3, "sublocality_level_2"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_2:Lcom/google/maps/model/AddressType;

    .line 94
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBLOCALITY_LEVEL_3"

    const/16 v2, 0x10

    const-string v3, "sublocality_level_3"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_3:Lcom/google/maps/model/AddressType;

    .line 95
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBLOCALITY_LEVEL_4"

    const/16 v2, 0x11

    const-string v3, "sublocality_level_4"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_4:Lcom/google/maps/model/AddressType;

    .line 96
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBLOCALITY_LEVEL_5"

    const/16 v2, 0x12

    const-string v3, "sublocality_level_5"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_5:Lcom/google/maps/model/AddressType;

    .line 99
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "NEIGHBORHOOD"

    const/16 v2, 0x13

    const-string v3, "neighborhood"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->NEIGHBORHOOD:Lcom/google/maps/model/AddressType;

    .line 102
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "PREMISE"

    const/16 v2, 0x14

    const-string v3, "premise"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->PREMISE:Lcom/google/maps/model/AddressType;

    .line 108
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBPREMISE"

    const/16 v2, 0x15

    const-string v3, "subpremise"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBPREMISE:Lcom/google/maps/model/AddressType;

    .line 111
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "POSTAL_CODE"

    const/16 v2, 0x16

    const-string v3, "postal_code"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->POSTAL_CODE:Lcom/google/maps/model/AddressType;

    .line 114
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "POSTAL_CODE_PREFIX"

    const/16 v2, 0x17

    const-string v3, "postal_code_prefix"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->POSTAL_CODE_PREFIX:Lcom/google/maps/model/AddressType;

    .line 117
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "NATURAL_FEATURE"

    const/16 v2, 0x18

    const-string v3, "natural_feature"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->NATURAL_FEATURE:Lcom/google/maps/model/AddressType;

    .line 120
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "AIRPORT"

    const/16 v2, 0x19

    const-string v3, "airport"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->AIRPORT:Lcom/google/maps/model/AddressType;

    .line 123
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "UNIVERSITY"

    const/16 v2, 0x1a

    const-string v3, "university"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->UNIVERSITY:Lcom/google/maps/model/AddressType;

    .line 126
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "PARK"

    const/16 v2, 0x1b

    const-string v3, "park"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->PARK:Lcom/google/maps/model/AddressType;

    .line 132
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "POINT_OF_INTEREST"

    const/16 v2, 0x1c

    const-string v3, "point_of_interest"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->POINT_OF_INTEREST:Lcom/google/maps/model/AddressType;

    .line 135
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ESTABLISHMENT"

    const/16 v2, 0x1d

    const-string v3, "establishment"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ESTABLISHMENT:Lcom/google/maps/model/AddressType;

    .line 138
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "BUS_STATION"

    const/16 v2, 0x1e

    const-string v3, "bus_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->BUS_STATION:Lcom/google/maps/model/AddressType;

    .line 141
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "TRAIN_STATION"

    const/16 v2, 0x1f

    const-string v3, "train_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->TRAIN_STATION:Lcom/google/maps/model/AddressType;

    .line 144
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SUBWAY_STATION"

    const/16 v2, 0x20

    const-string v3, "subway_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SUBWAY_STATION:Lcom/google/maps/model/AddressType;

    .line 147
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "TRANSIT_STATION"

    const/16 v2, 0x21

    const-string v3, "transit_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->TRANSIT_STATION:Lcom/google/maps/model/AddressType;

    .line 150
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "LIGHT_RAIL_STATION"

    const/16 v2, 0x22

    const-string v3, "light_rail_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->LIGHT_RAIL_STATION:Lcom/google/maps/model/AddressType;

    .line 153
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "CHURCH"

    const/16 v2, 0x23

    const-string v3, "church"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->CHURCH:Lcom/google/maps/model/AddressType;

    .line 156
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "FINANCE"

    const/16 v2, 0x24

    const-string v3, "finance"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->FINANCE:Lcom/google/maps/model/AddressType;

    .line 159
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "POST_OFFICE"

    const/16 v2, 0x25

    const-string v3, "post_office"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->POST_OFFICE:Lcom/google/maps/model/AddressType;

    .line 162
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "PLACE_OF_WORSHIP"

    const/16 v2, 0x26

    const-string v3, "place_of_worship"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->PLACE_OF_WORSHIP:Lcom/google/maps/model/AddressType;

    .line 168
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "POSTAL_TOWN"

    const/16 v2, 0x27

    const-string v3, "postal_town"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->POSTAL_TOWN:Lcom/google/maps/model/AddressType;

    .line 171
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SYNAGOGUE"

    const/16 v2, 0x28

    const-string v3, "synagogue"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SYNAGOGUE:Lcom/google/maps/model/AddressType;

    .line 174
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "FOOD"

    const/16 v2, 0x29

    const-string v3, "food"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->FOOD:Lcom/google/maps/model/AddressType;

    .line 177
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "GROCERY_OR_SUPERMARKET"

    const/16 v2, 0x2a

    const-string v3, "grocery_or_supermarket"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->GROCERY_OR_SUPERMARKET:Lcom/google/maps/model/AddressType;

    .line 180
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "STORE"

    const/16 v2, 0x2b

    const-string v3, "store"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->STORE:Lcom/google/maps/model/AddressType;

    .line 183
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "LAWYER"

    const/16 v2, 0x2c

    const-string v3, "lawyer"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->LAWYER:Lcom/google/maps/model/AddressType;

    .line 186
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "HEALTH"

    const/16 v2, 0x2d

    const-string v3, "health"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->HEALTH:Lcom/google/maps/model/AddressType;

    .line 189
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "INSURANCE_AGENCY"

    const/16 v2, 0x2e

    const-string v3, "insurance_agency"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->INSURANCE_AGENCY:Lcom/google/maps/model/AddressType;

    .line 192
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "GAS_STATION"

    const/16 v2, 0x2f

    const-string v3, "gas_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->GAS_STATION:Lcom/google/maps/model/AddressType;

    .line 195
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "CAR_DEALER"

    const/16 v2, 0x30

    const-string v3, "car_dealer"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->CAR_DEALER:Lcom/google/maps/model/AddressType;

    .line 198
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "CAR_REPAIR"

    const/16 v2, 0x31

    const-string v3, "car_repair"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->CAR_REPAIR:Lcom/google/maps/model/AddressType;

    .line 201
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "MEAL_TAKEAWAY"

    const/16 v2, 0x32

    const-string v3, "meal_takeaway"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->MEAL_TAKEAWAY:Lcom/google/maps/model/AddressType;

    .line 204
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "FURNITURE_STORE"

    const/16 v2, 0x33

    const-string v3, "furniture_store"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->FURNITURE_STORE:Lcom/google/maps/model/AddressType;

    .line 207
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "HOME_GOODS_STORE"

    const/16 v2, 0x34

    const-string v3, "home_goods_store"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->HOME_GOODS_STORE:Lcom/google/maps/model/AddressType;

    .line 210
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "SHOPPING_MALL"

    const/16 v2, 0x35

    const-string v3, "shopping_mall"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->SHOPPING_MALL:Lcom/google/maps/model/AddressType;

    .line 213
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "GYM"

    const/16 v2, 0x36

    const-string v3, "gym"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->GYM:Lcom/google/maps/model/AddressType;

    .line 216
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "ACCOUNTING"

    const/16 v2, 0x37

    const-string v3, "accounting"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->ACCOUNTING:Lcom/google/maps/model/AddressType;

    .line 219
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "MOVING_COMPANY"

    const/16 v2, 0x38

    const-string v3, "moving_company"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->MOVING_COMPANY:Lcom/google/maps/model/AddressType;

    .line 222
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "LODGING"

    const/16 v2, 0x39

    const-string v3, "lodging"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->LODGING:Lcom/google/maps/model/AddressType;

    .line 225
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "STORAGE"

    const/16 v2, 0x3a

    const-string v3, "storage"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->STORAGE:Lcom/google/maps/model/AddressType;

    .line 231
    new-instance v0, Lcom/google/maps/model/AddressType;

    const-string v1, "UNKNOWN"

    const/16 v2, 0x3b

    const-string v3, "unknown"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressType;->UNKNOWN:Lcom/google/maps/model/AddressType;

    .line 27
    const/16 v0, 0x3c

    new-array v0, v0, [Lcom/google/maps/model/AddressType;

    sget-object v1, Lcom/google/maps/model/AddressType;->STREET_ADDRESS:Lcom/google/maps/model/AddressType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/AddressType;->ROUTE:Lcom/google/maps/model/AddressType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/AddressType;->INTERSECTION:Lcom/google/maps/model/AddressType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/maps/model/AddressType;->POLITICAL:Lcom/google/maps/model/AddressType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/google/maps/model/AddressType;->COUNTRY:Lcom/google/maps/model/AddressType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_1:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_2:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_3:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_4:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/google/maps/model/AddressType;->ADMINISTRATIVE_AREA_LEVEL_5:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/google/maps/model/AddressType;->COLLOQUIAL_AREA:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/google/maps/model/AddressType;->LOCALITY:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/google/maps/model/AddressType;->WARD:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBLOCALITY:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_1:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_2:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_3:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_4:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBLOCALITY_LEVEL_5:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/google/maps/model/AddressType;->NEIGHBORHOOD:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/google/maps/model/AddressType;->PREMISE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBPREMISE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/google/maps/model/AddressType;->POSTAL_CODE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/google/maps/model/AddressType;->POSTAL_CODE_PREFIX:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/google/maps/model/AddressType;->NATURAL_FEATURE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/google/maps/model/AddressType;->AIRPORT:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/google/maps/model/AddressType;->UNIVERSITY:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/google/maps/model/AddressType;->PARK:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/google/maps/model/AddressType;->POINT_OF_INTEREST:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/google/maps/model/AddressType;->ESTABLISHMENT:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/google/maps/model/AddressType;->BUS_STATION:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/google/maps/model/AddressType;->TRAIN_STATION:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/google/maps/model/AddressType;->SUBWAY_STATION:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/google/maps/model/AddressType;->TRANSIT_STATION:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/google/maps/model/AddressType;->LIGHT_RAIL_STATION:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/google/maps/model/AddressType;->CHURCH:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/google/maps/model/AddressType;->FINANCE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/google/maps/model/AddressType;->POST_OFFICE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x26

    sget-object v2, Lcom/google/maps/model/AddressType;->PLACE_OF_WORSHIP:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x27

    sget-object v2, Lcom/google/maps/model/AddressType;->POSTAL_TOWN:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x28

    sget-object v2, Lcom/google/maps/model/AddressType;->SYNAGOGUE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x29

    sget-object v2, Lcom/google/maps/model/AddressType;->FOOD:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    sget-object v2, Lcom/google/maps/model/AddressType;->GROCERY_OR_SUPERMARKET:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    sget-object v2, Lcom/google/maps/model/AddressType;->STORE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    sget-object v2, Lcom/google/maps/model/AddressType;->LAWYER:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    sget-object v2, Lcom/google/maps/model/AddressType;->HEALTH:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    sget-object v2, Lcom/google/maps/model/AddressType;->INSURANCE_AGENCY:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    sget-object v2, Lcom/google/maps/model/AddressType;->GAS_STATION:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x30

    sget-object v2, Lcom/google/maps/model/AddressType;->CAR_DEALER:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x31

    sget-object v2, Lcom/google/maps/model/AddressType;->CAR_REPAIR:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x32

    sget-object v2, Lcom/google/maps/model/AddressType;->MEAL_TAKEAWAY:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x33

    sget-object v2, Lcom/google/maps/model/AddressType;->FURNITURE_STORE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x34

    sget-object v2, Lcom/google/maps/model/AddressType;->HOME_GOODS_STORE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x35

    sget-object v2, Lcom/google/maps/model/AddressType;->SHOPPING_MALL:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x36

    sget-object v2, Lcom/google/maps/model/AddressType;->GYM:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x37

    sget-object v2, Lcom/google/maps/model/AddressType;->ACCOUNTING:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x38

    sget-object v2, Lcom/google/maps/model/AddressType;->MOVING_COMPANY:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x39

    sget-object v2, Lcom/google/maps/model/AddressType;->LODGING:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    sget-object v2, Lcom/google/maps/model/AddressType;->STORAGE:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    sget-object v2, Lcom/google/maps/model/AddressType;->UNKNOWN:Lcom/google/maps/model/AddressType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/maps/model/AddressType;->$VALUES:[Lcom/google/maps/model/AddressType;

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
    .line 235
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 236
    iput-object p3, p0, Lcom/google/maps/model/AddressType;->addressType:Ljava/lang/String;

    .line 237
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/AddressType;
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/google/maps/model/AddressType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/AddressType;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/AddressType;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/google/maps/model/AddressType;->$VALUES:[Lcom/google/maps/model/AddressType;

    invoke-virtual {v0}, [Lcom/google/maps/model/AddressType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/AddressType;

    return-object v0
.end method


# virtual methods
.method public toCanonicalLiteral()Ljava/lang/String;
    .locals 1

    .prologue
    .line 245
    invoke-virtual {p0}, Lcom/google/maps/model/AddressType;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 241
    iget-object v0, p0, Lcom/google/maps/model/AddressType;->addressType:Ljava/lang/String;

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 250
    sget-object v0, Lcom/google/maps/model/AddressType;->UNKNOWN:Lcom/google/maps/model/AddressType;

    if-ne p0, v0, :cond_0

    .line 251
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Shouldn\'t use AddressType.UNKNOWN in a request."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 253
    :cond_0
    iget-object v0, p0, Lcom/google/maps/model/AddressType;->addressType:Ljava/lang/String;

    return-object v0
.end method
