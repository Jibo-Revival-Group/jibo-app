.class Lcom/jibo/ui/activity/OnBoardingActivity$1;
.super Ljava/lang/Object;
.source "OnBoardingActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/OnBoardingActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/OnBoardingActivity;)V
    .locals 0

    .prologue
    .line 292
    iput-object p1, p0, Lcom/jibo/ui/activity/OnBoardingActivity$1;->a:Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 295
    iget-object v0, p0, Lcom/jibo/ui/activity/OnBoardingActivity$1;->a:Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    const v1, 0x7f09013f

    iget-object v2, p0, Lcom/jibo/ui/activity/OnBoardingActivity$1;->a:Lcom/jibo/ui/activity/OnBoardingActivity;

    const-class v3, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;

    .line 296
    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/activity/OnBoardingActivity$1;->a:Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v4, v4, Lcom/jibo/ui/activity/OnBoardingActivity;->m:Landroid/os/Bundle;

    invoke-static {v2, v3, v4}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    sget-object v3, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/fragment/onboarding/SignupCompleteFragment;->a:Ljava/lang/String;

    .line 297
    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 298
    return-void
.end method
