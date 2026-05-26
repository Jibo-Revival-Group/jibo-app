.class Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;
.super Ljava/lang/Object;
.source "SelectGuardianFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->b:Ljava/lang/Boolean;

    .line 164
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->o:Z

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;-><init>()V

    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 166
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->d:Ljava/lang/String;

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment$2;->a:Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/SelectGuardianFragment;->a(Ljava/lang/Class;)V

    .line 168
    return-void
.end method
