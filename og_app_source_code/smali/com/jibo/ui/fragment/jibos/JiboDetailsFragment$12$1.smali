.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12$1;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;)V
    .locals 0

    .prologue
    .line 725
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 728
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->g()V

    .line 729
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$12;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->l(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    .line 730
    return-void
.end method
