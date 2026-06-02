package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.view.proxima.CustomFontEditText;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.Util;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DialogUtils {

    public interface DialogFragmentWrapperClickListener {
        /* JADX INFO: renamed from: a */
        void mo10186a(int i, int i2, Object obj);
    }

    /* JADX INFO: renamed from: a */
    public static void m10511a(Fragment fragment, int i, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_TITLE", str);
        bundle.putInt("ARGS_CHOICES_RES", i2);
        bundle.putSerializable("ARGS_TYPE", "SINGLE_CHOICE");
        DialogFragmentWrapper.m10535b(bundle, fragment, i, "SINGLE_CHOICE");
    }

    /* JADX INFO: renamed from: a */
    public static void m10512a(Fragment fragment, int i, String str, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_TITLE", str);
        bundle.putInt("ARGS_CHOICES_RES", i2);
        bundle.putInt("ARGS_CHOSEN_ITEM", i3);
        bundle.putSerializable("ARGS_TYPE", "SINGLE_CHOICE_RADIO");
        DialogFragmentWrapper.m10535b(bundle, fragment, i, "SINGLE_CHOICE_RADIO");
    }

    /* JADX INFO: renamed from: a */
    public static void m10513a(Fragment fragment, int i, String str, String str2) {
        m10516a(fragment, fragment.getFragmentManager(), i, str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m10518a(Fragment fragment, FragmentManager fragmentManager, int i, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_MESSAGE", str2);
        bundle.putString("ARGS_TITLE", str);
        bundle.putString("ARGS_OK_TEXT", str3);
        bundle.putString("ARGS_CANCEL_TEXT", str4);
        bundle.putSerializable("ARGS_TYPE", "REGULAR");
        DialogFragmentWrapper.m10536b(bundle, fragment, fragmentManager, i, "CONFIRMATION_DIALOG");
    }

    /* JADX INFO: renamed from: a */
    public static void m10516a(Fragment fragment, FragmentManager fragmentManager, int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_MESSAGE", str);
        bundle.putString("ARGS_OK_TEXT", str2);
        bundle.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG");
        DialogFragmentWrapper.m10536b(bundle, fragment, fragmentManager, i, "CONFIRMATION_DIALOG");
    }

    /* JADX INFO: renamed from: b */
    public static void m10520b(Fragment fragment, int i, String str, String str2) {
        m10514a(fragment, i, "", str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m10514a(Fragment fragment, int i, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_TITLE", str);
        bundle.putString("ARGS_MESSAGE", str2);
        bundle.putString("ARGS_OK_TEXT", str3);
        bundle.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG_GREY");
        DialogFragmentWrapper.m10535b(bundle, fragment, i, "CONFIRMATION_DIALOG_GREY");
    }

    /* JADX INFO: renamed from: c */
    public static void m10523c(Fragment fragment, int i, String str, String str2) {
        m10522b(fragment, fragment.getFragmentManager(), i, str, str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m10522b(Fragment fragment, FragmentManager fragmentManager, int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_MESSAGE", str2);
        bundle.putString("ARGS_TITLE", str);
        bundle.putSerializable("ARGS_TYPE", "INFO_DIALOG_MAINTENANCE");
        DialogFragmentWrapper.m10536b(bundle, fragment, fragmentManager, i, "INFO_DIALOG_MAINTENANCE");
    }

    /* JADX INFO: renamed from: d */
    public static void m10526d(Fragment fragment, int i, String str, String str2) {
        m10517a(fragment, fragment.getFragmentManager(), i, str, str2, (String) null);
    }

    /* JADX INFO: renamed from: b */
    public static void m10521b(Fragment fragment, int i, String str, String str2, String str3) {
        m10517a(fragment, fragment.getFragmentManager(), i, str, str2, str3);
    }

    /* JADX INFO: renamed from: c */
    public static void m10525c(Fragment fragment, FragmentManager fragmentManager, int i, String str, String str2) {
        m10517a(fragment, fragmentManager, i, str, str2, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public static void m10517a(Fragment fragment, FragmentManager fragmentManager, int i, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_MESSAGE", str2);
        bundle.putString("ARGS_TITLE", str);
        bundle.putString("ARGS_OK_TEXT", str3);
        bundle.putSerializable("ARGS_TYPE", "INFO_DIALOG");
        DialogFragmentWrapper.m10536b(bundle, fragment, fragmentManager, i, "INFO_DIALOG");
    }

    /* JADX INFO: renamed from: a */
    public static void m10510a(Fragment fragment, int i, Member member, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_MESSAGE", str2);
        bundle.putString("ARGS_TITLE", str);
        bundle.putString("ARGS_OK_TEXT", str3);
        bundle.putParcelable(Member.class.getSimpleName(), member);
        bundle.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG_ADD_CHILD");
        DialogFragmentWrapper.m10536b(bundle, fragment, fragment.getFragmentManager(), i, "CONFIRMATION_DIALOG_ADD_CHILD");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m10519a(FragmentManager fragmentManager) {
        for (Field field : DialogFragmentWrapper.DialogType.class.getDeclaredFields()) {
            if (fragmentManager.mo1470a(field.getName()) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public static void m10524c(Fragment fragment, int i, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_MESSAGE", str);
        bundle.putString("ARGS_OK_TEXT", str2);
        bundle.putString("ARGS_CANCEL_TEXT", str3);
        bundle.putSerializable("ARGS_TYPE", "CONFIRMATION_DIALOG_GREY");
        DialogFragmentWrapper.m10535b(bundle, fragment, i, "CONFIRMATION_DIALOG_GREY");
    }

    /* JADX INFO: renamed from: a */
    public static void m10515a(Fragment fragment, int i, String str, int[] iArr, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ARGS_TYPE", "BOTTOM_DIALOG");
        bundle.putString("ARGS_TITLE", str);
        bundle.putIntArray("ARGS_CHOICES_RES", iArr);
        bundle.putStringArray("ARGS_CHOICES_ARRAY", strArr);
        DialogFragmentWrapper.m10535b(bundle, fragment, i, "BOTTOM_DIALOG");
    }

    public static class DialogFragmentWrapper extends DialogFragment {

        /* JADX INFO: renamed from: a */
        private String f10196a;

        /* JADX INFO: renamed from: b */
        private DialogInterface.OnClickListener f10197b = new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapper.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                DialogFragmentWrapper.this.m10529a(DialogFragmentWrapper.this.getTargetRequestCode(), i, (Object) null);
            }
        };

        public interface DialogType {
        }

        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            Dialog dialogM10544h = null;
            if (getArguments() != null) {
                this.f10196a = getArguments().getString("ARGS_TYPE");
                switch (this.f10196a) {
                    case "SINGLE_CHOICE":
                        dialogM10544h = m10527a(getContext(), getArguments(), this.f10197b);
                        break;
                    case "SINGLE_CHOICE_RADIO":
                        dialogM10544h = m10533b(getContext(), getArguments(), this.f10197b);
                        break;
                    case "CONFIRMATION_DIALOG":
                        dialogM10544h = m10537c(getContext(), getArguments(), this.f10197b);
                        break;
                    case "CONFIRMATION_DIALOG_GREY":
                        dialogM10544h = m10539d(getContext(), getArguments(), this.f10197b);
                        break;
                    case "CONFIRMATION_DIALOG_ADD_CHILD":
                        dialogM10544h = m10543g(getContext(), getArguments(), this.f10197b);
                        break;
                    case "INFO_DIALOG":
                        dialogM10544h = m10541e(getContext(), getArguments(), this.f10197b);
                        break;
                    case "INFO_DIALOG_MAINTENANCE":
                        dialogM10544h = m10542f(getContext(), getArguments(), this.f10197b);
                        break;
                    case "EMAIL_ENTER":
                        dialogM10544h = m10534b(getContext(), getArguments(), getTargetFragment());
                        break;
                    case "NICKNAME_ENTER":
                        dialogM10544h = m10540d(getContext(), getArguments(), getTargetFragment());
                        break;
                    case "NAME_ENTER":
                        dialogM10544h = m10538c(getContext(), getArguments(), getTargetFragment());
                        break;
                    case "REGULAR":
                        dialogM10544h = m10528a(getContext(), getArguments(), getTargetFragment());
                        break;
                    case "BOTTOM_DIALOG":
                        dialogM10544h = m10544h(getContext(), getArguments(), this.f10197b);
                        break;
                }
                if (dialogM10544h instanceof AlertDialog) {
                    final AlertDialog alertDialog = (AlertDialog) dialogM10544h;
                    alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapper.1
                        @Override // android.content.DialogInterface.OnShowListener
                        public void onShow(DialogInterface dialogInterface) {
                            for (int i : new int[]{-1, -2, -3}) {
                                ProximaHelper.m11358b(alertDialog.m3218a(i));
                                if (alertDialog.m3218a(i) != null) {
                                    Button buttonM3218a = alertDialog.m3218a(i);
                                    buttonM3218a.setTextSize(16.0f);
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        buttonM3218a.setLetterSpacing(0.12f);
                                    }
                                }
                            }
                        }
                    });
                }
            }
            return dialogM10544h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static void m10535b(Bundle bundle, Fragment fragment, int i, String str) {
            m10536b(bundle, fragment, fragment.getFragmentManager(), i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static void m10536b(Bundle bundle, Fragment fragment, FragmentManager fragmentManager, int i, String str) {
            DialogFragmentWrapper dialogFragmentWrapper = new DialogFragmentWrapper();
            dialogFragmentWrapper.setArguments(bundle);
            dialogFragmentWrapper.setTargetFragment(fragment, i);
            dialogFragmentWrapper.show(fragmentManager, str);
        }

        /* JADX INFO: renamed from: a */
        private Dialog m10527a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            int i = bundle.getInt("ARGS_CHOICES_RES");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string);
                builder.m3225a(textView);
            }
            builder.m3227a(new ArrayAdapter(context, R.layout.simple_list_item_custom_font, Arrays.asList(context.getResources().getStringArray(i))), onClickListener);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: b */
        private Dialog m10533b(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            int i = bundle.getInt("ARGS_CHOICES_RES", -1);
            int i2 = bundle.getInt("ARGS_CHOSEN_ITEM");
            List listAsList = i != -1 ? Arrays.asList(context.getResources().getStringArray(i)) : bundle.getStringArrayList("ARGS_CHOICES_ARRAY");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string);
                builder.m3225a(textView);
            }
            builder.m3226a(new ArrayAdapter(context, R.layout.simple_list_item_single_choice_custom_font, listAsList), i2, onClickListener);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: c */
        private Dialog m10537c(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_MESSAGE");
            String string2 = bundle.getString("ARGS_OK_TEXT");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_msg_red, (ViewGroup) null);
                textView.setText(string);
                builder.m3233b(textView);
            }
            builder.m3229a(string2, onClickListener);
            builder.m3232b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: a */
        private Dialog m10528a(Context context, Bundle bundle, Fragment fragment) {
            String string = bundle.getString("ARGS_MESSAGE");
            String string2 = bundle.getString("ARGS_TITLE");
            String string3 = bundle.getString("ARGS_OK_TEXT");
            String string4 = bundle.getString("ARGS_CANCEL_TEXT");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string2)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string2);
                builder.m3225a(textView);
            }
            if (!TextUtils.isEmpty(string)) {
                TextView textView2 = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_msg, (ViewGroup) null);
                textView2.setText(string);
                builder.m3233b(textView2);
            }
            builder.m3229a(string3, this.f10197b);
            builder.m3235b(string4, this.f10197b);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: b */
        private Dialog m10534b(final Context context, Bundle bundle, Fragment fragment) {
            String string = bundle.getString("ARGS_TITLE");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_email, (ViewGroup) null);
            builder.m3233b(viewInflate);
            builder.m3228a(string);
            builder.m3221a(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapper.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (-1 == i) {
                        String string2 = ((EditText) viewInflate.findViewById(R.id.email)).getText().toString();
                        if (Util.m11494a((CharSequence) string2)) {
                            DialogFragmentWrapper.this.m10529a(112, -1, string2);
                            dialogInterface.dismiss();
                        } else {
                            ((TextInputLayout) viewInflate.findViewById(R.id.label_email)).setError(context.getString(R.string.error_invalid_email));
                        }
                    }
                }
            });
            builder.m3232b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: c */
        private Dialog m10538c(final Context context, Bundle bundle, final Fragment fragment) {
            String string = bundle.getString("ARGS_TITLE");
            final Account account = (Account) bundle.getParcelable("ARGS_ACCOUNT");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
            textView.setText(string);
            builder.m3225a(textView);
            builder.m3232b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
            final View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_firstname_lastname, (ViewGroup) null);
            builder.m3233b(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.first_name);
            editText.setText(account.getFirstName());
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.last_name);
            editText2.setText(account.getLastName());
            editText.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter()});
            editText2.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter()});
            builder.m3221a(R.string.set, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapper.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (-1 == i) {
                        String strTrim = ((EditText) viewInflate.findViewById(R.id.first_name)).getText().toString().trim();
                        String strTrim2 = ((EditText) viewInflate.findViewById(R.id.last_name)).getText().toString().trim();
                        if (!TextUtils.isEmpty(strTrim) && !TextUtils.isEmpty(strTrim2)) {
                            account.setFirstName(strTrim);
                            account.setLastName(strTrim2);
                            dialogInterface.dismiss();
                            DialogFragmentWrapper.this.m10529a(114, -1, (Object) null);
                            if (fragment.getActivity() instanceof SingleFragmentActivity) {
                                fragment.getActivity().setResult(-1);
                                ((SingleFragmentActivity) fragment.getActivity()).m10268q().putExtra("NAME_CHANGED", account.getFullName());
                                return;
                            }
                            return;
                        }
                        if (TextUtils.isEmpty(strTrim)) {
                            ((TextInputLayout) viewInflate.findViewById(R.id.label_first_name)).setError(context.getString(R.string.error_enter_first_and_last_name));
                        } else {
                            ((TextInputLayout) viewInflate.findViewById(R.id.label_last_name)).setError(context.getString(R.string.error_enter_first_and_last_name));
                        }
                    }
                }
            });
            AlertDialog alertDialogM3236b = builder.m3236b();
            editText2.addTextChangedListener(new DialogCheckForEmptyTextWatcher(alertDialogM3236b));
            editText.addTextChangedListener(new DialogCheckForEmptyTextWatcher(alertDialogM3236b));
            return alertDialogM3236b;
        }

        private class DialogCheckForEmptyTextWatcher implements TextWatcher {

            /* JADX INFO: renamed from: b */
            private Dialog f10217b;

            public DialogCheckForEmptyTextWatcher(Dialog dialog) {
                this.f10217b = dialog;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    ((AlertDialog) this.f10217b).m3218a(-1).setEnabled(false);
                } else {
                    ((AlertDialog) this.f10217b).m3218a(-1).setEnabled(true);
                }
            }
        }

        /* JADX INFO: renamed from: d */
        private Dialog m10539d(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            String string2 = bundle.getString("ARGS_MESSAGE");
            String string3 = bundle.getString("ARGS_OK_TEXT");
            String string4 = bundle.getString("ARGS_CANCEL_TEXT", context.getString(android.R.string.cancel));
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string);
                builder.m3225a(textView);
            }
            if (!TextUtils.isEmpty(string2)) {
                TextView textView2 = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_msg, (ViewGroup) null);
                textView2.setText(string2);
                if (TextUtils.isEmpty(string)) {
                    textView2.setPadding(context.getResources().getDimensionPixelSize(R.dimen.dialog_padding), context.getResources().getDimensionPixelSize(R.dimen.dialog_top_padding), context.getResources().getDimensionPixelSize(R.dimen.dialog_padding), 0);
                }
                builder.m3233b(textView2);
            }
            builder.m3229a(string3, onClickListener);
            builder.m3235b(string4, (DialogInterface.OnClickListener) null);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: e */
        private Dialog m10541e(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            String string2 = bundle.getString("ARGS_MESSAGE");
            String string3 = bundle.getString("ARGS_OK_TEXT");
            if (TextUtils.isEmpty(string2)) {
                string2 = "";
            }
            Spanned spannedFromHtml = Html.fromHtml(string2);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string);
                builder.m3225a(textView);
            }
            if (!TextUtils.isEmpty(spannedFromHtml)) {
                TextView textView2 = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_msg, (ViewGroup) null);
                textView2.setText(spannedFromHtml);
                builder.m3233b(textView2);
            }
            builder.m3229a(string3 == null ? getString(R.string.okay) : string3, onClickListener);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: f */
        private Dialog m10542f(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            Spanned spannedFromHtml = Html.fromHtml(bundle.getString("ARGS_MESSAGE"));
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string);
                builder.m3225a(textView);
            }
            if (!TextUtils.isEmpty(spannedFromHtml)) {
                TextView textView2 = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_msg, (ViewGroup) null);
                textView2.setText(spannedFromHtml);
                builder.m3233b(textView2);
            }
            builder.m3221a(android.R.string.ok, onClickListener);
            AlertDialog alertDialogM3236b = builder.m3236b();
            if (getTargetRequestCode() == 100) {
                setCancelable(false);
                alertDialogM3236b.setCanceledOnTouchOutside(false);
            }
            return alertDialogM3236b;
        }

        /* JADX INFO: renamed from: d */
        private Dialog m10540d(final Context context, Bundle bundle, final Fragment fragment) {
            String string = bundle.getString("ARGS_TITLE");
            String string2 = bundle.getString("ARGS_NICKNAME");
            final Loop loop = (Loop) bundle.getParcelable("ARGS_LOOP");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
            textView.setText(string);
            builder.m3225a(textView);
            final View viewInflate = LayoutInflater.from(context).inflate(R.layout.dialog_single_input, (ViewGroup) null);
            ((EditText) viewInflate.findViewById(R.id.text_input)).setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new InputFilter.LengthFilter(20)});
            ((EditText) viewInflate.findViewById(R.id.text_input)).setHint(context.getString(R.string.nickname_hint));
            if (!TextUtils.isEmpty(string2)) {
                ((EditText) viewInflate.findViewById(R.id.text_input)).setText(string2);
            }
            builder.m3233b(viewInflate);
            builder.m3232b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
            builder.m3221a(R.string.set, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapper.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (-1 == i) {
                        String strTrim = ((EditText) viewInflate.findViewById(R.id.text_input)).getText().toString().trim();
                        if (LoopHelper.checkPreferredNameError(loop, strTrim) == null) {
                            DialogFragmentWrapper.this.m10529a(113, -1, strTrim);
                            dialogInterface.dismiss();
                            fragment.getActivity().setResult(-1);
                            return;
                        }
                        ((TextInputLayout) viewInflate.findViewById(R.id.label_text_input)).setError(context.getString(R.string.error_duplicate_nickname));
                    }
                }
            });
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: g */
        private Dialog m10543g(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            String string2 = bundle.getString("ARGS_MESSAGE");
            String string3 = bundle.getString("ARGS_OK_TEXT");
            final Member member = (Member) bundle.getParcelable(Member.class.getSimpleName());
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (!TextUtils.isEmpty(string)) {
                TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_title, (ViewGroup) null);
                textView.setText(string);
                builder.m3225a(textView);
            }
            if (!TextUtils.isEmpty(string2)) {
                TextView textView2 = (TextView) LayoutInflater.from(context).inflate(R.layout.dialog_msg, (ViewGroup) null);
                textView2.setText(string2);
                builder.m3233b(textView2);
            }
            builder.m3229a(string3, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapper.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    DialogFragmentWrapper.this.m10529a(DialogFragmentWrapper.this.getTargetRequestCode(), i, member);
                }
            });
            builder.m3232b(android.R.string.cancel, onClickListener);
            return builder.m3236b();
        }

        /* JADX INFO: renamed from: h */
        private Dialog m10544h(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
            String string = bundle.getString("ARGS_TITLE");
            int[] intArray = bundle.getIntArray("ARGS_CHOICES_RES");
            String[] stringArray = bundle.getStringArray("ARGS_CHOICES_ARRAY");
            OptionsBottomSheetDialog optionsBottomSheetDialog = new OptionsBottomSheetDialog(context);
            optionsBottomSheetDialog.m10565a(string);
            optionsBottomSheetDialog.m10566a(intArray);
            optionsBottomSheetDialog.m10567a(stringArray);
            optionsBottomSheetDialog.m10564a(onClickListener);
            optionsBottomSheetDialog.m10568c();
            return optionsBottomSheetDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m10529a(int i, int i2, Object obj) {
            if (getTargetFragment() != null && (getTargetFragment() instanceof DialogFragmentWrapperClickListener)) {
                ((DialogFragmentWrapperClickListener) getTargetFragment()).mo10186a(i, i2, obj);
            } else if (getActivity() instanceof DialogFragmentWrapperClickListener) {
                ((DialogFragmentWrapperClickListener) getActivity()).mo10186a(i, i2, obj);
            }
        }
    }
}
