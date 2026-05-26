.class Lcom/mixpanel/android/mpmetrics/ExceptionHandler$1;
.super Ljava/lang/Object;
.source "ExceptionHandler.java"

# interfaces
.implements Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mixpanel/android/mpmetrics/ExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Throwable;

.field final synthetic b:Lcom/mixpanel/android/mpmetrics/ExceptionHandler;


# direct methods
.method constructor <init>(Lcom/mixpanel/android/mpmetrics/ExceptionHandler;Ljava/lang/Throwable;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$1;->b:Lcom/mixpanel/android/mpmetrics/ExceptionHandler;

    iput-object p2, p0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$1;->a:Ljava/lang/Throwable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)V
    .locals 3

    .prologue
    .line 38
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 39
    const-string v1, "$ae_crashed_reason"

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/ExceptionHandler$1;->a:Ljava/lang/Throwable;

    invoke-virtual {v2}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 40
    const-string v1, "$ae_crashed"

    const/4 v2, 0x1

    invoke-virtual {p1, v1, v0, v2}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Ljava/lang/String;Lorg/json/JSONObject;Z)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 42
    :goto_0
    return-void

    .line 41
    :catch_0
    move-exception v0

    goto :goto_0
.end method
