.class public final enum Lcom/google/maps/model/AddressComponentType;
.super Ljava/lang/Enum;
.source "AddressComponentType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/AddressComponentType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/AddressComponentType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_1:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_2:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_3:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_4:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ADMINISTRATIVE_AREA_LEVEL_5:Lcom/google/maps/model/AddressComponentType;

.field public static final enum AIRPORT:Lcom/google/maps/model/AddressComponentType;

.field public static final enum BUS_STATION:Lcom/google/maps/model/AddressComponentType;

.field public static final enum COLLOQUIAL_AREA:Lcom/google/maps/model/AddressComponentType;

.field public static final enum COUNTRY:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ESTABLISHMENT:Lcom/google/maps/model/AddressComponentType;

.field public static final enum FLOOR:Lcom/google/maps/model/AddressComponentType;

.field public static final enum INTERSECTION:Lcom/google/maps/model/AddressComponentType;

.field public static final enum LIGHT_RAIL_STATION:Lcom/google/maps/model/AddressComponentType;

.field public static final enum LOCALITY:Lcom/google/maps/model/AddressComponentType;

.field public static final enum NATURAL_FEATURE:Lcom/google/maps/model/AddressComponentType;

.field public static final enum NEIGHBORHOOD:Lcom/google/maps/model/AddressComponentType;

.field public static final enum PARK:Lcom/google/maps/model/AddressComponentType;

.field public static final enum PARKING:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POINT_OF_INTEREST:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POLITICAL:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POSTAL_CODE:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POSTAL_CODE_PREFIX:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POSTAL_CODE_SUFFIX:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POSTAL_TOWN:Lcom/google/maps/model/AddressComponentType;

.field public static final enum POST_BOX:Lcom/google/maps/model/AddressComponentType;

.field public static final enum PREMISE:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ROOM:Lcom/google/maps/model/AddressComponentType;

.field public static final enum ROUTE:Lcom/google/maps/model/AddressComponentType;

.field public static final enum STREET_ADDRESS:Lcom/google/maps/model/AddressComponentType;

.field public static final enum STREET_NUMBER:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBLOCALITY:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBLOCALITY_LEVEL_1:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBLOCALITY_LEVEL_2:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBLOCALITY_LEVEL_3:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBLOCALITY_LEVEL_4:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBLOCALITY_LEVEL_5:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBPREMISE:Lcom/google/maps/model/AddressComponentType;

.field public static final enum SUBWAY_STATION:Lcom/google/maps/model/AddressComponentType;

.field public static final enum TRAIN_STATION:Lcom/google/maps/model/AddressComponentType;

.field public static final enum TRANSIT_STATION:Lcom/google/maps/model/AddressComponentType;

.field public static final enum UNKNOWN:Lcom/google/maps/model/AddressComponentType;

.field public static final enum WARD:Lcom/google/maps/model/AddressComponentType;


