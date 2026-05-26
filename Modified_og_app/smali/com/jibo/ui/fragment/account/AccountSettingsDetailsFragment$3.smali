.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$3;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Lcom/facebook/GraphRequest$GraphJSONObjectCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Lcom/facebook/AccessToken;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V
    .locals 0

    .prologue
    .line 376
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted(Lorg/json/JSONObject;Lcom/facebook/GraphResponse;)V
    .locals 2

    .prologue
    .line 379
    const-string v0, "LoginActivity"

    invoke-virtual {p2}, Lcom/facebook/GraphResponse;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 381
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 382
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    const-string v1, "name"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 395
    :cond_0
    :goto_0
    return-void

    .line 384
    :catch_0
    move-exception v0

    goto :goto_0
.end method
