.class public final enum Lcom/google/maps/model/RankBy;
.super Ljava/lang/Enum;
.source "RankBy.java"

# interfaces
.implements Lcom/google/maps/internal/StringJoin$UrlValue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/maps/model/RankBy;",
        ">;",
        "Lcom/google/maps/internal/StringJoin$UrlValue;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/maps/model/RankBy;

.field public static final enum DISTANCE:Lcom/google/maps/model/RankBy;

.field public static final enum PROMINENCE:Lcom/google/maps/model/RankBy;


# instance fields
.field private final ranking:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 22
    new-instance v0, Lcom/google/maps/model/RankBy;

    const-string v1, "PROMINENCE"

    const-string v2, "prominence"

    invoke-direct {v0, v1, v3, v2}, Lcom/google/maps/model/RankBy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/RankBy;->PROMINENCE:Lcom/google/maps/model/RankBy;

    .line 23
    new-instance v0, Lcom/google/maps/model/RankBy;

    const-string v1, "DISTANCE"

    const-string v2, "distance"

    invoke-direct {v0, v1, v4, v2}, Lcom/google/maps/model/RankBy;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/google/maps/model/RankBy;->DISTANCE:Lcom/google/maps/model/RankBy;

    .line 21
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/google/maps/model/RankBy;

    sget-object v1, Lcom/google/maps/model/RankBy;->PROMINENCE:Lcom/google/maps/model/RankBy;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/maps/model/RankBy;->DISTANCE:Lcom/google/maps/model/RankBy;

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/maps/model/RankBy;->$VALUES:[Lcom/google/maps/model/RankBy;

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
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 28
    iput-object p3, p0, Lcom/google/maps/model/RankBy;->ranking:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/maps/model/RankBy;
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/google/maps/model/RankBy;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/maps/model/RankBy;

    return-object v0
.end method

.method public static values()[Lcom/google/maps/model/RankBy;
    .locals 1

    .prologue
    .line 21
    sget-object v0, Lcom/google/maps/model/RankBy;->$VALUES:[Lcom/google/maps/model/RankBy;

    invoke-virtual {v0}, [Lcom/google/maps/model/RankBy;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/maps/model/RankBy;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/google/maps/model/RankBy;->ranking:Ljava/lang/String;

    return-object v0
.end method

.method public toUrlValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/google/maps/model/RankBy;->ranking:Ljava/lang/String;

    return-object v0
.end method
