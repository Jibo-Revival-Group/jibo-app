.class public Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;
.super Ljava/lang/Object;
.source "SalesforceNotificationBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private a:Landroid/support/v4/app/NotificationCompat$Builder;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;
    .locals 1

    .prologue
    .line 69
    if-eqz p1, :cond_0

    .line 70
    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->b:Ljava/lang/String;

    .line 72
    :cond_0
    return-object p0
.end method

.method public a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;
    .locals 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->b:Ljava/lang/String;

    if-nez v0, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_0

    .line 83
    const-string v0, "miscellaneous"

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->b:Ljava/lang/String;

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    if-nez v0, :cond_1

    .line 88
    new-instance v0, Landroid/support/v4/app/NotificationCompat$Builder;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->b:Ljava/lang/String;

    invoke-direct {v0, p1, v1}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    .line 91
    :cond_1
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;

    iget-object v1, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;-><init>(Landroid/support/v4/app/NotificationCompat$Builder;)V

    return-object v0
.end method
