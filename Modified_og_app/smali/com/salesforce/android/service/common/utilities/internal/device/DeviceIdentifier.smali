.class public Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;
.super Ljava/lang/Object;
.source "DeviceIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;
    }
.end annotation


# instance fields
.field private final a:Landroid/content/SharedPreferences;

.field private final b:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;)V
    .locals 1

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->a:Landroid/content/SharedPreferences;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->a:Landroid/content/SharedPreferences;

    .line 67
    invoke-direct {p0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    invoke-direct {p0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->b:Ljava/lang/String;

    .line 73
    :goto_0
    return-void

    .line 70
    :cond_0
    iget-object v0, p1, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;->a()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->b:Ljava/lang/String;

    .line 71
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->b:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "unique_device_id"

    .line 93
    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 94
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 95
    return-void
.end method

.method private b()Z
    .locals 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->a:Landroid/content/SharedPreferences;

    const-string v1, "unique_device_id"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private c()Ljava/lang/String;
    .locals 3

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->a:Landroid/content/SharedPreferences;

    const-string v1, "unique_device_id"

    const-string v2, "UNKNOWN-DEVICE-ID"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;->b:Ljava/lang/String;

    return-object v0
.end method
