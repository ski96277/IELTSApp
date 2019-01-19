package rocketechit.ieltsapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rocketechit.ieltsapp.R;

public class Exam_item_details extends Fragment {

    String exam_name;
    String exam_status;
    String exam_author;
    String id;

    @BindView(R.id.exam_item_name_TV)
    TextView examItemNameTV;
    @BindView(R.id.author_name_TV)
    TextView authorNameTV;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.exam_details_TV)
    TextView examDetailsTV;
    @BindView((R.id.buy_OR_Free_btn))
    Button buy_Or_Free_btn;
    @BindView((R.id.add_cart_button))
    Button add_To_Cart_btn;
    @BindView(R.id.exam_price_TV)
    TextView examPriceTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        exam_name = getArguments().getString("exam_name");
        exam_status = getArguments().getString("exam_status");
        exam_author = getArguments().getString("exam_author");
        id = getArguments().getString("id");

        View view = inflater.inflate(R.layout.exam_item_details, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        examItemNameTV.setText(exam_name);
        examDetailsTV.setText("Description  Replace Here");
        authorNameTV.setText(exam_author);
        examPriceTV.append(exam_status);

        if (exam_status.equals("Free")) {
            buy_Or_Free_btn.setText("Start Exam");
            add_To_Cart_btn.setVisibility(View.GONE);
        } else {
            buy_Or_Free_btn.setText("Buy");
        }

    }

    @OnClick({R.id.buy_OR_Free_btn, R.id.add_cart_button})
    public void onViewClicked(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.buy_OR_Free_btn:
                if (buy_Or_Free_btn.getText().equals("Start Exam")) {

                    if (id.equals("Listening")) {
                        fragment = new Exam_Question_Show_Listening();
                    }
                    if (id.equals("Reading")) {

                        fragment = new Exam_Question_Show_reading();
                    }
                    if (id.equals("writing")){
                        fragment =new Exam_question_show_Written();
                    }if (id.equals("speaking")){
                        fragment=new Exam_Question_Show_Speaking();
                    }

                } else {
                    fragment = new Payment_Fragment();
                }
                if (fragment != null) {

                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.addToBackStack("");
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                    fragmentTransaction.replace(R.id.screen_Area, fragment);
                    fragmentTransaction.commit();
                }

                break;
            case R.id.add_cart_button:
                Toast.makeText(getContext(), "1 item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
