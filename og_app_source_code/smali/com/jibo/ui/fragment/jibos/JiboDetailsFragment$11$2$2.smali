.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field final synthetic b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 0

    .prologue
    .line 690
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 693
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 695
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    .line 696
    instance-of v2, v0, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    if-eqz v2, :cond_2

    move-object v1, v0

    .line 697
    check-cast v1, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->a:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    move-object v1, v0

    .line 698
    check-cast v1, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->a:Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/Items$WifiSettingsItem;->a(Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    .line 699
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->j(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iget-object v2, v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v2, v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->i(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/jibos/adapter/LoopMembersListAdapter;->notifyItemChanged(I)V

    .line 706
    :cond_1
    :goto_0
    return-void

    .line 701
    :cond_2
    instance-of v0, v0, Lcom/jibo/ui/helpers/Items$JiboSettingsItem;

    if-eqz v0, :cond_0

    .line 702
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11$2;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$11;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    goto :goto_0
.end method
