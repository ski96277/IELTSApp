package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.AdapterClass.FeatureAdapter;
import rocketechit.ieltsapp.R;

public class Features_Fragment extends Fragment {

    @BindView(R.id.recycler_view_ID)
    RecyclerView recyclerViewID;

    Fragment fragment = null;

    int[] images = {R.drawable.reading, R.drawable.writting, R.drawable.listening,
            R.drawable.speaking};
    String[] exam_name = {"Reading", "Writing", "Listening", "Speaking"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.features_fragment, null);
        ButterKnife.bind(this, view);

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewID.setLayoutManager(gridLayoutManager);

        FeatureAdapter featureAdapter = new FeatureAdapter(getActivity(), images, exam_name);
        recyclerViewID.setAdapter(featureAdapter);

        featureAdapter.setOnItemClickListener(new FeatureAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                if (position == 0) {
                    fragment = new ReadingFragment();
                }
                if (position == 1) {

                    fragment = new Writing_Fragment();
                }
                if (position == 2) {

                    fragment = new Listening_Fragment();
                }
                if (position == 3) {

                    fragment = new Speaking_Fragment();
                }
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.screen_Area, fragment);
                fragmentTransaction.commit();

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }


}
