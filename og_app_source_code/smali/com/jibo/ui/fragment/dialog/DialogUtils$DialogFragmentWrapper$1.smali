.class Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;
.super Ljava/lang/Object;
.source "DialogUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnShowListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/app/AlertDialog;

.field final synthetic b:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/support/v7/app/AlertDialog;)V
    .locals 0

    .prologue
    .line 340
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;->b:Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;->a:Landroid/support/v7/app/AlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onShow(Landroid/content/DialogInterface;)V
    .locals 6

    .prologue
    .line 343
    const/4 v0, 0x3

    new-array v1, v0, [I

    fill-array-data v1, :array_0

    .line 344
    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_1

    aget v3, v1, v0

    .line 346
    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;->a:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v4, v3}, Landroid/support/v7/app/AlertDialog;->a(I)Landroid/widget/Button;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/ui/view/proxima/ProximaHelper;->b(Landroid/view/View;)V

    .line 347
    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;->a:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v4, v3}, Landroid/support/v7/app/AlertDialog;->a(I)Landroid/widget/Button;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 348
    iget-object v4, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;->a:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v4, v3}, Landroid/support/v7/app/AlertDialog;->a(I)Landroid/widget/Button;

    move-result-object v3

    .line 350
    const/high16 v4, 0x41800000    # 16.0f

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setTextSize(F)V

    .line 352
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x15

    if-lt v4, v5, :cond_0

    .line 353
    const v4, 0x3df5c28f    # 0.12f

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setLetterSpacing(F)V

    .line 344
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 357
    :cond_1
    return-void

    .line 343
    :array_0
    .array-data 4
        -0x1
        -0x2
        -0x3
    .end array-data
.end method
