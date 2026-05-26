.class public Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment_ViewBinding;
.source "TipsGuidedExperienceFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f090078

    .line 26
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;Landroid/view/View;)V

    .line 28
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    .line 31
    const v0, 0x102000a

    const-string v1, "field \'list\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 32
    const-string v0, "field \'mBtnNext\' and method \'nextButton\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 33
    const-string v0, "field \'mBtnNext\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontButton;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mBtnNext:Lcom/jibo/ui/view/proxima/CustomFontButton;

    .line 34
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->c:Landroid/view/View;

    .line 35
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    const v0, 0x7f0900ed

    const-string v1, "field \'mContent2\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 42
    const v0, 0x7f0900ee

    const-string v1, "field \'mContent3\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 43
    const v0, 0x7f0900f0

    const-string v1, "field \'mContent5\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent5:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 44
    const v0, 0x7f0900f1

    const-string v1, "field \'mContent6\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent6:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 45
    const v0, 0x7f0900ef

    const-string v1, "method \'btnSetLocationClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 46
    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->d:Landroid/view/View;

    .line 47
    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 57
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    .line 58
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 59
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;

    .line 61
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 62
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mBtnNext:Lcom/jibo/ui/view/proxima/CustomFontButton;

    .line 63
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent2:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 64
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent3:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 65
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent5:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 66
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment;->mContent6:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 68
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->c:Landroid/view/View;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsGuidedExperienceFragment_ViewBinding;->d:Landroid/view/View;

    .line 73
    invoke-super {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment_ViewBinding;->unbind()V

    .line 74
    return-void
.end method
