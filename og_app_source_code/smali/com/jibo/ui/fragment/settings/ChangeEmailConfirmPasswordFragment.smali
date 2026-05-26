.class public Lcom/jibo/ui/fragment/settings/ChangeEmailConfirmPasswordFragment;
.super Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;
.source "ChangeEmailConfirmPasswordFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/jibo/ui/fragment/settings/ChangeEmailConfirmPasswordFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/ChangeEmailConfirmPasswordFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/ConfirmPasswordFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 15
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/settings/ChangeEmailFragment;

    .line 16
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 17
    const-string v1, "ARGS_PASSWORD"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/ChangeEmailConfirmPasswordFragment;->password:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 18
    const/16 v1, 0x3e7

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 19
    return-void
.end method

.method protected b()I
    .locals 1

    .prologue
    .line 23
    const v0, 0x7f0b0062

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    const v0, 0x7f1003fc

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/ChangeEmailConfirmPasswordFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
