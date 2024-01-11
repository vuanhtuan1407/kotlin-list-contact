package com.example.listcontact
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import com.example.listcontact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var detailArrayList: ArrayList<Detail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.game1, R.drawable.game2, R.drawable.game3, R.drawable.game4, R.drawable.game5,
            R.drawable.game6, R.drawable.game7, R.drawable.game8, R.drawable.game9,

            )

        val name = arrayOf(
            "Pham Phuong Nga",
            "Nguyen Huy Hoang",
            "Tran Minh Quang",
            "Tran Thu Huyen",
            "Do Ngoc Huy",
            "Tran Duc Canh",
            "Vu Anh Tuan",
            "Tran Thi Anh",
            "Ngo Van Tuan"

        )

        val exid = arrayOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8"
        )
        val phoneno = arrayOf(
            "79085503167", "79285243799", "79964854221", "79107363418", "79322653922", "79271491327", "79587135240", "79995394322", "79964853242"
        )
        val email = arrayOf(
            "helloword225@gmail.com", "helloword244@gmail.com", "helloword204@gmail.com", "helloword271@gmail.com", "helloword264@gmail.com",
            "helloword147@gmail.com", "helloword304@gmail.com", "helloword114@gmail.com", "helloword1511@gmail.com"
        )

        detailArrayList = ArrayList()

        for ( i in exid.indices) {
            val detail = Detail (name[i], exid[i], phoneno[i], email[i], imageId[i])
            detailArrayList.add(detail)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, detailArrayList)
        registerForContextMenu(binding.listview)
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val name = name[position]
            val phone = phoneno[position]
            val exid = exid[position]
            val email = email[position]
            val imageId = imageId[position]

            val i = Intent(this, DetailActivity:: class.java)
            i.putExtra("name", name)
            i.putExtra("phone", phone)
            i.putExtra("exid", exid)
            i.putExtra("email", email)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.main_menu, menu)

    }
    }