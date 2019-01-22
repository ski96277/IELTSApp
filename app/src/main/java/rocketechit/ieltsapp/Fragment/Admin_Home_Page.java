package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class Admin_Home_Page extends Fragment {
    Fragment fragment = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.admin_home_page, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.add_tutor_layout, R.id.view_tutor_list_layout, R.id.question_list_layout, R.id.view_all_payment_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_tutor_layout:

                fragment = new Total_Student_List();
                break;
            case R.id.view_tutor_list_layout:
                fragment = new Tutor_List();
                break;
            case R.id.question_list_layout:
                fragment = new Question_List_View_By_Admin();

                break;
            case R.id.view_all_payment_layout:
                fragment = new Payment_Details();
                break;
        }
        if (fragment != null) {

            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.screen_Area_Admin, fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }
}
