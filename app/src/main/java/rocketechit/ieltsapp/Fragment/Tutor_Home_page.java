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
import rocketechit.ieltsapp.Activity.Tutor_Activity;
import rocketechit.ieltsapp.AdapterClass.FeatureAdapter;
import rocketechit.ieltsapp.R;

public class Tutor_Home_page extends Fragment {

    @BindView(R.id.recycler_view_ID_tutor)
    RecyclerView recyclerViewIDTutor;
    Fragment fragment=null;
    String title="Add Exam";

    int[] images = {R.drawable.reading, R.drawable.writting, R.drawable.listening,
            R.drawable.speaking};
    String[] exam_name = {"Add Reading Question", "Add Writing Question", "Add Listening Question",
            "Add Speaking Question"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ((Tutor_Activity)getActivity()).setToolbarTitle(title);

        View view = inflater.inflate(R.layout.tutor_home_page, null);
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
                    fragment = new Add_MCQ_Question();
                }
                if (position == 1) {

                    fragment = new Add_Written_Question();
                }
                if (position == 2) {

                    fragment = new Add_Listening_Question();
                }
                if (position == 3) {

                    fragment = new Add_Speaking_Question();
                }
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.screen_Area_Tutor, fragment);
                fragmentTransaction.commit();

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
