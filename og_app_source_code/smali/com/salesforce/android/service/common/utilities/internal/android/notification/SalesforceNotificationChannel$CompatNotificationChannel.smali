.class public Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel$CompatNotificationChannel;
.super Ljava/lang/Object;
.source "SalesforceNotificationChannel.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationChannel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "CompatNotificationChannel"
.end annotation


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 287
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 290
    const-string v0, ""

    return-object v0
.end method

.method public b()Landroid/app/NotificationChannel;
    .locals 2

    .prologue
    .line 382
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Notification Channels are not supported by this version of Android."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
