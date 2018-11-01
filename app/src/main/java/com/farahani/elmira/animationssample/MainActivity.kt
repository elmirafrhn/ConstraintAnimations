package com.farahani.elmira.animationssample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.first_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        addAnimationOperations()
    }

    private fun addAnimationOperations() {
        var set=false
        val constraint1= ConstraintSet()
        constraint1.clone(root)
        val constrant2=ConstraintSet()
        constrant2.clone(this,R.layout.second_layout)

        icon3.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(root)
                val constraint=if(set) constraint1 else constrant2
                constraint.applyTo(root)
                set=!set
            }
        }


    }
}
