.class public Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;
.super Ljava/lang/Object;
.source "SalesforceNotificationBuilder.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder$Builder;
    }
.end annotation


# instance fields
.field private final a:Landroid/support/v4/app/NotificationCompat$Builder;


# direct methods
.method protected constructor <init>(Landroid/support/v4/app/NotificationCompat$Builder;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    .line 61
    return-void
.end method


# virtual methods
.method public a()Landroid/app/Notification;
    .locals 1

    .prologue
    .line 341
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompat$Builder;->b()Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method public a(I)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 121
    return-object p0
.end method

.method public a(Landroid/app/PendingIntent;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 171
    return-object p0
.end method

.method public a(Landroid/support/v4/app/NotificationCompat$Style;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 296
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Landroid/support/v4/app/NotificationCompat$Style;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 297
    return-object p0
.end method

.method public a(Ljava/lang/CharSequence;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->b(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 136
    return-object p0
.end method

.method public a(Z)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->a(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 232
    return-object p0
.end method

.method public b(I)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->b(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 247
    return-object p0
.end method

.method public c(I)Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationBuilder;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationBuilder;->a:Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/NotificationCompat$Builder;->c(I)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 252
    return-object p0
.end method
