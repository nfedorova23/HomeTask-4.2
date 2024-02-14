package com.nfedorova.task42

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.nfedorova.task42.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  Transition {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportFragmentManager.findFragmentByTag(UserFragment.TAG_USER) == null) {
            supportFragmentManager.commit {
                replace(
                    R.id.container,
                    UserFragment.newInstance(),
                    UserFragment.TAG_USER
                )
                addToBackStack(UserFragment.TAG_USER)
            }
        }
    }

    override fun editFragment(user: User) {
        val detailFragment = EditFragment(user)
        supportFragmentManager.commit {
            add(R.id.container, detailFragment, EditFragment.TAG_EDIT)
            addToBackStack(EditFragment.TAG_EDIT)
        }
    }
}

interface Transition {
    fun editFragment(user: User)
}