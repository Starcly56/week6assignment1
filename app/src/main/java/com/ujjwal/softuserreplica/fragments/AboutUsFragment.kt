package com.ujjwal.softuserreplica.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.ujjwal.softuserreplica.R


class AboutUsFragment : Fragment() {
    private lateinit var wvAboutUs : WebView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_about_us, container, false)
        wvAboutUs=view.findViewById(R.id.wvAboutUs)
        wvAboutUs.settings.javaScriptEnabled=true
        val webViewClient = WebViewClient()
        wvAboutUs.webViewClient=webViewClient
        wvAboutUs.loadUrl("https://softwarica.edu.np");
        return view
    }
//    fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK && this.wvAboutUs.canGoBack()) {
//            this.wvAboutUs.goBack()
//            return true
//        }
//        return super.onKeyDown(keyCode, event)
//    }
}