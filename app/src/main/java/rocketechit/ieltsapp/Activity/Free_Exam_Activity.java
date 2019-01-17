package rocketechit.ieltsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import rocketechit.ieltsapp.R;

import android.os.Bundle;

public class Free_Exam_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Free Exam Offer");
        setContentView(R.layout.activity_free__exam);
    }
}
