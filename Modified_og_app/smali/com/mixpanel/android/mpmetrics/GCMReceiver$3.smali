.class Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;
.super Ljava/lang/Object;
.source "GCMReceiver.java"

# interfaces
.implements Lcom/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mixpanel/android/mpmetrics/GCMReceiver;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Lcom/mixpanel/android/mpmetrics/GCMReceiver;


# direct methods
.method constructor <init>(Lcom/mixpanel/android/mpmetrics/GCMReceiver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 456
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->d:Lcom/mixpanel/android/mpmetrics/GCMReceiver;

    iput-object p2, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->b:Ljava/lang/String;

    iput-object p4, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)V
    .locals 3

    .prologue
    .line 459
    invoke-virtual {p1}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->g()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 460
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 462
    :try_start_0
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->a:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 463
    new-instance v0, Lorg/json/JSONObject;

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->a:Ljava/lang/String;

    invoke-direct {v0, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 468
    :goto_0
    :try_start_1
    const-string v1, "campaign_id"

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->b:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 469
    const-string v1, "message_id"

    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/GCMReceiver$3;->c:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 470
    const-string v1, "message_type"

    const-string v2, "push"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 471
    const-string v1, "$campaign_received"

    invoke-virtual {p1, v1, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->a(Ljava/lang/String;Lorg/json/JSONObject;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 474
    :cond_0
    :goto_1
    return-void

    .line 465
    :catch_0
    move-exception v0

    move-object v0, v1

    goto :goto_0

    .line 472
    :catch_1
    move-exception v0

    goto :goto_1

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method
