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

public class WrittenExamListAdapter extends RecyclerView.Adapter<WrittenExamListAdapter.ViewClass> {
    Context context;
    String[] exam_status;
    String[] name;
    String[] author;
    //for onClick from java class (Second ....)
    private static WrittenExamListAdapter.ClickListener clickListener;
    private TextView examname;
    private TextView authorname;

    public WrittenExamListAdapter(Context context, String[] name, String[] exam_status, String[] author) {
        this.context = context;
        this.exam_status = exam_status;
        this.name = name;
        this.author = author;

    }


    @NonNull
    @Override
    public WrittenExamListAdapter.ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.written_exam_list_item, null);

        return new WrittenExamListAdapter.ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WrittenExamListAdapter.ViewClass viewClass, int i) {
        viewClass.exam_name.setText(name[i]);
        viewClass.exam_status.setText(exam_status[i]);
//        viewClass.author.append(author[i]);
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
        Button menu_icon;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            exam_name = itemView.findViewById(R.id.exam_name);
            exam_status = itemView.findViewById(R.id.exam_status);
//            author = itemView.findViewById(R.id.author_name);
            menu_icon = itemView.findViewById(R.id.menu_icon_btn);
        }

        //Override this method for onClick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v, exam_status.getText().toString(),
                    exam_name.getText().toString(), "author");
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }


    @Override
    public void onBindViewHolder(@NonNull ViewClass holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

        holder.menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.menu_icon);
                popupMenu.inflate(R.menu.menu_recycler);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.buy_now_menu:
                                Toast.makeText(context, "buy now", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.add_to_cart_menu:
                                Toast.makeText(context, "Add to cart", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    //for onClick from java class
    public void setOnItemClickListener(WrittenExamListAdapter.ClickListener clickListener) {
        WrittenExamListAdapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View view, String exam_status, String exam_name, String author);

        void onItemLongClick(int position, View v);
    }
}