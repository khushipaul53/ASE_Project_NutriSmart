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

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class HomeFragment extends Fragment {
TextView tv_link1,tv_link2,Hi_text;
ProgressBar pb_water;
    String name="";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tv_link1=rootView.findViewById(R.id.tv_link1);
        tv_link2=rootView.findViewById(R.id.tv_link2);
//        Hi_text=rootView.findViewById(R.id.Hi_text);
        pb_water = new ProgressBar(getContext());



        pb_water.setMax(40);

        tv_link1.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link1.setTextColor(getResources().getColor(R.color.blue));
        tv_link2.setTextColor(getResources().getColor(R.color.blue));
//        name = getArguments().getString("name");

//        Bundle bundle = getIntent().getExtras();
//        Boolean b=bundle.getBoolean("isSingup");
//        if(b){
//        String bmi=getArguments().getString("bmi");
//        String proteinNeeded=getArguments().getString("proteinNeeded");
//        String carbsNeeded=getArguments().getString("carbsNeeded");
//        String calorie=getArguments().getString("calorie");
//Log.d("cmvnbvn",""+bmi+" "+proteinNeeded+" "+carbsNeeded+" "+calorie);

        tv_link1.setText("Paneer + Egg+ Milk");
        tv_link2.setMovementMethod(LinkMovementMethod.getInstance());
        tv_link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eatingwell.com/recipe/275923/creamy-chicken-noodle-soup-with-rotisserie-chicken/"));
                startActivity(browserIntent);

            }
        });
        tv_link2.setText("Butter milk+ Custurd +Fruits");
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