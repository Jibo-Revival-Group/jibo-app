.class public Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;
.super Ljava/lang/Object;
.source "ConnectionInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

.field private final b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

.field private final c:Z


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;)V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a:Landroid/net/NetworkInfo;

    .line 55
    if-nez v0, :cond_0

    .line 57
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->WIFI:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->a:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    .line 58
    sget-object v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->UNKNOWN:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 59
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c:Z

    .line 65
    :goto_0
    return-void

    .line 61
    :cond_0
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    invoke-static {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;->fromType(I)Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->a:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    .line 62
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v1

    invoke-static {v1}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;->fromType(I)Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    .line 63
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c:Z

    goto :goto_0
.end method


# virtual methods
.method public a()Z
    .locals 1

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c:Z

    return v0
.end method

.method public b()Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->a:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    return-object v0
.end method

.method public c()Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 104
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    const-string v1, "ConnectionInfo[IsConnected=%s, Technology=%s, RadioType=%s]"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-boolean v4, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->c:Z

    .line 105
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->a:Lcom/salesforce/android/service/common/utilities/internal/connectivity/Technology;

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/RadioType;

    aput-object v4, v2, v3

    .line 104
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
