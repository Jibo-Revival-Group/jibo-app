.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$16;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 977
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$16;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 980
    new-instance v0, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;-><init>()V

    .line 981
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$16;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/LoopInfoDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 982
    return-void
.end method
