package com.example.listcontact
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import com.example.listcontact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val exid = intent.getStringExtra("exid")
        val email = intent.getStringExtra("email")
        val imageId = intent.getIntExtra("imageId", R.drawable.game1)

        binding.nameProfile.text = name
        binding.phoneProfile.text = phone
        binding.idProfile.text = exid
        binding.emailProfile.text = email
        binding.profileImage.setImageResource(imageId)

    }
}