.class Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;
.super Landroid/os/AsyncTask;
.source "DevSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ListAttributionsAsyncTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;",
        ">;"
    }
.end annotation


# instance fields
.field a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;


# direct methods
.method private constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
    .locals 0

    .prologue
    .line 409
    iput-object p1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$1;)V
    .locals 0

    .prologue
    .line 409
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;-><init>(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V

    return-void
.end method


# virtual methods
.method protected varargs a([Ljava/lang/Void;)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;
    .locals 4

    .prologue
    .line 422
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->c()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;

    move-result-object v0

    .line 424
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->listAttributions(Ljava/lang/String;J)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    move-result-object v0

    .line 426
    return-object v0
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;)V
    .locals 2

    .prologue
    .line 431
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 433
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->responseText:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 434
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f01000c

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 435
    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->responseText:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 436
    return-void
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 409
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->a([Ljava/lang/Void;)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 409
    check-cast p1, Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->a(Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 415
    iget-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->b(Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->b:Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;->gqaLoopsSpinner:Landroid/widget/Spinner;

    invoke-virtual {v1}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment$ListAttributionsAsyncTask;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 417
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 418
    return-void
.end method
