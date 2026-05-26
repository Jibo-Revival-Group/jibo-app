.class final Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;
.super Lcom/crashlytics/android/core/NativeCrashWriter$ProtobufMessage;
.source "NativeCrashWriter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/crashlytics/android/core/NativeCrashWriter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "FrameMessage"
.end annotation


# instance fields
.field private final a:J

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:J

.field private final e:I


# direct methods
.method public constructor <init>(Lcom/crashlytics/android/core/internal/models/ThreadData$FrameData;)V
    .locals 2

    .prologue
    .line 356
    const/4 v0, 0x3

    const/4 v1, 0x0

    new-array v1, v1, [Lcom/crashlytics/android/core/NativeCrashWriter$ProtobufMessage;

    invoke-direct {p0, v0, v1}, Lcom/crashlytics/android/core/NativeCrashWriter$ProtobufMessage;-><init>(I[Lcom/crashlytics/android/core/NativeCrashWriter$ProtobufMessage;)V

    .line 357
    iget-wide v0, p1, Lcom/crashlytics/android/core/internal/models/ThreadData$FrameData;->a:J

    iput-wide v0, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->a:J

    .line 358
    iget-object v0, p1, Lcom/crashlytics/android/core/internal/models/ThreadData$FrameData;->b:Ljava/lang/String;

    iput-object v0, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->b:Ljava/lang/String;

    .line 359
    iget-object v0, p1, Lcom/crashlytics/android/core/internal/models/ThreadData$FrameData;->c:Ljava/lang/String;

    iput-object v0, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->c:Ljava/lang/String;

    .line 360
    iget-wide v0, p1, Lcom/crashlytics/android/core/internal/models/ThreadData$FrameData;->d:J

    iput-wide v0, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->d:J

    .line 361
    iget v0, p1, Lcom/crashlytics/android/core/internal/models/ThreadData$FrameData;->e:I

    iput v0, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->e:I

    .line 362
    return-void
.end method


# virtual methods
.method public a()I
    .locals 4

    .prologue
    .line 366
    const/4 v0, 0x1

    iget-wide v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->a:J

    invoke-static {v0, v2, v3}, Lcom/crashlytics/android/core/CodedOutputStream;->b(IJ)I

    move-result v0

    .line 367
    const/4 v1, 0x2

    iget-object v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->b:Ljava/lang/String;

    invoke-static {v2}, Lcom/crashlytics/android/core/ByteString;->a(Ljava/lang/String;)Lcom/crashlytics/android/core/ByteString;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/crashlytics/android/core/CodedOutputStream;->b(ILcom/crashlytics/android/core/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 368
    const/4 v1, 0x3

    iget-object v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->c:Ljava/lang/String;

    invoke-static {v2}, Lcom/crashlytics/android/core/ByteString;->a(Ljava/lang/String;)Lcom/crashlytics/android/core/ByteString;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/crashlytics/android/core/CodedOutputStream;->b(ILcom/crashlytics/android/core/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 369
    const/4 v1, 0x4

    iget-wide v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->d:J

    invoke-static {v1, v2, v3}, Lcom/crashlytics/android/core/CodedOutputStream;->b(IJ)I

    move-result v1

    add-int/2addr v0, v1

    .line 370
    const/4 v1, 0x5

    iget v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->e:I

    invoke-static {v1, v2}, Lcom/crashlytics/android/core/CodedOutputStream;->d(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 371
    return v0
.end method

.method public a(Lcom/crashlytics/android/core/CodedOutputStream;)V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 376
    const/4 v0, 0x1

    iget-wide v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->a:J

    invoke-virtual {p1, v0, v2, v3}, Lcom/crashlytics/android/core/CodedOutputStream;->a(IJ)V

    .line 377
    const/4 v0, 0x2

    iget-object v1, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->b:Ljava/lang/String;

    invoke-static {v1}, Lcom/crashlytics/android/core/ByteString;->a(Ljava/lang/String;)Lcom/crashlytics/android/core/ByteString;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/crashlytics/android/core/CodedOutputStream;->a(ILcom/crashlytics/android/core/ByteString;)V

    .line 378
    const/4 v0, 0x3

    iget-object v1, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->c:Ljava/lang/String;

    invoke-static {v1}, Lcom/crashlytics/android/core/ByteString;->a(Ljava/lang/String;)Lcom/crashlytics/android/core/ByteString;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/crashlytics/android/core/CodedOutputStream;->a(ILcom/crashlytics/android/core/ByteString;)V

    .line 379
    const/4 v0, 0x4

    iget-wide v2, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->d:J

    invoke-virtual {p1, v0, v2, v3}, Lcom/crashlytics/android/core/CodedOutputStream;->a(IJ)V

    .line 380
    const/4 v0, 0x5

    iget v1, p0, Lcom/crashlytics/android/core/NativeCrashWriter$FrameMessage;->e:I

    invoke-virtual {p1, v0, v1}, Lcom/crashlytics/android/core/CodedOutputStream;->a(II)V

    .line 381
    return-void
.end method
