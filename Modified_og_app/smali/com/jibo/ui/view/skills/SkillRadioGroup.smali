.class public Lcom/jibo/ui/view/skills/SkillRadioGroup;
.super Landroid/widget/LinearLayout;
.source "SkillRadioGroup.java"


# instance fields
.field private a:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 35
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a()V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 40
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a()V

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 45
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a()V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 51
    invoke-direct {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a()V

    .line 52
    return-void
.end method

.method private a()V
    .locals 1

    .prologue
    .line 55
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->setOrientation(I)V

    .line 56
    return-void
.end method


# virtual methods
.method public a(Ljava/util/List;I)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;",
            ">;I)V"
        }
    .end annotation

    .prologue
    const v8, 0x7f0900e6

    const v7, 0x1020014

    const v6, 0x1020006

    const/4 v2, 0x0

    .line 64
    if-nez p1, :cond_1

    .line 109
    :cond_0
    return-void

    .line 66
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;

    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v4, 0x7f0b00c8

    const/4 v5, 0x0

    invoke-virtual {v1, v4, v5, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 68
    invoke-virtual {v4, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 70
    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 72
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getIcon()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 73
    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 90
    :cond_2
    :goto_1
    invoke-virtual {v4, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 91
    invoke-virtual {v4, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 92
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    :cond_3
    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 95
    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/CompoundButton;

    .line 96
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getId()I

    move-result v0

    if-ne v0, p2, :cond_7

    const/4 v0, 0x1

    :goto_2
    invoke-virtual {v1, v0}, Landroid/widget/CompoundButton;->setChecked(Z)V

    .line 97
    invoke-virtual {v1, v2}, Landroid/widget/CompoundButton;->setClickable(Z)V

    .line 99
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a:Landroid/view/View$OnClickListener;

    invoke-virtual {v4, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    invoke-virtual {p0, v4}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 75
    :cond_5
    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 78
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getIcon()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->isExternal(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 79
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getIcon()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v1

    sget-object v5, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 80
    invoke-virtual {v1, v5}, Lcom/bumptech/glide/DrawableTypeRequest;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v5

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    invoke-virtual {v5, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    goto :goto_1

    .line 83
    :cond_6
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getIcon()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->getImageForUrl(Ljava/lang/String;)I

    move-result v1

    const/4 v5, -0x1

    if-eq v1, v5, :cond_2

    .line 84
    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 85
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$ChoiceDataItem$ChoiceValueDataItem;->getIcon()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->getImageForUrl(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v1, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    :cond_7
    move v0, v2

    .line 96
    goto :goto_2

    :cond_8
    move v1, v2

    .line 103
    :goto_3
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->getChildCount()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 104
    invoke-virtual {p0, v1}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 105
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;

    .line 106
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/SkillRadioGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0700b6

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v4

    invoke-virtual {v0, v2, v2, v2, v4}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 107
    invoke-virtual {v3, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 103
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3
.end method

.method public setOnClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/jibo/ui/view/skills/SkillRadioGroup;->a:Landroid/view/View$OnClickListener;

    .line 61
    return-void
.end method
