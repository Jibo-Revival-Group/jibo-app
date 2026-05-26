.class public final Lcom/jibo/utils/SubnetUtils$SubnetInfo;
.super Ljava/lang/Object;
.source "SubnetUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/utils/SubnetUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "SubnetInfo"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/utils/SubnetUtils;


# direct methods
.method private constructor <init>(Lcom/jibo/utils/SubnetUtils;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->a:Lcom/jibo/utils/SubnetUtils;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/utils/SubnetUtils;Lcom/jibo/utils/SubnetUtils$1;)V
    .locals 0

    .prologue
    .line 157
    invoke-direct {p0, p1}, Lcom/jibo/utils/SubnetUtils$SubnetInfo;-><init>(Lcom/jibo/utils/SubnetUtils;)V

    return-void
.end method

.method private b()I
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->a:Lcom/jibo/utils/SubnetUtils;

    invoke-static {v0}, Lcom/jibo/utils/SubnetUtils;->a(Lcom/jibo/utils/SubnetUtils;)I

    move-result v0

    return v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 3

    .prologue
    .line 178
    iget-object v0, p0, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->a:Lcom/jibo/utils/SubnetUtils;

    iget-object v1, p0, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->a:Lcom/jibo/utils/SubnetUtils;

    invoke-direct {p0}, Lcom/jibo/utils/SubnetUtils$SubnetInfo;->b()I

    move-result v2

    invoke-static {v1, v2}, Lcom/jibo/utils/SubnetUtils;->a(Lcom/jibo/utils/SubnetUtils;I)[I

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/utils/SubnetUtils;->a(Lcom/jibo/utils/SubnetUtils;[I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
