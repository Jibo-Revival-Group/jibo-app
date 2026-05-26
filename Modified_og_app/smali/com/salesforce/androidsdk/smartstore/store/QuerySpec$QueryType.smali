.class public final enum Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;
.super Ljava/lang/Enum;
.source "QuerySpec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "QueryType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

.field public static final enum exact:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

.field public static final enum like:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

.field public static final enum match:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

.field public static final enum range:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

.field public static final enum smart:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 524
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const-string v1, "exact"

    invoke-direct {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->exact:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 525
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const-string v1, "range"

    invoke-direct {v0, v1, v3}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->range:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 526
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const-string v1, "like"

    invoke-direct {v0, v1, v4}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->like:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 527
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const-string v1, "match"

    invoke-direct {v0, v1, v5}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->match:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 528
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    const-string v1, "smart"

    invoke-direct {v0, v1, v6}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->smart:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    .line 523
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->exact:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->range:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->like:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->match:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->smart:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    aput-object v1, v0, v6

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

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
    .line 523
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;
    .locals 1

    .prologue
    .line 523
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;
    .locals 1

    .prologue
    .line 523
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$QueryType;

    return-object v0
.end method
