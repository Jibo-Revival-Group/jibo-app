package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.view.proxima.CustomFontEditText;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.Util;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class DialogUtils {
   public static void a(Fragment var0, int var1, Member var2, String var3, String var4, String var5) {
      Bundle var6 = new Bundle();
      var6.putString("ARGS_MESSAGE", var4);
      var6.putString("ARGS_TITLE", var3);
      var6.putString("ARGS_OK_TEXT", var5);
      var6.putParcelable(Member.class.getSimpleName(), var2);
      var6.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG_ADD_CHILD");
      DialogUtils.DialogFragmentWrapper.b(var6, var0, var0.getFragmentManager(), var1, "CONFIRMATION_DIALOG_ADD_CHILD");
   }

   public static void a(Fragment var0, int var1, String var2, int var3) {
      Bundle var4 = new Bundle();
      var4.putString("ARGS_TITLE", var2);
      var4.putInt("ARGS_CHOICES_RES", var3);
      var4.putSerializable("ARGS_TYPE", "SINGLE_CHOICE");
      DialogUtils.DialogFragmentWrapper.b(var4, var0, var1, "SINGLE_CHOICE");
   }

   public static void a(Fragment var0, int var1, String var2, int var3, int var4) {
      Bundle var5 = new Bundle();
      var5.putString("ARGS_TITLE", var2);
      var5.putInt("ARGS_CHOICES_RES", var3);
      var5.putInt("ARGS_CHOSEN_ITEM", var4);
      var5.putSerializable("ARGS_TYPE", "SINGLE_CHOICE_RADIO");
      DialogUtils.DialogFragmentWrapper.b(var5, var0, var1, "SINGLE_CHOICE_RADIO");
   }

   public static void a(Fragment var0, int var1, String var2, String var3) {
      a(var0, var0.getFragmentManager(), var1, var2, var3);
   }

   public static void a(Fragment var0, int var1, String var2, String var3, String var4) {
      Bundle var5 = new Bundle();
      var5.putString("ARGS_TITLE", var2);
      var5.putString("ARGS_MESSAGE", var3);
      var5.putString("ARGS_OK_TEXT", var4);
      var5.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG_GREY");
      DialogUtils.DialogFragmentWrapper.b(var5, var0, var1, "CONFIRMATION_DIALOG_GREY");
   }

   public static void a(Fragment var0, int var1, String var2, int[] var3, String[] var4) {
      Bundle var5 = new Bundle();
      var5.putSerializable("ARGS_TYPE", "BOTTOM_DIALOG");
      var5.putString("ARGS_TITLE", var2);
      var5.putIntArray("ARGS_CHOICES_RES", var3);
      var5.putStringArray("ARGS_CHOICES_ARRAY", var4);
      DialogUtils.DialogFragmentWrapper.b(var5, var0, var1, "BOTTOM_DIALOG");
   }

   public static void a(Fragment var0, FragmentManager var1, int var2, String var3, String var4) {
      Bundle var5 = new Bundle();
      var5.putString("ARGS_MESSAGE", var3);
      var5.putString("ARGS_OK_TEXT", var4);
      var5.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG");
      DialogUtils.DialogFragmentWrapper.b(var5, var0, var1, var2, "CONFIRMATION_DIALOG");
   }

   public static void a(Fragment var0, FragmentManager var1, int var2, String var3, String var4, String var5) {
      Bundle var6 = new Bundle();
      var6.putString("ARGS_MESSAGE", var4);
      var6.putString("ARGS_TITLE", var3);
      var6.putString("ARGS_OK_TEXT", var5);
      var6.putSerializable("ARGS_TYPE", "INFO_DIALOG");
      DialogUtils.DialogFragmentWrapper.b(var6, var0, var1, var2, "INFO_DIALOG");
   }

   public static void a(Fragment var0, FragmentManager var1, int var2, String var3, String var4, String var5, String var6) {
      Bundle var7 = new Bundle();
      var7.putString("ARGS_MESSAGE", var4);
      var7.putString("ARGS_TITLE", var3);
      var7.putString("ARGS_OK_TEXT", var5);
      var7.putString("ARGS_CANCEL_TEXT", var6);
      var7.putSerializable("ARGS_TYPE", "REGULAR");
      DialogUtils.DialogFragmentWrapper.b(var7, var0, var1, var2, "CONFIRMATION_DIALOG");
   }

   public static boolean a(FragmentManager var0) {
      boolean var4 = false;
      Field[] var5 = DialogUtils.DialogFragmentWrapper.DialogType.class.getDeclaredFields();
      int var2 = var5.length;
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         if (var0.a(var5[var1].getName()) != null) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   public static void b(Fragment var0, int var1, String var2, String var3) {
      a(var0, var1, "", var2, var3);
   }

   public static void b(Fragment var0, int var1, String var2, String var3, String var4) {
      a(var0, var0.getFragmentManager(), var1, var2, var3, var4);
   }

   public static void b(Fragment var0, FragmentManager var1, int var2, String var3, String var4) {
      Bundle var5 = new Bundle();
      var5.putString("ARGS_MESSAGE", var4);
      var5.putString("ARGS_TITLE", var3);
      var5.putSerializable("ARGS_TYPE", "INFO_DIALOG_MAINTENANCE");
      DialogUtils.DialogFragmentWrapper.b(var5, var0, var1, var2, "INFO_DIALOG_MAINTENANCE");
   }

   public static void c(Fragment var0, int var1, String var2, String var3) {
      b(var0, var0.getFragmentManager(), var1, var2, var3);
   }

   public static void c(Fragment var0, int var1, String var2, String var3, String var4) {
      Bundle var5 = new Bundle();
      var5.putString("ARGS_MESSAGE", var2);
      var5.putString("ARGS_OK_TEXT", var3);
      var5.putString("ARGS_CANCEL_TEXT", var4);
      var5.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG_GREY");
      DialogUtils.DialogFragmentWrapper.b(var5, var0, var1, "CONFIRMATION_DIALOG_GREY");
   }

   public static void c(Fragment var0, FragmentManager var1, int var2, String var3, String var4) {
      a(var0, var1, var2, var3, var4, null);
   }

   public static void d(Fragment var0, int var1, String var2, String var3) {
      a(var0, var0.getFragmentManager(), var1, var2, var3, null);
   }

   public static class DialogFragmentWrapper extends DialogFragment {
      private String a;
      private OnClickListener b = new OnClickListener(this) {
         final DialogUtils.DialogFragmentWrapper a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            var1.dismiss();
            this.a.a(this.a.getTargetRequestCode(), var2, null);
         }
      };

      private Dialog a(Context var1, Bundle var2, OnClickListener var3) {
         String var5 = var2.getString("ARGS_TITLE");
         int var4 = var2.getInt("ARGS_CHOICES_RES");
         AlertDialog.Builder var7 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var5)) {
            TextView var6 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var6.setText(var5);
            var7.a(var6);
         }

         var7.a(new ArrayAdapter(var1, 2131427635, Arrays.asList(var1.getResources().getStringArray(var4))), var3);
         return var7.b();
      }

      private Dialog a(Context var1, Bundle var2, Fragment var3) {
         String var10 = var2.getString("ARGS_MESSAGE");
         String var6 = var2.getString("ARGS_TITLE");
         String var4 = var2.getString("ARGS_OK_TEXT");
         String var5 = var2.getString("ARGS_CANCEL_TEXT");
         AlertDialog.Builder var9 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var6)) {
            TextView var7 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var7.setText(var6);
            var9.a(var7);
         }

         if (!TextUtils.isEmpty(var10)) {
            TextView var8 = (TextView)LayoutInflater.from(var1).inflate(2131427410, null);
            var8.setText(var10);
            var9.b(var8);
         }

         var9.a(var4, this.b);
         var9.b(var5, this.b);
         return var9.b();
      }

      private void a(int var1, int var2, Object var3) {
         if (this.getTargetFragment() != null && this.getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener) {
            ((DialogUtils.DialogFragmentWrapperClickListener)this.getTargetFragment()).a(var1, var2, var3);
         } else if (this.getActivity() instanceof DialogUtils.DialogFragmentWrapperClickListener) {
            ((DialogUtils.DialogFragmentWrapperClickListener)this.getActivity()).a(var1, var2, var3);
         }
      }

      private Dialog b(Context var1, Bundle var2, OnClickListener var3) {
         String var6 = var2.getString("ARGS_TITLE");
         int var5 = var2.getInt("ARGS_CHOICES_RES", -1);
         int var4 = var2.getInt("ARGS_CHOSEN_ITEM");
         List var9 = var2.getStringArrayList("ARGS_CHOICES_ARRAY");
         if (var5 != -1) {
            var9 = Arrays.asList(var1.getResources().getStringArray(var5));
         }

         AlertDialog.Builder var8 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var6)) {
            TextView var7 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var7.setText(var6);
            var8.a(var7);
         }

         var8.a(new ArrayAdapter(var1, 2131427636, var9), var4, var3);
         return var8.b();
      }

      private Dialog b(Context var1, Bundle var2, Fragment var3) {
         String var4 = var2.getString("ARGS_TITLE");
         AlertDialog.Builder var5 = new AlertDialog.Builder(var1);
         View var6 = LayoutInflater.from(var1).inflate(2131427401, null);
         var5.b(var6);
         var5.a(var4);
         var5.a(17039370, new OnClickListener(this, var6, var1) {
            final View a;
            final Context b;
            final DialogUtils.DialogFragmentWrapper c;

            {
               this.c = var1;
               this.a = var2x;
               this.b = var3x;
            }

            public void onClick(DialogInterface var1, int var2x) {
               if (-1 == var2x) {
                  String var3x = ((EditText)this.a.findViewById(2131296546)).getText().toString();
                  if (Util.a((CharSequence)var3x)) {
                     this.c.a(112, -1, var3x);
                     var1.dismiss();
                  } else {
                     ((TextInputLayout)this.a.findViewById(2131296680)).setError(this.b.getString(2131755305));
                  }
               }
            }
         });
         var5.b(17039360, null);
         return var5.b();
      }

      private static void b(Bundle var0, Fragment var1, int var2, String var3) {
         b(var0, var1, var1.getFragmentManager(), var2, var3);
      }

      private static void b(Bundle var0, Fragment var1, FragmentManager var2, int var3, String var4) {
         DialogUtils.DialogFragmentWrapper var5 = new DialogUtils.DialogFragmentWrapper();
         var5.setArguments(var0);
         var5.setTargetFragment(var1, var3);
         var5.show(var2, var4);
      }

      private Dialog c(Context var1, Bundle var2, OnClickListener var3) {
         String var4 = var2.getString("ARGS_MESSAGE");
         String var5 = var2.getString("ARGS_OK_TEXT");
         AlertDialog.Builder var7 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var4)) {
            TextView var6 = (TextView)LayoutInflater.from(var1).inflate(2131427411, null);
            var6.setText(var4);
            var7.b(var6);
         }

         var7.a(var5, var3);
         var7.b(17039360, null);
         return var7.b();
      }

      private Dialog c(Context var1, Bundle var2, Fragment var3) {
         String var5 = var2.getString("ARGS_TITLE");
         Account var9 = (Account)var2.getParcelable("ARGS_ACCOUNT");
         AlertDialog.Builder var4 = new AlertDialog.Builder(var1);
         TextView var6 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
         var6.setText(var5);
         var4.a(var6);
         var4.b(17039360, null);
         View var7 = LayoutInflater.from(var1).inflate(2131427403, null);
         var4.b(var7);
         EditText var11 = (EditText)var7.findViewById(2131296567);
         var11.setText(var9.getFirstName());
         EditText var10 = (EditText)var7.findViewById(2131296686);
         var10.setText(var9.getLastName());
         var11.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter()});
         var10.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter()});
         var4.a(2131755653, new OnClickListener(this, var7, var9, var3, var1) {
            final View a;
            final Account b;
            final Fragment c;
            final Context d;
            final DialogUtils.DialogFragmentWrapper e;

            {
               this.e = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5x;
            }

            public void onClick(DialogInterface var1, int var2x) {
               if (-1 == var2x) {
                  String var3x = ((EditText)this.a.findViewById(2131296567)).getText().toString().trim();
                  String var4x = ((EditText)this.a.findViewById(2131296686)).getText().toString().trim();
                  if (!TextUtils.isEmpty(var3x) && !TextUtils.isEmpty(var4x)) {
                     this.b.setFirstName(var3x);
                     this.b.setLastName(var4x);
                     var1.dismiss();
                     this.e.a(114, -1, null);
                     if (this.c.getActivity() instanceof SingleFragmentActivity) {
                        this.c.getActivity().setResult(-1);
                        ((SingleFragmentActivity)this.c.getActivity()).q().putExtra("NAME_CHANGED", this.b.getFullName());
                     }
                  } else if (TextUtils.isEmpty(var3x)) {
                     ((TextInputLayout)this.a.findViewById(2131296681)).setError(this.d.getString(2131755304));
                  } else {
                     ((TextInputLayout)this.a.findViewById(2131296682)).setError(this.d.getString(2131755304));
                  }
               }
            }
         });
         AlertDialog var8 = var4.b();
         var10.addTextChangedListener(new DialogUtils.DialogFragmentWrapper.DialogCheckForEmptyTextWatcher(this, var8));
         var11.addTextChangedListener(new DialogUtils.DialogFragmentWrapper.DialogCheckForEmptyTextWatcher(this, var8));
         return var8;
      }

      private Dialog d(Context var1, Bundle var2, OnClickListener var3) {
         String var4 = var2.getString("ARGS_TITLE");
         String var5 = var2.getString("ARGS_MESSAGE");
         String var6 = var2.getString("ARGS_OK_TEXT");
         String var9 = var2.getString("ARGS_CANCEL_TEXT", var1.getString(17039360));
         AlertDialog.Builder var7 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var4)) {
            TextView var8 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var8.setText(var4);
            var7.a(var8);
         }

         if (!TextUtils.isEmpty(var5)) {
            TextView var10 = (TextView)LayoutInflater.from(var1).inflate(2131427410, null);
            var10.setText(var5);
            if (TextUtils.isEmpty(var4)) {
               var10.setPadding(
                  var1.getResources().getDimensionPixelSize(2131165361),
                  var1.getResources().getDimensionPixelSize(2131165362),
                  var1.getResources().getDimensionPixelSize(2131165361),
                  0
               );
            }

            var7.b(var10);
         }

         var7.a(var6, var3);
         var7.b(var9, null);
         return var7.b();
      }

      private Dialog d(Context var1, Bundle var2, Fragment var3) {
         String var6 = var2.getString("ARGS_TITLE");
         String var4 = var2.getString("ARGS_NICKNAME");
         Loop var8 = (Loop)var2.getParcelable("ARGS_LOOP");
         AlertDialog.Builder var5 = new AlertDialog.Builder(var1);
         TextView var7 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
         var7.setText(var6);
         var5.a(var7);
         View var9 = LayoutInflater.from(var1).inflate(2131427415, null);
         ((EditText)var9.findViewById(2131296993)).setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new LengthFilter(20)});
         ((EditText)var9.findViewById(2131296993)).setHint(var1.getString(2131755553));
         if (!TextUtils.isEmpty(var4)) {
            ((EditText)var9.findViewById(2131296993)).setText(var4);
         }

         var5.b(var9);
         var5.b(17039360, null);
         var5.a(2131755653, new OnClickListener(this, var9, var8, var3, var1) {
            final View a;
            final Loop b;
            final Fragment c;
            final Context d;
            final DialogUtils.DialogFragmentWrapper e;

            {
               this.e = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5x;
            }

            public void onClick(DialogInterface var1, int var2x) {
               if (-1 == var2x) {
                  String var3x = ((EditText)this.a.findViewById(2131296993)).getText().toString().trim();
                  if (LoopHelper.checkPreferredNameError(this.b, var3x) == null) {
                     this.e.a(113, -1, var3x);
                     var1.dismiss();
                     this.c.getActivity().setResult(-1);
                  } else {
                     ((TextInputLayout)this.a.findViewById(2131296683)).setError(this.d.getString(2131755303));
                  }
               }
            }
         });
         return var5.b();
      }

      private Dialog e(Context var1, Bundle var2, OnClickListener var3) {
         String var6 = var2.getString("ARGS_TITLE");
         String var5 = var2.getString("ARGS_MESSAGE");
         String var4 = var2.getString("ARGS_OK_TEXT");
         String var10 = var5;
         if (TextUtils.isEmpty(var5)) {
            var10 = "";
         }

         Spanned var12 = Html.fromHtml(var10);
         AlertDialog.Builder var11 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var6)) {
            TextView var7 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var7.setText(var6);
            var11.a(var7);
         }

         if (!TextUtils.isEmpty(var12)) {
            TextView var8 = (TextView)LayoutInflater.from(var1).inflate(2131427410, null);
            var8.setText(var12);
            var11.b(var8);
         }

         String var9;
         if (var4 == null) {
            var9 = this.getString(2131755569);
         } else {
            var9 = var4;
         }

         var11.a(var9, var3);
         return var11.b();
      }

      private Dialog f(Context var1, Bundle var2, OnClickListener var3) {
         String var4 = var2.getString("ARGS_TITLE");
         Spanned var9 = Html.fromHtml(var2.getString("ARGS_MESSAGE"));
         AlertDialog.Builder var5 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var4)) {
            TextView var6 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var6.setText(var4);
            var5.a(var6);
         }

         if (!TextUtils.isEmpty(var9)) {
            TextView var7 = (TextView)LayoutInflater.from(var1).inflate(2131427410, null);
            var7.setText(var9);
            var5.b(var7);
         }

         var5.a(17039370, var3);
         AlertDialog var8 = var5.b();
         if (this.getTargetRequestCode() == 100) {
            this.setCancelable(false);
            var8.setCanceledOnTouchOutside(false);
         }

         return var8;
      }

      private Dialog g(Context var1, Bundle var2, OnClickListener var3) {
         String var6 = var2.getString("ARGS_TITLE");
         String var4 = var2.getString("ARGS_MESSAGE");
         String var5 = var2.getString("ARGS_OK_TEXT");
         Member var10 = (Member)var2.getParcelable(Member.class.getSimpleName());
         AlertDialog.Builder var7 = new AlertDialog.Builder(var1);
         if (!TextUtils.isEmpty(var6)) {
            TextView var8 = (TextView)LayoutInflater.from(var1).inflate(2131427417, null);
            var8.setText(var6);
            var7.a(var8);
         }

         if (!TextUtils.isEmpty(var4)) {
            TextView var9 = (TextView)LayoutInflater.from(var1).inflate(2131427410, null);
            var9.setText(var4);
            var7.b(var9);
         }

         var7.a(var5, new OnClickListener(this, var10) {
            final Member a;
            final DialogUtils.DialogFragmentWrapper b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onClick(DialogInterface var1, int var2x) {
               var1.dismiss();
               this.b.a(this.b.getTargetRequestCode(), var2x, this.a);
            }
         });
         var7.b(17039360, var3);
         return var7.b();
      }

      private Dialog h(Context var1, Bundle var2, OnClickListener var3) {
         String var4 = var2.getString("ARGS_TITLE");
         int[] var5 = var2.getIntArray("ARGS_CHOICES_RES");
         String[] var7 = var2.getStringArray("ARGS_CHOICES_ARRAY");
         OptionsBottomSheetDialog var6 = new OptionsBottomSheetDialog(var1);
         var6.a(var4);
         var6.a(var5);
         var6.a(var7);
         var6.a(var3);
         var6.c();
         return var6;
      }

      @Override
      public Dialog onCreateDialog(Bundle var1) {
         Dialog var4 = null;
         AlertDialog var3 = null;
         if (this.getArguments() != null) {
            this.a = this.getArguments().getString("ARGS_TYPE");
            switch (this.a) {
               case "SINGLE_CHOICE":
                  var4 = this.a(this.getContext(), this.getArguments(), this.b);
                  break;
               case "SINGLE_CHOICE_RADIO":
                  var4 = this.b(this.getContext(), this.getArguments(), this.b);
                  break;
               case "CONFIRMATION_DIALOG":
                  var4 = this.c(this.getContext(), this.getArguments(), this.b);
                  break;
               case "CONFIRMATION_DIALOG_GREY":
                  var4 = this.d(this.getContext(), this.getArguments(), this.b);
                  break;
               case "CONFIRMATION_DIALOG_ADD_CHILD":
                  var4 = this.g(this.getContext(), this.getArguments(), this.b);
                  break;
               case "INFO_DIALOG":
                  var4 = this.e(this.getContext(), this.getArguments(), this.b);
                  break;
               case "INFO_DIALOG_MAINTENANCE":
                  var4 = this.f(this.getContext(), this.getArguments(), this.b);
                  break;
               case "EMAIL_ENTER":
                  var4 = this.b(this.getContext(), this.getArguments(), this.getTargetFragment());
                  break;
               case "NICKNAME_ENTER":
                  var4 = this.d(this.getContext(), this.getArguments(), this.getTargetFragment());
                  break;
               case "NAME_ENTER":
                  var4 = this.c(this.getContext(), this.getArguments(), this.getTargetFragment());
                  break;
               case "REGULAR":
                  var4 = this.a(this.getContext(), this.getArguments(), this.getTargetFragment());
                  break;
               case "BOTTOM_DIALOG":
                  var4 = this.h(this.getContext(), this.getArguments(), this.b);
            }

            var3 = var4;
            if (var4 instanceof AlertDialog) {
               var3 = (AlertDialog)var4;
               var3.setOnShowListener(new OnShowListener(this, var3) {
                  final AlertDialog a;
                  final DialogUtils.DialogFragmentWrapper b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  public void onShow(DialogInterface var1) {
                     for (int var4x : new int[]{-1, -2, -3}) {
                        ProximaHelper.b(this.a.a(var4x));
                        if (this.a.a(var4x) != null) {
                           Button var5 = this.a.a(var4x);
                           var5.setTextSize(16.0F);
                           if (VERSION.SDK_INT >= 21) {
                              var5.setLetterSpacing(0.12F);
                           }
                        }
                     }
                  }
               });
               var3 = var4;
            }
         }

         return var3;
      }

      private class DialogCheckForEmptyTextWatcher implements TextWatcher {
         final DialogUtils.DialogFragmentWrapper a;
         private Dialog b;

         public DialogCheckForEmptyTextWatcher(DialogUtils.DialogFragmentWrapper var1, Dialog var2) {
            this.a = var1;
            this.b = var2;
         }

         public void afterTextChanged(Editable var1) {
            if (TextUtils.isEmpty(var1)) {
               ((AlertDialog)this.b).a(-1).setEnabled(false);
            } else {
               ((AlertDialog)this.b).a(-1).setEnabled(true);
            }
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      }

      public interface DialogType {
      }
   }

   public interface DialogFragmentWrapperClickListener {
      void a(int var1, int var2, Object var3);
   }
}
