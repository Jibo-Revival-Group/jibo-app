.class public Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;
.super Ljava/lang/Object;
.source "AccountDeleteConfirmFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x1020027

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    .line 29
    const-string v0, "field \'closeButton\' and method \'onCloseButtonClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 30
    const-string v0, "field \'closeButton\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->closeButton:Landroid/widget/ImageView;

    .line 31
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->c:Landroid/view/View;

    .line 32
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const v0, 0x7f0900f8

    const-string v1, "field \'cross1\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross1:Landroid/widget/ImageView;

    .line 39
    const v0, 0x7f0900f9

    const-string v1, "field \'cross2\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross2:Landroid/widget/ImageView;

    .line 40
    const v0, 0x7f0900fa

    const-string v1, "field \'cross3\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross3:Landroid/widget/ImageView;

    .line 41
    const v0, 0x7f0900fb

    const-string v1, "field \'cross4\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross4:Landroid/widget/ImageView;

    .line 42
    const v0, 0x7f090145

    const-string v1, "field \'hideWarning\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->hideWarning:Landroid/view/View;

    .line 43
    const v0, 0x7f0902fb

    const-string v1, "field \'title\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->title:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 44
    const v0, 0x7f09032f

    const-string v1, "field \'warning1\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning1:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 45
    const v0, 0x7f090330

    const-string v1, "field \'warning2\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 46
    const v0, 0x7f090331

    const-string v1, "field \'warning3\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 47
    const v0, 0x7f09005f

    const-string v1, "method \'onBtnDelete\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 48
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->d:Landroid/view/View;

    .line 49
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    .line 61
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;

    .line 64
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->closeButton:Landroid/widget/ImageView;

    .line 65
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross1:Landroid/widget/ImageView;

    .line 66
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross2:Landroid/widget/ImageView;

    .line 67
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross3:Landroid/widget/ImageView;

    .line 68
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->cross4:Landroid/widget/ImageView;

    .line 69
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->hideWarning:Landroid/view/View;

    .line 70
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->title:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 71
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning1:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 72
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 73
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment;->warning3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 76
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->c:Landroid/view/View;

    .line 77
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 78
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteConfirmFragment_ViewBinding;->d:Landroid/view/View;

    .line 79
    return-void
.end method
