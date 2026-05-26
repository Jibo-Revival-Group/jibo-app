.class public Lcom/segment/analytics/AnalyticsContext;
.super Lcom/segment/analytics/ValueMap;
.source "AnalyticsContext.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/AnalyticsContext$Referrer;,
        Lcom/segment/analytics/AnalyticsContext$Location;,
        Lcom/segment/analytics/AnalyticsContext$Device;,
        Lcom/segment/analytics/AnalyticsContext$Campaign;
    }
.end annotation


# static fields
.field private static final APP_BUILD_KEY:Ljava/lang/String; = "build"

.field private static final APP_KEY:Ljava/lang/String; = "app"

.field private static final APP_NAMESPACE_KEY:Ljava/lang/String; = "namespace"

.field private static final APP_NAME_KEY:Ljava/lang/String; = "name"

.field private static final APP_VERSION_KEY:Ljava/lang/String; = "version"

.field private static final CAMPAIGN_KEY:Ljava/lang/String; = "campaign"

.field private static final DEVICE_KEY:Ljava/lang/String; = "device"

.field private static final LIBRARY_KEY:Ljava/lang/String; = "library"

.field private static final LIBRARY_NAME_KEY:Ljava/lang/String; = "name"

.field private static final LIBRARY_VERSION_KEY:Ljava/lang/String; = "version"

.field private static final LOCALE_KEY:Ljava/lang/String; = "locale"

.field private static final LOCATION_KEY:Ljava/lang/String; = "location"

.field private static final NETWORK_BLUETOOTH_KEY:Ljava/lang/String; = "bluetooth"

.field private static final NETWORK_CARRIER_KEY:Ljava/lang/String; = "carrier"

.field private static final NETWORK_CELLULAR_KEY:Ljava/lang/String; = "cellular"

.field private static final NETWORK_KEY:Ljava/lang/String; = "network"

.field private static final NETWORK_WIFI_KEY:Ljava/lang/String; = "wifi"

.field private static final OS_KEY:Ljava/lang/String; = "os"

.field private static final OS_NAME_KEY:Ljava/lang/String; = "name"

.field private static final OS_VERSION_KEY:Ljava/lang/String; = "version"

.field private static final REFERRER_KEY:Ljava/lang/String; = "referrer"

.field private static final SCREEN_DENSITY_KEY:Ljava/lang/String; = "density"

.field private static final SCREEN_HEIGHT_KEY:Ljava/lang/String; = "height"

.field private static final SCREEN_KEY:Ljava/lang/String; = "screen"

.field private static final SCREEN_WIDTH_KEY:Ljava/lang/String; = "width"

.field private static final TIMEZONE_KEY:Ljava/lang/String; = "timezone"

.field private static final TRAITS_KEY:Ljava/lang/String; = "traits"

.field private static final USER_AGENT_KEY:Ljava/lang/String; = "userAgent"


# direct methods
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
    .line 149
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    .line 150
    return-void
.end method

