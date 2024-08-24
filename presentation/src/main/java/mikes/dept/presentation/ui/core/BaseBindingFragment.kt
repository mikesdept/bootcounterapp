package mikes.dept.presentation.ui.core

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import mikes.dept.presentation.di.SubcomponentProvider
import mikes.dept.presentation.di.ViewModelProviderFactory
import javax.inject.Inject

abstract class BaseBindingFragment<VM : IViewModel, VB : ViewBinding>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private var _viewModel: VM? = null

    protected val viewModel: VM get() = _viewModel!!

    private var _binding: VB? = null

    protected val binding: VB get() = _binding!!

    abstract fun initDagger(subcomponentProvider: SubcomponentProvider)

    open fun initViewModelProvider(): ViewModelProvider = ViewModelProvider(this, viewModelProviderFactory)

    abstract fun initViewModel(viewModelProvider: ViewModelProvider): VM

    abstract fun initViewBinding(view: View): VB

    abstract fun setup()

    abstract fun reset()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initDagger((requireActivity().application as SubcomponentProvider))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _viewModel = initViewModel(initViewModelProvider())
        _binding = initViewBinding(view)
        setup()
    }

    override fun onDestroyView() {
        reset()
        super.onDestroyView()
    }

}
