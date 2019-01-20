package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class Exam_Question_Show_Listening extends Fragment {
    @BindView(R.id.play_button)
    ImageView playButton;
    @BindView(R.id.audio_progress)
    Button audioProgress;
    @BindView(R.id.headphone_icon)
    ImageView headphoneIcon;
    @BindView(R.id.image_icon_question_1)
    ImageView imageIconQuestion1;
    @BindView(R.id.question_1)
    LinearLayout question1;
    @BindView(R.id.radio_Group_ID)
    RadioGroup radioGroupID;
    @BindView(R.id.image_icon_question_2)
    ImageView imageIconQuestion2;
    @BindView(R.id.question_2)
    LinearLayout question2;
    @BindView(R.id.question_ans_two_ET)
    EditText questionAnsTwoET;
    @BindView(R.id.image_icon_question_3)
    ImageView imageIconQuestion3;
    @BindView(R.id.question_3)
    LinearLayout question3;
    @BindView(R.id.question_ans_three_ET)
    EditText questionAnsThreeET;
    @BindView(R.id.button_back)
    ImageView buttonBack;
    @BindView(R.id.button_forward)
    ImageView buttonForward;

    int i = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exam_question_show_listening, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.play_button)
    public void onViewClicked() {
        if (i % 2 == 0) {
            playButton.setImageResource(R.drawable.pause);
        } else {
            playButton.setImageResource(R.drawable.play_audio);
        }
        i++;

    }

    @OnClick({R.id.question_1, R.id.question_2, R.id.question_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.question_1:
                if (i % 2 == 0) {
                    imageIconQuestion1.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    radioGroupID.setVisibility(View.VISIBLE);
                    i++;
                } else {
                    imageIconQuestion1.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
                    radioGroupID.setVisibility(View.GONE);
                    i++;
                }
                break;
            case R.id.question_2:
                if (i%2==0){
                    imageIconQuestion2.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    questionAnsTwoET.setVisibility(View.VISIBLE);
                    i++;
                }else {
                    imageIconQuestion2.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
                    questionAnsTwoET.setVisibility(View.GONE);
                    i++;
                }

                break;
            case R.id.question_3:
                if (i%2==0){
                    imageIconQuestion3.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    questionAnsThreeET.setVisibility(View.VISIBLE);
                    i++;
                }else {
                    imageIconQuestion3.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
                    questionAnsThreeET.setVisibility(View.GONE);
                    i++;
                }
                break;
        }
    }
}
