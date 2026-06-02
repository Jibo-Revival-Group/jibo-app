package com.amazonaws.internal.config;

import com.amazonaws.regions.Regions;
import com.facebook.internal.AnalyticsEvents;
import com.jibo.aws.integration.aws.services.account.JiboAccountClient;
import com.jibo.aws.integration.aws.services.binary.JiboBinaryClient;
import com.jibo.aws.integration.aws.services.jot.JiboJotClient;
import com.jibo.aws.integration.aws.services.loop.JiboLoopClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.photo.JiboPhotoClient;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesClient;
import com.jibo.aws.integration.aws.services.voicetraining.JiboVoiceTrainingClient;
import com.jibo.aws.integration.util.C0977a;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
public class InternalConfig {
    public static final String TAG = C0977a.m10070a(InternalConfig.class);
    private final Map<String, HttpClientConfig> httpClients;
    private final Map<String, SignerConfig> serviceRegionSigners;
    private final Map<String, SignerConfig> serviceSigners;
    private final SignerConfig defaultSignerConfig = getDefaultSigner();
    private final Map<String, SignerConfig> regionSigners = getDefaultRegionSigners();

    public static class Factory {
        private static final InternalConfig SINGELTON;

        static {
            try {
                SINGELTON = new InternalConfig();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new IllegalStateException("Fatal: Failed to load the internal config for AWS Android SDK", e2);
            }
        }

        public static InternalConfig getInternalConfig() {
            return SINGELTON;
        }
    }

    InternalConfig() {
        this.regionSigners.putAll(getOverrideRegionSigners());
        this.serviceSigners = getDefaultServiceSigners();
        this.serviceSigners.putAll(getOverrideServiceSigners());
        this.serviceRegionSigners = getDefaultServiceRegionSigners();
        this.serviceRegionSigners.putAll(getOverrideServiceRegionSigners());
        this.httpClients = getDefaultHttpClients();
        this.httpClients.putAll(getOverrideHttpClients());
    }

    private static Map<String, HttpClientConfig> getDefaultHttpClients() {
        HashMap map = new HashMap();
        map.put(JiboAccountClient.class.getSimpleName(), new HttpClientConfig("account"));
        map.put(JiboLoopClient.class.getSimpleName(), new HttpClientConfig("loop"));
        map.put(JiboJotClient.class.getSimpleName(), new HttpClientConfig("jot"));
        map.put(JiboRobotPropertiesClient.class.getSimpleName(), new HttpClientConfig("robotproperties"));
        map.put(JiboVoiceTrainingClient.class.getSimpleName(), new HttpClientConfig("voicetraining"));
        map.put(JiboPhotoClient.class.getSimpleName(), new HttpClientConfig(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO));
        map.put(JiboBinaryClient.class.getSimpleName(), new HttpClientConfig(MIME.ENC_BINARY));
        return map;
    }

    private static Map<String, SignerConfig> getDefaultRegionSigners() {
        HashMap map = new HashMap();
        map.put(Regions.ApiDev.getName(), new SignerConfig("AWS4SignerType"));
        map.put(Regions.ServerDev.getName(), new SignerConfig("AWS4SignerType"));
        return map;
    }

    private static Map<String, SignerConfig> getDefaultServiceRegionSigners() {
        return new HashMap();
    }

    private static Map<String, SignerConfig> getDefaultServiceSigners() {
        HashMap map = new HashMap();
        map.put("account", new SignerConfig("AWS4SignerType"));
        map.put("loop", new SignerConfig("AWS4SignerType"));
        map.put("jot", new SignerConfig("AWS4SignerType"));
        map.put("robotproperties", new SignerConfig("AWS4SignerType"));
        map.put("voicetraining", new SignerConfig("AWS4SignerType"));
        map.put(Media.TYPE_AUDIO, new SignerConfig("AWS4SignerType"));
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, new SignerConfig("AWS4SignerType"));
        map.put("snap", new SignerConfig("AWS4SignerType"));
        map.put(MIME.ENC_BINARY, new SignerConfig("AWS4SignerType"));
        return map;
    }

    private static SignerConfig getDefaultSigner() {
        return new SignerConfig("AWS4SignerType");
    }

    private static Map<String, HttpClientConfig> getOverrideHttpClients() {
        return new HashMap();
    }

    private static Map<String, SignerConfig> getOverrideRegionSigners() {
        return new HashMap();
    }

    private static Map<String, SignerConfig> getOverrideServiceRegionSigners() {
        return new HashMap();
    }

    private static Map<String, SignerConfig> getOverrideServiceSigners() {
        return new HashMap();
    }

    public HttpClientConfig getHttpClientConfig(String str) {
        return this.httpClients.get(str);
    }

    public SignerConfig getSignerConfig(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (str2 != null) {
            SignerConfig signerConfig = this.serviceRegionSigners.get(str + "/" + str2);
            if (signerConfig != null) {
                return signerConfig;
            }
            SignerConfig signerConfig2 = this.regionSigners.get(str2);
            if (signerConfig2 != null) {
                return signerConfig2;
            }
        }
        SignerConfig signerConfig3 = this.serviceSigners.get(str);
        return signerConfig3 == null ? this.defaultSignerConfig : signerConfig3;
    }
}
