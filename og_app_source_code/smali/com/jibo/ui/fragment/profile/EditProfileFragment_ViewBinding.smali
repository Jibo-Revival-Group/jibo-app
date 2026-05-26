.class public Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;
.source "EditProfileFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;Landroid/view/View;)V

    .line 35
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    .line 38
    const v0, 0x7f090313

    const-string v1, "field \'memberName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->memberName:Landroid/widget/TextView;

    .line 39
    const v0, 0x7f090286

    const-string v1, "field \'settingPrefferedName\' and method \'nicknameClickEdit\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 40
    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingPrefferedName:Landroid/view/View;

    .line 41
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->c:Landroid/view/View;

    .line 42
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    const v0, 0x7f090282

    const-string v1, "field \'preferredName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->preferredName:Landroid/widget/TextView;

    .line 49
    const v0, 0x7f09027e

    const-string v1, "field \'gender\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->gender:Landroid/widget/TextView;

    .line 50
    const v0, 0x7f09027a

    const-string v1, "field \'email\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->email:Landroid/widget/TextView;

    .line 51
    const v0, 0x7f090278

    const-string v1, "field \'birthday\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->birthday:Landroid/widget/TextView;

    .line 52
    const v0, 0x7f09004b

    const-string v1, "field \'avatarEdit\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->avatarEdit:Landroid/view/View;

    .line 53
    const v0, 0x7f090277

    const-string v1, "field \'settingBirthday\' and method \'birthdayClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 54
    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingBirthday:Landroid/view/View;

    .line 55
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->d:Landroid/view/View;

    .line 56
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 62
    const v0, 0x7f09027d

    const-string v1, "field \'settingGender\' and method \'genderClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 63
    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingGender:Landroid/view/View;

    .line 64
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->e:Landroid/view/View;

    .line 65
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    const v0, 0x7f090279

    const-string v1, "field \'settingEmail\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingEmail:Landroid/view/View;

    .line 72
    const v0, 0x7f090085

    const-string v1, "field \'btnResendInvite\' and method \'resendInviteClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 73
    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->btnResendInvite:Landroid/view/View;

    .line 74
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->f:Landroid/view/View;

    .line 75
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    const v0, 0x7f090274

    const-string v1, "field \'setEmailInfo\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->setEmailInfo:Landroid/widget/TextView;

    .line 82
    const v0, 0x7f090276

    const-string v1, "field \'settingAddPrefName\' and method \'nicknameClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 83
    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingAddPrefName:Landroid/view/View;

    .line 84
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->g:Landroid/view/View;

    .line 85
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$5;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$5;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    const v0, 0x7f090289

    const-string v1, "field \'settingSetEmail\' and method \'setEmailClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 92
    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetEmail:Landroid/view/View;

    .line 93
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->h:Landroid/view/View;

    .line 94
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$6;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$6;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    const v0, 0x7f090280

    const-string v1, "field \'settingLegalGuardianName\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianName:Landroid/view/View;

    .line 101
    const v0, 0x7f0901b7

    const-string v1, "field \'legalGuardianName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->legalGuardianName:Landroid/widget/TextView;

    .line 102
    const v0, 0x7f09027f

    const-string v1, "field \'settingLegalGuardianEmail\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianEmail:Landroid/view/View;

    .line 103
    const v0, 0x7f0901b5

    const-string v1, "field \'legalGuardianEmail\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->legalGuardianEmail:Landroid/widget/TextView;

    .line 104
    const v0, 0x7f09028a

    const-string v1, "field \'settingSetPhone\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetPhone:Landroid/view/View;

    .line 105
    const v0, 0x7f090083

    const-string v1, "method \'removeFromLoopClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 106
    iput-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->i:Landroid/view/View;

    .line 107
    new-instance v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$7;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding$7;-><init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;Lcom/jibo/ui/fragment/profile/EditProfileFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    .line 118
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 119
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    .line 121
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->memberName:Landroid/widget/TextView;

    .line 122
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingPrefferedName:Landroid/view/View;

    .line 123
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->preferredName:Landroid/widget/TextView;

    .line 124
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->gender:Landroid/widget/TextView;

    .line 125
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->email:Landroid/widget/TextView;

    .line 126
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->birthday:Landroid/widget/TextView;

    .line 127
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->avatarEdit:Landroid/view/View;

    .line 128
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingBirthday:Landroid/view/View;

    .line 129
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingGender:Landroid/view/View;

    .line 130
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingEmail:Landroid/view/View;

    .line 131
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->btnResendInvite:Landroid/view/View;

    .line 132
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->setEmailInfo:Landroid/widget/TextView;

    .line 133
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingAddPrefName:Landroid/view/View;

    .line 134
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetEmail:Landroid/view/View;

    .line 135
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianName:Landroid/view/View;

    .line 136
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->legalGuardianName:Landroid/widget/TextView;

    .line 137
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingLegalGuardianEmail:Landroid/view/View;

    .line 138
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->legalGuardianEmail:Landroid/widget/TextView;

    .line 139
    iput-object v1, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->settingSetPhone:Landroid/view/View;

    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->c:Landroid/view/View;

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->d:Landroid/view/View;

    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->e:Landroid/view/View;

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 148
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->f:Landroid/view/View;

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->g:Landroid/view/View;

    .line 151
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->h:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->h:Landroid/view/View;

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 154
    iput-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment_ViewBinding;->i:Landroid/view/View;

    .line 156
    invoke-super {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->unbind()V

    .line 157
    return-void
.end method
