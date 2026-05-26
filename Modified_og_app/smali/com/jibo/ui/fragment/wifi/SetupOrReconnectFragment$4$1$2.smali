.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;)V
    .locals 0

    .prologue
    .line 215
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 219
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->g()V

    .line 221
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->ON_RECONNECT_TO_JIBO:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    iget-object v2, v2, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 223
    return-void
.end method
