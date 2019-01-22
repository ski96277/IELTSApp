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
import butterknife.Optional;
import rocketechit.ieltsapp.Activity.Admin_Activity;
import rocketechit.ieltsapp.AdapterClass.QuestionListAdapterView_By_Admin;
import rocketechit.ieltsapp.R;

public class Question_List_View_By_Admin extends Fragment {

    @BindView(R.id.recycler_View_ID_for_question_List)
    RecyclerView recyclerViewIDForquestionList;


    String[] exam_name = {"Written Demo Exam-1", "Written Demo Exam-2", "Written Demo Exam-3", "Written Demo Exam-4", "Written Demo Exam-5"};
    String[] exam_status = {"Free", "$100", "Free", "$50", "Free",};
    String[] author_name = {"SRK", "SK", "SRK", "SK", "SRK"};

    String title="Question List";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((Admin_Activity)getActivity()).settoolbarTitle(title);
        View view = inflater.inflate(R.layout.question_list_view_by_admin, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewIDForquestionList.setLayoutManager(linearLayoutManager);

        QuestionListAdapterView_By_Admin questionListAdapterView_by_admin=new QuestionListAdapterView_By_Admin(getContext(),exam_name,exam_status,author_name);
        recyclerViewIDForquestionList.setAdapter(questionListAdapterView_by_admin);

        questionListAdapterView_by_admin.setOnItemClickListener(new QuestionListAdapterView_By_Admin.ClickListener() {
            @Override
            public void onItemClick(int position, View view, String exam_status, String exam_name, String author) {
                Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });


    }
}
