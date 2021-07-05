package com.elson.viewdemo.nestedScrolling

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.elson.viewdemo.R
import kotlinx.android.synthetic.main.activity_nested_suspended.*
import java.util.*

/**
 * @author elson
 * @date 2021/7/5
 * @Desc
 * @see <a href=https://github.com/RubiTree/NestedScrollingHistory/blob/master/app/src/main/res/layout/activity_nested_suspended.xml>Suspend</a>
 */
class SuspendedLayoutActivity : AppCompatActivity() {

    private val fragments = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_suspended)

        initFragments()
        initScrollableLayout()
    }

    private fun initFragments() {
        fragments.add(BlankFragment.newInstance(0xfffdedbc.toInt()))
        fragments.add(BlankFragment.newInstance(0xFFB1F1F5.toInt()))
        fragments.add(BlankFragment.newInstance(0x30303333))
    }

    private fun initScrollableLayout() {
        vViewpager.offscreenPageLimit = 2
        vViewpager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(p0: Int) = fragments[p0]
            override fun getCount() = fragments.size
        }
    }
}