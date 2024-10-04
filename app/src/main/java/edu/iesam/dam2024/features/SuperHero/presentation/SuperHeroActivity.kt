package edu.iesam.dam2024.features.SuperHero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.SuperHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {
    private lateinit var xmlLocalDataSource: SuperHeroXmlLocalDataSource

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        xmlLocalDataSource = SuperHeroXmlLocalDataSource(this)
        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()
        val superHero = viewModel.viewCreated()
        //bindDate(superHero)
        Log.d("@dev", superHero.toString())
        //testXml()
        /*val superHerosFromXml= xmlLocalDataSource.findAll()
        Log.d("@dev",superHerosFromXml.toString())*/
    }

    /* private fun testXml(){
         val superHero = viewModel.itemSelected("1")
         superHero?.let {
             xmlLocalDataSource.save(it)
         }
         xmlLocalDataSource.delete()
     }
     private fun testListXml(){
         val superHeros = viewModel.viewCreated()
         val xmlLocalDataSource = SuperHeroXmlLocalDataSource(this)
         xmlLocalDataSource.saveAll(superHeros)
     }
    private fun bindDate(superHeros: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superHeros[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superHeros[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToSuperHeroDetail(superHeros[0].id)
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superHeros[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superHeros[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToSuperHeroDetail(superHeros[1].id)
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superHeros[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superHeros[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToSuperHeroDetail(superHeros[2].id)
        }

    }*/

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
    }
}