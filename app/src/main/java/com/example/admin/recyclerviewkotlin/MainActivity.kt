package com.example.admin.recyclerviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Bind the recyclerview
        val recyclerView = findViewById(R.id.rvAndroidVersions) as RecyclerView

        //Add a LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.addItemDecoration(LinearLayoutSpaceItemDecoration(16))

        //Here we create an arraylist to store alMyAndroidOS using the data class MyAndroidOS
        val alMyAndroidOS = ArrayList<MyAndroidOS>()

        //Adding some data to the arraylist
        alMyAndroidOS.add(MyAndroidOS(R.drawable.cupcake,"Cupcake", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.donut1,"Donut", "v1.6"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.eclair,"Eclair", "v2.1"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.froyo,"Froyo", "v2.2.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.gingerbread,"Gingerbread", "v2.3.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.honeycomb,"Honeycomb", "v3.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.icecreamsandwich,"Ice Cream Sandwich", "v4.0.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.jellybean,"Jelly Bean", "v4.1.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.kitkat,"KitKat", "v4.4.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.lollipop,"Lollipop", "v5.0"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.marshmallow1,"Marshmallow", "v6.0"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.nougat,"Nougat", "v7.0"))

        // adding the adapter to recyclerView
        recyclerView.adapter = MyAndroidAdapter(alMyAndroidOS){
            //Anko library has its own definition of toast which we have addded in build.gradle
            toast("${it.name} Clicked")//A toast that displays the name of OS which you clicked on
        }

    }
}
