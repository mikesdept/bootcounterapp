package mikes.dept.presentation.ui.booteventlist

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mikes.dept.presentation.R
import mikes.dept.presentation.databinding.FragmentBootEventListBinding
import mikes.dept.presentation.di.SubcomponentProvider
import mikes.dept.presentation.ui.core.BaseBindingFragment

class BootEventListFragment : BaseBindingFragment<BootEventListViewModel, FragmentBootEventListBinding>(R.layout.fragment_boot_event_list) {

    override fun initDagger(subcomponentProvider: SubcomponentProvider) = subcomponentProvider
        .provideBootEventListSubcomponent()
        .inject(this)

    override fun initViewModel(viewModelProvider: ViewModelProvider): BootEventListViewModel = viewModelProvider[BootEventListViewModelImpl::class.java]

    override fun initViewBinding(view: View): FragmentBootEventListBinding = FragmentBootEventListBinding.bind(view)

    override fun setup() {
        binding.btnSave.setOnClickListener {
            viewModel.onClickSettings()
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.navDirections.collectLatest { navDirections -> findNavController().navigate(navDirections) }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.bootEventList.collectLatest { bootEventList ->

                }
            }
        }
    }

    override fun reset() {
        binding.btnSave.setOnClickListener(null)
    }

}
