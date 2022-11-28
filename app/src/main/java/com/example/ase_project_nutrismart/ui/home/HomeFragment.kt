package com.example.ase_project_nutrismart.ui.home

import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.ase_project_nutrismart.R
import android.text.method.LinkMovementMethod
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    var tv_link1: TextView? = null
    var tv_link2: TextView? = null
    var Hi_text: TextView? = null
    var pb_water: ProgressBar? = null
    var name = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        tv_link1 = rootView.findViewById(R.id.tv_link1)
        tv_link2 = rootView.findViewById(R.id.tv_link2)
        //        Hi_text=rootView.findViewById(R.id.Hi_text);
        pb_water = ProgressBar(context)
        pb_water!!.max = 40
        tv_link1.setMovementMethod(LinkMovementMethod.getInstance())
        tv_link1.setTextColor(resources.getColor(R.color.blue))
        tv_link2.setTextColor(resources.getColor(R.color.blue))
        //        name = getArguments().getString("name");

//        Bundle bundle = getIntent().getExtras();
//        Boolean b=bundle.getBoolean("isSingup");
//        if(b){
//        String bmi=getArguments().getString("bmi");
//        String proteinNeeded=getArguments().getString("proteinNeeded");
//        String carbsNeeded=getArguments().getString("carbsNeeded");
//        String calorie=getArguments().getString("calorie");
//Log.d("cmvnbvn",""+bmi+" "+proteinNeeded+" "+carbsNeeded+" "+calorie);
        tv_link1.setText("Paneer + Egg+ Milk")
        tv_link2.setMovementMethod(LinkMovementMethod.getInstance())
        tv_link1.setOnClickListener(View.OnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.eatingwell.com/recipe/275923/creamy-chicken-noodle-soup-with-rotisserie-chicken/")
            )
            startActivity(browserIntent)
        })
        tv_link2.setText("Butter milk+ Custurd +Fruits")
        tv_link2.setOnClickListener(View.OnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.eatingwell.com/recipe/270514/really-green-smoothie/")
            )
            startActivity(browserIntent)
        })
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}