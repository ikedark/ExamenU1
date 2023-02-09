package mx.edu.potros.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Cls : EditText = findViewById(R.id.etC)
        val Frt : EditText = findViewById(R.id.etF)
        val C : Button = findViewById(R.id.btnGC)
        val F: Button = findViewById(R.id.btnGF)

        C.setOnClickListener {
            var celsius: Double = 0.0

            try {
                celsius = Cls.text.toString().toDouble()
            }catch (e: java.lang.Exception){
                Cls.setText("Deben ser valores reales")
                print(e)
            }

            var resF = CtoF(celsius)
            var formattedNumber = "%.2f".format(resF)
            Frt.setText(formattedNumber)
        }

        F.setOnClickListener {
            var farhenheit: Double = 0.0

            try {
                farhenheit = Frt.text.toString().toDouble()
            }catch (e: java.lang.Exception){
                Frt.setText("Deben ser valores reales")
                print(e)
            }

            var resC = FtoC(farhenheit)
            var formattedNumber = "%.2f".format(resC)
            Cls.setText(formattedNumber)
        }
    }

    fun CtoF(Celsius: Double): Double {
        return (Celsius * 1.8) + 32
    }

    fun FtoC(Farenheit: Double): Double {
        return ((Farenheit-32) / 1.8)
    }
}