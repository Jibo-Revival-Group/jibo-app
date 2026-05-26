.class public Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amazonaws/transform/Unmarshaller;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/transform/Unmarshaller",
        "<",
        "Ljava/lang/String;",
        "Lcom/amazonaws/transform/JsonUnmarshallerContext;",
        ">;"
    }
.end annotation


# static fields
.field private static instance:Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;
    .locals 1

    sget-object v0, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;->instance:Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    if-nez v0, :cond_0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;-><init>()V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;->instance:Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    :cond_0
    sget-object v0, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;->instance:Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic unmarshall(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    check-cast p1, Lcom/amazonaws/transform/JsonUnmarshallerContext;

    invoke-virtual {p0, p1}, Lcom/jibo/aws/integration/aws/services/skills/model/SettingsUnmarshaller;->unmarshall(Lcom/amazonaws/transform/JsonUnmarshallerContext;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unmarshall(Lcom/amazonaws/transform/JsonUnmarshallerContext;)Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/io/BufferedReader;

    invoke-virtual {p1}, Lcom/amazonaws/transform/JsonUnmarshallerContext;->getReader()Lcom/amazonaws/util/json/AwsJsonReader;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazonaws/util/json/AwsJsonReader;->getReader()Ljava/io/Reader;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    :goto_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
