package uz.ilkhomkhuja.ndkexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.ilkhomkhuja.ndkexample.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var result: Int? = null
    private var myResult: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRandomNumbers()

        binding.button.setOnClickListener {
            if (binding.edit.text.toString().trim().isNotEmpty()) {
                myResult = binding.edit.text.toString().toInt()
                if (result == myResult) {
                    Toast.makeText(this, "Answer is correct !!", Toast.LENGTH_SHORT).show()
                    setRandomNumbers()
                    binding.edit.text.clear()
                } else {
                    Toast.makeText(this, "Wrong answer !!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Answer is not included !!", Toast.LENGTH_SHORT).show()
            }
        }

        // Example of a call to a native method
        //binding.sampleText.text = stringFromJNI() + "\n" + secondStringFromJNI()
    }

    private fun setRandomNumbers() {
        val random = Random()
        val a = random.nextInt(100)
        val b = random.nextInt(100)
        val c = random.nextInt(4)
        binding.number1.text = "$a"
        binding.number3.text = "$b"
        when (c) {
            0 -> {
                binding.number2.text = "+"
                result = add(a, b)
            }
            1 -> {
                binding.number2.text = "-"
                result = sub(a, b)
            }
            2 -> {
                binding.number2.text = "*"
                result = mult(a, b)
            }
            else -> {
                binding.number2.text = "/"
                result = div(a, b)
            }
        }
    }

    /**
     * A native method that is implemented by the 'ndkexample' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String
    private external fun secondStringFromJNI(): String
    private external fun add(a: Int, b: Int): Int
    private external fun sub(a: Int, b: Int): Int
    private external fun mult(a: Int, b: Int): Int
    private external fun div(a: Int, b: Int): Int

    companion object {
        // Used to load the 'ndkexample' library on application startup.
        init {
            System.loadLibrary("ndkexample")
        }
    }
}