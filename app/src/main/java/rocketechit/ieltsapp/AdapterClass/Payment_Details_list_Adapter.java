package rocketechit.ieltsapp.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.R;

public class Payment_Details_list_Adapter extends RecyclerView.Adapter<Payment_Details_list_Adapter.ViewClass> {
    Context context;
    String[] name;
    String[] dueTaka;
    //for onClick from java class (Second ....)
    private static Payment_Details_list_Adapter.ClickListener clickListener;


    public Payment_Details_list_Adapter(Context context, String[] name, String[] dueTaka) {
        this.context = context;
        this.name = name;
        this.dueTaka = dueTaka;

    }


    @NonNull
    @Override
    public Payment_Details_list_Adapter.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.payment_details_list_item, null);

        return new Payment_Details_list_Adapter.ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Payment_Details_list_Adapter.ViewClass viewClass, int i) {
        viewClass.name_TV.setText(name[i]);
        viewClass.dueTaka_TV.setText("payable :"+dueTaka[i]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView name_TV;
        TextView dueTaka_TV;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            name_TV = itemView.findViewById(R.id.name_pay_TV);
            dueTaka_TV = itemView.findViewById(R.id.amount_TV);
        }

        //Override this method for onClick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }


    //for onClick from java class
    public void setOnItemClickListener(Payment_Details_list_Adapter.ClickListener clickListener) {
        Payment_Details_list_Adapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View view);

        void onItemLongClick(int position, View v);
    }
}