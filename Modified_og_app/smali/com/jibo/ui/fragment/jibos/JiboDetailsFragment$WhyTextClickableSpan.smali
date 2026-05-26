.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;
.super Landroid/text/style/ClickableSpan;
.source "JiboDetailsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "WhyTextClickableSpan"
.end annotation


# instance fields
.field a:Landroid/content/Context;

.field private b:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/View$OnClickListener;)V
    .locals 0

    .prologue
    .line 955
    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    .line 956
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;->a:Landroid/content/Context;

    .line 957
    iput-object p2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;->b:Landroid/view/View$OnClickListener;

    .line 958
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 971
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;->b:Landroid/view/View$OnClickListener;

    if-eqz v0, :cond_0

    .line 972
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;->b:Landroid/view/View$OnClickListener;

    invoke-interface {v0, p1}, Landroid/view/View$OnClickListener;->onClick(Landroid/view/View;)V

    .line 974
    :cond_0
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 2

    .prologue
    .line 963
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;->a:Landroid/content/Context;

    const v1, 0x7f06007b

    invoke-static {v0, v1}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 964
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setFakeBoldText(Z)V

    .line 965
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$WhyTextClickableSpan;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f070137

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 966
    return-void
.end method
