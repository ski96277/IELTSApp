package rocketechit.ieltsapp.Fragment;

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
import rocketechit.ieltsapp.AdapterClass.Payment_ExamListAdapter;
import rocketechit.ieltsapp.AdapterClass.WrittenExamListAdapter;
import rocketechit.ieltsapp.R;

public class My_Purchase_Exam extends Fragment {


    String[] exam_name = {"Written Demo Exam-1", "Written Demo Exam-2", "Written Demo Exam-3", "Written Demo Exam-4", "Written Demo Exam-5"};
    String[] exam_status = {"Free", "$100", "Free", "$50", "Free",};

    String[] author_name = {"SRK", "SK", "SRK", "SK", "SRK"};

    @BindView(R.id.recycler_View_my_purchase)
    RecyclerView recyclerViewMyPurchase;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_purchase_exam, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewMyPurchase.setLayoutManager(linearLayoutManager);

        Payment_ExamListAdapter payment_examListAdapter = new Payment_ExamListAdapter(getActivity(), exam_name, exam_status, author_name);
        recyclerViewMyPurchase.setAdapter(payment_examListAdapter);

        payment_examListAdapter.setOnItemClickListener(new Payment_ExamListAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view, String exam_status, String exam_name, String author) {
                Bundle bundle=new Bundle();
                bundle.putString("exam_name",exam_name);
                bundle.putString("exam_status",exam_status);
                bundle.putString("exam_author",author);
                bundle.putString("id","writing");

                Fragment fragment = new Exam_item_details();
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
}
