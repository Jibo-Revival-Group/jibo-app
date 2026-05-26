.class public Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OauthValue"
.end annotation


# instance fields
.field private authCode:Ljava/lang/String;

.field private authorizationUri:Ljava/lang/String;

.field private clientId:Ljava/lang/String;

.field private icon:Ljava/lang/String;

.field private iosCallbackUri:Ljava/lang/String;

.field private iosClientId:Ljava/lang/String;

.field private scopes:[Ljava/lang/String;

.field private serverClientId:Ljava/lang/String;

.field private serviceAccountName:Ljava/lang/String;

.field private serviceName:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 512
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    .line 513
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceAccountName:Ljava/lang/String;

    .line 514
    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceName:Ljava/lang/String;

    .line 515
    iput-object p3, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->authCode:Ljava/lang/String;

    .line 516
    iput-object p5, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->scopes:[Ljava/lang/String;

    .line 517
    iput-object p4, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->clientId:Ljava/lang/String;

    .line 518
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 520
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    .line 521
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceAccountName:Ljava/lang/String;

    .line 522
    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceName:Ljava/lang/String;

    .line 523
    iput-object p3, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->scopes:[Ljava/lang/String;

    .line 524
    return-void
.end method

.method static synthetic access$000(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->icon:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->title:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->authorizationUri:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->iosCallbackUri:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->iosClientId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)[Ljava/lang/String;
    .locals 1

    .prologue
    .line 499
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->scopes:[Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public getAuthCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 591
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->authCode:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthorizationUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 559
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->authorizationUri:Ljava/lang/String;

    return-object v0
.end method

.method public getClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 599
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->clientId:Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 527
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->icon:Ljava/lang/String;

    return-object v0
.end method

.method public getIosCallbackUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 567
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->iosCallbackUri:Ljava/lang/String;

    return-object v0
.end method

.method public getIosClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 575
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->iosClientId:Ljava/lang/String;

    return-object v0
.end method

.method public getScopes()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 583
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->scopes:[Ljava/lang/String;

    return-object v0
.end method

.method public getServerClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 607
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serverClientId:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceAccountName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 551
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceAccountName:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 543
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 535
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setAuthCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 595
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->authCode:Ljava/lang/String;

    .line 596
    return-void
.end method

.method public setAuthorizationUri(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 563
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->authorizationUri:Ljava/lang/String;

    .line 564
    return-void
.end method

.method public setClientId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 603
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->clientId:Ljava/lang/String;

    .line 604
    return-void
.end method

.method public setIcon(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 531
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->icon:Ljava/lang/String;

    .line 532
    return-void
.end method

.method public setIosCallbackUri(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 571
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->iosCallbackUri:Ljava/lang/String;

    .line 572
    return-void
.end method

.method public setIosClientId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 579
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->iosClientId:Ljava/lang/String;

    .line 580
    return-void
.end method

.method public setScopes([Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 587
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->scopes:[Ljava/lang/String;

    .line 588
    return-void
.end method

.method public setServerClientId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 611
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serverClientId:Ljava/lang/String;

    .line 612
    return-void
.end method

.method public setServiceAccountName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 555
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceAccountName:Ljava/lang/String;

    .line 556
    return-void
.end method

.method public setServiceName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 547
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->serviceName:Ljava/lang/String;

    .line 548
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 539
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->title:Ljava/lang/String;

    .line 540
    return-void
.end method
