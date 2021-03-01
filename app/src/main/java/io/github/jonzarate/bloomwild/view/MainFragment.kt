package io.github.jonzarate.bloomwild.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.jonzarate.bloomwild.Injector
import io.github.jonzarate.bloomwild.R
import io.github.jonzarate.bloomwild.databinding.FragmentMainBinding
import io.github.jonzarate.bloomwild.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewmodel: MainViewModel by viewModels { Injector.mainViewModelFactory }

    private val adapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setList()
        setObserver()
    }

    private fun setList() {
        with(binding.mainProducts){
            adapter = this@MainFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setObserver() {
        viewmodel.products.observe(viewLifecycleOwner, {
            with(adapter){
                submitProducts(it)
                notifyDataSetChanged()
            }
        })
    }
}