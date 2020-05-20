package com.example.coronavirus

import android.annotation.SuppressLint
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

class AdapterProvinsi : RecyclerView.Adapter<AdapterProvinsi.ViewHolder>(), Filterable{

    private var filterList = ArrayList<AtributProvinsi>()
    private var dataProvinsi = ArrayList<AtributProvinsi>()

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        val namaProvinsi: TextView = itemView!!.findViewById(R.id.negara)
        val sembuh: TextView = itemView!!.findViewById(R.id.sembuh)
        val meniggal: TextView = itemView!!.findViewById(R.id.meniggal)
        val positif: TextView = itemView!!.findViewById(R.id.positif)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namaProvinsi.text = "Nama provinsi = "+ filterList[position].attributes.Provinsi
        holder.positif.text = "Total positif = " + filterList[position].attributes.positif+ " orang"
        holder.sembuh.text = "Total sembuh = " + filterList[position].attributes.sembuh + " orang"
        holder.meniggal.text = "Total meninggal = " + filterList[position].attributes.meninggal + " orang"
    }

    fun setProvinsi(daftarProvinsi: ArrayList<AtributProvinsi>){
        this.filterList = daftarProvinsi
        this.dataProvinsi = daftarProvinsi
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch: String = constraint.toString()
                if (charSearch.isEmpty()){
                    filterList = dataProvinsi
                }else{
                    val arrayList = ArrayList<AtributProvinsi>()

                    for (row: AtributProvinsi in dataProvinsi){
                        if (row.attributes.Provinsi.toLowerCase(Locale.getDefault()).contains(charSearch)){
                            arrayList.add(row)
                        }
                    }
                    Log.e("isi data provinsi","-> $filterList")
                    filterList = arrayList
                }

                val filter = FilterResults()
                filter.values = filterList
                return filter
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results!!.values as ArrayList<AtributProvinsi>
                notifyDataSetChanged()
            }

        }
    }


}