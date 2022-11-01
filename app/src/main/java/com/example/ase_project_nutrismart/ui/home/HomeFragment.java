package com.example.ase_project_nutrismart.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ase_project_nutrismart.R;
import com.example.ase_project_nutrismart.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
TextView tv_link1,tv_link2,Hi_text;

    String name="";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tv_link1=rootView.findViewById(R.id.tv_link1);
        tv_link2=rootView.findViewById(R.id.tv_link2);
        Hi_text=rootView.findViewById(R.id.Hi_text);


        tv_link1.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link1.setTextColor(getResources().getColor(R.color.blue));
        tv_link2.setTextColor(getResources().getColor(R.color.blue));
//        name = getArguments().getString("name");
        Log.d("djf",""+name);
//       if(!name.isEmpty())
//       {
//Hi_text.setText("HI"+ name);}
        tv_link1.setText("https://www.eatingwell.com/recipe/275923/creamy-chicken-noodle-soup-with-rotisserie-chicken/");
        tv_link2.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eatingwell.com/recipe/275923/creamy-chicken-noodle-soup-with-rotisserie-chicken/"));
                startActivity(browserIntent);

            }
        });
        tv_link2.setText("https://www.eatingwell.com/recipe/270514/really-green-smoothie/");
        tv_link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eatingwell.com/recipe/270514/really-green-smoothie/"));
                startActivity(browserIntent);

            }
        });




        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}