package org.tensorflow.codelabs.objectdetection

import org.tensorflow.codelabs.objectdetection.model.Data
import org.tensorflow.codelabs.objectdetection.model.NutritionData
import org.tensorflow.codelabs.objectdetection.model.NutritionDataItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {
    @GET("multi/")
    fun getData(@Query("name") name:String): Call<List<NutritionDataItem>>
}