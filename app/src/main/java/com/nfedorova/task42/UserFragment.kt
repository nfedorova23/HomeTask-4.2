package com.nfedorova.task42


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class UserFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adapter(UserService.getRandomUserList())

        setFragmentResultListener(getString(R.string.updateKey)) { _, bundle ->
             bundle.getString(IMAGE_KEY)
            (recyclerView.adapter as Adapter).update()
        }
    }

    companion object {
        const val TAG_USER = "TAG_USER"
        const val IMAGE_KEY = "IMAGE_KEY"
        fun newInstance() = UserFragment()
    }
}