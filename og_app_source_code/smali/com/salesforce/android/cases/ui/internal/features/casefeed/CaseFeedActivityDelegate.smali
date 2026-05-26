.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;
.super Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;
.source "CaseFeedActivityDelegate.java"

# interfaces
.implements Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;",
        "Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;",
        ">;",
        "Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;

.field private b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;)V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BaseActivityDelegate;-><init>(Landroid/support/v7/app/AppCompatActivity;Ljava/lang/Class;)V

    .line 39
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;

    .line 40
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->b()V

    .line 58
    :cond_0
    return-void
.end method

.method protected a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;)V
    .locals 1

    .prologue
    .line 43
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    .line 46
    invoke-interface {p1, p0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter$Listener;)V

    .line 49
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->a()Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$View;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->a(Lcom/salesforce/android/cases/ui/internal/features/shared/BaseView;)V

    .line 50
    return-void
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;)V
    .locals 0

    .prologue
    .line 30
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->a(Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;)V

    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->a:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivity;->finish()V

    .line 64
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedActivityDelegate;->b:Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;

    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedContract$Presenter;->a()V

    .line 70
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
