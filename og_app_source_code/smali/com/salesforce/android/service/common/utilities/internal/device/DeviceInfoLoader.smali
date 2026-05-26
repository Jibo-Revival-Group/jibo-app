.class public Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;
.super Ljava/lang/Object;
.source "DeviceInfoLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;)V
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/AndroidInfo;

    .line 72
    iget-object v1, p1, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->c:Landroid/content/pm/PackageInfo;

    .line 73
    iget-object v2, p1, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->d:Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;

    invoke-virtual {v2}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->a()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->a:Ljava/lang/String;

    .line 74
    iget-object v2, p1, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader$Builder;->a:Ljava/lang/String;

    iput-object v2, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->b:Ljava/lang/String;

    .line 75
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    const-string v3, "%s (%d)"

    new-array v4, v8, [Ljava/lang/Object;

    iget-object v5, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    aput-object v5, v4, v6

    iget v1, v1, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v4, v7

    invoke-static {v2, v3, v4}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->c:Ljava/lang/String;

    .line 76
    const-string v1, "%s %s %s"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const-string v3, "android"

    aput-object v3, v2, v6

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/AndroidInfo;->a()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v7

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/AndroidInfo;->b()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v8

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->d:Ljava/lang/String;

    .line 77
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/AndroidInfo;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->e:Ljava/lang/String;

    .line 78
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->d:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceInfoLoader;->e:Ljava/lang/String;

    return-object v0
.end method
