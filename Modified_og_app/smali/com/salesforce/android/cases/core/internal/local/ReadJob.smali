.class public Lcom/salesforce/android/cases/core/internal/local/ReadJob;
.super Ljava/lang/Object;
.source "ReadJob.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Job;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/threading/Job",
        "<",
        "Lorg/json/JSONArray;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

.field private c:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

.field private d:I

.field private e:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 34
    const-class v0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method private constructor <init>(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;ILcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    .line 42
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->c:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    .line 43
    iput p3, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->d:I

    .line 44
    iput-object p4, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 45
    return-void
.end method

.method public static a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;ILcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/cases/core/internal/local/ReadJob;
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/local/ReadJob;-><init>(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;ILcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<",
            "Lorg/json/JSONArray;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 49
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/local/DbUtils;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 50
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot read from db, not authenticated"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 51
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 63
    :goto_0
    return-void

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->b:Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->c:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    iget v2, p0, Lcom/salesforce/android/cases/core/internal/local/ReadJob;->d:I

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;

    move-result-object v0

    .line 55
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0

    .line 56
    :catch_0
    move-exception v0

    .line 57
    invoke-interface {p1, v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 58
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    goto :goto_0
.end method
