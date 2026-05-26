.class Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateNicknameRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/profile/ProfileFragment$7;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment$7;)V
    .locals 0

    .prologue
    .line 450
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 453
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment$7;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->g()V

    .line 454
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment$7;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->e(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V

    .line 457
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment$7;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$7$1;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment$7;

    iget-object v1, v1, Lcom/jibo/ui/fragment/profile/ProfileFragment$7;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->f(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/service/SyncHelper;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 458
    return-void
.end method
