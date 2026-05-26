.class Lcom/jibo/service/BasicDeviceRegistrationService$1;
.super Ljava/lang/Object;
.source "BasicDeviceRegistrationService.java"

# interfaces
.implements Lcom/amazonaws/auth/AWSCredentials;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/service/BasicDeviceRegistrationService;->onHandleIntent(Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/service/BasicDeviceRegistrationService;


# direct methods
.method constructor <init>(Lcom/jibo/service/BasicDeviceRegistrationService;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/jibo/service/BasicDeviceRegistrationService$1;->b:Lcom/jibo/service/BasicDeviceRegistrationService;

    iput-object p2, p0, Lcom/jibo/service/BasicDeviceRegistrationService$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAWSAccessKeyId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAWSSecretKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/jibo/service/BasicDeviceRegistrationService$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
