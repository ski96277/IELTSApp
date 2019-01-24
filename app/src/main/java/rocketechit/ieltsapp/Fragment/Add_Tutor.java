package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.Activity.Admin_Activity;
import rocketechit.ieltsapp.R;

public class Add_Tutor extends Fragment {
    String title = "Add Tutor";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ((Admin_Activity)getActivity()).settoolbarTitle(title);

        ((Admin_Activity)getActivity()).hideFloatingActionButton();

        View view = inflater.inflate(R.layout.add_tutor, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
