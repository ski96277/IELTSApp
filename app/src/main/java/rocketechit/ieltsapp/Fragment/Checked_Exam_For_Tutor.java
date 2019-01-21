package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.Activity.Tutor_Activity;
import rocketechit.ieltsapp.R;

public class Checked_Exam_For_Tutor extends Fragment {
    String title="Checked Exam";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((Tutor_Activity) getActivity()).setToolbarTitle(title);
        View view=inflater.inflate(R.layout.checked_exam_for_tutor,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
