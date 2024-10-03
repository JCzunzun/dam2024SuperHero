package edu.iesam.dam2024.features.SuperHero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroDetailActivity : AppCompatActivity() {
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)
        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewMovie()
        getSuperHeroId()?.let { superHeroId ->
            viewModel.viewCreated(superHeroId)?.let { superHero ->
                bindData(superHero)
            }
        }
    }

    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.super_id)
        Glide
            .with(this)
            .load(superHero.image)
            .into(imageView)
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"
        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superHeroId)
            return intent
        }
    }
}