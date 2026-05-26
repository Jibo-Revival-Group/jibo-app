.class Lcom/jibo/ui/fragment/SplashFragment$1$1$2;
.super Ljava/lang/Object;
.source "SplashFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/SplashFragment$1$1;->onSuccess(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/jibo/ui/fragment/SplashFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/SplashFragment$1$1;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;->b:Lcom/jibo/ui/fragment/SplashFragment$1$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;->b:Lcom/jibo/ui/fragment/SplashFragment$1$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;->a:Ljava/util/List;

    iget-object v2, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;->b:Lcom/jibo/ui/fragment/SplashFragment$1$1;

    iget-object v2, v2, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v2, v2, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/util/List;Lcom/jibo/ui/fragment/BaseFragment;)V

    .line 106
    return-void
.end method
