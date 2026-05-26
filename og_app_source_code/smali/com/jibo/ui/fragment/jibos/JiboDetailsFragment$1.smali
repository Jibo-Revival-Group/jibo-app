.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 155
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    .line 156
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    if-nez v1, :cond_0

    .line 159
    :goto_0
    return-void

    .line 158
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$1;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    goto :goto_0
.end method