.method static declared-synchronized create(Landroid/content/Context;Lcom/segment/analytics/Traits;Z)Lcom/segment/analytics/AnalyticsContext;
    .locals 5

    .prologue
    .line 123
    const-class v1, Lcom/segment/analytics/AnalyticsContext;

    monitor-enter v1

    :try_start_0
    new-instance v0, Lcom/segment/analytics/AnalyticsContext;

    new-instance v2, Lcom/segment/analytics/internal/Utils$NullableConcurrentHashMap;

    invoke-direct {v2}, Lcom/segment/analytics/internal/Utils$NullableConcurrentHashMap;-><init>()V

    invoke-direct {v0, v2}, Lcom/segment/analytics/AnalyticsContext;-><init>(Ljava/util/Map;)V

    .line 125
    invoke-virtual {v0, p0}, Lcom/segment/analytics/AnalyticsContext;->putApp(Landroid/content/Context;)V

    .line 126
    invoke-virtual {v0, p1}, Lcom/segment/analytics/AnalyticsContext;->setTraits(Lcom/segment/analytics/Traits;)V

    .line 127
    invoke-virtual {v0, p0, p2}, Lcom/segment/analytics/AnalyticsContext;->putDevice(Landroid/content/Context;Z)V

    .line 128
    invoke-virtual {v0}, Lcom/segment/analytics/AnalyticsContext;->putLibrary()V

    .line 129
    const-string v2, "locale"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 130
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "-"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 129
    invoke-virtual {v0, v2, v3}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    invoke-virtual {v0, p0}, Lcom/segment/analytics/AnalyticsContext;->putNetwork(Landroid/content/Context;)V

    .line 132
    invoke-virtual {v0}, Lcom/segment/analytics/AnalyticsContext;->putOs()V

    .line 133
    invoke-virtual {v0, p0}, Lcom/segment/analytics/AnalyticsContext;->putScreen(Landroid/content/Context;)V

    .line 134
    const-string v2, "userAgent"

    const-string v3, "http.agent"

    invoke-static {v3}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v2, v3}, Lcom/segment/analytics/AnalyticsContext;->putUndefinedIfNull(Ljava/util/Map;Ljava/lang/String;Ljava/lang/CharSequence;)V

    .line 135
    const-string v2, "timezone"

    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v2, v3}, Lcom/segment/analytics/AnalyticsContext;->putUndefinedIfNull(Ljava/util/Map;Ljava/lang/String;Ljava/lang/CharSequence;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 136
    monitor-exit v1

    return-object v0

    .line 123
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method static putUndefinedIfNull(Ljava/util/Map;Ljava/lang/String;Ljava/lang/CharSequence;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ")V"
        }
    .end annotation

    .prologue
    .line 140
    invoke-static {p2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 141
    const-string v0, "undefined"

    invoke-interface {p0, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    :goto_0
    return-void

    .line 143
    :cond_0
    invoke-interface {p0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method


# virtual methods
.method attachAdvertisingId(Landroid/content/Context;Ljava/util/concurrent/CountDownLatch;Lcom/segment/analytics/integrations/Logger;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 155
    const-string v0, "com.google.android.gms.ads.identifier.AdvertisingIdClient"

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isOnClassPath(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 157
    new-instance v0, Lcom/segment/analytics/GetAdvertisingIdTask;

    invoke-direct {v0, p0, p2, p3}, Lcom/segment/analytics/GetAdvertisingIdTask;-><init>(Lcom/segment/analytics/AnalyticsContext;Ljava/util/concurrent/CountDownLatch;Lcom/segment/analytics/integrations/Logger;)V

    const/4 v1, 0x1

    new-array v1, v1, [Landroid/content/Context;

    aput-object p1, v1, v2

    invoke-virtual {v0, v1}, Lcom/segment/analytics/GetAdvertisingIdTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 165
    :goto_0
    return-void

    .line 159
    :cond_0
    const-string v0, "Not collecting advertising ID because com.google.android.gms.ads.identifier.AdvertisingIdClient was not found on the classpath."

    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {p3, v0, v1}, Lcom/segment/analytics/integrations/Logger;->debug(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 163
    invoke-virtual {p2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0
.end method

.method public campaign()Lcom/segment/analytics/AnalyticsContext$Campaign;
    .locals 2

    .prologue
    .line 224
    const-string v0, "campaign"

    const-class v1, Lcom/segment/analytics/AnalyticsContext$Campaign;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->getValueMap(Ljava/lang/String;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/AnalyticsContext$Campaign;

    return-object v0
.end method

.method public device()Lcom/segment/analytics/AnalyticsContext$Device;
    .locals 2

    .prologue
    .line 239
    const-string v0, "device"

    const-class v1, Lcom/segment/analytics/AnalyticsContext$Device;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->getValueMap(Ljava/lang/String;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/AnalyticsContext$Device;

    return-object v0
.end method

.method public location()Lcom/segment/analytics/AnalyticsContext$Location;
    .locals 2

    .prologue
    .line 262
    const-string v0, "location"

    const-class v1, Lcom/segment/analytics/AnalyticsContext$Location;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->getValueMap(Ljava/lang/String;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/AnalyticsContext$Location;

    return-object v0
.end method

.method putApp(Landroid/content/Context;)V
    .locals 5

    .prologue
    .line 205
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 206
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 207
    invoke-static {}, Lcom/segment/analytics/internal/Utils;->createMap()Ljava/util/Map;

    move-result-object v2

    .line 208
    const-string v3, "name"

    iget-object v4, v1, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v4, v0}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v2, v3, v0}, Lcom/segment/analytics/AnalyticsContext;->putUndefinedIfNull(Ljava/util/Map;Ljava/lang/String;Ljava/lang/CharSequence;)V

    .line 209
    const-string v0, "version"

    iget-object v3, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-static {v2, v0, v3}, Lcom/segment/analytics/AnalyticsContext;->putUndefinedIfNull(Ljava/util/Map;Ljava/lang/String;Ljava/lang/CharSequence;)V

    .line 210
    const-string v0, "namespace"

    iget-object v3, v1, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    invoke-static {v2, v0, v3}, Lcom/segment/analytics/AnalyticsContext;->putUndefinedIfNull(Ljava/util/Map;Ljava/lang/String;Ljava/lang/CharSequence;)V

    .line 211
    const-string v0, "build"

    iget v1, v1, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 212
    const-string v0, "app"

    invoke-virtual {p0, v0, v2}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 216
    :goto_0
    return-void

    .line 213
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public putCampaign(Lcom/segment/analytics/AnalyticsContext$Campaign;)Lcom/segment/analytics/AnalyticsContext;
    .locals 1

    .prologue
    .line 220
    const-string v0, "campaign"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/AnalyticsContext;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext;

    move-result-object v0

    return-object v0
.end method

.method putDevice(Landroid/content/Context;Z)V
    .locals 3

    .prologue
    .line 229
    new-instance v1, Lcom/segment/analytics/AnalyticsContext$Device;

    invoke-direct {v1}, Lcom/segment/analytics/AnalyticsContext$Device;-><init>()V

    .line 230
    if-eqz p2, :cond_0

    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->getDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 231
    :goto_0
    const-string v2, "id"

    invoke-virtual {v1, v2, v0}, Lcom/segment/analytics/AnalyticsContext$Device;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 232
    const-string v0, "manufacturer"

    sget-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lcom/segment/analytics/AnalyticsContext$Device;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 233
    const-string v0, "model"

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lcom/segment/analytics/AnalyticsContext$Device;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    const-string v0, "name"

    sget-object v2, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Lcom/segment/analytics/AnalyticsContext$Device;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 235
    const-string v0, "device"

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 236
    return-void

    .line 230
    :cond_0
    invoke-virtual {p0}, Lcom/segment/analytics/AnalyticsContext;->traits()Lcom/segment/analytics/Traits;

    move-result-object v0

    invoke-virtual {v0}, Lcom/segment/analytics/Traits;->anonymousId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public putDeviceToken(Ljava/lang/String;)Lcom/segment/analytics/AnalyticsContext;
    .locals 1

    .prologue
    .line 244
    invoke-virtual {p0}, Lcom/segment/analytics/AnalyticsContext;->device()Lcom/segment/analytics/AnalyticsContext$Device;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/segment/analytics/AnalyticsContext$Device;->putDeviceToken(Ljava/lang/String;)Lcom/segment/analytics/AnalyticsContext$Device;

    .line 245
    return-object p0
.end method

.method putLibrary()V
    .locals 3

    .prologue
    .line 250
    invoke-static {}, Lcom/segment/analytics/internal/Utils;->createMap()Ljava/util/Map;

    move-result-object v0

    .line 251
    const-string v1, "name"

    const-string v2, "analytics-android"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 252
    const-string v1, "version"

    const-string v2, "4.3.1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 253
    const-string v1, "library"

    invoke-virtual {p0, v1, v0}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 254
    return-void
.end method

.method public putLocation(Lcom/segment/analytics/AnalyticsContext$Location;)Lcom/segment/analytics/AnalyticsContext;
    .locals 1

    .prologue
    .line 258
    const-string v0, "location"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/AnalyticsContext;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext;

    move-result-object v0

    return-object v0
.end method

.method putNetwork(Landroid/content/Context;)V
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 270
    invoke-static {}, Lcom/segment/analytics/internal/Utils;->createMap()Ljava/util/Map;

    move-result-object v4

    .line 271
    const-string v0, "android.permission.ACCESS_NETWORK_STATE"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->hasPermission(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 272
    const-string v0, "connectivity"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->getSystemService(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 273
    if-eqz v0, :cond_0

    .line 274
    invoke-virtual {v0, v2}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v1

    .line 275
    const-string v5, "wifi"

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v2

    :goto_0
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v4, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v1

    .line 277
    const-string v5, "bluetooth"

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_2

    move v1, v2

    :goto_1
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v4, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    invoke-virtual {v0, v3}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v0

    .line 279
    const-string v1, "cellular"

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_3

    :goto_2
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {v4, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 283
    :cond_0
    const-string v0, "phone"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->getSystemService(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 284
    if-eqz v0, :cond_4

    .line 285
    const-string v1, "carrier"

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 290
    :goto_3
    const-string v0, "network"

    invoke-virtual {p0, v0, v4}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 291
    return-void

    :cond_1
    move v1, v3

    .line 275
    goto :goto_0

    :cond_2
    move v1, v3

    .line 277
    goto :goto_1

    :cond_3
    move v2, v3

    .line 279
    goto :goto_2

    .line 287
    :cond_4
    const-string v0, "carrier"

    const-string v1, "unknown"

    invoke-interface {v4, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3
.end method

.method putOs()V
    .locals 3

    .prologue
    .line 295
    invoke-static {}, Lcom/segment/analytics/internal/Utils;->createMap()Ljava/util/Map;

    move-result-object v0

    .line 296
    const-string v1, "name"

    const-string v2, "Android"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 297
    const-string v1, "version"

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 298
    const-string v1, "os"

    invoke-virtual {p0, v1, v0}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    return-void
.end method

.method public putReferrer(Lcom/segment/analytics/AnalyticsContext$Referrer;)Lcom/segment/analytics/AnalyticsContext;
    .locals 1

    .prologue
    .line 303
    const-string v0, "referrer"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/AnalyticsContext;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext;

    move-result-object v0

    return-object v0
.end method

.method putScreen(Landroid/content/Context;)V
    .locals 4

    .prologue
    .line 312
    invoke-static {}, Lcom/segment/analytics/internal/Utils;->createMap()Ljava/util/Map;

    move-result-object v1

    .line 313
    const-string v0, "window"

    invoke-static {p1, v0}, Lcom/segment/analytics/internal/Utils;->getSystemService(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 314
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 315
    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    .line 316
    invoke-virtual {v0, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 317
    const-string v0, "density"

    iget v3, v2, Landroid/util/DisplayMetrics;->density:F

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 318
    const-string v0, "height"

    iget v3, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 319
    const-string v0, "width"

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 320
    const-string v0, "screen"

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 321
    return-void
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext;
    .locals 0

    .prologue
    .line 169
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 170
    return-object p0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 76
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/AnalyticsContext;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/AnalyticsContext;

    move-result-object v0

    return-object v0
.end method

.method setTraits(Lcom/segment/analytics/Traits;)V
    .locals 2

    .prologue
    .line 184
    const-string v0, "traits"

    invoke-virtual {p1}, Lcom/segment/analytics/Traits;->unmodifiableCopy()Lcom/segment/analytics/Traits;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 185
    return-void
.end method

.method public traits()Lcom/segment/analytics/Traits;
    .locals 2

    .prologue
    .line 195
    const-string v0, "traits"

    const-class v1, Lcom/segment/analytics/Traits;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/AnalyticsContext;->getValueMap(Ljava/lang/String;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/Traits;

    return-object v0
.end method

.method public unmodifiableCopy()Lcom/segment/analytics/AnalyticsContext;
    .locals 2

    .prologue
    .line 175
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p0}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    .line 176
    new-instance v1, Lcom/segment/analytics/AnalyticsContext;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/segment/analytics/AnalyticsContext;-><init>(Ljava/util/Map;)V

    return-object v1
.end method
