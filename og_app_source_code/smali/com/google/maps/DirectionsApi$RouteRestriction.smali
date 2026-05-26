.class public final enum Lcom/google/maps/DirectionsApi$RouteRestriction;
.super Ljava/lang/Enum;
.source "DirectionsApi.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/DirectionsApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "RouteRestriction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/DirectionsApi$RouteRestriction;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/DirectionsApi$RouteRestriction;

.field public static final enum FERRIES:Lcom/google/maps/DirectionsApi$RouteRestriction;

.field public static final enum HIGHWAYS:Lcom/google/maps/DirectionsApi$RouteRestriction;

.field public static final enum TOLLS:Lcom/google/maps/DirectionsApi$RouteRestriction;


# instance fields
.field private final restriction:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 92
    new-instance v0, Lcom/google/maps/DirectionsApi$RouteRestriction;

    const-string v1, "TOLLS"

    const-string v2, "tolls"

    invoke-direct {v0, v1, v3, v2}, Lcom/google/maps/DirectionsApi$RouteRestriction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/DirectionsApi$RouteRestriction;->TOLLS:Lcom/google/maps/DirectionsApi$RouteRestriction;

    .line 95
    new-instance v0, Lcom/google/maps/DirectionsApi$RouteRestriction;

    const-string v1, "HIGHWAYS"

    const-string v2, "highways"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/maps/DirectionsApi$RouteRestriction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/DirectionsApi$RouteRestriction;->HIGHWAYS:Lcom/google/maps/DirectionsApi$RouteRestriction;

    .line 98
    new-instance v0, Lcom/google/maps/DirectionsApi$RouteRestriction;

    const-string v1, "FERRIES"

    const-string v2, "ferries"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/maps/DirectionsApi$RouteRestriction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/DirectionsApi$RouteRestriction;->FERRIES:Lcom/google/maps/DirectionsApi$RouteRestriction;

    .line 89
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/google/maps/DirectionsApi$RouteRestriction;

    sget-object v1, Lcom/google/maps/DirectionsApi$RouteRestriction;->TOLLS:Lcom/google/maps/DirectionsApi$RouteRestriction;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/DirectionsApi$RouteRestriction;->HIGHWAYS:Lcom/google/maps/DirectionsApi$RouteRestriction;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/DirectionsApi$RouteRestriction;->FERRIES:Lcom/google/maps/DirectionsApi$RouteRestriction;

    aput-object v1, v0, v5

    sput-object v0, Lcom/google/maps/DirectionsApi$RouteRestriction;->$VALUES:[Lcom/google/maps/DirectionsApi$RouteRestriction;

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
    .line 102
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 103
    iput-object p3, p0, Lcom/google/maps/DirectionsApi$RouteRestriction;->restriction:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/DirectionsApi$RouteRestriction;
    .locals 1

    .prologue
    .line 89
    const-class v0, Lcom/google/maps/DirectionsApi$RouteRestriction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/DirectionsApi$RouteRestriction;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/DirectionsApi$RouteRestriction;
    .locals 1

    .prologue
    .line 89
    sget-object v0, Lcom/google/maps/DirectionsApi$RouteRestriction;->$VALUES:[Lcom/google/maps/DirectionsApi$RouteRestriction;

    invoke-virtual {v0}, [Lcom/google/maps/DirectionsApi$RouteRestriction;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/DirectionsApi$RouteRestriction;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/google/maps/DirectionsApi$RouteRestriction;->restriction:Ljava/lang/String;

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/google/maps/DirectionsApi$RouteRestriction;->restriction:Ljava/lang/String;

    return-object v0
.end method
