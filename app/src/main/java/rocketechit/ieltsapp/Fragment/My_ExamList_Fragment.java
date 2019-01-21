package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class My_ExamList_Fragment extends Fragment {
    @BindView(R.id.screen_Area_my_exam_list)
    FrameLayout screenAreaMyExamList;
    Fragment fragment = null;
    @BindView(R.id.pending_btn)
    Button pendingBtn;
    @BindView(R.id.result_btn)
    Button resultBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_exam_list_fragment, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragment = new Pending_Result();
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.screen_Area_my_exam_list, fragment);
            fragmentTransaction.commit();
        }

    }

    @OnClick({R.id.pending_btn, R.id.result_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pending_btn:
                fragment = new Pending_Result();
                break;
            case R.id.result_btn:
                fragment = new Publish_Result();
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.screen_Area_my_exam_list, fragment);
            fragmentTransaction.commit();
        }
    }
}
