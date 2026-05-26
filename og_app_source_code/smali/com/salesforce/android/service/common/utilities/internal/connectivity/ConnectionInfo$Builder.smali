.class public Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;
.super Ljava/lang/Object;
.source "ConnectionInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/net/NetworkInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/net/NetworkInfo;)Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;->a:Landroid/net/NetworkInfo;

    .line 118
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;
    .locals 1

    .prologue
    .line 122
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo;-><init>(Lcom/salesforce/android/service/common/utilities/internal/connectivity/ConnectionInfo$Builder;)V

    return-object v0
.end method
