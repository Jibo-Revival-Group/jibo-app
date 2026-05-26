.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


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
    .line 161
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 9

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 164
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$MemberItem;

    .line 165
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v3

    if-nez v3, :cond_0

    move v0, v1

    .line 174
    :goto_0
    return v0

    .line 167
    :cond_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$MemberItem;->b()Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const/16 v3, 0x74

    iget-object v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v5, 0x7f100109

    new-array v6, v2, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 170
    invoke-static {v7}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v1

    invoke-virtual {v4, v5, v6}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v6, 0x7f1000ff

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 171
    invoke-static {v8}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v8

    invoke-virtual {v8}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v1

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 172
    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v1

    aput-object v1, v7, v2

    .line 171
    invoke-virtual {v5, v6, v7}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iget-object v5, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$2;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v6, 0x7f100269

    .line 173
    invoke-virtual {v5, v6}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 169
    invoke-static {v0, v3, v4, v1, v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move v0, v2

    .line 174
    goto :goto_0
.end method
