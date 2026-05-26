.class public Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;
.super Ljava/lang/Object;
.source "SingleFragmentActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/SingleFragmentActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private a:Landroid/content/Context;

.field private b:Landroid/support/v4/app/Fragment;

.field private c:Landroid/content/Intent;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    iput-object p1, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a:Landroid/content/Context;

    .line 91
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iput-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    sget-object v1, Lcom/jibo/ui/activity/SingleFragmentActivity;->i:Ljava/lang/String;

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 93
    return-void
.end method

.method public constructor <init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 96
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 97
    iput-object p1, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->b:Landroid/support/v4/app/Fragment;

    .line 98
    return-void
.end method


# virtual methods
.method public a()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    return-object v0
.end method

.method public a(Ljava/lang/String;I)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 122
    return-object p0
.end method

.method public a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 107
    return-object p0
.end method

.method public a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 117
    return-object p0
.end method

.method public a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    invoke-virtual {v0, p1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 112
    return-object p0
.end method

.method public a(I)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 126
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    sget-object v1, Lcom/jibo/ui/activity/SingleFragmentActivity;->i:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 128
    sget-object v0, Lcom/jibo/ui/activity/SingleFragmentActivity;->h:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/jibo/ui/activity/SingleFragmentActivity;->i:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " must be supplied in Extras!"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    :goto_0
    return-void

    .line 131
    :cond_0
    const/4 v0, -0x1

    if-ne p1, v0, :cond_1

    .line 132
    sget-object v0, Lcom/jibo/ui/activity/SingleFragmentActivity;->h:Ljava/lang/String;

    const-string v1, "Request code must be supplied!"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 136
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a:Landroid/content/Context;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->b:Landroid/support/v4/app/Fragment;

    if-nez v0, :cond_2

    .line 137
    sget-object v0, Lcom/jibo/ui/activity/SingleFragmentActivity;->h:Ljava/lang/String;

    const-string v1, "Neither context OR fragment must be supplied!"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 142
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->b:Landroid/support/v4/app/Fragment;

    if-eqz v0, :cond_4

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->b:Landroid/support/v4/app/Fragment;

    iget-object v1, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    invoke-virtual {v0, v1, p1}, Landroid/support/v4/app/Fragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 148
    :cond_3
    :goto_1
    iput-object v2, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->b:Landroid/support/v4/app/Fragment;

    .line 149
    iput-object v2, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a:Landroid/content/Context;

    .line 150
    iput-object v2, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    goto :goto_0

    .line 144
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a:Landroid/content/Context;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_3

    .line 145
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    iget-object v1, p0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->c:Landroid/content/Intent;

    invoke-virtual {v0, v1, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_1
.end method
