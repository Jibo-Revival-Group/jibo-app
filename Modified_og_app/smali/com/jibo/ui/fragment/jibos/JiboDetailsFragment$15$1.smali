.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 923
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;

    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 926
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;

    iget-object v0, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;->a:Ljava/lang/Exception;

    invoke-static {v0, v1}, Lcom/jibo/utils/ErrorHelper;->a(Landroid/content/Context;Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    .line 928
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15$1;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$15;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Ljava/lang/String;)V

    .line 929
    return-void
.end method
