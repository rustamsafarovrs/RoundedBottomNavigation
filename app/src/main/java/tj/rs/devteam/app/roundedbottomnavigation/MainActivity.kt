package tj.rs.devteam.app.roundedbottomnavigation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import tj.rs.devteam.app.roundedbottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        val sp: ShadowProperty = ShadowProperty()
            .setShadowColor(
                ContextCompat.getColor(
                    this,
                    R.color.shadow_color
                )
            )
            .setShadowDy(0)
            .setShadowDx(0)
            .setShadowRadius(resources.getDimensionPixelSize(R.dimen.dp_14))
            .setShadowSide(ShadowProperty.ALL)
        val sd = ShadowViewDrawable(
            sp, Color.WHITE,
            resources.getDimensionPixelSize(R.dimen.dp_48).toFloat(),
            resources.getDimensionPixelSize(R.dimen.dp_48).toFloat()
        )
        binding.materialCardView.background = sd
        binding.materialCardView.setLayerType(View.LAYER_TYPE_HARDWARE, null)

    }

}