.class Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;
.super Ljava/lang/Object;
.source "NamePronunciationFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;)V
    .locals 0

    .prologue
    .line 184
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 3

    .prologue
    .line 187
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne p1, v0, :cond_0

    .line 188
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    iget v0, v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->s:I

    if-nez v0, :cond_0

    .line 189
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    iget v1, v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->s:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->s:I

    .line 190
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment$2;->a:Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/NamePronunciationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f10025b

    .line 191
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(I)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f10025a

    .line 192
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(I)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x104000a

    const/4 v2, 0x0

    .line 193
    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 196
    :cond_0
    return-void
.end method
