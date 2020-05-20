package com.example.coronavirus

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_satu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class FragmentSatu : Fragment() {
    private val postServices = DataRespository.create()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        postServices.getPost().enqueue(object : Callback<PostModel> {
            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Log.e("tag", "Errornya ${t.message}")
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<PostModel>,
                response: Response<PostModel>
            ) {
                val names:PostModel = response.body()!!

                if (response.isSuccessful){
                    nama.text = names.name
                    nilai.text = names.value+" orang"
                }
            }


        })


        postServices.getPost2().enqueue(object : Callback<PostModel> {
            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Log.e("tag", "Errornya ${t.message}")
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                val data2:PostModel= response.body()!!

                if (response.isSuccessful){
                    nama2.text = data2.name
                    nilai2.text = data2.value+" orang"

                }
            }

        })


        postServices.getPost3().enqueue(object  : Callback<PostModel> {
            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Log.e("tag","Errornya ${t.message}")
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {

                val data3:PostModel = response.body()!!
                if (response.isSuccessful){
                    nama3.text = data3.name
                    nilai3.text = data3.value+" orang"
                }
            }

        })
        return inflater.inflate(R.layout.fragment_satu, container, false)
    }

}
