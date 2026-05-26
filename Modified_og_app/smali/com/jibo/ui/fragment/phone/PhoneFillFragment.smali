.class public Lcom/jibo/ui/fragment/phone/PhoneFillFragment;
.super Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;
.source "PhoneFillFragment.java"


# static fields
.field public static final l:Ljava/lang/String;


# instance fields
.field btnNext:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field phone:Landroid/widget/EditText;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 41
    const-class v0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->l:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 140
    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->btnNext:Landroid/view/View;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v2, 0xa

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setEnabled(Z)V

    .line 141
    return-void

    .line 140
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(IILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 127
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 128
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->d:Z

    if-nez v0, :cond_0

    .line 129
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/OnBoardingActivity;->s()V

    .line 132
    :cond_0
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 113
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->l()V

    .line 117
    return-void

    .line 114
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->phone:Landroid/widget/EditText;

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
    .line 121
    const v0, 0x7f10041e

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .prologue
    .line 71
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->d:Z

    if-nez v0, :cond_0

    .line 72
    const v0, 0x7f0c000a

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 73
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 75
    const v0, 0x7f090019

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->b:Landroid/view/MenuItem;

    .line 77
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 52
    const v0, 0x7f0b0080

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onNext(Landroid/view/View;)V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 136
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->e:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->b(Ljava/lang/Runnable;)V

    .line 137
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 6

    .prologue
    const v5, 0x7f070053

    const v4, 0x7f070051

    .line 81
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V

    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->b:Landroid/view/MenuItem;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->b:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->b(Landroid/view/View;)V

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060018

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    .line 87
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x7f10002d

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/4 v1, 0x2

    const/high16 v2, 0x41700000    # 15.0f

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextSize(IF)V

    .line 89
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 90
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 91
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 92
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 89
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setPadding(IIII)V

    .line 93
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const v1, 0x3df5c28f    # 0.12f

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setLetterSpacing(F)V

    .line 96
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;-><init>(Lcom/jibo/ui/fragment/phone/PhoneFillFragment;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    :cond_1
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 57
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/phone/PhoneBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 59
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->phone:Landroid/widget/EditText;

    new-instance v1, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$1;-><init>(Lcom/jibo/ui/fragment/phone/PhoneFillFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 67
    return-void
.end method
