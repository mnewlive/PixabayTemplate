package dev.androidbroadcast.pixabaytemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.androidbroadcast.pixabaytemplate.ui.FeedFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var fragment: FeedFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val feedFragment = FeedFragment.newInstance("title")
            fragment = feedFragment
            feedFragment.apply {
                supportFragmentManager.beginTransaction()
                    .add(R.id.containerView, feedFragment, FEED_FRAGMENT)
                    .commit()
            }
        } else fragment = supportFragmentManager.findFragmentByTag(FEED_FRAGMENT) as? FeedFragment
    }

    companion object {
        const val FEED_FRAGMENT = "FeedFragment"
    }
}