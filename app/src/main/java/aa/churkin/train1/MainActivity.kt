package aa.churkin.train1

import aa.churkin.train1.databinding.ActivityMainBinding
import android.R
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ChangeColorBtn.setOnClickListener {changeColor()}

    }
    private var i = 3;
    private fun changeColor(){
        var light:GradientDrawable;
        light = setLightByI()

        light.setColor(Color.GRAY);

        i = ++i % 4
        light = setLightByI()

        light.setColor( when(i){
            0-> Color.RED;
            1,3->Color.YELLOW;
            else -> Color.GREEN;
        })
    }

    private fun setLightByI(): GradientDrawable {
        var light1:GradientDrawable
        light1 = when (i) {
            0 -> binding.topLight.background.mutate() as GradientDrawable;
            1, 3 -> binding.middleLight.background.mutate() as GradientDrawable;
            else -> binding.bottomLight.background.mutate() as GradientDrawable;
        }
        return light1
    }
}