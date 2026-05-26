.class Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;
.super Ljava/lang/Object;
.source "AccountSettingsDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;)V
    .locals 0

    .prologue
    .line 439
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 442
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v1, v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 443
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5$1;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment$5;->a:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->t()V

    .line 444
    return-void
.end method
