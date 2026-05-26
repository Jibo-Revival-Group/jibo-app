.class public Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "RobotSettingsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    .line 39
    const v0, 0x7f090310

    const-string v1, "field \'txtJiboName\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboName:Landroid/widget/TextView;

    .line 40
    const v0, 0x7f090160

    const-string v1, "field \'imgJiboAvatar\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->imgJiboAvatar:Landroid/widget/ImageView;

    .line 41
    const v0, 0x7f090311

    const-string v1, "field \'txtJiboWifi\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboWifi:Landroid/widget/TextView;

    .line 42
    const v0, 0x7f09030f

    const-string v1, "field \'txtJiboLocation\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboLocation:Landroid/widget/TextView;

    .line 43
    const v0, 0x7f090059

    const-string v1, "field \'btnAbout\' and method \'showAbout\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 44
    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnAbout:Landroid/view/View;

    .line 45
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->c:Landroid/view/View;

    .line 46
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 52
    const v0, 0x7f09007d

    const-string v1, "field \'btnPassphrase\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    .line 53
    const v0, 0x7f090151

    const-string v1, "field \'iconPassphrase\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->iconPassphrase:Landroid/widget/ImageView;

    .line 54
    const v0, 0x7f090204

    const-string v1, "field \'passphraseText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    .line 55
    const v0, 0x7f0902ce

    const-string v1, "field \'mRemoteSwitch\'"

    const-class v2, Landroid/widget/Switch;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->mRemoteSwitch:Landroid/widget/Switch;

    .line 56
    const v0, 0x7f090070

    const-string v1, "method \'changeName\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 57
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->d:Landroid/view/View;

    .line 58
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    const v0, 0x7f09006f

    const-string v1, "method \'btnJiboAvatarClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 65
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->e:Landroid/view/View;

    .line 66
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 72
    const v0, 0x7f09009c

    const-string v1, "method \'btnWiFiSettingsClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 73
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->f:Landroid/view/View;

    .line 74
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    const v0, 0x7f090074

    const-string v1, "method \'btnLocationClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 81
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->g:Landroid/view/View;

    .line 82
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$5;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$5;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 88
    const v0, 0x7f090065

    const-string v1, "method \'btnEnableRemoteClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 89
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->h:Landroid/view/View;

    .line 90
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$6;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$6;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 96
    const v0, 0x7f09006b

    const-string v1, "method \'btnHolidaysClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 97
    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->i:Landroid/view/View;

    .line 98
    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$7;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding$7;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 104
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    .line 110
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 111
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    .line 113
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboName:Landroid/widget/TextView;

    .line 114
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->imgJiboAvatar:Landroid/widget/ImageView;

    .line 115
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboWifi:Landroid/widget/TextView;

    .line 116
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboLocation:Landroid/widget/TextView;

    .line 117
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnAbout:Landroid/view/View;

    .line 118
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    .line 119
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->iconPassphrase:Landroid/widget/ImageView;

    .line 120
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    .line 121
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->mRemoteSwitch:Landroid/widget/Switch;

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->c:Landroid/view/View;

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->d:Landroid/view/View;

    .line 127
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->e:Landroid/view/View;

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->f:Landroid/view/View;

    .line 131
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->g:Landroid/view/View;

    .line 133
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->h:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 134
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->h:Landroid/view/View;

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 136
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment_ViewBinding;->i:Landroid/view/View;

    .line 137
    return-void
.end method
