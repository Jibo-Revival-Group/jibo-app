package com.jibo.ui.fragment.onboarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;
import com.jibo.aws.integration.aws.services.gqa.model.QuestionRequest;
import com.jibo.aws.integration.aws.services.loop.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.RobotAccount;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.service.KeyRequestingSharingService;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;
import java.util.ArrayList;
import java.util.List;

public class DevSettingsFragment extends BaseFragment {
   public static final String a = DevSettingsFragment.class.getSimpleName();
   private int b = 0;
   @BindView
   Button buttonSetEndpoint;
   private GestureDetectorCompat c;
   @BindView
   TextView current_endpoint;
   private List<Loop> d = new ArrayList<>();
   @BindView
   EditText endpointEdit;
   @BindView
   Spinner endpointSpinner;
   @BindView
   Spinner gqaLoopsSpinner;
   @BindView
   Spinner loops1Spinner;
   @BindView
   Spinner loopsSpinner;
   @BindView
   EditText questionEdit;
   @BindView
   TextView responseText;
   @BindView
   Spinner suspensionLoopSpinner;
   @BindView
   Switch switchEncryption;
   @BindView
   TextView textVersion;
   @BindView
   TextView ugcKeyText;
   @BindView
   Spinner ugcLoopSpinner;

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @OnClick
   public void logout(View var1) {
      if (this.getActivity() instanceof OnBoardingActivity) {
         ((JiboApplication)this.getActivity().getApplication()).b();
         ((OnBoardingActivity)this.getActivity()).q();
      } else {
         this.getActivity().setResult(TabbedActivity.c);
         this.getActivity().finish();
      }
   }

   @Override
   protected String o() {
      return "Debug Screen";
   }

   @OnClick
   public void onBtnGenerateKeyClick(View var1) {
      KeyManager var3 = KeyManager.getInstance(this.getActivity(), EntityData.a(this.getActivity()).i().getId());

      try {
         var3.generateSymmetricKey(this.getActivity(), this.d.get(this.loops1Spinner.getSelectedItemPosition()).getId(), true);
      } catch (Exception var2) {
         LogUtils.b(a, "Could not generate key", var2);
         Crashlytics.a(var2);
      }
   }

   @OnClick
   public void onBtnListAttributions(View var1) {
      new DevSettingsFragment.ListAttributionsAsyncTask(this).execute(new Void[0]);
   }

   @OnClick
   public void onBtnRequestKeyClick(View var1) {
      Intent var2 = new Intent(this.getActivity(), KeyRequestingSharingService.class);
      var2.setAction("ACTION_REQUEST_KEY");
      var2.putExtra("loopId", this.d.get(this.loopsSpinner.getSelectedItemPosition()).getId());
      ServiceUtils.a(this.getActivity(), var2);
   }

