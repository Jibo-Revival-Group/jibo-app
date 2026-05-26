.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$6;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;)V
    .locals 0

    .prologue
    .line 736
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$6;->a:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 739
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 740
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$6;->a:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$6;->a:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetRequestCode()I

    move-result v1

    const/4 v2, 0x0

    invoke-static {v0, v1, p2, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;IILjava/lang/Object;)V

    .line 741
    return-void
.end method
