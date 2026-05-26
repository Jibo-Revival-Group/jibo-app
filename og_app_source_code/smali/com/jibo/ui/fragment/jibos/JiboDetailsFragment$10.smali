.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->r()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field final synthetic b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 0

    .prologue
    .line 616
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 619
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const/16 v1, 0x78

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v4, 0x7f100102

    new-array v5, v9, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 620
    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v5, 0x7f1000fa

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 621
    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    iget-object v7, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 622
    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->getAccount()Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    move-result-object v7

    invoke-virtual {v7}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getFirstName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v9

    .line 621
    invoke-virtual {v4, v5, v6}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$10;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    const v6, 0x7f100055

    .line 623
    invoke-virtual {v5, v6}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 619
    invoke-static/range {v0 .. v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILcom/jibo/aws/integration/aws/services/loop/model/Member;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 624
    return-void
.end method
