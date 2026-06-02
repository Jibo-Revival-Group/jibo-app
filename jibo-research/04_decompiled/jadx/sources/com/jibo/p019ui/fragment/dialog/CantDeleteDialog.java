package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CantDeleteDialog extends DialogFragment {
    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_title, (ViewGroup) null);
        textView.setText(R.string.owner_account_delete_title);
        AlertDialog.Builder builderM3233b = new AlertDialog.Builder(getActivity()).m3225a(textView).m3233b(LayoutInflater.from(getActivity()).inflate(R.layout.dialog_cant_delete, (ViewGroup) null));
        builderM3233b.m3221a(R.string.okay_cap, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.CantDeleteDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CantDeleteDialog.this.dismiss();
            }
        });
        builderM3233b.m3232b(R.string.more_info, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.CantDeleteDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                CantDeleteDialog.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.jibo.com/jibo/articles/en_US/FAQ/delete-account")));
            }
        });
        return builderM3233b.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
