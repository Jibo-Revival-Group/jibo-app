.class public Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "TipsFragment$NextButtonViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f090078

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    .line 26
    const-string v0, "field \'nextButton\' and method \'next\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 27
    const-string v0, "field \'nextButton\'"

    const-class v2, Landroid/widget/Button;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->nextButton:Landroid/widget/Button;

    .line 28
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;->c:Landroid/view/View;

    .line 29
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    .line 41
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 42
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;

    .line 44
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder;->nextButton:Landroid/widget/Button;

    .line 46
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$NextButtonViewHolder_ViewBinding;->c:Landroid/view/View;

    .line 48
    return-void
.end method
