.class public final enum Lcom/google/maps/model/TrafficModel;
.super Ljava/lang/Enum;
.source "TrafficModel.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/TrafficModel;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/TrafficModel;

.field public static final enum BEST_GUESS:Lcom/google/maps/model/TrafficModel;

.field public static final enum OPTIMISTIC:Lcom/google/maps/model/TrafficModel;

.field public static final enum PESSIMISTIC:Lcom/google/maps/model/TrafficModel;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 23
    new-instance v0, Lcom/google/maps/model/TrafficModel;

    const-string v1, "BEST_GUESS"

    invoke-direct {v0, v1, v2}, Lcom/google/maps/model/TrafficModel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TrafficModel;->BEST_GUESS:Lcom/google/maps/model/TrafficModel;

    .line 24
    new-instance v0, Lcom/google/maps/model/TrafficModel;

    const-string v1, "OPTIMISTIC"

    invoke-direct {v0, v1, v3}, Lcom/google/maps/model/TrafficModel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TrafficModel;->OPTIMISTIC:Lcom/google/maps/model/TrafficModel;

    .line 25
    new-instance v0, Lcom/google/maps/model/TrafficModel;

    const-string v1, "PESSIMISTIC"

    invoke-direct {v0, v1, v4}, Lcom/google/maps/model/TrafficModel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/maps/model/TrafficModel;->PESSIMISTIC:Lcom/google/maps/model/TrafficModel;

    .line 22
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/google/maps/model/TrafficModel;

    sget-object v1, Lcom/google/maps/model/TrafficModel;->BEST_GUESS:Lcom/google/maps/model/TrafficModel;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/maps/model/TrafficModel;->OPTIMISTIC:Lcom/google/maps/model/TrafficModel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/TrafficModel;->PESSIMISTIC:Lcom/google/maps/model/TrafficModel;

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/maps/model/TrafficModel;->$VALUES:[Lcom/google/maps/model/TrafficModel;

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

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/TrafficModel;
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/google/maps/model/TrafficModel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/TrafficModel;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/TrafficModel;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/google/maps/model/TrafficModel;->$VALUES:[Lcom/google/maps/model/TrafficModel;

    invoke-virtual {v0}, [Lcom/google/maps/model/TrafficModel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/TrafficModel;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/google/maps/model/TrafficModel;->name()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    invoke-virtual {p0}, Lcom/google/maps/model/TrafficModel;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
