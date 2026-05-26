.class Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "LoopPassphraseRestoreDialog_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding$1;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog_ViewBinding$1;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->onSetClicked(Landroid/view/View;)V

    .line 33
    return-void
.end method
