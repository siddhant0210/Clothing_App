package com.example.re_wear.fragments

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.re_wear.R
import com.example.re_wear.adapters.HomeViewPagerAdapter
import com.example.re_wear.fragments.categories.AccessoryFragment
import com.example.re_wear.fragments.categories.MenFragment
import com.example.re_wear.fragments.categories.SportsFragment
import com.example.re_wear.fragments.categories.WomenFragment
import com.example.re_wear.fragments.categories.MainCategoryFragment
import com.example.re_wear.fragments.categories.KidsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.zxing.integration.android.IntentIntegrator
import java.util.Locale

class HomeFragment : Fragment() {

    private val REQUEST_CODE_SPEECH_INPUT = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            MenFragment(),
            SportsFragment(),
            KidsFragment(),
            AccessoryFragment(),
            WomenFragment()
        )

        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val scan = view.findViewById<ImageView>(R.id.scanner)
        val mic = view.findViewById<ImageView>(R.id.mic)


        viewPager2.adapter = HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "Men"
                2 -> tab.text = "Women"
                3 -> tab.text = "Kids"
                4 -> tab.text = "Accessory"
                5 -> tab.text = "Sports"
                else -> tab.text = " Main"
            }
        }.attach()


        scan.setOnClickListener{
            val scanner = IntentIntegrator(requireActivity())
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }



        // FOR MIC --------------------->


        mic.setOnClickListener {
            // on below line we are calling speech recognizer intent.
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

            // on below line we are passing language model
            // and model free form in our intent
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )

            // on below line we are passing our
            // language as a default language.
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault()
            )

            // on below line we are specifying a prompt
            // message as speak to text on below line.
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text")

            // on below line we are specifying a try catch block.
            // in this block we are calling a start activity
            // for result method and passing our result code.
            try {
                startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
            } catch (e: Exception) {
                // on below line we are displaying error message in toast
                Toast
                    .makeText(
                        requireContext(), " " + e.message,
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(requireContext(), "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }



        //  ---------------MIC

        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            // on below line we are checking if result code is ok
            if (resultCode == RESULT_OK && data != null) {

                // in that case we are extracting the
                // data from our array list
                val res: ArrayList<String> =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>

                // on below line we are setting data
            }
        }
    }

}