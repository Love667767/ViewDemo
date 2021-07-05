package com.elson.viewdemo.nestedScrolling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elson.viewdemo.R

/**
 * @author elson
 * @date 2021/7/5
 * @Desc
 */
private const val ARG_PARAM1 = "param1"

class BlankFragment : Fragment() {
    private var color: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        color = arguments?.getInt(ARG_PARAM1)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_blank, container, false)
        inflate.findViewById<View>(R.id.vContainer).setBackgroundColor(color!!)
        return inflate
    }

    companion object {
        fun newInstance(color: Int):BlankFragment {
            val fragment = BlankFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_PARAM1, color)
            fragment.arguments = bundle
            return fragment
        }
    }
}