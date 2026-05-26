.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$1;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;)V
    .locals 0

    .prologue
    .line 300
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$1;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 303
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6$1;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$6;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b(Z)V

    .line 304
    return-void
.end method
