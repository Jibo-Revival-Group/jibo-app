.class public final enum Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;
.super Ljava/lang/Enum;
.source "QuerySpec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Order"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

.field public static final enum ascending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

.field public static final enum descending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;


# instance fields
.field public final sql:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 536
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    const-string v1, "ascending"

    const-string v2, "ASC"

    invoke-direct {v0, v1, v3, v2}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->ascending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    const-string v1, "descending"

    const-string v2, "DESC"

    invoke-direct {v0, v1, v4, v2}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->descending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    .line 535
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->ascending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    aput-object v1, v0, v3

    sget-object v1, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->descending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    aput-object v1, v0, v4

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

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
    .line 540
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 541
    iput-object p3, p0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->sql:Ljava/lang/String;

    .line 542
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;
    .locals 1

    .prologue
    .line 535
    const-class v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;
    .locals 1

    .prologue
    .line 535
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->$VALUES:[Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    return-object v0
.end method
