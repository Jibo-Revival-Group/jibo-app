.class public Lcom/salesforce/android/cases/core/internal/local/WriteJob;
.super Ljava/lang/Object;
.source "WriteJob.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/threading/Job",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

.field private c:Ljava/lang/String;

.field private d:Lorg/json/JSONArray;

.field private final e:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;Lorg/json/JSONArray;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 46
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->c:Ljava/lang/String;

    .line 47
    iput-object p3, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->d:Lorg/json/JSONArray;

    .line 48
    iput-object p4, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 49
    return-void
.end method

.method public static a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;Lorg/json/JSONArray;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/cases/core/internal/local/WriteJob;
    .locals 1

    .prologue
    .line 75
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/local/WriteJob;-><init>(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;Lorg/json/JSONArray;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v1, 0x0

    .line 53
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 54
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot write to db, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 55
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 71
    :goto_0
    return-void

    .line 59
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->c:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Ljava/lang/String;)V

    .line 60
    sget-object v0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Starting Write to {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->c:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-interface {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    move v0, v1

    .line 61
    :goto_1
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->d:Lorg/json/JSONArray;

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 62
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->d:Lorg/json/JSONArray;

    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 61
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 64
    :catch_0
    move-exception v0

    .line 65
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 66
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0

    .line 69
    :cond_1
    sget-object v0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Write to {} complete"

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/local/WriteJob;->c:Ljava/lang/String;

    aput-object v4, v3, v1

    invoke-interface {v0, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 70
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
