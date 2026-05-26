.class Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$1;
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
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$1;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$1;->a:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/WifiActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/WifiActivity;->q()V

    .line 117
    return-void
.end method
