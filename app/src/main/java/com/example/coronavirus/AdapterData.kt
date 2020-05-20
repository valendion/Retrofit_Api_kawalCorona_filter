package com.example.coronavirus

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class AdapterData : RecyclerView.Adapter<AdapterData.ViewHolder>(), Filterable{

//    private var daftarNegara = ArrayList<AttributModel>()
    private var filterList = ArrayList<AttributModel>()
    private var negara = ArrayList<AttributModel>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rycler_item,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.namaNegara.text = "Nama negara = "+filterList.get(position).attributes.Country_Region
        holder.sembuh.text = "Total sembuh = "+filterList.get(position).attributes.Recovered+ " orang"
        holder.meniggal.text = "Total meninggal = "+filterList.get(position).attributes.Deaths+ " orang"
        holder.positif.text = "Total Positif = "+filterList.get(position).attributes.Confirmed+ " orang"

//        Log.e("error","-> "+ daftarNegara.get(position).Country_Region)
//        Log.e("error"," -> "+ daftarNegara)

    }

    fun setDaftarNegara(daftarNegara:ArrayList<AttributModel>){
        this.negara = daftarNegara
        this.filterList = daftarNegara

        notifyDataSetChanged()
    }



    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){

        val namaNegara: TextView = itemView!!.findViewById(R.id.negara)
        val sembuh: TextView = itemView!!.findViewById(R.id.sembuh)
        val meniggal: TextView = itemView!!.findViewById(R.id.meniggal)
        val positif: TextView = itemView!!.findViewById(R.id.positif)

    }



    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch: String = constraint.toString()
                if (charSearch.isEmpty()){
                    filterList = negara
                }else{

                    val arrayList = ArrayList<AttributModel>()

                    for(row: AttributModel in negara){
                        Log.e("isi array","-> $negara")
                        if (row.attributes.Country_Region.toLowerCase(Locale.getDefault()).contains(charSearch))
                            arrayList.add(row)

                    }
                    filterList = arrayList

                }

                val filter = FilterResults()
                filter.values = filterList
                return filter
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                filterList = results!!.values as ArrayList<AttributModel>
                notifyDataSetChanged()

            }

        }
    }


}