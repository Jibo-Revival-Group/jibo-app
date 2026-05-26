.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;)V
    .locals 0

    .prologue
    .line 646
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 650
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->h(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    if-eqz v0, :cond_0

    .line 651
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    .line 652
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a(Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    .line 653
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->j(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->notifyItemChanged(I)V

    .line 655
    :cond_0
    return-void
.end method
