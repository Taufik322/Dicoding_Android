package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.example.dicodingandroid.R

class CustomView : AppCompatActivity() {

    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        myButton = findViewById(R.id.my_button)
        myEditText = findViewById(R.id.my_edit_text)

        setMyButtonEnable()

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        myButton.setOnClickListener { Toast.makeText(this, myEditText.text, Toast.LENGTH_SHORT).show() }

    }

    private fun setMyButtonEnable() {
        val result = myEditText.text
        myButton.isEnabled = result != null && result.toString().isNotEmpty()
    }
}

class MyButton: AppCompatButton {

    private var enabledBackground: Drawable? = null
    private var disabledBackground: Drawable? = null
    private var txtColor: Int = 0

    constructor(context: Context): super(context){
        init()
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = when {
            isEnabled -> enabledBackground
            else -> disabledBackground
        }

        setTextColor(txtColor)
        textSize = 12f
        gravity = Gravity.CENTER
        text = when{
            isEnabled -> "Submit"
            else -> "Isi terlebih dahulu"
        }
    }

    private fun init(){
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button)
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disable)
    }

}

class MyEditText: AppCompatEditText, View.OnTouchListener {

    private lateinit var mClearButtonImage: Drawable

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init(){
        mClearButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24) as Drawable
        setOnTouchListener(this)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) showClearButton() else hideClearButton()
            }
            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })
    }

    private fun showClearButton() {
        setCompoundDrawablesWithIntrinsicBounds(null, null,
            mClearButtonImage, null)
    }

    private fun hideClearButton() {
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            val clearButtonStart: Float
            val clearButtonEnd: Float
            var isClearButtonClicked = false
            when (layoutDirection) {
                View.LAYOUT_DIRECTION_RTL -> {
                    clearButtonEnd = (mClearButtonImage.intrinsicWidth + paddingStart).toFloat()
                    when {
                        event.x < clearButtonEnd -> isClearButtonClicked = true
                    }
                }
                else -> {
                    clearButtonStart = (width - paddingEnd - mClearButtonImage.intrinsicWidth).toFloat()
                    when {
                        event.x > clearButtonStart -> isClearButtonClicked = true
                    }
                }
            }
            when {
                isClearButtonClicked -> when {
                    event.action == MotionEvent.ACTION_DOWN -> {
                        mClearButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24) as Drawable
                        showClearButton()
                        return true
                    }
                    event.action == MotionEvent.ACTION_UP -> {
                        mClearButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24) as Drawable
                        when {
                            text != null -> text?.clear()
                        }
                        hideClearButton()
                        return true
                    }
                    else -> return false
                }
                else -> return false
            }
        }
        return false
    }
}