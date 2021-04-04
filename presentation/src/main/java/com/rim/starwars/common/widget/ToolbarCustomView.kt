package com.rim.starwars.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.rim.starwars.R
import com.rim.starwars.databinding.CustomViewHeaderBinding

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
class ToolbarCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleRes) {
    private val mBinding =
        CustomViewHeaderBinding.inflate(LayoutInflater.from(context), this, true)

    @StringRes
    private var titleRes: Int

    private var isBackBtnVisible: Boolean

    init {
        attrs.let {
            val typedArray =
                context.obtainStyledAttributes(
                    it,
                    R.styleable.ToolbarCustomView,
                    defStyleRes,
                    0
                )
            try {
                titleRes =
                    typedArray.getResourceId(R.styleable.ToolbarCustomView_ToolbarTitle, -1)
                isBackBtnVisible =
                    typedArray.getBoolean(
                        R.styleable.ToolbarCustomView_ToolbarBackVisibility,
                        false
                    )
            } finally {
                typedArray.recycle()
            }
            initView()
        }
    }

    private fun initView() {
        if (titleRes != -1) {
            mBinding.cvHeaderTitle.text = context.getString(titleRes)
        }
        mBinding.cvHeaderBackBtn.isVisible = isBackBtnVisible
    }

    fun setToolbarTitle(title: String) {
        mBinding.cvHeaderTitle.text = title
    }

    fun setOnBackClickListener(onClickAction: () -> Unit) {
        mBinding.cvHeaderBackBtn.setOnClickListener {
            onClickAction()
        }
    }
}