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

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewClass> {
    Context context;
    int[] images;
    String[] name;
    //for onClick from java class (Second ....)
    private static ClickListener clickListener;
    @BindView(R.id.image_item)
    ImageView imageItem;
    @BindView(R.id.exam_name)
    TextView examName;


    public FeatureAdapter(Context context, int[] images, String[] name) {
        this.context = context;
        this.images = images;
        this.name = name;

    }


    @NonNull
    @Override
    public ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_view, null);

        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass viewClass, int i) {
        viewClass.imageView.setImageResource(images[i]);
        Log.e("TAG", "onBindViewHolder: " + images[i]);
        viewClass.nameTV.setText(name[i]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    //implement interface for onClick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        ImageView imageView;
        TextView nameTV;

        public ViewClass(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            imageView = itemView.findViewById(R.id.image_item);
            nameTV = itemView.findViewById(R.id.exam_name);
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
        FeatureAdapter.clickListener = clickListener;
    }

    //for onClick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);
    }

}
