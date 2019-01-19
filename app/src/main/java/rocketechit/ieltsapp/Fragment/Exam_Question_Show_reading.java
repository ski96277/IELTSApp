package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    String title="MCQ Question Details";

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
                Toast.makeText(getActivity(), "Forward", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
