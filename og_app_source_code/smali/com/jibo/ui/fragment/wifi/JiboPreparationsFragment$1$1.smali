.class Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1$1;
.super Ljava/lang/Object;
.source "JiboPreparationsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment$1;->a:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/WifiActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/WifiActivity;->q()V

    .line 145
    return-void
.end method
