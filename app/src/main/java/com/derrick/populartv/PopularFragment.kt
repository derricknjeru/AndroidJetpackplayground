package com.derrick.populartv


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.derrick.R
import com.derrick.database.ShowDatabase
import com.derrick.databinding.FragmentPopularBinding
import com.derrick.ui.TvDetailsFragment
import kotlinx.android.synthetic.main.fragment_popular.*


/**
 * A simple [Fragment] subclass.
 *
 */
class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_popular, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application

        val dataSource = ShowDatabase.getInstance(application).showDatabaseDao

        val viewModelFactory = PopularViewModelFactory(dataSource, application)

        val popularViewModel =
            ViewModelProvider(this, viewModelFactory).get(PopularViewModel::class.java)

        binding.popularViewModel = popularViewModel

        binding.lifecycleOwner = this



        home_next.setOnClickListener {
            val args = Bundle().apply {
                putLong(TvDetailsFragment.EXTRA_TV_ID, 100)
            }

            findNavController().navigate(R.id.action_popularFragment_to_tvDetailsFragment, args)
        }
    }


}
