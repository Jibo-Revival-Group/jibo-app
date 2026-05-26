.class Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;
.super Ljava/lang/Object;
.source "TakeoverInAppActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a(Landroid/widget/Button;Lcom/mixpanel/android/mpmetrics/InAppButton;Lcom/mixpanel/android/mpmetrics/InAppNotification;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/mixpanel/android/mpmetrics/InAppButton;

.field final synthetic b:Lcom/mixpanel/android/mpmetrics/InAppNotification;

.field final synthetic c:I

.field final synthetic d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;


# direct methods
.method constructor <init>(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;Lcom/mixpanel/android/mpmetrics/InAppButton;Lcom/mixpanel/android/mpmetrics/InAppNotification;I)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;

    iput-object p2, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->a:Lcom/mixpanel/android/mpmetrics/InAppButton;

    iput-object p3, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->b:Lcom/mixpanel/android/mpmetrics/InAppNotification;

    iput p4, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->c:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 180
    const/4 v1, 0x0

    .line 181
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->a:Lcom/mixpanel/android/mpmetrics/InAppButton;

    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/InAppButton;->e()Ljava/lang/String;

    move-result-object v2

    .line 182
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 185
    :try_start_0
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 192
    :try_start_1
    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v3, v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 193
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;

    invoke-virtual {v0, v3}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Landroid/content/ActivityNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 199
    :goto_0
    :try_start_2
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 200
    :try_start_3
    const-string v1, "url"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_5

    move-object v1, v0

    .line 205
    :cond_0
    :goto_1
    const-string v2, "primary"

    .line 206
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->b:Lcom/mixpanel/android/mpmetrics/InAppNotification;

    check-cast v0, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;

    .line 207
    invoke-virtual {v0}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;->r()I

    move-result v0

    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    .line 208
    iget v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->c:I

    if-nez v0, :cond_2

    const-string v0, "secondary"

    :goto_2
    move-object v2, v0

    .line 211
    :cond_1
    if-nez v1, :cond_3

    .line 212
    :try_start_4
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_3

    .line 214
    :goto_3
    :try_start_5
    const-string v1, "button"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_4

    .line 218
    :goto_4
    iget-object v1, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;

    invoke-static {v1}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->b(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;

    move-result-object v1

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI;->c()Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;

    move-result-object v1

    const-string v2, "$campaign_open"

    iget-object v3, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->b:Lcom/mixpanel/android/mpmetrics/InAppNotification;

    invoke-interface {v1, v2, v3, v0}, Lcom/mixpanel/android/mpmetrics/MixpanelAPI$People;->a(Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/InAppNotification;Lorg/json/JSONObject;)V

    .line 219
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;

    invoke-virtual {v0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->finish()V

    .line 220
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$3;->d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;

    invoke-static {v0}, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;)I

    move-result v0

    invoke-static {v0}, Lcom/mixpanel/android/mpmetrics/UpdateDisplayState;->a(I)V

    .line 221
    :goto_5
    return-void

    .line 186
    :catch_0
    move-exception v0

    .line 187
    const-string v1, "MixpanelAPI.TakeoverInAppActivity"

    const-string v2, "Can\'t parse notification URI, will not take any action"

    invoke-static {v1, v2, v0}, Lcom/mixpanel/android/util/MPLog;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_5

    .line 194
    :catch_1
    move-exception v0

    .line 195
    const-string v0, "MixpanelAPI.TakeoverInAppActivity"

    const-string v3, "User doesn\'t have an activity for notification URI"

    invoke-static {v0, v3}, Lcom/mixpanel/android/util/MPLog;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 201
    :catch_2
    move-exception v0

    move-object v0, v1

    .line 202
    :goto_6
    const-string v1, "MixpanelAPI.TakeoverInAppActivity"

    const-string v2, "Can\'t put url into json properties"

    invoke-static {v1, v2}, Lcom/mixpanel/android/util/MPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v0

    goto :goto_1

    .line 208
    :cond_2
    const-string v0, "primary"

    goto :goto_2

    .line 215
    :catch_3
    move-exception v0

    move-object v0, v1

    .line 216
    :goto_7
    const-string v1, "MixpanelAPI.TakeoverInAppActivity"

    const-string v2, "Can\'t put button type into json properties"

    invoke-static {v1, v2}, Lcom/mixpanel/android/util/MPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    .line 215
    :catch_4
    move-exception v1

    goto :goto_7

    .line 201
    :catch_5
    move-exception v1

    goto :goto_6

    :cond_3
    move-object v0, v1

    goto :goto_3
.end method
