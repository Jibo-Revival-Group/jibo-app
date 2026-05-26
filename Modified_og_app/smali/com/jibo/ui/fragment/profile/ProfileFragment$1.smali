.class Lcom/jibo/ui/fragment/profile/ProfileFragment$1;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/Menu;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/view/Menu;)V
    .locals 0

    .prologue
    .line 237
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->a:Landroid/view/Menu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 240
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->a:Landroid/view/Menu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->a:Landroid/view/Menu;

    check-cast v0, Landroid/support/v7/view/menu/MenuBuilder;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/MenuBuilder;->k()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->a:Landroid/view/Menu;

    check-cast v0, Landroid/support/v7/view/menu/MenuBuilder;

    .line 241
    invoke-virtual {v0}, Landroid/support/v7/view/menu/MenuBuilder;->k()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 242
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->a:Landroid/view/Menu;

    check-cast v0, Landroid/support/v7/view/menu/MenuBuilder;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/MenuBuilder;->k()Ljava/util/ArrayList;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/MenuItem;

    .line 243
    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 244
    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment$1;Landroid/view/MenuItem;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 252
    :cond_0
    return-void
.end method
