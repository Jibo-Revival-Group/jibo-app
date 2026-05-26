.class Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;
.super Ljava/lang/Object;
.source "LocationAutoCompleteTextView.java"

# interfaces
.implements Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .locals 9

    .prologue
    .line 97
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->isAttachedToWindow()Z

    move-result v0

    if-nez v0, :cond_1

    .line 126
    :cond_0
    :goto_0
    return-void

    .line 101
    :cond_1
    if-nez p1, :cond_2

    .line 102
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    .line 103
    invoke-virtual {v1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f10012b

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 102
    invoke-static {v0, v1}, Lcom/jibo/utils/UIUtils;->a(Landroid/view/View;Ljava/lang/String;)V

    goto :goto_0

    .line 123
    :catch_0
    move-exception v0

    goto :goto_0

    .line 108
    :cond_2
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    const-string v1, "lat"

    .line 109
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    const-string v2, "lng"

    .line 110
    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    const-string v3, "city"

    .line 111
    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "state"

    .line 112
    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "country"

    .line 113
    invoke-virtual {p1, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "timezone"

    .line 114
    invoke-virtual {p1, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "addressLine"

    .line 115
    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/jibo/utils/Util;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "addressLine"

    .line 116
    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/jibo/utils/Util;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;-><init>(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->setTag(Ljava/lang/Object;)V

    .line 120
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-static {v0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;->d(Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;)Landroid/view/View$OnClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$3;->a:Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;

    invoke-interface {v0, v1}, Landroid/view/View$OnClickListener;->onClick(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0
.end method
