package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val TAB_CONTENT = "TAB_CONTENT"
private const val ARG_TITLE = "title"
private const val ARG_DESC = "description"

class CafeDetailFragment : Fragment() {
        private var content: String? = null
        private var title: String? = null
        private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(TAB_CONTENT)
            title = it.getString(ARG_TITLE)
            description = it.getString(ARG_DESC)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.content_description)
            ?.text = content
        view.findViewById<TextView>(R.id.content_title)?.text = title
        view.findViewById<TextView>(R.id.content_description)?.text = description
    }

    companion object {
        fun newInstance(content: String, description: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAB_CONTENT, content)
                    putString(ARG_TITLE, title)
                    putString(ARG_DESC, description)
                }
            }
    }
}