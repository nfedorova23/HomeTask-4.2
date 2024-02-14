package com.nfedorova.task42


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.nfedorova.task42.databinding.FragmentEditBinding

class EditFragment(
    private val user: User
) : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private var uri: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            userFirstNameEditText.setText(user.firstName)
            userLastNameEditText.setText(user.lastName)
            userPhoneNumberEditText.setText(user.phoneNumber)
            photoUser.setImageResource(user.image)

            editButton.setOnClickListener {
                user.firstName = userFirstNameEditText.text.toString()
                user.lastName = userLastNameEditText.text.toString()
                user.phoneNumber = userPhoneNumberEditText.text.toString()

                val bundle = Bundle()
                uri?.let { uri ->
                    val uriString = uri.toString()
                    bundle.putString(IMAGE_KEY, uriString)
                }
                setFragmentResult(getString(R.string.updateKey), bundle)
                requireActivity().supportFragmentManager.popBackStack()
            }
            cancelButton.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }


    companion object {
        const val TAG_EDIT = "TAG_EDIT"
        const val IMAGE_KEY = "IMAGE_KEY"
    }
}