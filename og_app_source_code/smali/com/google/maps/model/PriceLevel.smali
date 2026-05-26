.class public final enum Lcom/google/maps/model/PriceLevel;
.super Ljava/lang/Enum;
.source "PriceLevel.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/PriceLevel;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/PriceLevel;

.field public static final enum EXPENSIVE:Lcom/google/maps/model/PriceLevel;

.field public static final enum FREE:Lcom/google/maps/model/PriceLevel;

.field public static final enum INEXPENSIVE:Lcom/google/maps/model/PriceLevel;

.field public static final enum MODERATE:Lcom/google/maps/model/PriceLevel;

.field public static final enum UNKNOWN:Lcom/google/maps/model/PriceLevel;

.field public static final enum VERY_EXPENSIVE:Lcom/google/maps/model/PriceLevel;


# instance fields
.field private final priceLevel:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 22
    new-instance v0, Lcom/google/maps/model/PriceLevel;

    const-string v1, "FREE"

    const-string v2, "0"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/maps/model/PriceLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PriceLevel;->FREE:Lcom/google/maps/model/PriceLevel;

    .line 23
    new-instance v0, Lcom/google/maps/model/PriceLevel;

    const-string v1, "INEXPENSIVE"

    const-string v2, "1"

    invoke-direct {v0, v1, v5, v2}, Lcom/google/maps/model/PriceLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PriceLevel;->INEXPENSIVE:Lcom/google/maps/model/PriceLevel;

    .line 24
    new-instance v0, Lcom/google/maps/model/PriceLevel;

    const-string v1, "MODERATE"

    const-string v2, "2"

    invoke-direct {v0, v1, v6, v2}, Lcom/google/maps/model/PriceLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PriceLevel;->MODERATE:Lcom/google/maps/model/PriceLevel;

    .line 25
    new-instance v0, Lcom/google/maps/model/PriceLevel;

    const-string v1, "EXPENSIVE"

    const-string v2, "3"

    invoke-direct {v0, v1, v7, v2}, Lcom/google/maps/model/PriceLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PriceLevel;->EXPENSIVE:Lcom/google/maps/model/PriceLevel;

    .line 26
    new-instance v0, Lcom/google/maps/model/PriceLevel;

    const-string v1, "VERY_EXPENSIVE"

    const-string v2, "4"

    invoke-direct {v0, v1, v8, v2}, Lcom/google/maps/model/PriceLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PriceLevel;->VERY_EXPENSIVE:Lcom/google/maps/model/PriceLevel;

    .line 32
    new-instance v0, Lcom/google/maps/model/PriceLevel;

    const-string v1, "UNKNOWN"

    const/4 v2, 0x5

    const-string v3, "Unknown"

    invoke-direct {v0, v1, v2, v3}, Lcom/google/maps/model/PriceLevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/PriceLevel;->UNKNOWN:Lcom/google/maps/model/PriceLevel;

    .line 21
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/google/maps/model/PriceLevel;

    sget-object v1, Lcom/google/maps/model/PriceLevel;->FREE:Lcom/google/maps/model/PriceLevel;

    aput-object v1, v0, v4

    sget-object v1, Lcom/google/maps/model/PriceLevel;->INEXPENSIVE:Lcom/google/maps/model/PriceLevel;

    aput-object v1, v0, v5

    sget-object v1, Lcom/google/maps/model/PriceLevel;->MODERATE:Lcom/google/maps/model/PriceLevel;

    aput-object v1, v0, v6

    sget-object v1, Lcom/google/maps/model/PriceLevel;->EXPENSIVE:Lcom/google/maps/model/PriceLevel;

    aput-object v1, v0, v7

    sget-object v1, Lcom/google/maps/model/PriceLevel;->VERY_EXPENSIVE:Lcom/google/maps/model/PriceLevel;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/google/maps/model/PriceLevel;->UNKNOWN:Lcom/google/maps/model/PriceLevel;

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/maps/model/PriceLevel;->$VALUES:[Lcom/google/maps/model/PriceLevel;

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
    .line 36
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 37
    iput-object p3, p0, Lcom/google/maps/model/PriceLevel;->priceLevel:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/PriceLevel;
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/google/maps/model/PriceLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/PriceLevel;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/PriceLevel;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/google/maps/model/PriceLevel;->$VALUES:[Lcom/google/maps/model/PriceLevel;

    invoke-virtual {v0}, [Lcom/google/maps/model/PriceLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/PriceLevel;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/google/maps/model/PriceLevel;->priceLevel:Ljava/lang/String;

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 47
    sget-object v0, Lcom/google/maps/model/PriceLevel;->UNKNOWN:Lcom/google/maps/model/PriceLevel;

    if-ne p0, v0, :cond_0

    .line 48
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Shouldn\'t use PriceLevel.UNKNOWN in a request."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    iget-object v0, p0, Lcom/google/maps/model/PriceLevel;->priceLevel:Ljava/lang/String;

    return-object v0
.end method
