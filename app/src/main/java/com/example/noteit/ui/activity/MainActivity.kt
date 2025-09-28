package com.example.noteit.ui.activity

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.noteit.Pref
import com.example.noteit.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var state : Boolean = false
    private lateinit var pref : Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = Pref(this)
        state = pref.getState()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        if (state == false){
            navController.navigate(R.id.boardFragment)
            pref.setState(true)
        }else {
            navController.navigate(R.id.mainFragment)
        }

        onBackPressedDispatcher.addCallback(this) {
            if (!navController.popBackStack()) {
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}