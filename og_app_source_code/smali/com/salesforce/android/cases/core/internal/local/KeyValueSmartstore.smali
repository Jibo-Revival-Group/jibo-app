.class public Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;
.super Ljava/lang/Object;
.source "KeyValueSmartstore.java"


# static fields
.field private static final a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;


# instance fields
.field private final b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field private final c:Ljava/lang/String;

.field private d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 43
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const/4 v1, 0x0

    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const-string v3, "key"

    sget-object v4, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->string:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    invoke-direct {v2, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)V

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 3

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const-class v0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 55
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    .line 56
    invoke-static {p2}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 57
    invoke-static {}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->H()Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/androidsdk/smartstore/app/SmartStoreSDKManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 58
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    sget-object v2, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    .line 60
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;)Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 63
    const/4 v6, 0x0

    .line 65
    const/4 v7, 0x0

    .line 66
    const/4 v5, 0x1

    .line 68
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    const-string v1, "key"

    const-string v3, "key"

    sget-object v4, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->descending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    move-object v2, p1

    invoke-static/range {v0 .. v5}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    .line 70
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-virtual {v1, v0, v7}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;

    move-result-object v0

    .line 71
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 72
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    const-string v1, "value"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 78
    :goto_0
    return-object v0

    .line 74
    :catch_0
    move-exception v0

    .line 75
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "JSONException: Error reading mapped value for {} due to {}."

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v8

    .line 76
    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v9

    .line 75
    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    :cond_0
    move-object v0, v6

    goto :goto_0
.end method

.method public a()Ljava/util/Map;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 101
    const/4 v1, 0x0

    .line 103
    const v0, 0x7fffffff

    .line 104
    const/4 v3, 0x0

    .line 106
    :try_start_0
    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    const-string v5, "key"

    sget-object v6, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->descending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    .line 107
    invoke-static {v4, v5, v6, v0}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    .line 108
    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    invoke-virtual {v4, v0, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;

    move-result-object v3

    .line 109
    new-instance v0, Ljava/util/HashMap;

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    const/high16 v5, 0x3f800000    # 1.0f

    invoke-direct {v0, v4, v5}, Ljava/util/HashMap;-><init>(IF)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move v1, v2

    .line 110
    :goto_0
    :try_start_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v1, v4, :cond_0

    .line 111
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "key"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 112
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    const-string v6, "value"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 113
    invoke-virtual {v0, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 110
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 115
    :catch_0
    move-exception v0

    move-object v7, v0

    move-object v0, v1

    move-object v1, v7

    .line 116
    :goto_1
    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v4, "JSONException: Error reading all mapped values due to {}."

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v1}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v2

    invoke-interface {v3, v4, v5}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 118
    :cond_0
    return-object v0

    .line 115
    :catch_1
    move-exception v1

    goto :goto_1
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 83
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 85
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Long;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v6, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    const-string v7, "key"

    .line 86
    invoke-virtual {v5, v6, v7, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;[Ljava/lang/Long;)Lorg/json/JSONArray;

    move-result-object v1

    .line 88
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-eqz v2, :cond_0

    .line 89
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 91
    :cond_0
    const-string v1, "key"

    invoke-virtual {v0, v1, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 92
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 94
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->d:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 98
    :goto_0
    return-void

    .line 95
    :catch_0
    move-exception v0

    .line 96
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->b:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "JSONException writing to {}. {} "

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/KeyValueSmartstore;->c:Ljava/lang/String;

    aput-object v4, v3, v8

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v9

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
