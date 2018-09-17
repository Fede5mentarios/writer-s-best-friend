package com.bernst.d.federico.writesbestfriend.views.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by federico on 21/11/16.
 */

class CharacterPagesAdapter(
        private val mFragmentManager: FragmentManager) : FragmentPagerAdapter(mFragmentManager) {

    var fragmentList: List<Fragment> = emptyList()

    override fun getItem(position: Int): Fragment? {

        when (position) {
            PERSONAL_DATA_FRAGEMT_ID -> return null
            PHYSICAL_DATA_FRAGEMT_ID -> return null
            PERSONALITY_DATA_FRAGEMT_ID -> return null
            PAST_DATA_FRAGEMT_ID -> return null
            DEVELOP_DATA_FRAGEMT_ID -> return null
            RELATIONSHIPS_DATA_FRAGEMT_ID -> return null
            ART_DATA_FRAGEMT_ID -> return null
            else -> return null
        }
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    companion object {
        const val PERSONAL_DATA_FRAGEMT_ID = 0
        val PHYSICAL_DATA_FRAGEMT_ID = 1
        val PERSONALITY_DATA_FRAGEMT_ID = 2
        val PAST_DATA_FRAGEMT_ID = 3
        val DEVELOP_DATA_FRAGEMT_ID = 4
        val RELATIONSHIPS_DATA_FRAGEMT_ID = 5
        val ART_DATA_FRAGEMT_ID = 6
    }
}
