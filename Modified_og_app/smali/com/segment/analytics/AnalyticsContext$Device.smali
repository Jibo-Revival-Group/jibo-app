.class public Lcom/segment/analytics/AnalyticsContext$Device;
.super Lcom/segment/analytics/ValueMap;
.source "AnalyticsContext.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/segment/analytics/AnalyticsContext;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Device"
.end annotation


# static fields
.field static final DEVICE_ADVERTISING_ID_KEY:Ljava/lang/String; = "advertisingId"

.field static final DEVICE_AD_TRACKING_ENABLED_KEY:Ljava/lang/String; = "adTrackingEnabled"

.field static final DEVICE_ID_KEY:Ljava/lang/String; = "id"

.field static final DEVICE_MANUFACTURER_KEY:Ljava/lang/String; = "manufacturer"

.field static final DEVICE_MODEL_KEY:Ljava/lang/String; = "model"

.field static final DEVICE_NAME_KEY:Ljava/lang/String; = "name"

.field static final DEVICE_TOKEN_KEY:Ljava/lang/String; = "token"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 414
    invoke-direct {p0}, Lcom/segment/analytics/ValueMap;-><init>()V

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
    .line 418
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    .line 419
    return-void
.end method


# virtual methods
.method putAdvertisingInfo(Ljava/lang/String;Z)V
    .locals 2

    .prologue
    .line 429
    if-eqz p2, :cond_0

    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 430
    const-string v0, "advertisingId"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/AnalyticsContext$Device;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 432
    :cond_0
    const-string v0, "adTrackingEnabled"

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext$Device;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    return-void
.end method

.method public putDeviceToken(Ljava/lang/String;)Lcom/segment/analytics/AnalyticsContext$Device;
    .locals 1

    .prologue
    .line 437
    const-string v0, "token"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/AnalyticsContext$Device;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Device;

    move-result-object v0

    return-object v0
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Device;
    .locals 0

    .prologue
    .line 423
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 424
    return-object p0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 403
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/AnalyticsContext$Device;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext$Device;

    move-result-object v0

    return-object v0
.end method
