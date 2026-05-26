.class Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$2;
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
    .line 35
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$2;->a:Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 38
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "https://support.jibo.com/jibo/articles/en_US/FAQ/delete-account"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 39
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog$2;->a:Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->startActivity(Landroid/content/Intent;)V

    .line 40
    return-void
.end method
