.class Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "GuidedExperienceActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/GuidedExperienceActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyPagerAdapter"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/GuidedExperienceActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/FragmentManager;)V
    .locals 0

    .prologue
    .line 210
    iput-object p1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    .line 211
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 212
    return-void
.end method


# virtual methods
.method public a(I)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->a(Lcom/jibo/ui/activity/GuidedExperienceActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->a()Landroid/support/v4/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$MyPagerAdapter;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/GuidedExperienceActivity;->a(Lcom/jibo/ui/activity/GuidedExperienceActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method
