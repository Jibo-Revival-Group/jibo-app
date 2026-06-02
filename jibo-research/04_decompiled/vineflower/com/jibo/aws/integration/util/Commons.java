package com.jibo.aws.integration.util;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Commons {
   public static final String[] ALLOWED_ENDPOINTS = new String[]{
      "stg-entrypoint.jibo.com", "dev-entrypoint.jibo.com", "api.jibo.com", "alpha-entrypoint.jibo.com", "https://jibo-dev.ling.cn", "https://jibo.ling.cn"
   };
   public static final String ALPHA_ENDPOINT = "alpha-entrypoint.jibo.com";
   public static final String API_ENDPOINT = "api.jibo.com";
   public static final String DEFAULT_DOMAIN = "jibo.com";
   public static final String DEV_ENDPOINT = "dev-entrypoint.jibo.com";
   public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
      "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
   );
   public static final int MAX_LOOP_MEMBERS = 16;
   public static final String NETPOSA_1_ENDPOINT = "https://jibo-dev.ling.cn";
   public static final String NETPOSA_2_ENDPOINT = "https://jibo.ling.cn";
   public static final Pattern REAL_NUMBER_PATTERN = Pattern.compile("[+-]?(?=\\d*[.eE])(?=\\.?\\d)\\d*\\.?\\d*(?:[eE][+-]?\\d+)?");
   public static String ROOT_ENDPOINT = "stg-entrypoint.jibo.com";
   public static final String STG_ENDPOINT = "stg-entrypoint.jibo.com";
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

   public static String convertStreamToString(InputStream var0) {
      Scanner var1 = new Scanner(var0).useDelimiter("\\A");
      String var2;
      if (var1.hasNext()) {
         var2 = var1.next();
      } else {
         var2 = "";
      }

      return var2;
   }

   public static void setRootEndpoint(String var0) {
      ROOT_ENDPOINT = var0;
   }

   public static String streamToString(InputStream param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: iload 1
      // 01: newarray 5
      // 03: astore 5
      // 05: new java/lang/StringBuilder
      // 08: dup
      // 09: invokespecial java/lang/StringBuilder.<init> ()V
      // 0c: astore 4
      // 0e: aconst_null
      // 0f: astore 3
      // 10: new java/io/InputStreamReader
      // 13: astore 2
      // 14: aload 2
      // 15: aload 0
      // 16: ldc "UTF-8"
      // 18: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;Ljava/lang/String;)V
      // 1b: aload 2
      // 1c: aload 5
      // 1e: bipush 0
      // 1f: aload 5
      // 21: arraylength
      // 22: invokevirtual java/io/InputStreamReader.read ([CII)I
      // 25: istore 1
      // 26: iload 1
      // 27: ifge 38
      // 2a: aload 2
      // 2b: ifnull 32
      // 2e: aload 2
      // 2f: invokevirtual java/io/InputStreamReader.close ()V
      // 32: aload 4
      // 34: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 37: areturn
      // 38: aload 4
      // 3a: aload 5
      // 3c: bipush 0
      // 3d: iload 1
      // 3e: invokevirtual java/lang/StringBuilder.append ([CII)Ljava/lang/StringBuilder;
      // 41: pop
      // 42: goto 1b
      // 45: astore 0
      // 46: aload 2
      // 47: ifnull 32
      // 4a: aload 2
      // 4b: invokevirtual java/io/InputStreamReader.close ()V
      // 4e: goto 32
      // 51: astore 0
      // 52: goto 32
      // 55: astore 0
      // 56: aconst_null
      // 57: astore 2
      // 58: aload 2
      // 59: ifnull 32
      // 5c: aload 2
      // 5d: invokevirtual java/io/InputStreamReader.close ()V
      // 60: goto 32
      // 63: astore 0
      // 64: goto 32
      // 67: astore 0
      // 68: aload 3
      // 69: astore 2
      // 6a: aload 2
      // 6b: ifnull 72
      // 6e: aload 2
      // 6f: invokevirtual java/io/InputStreamReader.close ()V
      // 72: aload 0
      // 73: athrow
      // 74: astore 0
      // 75: goto 32
      // 78: astore 2
      // 79: goto 72
      // 7c: astore 0
      // 7d: goto 6a
      // 80: astore 0
      // 81: goto 58
      // 84: astore 0
      // 85: aconst_null
      // 86: astore 2
      // 87: goto 46
      // try (9 -> 15): 73 java/io/UnsupportedEncodingException
      // try (9 -> 15): 46 java/io/IOException
      // try (9 -> 15): 56 null
      // try (15 -> 22): 38 java/io/UnsupportedEncodingException
      // try (15 -> 22): 71 java/io/IOException
      // try (15 -> 22): 69 null
      // try (26 -> 28): 65 java/io/IOException
      // try (31 -> 37): 38 java/io/UnsupportedEncodingException
      // try (31 -> 37): 71 java/io/IOException
      // try (31 -> 37): 69 null
      // try (41 -> 43): 44 java/io/IOException
      // try (51 -> 53): 54 java/io/IOException
      // try (61 -> 63): 67 java/io/IOException
   }

   public interface AsyncCallback<RESULT> {
      void onError(Exception var1);

      void onSuccess(RESULT var1);
   }
}
