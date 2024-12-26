package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ba, container, false)

        val color = arguments?.getInt(ARG_COLOR) ?: Color.WHITE
        view.setBackgroundColor(color)

        val openFragmentBB = view.findViewById<Button>(R.id.open_fragment_bb)

        // Слушатель для получения цвета от FragmentBB
        parentFragmentManager.setFragmentResultListener(COLOR_REQUEST, this) { _, bundle ->
            val bgColor: Int = bundle.getInt(ARG_COLOR, Color.WHITE)
            view.setBackgroundColor(bgColor) // Красим фон в полученный цвет
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            openFragmentBB.visibility = View.GONE


        } else {
            openFragmentBB.apply {
                visibility = View.VISIBLE
                setOnClickListener {

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container
                            , FragmentBB.newInstance(ColorGenerator.generateColor()))
                        .addToBackStack(null) // Добавляем в стек, чтобы вернуться назад
                        .commit()
                }
            }
        }
        return view
    }

    companion object {
        private const val ARG_COLOR = "color"
        private const val COLOR_REQUEST = "colorRequest"
    }
}