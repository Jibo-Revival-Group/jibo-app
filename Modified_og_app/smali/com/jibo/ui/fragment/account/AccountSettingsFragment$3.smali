.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;
.super Ljava/lang/Object;
.source "AccountSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V
    .locals 0

    .prologue
    .line 270
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 273
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    .line 274
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->p(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    .line 273
    :goto_0
    invoke-static {v1, v0}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;Z)V

    .line 275
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Ljava/util/List;

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

    .line 276
    instance-of v2, v0, Lcom/jibo/ui/helpers/Items$SwitchRowItem;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 277
    check-cast v1, Lcom/jibo/ui/helpers/Items$SwitchRowItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/SharedPreferencesUtil;->p(Landroid/content/Context;)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/Items$SwitchRowItem;->a(Z)V

    .line 278
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;->notifyItemChanged(I)V

    .line 283
    :cond_1
    return-void

    .line 274
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
