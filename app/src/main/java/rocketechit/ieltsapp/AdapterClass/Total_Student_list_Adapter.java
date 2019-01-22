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

public class Total_Student_list_Adapter extends RecyclerView.Adapter<Total_Student_list_Adapter.ViewClass> {
    Context context;

    String[] name;
    String[] phone_number;
    //for onClick from java class (Second ....)
    private static Total_Student_list_Adapter.ClickListener clickListener;
    private TextView examname;
    private TextView authorname;

    public Total_Student_list_Adapter(Context context, String[] name,String[] phone_number) {
        this.context = context;
        this.name = name;
        this.phone_number = phone_number;

    }


    @NonNull
    @Override
    public Total_Student_list_Adapter.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.total_student_list_item_view, null);

        return new Total_Student_list_Adapter.ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Total_Student_list_Adapter.ViewClass viewClass, int i) {
        viewClass.st_name.setText(name[i]);
        viewClass.st_phone.setText(phone_number[i]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView st_name;
        TextView st_phone;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            st_name = itemView.findViewById(R.id.student_name_TV);
            st_phone = itemView.findViewById(R.id.student_phone_TV);
        }


        //Override this method for onClick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v, st_name.getText().toString(),
                    st_phone.getText().toString());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }


    //for onClick from java class
    public void setOnItemClickListener(Total_Student_list_Adapter.ClickListener clickListener) {
        Total_Student_list_Adapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View view, String st_name, String st_phone);

        void onItemLongClick(int position, View v);
    }
}