package com.example.coronavirus

import com.google.gson.annotations.SerializedName


data class PostModel(val name:String,
                     val value:String)


data class ModelNegara( @SerializedName("OBJECTID") val OBJECTID:String,
                        @SerializedName("Country_Region") val Country_Region:String,
                        @SerializedName("Last_Update") val Last_Update:String,
                        @SerializedName("Lat")val Lat:String,
                        @SerializedName("Long_") val Long_:String,
                        @SerializedName("Confirmed")val Confirmed:String,
                        @SerializedName("Deaths")val Deaths:String,
                        @SerializedName("Recovered")val Recovered:String,
                        @SerializedName("Active")val Active:String)

data class AttributModel( val attributes : ModelNegara)

data class ModelProvinsi( @SerializedName("FID") val FID:String,
                          @SerializedName("Kode_Provi") val Kode_Provi:String,
                          @SerializedName("Provinsi") val Provinsi:String,
                          @SerializedName("Kasus_Posi") val positif:String,
                          @SerializedName("Kasus_Semb") val sembuh:String,
                          @SerializedName("Kasus_Meni") val meninggal:String)

data class AtributProvinsi(val attributes : ModelProvinsi)












