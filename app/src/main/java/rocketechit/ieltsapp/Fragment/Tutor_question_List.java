package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.Activity.Tutor_Activity;
import rocketechit.ieltsapp.AdapterClass.Tutor_question_Adapter;
import rocketechit.ieltsapp.R;

public class Tutor_question_List extends Fragment {
    String title = "Question List";

    String[] exam_name = {"Reading Exam", "Writing Exam", "Listening Exam", "Speaking Exam"};
    @BindView(R.id.recycler_View_ID_For_tutor_Exam_list)
    RecyclerView recyclerViewIDForTutorExamList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((Tutor_Activity) getActivity()).setToolbarTitle(title);
        View view = inflater.inflate(R.layout.tutor_question_list, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewIDForTutorExamList.setLayoutManager(linearLayoutManager);

        Tutor_question_Adapter tutor_question_adapter = new Tutor_question_Adapter(getContext(), exam_name);
        recyclerViewIDForTutorExamList.setAdapter(tutor_question_adapter);

        tutor_question_adapter.setOnItemClickListener(new Tutor_question_Adapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view, String exam_status) {
                Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
