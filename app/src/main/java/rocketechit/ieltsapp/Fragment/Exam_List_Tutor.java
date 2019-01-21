package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class Exam_List_Tutor extends Fragment {
    Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exam_list_tutor, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragment = new Pending_Exam_For_Tutor();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.replace(R.id.screen_Area_Tutor_exam_list, fragment);
        fragmentTransaction.commit();
    }

    @OnClick({R.id.pending_btn, R.id.result_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pending_btn:
                fragment = new Pending_Exam_For_Tutor();
                break;
            case R.id.result_btn:
                fragment = new Checked_Exam_For_Tutor();

                break;
        }
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.screen_Area_Tutor_exam_list, fragment);
        fragmentTransaction.commit();
    }
}
