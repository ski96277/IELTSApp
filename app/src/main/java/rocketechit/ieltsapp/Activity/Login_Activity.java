package rocketechit.ieltsapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class Login_Activity extends AppCompatActivity {

    @BindView(R.id.username_ET)
    EditText usernameET;
    @BindView(R.id.pass_ET)
    EditText passET;
    @BindView(R.id.remind_me_check_box)
    CheckBox remindMeCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Login");
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.forgot_password_btn, R.id.button_signin, R.id.facebook_icon_btn, R.id.google_icon_btn, R.id.signup_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgot_password_btn:
                break;
            case R.id.button_signin:
                startActivity(new Intent(Login_Activity.this,MainActivity.class));
                break;
            case R.id.facebook_icon_btn:
                Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.google_icon_btn:
                Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.signup_btn:
                startActivity(new Intent(Login_Activity.this, SignUp_Activity.class));
                break;
        }
    }
}
