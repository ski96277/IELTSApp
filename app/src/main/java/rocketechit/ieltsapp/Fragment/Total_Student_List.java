package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.Activity.Admin_Activity;
import rocketechit.ieltsapp.AdapterClass.Total_Student_list_Adapter;
import rocketechit.ieltsapp.R;

public class Total_Student_List extends Fragment {

    String[] name = {"imran - 1", "imran - 2", "imran - 3", "imran - 4", "imran - 5"};
    String[] phone = {"01687870058", "01687870058", "01687870058", "01687870058", "01687870058"};
    @BindView(R.id.recycler_View_ID_Total_student_list)
    RecyclerView recyclerViewIDTotalStudentList;
    Fragment fragment=null;
    Bundle bundle;

    String title="Student List";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((Admin_Activity)getActivity()).settoolbarTitle(title);
        View view = inflater.inflate(R.layout.total_student_list, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bundle=new Bundle();

        //hide floating btn
        ((Admin_Activity)getActivity()).hideFloatingActionButton();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewIDTotalStudentList.setLayoutManager(linearLayoutManager);

        Total_Student_list_Adapter total_student_list_adapter=new Total_Student_list_Adapter(getContext(),name,phone);
        recyclerViewIDTotalStudentList.setAdapter(total_student_list_adapter);
        total_student_list_adapter.setOnItemClickListener(new Total_Student_list_Adapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view, String st_name, String st_phone) {
                fragment=new Student_Details_View_By_Admin();
                bundle.putString("name",st_name);
                bundle.putString("phone",st_phone);
                fragment.setArguments(bundle);
                fragment_Transaction();
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }

    public void fragment_Transaction(){
        if (fragment!=null){
            FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.screen_Area_Admin,fragment);
            fragmentTransaction.commit();
        }
    }
}
