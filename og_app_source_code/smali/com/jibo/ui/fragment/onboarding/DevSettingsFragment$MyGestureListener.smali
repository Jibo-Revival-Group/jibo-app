.class public Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "DevSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyGestureListener"
.end annotation


# instance fields
.field a:I

.field b:F

.field c:I

.field final synthetic d:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
    .locals 1

    .prologue
    .line 388
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->d:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    .line 389
    const/16 v0, -0x36b0

    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->a:I

    .line 390
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->b:F

    .line 391
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->c:I

    return-void
.end method


# virtual methods
.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 395
    const/4 v0, 0x1

    return v0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 2

    .prologue
    .line 401
    iget v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->b:F

    add-float/2addr v0, p4

    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->b:F

    .line 402
    iget v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->c:I

    .line 403
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    iget v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->a:I

    int-to-float v0, v0

    cmpg-float v0, p4, v0

    if-gtz v0, :cond_0

    .line 404
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener;->d:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->showDevSettings(Landroid/view/View;)Z

    .line 405
    :cond_0
    const/4 v0, 0x1

    return v0
.end method
