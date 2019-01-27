package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.Activity.MainActivity;
import rocketechit.ieltsapp.AdapterClass.Reading_ExamListAdapter;
import rocketechit.ieltsapp.R;

public class ReadingFragment extends Fragment {

    Fragment fragment;


    String[] exam_name = {"Reading Demo Exam-1", "Reading Demo Exam-2", "Reading Demo Exam-3", "Reading Demo Exam-4", "Reading Demo Exam-5"};
    String[] exam_status = {"Free", "$100", "Free", "$50", "Free",};
    String[] author_name = {"SRK", "SK", "SRK", "SK", "SRK"};

    String title = "MCQ Exam List";

    @BindView(R.id.recycler_View_ID_For_Reading)
    RecyclerView recyclerViewIDForReading;
    @BindView(R.id.all_check)
    CheckBox allCheck;
    @BindView(R.id.free_check)
    CheckBox freeCheck;
    @BindView(R.id.paid_check)
    CheckBox paidCheck;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set title bar
        ((MainActivity) getActivity())
                .setToolbarTitle(title);
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

        Reading_ExamListAdapter readingExamListAdapter = new Reading_ExamListAdapter(getActivity(), exam_name, exam_status, author_name);
        recyclerViewIDForReading.setAdapter(readingExamListAdapter);

        readingExamListAdapter.setOnItemClickListener(new Reading_ExamListAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v, String exam_status, String exam_name, String author) {

                Bundle bundle = new Bundle();
                bundle.putString("exam_name", exam_name);
                bundle.putString("exam_status", exam_status);
                bundle.putString("exam_author", author);
                bundle.putString("id", "Reading");

                fragment = new Exam_item_details();
                fragment.setArguments(bundle);


                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.addToBackStack("");
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    fragmentTransaction.replace(R.id.screen_Area, fragment);
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });

    }

    @OnClick({R.id.all_check, R.id.free_check, R.id.paid_check})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all_check:

                allCheck.setChecked(true);
                freeCheck.setChecked(false);
                paidCheck.setChecked(false);
                break;
            case R.id.free_check:
                allCheck.setChecked(false);
                freeCheck.setChecked(true);
                paidCheck.setChecked(false);
                break;
            case R.id.paid_check:

                allCheck.setChecked(false);
                freeCheck.setChecked(false);
                paidCheck.setChecked(true);
                break;
        }
    }
}
