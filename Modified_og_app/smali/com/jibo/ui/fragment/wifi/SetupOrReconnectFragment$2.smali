.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$2;
.super Ljava/lang/Object;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a()V
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
    .line 120
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 123
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    const v1, 0x7f1002e8

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 124
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$2;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->startActivity(Landroid/content/Intent;)V

    .line 126
    return-void
.end method
