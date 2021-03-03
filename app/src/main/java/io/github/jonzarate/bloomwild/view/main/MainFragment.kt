package io.github.jonzarate.bloomwild.view.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.google.android.material.bottomsheet.BottomSheetBehavior
import io.github.jonzarate.bloomwild.Injector
import io.github.jonzarate.bloomwild.databinding.FragmentMainBinding
import io.github.jonzarate.bloomwild.viewmodel.main.MainViewModel


class MainFragment : Fragment(), MainAdapter.OnProductSelected {

    private lateinit var binding: FragmentMainBinding
    private val viewmodel: MainViewModel by viewModels { Injector.mainViewModelFactory }

    private var adapter = MainAdapter(this)
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var smoothScrollController: SmoothScrollerToPosition

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(requireContext())
        smoothScrollController = SmoothScrollerToPosition(requireContext())

        setList()
        setObserver()
    }

    private fun setList() {
        with(binding.mainProducts){
            adapter = this@MainFragment.adapter
            layoutManager = this@MainFragment.layoutManager
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun setObserver() {
        viewmodel.products.observe(viewLifecycleOwner, {
            with(adapter) {
                submitProducts(it)
                notifyDataSetChanged()
            }
        })

        viewmodel.onHighlightedProductChanged.observe(viewLifecycleOwner, {
            smoothSnapToPosition(it)
            expandBottomSheet()
            adapter.notifyDataSetChanged()
        })
    }

    private fun smoothSnapToPosition(position: Int) {
        smoothScrollController.targetPosition = position
        layoutManager.startSmoothScroll(smoothScrollController)
    }

    private fun expandBottomSheet() {
        binding.detailBottomSheet?.also { bottomSheet ->
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onProductSelected(position: Int) {
        viewmodel.onProductSelected(position)
    }

    class SmoothScrollerToPosition(context: Context) : LinearSmoothScroller(context) {
        override fun getVerticalSnapPreference(): Int = SNAP_TO_START
        override fun getHorizontalSnapPreference(): Int = SNAP_TO_START
    }
}