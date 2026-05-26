.class Lcom/jibo/ui/fragment/BaseFragment$3;
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
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/jibo/ui/fragment/BaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/BaseFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 335
    iput-object p1, p0, Lcom/jibo/ui/fragment/BaseFragment$3;->b:Lcom/jibo/ui/fragment/BaseFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/BaseFragment$3;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 338
    iget-object v0, p0, Lcom/jibo/ui/fragment/BaseFragment$3;->b:Lcom/jibo/ui/fragment/BaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->l()V

    .line 341
    iget-object v0, p0, Lcom/jibo/ui/fragment/BaseFragment$3;->b:Lcom/jibo/ui/fragment/BaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/BaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    iget-object v1, p0, Lcom/jibo/ui/fragment/BaseFragment$3;->a:Ljava/util/List;

    iget-object v2, p0, Lcom/jibo/ui/fragment/BaseFragment$3;->b:Lcom/jibo/ui/fragment/BaseFragment;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->a(Ljava/util/List;Lcom/jibo/ui/fragment/BaseFragment;)V

    .line 342
    return-void
.end method
