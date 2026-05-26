.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;",
        "Lcom/jibo/aws/integration/aws/services/key/model/Backup;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V
    .locals 2

    .prologue
    .line 215
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$2;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Ljava/lang/Runnable;)V

    .line 225
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 2

    .prologue
    .line 205
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;Ljava/lang/Exception;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Ljava/lang/Runnable;)V

    .line 211
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 202
    check-cast p1, Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/key/model/Backup;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V

    return-void
.end method
