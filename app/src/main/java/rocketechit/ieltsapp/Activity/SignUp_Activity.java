package rocketechit.ieltsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class SignUp_Activity extends AppCompatActivity {

    @BindView(R.id.username_for_SignUp_ET)
    EditText usernameForSignUpET;
    @BindView(R.id.full_name_for_SignUp_ET)
    EditText fullNameForSignUpET;
    @BindView(R.id.pass_SignUP_ET)
    EditText passSignUPET;
    @BindView(R.id.pass_Confirm_SignUp_ET)
    EditText passConfirmSignUpET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("IELTS EXAM");
        setContentView(R.layout.activity_sign_up_);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.profile_image,R.id.button_signUp, R.id.facebook_icon_btn_for_SignUp, R.id.google_icon_for_SignUp_btn, R.id.signIn_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.profile_image:
                Toast.makeText(this, "select an image", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_signUp:
                startActivity(new Intent(SignUp_Activity.this,MainActivity.class));
                break;
            case R.id.facebook_icon_btn_for_SignUp:
                break;
            case R.id.google_icon_for_SignUp_btn:
                break;
            case R.id.signIn_btn:
                startActivity(new Intent(SignUp_Activity.this,Login_Activity.class));
                finish();
                break;
        }
    }
}