# instance fields
.field private final addressComponentType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 26
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "STREET_ADDRESS"

    const-string v2, "street_address"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->STREET_ADDRESS:Lcom/google/maps/model/AddressComponentType;

    .line 29
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ROUTE"

    const-string v2, "route"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ROUTE:Lcom/google/maps/model/AddressComponentType;

    .line 32
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "INTERSECTION"

    const-string v2, "intersection"

    invoke-direct {v0, v1, v6, v2}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->INTERSECTION:Lcom/google/maps/model/AddressComponentType;

    .line 35
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POLITICAL"

    const-string v2, "political"

    invoke-direct {v0, v1, v7, v2}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POLITICAL:Lcom/google/maps/model/AddressComponentType;

    .line 38
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "COUNTRY"

    const-string v2, "country"

    invoke-direct {v0, v1, v8, v2}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->COUNTRY:Lcom/google/maps/model/AddressComponentType;

    .line 44
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_1"

    const/4 v2, 0x5

    const-string v3, "administrative_area_level_1"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_1:Lcom/google/maps/model/AddressComponentType;

    .line 50
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_2"

    const/4 v2, 0x6

    const-string v3, "administrative_area_level_2"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_2:Lcom/google/maps/model/AddressComponentType;

    .line 56
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_3"

    const/4 v2, 0x7

    const-string v3, "administrative_area_level_3"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_3:Lcom/google/maps/model/AddressComponentType;

    .line 62
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_4"

    const/16 v2, 0x8

    const-string v3, "administrative_area_level_4"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_4:Lcom/google/maps/model/AddressComponentType;

    .line 68
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ADMINISTRATIVE_AREA_LEVEL_5"

    const/16 v2, 0x9

    const-string v3, "administrative_area_level_5"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_5:Lcom/google/maps/model/AddressComponentType;

    .line 71
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "COLLOQUIAL_AREA"

    const/16 v2, 0xa

    const-string v3, "colloquial_area"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->COLLOQUIAL_AREA:Lcom/google/maps/model/AddressComponentType;

    .line 74
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "LOCALITY"

    const/16 v2, 0xb

    const-string v3, "locality"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->LOCALITY:Lcom/google/maps/model/AddressComponentType;

    .line 80
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "WARD"

    const/16 v2, 0xc

    const-string v3, "ward"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->WARD:Lcom/google/maps/model/AddressComponentType;

    .line 87
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBLOCALITY"

    const/16 v2, 0xd

    const-string v3, "sublocality"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY:Lcom/google/maps/model/AddressComponentType;

    .line 88
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBLOCALITY_LEVEL_1"

    const/16 v2, 0xe

    const-string v3, "sublocality_level_1"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_1:Lcom/google/maps/model/AddressComponentType;

    .line 89
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBLOCALITY_LEVEL_2"

    const/16 v2, 0xf

    const-string v3, "sublocality_level_2"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_2:Lcom/google/maps/model/AddressComponentType;

    .line 90
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBLOCALITY_LEVEL_3"

    const/16 v2, 0x10

    const-string v3, "sublocality_level_3"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_3:Lcom/google/maps/model/AddressComponentType;

    .line 91
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBLOCALITY_LEVEL_4"

    const/16 v2, 0x11

    const-string v3, "sublocality_level_4"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_4:Lcom/google/maps/model/AddressComponentType;

    .line 92
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBLOCALITY_LEVEL_5"

    const/16 v2, 0x12

    const-string v3, "sublocality_level_5"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_5:Lcom/google/maps/model/AddressComponentType;

    .line 95
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "NEIGHBORHOOD"

    const/16 v2, 0x13

    const-string v3, "neighborhood"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->NEIGHBORHOOD:Lcom/google/maps/model/AddressComponentType;

    .line 98
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "PREMISE"

    const/16 v2, 0x14

    const-string v3, "premise"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->PREMISE:Lcom/google/maps/model/AddressComponentType;

    .line 104
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBPREMISE"

    const/16 v2, 0x15

    const-string v3, "subpremise"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBPREMISE:Lcom/google/maps/model/AddressComponentType;

    .line 107
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POSTAL_CODE"

    const/16 v2, 0x16

    const-string v3, "postal_code"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POSTAL_CODE:Lcom/google/maps/model/AddressComponentType;

    .line 110
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POSTAL_CODE_PREFIX"

    const/16 v2, 0x17

    const-string v3, "postal_code_prefix"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POSTAL_CODE_PREFIX:Lcom/google/maps/model/AddressComponentType;

    .line 113
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POSTAL_CODE_SUFFIX"

    const/16 v2, 0x18

    const-string v3, "postal_code_suffix"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POSTAL_CODE_SUFFIX:Lcom/google/maps/model/AddressComponentType;

    .line 116
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "NATURAL_FEATURE"

    const/16 v2, 0x19

    const-string v3, "natural_feature"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->NATURAL_FEATURE:Lcom/google/maps/model/AddressComponentType;

    .line 119
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "AIRPORT"

    const/16 v2, 0x1a

    const-string v3, "airport"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->AIRPORT:Lcom/google/maps/model/AddressComponentType;

    .line 122
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "PARK"

    const/16 v2, 0x1b

    const-string v3, "park"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->PARK:Lcom/google/maps/model/AddressComponentType;

    .line 128
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POINT_OF_INTEREST"

    const/16 v2, 0x1c

    const-string v3, "point_of_interest"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POINT_OF_INTEREST:Lcom/google/maps/model/AddressComponentType;

    .line 131
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "FLOOR"

    const/16 v2, 0x1d

    const-string v3, "floor"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->FLOOR:Lcom/google/maps/model/AddressComponentType;

    .line 134
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ESTABLISHMENT"

    const/16 v2, 0x1e

    const-string v3, "establishment"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ESTABLISHMENT:Lcom/google/maps/model/AddressComponentType;

    .line 137
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "PARKING"

    const/16 v2, 0x1f

    const-string v3, "parking"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->PARKING:Lcom/google/maps/model/AddressComponentType;

    .line 140
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POST_BOX"

    const/16 v2, 0x20

    const-string v3, "post_box"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POST_BOX:Lcom/google/maps/model/AddressComponentType;

    .line 146
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "POSTAL_TOWN"

    const/16 v2, 0x21

    const-string v3, "postal_town"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->POSTAL_TOWN:Lcom/google/maps/model/AddressComponentType;

    .line 149
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "ROOM"

    const/16 v2, 0x22

    const-string v3, "room"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->ROOM:Lcom/google/maps/model/AddressComponentType;

    .line 152
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "STREET_NUMBER"

    const/16 v2, 0x23

    const-string v3, "street_number"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->STREET_NUMBER:Lcom/google/maps/model/AddressComponentType;

    .line 155
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "BUS_STATION"

    const/16 v2, 0x24

    const-string v3, "bus_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->BUS_STATION:Lcom/google/maps/model/AddressComponentType;

    .line 158
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "TRAIN_STATION"

    const/16 v2, 0x25

    const-string v3, "train_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->TRAIN_STATION:Lcom/google/maps/model/AddressComponentType;

    .line 161
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "SUBWAY_STATION"

    const/16 v2, 0x26

    const-string v3, "subway_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->SUBWAY_STATION:Lcom/google/maps/model/AddressComponentType;

    .line 164
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "TRANSIT_STATION"

    const/16 v2, 0x27

    const-string v3, "transit_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->TRANSIT_STATION:Lcom/google/maps/model/AddressComponentType;

    .line 167
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "LIGHT_RAIL_STATION"

    const/16 v2, 0x28

    const-string v3, "light_rail_station"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->LIGHT_RAIL_STATION:Lcom/google/maps/model/AddressComponentType;

    .line 173
    new-instance v0, Lcom/google/maps/model/AddressComponentType;

    const-string v1, "UNKNOWN"

    const/16 v2, 0x29

    const-string v3, "unknown"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/AddressComponentType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->UNKNOWN:Lcom/google/maps/model/AddressComponentType;

    .line 23
    const/16 v0, 0x2a

    new-array v0, v0, [Lcom/google/maps/model/AddressComponentType;

    sget-object v1, Lcom/google/maps/model/AddressComponentType;->STREET_ADDRESS:Lcom/google/maps/model/AddressComponentType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/AddressComponentType;->ROUTE:Lcom/google/maps/model/AddressComponentType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/AddressComponentType;->INTERSECTION:Lcom/google/maps/model/AddressComponentType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/maps/model/AddressComponentType;->POLITICAL:Lcom/google/maps/model/AddressComponentType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/google/maps/model/AddressComponentType;->COUNTRY:Lcom/google/maps/model/AddressComponentType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_1:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_2:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_3:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_4:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ADMINISTRATIVE_AREA_LEVEL_5:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->COLLOQUIAL_AREA:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->LOCALITY:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->WARD:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_1:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_2:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_3:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_4:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBLOCALITY_LEVEL_5:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->NEIGHBORHOOD:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->PREMISE:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBPREMISE:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->POSTAL_CODE:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->POSTAL_CODE_PREFIX:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->POSTAL_CODE_SUFFIX:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->NATURAL_FEATURE:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->AIRPORT:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->PARK:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->POINT_OF_INTEREST:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->FLOOR:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ESTABLISHMENT:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->PARKING:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->POST_BOX:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->POSTAL_TOWN:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->ROOM:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->STREET_NUMBER:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->BUS_STATION:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->TRAIN_STATION:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x26

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->SUBWAY_STATION:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x27

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->TRANSIT_STATION:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x28

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->LIGHT_RAIL_STATION:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    const/16 v1, 0x29

    sget-object v2, Lcom/google/maps/model/AddressComponentType;->UNKNOWN:Lcom/google/maps/model/AddressComponentType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/maps/model/AddressComponentType;->$VALUES:[Lcom/google/maps/model/AddressComponentType;

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
    .line 177
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 178
    iput-object p3, p0, Lcom/google/maps/model/AddressComponentType;->addressComponentType:Ljava/lang/String;

    .line 179
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/AddressComponentType;
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/google/maps/model/AddressComponentType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/AddressComponentType;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/AddressComponentType;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Lcom/google/maps/model/AddressComponentType;->$VALUES:[Lcom/google/maps/model/AddressComponentType;

    invoke-virtual {v0}, [Lcom/google/maps/model/AddressComponentType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/AddressComponentType;

    return-object v0
.end method


# virtual methods
.method public toCanonicalLiteral()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    invoke-virtual {p0}, Lcom/google/maps/model/AddressComponentType;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/google/maps/model/AddressComponentType;->addressComponentType:Ljava/lang/String;

    return-object v0
.end method
