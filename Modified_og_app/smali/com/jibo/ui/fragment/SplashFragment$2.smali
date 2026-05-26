.class Lcom/jibo/ui/fragment/SplashFragment$2;
.super Ljava/lang/Object;
.source "SplashFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/SplashFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/SplashFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/SplashFragment;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/jibo/ui/fragment/SplashFragment$2;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 163
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$2;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->q()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 167
    :goto_0
    return-void

    .line 164
    :catch_0
    move-exception v0

    .line 165
    sget-object v1, Lcom/jibo/ui/fragment/SplashFragment;->a:Ljava/lang/String;

    const-string v2, "gotoSignupLoginFragment"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
