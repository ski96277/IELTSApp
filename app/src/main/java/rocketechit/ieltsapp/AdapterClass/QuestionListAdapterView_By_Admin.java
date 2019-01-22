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

public class QuestionListAdapterView_By_Admin extends RecyclerView.Adapter<QuestionListAdapterView_By_Admin.ViewClass> {
    Context context;
    String[] exam_status;
    String[] name;
    String[] author;
    //for onClick from java class (Second ....)
    private static QuestionListAdapterView_By_Admin.ClickListener clickListener;
    private TextView examname;
    private TextView authorname;

    public QuestionListAdapterView_By_Admin(Context context, String[] name, String[] exam_status, String[] author) {
        this.context = context;
        this.exam_status = exam_status;
        this.name = name;
        this.author = author;

    }


    @NonNull
    @Override
    public QuestionListAdapterView_By_Admin.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.question_item_view_by_admin, null);

        return new QuestionListAdapterView_By_Admin.ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionListAdapterView_By_Admin.ViewClass viewClass, int i) {
        viewClass.exam_name.setText(name[i]);
        viewClass.exam_status.setText(exam_status[i]);
        viewClass.author.append(author[i]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView exam_name;
        TextView exam_status;
        TextView author;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            exam_name = itemView.findViewById(R.id.exam_name_view);
            exam_status = itemView.findViewById(R.id.exam_status_view);
            author = itemView.findViewById(R.id.author_name_view);
        }

        //Override this method for onClick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v, exam_status.getText().toString(),
                    exam_name.getText().toString(), author.getText().toString());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }


    //for onClick from java class
    public void setOnItemClickListener(QuestionListAdapterView_By_Admin.ClickListener clickListener) {
        QuestionListAdapterView_By_Admin.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View view, String exam_status, String exam_name, String author);

        void onItemLongClick(int position, View v);
    }
}