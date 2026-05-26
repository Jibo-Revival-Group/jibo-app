.class public Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "DevSettingsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;

.field private j:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f09008e

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    .line 43
    const v0, 0x7f0900fc

    const-string v1, "field \'current_endpoint\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->current_endpoint:Landroid/widget/TextView;

    .line 44
    const v0, 0x7f090126

    const-string v1, "field \'endpointSpinner\'"

    const-class v2, Landroid/widget/Spinner;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointSpinner:Landroid/widget/Spinner;

    .line 45
    const v0, 0x7f0902df

    const-string v1, "field \'textVersion\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->textVersion:Landroid/widget/TextView;

    .line 46
    const v0, 0x7f0902cd

    const-string v1, "field \'switchEncryption\'"

    const-class v2, Landroid/widget/Switch;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->switchEncryption:Landroid/widget/Switch;

    .line 47
    const v0, 0x7f0901cd

    const-string v1, "field \'loopsSpinner\'"

    const-class v2, Landroid/widget/Spinner;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loopsSpinner:Landroid/widget/Spinner;

    .line 48
    const v0, 0x7f0901ce

    const-string v1, "field \'loops1Spinner\'"

    const-class v2, Landroid/widget/Spinner;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loops1Spinner:Landroid/widget/Spinner;

    .line 49
    const v0, 0x7f0901cf

    const-string v1, "field \'gqaLoopsSpinner\'"

    const-class v2, Landroid/widget/Spinner;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->gqaLoopsSpinner:Landroid/widget/Spinner;

    .line 50
    const v0, 0x7f0901d0

    const-string v1, "field \'ugcLoopSpinner\'"

    const-class v2, Landroid/widget/Spinner;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    .line 51
    const v0, 0x7f0901d1

    const-string v1, "field \'suspensionLoopSpinner\'"

    const-class v2, Landroid/widget/Spinner;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->suspensionLoopSpinner:Landroid/widget/Spinner;

    .line 52
    const v0, 0x7f09031a

    const-string v1, "field \'ugcKeyText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcKeyText:Landroid/widget/TextView;

    .line 53
    const v0, 0x7f090231

    const-string v1, "field \'questionEdit\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->questionEdit:Landroid/widget/EditText;

    .line 54
    const v0, 0x7f09023d

    const-string v1, "field \'responseText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->responseText:Landroid/widget/TextView;

    .line 55
    const v0, 0x7f090127

    const-string v1, "field \'endpointEdit\'"

    const-class v2, Landroid/widget/EditText;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointEdit:Landroid/widget/EditText;

    .line 56
    const-string v0, "field \'buttonSetEndpoint\' and method \'setEndpoint\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 57
    const-string v0, "field \'buttonSetEndpoint\'"

    const-class v2, Landroid/widget/Button;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->buttonSetEndpoint:Landroid/widget/Button;

    .line 58
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->c:Landroid/view/View;

    .line 59
    new-instance v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    const v0, 0x7f090076

    const-string v1, "method \'logout\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 66
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->d:Landroid/view/View;

    .line 67
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    const v0, 0x7f090084

    const-string v1, "method \'onBtnRequestKeyClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 74
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->e:Landroid/view/View;

    .line 75
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    const v0, 0x7f090073

    const-string v1, "method \'onBtnListAttributions\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 82
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->f:Landroid/view/View;

    .line 83
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    const v0, 0x7f09008c

    const-string v1, "method \'onBtnSendQuestion\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 90
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->g:Landroid/view/View;

    .line 91
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$5;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$5;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    const v0, 0x7f090068

    const-string v1, "method \'onBtnGenerateKeyClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 98
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->h:Landroid/view/View;

    .line 99
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$6;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$6;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    const v0, 0x7f090095

    const-string v1, "method \'onBtnSuspendLoopClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 106
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->i:Landroid/view/View;

    .line 107
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$7;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$7;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    const v0, 0x7f090111

    const-string v1, "method \'showDevSettings\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 114
    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->j:Landroid/view/View;

    .line 115
    new-instance v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$8;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding$8;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 121
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 126
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    .line 127
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 128
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    .line 130
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->current_endpoint:Landroid/widget/TextView;

    .line 131
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointSpinner:Landroid/widget/Spinner;

    .line 132
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->textVersion:Landroid/widget/TextView;

    .line 133
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->switchEncryption:Landroid/widget/Switch;

    .line 134
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loopsSpinner:Landroid/widget/Spinner;

    .line 135
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->loops1Spinner:Landroid/widget/Spinner;

    .line 136
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->gqaLoopsSpinner:Landroid/widget/Spinner;

    .line 137
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcLoopSpinner:Landroid/widget/Spinner;

    .line 138
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->suspensionLoopSpinner:Landroid/widget/Spinner;

    .line 139
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->ugcKeyText:Landroid/widget/TextView;

    .line 140
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->questionEdit:Landroid/widget/EditText;

    .line 141
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->responseText:Landroid/widget/TextView;

    .line 142
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->endpointEdit:Landroid/widget/EditText;

    .line 143
    iput-object v1, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->buttonSetEndpoint:Landroid/widget/Button;

    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->c:Landroid/view/View;

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 148
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->d:Landroid/view/View;

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->e:Landroid/view/View;

    .line 151
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->f:Landroid/view/View;

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 154
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->g:Landroid/view/View;

    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->h:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->h:Landroid/view/View;

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->i:Landroid/view/View;

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->j:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 160
    iput-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment_ViewBinding;->j:Landroid/view/View;

    .line 161
    return-void
.end method
