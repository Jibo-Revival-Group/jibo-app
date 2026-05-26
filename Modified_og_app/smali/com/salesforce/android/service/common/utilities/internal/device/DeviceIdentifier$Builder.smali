.class public Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;
.super Ljava/lang/Object;
.source "DeviceIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:Landroid/content/SharedPreferences;

.field protected b:Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

.field private c:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->c:Landroid/content/Context;

    .line 115
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;
    .locals 3

    .prologue
    .line 129
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->a:Landroid/content/SharedPreferences;

    if-nez v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->c:Landroid/content/Context;

    const-string v1, "com.salesforce.android.service"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->a:Landroid/content/SharedPreferences;

    .line 135
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

    if-nez v0, :cond_1

    .line 136
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;->b:Lcom/salesforce/android/service/common/utilities/internal/android/UUIDProvider;

    .line 139
    :cond_1
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier;-><init>(Lcom/salesforce/android/service/common/utilities/internal/device/DeviceIdentifier$Builder;)V

    return-object v0
.end method
