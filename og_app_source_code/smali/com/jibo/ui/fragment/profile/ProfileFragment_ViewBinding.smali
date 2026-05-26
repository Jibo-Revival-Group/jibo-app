.class public Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;
.source "ProfileFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f090209

    .line 22
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;Landroid/view/View;)V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    .line 27
    const v0, 0x7f0900e8

    const-string v1, "field \'contactAdult\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->contactAdult:Landroid/view/View;

    .line 28
    const v0, 0x7f0900e9

    const-string v1, "field \'contactChild\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->contactChild:Landroid/view/View;

    .line 29
    const v0, 0x7f090222

    const-string v1, "field \'mName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mName:Landroid/widget/TextView;

    .line 30
    const v0, 0x7f090223

    const-string v1, "field \'mNickName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mNickName:Landroid/widget/TextView;

    .line 31
    const v0, 0x7f0901b7

    const-string v1, "field \'mLegalGuardianName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mLegalGuardianName:Landroid/widget/TextView;

    .line 32
    const v0, 0x7f090220

    const-string v1, "field \'mBirthday\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mBirthday:Landroid/widget/TextView;

    .line 33
    const v0, 0x7f090224

    const-string v1, "field \'mTrained\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mTrained:Landroid/widget/TextView;

    .line 34
    const v0, 0x7f090208

    const-string v1, "field \'mPersonalSettings\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettings:Landroid/widget/TextView;

    .line 35
    const-string v0, "field \'mPersonalSettingsRow\' and method \'personalSettingsClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 36
    const-string v0, "field \'mPersonalSettingsRow\'"

    const-class v2, Landroid/widget/LinearLayout;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettingsRow:Landroid/widget/LinearLayout;

    .line 37
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;->c:Landroid/view/View;

    .line 38
    new-instance v0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/ProfileFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    const v0, 0x7f090207

    const-string v1, "field \'personalSettingDivider\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->personalSettingDivider:Landroid/view/View;

    .line 45
    const v0, 0x7f090221

    const-string v1, "field \'mEmail\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mEmail:Landroid/widget/TextView;

    .line 46
    const v0, 0x7f090105

    const-string v1, "field \'daysLeftInfo\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->daysLeftInfo:Landroid/widget/TextView;

    .line 47
    const v0, 0x7f090053

    const-string v1, "field \'bottomPanel\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/ProfileFragment;->bottomPanel:Landroid/view/View;

    .line 48
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 52
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    .line 53
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->contactAdult:Landroid/view/View;

    .line 57
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->contactChild:Landroid/view/View;

    .line 58
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mName:Landroid/widget/TextView;

    .line 59
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mNickName:Landroid/widget/TextView;

    .line 60
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mLegalGuardianName:Landroid/widget/TextView;

    .line 61
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mBirthday:Landroid/widget/TextView;

    .line 62
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mTrained:Landroid/widget/TextView;

    .line 63
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettings:Landroid/widget/TextView;

    .line 64
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mPersonalSettingsRow:Landroid/widget/LinearLayout;

    .line 65
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->personalSettingDivider:Landroid/view/View;

    .line 66
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->mEmail:Landroid/widget/TextView;

    .line 67
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->daysLeftInfo:Landroid/widget/TextView;

    .line 68
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment;->bottomPanel:Landroid/view/View;

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment_ViewBinding;->c:Landroid/view/View;

    .line 73
    invoke-super {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->unbind()V

    .line 74
    return-void
.end method
