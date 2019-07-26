package com.derrick.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.derrick.R
import kotlinx.android.synthetic.main.fragment_tv_details.*

/**
 * A simple [Fragment] subclass.
 */
class TvDetailsFragment : Fragment() {
    private var tv_id: Long = -1

    companion object {
        val EXTRA_TV_ID = "tv_id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_id = arguments?.getLong(EXTRA_TV_ID) ?: -1

        val safeAgs: TvDetailsFragmentArgs by navArgs()
        tv_name.text = safeAgs.title
        tv_description.text = safeAgs.tvDesc

    }


}
