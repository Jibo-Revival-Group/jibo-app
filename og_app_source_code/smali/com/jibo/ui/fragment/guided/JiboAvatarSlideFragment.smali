.class public Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;
.super Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;
.source "JiboAvatarSlideFragment.java"


# instance fields
.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtInfo:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public b(I)V
    .locals 0

    .prologue
    .line 68
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    const-string v0, ""

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 39
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->q()Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 41
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;->k()V

    .line 42
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 46
    const v0, 0x7f0b006d

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    .line 51
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/avatar/AvatarsLocationBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 53
    const v0, 0x7f100149

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 54
    const v1, 0x7f100148

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 55
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 56
    new-instance v3, Lcom/jibo/utils/Util$CustomTypefaceSpan;

    const-string v4, ""

    sget-object v5, Lcom/jibo/ui/view/proxima/ProximaHelper;->d:Landroid/graphics/Typeface;

    invoke-direct {v3, v4, v5}, Lcom/jibo/utils/Util$CustomTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 57
    invoke-virtual {v1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    add-int/2addr v0, v1

    const/16 v1, 0x21

    .line 56
    invoke-virtual {v2, v3, v4, v0, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 59
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/JiboAvatarSlideFragment;->txtInfo:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    return-void
.end method
