package otus.gpb.homework.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentAB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ab, container, false)

        val color = arguments?.getInt(ARG_COLOR) ?: Color.WHITE
        view.setBackgroundColor(color)

        return view
    }

    companion object {
        private const val ARG_COLOR = "color"

        fun newInstance(color: Int): FragmentAB {
            val fragment = FragmentAB()
            val args = Bundle().apply {
                putInt(ARG_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}