package com.example.coronavirus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentKetiga : Fragment() {

//    lateinit var adapterProvinsi: AdapterProvinsi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_tiga, container, false)
        recyclerView = view.findViewById(R.id.rv_provinsi)

        adapterProvinsi = AdapterProvinsi()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterProvinsi

        val service = DataRespository.create()

        service.getProvinsi().enqueue(object : Callback<ArrayList<AtributProvinsi>>{
            override fun onFailure(call: Call<ArrayList<AtributProvinsi>>, t: Throwable) {
                Log.e("errorProvinsi", "Error -> ${t.message}")
            }

            override fun onResponse(
                call: Call<ArrayList<AtributProvinsi>>,
                response: Response<ArrayList<AtributProvinsi>>
            ) {
                if (response.isSuccessful){
                    adapterProvinsi.setProvinsi(response.body()!!)
                }
            }

        })



        return view
    }

}
