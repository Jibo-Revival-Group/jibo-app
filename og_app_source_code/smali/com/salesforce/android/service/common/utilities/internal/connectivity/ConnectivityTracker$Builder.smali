.class public Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;
.super Ljava/lang/Object;
.source "ConnectivityTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/content/Context;

.field protected b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

.field protected c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

.field protected d:Landroid/net/ConnectivityManager;

.field protected e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 174
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;
    .locals 0

    .prologue
    .line 183
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a:Landroid/content/Context;

    .line 184
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

    .line 189
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;
    .locals 2

    .prologue
    .line 208
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Listener;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 211
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->d:Landroid/net/ConnectivityManager;

    if-nez v0, :cond_0

    .line 212
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->a:Landroid/content/Context;

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->d:Landroid/net/ConnectivityManager;

    .line 215
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    if-nez v0, :cond_1

    .line 216
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->c:Lcom/salesforce/android/service/common/utilities/internal/android/IntentFactory;

    .line 219
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    if-nez v0, :cond_2

    .line 220
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;->e:Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;

    .line 223
    :cond_2
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker;-><init>(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectivityTracker$Builder;)V

    return-object v0
.end method
