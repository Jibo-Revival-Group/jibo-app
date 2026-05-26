.class Lcom/jibo/ui/fragment/SplashFragment$1$1$1;
.super Ljava/lang/Object;
.source "SplashFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/SplashFragment$1$1;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/SplashFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/SplashFragment$1$1;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$1;->a:Lcom/jibo/ui/fragment/SplashFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 73
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$1;->a:Lcom/jibo/ui/fragment/SplashFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$1;->a:Lcom/jibo/ui/fragment/SplashFragment$1$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/SplashFragment$1$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    return-void
.end method
