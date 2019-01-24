package rocketechit.ieltsapp.AdapterClass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import rocketechit.ieltsapp.R;

public class Tutor_List_Adapter extends RecyclerView.Adapter<Tutor_List_Adapter.ViewClass> {
    Context context;
    String[] name;
    //for onClick from java class (Second ....)
    private static ClickListener clickListener;

    public Tutor_List_Adapter(Context context,String[] name) {
        this.context = context;
        this.name = name;

    }
    public Tutor_List_Adapter(Context context) {
        this.context = context;
        this.name = name;

    }


    @NonNull
    @Override
    public ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.tutor_list_item, null);

        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass viewClass, int i) {
//        viewClass.nameTV.setText(name[i]);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView nameTV;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            nameTV = itemView.findViewById(R.id.teacher_name_TV);

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
    public void setOnItemClickListener(ClickListener clickListener) {
        Tutor_List_Adapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }

}
