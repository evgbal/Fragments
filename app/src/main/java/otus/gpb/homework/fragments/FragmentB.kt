package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val landscapeLayout = view.findViewById<View>(R.id.landscape_layout)
        val fragmentContainer = view.findViewById<View>(R.id.fragment_container)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Ландшафтная ориентация: оба фрагмента на экране
            landscapeLayout.visibility = View.VISIBLE
            fragmentContainer.visibility = View.GONE

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_ba, FragmentBA())
                .replace(R.id.fragment_container_bb, FragmentBB())
                .commit()
        }
        else {
            // Портретная ориентация: только FragmentBB
            landscapeLayout.visibility = View.GONE
            fragmentContainer.visibility = View.VISIBLE

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentBA())
                .addToBackStack(null)
                .commit()
        }
        return view
    }
}