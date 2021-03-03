package io.github.jonzarate.bloomwild.view.detail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.jonzarate.bloomwild.Injector
import io.github.jonzarate.bloomwild.databinding.FragmentDetailBinding
import io.github.jonzarate.bloomwild.model.data.ProductAttributes
import io.github.jonzarate.bloomwild.viewmodel.detail.DetailViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewmodel: DetailViewModel by viewModels { Injector.detailViewModelFactory }

    private val adapter = DetailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setList()
        setObserver()
    }

    private fun setList() {
        with(binding.detailList){
            adapter = this@DetailFragment.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }

    private fun setObserver() {
        viewmodel.product.observe(viewLifecycleOwner, { attrs ->
            setNewProduct(attrs)
        })
    }

    private fun setNewProduct(attrs: ProductAttributes?){
        with(adapter) {
            submitProduct(attrs)
            notifyDataSetChanged()
        }
    }
}