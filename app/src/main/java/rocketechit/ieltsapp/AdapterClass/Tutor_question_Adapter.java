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

public class Tutor_question_Adapter extends RecyclerView.Adapter<Tutor_question_Adapter.ViewClass> {
    Context context;
    String[] exam_name;
    //for onClick from java class (Second ....)
    private static Tutor_question_Adapter.ClickListener clickListener;
    private TextView examname;
    private TextView authorname;

    public Tutor_question_Adapter(Context context, String[] exam_name) {
        this.context = context;
        this.exam_name = exam_name;

    }


    @NonNull
    @Override
    public Tutor_question_Adapter.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.tutor_question_item_view, null);

        return new Tutor_question_Adapter.ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tutor_question_Adapter.ViewClass viewClass, int i) {
        viewClass.exam_name.setText(exam_name[i]);
    }

    @Override
    public int getItemCount() {
        return exam_name.length;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView exam_name;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            exam_name = itemView.findViewById(R.id.exam_title_for_tutor);
        }

        //Override this method for onClick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v, exam_name.getText().toString());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    //for onClick from java class
    public void setOnItemClickListener(Tutor_question_Adapter.ClickListener clickListener) {
        Tutor_question_Adapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View view, String exam_status);

        void onItemLongClick(int position, View v);
    }
}