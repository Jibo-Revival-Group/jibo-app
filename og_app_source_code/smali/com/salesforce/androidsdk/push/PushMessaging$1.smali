.class final Lcom/salesforce/androidsdk/push/PushMessaging$1;
.super Ljava/lang/Object;
.source "PushMessaging.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/push/PushMessaging;->b(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/google/android/gms/iid/InstanceID;


# direct methods
.method constructor <init>(Lcom/google/android/gms/iid/InstanceID;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/salesforce/androidsdk/push/PushMessaging$1;->a:Lcom/google/android/gms/iid/InstanceID;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 126
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/push/PushMessaging$1;->a:Lcom/google/android/gms/iid/InstanceID;

    invoke-virtual {v0}, Lcom/google/android/gms/iid/InstanceID;->a()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 130
    :goto_0
    return-void

    .line 127
    :catch_0
    move-exception v0

    .line 128
    const-string v1, "PushMessaging"

    const-string v2, "Error deleting InstanceID"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
