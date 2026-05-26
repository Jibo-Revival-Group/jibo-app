.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 183
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    .line 186
    invoke-virtual {v3}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    .line 185
    invoke-static {v0, v3}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v0

    .line 190
    :try_start_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 195
    :goto_0
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 196
    :goto_1
    if-eqz v0, :cond_1

    .line 197
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-static {v0, v2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 228
    :goto_2
    return-void

    .line 191
    :catch_0
    move-exception v0

    move-object v0, v1

    .line 192
    goto :goto_0

    .line 195
    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    .line 199
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->f()V

    .line 201
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v0

    .line 202
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    invoke-direct {v4, p0, v2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-virtual {v0, v3, v1, v4}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    goto :goto_2
.end method
