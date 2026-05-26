.class Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$1;
.super Lbutterknife/internal/DebouncingOnClickListener;
.source "AccountDeleteConfirmFragment_ViewBinding.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

.field final synthetic c:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$1;->c:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;

    iput-object p2, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-direct {p0}, Lbutterknife/internal/DebouncingOnClickListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$1;->b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->onCloseButtonClick()V

    .line 36
    return-void
.end method
