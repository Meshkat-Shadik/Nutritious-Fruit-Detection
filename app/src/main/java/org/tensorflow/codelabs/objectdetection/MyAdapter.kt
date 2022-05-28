package org.tensorflow.codelabs.objectdetection

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.tensorflow.codelabs.objectdetection.model.NutritionDataItem

const val TAG = "TFLite - ODT2"

class MyAdapter(val context: Context, val nutritionList:List<NutritionDataItem>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
       var fruitName : TextView
        var status: TextView
        var myCard : LinearLayout

        init{
           fruitName = itemView.findViewById(R.id.nameId)
            status = itemView.findViewById(R.id.statusId)
            myCard = itemView.findViewById(R.id.cardId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items,parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.fruitName.text = nutritionList[position].data.name
        holder.status.text = nutritionList[position].status
//        if (holder.myCard.getChildCount() > 0) {
//            holder.myCard.removeAllViews()
//        }


//        val myGeneralItemList: MutableList<String> = mutableListOf()
//        val tv = TextView(context)
//        val lparams = LinearLayout.LayoutParams(
//            400, 120
//        )
//        tv.layoutParams = lparams

//        for (i in 0 until nutritionList[position].data.count.generalItemsCount) {


//            val textView = TextView(context)
//            textView.layoutParams = nutritionList[position].data.generalItems.map { el -> el }
//              nutritionList[position].data.generalItems.forEach{
//                  holder.myCard.removeView(tv)
//                  tv.text = it.nutrientName
//                  holder.myCard.addView(tv)
//               //   myGeneralItemList.plus(it.nutrientName)
//                  holder.myCard.addView(tv)
              }
            //the problem is here when we put data inside textview

//        }

    override fun getItemCount(): Int {
        return nutritionList.size
        TODO("Not yet implemented")
    }
    //   myGeneralItemList.map { el -> Log.d(TAG, el)}
    //    holder.myCard.addView(tv)
    }

