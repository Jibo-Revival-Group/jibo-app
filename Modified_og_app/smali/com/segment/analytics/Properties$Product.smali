.class public Lcom/segment/analytics/Properties$Product;
.super Lcom/segment/analytics/ValueMap;
.source "Properties.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/Properties;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Product"
.end annotation


# static fields
.field private static final ID_KEY:Ljava/lang/String; = "id"

.field private static final NAME_KEY:Ljava/lang/String; = "name"

.field private static final PRICE_KEY:Ljava/lang/String; = "price"

.field private static final SKU_KEY:Ljava/lang/String; = "sku"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;D)V
    .locals 3

    .prologue
    .line 407
    invoke-direct {p0}, Lcom/segment/analytics/ValueMap;-><init>()V

    .line 408
    const-string v0, "id"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties$Product;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 409
    const-string v0, "sku"

    invoke-virtual {p0, v0, p2}, Lcom/segment/analytics/Properties$Product;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 410
    const-string v0, "price"

    invoke-static {p3, p4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties$Product;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 411
    return-void
.end method

.method private constructor <init>(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 415
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    .line 416
    return-void
.end method


# virtual methods
.method public id()Ljava/lang/String;
    .locals 1

    .prologue
    .line 428
    const-string v0, "id"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties$Product;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 424
    const-string v0, "name"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties$Product;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public price()D
    .locals 4

    .prologue
    .line 436
    const-string v0, "price"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties$Product;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public putName(Ljava/lang/String;)Lcom/segment/analytics/Properties$Product;
    .locals 1

    .prologue
    .line 420
    const-string v0, "name"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties$Product;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties$Product;

    move-result-object v0

    return-object v0
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties$Product;
    .locals 0

    .prologue
    .line 441
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 442
    return-object p0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 392
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/Properties$Product;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties$Product;

    move-result-object v0

    return-object v0
.end method

.method public sku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 432
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties$Product;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
