.class public Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;
.source "AboutYouFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;Landroid/view/View;)V
    .locals 6

    .prologue
    const v5, 0x7f09027d

    const v4, 0x7f090277

    const v3, 0x7f09004b

    .line 28
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;Landroid/view/View;)V

    .line 30
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    .line 33
    const v0, 0x7f090137

    const-string v1, "field \'first_name\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    .line 34
    const v0, 0x7f0901ae

    const-string v1, "field \'last_name\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    .line 35
    const-string v0, "field \'mGender\' and method \'genderClick\'"

    invoke-static {p2, v5, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 36
    const-string v0, "field \'mGender\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v5, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mGender:Landroid/widget/TextView;

    .line 37
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->c:Landroid/view/View;

    .line 38
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    const-string v0, "field \'mBirthday\' and method \'birthdayClick\'"

    invoke-static {p2, v4, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 45
    const-string v0, "field \'mBirthday\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v4, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mBirthday:Landroid/widget/TextView;

    .line 46
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->d:Landroid/view/View;

    .line 47
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$2;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    const-string v0, "field \'avatarEditButton\' and method \'changePicture\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 54
    const-string v0, "field \'avatarEditButton\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->avatarEditButton:Landroid/widget/ImageView;

    .line 55
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->e:Landroid/view/View;

    .line 56
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$3;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 62
    const v0, 0x7f09004a

    const-string v1, "method \'onAvatarClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 63
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->f:Landroid/view/View;

    .line 64
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    .line 75
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;

    .line 78
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->first_name:Landroid/widget/TextView;

    .line 79
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->last_name:Landroid/widget/TextView;

    .line 80
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mGender:Landroid/widget/TextView;

    .line 81
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->mBirthday:Landroid/widget/TextView;

    .line 82
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment;->avatarEditButton:Landroid/widget/ImageView;

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->c:Landroid/view/View;

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 87
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->d:Landroid/view/View;

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->e:Landroid/view/View;

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/AboutYouFragment_ViewBinding;->f:Landroid/view/View;

    .line 93
    invoke-super {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->unbind()V

    .line 94
    return-void
.end method
