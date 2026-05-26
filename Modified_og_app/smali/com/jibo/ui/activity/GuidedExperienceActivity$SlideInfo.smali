.class Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;
.super Ljava/lang/Object;
.source "GuidedExperienceActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/GuidedExperienceActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SlideInfo"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

.field private b:Landroid/support/v4/app/Fragment;

.field private c:Z

.field private d:I


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;)V
    .locals 1

    .prologue
    .line 250
    iput-object p1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 248
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->d:I

    .line 251
    iput-object p2, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->b:Landroid/support/v4/app/Fragment;

    .line 252
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/GuidedExperienceActivity;Landroid/support/v4/app/Fragment;ZI)V
    .locals 1

    .prologue
    .line 254
    iput-object p1, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->a:Lcom/jibo/ui/activity/GuidedExperienceActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 248
    const/4 v0, -0x1

    iput v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->d:I

    .line 255
    iput-object p2, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->b:Landroid/support/v4/app/Fragment;

    .line 256
    iput-boolean p3, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->c:Z

    .line 257
    iput p4, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->d:I

    .line 258
    return-void
.end method


# virtual methods
.method public a()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->b:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 265
    iget-boolean v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->c:Z

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 269
    iget v0, p0, Lcom/jibo/ui/activity/GuidedExperienceActivity$SlideInfo;->d:I

    return v0
.end method
