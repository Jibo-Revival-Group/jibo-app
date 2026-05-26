.class Lcom/jibo/ui/activity/TipsActivity$1;
.super Ljava/lang/Object;
.source "TipsActivity.java"

# interfaces
.implements Landroid/support/design/widget/AppBarLayout$OnOffsetChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TipsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field a:Z

.field b:I

.field final synthetic c:Lcom/jibo/ui/activity/TipsActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TipsActivity;)V
    .locals 1

    .prologue
    .line 99
    iput-object p1, p0, Lcom/jibo/ui/activity/TipsActivity$1;->c:Lcom/jibo/ui/activity/TipsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->a:Z

    .line 101
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->b:I

    return-void
.end method


# virtual methods
.method public a(Landroid/support/design/widget/AppBarLayout;I)V
    .locals 3

    .prologue
    .line 105
    iget v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->b:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 106
    invoke-virtual {p1}, Landroid/support/design/widget/AppBarLayout;->getTotalScrollRange()I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->b:I

    .line 108
    :cond_0
    iget v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->b:I

    add-int/2addr v0, p2

    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity$1;->c:Lcom/jibo/ui/activity/TipsActivity;

    iget v1, v1, Lcom/jibo/ui/activity/TipsActivity;->h:I

    if-gt v0, v1, :cond_2

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->c:Lcom/jibo/ui/activity/TipsActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/TipsActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 112
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->a:Z

    .line 119
    :cond_1
    :goto_0
    return-void

    .line 113
    :cond_2
    iget-boolean v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->a:Z

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->b:I

    add-int/2addr v0, p2

    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity$1;->c:Lcom/jibo/ui/activity/TipsActivity;

    iget v1, v1, Lcom/jibo/ui/activity/TipsActivity;->h:I

    if-le v0, v1, :cond_1

    .line 116
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->c:Lcom/jibo/ui/activity/TipsActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/TipsActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    iget-object v1, p0, Lcom/jibo/ui/activity/TipsActivity$1;->c:Lcom/jibo/ui/activity/TipsActivity;

    const v2, 0x7f080109

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/Toolbar;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 117
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/activity/TipsActivity$1;->a:Z

    goto :goto_0
.end method
