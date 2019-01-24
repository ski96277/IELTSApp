package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class Make_A_Form_For_Post_Question extends Fragment {
    @BindView(R.id.numbet_picker_ID)
    NumberPicker numbetPickerID;
    String value_From;
    @BindView(R.id.submit_button)
    Button submitButton;
    Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        bundle = getArguments();
        value_From = bundle.getString("value");

        View view = inflater.inflate(R.layout.make_a_form_for_post_question, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numbetPickerID.setMinValue(1);
        numbetPickerID.setMaxValue(10);
    }

    @OnClick({R.id.submit_button, R.id.add_question_later})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.submit_button:
                if (value_From.equals("reading")) {

                    fragment = new Add_MCQ_Question();

                }
                if (value_From.equals("writing")) {
                    fragment = new Add_Written_Question();

                }
                if (value_From.equals("listening")) {
                    fragment = new Add_Listening_Question();
                }
                if (value_From.equals("speaking")) {
                    fragment = new Add_Speaking_Question();
                }
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.replace(R.id.screen_Area_Admin, fragment);
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.commit();
                break;
            case R.id.add_question_later:
                fragment=null;
                fragment = new Add_Question_For_Admin_Home_page();
                FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.screen_Area_Admin, fragment);
                fragmentTransaction2.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction2.commit();

                break;
        }
    }

}
