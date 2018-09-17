package com.bernst.d.federico.writesbestfriend.views.activities

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import com.bernst.d.federico.writesbestfriend.R
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.model.form.Categoria
import com.bernst.d.federico.writesbestfriend.viewmodel.CharacterViewModel
import com.bernst.d.federico.writesbestfriend.views.adapters.CharacterPagesAdapter
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : BasicActivity<CharacterViewModel>(CharacterViewModel::class.java) {

    var pageAdapter: CharacterPagesAdapter = CharacterPagesAdapter(supportFragmentManager)
    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val characterID = intent.getLongExtra(CHARACTER_ID, -1L)
        characterViewModel.setCharacterID(characterID)
        iniciarTabs()
    }

    override fun iniciarObservers() {
        characterViewModel.categorriasExtras.observe(this,
                Observer { categorias ->
                    categorias?.forEach { category ->
                        tabFromCategory(category)
                    }
                })
    }

    private fun tabFromCategory(categoria: Categoria) {
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(personal_data_label))
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(physical_data_label))
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(personality_data_label))
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(past_data_label))
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(develop_data_label))
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(relationships_data_label))
//        tabLayout_categorias.addTab(tabLayout_categorias.newTab().setText(art_data_label))

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iniciarListeners() {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun iniciarTabs() {
        tabLayout_categorias.elevation = 4f
//        tabLayout_categorias.tabGravity = TabLayout.MODE_SCROLLABLE
        viewPager_form.adapter = pageAdapter
//        viewPager_form.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout_categorias))
//
//        tabLayout_categorias.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                viewPager_form.currentItem = tab.position
//            }
//
//            override fun onTabUnselected(tab: Tab) {}
//
//            override fun onTabReselected(tab: Tab) {}
//        })
    }

    override val mainView: Int
        get() = R.layout.activity_form

    override val adView: AdView?
        get() = null

    override val tituloId: Int
        get() = R.string.personaje

    override fun injectDependencies(components: WritersbfComponents) = components.inject(this)

    companion object {

        private val CHARACTER_ID = "CHARACTER_ID"

        fun getIntent(intent: Intent, characterID: Long?): Intent {
            val toReturn = Intent(intent)
            toReturn.putExtra(CHARACTER_ID, characterID)
            return toReturn
        }
    }
}
