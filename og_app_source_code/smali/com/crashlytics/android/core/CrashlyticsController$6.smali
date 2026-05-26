.class Lcom/crashlytics/android/core/CrashlyticsController$6;
.super Ljava/lang/Object;
.source "CrashlyticsController.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/crashlytics/android/core/CrashlyticsController;->a(Ljava/lang/Thread;Ljava/lang/Throwable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/util/Date;

.field final synthetic b:Ljava/lang/Thread;

.field final synthetic c:Ljava/lang/Throwable;

.field final synthetic d:Lcom/crashlytics/android/core/CrashlyticsController;


# direct methods
.method constructor <init>(Lcom/crashlytics/android/core/CrashlyticsController;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 285
    iput-object p1, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    iput-object p2, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->a:Ljava/util/Date;

    iput-object p3, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->b:Ljava/lang/Thread;

    iput-object p4, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->c:Ljava/lang/Throwable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/Void;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 290
    iget-object v0, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    invoke-static {v0}, Lcom/crashlytics/android/core/CrashlyticsController;->a(Lcom/crashlytics/android/core/CrashlyticsController;)Lcom/crashlytics/android/core/CrashlyticsCore;

    move-result-object v0

    invoke-virtual {v0}, Lcom/crashlytics/android/core/CrashlyticsCore;->o()V

    .line 292
    iget-object v0, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    iget-object v2, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->a:Ljava/util/Date;

    iget-object v3, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->b:Ljava/lang/Thread;

    iget-object v4, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->c:Ljava/lang/Throwable;

    invoke-static {v0, v2, v3, v4}, Lcom/crashlytics/android/core/CrashlyticsController;->a(Lcom/crashlytics/android/core/CrashlyticsController;Ljava/util/Date;Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 294
    invoke-static {}, Lio/fabric/sdk/android/services/settings/Settings;->a()Lio/fabric/sdk/android/services/settings/Settings;

    move-result-object v0

    invoke-virtual {v0}, Lio/fabric/sdk/android/services/settings/Settings;->b()Lio/fabric/sdk/android/services/settings/SettingsData;

    move-result-object v2

    .line 295
    if-eqz v2, :cond_2

    iget-object v0, v2, Lio/fabric/sdk/android/services/settings/SettingsData;->b:Lio/fabric/sdk/android/services/settings/SessionSettingsData;

    .line 298
    :goto_0
    iget-object v3, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    invoke-virtual {v3, v0}, Lcom/crashlytics/android/core/CrashlyticsController;->b(Lio/fabric/sdk/android/services/settings/SessionSettingsData;)V

    .line 299
    iget-object v3, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    invoke-static {v3}, Lcom/crashlytics/android/core/CrashlyticsController;->b(Lcom/crashlytics/android/core/CrashlyticsController;)V

    .line 301
    if-eqz v0, :cond_0

    .line 302
    iget-object v3, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    iget v0, v0, Lio/fabric/sdk/android/services/settings/SessionSettingsData;->g:I

    invoke-virtual {v3, v0}, Lcom/crashlytics/android/core/CrashlyticsController;->a(I)V

    .line 305
    :cond_0
    iget-object v0, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    invoke-static {v0, v2}, Lcom/crashlytics/android/core/CrashlyticsController;->a(Lcom/crashlytics/android/core/CrashlyticsController;Lio/fabric/sdk/android/services/settings/SettingsData;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 306
    iget-object v0, p0, Lcom/crashlytics/android/core/CrashlyticsController$6;->d:Lcom/crashlytics/android/core/CrashlyticsController;

    invoke-static {v0, v2}, Lcom/crashlytics/android/core/CrashlyticsController;->b(Lcom/crashlytics/android/core/CrashlyticsController;Lio/fabric/sdk/android/services/settings/SettingsData;)V

    .line 308
    :cond_1
    return-object v1

    :cond_2
    move-object v0, v1

    .line 295
    goto :goto_0
.end method

.method public synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 285
    invoke-virtual {p0}, Lcom/crashlytics/android/core/CrashlyticsController$6;->a()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method
