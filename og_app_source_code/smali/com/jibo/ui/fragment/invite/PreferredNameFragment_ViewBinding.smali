.class public Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;
.super Ljava/lang/Object;
.source "PreferredNameFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f0901f0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    .line 30
    const v0, 0x7f0901ef

    const-string v1, "field \'nickname\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    .line 31
    const-string v0, "field \'nicknameSkip\' and method \'nicknameSkip\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 32
    const-string v0, "field \'nicknameSkip\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nicknameSkip:Landroid/widget/TextView;

    .line 33
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->c:Landroid/view/View;

    .line 34
    new-instance v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    const v0, 0x7f090326

    const-string v1, "field \'mViewLoopMembers\' and method \'viewLoopMembers\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 41
    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mViewLoopMembers:Landroid/view/View;

    .line 42
    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->d:Landroid/view/View;

    .line 43
    new-instance v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    const v0, 0x7f0900c1

    const-string v1, "field \'mChangePronunciationName\' and method \'changePronunciationName\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 50
    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mChangePronunciationName:Landroid/view/View;

    .line 51
    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->e:Landroid/view/View;

    .line 52
    new-instance v1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/PreferredNameFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    const v0, 0x7f09021f

    const-string v1, "field \'mPreferredNameTip\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    .line 59
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    .line 65
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/PreferredNameFragment;

    .line 68
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nickname:Landroid/widget/EditText;

    .line 69
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->nicknameSkip:Landroid/widget/TextView;

    .line 70
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mViewLoopMembers:Landroid/view/View;

    .line 71
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mChangePronunciationName:Landroid/view/View;

    .line 72
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->mPreferredNameTip:Landroid/widget/TextView;

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->c:Landroid/view/View;

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->d:Landroid/view/View;

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 79
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/PreferredNameFragment_ViewBinding;->e:Landroid/view/View;

    .line 80
    return-void
.end method
