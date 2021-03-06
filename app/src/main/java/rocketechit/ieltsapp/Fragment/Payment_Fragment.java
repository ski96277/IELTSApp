package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.Activity.MainActivity;
import rocketechit.ieltsapp.R;

public class Payment_Fragment extends Fragment {
    String title="Payment Method";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setToolbarTitle(title);

        View view=inflater.inflate(R.layout.payment_fragment,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
