.class public Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;
.super Ljava/lang/Object;
.source "SalesforceNotificationChannel.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$CompatNotificationChannel;,
        Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$OreoNotificationChannel;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V
    .locals 2

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_0

    .line 45
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$OreoNotificationChannel;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$OreoNotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;->a:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    .line 49
    :goto_0
    return-void

    .line 47
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$CompatNotificationChannel;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$CompatNotificationChannel;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;->a:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    goto :goto_0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;->a:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b()Landroid/app/NotificationChannel;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;->a:Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;->b()Landroid/app/NotificationChannel;

    move-result-object v0

    return-object v0
.end method
