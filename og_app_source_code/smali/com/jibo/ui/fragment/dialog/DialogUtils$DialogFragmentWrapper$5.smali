.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->g(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

.field final synthetic b:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V
    .locals 0

    .prologue
    .line 709
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;->b:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 712
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 713
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;->b:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;->b:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetRequestCode()I

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-static {v0, v1, p2, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;IILjava/lang/Object;)V

    .line 714
    return-void
.end method
