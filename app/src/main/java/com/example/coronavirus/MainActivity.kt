package com.example.coronavirus


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList


//var displayList = ArrayList<AttributModel>()
var negara = ArrayList<AttributModel>()
lateinit var recyclerView: RecyclerView
lateinit var adapterData: AdapterData
lateinit var adapterProvinsi: AdapterProvinsi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "CoronaVirus"
        setSupportActionBar(toolbar)


        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        tablayout.setupWithViewPager(viewPager)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)



        val menuSearch = menu!!.findItem(R.id.menu_search)
        var searchView: SearchView? = null

        if(menuSearch != null){
            searchView = menuSearch.actionView as SearchView
        }

        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                adapterData.filter.filter(newText)
                adapterProvinsi.filter.filter(newText)
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

}











