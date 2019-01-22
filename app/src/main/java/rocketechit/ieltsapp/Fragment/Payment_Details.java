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
import rocketechit.ieltsapp.Activity.Admin_Activity;
import rocketechit.ieltsapp.AdapterClass.Payment_Details_list_Adapter;
import rocketechit.ieltsapp.R;

public class Payment_Details extends Fragment {

    String title = "Payment Details";
    @BindView(R.id.recycler_view_payment_details)
    RecyclerView recyclerViewPaymentDetails;

    String[] name={"Imran 1","Imran 2","Imran 3","Imran 4","Imran 5","Imran 6","Imran 7"};
    String[] dueTaka={"$50","$10","$20","$50","$1000","$500","$200"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((Admin_Activity) getActivity()).settoolbarTitle(title);
        View view = inflater.inflate(R.layout.payment_details, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager  linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewPaymentDetails.setLayoutManager(linearLayoutManager);

        Payment_Details_list_Adapter payment_details_list_adapter=new Payment_Details_list_Adapter(getContext(),name,dueTaka);
        recyclerViewPaymentDetails.setAdapter(payment_details_list_adapter);
        payment_details_list_adapter.setOnItemClickListener(new Payment_Details_list_Adapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getContext(), "Oi......", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
