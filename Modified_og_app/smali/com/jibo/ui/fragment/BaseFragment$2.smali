.class Lcom/jibo/ui/fragment/BaseFragment$2;
.super Ljava/lang/Object;
.source "BaseFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/BaseFragment;->j()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/BaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/BaseFragment;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lcom/jibo/ui/fragment/BaseFragment$2;->b:Lcom/jibo/ui/fragment/BaseFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/BaseFragment$2;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 316
    iget-object v0, p0, Lcom/jibo/ui/fragment/BaseFragment$2;->a:Ljava/lang/Exception;

    check-cast v0, Lcom/jibo/aws/integration/aws/services/exception/UnauthorizedRequestException;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/exception/UnauthorizedRequestException;->getErrorMessage()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Clock skew"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 317
    iget-object v0, p0, Lcom/jibo/ui/fragment/BaseFragment$2;->b:Lcom/jibo/ui/fragment/BaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f100125

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 319
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/BaseFragment$2;->b:Lcom/jibo/ui/fragment/BaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/OnBoardingActivity;->j:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 320
    return-void
.end method
