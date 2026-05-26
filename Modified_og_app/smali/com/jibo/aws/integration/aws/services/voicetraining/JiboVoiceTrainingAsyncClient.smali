.class public Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;
.super Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;


# direct methods
.method public constructor <init>(Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/ClientConfiguration;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Ljava/util/concurrent/ExecutorService;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Ljava/util/concurrent/ExecutorService;)V

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->a()V

    return-void
.end method


# virtual methods
.method protected a()V
    .locals 2

    const-string v0, "voicetraining"

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->setServiceNameIntern(Ljava/lang/String;)V

    const-string v0, "voicetraining"

    const-string v1, "VoiceTraining_20151103."

    invoke-virtual {p0, v0, v1}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingAsyncClient;->setServiceType(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
