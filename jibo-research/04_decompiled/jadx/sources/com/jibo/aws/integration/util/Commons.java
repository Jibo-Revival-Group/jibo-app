package com.jibo.aws.integration.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class Commons {
    public static final String DEFAULT_DOMAIN = "jibo.com";
    public static final int MAX_LOOP_MEMBERS = 16;
    public static final String TARGET_PREFIX_ACCOUNT = "Account_20151111.";
    public static final String TARGET_PREFIX_ACCOUNT_ADMIN = "Account_20151111.";
    public static final String TARGET_PREFIX_AUDIO = "Audio_20151103.";
    public static final String TARGET_PREFIX_BINARY = "Binary_20151201.";
    public static final String TARGET_PREFIX_COLLISION = "Collision_20161126.";
    public static final String TARGET_PREFIX_GQA = "GQA_20160930s.";
    public static final String TARGET_PREFIX_JOT = "Jot_20160126.";
    public static final String TARGET_PREFIX_KEY = "Key_20160201.";
    public static final String TARGET_PREFIX_LOOP = "Loop_20160324.";
    public static final String TARGET_PREFIX_MEDIA = "Media_20160725.";
    public static final String TARGET_PREFIX_NOTIFICATION = "Notification_20150505.";
    public static final String TARGET_PREFIX_OOBE = "OOBE_20161026.";
    public static final String TARGET_PREFIX_PERSON = "Person_20160801.";
    public static final String TARGET_PREFIX_PHOTO = "Photo_20151103.";
    public static final String TARGET_PREFIX_PLACEHOLDER = "$TARGET$.";
    public static final String TARGET_PREFIX_PUSH = "Push_20160729.";
    public static final String TARGET_PREFIX_RELATIONSHIPS = "Relationships_20160118.";
    public static final String TARGET_PREFIX_ROBOT_PROPS = "RobotProperties_20160225.";
    public static final String TARGET_PREFIX_SKILLS = "Settings_20171219.";
    public static final String TARGET_PREFIX_SNAP = "Snap_20160103.";
    public static final String TARGET_PREFIX_VOICE_TRAINING = "VoiceTraining_20151103.";
    public static boolean _DEBUG_LOG_OUTPUT = false;
    public static final String STG_ENDPOINT = "stg-entrypoint.jibo.com";
    public static final String DEV_ENDPOINT = "dev-entrypoint.jibo.com";
    public static final String API_ENDPOINT = "api.jibo.com";
    public static final String ALPHA_ENDPOINT = "alpha-entrypoint.jibo.com";
    public static final String NETPOSA_1_ENDPOINT = "https://jibo-dev.ling.cn";
    public static final String NETPOSA_2_ENDPOINT = "https://jibo.ling.cn";
    public static final String[] ALLOWED_ENDPOINTS = {STG_ENDPOINT, DEV_ENDPOINT, API_ENDPOINT, ALPHA_ENDPOINT, NETPOSA_1_ENDPOINT, NETPOSA_2_ENDPOINT};
    public static String ROOT_ENDPOINT = STG_ENDPOINT;
    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    public static final Pattern REAL_NUMBER_PATTERN = Pattern.compile("[+-]?(?=\\d*[.eE])(?=\\.?\\d)\\d*\\.?\\d*(?:[eE][+-]?\\d+)?");

    public interface AsyncCallback<RESULT> {
        void onError(Exception exc);

        void onSuccess(RESULT result);
    }

    public static String convertStreamToString(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }

    public static void setRootEndpoint(String str) {
        ROOT_ENDPOINT = str;
    }

    public static String streamToString(InputStream inputStream, int i) throws Throwable {
        InputStreamReader inputStreamReader;
        char[] cArr = new char[i];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, HTTP.UTF_8);
            while (true) {
                try {
                    int i2 = inputStreamReader.read(cArr, 0, cArr.length);
                    if (i2 < 0) {
                        break;
                    }
                    sb.append(cArr, 0, i2);
                } catch (UnsupportedEncodingException e) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    inputStreamReader2 = inputStreamReader;
                    th = th;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e6) {
                }
            }
        } catch (UnsupportedEncodingException e7) {
            inputStreamReader = null;
        } catch (IOException e8) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return sb.toString();
    }
}
