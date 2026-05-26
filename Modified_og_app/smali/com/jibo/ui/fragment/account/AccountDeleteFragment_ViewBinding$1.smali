.class Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "AccountDeleteFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountDeleteFragment;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding$1;->c:Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->onBtnDelete()V

    .line 40
    return-void
.end method
