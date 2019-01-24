package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.Activity.Admin_Activity;
import rocketechit.ieltsapp.AdapterClass.FeatureAdapter;
import rocketechit.ieltsapp.R;

public class Add_Question_For_Admin_Home_page extends Fragment {

    @BindView(R.id.recycler_view_ID_tutor)
    RecyclerView recyclerViewIDTutor;
    Fragment fragment=null;
    String title="Add Exam";
    Bundle bundle;

    int[] images = {R.drawable.reading, R.drawable.writting, R.drawable.listening,
            R.drawable.speaking};
    String[] exam_name = {"Add Reading Question", "Add Writing Question", "Add Listening Question",
            "Add Speaking Question"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ((Admin_Activity)getActivity()).settoolbarTitle(title);
bundle=new Bundle();
        View view = inflater.inflate(R.layout.add_question_for_admin_home_page, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewIDTutor.setLayoutManager(gridLayoutManager);

        FeatureAdapter featureAdapter = new FeatureAdapter(getActivity(), images, exam_name);
        recyclerViewIDTutor.setAdapter(featureAdapter);

        featureAdapter.setOnItemClickListener(new FeatureAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                if (position == 0) {
                    fragment = new Make_A_Form_For_Post_Question();
                    bundle.putString("value","reading");
                }
                if (position == 1) {

                    fragment = new Make_A_Form_For_Post_Question();
                    bundle.putString("value","writing");

                }
                if (position == 2) {

                    fragment = new Make_A_Form_For_Post_Question();
                    bundle.putString("value","listening");

                }
                if (position == 3) {

                    fragment = new Make_A_Form_For_Post_Question();

                    bundle.putString("value","speaking");
                }
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("");
                fragment.setArguments(bundle);
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.screen_Area_Admin, fragment);
                fragmentTransaction.commit();

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
