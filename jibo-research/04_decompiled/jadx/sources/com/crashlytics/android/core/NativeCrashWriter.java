package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import io.fabric.sdk.android.Fabric;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class NativeCrashWriter {

    /* JADX INFO: renamed from: a */
    private static final SignalData f5279a = new SignalData("", "", 0);

    /* JADX INFO: renamed from: b */
    private static final ProtobufMessage[] f5280b = new ProtobufMessage[0];

    /* JADX INFO: renamed from: c */
    private static final ThreadMessage[] f5281c = new ThreadMessage[0];

    /* JADX INFO: renamed from: d */
    private static final FrameMessage[] f5282d = new FrameMessage[0];

    /* JADX INFO: renamed from: e */
    private static final BinaryImageMessage[] f5283e = new BinaryImageMessage[0];

    /* JADX INFO: renamed from: f */
    private static final CustomAttributeMessage[] f5284f = new CustomAttributeMessage[0];

    private static abstract class ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final int f5305a;

        /* JADX INFO: renamed from: b */
        private final ProtobufMessage[] f5306b;

        public ProtobufMessage(int i, ProtobufMessage... protobufMessageArr) {
            this.f5305a = i;
            this.f5306b = protobufMessageArr == null ? NativeCrashWriter.f5280b : protobufMessageArr;
        }

        /* JADX INFO: renamed from: b */
        public int mo5947b() {
            int iM5949c = m5949c();
            return iM5949c + CodedOutputStream.m5742l(iM5949c) + CodedOutputStream.m5741j(this.f5305a);
        }

        /* JADX INFO: renamed from: c */
        public int m5949c() {
            int iMo5945a = mo5945a();
            for (ProtobufMessage protobufMessage : this.f5306b) {
                iMo5945a += protobufMessage.mo5947b();
            }
            return iMo5945a;
        }

        /* JADX INFO: renamed from: b */
        public void mo5948b(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5765g(this.f5305a, 2);
            codedOutputStream.m5767k(m5949c());
            mo5946a(codedOutputStream);
            for (ProtobufMessage protobufMessage : this.f5306b) {
                protobufMessage.mo5948b(codedOutputStream);
            }
        }

        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    private static final class RepeatedMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final ProtobufMessage[] f5307a;

        public RepeatedMessage(ProtobufMessage... protobufMessageArr) {
            super(0, new ProtobufMessage[0]);
            this.f5307a = protobufMessageArr;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: b */
        public void mo5948b(CodedOutputStream codedOutputStream) throws IOException {
            for (ProtobufMessage protobufMessage : this.f5307a) {
                protobufMessage.mo5948b(codedOutputStream);
            }
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: b */
        public int mo5947b() {
            int iMo5947b = 0;
            for (ProtobufMessage protobufMessage : this.f5307a) {
                iMo5947b += protobufMessage.mo5947b();
            }
            return iMo5947b;
        }
    }

    private static final class NullMessage extends ProtobufMessage {
        public NullMessage() {
            super(0, new ProtobufMessage[0]);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: b */
        public void mo5948b(CodedOutputStream codedOutputStream) throws IOException {
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: b */
        public int mo5947b() {
            return 0;
        }
    }

    private static final class EventMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final long f5297a;

        /* JADX INFO: renamed from: b */
        private final String f5298b;

        public EventMessage(long j, String str, ProtobufMessage... protobufMessageArr) {
            super(10, protobufMessageArr);
            this.f5297a = j;
            this.f5298b = str;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return CodedOutputStream.m5727b(1, this.f5297a) + CodedOutputStream.m5728b(2, ByteString.m5711a(this.f5298b));
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5749a(1, this.f5297a);
            codedOutputStream.m5750a(2, ByteString.m5711a(this.f5298b));
        }
    }

    private static final class DeviceMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final float f5291a;

        /* JADX INFO: renamed from: b */
        private final int f5292b;

        /* JADX INFO: renamed from: c */
        private final boolean f5293c;

        /* JADX INFO: renamed from: d */
        private final int f5294d;

        /* JADX INFO: renamed from: e */
        private final long f5295e;

        /* JADX INFO: renamed from: f */
        private final long f5296f;

        public DeviceMessage(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new ProtobufMessage[0]);
            this.f5291a = f;
            this.f5292b = i;
            this.f5293c = z;
            this.f5294d = i2;
            this.f5295e = j;
            this.f5296f = j2;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return 0 + CodedOutputStream.m5726b(1, this.f5291a) + CodedOutputStream.m5738f(2, this.f5292b) + CodedOutputStream.m5729b(3, this.f5293c) + CodedOutputStream.m5733d(4, this.f5294d) + CodedOutputStream.m5727b(5, this.f5295e) + CodedOutputStream.m5727b(6, this.f5296f);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5747a(1, this.f5291a);
            codedOutputStream.m5761c(2, this.f5292b);
            codedOutputStream.m5751a(3, this.f5293c);
            codedOutputStream.m5748a(4, this.f5294d);
            codedOutputStream.m5749a(5, this.f5295e);
            codedOutputStream.m5749a(6, this.f5296f);
        }
    }

    private static final class LogMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        ByteString f5304a;

        public LogMessage(ByteString byteString) {
            super(6, new ProtobufMessage[0]);
            this.f5304a = byteString;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return CodedOutputStream.m5728b(1, this.f5304a);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5750a(1, this.f5304a);
        }
    }

    private static final class ApplicationMessage extends ProtobufMessage {
        public ApplicationMessage(ExecutionMessage executionMessage, RepeatedMessage repeatedMessage) {
            super(3, executionMessage, repeatedMessage);
        }
    }

    private static final class ExecutionMessage extends ProtobufMessage {
        public ExecutionMessage(SignalMessage signalMessage, RepeatedMessage repeatedMessage, RepeatedMessage repeatedMessage2) {
            super(1, repeatedMessage, signalMessage, repeatedMessage2);
        }
    }

    private static final class ThreadMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final String f5311a;

        /* JADX INFO: renamed from: b */
        private final int f5312b;

        public ThreadMessage(ThreadData threadData, RepeatedMessage repeatedMessage) {
            super(1, repeatedMessage);
            this.f5311a = threadData.f5373a;
            this.f5312b = threadData.f5374b;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return (m5950d() ? CodedOutputStream.m5728b(1, ByteString.m5711a(this.f5311a)) : 0) + CodedOutputStream.m5733d(2, this.f5312b);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            if (m5950d()) {
                codedOutputStream.m5750a(1, ByteString.m5711a(this.f5311a));
            }
            codedOutputStream.m5748a(2, this.f5312b);
        }

        /* JADX INFO: renamed from: d */
        private boolean m5950d() {
            return this.f5311a != null && this.f5311a.length() > 0;
        }
    }

    private static final class FrameMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final long f5299a;

        /* JADX INFO: renamed from: b */
        private final String f5300b;

        /* JADX INFO: renamed from: c */
        private final String f5301c;

        /* JADX INFO: renamed from: d */
        private final long f5302d;

        /* JADX INFO: renamed from: e */
        private final int f5303e;

        public FrameMessage(ThreadData.FrameData frameData) {
            super(3, new ProtobufMessage[0]);
            this.f5299a = frameData.f5376a;
            this.f5300b = frameData.f5377b;
            this.f5301c = frameData.f5378c;
            this.f5302d = frameData.f5379d;
            this.f5303e = frameData.f5380e;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return CodedOutputStream.m5727b(1, this.f5299a) + CodedOutputStream.m5728b(2, ByteString.m5711a(this.f5300b)) + CodedOutputStream.m5728b(3, ByteString.m5711a(this.f5301c)) + CodedOutputStream.m5727b(4, this.f5302d) + CodedOutputStream.m5733d(5, this.f5303e);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5749a(1, this.f5299a);
            codedOutputStream.m5750a(2, ByteString.m5711a(this.f5300b));
            codedOutputStream.m5750a(3, ByteString.m5711a(this.f5301c));
            codedOutputStream.m5749a(4, this.f5302d);
            codedOutputStream.m5748a(5, this.f5303e);
        }
    }

    private static final class SignalMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final String f5308a;

        /* JADX INFO: renamed from: b */
        private final String f5309b;

        /* JADX INFO: renamed from: c */
        private final long f5310c;

        public SignalMessage(SignalData signalData) {
            super(3, new ProtobufMessage[0]);
            this.f5308a = signalData.f5370a;
            this.f5309b = signalData.f5371b;
            this.f5310c = signalData.f5372c;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return CodedOutputStream.m5728b(1, ByteString.m5711a(this.f5308a)) + CodedOutputStream.m5728b(2, ByteString.m5711a(this.f5309b)) + CodedOutputStream.m5727b(3, this.f5310c);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5750a(1, ByteString.m5711a(this.f5308a));
            codedOutputStream.m5750a(2, ByteString.m5711a(this.f5309b));
            codedOutputStream.m5749a(3, this.f5310c);
        }
    }

    private static final class BinaryImageMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final long f5285a;

        /* JADX INFO: renamed from: b */
        private final long f5286b;

        /* JADX INFO: renamed from: c */
        private final String f5287c;

        /* JADX INFO: renamed from: d */
        private final String f5288d;

        public BinaryImageMessage(BinaryImageData binaryImageData) {
            super(4, new ProtobufMessage[0]);
            this.f5285a = binaryImageData.f5350a;
            this.f5286b = binaryImageData.f5351b;
            this.f5287c = binaryImageData.f5352c;
            this.f5288d = binaryImageData.f5353d;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            int iM5727b = CodedOutputStream.m5727b(1, this.f5285a);
            return iM5727b + CodedOutputStream.m5728b(3, ByteString.m5711a(this.f5287c)) + CodedOutputStream.m5727b(2, this.f5286b) + CodedOutputStream.m5728b(4, ByteString.m5711a(this.f5288d));
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5749a(1, this.f5285a);
            codedOutputStream.m5749a(2, this.f5286b);
            codedOutputStream.m5750a(3, ByteString.m5711a(this.f5287c));
            codedOutputStream.m5750a(4, ByteString.m5711a(this.f5288d));
        }
    }

    private static final class CustomAttributeMessage extends ProtobufMessage {

        /* JADX INFO: renamed from: a */
        private final String f5289a;

        /* JADX INFO: renamed from: b */
        private final String f5290b;

        public CustomAttributeMessage(CustomAttributeData customAttributeData) {
            super(2, new ProtobufMessage[0]);
            this.f5289a = customAttributeData.f5354a;
            this.f5290b = customAttributeData.f5355b;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public int mo5945a() {
            return CodedOutputStream.m5728b(2, ByteString.m5711a(this.f5290b == null ? "" : this.f5290b)) + CodedOutputStream.m5728b(1, ByteString.m5711a(this.f5289a));
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        /* JADX INFO: renamed from: a */
        public void mo5946a(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.m5750a(1, ByteString.m5711a(this.f5289a));
            codedOutputStream.m5750a(2, ByteString.m5711a(this.f5290b == null ? "" : this.f5290b));
        }
    }

    /* JADX INFO: renamed from: a */
    private static EventMessage m5936a(SessionEventData sessionEventData, LogFileManager logFileManager, Map<String, String> map) throws IOException {
        ApplicationMessage applicationMessage = new ApplicationMessage(new ExecutionMessage(new SignalMessage(sessionEventData.f5365b != null ? sessionEventData.f5365b : f5279a), m5941a(sessionEventData.f5366c), m5938a(sessionEventData.f5367d)), m5939a(m5944a(sessionEventData.f5368e, map)));
        ProtobufMessage protobufMessageM5937a = m5937a(sessionEventData.f5369f);
        ByteString byteStringM5922a = logFileManager.m5922a();
        if (byteStringM5922a == null) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.m5926b();
        return new EventMessage(sessionEventData.f5364a, "ndk-crash", applicationMessage, protobufMessageM5937a, byteStringM5922a != null ? new LogMessage(byteStringM5922a) : new NullMessage());
    }

    /* JADX INFO: renamed from: a */
    private static CustomAttributeData[] m5944a(CustomAttributeData[] customAttributeDataArr, Map<String, String> map) {
        int i = 0;
        TreeMap treeMap = new TreeMap(map);
        if (customAttributeDataArr != null) {
            for (CustomAttributeData customAttributeData : customAttributeDataArr) {
                treeMap.put(customAttributeData.f5354a, customAttributeData.f5355b);
            }
        }
        Map.Entry[] entryArr = (Map.Entry[]) treeMap.entrySet().toArray(new Map.Entry[treeMap.size()]);
        CustomAttributeData[] customAttributeDataArr2 = new CustomAttributeData[entryArr.length];
        while (true) {
            int i2 = i;
            if (i2 < customAttributeDataArr2.length) {
                customAttributeDataArr2[i2] = new CustomAttributeData((String) entryArr[i2].getKey(), (String) entryArr[i2].getValue());
                i = i2 + 1;
            } else {
                return customAttributeDataArr2;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static ProtobufMessage m5937a(DeviceData deviceData) {
        return deviceData == null ? new NullMessage() : new DeviceMessage(deviceData.f5361f / 100.0f, deviceData.f5362g, deviceData.f5363h, deviceData.f5356a, deviceData.f5357b - deviceData.f5359d, deviceData.f5358c - deviceData.f5360e);
    }

    /* JADX INFO: renamed from: a */
    private static RepeatedMessage m5941a(ThreadData[] threadDataArr) {
        ThreadMessage[] threadMessageArr = threadDataArr != null ? new ThreadMessage[threadDataArr.length] : f5281c;
        for (int i = 0; i < threadMessageArr.length; i++) {
            ThreadData threadData = threadDataArr[i];
            threadMessageArr[i] = new ThreadMessage(threadData, m5940a(threadData.f5375c));
        }
        return new RepeatedMessage(threadMessageArr);
    }

    /* JADX INFO: renamed from: a */
    private static RepeatedMessage m5940a(ThreadData.FrameData[] frameDataArr) {
        FrameMessage[] frameMessageArr = frameDataArr != null ? new FrameMessage[frameDataArr.length] : f5282d;
        for (int i = 0; i < frameMessageArr.length; i++) {
            frameMessageArr[i] = new FrameMessage(frameDataArr[i]);
        }
        return new RepeatedMessage(frameMessageArr);
    }

    /* JADX INFO: renamed from: a */
    private static RepeatedMessage m5938a(BinaryImageData[] binaryImageDataArr) {
        BinaryImageMessage[] binaryImageMessageArr = binaryImageDataArr != null ? new BinaryImageMessage[binaryImageDataArr.length] : f5283e;
        for (int i = 0; i < binaryImageMessageArr.length; i++) {
            binaryImageMessageArr[i] = new BinaryImageMessage(binaryImageDataArr[i]);
        }
        return new RepeatedMessage(binaryImageMessageArr);
    }

    /* JADX INFO: renamed from: a */
    private static RepeatedMessage m5939a(CustomAttributeData[] customAttributeDataArr) {
        CustomAttributeMessage[] customAttributeMessageArr = customAttributeDataArr != null ? new CustomAttributeMessage[customAttributeDataArr.length] : f5284f;
        for (int i = 0; i < customAttributeMessageArr.length; i++) {
            customAttributeMessageArr[i] = new CustomAttributeMessage(customAttributeDataArr[i]);
        }
        return new RepeatedMessage(customAttributeMessageArr);
    }

    /* JADX INFO: renamed from: a */
    public static void m5942a(SessionEventData sessionEventData, LogFileManager logFileManager, Map<String, String> map, CodedOutputStream codedOutputStream) throws IOException {
        m5936a(sessionEventData, logFileManager, map).mo5948b(codedOutputStream);
    }
}
