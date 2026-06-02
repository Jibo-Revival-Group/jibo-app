package com.amazonaws.metrics;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.metrics.MetricCollector;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSServiceMetrics;
import com.jibo.aws.integration.util.C0977a;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public enum AwsSdkMetrics {
    ;

    private static final String MBEAN_OBJECT_NAME = "com.amazonaws.management:type=" + AwsSdkMetrics.class.getSimpleName();
    private static volatile String credentialFile;
    private static volatile AWSCredentialsProvider credentialProvider;
    private static final boolean defaultMetricsEnabled;
    private static boolean dirtyEnabling;
    private static volatile String hostMetricName;
    private static volatile String jvmMetricName;
    private static volatile boolean machineMetricsExcluded;

    /* JADX INFO: renamed from: mc */
    private static volatile MetricCollector f4645mc;
    private static volatile String metricNameSpace;
    private static volatile Integer metricQueueSize;
    private static volatile boolean perHostMetricsIncluded;
    private static volatile Long queuePollTimeoutMilli;
    private static volatile Regions region;
    private static final MetricRegistry registry;
    private static volatile boolean singleMetricNamespace;

    /* JADX WARN: Type inference failed for: r0v10, types: [com.amazonaws.metrics.AwsSdkMetrics$MetricRegistry] */
    static {
        metricNameSpace = "AWSSDK/Java";
        String property = System.getProperty("com.amazonaws.sdk.enableDefaultMetrics");
        defaultMetricsEnabled = property != null;
        if (defaultMetricsEnabled) {
            String[] strArrSplit = property.split(",");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (String str : strArrSplit) {
                String strTrim = str.trim();
                if (!z3 && "excludeMachineMetrics".equals(strTrim)) {
                    z3 = true;
                } else if (!z2 && "includePerHostMetrics".equals(strTrim)) {
                    z2 = true;
                } else if (z || !"useSingleMetricNamespace".equals(strTrim)) {
                    String[] strArrSplit2 = strTrim.split("=");
                    if (strArrSplit2.length == 2) {
                        String strTrim2 = strArrSplit2[0].trim();
                        String strTrim3 = strArrSplit2[1].trim();
                        try {
                            if ("credentialFile".equals(strTrim2)) {
                                setCredentialFile0(strTrim3);
                            } else if ("cloudwatchRegion".equals(strTrim2)) {
                                region = Regions.fromName(strTrim3);
                            } else if ("metricQueueSize".equals(strTrim2)) {
                                Integer num = new Integer(strTrim3);
                                if (num.intValue() < 1) {
                                    throw new IllegalArgumentException("metricQueueSize must be at least 1");
                                }
                                metricQueueSize = num;
                            } else if ("getQueuePollTimeoutMilli".equals(strTrim2)) {
                                Long l = new Long(strTrim3);
                                if (l.intValue() < 1000) {
                                    throw new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
                                }
                                queuePollTimeoutMilli = l;
                            } else if ("metricNameSpace".equals(strTrim2)) {
                                metricNameSpace = strTrim3;
                            } else if ("jvmMetricName".equals(strTrim2)) {
                                jvmMetricName = strTrim3;
                            } else if ("hostMetricName".equals(strTrim2)) {
                                hostMetricName = strTrim3;
                            } else {
                                C0977a.m10072a(AwsSdkMetrics.class.getSimpleName(), "Ignoring unrecognized parameter: " + strTrim);
                            }
                        } catch (Exception e) {
                            C0977a.m10073a(AwsSdkMetrics.class.getSimpleName(), "Ignoring failure", e);
                        }
                    } else {
                        continue;
                    }
                } else {
                    z = true;
                }
            }
            machineMetricsExcluded = z3;
            perHostMetricsIncluded = z2;
            singleMetricNamespace = z;
        }
        registry = new Object() { // from class: com.amazonaws.metrics.AwsSdkMetrics.MetricRegistry
            private final Set<MetricType> metricTypes = new HashSet();
            private volatile Set<MetricType> readOnly;

            {
                this.metricTypes.add(AWSRequestMetrics.Field.ClientExecuteTime);
                this.metricTypes.add(AWSRequestMetrics.Field.Exception);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpClientRetryCount);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpRequestTime);
                this.metricTypes.add(AWSRequestMetrics.Field.RequestCount);
                this.metricTypes.add(AWSRequestMetrics.Field.RetryCount);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolAvailableCount);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolLeasedCount);
                this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolPendingCount);
                this.metricTypes.add(AWSServiceMetrics.HttpClientGetConnectionTime);
                syncReadOnly();
            }

            private void syncReadOnly() {
                this.readOnly = Collections.unmodifiableSet(new HashSet(this.metricTypes));
            }
        };
    }

    public static synchronized boolean enableDefaultMetrics() {
        MetricCollector factory;
        boolean z;
        if (f4645mc != null && f4645mc.isEnabled()) {
            z = false;
        } else {
            if (dirtyEnabling) {
                throw new IllegalStateException("Reentrancy is not allowed");
            }
            dirtyEnabling = true;
            try {
                try {
                    factory = ((MetricCollector.Factory) Class.forName("com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory").newInstance()).getInstance();
                } catch (Exception e) {
                    C0977a.m10077c(AwsSdkMetrics.class.getSimpleName(), "Failed to enable the default metrics", e);
                    dirtyEnabling = false;
                }
                if (factory != null) {
                    setMetricCollector(factory);
                    dirtyEnabling = false;
                    z = true;
                } else {
                    dirtyEnabling = false;
                    z = false;
                }
            } catch (Throwable th) {
                dirtyEnabling = false;
                throw th;
            }
        }
        return z;
    }

    public static <T extends RequestMetricCollector> T getRequestMetricCollector() {
        if (f4645mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return f4645mc == null ? (T) RequestMetricCollector.NONE : (T) f4645mc.getRequestMetricCollector();
    }

    public static boolean isDefaultMetricsEnabled() {
        return defaultMetricsEnabled;
    }

    private static void setCredentialFile0(String str) {
        final PropertiesCredentials propertiesCredentials = new PropertiesCredentials(new File(str));
        synchronized (AwsSdkMetrics.class) {
            credentialProvider = new AWSCredentialsProvider() { // from class: com.amazonaws.metrics.AwsSdkMetrics.1
                @Override // com.amazonaws.auth.AWSCredentialsProvider
                public AWSCredentials getCredentials() {
                    return propertiesCredentials;
                }
            };
            credentialFile = str;
        }
    }

    public static synchronized void setMetricCollector(MetricCollector metricCollector) {
        MetricCollector metricCollector2 = f4645mc;
        f4645mc = metricCollector;
        if (metricCollector2 != null) {
            metricCollector2.stop();
        }
    }
}
