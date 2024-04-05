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

        //set i if save
        i = savedInstanceState?.getInt("i") ?: 0
        //set down
        down = savedInstanceState?.getBoolean("down") ?: true
        //set color
        drawCircleColor()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //save i
        outState.putInt("i",i)
        //save down
        outState.putBoolean("down",down)
    }
    private var i = 0;
    private var down = true;
    private fun changeColor(){
        drawCircleGray()

        if(down){
            i++
        }
        else{
            i--
        }

        if(i >= 3){
            down = false
        }
        if(i<=1){
            down = true
        }

        drawCircleColor()
    }
    private fun drawCircleGray(){
        if (i == 0) return;
        var CurrentCircle:GradientDrawable;
        CurrentCircle = setLightByI()
        CurrentCircle.setColor(Color.GRAY);
    }
    private fun drawCircleColor(){
        if (i == 0) return;
        var CurrentCircle:GradientDrawable;
        CurrentCircle = setLightByI()
        CurrentCircle.setColor( when(i){
            1-> Color.RED;
            2->Color.YELLOW;
            else -> Color.GREEN;
        })
    }

    private fun setLightByI(): GradientDrawable {
        var light1:GradientDrawable
        light1 = when (i) {
            1 -> binding.topLight.background.mutate() as GradientDrawable;
            2 -> binding.middleLight.background.mutate() as GradientDrawable;
            else -> binding.bottomLight.background.mutate() as GradientDrawable;
        }
        return light1
    }
}