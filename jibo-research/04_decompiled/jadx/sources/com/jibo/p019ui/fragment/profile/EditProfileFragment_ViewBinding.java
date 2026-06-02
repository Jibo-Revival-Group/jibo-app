package com.jibo.p019ui.fragment.profile;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class EditProfileFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private EditProfileFragment f10866b;

    /* JADX INFO: renamed from: c */
    private View f10867c;

    /* JADX INFO: renamed from: d */
    private View f10868d;

    /* JADX INFO: renamed from: e */
    private View f10869e;

    /* JADX INFO: renamed from: f */
    private View f10870f;

    /* JADX INFO: renamed from: g */
    private View f10871g;

    /* JADX INFO: renamed from: h */
    private View f10872h;

    /* JADX INFO: renamed from: i */
    private View f10873i;

    public EditProfileFragment_ViewBinding(final EditProfileFragment editProfileFragment, View view) {
        super(editProfileFragment, view);
        this.f10866b = editProfileFragment;
        editProfileFragment.memberName = (TextView) Utils.m5161b(view, R.id.txtMemberName, "field 'memberName'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.settingPrefferedName, "field 'settingPrefferedName' and method 'nicknameClickEdit'");
        editProfileFragment.settingPrefferedName = viewM5158a;
        this.f10867c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.nicknameClickEdit();
            }
        });
        editProfileFragment.preferredName = (TextView) Utils.m5161b(view, R.id.settingNameTextView, "field 'preferredName'", TextView.class);
        editProfileFragment.gender = (TextView) Utils.m5161b(view, R.id.settingGenderTextView, "field 'gender'", TextView.class);
        editProfileFragment.email = (TextView) Utils.m5161b(view, R.id.settingEmailTextView, "field 'email'", TextView.class);
        editProfileFragment.birthday = (TextView) Utils.m5161b(view, R.id.settingBirthdayTextView, "field 'birthday'", TextView.class);
        editProfileFragment.avatarEdit = Utils.m5158a(view, R.id.avatar_edit, "field 'avatarEdit'");
        View viewM5158a2 = Utils.m5158a(view, R.id.settingBirthday, "field 'settingBirthday' and method 'birthdayClick'");
        editProfileFragment.settingBirthday = viewM5158a2;
        this.f10868d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.birthdayClick();
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.settingGender, "field 'settingGender' and method 'genderClick'");
        editProfileFragment.settingGender = viewM5158a3;
        this.f10869e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.genderClick();
            }
        });
        editProfileFragment.settingEmail = Utils.m5158a(view, R.id.settingEmail, "field 'settingEmail'");
        View viewM5158a4 = Utils.m5158a(view, R.id.btnResendInvite, "field 'btnResendInvite' and method 'resendInviteClick'");
        editProfileFragment.btnResendInvite = viewM5158a4;
        this.f10870f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.resendInviteClick();
            }
        });
        editProfileFragment.setEmailInfo = (TextView) Utils.m5161b(view, R.id.setEmailInfo, "field 'setEmailInfo'", TextView.class);
        View viewM5158a5 = Utils.m5158a(view, R.id.settingAddPrefName, "field 'settingAddPrefName' and method 'nicknameClick'");
        editProfileFragment.settingAddPrefName = viewM5158a5;
        this.f10871g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.nicknameClick();
            }
        });
        View viewM5158a6 = Utils.m5158a(view, R.id.settingSetEmail, "field 'settingSetEmail' and method 'setEmailClick'");
        editProfileFragment.settingSetEmail = viewM5158a6;
        this.f10872h = viewM5158a6;
        viewM5158a6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.setEmailClick();
            }
        });
        editProfileFragment.settingLegalGuardianName = Utils.m5158a(view, R.id.settingLegalGuardianName, "field 'settingLegalGuardianName'");
        editProfileFragment.legalGuardianName = (TextView) Utils.m5161b(view, R.id.legalGuardianName, "field 'legalGuardianName'", TextView.class);
        editProfileFragment.settingLegalGuardianEmail = Utils.m5158a(view, R.id.settingLegalGuardianEmail, "field 'settingLegalGuardianEmail'");
        editProfileFragment.legalGuardianEmail = (TextView) Utils.m5161b(view, R.id.legalGuardianEmail, "field 'legalGuardianEmail'", TextView.class);
        editProfileFragment.settingSetPhone = Utils.m5158a(view, R.id.settingSetPhone, "field 'settingSetPhone'");
        View viewM5158a7 = Utils.m5158a(view, R.id.btnRemoveFromLoop, "method 'removeFromLoopClick'");
        this.f10873i = viewM5158a7;
        viewM5158a7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                editProfileFragment.removeFromLoopClick();
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        EditProfileFragment editProfileFragment = this.f10866b;
        if (editProfileFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10866b = null;
        editProfileFragment.memberName = null;
        editProfileFragment.settingPrefferedName = null;
        editProfileFragment.preferredName = null;
        editProfileFragment.gender = null;
        editProfileFragment.email = null;
        editProfileFragment.birthday = null;
        editProfileFragment.avatarEdit = null;
        editProfileFragment.settingBirthday = null;
        editProfileFragment.settingGender = null;
        editProfileFragment.settingEmail = null;
        editProfileFragment.btnResendInvite = null;
        editProfileFragment.setEmailInfo = null;
        editProfileFragment.settingAddPrefName = null;
        editProfileFragment.settingSetEmail = null;
        editProfileFragment.settingLegalGuardianName = null;
        editProfileFragment.legalGuardianName = null;
        editProfileFragment.settingLegalGuardianEmail = null;
        editProfileFragment.legalGuardianEmail = null;
        editProfileFragment.settingSetPhone = null;
        this.f10867c.setOnClickListener(null);
        this.f10867c = null;
        this.f10868d.setOnClickListener(null);
        this.f10868d = null;
        this.f10869e.setOnClickListener(null);
        this.f10869e = null;
        this.f10870f.setOnClickListener(null);
        this.f10870f = null;
        this.f10871g.setOnClickListener(null);
        this.f10871g = null;
        this.f10872h.setOnClickListener(null);
        this.f10872h = null;
        this.f10873i.setOnClickListener(null);
        this.f10873i = null;
        super.unbind();
    }
}
