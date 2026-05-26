.class public Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;
.super Ljava/lang/Object;
.source "SalesforceNotificationManager.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationManager;


# instance fields
.field private a:Landroid/support/v4/app/NotificationManagerCompat;

.field private b:Landroid/app/NotificationManager;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    invoke-static {p1}, Landroid/support/v4/app/NotificationManagerCompat;->a(Landroid/content/Context;)Landroid/support/v4/app/NotificationManagerCompat;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;->a:Landroid/support/v4/app/NotificationManagerCompat;

    .line 51
    const-string v0, "notification"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;->b:Landroid/app/NotificationManager;

    .line 52
    return-void
.end method

.method public static a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;
    .locals 1

    .prologue
    .line 46
    new-instance v0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;-><init>(Landroid/content/Context;)V

    return-object v0
.end method


# virtual methods
.method public a(ILandroid/app/Notification;)V
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;->a:Landroid/support/v4/app/NotificationManagerCompat;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/app/NotificationManagerCompat;->a(ILandroid/app/Notification;)V

    .line 68
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;)V
    .locals 2

    .prologue
    .line 79
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_0

    .line 80
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/notification/SalesforceNotificationManager;->b:Landroid/app/NotificationManager;

    invoke-interface {p1}, Lcom/salesforce/android/service/common/utilities/internal/android/notification/NotificationChannel;->b()Landroid/app/NotificationChannel;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 82
    :cond_0
    return-void
.end method
