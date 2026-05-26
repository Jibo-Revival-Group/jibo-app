.class Lcom/mixpanel/android/mpmetrics/InAppFragment$3;
.super Ljava/lang/Object;
.source "InAppFragment.java"

# interfaces
.implements Landroid/view/GestureDetector$OnGestureListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mixpanel/android/mpmetrics/InAppFragment;->onAttach(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/mixpanel/android/mpmetrics/InAppFragment;


# direct methods
.method constructor <init>(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;->a:Lcom/mixpanel/android/mpmetrics/InAppFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 113
    const/4 v0, 0x1

    return v0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1

    .prologue
    .line 119
    const/4 v0, 0x0

    cmpl-float v0, p4, v0

    if-lez v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;->a:Lcom/mixpanel/android/mpmetrics/InAppFragment;

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V

    .line 122
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 0

    .prologue
    .line 126
    return-void
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1

    .prologue
    .line 131
    const/4 v0, 0x0

    return v0
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 0

    .prologue
    .line 135
    return-void
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 139
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;->a:Lcom/mixpanel/android/mpmetrics/InAppFragment;

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->e(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState$DisplayState$InAppNotificationState;->a()Lcom/mixpanel/android/mpmetrics/InAppNotification;

    move-result-object v0

    check-cast v0, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;

    .line 141
    const/4 v2, 0x0

    .line 142
    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/MiniInAppNotification;->n()Ljava/lang/String;

    move-result-object v3

    .line 143
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 146
    :try_start_0
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 153
    :try_start_1
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.VIEW"

    invoke-direct {v4, v5, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 154
    iget-object v5, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;->a:Lcom/mixpanel/android/mpmetrics/InAppFragment;

    invoke-static {v5}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->d(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Landroid/app/Activity;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Landroid/content/ActivityNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 160
    :goto_0
    :try_start_2
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 161
    :try_start_3
    const-string v2, "url"

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    .line 166
    :goto_1
    iget-object v2, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;->a:Lcom/mixpanel/android/mpmetrics/InAppFragment;

    invoke-static {v2}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->f(Lcom/mixpanel/android/mpmetrics/InAppFragment;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    move-result-object v2

    invoke-virtual {v2}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->c()Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    move-result-object v2

    const-string v3, "$campaign_open"

    invoke-interface {v2, v3, v0, v1}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/InAppNotification;Lorg/json/JSONObject;)V

    .line 168
    iget-object v0, p0, Lcom/mixpanel/android/mpmetrics/InAppFragment$3;->a:Lcom/mixpanel/android/mpmetrics/InAppFragment;

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/InAppFragment;->a(Lcom/mixpanel/android/mpmetrics/InAppFragment;)V

    .line 169
    :goto_2
    return v7

    .line 147
    :catch_0
    move-exception v0

    .line 148
    const-string v1, "MixpanelAPI.InAppFrag"

    const-string v2, "Can\'t parse notification URI, will not take any action"

    invoke-static {v1, v2, v0}, Lcom/mixpanel/android/util/MPLog;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 155
    :catch_1
    move-exception v4

    .line 156
    const-string v4, "MixpanelAPI.InAppFrag"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "User doesn\'t have an activity for notification URI "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Lcom/mixpanel/android/util/MPLog;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 162
    :catch_2
    move-exception v1

    move-object v1, v2

    .line 163
    :goto_3
    const-string v2, "MixpanelAPI.InAppFrag"

    const-string v3, "Can\'t put url into json properties"

    invoke-static {v2, v3}, Lcom/mixpanel/android/util/MPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 162
    :catch_3
    move-exception v2

    goto :goto_3

    :cond_0
    move-object v1, v2

    goto :goto_1
.end method
