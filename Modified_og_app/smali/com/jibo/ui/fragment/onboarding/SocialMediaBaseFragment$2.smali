.class Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;
.super Ljava/lang/Object;
.source "SocialMediaBaseFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 3

    .prologue
    .line 82
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, p2, v1, v2}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;ZLcom/amazonaws/handlers/AsyncHandler;)V

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 90
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->isActive()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;)V

    .line 105
    :cond_0
    :goto_0
    return-void

    .line 94
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;-><init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 65
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    const-string v1, "login"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 66
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    new-instance v1, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$1;-><init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->a(Ljava/lang/Runnable;)V

    .line 76
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 62
    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V

    return-void
.end method
