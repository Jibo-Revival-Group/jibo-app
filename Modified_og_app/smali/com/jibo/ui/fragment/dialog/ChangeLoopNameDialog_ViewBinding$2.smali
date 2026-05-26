.class Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$2;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "ChangeLoopNameDialog_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;-><init>(Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

.field final synthetic c:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$2;->c:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$2;->b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog_ViewBinding$2;->b:Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    invoke-virtual {v0, p1}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->onSetClicked(Landroid/view/View;)V

    .line 44
    return-void
.end method
