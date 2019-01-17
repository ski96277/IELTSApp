package rocketechit.ieltsapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.AdapterClass.ExamAdapter;
import rocketechit.ieltsapp.R;

public class ReadingFragment extends Fragment {

    Fragment fragment;


    String[] exam_name = {"Demo Exam-1", "Demo Exam-2", "Demo Exam-3", "Demo Exam-4", "Demo Exam-5"};
    String[] exam_status = {"Free", "$100", "Free", "$50", "Free",};
    @BindView(R.id.recycler_View_ID_For_Reading)
    RecyclerView recyclerViewIDForReading;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("MCQ Exam List");
        View view = inflater.inflate(R.layout.reading_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewIDForReading.setLayoutManager(linearLayoutManager);

        ExamAdapter examAdapter = new ExamAdapter(getActivity(), exam_name, exam_status);
        recyclerViewIDForReading.setAdapter(examAdapter);

        examAdapter.setOnItemClickListener(new ExamAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, String exam_status) {
                String status = exam_status;
                if (status.equals("Free")) {
                    fragment = new Exam_Question_Show_reading();

                } else {
                    fragment = new Payment_Fragment();
                }
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.addToBackStack("");
                    fragmentTransaction.replace(R.id.screen_Area, fragment);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

    }
}
