.class Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a(Lcom/jibo/aws/integration/aws/services/loop/model/RemoveMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/ProfileFragment$6;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment$6;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 424
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment$6;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 429
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/db/EntityData;->b(Ljava/lang/String;)V

    .line 430
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment$6;->a:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 431
    return-void
.end method
