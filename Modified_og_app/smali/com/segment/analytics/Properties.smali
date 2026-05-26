.class public Lcom/segment/analytics/Properties;
.super Lcom/segment/analytics/ValueMap;
.source "Properties.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/Properties$Product;
    }
.end annotation


# static fields
.field private static final CATEGORY_KEY:Ljava/lang/String; = "category"

.field private static final COUPON_KEY:Ljava/lang/String; = "coupon"

.field private static final CURRENCY_KEY:Ljava/lang/String; = "currency"

.field private static final DISCOUNT_KEY:Ljava/lang/String; = "discount"

.field private static final ID_KEY:Ljava/lang/String; = "id"

.field private static final NAME_KEY:Ljava/lang/String; = "name"

.field private static final ORDER_ID_KEY:Ljava/lang/String; = "orderId"

.field private static final PATH_KEY:Ljava/lang/String; = "path"

.field private static final PRICE_KEY:Ljava/lang/String; = "price"

.field private static final PRODUCTS_KEY:Ljava/lang/String; = "products"

.field private static final REFERRER_KEY:Ljava/lang/String; = "referrer"

.field private static final REPEAT_KEY:Ljava/lang/String; = "repeat"

.field private static final REVENUE_KEY:Ljava/lang/String; = "revenue"

.field private static final SHIPPING_KEY:Ljava/lang/String; = "shipping"

.field private static final SKU_KEY:Ljava/lang/String; = "sku"

.field private static final SUBTOTAL_KEY:Ljava/lang/String; = "subtotal"

.field private static final TAX_KEY:Ljava/lang/String; = "tax"

.field private static final TITLE_KEY:Ljava/lang/String; = "title"

.field private static final TOTAL_KEY:Ljava/lang/String; = "total"

.field private static final URL_KEY:Ljava/lang/String; = "url"

.field private static final VALUE_KEY:Ljava/lang/String; = "value"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/segment/analytics/ValueMap;-><init>()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0

    .prologue
    .line 70
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(I)V

    .line 71
    return-void
.end method

.method constructor <init>(Ljava/util/Map;)V
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
    .line 75
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    .line 76
    return-void
.end method


# virtual methods
.method public category()Ljava/lang/String;
    .locals 1

    .prologue
    .line 199
    const-string v0, "category"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public coupon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 346
    const-string v0, "coupon"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public currency()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    const-string v0, "currency"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public discount()D
    .locals 4

    .prologue
    .line 333
    const-string v0, "discount"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public isRepeatCustomer()Z
    .locals 2

    .prologue
    .line 382
    const-string v0, "repeat"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public name()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    const-string v0, "name"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public orderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 251
    const-string v0, "orderId"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public path()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    const-string v0, "path"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public price()D
    .locals 4

    .prologue
    .line 225
    const-string v0, "price"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public productId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 238
    const-string v0, "id"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public products()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/segment/analytics/Properties$Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 369
    const-string v0, "products"

    const-class v1, Lcom/segment/analytics/Properties$Product;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->getList(Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public varargs products([Lcom/segment/analytics/Properties$Product;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/segment/analytics/Properties$Product;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/segment/analytics/Properties$Product;",
            ">;"
        }
    .end annotation

    .prologue
    .line 365
    invoke-virtual {p0}, Lcom/segment/analytics/Properties;->products()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public putCategory(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 195
    const-string v0, "category"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putCoupon(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 342
    const-string v0, "coupon"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putCurrency(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 115
    const-string v0, "currency"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putDiscount(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 329
    const-string v0, "discount"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putName(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 181
    const-string v0, "name"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putOrderId(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 247
    const-string v0, "orderId"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putPath(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 128
    const-string v0, "path"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putPrice(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 221
    const-string v0, "price"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putProductId(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 234
    const-string v0, "id"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public varargs putProducts([Lcom/segment/analytics/Properties$Product;)Lcom/segment/analytics/Properties;
    .locals 2

    .prologue
    .line 355
    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty([Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 356
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "products cannot be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 358
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    array-length v1, p1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 359
    invoke-static {v0, p1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 360
    const-string v1, "products"

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v1, v0}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putReferrer(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 142
    const-string v0, "referrer"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putRepeatCustomer(Z)Lcom/segment/analytics/Properties;
    .locals 2

    .prologue
    .line 378
    const-string v0, "repeat"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putRevenue(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 89
    const-string v0, "revenue"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putShipping(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 303
    const-string v0, "shipping"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putSku(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 208
    const-string v0, "sku"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putSubtotal()D
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 290
    invoke-virtual {p0}, Lcom/segment/analytics/Properties;->subtotal()D

    move-result-wide v0

    return-wide v0
.end method

.method public putSubtotal(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 282
    const-string v0, "subtotal"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putTax(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 316
    const-string v0, "tax"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putTitle(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 155
    const-string v0, "title"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putTotal(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 260
    const-string v0, "total"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putUrl(Ljava/lang/String;)Lcom/segment/analytics/Properties;
    .locals 1

    .prologue
    .line 168
    const-string v0, "url"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putValue(D)Lcom/segment/analytics/Properties;
    .locals 3

    .prologue
    .line 102
    const-string v0, "value"

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;
    .locals 0

    .prologue
    .line 80
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 81
    return-object p0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 40
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/Properties;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Properties;

    move-result-object v0

    return-object v0
.end method

.method public referrer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    const-string v0, "referrer"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public revenue()D
    .locals 4

    .prologue
    .line 93
    const-string v0, "revenue"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public shipping()D
    .locals 4

    .prologue
    .line 307
    const-string v0, "shipping"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public sku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 212
    const-string v0, "sku"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public subtotal()D
    .locals 4

    .prologue
    .line 294
    const-string v0, "subtotal"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public tax()D
    .locals 4

    .prologue
    .line 320
    const-string v0, "tax"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    const-string v0, "title"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public total()D
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 264
    const-string v0, "total"

    invoke-virtual {p0, v0, v4, v5}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    .line 265
    cmpl-double v2, v0, v4

    if-eqz v2, :cond_1

    .line 272
    :cond_0
    :goto_0
    return-wide v0

    .line 268
    :cond_1
    invoke-virtual {p0}, Lcom/segment/analytics/Properties;->revenue()D

    move-result-wide v0

    .line 269
    cmpl-double v2, v0, v4

    if-nez v2, :cond_0

    .line 272
    invoke-virtual {p0}, Lcom/segment/analytics/Properties;->value()D

    move-result-wide v0

    goto :goto_0
.end method

.method public url()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    const-string v0, "url"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Properties;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public value()D
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 106
    const-string v0, "value"

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Properties;->getDouble(Ljava/lang/String;D)D

    move-result-wide v0

    .line 107
    cmpl-double v2, v0, v2

    if-eqz v2, :cond_0

    .line 110
    :goto_0
    return-wide v0

    :cond_0
    invoke-virtual {p0}, Lcom/segment/analytics/Properties;->revenue()D

    move-result-wide v0

    goto :goto_0
.end method
