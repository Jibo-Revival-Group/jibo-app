.class Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;
.super Ljava/lang/Object;
.source "AccountSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a(Lcom/jibo/aws/integration/aws/services/skills/model/GetSettingsRequest;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 203
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->g()V

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->a:Ljava/util/List;

    invoke-interface {v0, v1, v2}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    .line 206
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1$2;->b:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;->notifyDataSetChanged()V

    .line 208
    :cond_0
    return-void
.end method