   @OnClick
   public void onBtnSendQuestion(View var1) {
      String var2 = this.questionEdit.getText().toString();
      Loop var3 = this.d.get(this.gqaLoopsSpinner.getSelectedItemPosition());
      EntityData.a(this.getContext()).b().getRobot(var3.getId(), new AsyncHandler<GetRobotRequest, RobotAccount>(this, var2) {
         final String a;
         final DevSettingsFragment b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void a(GetRobotRequest var1, RobotAccount var2x) {
            JiboGQAAsyncClient var3x = new JiboGQAAsyncClient(new BasicAWSCredentials(var2x.getAccessKeyId(), var2x.getSecretAccessKey()));
            var3x.setEndpoint("dev-entrypoint.jibo.com");
            var3x.sendQuestion(this.a, new AsyncHandler<QuestionRequest, GQAAttribution>(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               public void a(QuestionRequest var1, GQAAttribution var2x) {
                  this.a.b.a(new Runnable(this, var2x) {
                     final GQAAttribution a;
                     final <unrepresentable> b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     @Override
                     public void run() {
                        this.b.a.b.responseText.setText(this.a.toString());
                        Animation var1x = AnimationUtils.loadAnimation(this.b.a.b.getActivity(), 2130771980);
                        this.b.a.b.responseText.startAnimation(var1x);
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.a.b.a(new Runnable(this, var1) {
                     final Exception a;
                     final <unrepresentable> b;

                     {
                        this.b = var1;
                        this.a = var2x;
                     }

                     @Override
                     public void run() {
                        Toast.makeText(this.b.a.b.getContext(), this.a.getMessage(), 1).show();
                     }
                  });
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.b.a(new Runnable(this, var1) {
               final Exception a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  Toast.makeText(this.b.b.getContext(), this.a.getMessage(), 1).show();
               }
            });
         }
      });
   }

   @OnClick
   public void onBtnSuspendLoopClick(View var1) {
      LoopHelper.suspendLoop(this.d.get(this.suspensionLoopSpinner.getSelectedItemPosition()).getId(), new Commons.AsyncCallback<Object>(this) {
         final DevSettingsFragment a;

         {
            this.a = var1;
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(new Runnable(this, var1) {
               final Exception a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               @Override
               public void run() {
                  Toast.makeText(this.b.a.getContext(), this.a.getMessage(), 1).show();
               }
            });
         }

         @Override
         public void onSuccess(Object var1) {
            Toast.makeText(this.a.getContext(), "Loop has been suspended", 1).show();
         }
      });
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427432, var2, false);
   }

   @Override
   public void onViewCreated(View param1, Bundle param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: aload 1
      // 002: aload 2
      // 003: invokespecial com/jibo/ui/fragment/BaseFragment.onViewCreated (Landroid/view/View;Landroid/os/Bundle;)V
      // 006: aload 0
      // 007: new android/support/v4/view/GestureDetectorCompat
      // 00a: dup
      // 00b: aload 0
      // 00c: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 00f: new com/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener
      // 012: dup
      // 013: aload 0
      // 014: invokespecial com/jibo/ui/fragment/onboarding/DevSettingsFragment$MyGestureListener.<init> (Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
      // 017: invokespecial android/support/v4/view/GestureDetectorCompat.<init> (Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V
      // 01a: putfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.c Landroid/support/v4/view/GestureDetectorCompat;
      // 01d: aload 0
      // 01e: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.endpointSpinner Landroid/widget/Spinner;
      // 021: new android/widget/ArrayAdapter
      // 024: dup
      // 025: aload 0
      // 026: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 029: ldc_w 2131427532
      // 02c: getstatic com/jibo/aws/integration/util/Commons.ALLOWED_ENDPOINTS [Ljava/lang/String;
      // 02f: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;I[Ljava/lang/Object;)V
      // 032: invokevirtual android/widget/Spinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 035: aload 0
      // 036: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 039: aload 0
      // 03a: ldc_w 2131755063
      // 03d: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getString (I)Ljava/lang/String;
      // 040: bipush 0
      // 041: invokevirtual android/support/v4/app/FragmentActivity.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 044: astore 2
      // 045: aload 2
      // 046: ldc_w "PREF_END_POINT"
      // 049: getstatic com/jibo/aws/integration/util/Commons.ROOT_ENDPOINT Ljava/lang/String;
      // 04c: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 051: astore 1
      // 052: bipush 0
      // 053: istore 3
      // 054: iload 3
      // 055: getstatic com/jibo/aws/integration/util/Commons.ALLOWED_ENDPOINTS [Ljava/lang/String;
      // 058: arraylength
      // 059: if_icmpge 06d
      // 05c: getstatic com/jibo/aws/integration/util/Commons.ALLOWED_ENDPOINTS [Ljava/lang/String;
      // 05f: iload 3
      // 060: aaload
      // 061: aload 1
      // 062: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 065: ifeq 22b
      // 068: aload 0
      // 069: iload 3
      // 06a: putfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.b I
      // 06d: aload 0
      // 06e: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.endpointSpinner Landroid/widget/Spinner;
      // 071: aload 0
      // 072: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.b I
      // 075: bipush 0
      // 076: invokevirtual android/widget/Spinner.setSelection (IZ)V
      // 079: aload 0
      // 07a: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.endpointSpinner Landroid/widget/Spinner;
      // 07d: new com/jibo/ui/fragment/onboarding/DevSettingsFragment$1
      // 080: dup
      // 081: aload 0
      // 082: aload 2
      // 083: invokespecial com/jibo/ui/fragment/onboarding/DevSettingsFragment$1.<init> (Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/content/SharedPreferences;)V
      // 086: invokevirtual android/widget/Spinner.setOnItemSelectedListener (Landroid/widget/AdapterView$OnItemSelectedListener;)V
      // 089: aload 0
      // 08a: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.current_endpoint Landroid/widget/TextView;
      // 08d: aload 2
      // 08e: ldc_w "PREF_END_POINT"
      // 091: getstatic com/jibo/aws/integration/util/Commons.ROOT_ENDPOINT Ljava/lang/String;
      // 094: invokeinterface android/content/SharedPreferences.getString (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 099: invokevirtual android/widget/TextView.setText (Ljava/lang/CharSequence;)V
      // 09c: aload 0
      // 09d: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.textVersion Landroid/widget/TextView;
      // 0a0: new java/lang/StringBuilder
      // 0a3: dup
      // 0a4: invokespecial java/lang/StringBuilder.<init> ()V
      // 0a7: ldc_w "Version: "
      // 0aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ad: aload 0
      // 0ae: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 0b1: invokestatic com/jibo/utils/Util.a (Landroid/content/Context;)Ljava/lang/String;
      // 0b4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b7: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ba: invokevirtual android/widget/TextView.setText (Ljava/lang/CharSequence;)V
      // 0bd: aload 2
      // 0be: ldc_w "PREF_ENCRYPTION_ENABLED"
      // 0c1: bipush 1
      // 0c2: invokeinterface android/content/SharedPreferences.getBoolean (Ljava/lang/String;Z)Z 3
      // 0c7: istore 4
      // 0c9: aload 0
      // 0ca: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.switchEncryption Landroid/widget/Switch;
      // 0cd: iload 4
      // 0cf: invokevirtual android/widget/Switch.setChecked (Z)V
      // 0d2: aload 0
      // 0d3: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.switchEncryption Landroid/widget/Switch;
      // 0d6: new com/jibo/ui/fragment/onboarding/DevSettingsFragment$3
      // 0d9: dup
      // 0da: aload 0
      // 0db: aload 2
      // 0dc: invokespecial com/jibo/ui/fragment/onboarding/DevSettingsFragment$3.<init> (Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;Landroid/content/SharedPreferences;)V
      // 0df: invokevirtual android/widget/Switch.setOnCheckedChangeListener (Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
      // 0e2: new java/util/ArrayList
      // 0e5: dup
      // 0e6: invokespecial java/util/ArrayList.<init> ()V
      // 0e9: astore 6
      // 0eb: aload 0
      // 0ec: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 0ef: invokevirtual android/support/v4/app/FragmentActivity.getContentResolver ()Landroid/content/ContentResolver;
      // 0f2: bipush 8
      // 0f4: invokestatic com/jibo/db/DatabaseContract$EntityEntry.a (I)Landroid/net/Uri;
      // 0f7: getstatic com/jibo/db/DatabaseContract$EntityEntry.a [Ljava/lang/String;
      // 0fa: aconst_null
      // 0fb: aconst_null
      // 0fc: ldc_w "_id"
      // 0ff: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 102: astore 2
      // 103: aload 2
      // 104: ifnull 231
      // 107: aload 2
      // 108: astore 1
      // 109: aload 2
      // 10a: invokeinterface android/database/Cursor.isClosed ()Z 1
      // 10f: ifne 231
      // 112: aload 2
      // 113: astore 1
      // 114: aload 2
      // 115: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 11a: ifeq 231
      // 11d: aload 2
      // 11e: astore 1
      // 11f: aload 2
      // 120: invokeinterface android/database/Cursor.isAfterLast ()Z 1
      // 125: ifne 231
      // 128: aload 2
      // 129: astore 1
      // 12a: aload 0
      // 12b: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.d Ljava/util/List;
      // 12e: aload 2
      // 12f: invokestatic com/jibo/db/EntityData.a (Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
      // 132: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 137: pop
      // 138: aload 2
      // 139: astore 1
      // 13a: aload 6
      // 13c: aload 0
      // 13d: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.d Ljava/util/List;
      // 140: aload 0
      // 141: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.d Ljava/util/List;
      // 144: invokeinterface java/util/List.size ()I 1
      // 149: bipush 1
      // 14a: isub
      // 14b: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 150: checkcast com/jibo/aws/integration/aws/services/loop/model/Loop
      // 153: invokevirtual com/jibo/aws/integration/aws/services/loop/model/Loop.getName ()Ljava/lang/String;
      // 156: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 15b: pop
      // 15c: aload 2
      // 15d: astore 1
      // 15e: aload 2
      // 15f: invokeinterface android/database/Cursor.moveToNext ()Z 1
      // 164: pop
      // 165: goto 11d
      // 168: astore 5
      // 16a: aload 2
      // 16b: astore 1
      // 16c: aload 5
      // 16e: invokestatic com/crashlytics/android/Crashlytics.a (Ljava/lang/Throwable;)V
      // 171: aload 2
      // 172: ifnull 17b
      // 175: aload 2
      // 176: invokeinterface android/database/Cursor.close ()V 1
      // 17b: aload 0
      // 17c: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.loopsSpinner Landroid/widget/Spinner;
      // 17f: new android/widget/ArrayAdapter
      // 182: dup
      // 183: aload 0
      // 184: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 187: ldc_w 2131427532
      // 18a: aload 6
      // 18c: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;ILjava/util/List;)V
      // 18f: invokevirtual android/widget/Spinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 192: aload 0
      // 193: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.loopsSpinner Landroid/widget/Spinner;
      // 196: bipush 0
      // 197: bipush 0
      // 198: invokevirtual android/widget/Spinner.setSelection (IZ)V
      // 19b: aload 0
      // 19c: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.loops1Spinner Landroid/widget/Spinner;
      // 19f: new android/widget/ArrayAdapter
      // 1a2: dup
      // 1a3: aload 0
      // 1a4: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 1a7: ldc_w 2131427532
      // 1aa: aload 6
      // 1ac: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;ILjava/util/List;)V
      // 1af: invokevirtual android/widget/Spinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 1b2: aload 0
      // 1b3: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.loops1Spinner Landroid/widget/Spinner;
      // 1b6: bipush 0
      // 1b7: bipush 0
      // 1b8: invokevirtual android/widget/Spinner.setSelection (IZ)V
      // 1bb: aload 0
      // 1bc: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.gqaLoopsSpinner Landroid/widget/Spinner;
      // 1bf: new android/widget/ArrayAdapter
      // 1c2: dup
      // 1c3: aload 0
      // 1c4: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 1c7: ldc_w 2131427532
      // 1ca: aload 6
      // 1cc: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;ILjava/util/List;)V
      // 1cf: invokevirtual android/widget/Spinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 1d2: aload 0
      // 1d3: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.gqaLoopsSpinner Landroid/widget/Spinner;
      // 1d6: bipush 0
      // 1d7: bipush 0
      // 1d8: invokevirtual android/widget/Spinner.setSelection (IZ)V
      // 1db: aload 0
      // 1dc: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.ugcLoopSpinner Landroid/widget/Spinner;
      // 1df: new android/widget/ArrayAdapter
      // 1e2: dup
      // 1e3: aload 0
      // 1e4: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 1e7: ldc_w 2131427532
      // 1ea: aload 6
      // 1ec: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;ILjava/util/List;)V
      // 1ef: invokevirtual android/widget/Spinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 1f2: aload 0
      // 1f3: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.ugcLoopSpinner Landroid/widget/Spinner;
      // 1f6: new com/jibo/ui/fragment/onboarding/DevSettingsFragment$4
      // 1f9: dup
      // 1fa: aload 0
      // 1fb: invokespecial com/jibo/ui/fragment/onboarding/DevSettingsFragment$4.<init> (Lcom/jibo/ui/fragment/onboarding/DevSettingsFragment;)V
      // 1fe: invokevirtual android/widget/Spinner.setOnItemSelectedListener (Landroid/widget/AdapterView$OnItemSelectedListener;)V
      // 201: aload 0
      // 202: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.ugcLoopSpinner Landroid/widget/Spinner;
      // 205: bipush 0
      // 206: bipush 0
      // 207: invokevirtual android/widget/Spinner.setSelection (IZ)V
      // 20a: aload 0
      // 20b: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.suspensionLoopSpinner Landroid/widget/Spinner;
      // 20e: new android/widget/ArrayAdapter
      // 211: dup
      // 212: aload 0
      // 213: invokevirtual com/jibo/ui/fragment/onboarding/DevSettingsFragment.getActivity ()Landroid/support/v4/app/FragmentActivity;
      // 216: ldc_w 2131427532
      // 219: aload 6
      // 21b: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;ILjava/util/List;)V
      // 21e: invokevirtual android/widget/Spinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 221: aload 0
      // 222: getfield com/jibo/ui/fragment/onboarding/DevSettingsFragment.suspensionLoopSpinner Landroid/widget/Spinner;
      // 225: bipush 0
      // 226: bipush 0
      // 227: invokevirtual android/widget/Spinner.setSelection (IZ)V
      // 22a: return
      // 22b: iinc 3 1
      // 22e: goto 054
      // 231: aload 2
      // 232: ifnull 17b
      // 235: aload 2
      // 236: invokeinterface android/database/Cursor.close ()V 1
      // 23b: goto 17b
      // 23e: astore 1
      // 23f: aconst_null
      // 240: astore 2
      // 241: aload 1
      // 242: astore 5
      // 244: aload 2
      // 245: ifnull 24e
      // 248: aload 2
      // 249: invokeinterface android/database/Cursor.close ()V 1
      // 24e: aload 5
      // 250: athrow
      // 251: astore 5
      // 253: aload 1
      // 254: astore 2
      // 255: goto 244
      // 258: astore 5
      // 25a: aconst_null
      // 25b: astore 2
      // 25c: goto 16a
      // try (108 -> 119): 279 java/lang/Exception
      // try (108 -> 119): 264 null
      // try (123 -> 126): 165 java/lang/Exception
      // try (123 -> 126): 275 null
      // try (128 -> 131): 165 java/lang/Exception
      // try (128 -> 131): 275 null
      // try (133 -> 136): 165 java/lang/Exception
      // try (133 -> 136): 275 null
      // try (138 -> 144): 165 java/lang/Exception
      // try (138 -> 144): 275 null
      // try (146 -> 159): 165 java/lang/Exception
      // try (146 -> 159): 275 null
      // try (161 -> 164): 165 java/lang/Exception
      // try (161 -> 164): 275 null
      // try (168 -> 170): 275 null
   }

   @OnClick
   public void setEndpoint(View var1) {
      String var2 = this.endpointEdit.getText().toString();
      if (TextUtils.isEmpty(var2)) {
         Toast.makeText(this.getContext(), "Endpoint must not be empty", 1).show();
      } else {
         SharedPreferences var3 = this.getActivity().getSharedPreferences(this.getString(2131755063), 0);
         Commons.setRootEndpoint(var2);
         var3.edit().putString("PREF_END_POINT", var2).apply();
         this.logout(null);
      }
   }

   @OnLongClick
   public boolean showDevSettings(View var1) {
      return true;
   }

   private class ListAttributionsAsyncTask extends AsyncTask<Void, Void, AttributionListResponse> {
      Loop a;
      final DevSettingsFragment b;

      private ListAttributionsAsyncTask(DevSettingsFragment var1) {
         this.b = var1;
      }

      protected AttributionListResponse a(Void... var1) {
         return EntityData.a(this.b.getContext()).c().listAttributions(this.a.getRobotFriendlyId(), 0L);
      }

      protected void a(AttributionListResponse var1) {
         super.onPostExecute(var1);
         this.b.responseText.setText(var1.toString());
         Animation var2 = AnimationUtils.loadAnimation(this.b.getActivity(), 2130771980);
         this.b.responseText.startAnimation(var2);
      }

      protected void onPreExecute() {
         this.a = this.b.d.get(this.b.gqaLoopsSpinner.getSelectedItemPosition());
         super.onPreExecute();
      }
   }

   public class MyGestureListener extends SimpleOnGestureListener {
      int a;
      float b;
      int c;
      final DevSettingsFragment d;

      public MyGestureListener(DevSettingsFragment var1) {
         this.d = var1;
         this.a = -14000;
         this.b = 0.0F;
         this.c = 0;
      }

      public boolean onDown(MotionEvent var1) {
         return true;
      }

      public boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
         this.b += var4;
         this.c++;
         if (var1 != null && var2 != null && var4 <= this.a) {
            this.d.showDevSettings(null);
         }

         return true;
      }
   }
}
