.class Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$1;
.super Ljava/lang/Object;
.source "CantDeleteDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$1;->a:Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$1;->a:Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->dismiss()V

    .line 32
    return-void
.end method
