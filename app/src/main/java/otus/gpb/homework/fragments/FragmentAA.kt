package otus.gpb.homework.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_aa, container, false)

        val color = arguments?.getInt(ARG_COLOR) ?: Color.WHITE
        view.setBackgroundColor(color)

        view.findViewById<Button>(R.id.button_open_fragment_ab).setOnClickListener(
            {
                if (parentFragment is FragmentA)
                        (parentFragment as FragmentA).openFragmentAB()
            }
        )

        return view
    }

    companion object {
        private const val ARG_COLOR = "color"

        fun newInstance(color: Int): FragmentAA {
            val fragment = FragmentAA()
            val args = Bundle().apply {
                putInt(ARG_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}