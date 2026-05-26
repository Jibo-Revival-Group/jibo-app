.class public Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;
.super Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SkillFooterItem"
.end annotation


# instance fields
.field private mLinkColor:I


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;)V
    .locals 1

    .prologue
    .line 77
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_footer:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 74
    const/high16 v0, -0x1000000

    iput v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->mLinkColor:I

    .line 79
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;)V
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;)V

    .line 83
    return-void
.end method


# virtual methods
.method public getTitle()Ljava/lang/CharSequence;
    .locals 11

    .prologue
    const/16 v9, 0x21

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 91
    new-instance v5, Landroid/text/SpannableStringBuilder;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$DataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-direct {v5, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;->getLinks()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 96
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem;->getLinks()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;

    .line 97
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getPlaceholder()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    move v4, v2

    move v1, v3

    .line 100
    :goto_0
    if-eqz v4, :cond_0

    .line 102
    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getPlaceholder()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v4

    .line 104
    const/4 v7, -0x1

    if-eq v4, v7, :cond_2

    .line 106
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v1, v4

    .line 107
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getPlaceholder()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    add-int/2addr v7, v4

    invoke-virtual {v5, v4, v7}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    .line 108
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getText()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v4, v7}, Landroid/text/SpannableStringBuilder;->insert(ILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 109
    new-instance v7, Landroid/text/style/ForegroundColorSpan;

    iget v8, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->mLinkColor:I

    invoke-direct {v7, v8}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getText()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    add-int/2addr v8, v4

    invoke-virtual {v5, v7, v4, v8, v9}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 111
    new-instance v7, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;

    invoke-direct {v7, p0, v0}, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem$1;-><init>(Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;)V

    .line 135
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$FooterDataItem$Link;->getText()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    add-int/2addr v8, v4

    .line 111
    invoke-virtual {v5, v7, v4, v8, v9}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    move v4, v1

    move v1, v2

    :goto_1
    move v10, v1

    move v1, v4

    move v4, v10

    .line 137
    goto :goto_0

    .line 140
    :cond_1
    return-object v5

    :cond_2
    move v4, v1

    move v1, v3

    goto :goto_1
.end method

.method public setLinkColor(I)V
    .locals 0

    .prologue
    .line 86
    iput p1, p0, Lcom/jibo/ui/helpers/skills/Items$SkillFooterItem;->mLinkColor:I

    .line 87
    return-void
.end method
