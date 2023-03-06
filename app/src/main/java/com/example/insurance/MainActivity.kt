package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            var premium: Int = 0
            var extra: Int = 0
            var total: Int = 0

            //Position 0..n-1
            val age = binding.spinnerAge.selectedItemPosition
            if(age == 0){//less than 17
                premium = 60
            }else if(age == 1){
                premium = 70
            }else if(age == 2){
                premium = 90
            }else if(age == 3){
                premium = 120
            }else {
                premium = 150
            }

            val gender =  binding.radioGroupGender.checkedRadioButtonId
            if(gender == binding.radioButtonMale.id){
                //calculate extra premium for male
                if(age == 0){//less than 17
                    extra += 0
                }else if(age == 1){
                    extra += 50
                }else if(age == 2){
                    extra += 100
                }else if(age == 3){
                    extra += 150
                }else {
                    extra += 200
                }

            }

            val smoker = binding.checkBoxSmoker.isChecked
            if(smoker){
                //calculate extra premium for smoker
                if(age == 0){//less than 17
                    extra += 0
                }else if(age == 1){
                    extra += 100
                }else if(age == 2){
                    extra += 150
                }else if(age == 3){
                    extra += 200
                }else if (age == 4){
                    extra += 250
                } else{
                    extra += 300
                }
            }
            total = premium + extra
            binding.myPremium = Premium(premium, extra, total)
        }

        binding.buttonReset.setOnClickListener {
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.myPremium = Premium()
        }
    }
}