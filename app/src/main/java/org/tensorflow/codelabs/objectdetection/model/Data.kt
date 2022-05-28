package org.tensorflow.codelabs.objectdetection.model

data class Data(
    val count: Count,
    val generalItems: List<GeneralItem>,
    val mineralItems: List<MineralItem>,
    val name: String,
    val source: String,
    val totalNutritionValue: TotalNutritionValue,
    val vitaminItems: List<VitaminItem>
)