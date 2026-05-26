.class public Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;
.super Landroid/support/v4/app/DialogFragment;
.source "CantDeleteDialog.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 22
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0059

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 23
    const v1, 0x7f100238

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 24
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b0046

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 25
    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 26
    invoke-virtual {v2, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 27
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 28
    const v1, 0x7f100232

    new-instance v2, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$1;-><init>(Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 35
    const v1, 0x7f100218

    new-instance v2, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$2;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$2;-><init>(Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 43
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 48
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 49
    return-void
.end method
