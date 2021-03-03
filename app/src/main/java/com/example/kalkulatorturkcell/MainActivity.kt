package com.example.kalkulatorturkcell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var op = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0.setOnClickListener{appendOnExpression("0", true)
        }
        button1.setOnClickListener{appendOnExpression("1", true)
        }
        button2.setOnClickListener{appendOnExpression("2", true)
        }
        button3.setOnClickListener{appendOnExpression("3", true)
        }
        button4.setOnClickListener{appendOnExpression("4", true)
        }
        button5.setOnClickListener{appendOnExpression("5", true)
        }
        button6.setOnClickListener{appendOnExpression("6", true)
        }
        button7.setOnClickListener{appendOnExpression("7", true)
        }
        button8.setOnClickListener{appendOnExpression("8", true)
        }
        button9.setOnClickListener{appendOnExpression("9", true)
        }
        buttonPlus.setOnClickListener{appendOnExpression("+", false)
            op = "+"
        }
        buttonMinus.setOnClickListener{appendOnExpression("-", false)
            op = "-"
        }
        buttonMulti.setOnClickListener{appendOnExpression("*", false)
            op = "*"
        }
        buttonDiv.setOnClickListener{appendOnExpression("/", false)
            op = "/"
        }
        buttonAC.setOnClickListener{
            input.text = ""
            output.text = ""
            //AC resets the calculator hence input and output should be NULL
        }
        buttonEq.setOnClickListener{
             //CODE******************************************************
            try{output.text = calculate().toString()
                input.text = ""
            }catch(e:Exception){
                input.text = ""
                output.text = ""
            }
            op = ""
            //try-catch was explained in class by Kasim Hoca
            //instead of printing the error with e.printStackTrace or any other e method
            //I chose to reset the calculator
            //so the user knows they did something wrong

        }
    }

    fun appendOnExpression(text:String, canClean:Boolean){
        //input is taken as String
        //otherwise it would get way too messy
        //we'd rather have it all as a String and then do the calculation in another function using iterables
        if(output.text.isNotEmpty()){
            input.text = ""
        }
        //output is checked if it's NULL or not
        //it it is not NULL then it is cleared
        //otherwise the new input and the old results are concatenated and it looks unpleasing
        if(canClean){
            output.text = ""
            input.append(text)
        }else{
            input.append(output.text)
            input.append(text)
            output.text = ""
        }
    }

    fun calculate():Double{
        var nums = input.text.toString().split(op)
        when(op){
            "+"->return nums[0].toDouble() + nums[1].toDouble()
            "-"->return nums[0].toDouble() - nums[1].toDouble()
            "*"->return nums[0].toDouble() * nums[1].toDouble()
            "/"->return nums[0].toDouble() / nums[1].toDouble()
            else -> return input.text.toString().toDouble()
        }
        return input.text.toString().toDouble()
    }
}