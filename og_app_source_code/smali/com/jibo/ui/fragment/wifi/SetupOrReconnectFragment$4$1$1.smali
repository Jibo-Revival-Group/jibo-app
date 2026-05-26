.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 208
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1;->b:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4$1$1;->a:Ljava/lang/Exception;

    const-string v2, "Error restoring key"

    const/4 v3, 0x1

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 209
    return-void
.end method
