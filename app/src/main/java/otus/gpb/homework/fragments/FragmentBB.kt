package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bb, container, false)

        // Кнопка для генерации цвета и возврата результата в FragmentBA
        view.findViewById<Button>(R.id.send_color).setOnClickListener {
            val randomColor = ColorGenerator.generateColor()

            if (resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                // Закрываем текущий фрагмент
                parentFragmentManager.popBackStack()
            }

            // Передаем результат обратно в FragmentBA
            val result = Bundle()
            result.putInt(ARG_COLOR, randomColor)
            parentFragmentManager.setFragmentResult(COLOR_REQUEST, result)
        }

        return view
    }



    companion object {
        private const val ARG_COLOR = "color"
        private const val COLOR_REQUEST = "colorRequest"

        fun newInstance(color: Int): FragmentBB {
            val fragment = FragmentBB()
            val args = Bundle().apply {
                putInt(ARG_COLOR, color)
            }
            fragment.arguments = args
            return fragment
        }
    }
}