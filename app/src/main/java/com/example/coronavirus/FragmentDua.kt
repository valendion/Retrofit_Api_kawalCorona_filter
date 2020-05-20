package com.example.coronavirus

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Fragment dua
class FragmentDua : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dua, container,false)
//        var context: Context = context!!.applicationContext
        recyclerView = view.findViewById(R.id.rv_utama)
//        displayList.addAll(negara)
//        Log.e("isi data main","-> $negara")
        adapterData = AdapterData()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterData
        return view
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    fun getData(){
        val service = DataRespository.create()

        service.getDaftar().enqueue(object : Callback<ArrayList<AttributModel>> {
            override fun onFailure(call: Call<ArrayList<AttributModel>>, t: Throwable) {
                Log.e("error","Erorr ->" + t.message)
            }

            override fun onResponse(
                call: Call<ArrayList<AttributModel>>,
                response: Response<ArrayList<AttributModel>>
            ) {
                if (response.isSuccessful){

                    adapterData.setDaftarNegara(response.body()!!)

                }
            }

        })
    }
}
