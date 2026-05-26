.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Lcom/facebook/FacebookCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/FacebookCallback",
        "<",
        "Lcom/facebook/login/LoginResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/facebook/login/LoginResult;)V
    .locals 4

    .prologue
    .line 146
    invoke-virtual {p1}, Lcom/facebook/login/LoginResult;->getRecentlyGrantedPermissions()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 147
    invoke-virtual {p1}, Lcom/facebook/login/LoginResult;->getAccessToken()Lcom/facebook/AccessToken;

    move-result-object v0

    .line 148
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/facebook/AccessToken;->getToken()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->p:Ljava/lang/String;

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f08011a

    const v3, 0x7f06001f

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 152
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    .line 153
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->p:Ljava/lang/String;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->q:Lcom/amazonaws/handlers/AsyncHandler;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->facebookMobileConnect(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {p1}, Lcom/facebook/login/LoginResult;->getAccessToken()Lcom/facebook/AccessToken;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->a(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Lcom/facebook/AccessToken;)V

    .line 158
    :cond_0
    return-void
.end method

.method public onCancel()V
    .locals 4

    .prologue
    .line 162
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080228

    const v3, 0x7f06007b

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    const v1, 0x7f1000d3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 165
    return-void
.end method

.method public onError(Lcom/facebook/FacebookException;)V
    .locals 4

    .prologue
    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    invoke-static {v0, p1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/Throwable;)V

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080228

    const v3, 0x7f06007b

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    const v1, 0x7f1000d3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 173
    return-void
.end method

.method public synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 142
    check-cast p1, Lcom/facebook/login/LoginResult;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$2;->a(Lcom/facebook/login/LoginResult;)V

    return-void
.end method
