package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {
    private var callback: OnBackPressedCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        view.findViewById<Button>(R.id.button_open_fragment_aa).setOnClickListener {
            openFragmentAA()
        }
        return view
    }

    private fun openFragmentAA() {
        val randomColor = ColorGenerator.generateColor()

        val fragmentAA = FragmentAA.newInstance(randomColor)
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_ax, fragmentAA) // Replace with container ID
            .addToBackStack(null) // Optional: Add to back stack
            .commit()
    }

    fun openFragmentAB() {
        val randomColor = ColorGenerator.generateColor()

        val fragmentAB = FragmentAB.newInstance(randomColor)
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_ax, fragmentAB) // Replace with container ID
            .addToBackStack(null) // Optional: Add to back stack
            .commit()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Реализуйте обработку нажатия на кнопку “Назад”, используя
                // OnBackPressedDispatcher, таким образом, что по нажатию
                // из стека фрагментов удаляется один фрагмент.
                // После того как размер стека = 1, закрывайте активити.
                if (childFragmentManager.backStackEntryCount > 1) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback!!)
    }

    override fun onDetach() {
        super.onDetach()
        callback?.remove() // Удаляем обработчик при отсоединении фрагмента
        callback = null
    }

}