.class public final enum Lcom/google/maps/model/LocationType;
.super Ljava/lang/Enum;
.source "LocationType.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/LocationType;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/LocationType;

.field public static final enum APPROXIMATE:Lcom/google/maps/model/LocationType;

.field public static final enum GEOMETRIC_CENTER:Lcom/google/maps/model/LocationType;

.field public static final enum RANGE_INTERPOLATED:Lcom/google/maps/model/LocationType;

.field public static final enum ROOFTOP:Lcom/google/maps/model/LocationType;

.field public static final enum UNKNOWN:Lcom/google/maps/model/LocationType;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 30
    new-instance v0, Lcom/google/maps/model/LocationType;

    const-string v1, "ROOFTOP"

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/LocationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/LocationType;->ROOFTOP:Lcom/google/maps/model/LocationType;

    .line 37
    new-instance v0, Lcom/google/maps/model/LocationType;

    const-string v1, "RANGE_INTERPOLATED"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/LocationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/LocationType;->RANGE_INTERPOLATED:Lcom/google/maps/model/LocationType;

    .line 43
    new-instance v0, Lcom/google/maps/model/LocationType;

    const-string v1, "GEOMETRIC_CENTER"

    invoke-direct {v0, v1, v4}, Lcom/google/maps/model/LocationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/LocationType;->GEOMETRIC_CENTER:Lcom/google/maps/model/LocationType;

    .line 46
    new-instance v0, Lcom/google/maps/model/LocationType;

    const-string v1, "APPROXIMATE"

    invoke-direct {v0, v1, v5}, Lcom/google/maps/model/LocationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/LocationType;->APPROXIMATE:Lcom/google/maps/model/LocationType;

    .line 52
    new-instance v0, Lcom/google/maps/model/LocationType;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v6}, Lcom/google/maps/model/LocationType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/LocationType;->UNKNOWN:Lcom/google/maps/model/LocationType;

    .line 25
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/google/maps/model/LocationType;

    sget-object v1, Lcom/google/maps/model/LocationType;->ROOFTOP:Lcom/google/maps/model/LocationType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/maps/model/LocationType;->RANGE_INTERPOLATED:Lcom/google/maps/model/LocationType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/LocationType;->GEOMETRIC_CENTER:Lcom/google/maps/model/LocationType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/LocationType;->APPROXIMATE:Lcom/google/maps/model/LocationType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/LocationType;->UNKNOWN:Lcom/google/maps/model/LocationType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/google/maps/model/LocationType;->$VALUES:[Lcom/google/maps/model/LocationType;

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
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/LocationType;
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/google/maps/model/LocationType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/LocationType;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/LocationType;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/google/maps/model/LocationType;->$VALUES:[Lcom/google/maps/model/LocationType;

    invoke-virtual {v0}, [Lcom/google/maps/model/LocationType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/LocationType;

    return-object v0
.end method


# virtual methods
.method public toUrlValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 56
    sget-object v0, Lcom/google/maps/model/LocationType;->UNKNOWN:Lcom/google/maps/model/LocationType;

    if-ne p0, v0, :cond_0

    .line 57
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Shouldn\'t use LocationType.UNKNOWN in a request."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 59
    :cond_0
    invoke-virtual {p0}, Lcom/google/maps/model/LocationType;->name()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
