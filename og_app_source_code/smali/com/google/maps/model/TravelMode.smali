.class public final enum Lcom/google/maps/model/TravelMode;
.super Ljava/lang/Enum;
.source "TravelMode.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/TravelMode;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/TravelMode;

.field public static final enum BICYCLING:Lcom/google/maps/model/TravelMode;

.field public static final enum DRIVING:Lcom/google/maps/model/TravelMode;

.field public static final enum TRANSIT:Lcom/google/maps/model/TravelMode;

.field public static final enum UNKNOWN:Lcom/google/maps/model/TravelMode;

.field public static final enum WALKING:Lcom/google/maps/model/TravelMode;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 31
    new-instance v0, Lcom/google/maps/model/TravelMode;

    const-string v1, "DRIVING"

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/TravelMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TravelMode;->DRIVING:Lcom/google/maps/model/TravelMode;

    .line 32
    new-instance v0, Lcom/google/maps/model/TravelMode;

    const-string v1, "WALKING"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/TravelMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TravelMode;->WALKING:Lcom/google/maps/model/TravelMode;

    .line 33
    new-instance v0, Lcom/google/maps/model/TravelMode;

    const-string v1, "BICYCLING"

    invoke-direct {v0, v1, v4}, Lcom/google/maps/model/TravelMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TravelMode;->BICYCLING:Lcom/google/maps/model/TravelMode;

    .line 34
    new-instance v0, Lcom/google/maps/model/TravelMode;

    const-string v1, "TRANSIT"

    invoke-direct {v0, v1, v5}, Lcom/google/maps/model/TravelMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TravelMode;->TRANSIT:Lcom/google/maps/model/TravelMode;

    .line 40
    new-instance v0, Lcom/google/maps/model/TravelMode;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v6}, Lcom/google/maps/model/TravelMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TravelMode;->UNKNOWN:Lcom/google/maps/model/TravelMode;

    .line 30
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/google/maps/model/TravelMode;

    sget-object v1, Lcom/google/maps/model/TravelMode;->DRIVING:Lcom/google/maps/model/TravelMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/maps/model/TravelMode;->WALKING:Lcom/google/maps/model/TravelMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/TravelMode;->BICYCLING:Lcom/google/maps/model/TravelMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/TravelMode;->TRANSIT:Lcom/google/maps/model/TravelMode;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/TravelMode;->UNKNOWN:Lcom/google/maps/model/TravelMode;

    aput-object v1, v0, v6

    sput-object v0, Lcom/google/maps/model/TravelMode;->$VALUES:[Lcom/google/maps/model/TravelMode;

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
    .line 30
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/TravelMode;
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/google/maps/model/TravelMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/TravelMode;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/TravelMode;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/google/maps/model/TravelMode;->$VALUES:[Lcom/google/maps/model/TravelMode;

    invoke-virtual {v0}, [Lcom/google/maps/model/TravelMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/TravelMode;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/google/maps/model/TravelMode;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 49
    sget-object v0, Lcom/google/maps/model/TravelMode;->UNKNOWN:Lcom/google/maps/model/TravelMode;

    if-ne p0, v0, :cond_0

    .line 50
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Shouldn\'t use TravelMode.UNKNOWN in a request."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/model/TravelMode;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
