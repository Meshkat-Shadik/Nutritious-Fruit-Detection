package org.tensorflow.codelabs.objectdetection

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.tensorflow.codelabs.objectdetection.model.NutritionDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailInformation : AppCompatActivity() {


    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_detail_information)
        val message = intent.getStringExtra("selectedFruit")

        recycleView = findViewById(R.id.recyclerId)
        recycleView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = linearLayoutManager

        Log.i("dad", "Passed Data = "+message)
        if (message != null) {
            getMyData(message)

        }

       // Toast.makeText(applicationContext,"safsafsa"+message,Toast.LENGTH_LONG ).show();

    }

    private fun getMyData(name: String) {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData(name)

        val progressDoalog : ProgressDialog
        progressDoalog =  ProgressDialog(this)
        progressDoalog.setMessage("Nutrition Data is Loading!")
        progressDoalog.setTitle("Be Patient")
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        // show it
        progressDoalog.show()


        retrofitData.enqueue(object : Callback<List<NutritionDataItem>?> {
            override fun onResponse(
                call: Call<List<NutritionDataItem>?>,
                response: Response<List<NutritionDataItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recycleView.adapter = myAdapter
                progressDoalog.dismiss();

            }

            override fun onFailure(call: Call<List<NutritionDataItem>?>, t: Throwable) {
               // TODO("Not yet implemented")
                progressDoalog.dismiss();
            }
        })



    }

}