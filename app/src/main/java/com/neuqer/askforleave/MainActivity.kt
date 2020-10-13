package com.neuqer.askforleave

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.neuqer.askforleave.ask_for_leave.AskForLeaveHostActivity
import com.neuqer.askforleave.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewDataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewDataBinding.lifecycleOwner = this
        setDarkStatusIcon(true)
        viewDataBinding.mainBtnEnter.setOnClickListener {
            val intent = Intent(this, AskForLeaveHostActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setDarkStatusIcon(bDark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView: View = window.decorView
            var vis: Int = decorView.systemUiVisibility
            vis = if (bDark) {
                vis or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            decorView.systemUiVisibility = vis
        }
    }
}