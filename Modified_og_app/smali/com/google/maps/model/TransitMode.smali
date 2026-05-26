.class public final enum Lcom/google/maps/model/TransitMode;
.super Ljava/lang/Enum;
.source "TransitMode.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/TransitMode;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/TransitMode;

.field public static final enum BUS:Lcom/google/maps/model/TransitMode;

.field public static final enum RAIL:Lcom/google/maps/model/TransitMode;

.field public static final enum SUBWAY:Lcom/google/maps/model/TransitMode;

.field public static final enum TRAIN:Lcom/google/maps/model/TransitMode;

.field public static final enum TRAM:Lcom/google/maps/model/TransitMode;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 23
    new-instance v0, Lcom/google/maps/model/TransitMode;

    const-string v1, "BUS"

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/TransitMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitMode;->BUS:Lcom/google/maps/model/TransitMode;

    .line 24
    new-instance v0, Lcom/google/maps/model/TransitMode;

    const-string v1, "SUBWAY"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/TransitMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitMode;->SUBWAY:Lcom/google/maps/model/TransitMode;

    .line 25
    new-instance v0, Lcom/google/maps/model/TransitMode;

    const-string v1, "TRAIN"

    invoke-direct {v0, v1, v4}, Lcom/google/maps/model/TransitMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitMode;->TRAIN:Lcom/google/maps/model/TransitMode;

    .line 26
    new-instance v0, Lcom/google/maps/model/TransitMode;

    const-string v1, "TRAM"

    invoke-direct {v0, v1, v5}, Lcom/google/maps/model/TransitMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitMode;->TRAM:Lcom/google/maps/model/TransitMode;

    .line 29
    new-instance v0, Lcom/google/maps/model/TransitMode;

    const-string v1, "RAIL"

    invoke-direct {v0, v1, v6}, Lcom/google/maps/model/TransitMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TransitMode;->RAIL:Lcom/google/maps/model/TransitMode;

    .line 22
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/google/maps/model/TransitMode;

    sget-object v1, Lcom/google/maps/model/TransitMode;->BUS:Lcom/google/maps/model/TransitMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/maps/model/TransitMode;->SUBWAY:Lcom/google/maps/model/TransitMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/TransitMode;->TRAIN:Lcom/google/maps/model/TransitMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/TransitMode;->TRAM:Lcom/google/maps/model/TransitMode;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/TransitMode;->RAIL:Lcom/google/maps/model/TransitMode;

    aput-object v1, v0, v6

    sput-object v0, Lcom/google/maps/model/TransitMode;->$VALUES:[Lcom/google/maps/model/TransitMode;

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
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/TransitMode;
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/google/maps/model/TransitMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/TransitMode;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/TransitMode;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/google/maps/model/TransitMode;->$VALUES:[Lcom/google/maps/model/TransitMode;

    invoke-virtual {v0}, [Lcom/google/maps/model/TransitMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/TransitMode;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/google/maps/model/TransitMode;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/google/maps/model/TransitMode;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
