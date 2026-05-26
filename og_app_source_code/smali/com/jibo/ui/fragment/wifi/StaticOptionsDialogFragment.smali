.class public Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "StaticOptionsDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment$OnStaticOptionsChangeListener;
    }
.end annotation


# instance fields
.field a:Lbutterknife/Unbinder;

.field editDns1:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field editDns2:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field editIpAddress:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field editRouter:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field editSubnetMask:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method

.method private a()Ljava/lang/String;
    .locals 2

    .prologue
    .line 105
    const-string v0, ""

    .line 107
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editIpAddress:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 109
    :goto_0
    return-object v0

    .line 108
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private a(Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/EditText;)Z
    .locals 8

    .prologue
    const v6, 0x7f10043f

    const/4 v1, 0x0

    .line 178
    const/4 v2, 0x1

    .line 179
    const-string v3, ""

    const-string v4, ""

    const-string v0, ""

    .line 181
    :try_start_0
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 182
    invoke-virtual {p2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 183
    invoke-virtual {p3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    move-object v7, v4

    move-object v4, v3

    move-object v3, v7

    .line 186
    :goto_0
    :try_start_1
    new-instance v5, Lcom/jibo/utils/SubnetUtils;

    invoke-direct {v5, v4, v3}, Lcom/jibo/utils/SubnetUtils;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    new-instance v4, Lcom/jibo/utils/SubnetUtils;

    invoke-direct {v4, v0, v3}, Lcom/jibo/utils/SubnetUtils;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    invoke-virtual {v5}, Lcom/jibo/utils/SubnetUtils;->a()Lcom/jibo/utils/SubnetUtils$SubnetInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4}, Lcom/jibo/utils/SubnetUtils;->a()Lcom/jibo/utils/SubnetUtils$SubnetInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 189
    invoke-virtual {p3}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    const v2, 0x7f10043f

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    .line 190
    invoke-virtual {p3}, Landroid/widget/EditText;->requestFocus()Z

    move v0, v1

    .line 201
    :goto_1
    return v0

    .line 184
    :catch_0
    move-exception v5

    move-object v7, v4

    move-object v4, v3

    move-object v3, v7

    goto :goto_0

    .line 193
    :cond_0
    invoke-virtual {p3}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    .line 194
    invoke-virtual {p3}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/support/design/widget/TextInputLayout;->setErrorEnabled(Z)V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    move v0, v2

    goto :goto_1

    .line 196
    :catch_1
    move-exception v0

    .line 198
    invoke-virtual {p3}, Landroid/widget/EditText;->requestFocus()Z

    .line 199
    invoke-virtual {p3}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    invoke-virtual {p0, v6}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    move v0, v1

    goto :goto_1
.end method

.method private a(Landroid/widget/EditText;Ljava/util/regex/Pattern;)Z
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 152
    const/4 v2, 0x1

    .line 153
    const-string v0, ""

    .line 155
    :try_start_0
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 158
    :goto_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {p2, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-nez v0, :cond_0

    .line 159
    invoke-virtual {p1}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    const v2, 0x7f10043e

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    .line 160
    invoke-virtual {p1}, Landroid/widget/EditText;->requestFocus()Z

    move v0, v1

    .line 166
    :goto_1
    return v0

    .line 163
    :cond_0
    invoke-virtual {p1}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/support/design/widget/TextInputLayout;->setError(Ljava/lang/CharSequence;)V

    .line 164
    invoke-virtual {p1}, Landroid/widget/EditText;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/TextInputLayout;

    invoke-virtual {v0, v1}, Landroid/support/design/widget/TextInputLayout;->setErrorEnabled(Z)V

    move v0, v2

    goto :goto_1

    .line 156
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method private b()Ljava/lang/String;
    .locals 2

    .prologue
    .line 113
    const-string v0, ""

    .line 115
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editSubnetMask:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 117
    :goto_0
    return-object v0

    .line 116
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private c()Ljava/lang/String;
    .locals 2

    .prologue
    .line 121
    const-string v0, ""

    .line 123
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editRouter:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 125
    :goto_0
    return-object v0

    .line 124
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private d()Ljava/lang/String;
    .locals 2

    .prologue
    .line 129
    const-string v0, ""

    .line 131
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns1:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 133
    :goto_0
    return-object v0

    .line 132
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private e()Ljava/lang/String;
    .locals 2

    .prologue
    .line 137
    const-string v0, ""

    .line 139
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns2:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 141
    :goto_0
    return-object v0

    .line 140
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private f()Z
    .locals 4

    .prologue
    .line 210
    const/4 v0, 0x1

    .line 212
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editIpAddress:Landroid/widget/EditText;

    sget-object v2, Landroid/util/Patterns;->IP_ADDRESS:Ljava/util/regex/Pattern;

    invoke-direct {p0, v1, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a(Landroid/widget/EditText;Ljava/util/regex/Pattern;)Z

    move-result v0

    .line 213
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editSubnetMask:Landroid/widget/EditText;

    sget-object v2, Landroid/util/Patterns;->IP_ADDRESS:Ljava/util/regex/Pattern;

    invoke-direct {p0, v1, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a(Landroid/widget/EditText;Ljava/util/regex/Pattern;)Z

    move-result v1

    and-int/2addr v0, v1

    .line 214
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editRouter:Landroid/widget/EditText;

    sget-object v2, Landroid/util/Patterns;->IP_ADDRESS:Ljava/util/regex/Pattern;

    invoke-direct {p0, v1, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a(Landroid/widget/EditText;Ljava/util/regex/Pattern;)Z

    move-result v1

    and-int/2addr v0, v1

    .line 215
    if-eqz v0, :cond_0

    .line 216
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editIpAddress:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editRouter:Landroid/widget/EditText;

    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editSubnetMask:Landroid/widget/EditText;

    invoke-direct {p0, v1, v2, v3}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a(Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/EditText;)Z

    move-result v1

    and-int/2addr v0, v1

    .line 218
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns1:Landroid/widget/EditText;

    sget-object v2, Lcom/jibo/utils/Commons;->f:Ljava/util/regex/Pattern;

    invoke-direct {p0, v1, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a(Landroid/widget/EditText;Ljava/util/regex/Pattern;)Z

    move-result v1

    and-int/2addr v0, v1

    .line 219
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns2:Landroid/widget/EditText;

    sget-object v2, Lcom/jibo/utils/Commons;->f:Ljava/util/regex/Pattern;

    invoke-direct {p0, v1, v2}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a(Landroid/widget/EditText;Ljava/util/regex/Pattern;)Z
    :try_end_0
    .catch Ljava/security/InvalidParameterException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v1

    and-int/2addr v0, v1

    .line 224
    :goto_0
    return v0

    .line 220
    :catch_0
    move-exception v0

    .line 221
    const/4 v0, 0x0

    goto :goto_0

    .line 222
    :catch_1
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method public onCancelClicked(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 84
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->dismiss()V

    .line 85
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 6

    .prologue
    const/4 v3, 0x0

    const v5, 0x7f100306

    .line 48
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0059

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 49
    const v1, 0x7f10010b

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 50
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b0058

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 51
    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 52
    invoke-virtual {v2, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 53
    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    const/4 v2, 0x1

    .line 54
    invoke-virtual {v0, v2}, Landroid/support/v7/app/AlertDialog$Builder;->a(Z)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v0

    .line 56
    invoke-static {p0, v1}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a:Lbutterknife/Unbinder;

    .line 59
    if-nez p1, :cond_0

    .line 60
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editIpAddress:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ARG_IPADDRESS"

    .line 61
    invoke-virtual {p0, v5}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 60
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 62
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editSubnetMask:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ARG_SUBNETMASK"

    .line 63
    invoke-virtual {p0, v5}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 62
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 64
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editRouter:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ARG_ROUTER"

    .line 65
    invoke-virtual {p0, v5}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 64
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns1:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ARG_DNS1"

    const v4, 0x7f100304

    .line 67
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 66
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->editDns2:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ARG_DNS2"

    const v4, 0x7f100305

    .line 69
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 68
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 72
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 77
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 80
    return-void
.end method

.method public onSetClicked(Landroid/view/View;)V
    .locals 6
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 90
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->f()Z

    move-result v0

    if-nez v0, :cond_0

    .line 100
    :goto_0
    return-void

    .line 94
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment$OnStaticOptionsChangeListener;

    if-eqz v0, :cond_1

    .line 95
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment$OnStaticOptionsChangeListener;

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->a()Ljava/lang/String;

    move-result-object v1

    .line 96
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->b()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->c()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->d()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->e()Ljava/lang/String;

    move-result-object v5

    .line 95
    invoke-interface/range {v0 .. v5}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment$OnStaticOptionsChangeListener;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/StaticOptionsDialogFragment;->dismiss()V

    goto :goto_0
.end method
