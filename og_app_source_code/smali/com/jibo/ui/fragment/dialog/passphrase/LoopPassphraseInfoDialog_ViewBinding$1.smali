.class Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "LoopPassphraseInfoDialog_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;-><init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$1;->c:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$1;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog_ViewBinding$1;->b:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->okayClicked(Landroid/view/View;)V

    .line 34
    return-void
.end method
