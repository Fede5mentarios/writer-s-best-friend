package com.bernst.d.federico.writesbestfriend.views.activities

import com.bernst.d.federico.writesbestfriend.R.string.personajes
import com.bernst.d.federico.writesbestfriend.dagger.components.WritersbfComponents
import com.bernst.d.federico.writesbestfriend.model.creation.Creacion
import com.bernst.d.federico.writesbestfriend.viewmodel.CharactersViewModel

class CharacterListActivity : ListActivity<CharactersViewModel>(CharactersViewModel::class.java) {

    private lateinit var charactersViewModel: CharactersViewModel

    override fun newCreation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreationClick(creation: Creacion) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val tituloId: Int
        get() = personajes

}
