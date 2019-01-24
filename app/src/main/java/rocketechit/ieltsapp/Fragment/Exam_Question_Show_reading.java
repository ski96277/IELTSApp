package rocketechit.ieltsapp.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.Activity.MainActivity;
import rocketechit.ieltsapp.R;

public class Exam_Question_Show_reading extends Fragment {
    @BindView(R.id.question_TV)
    TextView questionTV;
    @BindView(R.id.radio_Group_ID)
    RadioGroup radioGroupID;
    String title = "MCQ Question Details";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity())
                .setToolbarTitle(title);
        View view = inflater.inflate(R.layout.exam_question, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.button_back, R.id.button_forward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_back:
                Toast.makeText(getActivity(), "Back", Toast.LENGTH_SHORT).show();

                break;
            case R.id.button_forward:
//                Toast.makeText(getActivity(), "Forward", Toast.LENGTH_SHORT).show();
                showAlert();
                break;
        }
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater layoutInflater = this.getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.rating_alert_dialog, null);
        builder.setView(view);

        final AlertDialog alertDialog = builder.create();

        Button button_NO;
        Button button_yes;

        button_NO = view.findViewById(R.id.submit_No_rating);
        button_yes = view.findViewById(R.id.submit_Yes_rating);

        button_NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //method
                alertDialog.dismiss();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

}
