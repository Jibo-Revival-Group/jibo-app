.class Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;
.super Ljava/lang/Object;
.source "SocialMediaBaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a(Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 94
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 98
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->g()V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;->b:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2;->a:Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/SocialMediaBaseFragment$2$2;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    return-void
.end method
