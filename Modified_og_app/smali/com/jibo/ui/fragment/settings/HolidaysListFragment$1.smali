.class Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;
.super Ljava/lang/Object;
.source "HolidaysListFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(ZLjava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Z

.field final synthetic c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;Ljava/util/List;Z)V
    .locals 0

    .prologue
    .line 166
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->a:Ljava/util/List;

    iput-boolean p3, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->b:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(Ljava/lang/Runnable;)V

    .line 187
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 169
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->c:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    const-string v1, "switch holidays"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 170
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 166
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;->a(Lcom/jibo/aws/integration/aws/services/person/model/HolidaysSwitchRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
