.class public Lcom/jibo/ui/fragment/phone/PhoneEditFragment;
.super Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;
.source "PhoneEditFragment.java"


# static fields
.field public static final l:Ljava/lang/String;


# instance fields
.field phone:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->l:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 115
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    if-eqz v0, :cond_0

    .line 116
    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v2, 0xa

    if-ne v0, v2, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setEnabled(Z)V

    .line 118
    :cond_0
    return-void

    .line 116
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 105
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 106
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 107
    return-void
.end method

.method protected b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->phone:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    const v0, 0x7f10041d

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 70
    const v0, 0x7f0c000a

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 71
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 73
    const v0, 0x7f090019

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b:Landroid/view/MenuItem;

    .line 74
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 47
    const v0, 0x7f0b007f

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

    .line 78
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 82
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->b(Landroid/view/View;)V

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x7f10002a

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/4 v1, 0x2

    const/high16 v2, 0x41700000    # 15.0f

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextSize(IF)V

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 87
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 88
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 89
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 86
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setPadding(IIII)V

    .line 90
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x3df5c28f    # 0.12f

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setLetterSpacing(F)V

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$2;-><init>(Lcom/jibo/ui/fragment/phone/PhoneEditFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    :cond_1
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 52
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->phone:Landroid/widget/EditText;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment$1;-><init>(Lcom/jibo/ui/fragment/phone/PhoneEditFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 63
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    if-nez p2, :cond_0

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->phone:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneEditFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "PARAM_PHONENUMBER"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "+1"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 66
    :cond_0
    return-void
.end method
