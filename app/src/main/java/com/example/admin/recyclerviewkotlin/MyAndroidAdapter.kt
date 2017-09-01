package com.example.admin.recyclerviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_android_version.view.*

/*Here in constructor of MyAndroidAdapter we pass the ArrayList<MyAndroidOS> and a listener as we want to call them in our Main Activity*/

class MyAndroidAdapter(val myAndroidOSList: ArrayList<MyAndroidOS>, val listener: (MyAndroidOS) -> Unit) : RecyclerView.Adapter<MyAndroidAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAndroidAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_android_version, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAndroidAdapter.ViewHolder, position: Int) {
        holder.bindItems(myAndroidOSList[position], listener)
    }

    override fun getItemCount(): Int {
        return myAndroidOSList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(myAndroidOS: MyAndroidOS, listener: (MyAndroidOS) -> Unit) = with(itemView)  {
            /*
             tvName, tvVersion, ivIcon are the ids which we have specified in item_android_version.xml and they are available to us due to kotlin extensions which we have added in our gradle and we also have imported in this class( import kotlinx.android.synthetic.main.item_android_version.view.* )
            In this import you can write the name of any xml file without the need to bind it in your class file and thus get rid of findViewById
            */
            itemView.tvName.text = myAndroidOS.name  /*Like here we directly use tvName without using findViewById */
            itemView.tvVersion.text = myAndroidOS.version
            itemView.ivIcon.setImageResource(myAndroidOS.imageIcon)
            itemView.setOnClickListener{listener(myAndroidOS)}

        }
    }


}
