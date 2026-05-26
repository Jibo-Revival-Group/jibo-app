.class public Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;
.source "AccountSettingsDetailsFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;

.field private k:Landroid/view/View;

.field private l:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f090288

    .line 43
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;Landroid/view/View;)V

    .line 45
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    .line 48
    const v0, 0x7f090282

    const-string v1, "field \'mName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mName:Landroid/widget/TextView;

    .line 49
    const v0, 0x7f09027e

    const-string v1, "field \'mGender\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mGender:Landroid/widget/TextView;

    .line 50
    const v0, 0x7f09027a

    const-string v1, "field \'mEmail\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mEmail:Landroid/widget/TextView;

    .line 51
    const v0, 0x7f090278

    const-string v1, "field \'mBirthday\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mBirthday:Landroid/widget/TextView;

    .line 52
    const v0, 0x7f090285

    const-string v1, "field \'mSettingPhoneNumberTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mSettingPhoneNumberTitle:Landroid/widget/TextView;

    .line 53
    const v0, 0x7f090284

    const-string v1, "field \'mPhoneNumber\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mPhoneNumber:Landroid/widget/TextView;

    .line 54
    const-string v0, "field \'receiveMessagesSwitch\' and method \'onReceiveMessagesClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 55
    const-string v0, "field \'receiveMessagesSwitch\'"

    const-class v2, Landroid/widget/Switch;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    .line 56
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->c:Landroid/view/View;

    .line 57
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    const v0, 0x7f09004b

    const-string v1, "field \'avatarEditButton\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->avatarEditButton:Landroid/widget/ImageView;

    .line 64
    const v0, 0x7f09027c

    const-string v1, "field \'mFacebook\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    .line 65
    const v0, 0x7f0901c9

    const-string v1, "field \'facebookLoginButton\'"

    const-class v2, Lcom/facebook/login/widget/LoginButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/login/widget/LoginButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    .line 66
    const v0, 0x7f09012e

    const-string v1, "field \'mFacebookLoggedInIcon\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    .line 67
    const v0, 0x7f090281

    const-string v1, "method \'nameClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 68
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->d:Landroid/view/View;

    .line 69
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    const v0, 0x7f09027d

    const-string v1, "method \'genderClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 76
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->e:Landroid/view/View;

    .line 77
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    const v0, 0x7f090277

    const-string v1, "method \'birthdayClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 84
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->f:Landroid/view/View;

    .line 85
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    const v0, 0x7f090283

    const-string v1, "method \'onPhoneNumberClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 92
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->g:Landroid/view/View;

    .line 93
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$5;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$5;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    const v0, 0x7f090287

    const-string v1, "method \'onReceiveMessagesClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 100
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->h:Landroid/view/View;

    .line 101
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$6;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$6;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    const v0, 0x7f09027b

    const-string v1, "method \'facebookClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 108
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->i:Landroid/view/View;

    .line 109
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$7;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$7;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    const v0, 0x7f0900c2

    const-string v1, "method \'changePasswordClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 116
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->j:Landroid/view/View;

    .line 117
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$8;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$8;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    const v0, 0x7f09028b

    const-string v1, "method \'changeEmailClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 124
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->k:Landroid/view/View;

    .line 125
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$9;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$9;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    const v0, 0x7f090060

    const-string v1, "method \'onDevSettings\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 132
    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->l:Landroid/view/View;

    .line 133
    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$10;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding$10;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 139
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    .line 144
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 145
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    .line 147
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mName:Landroid/widget/TextView;

    .line 148
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mGender:Landroid/widget/TextView;

    .line 149
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mEmail:Landroid/widget/TextView;

    .line 150
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mBirthday:Landroid/widget/TextView;

    .line 151
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mSettingPhoneNumberTitle:Landroid/widget/TextView;

    .line 152
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mPhoneNumber:Landroid/widget/TextView;

    .line 153
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->receiveMessagesSwitch:Landroid/widget/Switch;

    .line 154
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->avatarEditButton:Landroid/widget/ImageView;

    .line 155
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebook:Landroid/widget/TextView;

    .line 156
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->facebookLoginButton:Lcom/facebook/login/widget/LoginButton;

    .line 157
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;->mFacebookLoggedInIcon:Landroid/widget/ImageView;

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 160
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->c:Landroid/view/View;

    .line 161
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->d:Landroid/view/View;

    .line 163
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 164
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->e:Landroid/view/View;

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 166
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->f:Landroid/view/View;

    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 168
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->g:Landroid/view/View;

    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->h:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->h:Landroid/view/View;

    .line 171
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->i:Landroid/view/View;

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->j:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->j:Landroid/view/View;

    .line 175
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->k:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 176
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->k:Landroid/view/View;

    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->l:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 178
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment_ViewBinding;->l:Landroid/view/View;

    .line 180
    invoke-super {p0}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->unbind()V

    .line 181
    return-void
.end method
