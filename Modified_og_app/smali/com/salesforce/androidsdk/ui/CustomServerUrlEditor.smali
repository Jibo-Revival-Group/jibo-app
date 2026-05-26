.class public Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;
.super Landroid/app/DialogFragment;
.source "CustomServerUrlEditor.java"


# instance fields
.field a:Z

.field private b:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private c:Lcom/salesforce/androidsdk/config/LoginServerManager;

.field private d:Landroid/content/Context;

.field private e:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 61
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 62
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->d:Landroid/content/Context;

    .line 65
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 68
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l()Lcom/salesforce/androidsdk/config/LoginServerManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    .line 69
    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/ui/SalesforceR;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    return-object v0
.end method

.method private a(I)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 168
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->e:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 169
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    .line 170
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 171
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v5, ""

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_0
    move v1, v3

    .line 176
    :goto_0
    iget-object v5, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v5}, Lcom/salesforce/androidsdk/ui/SalesforceR;->N()I

    move-result v5

    if-ne p1, v5, :cond_1

    .line 177
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/webkit/URLUtil;->isHttpsUrl(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    move v1, v3

    .line 178
    :goto_1
    if-eqz v1, :cond_1

    .line 179
    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->d:Landroid/content/Context;

    iget-object v5, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v5}, Lcom/salesforce/androidsdk/ui/SalesforceR;->V()I

    move-result v5

    invoke-virtual {p0, v5}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 180
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 183
    :cond_1
    if-eqz v1, :cond_4

    .line 184
    invoke-virtual {v0}, Landroid/widget/EditText;->selectAll()V

    .line 185
    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 186
    const/4 v0, 0x0

    .line 188
    :goto_2
    return-object v0

    :cond_2
    move v1, v2

    .line 171
    goto :goto_0

    :cond_3
    move v1, v2

    .line 177
    goto :goto_1

    .line 188
    :cond_4
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(ILjava/lang/String;)V
    .locals 2

    .prologue
    .line 137
    if-nez p2, :cond_0

    .line 138
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Value cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 140
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->e:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 141
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 142
    if-eqz v0, :cond_1

    .line 143
    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 144
    invoke-virtual {v0}, Landroid/widget/EditText;->getOnFocusChangeListener()Landroid/view/View$OnFocusChangeListener;

    move-result-object v1

    if-nez v1, :cond_1

    .line 145
    new-instance v1, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;

    invoke-direct {v1, p0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$3;-><init>(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 165
    :cond_1
    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic b(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)Lcom/salesforce/androidsdk/config/LoginServerManager;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->c:Lcom/salesforce/androidsdk/config/LoginServerManager;

    return-object v0
.end method

.method private b(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->M()I

    move-result v0

    if-ne p1, v0, :cond_0

    .line 193
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->O()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 195
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->P()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method static synthetic b(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->S()I

    move-result v0

    invoke-virtual {p1, v0, p2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->e:Landroid/view/View;

    .line 75
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->M()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(I)Ljava/lang/String;

    move-result-object v0

    .line 76
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->N()I

    move-result v1

    invoke-direct {p0, v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b(I)Ljava/lang/String;

    move-result-object v1

    .line 77
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->P()I

    move-result v2

    invoke-virtual {p0, v2}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a:Z

    .line 78
    iget-boolean v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a:Z

    if-eqz v2, :cond_0

    .line 79
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getDialog()Landroid/app/Dialog;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/SalesforceR;->Q()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setTitle(I)V

    .line 83
    :goto_0
    iget-object v2, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v2}, Lcom/salesforce/androidsdk/ui/SalesforceR;->M()I

    move-result v2

    invoke-direct {p0, v2, v0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(ILjava/lang/String;)V

    .line 84
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;->N()I

    move-result v0

    invoke-direct {p0, v0, v1}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->a(ILjava/lang/String;)V

    .line 89
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->e:Landroid/view/View;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->T()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 90
    new-instance v1, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;

    invoke-direct {v1, p0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$1;-><init>(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 108
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->e:Landroid/view/View;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->U()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 109
    new-instance v1, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$2;

    invoke-direct {v1, p0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor$2;-><init>(Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 116
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->e:Landroid/view/View;

    return-object v0

    .line 81
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getDialog()Landroid/app/Dialog;

    move-result-object v2

    iget-object v3, p0, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->b:Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-virtual {v3}, Lcom/salesforce/androidsdk/ui/SalesforceR;->R()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setTitle(I)V

    goto :goto_0
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 121
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/ui/CustomServerUrlEditor;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;

    .line 122
    if-eqz v0, :cond_0

    .line 123
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/ServerPickerActivity;->c()V

    .line 125
    :cond_0
    return-void
.end method
