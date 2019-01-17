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

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewClass> {
    Context context;
    String[] exam_status;
    String[] name;
    //for onClick from java class (Second ....)
    private static ExamAdapter.ClickListener clickListener;

    public ExamAdapter(Context context, String[] name,String[] exam_status) {
        this.context = context;
        this.exam_status = exam_status;
        this.name = name;

    }


    @NonNull
    @Override
    public ExamAdapter.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.exam_item_view, null);

        return new ExamAdapter.ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.ViewClass viewClass, int i) {
        viewClass.exam_name.setText(name[i]);
//        Log.e("TAG", "onBindViewHolder: " + images[i]);
        viewClass.exam_status.setText(exam_status[i]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView exam_name;
        TextView exam_status;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            exam_name = itemView.findViewById(R.id.exam_name);
            exam_status = itemView.findViewById(R.id.exam_status);
        }

        //Override this method for onClick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), exam_status.getText().toString());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }

    //for onClick from java class
    public void setOnItemClickListener(ExamAdapter.ClickListener clickListener) {
        ExamAdapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, String exam_status);

        void onItemLongClick(int position, View v);
    }

}