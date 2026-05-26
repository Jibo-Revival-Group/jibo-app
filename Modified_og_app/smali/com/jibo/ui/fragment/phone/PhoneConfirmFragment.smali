.class public Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;
.super Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;
.source "PhoneConfirmFragment.java"


# static fields
.field public static final l:Ljava/lang/String;


# instance fields
.field code:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer1:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field footer_error:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-class v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->l:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->q()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 46
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private q()V
    .locals 3

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->f()V

    .line 136
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->e()V

    .line 138
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->a()Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->verifyPhoneByCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 195
    return-void
.end method


# virtual methods
.method protected a()V
    .locals 7

    .prologue
    const v6, 0x7f06007c

    const/4 v5, 0x6

    const/4 v1, 0x0

    const/4 v2, -0x1

    const/4 v0, 0x1

    .line 258
    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    if-nez v3, :cond_0

    .line 277
    :goto_0
    return-void

    .line 260
    :cond_0
    iget-boolean v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->d:Z

    if-eqz v3, :cond_3

    .line 261
    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v4, 0x7f10002b

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v4, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->length()I

    move-result v4

    if-ne v4, v5, :cond_1

    :goto_1
    invoke-virtual {v3, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setEnabled(Z)V

    .line 263
    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v2

    :goto_2
    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    goto :goto_0

    :cond_1
    move v0, v1

    .line 262
    goto :goto_1

    .line 264
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v6}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v0

    goto :goto_2

    .line 266
    :cond_3
    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->length()I

    move-result v3

    if-lez v3, :cond_6

    .line 267
    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v4, 0x7f10002a

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 268
    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v4, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->length()I

    move-result v4

    if-ne v4, v5, :cond_4

    :goto_3
    invoke-virtual {v3, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setEnabled(Z)V

    .line 269
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_5

    :goto_4
    invoke-virtual {v0, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    goto :goto_0

    :cond_4
    move v0, v1

    .line 268
    goto :goto_3

    .line 270
    :cond_5
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v6}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    goto :goto_4

    .line 272
    :cond_6
    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v2, 0x7f10002d

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 273
    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f060018

    invoke-static {v2, v3}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    .line 274
    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setEnabled(Z)V

    goto/16 :goto_0
.end method

.method public a(IILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 238
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 239
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->d:Z

    if-eqz v0, :cond_1

    .line 240
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->d()Z

    .line 245
    :cond_0
    :goto_0
    return-void

    .line 242
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->s()V

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 226
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 227
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 228
    return-void
.end method

.method protected b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->m:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 205
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->b(Landroid/os/Bundle;)V

    .line 206
    const-string v0, "PARAM_PHONENUMBER"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->m:Ljava/lang/String;

    .line 207
    return-void
.end method

.method public h()Z
    .locals 7

    .prologue
    .line 211
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->d:Z

    if-eqz v0, :cond_0

    .line 212
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x68

    const v0, 0x7f10010a

    .line 214
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v0, 0x7f100101

    .line 215
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    const v0, 0x7f10002d

    .line 216
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    const v0, 0x7f10004b

    .line 217
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    .line 212
    invoke-static/range {v0 .. v6}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    const/4 v0, 0x1

    .line 220
    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->h()Z

    move-result v0

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    const v0, 0x7f10041c

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 91
    const v0, 0x7f0c000a

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 92
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 94
    const v0, 0x7f090019

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->b:Landroid/view/MenuItem;

    .line 95
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 63
    const v0, 0x7f0b007e

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 6

    .prologue
    const v5, 0x7f070053

    const v4, 0x7f070051

    .line 99
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->b:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 102
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->b(Landroid/view/View;)V

    .line 104
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a()V

    .line 105
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/4 v1, 0x2

    const/high16 v2, 0x41700000    # 15.0f

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextSize(IF)V

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 107
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 108
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 109
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 106
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setPadding(IIII)V

    .line 110
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x3df5c28f    # 0.12f

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setLetterSpacing(F)V

    .line 113
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    :cond_1
    return-void
.end method

.method public onResendCode(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 249
    new-instance v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$4;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$4;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->b(Ljava/lang/Runnable;)V

    .line 255
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 199
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 200
    const-string v0, "PARAM_PHONENUMBER"

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->m:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 68
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 70
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->code:Landroid/widget/EditText;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$1;-><init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 86
    return-void
.end method
