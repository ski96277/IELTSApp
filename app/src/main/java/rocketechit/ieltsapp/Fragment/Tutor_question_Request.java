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
import rocketechit.ieltsapp.AdapterClass.Tutor_List_Adapter;
import rocketechit.ieltsapp.R;

public class Tutor_question_Request extends Fragment {
    @BindView(R.id.recycler_View_ID_for_tutor_request_question)
    RecyclerView recyclerViewIDForTutorRequestQuestion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tutor_question_requestion, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewIDForTutorRequestQuestion.setLayoutManager(linearLayoutManager);

        Tutor_List_Adapter tutor_list_adapter=new Tutor_List_Adapter(getContext());
        recyclerViewIDForTutorRequestQuestion.setAdapter(tutor_list_adapter);

        tutor_list_adapter.setOnItemClickListener(new Tutor_List_Adapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getContext(), "hi...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
