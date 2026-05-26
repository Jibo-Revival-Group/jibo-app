.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a(Lcom/jibo/aws/integration/aws/services/collision/model/MatchRequest;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

.field final synthetic b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;)V
    .locals 0

    .prologue
    .line 310
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iput-object p2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 313
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->g()V

    .line 315
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b(Z)V

    .line 318
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->a:Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/collision/model/CollisionCheckContainer;->getCollision()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 319
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 320
    const-string v1, "ARG_NICKNAME"

    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const-class v2, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v1, v2, v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 326
    :goto_0
    return-void

    .line 324
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$2;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const-class v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Ljava/lang/Class;)V

    goto :goto_0
.end method
